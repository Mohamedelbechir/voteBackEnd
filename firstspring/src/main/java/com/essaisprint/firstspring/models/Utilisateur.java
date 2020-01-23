package com.essaisprint.firstspring.models;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Candidat
 */
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "utilisateur_id", nullable = false, unique = true)
    private long utilisateur_id;

    @Column(name = "cin", nullable = false, unique = true)
    @NotNull
    private String cin;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_naissance;

    private String adresse;

    private String tel;

    private String sexe;

    private String situation_familiale;

    private String origine;

    private String password;
    
    @Column(nullable = false, unique = true)
	@Email
	@NotEmpty
    private String email;

    @NotEmpty
    private String type; 
 
  /*  @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   // @JoinTable(name = "participation_utilisateur", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "id_election"))
   @JsonIgnore 
   private Collection<Election> elections;
*/
    public Utilisateur(){
        super();
    }
    public Utilisateur(long utilisateur_id, @NotNull String cin, @NotNull String nom, @NotNull String prenom,
            @NotNull Date date_naissance, String adresse, String tel, String sexe, String situation_familiale,
            String origine, @Length(min = 5) @NotEmpty String password, @Email @NotEmpty String email/*,
            Set<Election> elections*/, String type) {
        this.utilisateur_id = utilisateur_id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.tel = tel;
        this.sexe = sexe;
        this.situation_familiale = situation_familiale;
        this.origine = origine;
        this.password = password;
        this.email = email;
       // this.elections = elections;
        this.type = type;
    }

    
    public long getId() {
        return utilisateur_id;
    }

    public void setId(long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* public Collection<Election> getElections() {
        return elections;
    }

    public void setElections(Set<Election> elections) {
        this.elections = elections;
    }
    */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
    }
    /*
	public void addElection(Election elect) {
        this.elections.add(elect);
    }
    @JsonIgnore
    protected Collection<Election> getElectionsInternal() {
        if (this.elections == null) {
            this.elections = new HashSet<>();
        }
        return this.elections;
    }
    public void clearElections() {
        getElectionsInternal().clear();
    }
*/


	 
    

}
