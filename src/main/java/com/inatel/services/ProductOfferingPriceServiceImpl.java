package com.inatel.services;

import com.inatel.domain.ProductOfferingPrice;
import com.inatel.repositories.ProductOfferingPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductOfferingPriceServiceImpl implements ProductOfferingPriceService {

    @Autowired
    ProductOfferingPriceRepository productOfferingPriceRepository;

    @Override
    public List<ProductOfferingPrice> getAllProductOfferingPrice() {

        List<ProductOfferingPrice> allPops = new ArrayList<>();

        productOfferingPriceRepository.findAll().forEach(allPops::add);

        return allPops;
    }

    @Override
    public ProductOfferingPrice getProductOfferingPrice(Long id) {

        return  productOfferingPriceRepository.findById(id).orElse(null);
    }

    @Override
    public ProductOfferingPrice addProductOfferingPrice(ProductOfferingPrice pop) {

        return  productOfferingPriceRepository.save(pop);
    }

    @Override
    public ProductOfferingPrice updateProductOfferingPrice(ProductOfferingPrice pop) {
        return productOfferingPriceRepository.save(pop);
    }

    @Override
    public ProductOfferingPrice deleteProductOfferingPrice(Long id) {
        ProductOfferingPrice pop = getProductOfferingPrice(id);
        pop.setActivated(false);

        return productOfferingPriceRepository.save(pop);
    }
}
