public class Product {
    /**
     * Стоимость товара
     */
    double price;
    /**
     * Название товара
     */
    String name;

    public Product(String name) {
        this.name = name;
    }

    /**
     * Форматирование стоимости
     * @return String руб.коп
     */
    public String getFormattedPrice() {
        return String.format("%1$,.2f", price);
    }

}
