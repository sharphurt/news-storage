package ru.sharphurt.newsstorage.constants;

public class AliasConstants {
    public static final String EXCEPTION_MESSAGE_BASE = "Exception during request execution: %s | ";
    public static final String EXCEPTION_EMPTY_DATABASE = EXCEPTION_MESSAGE_BASE + "Database is empty";
    public static final String EXCEPTION_ENTITY_NOT_FOUND = EXCEPTION_MESSAGE_BASE + "Entity with id [%s] not found";
    public static final String EXCEPTION_PARSE_RSS_FEED = EXCEPTION_MESSAGE_BASE + "Cannot parse RSS item: %s";

    public static final String LOG_REQUEST_RECEIVED = "Request received: %s | ";


    public static final String LOG_REQUEST_PROCESSED = "Request processed: %s | ";


    public static final String LOG_WARN_ITEM_NOT_PARSED = "Item's publication date [%s] cannot be parsed. Item skipped";

}
