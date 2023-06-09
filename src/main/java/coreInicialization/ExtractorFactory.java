package coreInicialization;

import core.TSNameExtractor;

public class ExtractorFactory {

	private TSNameExtractor extractor;
	
	public TSNameExtractor create() {
		
		this.extractor = new TSNameExtractor();
		
		return this.extractor;
	}
	
	public TSNameExtractor getExtractor(){
		
		return this.extractor;
	}
}
