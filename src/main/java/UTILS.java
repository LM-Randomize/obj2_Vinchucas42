package main.java;

import java.util.Date;

public final class UTILS {

	//Calcula la diferencia en dias de las fechas que recibe.
	public static long diferenciaDias(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		long diffTime = endTime - startTime;
		long diffDays = diffTime / (1000 * 60 * 60 * 24);
		return diffDays;
	}
}
