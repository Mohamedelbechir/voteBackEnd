package com.essaisprint.firstspring.daos;

import com.essaisprint.firstspring.models.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * produitDao cette annotation est appliquée à la classe afin d'indiquer à
 * Spring qu'il s'agit d'une classe qui gère les données, ce qui nous permettra
 * de profiter de certaines fonctionnalités comme les translations des erreurs.
 * Nous y reviendrons.
 */
@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {

    Iterable<Produit> findByPrixGreaterThan(int prixLimit);

    Produit findById(int id);

    Iterable<Produit> findByNomLike(String recherche);    

    @Query("SELECT id, nom, prix FROM Produit p WHERE p.prix > :prixLimit")
    Iterable<Produit>  chercherUnProduitCher(@Param("prixLimit") int prix);
}
