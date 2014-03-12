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
            document.frmFacility.submit();
        }
    </script>
</head>
<body>
<h1>Facility Operations</h1>

<p><a href="/FacilityMgmt">Main Menu</a></p>
<table style="padding: 2px; text-align: center">
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
    <c:if test="${facility!=null}">
        <tr>
            <td>
                <div>
                    <form name="frmFacility" method="POST" action="deleteOrUpdate.htm">
                        <input type="hidden" id="action" name="action">
                        <table>
                            <tr>
                                <td>Facility Id</td>
                                <td><input type="text" name="id" value="${facility.id}"></td>
                            </tr>
                            <tr>
                                <td>Facility Name</td>
                                <td><input type="text" name="name" value="${facility.name}"></td>
                            </tr>
                            <tr>
                                <td>Facility details</td>
                                <td><input type="text" name="details" value="${facility.details}"></td>
                            </tr>
                            <tr>
                                <td>Available Capacity</td>
                                <td><input type="text" name="availableCapacity" value="${facility.availableCapacity}">
                                </td>
                            </tr>
                            <tr>
                                <td>In Use</td>
                                <td>
                                    <c:if test="${facility.inUse == 'true'}">
                                        <input type="checkbox" name="inUse" checked value="true">
                                    </c:if>
                                    <c:if test="${facility.inUse == 'false'}">
                                        <input type="checkbox" name="inUse" value="false">
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>Downtime</td>
                                <td><input type="text" name="downTime" value="${facility.downTime}"></td>
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
                            <th>Facility Id</th>
                            <th>Facility Name</th>
                            <th>Facility details</th>
                            <th>Available Capacity</th>
                            <th>In Use</th>
                            <th>Downtime</th>
                        </tr>
                        <c:forEach items="${list}" var="facility">
                            <tr>
                                <td><c:out value="${facility.id}"/></td>
                                <td><c:out value="${facility.name}"/></td>
                                <td><c:out value="${facility.details}"/></td>
                                <td><c:out value="${facility.availableCapacity}"/></td>
                                <td><c:out value="${facility.inUse}"/></td>
                                <td><c:out value="${facility.downTime}"/></td>
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
