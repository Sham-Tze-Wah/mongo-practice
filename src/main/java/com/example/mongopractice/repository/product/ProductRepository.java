package com.example.mongopractice.repository.product;

import com.example.mongopractice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "select p from ProductEntity p WHERE p.name = ?1 and p.deleted = '0'")
    public List<ProductEntity> findByName(String name);
}
