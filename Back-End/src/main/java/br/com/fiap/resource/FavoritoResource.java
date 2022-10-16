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
import br.com.fiap.bo.FavoritoBO;
import br.com.fiap.to.FavoritoTO;

@Path("favorito")
public class FavoritoResource {

	private FavoritoBO fb = new FavoritoBO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FavoritoTO ft, @Context UriInfo uriInfo) {
		fb.cadastrar(ft);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(ft.getIdFavorito()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(FavoritoTO ft, @PathParam("id") int id) {
		ft.setIdFavorito(id);
		fb.atualizar(ft);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		fb.remover(id);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FavoritoTO> buscar(@PathParam("id") int id) {
		return fb.listar(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FavoritoTO> buscarTodos() {
		return fb.listarTodos();
	}
}