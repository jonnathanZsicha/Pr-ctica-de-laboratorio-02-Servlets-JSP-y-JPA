package agenda.telefonica.dao;

import agenda.telefonica.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	//es mejor inyeccion de objetos
	protected static DAOFactory factory = new JPADAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
		
	}
	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract TelefonoDAO getTelefonoDAO();
	

}
