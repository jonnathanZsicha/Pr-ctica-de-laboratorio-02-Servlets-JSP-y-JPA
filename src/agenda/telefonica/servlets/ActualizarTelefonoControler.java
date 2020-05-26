package agenda.telefonica.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.telefonica.dao.DAOFactory;
import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.dao.UsuarioDAO;
import agenda.telefonica.entidad.Telefono;
import agenda.telefonica.entidad.Usuario;


/**
 * Servlet implementation class ActualizarTelefonoControler
 */
@WebServlet("/ActualizarTelefonoController")
public class ActualizarTelefonoControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String url = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarTelefonoControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		
		 int id = Integer.parseInt( request.getParameter("id"));
	        String numero = request.getParameter("numero");
	        String tipo = request.getParameter("tipo");
	        String operadora = request.getParameter("operadora");
	        System.out.println("esperando para actualizar"+ numero + tipo + operadora);
	        String correo = request.getParameter("correo");
	    	Usuario user = usuarioDAO.findByCorreo(correo);
	        Telefono telf = new Telefono(id, numero, tipo, operadora, user);
	        telefonoDAO.update(telf);
	        System.out.println("se ha actualizado el telefono");
	        
	        java.util.List<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
	    	request.setAttribute("telefonos", telefonos);
	        url = "/JSP/TelefonosList.jsp";
	        request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
