package week2Day2Annotations.taskSerialization;

import java.io.Serializable;

public class DataSerial implements Serializable {

    private String one = "one";
    private String two = "two";
    @Save
    private String three = "three";
    private String four = "four";
    @Save
    private String five = "five";
    @Save
    private String six = "six";
    private String seven = "seven";



}
