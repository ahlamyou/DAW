package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author ahlam
 *
 */
public class FechaUtil implements IDateValidator {
	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");

	public FechaUtil() {

	}

	@Override
	public boolean isValid(String dateStr) {
		try {
			this.dateFormatter.parse(dateStr);
		} catch (DateTimeParseException e) {
//			System.out.println(e.getLocalizedMessage());
//			e.printStackTrace();
			return false;
		}
		return true;
	}

	public LocalDate getLocalDateFromString(String dateStr) {
		try {
			return LocalDate.parse(dateStr, dateFormatter);
		} catch (Exception e) {
			System.out.println("No se ha podido convertir el String a LocalDate");
			e.printStackTrace();
			return null;
		}

	}

	public LocalDate getFechaSiguienteSinHora(LocalDate localDate, int weeks) {

		return localDate.plusWeeks(weeks);
	}

	public LocalDate getFechaActual() {

		return LocalDate.now();
	}
}