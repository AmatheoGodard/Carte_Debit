/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pj_cartedebit;

/**
 *
 * @author amatheo
 */
public class C_CarteDebit {
    
    private V_Main fm_main;
    
    public C_CarteDebit () {
        fm_main = new V_Main();
        
        fm_main.Afficher();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        C_CarteDebit leControleur = new C_CarteDebit();
    }
    
}
