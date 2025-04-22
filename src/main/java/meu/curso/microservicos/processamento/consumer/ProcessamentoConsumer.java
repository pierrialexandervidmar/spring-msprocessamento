package meu.curso.microservicos.processamento.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import meu.curso.microservicos.processamento.dto.PedidoDto;

@Component
public class ProcessamentoConsumer {

  @RabbitListener(queues = "${broker.queue.processamento.name}")
  public void listenerProcessamentoQueue(PedidoDto pedido) {
    System.out.println("Processando a mensagem: " + pedido.getDescricao());

    if (pedido.getItens() != null) {
      pedido.getItens().forEach(item -> 
          System.out.println("Item: " + item.getNomeProduto() + " - Quantidade: " + item.getQuantidade())
      );
  }
  }
}
