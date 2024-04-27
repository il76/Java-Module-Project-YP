import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> productList = new ArrayList<>();

    public Calculator() {
        Scanner scanner = new Scanner(System.in);
        // без этой строки не принимает значения вида "Тест 2"
        scanner.useDelimiter(System.getProperty("line.separator"));
        System.out.println("Введите список товаров");
        while (true) {
            System.out.println("Введите название товара или команду \"Завершить\" для окончания ввода");
            String userInput = scanner.next();
            if (userInput.toLowerCase().equals("завершить")) {
                break;
            } else {
                Product product = new Product(userInput);
                while (true) {
                    double price;
                    try {
                        System.out.println("Укажите стоимость товара в формате рубли.копейки (например, 11.00 или 14.15)");
                        price = scanner.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Стоимость товара должна быть числом, попробуйте ещё раз");
                        scanner.nextLine();
                        continue;
                    }
                    if (price <= 0) {
                        System.out.println("Стоимость товара должна быть положительной");
                    } else {
                        product.price = price;
                        productList.add(product);
                        System.out.println("Товар " + product.name + " со стоимостью " + product.getFormattedPrice() + " успешно добавлен");
                        break;
                    }
                }
            }
        }
    }

    /**
     * Список товаров
     */
    public void printList() {
        System.out.println("Добавленные товары:");
        for (Product product: productList) {
            System.out.println("Товар " + product.name + " стоит " + product.getFormattedPrice() + " р.");
        }
    }
}
