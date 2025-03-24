package com.girouard.springfilrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.girouard.springfilrouge.view.SaleView;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    @JsonView(SaleView.class)
    protected String name;

    @Column(length = 10, nullable = false, unique = true)
    @Length(max = 10, min = 3)
    @NotBlank
    @JsonView(SaleView.class)
    protected String code;

    @Column(columnDefinition = "TEXT") //TEXT est illimité, varchar est 255
    protected String description;

    @DecimalMin(value = "0.1")
    protected float price;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected State state;

    @ManyToMany
    @JoinTable(name = "product_label", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
    protected List<Label> labels = new ArrayList<>();
}
