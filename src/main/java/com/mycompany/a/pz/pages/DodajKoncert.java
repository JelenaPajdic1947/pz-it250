/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.components.GenericEditor;
import com.mycompany.a.pz.dao.KoncertDao;
import com.mycompany.a.pz.entities.Koncert;
import com.mycompany.a.pz.services.ProtectedPage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class DodajKoncert  {
    @Persist
    @Property
    private Koncert koncert;
    @Property
    private Koncert onekoncert;
    @Property
    private List<Koncert> listaKoncert;
    @Inject
    private KoncertDao koncertDao;

    void onActivate() {
        if (listaKoncert == null) {
            listaKoncert = new ArrayList<Koncert>();
        }

        listaKoncert = koncertDao.getListaKoncerata();
    }

    @CommitAfter
    Object onActionFromEdit(Koncert listaKoncert) {
        koncert = listaKoncert;
        return this;
    }

    @CommitAfter
    Object onSuccess() {
        koncertDao.dodajIliUpdatujKoncert(koncert);
        koncert = new Koncert();
        return this;

    }

    @CommitAfter
    Object onActionFromDelete(int id) {
        koncertDao.obrisiKoncert(id);
        return this;
    }
}


