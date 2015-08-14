/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.components.GenericEditor;
import com.mycompany.a.pz.dao.UserDao;
import com.mycompany.a.pz.entities.User;
import com.mycompany.a.pz.services.ProtectedPage;
import java.util.ArrayList;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
@ProtectedPage
@RolesAllowed(value={"Admin"})
public class DodajUsera{
    @Property
    private User user;
    @Property
    private User oneuser;
    @Property
    private ArrayList<User> useri;
    @Inject
    private UserDao userDao;
    
 void onActivate() {
 if (useri == null) {
 useri = new ArrayList<User>();
 }
 useri = userDao.getListaSvihKorisnika();
 }
 
 @CommitAfter
  Object onSuccess() {
        userDao.dodajIliUpdatujKoncert(user);
        user = new User();
        return this;
    }
  @CommitAfter
  Object onActionFromEdit(User useri) {
        user = useri;
        return this;
    }
@CommitAfter
Object onActionFromDelete(Integer id)
 {
userDao.obrisiKorisnika(id);
    
    return this;
    
}

}
