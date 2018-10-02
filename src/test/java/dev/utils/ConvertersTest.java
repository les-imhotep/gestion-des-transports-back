package dev.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.Test;

public class ConvertersTest {

	@Test
	public void LOCALDATETIME_TO_STRING_TIME() {
		
		LocalDateTime dateTime = LocalDateTime.of(2018, 10, 2, 9, 41);
		
		
		String heure = Converters.LOCALDATETIME_TO_STRING_TIME.convert(dateTime);
		
		
		assertThat(heure).isEqualTo("09:41");
		
	}
	
	@Test
	public void LOCALDATETIME_TO_STRING_DATE() {
		
		LocalDateTime dateTime = LocalDateTime.of(2018, 10, 2, 9, 41);
		
		
		String date = Converters.LOCALDATETIME_TO_STRING_DATE.convert(dateTime);
		
		
		assertThat(date).isEqualTo("2018-10-02");
		
	}

	
	
	
	
	
	
	

}
