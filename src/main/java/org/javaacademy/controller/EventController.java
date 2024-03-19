package org.javaacademy.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.dto.EventDto;
import org.javaacademy.service.EventService;
import org.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {
    private final EventService eventService;
    private final UserService userService;

    @PostMapping("/event/{token")
    public ResponseEntity<?> createEvent(@PathVariable String token, @RequestBody EventDto eventDto) {
        if (token == null) {
            return new ResponseEntity<>("Токен пользователя не задан", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(eventService.createEvent(userService.getUserByToken(token), eventDto),
                                    HttpStatus.OK);
    }
}
