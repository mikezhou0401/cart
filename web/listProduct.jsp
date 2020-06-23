<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${!empty user}">
    <div align="center">
        当前用户: ${user.name}
    </div>
</c:if>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <form action="addOrderItem" method="post">

                    数量<input type="text" value="1" name="num">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" value="加入购物车">
                </form>

            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4" align="center"><a href="/listOrderItem">查看购物车</a></td>

    </tr>
</table>