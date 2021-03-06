package com.ntapia.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import java.io.Serializable;

/**
 * Entity that represents the Cards data
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {

    private static final long serialVersionUID = 20190117L;

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
