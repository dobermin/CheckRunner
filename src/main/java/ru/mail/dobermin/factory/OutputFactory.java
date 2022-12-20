package ru.mail.dobermin.factory;

import ru.mail.dobermin.enums.OutputTypes;
import ru.mail.dobermin.service.CheckDecorator;
import ru.mail.dobermin.utils.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record OutputFactory(CheckDecorator checkDecorator) {

    public OutputFactory print(OutputTypes outputTypes) {
        switch (outputTypes) {
            case CONSOLE -> toConsole();
            case FILE -> toFile();
        }

        return this;
    }

    private String getHead() {
        return String.format(
                "%19s\n%20s\n%19s\n%s\n%s\n",
                "CASH RECEIPT",
                "SUPERMARKET 123",
                "12, MILKYWAY",
                "---------------------------",
                "QTY DESCRIPTION PRICE TOTAL"
        );
    }

    private String getBottom() {
        return String.format(
                "%s\n%s%23.7s\n%s%18.7s\n%s%21.7s",
                "===========================",
                "SUM", checkDecorator.getTotal(),
                "DISCOUNT", checkDecorator.getDiscount(),
                "TOTAL", Utils.format(checkDecorator.getTotal() - checkDecorator.getDiscount())
        );
    }

    private String output() {
        return getHead() +
                checkDecorator.output() +
                getBottom();
    }

    private void toConsole() {
        System.out.println(output());
    }

    private void toFile() {
        String fileName = "check.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8));
            writer.write(output());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
