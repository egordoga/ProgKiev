package homeWork.bank1.entity;

import javax.persistence.*;

@Entity
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    public Rates() {
    }

    public Rates(Double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
