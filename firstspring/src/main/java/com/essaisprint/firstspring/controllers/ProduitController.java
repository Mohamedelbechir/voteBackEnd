
package com.essaisprint.firstspring.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.essaisprint.firstspring.daos.ProduitDao;
import com.essaisprint.firstspring.exceptions.ProduitIntrouvableExeption;
import com.essaisprint.firstspring.models.Produit;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * ProductController
 */
@RestController // pour dire que c'est un controller qui permet de traiter les requettes
public class ProduitController {
    /**
     * Tout d'abord, nous avons créé une variable de type ProductDao, que nous avons
     * annotée avec @Autowired afin que Spring se charge d'en fabriquer une
     * instance. ProductDao a désormais accès à toutes les méthodes que nous avons
     * définies.
     */
    @Autowired
    private ProduitDao produitDao;

    @GetMapping(value = "/produits")
    public MappingJacksonValue getProducts() {
        Iterable<Produit> produits = this.produitDao.findAll();
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    @GetMapping(value = "/produits/{id}")
    public Produit afficherUnProduiString(@PathVariable int id) throws ProduitIntrouvableExeption {
        Produit produit = produitDao.findById(id);
        if(produit == null)
            throw new ProduitIntrouvableExeption("Le produit avec l'id "+ id +" est introvable");
        return produit;
    } 
    @GetMapping(value="/test/produits/{prixLimit}")
    public Iterable<Produit> testdelarequete(@PathVariable int prixLimit) {
        // return produitDao.findByPrixGreaterThan(prixLimit);
        return produitDao.chercherUnProduitCher(prixLimit);
    }
   /* @GetMapping(value = "test/produits/{recherche}")
    public Iterable<Produit>  testeDeRequetes(@PathVariable String recherche) {
        return produitDao.findByNomLike("%"+recherche+"%");
    }*/
    

    /**
     * @RequestBody Cette annotation demande à Spring que le JSON contenu dans la
     *              partie body de la requête HTTP soit converti en objet Java
     * 
     */
    @PostMapping(value = "/produits")
    public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Produit produit) {
        Produit productAdded = produitDao.save(produit);
      
        
       if (productAdded == null)
            return ResponseEntity.noContent().build();
            
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productAdded.getId()).toUri();
        return ResponseEntity.created(location).build();
    
    }
    @DeleteMapping(value = "produits/{id}")
    public void supprimerProduit(@PathVariable int id){
        this.produitDao.deleteById(id);
    }

}
