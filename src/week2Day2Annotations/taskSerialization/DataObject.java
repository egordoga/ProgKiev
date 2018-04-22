package week2Day2Annotations.taskSerialization;

import java.lang.reflect.Field;

public class DataObject {

    Class<?> cls = DataSerial.class;
    String str = "";

    String makeObj() throws IllegalAccessException, InstantiationException {

             Field[] fields = cls.getDeclaredFields();

             for (Field field : fields) {
                 if (field.isAnnotationPresent(Save.class)) {
                     field.setAccessible(true);
                     str += (" " + field.get(cls.newInstance()));
                 }
             }

        if (!(cls.getSuperclass() == null) && !(cls.getSuperclass() == Object.class)) {
            cls = cls.getSuperclass();
            makeObj();
         }
        return str;
    }
}
