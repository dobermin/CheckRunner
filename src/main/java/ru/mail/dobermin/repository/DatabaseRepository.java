package ru.mail.dobermin.repository;

import ru.mail.dobermin.factory.Database;

import java.io.IOException;
import java.util.Set;

public interface DatabaseRepository {

    Set<Database> load() throws IOException;
}
