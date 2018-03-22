<%-- 
    Document   : createtrainingmaster
    Created on : 3 Mar, 2018, 4:50:33 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head> 
        <title>Training Sub Type Master </title>

    </head>
    <script>
        function checkBlankField(){
            var flag = true;
            if($('#trainingsubtype').val() == ''){
                document.getElementById('trainingsubtypeError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if($('#trainingType').val() == ''){
                document.getElementById('trainingTypeError').innerHTML= '-It must not be empty or white space.';
                flag = false;
            }
                return flag;
        }
        
        function trainingOnChange(idString){
            if(document.getElementById(idString).innerHTML != null){
             document.getElementById(idString).innerHTML = '';       
            }
        }
    </script>
    
    
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Training Sub Type Master</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Sub Type Master</li>
            </ol>
        </section>
        <form:form class="form-horizontal" role="form1" action="trainingType.htm?act=SubmittraningSubtype"  method="post" name='form' commandName="trainingSubType" onsubmit='return checkBlankField();'>
            <form:hidden path="id"></form:hidden>
            <form:hidden path="createdby"></form:hidden>
            <form:hidden path="createddate"></form:hidden>
                <section class="content">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group"><div class="col-md-12 col-sm-12">
                                                <div class="col-sm-6">
                                                    <label>Training Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="trainingType.id"  class="form-control ">
                                                            <form:option label="-- Select --"  value="" ></form:option>
                                                            <c:forEach var="list" items="${list}" >
                                                                <form:option value="${list.key}">${list.value}</form:option>
                                                            </c:forEach>
                                                        </form:select>
                                                        <form:errors path="trainingType.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                        </div>
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Training Sub Type:<span style="color: red;font-size: 12px;"></span></label>
                                                    <form:input path="trainingsubtype" id="trainingsubtype" class="form-control" placeholder="Training Sub Type" onchange="trainingOnChange('trainingsubtypeError');"></form:input>
                                                         <span style="font-size: 14px; color: #dd4b39;" id="trainingsubtypeError"></span>
                                                <%--<form:errors path="trainingsubtype" cssClass="errorDiv"></form:errors>--%>
                                                    
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <fieldset>
                                                        <!--                                                    <input type="radio" name="status" id="status" value="0" checked>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                            <input type="radio" name="status" id="status" value="1">Inactive-->
                                                    <form:radiobutton path="status" id="status" name="status" required="required"  value="0"/>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <form:radiobutton path="status" id="status" name="status" required="required" value="1"/>Inactive
                                                </fieldset>
                                            </div>

                                        </div>

                                        <div class="form-group"><div class="col-md-12 col-sm-12">
                                                <div class="col-sm-6">
                                                    <label>Training Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="trainingType.id" id="trainingType" class="form-control " onchange="trainingOnChange('trainingTypeError');">
                                                            <form:option label="-- Select --"  value="" ></form:option>
                                                            <c:forEach var="list" items="${list}" >
                                                                <form:option value="${list.key}">${list.value}</form:option>
                                                            </c:forEach>
                                                        </form:select>
                                                     <span style="font-size: 14px; color: #dd4b39;" id="trainingTypeError"></span>
                                                    </div>
                                                </div></div>
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
