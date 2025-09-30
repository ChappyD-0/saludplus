package com.blacksystem.saludplus.model.paciente

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "pacientes")
@Getter
@Setter
class Paciente(
    @Column(nullable = false) var nombre: String,
    @Column(nullable = false) var apellido: String,
    @Column(nullable = false) var edad: Int,
    @Column(nullable = false) var telefono: String,

    // NUEVOS CAMPOS
    @Column(nullable = false, unique = true, length = 18) var curp: String,
    @Column(nullable = false) var direccion: String,
    @Column(nullable = false) var correo: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPaciente: Long? = null

    protected constructor() : this("", "", 0, "", "", "", "")
}
