package CONTROLADOR;

import MODELO.modelo_login;
import MODELO.modelo_registro;
import MODELO.modelo_tarjeta;
import VALIDACIONES.Validaciones;
import VISTA.Login;
import VISTA.Pago_Tarjeta;
import VISTA.Registroc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import java.util.List;
import javax.sound.sampled.LineEvent;

public class Controlador_Registro {

    private Registroc vista;

    public Controlador_Registro(Registroc vista) {
        this.vista = vista;
        inicializar();
    }

    private void inicializar() {
        // Agrega ActionListener a los campos de texto
        agregarListenersCamposTexto();

        // Agrega ActionListener al botón de registro
        vista.getBtnRegistro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si todos los campos están llenos
                if (camposLlenos()) {
                    // Muestra un mensaje en un cuadro de diálogo emergente
                    JOptionPane.showMessageDialog(vista, "Cliente creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Muestra un mensaje de error si no todos los campos están llenos
                    JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void agregarListenersCamposTexto() {
        // Agrega ActionListener para cada campo de texto
        vista.getTxtnombreA().addActionListener(new CamposTextoListener());
        vista.getTxtape().addActionListener(new CamposTextoListener());
        vista.getTxtcedula().addActionListener(new CamposTextoListener());
        vista.getTxtusuario().addActionListener(new CamposTextoListener());
        vista.getTxtcontra().addActionListener(new CamposTextoListener());
        vista.getTxtvalcontra().addActionListener(new CamposTextoListener());
        vista.getTxtRespuesta().addActionListener(new CamposTextoListener());
    }

    private class CamposTextoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Actualiza el estado del botón Registrar según los campos de texto
            guardar();
            abrirTarjetaregistro();
        }
    }

    private boolean camposLlenos() {
        String nombre = vista.getTxtnombreA().getText();
        String apellido = vista.getTxtape().getText();
        String cedula = vista.getTxtcedula().getText();
        String usuario = vista.getTxtusuario().getText();
        String contrasena = vista.getTxtcontra().getText();
        String valContrasena = vista.getTxtvalcontra().getText();
        String respuesta = vista.getTxtRespuesta().getText();

        return !nombre.isEmpty()
                && !apellido.isEmpty()
                && !cedula.isEmpty()
                && !usuario.isEmpty()
                && !contrasena.isEmpty()
                && !valContrasena.isEmpty()
                && !respuesta.isEmpty();
    }

// ...
// Declara la listaReg fuera del método
// ...
    private void guardar() {
        String nombre = vista.getTxtnombreA().getText();
        boolean nombreValido = Validaciones.validarUsuario(nombre);

        String apellido = vista.getTxtape().getText();
        boolean apellidoValido = Validaciones.validarUsuario(apellido);

        String cedula = vista.getTxtcedula().getText();
        boolean cedulaValida = Validaciones.validarCedulaEcuatoriana(cedula);
        boolean cedulaNumerica = Validaciones.validarCedulaEcuatoriana(cedula);

        String usuario = vista.getTxtusuario().getText();
        boolean usuarioValido = Validaciones.validarUsuario(usuario);

        String contrasena = vista.getTxtcontra().getText();
        boolean contrasenaValida = Validaciones.validarContrasena(contrasena);

        String valContrasena = vista.getTxtvalcontra().getText();
        boolean contrasenaValidaConfirmacion = Validaciones.validarContrasena(valContrasena);

        String respuesta = vista.getTxtRespuesta().getText();
        boolean respuestaValida = Validaciones.validarUsuario(respuesta);

        Object selected = vista.getComboboxpregunta().getSelectedItem();
        boolean comboValido = Validaciones.validarComboBox(vista.getComboboxpregunta(), "SELECCIONE");
        boolean checkBoxValido = Validaciones.validarCheckBox(vista.getjCheckBoxTerminos());

        System.out.println("Validations: Cedula=" + cedulaValida + ", Usuario=" + usuarioValido + ", Apellido=" + apellidoValido + ", Nombre=" + nombreValido + ", Respuesta=" + respuestaValida
                + "contra:" + contrasenaValida + "  validacion:" + contrasenaValidaConfirmacion + "  respuesta:" + respuestaValida + " Combo: " + comboValido + " chex" + checkBoxValido);

        if (nombreValido && apellidoValido && usuarioValido && respuestaValida && cedulaValida && cedulaNumerica && contrasenaValida && contrasenaValidaConfirmacion && comboValido) {
            System.out.println("Entre capa 1");

            // Se guarda los datos
            System.out.println("Cédula válida");

            if (contrasenaValida) {
                //System.out.println("Entre capa 3 contra");

                if (contrasenaValidaConfirmacion && contrasena.equals(valContrasena)) {
                    //System.out.println("Entre capa 3 contra validacion");

                    // Enable the registration button if all conditions are met
                    if (checkBoxValido) {
                        // La casilla de verificación está seleccionada
                        System.out.println("La casilla de verificación está seleccionada");
                        vista.getBtnRegistro().setEnabled(true);
                        vista.getBtntargeta().setEnabled(true);

                        modelo_registro nuevore = new modelo_registro(nombre, apellido, cedula, usuario, contrasena, valContrasena, respuesta);

                        List<modelo_registro> listaReg = new ArrayList<>();
                        // Añadir nuevo objeto nuevore a listaReg
                        listaReg.add(nuevore);

                        // Imprimir la lista actualizada
                        imprimirListaReg(listaReg);

                        //retroceder 
                        JOptionPane.showMessageDialog(vista, "Cliente creado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        // Cierra la ventana de registro
                        vista.dispose();

                        // Abre la ventana de login
                        // abrirVentanaLogin();
                    } else {
                        // La casilla de verificación no está seleccionada
                        System.out.println("La casilla de verificación no está seleccionada");
                        JOptionPane.showMessageDialog(null, "Debe seleccionar la casilla de términos y condiciones.");
                    }
                } else {
                    // Contraseña y confirmación no coinciden
                    JOptionPane.showMessageDialog(null, "Los campos de 'Contraseña' y 'Confirmación de Contraseña' deben ser iguales.");
                }
            } else {
                // Contraseña no válida
                JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial.");
            }
        } else {
            // Informar al usuario sobre el campo que debe corregir
            String mensaje = "Por favor, corrija los siguientes campos:\n";
            if (!nombreValido) {
                mensaje += "- Nombre\n";
            }
            if (!apellidoValido) {
                mensaje += "- Apellido\n";
            }
            if (!usuarioValido) {
                mensaje += "- Usuario\n";
            }
            if (!respuestaValida) {
                mensaje += "- Respuesta\n";
            }
            if (!cedulaValida) {
                mensaje += "- Cédula\n";
            }
            if (!cedulaNumerica) {
                mensaje += "- Verifique que su cédula solamente tenga valores numéricos (0-9)\n";
            }
            if (!contrasenaValida) {
                mensaje += "- Contraseña\n -recuerde que debe contener minimo 8 cracteres , una letra mayuscula una letra minuscula ,un numero y un caracter especial \n ";
            }
            if (!contrasenaValidaConfirmacion) {
                mensaje += "- Confirmación de Contraseña\n -los campos (contraseña) y (confirmacion de contraseña ) deben ser iguales \n ";
            }
            if (!comboValido) {
                mensaje += "- Seleccione una opción en el ComboBox\n";
            }

            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

// Método para imprimir la listaReg
    private void imprimirListaReg(List<modelo_registro> lista) {
        System.out.println("Contenido de listaReg:");

        // Usando un bucle for-each para recorrer la lista
        for (modelo_registro elemento : lista) {
            System.out.println(elemento);
        }
    }

    ///retroseder login 
    private void abrirVentanaLogin() {
        // Crear la vista de login
        Login loginFrame = new Login(/* proporciona los componentes necesarios */);
        modelo_login modelo_login = null;

        // Crear una instancia del controlador de login y asociarlo con la vista
        // controlador_login loginController = new controlador_login(loginFrame, modelo_login);
        // Mostrar el frame de login
        loginFrame.setVisible(true);
    }

    private void abrirTarjetaregistro() {
        // Crear la vista de login
        Pago_Tarjeta loginFrame = new Pago_Tarjeta(/* proporciona los componentes necesarios */);
        modelo_tarjeta modelo_tarjeta = null;

        // Crear una instancia del controlador de login y asociarlo con la vista
        // controlador_login loginController = new controlador_login(loginFrame, modelo_login);
        // Mostrar el frame de login
        loginFrame.setVisible(true);
    }

}
