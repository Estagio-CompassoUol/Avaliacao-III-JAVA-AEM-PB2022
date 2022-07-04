<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	

	Usuario Logado: ${usuarioLogado.logEmail }
		
	
	<br>
			
	Lista de produtos: <br>
	
	<br>
	  <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>DESCRIÇÃO</th>
                <th>PREÇO</th>            
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${produtos}" var="produto">            
                <tr>
                    <td>${produto.idProd }</td>
                    <td>${produto.nomeProd}</td>    
                    <td>${produto.descricao}</td>
                    <td>${produto.valor}</td>
                    <td><a href="/gbreletro/do?direct=AdicionarCarrinho&id=${produto.idProd }">Salvar no Carrinho</a></td>
                </tr>                
                
           </c:forEach>     
        </tbody>    
    </table>
	<a href="/gbreletro/do?direct=IrParaCarrinho">Ir para o Carrinho</a>
</body>
</html>
