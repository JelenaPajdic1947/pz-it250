/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.dao.KoncertDao;
import com.mycompany.a.pz.dao.KupovinaDao;
import com.mycompany.a.pz.entities.Koncert;
import com.mycompany.a.pz.entities.Kupovina;
import com.mycompany.a.pz.entities.User;
import com.mycompany.a.pz.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */

@ProtectedPage
@RolesAllowed(value={"Admin","Sluzbenik"})
public class KupovinaDodavanje {
    
    
    @Property
    private Kupovina rezervacija;
    @Property
    private Kupovina rezervacijaone;
    @Property
    private Koncert id;
    @Property
    private Koncert koncert;
    @Property
    private List<Kupovina> listaKupovina;
    @Property
    private List<Koncert> listaKoncerta;
    @Inject
    private KupovinaDao rezervacijaDAO;  
    @Inject
    private KoncertDao koncertDao;
    @SessionState
    private User ulogovaniKorisnik;
    
    //encoder
    public ValueEncoder getEncoder() {
        
        return new ValueEncoder<Koncert>() {

            @Override
            public String toClient(Koncert v) {
                return String.valueOf(v.getId());
            }

            @Override
            public Koncert toValue(String string) {
                koncert = koncertDao.getKoncertById(Integer.parseInt(string));
                return koncert;
            }
        };
    }
    
    
    
    void onActivate() {
        if(listaKoncerta == null) {
            listaKupovina = new ArrayList<Kupovina>();
        }
        
        listaKoncerta = koncertDao.getListaKoncerata();
        listaKupovina = rezervacijaDAO.getListaKupovina();
    }
    
    @CommitAfter
    Object onSuccess() {
        rezervacija.setKoncertId(id);
        rezervacija.setIdUsera(null);
        rezervacijaDAO.dodajIliUpdatujKupovinu(rezervacija);
        rezervacija = new Kupovina();
        return this;
    }
    
    @CommitAfter
    Object onActionFromDelete(int id) {
        rezervacijaDAO.obrisiKupovinu(id);
        return this;
    }
    
    public String getKoncert() {
        if(rezervacijaone.getKoncertId() != null) {
            return rezervacijaone.getKoncertId().getIzvodjac();
        } else {
            return "";
        }
    }
    
}


