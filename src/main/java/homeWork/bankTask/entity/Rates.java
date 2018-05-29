package homeWork.bankTask.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

//@Entity
public class Rates {
    private int id;
    private double value;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rates rates = (Rates) o;
        return id == rates.id &&
                Double.compare(rates.value, value) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, value);
    }
}
