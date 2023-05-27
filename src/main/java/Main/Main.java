package Main;

import core.CoreInit;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		CoreInit core = new CoreInit();
		core.init(
				new String[] {"www.github.com/felipe", "US1" }
		);
	}
}
