package me.moriya.controller;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
@Produces(MediaType.TEXT_HTML  + ";charset=utf-8")
public class RootController implements Serializable {

	private static final long serialVersionUID = -6237972627418415705L;

	@GET
	public Response message() {
		return Response.status(200).entity("<h1>Service is running</h1>").build();
	}
	
}
