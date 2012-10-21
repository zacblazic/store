package za.co.invoketech.store.application.util;

import java.util.Date;

public class DefensiveDate {
	public static Date copyDate(Date date) {
		if(date != null) {
			return new Date(date.getTime());
		}
		
		return null;
	}
}
