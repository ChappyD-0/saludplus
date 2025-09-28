package com.blacksystem.saludplus.controller

import com.blacksystem.saludplus.model.dto.paciente.PacienteCreateDTO
import com.blacksystem.saludplus.model.dto.paciente.PacientePatchDTO
import com.blacksystem.saludplus.model.dto.paciente.PacienteResponseDTO
import com.blacksystem.saludplus.model.dto.paciente.PacienteUpdateDTO
import com.blacksystem.saludplus.model.paciente.Paciente
import com.blacksystem.saludplus.model.paciente.applyPatch
import com.blacksystem.saludplus.model.paciente.applyPut
import com.blacksystem.saludplus.model.paciente.toResponse
import com.blacksystem.saludplus.service.PacienteService
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/saludplus")
@Validated
class PacienteController(
    private val service: PacienteService
) {

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable) =
        service.getAll(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) =
        service.getOne(id).toResponse()

    @PostMapping
    fun create(@RequestBody @Valid body: PacienteCreateDTO): ResponseEntity<PacienteResponseDTO> {
        val saved = service.create(Paciente(body.nombre, body.apellido, body.edad, body.telefono))
        val uri = URI.create("/pacientes/${saved.idPaciente}")
        return ResponseEntity.created(uri).body(saved.toResponse())
    }

    @PutMapping("/{id}")
    fun put(@PathVariable id: Long, @RequestBody @Valid body: PacienteUpdateDTO) =
        service.update(id) { it.applyPut(body) }.toResponse()

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: Long, @RequestBody body: PacientePatchDTO) =
        service.update(id) { it.applyPatch(body) }.toResponse()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
