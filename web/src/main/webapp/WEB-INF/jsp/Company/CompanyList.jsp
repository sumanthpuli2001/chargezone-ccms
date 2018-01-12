<%-- 
    Document   : CompanyList
    Created on : 27 Sep, 2017, 5:15:52 PM
    Author     : Sejal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Company List</title>
        <script>
            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }
        </script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>All Companies List:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">All Companies List</li>
            </ol>
        </section>
        <form:form action="companyMaster.htm?act=deleteClick" method="post" commandName="companyMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'companyMaster.htm?act=createNew'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty companyList}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <th>Sr.No.</th>
                                                                    <th>Company Name</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach  var="companyList" items="${companyList}">
                                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="deptCheckId" value="${companyList.companyId}">
                                                                        </td>
                                                                        <td>
                                                                            <c:out value = "${count}"/>
                                                                        </td>
                                                                        <td>
                                                                            ${companyList.companyName}
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>

    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
