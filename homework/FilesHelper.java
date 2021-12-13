package com.galeeva.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public final class FilesHelper {

    private final static String COMMA_DELIMITER = ",";

    private FilesHelper() {
    }

    public static Map<String, Item> convertToMapFirstFile(Path path) throws IOException {
        Map<String, Item> itemMap = new LinkedHashMap<>();
        try (BufferedReader csvReader = Files.newBufferedReader(path)) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] values = row.split(COMMA_DELIMITER);
                Item item = new Item(values[0], values[1]);
                itemMap.put(item.getId(), item);
            }
        }
        return itemMap;
    }

    public static Map<String, Item> convertToMapSecondFile(Path path, Map<String, Item> itemMap) throws IOException {
        Map<String, Item> map = new LinkedHashMap<>();
        try (BufferedReader csvReader = Files.newBufferedReader(path)) {
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] values = row.split(COMMA_DELIMITER);
                Item item = new Item(values[0], values[1], values[2]);
                String price = itemMap.get(item.getId()).getPrice();
                Item item1 = new Item(values[0], values[1], price);
                map.put(item.getId(), item1);
            }
        }
        return map;
    }

    public static List<String> writeCSV(Map<String, Item> itemMap) {
        return itemMap.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(toList());
    }
}




