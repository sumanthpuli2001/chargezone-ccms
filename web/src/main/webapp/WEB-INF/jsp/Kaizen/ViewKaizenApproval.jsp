<%-- 
    Document   : ViewKaizenApproval
    Created on : Apr 21, 2018, 9:45:38 AM
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
    <style>
        table, th, th {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th, th {
            padding: 15px;
        }
        .disabledInput{
            background-color: black;
        }
    </style>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>Kaizen</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Kaizen</li>
            </ol>
        </section>
        <form:form action="kaizen.htm?act=kaizenApproval" method="post" commandName="kaizenMaster" enctype="multipart/form-data"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <%--<form:hidden path="${list.id}" name="id"/>--%>
                                <input type="hidden" name="id" value="${list.id}">
                                <div class="table">
                                    <table style="width:100%">
                                        <tr>
                                            <th colspan="3">Kaizen Sr. No.</th>
                                            <th colspan="5">${list.srNo}</th>
                                            <th colspan="2">Team Leader</th>
                                            <th colspan="2">${list.teamLeader}</th>
                                        </tr>
                                        <tr>
                                            <th colspan="3">Team Name </th>
                                            <th colspan="5">${list.teamName}</th>
                                            <th colspan="2">Kaizen Idea Generator</th>
                                            <th colspan="2">${list.ideaGenerator}</th>
                                        </tr>
                                        <tr>
                                            <th colspan="3">Department </th>
                                            <th colspan="5">${list.department}</th>
                                            <th colspan="2" rowspan="3">Team Member </th>
                                            <th colspan="2" rowspan="3"> ${list.teamMember}</th>
                                        </tr>
                                        <tr style="vertical-align: top;">
                                            <th colspan="3" rowspan="5">
                                                Problem Description:  <br>Electricity Consumption is more  <br><br>
                                                ${list.problemDescription}
                                            </th>
                                            <th colspan="5" rowspan="5" style="text-align: center;" >
                                                Before Photo <br>
                                                <img hight="400" width="500" src="StorageYard/Kaizen/beforePhoto/${list.beforePhoto}"  >
                                            </th>
                                            <!--<th colspan="2"><input name="teamMember" type="text"></th>-->
                                        </tr>
                                        <tr>
                                            <!--<th colspan="2"><input name="teamMember" type="text"></th>-->
                                        </tr>
                                        <tr>
                                            <th colspan="2">Start Date </th>
                                            <th colspan="2"> ${list.startDate}
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Completion Date  </th>
                                            <th colspan="2"> ${list.compiletionDate}
                                            </th>
                                        </tr>
                                        <tr>
                                            <th colspan="2">Budget Requirement  </th>
                                            <th colspan="2">${list.budgetRequirement}</th>
                                        </tr>
                                        <tr style="vertical-align: top;">
                                            <th colspan="3" rowspan="5">Improvement Description :<br>We can remove the unnecessary lights<br><br>
                                                ${list.improvementDescription}
                                            </th>
                                            <th colspan="5" rowspan="5" style="text-align: center;">After Photo<br>
                                                <img hight="400" width="500" src="StorageYard/Kaizen/afterPhoto/${list.afterPhoto}">
                                            </th>
                                            <th colspan="2" rowspan="1">Tangible Benefit </th>
                                            <th colspan="2" rowspan="1">${list.tangibleBenefit}</th>
                                        </tr>
                                        <tr>
                                            <th colspan="2" rowspan="1">Intangible Benefit </th>
                                            <th colspan="2" rowspan="1">${list.intangibleBenefit}</th>
                                        </tr>
                                        <tr>
                                            <th colspan="2" rowspan="3" style="vertical-align: top;height: 200px !important;">Horizontal Deployment: </th>
                                            <th colspan="2" rowspan="3" style="height: 200px !important; vertical-align: top;"> ${list.horizontalDeployment}  </th>
                                        </tr>

                                        <tr></tr>
                                        <tr></tr>
                                        <tr>
                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>Productivity</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.productivity eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.productivity ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Quality</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.quality eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.quality ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>Delivery</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.delivery eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.delivery ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b>  Safety</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.safety eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.safety ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>

                                            <td colspan="2" >
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Cost</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.cost eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.cost ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>
                                            <td colspan="2">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="col-md-6 col-sm-6" style="text-align: left;">
                                                        <b> Morale</b>
                                                    </div>
                                                    <div class="col-md-6 col-sm-6" style="text-align:right">
                                                        <c:if test="${list.morale eq 1}">
                                                            Yes
                                                        </c:if>
                                                        <c:if test="${list.morale ne 1}">
                                                            No
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </td>

                                        </tr>

                                    </table>
<!--                                    <div class="form-group">
                                        <br>
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <button type="button" onclick="viewClick(${list.id});" class="btn btn-primary" aria-haspopup="true" aria-expanded="false">
                                                &nbsp;&nbsp;Approved
                                            </button>
                                            <div class="col-sm-4" style="text-align: left">
                                                <button type="submit" class="btn btn-success" id="btnType2"  class="btn btn-primary" name="btnType"  value="Approve" style="width: 100px"> &nbsp;&nbsp;Approved</button>
                                            </div>
                                            <div class="col-sm-4" style="text-align: center">
                                                <button type="submit" class="btn btn-warning" id="btnType2"  class="btn btn-primary" name="btnType"  value="Recycle"  style="width: 100px"> &nbsp;&nbsp;Recycle</button>
                                            </div>
                                            <div class="col-sm-4" style="text-align: right">
                                                <button type="submit" class="btn btn-danger" onclick="return reject();" id="btnType1" class="btn btn-primary" name="btnType" value="Reject" style="width: 100px" > &nbsp;&nbsp;Reject</button>
                                            </div>
                                        </div>
                                    </div>-->
                                </div>
                            </div> <!--/tab-content -->
                        </div><!-- nav-tabs-custom -->


                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
    <script>
        function check(old1) {
            
            if (old1 = 1) {
                document.getElementById("checkBoxClass").checked = true;
            } else {
                document.getElementById("checkBoxClass").checked = false;
            }
        }

        function viewClick(id) {
            window.location = 'kaizen.htm?act=approvedKaizen&id=' + id;
        }

    </script>
</html>