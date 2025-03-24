package com.girouard.springfilrouge.controller;

import com.girouard.springfilrouge.dao.SaleLineDao;
import com.girouard.springfilrouge.model.SaleLine;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class SaleLineController {

//    @Autowired
//    protected SaleLineDao saleLineDao;
// plus simple, mais pas la bonne manière de faire, celle du dessous est mieux pour les tests unitaires plus tard

    protected SaleLineDao saleLineDao;

    @Autowired
    public SaleLineController(SaleLineDao saleLineDao) {
        this.saleLineDao = saleLineDao;
    }

    @GetMapping("/saleLine/{id}")
    public ResponseEntity<SaleLine> get(@PathVariable int id) {
        Optional<SaleLine> optionalSaleLine = saleLineDao.findById(id);
        if (optionalSaleLine.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalSaleLine.get(), HttpStatus.OK);
    }

    @GetMapping("/saleLines")
    public List<SaleLine> getAll() {
        return saleLineDao.findAll();
    }

    @PostMapping("/saleLine")
    public ResponseEntity<SaleLine> save(@RequestBody @Valid SaleLine saleLine) {
        saleLineDao.save(saleLine);
        return new ResponseEntity<>(saleLine, HttpStatus.CREATED);
    }

    @DeleteMapping("/saleLine/{id}")
    public ResponseEntity<SaleLine> delete(@PathVariable int id) {
        Optional<SaleLine> optionalSaleLine = saleLineDao.findById(id);
        if (optionalSaleLine.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        saleLineDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/saleLine/{id}")
    public ResponseEntity<SaleLine> update(@PathVariable int id, @RequestBody @Valid SaleLine saleLine) {
        Optional<SaleLine> optionalSaleLine = saleLineDao.findById(id);
        if (optionalSaleLine.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        saleLine.setId(id);
        saleLineDao.save(saleLine);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
