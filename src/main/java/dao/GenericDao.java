package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class GenericDao<T> implements Serializable{
	/**
	 * 
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
	
	public List<T> listarTodos(String tabela){
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(tabela);
		Query query = entityManager.createQuery(sql.toString());
		return query.getResultList();
		
	}
	
}






