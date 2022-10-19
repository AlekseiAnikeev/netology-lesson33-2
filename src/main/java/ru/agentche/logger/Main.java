package ru.agentche.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 18.10.2022
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        List<Integer> list;
        Scanner scanner = new Scanner(System.in);
        logger.log("Старт приложения");
        logger.log("Приветствуем пользователя, просим ввести размер списка N.");
        int size = valueQuery(scanner, "Привет, введи размер списка");
        logger.log("Просим ввести верхнюю границу значений элементов в списке M.");
        int valueBoundary = valueQuery(scanner, "Ок, теперь введи границу значений элементов в списке");
        logger.log("Создаем список случайностей");
        list = randomList(size, valueBoundary);
        System.out.println("Список случайных чисел " + list);
        logger.log("Просим пользователя ввести входные данные для фильтра");
        list = listFiltering(scanner, list);
        logger.log("Прошло фильтр " + list.size() + " элемента из " + size);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + list);
        logger.log("Завершаем программу");

        scanner.close();
    }

    private static List<Integer> listFiltering(Scanner scanner, List<Integer> source) {
        int treshold = valueQuery(scanner, "Введите порог для фильтра:");
        Logger.getInstance().log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        return filter.filterOut(source);
    }

    private static int valueQuery(Scanner scanner, String message) {
        int value;
        while (true) {
            System.out.println(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                message = "Не корректный ввод, введенный символ не является цифрой";
                Logger.getInstance().log("Не корректный ввод, введенный символ не является цифрой");
            }
        }
    }

    public static List<Integer> randomList(int size, int valueBoundary) {
        List<Integer> randomList = new ArrayList<>();
        IntStream.rangeClosed(1, size).forEach(value -> randomList.add(new Random().nextInt(valueBoundary)));
        return randomList;
    }
}
