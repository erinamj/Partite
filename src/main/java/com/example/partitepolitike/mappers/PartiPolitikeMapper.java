package com.example.partitepolitike.mappers;

import com.example.partitepolitike.entites.PartiPolitikeEntity;
import com.example.partitepolitike.models.PartiPolitikeDto;
import org.springframework.stereotype.Component;

@Component
public class PartiPolitikeMapper {
    public PartiPolitikeEntity toEntity(PartiPolitikeDto dto) {
        var entity = new PartiPolitikeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setIdeology(dto.getIdeology());
        entity.setFoundingYear(dto.getFoundingYear());
        entity.setLeader(dto.getLeader());
        entity.setRulingParty(dto.isRulingParty());
        entity.setHeadquarters(dto.getHeadquarters());
        entity.setNumberOfMembers(dto.getNumberOfMembers());
        return entity;
    }

    public PartiPolitikeDto toDto(PartiPolitikeDto entity) {
        var dto = new PartiPolitikeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIdeology(entity.getIdeology());
        dto.setFoundingYear(entity.getFoundingYear());
        dto.setLeader(entity.getLeader());
        dto.setRulingParty(entity.isRulingParty());
        return dto;
    }
}
