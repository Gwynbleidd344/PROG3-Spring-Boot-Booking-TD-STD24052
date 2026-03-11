package hei.school.fastapi_to_spring_boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hei.school.fastapi_to_spring_boot.model.Booking;

@RestController
public class BookingController {
    List<Booking> savedBookings = new ArrayList<>();

    @GetMapping("/bookings")
    public List<Booking> getSavedBookings() {
        return savedBookings;
    }
}
