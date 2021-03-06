package controller;

import dao.EventManager;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
    private String ended;
    private String created;
    private List<Event> events;
    private List<Event> eventsFam;
    private List<Event> eventsPol;
    private List<Event> eventsSpa;
    private List<Event> eventsSpo;
    private List<Event> eventsOth;

    private String id;

    public String submit() {
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
            case "Other":
                this.subject = "Other";
                break;
        }

        emanager.addEvent(e);
        fillArray();
        return "created";
    }

    public void submitDel(Event e) {
        emanager.deleteEvent(e);
        fillArray();
    }

    // när edit anropas skickas eventet och dess data till update.html
    public String edit(Event e) {
        return "update?faces-redirect=true&id=" + e.getId() + "&created=" + e.getCreated() + "&message=" 
                + e.getMessage() + "&author=" + e.getAuthor() + "&ended=" + e.getEnded() + "&subject=" + e.getSubject();
    }

    public String submitUpd() {
        Event newE = new Event(message, author, subject, LocalDate.parse(ended));
        newE.setId(Long.parseLong(id));
        newE.setCreated(LocalDate.parse(created));
        emanager.updateEvent(newE);
        return "updated";
    }

    @PostConstruct
    public void fillArray() {
        events = emanager.getEvents();
        eventsFam = emanager.getFamilyEvents();
        eventsPol = emanager.getPoliticsEvents();
        eventsSpa = emanager.getSpaceEvents();
        eventsSpo = emanager.getSportsEvents();
        eventsOth = emanager.getOtherEvents();
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

    public List<Event> getEventsOth() {
        return eventsOth;
    }

    public void setEventsOth(List<Event> eventsOth) {
        this.eventsOth = eventsOth;
    }

}
