package homeWork.week2Day2Annotations.taskTextContainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainSaver {

    public static void main(String[] args) throws  IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Container.class;
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(new Container());
            }
        }
    }
}
