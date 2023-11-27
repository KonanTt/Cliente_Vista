package CONTROLADOR;

import MODELO.modelo_login;
import MODELO.modelo_registro;
import VALIDACIONES.Validaciones;
import VISTA.Login;
import VISTA.Principal;
import VISTA.Registroc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador_login {

    private Login view;
    private modelo_login modelo;
    private Validaciones validaciones;
    modelo_registro modelo1 = new modelo_registro();

    public controlador_login(Login view, modelo_login modelo) {
        this.view = view;
        this.modelo = modelo;

        view.getBtnRegUsu().addActionListener(new RegistroListener());
        view.getBtnIngre().addActionListener(new LoginListener());

        // Agrega ActionListener a los campos de texto
        agregarListenersCamposTexto();
    }

    private void agregarListenersCamposTexto() {
        // Agrega ActionListener para cada campo de texto
        view.getTxtUser().addActionListener(new CamposTextologin());
        view.getTxtPass().addActionListener(new CamposTextologin());
    }

    private class CamposTextologin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Actualiza el estado del botón Registrar según los campos de texto
            // ingresar();
            view.getBtnIngre().setEnabled(true);
        }
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ingresar();
        }
    }

    private void ingresar() {
        if (camposLlenos()) {
            // Asegúrate de que view y getTxtUser() no sean null

            String usuario = view.getTxtUser().getText();
            boolean usuarioValido = validaciones.validarUsuario(usuario);
            String password = view.getTxtPass().getText();
            boolean passValido = validaciones.validarContrasena(password);

            System.out.println(usuarioValido);
            System.out.println(passValido);
            // Validar campos antes de enviar al modelo
            if (usuarioValido && passValido) {
                System.out.println(usuarioValido);

                // Enviar al modelo para la validación
                if (view.getTxtUser().getText().equals("adr") && view.getTxtPass().getText().equals("Adr1234_")) {
                    JOptionPane.showMessageDialog(view, "Ingreso correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Acción después de un inicio de sesión exitoso
                    abrirInterfazMenu();

                } else {
                    view.getBtnIngre().setEnabled(false);
                    JOptionPane.showMessageDialog(view, "Revise sus credenciales", "Error", JOptionPane.INFORMATION_MESSAGE);
                    // Manejar un inicio de sesión fallido
                    // view.mostrarMensajeError("Usuario o contraseña incorrectos");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Revise sus credenciales", "Error", JOptionPane.INFORMATION_MESSAGE);
                // Manejar campos inválidos
                // view.mostrarMensajeError("Por favor, ingrese usuario y contraseña válidos");
            }
        }

    }

    private boolean camposLlenos() {
        String usuario = view.getTxtUser().getText();
        String contrasena = view.getTxtPass().getText();
        return !usuario.isEmpty() && !contrasena.isEmpty();
    }

    public void Registro() {
        Registroc registroFrame = new Registroc(/* proporciona los componentes necesarios */);

        // Crear una instancia del controlador y asociarlo con la vista
        Controlador_Registro controlador = new Controlador_Registro(registroFrame);

        // Mostrar el frame
        registroFrame.setVisible(true);
    }

    private class RegistroListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Llamar al método Registro al hacer clic en el botón "Registrarse"
            Registro();
        }
    }

    private void abrirInterfazMenu() {
        Principal principalView = new Principal();

        // Crear el controlador del menú
        Controlador_Menu principalController = new Controlador_Menu(principalView);

        // Mostrar la interfaz de menú
        principalView.setVisible(true);

        // Cerrar la ventana de inicio de sesión si es necesario
        view.dispose();
    }
}
