package com.co.storeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.storeback.entity.ProductEntity;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {

}
