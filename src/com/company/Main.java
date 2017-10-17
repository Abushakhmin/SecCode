package com.company;

public class Main {

    public static void main(String[] args) {

        int n = args.length;

        if(n == 2 || n == 3) {

            if(n == 2) {

                switch(args[0]) {

                    case "rm":
                        System.out.println("Запуск удаления...");
                        DeleteAll.onDeleteAll(args[1]);
                        System.out.println("Аргумент: " + args[1] + " удален");
                        break;

                    case "ll":
                        System.out.println("Выводим список каталогов и файлов...");
                        ListAll.onListAll(args[1]);
                        System.out.println("Конец");
                        break;

                    case "mkdir":
                        System.out.println("Создаем директорию...");
                        AddDir.onAddDir(args[1]);
                        System.out.println("Конец");
                        break;

                    case "file":
                        System.out.println("Создаем файл...");
                        AddFile.onAddFile(args[1]);
                        System.out.println("Конец");
                        break;

                    default:
                        System.out.println("Ошибка ввода команды!");
                }

            } else {
                switch(args[0]) {

                    case "cp":
                        System.out.println("Запуск копирования...");
                        CopyAll.onCopyAll(args[1], args[2]);
                        System.out.println("Аргумент: " + args[1] + " Скопирован в: " + args[2]);
                        break;

                    case "mv":
                        System.out.println("Запуск перемещения или переименования...");
                        RenameAll.onRenameAll(args[1], args[2]);
                        System.out.println("Итоговый результат: " + args[2]);
                        break;

                    default:
                        System.out.println("Ошибка ввода команды!");
                }
            }
        } else System.out.println("Ошибка ввода аргументов!");
    }
}

