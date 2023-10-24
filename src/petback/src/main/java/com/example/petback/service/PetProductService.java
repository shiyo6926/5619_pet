package com.example.petback.service;

import com.example.petback.entity.PetProduct;
import com.example.petback.mapper.PetProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetProductService {
    private  PetProductMapper petProductMapper;

    public List<PetProduct> getPetProductsBytag(PetProduct petProduct) {
        // 检查参数是否为空
        List<PetProduct> listbytag =new ArrayList<>();;
        if (petProduct.getTag() == null || petProduct.getTag().isEmpty()) {
            petProduct.setReason("Error: Tag is missing");
            listbytag.add(petProduct);
            return listbytag;
        }


        // 调用 Mapper 获取数据
        return petProductMapper.getPetProductsbytag(petProduct.getTag());
    }
    public List<PetProduct> getPetProducts() {
        // 检查参数是否为空
        List<PetProduct> list =new ArrayList<>();;

        // 调用 Mapper 获取数据
        return petProductMapper.getPetProducts();
    }
}

