package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import coreInicialization.ObservableTSInit;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException {
		ObservableTSInit core = new ObservableTSInit();
		core.init( new String[]{"www.github.com/felipe", "US1" });
	}
}