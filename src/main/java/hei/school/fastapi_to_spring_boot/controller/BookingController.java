package hei.school.fastapi_to_spring_boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hei.school.fastapi_to_spring_boot.model.Booking;

@RestController
public class BookingController {
    List<Booking> savedBookings = new ArrayList<>();

    @GetMapping("/bookings")
    public List<Booking> getSavedBookings() {
        return savedBookings;
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@RequestBody List<Booking> newBookings) {
        List<Booking> processedBookings = new ArrayList<>();

        for (Booking booking : newBookings) {

            if (booking.getRoomNumber() < 1 || booking.getRoomNumber() > 9) {
                return ResponseEntity.badRequest().body("Error: Invalid room number: "+ booking.getRoomNumber() +" (must be between 1 and 9)");
            }

            boolean bookingExists = savedBookings.stream()
                    .anyMatch(existing -> existing.getRoomNumber() == booking.getRoomNumber() &&
                            existing.getBookingDate().equals(booking.getBookingDate()));

            if (bookingExists) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Room" + booking.getRoomNumber() + "is already taken on " + booking.getBookingDate());
            } else {
                processedBookings.add(booking);
            }
        }
        savedBookings.addAll(processedBookings);
        return ResponseEntity.status(HttpStatus.CREATED).body(processedBookings);
    }
}
