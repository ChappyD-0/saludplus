package com.blacksystem.saludplus.service

import com.blacksystem.saludplus.model.paciente.Paciente
import com.blacksystem.saludplus.repository.paciente.PacienteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

class NotFoundException(message: String) : RuntimeException(message)

@Service
class PacienteService(
    private val repo: PacienteRepository
) {
    @Transactional(readOnly = true)
    fun getAll(pageable: Pageable): Page<Paciente> = repo.findAll(pageable)

    @Transactional(readOnly = true)
    fun getOne(id: Long): Paciente =
        repo.findById(id).orElseThrow { NotFoundException("Paciente $id no encontrado") }

    @Transactional
    fun create(p: Paciente): Paciente = repo.save(p)

    @Transactional
    fun update(id: Long, updater: (Paciente) -> Unit): Paciente {
        val p = getOne(id)
        updater(p)
        return repo.save(p)
    }

    @Transactional
    fun delete(id: Long) {
        if (!repo.existsById(id)) throw NotFoundException("Paciente $id no encontrado")
        repo.deleteById(id)
    }
}
