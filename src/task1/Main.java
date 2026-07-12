package task1;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        try {
            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1, 1);
            int c = calc.devide.apply(a, b); //тут происходит деление на 0
            //возникает ошибка ArithmeticException
            //обработаем и работает

            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Делитель равен нулю, на нуль делить нельзя");
        }
    }
}
