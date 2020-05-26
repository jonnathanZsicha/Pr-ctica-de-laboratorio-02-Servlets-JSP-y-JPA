package agenda.telefonica.jpa;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



import agenda.telefonica.dao.UsuarioDAO;

import agenda.telefonica.entidad.Usuario;


public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	 public JPAUsuarioDAO() {
			super(Usuario.class);
		    }

	@Override
	public Usuario findByCorreo(String correobusqueda) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> telefonoRoot = criteriaQuery.from(Usuario.class);
		
		Predicate predicate = criteriaBuilder.like(telefonoRoot.get("correo").as(String.class), correobusqueda);
		
		criteriaQuery.select(telefonoRoot).where(predicate);
		
		return  (Usuario) em.createQuery(criteriaQuery).getSingleResult();
		
		
		
		
	
	}



}
