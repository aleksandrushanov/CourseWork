package Task;

import java.time.LocalDate;

public class MonthlyTask extends Task {//Ежемесячное задание
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().toLocalDate().getDayOfMonth();
    }
}
