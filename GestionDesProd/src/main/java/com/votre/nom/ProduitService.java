package com.votre.nom;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        // Vérification de l'unicité du produit (ID ou nom)
        if (produitExiste(produit.getId()) || nomProduitExiste(produit.getNom())) {
            throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
        }

        // Validation des données (prix et quantité positifs)
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité des produits doivent être positifs.");
        }

        produits.add(produit);
    }

    // Méthodes auxiliaires
    private boolean produitExiste(Long id) {
        return produits.stream().anyMatch(produit -> produit.getId().equals(id));
    }

    private boolean nomProduitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }
}

