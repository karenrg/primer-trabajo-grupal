package py.edu.upa.test.ws;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import py.edu.upa.test.business.ProductoBC;
import py.edu.upa.test.entity.Producto;

@Path("productos")
@RequestScoped
public class ProductoService {

	@Inject
	private ProductoBC bc;

//  http://localhost:8080/rest/productos
	@GET
    @Produces("application/json")
	public Response getAll() {
		try {
			return Response.ok().entity(bc.find()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}
	
//  http://localhost:8080/rest/productos
	@POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
	public Response add(Producto t) {
		try {
			bc.insert(t);
			return Response.ok().entity(t).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
	}

//	http://localhost:8080/rest/tasks/1
    @GET
    @Path("/{idProducto: \\d+}")
    @Produces({"application/json"})
    public Response get(@PathParam("idProducto") Integer id) {
    	try {
			return Response.ok().entity(bc.findById(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }

//    http://localhost:8080/rest/productos/1
    @PUT
    @Path("/{idProducto: \\d+}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response update(@PathParam("idProducto") Integer id, Producto t) {
    	try {
    		bc.update(id,t);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }

    @DELETE
    @Path("/{idProducto: \\d+}")
    @Produces({"application/json"})
    public Response delete(@PathParam("idProducto") Integer id) {
    	try {
    		bc.delete(id);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
    
//    http://localhost:8080/rest/tasks/prueba?filter=xx
    @GET
    @Path("/pruebas")
    @Produces({"application/json"})
    public Response update(@QueryParam("filter") String filter) {
    	try {
			return Response.ok().entity(bc.getWithFilter(filter)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
    }
    
    @GET
    @Path("/byproveedor")
    @Produces({"application/json"})
    public Response getByProveedor (@QueryParam("idProveedor") Integer idProveedor) {
    try {
    	return Response.ok().entity(bc.getProductoByProveedor(idProveedor)).build();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
    				.entity("ERROR_GENERICO")
    				.build();
    }
    } 
   @GET
   @Path("/pagination")
   @Produces({"application/json"})
   public Response getWithPagination (@QueryParam("page") Integer page, @QueryParam("size") Integer size) {
   	try { 
			return Response.ok().entity(bc.getPaginatedProductos(page, size)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("ERROR_GENERICO")
					.build();
		}
   }
    	}		
