package book.general_programming;

import java.math.BigDecimal;

/**
 * <h1>Avoid <i>float</i> and <i>double</i> if exact answers are required</h1>
 * <p>The float and double types are particularly ill-suited for monetary calculation.</p>
 */
public class Item60 {
    public static void main(String[] args) {
        System.out.println(1.03 - 0.42);
        System.out.println(1.00 - 0.90);
        //rounding doesn't sovles this problem
        /*
        Suppose you have a dollar, and you see a shelf with a row of candies priced at 10¢, 20¢, 30¢ and so forth, up to a dollar. You buy one of each candy, starting with the one that costs 10¢, until you can't afford to  buy the next candy on the shelf. How many candies do you buy, and how much change do you get?
         */
//        wrongAnswers();
        correctAnswer();
        alternativeCorrect();
    }

    private static void alternativeCorrect() {
        //do all calculations in cents avoiding floating points
        int itemBought = 0;
        int funds = 100;
        for (int price = 0; funds>=price; price+=10) {
            funds-=price;
            itemBought++;
        }
        System.out.println(itemBought + " item bought");
        System.out.println("Money Left : " + funds);
    }

    private static void correctAnswer() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10"); //note using ".10" instead of .10
        int itemBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemBought++;
        }
        System.out.println(itemBought + " item bought");
        System.out.println("Money Left : " + funds);
    }

    private static void wrongAnswers() {
        double funds = 1.00;
        int itemBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemBought++;
        }
        System.out.println(itemBought + " Items bought.");
        System.out.println("Change : " + funds);
    }
}
