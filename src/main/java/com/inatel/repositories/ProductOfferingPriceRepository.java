package com.inatel.repositories;

import com.inatel.domain.ProductOfferingPrice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductOfferingPriceRepository extends CrudRepository<ProductOfferingPrice, Long> {
    List<ProductOfferingPrice> findByActivatedTrue();
}
