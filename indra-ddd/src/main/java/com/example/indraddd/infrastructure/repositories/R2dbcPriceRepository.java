package com.example.indraddd.infrastructure.repositories;

import com.example.indraddd.infrastructure.entities.PriceEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface R2dbcPriceRepository extends R2dbcRepository<PriceEntity, Long> {

    @Query(value = "SELECT p.* FROM PRICE p LEFT JOIN BRAND b ON p.brand_id = b.id LEFT JOIN PRODUCT pro ON p.product_id = pro.id WHERE pro.id = ?1 AND b.id = ?2 AND ?3 >= FORMATDATETIME(start_date, 'dd HH:mm') AND ?3 <= FORMATDATETIME(end_date, 'dd HH:mm') ORDER BY p.priority DESC LIMIT 1")
    Mono<PriceEntity> getByDateAndProductAndBrand(Long productId, Long brandId, String date);

}
