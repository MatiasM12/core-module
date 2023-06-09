package core;

import Interfaces.TestSummary;

public class TSBadgeProyecto implements TestSummary {
	
	  String proyecto;
	  boolean b;
	  
	  public TSBadgeProyecto(boolean b){
		  this.proyecto = "Core";
		  this.b = b;
	  }
	  
	  
	@Override
	public TestSummary update(TestSummary ts) {
		// TODO Auto-generated method stub
		return ts;
	}
	
	public boolean getBadge(){
		
		
		return b;
	}
	
	public String getProyecto(){
		
		
		return proyecto;
	}
	  
	  
	  

}
