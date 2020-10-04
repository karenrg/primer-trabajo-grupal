	package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.DAO.ProductoDAO;
import py.edu.upa.test.entity.Producto;


@Stateless
public class ProductoBC {
	
    @Inject
	private ProductoDAO dao;
	

	public List<Producto> find() {
		return dao.find();
	}
	
	public Producto findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Producto t){
		dao.insert(t);
	}
	
	public void update(Integer id, Producto t){
		dao.update(id, t);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public List<Producto> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	//obtener producto por proveedor
	public List<Producto> getProductoByProveedor(Integer id) {
		return dao.getProductoByProveedor(id);
	}
	//Paginación
		public List<Producto> getPaginatedProductos(Integer page, Integer size){
			return dao.findWithPagination(page, size);	
}
}

