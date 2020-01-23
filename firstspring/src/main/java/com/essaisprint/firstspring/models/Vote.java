
package com.essaisprint.firstspring.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Vote
 */
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private long idElecteur;
    @NotNull
    private long idCandidat;
    @NotNull
    private long idElection; 
    
	//@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
    private Date date; 

    @PrePersist
    protected void onCreate(){
        date = new Date();
    }
    public long getId() { 
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    


    public Vote() {
        super();
    }

    public Vote(long id, long idElecteur, long idCandidat, long idElection, Date date) {
        this.id = id;
        this.idElecteur = idElecteur;
        this.idCandidat = idCandidat;
        this.idElection = idElection;
        this.date = date;
    }

    public long getIdElecteur() {
        return idElecteur;
    }

    public void setIdElecteur(long idElecteur) {
        this.idElecteur = idElecteur;
    }

    public long getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(long idEcandidat) {
        this.idCandidat = idEcandidat;
    }

    public long getIdElection() {
        return idElection;
    }

    public void setIdElection(long idEelection) {
        this.idElection = idEelection;
    }
    
    

	
    
}
