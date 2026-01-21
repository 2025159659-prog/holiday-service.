@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    // TAMBAH INI UNTUK FIX ERROR 405 (ADD)
    @PostMapping
    public Holiday createHoliday(@RequestBody Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    // TAMBAH INI UNTUK UPDATE
    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        holiday.setId(id);
        return holidayRepository.save(holiday);
    }

    // TAMBAH INI UNTUK DELETE
    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayRepository.deleteById(id);
    }
}

**Ringkasan Perubahan:**
1.  **ManageHoliday.java (Canvas)**: Sekarang menggunakan `Map` untuk menghantar data supaya nama medan sepadan (`holidayName` & `holidayDate`). Saya juga menambah `JsonDeserializer` untuk menukar data dari API masuk ke dalam `bean.Holiday` dengan betul.
2.  **HolidayController.java (Microservice)**: Perlu ditambah `@PostMapping`, `@PutMapping`, dan `@DeleteMapping` untuk menerima permintaan dari Servlet.

Sila kemaskini kedua-dua fail tersebut dan cuba jalankan semula. Beritahu saya jika anda masih mendapat ralat!
