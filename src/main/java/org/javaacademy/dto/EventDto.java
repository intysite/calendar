package org.javaacademy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class EventDto {
    private String user;
    private LocalDate datetime;
    private String description;
    private String category;
}
