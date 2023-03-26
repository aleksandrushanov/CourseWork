package Task;

import Enum.*;
import Exception.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Set<Task> removedTasks = new HashSet<>();

   public void add(TaskPeriodicity taskPeriodicity) throws IncorrectArgumentException{//добавление задачи
       var tp = taskPeriodicity.createTask();
       tp.askData();
       taskMap.putIfAbsent(tp.getId(), tp);
       System.out.println("Созданна задача: "+ tp);
   }
   public void removal(int id)throws TaskNotFoundException {//Удалаение задачи
       Task task = taskMap.get(id);
       removedTasks.add(task);
       taskMap.values().removeIf(t -> t.getId() == id);
       System.out.println("Задача была удалена \\n" + task);
       if (task == null) {
           throw new TaskNotFoundException("Данной задачи нет " + id);
       }
   }

    public void allTasksByDate(LocalDate localDate) throws TaskNotFoundException {// задачи по дате
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            LocalDate taskDate = taskMap.getValue().getDateTime().toLocalDate();
            if (taskDate.equals(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            } else if (localDate.isAfter(taskDate) && taskMap.getValue().appearsIn(localDate)) {
                System.out.println(taskMap.getKey() + " " + taskMap.getValue());
            } else throw new TaskNotFoundException("На эту дату нет заданий");
        }
    }

    public void listTaskMap() {
        System.out.println("Актульаные задачи:  ");
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            System.out.println(taskMap.getKey() + " " + taskMap.getValue());
        }
    }

}
