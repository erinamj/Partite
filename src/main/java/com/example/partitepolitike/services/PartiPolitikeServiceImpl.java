package com.example.partitepolitike.services;

import com.example.partitepolitike.entites.PartiPolitikeEntity;
import com.example.partitepolitike.mappers.PartiPolitikeMapper;
import com.example.partitepolitike.models.PartiPolitikeDto;
import com.example.partitepolitike.repositories.PartiPolitikeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartiPolitikeServiceImpl implements PartiPolitikeService {
        private final PartiPolitikeRepository repository;
        private final PartiPolitikeMapper partiPolitikeMapper;

        public PartiPolitikeServiceImpl(PartiPolitikeRepository repository, PartiPolitikeMapper partiPolitikeMapper) {
                this.repository = repository;
                this.partiPolitikeMapper = partiPolitikeMapper;
        }


        @Override
        public void add(PartiPolitikeDto partiPolitike) {
                var entity = partiPolitikeMapper.toEntity(partiPolitike);
                repository.save(partiPolitike);
        }

        @Override
        public void modify(Long id, PartiPolitikeDto updatedPartiPolitike) {
                Optional<PartiPolitikeEntity> optionalEntity = repository.findById(id);
                if (optionalEntity.isEmpty()) {
                        throw new RuntimeException("Political party not found");
                }

                PartiPolitikeEntity entity = optionalEntity.get();
                entity.setName(updatedPartiPolitike.getName());
                entity.setIdeology(updatedPartiPolitike.getIdeology());
                entity.setFoundingYear(updatedPartiPolitike.getFoundingYear());
                entity.setLeader(updatedPartiPolitike.getLeader());
                entity.setRulingParty(updatedPartiPolitike.isRulingParty());
                entity.setHeadquarters(updatedPartiPolitike.getHeadquarters());
                entity.setNumberOfMembers(updatedPartiPolitike.getNumberOfMembers());

                repository.save(entity);
        }

        @Override
        public void removeById(Long id) {
                repository.deleteById(id);
        }

        @Override
        public PartiPolitikeDto findById(Long id) {
                var entity = repository.findById(id);
                if (entity.isEmpty())
                        throw new RuntimeException("Political party not found");
                var dto = partiPolitikeMapper.toDto(entity.get());
                return dto;
        }

        @Override
        public List<PartiPolitikeDto> findAll() {
                return repository.findAll().stream().map(partiPolitikeMapper::toDto).toList();
        }

        @Override
        public void changeStatus(long id, PartiPolitikeDto statusChangeDto) {
                var optionalEntity = repository.findById(id);
                if (optionalEntity.isEmpty())
                        throw new EntityNotFoundException("Entity not found with id: " + id);
                var entity = optionalEntity.get();
                entity.setRulingParty(statusChangeDto.isRulingParty());
                repository.save(entity);
        }
}