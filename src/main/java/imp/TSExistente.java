package imp;

import Interfaces.OriginTS;
import Interfaces.TestSummary;
import core.TSBADGE;

public class TSExistente extends OriginTS {

	public TSExistente(TestSummary unDelegado) {
		super(unDelegado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connectTS(String url, String us) {
		this.update(new TSBADGE(us,true));
		return true;
	}

}
