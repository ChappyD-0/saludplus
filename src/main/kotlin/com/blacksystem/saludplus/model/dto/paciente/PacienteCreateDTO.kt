package com.blacksystem.saludplus.model.dto.paciente

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank


data class PacienteCreateDTO(
    @field:NotBlank val nombre: String,
    @field:NotBlank val apellido: String,
    @field:Min(0) val edad: Int,
    @field:NotBlank val telefono: String
)

data class PacienteUpdateDTO( // PUT completo
    @field:NotBlank val nombre: String,
    @field:NotBlank val apellido: String,
    @field:Min(0) val edad: Int,
    @field:NotBlank val telefono: String
)

data class PacientePatchDTO(
    val nombre: String? = null,
    val apellido: String? = null,
    val edad: Int? = null,
    val telefono: String? = null
)

data class PacienteResponseDTO(
    val id: Long,
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val telefono: String
)
