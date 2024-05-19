package com.nttdata.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSON {
    private JSON() {
    }

    private final static ObjectMapper objectMapper = getDefaulObjectMapper();

    /**
     * Returns a default ObjectMapper instance that is used by all the methods in
     * this class.
     * The ObjectMapper is configured to:
     * 
     * - Register the JavaTimeModule, which enables Jackson to serialize and
     * deserialize Java 8 date and time objects (LocalDate, LocalDateTime,
     * etc.) to/from JSON.
     * - Disable the FAIL_ON_UNKNOWN_PROPERTIES feature, which means that
     * deserialization will not fail if the JSON contains properties that do
     * not correspond to any of the fields in the target class. Instead, these
     * "unknown" properties will be ignored.
     * 
     *
     * @return A default ObjectMapper instance.
     */
    public static ObjectMapper getDefaulObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();

        // Register the JavaTimeModule, which allows Jackson to serialize and
        // deserialize Java 8 date and time objects to/from JSON.
        defaultObjectMapper.registerModule(new JavaTimeModule());

        // Disable the FAIL_ON_UNKNOWN_PROPERTIES feature of the ObjectMapper.
        // This means that deserialization will not fail if the JSON contains
        // properties that do not correspond to any of the fields in the target
        // class. Instead, these "unknown" properties will be ignored.
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return defaultObjectMapper;
    }

    /**
     * Parses a JSON string and returns the resulting JSON tree.
     * 
     * @param src The JSON string to parse.
     * @return The root node of the resulting JSON tree.
     * @throws IOException If there was an error reading from the input source.
     */
    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    /**
     * Converts a {@link JsonNode} to the specified class.
     * 
     * @param <A>   The class type that we want to convert to.
     * @param node  The {@link JsonNode} to convert from.
     * @param clazz The class type that we want to convert to.
     * @return An instance of class A, which was created by deserializing the
     *         {@link JsonNode}.
     * @throws JsonProcessingException  If there was an error during the
     *                                  deserialization process.
     * @throws IllegalArgumentException If the JSON node does not match the
     *                                  structure of the class A.
     */
    public static <A> A fromJson(JsonNode node, Class<A> clazz)
            throws JsonProcessingException, IllegalArgumentException {
        return objectMapper.treeToValue(node, clazz);

    }

    /**
     * Converts a POJO (Plain Old Java Object) to a {@link JsonNode} tree.
     * 
     * @param obj The POJO to convert.
     * @return A {@link JsonNode} tree that represents the structure of the
     *         POJO. The returned JsonNode tree can be used for further
     *         processing, such as serialization to a JSON string or
     *         further transformation using the Jackson ObjectMapper class.
     * 
     */
    public static JsonNode toJson(Object obj) {
        return objectMapper.valueToTree(obj);
    }

    /**
     * Converts a {@link JsonNode} to a JSON string.
     * 
     * @param node The {@link JsonNode} to convert to a JSON string.
     * @return A JSON string that represents the structure of the {@link JsonNode}.
     * @throws JsonProcessingException
     */
    public static String stringify(JsonNode node) throws JsonProcessingException {
        return objectMapper.writeValueAsString(node);
    }

    /**
     * Converts a {@link JsonNode} to a JSON string with pretty printing enabled.
     * 
     * @param node The {@link JsonNode} to convert to a JSON string.
     * @return A JSON string that represents the structure of the {@link JsonNode}.
     *         The returned JSON string will be formatted with line breaks and
     *         whitespace to make it more human-readable. This is useful for
     *         debugging or logging purposes.
     * @throws JsonProcessingException
     */
    public static String prettyStringify(JsonNode node) throws JsonProcessingException {
        return generateString(node, true);
    }

    /**
     * Generates a JSON string from a {@link JsonNode} instance.
     * 
     * @param node   The {@link JsonNode} instance to serialize to a JSON
     *               string.
     * @param pretty A boolean flag indicating whether the generated JSON
     *               string should be formatted with line breaks and
     *               whitespace to make it more human-readable. If this flag is
     *               {@code true}, then the generated JSON string will be
     *               formatted with line breaks and whitespace. If this flag is
     *               {@code false}, then the generated JSON string will not be
     *               formatted.
     * @return A JSON string that represents the structure of the {@link JsonNode}
     *         instance.
     * @throws JsonProcessingException If there was an error during the
     *                                 serialization process. This exception
     *                                 is thrown by the Jackson ObjectMapper
     *                                 class, which is used by this method to
     *                                 perform the serialization.
     */
    private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
        /*
         * Get a reference to the Jackson ObjectWriter instance that will be
         * used to serialize the JsonNode instance.
         */
        ObjectWriter objectWriter = objectMapper.writer();

        /*
         * If the pretty flag is set to true, then configure the
         * ObjectWriter instance to indent the output JSON string.
         */
        if (pretty) {
            objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        }

        /*
         * Serialize the JsonNode instance to a JSON string using the
         * ObjectWriter instance. The ObjectWriter#writeValueAsString method
         */
        return objectWriter.writeValueAsString(node);
    }

}
