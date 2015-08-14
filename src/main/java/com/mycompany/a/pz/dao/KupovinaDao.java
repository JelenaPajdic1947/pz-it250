/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.Kupovina;
import java.util.List;

/**
 *
 * @author pc
 */
public interface KupovinaDao {
    public List<Kupovina> getListaKupovina();

    public Kupovina getKupovinaById(Integer id);

    public void dodajKupovinu(Kupovina koncert);
    
    public Kupovina dodajIliUpdatujKupovinu(Kupovina kupovina);

    public void obrisiKupovinu(int id);
}
