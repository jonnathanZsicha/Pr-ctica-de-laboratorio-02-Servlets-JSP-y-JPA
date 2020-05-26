package agenda.telefonica.servlets;


import java.awt.List;
import java.io.IOException;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import agenda.telefonica.dao.DAOFactory;
import agenda.telefonica.dao.TelefonoDAO;
import agenda.telefonica.dao.UsuarioDAO;
import agenda.telefonica.entidad.Telefono;
import agenda.telefonica.entidad.Usuario;



/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		TelefonoDAO telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();

		HttpSession session = request.getSession(true);
		String correobusqueda = request.getParameter("correo");
		Usuario user = usuarioDAO.findByCorreo(correobusqueda);
		System.out.println(user);
		String url = null;
		try {
			if (user != null) {
				System.out.println(user);
				String correo = user.getCorreo();
				String password= user.getPassword();
				String cedula=user.getCedula();
				
				if (session.isNew()) {
					session.setAttribute("acceso", true);
					session.setAttribute("correo",correo );
					session.setAttribute("cedula",cedula );
					
					if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
						boolean bool =  (boolean) session.getAttribute("acceso");
						System.out.println("creacion 1ra sesion acceso :"+ bool);
				       java.util.List<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
				       System.out.println("estos son todos los telefonos" + telefonos);
				        request.setAttribute("telefonos", telefonos);
				        /*
						for (Telefono telefonos : telefonoDAO.findByUsuarioId(user.getCedula())) {
							System.out.println(telefonos);
						}*/
						url = "/JSP/TelefonosList.jsp";
					}	
				}else {
					System.out.println("estas en el else");
					
					if ((correo.equals(request.getParameter("correo"))) && (password.equals(request.getParameter("password")))  ) {
						session.setAttribute("correo",correo );
						session.setAttribute("cedula",cedula );
						 java.util.List<Telefono> telefonos=telefonoDAO.findByUsuarioId(user.getCedula());
						System.out.println(telefonos);
						request.setAttribute("telefonos", telefonos);
						url = "/JSP/TelefonosList.jsp";
					}
					
				}
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("este es el errror " + e);
			url= "/Html/login.html";
		}
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	
	}
}
