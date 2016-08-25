package com.comcast.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({ "application/xml", "application/json" })
public interface PartnerService {

	@GET
	@Path("/partners/{id}/")
	Partner getAdCampain(@PathParam("id") String id);
	
	@POST
	@Path("/partners/")
	Response addAdCampain(Partner partner);
}
