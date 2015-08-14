/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Kupovina;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class KupovinaDaoImpl implements KupovinaDao {
    @Inject
    private Session session;

    @Override
    public List<Kupovina> getListaKupovina() {
        return session.createCriteria(Kupovina.class).list();
    }

    @Override
    public Kupovina getKupovinaById(Integer id) {
       return (Kupovina) session.createCriteria(Kupovina.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajKupovinu(Kupovina koncert) {
        session.persist(koncert);
        
    }

    @Override
    public Kupovina dodajIliUpdatujKupovinu(Kupovina kupovina) {
       return (Kupovina) session.merge(kupovina);
    }

    @Override
    public void obrisiKupovinu(int id) {
       Kupovina exKup = (Kupovina) session.createCriteria(Kupovina.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(exKup);
    }
    
    
}

