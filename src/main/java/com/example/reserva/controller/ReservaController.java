package com.example.reserva.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        /*
        Al ponerle .ok(), le estás pegando a esa bandeja una etiqueta verde con el código 200 OK
        ese codigo es universal osea que si te tira el 200 es que todo salio de maravilla, vo dale noma
        */
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReservaPorId(@PathVariable Long id){
        /*
    Literalmente significa "Variable de la ruta". Es la herramienta que va a la URL, lee el número que el cliente escribió en el 
    espacio de {id}, y se lo inyecta a tu variable Long id de Java para que puedas pasárselo a tu Service.

    1.-Si en Postman tú haces un GET a http://localhost:8080/api/reservas/5:

    2.-Spring ve que el 5 está ocupando el lugar de /{id} en la ruta.

    3.-El @PathVariable atrapa ese 5.

    4.- Se lo pasa a tu método y tu código se ejecuta por detrás como: reservaService.obtenerReservaPorId(5). y woala

    pd: me llevo un rato entenderlo porq soy boludo simplemente
    pd2: pitbull god para programar
    SWING YOUR PARTNER 'ROUND AND ROUND'

    END OF THE NIGHT, IT'S GOIN' DOWN
        */

        log.info("GET /api/reservas/{}", id);
        ReservaResponseDTO reserva = reservaService.obtenerReservaPorId(id);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id){
        log.info("PATCH /api/reservas/{} - Eliminar reserva", id);
        reservaService.eliminarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizarReserva(@PathVariable Long id, @RequestBody ReservaRequestDTO requestDTO){
        log.info("PUT /api/reservas/{} Actualizar", id);
        ReservaResponseDTO reservaActualizada = reservaService.actualizarReserva(id, requestDTO);
        return ResponseEntity.ok(reservaActualizada);
    }
    
    
    


    

}
