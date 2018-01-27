package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDao <T>{

	@PersistenceContext(unitName= "sample-cdi-maven")
	private EntityManager entityManager;
	public Class<T> tipoClass;
	public BaseDao() {}
	public BaseDao(Class<T> tipoClass) {
		this.tipoClass = tipoClass;
	}
	public void salvar(T entidade) {
		entityManager.persist(entidade);
	}
	
	public T atualizar(T entidade) {
		return entityManager.merge(entidade);
	}
	
	public List<T> listarTodos(){
		StringBuilder sql = new StringBuilder();
		sql.append("from").append(tipoClass.getSimpleName());
		Query query = entityManager.createQuery(sql.toString());
		return query.getResultList();
		
	}
}
