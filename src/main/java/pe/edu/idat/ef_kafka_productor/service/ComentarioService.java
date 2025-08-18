package pe.edu.idat.ef_kafka_productor.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.edu.idat.ef_kafka_productor.model.Comentario;

@Service
public class ComentarioService {

    private static final String TOPIC = "comentarios_usuarios";
    private final KafkaTemplate<String, Comentario> kafkaTemplate;

    public ComentarioService(KafkaTemplate<String, Comentario> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarComentario(Comentario comentario) {
        kafkaTemplate.send(TOPIC, comentario);
        System.out.println("Comentario enviado: " + comentario);
    }
}
 