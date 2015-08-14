/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Koncert;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class KoncertDaoImpl implements KoncertDao{
    
    @Inject
    private Session session;

    @Override
    public List<Koncert> getListaKoncerata() {
         return session.createCriteria(Koncert.class).list();
    }

    @Override
    public Koncert getKoncertById(Integer id) {
       return (Koncert) session.createCriteria(Koncert.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajKoncert(Koncert koncert) {
       session.persist(koncert);
    }

    @Override
    public Koncert dodajIliUpdatujKoncert(Koncert koncert) {
       return (Koncert) session.merge(koncert);
    }

    @Override
    public void obrisiKoncert(int id) {
         Koncert exKon = (Koncert) session.createCriteria(Koncert.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(exKon);
    }
}
