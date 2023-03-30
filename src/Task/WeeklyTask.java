package Task;

import java.time.LocalDate;

public class WeeklyTask extends Task {//Еженедельное задание
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfWeek() == getDateTime().toLocalDate().getDayOfWeek();
    }
}
