package Task;

import Enum.TypeTask;
import Exception.IncorrectArgumentException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator = 0;
    private String title;
    private TypeTask type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;

    public Task() {
        idGenerator++;
        id = idGenerator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeTask getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate localDate);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return String.format("id: %d, тип: %s, заголовок: %s, описание: %s, дата и время: %s", id, type, title,
                description, InputUtils.dateTimeToString(getDateTime()));
    }
    public void askData() throws IncorrectArgumentException {
        System.out.println("Пожалуйста, выберите тип задачи:");
        for (TypeTask taskType : TypeTask.values()) {
            System.out.println(taskType);
        }
        type = TypeTask.valueOf(InputUtils.askString("Ваш выбор").toUpperCase());
        title = InputUtils.askString("Загаловок");
        if (title == null || title.isBlank() || title.isEmpty()) {
            throw new IncorrectArgumentException("Введите корректный заголовок");
        }
        description = InputUtils.askString("Введите описание");
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new IncorrectArgumentException("Введите корректное описание");
        }
        dateTime = InputUtils.askDataTime("Укажите дату и время");
    }

}
