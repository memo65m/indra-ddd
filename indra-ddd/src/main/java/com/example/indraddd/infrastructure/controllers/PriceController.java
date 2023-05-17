package com.example.indraddd.infrastructure.controllers;

import com.example.indraddd.application.services.PriceService;
import com.example.indraddd.domain.models.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @GetMapping(value = "/rate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Price> getRate(
            @RequestParam @DateTimeFormat(pattern = "dd HH:mm") String date,
            @RequestParam Long productId,
            @RequestParam Long brandId) {
        return priceService.getByDateAndProductAndBrand(date, Price.builder().productId(productId).brandId(brandId).build());
    }

}
