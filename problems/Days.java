package problems;

import java.util.Scanner;

public class Days {

    // Date form YYYY-MM-DD
    public int [] getDateParts(String d) {
        String[] parts = d.split("-");
        int [] values = new int[3];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Integer.parseInt(parts[i]);
        }
        return values;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getMonthDays(int month, int year) {
        if(month == 2) {
            if(isLeapYear(year)) {
                return 29;
            }
            else {
                return 28;
            }
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        else {
            return 31;
        }
    }

    public int daysFromStartOfYear(int [] d) {
        int days = 0;
        for (int i = 1; i < d[1]; i++) {
            days += getMonthDays(i, d[0]);
        }
        return days + d[2] + 1;
    }

    public int daysToEndOfYear(int [] d) {
        int days = 0;
        for(int i = d[1]+1; i <= 12; i++) {
            days += getMonthDays(i, d[0]);
        }
        days += getMonthDays(d[1], d[0]) - d[2] - 1;
        return days;
    }

    public int daysTillEndOfMonth(int y, int m, int d) {
        int monthDays = getMonthDays(m, y);
        return monthDays - d;
    }

    public int daysFromMonthToMonth(int m1, int m2, int y) {
        int days = 0;
        for(int i = m1; i <= m2; i++) {
            days += getMonthDays(i, y);
        }
        return days;
    }

    public int daysFromYearToYear(int y1, int y2) {
        int days = 0;
        for(int i = y1; i <= y2; i++) {
            if(isLeapYear(i)) {
                days += 366;
            }
            else {
                days += 365;
            }
        }
        return days;
    }

    // Date form YYYY-MM-DD
    public int daysBetweenDates(String date1, String date2) {
        int [] d1 = getDateParts(date1);
        int [] d2 = getDateParts(date2);
        int days = 0;
        if(d1[0] == d2[0]) {

        }
        if(date1.compareTo(date2) == 0) {  // Same day
            return 0;
        }
        else if(d1[1] == d2[1] && d1[0] == d2[0]) {  // Same month and year
            return Math.abs(d1[2] - d2[2]);
        }
        else if(d1[0] == d2[0]) {  // Same year
            if(date1.compareTo(date2) < 0) {
                days += daysTillEndOfMonth(d1[0], d1[1], d1[2]);
                days += d2[2];
                days += daysFromMonthToMonth(d1[1]+1, d2[1]-1, d2[0]);
            }
            else {
                days += daysTillEndOfMonth(d2[0], d2[1], d2[2]);
                days += d1[2];
                days += daysFromMonthToMonth(d2[1]+1, d1[1]-1, d2[0]);
            }

        }
        else if(date1.compareTo(date2) < 0) {  // date1 less than date2
            days += daysToEndOfYear(d1);
            System.out.println(days);
            days += daysFromStartOfYear(d2);
            System.out.println(days);
            days += daysFromYearToYear(d1[0]+1, d2[0]-1);
        }

        else {  // date1 greater than date2
            days += daysToEndOfYear(d2);
            days += daysFromStartOfYear(d1);
            days += daysFromYearToYear(d2[0]+1, d1[0]-1);
        }

        return days;
    }

    public static void main(String[] args) {
        Days days = new Days();
        Scanner in = new Scanner(System.in);
        String d1 = in.nextLine();
        String d2 = in.nextLine();
        System.out.println(days.daysBetweenDates(d1, d2));
    }
}
