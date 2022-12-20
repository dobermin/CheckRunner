package ru.mail.dobermin;

import ru.mail.dobermin.enums.OutputTypes;
import ru.mail.dobermin.factory.OutputFactory;
import ru.mail.dobermin.service.CheckDecorator;
import ru.mail.dobermin.service.PurchaseServiceImpl;

public class CheckRunner {

    public static void main(String[] args) {

        CheckDecorator decorator = new PurchaseServiceImpl(args).getPurchases();
        new OutputFactory(decorator).print(OutputTypes.CONSOLE).print(OutputTypes.FILE);
    }
}
