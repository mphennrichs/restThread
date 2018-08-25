package com.inatel.services;

import com.inatel.domain.ProductOfferingPrice;

import java.util.List;

public interface ProductOfferingPriceService {

    List<ProductOfferingPrice> getAllProductOfferingPrice();

    List<ProductOfferingPrice> getAllActivatedProductOfferingPrice();

    void activateProductOfferingPrice() throws InterruptedException;

    ProductOfferingPrice getProductOfferingPrice(Long id);

    ProductOfferingPrice saveOrUpdateProductOfferingPrice(ProductOfferingPrice pop);

    ProductOfferingPrice deleteProductOfferingPrice(Long id);
}
