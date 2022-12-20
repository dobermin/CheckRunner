package ru.mail.dobermin.entity;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import ru.mail.dobermin.DTO.DiscountCard;
import ru.mail.dobermin.DTO.Product;

abstract public class AbstractTest {

    protected Product product;
    protected DiscountCard discountCard;
    protected Purchase purchase;

    @BeforeEach
    void setUp() {

        discountCard = Mockito.mock(DiscountCard.class);
        Mockito.when(discountCard.getId()).thenReturn(1);
        Mockito.when(discountCard.getNumber()).thenReturn(1234);
        Mockito.when(discountCard.getPercent()).thenReturn(5.0);

        product = Mockito.mock(Product.class);
        Mockito.when(product.getPrice()).thenReturn(3.0);
        Mockito.when(product.getProduct()).thenReturn("Вода");
        Mockito.when(product.getId()).thenReturn(20);

        purchase = new Purchase.Builder()
                .withCount(2)
                .withDiscountCard(discountCard)
                .withProduct(product)
                .build();
    }
}
