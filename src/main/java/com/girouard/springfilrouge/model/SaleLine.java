package com.girouard.springfilrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.girouard.springfilrouge.view.SaleView;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SaleLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @DecimalMin(value = "0.1")
    @JsonView(SaleView.class)
    protected float salePrice;

    @Min(1)
    @JsonView(SaleView.class)
    protected int quantity;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(SaleView.class)
    protected Product product;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected Sale sale;

}
