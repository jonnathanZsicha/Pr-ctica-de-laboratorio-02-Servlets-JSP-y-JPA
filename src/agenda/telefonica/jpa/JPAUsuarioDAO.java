package agenda.telefonica.jpa;


import agenda.telefonica.dao.UsuarioDAO;
import agenda.telefonica.entidad.Usuario;


public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	 public JPAUsuarioDAO() {
			super(Usuario.class);
		    }

	@Override
	public Usuario findByCorreo(String correobusqueda) {
		// TODO Auto-generated method stub
		return null;
	}



}
