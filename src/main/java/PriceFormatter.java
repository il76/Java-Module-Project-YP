import java.util.Locale;

public class PriceFormatter {
    /**
     * Стоимость, которую будем выводить красиво
     */
    Double price;

    PriceFormatter(Double price) {
        this.price = price;
    }
    /**
     * Форматирование стоимости
     * @return String руб.коп
     */
    public String getFormattedPrice() {
        // https://stackoverflow.com/questions/13763700/java-string-format-numbers-with-localization
        return String.format(Locale.ENGLISH, "%1$,.2f", price) + " " + getFormattedCurrency();
    }

    private String getFormattedCurrency() {
        String currency = "рубль";
        int intPrice = price.intValue();
        int lastDigit = intPrice % 10;
        if (intPrice == 1 || (intPrice > 20 && lastDigit == 1)) {
            currency = "рубль";
        } else if ((intPrice >= 2 && intPrice < 5) || (intPrice > 20 && lastDigit >= 2 && lastDigit < 5)) {
            currency = "рубля";
        } else if ((intPrice >= 5 && intPrice < 20) || lastDigit == 0 || lastDigit >= 5) {
            currency = "рублей";
        }
        return currency;
    }
}
