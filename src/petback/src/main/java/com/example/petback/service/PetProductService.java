package com.example.petback.service;

import com.example.petback.entity.PetProduct;
import com.example.petback.mapper.PetProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetProductService {
    @Autowired
    private  PetProductMapper petProductMapper;

    public List<PetProduct> getPetProductsBypet(PetProduct petProduct) {
        // 检查参数是否为空
        List<PetProduct> listbypet =new ArrayList<>();;
        if (petProduct.getPet() == null || petProduct.getPet().isEmpty()) {
            petProduct.setReason("Error: Pet is missing");
            listbypet.add(petProduct);
            return listbypet;
        }


        // 调用 Mapper 获取数据
        return petProductMapper.getPetProductsbypet(petProduct.getPet());
    }
    public List<PetProduct> getPetProducts() {
        // 检查参数是否为空
        List<PetProduct> list =new ArrayList<>();;

        // 调用 Mapper 获取数据
        return petProductMapper.getPetProducts();
    }
}

