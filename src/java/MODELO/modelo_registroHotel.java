/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import java.util.Date;

/**
 *
 * @author CASA
 */
public class modelo_registroHotel {
    private Date  fecha_reserva;

    public modelo_registroHotel() {
    }

    public modelo_registroHotel(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }
    @Override
    public String toString() {
    return "reserva hotel Registrado {" +
            "reserva='" + fecha_reserva.toString() + 
            // Agrega otros campos según sea necesario
            '}';
            }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }
    
    
}
