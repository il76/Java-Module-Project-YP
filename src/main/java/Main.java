import java.util.Scanner;

public class Main {
    public static int peopleCnt;

    public static void askPeopleCnt() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("На скольких человек необходимо разделить счёт?");
                peopleCnt = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Принимается только числовой ввод, попробуйте ещё раз");
                scanner.nextLine();
                continue;
            }
            if (peopleCnt < 1) {
                System.out.println("Если никого нет, то и делить нечего. Число участников должно быть > 1");
            } else if (peopleCnt == 1) {
                System.out.println("Если заказ делал один человек, то он и платит. Число участников должно быть > 1");
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Вас приветствует калькулятор счёта");
        askPeopleCnt();
        System.out.println("Данные приняты, делим счёт на "+peopleCnt+" человек(а)");
        Calculator calc = new Calculator();
        calc.printList();
        PriceFormatter formatter = new PriceFormatter(calc.totalAmount / peopleCnt);
        System.out.println("Каждый человек должен заплатить "+formatter.getFormattedPrice()+"\n");
        System.out.println("Спасибо за использование калькулятора. Приходите ещё.");
    }
}