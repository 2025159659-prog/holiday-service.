package com.system.holiday.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Model Entiti untuk jadual holidays dalam pangkalan data.
 * Medan holidayType ditambah untuk menyimpan kategori cuti (cth: PUBLIC, STATE).
 */
@Entity
@Table(name = "holidays")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String holidayName;

    @Column(nullable = false)
    private LocalDate holidayDate;

    // Medan baru untuk mengelakkan nilai null pada kategori
    @Column(name = "holiday_type")
    private String holidayType;

    // Konstruktor Kosong (Diperlukan oleh JPA)
    public Holiday() {
    }

    // Konstruktor Penuh
    public Holiday(String holidayName, LocalDate holidayDate, String holidayType) {
        this.holidayName = holidayName;
        this.holidayDate = holidayDate;
        this.holidayType = holidayType;
    }

    // --- Getter dan Setter ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public LocalDate getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }
}
