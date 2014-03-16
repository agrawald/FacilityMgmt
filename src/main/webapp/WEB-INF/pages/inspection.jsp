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
            document.frmInspection.submit();
        }
    </script>
</head>
<body>
<h1>Inspection Operations</h1>

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
    <c:if test="${inspection!=null}">
        <tr>
            <td>
                <div>
                    <form name="frmInspection" method="POST" action="deleteOrUpdate.htm">
                        <input type="hidden" id="action" name="action">
                        <table>
                            <tr>
                                <td>Inspection Id</td>
                                <td><input type="text" name="id" value="${inspection.id}"></td>
                            </tr>
                            <tr>
                                <td>Inspection Details</td>
                                <td><input type="text" name="details" value="${inspection.details}"></td>
                            </tr>
                            <tr>
                                <td>Usage Id</td>
                                <td><input type="text" name="usageId" value="${inspection.usageId}">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="button" id="delete" name="Delete" value="Delete"
                                           onclick="onUpdateDeleteClick(this)">
                                </td>
                                <td>
                                    <input type="button" id="update" name="Add/Update" value="Add/Update"
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
                            <th>Inspection Id</th>
                            <th>Inspection details</th>
                            <th>Usage ID</th>
                        </tr>
                        <c:forEach items="${list}" var="inspection">
                            <tr>
                                <td><c:out value="${inspection.id}"/></td>
                                <td><c:out value="${inspection.details}"/></td>
                                <td><c:out value="${inspection.usageId}"/></td>
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
