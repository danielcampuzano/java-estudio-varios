package com.co.storeback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.storeback.entity.SizeEntity;

public interface ISizeRepository extends JpaRepository<SizeEntity, Integer> {

}
