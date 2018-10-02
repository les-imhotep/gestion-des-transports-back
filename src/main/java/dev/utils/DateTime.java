package dev.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author diginamic09
 * 
 * Passer d'une date et d'une heure (format String) en LocalDateTime
 *
 */
public class DateTime {
	
	/**
	 * Méthode static pour formatter et parser deux string (front) en LocalDateTime (exploitable en back)
	 * 
	 * @param date
	 * @param heure
	 * @return
	 */
	public static LocalDateTime dateEtHeureToLocalDateTime (String date, String heure) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(date).append(" ").append(heure).toString();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime dateTime = LocalDateTime.parse(stringBuilder, formatter);
		
		
		return dateTime;
		
	}

}
