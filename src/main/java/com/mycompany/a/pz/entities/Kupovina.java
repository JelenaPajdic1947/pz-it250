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
@Table(name = "kupovina")
@NamedQueries({
 @NamedQuery(name = "Kupovina.findAll", query = "SELECT k FROM Kupovina k")})
public class Kupovina extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "brojKarata")
    private Integer brojKarata;
    @Basic(optional = false)
    @Column(name = "UkupnaCena")
    private String ukupnaCena;
    
    
    
    @JoinColumn(name = "koncert_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Koncert id;
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUsera;
    
            
    @Inject
    public Kupovina(){
        
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
     * @return the korisnikId
     */
 
@Override
    public String toString() {
        return "com.mycompany.a.pz.entities.Kupovina[ id=" + id + " ]";
    }

    /**
     * @return the koncertId
     */
    public Koncert getKoncertId() {
        return id;
    }

    /**
     * @param koncertId the koncertId to set
     */
    public void setKoncertId(Koncert id) {
        this.id = id;
    }

    /**
     * @return the idUsera
     */
    public User getIdUsera() {
        return idUsera;
    }

    /**
     * @param idUsera the idUsera to set
     */
    public void setIdUsera(User idUsera) {
        this.idUsera = idUsera;
    }
 
    
    
    
}
