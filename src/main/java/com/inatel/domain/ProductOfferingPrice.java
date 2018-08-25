package com.inatel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ProductOfferingPrice")
public class ProductOfferingPrice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @NotNull
    String name;

    String description;

    @NotNull
    String code;

    @NotNull
    Double price;

    @NotNull
    @Column(name="date_register")
    LocalDate dateRegister;

    @NotNull
    @Builder.Default
    boolean activated = false;
}

