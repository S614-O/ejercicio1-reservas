package com.example.reserva.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

/*
Request

Es la información que el cliente (una página web, una app móvil, o Postman) te envía para crear o modificar algo.
Por qué es distinto: Un usuario normal solo debería enviarte el nombre y la descripcion de una categoría. 
No debe enviarte el id (porque eso lo genera tu base de datos) ni la fechaCreacion (porque esa es la hora actual de tu servidor).
*/

public class ReservaRequestDTO {
    private String nombreCliente;
    private String telefono;
    private LocalDateTime fechaHora;
    private int numeroPersonas;
    private String estado;

}
