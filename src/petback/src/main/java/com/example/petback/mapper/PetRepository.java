package com.example.petback.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
    // 可以添加自定义查询方法，根据需要
}
