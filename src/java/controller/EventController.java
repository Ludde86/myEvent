/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventManager;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;
import model.Event;
import org.primefaces.component.outputlabel.OutputLabel;

/**
 *
 * @author Ludde
 */
@Named(value = "eventController")
@RequestScoped
public class EventController {

    @Inject
    EventManager emanager;

    private String message;
    private String author;
    private String subject;
    private String ended;
    private String created;
    private List<Event> events;
    private List<Event> eventsFam;
    private List<Event> eventsPol;
    private List<Event> eventsSpa;
    private List<Event> eventsSpo;
    
    private String id;

    
    public void submit() {
        Event e = new Event(message, author, subject, LocalDate.parse(ended));
        
        switch (this.subject) {
            case "Family":
                this.subject = "Family";
                break;
            case "Politics":
                this.subject = "Politics";
                break;
            case "Space":
                this.subject = "Space";
                break;
            case "Sports":
                this.subject = "Sports";
                break;
        }

        emanager.addEvent(e);
        fillArray();
    }

    public void submitDel(Event e) {
        emanager.deleteEvent(e);
        fillArray();
    }

    public String edit(Event e) {
        return "update?faces-redirect=true&id=" + e.getId() + "&created=" + e.getCreated();
    }
    
    public void submitUpd() {
       Event event = new Event(message, author, subject, LocalDate.parse(ended));
       event.setId(Long.parseLong(id));
       event.setCreated(LocalDate.parse(created));
        emanager.updateEvent(event);
    }

    @PostConstruct
    public void fillArray() {
        events = emanager.getEvents();
        eventsFam = emanager.getFamilyEvents();
        eventsPol = emanager.getPoliticsEvents();
        eventsSpa = emanager.getSpaceEvents();
        eventsSpo = emanager.getSportsEvents();
    }

    public EventController() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEnded() {
        return ended;
    }

    public void setEnded(String ended) {
        this.ended = ended;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEventsFam() {
        return eventsFam;
    }

    public void setEventsFam(List<Event> eventsFam) {
        this.eventsFam = eventsFam;
    }

    public List<Event> getEventsPol() {
        return eventsPol;
    }

    public void setEventsPol(List<Event> eventsPol) {
        this.eventsPol = eventsPol;
    }

    public List<Event> getEventsSpa() {
        return eventsSpa;
    }

    public void setEventsSpa(List<Event> eventsSpa) {
        this.eventsSpa = eventsSpa;
    }

    public List<Event> getEventsSpo() {
        return eventsSpo;
    }

    public void setEventsSpo(List<Event> eventsSpo) {
        this.eventsSpo = eventsSpo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
