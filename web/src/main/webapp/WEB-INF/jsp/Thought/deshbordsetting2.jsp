<%-- 
    Document   : Dashbordsetting
    Created on : 20 Feb, 2018, 9:57:16 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Dashbord Setting </title>
        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete?");
                if(checkboxes){
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                
                alert("Please, Select one or more record(s).");
                }
                return false;
            }
        </script>
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Dashbord Setting</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li><li>Setting</li>
                <li class="active">Dashbord Setting</li>
            </ol>
        </section>
       <ul class="nav nav-tabs">
    <li><a href="thoughtMaster.htm?act=createthought">Thought oF the Day</a></li>
    <li><a href="thoughtMaster.htm?act=createthought1">Upload Video</a></li>
    <li class="active"><a href="">Gallery</a></li>
    <li><a href="thoughtMaster.htm?act=createthought3">R & R</a></li>
  </ul> 
        <form:form action="thoughtMaster.htm?act=deletegallerySubmit" method="post"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>

                                <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'thoughtMaster.htm?act=creategallery'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
                                </c:if>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                                        </c:if>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Image</th>
                                                                    <th style="width: 50px;">Description</th>
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td><img src="StorageYard/galleryimage/${list[1]}" width="50px; !important" height="50px; !important">${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
<!--                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                Action <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu" >
                                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                                    
                                                                                <li style="width: 100px;">
                                                                                    <a href="#"
                                                                                       onclick="viewClick(${list[0]});">
                                                                                        onclick="viewClick($//{list[0]},$//{list[1]});">
                                                                                        &nbsp;&nbsp;Edit
                                                                                    </a>
                                                                                </li>
                                                                                </c:if>
                                                                            </ul>
                                                                        </div>
                                                                    </td>-->
                                                                <%--</c:if>--%>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>
    </div>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
