package homeWork.bank1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private Double summ;

    @OneToMany(mappedBy = "from")
    private List<Transaction> fromList = new ArrayList<>();

    @OneToMany(mappedBy = "to")
    private List<Transaction> toList = new ArrayList<>();

    public Account() {
    }

    public Account(Client client, Currency currency) {
        this.client = client;
        this.currency = currency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Transaction> getFromList() {
        return fromList;
    }

    public void setFromList(List<Transaction> fromList) {
        this.fromList = fromList;
    }

    public List<Transaction> getToList() {
        return toList;
    }

    public void setToList(List<Transaction> toList) {
        this.toList = toList;
    }
}
