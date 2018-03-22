<%--
    Document   : LeaveApplicationResult
    Created on : Oct 16, 2015, 4:07:58 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script>
    function reviewClick(f2fRequestId) {
        window.location = 'candidateF2FApproval.htm?act=openInterviewReviewPage&id='+f2fRequestId;
    }
</script>

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        
        <title>F2F Interview List</title>
    </head>




    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>F2F Interview List: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">F2F Interview List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <form:form action="" method="post" commandName=""
                   name='form1' class="form-horizontal" role="form">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->

                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>-->
                            <div style="clear: both"></div>

                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty F2FInterviewList}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th>Candidate Name</th>
                                                                <th>Vacancy Name</th>
                                                                <th>Date</th>
                                                                <th>Status</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                    </c:otherwise>
                                                </c:choose>
                                                <tbody>
                                                    <c:forEach var="list" items="${F2FInterviewList}">
                                                        <tr>

                                                            <td>${list[1]}</td>
                                                            <td>${list[2]}</td>
                                                            <td>${list[3]}</td>
                                                            <td>
                                                                <c:if test="${list[4] eq 0}">

                                                                    <span>Pending</span>    
                                                                </c:if>
                                                                <c:if test="${list[4] eq 1}">

                                                                    <span>Submitted By Comittee</span>    
                                                                </c:if>
                                                                <c:if test="${list[4] eq 2}">

                                                                    <span>
                                                                        Submitted By HR

                                                                    </span>    
                                                                </c:if>
                                                                <c:if test="${list[4] eq 3}">

                                                                    <span>
                                                                        Final Submitted

                                                                    </span>    
                                                                </c:if>


                                                            </td>

                                                            <td>
                                                                <div class="btn-group">
                                                                        <button type="button" onclick="reviewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                
                                                                <!--<button type="button" class="btn btn-primary" onclick="(${list[0]});"> Review </button>-->
                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>


                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>


    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->


</html>




