package com.telusko.ecom_project.service;

import com.telusko.ecom_project.model.Product;
import com.telusko.ecom_project.repo.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepo repo;

    public List<Product> getAllProducts() {

        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setId(resolveProductId(product.getId()));
        product.setStockQuantity(product.getStockQuantity() == null ? 0 : product.getStockQuantity());
        product.setProductAvailable(Boolean.TRUE.equals(product.getProductAvailable()));
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);
    }

    private Integer resolveProductId(Integer requestedId) {
        if (requestedId != null) {
            return requestedId;
        }

        return repo.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream()
                .map(Product::getId)
                .filter(Objects::nonNull)
                .findFirst()
                .map(id -> id + 1)
                .orElse(1);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }

    public void deleteProduct(int id)
    {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
