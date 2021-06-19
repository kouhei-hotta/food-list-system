<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<label for="food_name">商品名</label><br />
<input type="text" name="food_name" value="${food.food_name}" />
<br /><br />

<label for="amount">内容量</label><br />
<input type="text" name="amount" value="${food.amount}" />
<br /><br />

<input type="radio" name="radiobutton" value="${food.open_flag}">開封 <br />
<input type="radio" name="radiobutton" value="${food.unopen_flag}">未開封
<br /><br />


<label for="limit">賞味期限</label><br />
<input type="date" name="limit" value="${food.limit}" />
<br /><br />

<input type="hidden" name="u_token" value="${u_token}" />
<button type="submit">登録</button>
