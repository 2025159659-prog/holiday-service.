package com.system.holiday.controller;

import com.system.holiday.model.Holiday;
import com.system.holiday.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@CrossOrigin(origins = "*")
public class HolidayController {
    @Autowired
    private HolidayRepository repository;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return repository.findAll();
    }
}