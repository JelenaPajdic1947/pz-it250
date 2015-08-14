/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.dao;

import com.mycompany.a.pz.entities.User;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface UserDao {
    public User checkUser(String email, String password);
  
 public User registerUser(User user);
 
 public boolean checkIfEmailExists(String email);
 
  public ArrayList<User> getListaSvihKorisnika();

    public User getKorisnikById(Integer id);

    public void dodajKorisnika(User user);

    public void obrisiKorisnika(Integer id);
    
    public User dodajIliUpdatujKoncert(User user);

}
