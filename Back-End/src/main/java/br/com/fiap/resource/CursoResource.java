package br.com.fiap.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.CursoBO;
import br.com.fiap.to.CursoTO;

@Path("curso")
public class CursoResource {

	private CursoBO cb = new CursoBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CursoTO ct, @Context UriInfo uriInfo) {
		cb.cadastrar(ct);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(ct.getIdCurso()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CursoTO ct, @PathParam("id") int id) {
		ct.setIdCurso(id);
		cb.atualizar(ct);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		cb.remover(id);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CursoTO> buscar(@PathParam("id") int id) {
		return cb.listar(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CursoTO> buscarTodos() {
		return cb.listarTodos();
	}
}