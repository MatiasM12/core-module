package core;

public class TestResult{
    public String name;
    public Boolean result;
    TestResult(String name, Boolean result){
        this.name = name;
        this.result = result;
    }
    @Override
    public boolean equals(Object o) {
        return   ((TestResult) o).name == this.name;
    }
}
