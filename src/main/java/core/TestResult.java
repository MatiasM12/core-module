package core;

public class TestResult{
    public final String name;
    public Boolean result;
    TestResult(String name, Boolean result){
        this.name = name;
        this.result = result;
    }
    @Override
    public boolean equals(Object o) {
        System.out.println("Esta entrando al equals");
        return   ((TestResult) o).name == this.name;
    }


    public static void main(String[] args)  {
        TestResult test = new TestResult("Test",true);
        TestResult test2 = new TestResult("Test",false);

        System.out.println(test.equals(test2));

        (new TestSummary()).update(test);

    }
}
