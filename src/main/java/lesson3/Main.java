package lesson3;

import java.time.LocalDate;
// 2. Создать массив из 5 товаров.
public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product(
                "Samsung S25 Ultra",
                LocalDate.of(2025, 2, 1),
                "Samsung Corp.",
                "Korea",
                5599,
                true);

        productsArray[1] = new Product(
                "MacBook Pro 16",
                LocalDate.of(2026, 1, 15),
                "Apple Inc.",
                "USA",
                8999,
                false
        );

        productsArray[2] = new Product(
                "Sony WH-1000XM6",
                LocalDate.of(2025, 7, 20),
                "Sony Corporation",
                "Japan",
                1499,
                true
        );

        productsArray[3] = new Product(
                "PlayStation 6",
                LocalDate.of(2026, 3, 10),
                "Sony Interactive",
                "Japan",
                4999,
                false
        );

        productsArray[4] = new Product(
                "Apple Watch X",
                LocalDate.of(2025, 9, 5),
                "Apple Inc.",
                "China",
                2799,
                true
        );

        System.out.println("Список товаров:");

        for (Product p : productsArray) {
            p.getInformation();
        }

    }
}
