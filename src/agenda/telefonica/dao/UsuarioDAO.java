package agenda.telefonica.dao;

import agenda.telefonica.entidad.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario , String>{
	
	public abstract Usuario findByCorreo(String correobusqueda);

}
