package controller.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Cliente;
import model.Contato;

@WebServlet("/contato-cadastrar")
public class ContatoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDAO contatoDao = new ContatoDAO();
	Contato contato = new Contato();
	Cliente cliente = new Cliente();

	public ContatoCadastrarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setAssunto(request.getParameter("assunto"));
		contato.setMensagem(request.getParameter("mensagem"));
		cliente.setCpf(request.getParameter("cpf"));
		contato.setCliente(cliente);
		contatoDao.cadastrar(contato);
		response.sendRedirect("contato");

	}

}
