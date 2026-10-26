<%-- 
    Document   : AddServicePRDocument1
    Created on : 20 May, 2024, 4:20:01 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Details</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
       //     window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
       window.opener.showuser11('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Item Details</h1>
            
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
                                <form:form action="prMaster.htm?act=addServicePRSubmit1" method="post" enctype="multipart/form-data" 
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                  
                                 
                                    
                                    <hr>
                                    
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">File <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input type="file" name="service_file" value="" class="form-control" />
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" title="Submit" value="Submit">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    
                                    
                                    
                                   
                                    
                                    <c:if test="${prItemMaster.size()>0}">
                                    Material Details &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary" style="width: 100px;" formaction="prMaster.htm?act=addPrItemMaterialSubmit1" title="" value="Add" >
                                    <input type="hidden" name="pr_no1" value="${pr_no}">
                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table style="" align="Center" class="table table-bordered">
                                                    <tr>
                                                        <th>Select</th>
                                                        <th>Item Code</th>
                                                        <th>Item Description</th>
                                                        <th>Item Detail</th>
                                                        <th>UOM</th>
                                                        <th>Quantity</th>
                                                        
                                                    </tr>
                                                    <c:forEach var="prItemMaster" items="${prItemMaster}" varStatus="status1">
                                                        <tr>
                                                            <td><input type="checkbox" name="checkId" id="materialCheckId" value="${status1.count}"></td>
                                                            <td><input type="text" name="material_code1" value="${prItemMaster[0]}" class="form-control" /></td>
                                                            <td><input type="text" name="material_desc1" value="${prItemMaster[1]}" class="form-control" /></td>
                                                            <td><input type="text" name="material_detail" value=""  class="form-control" /></td>
                                                            <td><input type="text" name="material_uom" value="${prItemMaster[2]}" class="form-control" /></td>
                                                            <td><input type="text" name="material_qty" value="${prItemMaster[3]}" class="form-control" /></td>
                                                        
                                                    </tr>
                                                    </c:forEach>
                                                    
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    </c:if>
                                    
                                   
                                    
                                    Item Details &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-primary" style="width: 100px;" formaction="prMaster.htm?act=deletePrItemMaterial1" title="" value="Delete" >
                                    <div class="form-group">
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                    <c:choose>
                                                        <c:when test="${empty tenderItemMaster}">
                                                            
                                                        </c:when>
                                                        <c:otherwise>
                                                            
                                                                        
                                                            <table  class="table table-bordered" style="" align="Center">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Select</th>
                                                                        <th>Sr No.</th>
                                                                        <th>Item Code</th>
                                                                        <th>Item Description</th>
                                                                        <th>Purpose</th>
                                                                        <th>Make</th>
                                                                        <th>UOM</th>
                                                                        <th>Qty</th>
                                                                        
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">

                                                                            <tr>
                                                                                <td><input type="checkbox" name="checkedId" id="materialCheckedId" value="${tenderItemMaster.id}"></td>
                                                                                <td>${tenderItemMaster.itemCode}</td>
                                                                                 <td>${tenderItemMaster.srNo}</td>
                                                                                <td>${tenderItemMaster.itemDescription}</td>
                                                                                <td>${tenderItemMaster.deliveryScheduleQty}</td>
                                                                                <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                                                                <td>${tenderItemMaster.uom}</td>
                                                                                <td>${tenderItemMaster.qty}</td>
                                                                        
                                                                            </tr>
                                                                        </c:forEach>



                                                                </tbody>
                                                            </table>
                                                                        
                                                                 
                                                                
                                                        </c:otherwise>
                                                    </c:choose>
                                            </div>
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
<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>
