package homeWork.week2Day2Annotations.taskSerialization;

import java.io.Serializable;

public class DataSerialParent2 implements Serializable {

    @Save
    private String vasya = "Vasya";
    private String lena = "Lena";
}
