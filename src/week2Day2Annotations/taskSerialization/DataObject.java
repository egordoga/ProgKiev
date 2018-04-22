package week2Day2Annotations.taskSerialization;

import java.lang.reflect.Field;

public class DataObject {

     String makeObj() throws IllegalAccessException {
        String str = "";
        Class<?> cls = DataSerial.class;
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                str += (" " + field.get(new DataSerial()));
            }
        }
        return str;
    }
}
