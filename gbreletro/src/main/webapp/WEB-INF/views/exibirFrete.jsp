<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, model.Frete"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />	
	 <table>
        <thead>
            <tr>  
                <th>CEP  </th>
                <th>VALOR </th>
                <th>PRAZO   </th> 
                           
            </tr>
        </thead>
        <tbody> 
        	<c:forEach items="${frete}" var="freteP">       	          
                <tr>
                    <td>  ${freteP.cep}  </td>
                    <td>  R$ ${freteP.valorFrete}   </td>
                    <td>   ${freteP.prazo}  dias  </td>   
                </tr>
                
    			<form action="/gbreletro/do?direct=SalvarCarrinho" method="post">
    			
					<input type="hidden" name="cep" value="${freteP.cep}" />
					<input type="hidden" name="valor" value="${freteP.valorFrete}" />
					<input type="hidden" name="prazo" value="${freteP.prazo}" />
										
					<input type="submit"/>	
    			</form> 
            </c:forEach>    
        </tbody>    
    </table>    
       
</body>
</html>