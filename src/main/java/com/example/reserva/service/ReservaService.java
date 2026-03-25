package com.example.reserva.service;

import java.util.List;

import com.example.reserva.dto.ReservaRequestDTO;
import com.example.reserva.dto.ReservaResponseDTO;

public interface ReservaService {
    
    //para crear una reserva necesito lo que me pase el cliente osea ReservaRequestDTO
    ReservaResponseDTO crearReserva(ReservaRequestDTO requestDTO);
    
    //Para obtener la lista de todas la reservas lo que ncesitos es, las reservas, si este es medio xd
    //Pero fue la unica forma de explicarlo xd
    List<ReservaResponseDTO> obtenerTodasLasReservas();
    
    //Para obtener una reserva que necesito? pos el id xd
    ReservaResponseDTO obtenerReservaPorId(Long id);

    //y para actualizar una reserva recuerda UNA, solo necesito el id de la reserva y no me los vas a creer
    //la reserva tambien
    ReservaResponseDTO actualizarReserva(Long id, ReservaRequestDTO requestDTO);

    //Creo que no hace falta explicar xd
    void eliminarReserva(Long id);

    //Es pensamiento basico, si necesito esto entonces debo darle esto, basicamente es asi
    //aunque el cerebro le da un derrame al pensar un poco 
    //llevo una hora aqui la re puta madre

    //Como dijo un filosofo griego chino taiwanes

    //ME CAGO EN JAVA!!!!!!

}
