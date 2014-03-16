<%--
  Created by IntelliJ IDEA.
  User: e7006722
  Date: 12/03/14
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <script type="text/css">
        body {
            text-align: center;
            text-align: -webkit-center;
        }
    </script>
    <script type="application/javascript">
        function onUpdateDeleteClick(btn) {
            document.getElementById("action").value = btn.value;
            document.frmProblem.submit();
        }
    </script>
</head>
<body>
<h1>Problem Operations</h1>

<p><a href="/">Main Menu</a></p>
<table>
    <c:if test="${msg!=null}">
        <tr>
            <td>
                <div id="msg">${msg}</div>
            </td>
        </tr>
    </c:if>
    <c:if test="${error!=null}">
        <tr>
            <td>
                <div id="error" style="color: red">${error}</div>
            </td>
        </tr>
    </c:if>
    <tr>
        <td>
            <div id="search">
                <form method="POST" action="get.htm">
                    <input type="text" name="searchId">
                    <input type="submit" value="Search">
                </form>
                <form method="POST" action="list.htm">
                    <input type="submit" value="Search All">
                </form>

            </div>
        </td>
    </tr>
    <c:if test="${problem!=null}">
        <tr>
            <td>
                <div>
                    <form name="frmProblem" method="POST" action="deleteOrUpdate.htm">
                        <input type="hidden" id="action" name="action">
                        <table>
                            <tr>
                                <td>Problem Id</td>
                                <td><input type="text" name="id" value="${problem.id}"></td>
                            </tr>
                            <tr>
                                <td>Problem Details</td>
                                <td><input type="text" name="details" value="${problem.details}"></td>
                            </tr>
                            <tr>
                                <td>Found On</td>
                                <td><input type="text" name="foundOn" value="${problem.foundOn}"></td>
                            </tr>
                            <tr>
                                <td>Is Resolved</td>
                                <td><input type="text" name="isResolved" value="${problem.isResolved}"></td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="button" id="delete" name="Delete" value="delete"
                                           onclick="onUpdateDeleteClick(this)">
                                </td>
                                <td>
                                    <input type="button" id="update" name="Add/Update" value="update"
                                           onclick="onUpdateDeleteClick(this)">
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </td>
        </tr>
    </c:if>
    <c:if test="${list!=null}">
        <tr>
            <td>
                <div>
                    <table border="2px solid" style="padding: 2px; text-align: center">
                        <tr>
                            <th>Problem Id</th>
                            <th>Problem Details</th>
                            <th>Found On</th>
                            <th>Is Resolved</th>
                        </tr>
                        <c:forEach items="${list}" var="problem">
                            <tr>
                                <td><c:out value="${problem.id}"/></td>
                                <td><c:out value="${problem.details}"/></td>
                                <td><c:out value="${problem.foundOn}"/></td>
                                <td><c:out value="${problem.isResolved}"/></td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>
