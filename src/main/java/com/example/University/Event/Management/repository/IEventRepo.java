package com.example.University.Event.Management.repository;


import jdk.jfr.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface IEventRepo extends CrudRepository<Event,Long> {
    List<Event> findAllByDate(LocalDate date);
}