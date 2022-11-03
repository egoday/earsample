package com.earsample.javaee.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class IndexController {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/")
    public String index() {
		return "hello";
	}

}
