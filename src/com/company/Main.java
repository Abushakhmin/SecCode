package com.company;

import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        // Если аргументов не равно 3, то выводим сообщение
        if (args.length != 3) {
            System.out.println("Введите аргументы. Пример: cp /home/roman/workspace/test/first_forder/text /home/roman/workspace/test/second_forder/text1");
            return;
        }

        if (args[0].equals("cp")) {
            copyFile(args[0], args[1], args[2]);
        }

        if (args[0].equals("mv")) {
            catFile(args[0], args[1], args[2]);
        }

        if (args[0].equals("rm")) {
            delFile(args[1]);
        }
    }

    private static void copyFile(String arg, String arg1, String arg2){
        try {
            System.out.println("Получена команда " + arg + " Выполняем копирование....");
            Path source = Paths.get(arg1);
            Path target = Paths.get(arg2);
            // скопировать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Выполнилось копирование. Но это не точно. Проверяй вручную пока");
        }
        // Исключения
        catch (InvalidClassException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода вывода " + e);
        }
    }

    private static void catFile(String arg, String arg1, String arg2){
        try {
            System.out.println("Получена команда " + arg + " Выполняем перемещение....");
            Path source = Paths.get(arg1);
            Path target = Paths.get(arg2);
            // переместить\вырезать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Выполнилось копирование. Но это не точно. Проверяй вручную пока");

            delFile(String.valueOf(source));

            System.out.println("Готово!!! Файл перемещен!");
        }
        // Исключения
        catch (InvalidClassException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода вывода " + e);
        }
    }

    private static void delFile(String arg){

        Path del = Paths.get(arg);

        System.out.println("Выполняется удаление....");
        try {
            Files.delete(del);

        }

        catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", del);
        }

        catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", del);
        }

        catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }
}