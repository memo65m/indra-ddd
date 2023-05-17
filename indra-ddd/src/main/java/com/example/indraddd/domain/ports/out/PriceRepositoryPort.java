package com.example.indraddd.domain.ports.out;

import com.example.indraddd.domain.models.Price;
import reactor.core.publisher.Mono;

public interface PriceRepositoryPort {
    Mono<Price> getByDateAndProductAndBrand(String date, Price price);

}
