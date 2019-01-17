// Copyright (c) 2018 Boomi, Inc.
package com.ntapia.bank.customer;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import java.io.Serializable;

/**
 *
 */
@Entity
@Data
@Builder
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 4, nullable = false)
    private String number1;

    @Column(length = 4, nullable = false)
    private String number2;

    @Column(length = 4, nullable = false)
    private String number3;

    @Column(length = 4, nullable = false)
    private String number4;

    @Column(length = 4, nullable = false)
    private String ccv;

    @Column(length = 50, nullable = false)
    private String cardType;

    @Version
    private Long version;
}
