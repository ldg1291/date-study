package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZonedDateTime;

@RestController
public class InstantController {

    @GetMapping("/instant/now")
    public Instant getNow() {
        return Instant.now();
    }

    @GetMapping("/instant/equals/{date1}/{date2}")
    public Boolean isEqualInstant (@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssz") ZonedDateTime date1, @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssz") ZonedDateTime date2) {
        return date1.toInstant().getEpochSecond() == date2.toInstant().getEpochSecond();
    }
}
