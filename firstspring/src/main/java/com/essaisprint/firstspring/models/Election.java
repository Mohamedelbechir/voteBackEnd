package com.essaisprint.firstspring.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Election
 */

@Entity
@Table(name = "Election")
public class Election {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_election")
	private long id_election; 
	private String libele;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
	private Date dateDebut;

	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss")
	private Date dateFin;

	private boolean etat = false;

	@NotNull
	private String type;

	@ManyToMany
	private  Set<Utilisateur> candidats;

	// /**
	//  * Plusieurs candidats peut participer à une election
	//  */
	// @ManyToMany
	// private Collection<Utilisateur> candidats;

	public Election() {
		super();
	}

	



	// @Override
	// public boolean equals(Object obj) {
	// 	if (this == obj)
	// 		return true;
	// 	if (obj == null)
	// 		return false;
	// 	if (getClass() != obj.getClass())
	// 		return false;
	// 	Election other = (Election) obj;
	// 	if (id_election != other.id_election)
	// 		return false;
	// 	return true;
	// }

	public long getId() {
		return id_election;
	}

	public void setId(final long id_election) {
		this.id_election = id_election;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(final Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(final Date dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(final Boolean etat) {
		this.etat = etat;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(final String libele) {
		this.libele = libele;
	}

	public Election(final long id_election, final String libele, @NotNull final Date dateDebut,
			@NotNull final Date dateFin, final boolean etat, @NotNull final String type,
			final Set<Utilisateur> candidats) {
		this.id_election = id_election;
		this.libele = libele;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etat = etat;
		this.type = type;
		this.candidats = candidats;
	}

	public Collection<Utilisateur> getCandidats() {
		return candidats;
	}

	public void setCandidats(final Set<Utilisateur> candidats) {
		this.candidats = candidats;
	}
	public void addCandidat(Utilisateur utilisateur) {
        this.candidats.add(utilisateur);
    }
	@JsonIgnore
    protected Collection<Utilisateur> getElectionsInternal() {
        if (this.candidats == null) {
            this.candidats = new HashSet<>();
        }
        return this.candidats;
    }
    public void clearElections() {
        getElectionsInternal().clear();
    }
	

}
