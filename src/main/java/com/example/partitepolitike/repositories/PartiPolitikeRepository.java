package com.example.partitepolitike.repositories;

import com.example.partitepolitike.entites.PartiPolitikeEntity;
import com.example.partitepolitike.models.PartiPolitikeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiPolitikeRepository extends JpaRepository<PartiPolitikeEntity, Long> {
}
