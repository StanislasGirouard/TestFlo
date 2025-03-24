package com.girouard.springfilrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.girouard.springfilrouge.view.SaleView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    @NotNull
    @JsonView(SaleView.class)
    protected LocalDateTime date;

    @OneToMany(mappedBy = "sale")
    @JsonView(SaleView.class)
    protected List<SaleLine> lines = new ArrayList<>();
}
