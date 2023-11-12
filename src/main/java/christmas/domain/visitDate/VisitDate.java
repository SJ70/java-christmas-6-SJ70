package christmas.domain.visitDate;

import static christmas.domain.visitDate.ErrorMessages.NON_EXISTENT_DATE;

import java.time.DateTimeException;
import java.time.LocalDate;

public class VisitDate {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;

    private final LocalDate date;

    private VisitDate(LocalDate date) {
        this.date = date;
    }

    public static VisitDate fromDay(int day) {
        try {
            return new VisitDate(LocalDate.of(YEAR, MONTH, day));
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(NON_EXISTENT_DATE.getMessage());
        }
    }

    public LocalDate getDate() {
        return date;
    }

}
