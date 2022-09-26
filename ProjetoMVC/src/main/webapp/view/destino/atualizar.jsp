<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Destino</title>

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
</head>
<body>
	<main>
		<header class="header">
			<div class="row my-4">
				<div class="col">
					<h1>Atualizar Destino</h1>
				</div>
			</div>

		</header>

		<div class="container py-3">
			<form action="./atualizar-destino">

			
			<div class="form-group mb-3">
					<label for="id" class="form-label"> Id </label> <input
						type="text" id="id" name="id" class="form-control"
						value="<%=request.getAttribute("id")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Nome </label> <input
						type="text" id="nome" name="nome" class="form-control"
						value="<%=request.getAttribute("nome")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="email" class="form-label"> Email </label> <input
						type="text" id="email" name="email" class="form-control"
						value="<%=request.getAttribute("email")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="telefone" class="form-label"> Telefone </label> <input
						type="text" id="telefone" name="telefone" class="form-control"
						value="<%=request.getAttribute("telefone")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="destino" class="form-label"> Destino </label> <input
						type="text" id="destino" name="destino" class="form-control"
						value="<%=request.getAttribute("destino")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="aerea" class="form-label"> Passagem Aérea </label> <input
						type="text" id="aerea" name="aerea" class="form-control"
						value="<%=request.getAttribute("aerea")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="preco" class="form-label"> Preço </label> <input
						type="text" id="preco" name="preco" class="form-control"
						value="<%=request.getAttribute("preco")%>" />
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>

				<a href="../../destino" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

	</main>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>