package Task_2;

import com.sun.jdi.InterfaceType;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    public static void main(String[] args) {
        Class<Calculate> calculateClass = Calculate.class;
        List<Method> list = List.of(calculateClass.getDeclaredMethods());

        List<String> methodList = list.stream()
                .map(Method::getName)
                .filter(name -> name.startsWith("calc"))
                .collect(Collectors.toList());

        for (String name: methodList) {
            System.out.printf("%s -> %s\n", name, pars(name));
        }
    }

    private static String getOperation(String s) {
        String answer = "";
        if (s.equals("plus")) {
            answer = "+";
        } else if (s.equals("minus")) {
            answer = "-";
        } else if (s.equals("multiply")) {
            answer = "*";
        } else if (s.equals("divide")) {
            answer = "/";
        }
        return answer;
    }

    private static int calc(int a, String operation, int b) {
        int answer = 0;

        if (operation.equals("+")) {
            answer = a + b;
        } else if (operation.equals("-")) {
            answer = a - b;
        } else if (operation.equals("*")) {
            answer = a*b;
        } else if (operation.equals("/")) {
            answer = a/b;
        }

        return answer;
    }

    private static String pars(String s) {
        String answer = "";

        int a, b = 0;
        s = s.substring(4);

        String num = "";
        while (Character.isDigit(s.charAt(0))) {
            num += s.charAt(0);
            s = s.substring(1);
        }

        a = Integer.parseInt(num);

        String operation = "";

        while (Character.isLetter(s.charAt(0))) {
            operation += s.charAt(0);
            s = s.substring(1);
        }

        operation = getOperation(operation);

        b = Integer.parseInt(s);

        return String.format("%d %s %d = %d", a, operation, b, calc(a, operation, b));
    }
}
