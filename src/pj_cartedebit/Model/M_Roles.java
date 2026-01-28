/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pj_cartedebit.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import pj_cartedebit.Db_mariadb;

/**
 *
 * @author amatheo
 */
public class M_Roles {
    
    private Db_mariadb db; 
    private int id;
    private String code, nom, commentaire;
    private LocalDateTime created_at, updated_at;

    public M_Roles(Db_mariadb db, int id, String code, String nom, String commentaire, LocalDateTime created_at, LocalDateTime updated_at) {
        this.db = db;
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.commentaire = commentaire;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public M_Roles(Db_mariadb db, String code, String nom, String commentaire, LocalDateTime created_at, LocalDateTime updated_at) throws SQLException {
        this.db = db;
        this.code = code;
        this.nom = nom;
        this.commentaire = commentaire;
        this.created_at = created_at;
        this.updated_at = updated_at;
        
        String sql = "INSERT INTO mcd_roles (code, nom, commentaire, created_at, updated_at)"
                        + " VALUES ('" + code + "', '" + nom + "', '" + commentaire + "', '" + created_at + "', '" + updated_at + "');";
        db.sqlExec(sql);
        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id = res.getInt("id");
        res.close();
    }

    public M_Roles(Db_mariadb db, int id) throws SQLException {
        this.db = db;
        this.id = id;
        
        String sql = "SELECT * FROM mcd_cartes WHERE id = '" + id + "'";
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.code = res.getString("code");
        this.nom = res.getString("nom");
        this.commentaire = res.getString("commentaire");
        this.created_at = res.getObject("created_at", LocalDateTime.class);
        this.updated_at = res.getObject("updated_at", LocalDateTime.class);
        res.close();
    }

    public Db_mariadb getDb() {
        return db;
    }

    public void setDb(Db_mariadb db) {
        this.db = db;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
    
    public void update() throws SQLException {
        String sql = "UPDATE mcd_roles SET "
                + "code='" + code + "', "
                + "nom='" + nom + "', "
                + "commentaire='" + commentaire + "'"
                + "created_at='" + created_at + "'"
                + "updated_at='" + updated_at + "'"
                + " WHERE id=" + id + ";";
        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM mcd_roles WHERE id=" + id + ";";
        db.sqlExec(sql);
    }

    public static LinkedHashMap<Integer, M_Roles> getRecords(Db_mariadb db) throws SQLException {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Roles> getRecords(Db_mariadb db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Roles> lesRoles;
        lesRoles = new LinkedHashMap<>();
        M_Roles unRole;

        int cle;
        LocalDateTime created_at, updated_at;
        String code, nom, commentaire;

        String sql = "SELECT * FROM mcd_produits WHERE " + clauseWhere + ";";
        ResultSet res;
        res = db.sqlSelect(sql);

        while (res.next()) {
            cle = res.getInt("id");
            code = res.getString("code");
            nom = res.getString("nom");
            commentaire = res.getString("commentaire");
            created_at = res.getObject("created_at", LocalDateTime.class);
            updated_at = res.getObject("updated_at", LocalDateTime.class);

            unRole = new M_Roles(db, cle, code, nom, commentaire, created_at, updated_at);
            lesRoles.put(cle, unRole);
        }

        res.close();

        return lesRoles;
    }

    @Override
    public String toString() {
        return "M_Roles{" + "db=" + db + ", id=" + id + ", code=" + code + ", nom=" + nom + ", commentaire=" + commentaire + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
}
