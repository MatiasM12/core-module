package Main;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

import core.Core;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, FileNotFoundException, MalformedURLException {
		Core core = new Core();
		core.init( new String[]{"www.github.com/felipe", "US1" });
		System.out.println("hola");
	}
}