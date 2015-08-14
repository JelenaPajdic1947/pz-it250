/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.entities;

import com.mycompany.a.pz.data.Rola;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;
import javax.persistence.OneToMany;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "user")
@NamedQueries({
 @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})

public class User extends AbstractEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    
    @Basic(optional = false)
    
    @Column(name = "password")
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "rola")
    private Rola rola;
    
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsera")
  
    private List<Kupovina> kupovinaList;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
     private List<Rezervacija> rezervacijaList;
     
     

    
    
    
    @Inject
    public User(){
        
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

   

    /**
     * @return the email
     */
 
    
    @Override
    public String toString() {
        return "com.mycompany.a.pz.entities.User[ id=" + id + " ]";
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the rola
     */
    public Rola getRola() {
        return rola;
    }

    /**
     * @param rola the rola to set
     */
    public void setRola(Rola rola) {
        this.rola = rola;
    }

   

    /**
     * @return the kupovinaList
     */
    public List<Kupovina> getKupovinaList() {
        return kupovinaList;
    }

    /**
     * @param kupovinaList the kupovinaList to set
     */
    public void setKupovinaList(List<Kupovina> kupovinaList) {
        this.kupovinaList = kupovinaList;
    }

    /**
     * @return the rezervacijaList
     */
    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    /**
     * @param rezervacijaList the rezervacijaList to set
     */
    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }
 
}
