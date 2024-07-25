package ru.siebel.stock.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.siebel.order.dto.Order;
import ru.siebel.stock.api.StockApi;
import ru.siebel.stock.dto.Stock;
import ru.siebel.stock.service.service.StockService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StockController implements StockApi {

    private final StockService stockService;
    List<String> ingredients;

    @Override
    @ResponseBody
    public ResponseEntity<Boolean> checkIngredients(Order dto) {
        ingredients = List.of(dto.getContent().split(","));
        return new ResponseEntity<>(stockService.checkIngredients(ingredients), HttpStatus.OK);
    }

    @Override
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getOrderIngredients(Order dto) {
        ingredients = List.of(dto.getContent().split(","));
        return new ResponseEntity<>(stockService.getOrderIngredients(ingredients), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Stock> getStockByValue(String value) {
        return new ResponseEntity<>(stockService.getStockByValue(value), HttpStatus.OK);
    }
}
