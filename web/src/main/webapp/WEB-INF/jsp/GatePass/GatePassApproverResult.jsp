<%-- 
    Document   : GatePassApproverResult
    Created on : Nov 24, 2015, 6:49:37 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
            <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Gate Pass</title>
          <script>
            function viewClick(id, empId) {
                window.location = "gatePass.htm?act=viewClick&id=" + id + "&empId=" + empId;
            }
        </script>
    </head>
    <body>
  <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Gate Pass Form: </h1>
                <div style="float: right"></div>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Gate Pass</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <form:form action="" method="post" commandName="gatePass"
                       name='form1' class="form-horizontal" role="form">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div style="clear: both"></div>
                                    <div class="box-header">
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                                        <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                        <th>Emp Id</th>
                                                                        <th>Emp Name</th>
                                                                        <th>Assets</th>
                                                                        <th>Return Type</th>
                                                                        <th>Date And Time</th>
                                                                        <th>Status</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}">
                                                                <tr>
                                                                    <!--<td></td>-->
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>
                                                                       <c:if test="${list[4] eq true}">Returnable Gate Pass</c:if>
                                                                       <c:if test="${list[4] eq false}">Non-Returnable Gate Pass</c:if>
                                                                        </td>
                                                                    <td>${list[5]}</td>
                                                                     <td><c:if test="${list[7] eq 1}">
                                                                       <span class="badge">Approval Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 7}">
                                                                        <span class="label label-warning">Returned by Security</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 8}">
                                                                       <span class="badge">Approval Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 10}">
                                                                      <span class="badge">Withdraw Pending</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 17}">
                                                                      <span class="label label-warning">Returned Withdraw</span>
                                                                        </c:if>
                                                                        <c:if test="${list[7] eq 18}">
                                                                             <span class="badge">Withdraw Pending</span>
                                                                        </c:if>
                                                                      </td>  
                                                                        
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button"  onclick="viewClick(${list[0]},${list[6]});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                            View
                                                                                </button>
<!--                                                                                <ul class="dropdown-menu">
                                                                                    <li>
                                                                                    </li>
                                                                                </ul>-->
                                                                            </div>
                                                                        </td>
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
    </body>
</html>
