package com.example.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reserva.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
/*
CON SOLO ESA LINEA DE CODIGO PUEDES HACER TODO ESTO SIN HABER ESCRITO NADA

save(reserva) Sirve tanto para crear (INSERT) como para actualizar (UPDATE).
findById(id) Busca una reserva específica por su llave primaria.
findAll() Te devuelve una lista con todas las reservas de la tabla.
deleteById(id) Elimina una reserva usando su ID.

NOS ESTAN QUITANDO LA PEGA AAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!!
*/
}
