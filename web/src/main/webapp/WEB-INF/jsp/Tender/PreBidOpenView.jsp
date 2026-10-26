<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Bid Information</title>
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
            var checkboxes1 = "";
            checkboxes1 = document.getElementsByName('checkedId');
            for (var i = 0, n = checkboxes1.length; i < n; i++) {
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
            <h1>Tender Bid Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Pre Qualification Bid Information</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="tenderMaster.htm?act=preBidOpenUserView" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="hidden" name="refNo" value="${refNo}">
            <input type="hidden" name="id" value="${id}">
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

                                                    <table id="table_11" class="table table-bordered" style="" align="Center"  >
                                                    
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Tender Ref No.</th>
                                                                    <th>Vendor Id</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Vendor Email Id</th>
                                                                    <th>Vendor Location</th>
                                                                    <th>View All Attachment</th>
                                                                    <th>View</th>
                                                                    <th>Comparison</th>
                                                                    <th>Print</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list1" items="${list1}" varStatus="status">
                                                                    <tr>
                                                                        <td><input type="checkbox" value="${list1[1]}" name="checkedId"></td>
                                                                        <td>${list1[0]}</td>
                                                                        <td>${list1[1]}</td>
                                                                        <td>${list1[2]}</td>
                                                                        <td>${list1[5]}</td>
                                                                        <td>${list1[3]}</td>
                                                                        
                                                                        <td>
                                                                            <a href="#" onclick="window.open('tenderMaster.htm?act=vendorAllAttachView&refNo=${list1[0]}&vendorCode=${list1[1]}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">View</a>
                                                                        </td>
                                                                        <td><a href="tenderMaster.htm?act=preBidView&refNo=${list1[0]}&vendorCode=${list1[1]}">View</a></td>
                                                                        <td><a href="tenderMaster.htm?act=preBidComparisonView&refNo=${list1[0]}&vendorCode=${list1[1]}">Comparison</a></td>
                                                                        <td><a href="tenderMaster.htm?act=preBidPrint&refNo=${list1[0]}&vendorCode=${list1[1]}">Print</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        
                                                </table>

                                                    <c:choose>
                                                        <c:when test="${empty list1}">
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                    <div class="form-group">
                                                
                                        <div class="col-sm-3">
                                            <label class="control-label">&nbsp;&nbsp;Remark :</label>
                                        </div>
                                        <div class="col-sm-9">
                                            <textarea name="remark" value="" class="form-control"   maxlength="200" ></textarea>
                                        </div>
                                        
                                    </div>

                                                            
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 250px!important;" formaction="tenderMaster.htm?act=preBidAuthorize" title="" value="Authorize to Technical Bid">
                                        </div>
                                    </div>              
                                                        </c:otherwise>
                                                    </c:choose>
                                                            
<h3>Tender To Be Open For Pre Qualification Bid</h3>
<hr>

                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Vendor Id</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Vendor Location</th>
                                                                    <th>Vendor Mobile Number</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td><input type="checkbox" value="${list[1]}" name="checkId" checked="true"></td>
                                                                        <td>${list[1]}</td>
                                                                        <td>${list[2]}</td>
                                                                        <td>${list[3]}</td>
                                                                        <td>${list[4]}</td>
                                                                        
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
<!--                                            </div>-->

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Open">
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

