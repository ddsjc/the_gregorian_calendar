import org.junit.jupiter.api.Test;
import sukhov.danila.service.CalendarCreator;
import sukhov.danila.store.CurrentYear;
import sukhov.danila.store.DayOfWeek;
import sukhov.danila.store.MonthOfYear;
import sukhov.danila.store.WeekOfMonth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalendarCreatorTest {
    @Test
    void testJanuaryFirstDay(){
        CalendarCreator creator = new CalendarCreator();
        CurrentYear year = creator.generateCalendar(2025);
        MonthOfYear month = year.getMonthsOfYear().stream().filter(m -> m.getNameOfMonth().equals("JANUARY")).findFirst().orElseThrow();
        WeekOfMonth weekOfMonth = month.getWeeks().get(0);
        DayOfWeek firstDay = weekOfMonth.getDays().get(2);
        assertEquals(1, firstDay.getDayOfMonth(), "Первый день должен быть 1");
    }
    @Test
    void testFebruaryLength(){
        CalendarCreator creator = new CalendarCreator();
        CurrentYear year = creator.generateCalendar(2025);
        MonthOfYear month = year.getMonthsOfYear().stream().filter(m -> m.getNameOfMonth().equals("FEBRUARY")).findFirst().orElseThrow();
        long countsDays = month.getWeeks().stream().flatMap(w -> w.getDays().stream()).filter(d -> d.getDayOfMonth() != 0).count();
        assertEquals(28, countsDays, "В Феврале 28 дней");
    }
    @Test
    void testFebruaryLeapYear(){
        CalendarCreator creator = new CalendarCreator();
        CurrentYear year = creator.generateCalendar(2024);
        MonthOfYear month = year.getMonthsOfYear().stream().filter(m -> m.getNameOfMonth().equals("FEBRUARY")).findFirst().orElseThrow();
        long countsDays = month.getWeeks().stream().flatMap(w -> w.getDays().stream()).filter(d -> d.getDayOfMonth() != 0).count();
        assertEquals(29, countsDays, "В Феврале 28 дней");
    }
    @Test
    void testAllMonthsHaveWeeks() {
        CalendarCreator creator = new CalendarCreator();
        CurrentYear year = creator.generateCalendar(2025);
        assertEquals(12, year.getMonthsOfYear().size(), "Должно быть 12 месяцев");

        year.getMonthsOfYear().forEach(month -> {
            assertFalse(month.getWeeks().isEmpty(), "Каждый месяц должен содержать хотя бы одну неделю");
        });
    }
}
