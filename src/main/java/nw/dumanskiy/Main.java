package nw.dumanskiy;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class hobbyClass = Class.forName("com.netcracker.dumanskiy.Hobby");
        Object hobby = hobbyClass.getConstructor(String.class, int.class).newInstance("NewHobby", 1234);
        Field[] fields = hobbyClass.getFields();
        Method[] methods = hobbyClass.getMethods();
        Constructor[] constructors = hobbyClass.getConstructors();
        for (Field field : fields) {
            System.out.println(field);
        }
        for (Method method : methods) {
            System.out.println(method);
        }
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("test: " + hobbyClass.getMethod("test", int.class, String.class, double.class).invoke(hobby, 10, "test", 20.5));
        Field field = hobbyClass.getDeclaredField("amount");
        field.setAccessible(true);
        System.out.println("Amount(private field without constructors and setters): " + field.get(hobby));
        field.set(hobby, 12);
        System.out.println("Amount(private field without constructors and setters) after change: " + field.get(hobby));
        field = hobbyClass.getDeclaredField("some");
        field.setAccessible(true);
        System.out.println(field.get(hobby));
        field.set(hobby, 22);
        System.out.println(field.get(hobby));
    }
}
