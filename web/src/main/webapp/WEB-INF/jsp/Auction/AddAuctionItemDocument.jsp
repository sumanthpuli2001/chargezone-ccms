<%-- 
    Document   : AddAuctionItemDocument
    Created on : 15 Jul, 2022, 3:36:36 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction Item Details</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
       //     window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
       window.opener.showuser1('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Auction Item Details</h1>
            
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
                                <form:form action="auctionMaster.htm?act=addItemDocumentSubmit" method="post" enctype="multipart/form-data" 
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                   
                                    
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">File <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input type="file" name="service_file" value="" class="form-control" />
                                             <a href="StorageYard/Auction Item.xlsx">Eg. Item Details File</a>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" title="Submit" value="Submit">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    
                                    

                                                   
                                                            
                                                            <c:set var="count" value="0" scope="page" />
                                                                    
                                                                   
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Select</th>
                                                                                    <th>Sr. No.</th>
                                                                                    <th>Item Code</th>
                                                                                    <th>Item Name</th>
                                                                                    <th>Item Description</th>
                                                                                   
                                                                                    <th>UOM</th>
                                                                                    <th>Qty</th>
                                                                                    
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                               
                                                                                    <c:forEach var="itemDetail" items="${itemDetail}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td><input type="checkbox" value="${itemDetail.id}" name="checkedIdd"></td>
                                                                                            <td>${itemDetail.srNo}</td>
                                                                                            <td>${itemDetail.itemCode}</td>
                                                                                            <td>${itemDetail.itemName}</td>
                                                                                            <td>${itemDetail.itemDesc}</td>
                                                                                           
                                                                                            <td>${itemDetail.uom}</td>
                                                                                            <td>${itemDetail.qty}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                
                                                                              
                                                                                
                                                                            </tbody>
                                                                        </table>
                                                                   
                                                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="auctionMaster.htm?act=deleteItemDocument" title="" value="Delete">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                                                        
                                                                    <hr>
                                                               
                                                      
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
