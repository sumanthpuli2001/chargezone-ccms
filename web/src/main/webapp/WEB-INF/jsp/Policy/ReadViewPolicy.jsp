<%-- 
    Document   : ReadViewPolicy
    Created on : 13 Jul, 2018, 11:19:11 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Read Policy:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
                <li class="active">Read</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" enctype="multipart/form-data" name='form' role="form" commandName="policyCreate" onsubmit='return saveSubmit11();' action="policyMaster.htm?act=policyAccept">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Enter Policy Name:<span style="color: red;font-size: 5px;">*</span></label>
                                            </div>
                                            <div class="col-sm-5">
                                            <form:input path="name" id="name" class="form-control" placeholder="Policy Name" readonly="true"/>
                                            <span id="nameError" style="color: red;"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">${policyDropDown.name}
                                        <input type="hidden" name="policyName" id="policyName" value="${policyDropDown.name}">
                                        <div class="col-sm-3">
                                            <label>policy Type :<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-5">
                                            <select name="policyId1" id="policyId1"  class="form-control" readonly="true">
                                                <c:forEach var="comp" items="${policydp}">
                                                    <option value="${comp.key}" label="${comp.value}" ></option>
                                                </c:forEach>
                                            </select>
                                            <span id="policyError" style="color: red;"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment:<span style="color: red;font-size: 5px;">*</span></label>
                                        </div>
                                        <div class="col-sm-5">
                                            <%--<form:input type="file" path="attachment" id="attachment" class="form-control" accept="image/jpg,image/jpeg,image/png" onchange="attachment(1);" readonly="true"/>--%>
                                            <a href="StorageYard/policyAttachment/${policyCreate.attachment}">${policyCreate.attachment}</a>
                                            <span id="attachmentError" style="color: red;"></span>
                                        </div>
                                    </div>
                                    <c:if test="${employeeMaster.id != policyCreate.acceptByPolicyId || policyCreate.acceptPolicy != 1}">
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Accept">
                                        </div>
                                    </c:if>
                                </div>
                            </form:form>
                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>
</section><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<script>
    function attachment(id) {
        if (typeof FileReader !== "undefined") {
            var fileSize = document.getElementById('certificateId' + id).files[0].size;
//                alert("my File size is   " + fileSize);
            if (fileSize > 1048576) {
                document.getElementById('certificateId' + id).value = '';
                document.getElementById('certificateError').innerHTML = "- It must not more than 1mb";
            } else {
                document.getElementById('certificateError').innerHTML = '';
            }
            // check file size
        }


    }
</script>
</html>
