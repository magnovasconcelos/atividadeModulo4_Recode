package controller.reserva;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import model.Cliente;
import model.Destino;
import model.Reserva;

@WebServlet("/reserva-cadastrar")
public class ReservaCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO reservaDao = new ReservaDAO();
	Reserva reserva = new Reserva();
	Destino destino = new Destino();
	Cliente cliente = new Cliente();

	public ReservaCadastrarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		reserva.setDataReserva(data);
		Double valor = Double.parseDouble(request.getParameter("valor"));
		reserva.setValorReserva(valor);
		reserva.setFormaPagamento(request.getParameter("formaPagamento"));
		cliente.setCpf(request.getParameter("cpf"));
		reserva.setCliente(cliente);
		int id = Integer.parseInt(request.getParameter("id"));
		destino.setId(id);
		reserva.setDestino(destino);
		
		reservaDao.cadastrar(reserva);
		response.sendRedirect("reserva");

	}

}
