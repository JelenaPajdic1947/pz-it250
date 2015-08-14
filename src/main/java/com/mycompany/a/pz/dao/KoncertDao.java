/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Koncert;
import java.util.List;

/**
 *
 * @author pc
 */
public interface KoncertDao {
     public List<Koncert> getListaKoncerata();

    public Koncert getKoncertById(Integer id);

    public void dodajKoncert(Koncert koncert);
    
    public Koncert dodajIliUpdatujKoncert(Koncert koncert);

    public void obrisiKoncert(int id);
}
