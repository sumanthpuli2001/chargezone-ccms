<%-- 
    Document   : AppraisalFillingDataResult
    Created on : Oct 26, 2015, 3:19:35 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Filling Data Result</title>
    </head>
    <script>
        function editClick(id) {
           
            window.location = 'appraisalFillingData.htm?act=editClick&id=' + id;
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
            <h1>CYCLE TIME-LINE SETTING </h1>
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
        <form:form action="appraisalFillingData.htm?act=deleteSubmit" method="post" commandName="appraisalFillingData" 
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>
                                <button type="button" class="btn btn-primary" style="float: right" onclick="window.location = 'appraisalFillingData.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;New</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered table-responsive">
                                                <table id="table_1" class="table table-bordered table-striped table-hover table" style="" align="Center"  >
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
                                                                    <th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>
                                                                    <th>Cycle Name</th>
                                                                    <th style="font-size: 12px;">Cycle Start From Date</th>
                                                                    <th style="font-size: 12px;">Cycle Start To Date</th>
                                                                    <!--                                                                    <th style="font-size: 12px;">Manager Time-Line Start Date</th>manager
                                                                                                                                        <th style="font-size: 12px;">Manager Time-Line End Date</th>manager-->
                                                                    <!--                                                                    <th style="font-size: 12px;">Employee Time-Line Mid Year Start Date</th>
                                                                                                                                        <th style="font-size: 12px;">Employee Time-Line Mid Year End Date</th>-->
                                                                    <!--                                                                    <th style="font-size: 12px;">Manager Time-Line Mid-Year Start Date</th>manager
                                                                                                                                        <th style="font-size: 12px;">Manager Time-Line End-Year End-Date</th>manager-->
                                                                    <th style="font-size: 12px;">Cycle End From Date</th>
                                                                    <th style="font-size: 12px;">Cycle End To Date</th>
                                                                    <!--                                                                    <th style="font-size: 12px;">Manager Time-Line Year Start Date</th>
                                                                                                                                        <th style="font-size: 12px;">Manager Time-Line Year End Date</th>-->
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td align="center"><input type="checkbox" name="checkId" id="leaveTypeId" value="${list.id}"/></td>
                                                                <td>${list.year}</td>
                                                                <td>${list.startDate}</td>
                                                                <td>${list.endDate}</td>
<!--                                                                <td>${list.managerStartDate}</td>manager
                                                                <td>${list.managerEndDate}</td>manager-->
<!--                                                                <td>${list.midYearStartDate}</td>
                                                                <td>${list.midYearEndDate}</td>-->
<!--                                                                <td>${list.managerMidYearStartDate}</td>manager
                                                                <td>${list.managerMidYearEndDate}</td>manager-->
                                                                <td>${list.yearEndStartDate}</td>
                                                                <td>${list.yearEndEndDate}</td>


<!--                                                                <td>${list.managerYearEndStartDate}</td>
<td>${list.managerYearEndEndDate}</td>-->
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button"  onclick="editClick(${list.id});" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            <!--Action <span class="caret"></span>-->
                                                                            <span class="fa fa-pencil"></span>
                                                                            <!--<ul class="dropdown-menu">-->
                                                                            <!--<li>-->
                                                                            <a href="#">&nbsp;&nbsp;Edit</a>
                                                                            <!--</li>-->
                                                                        </button>


                                                                        <!--</ul>-->
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

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
