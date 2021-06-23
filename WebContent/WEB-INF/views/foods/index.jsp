<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
         <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>食料品　一覧</h2>
        <table id="food_list">
            <tbody>
                <tr>
                    <th class="food_name">商品名</th>
                    <th class="amount">内容量</th>
                    <th class="open_flag">開封or未開封</th>
                    <th class="limit">賞味期限</th>
                    <th class=" ">賞味期限までの日数</th>
                </tr>
                <c:forEach var="food" items="${foods}" varStatus="status">
                <c:choose>
                    <c:when test="${food.open_flag == 0}">
                        string open_flag = "未開封"
                    </c:when>
                    <c:otherwise>
                        string open_flag = "開封"
                     </c:otherwise>
                 </c:choose>
                    <tr>
                        <td class="food_name"><a href="<c:url value='/foods/show?id=${food.id}' />"><c:out value="${food.food_name}" /></a> </td>
                        <td class="amount">${food.amount}</td>
                        <td class="amount">${food.open_flag}</td>
                        <td class="time_limit"><fmt:formatDate value='${food.time_limit}' pattern='yyy-MM-dd' /></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <p><a href="<c:url value='/foods/new' />">新購入品の登録</a></p>

    </c:param>
</c:import>
