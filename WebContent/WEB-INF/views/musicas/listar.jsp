<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h2>Listagem de M�sicas</h2>
<br>
<table class="table">
	<thead>
		<th>ID</th>
		<th>Nome da M�sica</th>
		<th>Data de Cria��o</th>
		<th>Nome do �lbum</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty musicas}">
			<c:forEach items="${musicas}" var="musica">
				<tr>
					<td>${musica.id}</td>
					<td>${musica.nome}</td>
					<td><fmt:formatDate value="${musica.dataCriacao}" pattern="dd/MM/yyyy" timeZone="UTC"/></td>
					<td>${musica.album.nome}</td>
					<td>
						<a href="/TreinaWebSpringMVC/musicas/alterar/${musica.id}">Alterar</a>
						<a href="/TreinaWebSpringMVC/musicas/excluir/${musica.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<br>
<a href="/TreinaWebSpringMVC/musicas/adicionar" class="btn btn-default">Adicionar Nova M�sica</a>

