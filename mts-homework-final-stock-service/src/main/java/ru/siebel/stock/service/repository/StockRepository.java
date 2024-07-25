package ru.siebel.stock.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.siebel.stock.service.entity.StockEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, UUID> {
    Optional<StockEntity> getStockEntityByValue(String value);
}
