package controller.reserva;

import java.io.IOException;
import java.time.LocalDate;

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

@WebServlet(urlPatterns = {"/reserva-editar", "/reserva-atualizar"})
public class ReservaAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservaDAO reservaDao = new ReservaDAO();
	Destino destino = new Destino();
	Reserva reserva = new Reserva();
	Cliente cliente = new Cliente();

	public ReservaAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/reserva-editar":
			editar(request, response);
			break;
		case "/reserva-atualizar":
			atualizar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("numeroReserva"));
		reserva = reservaDao.consultarByNumeroReserva(num);
		request.setAttribute("reserva", reserva);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reserva/atualizar.jsp");
		rd.forward(request, response);
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("numeroReserva"));
		reserva.setNumeroReserva(num);
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		reserva.setDataReserva(data);
		Double valor = Double.parseDouble(request.getParameter("valor"));
		reserva.setValorReserva(valor);
		reserva.setFormaPagamento(request.getParameter("formaPagamento"));
		//cliente.setCpf(request.getParameter("cpf"));
		//reserva.setCliente(cliente);
		//int id = Integer.parseInt(request.getParameter("id"));
		//destino.setId(id);
		//reserva.setDestino(destino);
		reservaDao.atualizar(reserva);
		response.sendRedirect("reserva");
	}

}
