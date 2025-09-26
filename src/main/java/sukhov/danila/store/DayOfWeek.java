package sukhov.danila.store;

public class DayOfWeek {
    private final int dayOfMonth;
    private final  String dayOfWeek;

    public DayOfWeek(int dayOfMonth, String dayOfWeek) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toString(){
        return dayOfMonth == 0? "   " : String.format("%2d ", dayOfMonth);
    }
}
