package CONTROLADOR;

import MODELO.modelo_historial;
import MODELO.modelo_registroHotel;
import VISTA.Historial_Transacciones;
import VISTA.Principal;
import VISTA.Reserva_Hoteles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Menu {

    private Principal vista;

    public Controlador_Menu(Principal vista) {
        this.vista = vista;

        // Agregar ActionListener a los componentes que necesitan manejar eventos
        this.vista.getBtnreservahotel().addActionListener(new ReservaHotelListener());
        this.vista.getBtnreservavuelo().addActionListener(new ReservaVueloListener());
        this.vista.getBtnpagotargeta().addActionListener(new HistorialListener());
        this.vista.getCerrar().addActionListener(new CerrarListener());
        this.vista.getMenuactualizar().addActionListener(new ActualizarListener());
    }

    // ActionListener para el botón de Reserva de Hotel
    class ReservaHotelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirVentanaHotel();
        }
    }

    // ActionListener para el botón de Reserva de Vuelo
    class ReservaVueloListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para manejar la acción de reserva de vuelo
            // Puedes abrir una nueva ventana, por ejemplo
        }
    }

    // ActionListener para el botón de Historial
    class HistorialListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            abrirVentanaHistorial();
        }
    }

    // ActionListener para el botón de Cerrar
    class CerrarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para cerrar la aplicación o realizar otras acciones
            System.exit(0);
        }
    }

    // ActionListener para el menú de Actualizar
    class ActualizarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para manejar la acción de actualizar
            // Puedes implementar la lógica según tus necesidades
        }
    }

    // Método para abrir la ventana de reserva de hoteles
    private void abrirVentanaHotel() {
        // Crear la vista de reserva de hoteles
        Reserva_Hoteles reservaHotelesFrame = new Reserva_Hoteles();
        modelo_registroHotel modeloHotel = null; 
        reservaHotelesFrame.setVisible(true);
    }

    // Método para abrir la ventana de historial
    private void abrirVentanaHistorial() {
        // Crear la vista de historial
        Historial_Transacciones historialFrame = new Historial_Transacciones();
        modelo_historial modeloHistorial = null; 
        historialFrame.setVisible(true);
    }
}
