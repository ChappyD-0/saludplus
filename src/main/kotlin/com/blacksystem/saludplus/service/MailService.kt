package com.blacksystem.saludplus.service.mail

import org.slf4j.LoggerFactory
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailService(
    private val mailSender: JavaMailSender
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun enviarBienvenida(destino: String, nombre: String) {
        val msg = SimpleMailMessage().apply {
            setTo(destino)
            subject = "Bienvenido(a) a SaludPlus"
            text = """
                Hola $nombre,
                
                Tu registro en SaludPlus se ha completado con éxito.
                ¡Gracias por confiar en nosotros!

                — Equipo SaludPlus
            """.trimIndent()
        }
        mailSender.send(msg)
        log.info("Correo de bienvenida enviado a {}", destino)
    }
}
