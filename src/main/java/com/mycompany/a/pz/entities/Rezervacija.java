/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
 @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija  extends AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "brojKarata")
    private Integer brojKarata;
    @Basic(optional = false)
    @Column(name = "UkupnaCena")
    private String ukupnaCena;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    
    
    @JoinColumn(name = "koncert_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Koncert koncertId;
  
    
    @Inject
    public Rezervacija() {
    }

    /**
     * @return the brojKarata
     */
    public Integer getBrojKarata() {
        return brojKarata;
    }

    /**
     * @param brojKarata the brojKarata to set
     */
    public void setBrojKarata(Integer brojKarata) {
        this.brojKarata = brojKarata;
    }

    /**
     * @return the ukupnaCena
     */
    public String getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * @param ukupnaCena the ukupnaCena to set
     */
    public void setUkupnaCena(String ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    

    /**
     * @return the koncertId
     */
    public Koncert getKoncertId() {
        return koncertId;
    }

    /**
     * @param koncertId the koncertId to set
     */
    public void setKoncertId(Koncert koncertId) {
        this.koncertId = koncertId;
    }

  
    
    @Override
    public String toString() {
        return "com.mycompany.a.pz.entities.Rezervacija[ id=" + id + " ]";
    }

    /**
     * @return the userId
     */
    public User getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

   
 
    
    
}
    


