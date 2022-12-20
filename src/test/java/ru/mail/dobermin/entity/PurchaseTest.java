package ru.mail.dobermin.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseTest extends AbstractTest {

    @Test
    void getTotal() {
        assertEquals(6, purchase.getTotal());
    }

    @Test
    void getDiscount() {
        assertEquals(0.3, purchase.getDiscount());

        Purchase purchase = new Purchase.Builder()
                .withCount(10)
                .withDiscountCard(discountCard)
                .withProduct(product)
                .build();

        assertEquals(4.5, purchase.getDiscount());
    }
}