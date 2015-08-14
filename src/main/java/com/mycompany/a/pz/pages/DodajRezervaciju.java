/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.dao.KoncertDao;
import com.mycompany.a.pz.dao.RezervacijaDao;
import com.mycompany.a.pz.entities.Koncert;
import com.mycompany.a.pz.entities.Rezervacija;
import com.mycompany.a.pz.entities.User;
import com.mycompany.a.pz.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
@ProtectedPage
@RolesAllowed(value={"User","Sluzbenik"})
public class DodajRezervaciju {
    @SessionState
    private User ulogovaniKorisnik;
    @Inject
    private RezervacijaDao rezervacijeDao;

    @Inject
    private KoncertDao koncertDao;
    
    
    @Property
    private Rezervacija rezervacija;

    @Property
    private Rezervacija tmprezervacija;

    @Property
    private List<Rezervacija> rezervacijeLista;

    @Property
    private List<Koncert> koncertLista;

    @Property
    private Koncert koncert;

    
    
    void onActivate() {
 if (rezervacijeLista== null) {
 rezervacijeLista = new ArrayList<Rezervacija>();
 }
 rezervacijeLista = rezervacijeDao.getListaRezervacija();
 koncertLista=koncertDao.getListaKoncerata();
 }
 

    @CommitAfter
  Object onSuccess() {
       rezervacija.setKoncertId(koncert);
       rezervacija.setUserId(ulogovaniKorisnik);
        rezervacijeDao.dodajIliUpdatujRezervaciju(rezervacija);
       rezervacija = new Rezervacija();
        return this;
    }

    @CommitAfter
    void onDelete(Integer id) {
        rezervacijeDao.obrisiRezervaciju(id);
    }

    public String getKoncertIme() {
        if (tmprezervacija.getKoncertId() != null) {
            return tmprezervacija.getKoncertId().getIzvodjac();
        } else {
            return "";
        }
    }
}
