package com.girouard.springfilrouge.dao;

import com.girouard.springfilrouge.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelDao extends JpaRepository<Label, Integer> {

}
