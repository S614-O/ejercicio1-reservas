package com.example.reserva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reserva.dto.ReservaRequestDTO;
import com.example.reserva.dto.ReservaResponseDTO;
import com.example.reserva.service.ReservaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@RestController //Le dice a Spring: "Esta clase es el recepcionista. Va a escuchar peticiones de internet y va a devolver datos puros (en formato JSON), no páginas web"
@RequestMapping("/api/reservas") //Es la dirección exacta de esa puerta. Le dice al servidor: "Cualquier petición web que empiece con la ruta http://localhost:8080/api/reservas, mándala para acá".
@RequiredArgsConstructor
@Slf4j

public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva (@RequestBody ReservaRequestDTO requestDTO){
        log.info("POST /api/reservas - crear reserva: {}", requestDTO.getNombreCliente());
        ReservaResponseDTO reservaCreada = reservaService.crearReserva(requestDTO);        
        return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
    }

    @GetMapping("/activas")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodasLasReservas(){
        log.info("GET /api/reservas/activas");
        List<ReservaResponseDTO> reservas = reservaService.obtenerTodasLasReservas();
        return ResponseEntity.ok(reservas);
    }
    
    


    

}
