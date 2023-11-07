package controller.contato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;

@WebServlet("/contato-deletar")
public class ContatoDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDAO contatoDao = new ContatoDAO();
	Contato contato = new Contato();

	public ContatoDeletarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		deletar(request, response);
		
	}
		
		protected void deletar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		contatoDao.removerByCpf(cpf);
		response.sendRedirect("contato");
	}

}
