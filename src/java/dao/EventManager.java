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
    
    public List<Event> getEvents() {
        Query q = em.createQuery("select e from Event e");
        return q.getResultList();
    }
    
}
