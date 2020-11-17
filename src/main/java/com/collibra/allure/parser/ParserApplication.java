package com.collibra.allure.parser;

import com.collibra.allure.parser.model.AllureEntry;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@SpringBootApplication
public class ParserApplication implements CommandLineRunner {

    public static final String SEPARATOR = "\t";

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static void main(String[] args) {
        SpringApplication.run(ParserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Path path = Paths.get("./allure-maintenance-1030.csv");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bufferedWriter.append(AllureEntry.getHeaders());
            bufferedWriter.newLine();

            Files.list(Paths.get("/Users/izio/Downloads/allure-report 2/data/test-cases"))
                    .map(this::parse)
                    .forEach(item -> writeLine(bufferedWriter, item));
        }
        System.out.println("please open file " + path.toAbsolutePath().toString());


    }

    private void writeLine(BufferedWriter bufferedWriter, AllureEntry item) {
        try {
            bufferedWriter.append(item.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }


    private AllureEntry parse(Path path) {
        try {
            return objectMapper.readValue(path.toFile(), AllureEntry.class);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
