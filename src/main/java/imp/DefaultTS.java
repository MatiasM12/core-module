package imp;

import java.util.HashMap;
import java.util.Map;

import Interfaces.OriginTS;
import Interfaces.TestSummary;
import core.TSResultDefault;

public class DefaultTS extends OriginTS {

	
	
	public DefaultTS(TestSummary ts) {
		super(ts);
	}

	@Override
	public boolean connectTS(String url, String us) {
		
		Map<String,Boolean> ca = new HashMap<String,Boolean>();
		Map<String,String> categoria = new HashMap<String,String>();
		ca.put("CA1", true);
		categoria.put("CA1", "FUNCIONAL");		
		new TSResultDefault(us,ca,categoria);
		return true;
	}

}
