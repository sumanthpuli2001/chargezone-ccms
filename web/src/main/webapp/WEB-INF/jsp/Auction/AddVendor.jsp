<%-- 
    Document   : AddVendor
    Created on : 13 Aug, 2022, 9:00:08 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Information</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
 //           window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
         //   window.opener.showuser('1');
         window.opener.location.reload();
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Information</h1>
            
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
                                <form:form action="auctionMaster.htm?act=addVendorSearch" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                        name="form"   class="form-horizontal" role="form">
                                    <input type="hidden" name="auction_no" id="auction_no" value="${auction_no}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Code :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="vendor_code" name="vendor_code"  >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Name :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="vendor_name" name="vendor_name"  >
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="Search">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    
                                    <c:choose>
                                        <c:when test="${empty vendorMaster}">

                                        </c:when>
                                        <c:otherwise>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Code :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="${vendor_code}" class="form-control" id="vendor_code1" name="vendor_code1"  >
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Name :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="${vendor_name}" class="form-control" id="vendor_name1" name="vendor_name1"  >
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Start Price :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="" class="form-control" id="start_price" name="start_price"  onchange="calculate_price()" required="true">
                                                </div>
                                            </div>                
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Loading Factor (%) :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="" class="form-control" id="loading_factor_per" name="loading_factor_per"  onchange="calculate_price()" required="true">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Loading Factor (Value) :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="" class="form-control" id="loading_factor_val" name="loading_factor_val"  onchange="calculate_price()" required="true">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Final Price :</label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" value="" class="form-control" id="final_price" name="final_price"  readonly="true">
                                                </div>
                                            </div>
                                                
                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="auctionMaster.htm?act=addVendorSubmit" title="" value="Add">
                                                    <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                                </div>
                                            </div>

                                        </c:otherwise>
                                    </c:choose>
                                    
                                    
                                    
                                    
                                    

                                    
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script language="javascript" type="text/javascript">
    function calculate_price()
    {
        
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        
        if (document.form.start_price.length == null)
        {
            document.form.final_price.value = parseFloat(document.form.start_price.value) + parseFloat(document.form.loading_factor_val.value) + parseFloat((document.form.start_price.value * document.form.loading_factor_per.value / 100).toFixed(2));
        }
        while (i1 < document.form.start_price.length) 
        {
            
            alert("");
            document.form.final_price[i1].value = parseFloat(document.form.start_price[i1].value) + parseFloat(document.form.loading_factor_val[i1].value) + parseFloat((document.form.start_price[i1].value * document.form.loading_factor_per[i1].value / 100 ).toFixed(2));
            i1++;
            j1++;
	}
    }
    </script>
    
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

