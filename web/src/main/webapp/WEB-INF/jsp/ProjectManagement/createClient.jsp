<%-- 
    Document   : createClient
    Created on : Jun 18, 2018, 12:24:36 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head> 
        <title>Training Type Master </title>

    </head>
    <script>
        function checkBlankField() {
            var flag = true;
            if ($('#training').val().replace(/\s/g, "") == '') {
                document.getElementById('trainingError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            return flag;
        }
        function trainerOnchangeFunction(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }
    </script>

    <div class="content-wrapper">
        <section class="content-header">
            <h1> TRAINING TYPE MASTER</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Type Master</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <form:form class="form-horizontal" role="form1" action="projectManagement.htm?act=submitClient"  method="post" name='form' commandName="clientMaster" onsubmit='return checkBlankField();'>
            <form:hidden path="id"></form:hidden>
            <section class="content">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="name" id="name" class="form-control" placeholder="Name" onchange="trainerOnchangeFunction('trainingError');"></form:input>
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingError"></span>
                                                </div>
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Email ID:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="emailId" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required=""></form:input>
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingError"></span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:textarea path="address" class="form-control"  placeholder="Address"></form:textarea>    
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingError"></span>
                                                </div>
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Contact No:<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="contactNo" class="form-control" placeholder="Contact No"  required=""></form:input>
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingError"></span>
                                                </div>
                                            </div>


                                        <%--</c:if>--%>
                                        <div class="form-group">
                                            <div class=" col-sm-6 col-sm-offset-5">
                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
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
    </div>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

