package com.example.lab5.Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Event {
    private String ID;
    private String description;
    private int capacity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
