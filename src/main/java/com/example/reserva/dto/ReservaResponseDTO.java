package com.example.reserva.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Response

Es la información que tu servidor (Backend) le devuelve al cliente después de hacer el trabajo.
Por qué es distinto: Aquí sí devuelves el paquete completo. 
El frontend necesita saber qué id se le asignó a la categoría, si está activo y 
en qué fechaCreacion se hizo, para poder mostrarlo bonito en la pantalla.
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //Básicamente, crea por ti el "Patrón Builder" 
        // en segundo plano. Para que veas lo útil que es
        //osea no tienes que hacer esto: Reserva reserva = new Reserva(1L, "Juan", "555-1234", fecha, 4, "CONFIRMADO");
        //eso lo haces mas facil y "rapido" en ReservaServiceImpl mas especifico en 
        // private ReservaResponseDTO convertirEnEntidadADTO(Reserva reserva) -> aqui es donde Builder toma accion 
public class ReservaResponseDTO {
    private Long id;
    private String nombreCliente;
    private String telefono;
    private LocalDateTime fechaHora;
    private int numeroPersonas;
    private String estado;
}
