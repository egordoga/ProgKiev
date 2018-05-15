package homeWork.week2Day2Annotations.taskAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainAnnotation {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> clazz = Test.class;
        Method method = clazz.getDeclaredMethod("printUser", String.class, int.class);
        MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
        method.invoke(new Test(), ma.name(), ma.age());
        //new Test().printUser(ma.name(), ma.age());  //или так вызвать?
    }
}
