package agenda.telefonica.jpa;


import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.entidad.Telefono;
import agenda.telefonica.entidad.Usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{
	
	private List<Telefono> list;

	public JPATelefonoDAO() {
		super(Telefono.class);
		
	}
	

	@Override
	public List<Telefono> findByUsuarioId(String usuariocedula) {
		// TODO Auto-generated method stub

		
		Usuario usuario = JPADAOFactory.getFactory().getUsuarioDAO().read(usuariocedula);
		System.out.println("este es el usuario" + usuario);
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		
		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);
		
		Predicate predicate = criteriaBuilder.equal(telefonoRoot.get("usuario"), usuario);
		
		criteriaQuery.select(telefonoRoot).where(predicate);
		
		list =em.createQuery(criteriaQuery).getResultList();
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}

	@Override
	public int findultimoid() {
		// TODO Auto-generated method stub
		
		
		CriteriaBuilder cb1 = em.getCriteriaBuilder();
		CriteriaQuery<Integer> cq1 = cb1.createQuery(Integer.class);
		Root<Telefono> root = cq1.from(Telefono.class);
		cq1.select(cb1.max(root.get("id")));
		int ultimo = em.createQuery(cq1).getSingleResult();
		return ultimo;
	}

	
	@Override
	public List<Telefono> findByNumero(String numero) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		
		Root<Telefono> telefonoRoot = criteriaQuery.from(Telefono.class);
		
		Predicate predicate = criteriaBuilder.like(telefonoRoot.get("numero").as(String.class), numero);
		
		criteriaQuery.select(telefonoRoot).where(predicate);
		
		return  em.createQuery(criteriaQuery).getResultList();
	}
	
}
