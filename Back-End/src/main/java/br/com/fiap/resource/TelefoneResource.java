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

import br.com.fiap.bo.TelefoneBO;
import br.com.fiap.to.TelefoneTO;

@Path("/telefone")
public class TelefoneResource {

	private TelefoneBO tbo = new TelefoneBO();

	// Cadastrar / Insert / Post (Postman)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(TelefoneTO tto, @Context UriInfo uriInfo) {
		tbo.cadastrar(tto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(tto.getIdRegistroGeral()));
		return Response.created(builder.build()).build();
	}

	// Atualizar / Update / Put (Postman)
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(TelefoneTO tto, @PathParam("id") int id) {
		tto.setIdRegistroGeral(id);
		tbo.atualizar(tto);
		return Response.ok().build();
	}

	// Excluir / Delete / Delete (Postman)
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		tbo.remover(id);
	}

	// Buscar / Select / GET-BY_ID (Postman)
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TelefoneTO> buscar(@PathParam("id") int id) {
		return tbo.listar(id);
	}

	// BuscarTodos / SelectAll / GET-ALL (Postman)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<TelefoneTO> buscarTodos() {
		return tbo.listarTodos();
	}
}