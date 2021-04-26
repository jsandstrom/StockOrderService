package com.example.stockorder;

import org.springframework.data.repository.CrudRepository;

public interface StockorderRepository extends CrudRepository<Stockorder, Integer> {
    
}