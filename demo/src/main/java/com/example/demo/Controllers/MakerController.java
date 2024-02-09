package com.example.demo.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Controllers.DTO.MakerDTO;
import com.example.demo.Entities.Maker;
import com.example.demo.Services.IMakerService;

import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<MakerDTO> makerDTOList = makerService.findAll()
                                                  .stream()
                                                  .map(maker -> MakerDTO.builder()
                                                                       .id(maker.getId())
                                                                       .name(maker.getName())
                                                                       .productList(maker.getProductList())
                                                                       .build())
                                                                       .toList();

        return ResponseEntity.ok(makerDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMaker(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        if (makerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        makerService.save(Maker.builder().name(makerDTO.getName()).build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){

        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            makerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("El parametro id se encuentra vacio");
    }
}