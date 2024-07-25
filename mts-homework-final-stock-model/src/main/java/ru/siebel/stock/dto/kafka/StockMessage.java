package ru.siebel.stock.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.siebel.stock.dto.Stock;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockMessage implements Serializable {
    public static final long serialVersionIUD = 12345L;

    private Stock stock;
}
