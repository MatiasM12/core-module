package core;

import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		InitCore ic = new InitCore("C:\\Users\\matia\\Desktop\\core-module\\bin\\main\\InterfacesImpl", null);
		ic.init("DefaultFinder", "", 1);
	}

}
