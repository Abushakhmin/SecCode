package com.company;

import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Введите аргументы. Пример: /home/roman/workspace/test/first_forder/text /home/roman/workspace/test/second_forder/text1");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);
            // скопировать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Выполнилось копирование. Но это не точно. Проверяй вручную пока");
        }
        catch (InvalidClassException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода вывода " + e);
        }
    }
}
