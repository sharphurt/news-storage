package ru.sharphurt.newsstorage.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeDeserializer extends JsonDeserializer<java.time.LocalDateTime> {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

    @Override
    public java.time.LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateString = p.getText();
        return java.time.LocalDateTime.parse(dateString, dateFormat);
    }
}