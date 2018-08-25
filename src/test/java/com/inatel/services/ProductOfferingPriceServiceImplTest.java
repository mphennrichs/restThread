package com.inatel.services;

import com.inatel.domain.ProductOfferingPrice;
import com.inatel.repositories.ProductOfferingPriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;

public class ProductOfferingPriceServiceImplTest {

  @Mock
  ProductOfferingPriceRepository productOfferingPriceRepository;

  @InjectMocks
  ProductOfferingPriceServiceImpl productOfferingPriceService;

  @Before
  public void setUp() throws Exception {

    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void shouldDeleteProductOfferingPrice() {

    ProductOfferingPrice original = ProductOfferingPrice.builder()
            .id(1L)
            .code("code")
            .description("descrition")
            .name("original")
            .activated(true)
            .build();

    ProductOfferingPrice updated = ProductOfferingPrice.builder()
            .id(1L)
            .code("code")
            .description("descrition")
            .name("original")
            .activated(false)
            .build();

    Mockito.doReturn(Optional.of(original)).when(productOfferingPriceRepository).findById(anyLong());
    Mockito.doReturn(updated).when(productOfferingPriceRepository).save(any(ProductOfferingPrice.class));

    ProductOfferingPrice result = productOfferingPriceService.deleteProductOfferingPrice(1L);

    assertTrue(result.getId().equals(original.getId()));
    assertTrue(result.getCode().equals(original.getCode()));
    assertTrue(result.getDescription().equals(original.getDescription()));
    assertTrue(result.getName().equals(original.getName()));
    assertTrue(result.getActivated().equals(updated.getActivated()));
  }
}