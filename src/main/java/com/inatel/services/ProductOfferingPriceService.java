package com.inatel.services;

import com.inatel.domain.ProductOfferingPrice;

import java.util.List;

public interface ProductOfferingPriceService {

    List<ProductOfferingPrice> getAllProductOfferingPrice();

    ProductOfferingPrice getProductOfferingPrice(Long id);

    ProductOfferingPrice addProductOfferingPrice(ProductOfferingPrice pop);

    ProductOfferingPrice updateProductOfferingPrice(ProductOfferingPrice pop);

    ProductOfferingPrice deleteProductOfferingPrice(Long id);
}
