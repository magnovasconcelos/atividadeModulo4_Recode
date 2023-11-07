<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!doctype html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
<title>Trabalho Módulo - 4</title>
</head>
<body>
	<!--NAVEGAÇÃO-->
	<header>
		<nav
			class="container-fluid navbar navbar-expand-lg fixed-top bg-white">
			<section class="section container-fluid">
				<a class="navbar-brand" href="#"><img
					src="./assets/img/imgLogo/mTur.jpg"
					class="img-thumbnail border-primary" alt="" width="50" height="50"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navTur"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<section class="section navbar-collapse" id="navTur">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 mx-auto">
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/destino">Destinos</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/views/promocoes/index.html">Promoções</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/contato">Contato</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/cliente">Cadastro</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/AgenciaM-TurMvc/reserva">Reservas</a></li>
					</ul>
					<div class="d-flex">
						<a href="#" class="text-dark me-3"><i class="bi bi-facebook"></i></a>
						<a href="#" class="text-dark me-3"><i class="bi bi-instagram"></i></a>
						<a href="#" class="text-dark me-3"><i class="bi bi-linkedin"></i></a>
						<a href="#" class="text-dark"><i class="bi bi-twitter"></i></a>
					</div>
				</section>
			</section>
		</nav>
	</header>
	<section class="container-fluid bg-primary conteiner-principal">
		<section class="container-fluid conteiner-segundario">
			<main>
				<section class="container">
					<div class="p-4">
						<a href="./views/contato/cadastrar.jsp"
							class="btn btn-dark mb-2 botao"> Novo</a> <a
							href="/AgenciaM-TurMvc/index.jsp" class="btn btn-dark mb-2 botao">Voltar</a>
						<table class="table table-responsive table-hover  text-center">
							<thead class="table-dark">
								<tr>
									<th scope="col">Assunto</th>
									<th scope="col">Mansagem</th>
									<th scope="col">Cliente (CPF)</th>
									<th scope="col">Atualizar / Deletar</th>
								</tr>
							</thead>
							<tbody>
								<jstl:forEach items="${listaContato}" var="c">
									<tr>
										<td>${c.assunto}</td>
										<td>${c.mensagem}</td>
										<td>${c.cliente.cpf}</td>
										<td>
											<div class="d-flex">
												<a href="contato-editar?cpf=${c.cliente.cpf}" class="mx-1"
													title="Editar"> <i class="bi bi-pencil-square"></i>
												</a> <a href="contato-deletar?cpf=${c.cliente.cpf}" class="mx-1"
													title="Remover"
													onclick="return confirm('Deseja excluir a mensagem do cliente ${c.cliente.cpf}.')">
													<i class="bi bi-trash"></i>
												</a>
											</div>
										</td>
									</tr>
								</jstl:forEach>
							</tbody>
						</table>
					</div>
				</section>
			</main>
		</section>
		<!--FOOTER-->
		<footer class="container-fluid mt-3 bg-white rodape">
			<div class="footer">
				<section class="row">
					<section class="col about-company text-center mt-3">
						<p>
							<span class="bi bi-facebook"><a href="#" class="link-dark"
								style="text-decoration: none"></a></span> <span class="bi bi-instagram"><a
								href="#" class="link-dark" style="text-decoration: none"></a></span> <span
								class="bi bi-linkedin"><a href="#" class="link-dark"
								style="text-decoration: none"></a></span> <span class="bi bi-twitter"><a
								href="#" class="link-dark" style="text-decoration: none"></a></span>
						</p>
					</section>
				</section>
				<section class="row">
					<section class="col copyright text-center">
						<p class="">
							<small class="text-dark-50">A maior empresa de turismo do
								Brasil - Viagem com a M-TUR | © 2023. Todos os Direitos
								Reservados</small>
						</p>
					</section>
				</section>
			</div>
		</footer>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"></script>
	</section>
</body>

</html>