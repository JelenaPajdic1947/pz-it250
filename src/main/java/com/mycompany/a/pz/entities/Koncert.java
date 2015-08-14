/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.a.pz.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author pc
 */

@Entity
@Table(name = "koncert")
@NamedQueries({
 @NamedQuery(name = "Koncert.findAll", query = "SELECT k FROM Koncert k")})

public class Koncert extends AbstractEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "izvodjac")
    private String izvodjac;
    
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "mesto")
    private String mesto;
    
    @Basic(optional = false)
    @Column(name = "cena_karte")
    private String cenaKarte;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "koncertId")
    private List<Rezervacija> rezervacijeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Kupovina> kupovinaList;
    
    
    
    @Inject
    public Koncert(){
        
    }

    /**
     * @return the izvodjac
     */
    public String getIzvodjac() {
        return izvodjac;
    }

    /**
     * @param izvodjac the izvodjac to set
     */
    public void setIzvodjac(String izvodjac) {
        this.izvodjac = izvodjac;
    }

    /**
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the mesto
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * @param mesto the mesto to set
     */
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    /**
     * @return the cenaKarte
     */
    public String getCenaKarte() {
        return cenaKarte;
    }

    /**
     * @param cenaKarte the cenaKarte to set
     */
    public void setCenaKarte(String cenaKarte) {
        this.cenaKarte = cenaKarte;
    }
@Override
    public String toString() {
        return "com.mycompany.a.pz.entities.Koncert[ id=" + id + " ]";
    }

    /**
     * @return the rezervacijeList
     */
    public List<Rezervacija> getRezervacijeList() {
        return rezervacijeList;
    }

    /**
     * @param rezervacijeList the rezervacijeList to set
     */
    public void setRezervacijeList(List<Rezervacija> rezervacijeList) {
        this.rezervacijeList = rezervacijeList;
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



   
 
    
}
