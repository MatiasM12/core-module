package core;

import coreInicialization.Core;
import mocks.ObAT;
import mocks.TSStub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class US1 {

	private static TestSummary ts;

	@BeforeEach
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "url";
		String[] args = new String[] { url, us };
		Observable obv = new Core().init(args);
		Observer o = new ObAT(obv);
		ts = ((ObAT) o).getTS();
	}

	@Test
	void CA1() {
		Map<String, Boolean> test = createMap("CA1", true); // [CA1 : TRUE]
		TestSummary newTS = createTS(test);
		assertEquals(((TSStub) ts.update(newTS)).sizeCA(), 1);
	}

	@Test
	void CA2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		Map<String, Boolean> test = new HashMap<String, Boolean>(); // []
		TestSummary newTS = createTS(test);
		assertEquals(((TSStub) ts.update(newTS)).sizeCA(), 0);
	}

	@Test
	void CA3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException {
		Map<String, Boolean> test1 = createMap("CA1", true); // [CA1 : TRUE]
		Map<String, Boolean> test2 = createMap("CA1", false); // [CA1 : FALSE]
		TestSummary newTSTrue = createTS(test1);
		TestSummary newTSFalse = createTS(test2);
		assertEquals(ts.update(newTSTrue).equals(ts.update(newTSFalse)), false);
	}

	// Funciones auxiliares
	private Map<String, Boolean> createMap(String ca, boolean status) {
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		m.put(ca, status);
		return m;
	}

	private TSStub createTS(Map<String, Boolean> test) {
		return new TSStub("US1", test);
	}
}
