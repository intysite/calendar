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
    public Event castToEntity(EventDto eventDto) {
        User user = userDao.findByName(eventDto.getUser())
                .orElseThrow(() -> new UserNotFoundException("Не найден пользователь с почтой " + eventDto.getUser()));
        Category category;
        if (Arrays.stream(Category.values()).anyMatch(e -> e.name().equals(eventDto.getCategory()))) {
            category = Category.valueOf(eventDto.getCategory());
        } else {
            category = Category.OTHER;
        }

        return new Event(user,
                eventDto.getDatetime(),
                eventDto.getDescription(),
                category);
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
