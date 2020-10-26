package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class seat {
    String train_id;
    String seat_id;
    String seat_type;
    String seat_location;
    String seat_price;
    String seat_carriage;
}
