package ru.mail.dobermin.factory;

import ru.mail.dobermin.DTO.DiscountCard;
import ru.mail.dobermin.DTO.Product;
import ru.mail.dobermin.enums.DatabaseTypes;
import ru.mail.dobermin.utils.Mapper;

import java.util.Set;

public class DatabaseFactory {

    public Set<Database> get(DatabaseTypes databaseTypes) {
        Set<Database> database = null;
        switch (databaseTypes) {
            case PRODUCT -> database = new Mapper.Builder()
                    .withFileName("products")
                    .withClass(Product.class)
                    .build();
            case DISCOUNT_CARD -> database = new Mapper.Builder()
                    .withFileName("cards")
                    .withClass(DiscountCard.class)
                    .build();
        }
        return database;
    }
}
