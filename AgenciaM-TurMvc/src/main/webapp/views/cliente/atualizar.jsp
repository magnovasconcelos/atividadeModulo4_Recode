<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trabalho Módulo - 4</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>

<body>
	<!--NAVEGAÇÃO-->
	<header>
		<nav class="navbar navbar-expand-lg fixed-top bg-white">
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
				<section class="section container">
					<form action="./cliente-atualizar" class="form-control">
						<fieldset>
							<legend class="text-center h3">
								Atualizar Cliente
							</legend>
							<div>
								<label for="cpf"></label> <input type="hidden"
									class="form-control" id="cpf" name="cpf" value="${cliente.cpf}"
									readonly>
							</div>
							<div>
								<label for="nomeCompleto">Nome Completo</label> <input
									type="text" class="form-control" id="nomeCompleto" name="nome"
									value="${cliente.nome}">
							</div>
							<div>
								<label for="email">E-mail</label> <input type="text"
									class="form-control" id="email" name="email"
									value="${cliente.email}">
							</div>
							<div>
								<label for="telefone">Telefone</label> <input type="tel"
									class="form-control" id="telefone" name="telefone"
									value="${cliente.telefone}">
							</div>
							<button type="submit" class="btn btn-dark mt-2 botao">Atualizar</button>

							<a href="./cliente" class="btn btn-dark mt-2 botao">Cancelar</a>
						</fieldset>
					</form>
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
</body>
</html>