package dev.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * @author diginamic09
 *
 */
public class DateTimeTest {

	@Test
	public void DateEtHeureToLocalDateTime() {
		
		String heure = "09:41";
		String date = "2018-10-02";
		
		LocalDateTime localDateTime = DateTime.dateEtHeureToLocalDateTime(date, heure);
		
		assertThat(localDateTime).isEqualTo("2018-10-02T09:41");
	}

}
