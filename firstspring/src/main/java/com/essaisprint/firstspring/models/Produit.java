package com.essaisprint.firstspring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Product
 */
// @JsonIgnoreProperties(value = {"id","prixAchat"}) // une liste d'attribut à
// ignorer
// @JsonFilter("monFiltreDynamique")
@Entity
@Table(name = "Produit")
public class Produit implements Serializable  {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Length(min = 3, max = 20)
    private String nom;

    @Min(value = 1, message = "le prix d'un produit doit être toujour superieur à 1")
    private int prix;
    /** pour ne pas que l'attribut soit convertie en json */
    // @JsonIgnore
    private int prixAchat;

    
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss")
    private Date dateAjout;

    Produit() {
    }

    public Produit(int id, String nom, int prix, int prixAchat, Date dateAjout) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixAchat = prixAchat;
        this.dateAjout = dateAjout;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

   
}
