<%-- 
    Document   : viewformatepage
    Created on : 14 Jun, 2018, 5:40:23 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>view Format Full And Final Settlement</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>VIEW FORMAT FULL AND FINAL SETTLEMENT</h1>
            <ol class="breadcrumb">
                <li><a href="homeController.htm?act=openHomePage"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">view Format Full And Final Settlement</li>
            </ol>
        </section>

        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="resignationMaster.htm?act=submitCraeteFormat" method="post" commandName="formateFullNdFinalLetter"
                   name='form1' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                <!--<button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>-->
                                <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'recruitment.htm?act=newCreateBudget'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                <%--</c:if>--%>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Company Name:<span style="color: red;font-size: 12px;">*</span></label>
<!--                                                     <label>Description:<span style="color: red;font-size: 12px;"></span></label>-->
                                                    <span >${formateFullNdFinalLetter.companyName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>DATE:<span style="color: red;font-size: 12px;">*</span></label>
<!--                                                     <label>Description:<span style="color: red;font-size: 12px;"></span></label>-->
                                                    <span >${formateFullNdFinalLetter.createDate}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <label>Description:<span style="color: red;font-size: 12px;"></span></label>
                                                    <span >${formateFullNdFinalLetter.description}</span>
                                                    </div>
                                                </div>
<!--                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>
                                                </div>-->
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div>
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

    <script>
        initSample();


    </script>
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
    </script>
</html>

