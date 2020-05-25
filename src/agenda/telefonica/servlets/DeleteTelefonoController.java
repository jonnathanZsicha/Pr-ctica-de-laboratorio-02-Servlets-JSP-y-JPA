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
 * Servlet implementation class DeleteTelefonoController
 */
@WebServlet("/DeleteTelefonoController")
public class DeleteTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			TelefonoDAO telefonoDAO2 = DAOFactory.getFactory().getTelefonoDAO();
	    	System.out.println("ha llegado a eliminar un telefono");
	    	String ids = request.getParameter("id");
	    	int idi = Integer.parseInt(ids);
	    	Telefono te = telefonoDAO2.read(idi);
	    	telefonoDAO2.delete(te);
	    	System.out.print("\n---Elminación de telefono\n");
	    	UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
	    	String correo = request.getParameter("correo");
	    	Usuario user = usuarioDAO.findByCorreo(correo);
	    	Set<Telefono> telefonos=telefonoDAO2.findByUsuarioId(user.getCedula());
	    	request.setAttribute("telefonos", telefonos);
	        url = "/JSP/TelefonosList.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
			url = "/Html/login.html";
		}
		
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
