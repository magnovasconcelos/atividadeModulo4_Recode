package controller.contato;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Cliente;
import model.Contato;

@WebServlet(urlPatterns = {"/contato-editar", "/contato-atualizar"})
public class ContatoAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDAO contatoDao = new ContatoDAO();
	Contato contato = new Contato();
	Cliente cliente = new Cliente();

	public ContatoAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/contato-editar":
			editar(request, response);
			break;
		case "/contato-atualizar":
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
		contato = contatoDao.consultarByCpf(cpf);

		request.setAttribute("contato", contato);
		RequestDispatcher rd = request.getRequestDispatcher("./views/contato/atualizar.jsp");
		rd.forward(request, response);
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setAssunto(request.getParameter("assunto"));
		contato.setMensagem(request.getParameter("mensagem"));
		cliente.setCpf(request.getParameter("cpf"));
		contato.setCliente(cliente);
		contatoDao.atualizar(contato);
		response.sendRedirect("contato");
	}

}
