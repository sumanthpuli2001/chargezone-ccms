<%-- 
    Document   : KraCategoryEdit
    Created on : Feb 23, 2016, 5:55:57 PM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KRA Category</title>
    </head>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <c:if test="${!empty successmessage}" >
                <script>
                    alert("${successmessage}");
                </script>
                <!--<div class="fadeOutEffect alert alert-success" role="alert"></div>-->
            </c:if>
            <c:if test="${!empty failuremessage}">
                <script>
                    alert("${failuremessage}");
                </script>
                <!--<div class="fadeOutEffect alert alert-danger" role="alert"></div>-->
            </c:if>

            <section class="content-header">
                <h1>KRA CATEGORY</h1>

            </section>
            <div class="content">
                <!-- Main content -->
                <form:form action="kraCategory.htm?act=createSubmit" method="post" commandName="kraCategory"
                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                    <form:hidden path="id"></form:hidden>
                        <!--<form class="form-horizontal" role="form" commandName>-->

                        <!--Read only entries Starts here-->
                        <!--<div class="box box-info collapsed-box ">-->
                        <div class="row">
                            <div class="col-sm-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <div class="box-body no-padding">
                                            <!--<div class="row">-->
                                            <div class="col-sm-6 ">                                                
                                                <div class="form-group">
                                                    <!--<div class="col-sm-4">-->
                                                    <label>KRA Category<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div>
                                                    <form:input  path="kraCategoryName" class="col-sm-6 form-control" required="true" />
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <button  type="submit" class="btn btn-primary" style="width: 100px;" id="saveSubmit1" >SUBMIT</button>
                                    <br/>
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </form:form>
            </div>
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>

</html>
