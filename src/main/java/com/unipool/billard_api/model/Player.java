package com.unipool.billard_api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "player", schema = "public") // Remplace "billard" par le bon schéma
@NoArgsConstructor
public class Player  implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName ="";
    private String lastName ="";
    private String email;
    private String password;
    private  int points =0;

}
