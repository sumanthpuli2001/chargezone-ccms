<%-- 
    Document   : TrainerMasterlblView
    Created on : Mar 14, 2018, 10:46:12 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Trainings Details:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Details</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="trainerLogin.htm?act=SubmitAttendanceClick" method="post" commandName="trainerMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="hidden" id="trainingMasterId" name="trainingMasterId" value="${trainingMasterId}">
            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
            <!--<input type="hidden" id="allTrainingsId" name="allTrainingsId" value="${list[0]}">-->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.history.back();"></i>&nbsp;&nbsp;BACK</button>-->
                                <c:if test="${shosts eq true}">
                                <input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />
                                </c:if>
                                <c:if test="${shosts eq false}">
                                <button type="submit" class="btn btn-primary" style="" title="" style="width: 100px;"><!--<i class="fa fa-"></i>-->Submit</button>
                                 </c:if>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>

                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>

                                                            <thead>
                                                                <tr>
                                                                    <c:if test="${shosts eq true}">
                                                                        <th style="width: 50px;">SR. No</th>
                                                                        </c:if> 
                                                                        <c:if test="${shosts eq false}">
                                                                        <th align="Center" style="width: 1px;"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                        </c:if> 
                                                                    <th style="width: 50px;">Trainings</th>
                                                                    <th style="width: 50px;">Attendance</th>

                                                                </tr>
                                                            </thead>

                                                            <tbody>
                                                                <!--${list[0]}-->
                                                                <c:forEach var="list"  items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <c:if test="${shosts eq false}">
                                                                            <td align="Center">
                                                                                <input type="checkbox" onclick="deleteCheck11();" name="checkId" id="checkId" value="${list[0]}">
                                                                            </td>
                                                                        </c:if> 
                                                                        <c:if test="${shosts eq true}">
                                                                            <td>${status.count}</td>
                                                                        </c:if> 
                                                                        <td>${list[1]}</td>
                                                                        <!--<td>-->
                                                                        <c:if test="${shosts eq true}">
                                                                            <c:if test="${list[2] eq 0}">
                                                                                <td><b style="color: green">PR</b></td>
                                                                            </c:if> 
                                                                            <c:if test="${list[2] eq 1}">
                                                                                <td><b style="color: red">AB</b></td>
                                                                            </c:if> 
                                                                        </c:if> 
                                                                        <c:if test="${shosts eq false}">
                                                                            <td></td>
                                                                        </c:if> 
                                                                        <!--</td>-->
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script>
        function viewClick(id)
        {
        //            alert('hello '+id);
        window.location = 'trainerLogin.htm?act=editClick&id=' + id;
        }
        //        function deleteCheck11() {
        ////            alert("Hi");
        //            var checkboxes = "";
        //            
        //            checkboxes = document.getElementsByName('checkId');
        //            for(int i=0;i<checkboxes.lengthi++)
        //            {
        //                alert(checkboxes[i]);
        //            }
        //            for (var i = 0, n = checkboxes.length; i < n; i++) {
        //                if (checkboxes[i].checked) {
        //                    return true;
        //                }
        //            }
        //            alert("Please, Select one or more record(s).");
        //            
        //            return false;
        //        }

        //        $("#checkId").live("click", function () {
        //        $("input:checkbox:unchecked").each(function () {
        //            alert("Id: " + $(this).attr("id") + " Value: " + $(this).val());
        //        });
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid ;
        text-align: left;
        padding: 8px;
    }
</style>