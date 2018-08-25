package com.inatel.services;

import com.inatel.domain.ConfigVariable;
import com.inatel.domain.ProductOfferingPrice;
import com.inatel.repositories.ProductOfferingPriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductOfferingPriceServiceImpl implements ProductOfferingPriceService {

    @Autowired
    ProductOfferingPriceRepository productOfferingPriceRepository;

    @Autowired
    ConfigVariableService configVariableService;

    static final String APPROVED_PRICE_NAME = "approved_price";
    static final String EXECUTION_TIME_NAME = "execution_time";

    @Override
    public List<ProductOfferingPrice> getAllProductOfferingPrice() {

        List<ProductOfferingPrice> allPops = new ArrayList<>();

        productOfferingPriceRepository.findAll().forEach(allPops::add);

        return allPops;
    }

    @Override
    public List<ProductOfferingPrice> getAllActivatedProductOfferingPrice() {
        return productOfferingPriceRepository.findByActivatedTrue();
    }

    @Override
    public void activateProductOfferingPrice() throws InterruptedException {
        ConfigVariable approvedPrice = configVariableService
                .getConfigurationByNameAndActiveTrue(APPROVED_PRICE_NAME);

        Double approvedPriceValue = Double.parseDouble(approvedPrice.getValue());

        List<ProductOfferingPrice> popList = getAllProductOfferingPrice();

        //create a list of Callables to process the checkActivated for each POP
        List<Callable<ProductOfferingPrice>> callList = popList.stream()
                .map(pop -> (
                        (Callable<ProductOfferingPrice>)(() -> checkActivated(pop,approvedPriceValue))
                        )
                )
                .collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool (4);

        executorService.invokeAll(callList);
    }

    private ProductOfferingPrice checkActivated(ProductOfferingPrice pop, Double approvedPrice){
        if (!pop.getActivated() && pop.getPrice().equals(approvedPrice)){

            log.info("[CHECKACTIVATED] activating: " + pop);

            pop.setActivated(true);
            saveOrUpdateProductOfferingPrice(pop);
        }

        return pop;
    }

    @Override
    public ProductOfferingPrice getProductOfferingPrice(Long id) {

        return  productOfferingPriceRepository.findById(id).orElse(null);
    }

    @Override
    public ProductOfferingPrice saveOrUpdateProductOfferingPrice(ProductOfferingPrice pop) {

        log.info("[SAVE] saved: " + pop);

        return  productOfferingPriceRepository.save(pop);
    }

    @Override
    public ProductOfferingPrice deleteProductOfferingPrice(Long id) {
        ProductOfferingPrice pop = getProductOfferingPrice(id);
        pop.setActivated(false);

        ProductOfferingPrice result = productOfferingPriceRepository.save(pop);

        log.info("[DELETE] deleted: " + result);

        return result;
    }
}
