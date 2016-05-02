<%-- 
    Document   : HrResult
    Author     : Vinita
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exit Interview Result</title>
    </head>
    <script>

        function viewClick(id, empId) {
            window.location = 'exitInterviewMaster.htm?act=createApproveOrReturn&id=' + id + '&empID=' + empId;
        }

        function toggle(source) {
            var checkboxes = document.getElementsByName('hoursId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                checkboxes[i].checked = source.checked;
            }
        }
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



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Exit Interview Result: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Exit Interview</li>
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
                                                                    <th>Employee id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                    <c:forEach var="list" items="${list}">
                                                            <tr>
                                                               <td>${list[4]}</td>
                                                                <td>${list[2]}</td>
                                                                 <c:if test="${list[3] == 1}"><td><span class="badge">Pending</span></td></c:if>
                                                                 <%--<c:if test="${list[3] == 2}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                 <%--<c:if test="${list[3] == 6}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                 <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"  onclick="viewClick('${list[0]}', '${list[1]}');" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;View
                                                                            </button>
<!--                                                                            <ul class="dropdown-menu">
                                                                                <li>
                                                                                    <a href="#"
                                                                           >
                                                                                      
                                                                                </a>
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
                                        <br/>
                                        <br/>
                                        <div class="col-sm-6">
                                            <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                        </div><!-- /.row -->
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


