package sukhov.danila;

import sukhov.danila.service.CalendarCreator;
import sukhov.danila.store.CurrentYear;

import java.io.IOException;
import java.time.Month;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите год (в формате: '2025') : ");
        Scanner scanner = new Scanner(System.in);
        int year;
        try{
            year = scanner.nextInt();
            if(year < 1600){
                throw new IllegalArgumentException("Год должен быть больше 1600");
            }
        }catch (NumberFormatException e){
            System.out.println("Нужно ввести год");
            return;
        }catch (IllegalArgumentException e){
            System.out.println("Ошибка :  " + e.getMessage());
            return;
        }
        CalendarCreator calendarCreator = new CalendarCreator();
        CurrentYear currentYear = calendarCreator.generateCalendar(year);
        System.out.println(currentYear);
    }
}