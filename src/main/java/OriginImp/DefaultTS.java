package OriginImp;

import java.util.HashMap;
import java.util.Map;

import Imp.TSResultDefault;
import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class DefaultTS extends OriginTS {

	public DefaultTS(TestSummary unDelegado, String url, String us) {
		super(unDelegado, url, us);
	}

	@Override
	public boolean connectTS(String url, String us) {
		Map<String,Boolean> m = new HashMap<String,Boolean>();
		m.put("CA1", true);
		TestSummary ts = new TSResultDefault(us,m);
	    super.update(ts);
		return true;
	}

}
