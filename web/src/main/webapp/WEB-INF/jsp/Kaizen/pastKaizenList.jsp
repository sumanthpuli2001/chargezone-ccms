<%-- 
    Document   : pastKaizenList
    Created on : Apr 25, 2018, 11:35:35 AM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<head>
    <title>SUMMARY KAIZEN LIST</title>
</head>
<html>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>KAIZEN SUMMARY LIST</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Summary Kaizen List</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header" style="text-align: right;">
                                <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'kaizen.htm?act=exportToExcelLeaveBalance'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->
                                <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel();"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->
                                  <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'kaizen.htm?act=exportToExcelpastKaizenMasterList'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center">

                                                <c:choose>
                                                    <c:when test="${empty list}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>

                                                            <tr>
                                                                <!--<th style="width: 1px; text-align: center" ><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                                <th>Sr.No</th>
                                                                <th>Kaizen Team</th>
                                                                <th>Department</th>
                                                                <th>Date</th>
                                                                <th>Kaizen Idea</th>
                                                                <th>Problem/waste identified </th>
                                                                <th>Idea Generator's Name</th>
                                                                <th>Kaizen Completion Target Date</th>
                                                                <th>Kaizen Status (Open/Close)</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach  var="list1" items="${list}">
                                                                <tr>
                                                                    <!--                                                                    <td align="Center">
                                                                                                                                            <input type="checkbox" name="checkId" id="checkId" value="${list[0]}">
                                                                                                                                        </td>-->
                                                                    <td>${list1[1]}</td>
                                                                    <td>${list1[2]}</td>
                                                                    <td>${list1[3]}</td>
                                                                    <td>${list1[4]}</td>
                                                                    <td>${list1[5]}</td>
                                                                    <td>${list1[6]}</td>
                                                                    <td>${list1[9]}</td>
                                                                    <td>${list1[7]}</td>
                                                                    <c:if test="${list1[8] eq 21}"><td><span class="label label-success">Close</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 0}"><td><span class="badge">Open</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 2 || list1[8] eq 22}"><td><span class="label label-warning">Recycled</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 3 || list1[8] eq 23}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                                    <%--<c:if test="${list1[8] eq 10}"><td><span class="label label-default">OnHold</span></td></c:if>--%>
                                                                    <%--<c:if test="${list1[8] eq 4}"><td><span class="label label-success">Final Approve Pending</span></td></c:if>--%>
                                                                    <c:if test="${list1[8] eq 1}"><td><span class="label label-success">Final Approve <br>Pending</span></td></c:if>
                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" onclick="viewClick(${list1[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;View
                                                                            </button>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                    </div> 
                                </div>  
                            </div>
                        </div>  
                    </div>  
                </div> 
            </div>
        </section>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>
    <script type="text/javascript">
        function ExportToExcel(tableid) {
            var data = "<table border='1px solid black !important;'>";
            data += $('#table1').html();
            //            data += "</table><table><tr><td colspan='4'><td></tr></table>";
            //            data += $('#table1').html();
            //            data += "</table><table><tr><td colspan='4'><td></tr></table>";
            //            data += "<table border='1px solid black !important;'>";
            //            data += $('#table2').html();
            //            data += "</table><table><tr><td colspan='4'><td></tr></table>";
            //            data += "<table border='1px solid black !important;'>";
            //            data += $('#table3').html();
            data += "</table>";
            window.open('data:application/vnd.ms-excel,' + encodeURIComponent(data));
            
//            
        }
    </script>  

    <script>
        function viewClick(id) {
            window.location = 'kaizen.htm?act=viewKaizen&id=' + id;
        }


    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

