package ru.siebel.stock.service.Deserializer;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import ru.siebel.stock.dto.Stock;

import java.io.IOException;

public class StockDeserializer extends KeyDeserializer {
    @Override
    public Stock deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        return new Stock();
    }
}
