package dmtoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Test {
	
	public static void main(String[] args) {
//		int i = 200;
//		int k = 300;
//		String a = "500";
//		String b = "300";
//		
//		System.out.println(Integer.parseInt(a) - Integer.parseInt(b)); 
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String format = sf.format(new Date());
		
		System.out.println(format);
		
	}
	

}
