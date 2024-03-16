package org.javaacademy.mapper;

import org.javaacademy.dto.EventDto;
import org.javaacademy.entity.Event;
import org.javaacademy.entity.User;
import org.javaacademy.exception.UserNotFoundException;
import org.javaacademy.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    @Autowired
    UserDao userDao;
    public Event castToEntity(EventDto eventDto) {
        User user = userDao.findByName(eventDto.getUser())
                .orElseThrow(() -> new UserNotFoundException("Не найден пользователь с почтой " + eventDto.getUser()));
        return new Event(user,
                eventDto.getDatetime(),
                eventDto.getDescription(),
                eventDto.getCategory());
    }

    public EventDto castToDto(Event event) {
        return EventDto.builder()
                .user(event.getUser().getName())
                .datetime(event.getDatetime())
                .description(event.getDescription())
                .category(event.getCategory())
                .build();
    }
}
