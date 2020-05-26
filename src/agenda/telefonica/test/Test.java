package agenda.telefonica.test;

import java.util.List;
import java.util.Set;

import agenda.telefonica.dao.DAOFactory;
import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.dao.UsuarioDAO;
import agenda.telefonica.entidad.Telefono;
import agenda.telefonica.jpa.JPADAOFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO= DAOFactory.getFactory().getTelefonoDAO();
		
		
		//System.out.println( telefonoDAO.findByUsuarioId("0106232812"));
		//System.out.println(usuarioDAO.findByCorreo("rsicha50@gmail.com"));
		//System.out.println(telefonoDAO.findByNumero("0981951042"));
		System.out.println(telefonoDAO.findultimoid());
	}

}
