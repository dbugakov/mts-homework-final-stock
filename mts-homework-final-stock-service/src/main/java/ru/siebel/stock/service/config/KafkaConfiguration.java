package ru.siebel.stock.service.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import ru.siebel.stock.dto.kafka.StockMessage;
import ru.siebel.stock.service.service.StockService;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final StockService stockService;

    @Bean
    public Consumer<Message<StockMessage>> consumeStockMessage() {
        return message -> {
            Acknowledgment acknowledgment = message.getHeaders()
                    .get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
            StockMessage payload = message.getPayload();

            stockService.saveStock(payload.getStock());

            if (acknowledgment != null) {
                acknowledgment.acknowledge();
            }
        };
    }
}