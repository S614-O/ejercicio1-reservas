package com.example.reserva.modelo;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //lo ser entidad
@Table(name = "reservas") //hace que se represente como tabla como una base de datos
@Data //Crea automáticamente Getters, Setters, toString y equals
@NoArgsConstructor //Crea un constructor vacío (obligatorio para JPA).
@AllArgsConstructor //Crea un constructor que incluye todos los atributos.

public class Reserva {
    @Id //Marca el campo como la llave primaria única de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indica que la base de datos genera el ID automáticamente (autoincremental).
    private Long id;

    @Column(nullable=false) // Este campo es obligatorio, no aceptes un valor vacío (NULL)".
    private String nombreCliente;
    private String telefono;
    private LocalDateTime fechaHora;
    private int numeroPersonas;
    private String estado;
    
}
