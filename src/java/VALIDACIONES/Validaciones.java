/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VALIDACIONES;

import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author CASA
 */
public class Validaciones {

    //login
    public static boolean validateLogin(String user, String pass) {
        if (user.isEmpty() && pass.isEmpty()) {
            return false;
        } else if (user.matches("[a-zA-Z]+") && pass.matches("^[A-Z].*[a-zA-Z-0-9]{6}$")) {
            return true;
        } else {
            return false;
        }
    }

    //registro 
    public static boolean validarUsuario(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return false;
        } else if (nombre.matches("[a-zA-Z]+")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) {
            return false;
        } else if (contrasena.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarCedulaEcuatoriana(String cedula) {
        // La cédula debe contener 10 dígitos numéricos
        if (cedula.matches("\\d{10}")) {
            // Verificación del último dígito según el algoritmo de validación
            int suma = 0;
            int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
            int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));

            for (int i = 0; i < 9; i++) {
                int digito = Integer.parseInt(cedula.substring(i, i + 1));
                digito *= coeficientes[i];

                if (digito > 9) {
                    digito -= 9;
                }

                suma += digito;
            }

            int resultado = 10 - (suma % 10);
            if (resultado == 10) {
                resultado = 0;
            }

            return resultado == digitoVerificador;
        }
        return false;

    }

    public static boolean validarComboBox(JComboBox comboBox, String valorNoSeleccionado) {
        // Verificar si se ha seleccionado un elemento específico
        Object selectedItem = comboBox.getSelectedItem();
        return selectedItem != null && !selectedItem.toString().equals(valorNoSeleccionado);
    }

    public static boolean validarCheckBox(JCheckBox checkBox) {
        // Verificar si el JCheckBox está seleccionado
        return checkBox.isSelected();
    }
/////
     public static boolean ValidarLongitud(String cad) {
        return cad.matches("[0-9]{1,16}");
    }

    public static boolean ValidarCuotas(String cad) {
        return cad.matches("[0-9]{1,2}");
    }

    public static boolean VerificarEmail(String correo) {

        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mat = patron.matcher(correo);

        return mat.find();
    }

    public static boolean validarAnioVencimiento(String anio) {
        try {
            int anioVencimiento = Integer.parseInt(anio);

            // Obtén el año actual
            int anioActual = Calendar.getInstance().get(Calendar.YEAR);

            // Límite de 6 años en el futuro
            int anioLimite = anioActual + 6;

            // Verifica que el año de vencimiento esté en el rango permitido
            return anioVencimiento >= anioActual && anioVencimiento <= anioLimite;
        } catch (NumberFormatException e) {
            // Manejo de la excepción si el formato del año no es válido
            return false;
        }
    }

    public static void ValidarLetrNum(boolean dato, KeyEvent e) {
        if (dato) {
            e.consume();
        }
    }

    public static boolean validarCodigo(String cadena) {
        // Verifica que la cadena contenga solo letras y tenga un máximo de 15 caracteres
        return cadena.matches("^[a-zA-Z]{1,15}$");
    }

    public static boolean validarNumeroTelefonico(String numeroTelefono) {
        // Verifica que el número de teléfono contenga solo números y tenga 10 dígitos
        return numeroTelefono.matches("^[0-9]{10}$");
    }

    public static boolean validarNombre(String cadena) {
        // Verifica que la cadena contenga solo letras, la primera letra sea mayúscula y tenga un máximo de 15 caracteres
        return cadena.matches("^[A-Z][a-zA-Z]{0,14}$");
    }

    public static boolean Cedula(String cedula) {
        boolean estado = false;
        try {
            if (cedula.length() == 10) {
                if ((Integer.parseInt(cedula.substring(0, 2)) <= 24) || Integer.parseInt(cedula.substring(0, 2)) <= 30) {
                    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int digito_verificador = Integer.parseInt(cedula.substring(cedula.length() - 1, cedula.length()));
                    int suma = 0;
                    int multiplic = 0;
                    int modulo;

                    for (int i = 0; i < cedula.length() - 1; i++) {
                        multiplic = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                        multiplic = (multiplic > 9) ? multiplic -= 9 : multiplic;
                        suma += multiplic;
                    }
                    modulo = suma % 10;
                    if ((10 - modulo) == digito_verificador) {
                        estado = true;
                    }
                    if (modulo == 0 & modulo == digito_verificador) {
                        estado = true;
                    }
                } else {
                    estado = false;
                    JOptionPane.showMessageDialog(null, "Cedula no pertenece a Ecuador");
                }
            }
        } catch (NumberFormatException e) {
            estado = false;
            JOptionPane.showMessageDialog(null, "Error al validar");
        }
        return estado;
    }

    public static void validarCamposLlenos(boolean checkBoxEstado, String... campos) {
        // Verifica que todos los campos estén llenos
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                throw new RuntimeException("Todos los campos deben estar llenos");
            }
        }

        if (!checkBoxEstado) {
            throw new RuntimeException("Debe aceptar los terminos y condiciones para continuar.");
        }

        // No se necesita un valor de retorno, ya que el método es void
    }

    public static void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
