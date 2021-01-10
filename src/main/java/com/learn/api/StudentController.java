package com.learn.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

	@SuppressWarnings("rawtypes")
	@GET
	public Response getAllStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("restapi_PU");
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT * FROM student";
		List list = em.createNativeQuery(sql).getResultList();
		return Response.ok(list).build();
	}
}