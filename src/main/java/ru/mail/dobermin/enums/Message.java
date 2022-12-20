package ru.mail.dobermin.enums;

public enum Message {

    PRODUCT_MISS("Продукт с id = %s не найден\n"),
    CARD_MISS("Дисконтная карта с номером = %s не найдена\n"),
    FILE_MISS("Файл %s не существует\n");

    public String label;

    Message(String label) {
        this.label = label;
    }
}
