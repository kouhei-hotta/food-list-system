<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="food_name">商品名</label><br />
<input type="text" name="food_name" value="${food.food_name}" />
<br /><br />

<label for="amount">内容量</label><br />
<input type="text" name="amount" value="${food.amount}" />
<br /><br />

<input type="radio" name="open_flag" value="1">開封 <br />
<input type="radio" name="open_flag" value="0">未開封
<br /><br />


<label for="time_limit">賞味期限</label><br />
<input type="date" name="time_limit" value="${food.time_limit}" />
<br /><br />

<input type="hidden" name="u_token" value="${u_token}" />
<button type="submit">登録</button>
