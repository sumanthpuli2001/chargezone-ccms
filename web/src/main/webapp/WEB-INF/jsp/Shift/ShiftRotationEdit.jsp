<%--
    Document   : ShiftRotationEdit
    Created on : Nov 5, 2015, 10:59:06 AM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shift Rotation Create</title>
    </head>
    <script>
        $(function () {
            var i = document.getElementById("countId").value;
            $("#addRowButtonId_table_1").on("click", function () {
                i++;
                var clone = "<div id = \"shift_nameId" + i + "\" class=\"form-group col-sm-12\" style=\"margin-left: 0px !important;margin-right:  0px !important;padding-left: 0px !important;padding-right: 0px !important;\"><div class=\"col-sm-3\"></div><div class=\"col-sm-6\" >"
                        + "<select name =\"shiftMaster" + i + "\" id =\"shiftMaster" + i + "\" class =\"form-control\">"
                        + "</select>"
                        + "</div>"
                        + "<div class=\"col-sm-3\" style=\"margin - top: 5px\">"
                        + "<span>"
                        + "<input type =\"button\" value=\"-\" id=\"addRowButtonId_table_1\" onclick=\"remove111('shift_nameId" + i + "');\"/>"
                        + "</span></div></div>";
                $("#shift_nameId").append(clone);
                document.getElementById("countId").value = i;
                optionAdd(i);
            });
        });
        function optionAdd(id) {
            var element2 = document.getElementById('shiftMaster1');
            var obj2 = document.getElementById("shiftMaster" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }
        function remove111(ii) {
//            alert(ii);
            var element1 = document.getElementById(ii);
            element1.parentNode.removeChild(element1);
        }
    </script>
    <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Shift Rotation </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="shiftRotationMaster.htm?act=editSubmit" method="post" commandName="shiftRotationMaster"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>

                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-header">

                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class=" col-sm-3">

                                                        <label>Title:</label>
                                                    </div>
                                                    <div class="col-sm-6">
                                                    <form:input path="title" class="form-control" placeholder="Enter title"></form:input>
                                                    <form:errors path="title" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <div class="form-group" id="shift_nameId">

                                                    <div class=" col-sm-3">
                                                        <label>Shift Name:</label>
                                                    </div>
                                                    <input type="hidden" name="countId" id="countId" value="${fn:length(list)}">

                                                <div class=" col-sm-6" id="shift_nameId1">
                                                    <c:forEach var="list" items="${list}" varStatus="status">
                                                        <input type="hidden" name="shiftId${status.count}" id="shiftId${status.count}" value="${list.id}">
                                                        <select name="shiftMaster${status.count}" id="shiftMaster${status.count}" class="form-control" value="" >
                                                            <option value="" label="-- Select --" />
                                                            <c:forEach var="shiftList" items="${shiftMap}">
                                                                <c:if test="${shiftList.key eq list.shiftMaster.id}">

                                                                    <option value="${shiftList.key}" selected="">${shiftList.value}</option>
                                                                </c:if>
                                                                <c:if test="${shiftList.key ne list.shiftMaster.id}">

                                                                    <option value="${shiftList.key}">${shiftList.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select><br/>
                                                    </c:forEach>
                                                </div>


                                                <div class="col-sm-3" style="margin-top: 5px">
                                                    <span >
                                                        <input type="button" value="+" id="addRowButtonId_table_1" />
                                                    </span></div><br/>
                                            </div>
                                            <div class="form-group">
                                                <div class=" col-sm-3">
                                                    <label>Duration:</label>
                                                </div>
                                                <div class=" col-sm-6">
                                                    <form:select path="duration" class="form-control" >
                                                        <form:option value="">--select--</form:option>
                                                        <form:option value="monthly">Monthly</form:option>
                                                        <form:option value="weekly">Weekly</form:option>
                                                        <form:option value="fortNightly">FortNightly</form:option>
                                                    </form:select>
                                                    <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class=" col-sm-3">

                                                        <label>Remark:</label>
                                                    </div>
                                                    <div class=" col-sm-6">
                                                    <form:input path="remark" class="form-control" placeholder="Enter Remark"></form:input>
                                                    <form:errors path="remark" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>




                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                        <div class="col-md-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                        </div>
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
