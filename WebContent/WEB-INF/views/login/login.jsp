<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <h2>ログイン</h2>
        <form method="POST" action="<c:url value='/login' />">
            <label for="email">メールアドレス</label><br />
            <input type="email" name="email" />
            <br /><br />

            <label for="password">パスワード</label><br />
            <input type="password" name="password" />
            <br /><br />

            <input type="hidden" name="u_token" value="${u_token}" />
            <button type="submit">ログイン</button>
        </form>
        <br /><br />
        <p><a href="<c:url value='/users/new' />">新規登録</a></p>
    </c:param>
</c:import>
