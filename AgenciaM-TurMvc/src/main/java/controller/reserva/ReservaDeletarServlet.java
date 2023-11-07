package controller.reserva;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import model.Reserva;

@WebServlet("/reserva-deletar")
public class ReservaDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO reservaDao = new ReservaDAO();
	Reserva reserva = new Reserva();

	public ReservaDeletarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		deletar(request, response);
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("numeroReserva"));
		reservaDao.removerByNumeroReserva(num);
		response.sendRedirect("reserva");

	}
}
