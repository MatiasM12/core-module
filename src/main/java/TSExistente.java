import java.util.HashMap;
import java.util.Map;

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
		Map<String, Boolean> cA = new HashMap<String, Boolean>();
		cA.put("CA1", true);
		cA.put("CA2", true);
		Map<String, String> cACategories = new HashMap<String, String>();
		cACategories.put("CA1", "Seguridad");
		cACategories.put("CA2", "Seguridad");
		this.update(new TSBADGE(us,cA,cACategories,true));
		return true;
	}

}
