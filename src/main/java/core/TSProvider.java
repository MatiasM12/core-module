package core;

import Interfaces.TestSummary;

import java.util.Map;

public interface TSProvider {
    Map<String, TestSummary> getData();
}
