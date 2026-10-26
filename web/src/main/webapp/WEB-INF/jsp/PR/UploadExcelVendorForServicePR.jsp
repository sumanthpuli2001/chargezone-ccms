<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Vendor Excel</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
     //       window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.showuser('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Upload Vendor Excel</h1>
            
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="prMaster.htm?act=uploadExcelVendorForServicePRSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Upload Excel :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="technicalfile" name="technicalfile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12 col-sm-12">
                                             <div style="max-height: 400px; overflow-x: auto; overflow-y: auto; border: 1px solid #ddd; margin: auto; width: 100%;">
                                                <table class="table table-bordered" style="width: 100%;" align="center">
                                                    <c:choose>
                                                        <c:when test="${empty tenderVendor1}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Vendor Code</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Address</th>
                                                                    <th>Email Id</th>
                                                                    <th>Mobile No</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="tenderVendor1" items="${tenderVendor1}" varStatus="status">
                                                                    <tr>
                                                                        
                                                                         <td>${tenderVendor1.vendorCode}</td>
                                                                         <td>${tenderVendor1.vendorName}</td>
                                                                         <td>${tenderVendor1.address}</td>
                                                                         <td>${tenderVendor1.emailId}</td>
                                                                         <td>${tenderVendor1.mobileNo}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    
                                    <br>
                                    <div class="form-group" style="text-align: center;">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="SUBMIT">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
</html>