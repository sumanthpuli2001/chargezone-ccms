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
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                            <table id="table1" class="table table-bordered table-striped table-hover" style="" align="center">

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
                                                                <th style="width: 50px;">Sr.No</th>
                                                                <th style="width: 50px;">Kaizen Team</th>
                                                                <th style="width: 50px;">Department</th>
                                                                <th style="width: 50px;">Date</th>
                                                                <th style="width: 50px;">Kaizen Idea</th>
                                                                <th style="width: 50px;">Problem/waste identified (WORMPIT)</th>
                                                                <th style="width: 50px;">Idea Generator's Name</th>
                                                                <th style="width: 50px;">Kaizen Completion Target Date</th>
                                                                <th style="width: 50px;">Kaizen Status (Open/Close)</th>
                                                                <th style="width: 50px;">Action</th>
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
                                                                    <c:if test="${list1[8] eq 5}"><td><span class="label label-success">Close</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 0}"><td><span class="badge">Open</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 2 }"><td><span class="label label-warning">Recycled</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 3}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 10}"><td><span class="label label-default">OnHold</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 4}"><td><span class="label label-success">Final Approve Pending</span></td></c:if>
                                                                    <c:if test="${list1[8] eq 1}"><td><span class="label label-success">Final Approve Pending</span></td></c:if>
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
    <script>
        function viewClick(id) {
            window.location = 'kaizen.htm?act=viewKaizen&id=' + id;
        }


    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

