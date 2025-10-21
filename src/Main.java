import java.util.Scanner;

import static java.lang.Long.sum;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число");
        int firstNumber = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число");
        int secondNumber = new Scanner(System.in).nextInt();
        double quotient = (double)  firstNumber / secondNumber;
        System.out.println("Сумма равна: " + sum(firstNumber,secondNumber));
        System.out.println("Разность равна: " + sum(firstNumber,-secondNumber));
        System.out.println("Произведение равно: " + firstNumber*secondNumber);
        System.out.println("Частное равно: " + quotient);
    }
}
