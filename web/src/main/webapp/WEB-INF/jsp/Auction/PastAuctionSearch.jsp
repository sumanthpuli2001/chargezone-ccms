<%-- 
    Document   : PastAuctionSearch
    Created on : 13 Aug, 2022, 4:15:18 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Close Auction List</title>
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
            <h1>Close Auction List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Close Auction List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="auctionMaster.htm?act=pastAuctionList" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
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

                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Auction No. :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <input type="text" name="auction_no" value="" class="form-control" maxlength="30" />
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Auction Title :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <input type="text" name="auction_title" value="" class="form-control" maxlength="30" />
                                                    </div>
                                                </div>
                                                
                                                Opening Date
                                                <hr>
                                                
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">From Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class='input-group date' id='datetimepicker1'>
                                                <input name="open_from_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker1').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">To Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <div class='input-group date' id='datetimepicker2'>
                                                <input name="open_to_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker2').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                Closing Date
                                                <hr>
                                                
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">From Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class='input-group date' id='datetimepicker3'>
                                                <input name="close_from_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker3').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">To Date :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <div class='input-group date' id='datetimepicker4'>
                                                <input name="close_to_date" type="text" class="form-control form_datetime" value=""  maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker4').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD-MM-YYYY',
                                                        });
                                                    });
                                                </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                

                                            <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Search">
                                        </div>
                                    </div>
                            
                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center"> </td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr. No.</th>
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
                                                                        <td>${status.count}</td>
                                                                        <td>${list.auctionNo}</td>
                                                                        <td>${list.title}</td>
                                                                        <td>${list.biddingStartdate}</td>
                                                                        <td>${list.biddingEnddate}</td>
                                                                        <td>${list.type} </td>
<!--                                                                        
                                                                        <td>
                                                                            
                                                                                <a href="auctionMaster.htm?act=receivedAuctionView&id=${list.id}">
                                                                                    View
                                                                                </a>
                                                                            
                                                                        </td>-->
                                                                        
                                                                        
                                                                         <c:if test="${list.biddingType ne 'Itemwise Bidding' }">
                                                                            <td>
                                                                                    <a href="auctionMaster.htm?act=receivedAuctionView1&id=${list.id}">View</a>
                                                                                
                                                                            </td>
                                                                            </c:if>
                                                                            <c:if test="${list.biddingType eq 'Itemwise Bidding'}">
                                                                            <td>
                                                                                    <a href="auctionMaster.htm?act=itemwiseReceivedAuctionView&auctionId=${list.auctionNo}">View</a>
                                                                                
                                                                            </td>
                                                                             </c:if>
                                                                        
                                                                        
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
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>


