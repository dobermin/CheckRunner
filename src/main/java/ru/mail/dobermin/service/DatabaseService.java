package ru.mail.dobermin.service;

import java.io.IOException;
import java.util.Set;

public interface DatabaseService<T> {

    Set<T> findAll() throws IOException;
}
