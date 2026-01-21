/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pj_cartedebit.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
                        + " VALUES ('" + name + "', '" + email + "', '" + password + "', '" + remember_token + "', '" + commentaire + "', '" + email_verified_at + "', '" + created_at +"','" + updated_at +"','" + id_roles +"');";
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
    
    
}
