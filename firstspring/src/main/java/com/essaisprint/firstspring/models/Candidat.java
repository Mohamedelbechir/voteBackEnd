package com.essaisprint.firstspring.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

/**
 * Candidat
 */
@Entity
public class Candidat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long candidat_id;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull
    private String email;

    @Column(name = "cin", nullable = false, unique = true)
    @NotNull
    private String cin;

    @NotNull
    @Transient
    private String nationnalite;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private Date date_naissance;

    private String addresse;

    private String tel;

    private String sexe;

    private String situation_familiale;

    private String origine;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "participation_candidat", joinColumns = @JoinColumn(name = "id_candidat"), inverseJoinColumns = @JoinColumn(name = "id_election"))
    private Set<Election> elections;


    public long getId() {
        return candidat_id;
    }

    public void setId(long candidat_id) {
        this.candidat_id = candidat_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    
 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSituation_familiale() {
        return situation_familiale;
    }

    public void setSituation_familiale(String situation_familiale) {
        this.situation_familiale = situation_familiale;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public Set<Election> getElections() {
        return elections;
    }

    public void setElections(Set<Election> elections) {
        this.elections = elections;
    }

    public Candidat(long candidat_id, @NotNull String email, @NotNull String cin, @NotNull String nationnalite,
            @NotNull String nom, @NotNull String prenom, @NotNull Date date_naissance, String addresse, String tel,
            String sexe, String situation_familiale, String origine, Set<Election> elections) {
        this.candidat_id = candidat_id;
        this.email = email;
        this.cin = cin;
        this.nationnalite = nationnalite;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.addresse = addresse;
        this.tel = tel;
        this.sexe = sexe;
        this.situation_familiale = situation_familiale;
        this.origine = origine;
        this.elections = elections;
    }

	
    

}
