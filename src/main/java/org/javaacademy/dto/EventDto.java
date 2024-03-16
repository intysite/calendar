package org.javaacademy.dto;

import lombok.Builder;
import lombok.Getter;
import org.javaacademy.entity.Category;

import java.time.LocalDate;

@Builder
@Getter
public class EventDto {
    private String user;
    private LocalDate datetime;
    private String description;
    private Category category;
}
