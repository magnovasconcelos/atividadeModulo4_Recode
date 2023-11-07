package controller.destino;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/destino", "/destino-imagem" })
public class DestinoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			listar(request, response);
			break;
		case "/destino-imagem":
			listarImagem(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Destino> lista = destinoDao.getDestino();
		request.setAttribute("listaDestino", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/index.jsp");
		rd.forward(request, response);
	}

	protected void listarImagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Destino destino = destinoDao.consultarImagemById(id); // Suponho que haja um método consultarImagemById que
																// retorna um objeto Destino com a imagem
		byte[] imagem = destino.getImagem(); // Supondo que a imagem está armazenada em um array de bytes na classe
												// Destino

		if (imagem != null) {
			response.setContentType("image/png");
			response.getOutputStream().write(imagem);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
