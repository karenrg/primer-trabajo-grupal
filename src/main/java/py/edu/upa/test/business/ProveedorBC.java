package py.edu.upa.test.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.edu.upa.test.DAO.ProveedorDAO;
import py.edu.upa.test.entity.Proveedor;


@Stateless
public class ProveedorBC {
	
    @Inject
	private ProveedorDAO dao;
	

	public List<Proveedor> find() {
		return dao.find();
	}
	
	public Proveedor findById(Integer id) {
		return dao.findById(id);
	}
	
	public void insert(Proveedor t){
		dao.insert(t);
	}
	
	public void update(Integer id, Proveedor t){
		dao.update(id, t);
	}
	
	public void delete(Integer id){
		dao.delete(id);
	}
	
	public List<Proveedor> getWithFilter(String filter) {
		return dao.findWithFilter(filter);
	}
	//obtener tarea por tipo
	public List<Proveedor> getProveedorByProducto(Integer id) {
		return dao.getProveedorByProducto(id);
	}
	//Paginación
		public List<Proveedor> getPaginatedProveedor(Integer page, Integer size){
			return dao.findWithPagination(page, size);	
}
}


