package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDao<T> implements Serializable{
	/**
	 * T
	 */
	private static final long serialVersionUID = 7981415805043661774L;
	@PersistenceContext(unitName= "sample-cdi-maven")
	private EntityManager entityManager;
	public GenericDao() {}

	public void salvar(T entidade) {
		entityManager.persist(entidade);
	}
	
	public T atualizar(T entidade) {
		return entityManager.merge(entidade);
	}
	
	public List<T> listarTodos(StringBuilder sql){
		Query query = entityManager.createQuery(sql.toString());
		return query.getResultList();
		
	}
	public void deletar(String sql) {
		entityManager.createQuery(sql).executeUpdate();
	}
}






