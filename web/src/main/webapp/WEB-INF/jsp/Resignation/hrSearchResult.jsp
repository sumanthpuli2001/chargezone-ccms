<%-- 
    Document   : hrSearchResult
    Created on : Jan 11, 2016, 5:44:54 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NO Due Result</title>
    </head>
 
  <script>

        function resign(id, empId) {
              window.location = 'resignationMaster.htm?act=Hrview&id=' + id + '&EmpId=' + empId;
        }
        function exit(id, empId) {
                 window.location = 'exitInterviewMaster.htm?act=createApproveOrReturn&id=' + id + '&empID=' + empId;
        }
        function nodue(id, empId) {
              window.location = 'noDueMaster.htm?act=createNoDueApproval&id=' + id + '&empID=' + empId;
        }
      </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1> Result: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Result</li>
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
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                        <c:when test="${empty SearchRequestResultList}">
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
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Resignation Status</th>
                                                                    <th>Exit Employee Status</th>
                                                                    <th>No Due Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${SearchRequestResultList}">
                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="hoursId" value="${list[0]}"/></td>-->
                                                                <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                               
                                                            <td>
                                                                <c:if test="${list[2] == 0}"><span class="badge">Pending</span></c:if>
                                                                <c:if test="${list[2] == 1}"><span class="label label-danger">Returned</span></c:if>
                                                                <c:if test="${list[2] == 2}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">Manager Approved</span></c:if>
                                                                <c:if test="${list[2] == 3}"><span class="badge">Pending</span></c:if>
                                                                <c:if test="${list[2] == 4}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">HR Approved</span></c:if>
                                                                
                                                                <c:if test="${list[2] == 5}"><span class="badge">Withdraw Pending</span></c:if>
                                                                <c:if test="${list[2] == 6}"><span class="label label-danger">Withdraw Returned</span></c:if>
                                                                <c:if test="${list[2] == 7}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">Withdraw Manager Approved</span></c:if>
                                                                <c:if test="${list[2] == 8}"><span class="badge">Withdraw Pending</span></c:if>   
                                                                <c:if test="${list[2] == 9}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">Withdraw HR Approved</span></c:if>
                                                            </td>
                                                            <td>
                                                                <c:if test="${list[3] == 0}"><span class="badge">Pending</span></c:if>
                                                                <c:if test="${list[3] == 1}"><span class="label label-danger">Returned</span></c:if>
                                                                <c:if test="${list[3] == 2}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Manager Approved</span></c:if>
                                                                <c:if test="${list[3] == 3}"><span class="badge">Pending</span></c:if>
                                                                <c:if test="${list[3] == 4}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">HR Approved</span></c:if>
                                                                
                                                                <c:if test="${list[3] == 5}"><span class="badge">Withdraw Pending span></c:if>
                                                                <c:if test="${list[3] == 6}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Withdraw Manager Approved</span></c:if>
                                                                <c:if test="${list[3] == 7}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Withdraw HR Approved</span></c:if>
                                                            </td>
                                                                
                                                            <td>
                                                                <c:if test="${list[4] == 0}"><span class="badge" onclick="nodue('${list[8]}','${list[5]}')">Pending</span></c:if>
                                                                <c:if test="${list[4] == 1}"><span class="label label-danger">Returned</span></c:if>
                                                                <c:if test="${list[4] == 2}"><span class="label label-success" onclick="nodue('${list[8]}','${list[5]}')">HR Approved</span></c:if>
                                                                <c:if test="${list[4] == 3}"><span class="badge" onclick="nodue('${list[8]}','${list[5]}')">Pending</span></c:if>
                                                                
                                                                <c:if test="${list[4] == 4}"><span class="badge" onclick="nodue('${list[8]}','${list[5]}')">Withdraw Pending</span></c:if>
                                                                <c:if test="${list[4] == 5}"><span class="label label-danger">Withdraw Returned</span></c:if>
                                                                <c:if test="${list[4] == 6}"><span class="label label-success" onclick="nodue('${list[8]}','${list[5]}')">Withdraw Approved</span></c:if>
                                                                <c:if test="${list[4] == 7}"><span class="badge" onclick="nodue('${list[8]}','${list[5]}')">Withdraw Pending</span></c:if>   
                                                            </td>
                                                                
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                        <br/>
                                        <br/>
                                        <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
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


