/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventManager;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Event;

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
    private Date ended;
    private Date created;
    private List<Event> events;
    
    public void submit() {
        Event e = new Event(message, author, subject, ended);
        
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
        events = emanager.getEvents();
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

    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
}
