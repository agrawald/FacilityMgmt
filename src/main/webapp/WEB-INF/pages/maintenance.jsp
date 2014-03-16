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
            document.frmMaintenance.submit();
        }
    </script>
</head>
<body>
<h1>Maintenance Operations</h1>

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
    <c:if test="${maintenance!=null}">
        <tr>
            <td>
                <div>
                    <form name="frmMaintenance" method="POST" action="deleteOrUpdate.htm">
                        <input type="hidden" id="action" name="action">
                        <table>
                            <tr>
                                <td>Maintenance Id</td>
                                <td><input type="text" name="id" value="${maintenance.id}"></td>
                            </tr>
                            <tr>
                                <td>Facility Id</td>
                                <td><input type="text" name="facilityId" value="${maintenance.facilityId}"></td>
                            </tr>
                            <tr>
                                <td>Cost</td>
                                <td><input type="text" name="cost" value="${maintenance.cost}"></td>
                            </tr>
                            <tr>
                                <td>Start Date</td>
                                <td><input type="text" name="startDate" value="${maintenance.startDate}">
                                </td>
                            </tr>
                            <tr>
                                <td>End Date</td>
                                <td><input type="text" name="endDate" value="${maintenance.endDate}">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="button" id="delete" name="Delete" value="delete"
                                           onclick="onUpdateDeleteClick(this)">
                                </td>
                                <td>
                                    <input type="button" id="update" name="Update" value="update"
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
                            <th>Maintenance Id</th>
                            <th>Facility Id</th>
                            <th>Cost</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                        </tr>
                        <c:forEach items="${list}" var="maintenance">
                            <tr>
                                <td><c:out value="${maintenance.id}"/></td>
                                <td><c:out value="${maintenance.facilityId}"/></td>
                                <td><c:out value="${maintenance.cost}"/></td>
                                <td><c:out value="${maintenance.startDate}"/></td>
                                <td><c:out value="${maintenance.endDate}"/></td>
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
