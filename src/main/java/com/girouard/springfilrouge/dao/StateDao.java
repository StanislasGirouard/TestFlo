package com.girouard.springfilrouge.dao;

import com.girouard.springfilrouge.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDao extends JpaRepository<State, Integer> {

}
