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

import br.com.fiap.bo.IdiomaCandidatoBO;
import br.com.fiap.to.IdiomaCandidatoTO;


@Path("/idiomaCandidato")
public class IdiomaCandidatoResource {

	private IdiomaCandidatoBO eb = new IdiomaCandidatoBO();

	// Cadastrar / Insert / Post (Postman)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(IdiomaCandidatoTO et, @Context UriInfo uriInfo) {
		// Cadastrando um novo recrutador
		eb.cadastrar(et);

		// Construindo o PATH
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();

		// Parseando o código e concatenando com o PATH
		builder.path(Integer.toString(et.getIdIdiomaCandidato()));

		// Retornando o Status Code do HTTP através do Builder
		return Response.created(builder.build()).build();
	}
	
	// Atualizar / Update / Put (Postman)
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response atualizar(IdiomaCandidatoTO et, @PathParam("id") int id) {

			// Setar o ID do registro do recrutador
			et.setIdIdiomaCandidato(id);

			// Atualizando o objeto (registro do recrutador)
			eb.atualizar(et);

			// Retornando o Status 200
			return Response.ok().build();
		}

		// Excluir / Delete / Delete (Postman)
		@DELETE
		@Path("/{id}")
		public void excluir(@PathParam("id") int id) {
			eb.remover(id);
		}

		// Buscar / Select / GET-BY_ID (Postman)
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<IdiomaCandidatoTO> buscar(@PathParam("id") int id) {
			return eb.listar(id);
		}

		// BuscarTodos / SelectAll / GET-ALL (Postman)
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<IdiomaCandidatoTO> buscarTodos() {
			return eb.listarTodos();
		}
}