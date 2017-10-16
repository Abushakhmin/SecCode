package com.company;

import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        switch(args[0]) {

            case "cp":
                System.out.println("Запуск копирования...");
                Cop.onCop(args[1], args[2]);
                System.out.println("Аргумент: " + args[1] + " Скопирован в: " + args[2]);
                break;

            case "rm":
                System.out.println("Запуск удаления...");
                Del.onDel(args[1]);
                System.out.println("Аргумент: " + args[1] + " удален");
                break;

            case "mv":
                System.out.println("Запуск перемещения или переименования...");
                Cat.onCat(args[1], args[2]);
                System.out.println("Итоговый результат: " + args[2]);
                break;

            case "ll":
                System.out.println("Выводим список каталогов и файлов...");
                Lis.onLis(args[1]);
                System.out.println("Конец");
                break;

            case "mkdir":
                System.out.println("Создаем директорию...");
                Dir.onDir(args[1]);
                System.out.println("Конец");
                break;

            case "file":
                System.out.println("Создаем файл...");
                Fil.onFil(args[1]);
                System.out.println("Конец");
                break;

            default:
                System.out.println("Ошибка в команде...");
        }
    }
}

class Cop extends Main {

    static void onCop(String arg1, String arg2){
        try {
            Path source = Paths.get(arg1);
            Path target = Paths.get(arg2);
            // скопировать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }

        catch (InvalidClassException e) {
                System.out.println("Ошибка указания пути " + e);
        }

        catch (IOException e) {
                System.out.println("Ошибка ввода вывода " + e);
        }
    }
}

class Del extends Main {

    static void onDel(String arg1) {

        Path del = Paths.get(arg1);

        try {
            Files.delete(del);

        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", del);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", del);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
    }
}

class Cat extends Main {

    static void onCat(String arg1, String arg2){
        try {

            Path source = Paths.get(arg1);
            Path target = Paths.get(arg2);

            // переместить\вырезать файл
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            Del.onDel(String.valueOf(source));

        }
        // Исключения
        catch (InvalidClassException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода вывода " + e);
        }
    }
}

class Lis extends Main {


    static void onLis(String arg1){

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(arg1))) {
            for (Path file: stream) {
                if(!file.toFile().isDirectory() ) {
                    System.out.println(file.getFileName());
                }
            }
        } catch (IOException | DirectoryIteratorException x) {
                System.err.println(x);
        }
    }
}

class Dir extends Main {

    static void onDir(String arg1) {
        Path path = Paths.get(arg1);

        try {
            Files.createDirectory(path);
        }

        catch (FileAlreadyExistsException e){
            // the directory already exists.
        }

        catch (IOException e) {
            //something else went wrong
        e.printStackTrace();
        }
    }
}

class Fil extends Main {

    static void onFil(String arg1) {
        File filPath = new File(arg1);
        filPath.mkdir();

        try {
            filPath.createNewFile();
        }

        catch (IOException e) {
                e.printStackTrace();
        }
    }
}

