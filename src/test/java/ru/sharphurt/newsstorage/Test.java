package ru.sharphurt.newsstorage;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        var string = "Thu, 29 Feb 2024 14:28:40 +0300";
        var datetimeFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        var result = ZonedDateTime.parse(string, datetimeFormatter);
    }

}
