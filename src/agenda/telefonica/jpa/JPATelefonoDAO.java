package agenda.telefonica.jpa;


import java.util.List;
import java.util.ArrayList;

import java.util.Set;

import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.entidad.Telefono;
import agenda.telefonica.entidad.Usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{
	
	public JPATelefonoDAO() {
		super(Telefono.class);
		
	}
	

	@Override
	public Set<Telefono> findByUsuarioId(String usuariocedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findultimoid() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Telefono> findByNumero(String numero) {
		// TODO Auto-generated method stub
		return null;
	}


}
