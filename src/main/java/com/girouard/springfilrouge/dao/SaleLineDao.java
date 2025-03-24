package com.girouard.springfilrouge.dao;

import com.girouard.springfilrouge.model.SaleLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleLineDao extends JpaRepository<SaleLine, Integer> {

}
