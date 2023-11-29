package com.example.partitepolitike.entites;


import com.example.partitepolitike.models.PartiPolitikeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PartiPolitike")
public class PartiPolitikeEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ideology;
    private int foundingYear;
    private String leader;
    private boolean isRulingParty;
    private String headquarters;
    private int numberOfMembers;

}
