package coreInicialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TSFilter {

	public List<String> filterByCategory(Map<String,String> categories, String category) {
		List<String> keys = new ArrayList<>();
        for (String key : categories.keySet()) {
            if (categories.get(key).equals(category)) {
                keys.add(key);
            }
        }
		return keys;
	}
}
