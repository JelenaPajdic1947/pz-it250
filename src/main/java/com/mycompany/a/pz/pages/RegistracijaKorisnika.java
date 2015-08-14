/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.pages;

import com.mycompany.a.pz.dao.UserDao;
import com.mycompany.a.pz.data.Rola;
import com.mycompany.a.pz.entities.User;
import com.mycompany.a.pz.services.ProtectedPage;
import javax.annotation.security.RolesAllowed;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
public class RegistracijaKorisnika {

    @Property
    private User userReg;
    @SessionState
    private User loggedInUser;
    @Inject
    private UserDao userDao;
    @Component
    private BeanEditForm form;

    public String getMD5Hash(String yourString) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    @CommitAfter
    Object onSuccess() {
        if (!userDao.checkIfEmailExists(userReg.getEmail())) {
            String unhashedPassword = userReg.getPassword();
            userReg.setPassword(getMD5Hash(unhashedPassword));
            userReg.setRola(Rola.User);
            User newKorisnik = userDao.registerUser(userReg);
            loggedInUser = newKorisnik;
            return Index.class;
        } else {
            form.recordError("Email exists");
            return null;
        }
    }
}
