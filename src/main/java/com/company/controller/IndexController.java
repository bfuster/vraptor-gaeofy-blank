package com.company.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.company.model.Sample;
import com.squaremarks.gaeofy.datastore.DataStoreTemplate;

@Resource
public class IndexController {

	private final Result result;
	private final DataStoreTemplate ds;

	public IndexController(Result result, DataStoreTemplate ds) {
		this.result = result;
		this.ds = ds;
	}

	@Path("/")
	public void index() {
		
		ds.save(new Sample("Datastore is working! Check it out <a href='/_ah/admin'>/_ah/admin</a>"));
		List<Sample> samples = ds.list(Sample.class);
		
		result.include("samples", samples);
	}
	
}
