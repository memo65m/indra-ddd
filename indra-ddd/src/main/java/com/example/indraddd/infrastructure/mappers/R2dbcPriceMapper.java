package com.example.indraddd.infrastructure.mappers;

import com.example.indraddd.domain.models.Price;
import com.example.indraddd.infrastructure.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface R2dbcPriceMapper {

    R2dbcPriceMapper R2DBC_PRICE_MAPPER = Mappers.getMapper(R2dbcPriceMapper.class);

    PriceEntity priceToPriceEntity(Price price);

    Price priceEntityToPrice(PriceEntity priceEntity);

}
