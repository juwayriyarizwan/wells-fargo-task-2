package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

/* pk portfolioId
fk clientId
creationDate
*/

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private String creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    protected Portfolio(){

    }

    public Portfolio(Client client, String creationDate){
        this.client = client;
        this.creationDate = creationDate;
    }

    public Long getPortfolioId(){ return portfolioId; }

    public Client getClient(){ return client; }

    public void setClient(Client client){ this.client = client; }

    public String getCreationDate(){ return creationDate; }

    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

    public List<Security> getSecurities() { return securities; }

    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
