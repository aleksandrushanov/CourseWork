package Task;

import java.time.LocalDate;

public class DailyTask extends Task {// Ежедневная задача
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return true;
    }

}
