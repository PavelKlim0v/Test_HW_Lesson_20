package runner;

import crud.*;
import java.util.Scanner;

/**
 *  Задание 1. (Основное задание)
 * 	  Домашнее задание с дедлайном до субботы вечера:
 *    Скачать и установить СУБД MySQL. Создать таблицу с данными студентов группы.
 *    Создать Java приложение для получения списка всех студентов группы.
 *
 *  Задание 2. (Дополнительное задание)
 *    Улучшить основное задание. Создать таблицу с городами, где живут студенты.
 *    Вывести информацию о каждом студенте группы и его родном городе.
 *    Предусмотреть операции добавления новых городов, новых студентов, удаления студентов и удаления городов.
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in);    // самый обычный сканнер

    public static String scanner() {    // теперь сканнер вызывается так: Main.scanner();  и всё.
        String str = scanner.next();
        return str;
    }

    public static void main(String[] args) {
        CRUD crud = new CRUD();

        crud.createStudent();   // добавление студента в бд
        crud.getAllStudents();  // вывод списка студентов в консоль
        crud.deleteStudent();   // удаление студенто по id из бд

        scanner.close();
    }

}
