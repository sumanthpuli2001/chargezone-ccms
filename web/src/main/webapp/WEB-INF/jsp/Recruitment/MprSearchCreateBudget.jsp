<%-- 
    Document   : MprSearchCreateBudget
    Created on : 13 Feb, 2018, 11:08:23 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Registration Result</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Request For Man Power Requisition</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Request MPR</li>
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
                                                   commandName="recruitmentMaster" action="recruitment.htm?act=detailCreateForMpr">
                                           
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Man Power Planning Budget:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="budget" id="budget1" readonly="true" class="form-control" placeholder="Budget"></form:input>
                                                    <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>MPR Remaining Budget:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <input  id="remaining" name="remaining" readonly="true" class="form-control" placeholder="Remaining Budget"></input>
                                                    <form:errors  cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Job Type:<span style="color: red;font-size: 12px;">*</span></label>  &nbsp;&nbsp;&nbsp;
                                                    <%--<form:select disabled="true" path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" readonly="true">--%>
                                                        <span >${jobtypeNAme}</span>
                                                    <%--</form:select>--%>
                                                    <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                    <span>${departmentName}</span>    
                                                    <%--<form:select path="departmentMaster.id" id="departmentMaster" class="form-control" disabled="true" readonly="true">--%>
                                                            <%--<form:option value="" label="-- Select --" />--%>
                                                            <%--<form:options items="${deptMap}"></form:options>--%>
                                                        <%--</form:select>--%>
                                                        <%--<form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <div class="form-group">
<!--                                                    <div class="col-sm-6">
                                                        <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                        <%--<form:select path="locationMaster.id" id="locationMaster" class="form-control"  disabled="true" >--%>
                                                            <%--<form:option value="" label="-- Select --" />--%>
                                                            <%--<form:options items="${locationMap}"/>--%>
                                                        <%--</form:select>--%>
                                                        <%--<form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                    </div>-->
                                                    <div class="col-sm-6">
                                                        <label>Location:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;&nbsp;
                                                        <%--<form:select path="locationMaster.id" id="locationMaster" class="form-control"  disabled="true" >--%>
                                                            <%--<form:option value="" label="-- Select --" />--%>
                                                       
                                                        <span> ${locationName}</span>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Number Of Position:<span style="color: red;font-size: 12px;"></span></label>
                                                        <span>${position}</span>
                                                        <%--<form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position" disabled="true"></form:input>--%>
                                                        <%--<form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>--%>
                                                    </div>

                                                </div>
                                        </form:form>

                                        <form:form class="form-horizontal" method="post"
                                                   commandName="mprMaster" action="recruitment.htm?act=detailCreateForMpr">
                                               <input type="hidden" name="recruitmentMasterid" id="recruitmentMasterid" value="${recruitmentMaster.id}">
                                            <div class="form-group">
                                                <!--                                                <div class="col-sm-6">
                                                                                                    <label>Man Power Planning Budget:<span style="color: red;font-size: 15px;"></span><br>[${recruitmentMaster.budget}]&nbsp;&nbsp;&nbsp;&nbsp;Remaining Budget :<p id="demo657"></p></label>
                                                
                                                                                                </div>-->
                                                <div class="col-sm-6">
                                                    <label>MPR Budget:<span style="color: red;font-size: 12px;">*(Budget should be less than ${recruitmentMaster.budget} )</span></label>
                                                    <form:input path="budget" id="budget" onchange="onChangeTest(this)" class="form-control" placeholder="Budget"></form:input>
                                                    <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Job Role:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="designationMaster.id" id="designationMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${desigList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--<div class="col-sm-6">-->
                                                <%--<form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control">--%>
                                                <%--<form:option value="" label="-- Select --" />--%>
                                                <%--<form:options items="${jobtype1}"></form:options>--%>
                                                <%--</form:select>--%>
                                                <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                <!--</div>-->
                                            </div>
                                      
                                                <div class="form-group">
                                                   
                                                    <div class="col-sm-6">
                                                        <label>Vacancy Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="name" class="form-control" placeholder="Name"></form:input>
                                                    <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Work Experience(In Year):<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="experience" class="form-control" placeholder="Experience"></form:input>
                                                    <form:errors path="experience" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                
                                              
                                            
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <label>Job Description1:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:textarea path="description" class="form-control" id="editor"  placeholder="Description"></form:textarea>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
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
    </div>
    <script type="text/javascript">
        function onChangeTest(changeVal) {
            var x = document.getElementById("budget1").value;
            var y = document.getElementById("budget").value;
            var z = x - y;
            document.getElementById("remaining").value = z;
        }
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
