package core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import coreInicialization.Core;
import coreInicialization.TSFilter;
import mocks.ObAT;
import mocks.TSWithCategories;

public class US5 {

	private static TestSummary ts;
	private static TSWithCategories newTS, newEmptyCategoryTS, tsWithMultipleCategories;
	private static TSFilter filter;

	@BeforeEach
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "url";
		String[] args = new String[] { url, us };
		Observable observableTS = new Core().init(args);
		Observer o = new ObAT(observableTS);
		ts = ((ObAT) o).getTS();
		newTS = createTS("CA1", "Seguridad");
		newEmptyCategoryTS = createTS("CA1", null);
		tsWithMultipleCategories = createTSWithMultipleCategories();
		filter = new TSFilter();
	}

	@Test
	public void CA1() {
		assertEquals(((TSWithCategories) ts.update(newTS)).getSizeOfCategories(), 1);
		assertEquals(((TSWithCategories) ts.update(newTS)).getCategoryOf("CA1"), "Seguridad");
	}

	@Test
	public void CA2() {
		assertEquals(((TSWithCategories) ts.update(newEmptyCategoryTS)).getSizeOfCategories(), 0);
		assertEquals(((TSWithCategories) ts.update(newEmptyCategoryTS)).getCategoryOf("CA1"), null);
	}

	@Test
	public void CA3() {
		newTS.caCategories = newCategory("CA1", "Accesibilidad");
		assertEquals(((TSWithCategories) ts.update(newTS)).getSizeOfCategories(), 1);
		assertEquals(((TSWithCategories) ts.update(newTS)).getCategoryOf("CA1"), "Accesibilidad");
	}

	@Test
	public void CA4() {
		List<String> caOfCategory = filter.filterByCategory(
				((TSWithCategories) ts.update(tsWithMultipleCategories)).getAllCategories(), "Seguridad");
		assertEquals(caOfCategory.size(), 2);
		assertEquals(caOfCategory.get(0), "CA1");
		assertEquals(caOfCategory.get(1), "CA3");
	}

	@Test
	public void CA5() {
		List<String> caEmptyCategory = filter
				.filterByCategory(((TSWithCategories) ts.update(tsWithMultipleCategories)).getAllCategories(), "");
		assertEquals(caEmptyCategory.size(), 0);
	}

	private Map<String, Boolean> createMap(String ca, boolean status) {
		Map<String, Boolean> m = new HashMap<String, Boolean>();
		m.put(ca, status);
		return m;
	}

	private Map<String, String> newCategory(String ca, String category) {
		Map<String, String> m = new HashMap<String, String>();
		if (category != null)
			m.put(ca, category);
		return m;
	}

	private TSWithCategories createTS(String ca, String category) {
		Map<String, Boolean> m = createMap(ca, true);
		Map<String, String> m2 = newCategory(ca, category);
		return new TSWithCategories("US1", m, m2);
	}

	private TSWithCategories createTSWithMultipleCategories() {
		Map<String, Boolean> m = createMap("CA1", true);
		m.put("CA2", true);
		m.put("CA3", true);
		Map<String, String> m2 = newCategory("CA1", "Seguridad");
		m2.put("CA2", "Accesibilidad");
		m2.put("CA3", "Seguridad");
		return new TSWithCategories("US1", m, m2);
	}

}
