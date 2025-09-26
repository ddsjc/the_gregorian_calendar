package sukhov.danila.store;

import java.util.List;

public class WeekOfMonth {
    private List<DayOfWeek> days;

    public WeekOfMonth(List<DayOfWeek> days) {
        this.days = days;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(DayOfWeek day : days){
            stringBuilder.append(day);
        }
        return stringBuilder.toString();
    }
}
