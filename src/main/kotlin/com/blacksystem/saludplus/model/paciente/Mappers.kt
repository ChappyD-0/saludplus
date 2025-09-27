package com.blacksystem.saludplus.model.paciente

import com.blacksystem.saludplus.model.dto.paciente.PacientePatchDTO
import com.blacksystem.saludplus.model.dto.paciente.PacienteResponseDTO
import com.blacksystem.saludplus.model.dto.paciente.PacienteUpdateDTO

fun Paciente.toResponse() = PacienteResponseDTO(
    id = this.idPaciente!!,
    nombre = this.nombre,
    apellido = this.apellido,
    edad = this.edad,
    telefono = this.telefono
)

fun Paciente.applyPut(dto: PacienteUpdateDTO) {
    nombre = dto.nombre
    apellido = dto.apellido
    edad = dto.edad
    telefono = dto.telefono
}

fun Paciente.applyPatch(dto: PacientePatchDTO) {
    dto.nombre?.let { nombre = it }
    dto.apellido?.let { apellido = it }
    dto.edad?.let { edad = it }
    dto.telefono?.let { telefono = it }
}
