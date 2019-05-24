<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Listagem de �lbuns</h2>
<br>
<table class="table">
	<thead>
		<th>ID</th>
		<th>Nome do �lbum</th>
		<th>Ano de Lan�amento</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty albuns}">
			<c:forEach items="${albuns}" var="album">
				<tr>
					<td>${album.id}</td>
					<td>${album.nome}</td>
					<td>${album.anoDeLancamento}</td>
					<td>
						<a href="/TreinaWebSpringMVC/albuns/alterar/${album.id}">Alterar</a>
						<a href="/TreinaWebSpringMVC/albuns/excluir/${album.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br>
<a href="/TreinaWebSpringMVC/albuns/adicionar" class="btn btn-default">Adicionar Novo �lbum</a>

