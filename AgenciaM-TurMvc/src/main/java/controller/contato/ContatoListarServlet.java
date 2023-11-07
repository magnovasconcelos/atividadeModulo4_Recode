package controller.contato;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Cliente;
import model.Contato;

@WebServlet("/contato")
public class ContatoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDAO contatoDao = new ContatoDAO();
	Contato contato = new Contato();
	Cliente cliente = new Cliente();

	public ContatoListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/contato":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Contato> lista = contatoDao.getContato();
		request.setAttribute("listaContato", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/contato/index.jsp");
		rd.forward(request, response);
	}

}
