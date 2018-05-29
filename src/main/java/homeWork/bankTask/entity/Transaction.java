package homeWork.bankTask.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

//@Entity
public class Transaction {
    private int id;
    private int toAccountId;
    private int fromAccountId;
    private double sum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "to_account_id")
    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }

    @Basic
    @Column(name = "from_account_id")
    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    @Basic
    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                toAccountId == that.toAccountId &&
                fromAccountId == that.fromAccountId &&
                Double.compare(that.sum, sum) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, toAccountId, fromAccountId, sum);
    }
}
