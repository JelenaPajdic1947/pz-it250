/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Rezervacija;
import java.util.List;

/**
 *
 * @author pc
 */
public interface RezervacijaDao {
    public List<Rezervacija> getListaRezervacija();

    public Rezervacija getRezervacijaById(Integer id);

    public void dodajRezervaciju(Rezervacija koncert);
    
    public Rezervacija dodajIliUpdatujRezervaciju(Rezervacija rezervacija);

    public void obrisiRezervaciju(int id);
}
