package coreInicialization;

import breaker.CBOrigin;

public class CBOriginFactory {


	CBOrigin breaker;
	
	public CBOrigin createBreaker(){
		this.breaker = new CBOrigin();
		return this.breaker;
	}
	
	public CBOrigin	getBreaker(){
		return this.breaker;
	}
	
	

}
