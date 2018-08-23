<%-- 
    Document   : ShowVacancyOnly
    Created on : 11 Aug, 2018, 4:35:30 PM
    Author     : Dell-1
--%>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Edit Vacancy</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>VIEW VACANCY</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View Vacancy</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
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
                                        </div>
                                        <!--<div class="form-group">-->


                                        <form:form class="form-horizontal" method="post"
                                                   commandName="vacancyMaster" action="vacancy.htm?act=submitVacancyApprove">
                                            <form:hidden path="id"></form:hidden>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Vacancy Name&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                        <span> ${vacancyMaster.name}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Vacancy Created Date&nbsp;&nbsp;:</label>
                                                    <span> ${vacancyMaster.fromDate}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Vacancy End Date:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span>${vacancyMaster.toDate}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Location&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span> ${locationName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Number Of Position:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span>${vacancyMaster.numberOfPosition}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Type&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span >${jobtypeNAme}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Department:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span>${departmentName}</span>    
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Role&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                    <span >${designationName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Work Experience(In Years)&nbsp;:</label>
                                                    <span>${vacancyMaster.experience}</span>   
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${vacancyMaster.description}</span>
                                                </div>
                                            </div>


                                        </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>

        <section class="content">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <label><h3>History</h3></label>
                            <div class="table table-bordered">
                                <table border="1" style="width: 100%;" >
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
                                                    <th style="width: 50px;">Name</th>
                                                    <th style="width: 50px;">Date & Time</th>
                                                    <th style="width: 50px;">Comment's</th>
                                                    <th style="width: 50px;">Status</th>
                                                </tr>
                                            </thead>
                                        </c:otherwise>
                                    </c:choose>
                                    <tbody>
                                        <c:forEach var="list" items="${list}">
                                            <tr>
                                                <td>${list[5]}</td>
                                                <td>${list[4]}</td>
                                                <td>${list[1]}</td>
                                                <td>${list[3]}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

    </script>
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script>
        initSample();


</script>
</html>
