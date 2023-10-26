package com.example.petback.service;

import com.example.petback.entity.ProductReview;
import com.example.petback.mapper.ProductReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewMapper productReviewMapper;

    public ProductReview addProductReview(ProductReview productReview) {
        // 检查参数是否为空

        if (Objects.equals(productReview.getUserId(),null) || Objects.equals(productReview.getUserId(),"")) {
            productReview.setReason("Error: UserId is missing");
            return productReview;
        }

        if (productReview.getReviewContent() == null || productReview.getReviewContent().isEmpty()) {
            productReview.setReason("Error: ReviewContent is missing");
            return productReview;
        }
        if (Objects.equals(productReview.getProductId(),null) || Objects.equals(productReview.getProductId(),"")) {
            productReview.setReason("Error: ProductId is missing");
            return productReview;
        }

        // 调用 Mapper 插入数据
        productReviewMapper.addProductReview(productReview);
        productReview.setReason("successful");
        List<ProductReview> getProductReviewlist = productReviewMapper.getProductReviewList(productReview);
        return getProductReviewlist.get(0);
    }



    public ProductReview editProductReview(ProductReview productReview) {
        // 检查参数是否为空

        if (Objects.equals(productReview.getUserId(),null) || Objects.equals(productReview.getUserId(),"")) {
            productReview.setReason("Error: UserId is missing");
            return productReview;
        }

        if (productReview.getReviewContent() == null || productReview.getReviewContent().isEmpty()) {
            productReview.setReason("Error: ReviewContent is missing");
            return productReview;
        }

        if (Objects.equals(productReview.getReviewId(),null) || Objects.equals(productReview.getReviewId(),"")) {
            productReview.setReason("Error: ProductReviewId is missing");
            return productReview;
        }
        if (Objects.equals(productReview.getProductId(),null) || Objects.equals(productReview.getProductId(),"")) {
            productReview.setReason("Error: ProductId is missing");
            return productReview;
        }

        productReviewMapper.updateProductReview(productReview);
        productReview.setReason("successful");
        return productReview;
    }


    public ProductReview deleteProductReview(ProductReview productReview) {
        // 检查参数是否为空

        if (Objects.equals(productReview.getUserId(),null) || Objects.equals(productReview.getUserId(),"")) {
            productReview.setReason("Error: UserId is missing");
            return productReview;
        }


        if (Objects.equals(productReview.getReviewId(),null) || Objects.equals(productReview.getReviewId(),"")) {
            productReview.setReason("Error: UserId is missing");
            return productReview;
        }
        if (Objects.equals(productReview.getProductId(),null) || Objects.equals(productReview.getProductId(),"")) {
            productReview.setReason("Error: ProductId is missing");
            return productReview;
        }

        // 调用 Mapper 删除数据
        productReviewMapper.deleteProductReview(productReview);
        productReview.setReason("successful");
        return productReview;
    }

    public List<ProductReview> getProductReviewByproductId(int productId) {
        // 检查参数是否为空
        List<ProductReview> listbyuser =new ArrayList<>();;
        if (Objects.equals(productId,null) || Objects.equals(productId,"")) {
            listbyuser.get(0).setReason("Error: ProductId is missing");
            return listbyuser;
        }


        // 调用 Mapper 获取数据
        return productReviewMapper.getProductReviewByproductId(productId);
    }

}

