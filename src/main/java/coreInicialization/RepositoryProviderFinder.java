package coreInicialization;

import java.util.Set;

import interfaces.TSProvider;

public class RepositoryProviderFinder  {

	public TSProvider findProviderByRepository(Set<TSProvider> providers, String repo) {
	    return providers.stream()
	            .filter(provider -> provider.getClass().getName().equals(repo))
	            .findFirst()
	            .orElse(null);
	}

}
