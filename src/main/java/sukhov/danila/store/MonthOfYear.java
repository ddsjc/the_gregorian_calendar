package sukhov.danila.store;

import java.util.List;

public class MonthOfYear {
    private final String nameOfMonth;
    private final List<WeekOfMonth> weeks;

    public MonthOfYear(String nameOfMonth, List<WeekOfMonth> weeks) {
        this.nameOfMonth = nameOfMonth;
        this.weeks = weeks;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public List<WeekOfMonth> getWeeks() {
        return weeks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(nameOfMonth + ":\n");
        stringBuilder.append("Пн Вт Ср Чт Пт Сб Вс\n");
        for (WeekOfMonth week : weeks){
            stringBuilder.append(week).append("\n");
        }
        return stringBuilder.toString();
    }
}
