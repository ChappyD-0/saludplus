package com.blacksystem.saludplus.model.paciente

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "pacientes")
@Getter
@Setter
class Paciente (
    @Column(nullable = false) var nombre: String,
    @Column(nullable = false) var apellido: String,
    @Column(nullable = false) var edad:Int,
    @Column(nullable = false) var telefono: String,
    //@Column(nullable = false) var expediente: Expediente,
    ){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPaciente: Long? = null


    protected constructor(): this("", "", 0, "")
}