package week2Day2Annotations.taskSerialization;

import java.io.*;

public class MainSerial {

    private static File file = new File("e://2.txt");

    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        DataObject dataObject = new DataObject();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dataObject.makeObj());
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        String str = (String) ois.readObject();
        ois.close();

        str = str.trim();
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
