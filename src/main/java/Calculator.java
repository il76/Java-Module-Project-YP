import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    ArrayList<Product> productList = new ArrayList<>();
    double totalAmount;

    public void getData() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        // без этой строки не принимает значения вида "Тест 2". Вот только в Windows НЕ работает
        // scanner.useDelimiter(System.lineSeparator());
        // нужно так, что в linux, что в windows - привет особенностям реализации консоли ввода
        scanner.useDelimiter("\n");
        // scanner.useLocale(Locale.ENGLISH); //десятичная точка вместо запятой
        System.out.println("Введите список товаров");
        while (true) {
            System.out.println("Введите название товара или команду \"Завершить\" для окончания ввода");
            String userInput = scanner.next().trim();
            if (userInput.equalsIgnoreCase("завершить")) {
                break;
            } else if (userInput.isEmpty()) {
                System.out.println("Вы не ввели название товара, попробуйте ещё раз");
                continue;
            } else {
                Product product = new Product(userInput);
                while (true) {
                    double price;
                    try {
                        System.out.println("Укажите стоимость товара в формате рубли.копейки (например, 11.00 или 14.15)");
                        price = scanner.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Стоимость товара должна быть числом, попробуйте ещё раз");
                        scanner.next(); //без этой строки зациклится, нужно сменить строку
                        continue;
                    }
                    if (price <= 0) {
                        System.out.println("Стоимость товара должна быть положительной");
                    } else {
                        product.price = price;
                        productList.add(product);
                        PriceFormatter formatter = new PriceFormatter(product.price);
                        System.out.println("Товар " + product.name + " со стоимостью " + formatter.getFormattedPrice() + " успешно добавлен");
                        totalAmount += product.price;
                        break;
                    }
                }
            }
        }
    }

    public Calculator() {

    }

    /**
     * Список товаров
     */
    public void printList() {
        System.out.println("Добавленные товары:");
        for (Product product: productList) {
            PriceFormatter formatter = new PriceFormatter(product.price);
            System.out.println("Товар \"" + product.name + "\" стоит " + formatter.getFormattedPrice());
        }
    }
}
