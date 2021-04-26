package com.example.stockorder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StockorderController {
    
    @Autowired
	private StockorderRepository stockorderRepository;
    
    @GetMapping(path = "/stockorder")
    @CrossOrigin()
    List<Stockorder> getAll(){
        List<Stockorder> stockorders = new ArrayList<Stockorder>();
        for (Stockorder stockorder : stockorderRepository.findAll()) {
            stockorders.add(stockorder);
		}
        return stockorders;
    }

    @GetMapping(path = "/stockorder/{id}")
    @CrossOrigin()
    Stockorder getSingle(@PathVariable Integer id) {
        return stockorderRepository.findById(id).get();
    }

    @PostMapping(path = "/stockorder", consumes="application/json", produces = "application/json")
    @CrossOrigin()
    ResponseEntity<Object> add(@RequestBody Stockorder s) {
        
        stockorderRepository.save(s);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(s.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/stockorder/{id}", consumes="application/json", produces = "application/json")
    @CrossOrigin()
    Stockorder update(@PathVariable Integer id, @RequestBody Stockorder updatedStockorder) {

        Stockorder dbStockorder = stockorderRepository.findById(id).get();
        dbStockorder.setAmount(updatedStockorder.getAmount());
        dbStockorder.setStockId(updatedStockorder.getStockId());
        
        stockorderRepository.save(dbStockorder);
        
        return dbStockorder;
    }

    @DeleteMapping(path = "/stockorder/{id}")
    @CrossOrigin()
    void delete(@PathVariable Integer id) {
        stockorderRepository.deleteById(id);
    }
}