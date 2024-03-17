package org.javaacademy.mapper;

import org.javaacademy.dto.EventDto;
import org.javaacademy.entity.Category;
import org.javaacademy.entity.Event;
import org.javaacademy.entity.User;
import org.javaacademy.exception.UserNotFoundException;
import org.javaacademy.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EventMapper {
    @Autowired
    UserDao userDao;
    public Event castToEntity(User user, EventDto eventDto) {
        return new Event(user,
                eventDto.getDatetime(),
                eventDto.getDescription(),
                Category.valueOf(eventDto.getCategory()));
    }

    public EventDto castToDto(Event event) {
        return EventDto.builder()
                .user(event.getUser().getName())
                .datetime(event.getDatetime())
                .description(event.getDescription())
                .category(event.getCategory().toString())
                .build();
    }
}
