package com.example.indraddd.domain.ports.in;

import com.example.indraddd.domain.models.Price;
import reactor.core.publisher.Mono;

public interface RetrievePriceUseCase {
    Mono<Price> getByDateAndProductAndBrand(String date, Price price);

}
