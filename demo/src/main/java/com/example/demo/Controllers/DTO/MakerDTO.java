package com.example.demo.Controllers.DTO;

import java.util.List;

import com.example.demo.Entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    private Long id;
    private String name;
    private List<Product> productList;
    
}
