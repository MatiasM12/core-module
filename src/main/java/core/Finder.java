package core;

public class Finder {

    public static void findReport(String path){
        ReportBuilder builder = new ReportBuilder(path);
        builder.build();
    }
}
