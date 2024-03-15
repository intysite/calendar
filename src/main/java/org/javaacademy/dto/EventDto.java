package org.javaacademy.dto;

import lombok.Data;
import org.javaacademy.entity.Category;

import java.time.LocalDate;

@Data
public class EventDto {
    private String user;
    private LocalDate datetime;
    private String description;
    private Category category;
}
