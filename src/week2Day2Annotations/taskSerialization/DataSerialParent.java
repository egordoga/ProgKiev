package week2Day2Annotations.taskSerialization;

import java.io.Serializable;

public class DataSerialParent extends DataSerialParent2 implements Serializable {

    private String eight = "eight";
    @Save
    private String nine = "nine";
    @Save
    private String ten = "ten";
}