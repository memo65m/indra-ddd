package com.example.indraddd.application.services;

import com.example.indraddd.domain.models.Price;
import com.example.indraddd.domain.ports.in.RetrievePriceUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PriceService implements RetrievePriceUseCase {

    private final RetrievePriceUseCase retrievePriceUseCase;

    @Override
    public Mono<Price> getByDateAndProductAndBrand(String date, Price price) {
        return retrievePriceUseCase.getByDateAndProductAndBrand(date, price);
    }

}
