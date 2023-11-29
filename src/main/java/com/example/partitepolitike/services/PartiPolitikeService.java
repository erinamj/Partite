package com.example.partitepolitike.services;

import com.example.partitepolitike.entites.PartiPolitikeEntity;
import com.example.partitepolitike.models.PartiPolitikeDto;

import java.util.List;

public interface PartiPolitikeService {

    void add(PartiPolitikeDto partiPolitike);


    void modify(Long id, PartiPolitikeEntity updatedPartiPolitike);

    void removeById(Long id);

    PartiPolitikeDto findById(Long id);

    List<PartiPolitikeDto> findAll();
    void changeStatus(long id, PartiPolitikeDto statusChangeDto);

}

