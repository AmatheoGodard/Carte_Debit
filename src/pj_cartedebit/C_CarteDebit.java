/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pj_cartedebit;

import java.sql.SQLException;
import pj_cartedebit.Model.M_Users;
import pj_cartedebit.View.V_Main;

/**
 *
 * @author amatheo
 */
public class C_CarteDebit {

    private V_Main fm_main;
    private Db_mariadb baseRR;
    private M_Users utilConnecte;

    public C_CarteDebit() throws Exception {
        connection();
        fm_main = new V_Main(this);

        fm_main.Afficher();
    }

    private void connection() throws Exception {
        baseRR = new Db_mariadb(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
    }

    public void deconnexion() throws SQLException {
        baseRR.closeBase();
    }
    
    /* Model M_Users */    
    
    public M_Users connexionUtilis(String login, String mdp) throws SQLException {
        utilConnecte = M_Users.connexion_log(baseRR, login, mdp);
        return utilConnecte;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        C_CarteDebit leControleur = new C_CarteDebit();
    }

}
