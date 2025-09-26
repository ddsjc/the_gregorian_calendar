package sukhov.danila.service;
import sukhov.danila.store.CurrentYear;
import sukhov.danila.store.DayOfWeek;
import sukhov.danila.store.MonthOfYear;
import sukhov.danila.store.WeekOfMonth;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public class CalendarCreator {
    public CurrentYear generateCalendar(int year){
        List<MonthOfYear> months = new ArrayList<>();
        for(Month month : Month.values()){
            months.add(createMonth(year, month));
        }
        return new CurrentYear(year, months);
    }
    public MonthOfYear createMonth(int year, Month month){
        boolean isLeap = Year.isLeap(year);
        int lengthOfMonth = month.length(isLeap);

        List<WeekOfMonth> weeks = new ArrayList<>();
        List<DayOfWeek> currentWeek = new ArrayList<>();

        LocalDate firstDayOfMonth= LocalDate.of(year, month, 1);
        int shift = firstDayOfMonth.getDayOfWeek().getValue() - 1;

        for(int i = 0; i < shift ; i++ ){
            currentWeek.add(new DayOfWeek(0, " "));
        }

        for(int day = 1; day <= lengthOfMonth; day++){
            LocalDate date = LocalDate.of(year, month, day);
            currentWeek.add(new DayOfWeek(day, date.getDayOfWeek().toString()));

            if(currentWeek.size() == 7){
                weeks.add(new WeekOfMonth(new ArrayList<>(currentWeek)));
                currentWeek = new ArrayList<>();
            }
        }

        if(!currentWeek.isEmpty()){
            while (currentWeek.size() < 7){
                currentWeek.add(new DayOfWeek(0, " "));
            }
            weeks.add(new WeekOfMonth(currentWeek));
        }

        return new MonthOfYear(month.name(), weeks);
    }

}
