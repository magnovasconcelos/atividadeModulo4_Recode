package controller.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/cliente-deletar")
public class ClienteDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClienteDeletarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		deletar(request, response);
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		clienteDao.removerByCpf(cpf);
		response.sendRedirect("cliente");
	}

}
