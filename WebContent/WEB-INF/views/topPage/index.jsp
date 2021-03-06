<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
         <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>食料品管理システムへようこそ</h2>
        <br /><br />
        <p><a href="<c:url value='/foods/index' />">食料品一覧</a></p>
        <p><a href="<c:url value='/login' />">ログイン</a></p>
    </c:param>
</c:import>
