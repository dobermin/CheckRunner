package ru.mail.dobermin.service;

import ru.mail.dobermin.DTO.DiscountCard;
import ru.mail.dobermin.repository.DiscountCardRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class DiscountCardServiceImpl implements DiscountCardService {

    @Override
    public Set<DiscountCard> findAll() {
        return new DiscountCardRepository().load().stream().map(database -> (DiscountCard) database).collect(Collectors.toSet());
    }
}
