/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pj_cartedebit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author amatheo
 */
public class M_Acheter {
    
    private Db_mariadb db;
    private int idCarte, idAchat;
    private LocalDate dateAchat;
    private float montant;
    private String commentaire;

    public M_Acheter(Db_mariadb db, int idCarte, int idAchat, LocalDate dateAchat, float montant, String commentaire) {
        this.db = db;
        this.idCarte = idCarte;
        this.idAchat = idAchat;
        this.dateAchat = dateAchat;
        this.montant = montant;
        this.commentaire = commentaire;
    }

    public M_Acheter(Db_mariadb db, LocalDate dateAchat, float montant, String commentaire) throws SQLException {
        this.db = db;
        this.dateAchat = dateAchat;
        this.montant = montant;
        this.commentaire = commentaire;
        
        String sql = "INSERT INTO mcd_acheter (date_paiement, montant, commentaire)"
                        + " VALUES ('" + dateAchat + "', '" + montant + "', '" + commentaire + "');";
        
    }
    
    
    
    
}
