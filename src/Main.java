import Task.InputUtils;
import Task.TaskService;

import java.util.Scanner;

import Enum.*;
import Exception.*;

public class Main {
    private static final TaskService taskService = new TaskService();
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Пожалуйста, выберите команду:  ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            allTasksByDate();
                            break;
                        case 4:
                            listTaskMap();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println("Неизвестный пункт меню");
                    }
                } else {
                    scanner.next();
                    System.out.println("Пожалуйста, выберите пункт меню из списка: ");
                }
            }
            System.out.println("До свидания!");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getArgument());
        }
    }

    private static void printMenu() {
        System.out.println("Доступные команды: \n 1. Добавить задачу \n 2. Удалить задачу " +
                "\n 3. Получите задание на указанную дату\n 4. Показать список задач \n " + "0.Выход");
    }
    private static void add() throws IncorrectArgumentException {
        System.out.println("Пожалуйста, выберите периодичность выполнения задания: ");
        for (TaskPeriodicity taskPeriodicity : TaskPeriodicity.values()) {
            System.out.println(taskPeriodicity);
        }
        var strPeriodicity = InputUtils.askString("Ваш выбор: " ).toUpperCase();
        var periodicity = TaskPeriodicity.valueOf(strPeriodicity);
        taskService.add(periodicity);
    }

    private static void remove() throws TaskNotFoundException {
        int id = InputUtils.askInt("Введите идентификатор задачи, которую вы хотите удалить");
        taskService.removal(id);
    }

    private static void allTasksByDate() throws TaskNotFoundException {
        var date = InputUtils.askDate("Пожалуйста, введите дату ");
        taskService.allTasksByDate(date);
    }
    private static void listTaskMap() {
        taskService.listTaskMap();
    }

}