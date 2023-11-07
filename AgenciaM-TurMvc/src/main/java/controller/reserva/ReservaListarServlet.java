package controller.reserva;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Reserva;

@WebServlet("/reserva")
public class ReservaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO reservaDao = new ReservaDAO();
	Reserva reserva = new Reserva();
	Destino destino = new Destino();
	Cliente cliente = new Cliente();

	public ReservaListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/reserva":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reserva> lista = reservaDao.getReserva();
		request.setAttribute("listaReserva", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/index.jsp");
		rd.forward(request, response);
	}

}
