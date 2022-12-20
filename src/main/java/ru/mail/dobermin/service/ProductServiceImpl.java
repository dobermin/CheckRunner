package ru.mail.dobermin.service;

import ru.mail.dobermin.DTO.Product;
import ru.mail.dobermin.repository.ProductRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    @Override
    public Set<Product> findAll() {
        return new ProductRepository().load()
                .stream().map(database -> (Product) database)
                .collect(Collectors.toSet());
    }
}
