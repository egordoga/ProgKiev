package homeWork.taskClientWithPhoto.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Photo {
    private int id;
    private byte[] jpg;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jpg")
    public byte[] getJpg() {
        return jpg;
    }

    public void setJpg(byte[] jpg) {
        this.jpg = jpg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id &&
                Arrays.equals(jpg, photo.jpg);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(jpg);
        return result;
    }
}
