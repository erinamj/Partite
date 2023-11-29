package com.example.partitepolitike.controllers;

import com.example.partitepolitike.entites.PartiPolitikeEntity;
import com.example.partitepolitike.models.PartiPolitikeDto;
import com.example.partitepolitike.services.PartiPolitikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parti-politike")
@CrossOrigin(origins = "*")
public class PartiPolitikeController {
    private final PartiPolitikeService partiPolitikeService;

    public PartiPolitikeController(PartiPolitikeService partiPolitikeService) {
        this.partiPolitikeService = partiPolitikeService;
    }

    @GetMapping
    public List<PartiPolitikeDto> getAllPartiPolitike() {
        return partiPolitikeService.findAll();
    }

    @GetMapping("/{id}")
    public PartiPolitikeDto getById(@PathVariable Long id) {
        return partiPolitikeService.findById(id);
    }

    @PostMapping
    public void addPartiPolitike(@RequestBody PartiPolitikeDto newPartiPolitike) {
        partiPolitikeService.add(newPartiPolitike);
    }

    @PutMapping("/{id}")
    public void updatePartiPolitike(@PathVariable Long id, @RequestBody PartiPolitikeEntity updatedPartiPolitike) {
        partiPolitikeService.modify(id, updatedPartiPolitike);
    }

    @DeleteMapping("/{id}")
    public void deletePartiPolitike(@PathVariable Long id) {
        partiPolitikeService.removeById(id);
    }
}
