<%-- 
    Document   : VisitorVisitedLocationEdit
    Created on : Feb 5, 2016, 2:25:41 PM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Visited Location Edit</title>

        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Checking ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
            $(function () {
                $("#username").focus();
            });

            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('id');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>Edit Visited Location: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Visited Location </li>
                    <li class="active">Visitor Visited Location Edit</li>
                </ol>
            </section>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                    <form:form class="form-horizontal" role="form" action="visitorVisitedLocation.htm?act=editSubmit" commandName="visitorVisitedLocation" 
                                               enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                                        <form:hidden path="id"></form:hidden>
                                            <div class="row">
                                            <%--<c:forEach var="locationList" items="locationList">--%>
                                                <div class="col-md-12">
                                                    <div class="box-header">
                                                        <div class="form-group">
                                                            <div class="col-sm-3">
                                                                <label class="control-label">Enter Location Name: <span style="color: red;font-size: 12px;">*</span></label>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <form:input path="location" placeholder="Enter Location Name" class="form-control" required="true"/>
                                                               
                                                            </div>
                                                            <br/>
                                                            <br/>
                                                            <br/>
                                                            <div class="form-group">
                                                                <div class="col-sm-6 col-sm-offset-5">
                                                                    <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Update" >
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%--</c:forEach>--%>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
