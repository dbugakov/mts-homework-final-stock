package ru.siebel.stock.service.mapper;

import org.mapstruct.Mapper;
import ru.siebel.stock.dto.Stock;
import ru.siebel.stock.service.entity.StockEntity;


@Mapper(componentModel = "spring")
public interface StockMapper {

    Stock entityToDto(StockEntity entity);

    StockEntity dtoToEntity(Stock dto);

}
