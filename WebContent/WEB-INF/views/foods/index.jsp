<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
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
                    <tr class="row${status.count % 2}">
                        <td class="food_name">${food.food_name}</td>
                        <td class="amount">${food.amount}" <fmt:formatDate value='${report.report_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="open_flag">${food.open_flag}</td>
                        <td class="limit">${food.limit}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <p><a href="<c:url value='/foods/new' />">新購入品の登録</a></p>

    </c:param>
</c:import>
