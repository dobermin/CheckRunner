package ru.mail.dobermin.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import ru.mail.dobermin.enums.Message;
import ru.mail.dobermin.factory.Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mapper {

    private String fileName;
    private Class clazz;

    public static class Builder {

        private final Mapper mapper;

        public Builder() {
            mapper = new Mapper();
        }

        public Builder withFileName(String fileName) {
            mapper.fileName = fileName;
            return this;
        }

        public Builder withClass(Class clazz) {
            mapper.clazz = clazz;
            return this;
        }

        public Set<Database> build() {
            String fileName = mapper.fileName + ".json";
            try {
                try (
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)), StandardCharsets.UTF_8));
                ) {
                    ObjectMapper m = new ObjectMapper();
                    CollectionType collectionType = m.getTypeFactory().constructCollectionType(HashSet.class, mapper.clazz);

                    return m.readValue(bufferedReader, collectionType);
                }
            } catch (Exception e) {
                System.out.printf(Message.FILE_MISS.label, fileName);
            }
            return null;
        }
    }
}
