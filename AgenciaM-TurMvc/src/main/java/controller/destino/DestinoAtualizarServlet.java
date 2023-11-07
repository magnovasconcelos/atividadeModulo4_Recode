package controller.destino;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/destino-editar", "/destino/reserva-editar", "/destino-atualizar" })
@MultipartConfig
public class DestinoAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino-editar":
			editar(request, response);
			break;
		case "/destino/reserva-editar":
			editarReserva(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino-atualizar":
			atualizar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destino = destinoDao.consultarById(id);
		request.setAttribute("destino", destino);
		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/atualizar.jsp");
		rd.forward(request, response);
	}

	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		destino.setId(id);
		destino.setNomeDestino(request.getParameter("nome"));
		Double preco = Double.parseDouble(request.getParameter("preco"));
		destino.setPrecoDestino(preco);
		
		Part imagemPart = request.getPart("imagem");

		InputStream imagemInputStream = imagemPart.getInputStream();

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];
		while ((nRead = imagemInputStream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();

		byte[] imagemData = buffer.toByteArray();

		destino.setImagem(imagemData);
		destinoDao.atualizar(destino);
		response.sendRedirect("destino");

	}
	
	protected void editarReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destino = destinoDao.consultarById(id);
		request.setAttribute("destino", destino);
		RequestDispatcher rd = request.getRequestDispatcher("../views/reserva/cadastrar.jsp");
		rd.forward(request, response);
	}

}
