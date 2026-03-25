package com.example.reserva.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.reserva.dto.ReservaRequestDTO;
import com.example.reserva.dto.ReservaResponseDTO;
import com.example.reserva.modelo.Reserva;
import com.example.reserva.repository.ReservaRepository;
import com.example.reserva.service.ReservaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service //Le dice a Spring: "Esta clase es el cerebro (la lógica de negocio), guárdala en tu memoria para usarla cuando la necesite".
@RequiredArgsConstructor //Crea un constructor automático para tus variables
@Slf4j //Te regala una variable llamada log lista para usar, para que puedas imprimir mensajes en la consola|NOMBRE QLIAO PA RECORDAR 
@Transactional //Crea una "red de seguridad" en la base de datos: si guardas algo y ocurre un error un milisegundo después, deshace todo

public class ReservaServiceImpl implements ReservaService{
    private final ReservaRepository reservaRepository;

    @Override
    public ReservaResponseDTO crearReserva(ReservaRequestDTO requestDTO) {
        log.info("Creando nueva Rerserva: {}", requestDTO.getNombreCliente());
        
        Reserva reserva = convertirDTOAEntidad(requestDTO);
        Reserva rersevaGuardada = reservaRepository.save(reserva);

        return convertirEnEntidadADTO(rersevaGuardada);
        
    }

    @Override
    public List<ReservaResponseDTO> obtenerTodasLasReservas() {
        log.info("Obteniendo todas las Categorias");

        return reservaRepository.findAll()
            .stream()
            .map(this::convertirEnEntidadADTO)
            .collect(Collectors.toList());
            /*
            Primero, findAll() saca todas tus reservas "crudas" de la base de datos y las pone a avanzar en fila india 
            sobre una cinta transportadora, que es el .stream(). Conforme van avanzando por esa cinta, pasan por una 
            máquina transformadora llamada .map(); esta máquina toma cada reserva original, le aplica el método traductor (this::convertirEnEntidadADTO) 
            y la saca convertida en un ResponseDTO limpio y presentable. Al final del recorrido está el .collect(), que 
            simplemente se encarga de recolectar todas esas nuevas cajas ya transformadas 
            y agruparlas en una lista final lista para enviarse y woala parece dificil pero no es mucho pero es trabajo honesto
            */
    }

    @Override
    public ReservaResponseDTO obtenerReservaPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerReservaPorId'");
    }

    @Override
    public ReservaResponseDTO actualizarReserva(Long id, ReservaRequestDTO requestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarReserva'");
    }

    @Override
    public void eliminarReserva(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarReserva'");
    }

    private Reserva convertirDTOAEntidad(ReservaRequestDTO dto){
        Reserva reserva = new Reserva();
        reserva.setNombreCliente(dto.getNombreCliente());
        reserva.setTelefono(dto.getTelefono());
        reserva.setFechaHora(dto.getFechaHora());
        reserva.setNumeroPersonas(dto.getNumeroPersonas());
        reserva.setEstado(dto.getEstado());
        return reserva;

        /*
        Toma los datos que escribió el usuario en la página (tu RequestDTO) 
        y los convierte al formato oficial que tu base de datos entiende (tu Entidad @Entity Reserva).
        osea es como un traductor
        */
    }

    private ReservaResponseDTO convertirEnEntidadADTO(Reserva reserva){
        return ReservaResponseDTO.builder()
        .id(reserva.getId())
        .nombreCliente(reserva.getNombreCliente())
        .telefono(reserva.getTelefono())
        .fechaHora(reserva.getFechaHora())
        .numeroPersonas(reserva.getNumeroPersonas())
        .estado(reserva.getEstado())
        .build();

        /*
        este código es un empaquetador oficial. Su único trabajo es tomar los datos "crudos" que acaban de salir 
        de tu base de datos (tu @Entity Reserva) y meterlos en una caja limpia y segura (ReservaResponseDTO) 
        para enviársela al cliente que está usando la página

        Creeme que esta wea es importante y revisa bien que tu Response ctm y que este el @Builder 
        porque si no te pasara como a mi que estuve MEDIA HORA BUSCANDO porque no me aparecia el .builder()
        
        */

    }

}
