package ru.siebel.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock implements Serializable {

    public static final long serialVersionIUD = 12345L;

    private UUID id;

    private String value;

    private int stock;

    private int reserved;
}
