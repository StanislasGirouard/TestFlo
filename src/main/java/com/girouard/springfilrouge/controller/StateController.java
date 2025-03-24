package com.girouard.springfilrouge.controller;

import com.girouard.springfilrouge.dao.StateDao;
import com.girouard.springfilrouge.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class StateController {

//    @Autowired
//    protected StateDao stateDao;
// plus simple, mais pas la bonne manière de faire, celle du dessous est mieux pour les tests unitaires plus tard

    protected StateDao stateDao;

    @Autowired
    public StateController(StateDao stateDao) {
        this.stateDao = stateDao;
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<State> get(@PathVariable int id) {
        Optional<State> optionalState = stateDao.findById(id);
        if (optionalState.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalState.get(), HttpStatus.OK);
    }

    @GetMapping("/states")
    public List<State> getAll() {
        return stateDao.findAll();
    }

    @PostMapping("/state")
    public ResponseEntity<State> save(@RequestBody State state) {
        stateDao.save(state);
        return new ResponseEntity<>(state, HttpStatus.CREATED);
    }

    @DeleteMapping("/state/{id}")
    public ResponseEntity<State> delete(@PathVariable int id) {
        Optional<State> optionalState = stateDao.findById(id);
        if (optionalState.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stateDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/state/{id}")
    public ResponseEntity<State> update(@PathVariable int id, @RequestBody State state) {
        Optional<State> optionalState = stateDao.findById(id);
        if (optionalState.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        state.setId(id);
        stateDao.save(state);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
