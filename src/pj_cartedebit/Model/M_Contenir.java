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
public class M_Contenir {
    
    private Db_mariadb db;
    private int idAchat, idProduit;
    float qte, prix;
    private String commentaire;
    private LocalDateTime created_at, updated_at;

    public M_Contenir(Db_mariadb db, int idAchat, int idProduit, float qte, float prix, String commentaire, LocalDateTime created_at, LocalDateTime updated_at) {
        this.db = db;
        this.idAchat = idAchat;
        this.idProduit = idProduit;
        this.qte = qte;
        this.prix = prix;
        this.commentaire = commentaire;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    
    
}
