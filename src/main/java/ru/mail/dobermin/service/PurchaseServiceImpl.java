package ru.mail.dobermin.service;

import ru.mail.dobermin.DTO.DiscountCard;
import ru.mail.dobermin.DTO.Product;
import ru.mail.dobermin.entity.Purchase;
import ru.mail.dobermin.enums.Message;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseServiceImpl implements PurchaseService {

    private final List<String> args;
    private final Set<Product> products;
    private final Set<DiscountCard> discountCards;
    private DiscountCard card = null;

    public PurchaseServiceImpl(String[] args) {
        products = new ProductServiceImpl().findAll();
        discountCards = new DiscountCardServiceImpl().findAll();
        this.args = Arrays.stream(args).collect(Collectors.toList());
    }

    @Override
    public CheckDecorator getPurchases() {
        CheckDecorator checkDecorator = new CheckDecorator();
        getCard();
        for (String arg : args) {
            List<String> list = List.of(arg.split("-"));
            String productId = list.get(0);
            try {
                Product product = products.stream().filter(p -> ("" + p.getId()).equals(productId)).findFirst().orElseThrow();
                try {
                    Purchase purchase = new Purchase.Builder()
                            .withProduct(product)
                            .withCount(Integer.parseInt(list.get(1)))
                            .withDiscountCard(card)
                            .build();
                    checkDecorator = new CheckDecorator(checkDecorator, purchase);
                } catch (Exception ignored) {
                }
            } catch (Exception e) {
                System.out.printf(Message.PRODUCT_MISS.label, productId);
            }
        }
        return checkDecorator;
    }

    private void getCard() {
        String card = args.stream().filter(s -> s.startsWith("card")).findFirst().orElse(null);
        if (card == null) return;
        List<String> list = List.of(card.split("-"));
        String cardId = list.get(1);
        try {
            args.remove(card);
            this.card = discountCards.stream().filter(discountCard -> Objects.equals(cardId, "" + discountCard.getNumber())).findFirst().orElseThrow();
        } catch (Exception e) {
            System.out.printf(Message.CARD_MISS.label, list.get(1));
        }
    }
}
