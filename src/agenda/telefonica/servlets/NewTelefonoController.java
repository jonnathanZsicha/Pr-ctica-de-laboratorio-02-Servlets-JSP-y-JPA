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
 * Servlet implementation class NewTelefonoController
 */
@WebServlet("/NewTelefonoController")
public class NewTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		String numero = request.getParameter("numero");
    	String tipo = request.getParameter("tipo");
    	String operadora = request.getParameter("operadora");
    	System.out.println("ha llegado a crear un telefono");
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		
		String correobusqueda = request.getParameter("correo");
		Usuario user = usuarioDAO.findByCorreo(correobusqueda);
		System.out.println("usuario"+user);
		int id  = telefonoDAO.findultimoid();
		id = id+1;
		Telefono tel = new Telefono(id, numero, tipo , operadora, user );
		System.out.println(id);
		
		System.out.println("usuario"+user);
		tel.setUsuario(user);
		System.out.println("telefono ?"+tel);
		telefonoDAO.create(tel);
		System.out.print("\n---Creación de telefono\n");
		java.util.List<Telefono> telefonos= telefonoDAO.findByUsuarioId(user.getCedula());
	       System.out.println("estos son todos los telefonos" + telefonos);
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
