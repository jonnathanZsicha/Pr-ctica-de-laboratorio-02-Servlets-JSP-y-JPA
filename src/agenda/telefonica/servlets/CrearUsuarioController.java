package agenda.telefonica.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.telefonica.dao.DAOFactory;
import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.dao.UsuarioDAO;
import agenda.telefonica.entidad.Usuario;


/**
 * Servlet implementation class UsuarioControler
 */
@WebServlet("/UsuarioControler")
public class CrearUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String password= request.getParameter("password");
		
		Usuario user = new Usuario(cedula, nombre, apellido, correo, password);
		usuarioDAO.create(user);
		System.out.println("se ha registrado exitoso el usuario");
		
		request.getRequestDispatcher( "/Html/login.html" ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
