package com.example.demo.Controllers.DTO;

import java.math.BigDecimal;

import com.example.demo.Entities.Maker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Maker maker;
}
