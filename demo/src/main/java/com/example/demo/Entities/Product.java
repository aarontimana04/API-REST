package com.example.demo.Entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;
    
    @Column(name = "precio")
    private BigDecimal price; //BigDecimal es parecido al float, más apropiado por cuando
                              // se trata de cantidades monetarias

    //RELACION ENTRE ENTIDADES
    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    @JsonIgnore
    private Maker maker;

}
