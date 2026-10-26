<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Price Comparison</title>
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
            <h1>Tender Price Comparison</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Price Comparison</li>
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
                                            <center><a href="tenderMaster.htm?act=priceBidServiceComparisonSummaryView&refNo=${refNo}&pageNo=${pageNo}&next=sub">Previous</a> &nbsp;&nbsp;<a href="tenderMaster.htm?act=priceBidServiceComparisonSummaryView&refNo=${refNo}&pageNo=${pageNo}&next=add">Next</a></center>
                                            <br>
<!--                                            <div class="table">-->

                                                
                                                    
                                                        
                                                           <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    
                                                                    <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status1">
                                                                        <c:if test="${status1.count == '1'}">
                                                                            <tr>
                                                                                <th>${fileDetail.fileName} </th>
                                                                                <c:if test="${vendor_code1 != ''}">
                                                                                    <th>${grand_total_value1_1}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code2 != ''}">
                                                                                    <th>${grand_total_value2_1}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code3 != ''}">
                                                                                    <th>${grand_total_value3_1}</th>
                                                                                </c:if>
                                                                            </tr>
                                                                        </c:if>
                                                                        <c:if test="${status1.count == '2'}">
                                                                            <tr>
                                                                                <th>${fileDetail.fileName} </th>
                                                                                <c:if test="${vendor_code1 != ''}">
                                                                                    <th>${grand_total_value1_2}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code2 != ''}">
                                                                                    <th>${grand_total_value2_2}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code3 != ''}">
                                                                                    <th>${grand_total_value3_2}</th>
                                                                                </c:if>
                                                                            </tr>
                                                                        </c:if>    
                                                                        <c:if test="${status1.count == '3'}">
                                                                            <tr>
                                                                                <th>${fileDetail.fileName} </th>
                                                                                <c:if test="${vendor_code1 != ''}">
                                                                                    <th>${grand_total_value1_3}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code2 != ''}">
                                                                                    <th>${grand_total_value2_3}</th>
                                                                                </c:if>
                                                                                <c:if test="${vendor_code3 != ''}">
                                                                                    <th>${grand_total_value3_3}</th>
                                                                                </c:if>
                                                                            </tr>
                                                                        </c:if>    
                                                                    </c:forEach>
                                                                    
                                                                </tbody>
                                                            </table> 
                                                        
                                                    
                                               
<!--                                            </div>-->
                                        
                                        
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Tender Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${tender_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Tender Due Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${tender_due_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Sent From No. Of Vendor </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${total_vendor}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Received From No. Of Vendor </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${total_bid}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open By </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_by}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open By ID</label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_by_id}
                                            </div>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

