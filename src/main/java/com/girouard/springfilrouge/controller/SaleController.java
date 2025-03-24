package com.girouard.springfilrouge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.girouard.springfilrouge.dao.SaleDao;
import com.girouard.springfilrouge.model.Sale;
import com.girouard.springfilrouge.view.SaleView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class SaleController {

//    @Autowired
//    protected SaleDao saleDao;
// plus simple, mais pas la bonne manière de faire, celle du dessous est mieux pour les tests unitaires plus tard

    protected SaleDao saleDao;

    @Autowired
    public SaleController(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @GetMapping("/sale/{id}")
    @JsonView(SaleView.class)
    public ResponseEntity<Sale> get(@PathVariable int id) {
        Optional<Sale> optionalSale = saleDao.findById(id);
        if (optionalSale.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSale.get(), HttpStatus.OK);
    }

    @GetMapping("/sales")
    @JsonView(SaleView.class)
    public List<Sale> getAll() {
        return saleDao.findAll();
    }

    @PostMapping("/sale")
    @JsonView(SaleView.class)
    public ResponseEntity<Sale> save(@RequestBody @Valid Sale sale) {
        saleDao.save(sale);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

    @DeleteMapping("/sale/{id}")
    public ResponseEntity<Sale> delete(@PathVariable int id) {
        Optional<Sale> optionalSale = saleDao.findById(id);
        if (optionalSale.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        saleDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/sale/{id}")
    public ResponseEntity<Sale> update(@PathVariable int id, @RequestBody @Valid Sale sale) {
        Optional<Sale> optionalSale = saleDao.findById(id);
        if (optionalSale.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sale.setId(id);
        saleDao.save(sale);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
