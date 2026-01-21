package com.system.holiday.controller;

import com.system.holiday.model.Holiday;
import com.system.holiday.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        holiday.setId(id);
        return holidayRepository.save(holiday);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayRepository.deleteById(id);
    }
}
