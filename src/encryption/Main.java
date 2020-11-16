/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import static encryption.InterfaceDES.key;
import javax.swing.JOptionPane;

/**
 *
 * @author PORTO
 */
public class Main {

    public static void main(String[] args) {
        main();
    }

    public static void main() {
        String opcion = JOptionPane.showInputDialog("Escribe D para ejecutar el algoritmo DES"
                + "\nEscribe A para ejecutar el algoritmo AES");
        if (opcion.equalsIgnoreCase("D")) {
            InterfaceDES obj = new InterfaceDES();
            do {
                key = JOptionPane.showInputDialog("Porfavor ingresa la clave de 8 digitos: ");
            } while (key.length() != 8);
            obj.setVisible(true);
        } else if (opcion.equalsIgnoreCase("A")) {
            InterfaceAES obj = new InterfaceAES();
            obj.setVisible(true);
        }
    }
}
