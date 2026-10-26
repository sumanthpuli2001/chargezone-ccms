<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Attachment</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
            window.opener.document.getElementById('requireDocument4').innerHTML='${technicalfile}';
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor All Attachment</h1>
            
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
                                <form:form action="tenderMaster.htm?act=technicalSpecificationAttachByAdminfor2PhaseSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Attachment</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list1" items="${list1}" varStatus="status">
                                                                    <tr>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <c:forEach var="list1" items="${list2}" varStatus="status">
                                                                    <tr>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <c:forEach var="list1" items="${list3}" varStatus="status">
                                                                    <tr>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <c:forEach var="list1" items="${list4}" varStatus="status">
                                                                    <tr>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <c:forEach var="list1" items="${list5}" varStatus="status">
                                                                    <tr>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                    
                                                </table>
                                            </div>
                                        </div>

                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
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
    <script>
        function Validate() {
            var pass = $('#password').val();
            var pass1 = $('#password1').val();
            if (pass != pass1) {
                alert('Password not match');
                return false;
            }
            return true;
        }
    </script>

</html>