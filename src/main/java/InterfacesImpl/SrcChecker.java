package InterfacesImpl;

import core.Checker;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class SrcChecker extends Checker {
    private Date lastModifiedTime;
    @Override
    public void check(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        if (files != null)
        {
            for (File file : files)
            {
                if (file.lastModified() > lastModifiedTime)
                {
                    lastModifiedTime = file.lastModified();
                    if(observer != null){
                        observer.update();
                    }
                    break;
                }
            }
        }
    }
}
