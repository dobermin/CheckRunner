package ru.mail.dobermin.repository;

import ru.mail.dobermin.enums.DatabaseTypes;
import ru.mail.dobermin.factory.Database;
import ru.mail.dobermin.factory.DatabaseFactory;

import java.util.Set;

public class DiscountCardRepository implements DatabaseRepository {

    @Override
    public Set<Database> load() {
        return new DatabaseFactory().get(DatabaseTypes.DISCOUNT_CARD);
    }
}
