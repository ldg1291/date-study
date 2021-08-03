package com.example.demo.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ZonedDateTimeController {

    @GetMapping("/zoned/convert/local/{date}/{zoneId}")
    public ZonedDateTime convertLocal(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssz") ZonedDateTime date, @PathVariable String zoneId) {
        return date.withZoneSameInstant(ZoneId.of(zoneId));
    }

    @GetMapping("/zoned/convert/instant/{date}/{zoneId}")
    public ZonedDateTime convertInstant(@PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmmssz") ZonedDateTime date, @PathVariable String zoneId) {
        return date.withZoneSameLocal(ZoneId.of(zoneId));
    }

    @GetMapping("/zoned/all/{year}/{zoneId}")
    public List<ZonedDateTime> getAllFirstDateOfYear(@PathVariable Integer year, @PathVariable String zoneId) {

        return List.of(1,2,3,4,5,6,7,8,9,10,11,12)
                .stream()
                .map(month -> ZonedDateTime.of(LocalDateTime.of(year, month, 1, 0, 0, 0), ZoneId.of(zoneId)))
                .collect(Collectors.toList());
    }

    @GetMapping("/zoned/rules/{zoneId}")
    public ZoneRules getZoneRulse(@PathVariable String zoneId) {
        return ZoneId.of(zoneId).getRules();
    }
}
