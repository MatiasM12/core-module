

import Interfaces.OriginTS;
import Interfaces.TestSummary;

public class TSInexistente extends OriginTS {

	public TSInexistente(TestSummary unDelegado) {
		super(unDelegado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connectTS(String url, String us) {
		
		
		return false;
	}

}
