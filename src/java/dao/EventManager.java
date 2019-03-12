/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Event;

/**
 *
 * @author Ludde
 */
@Stateless
public class EventManager {

    @PersistenceContext
    EntityManager em;
    
    public void addEvent(Event e) {
        em.persist(e);
    }
    
    public void deleteEvent(Event e) {
        em.remove(em.find(Event.class, e.getId()));
    }
    
    public List<Event> getEvents() {
        Query q = em.createQuery("select e from Event e");
        return q.getResultList();
    }
    
    public List<Event> getFamilyEvents() {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.subject = 'Family'");
        return q.getResultList();
    }
    
    public List<Event> getPoliticsEvents() {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.subject = 'Politics'");
        return q.getResultList();
    }
    
    public List<Event> getSpaceEvents() {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.subject = 'Space'");
        return q.getResultList();
    }
    
    public List<Event> getSportsEvents() {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.subject = 'Sports'");
        return q.getResultList();
    }
    
    public Event findEvent(Long id) {
        return em.find(Event.class, id);
    }
    
}
