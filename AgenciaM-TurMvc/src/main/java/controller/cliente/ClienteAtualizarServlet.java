package controller.cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet(urlPatterns = { "/cliente-editar", "/cliente-atualizar" })
public class ClienteAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClienteAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/cliente-editar":
			editar(request, response);
			break;
		case "/cliente-atualizar":
			atualizar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		cliente = clienteDao.consultarByCpf(cpf);

		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/atualizar.jsp");
		rd.forward(request, response);
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));

		clienteDao.atualizar(cliente);
		response.sendRedirect("cliente");
	}

}
