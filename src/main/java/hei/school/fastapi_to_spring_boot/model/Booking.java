package hei.school.fastapi_to_spring_boot.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {
    private String clientName;
    private String phoneNumber;
    private String email;
    private int roomNumber;
    private String roomDescription;
    private LocalDate bookingDate;
}
