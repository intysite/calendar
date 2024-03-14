package org.javaacademy.repository;

import org.javaacademy.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDao extends JpaRepository<Event, Long> {

}
