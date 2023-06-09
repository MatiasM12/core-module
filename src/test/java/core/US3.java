package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import coreInicialization.Core;
import mocks.ObAT;
import mocks.TSBadge;

public class US3 {

	private static TestSummary ts;

	@BeforeEach
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "url";
		String[] args = new String[] { url, us };
		Observable obv = new Core().init(args);
		Observer o = new ObAT(obv);
		ts = ((ObAT) o).getTS();
	}

	@Test
	void CA1PassedBadge() {
		TestSummary newTS = createTS("US1", true);
		assertEquals(((TSBadge) ts.update(newTS)).getState(), true);
	}

	void CA2FailedBadge() {
		TestSummary newTS = createTS("US1", false);
		assertEquals(((TSBadge) ts.update(newTS)).getState(), false);
	}

	private TestSummary createTS(String us, Boolean b) {
		Map<String, Boolean> cA = new HashMap<String, Boolean>();
		Map<String, String> cACategories = new HashMap<String, String>();
		return new TSBadge(us, cA, cACategories, b);
	}
}
