package controller.cliente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/cliente")
public class ClienteListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClienteListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/cliente":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Cliente> lista = clienteDao.getCliente();
		request.setAttribute("listaCliente", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/index.jsp");
		rd.forward(request, response);
	}

}
