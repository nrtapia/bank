package com.ntapia.bank.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Entity
@NamedEntityGraph(name = "Customer.cards", attributeNodes = @NamedAttributeNode("cards"))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String fullName;

    @Column(length = 100)
    private String address;

    @Column(length = 30)
    private String city;

    @Column(length = 20)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<Card> cards;

    @Version
    private Long version;
}
