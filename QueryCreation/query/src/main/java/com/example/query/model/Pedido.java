package com.example.query.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int idNf;
    private int idItem;
    private int codProd;
    private double valorUnit;
    private int quantidade;
    private int desconto;

  
}
