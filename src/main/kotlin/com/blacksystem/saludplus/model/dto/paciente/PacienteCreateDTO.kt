package com.blacksystem.saludplus.model.dto.paciente

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.*

data class PacienteCreateDTO(
    @field:NotBlank val nombre: String,
    @field:NotBlank val apellido: String,
    @field:Min(0) val edad: Int,
    @field:NotBlank val telefono: String,

    // NUEVOS
    @field:NotBlank
    @field:Pattern(regexp = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]\\d$", message = "CURP inválida")
    val curp: String,

    @field:NotBlank val direccion: String,

    @field:NotBlank
    @field:Email(message = "Correo inválido")
    val correo: String,
)

data class PacienteUpdateDTO( // PUT completo
    @field:NotBlank val nombre: String,
    @field:NotBlank val apellido: String,
    @field:Min(0) val edad: Int,
    @field:NotBlank val telefono: String,

    @field:NotBlank
    @field:Pattern(regexp = "^[A-Z]{4}\\d{6}[HM][A-Z]{5}[A-Z0-9]\\d$", message = "CURP inválida")
    val curp: String,

    @field:NotBlank val direccion: String,

    @field:NotBlank
    @field:Email(message = "Correo inválido")
    val correo: String,
)

data class PacientePatchDTO(
    val nombre: String? = null,
    val apellido: String? = null,
    val edad: Int? = null,
    val telefono: String? = null,

    val curp: String? = null,
    val direccion: String? = null,
    val correo: String? = null,
)

data class PacienteResponseDTO(
    @JsonProperty("idPaciente") val id: Long,
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val telefono: String,

    val curp: String,
    val direccion: String,
    val correo: String,
)

