package com.galeeva.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Даны два файла в формате CSV.
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую (может использоваться и любой другой символ)
 * перечислены значения. Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля: ID,NAME,PRICE.
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class FilesRunner {

    public static void main(String[] args) throws IOException {
        Path path1 = Path.of("resources", "items-price.csv");
        Path path2 = Path.of("resources", "items-name.csv");
        Map<String, Item> newMap = FilesHelper.convertToMapSecondFile(path2, FilesHelper.convertToMapFirstFile(path1));

        Path resultPath = Path.of("resources", "result.csv");
        Files.write(resultPath, FilesHelper.writeCSV(newMap));
    }
}
