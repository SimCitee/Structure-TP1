package Classes;

import java.io.IOException;

public class ExceptionBlank extends Exception {
		
	String str;
	
	public ExceptionBlank(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}
}
