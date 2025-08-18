package pe.edu.idat.ef_kafka_productor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.ef_kafka_productor.model.Comentario;
import pe.edu.idat.ef_kafka_productor.service.ComentarioService;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<String> crearComentario(@RequestBody Comentario comentario) {
        comentarioService.enviarComentario(comentario);
        return ResponseEntity.ok("Comentario recibido y enviado a Kafka.");
    }
}