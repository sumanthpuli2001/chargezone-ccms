<%-- 
    Document   : RejectAuctionList
    Created on : 8 Aug, 2022, 5:55:44 PM
    Author     : admin
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Auction Reject List</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Auction Reject List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Auction Reject List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
<!--                                            <div class="table">-->

                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${1 == 2}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Auction No.</th>
                                                                    <th>Auction Title</th>
                                                                    <th>Auction Date</th>
                                                                    <th>Auction Due Date</th>
                                                                    <th>Auction Type</th>
                                                                    <th>View</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td>${list.auctionNo}</td>
                                                                        <td>${list.title}</td>
                                                                        <td>${list.biddingStartdate}</td>
                                                                        <td>${list.biddingEnddate}</td>
                                                                        <td>${list.type}</td>
                                                                        <td>
                                                                            
                                                                                <a href="auctionMaster.htm?act=rejectView&id=${list.id}">View</a>
                                                                            
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                
                                                                    
                                                                
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
<!--                                            </div>-->
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>




