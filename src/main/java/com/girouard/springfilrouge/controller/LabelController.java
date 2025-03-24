package com.girouard.springfilrouge.controller;

import com.girouard.springfilrouge.dao.LabelDao;
import com.girouard.springfilrouge.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class LabelController {

//    @Autowired
//    protected LabelDao labelDao;
// plus simple, mais pas la bonne manière de faire, celle du dessous est mieux pour les tests unitaires plus tard

    protected LabelDao labelDao;

    @Autowired
    public LabelController(LabelDao labelDao) {
        this.labelDao = labelDao;
    }

    @GetMapping("/label/{id}")
    public ResponseEntity<Label> get(@PathVariable int id) {
        Optional<Label> optionalLabel = labelDao.findById(id);
        if (optionalLabel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalLabel.get(), HttpStatus.OK);
    }

    @GetMapping("/labels")
    public List<Label> getAll() {
        return labelDao.findAll();
    }

    @PostMapping("/label")
    public ResponseEntity<Label> save(@RequestBody Label label) {
        labelDao.save(label);
        return new ResponseEntity<>(label, HttpStatus.CREATED);
    }

    @DeleteMapping("/label/{id}")
    public ResponseEntity<Label> delete(@PathVariable int id) {
        Optional<Label> optionalLabel = labelDao.findById(id);
        if (optionalLabel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        labelDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/label/{id}")
    public ResponseEntity<Label> update(@PathVariable int id, @RequestBody Label label) {
        Optional<Label> optionalLabel = labelDao.findById(id);
        if (optionalLabel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        label.setId(id);
        labelDao.save(label);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
