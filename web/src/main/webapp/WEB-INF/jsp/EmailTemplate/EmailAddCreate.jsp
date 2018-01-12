<%-- 
    Document   :
    Created on : Oct 19, 2015, 5:34:20 PM
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <script>
        $(function () {
            var i = 1
            $("#addRowButtonId_table_1").on("click", function () {
                i++;
                var clone = "<div id = \"email_Id" + i + "\" class=\"form-group col-sm-12\" style=\"margin-left: 0px !important;margin-right:  0px !important;padding-left: 0px !important;padding-right: 0px !important;\" ><div class=\"col-sm-3\"></div><div class=\"col-sm-6\" >"
                        + "<input name ='emailId' id =\"emailId" + i + "\" class =\"form-control\" style=\"margin-top: 10px\">"
                        + "</input>"
                        + "</div>"
                        + "<div class=\"col-sm-3\" style=\"margin - top: 5px\">"
                        + "<span>"
                        + "<input type =\"button\" value=\"-\" onclick=\"removeIt('email_Id" + i + "');\"/>"
                        + "</span></div></div>";
                $("#id").append(clone);
                document.getElementById("countId").value = i;
                optionAdd(i);
            });
        });
        function optionAdd(id) {
            var element2 = document.getElementById('email_Id1');
            var obj2 = document.getElementById("emailId" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }
        function removeIt(ii) {
            var element1 = document.getElementById(ii);
            element1.parentNode.removeChild(element1);
        }

    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Add New Email</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Add New Email</li>
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
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" 
                                           commandName="emailAddMaster" action="emailAddMaster.htm?act=createSubmit">

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Enter Module Name:<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <form:select path="moduleName" class="form-control">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:option value="Leave" label="Leave" ></form:option>
                                                <form:option value="Attendance" label="Attendance" ></form:option>
                                                <form:option value="Travel" label="Travel" ></form:option>
                                                <form:option value="Expense" label="Expense" ></form:option>
                                                <form:option value="PMP" label="PMP" ></form:option>
                                                <form:option value="PIP" label="PIP" ></form:option>
                                                <form:option value="Pool Car" label="Pool Car" ></form:option>
                                                <form:option value="Gate Pass" label="Gate Pass" ></form:option>
                                                <form:option value="Cafeteria" label="Cafeteria" ></form:option>
                                                <form:option value="IT Service" label="IT Service" ></form:option>
                                                <form:option value="HR Service" label="HR Service" ></form:option>
                                                <form:option value="Probation To Conformation" label="Probation To Conformation" ></form:option>
                                                <form:option value="Resignation" label="Resignation" ></form:option>
                                                <form:option value="No Due" label="No Due" ></form:option>
                                                <form:option value="Exit Employee" label="Exit Employee" ></form:option>
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Department :<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <form:select path="departmentMaster.id" class="form-control">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <%--<form:option value="ALL" label="ALL" ></form:option>--%>
                                                <form:options items="${deptMap}"></form:options>
                                            </form:select>
                                            <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group" id="id">
                                            <div class="col-sm-3">
                                                <label class="control-label">Email Id:</label>
                                            </div>
                                            <input type="hidden" name="countId" id="countId" value="1">
                                            <div class="col-sm-6" id="email_Id1">
                                                <input id="emailId" name="emailId" class="form-control"  style="margin-bottom: 10px"/>
                                            </div>
                                            <div class="col-sm-3" style="margin-top: 5px">
                                                <span >
                                                    <input type="button" value="+" id="addRowButtonId_table_1" />
                                                </span></div><br/>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>

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
</html>
