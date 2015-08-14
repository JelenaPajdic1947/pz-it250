/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.User;
import java.util.ArrayList;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class UserDaoImpl implements UserDao {

    @Inject
    private Session session;

    @Override
    public User checkUser(String email, String password) {
        try {
            User u = (User) session.createCriteria(User.class).add(Restrictions.eq("email",
                    email)).add(Restrictions.eq("password", password)).uniqueResult();
            if (u != null) {
                return u;
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public User registerUser(User user) {
        return (User) session.merge(user);
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        Long rows = (Long) session.createCriteria(User.class).add(Restrictions.eq("email",
                email)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows == 0) ? false : true;
    }

    @Override
    public ArrayList<User> getListaSvihKorisnika() {
        return (ArrayList<User>) session.createCriteria(User.class).list();
    }

    @Override
    public User getKorisnikById(Integer id) {
        return (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void dodajKorisnika(User user) {
        session.persist(user);
    }

    @Override
    public void obrisiKorisnika(Integer id) {
        User tmpUser = (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        session.delete(tmpUser);
    }

    @Override
    public User dodajIliUpdatujKoncert(User user) {
        return (User) session.merge(user);
    }

}
