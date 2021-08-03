package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@RestController
public class OffsetDateTimeController {

    @GetMapping("/offset/convert/local/{date}/{offset}")
    public OffsetDateTime convertLocal(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssZ") OffsetDateTime date, @PathVariable String offset) {
        return date.withOffsetSameInstant(ZoneOffset.of(offset));
    }

    @GetMapping("/offset/convert/instant/{date}/{offset}")
    public OffsetDateTime convertInstant(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssZ") OffsetDateTime date, @PathVariable String offset) {
        return date.withOffsetSameLocal(ZoneOffset.of(offset));
    }
}
