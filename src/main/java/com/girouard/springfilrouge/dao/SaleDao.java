package com.girouard.springfilrouge.dao;

import com.girouard.springfilrouge.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDao extends JpaRepository<Sale, Integer> {

}
