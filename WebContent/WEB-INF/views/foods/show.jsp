<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${food != null}">
                <h2>食料品　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>商品名</th>
                            <td><c:out value="${food.food_name}" /></td>
                        </tr>
                        <tr>
                            <th>内容量</th>
                            <td><c:out value="${food.amount}" /></td>
                        </tr>
                        <tr>
                            <th>開封or未開封</th>
                            <td><c:out value="${food.open_flag}" /></td>
                        </tr>
                        <tr>
                            <th>賞味期限</th>
                            <td>
                                <fmt:formatDate value="${food.time_limit}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>購入者</th>
                            <td>
                                <c:out value="${food.user.name}" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_user.id == food.user.id}">
                    <p><a href="<c:url value="/foods/edit?id=${user.id}" />">編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/foods/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>