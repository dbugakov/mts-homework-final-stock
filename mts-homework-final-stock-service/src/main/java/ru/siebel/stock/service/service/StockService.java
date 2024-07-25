package ru.siebel.stock.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.siebel.stock.dto.Stock;
import ru.siebel.stock.service.entity.StockEntity;
import ru.siebel.stock.service.mapper.StockMapper;
import ru.siebel.stock.service.repository.StockRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    private final StockMapper stockMapper;

    public boolean checkIngredients(List<String> ingredients) {
        Optional<StockEntity> currentIngredient;
        for (String ingredient : ingredients) {
            currentIngredient = stockRepository.getStockEntityByValue(ingredient);
            if (currentIngredient.isEmpty()) {
                return false;
            } else if (currentIngredient.get().getReserved() >= currentIngredient.get().getStock()) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> getOrderIngredients(List<String> ingredients) {
        Optional<StockEntity> currentIngredient;
        Map<String, Integer> stockMap = new HashMap<>();
        for (String ingredient : ingredients) {
            currentIngredient = stockRepository.getStockEntityByValue(ingredient);
            if (currentIngredient.isPresent()) {
                Stock stock = stockMapper.entityToDto(currentIngredient.get());
                if (stockMap.containsKey(stock.getValue())) {
                    stockMap.put(stock.getValue(), stockMap.get(stock) + 1);
                } else {
                    stockMap.put(stock.getValue(), 1);
                }
            }
        }
        return stockMap;
    }

    public Stock getStockByValue(String value) {
        Optional<StockEntity> entity = stockRepository.getStockEntityByValue(value);
        return entity.map(stockMapper::entityToDto).orElse(null);
    }

    public void saveStock(Stock dto) {
        StockEntity entity = stockMapper.dtoToEntity(dto);
        stockRepository.save(entity);
    }
}
