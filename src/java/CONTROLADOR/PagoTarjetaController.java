/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import VALIDACIONES.Validaciones;
import VISTA.Pago_Tarjeta;


/**
 *
 * @author danny
 */
public class PagoTarjetaController {

    private final Pago_Tarjeta vista;
    Validaciones val = new Validaciones();

    public PagoTarjetaController(Pago_Tarjeta vista) {
        this.vista = vista;
        configurarListeners();
    }

    private void configurarListeners() {
        vista.getBtnContinuar().addActionListener(e -> btnContinuarActionPerformed());
        vista.getBtnRegresar().addActionListener(e -> btnRegresarActionPerformed());
    }

    private void btnContinuarActionPerformed() {
        try {
            // Validar que los campos estén llenos
            Validaciones.validarCamposLlenos(
                    vista.getCheckTerminosCondiciones().isSelected(),
                    vista.getTxtMovil().getText(),
                    vista.getTxtCorreo().getText(),
                    vista.getTxtNombreTitular().getText(),
                    vista.getTxtTipoDocumentacion().getText(),
                    vista.getTxtNumeroTarjeta().getText(),
                    vista.getTxtAnioVencimiento().getText(),
                    vista.getTxtCodigoVerificacion().getText(),
                    vista.getTxtNumCuotas().getText()
            );

            String cadena = vista.getTxtNumeroTarjeta().getText();
            if (!Validaciones.ValidarLongitud(cadena)) {
                throw new RuntimeException("Numero de Tarjeta no válida. Debe cumplir con ciertos requisitos.");
            }

            String numeroTelefono = vista.getTxtMovil().getText();
            if (!Validaciones.validarNumeroTelefonico(numeroTelefono)) {
                throw new RuntimeException("Número de teléfono no válido. Debe cumplir con ciertos requisitos.");
            }

            String email = vista.getTxtCorreo().getText();
            if (!Validaciones.VerificarEmail(email)) {
                throw new RuntimeException("Email no válido. Debe cumplir con ciertos requisitos.");
            }

            String cuotas = vista.getTxtNumCuotas().getText();
            if (!Validaciones.ValidarCuotas(cuotas)) {
                throw new RuntimeException("Numero de cuotas no válido. Debe cumplir con ciertos requisitos.");
            }

            String cedula = vista.getTxtTipoDocumentacion().getText();
            if (!Validaciones.Cedula(cedula)) {
                throw new RuntimeException("Numero de Cedula no válida. Debe cumplir con ciertos requisitos.");
            }

            String name = vista.getTxtNombreTitular().getText();
            if (!Validaciones.validarNombre(name)) {
                throw new RuntimeException("Nombre de titular no válido. Debe cumplir con ciertos requisitos.");
            }

            String codigo = vista.getTxtCodigoVerificacion().getText();
            if (!Validaciones.validarCodigo(codigo)) {
                throw new RuntimeException("Verificacion de Codigo no válido. Debe cumplir con ciertos requisitos.");
            }

            if (!Validaciones.validarAnioVencimiento(vista.getTxtAnioVencimiento().getText())) {
                throw new RuntimeException("Año de vencimiento no válido. Debe ser un año entre el actual y los próximos 6 años.");
            }

            Validaciones.mostrarMensajeExito("Datos válidos. Continuando...");

        } catch (RuntimeException ex) {
            Validaciones.mostrarMensajeError(ex.getMessage());
        }
    }

    private void btnRegresarActionPerformed() {
  vista.dispose();
    }
}
