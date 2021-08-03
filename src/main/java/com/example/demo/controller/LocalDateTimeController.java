package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class LocalDateTimeController {

    @GetMapping("/local/calculate/{date}/{amount}")
    public LocalDateTime calculate(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmss") LocalDateTime date, @PathVariable Long amount) {
        return date.plusDays(amount);
    }
}
