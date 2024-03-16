package org.javaacademy.service;

import lombok.AllArgsConstructor;
import org.javaacademy.dto.EventDto;
import org.javaacademy.entity.Category;
import org.javaacademy.entity.Event;
import org.javaacademy.mapper.EventMapper;
import org.javaacademy.repository.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class EventService {

    @Autowired
    EventMapper eventMapper;
    EventDao eventDao;

    public Long createEvent(EventDto eventDto) {
        Category category;
        if (Arrays.stream(Category.values()).anyMatch(e -> e.name().equals(eventDto.getCategory()))) {
            category = Category.valueOf(eventDto.getCategory());
        } else {
            category = Category.OTHER;
        }
        eventDto.setCategory(category.toString());

        Event event = eventMapper.castToEntity(eventDto);
        eventDao.save(event);
        return event.getId();
    }
}
