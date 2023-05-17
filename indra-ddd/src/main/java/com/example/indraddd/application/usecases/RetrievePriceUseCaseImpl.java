package com.example.indraddd.application.usecases;

import com.example.indraddd.domain.models.Price;
import com.example.indraddd.domain.ports.in.RetrievePriceUseCase;
import com.example.indraddd.domain.ports.out.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RetrievePriceUseCaseImpl implements RetrievePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;


    @Override
    public Mono<Price> getByDateAndProductAndBrand(String date, Price price) {
        return priceRepositoryPort.getByDateAndProductAndBrand(date, price);
    }

}
