
import CONTROLADOR.controlador_login;
import MODELO.modelo_login;
import VISTA.Login;
import VISTA.Principal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CASA
 */
public class main_principal {
  public static void main(String[] args) {
        // Crear la vista y el modelo
        Login loginView = new Login();
        modelo_login loginModel = new modelo_login();

        // Crear el controlador
      controlador_login loginController = new controlador_login(loginView, loginModel);

        // Mostrar la vista
        loginView.mostrarVentana();
        
        // Crear la vista

        // Crear el controlador
                
    
    }   
}
