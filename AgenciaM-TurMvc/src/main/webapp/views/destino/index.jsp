<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!doctype html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
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
					<section class="">
						<div class="p-4">
							<a href="./views/destino/cadastrar.jsp"
								class="btn btn-dark mb-2 botao">Novo</a> <a
								href="/AgenciaM-TurMvc/index.jsp"
								class="btn btn-dark mb-2 botao">Voltar</a>
							<div class="container">
								<section class="row">
									<jstl:forEach items="${listaDestino}" var="d">
										<section class="col-md-4">
											<section class="card border-dark mb-3">
												<section class="card-body">
													<img src="destino-imagem?id=${d.id}" width="100"
														height="100" class="card-img-top img-fluid" alt="" />
													<p class="card-title text-center">${d.nomeDestino}</p>
													<p class="card-text text-center">${d.precoDestino}</p>
													<p class="card-text text-center">FAÇA A SUA RESERVA
														AGORA</p>
													<p class="card-text text-center">Reservar | Editar |
														Remover</p>
													<div class="d-flex">
														<a href="destino/reserva-editar?id=${d.id}" class="icons-cards"
															title="Reservar"
															onclick="return confirm('Deseja fazer essa reserva ${d.nomeDestino}.')">
															<i class="bi bi-check-square"></i>
														</a> <a href="destino-editar?id=${d.id}" class="mx-2"
															title="Editar"> <i class="bi bi-pencil-square"></i>
														</a> <a href="destino-deletar?id=${d.id}" class="mx-0"
															title="Remover"
															onclick="return confirm('Deseja excluir o destino ${d.nomeDestino}.')">
															<i class="bi bi-trash"></i>
														</a>
													</div>
												</section>
											</section>
										</section>
									</jstl:forEach>
								</section>
							</div>
						</div>
					</section>
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
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"></script>
</body>

</html>