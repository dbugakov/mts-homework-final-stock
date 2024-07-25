package ru.siebel.stock.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.siebel.order.dto.Order;
import ru.siebel.stock.dto.Stock;

import java.util.Map;

@FeignClient(
        name = "StockApi",
        url = "localhost:7456"
)
public interface StockApi {

    @PostMapping("/checkIngredients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Boolean> checkIngredients(@RequestBody Order dto);

    @PostMapping("/getOrderIngredients")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String, Integer>> getOrderIngredients(@RequestBody Order dto);

    @PostMapping("/getStockByValue")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Stock> getStockByValue(@RequestParam String value);
}