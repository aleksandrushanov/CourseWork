package Task;

import java.time.LocalDate;

public class OneTimeTask extends Task {//Одноразовая задача
    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate == getDateTime().toLocalDate();
    }
}
