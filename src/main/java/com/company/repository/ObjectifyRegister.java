package com.company.repository;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.company.model.Sample;
import com.squaremarks.gaeofy.ofy.GAEOfy;

@Component
@ApplicationScoped
public class ObjectifyRegister {
	
	static {
		
		GAEOfy.register(Sample.class, "sample");
	}

}
