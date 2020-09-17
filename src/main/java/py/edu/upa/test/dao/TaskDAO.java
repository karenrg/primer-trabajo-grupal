package py.edu.upa.test.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import py.edu.upa.test.entity.Task;

@Stateless
public class TaskDAO {
	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Task> findWithFilter(String filter) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Task.class);
		
		criteria.add(Restrictions.and(
				Restrictions.ilike("description", filter),
				Restrictions.or(
						Restrictions.eq("deleted", false),
						Restrictions.isNull("deleted")
				)));
		
		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<Task> find() {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Task.class);
		
		criteria.add(Restrictions.or(
				Restrictions.eq("deleted", false),
				Restrictions.isNull("deleted")));
		
		return criteria.list();

	}
	
	public Task findById(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Task.class);
		
		criteria.add(Restrictions.eq("id", id));
		
		return (Task) criteria.uniqueResult();

	}
	
	public void insert(Task t){
		entityManager.persist(t);
	}
	
	public void update(Integer id, Task task){
		Task t = findById(id);
		t.setCreationDate(task.getCreationDate());
		t.setDescription(task.getDescription());
		t.setDeleted(task.getDeleted());
		t.setFile(task.getFile());
		t.setLimitDate(task.getLimitDate());
		t.setName(task.getName());
		t.setUpdateDate(task.getUpdateDate());
		entityManager.merge(t);
	}
	
	public void delete(Integer id){
		Task t = findById(id);
		t.setDeleted(true);
		entityManager.merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskByType(Integer id) {

		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Task.class);
		
		criteria.createAlias("type", "type");
		
		criteria.add(Restrictions.and(
				Restrictions.eq("type.id", id),
				Restrictions.or(
						Restrictions.eq("deleted", false),
						Restrictions.isNull("deleted"))));
		
		return (List<Task>) criteria.list();
	}

//		http:localhost:8080/rest/task/pagitation?page=2&size=1
	//Ejemplo método getPaginateTask
	/**
	*Obtener lista de tareascon paginación
	*@param id_type
	*@return lista de tareas
	*/
	@SuppressWarnings("unchecked")
	public List <Task> getPaginatedTasks(Integer page, Integer size) {
		
		//calcular el inicio de la pagina
		int registroInicio = 0;
		registroInicio = (page - 1) * size;

		Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(Task.class);

		criteria.add(
					Restrictions.or(
							Restrictions.eq("deleted", false),
							Restrictions.isNull("deleted")
									)
						);
		//se asigna el registro de inicio
		criteria.setFirstResult(registroInicio);

		//se asigna el tamaño de la pag
		criteria.setMaxResults(size);

		//retorna la lista
		return criteria.list();
	}

}