package za.co.invoketech.store.application.util;

import java.util.Calendar;
import java.util.Date;

public class Dates {
	
	public static Date copy(Date date) {
		if(date != null) {
			return new Date(date.getTime());
		}
		
		return null;
	}
	
	public static Date now() {
		return Calendar.getInstance().getTime();
	}
}
