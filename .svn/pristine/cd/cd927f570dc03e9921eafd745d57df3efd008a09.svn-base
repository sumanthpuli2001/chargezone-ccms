<%--
    Document   : TravelCashAdvanceResult
    Created on : Mar 22, 2016, 11:12:13 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cash Advance Section</title>
    </head>
    <script>

        function viewClick(travelId, empId) {

            window.location = 'travelRequestMaster.htm?act=updateCashAdvanceSectionByAdmin&travelId=' + travelId + '&empId=' + empId;
        }

    </script>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Cash Advance Section: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Cash Advance Section</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="" method="post" commandName=""
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty approvedTravelReqList}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Department</th>
                                                                    <th>Designation</th>
                                                                    <th>Travel Type</th>
                                                                    <th>Travel Request No.</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>

                                                    <c:forEach var="approvedTravelReqList" items="${approvedTravelReqList}">
                                                        <tr>
                                                            <td>${approvedTravelReqList[0]}</td>
                                                            <td>${approvedTravelReqList[1]}</td>
                                                            <td>${approvedTravelReqList[2]}</td>
                                                            <td>${approvedTravelReqList[3]}</td>
                                                            <td>${approvedTravelReqList[4]}</td>
                                                            <td>${approvedTravelReqList[5]}</td>
                                                            <td>
                                                                <div class="btn-group">
                                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick('${approvedTravelReqList[6]}', '${approvedTravelReqList[7]}');">
                                                                        &nbsp;&nbsp;View</button>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
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
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>



