package Task;

import java.time.LocalDate;

public class YearlyTask extends Task {//Ежегодное задание
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfYear() == getDateTime().toLocalDate().getDayOfYear();
    }
}
