import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class PrintMessages {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        print(new Messages());
    }

    public static void printMessage(String style, String color, String msg) {
        if (style.equals("arrow")) {
            System.out.println(color + "---> " + msg + " <---" + color);
        } else if (style.equals("hurray")) {
            System.out.println(color + "^^^^ " + msg + " ^^^^" + color);
        } else if (style.equals("!")) {
            System.out.println(color + "!!! " + msg + " !!!" + color);
        } else {
            System.out.println(msg);
        }
    }

    private static void print(Messages msg) throws InvocationTargetException, IllegalAccessException {
        Class<?> someClass = msg.getClass();

        List<Method> list = List.of(someClass.getDeclaredMethods());

        for (Method m: list) {
            if (m.isAnnotationPresent(Print.class)) {
                Print methodAnnotation = m.getAnnotation(Print.class);

                printMessage(methodAnnotation.style(), methodAnnotation.color(), (String) m.invoke(msg));
            } else if (someClass.isAnnotationPresent(Print.class)) {
                Print classAnnotation = someClass.getAnnotation(Print.class);

                printMessage(classAnnotation.style(), classAnnotation.color(), (String) m.invoke(msg));
            } else {
                printMessage("NONE", "NONE", (String) m.invoke(msg));
            }
        }
    }
}
