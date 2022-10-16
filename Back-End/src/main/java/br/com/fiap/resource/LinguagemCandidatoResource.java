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

import br.com.fiap.bo.LinguagemCandidatoBO;
import br.com.fiap.to.LinguagemCandidatoTO;

@Path("/linguagemCandidato")
public class LinguagemCandidatoResource {

	private LinguagemCandidatoBO lcb = new LinguagemCandidatoBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(LinguagemCandidatoTO lct, @Context UriInfo uriInfo) {
		lcb.cadastrar(lct);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(lct.getIdLinguagemCandidato()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(LinguagemCandidatoTO lct, @PathParam("id") int id) {
		lct.setIdLinguagemCandidato(id);
		lcb.atualizar(lct);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		lcb.remover(id);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LinguagemCandidatoTO> buscar(@PathParam("id") int id) {
		return lcb.listar(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LinguagemCandidatoTO> buscarTodos() {
		return lcb.listarTodos();
	}
}
