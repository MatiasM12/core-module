package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import core.InitProviderTS;
import core.ProviderTS;



public class Main {
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		
		
		ProviderTS p = new InitProviderTS().init(args);
		
		
}
}
