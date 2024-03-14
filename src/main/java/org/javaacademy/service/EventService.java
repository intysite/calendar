package org.javaacademy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    public Long createEvent() {
        return 100L;
    }
}
