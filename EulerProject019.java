/*
 * Counting Sundays
 * Problem 19
 * 
 * You are given the following information, but you may prefer to do some research for yourself.
 *           1 Jan 1900 was a Monday.
 *           Thirty days has September,
 *           April, June and November.
 *           All the rest have thirty-one,
 *           Saving February alone,
 *           Which has twenty-eight, rain or shine.
 *           And on leap years, twenty-nine.
 *           A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
package number;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CountingSundays {
	public static int calculateWeek(int year, int month, int date){
		// Zeller's congruence
		if(month <= 2){
			month += 12;
			year--;
		}
		int c = year/100;
		int y = year%100;
		int w = c/4-2*c+y+y/4+13*(month+1)/5+date-1;
		w = (w%7 + 7)%7;
		return w;
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		int count = 0;
		for(int i = 1901; i <= 2000; i++)
			for(int j = 1; j <= 12; j++)
				if(calculateWeek(i, j, 01) == 0)
					count++;
		System.out.println(count);
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}
/*	public static void calculateSuns(Date start, Date end){
		Calendar startCalDate = Calendar.getInstance();
		startCalDate.setTime(start);
		Calendar endCalDate = Calendar.getInstance();
		endCalDate.setTime(end);
		int isSunday;
		int count = 0;
		while(startCalDate.before(endCalDate)){
			isSunday = startCalDate.get(Calendar.DAY_OF_WEEK);
			if(isSunday == 1)
				count++;
			startCalDate.add(Calendar.MONTH, 1);
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		long start = System.nanoTime();
		Calendar startDate = Calendar.getInstance();
		startDate.set(Calendar.YEAR, 1901);
		startDate.set(Calendar.MONTH, 0);
		startDate.set(Calendar.DATE, 1);
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, 2000);
		endDate.set(Calendar.MONTH, 11);
		endDate.set(Calendar.DATE, 31);
		calculateSuns(startDate.getTime(), endDate.getTime());
		long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
	}*/
/*	public static void main(String[] args) {
		long start = System.nanoTime();
        GregorianCalendar gc = new GregorianCalendar(1, Calendar.JANUARY, 1900);
        int count = 0;
        for (int i = 1901; i < 2001; i++) {
            gc.set(GregorianCalendar.YEAR, i);
            for (int j = 0; j < 12; j++) {
                gc.set(GregorianCalendar.MONTH, j);
                if (gc.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
                    count++;
                }
            }
        }
        System.out.println(count);
        long time = System.nanoTime() - start;
		System.out.println("Runtime is " + time/1000/1000.0 + " ms.");
    }*/
}
