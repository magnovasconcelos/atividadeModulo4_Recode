package controller.destino;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DestinoDAO;
import model.Destino;

@WebServlet("/destino-cadastrar")
@MultipartConfig
public class DestinoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO destinoDao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoCadastrarServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setNomeDestino(request.getParameter("nome"));

		try {
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

			destinoDao.cadastrar(destino);
			response.sendRedirect("destino");

		} catch (NumberFormatException e) {

		}
	}

}
