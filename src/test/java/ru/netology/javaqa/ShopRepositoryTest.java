package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void deleteProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "клавиатура", 10_000);
        Product product2 = new Product(2, "мышка", 9_000);
        Product product3 = new Product(3, "монитор", 20_000);
        Product product4 = new Product(4, "колонки", 8_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void noDeleteProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "клавиатура", 10_000);
        Product product2 = new Product(2, "мышка", 9_000);
        Product product3 = new Product(3, "монитор", 20_000);
        Product product4 = new Product(4, "колонки", 8_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(5);
        });
    }

    @Test
    public void addNewProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "клавиатура", 10_000);
        Product product2 = new Product(2, "мышка", 9_000);
        Product product3 = new Product(3, "монитор", 20_000);
        Product product4 = new Product(4, "колонки", 8_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addRepeatedProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "клавиатура", 10_000);
        Product product2 = new Product(2, "мышка", 9_000);
        Product product3 = new Product(3, "монитор", 20_000);
        Product product4 = new Product(4, "колонки", 8_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product4);
        });
    }

}