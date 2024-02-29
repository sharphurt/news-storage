package ru.sharphurt.newsstorage.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        var zonedDateTime = ZonedDateTime.ofLocal(localDateTime, ZoneId.of("+03:00"), ZoneOffset.of("+03:00"));
        jsonGenerator.writeString(dateFormat.format(zonedDateTime));
    }
}