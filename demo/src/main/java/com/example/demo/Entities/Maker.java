package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fabricante")

public class Maker {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA generará el ID unico para cada entidad
    private Long id;

    @Column(name = "nombre")
    private String name;

    //Un fabricante puede producir muchos productos
    @OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();
}
