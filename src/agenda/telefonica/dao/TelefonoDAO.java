package agenda.telefonica.dao;


import java.util.List;
import java.util.Set;

import agenda.telefonica.entidad.Telefono;



public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	
	public abstract Set<Telefono> findByUsuarioId(String usuariocedula);
	 public abstract int findultimoid();
	 public abstract Set<Telefono> findByNumero(String numero);
	 

}
