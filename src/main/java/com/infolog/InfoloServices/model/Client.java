package com.infolog.InfologServices.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column
    private String secondName;

    @Column
    private int pin;

    @Column
    private String address;

    @Column
    private BigInteger phone;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<com.infolog.InfologServices.model.Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAccount(Account account){
        accounts.add(account);
        account.setClient(this);
    }

    public void removeAccount(Account account){
        accounts.remove(account);
        account.setClient(null);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
