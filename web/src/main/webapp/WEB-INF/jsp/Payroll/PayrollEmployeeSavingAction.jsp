<%-- 
    Document   : PayrollEmployeeSavingAction
    Created on : Apr 17, 2018, 5:32:15 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Saving Approve Action</title>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>EMPLOYEE SAVING </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Saving Approve Action</li>
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
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>


                                <form:form action="taxSavingSubmit.htm?act=viewClick" method="post" commandName="taxSavingSubmit" 
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

                                    <div class="box-body no-padding">

                                        <div class="row">
                                            <div class="col-md-12 col-sm-12" style="font-size: 16px; margin: 10px 0px 20px 0px;">
                                                <b>Employee Name :</b>
                                                <span>${employeeMaster.employeeName}</span>
                                                <input type="hidden" name="eid" id="eid" value="${employeeMaster.id}">

                                                &nbsp;&nbsp;&nbsp;
                                                <b> Year : </b>
                                                <span>${taxSavingSubmit.payrollFinancialYear.title}</span> 
                                                <input type="hidden" name="fid" id="fid" value="${taxSavingSubmit.payrollFinancialYear.id}">  
                                                <input type="hidden" name="tid" id="tid" value="${taxSavingSubmit.id}">  

                                            </div>
                                        </div>
                                        <div class="table table-bordered">
                                            <c:forEach var="list" items="${finalData}" varStatus="myindex">
                                                <input type="hidden" name="hiddenSubmitId" value="${list[0]}" />
                                                <div style="text-align: center;"><b>Section - ${list[0]}</b></div>
                                                <br/>
                                                <table id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <th>Sr. No.</th>
                                                            <th>Saving Type</th>
                                                            <th>Amount</th>
                                                            <th>Submit Proof</th>
                                                            <th>Status</th>
                                                            <th>Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="list1" items="${list}" varStatus="myindex1">
                                                            <c:set var="Count" value="${myindex1.count}"></c:set>
                                                            <c:set var="index" value="1"></c:set>
                                                            <c:if test="${Count > 1}">
                                                                <tr>
                                                            <input type="hidden" class="tddsId" name="tddsId" value="${list1[4]}"/>

                                                            <td>${Count-1}</td>

                                                            <td>${list1[0]}</td>

                                                            <td><input type="text" name="savingTypeAmount1" value="${list1[1]}" class="form-control savingTypeAmount1"></td>

                                                            <c:choose>
                                                              
                                                                <%--<c:when test="${((list1[1] == 0.0 and (list1[2] != '' or list1[2] != null))) or ((list1[1] != 0.0 and (list1[2] == '' or list1[2] == null))) or ((list1[1] == 0.0 and (list1[2] == '' or list1[2] == null)))}">--%>
                                                                <c:when test="">
                                                                    <td><span class="label label-warning"></span></td>
                                                                    <td><span class="label label-warning"></span></td>
                                                                    <td><span class="label label-warning"></span></td>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                    <td><a href="taxSavingSubmit.htm?act=readFile&amp;fileName=${list1[2]}">${list1[2]}</a></td>

                                                                    <c:if test="${list1[3] == 0}"><td><span class="label label-warning">Pending</span></td></c:if>
                                                                    <c:if test="${list1[3] == 1}"><td><span class="label label-success">Approved</span></td></c:if>
                                                                    <c:if test="${list1[3] == 2}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                                    <c:if test="${list1[3] == 3}"><td><span class="label label-warning">Recycled</span></td></c:if>

                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                    Action <span class="caret"></span>
                                                                                </button>

                                                                                <ul class="dropdown-menu" >
                                                                                    <li>
                                                                                        <a href="#" class="approveId">
                                                                                            &nbsp;&nbsp;Approve&nbsp;<i class="fa fa-check" aria-hidden="true"></i>
                                                                                        </a>
                                                                                    </li>

                                                                                    <li>
                                                                                        <a href="#" class="rejectId">
                                                                                            &nbsp;&nbsp;Reject&nbsp;<i class="fa fa-times" aria-hidden="true"></i>
                                                                                        </a>
                                                                                    </li>

                                                                                    <li>
                                                                                        <a href="#" class="recycleId">
                                                                                            &nbsp;&nbsp;Recycle&nbsp;<i class="fa fa-recycle" aria-hidden="true"></i>
                                                                                        </a>
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                        </td>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <%--<c:choose>--%>
                                                            <%--<c:when test="${list1[2]eq ''}">--%>
                                                            <!--<td><span class="label label-warning">Pending Proof</span></td>-->
                                                            <%--</c:when>--%>
                                                            <%--<c:otherwise>--%>
                                                                <!--<td><a href="taxSavingSubmit.htm?act=readFile&amp;fileName=${list1[2]}">${list1[2]}</a></td>-->
                                                            <%--</c:otherwise>--%>
                                                            <%--</c:choose>--%>

                                                            <%--<c:if test="${list1[3] == 0}"><td><span class="label label-warning">Pending</span></td></c:if>--%>
                                                            <%--<c:if test="${list1[3] == 1}"><td><span class="label label-success">Approved</span></td></c:if>--%>
                                                            <%--<c:if test="${list1[3] == 2}"><td><span class="label label-danger">Rejected</span></td></c:if>--%>
                                                            <%--<c:if test="${list1[3] == 3}"><td><span class="label label-warning">Recycled</span></td></c:if>--%>

                                                            <!--                                                                    <td>
                                                                                                                                    <div class="btn-group">
                                                                                                                                        <button type="button"  class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                                            Action <span class="caret"></span>
                                                                                                                                        </button>
                                                            
                                                                                                                                        <ul class="dropdown-menu" >
                                                                                                                                            <li>
                                                                                                                                                <a href="#" class="approveId">
                                                                                                                                                    &nbsp;&nbsp;Approve
                                                                                                                                                </a>
                                                                                                                                            </li>
                                                            
                                                                                                                                            <li>
                                                                                                                                                <a href="#" class="rejectId">
                                                                                                                                                    &nbsp;&nbsp;Reject
                                                                                                                                                </a>
                                                                                                                                            </li>
                                                            
                                                                                                                                            <li>
                                                                                                                                                <a href="#" class="recycleId">
                                                                                                                                                    &nbsp;&nbsp;Recycle
                                                                                                                                                </a>
                                                                                                                                            </li>
                                                                                                                                        </ul>
                                                                                                                                    </div>
                                                                                                                                </td>-->
                                                            </tr>

                                                        </c:if>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </c:forEach>

                                        </div>

                                        <center>
                                            <c:if test="${taxSavingSubmit1.status eq 1}"><td><span style="font-size:15px" class="label label-default">Pending</span></td></c:if>
                                            <c:if test="${taxSavingSubmit1.status eq 2}"><td><span style="font-size:15px" class="label label-success">Approved</span></td></c:if>
                                            <c:if test="${taxSavingSubmit1.status eq 3}"><td><span style="font-size:15px" class="label label-warning">Partially Approved</span></td></c:if>
                                            <c:if test="${taxSavingSubmit1.status eq 4}"><td><span style="font-size:15px" class="label label-danger">Rejected</span></td></c:if>
                                            <c:if test="${taxSavingSubmit1.status eq 5}"><td><span style="font-size:15px" class="label label-info">Recycled </span></td></c:if>

                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12" style="font-size: 16px; margin: 30px 0px 20px 0px;">
                                                        <div class="col-md-4 col-sm-4" style="text-align: left;">
                                                            <i class=""></i>
                                                            <input type="button" id="partApprove" class="btn btn-success partApprove" style="width: 100px; "  title="" value="APPROVE">
                                                        </div>
                                                        <div class="col-md-4 col-sm-4" style="text-align: center;">
                                                            <input type="button" id="partReject" class="btn btn-danger partReject" style="width: 100px;"  title="" value="REJECT">
                                                        </div>
                                                        <div class="col-md-4 col-sm-4" style="text-align: right;">
                                                            <input type="button" id="partRecycle" class="btn btn-info partRecycle" style="width: 100px;"  title="" value="RECYCLE">
                                                        </div>
                                                    </div> 
                                                </div>

                                            </center>
                                        </div>



                                        <!--                                    <div class="col-sm-6 col-sm-offset-5">
                                                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                                            </div>-->

                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script type="text/javascript" language="javascript">

        function checkfile(sender, index) {
//          alert("hii"+index);
            var tflag11 = document.getElementById("hrId").value;
//            alert(tflag11);
            $('#saveSubmit2').show();

            var validExts = new Array(".xlsx", ".xls");
            var fileExt = sender.value;
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (validExts.indexOf(fileExt) < 0) {
                alert("Invalid file selected, valid files are of " +
                        validExts.toString() + " types.");
                document.getElementById('file11').value = '';
                return false;
                $("#uploadDiv" + index).hide();

            } else {
                $("#uploadDiv" + index).show();
                return true;
            }
        }
    </script>
    <script>
        $(".approveId").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var v = $(this).closest('tr').find('input.savingTypeAmount1').val();
            var s = $(this).closest('tr').find('input.tddsId').val();
            window.location = "taxSavingSubmit.htm?act=changeField&amount=" + v + "&status=1&tddsId=" + s + "&eid=" + eid + "&fid=" + fid;

        });
        $(".rejectId").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var v = $(this).closest('tr').find('input.savingTypeAmount1').val();
            var s = $(this).closest('tr').find('input.tddsId').val();
            window.location = "taxSavingSubmit.htm?act=changeField&amount=" + v + "&status=2&tddsId=" + s + "&eid=" + eid + "&fid=" + fid;
            ;

        });
        $(".recycleId").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var v = $(this).closest('tr').find('input.savingTypeAmount1').val();
            var s = $(this).closest('tr').find('input.tddsId').val();
            window.location = "taxSavingSubmit.htm?act=changeField&amount=" + v + "&status=3&tddsId=" + s + "&eid=" + eid + "&fid=" + fid;
            ;
        });

        $(".partApprove").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var tid = $('#tid').val();
            window.location = "taxSavingSubmit.htm?act=partiallyChange&status=2&eid=" + eid + "&fid=" + fid + "&tid=" + tid;
        });

        $(".partReject").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var tid = $('#tid').val();
            window.location = "taxSavingSubmit.htm?act=partiallyChange&status=4&eid=" + eid + "&fid=" + fid + "&tid=" + tid;
        });

        $(".partRecycle").on("click", function () {
            var eid = $('#eid').val();
            var fid = $('#fid').val();
            var tid = $('#tid').val();
            window.location = "taxSavingSubmit.htm?act=partiallyChange&status=5&eid=" + eid + "&fid=" + fid + "&tid=" + tid;
        });


    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
