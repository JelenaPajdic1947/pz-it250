/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.dao.KoncertDao;
import com.mycompany.a.pz.entities.Koncert;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
public class PrikaziKoncerte {
    @Property
    private List<Koncert> listaKoncert;
    @Inject
    private KoncertDao koncertDao;
     @Persist
    @Property
    private Koncert koncert;

    void onActivate() {
        if (listaKoncert == null) {
            listaKoncert = new ArrayList<Koncert>();
        }

        listaKoncert = koncertDao.getListaKoncerata();
    }

}
