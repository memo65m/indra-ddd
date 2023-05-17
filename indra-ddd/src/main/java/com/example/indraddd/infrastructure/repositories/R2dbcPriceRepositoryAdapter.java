package com.example.indraddd.infrastructure.repositories;

import com.example.indraddd.domain.models.Price;
import com.example.indraddd.domain.ports.out.PriceRepositoryPort;
import com.example.indraddd.infrastructure.entities.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.example.indraddd.infrastructure.mappers.R2dbcPriceMapper.R2DBC_PRICE_MAPPER;

@Component
@RequiredArgsConstructor
public class R2dbcPriceRepositoryAdapter implements PriceRepositoryPort {

    private final R2dbcPriceRepository r2dbcPriceRepository;
    @Override
    public Mono<Price> getByDateAndProductAndBrand(String date, Price price) {
        PriceEntity priceEntity = R2DBC_PRICE_MAPPER.priceToPriceEntity(price);
        return r2dbcPriceRepository.getByDateAndProductAndBrand(priceEntity.getProductId(), priceEntity.getBrandId(), date)
                .map(R2DBC_PRICE_MAPPER::priceEntityToPrice);
    }
}
