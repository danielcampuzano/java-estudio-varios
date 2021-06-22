package com.co.storeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.storeback.entity.PriceEntity;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Integer> {


}
