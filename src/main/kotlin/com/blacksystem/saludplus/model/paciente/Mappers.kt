package com.blacksystem.saludplus.model.paciente

import com.blacksystem.saludplus.model.dto.paciente.*

fun Paciente.toResponse() = PacienteResponseDTO(
    id = this.idPaciente!!,
    nombre = this.nombre,
    apellido = this.apellido,
    edad = this.edad,
    telefono = this.telefono,
    curp = this.curp,
    direccion = this.direccion,
    correo = this.correo,
)

fun Paciente.applyPut(dto: PacienteUpdateDTO) {
    nombre = dto.nombre
    apellido = dto.apellido
    edad = dto.edad
    telefono = dto.telefono
    curp = dto.curp
    direccion = dto.direccion
    correo = dto.correo
}

fun Paciente.applyPatch(dto: PacientePatchDTO) {
    dto.nombre?.let { nombre = it }
    dto.apellido?.let { apellido = it }
    dto.edad?.let { edad = it }
    dto.telefono?.let { telefono = it }
    dto.curp?.let { curp = it }
    dto.direccion?.let { direccion = it }
    dto.correo?.let { correo = it }
}
