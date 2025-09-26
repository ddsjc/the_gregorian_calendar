package sukhov.danila.store;

import java.util.List;

public class CurrentYear {
    private final int numberOfYear;
    private final List<MonthOfYear> monthsOfYear;
    public CurrentYear(int numberOfYear, List<MonthOfYear> monthsOfYear) {
        this.numberOfYear = numberOfYear;
        this.monthsOfYear = monthsOfYear;
    }

    public int getNumberOfYear() {
        return numberOfYear;
    }
    public List<MonthOfYear> getMonthsOfYear() {
        return monthsOfYear;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MonthOfYear month : monthsOfYear){
            stringBuilder.append(month).append("\n");
        }
        return stringBuilder.toString();
    }
}
