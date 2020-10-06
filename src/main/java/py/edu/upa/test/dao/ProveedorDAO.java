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
	
	
	@SuppressWarnings("unchecked")
	public List<Proveedor> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
	
		return criteria.list();

	}
	
	public Proveedor findById(Integer idProveedor) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.eq("idProveedor", idProveedor));
		
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
		entityManager.remove(t);
	}


	@SuppressWarnings("unchecked")
	public List<Proveedor> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Proveedor.class);
		
		criteria.add(Restrictions.ilike("description", filter));
		
		return criteria.list();
	}


	}
