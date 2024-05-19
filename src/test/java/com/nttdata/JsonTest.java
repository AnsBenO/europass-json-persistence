package com.nttdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.nttdata.pojos.Author;
import com.nttdata.pojos.Book;
import com.nttdata.pojos.DayTestCasePojo;
import com.nttdata.pojos.SimpleTestCaseJsonPojo;
import com.nttdata.utils.JSON;

public class JsonTest {
    String dayScenario1 = """
            {
                "date": "2024-12-25",
                "name": "christmas day"
            }
                """;

    String simpleTestCaseJsonSource = "{\"message\":\"hello world\", \"code\":200}";

    String authorBooksScenario = """
            {
                "name": "John Doe",
                "books": [
                    {
                        "title": "Book 1",
                        "inPrint": true,
                        "publishDate": "2020-01-01"
                    },
                    {
                        "title": "Book 2",
                        "inPrint": false,
                        "publishDate": "2019-06-09"
                    },
                    {
                        "title": "Book 3",
                        "inPrint": true,
                        "publishDate": "2016-03-01"
                    }
                ]
            }
                            """;

    @Test
    public void parse() throws IOException {

        JsonNode jsonNode = JSON.parse(simpleTestCaseJsonSource);
        String asText = jsonNode.get("message").asText();
        assertEquals("hello world", asText);
    }

    @Test
    public void fromJson() throws IOException {

        JsonNode jsonNode = JSON.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPojo pojo = JSON.fromJson(jsonNode, SimpleTestCaseJsonPojo.class);
        assertEquals("hello world", pojo.getMessage());

    }

    @Test
    public void toJson() throws JsonProcessingException {
        String testMessage = "hello again!!";
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setMessage(testMessage);

        JsonNode node = JSON.toJson(pojo);

        assertEquals(node.get("message").asText(), testMessage);
    }

    @Test
    public void stringify() throws JsonProcessingException {
        String testMessage = "hello again!!";
        String testStringifiedJson = "{\"message\":\"hello again!!\"}";
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setMessage(testMessage);

        JsonNode node = JSON.toJson(pojo);
        String stringifiedNode = JSON.stringify(node);
        // stringifiedNode => "{"message":"hello again!!"}"
        assertEquals(testStringifiedJson, stringifiedNode);
    }

    @Test
    public void prettyStringify() throws JsonProcessingException {
        String testMessage = "hello again!!";
        String testStringifiedJson = "{\r\n" + //
                "  \"message\" : \"hello again!!\"\r\n" + //
                "}";
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setMessage(testMessage);

        JsonNode node = JSON.toJson(pojo);
        String stringifiedNode = JSON.prettyStringify(node);
        assertEquals(testStringifiedJson, stringifiedNode);
    }

    @Test
    public void dayTest() throws IOException {

        JsonNode jsonNode = JSON.parse(dayScenario1);
        DayTestCasePojo pojo = JSON.fromJson(jsonNode, DayTestCasePojo.class);
        LocalDate date = pojo.getDate();
        String dateString = date.toString();
        assertEquals("2024-12-25", dateString);

    }

    @Test
    public void authorBooksTest() throws IOException {

        JsonNode jsonNode = JSON.parse(authorBooksScenario);
        Author author = JSON.fromJson(jsonNode, Author.class);
        System.out.println("[Author]: " + author);
        List<Book> books = author.getBooks();
        books.forEach(System.out::println);

    }

}
