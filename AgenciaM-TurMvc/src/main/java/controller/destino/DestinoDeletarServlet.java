package controller.destino;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet("/destino-deletar")
public class DestinoDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoDeletarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		deletar(request, response);

	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		destinoDao.removerById(id);
		response.sendRedirect("destino");
	}

}
