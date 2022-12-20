package ru.mail.dobermin.entity;

import ru.mail.dobermin.DTO.DiscountCard;
import ru.mail.dobermin.DTO.Product;
import ru.mail.dobermin.service.Check;
import ru.mail.dobermin.utils.Utils;

public class Purchase implements Check {

    private Product product;
    private int count;
    private double total;
    private DiscountCard card;
    private double discount = 0;

    @Override
    public String toString() {
        return "Purchase{" +
                ", product=" + product +
                ", count=" + count +
                ", total=" + total +
                ", card=" + card +
                ", discount=" + discount +
                '}';
    }

    public double getTotal() {
        return total;
    }

    @Override
    public double getDiscount() {
        return Utils.format(discount * getTotal() / 100);
    }

    @Override
    public String output() {
        StringBuilder builder = new StringBuilder();
        String str = String.format(
                "%-4s%-12s%s%6.5s\n",
                count, product.getProduct(), product.getPrice(), getTotal()
        );
        builder.append(str);

        if (discount != 0) {
            String discount = String.format(
                    "%26.6s\n",
                    getDiscount() * -1
            );
            builder.append(discount);
        }

        return builder.toString();
    }

    public static class Builder {

        private final Purchase purchase;

        public Builder() {
            purchase = new Purchase();
        }

        public Builder withProduct(Product product) {
            purchase.product = product;
            return this;
        }

        public Builder withDiscountCard(DiscountCard discountCard) {
            purchase.card = discountCard;
            return this;
        }

        public Builder withCount(int count) {
            purchase.count = count;
            return this;
        }

        public Purchase build() {
            purchase.total = purchase.product.getPrice() * purchase.count;
            if (purchase.card != null)
                purchase.discount = purchase.card.getPercent();
            if (purchase.count > 5)
                purchase.discount += 10;
            return purchase;
        }
    }
}
