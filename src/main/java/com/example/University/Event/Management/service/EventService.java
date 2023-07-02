package com.example.University.Event.Management.service;

import com.example.University.Event.Management.repository.IEventRepo;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private IEventRepo iEventRepo;
    public Event addEvent(Event event) {
        return iEventRepo.save(event);
    }

    public Optional<Event> updateEvent(Long eventId, Event event) {
        Optional<Event> optionalEvent = iEventRepo.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.set(event.getClass());
            existingEvent.clone();
            existingEvent.set(event.getClass());
            existingEvent.toString(event.getClass());
            existingEvent.set(event.end());
            iEventRepo.save(existingEvent);
        }
        return optionalEvent;
    }

    public boolean deleteEvent(Long eventId) {
        if (iEventRepo.existsById(eventId)) {
            iEventRepo.deleteById(eventId);
            return true;
        }
        return false;
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return iEventRepo.findAllByDate(date);
    }

}