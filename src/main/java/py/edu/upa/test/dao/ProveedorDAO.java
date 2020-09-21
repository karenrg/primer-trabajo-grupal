package py.edu.upa.test.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import py.edu.upa.test.entity.Proveedor;


@Stateless
public class ProveedorDAO {
	@PersistenceContext
	EntityManager entityManager;
	
//	@SuppressWarnings("unchecked")
//	public List<Proveedor> findWithFilter(String filter) {
//
//		Session session = (Session) entityManager.getDelegate();
//		Criteria criteria = session.createCriteria(Proveedor.class);
//		
//		criteria.add(Restrictions.and(
//				Restrictions.ilike("description", filter),
//				Restrictions.or(
//						Restrictions.eq("deleted", false),
//						Restrictions.isNull("deleted")
//				)));
//		
//		return criteria.list();

	
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
//		criteria.add(Restrictions.or(
//				Restrictions.eq("deleted", false),
//				Restrictions.isNull("deleted")));
//		
		return criteria.list();

	}
	
	public Proveedor findById(Integer idProveedor) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.eq("id_proveedor", idProveedor));
		
		return (Proveedor) criteria.uniqueResult();

	}
	
	public void insert(Proveedor t){
		entityManager.persist(t);
	}
	
	public void update(Integer idProveedor, Proveedor proveedor){
		Proveedor t = findById(idProveedor);
		t.setRuc(proveedor.getRuc());
		t.setTelefono(proveedor.getTelefono());
		t.setNombre(proveedor.getNombre());
		entityManager.merge(t);
	}
	
	public void delete(Integer id){
		Proveedor t = findById(id);
		entityManager.merge(t);
	}


	@SuppressWarnings("unchecked")
	public List<Proveedor> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.ilike("description", filter));
		
		return criteria.list();
	}

//	@SuppressWarnings("unchecked")
//	public List<Proveedor> findWithPagination(Integer page, Integer size) {
//		
//		//Calcular inicio
//		int registroInicio = 0;
//		registroInicio = (page - 1)* size;		
//
//		Session session = (Session) entityManager.getDelegate();
//		Criteria criteria = session.createCriteria(Proveedor.class);
//				
////		criteria.add(
////				Restrictions.or(
////						Restrictions.eq("deleted", false),
////						Restrictions.isNull("deleted")));
//		
//		//Asignar Registro de inicio
//		criteria.setFirstResult(registroInicio);
//		//Asignar Tamaño de Página
//		criteria.setMaxResults(size);
//		//Retornar lista
//		return criteria.list();
//	}

	}
