package ru.mail.dobermin.DTO;

import ru.mail.dobermin.factory.Database;

import java.util.Objects;

public class DiscountCard implements Database {

    private int id;
    private int number;
    private double percent;

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public double getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number=" + number +
                ", percent=" + percent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return id == that.id && number == that.number && Double.compare(that.percent, percent) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, percent);
    }
}
