package homeWork.week2Day2Annotations.taskTextContainer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

@SaveTo(path = "e://1.txt")
public class Container {
    private String text = "This is a text";

    @Saver
    public void save() throws IOException, IllegalAccessException {
        Class<?> clazz = this.getClass();
        SaveTo st = clazz.getAnnotation(SaveTo.class);
        String path = st.path();
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class) {
                fw.write((String) field.get(this));
            }
        }

        fw.close();
    }
}
