<%-- 
    Document   : CurrentOpening
    Created on : Mar 29, 2016, 10:39:50 AM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Current Openings</title>
    </head>
    <body>
       <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>CURRENT OPENINGS</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Current Openings</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
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
                             <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                            <form:form action="" method="post" commandName=""
                                       name='form1'  class="form-horizontal" role="form">
                                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1" class=" table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty finalList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no Current Opening."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                
                                                                    <tr>
                                                                        <c:forEach var="list" items="${finalList}">
                                                                        <tr>
                                                                        <br>
                                                                        <img style="margin: auto;height: 500px;" src="${list}">
                                                                        <br> <hr>
                                                                        </tr>
                                                                        </c:forEach>
                                                                    </tr>
                                                               
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </table>
                                                </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>
                             
                            </form:form>
                        </div>
                    </div><!-- nav-tabs-custom -->
                </div>
            </div>
        </section>
    </div>
    </body>
     <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
