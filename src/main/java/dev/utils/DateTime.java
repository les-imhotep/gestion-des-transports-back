package dev.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
	
	public static LocalDateTime dateEtHeureToLocalDateTime (String date, String heure) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(date).append(" ").append(heure).toString();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime dateTime = LocalDateTime.parse(stringBuilder, formatter);
		
		
		return dateTime;
		
	}

}
