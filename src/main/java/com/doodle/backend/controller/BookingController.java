package com.doodle.backend.controller;


import com.doodle.backend.entities.Booking;
import com.doodle.backend.services.BookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingServiceImp bookingServiceImpl;
    @GetMapping("/bookings")
    public List<Booking> listBooking() {
        return bookingServiceImpl.getAllBookings();
    }


    @PostMapping("/create")
    public ResponseEntity<Booking> createEvent(@RequestBody Booking booking) {
        Booking createdEvent = bookingServiceImpl.createEvent(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }
    @GetMapping("/event/{IdBooking}")
    public ResponseEntity<Booking> getEventById(@PathVariable Long IdBooking) {
        Optional<Booking> event = bookingServiceImpl.getEventById(IdBooking);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{IdBooking}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long IdBooking) {
        bookingServiceImpl.deleteBooking(IdBooking);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @PatchMapping("/update/{IdBooking}")
    public ResponseEntity<String> updateEvent(@PathVariable Long IdBooking, @RequestBody Map<String, Object> updates) {
        boolean updated = bookingServiceImpl.updateEvent(IdBooking, (Map<String, Object>) updates);

        if (updated) {
            return ResponseEntity.ok("Event updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
    }

    @PostMapping("/bookEvent")
    public ResponseEntity<String> bookEvent(@RequestParam Long IdBooking, @RequestParam Long IdUser) {
        try {
            bookingServiceImpl.bookEvent(IdBooking, IdUser);
            return ResponseEntity.ok("Booking successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Booking failed");
        }
    }

}
