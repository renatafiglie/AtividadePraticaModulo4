package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDao;

import model.Destino;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(urlPatterns = { "/destino", "/cadastrar-destino", "/editar-destino", "/atualizar-destino", "/deletar-destino" })
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DestinoDao destinoDao = new DestinoDao();
	Destino destino = new Destino();

	public DestinoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			read(request, response);
			break;

		case "/cadastrar-destino":
			create(request, response);
			break;

		case "/editar-destino":
			readById(request, response);
			break;
			
		case "/atualizar-destino":
			update(request, response);
			break;
			
		case "/deletar-destino":
			delete(request, response);
			break;
			
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setNome(request.getParameter("nome"));
		destino.setEmail(request.getParameter("email"));
		destino.setTelefone(Integer.parseInt(request.getParameter("telefone")));
		destino.setDestino(request.getParameter("destino"));
		destino.setAerea(request.getParameter("aerea"));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		destinoDao.saveUser(destino);
		response.sendRedirect("destino");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destino> lista = destinoDao.readUsers();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/destino/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		destino.setId(Integer.parseInt(request.getParameter("id")));
		destino.setNome(request.getParameter("nome"));
		destino.setEmail(request.getParameter("email"));
		destino.setTelefone(Integer.parseInt(request.getParameter("telefone")));
		destino.setDestino(request.getParameter("destino"));
		destino.setAerea(request.getParameter("aerea"));
		destino.setPreco(Integer.parseInt(request.getParameter("preco")));
		destinoDao.updateUser(destino);
		response.sendRedirect("destino");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destinoDao.deleteUser(id);
		response.sendRedirect("destino");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		destino = destinoDao.getUserById(id);
		
		
		request.setAttribute("id", destino.getId());
		request.setAttribute("nome", destino.getNome());
		request.setAttribute("email", destino.getEmail());
		request.setAttribute("telefone", destino.getTelefone());
		request.setAttribute("destino", destino.getDestino());
		request.setAttribute("aerea", destino.getAerea());
		request.setAttribute("preco", destino.getPreco());
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/destino/atualizar.jsp");
		rd.forward(request, response);
		
	}

}
