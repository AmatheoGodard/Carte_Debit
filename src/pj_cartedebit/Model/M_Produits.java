/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pj_cartedebit.Model;

import java.time.LocalDateTime;
import pj_cartedebit.Db_mariadb;

/**
 *
 * @author amatheo
 */
public class M_Produits {
    
    private Db_mariadb db;
    private int id;
    private String code, nom, commentaire;
    private float prix;
    private LocalDateTime created_at, updated_at;

    public M_Produits(Db_mariadb db, int id, String code, String nom, String commentaire, float prix, LocalDateTime created_at, LocalDateTime updated_at) {
        this.db = db;
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.commentaire = commentaire;
        this.prix = prix;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public M_Produits(Db_mariadb db, String code, String nom, String commentaire, float prix, LocalDateTime created_at, LocalDateTime updated_at) {
        this.db = db;
        this.code = code;
        this.nom = nom;
        this.commentaire = commentaire;
        this.prix = prix;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public M_Produits(Db_mariadb db, int id) {
        this.db = db;
        this.id = id;
    }
    
    
}
