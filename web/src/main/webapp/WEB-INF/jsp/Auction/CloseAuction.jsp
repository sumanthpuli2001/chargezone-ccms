<%-- 
    Document   : CloseAuction
    Created on : 19 Jul, 2022, 5:44:49 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close Auction</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
  //          window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
            window.opener.location.reload();
            window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Close Auction By Force</h1>
            
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="auctionMaster.htm?act=closeAuctionSubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                           class="form-horizontal" role="form">
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction No :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="auction_no" name="auction_no" value="${auction_no}" readonly="true">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Remark :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="remark" name="remark" value="" required="true">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
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
