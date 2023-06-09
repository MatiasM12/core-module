package core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.Observable;
import Interfaces.Observer;
import Interfaces.TestSummary;
import coreInicialization.Core;
import mocks.ObAT;
import mocks.TSWithCategories;

public class US5 {

	private static TestSummary ts;
	private static List<String> validCategories;
	private static TSWithCategories newValidCategoryTS, newEmptyCategoryTS,newInvalidCategoryTS, tsWithMultipleCategories;

	@BeforeEach
	public void escenario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException {
		String us = "US1";
		String url = "http://fakeurl.com";
		String[] args = new String[] { url, us };
		validCategories = createValidListOfCategories(); //{"Usabilidad","Funcionalidad","Rendimiento","Seguridad","Accesibilidad"}
		Observable observableTS = new Core().init(args);
		Observer o = new ObAT(observableTS);
		ts = ((ObAT) o).getTS();
		newValidCategoryTS = createTS("CA1", "Seguridad");
		newEmptyCategoryTS = createTS("CA1", null);
		newInvalidCategoryTS = createTS("CA1", "Archivo.txt");
		tsWithMultipleCategories = createTSWithMultipleCategories();
	}

	@Test
	public void CA1ValidCategory() {
		assertEquals(((TSWithCategories) ts.update(newValidCategoryTS)).getSizeOfCategories(), 1);
		assertEquals(((TSWithCategories) ts.update(newValidCategoryTS)).getCategoryOf("CA1"), "Seguridad");
		assertTrue(validCategories.contains(((TSWithCategories) ts.update(newValidCategoryTS)).getCategoryOf("CA1")));
	}

	@Test
	public void CA2WithoutCategory() {
		assertEquals(((TSWithCategories) ts.update(newEmptyCategoryTS)).getSizeOfCategories(), 0);
		assertEquals(((TSWithCategories) ts.update(newEmptyCategoryTS)).getCategoryOf("CA1"), null);
	}

	@Test
	public void CA3InvalidCategory() {
		assertFalse(validCategories.contains(((TSWithCategories) ts.update(newInvalidCategoryTS)).getCategoryOf("CA1")));
	}

	@Test
	public void CA4CategoryFilter() {
		List<String> caOfCategory = ((TSWithCategories) ts.update(tsWithMultipleCategories)).getCAsByCategory("Seguridad");
		assertEquals(caOfCategory.size(), 2);
		assertEquals(caOfCategory.get(0), "CA1");
		assertEquals(caOfCategory.get(1), "CA3");
	}

	@Test
	public void CA5CategoryEmptyFilter() {
		List<String> caEmptyCategory = ((TSWithCategories) ts.update(tsWithMultipleCategories)).getCAsByCategory("");
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
	
	public List<String> createValidListOfCategories() {
		List<String> list = new ArrayList<String>();
		list.add("Seguridad");
		list.add("Usabilidad");
		list.add("Funcionalidad");
		list.add("Rendimiento");
		list.add("Accesibilidad");
		return list;
	}

}
