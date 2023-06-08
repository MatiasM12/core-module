package coreInicialization;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import Interfaces.TestSummary;

public class OriginTSFactory {

	String path;
	Set<TestSummary> set;

	public OriginTSFactory(String path) {
		this.path = path;
	}

	public TestSummary init(String url, String us, String pluginElegido, TestSummary ts)throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException,IllegalAccessException, NoSuchMethodException {
		this.set = new OriginFinder(this.path).find(ts);
		TestSummary origin = new OriginChooser().getOne(set, pluginElegido);
		return origin;
	}

	public Set<TestSummary> getSet() {
		return this.set;
	}
}
