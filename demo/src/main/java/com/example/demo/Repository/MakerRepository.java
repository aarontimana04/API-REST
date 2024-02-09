package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.Maker;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long>{
    
}
