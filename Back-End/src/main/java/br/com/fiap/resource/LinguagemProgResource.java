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

import br.com.fiap.bo.LinguagemProgBO;
import br.com.fiap.to.LinguagemProgTO;

@Path("/linguagemProgramacao")
public class LinguagemProgResource {

	private LinguagemProgBO lpb = new LinguagemProgBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(LinguagemProgTO lpt, @Context UriInfo uriInfo) {
		lpb.cadastrar(lpt);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(lpt.getIdLinguagemProg()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(LinguagemProgTO lpt, @PathParam("id") int id) {
		lpt.setIdLinguagemProg(id);
		lpb.atualizar(lpt);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		lpb.remover(id);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LinguagemProgTO> buscar(@PathParam("id") int id) {
		return lpb.listar(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LinguagemProgTO> buscarTodos() {
		return lpb.listarTodos();
	}
}