package coreIC;

import java.util.LinkedList;
import java.util.List;

public class TestSourceFile implements SourceFiles{
    List<AcceptanceTest> testList;

    public TestSourceFile(List<AcceptanceTest> testList){
        for (AcceptanceTest at : testList){
            this.testList.add(at);
        }
    }
    @Override
    public List<Object> getValues() {
        List<Object> ret = new LinkedList<Object>();
        for (AcceptanceTest at : this.testList){
            ret.add((Object) at);
        }
        return ret;
    }
}
