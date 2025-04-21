package meu.curso.microservicos.processamento.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {

  @RabbitListener(queues = "${broker.queue.processamento.name}")
  public void listenerProcessamentoQueue(@Payload String descricao) {
    System.out.println("Processando a mensagem: " + descricao);
  }
}
