/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pj_cartedebit.Model;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import pj_cartedebit.Db_mariadb;

/**
 *
 * @author amatheo
 */
public class M_Users {

    private Db_mariadb db;
    private int id_user, id_roles;
    private String name, email, password, remember_token, commentaire;
    private LocalDateTime email_verified_at, created_at, updated_at;

    public M_Users(Db_mariadb db, int id_user, int id_roles, String name, String email, String password, String remember_token, String commentaire, LocalDateTime email_verified_at, LocalDateTime created_at, LocalDateTime updated_at) {
        this.db = db;
        this.id_user = id_user;
        this.id_roles = id_roles;
        this.name = name;
        this.email = email;
        this.password = password;
        this.remember_token = remember_token;
        this.commentaire = commentaire;
        this.email_verified_at = email_verified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public M_Users(Db_mariadb db, int id_roles, String name, String email, String password, String remember_token, String commentaire, LocalDateTime email_verified_at, LocalDateTime created_at, LocalDateTime updated_at) throws SQLException {
        this.db = db;
        this.id_roles = id_roles;
        this.name = name;
        this.email = email;
        this.password = password;
        this.remember_token = remember_token;
        this.commentaire = commentaire;
        this.email_verified_at = email_verified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;

        String sql = "INSERT INTO mcd_users (name, email, email_verified_at, password, remember_token, commentaire, created_at, updated_at, id_role)"
                + " VALUES ('" + name + "', '" + email + "', '" + password + "', '" + remember_token + "', '" + commentaire + "', '" + email_verified_at + "', '" + created_at + "','" + updated_at + "','" + id_roles + "');";
        db.sqlExec(sql);
        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_user = res.getInt("id");
        res.close();
    }

    public M_Users(Db_mariadb db, int id_user) throws SQLException {
        this.db = db;
        this.id_user = id_user;

        String sql = "SELECT * FROM mcd_users WHERE id = '" + id_user + "'";
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.name = res.getString("name");
        this.email = res.getString("email");
        this.email_verified_at = res.getObject("email_verified_at", LocalDateTime.class);
        this.password = res.getString("password");
        this.remember_token = res.getString("remember_token");
        this.commentaire = res.getString("commentaire");
        this.created_at = res.getObject("created_at", LocalDateTime.class);
        this.updated_at = res.getObject("updated_at", LocalDateTime.class);
        this.id_roles = res.getInt("id_role");
        res.close();
    }

    public Db_mariadb getDb() {
        return db;
    }

    public void setDb(Db_mariadb db) {
        this.db = db;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_roles() {
        return id_roles;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember_token() {
        return remember_token;
    }

    public void setRemember_token(String remember_token) {
        this.remember_token = remember_token;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDateTime getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(LocalDateTime email_verified_at) {
        this.email_verified_at = email_verified_at;
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
        String sql;
        sql = "UPDATE mcd_users SET "
                + "name='" + name + "', "
                + "email='" + email + "', "
                + "email_verified_at='" + email_verified_at + "', "
                + "password='" + password + "', "
                + "remember_token='" + remember_token + "', "
                + "commentaire='" + commentaire + "', "
                + "created_at='" + created_at + "', "
                + "updated_at='" + updated_at + "', "
                + "id_role='" + id_roles + "' "
                + "WHERE id=" + id_user + ";";

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM mcd_users WHERE id=" + id_user + ";";
        db.sqlExec(sql);
    }

    public static LinkedHashMap<Integer, M_Users> getRecords(Db_mariadb db) throws SQLException {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Users> getRecords(Db_mariadb db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Users> lesUtilisateurs;
        lesUtilisateurs = new LinkedHashMap();
        M_Users unUtilisateur;

        int cle, idRole;
        String name, email, mp, remember_token, commentaire;
        LocalDateTime email_verfied_at, created_at, updated_at;

        String sql;
        sql = "SELECT * FROM mcd_users WHERE " + clauseWhere + " ORDER BY name";
        ResultSet res;
        res = db.sqlSelect(sql);

        while (res.next()) {
            cle = res.getInt("id");
            name = res.getString("name");
            email = res.getString("email");
            email_verfied_at = res.getObject("email_verfied_at", LocalDateTime.class);
            mp = res.getString("password");
            remember_token = res.getString("remember_token");
            commentaire = res.getString("commentaire");
            created_at = res.getObject("created_at", LocalDateTime.class);
            updated_at = res.getObject("updated_at", LocalDateTime.class);
            idRole = res.getInt("idRole");

            unUtilisateur = new M_Users(db, cle, idRole, name, email, mp, remember_token, commentaire, email_verfied_at, created_at, updated_at);
            lesUtilisateurs.put(cle, unUtilisateur);
        }

        res.close();

        return lesUtilisateurs;
    }

    public static M_Users connexion_log(Db_mariadb db, String login, String motPasse) throws SQLException {
        M_Users unUtilisateur = null;
        String sql, mp;
        int idUtil;

        int idRole;
        String name, email, remember_token, commentaire;
        LocalDateTime email_verfied_at, created_at, updated_at;

        sql = "SELECT * FROM mcd_users"
                + " WHERE name='" + login + "';";
        ResultSet res;
        res = db.sqlSelect(sql);

        if (res.first()) {
            System.out.println("Login trouvé");
            mp = res.getString("password");
            System.out.println(mp);
            if (BCrypt.verifyer().verify(motPasse.toCharArray(), mp).verified) {

                idUtil = res.getInt("id");
                name = res.getString("name");
                email = res.getString("email");
                email_verfied_at = res.getObject("email_verified_at", LocalDateTime.class);
                mp = res.getString("password");
                remember_token = res.getString("remember_token");
                commentaire = res.getString("commentaire");
                created_at = res.getObject("created_at", LocalDateTime.class);
                updated_at = res.getObject("updated_at", LocalDateTime.class);
                idRole = res.getInt("id_role");

                unUtilisateur = new M_Users(db, idUtil, idRole, name, email, mp, remember_token, commentaire, email_verfied_at, created_at, updated_at);
            } else {
                System.out.println("Mauvais Mot de passe");
            }
        }
        res.close();
        System.out.println(unUtilisateur);
        return unUtilisateur;
    }

    @Override
    public String toString() {
        return "M_Users{" + "db=" + db + ", id_user=" + id_user + ", id_roles=" + id_roles + ", name=" + name + ", email=" + email + ", password=" + password + ", remember_token=" + remember_token + ", commentaire=" + commentaire + ", email_verified_at=" + email_verified_at + ", created_at=" + created_at + ", updated_at=" + updated_at + '}';
    }
    
    

}
