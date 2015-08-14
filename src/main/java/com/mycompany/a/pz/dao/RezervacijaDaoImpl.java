/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Rezervacija;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class RezervacijaDaoImpl implements RezervacijaDao {

    
    @Inject
    private Session session;

    @Override
    public List<Rezervacija> getListaRezervacija() {
        return session.createCriteria(Rezervacija.class).list();
    }

    @Override
    public Rezervacija getRezervacijaById(Integer id) {
         return (Rezervacija) session.createCriteria(Rezervacija.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajRezervaciju(Rezervacija koncert) {
       session.persist(koncert);
    }

    @Override
    public Rezervacija dodajIliUpdatujRezervaciju(Rezervacija rezervacija) {
        return (Rezervacija) session.merge(rezervacija);
    }

    @Override
    public void obrisiRezervaciju(int id) {
        Rezervacija exRez = (Rezervacija) session.createCriteria(Rezervacija.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(exRez);
    }
     
    
}
