package py.edu.upa.test.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Producto;


@Stateless
public class ProductoDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Producto> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.and(
				Restrictions.ilike("description", filter)
//				Restrictions.or(
//						Restrictions.eq("deleted", false),
//						Restrictions.isNull("deleted")
				));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
//		criteria.add(Restrictions.or(
//				Restrictions.eq("deleted", false),
//				Restrictions.isNull("deleted")));
		
		return criteria.list();

	}
	
	public Producto findById(Integer id) {


		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.add(Restrictions.eq("id_producto", id));
		
		return (Producto) criteria.uniqueResult();

	}
//	@SuppressWarnings("unchecked")
//	public List<Producto> getProductoByProveedor(Integer idProveedor) {
//	Session session = (Session) entityManager.getDelegate();
//	Criteria criteria = session.createCriteria(Producto.class);
//	criteria.createAlias("proveedor", "proveedor");
//	criteria.add(Restrictions.and(
//    Restrictions.eq("proveedor.id_proveedor", idProveedor),
//	Restrictions.or(
//	Restrictions.eq("deleted", false),
//	Restrictions.isNull("deleted")
//	)));
//	return criteria.list();
//	}
//	
	public void insert(Producto t){
		entityManager.persist(t);
	}
	
	public void update(Integer id_producto, Producto producto){
		Producto t = findById(id_producto);
		t.setNombre(producto.getNombre());
		t.setPrecio(producto.getPrecio());
		t.setDescripcion(producto.getDescripcion());
		t.setStock(producto.getStock());
		t.setFavorito(producto.getFavorito());
		entityManager.merge(t);
	}
	
	
//	Obtener tarea por tipo
	//List<Task>Por tareas filtradas por tipo
	@SuppressWarnings("unchecked")
	public List<Producto> getProductoByProveedor(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
		
		criteria.createAlias("proveedor", "proveedor");
		
		criteria.add(Restrictions.and(
				Restrictions.eq("proveedor.id_proveedor", id)));
//				Restrictions.or(
//						Restrictions.eq("deleted", false),
//						Restrictions.isNull("deleted")))

		
		return (List<Producto>) criteria.list();
	}
	
	//getPaginatedTasks(page, size)
	
	/**
	 * @param id_type
	 * @return lista de tareas
	 */
	
	public void delete(Integer id){
		Producto t = findById(id);
		entityManager.remove(t);
	}
	@SuppressWarnings("unchecked")
	public List<Producto> findWithPagination(Integer page, Integer size) {
		
		//Calcular inicio
		int registroInicio = 0;
		registroInicio = (page - 1)* size;		

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Producto.class);
				
		
		//Asignar Registro de inicio
		criteria.setFirstResult(registroInicio);
		//Asignar Tama�o de P�gina
		criteria.setMaxResults(size);
		//Retornar lista
		return criteria.list();

	}
}