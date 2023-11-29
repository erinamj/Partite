package com.example.partitepolitike.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartiPolitikeDto {
    private Long id;
    private String name;
    private String ideology;
    private int foundingYear;
    private String leader;
    private boolean isRulingParty;
    private String headquarters;
    private int numberOfMembers;

}
