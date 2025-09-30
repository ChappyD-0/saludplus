        package com.blacksystem.saludplus.repository.paciente

        import com.blacksystem.saludplus.model.paciente.Paciente
        import org.springframework.data.jpa.repository.JpaRepository

        interface PacienteRepository: JpaRepository<Paciente, Long> {
            fun findByIdPaciente(idPaciente: Long): Paciente?
            fun getAllByNombre(nombre: String): List<Paciente>
            fun deleteByIdPaciente(idPaciente: Long)
        }