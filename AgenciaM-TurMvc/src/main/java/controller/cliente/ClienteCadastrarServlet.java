package controller.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/cliente-cadastrar")
public class ClienteCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClienteCadastrarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));

		clienteDao.cadastrar(cliente);
		response.sendRedirect("cliente");

	}

}
