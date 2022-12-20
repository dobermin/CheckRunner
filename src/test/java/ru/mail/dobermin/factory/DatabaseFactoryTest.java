package ru.mail.dobermin.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.mail.dobermin.DTO.Product;
import ru.mail.dobermin.utils.Mapper;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseFactoryTest {

    private Mapper.Builder mock;

    @BeforeEach
    void setUp() {
        mock = Mockito.mock(Mapper.Builder.class);

        Product product = new Product();
        product.setId(10);
        product.setProduct("Хлеб");
        product.setPrice(1.2);

        Mockito.when(mock.build()).thenReturn(Collections.singleton(product));
    }

    @Test
    void get() {
        assertEquals(1, mock.build().size());
        Database database = mock.build().stream().findFirst().orElse(null);
        assertNotNull(database);
        Product product = (Product) database;
        assertEquals(10, product.getId());
        assertEquals("Хлеб", product.getProduct());
        assertEquals(1.2, product.getPrice());
    }
}