package OriginImp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Imp.TSResultDefault;
import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class timerTS extends OriginTS {

	public timerTS(TestSummary unDelegado, String url, String us) {
		super(unDelegado, url, us);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connectTS(String url, String us) {
		Timer timer = new Timer();
        TimerTask task = new TimerTask() {
        int count = 0;
        @Override
        public void run() {
        	Map <String,Boolean> criterios = new HashMap<String,Boolean>();
            Random r = new Random();
            for (int i = 0; i < 5; i++) {
                criterios.put("CA"+i, r.nextBoolean());
             }
    		TestSummary ts = new TSResultDefault(us,criterios);
    		superUpdate(ts);
    		
            }
        };
        timer.schedule(task, 1000, 2000);
		return true;
	}

	private void superUpdate (TestSummary ts) {
		super.update(ts);
	}
}

