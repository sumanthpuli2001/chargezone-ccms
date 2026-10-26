<%-- 
    Document   : UpdateVendorPrice
    Created on : 10 Aug, 2022, 10:42:48 AM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Vendor Price</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
      //      window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.location.reload();
		window.close();
	}
</script>

<script language="javascript" type="text/javascript">
    
            var tempCount3 = 1;
            function Policy()
            {
        
                    tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='generalfile" + tempCount3 + "' id='generalfile" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
                addAPolicy(tempCount3);
            }
            
            function removePolicy(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }
            
            
            function Documentdelete(id)
            {
                var t=document.getElementById("refNo").value;
                var t1=document.getElementById("vendor_code").value;
                
                window.location='vendor.htm?act=vendorAttachDelete&id='+id+'&refNo='+t+'&vendor_code='+t1;
            }
</script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Update Vendor Price</h1>
            
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
                                <form:form action="auctionMaster.htm?act=updateVendorPriceSubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                        name="form"   class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    <input type="hidden" name="vendorCode" id="vendorCode" value="${vendorCode}">
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Start Price :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" name="start_price" value="${start_price}" class="form-control"   maxlength="24" required="required" onKeyPress="return isNumberKey(event)" onChange="return calculate_price()">
                                        </div>
                                    </div>
                                     
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Loading Factor (%) :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" name="loading_factor_per" value="${loading_factor_per}" class="form-control"   maxlength="240" readonly="true">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Loading Factor (Value) :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" name="loading_factor_val" value="${loading_factor_val}" class="form-control"   maxlength="240" readonly="true">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Final Price :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" name="final_price" value="${final_price}" class="form-control"   maxlength="240" readonly="true">
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

<script language="javascript" type="text/javascript">
    function isNumberKey(evt)
    {
        var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode == 46)
                {
                    return true
                }
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;

                return true;
    }
    
    
    function calculate_price()
    {
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        var loading_per = document.form.loading_factor_per.value;
        var loading_val = document.form.loading_factor_val.value;
        var start_price = document.form.start_price.value;
        
        grand_total = parseFloat(start_price) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
        
        
        document.form.final_price.value = grand_total.toFixed(2);
        
        
    }
</script>

    
    
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    
</html>
