<%-- 
    Document   : CreateItemwiseAuction
    Created on : 3 Jun, 2023, 3:36:17 PM
    Author     : Bulwarks-1
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Details</title>

        <script>
            function closewindow() {
                //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
                //     window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.showuser1('1');
                window.close();
            }
        </script>
            <script language="javascript" type="text/javascript">
    function calculate_price()
    {
        //alert("");
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
            document.form.final_price[i1].value = parseFloat(document.form.start_price[i1].value) + parseFloat(document.form.loading_factor_val[i1].value) + parseFloat((document.form.start_price[i1].value * document.form.loading_factor_per[i1].value / 100 ).toFixed(2));
            i1++;
            j1++;
	}
    }
    </script>
    </head>
    <!-- Content Wrapper. Contains page content -->

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


    <!-- Content Wrapper. Contains page content -->


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
                                
                                     <form:form action="auctionMaster.htm?act=uploadExcelItemVendorForAuctionSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                         <c:set var="count" value="0" scope="page" />
                                        <c:forEach var="li" items="${li}" varStatus="status">
                                            <input type="hidden" name="length" id="length" value="${status.count}">
                                     <input type="hidden" name="li" id="li" value="${li}">
                               </c:forEach>
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <input type="hidden" name="item_id" id="item_id" value="${item_no}"> 
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Upload Excel :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="technicalfile" name="technicalfile" accept="" onchange="checkFileSize();">
                                            <a href="StorageYard/Auction Vendor.xlsx">Eg. Auction Vendor File</a>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="Submit">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    <br>
                                </form:form>
                                
                                
                                
                                
                                
                           <form:form action="auctionMaster.htm?act=searchVendorItemForAuctionSubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                        name="form"   class="form-horizontal" role="form">
                                <c:set var="count" value="0" scope="page" />
                               <c:forEach var="li" items="${li}" varStatus="status">
                                   <input type="hidden" name="length" id="length" value="${status.count}">
                                     <input type="hidden" name="li" id="li" value="${li}">
                               </c:forEach>
                                  
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <input type="hidden" name="item_id" id="item_id" value="${item_no}"> 
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
                                    
                                    
                                    
   <script language="javascript" type="text/javascript">
    function calculate()
    {
        //alert("");
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
            document.form.final_price[i1].value = parseFloat(document.form.start_price[i1].value) + parseFloat(document.form.loading_factor_val[i1].value) + parseFloat((document.form.start_price[i1].value * document.form.loading_factor_per[i1].value / 100 ).toFixed(2));
            i1++;
            j1++;
	}
    }
    </script>
                              
                                                 <div class="col-sm-3">
                                            <label class="control-label">Vendor List:</label>
                                        </div>
                                    <div class="col-md-12 col-sm-12">
                                        
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty vendorMaster}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Vendor Code</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Address</th>
                                                                    <th>Email Id</th>
                                                                    <th>Mobile No</th>
                                                                    <th>Basic Start Price</th>
                                                                    <th>Loading Factor (%)</th>
                                                                    <th>Loading Factor (Value)</th>
                                                                    <th>Final Price</th>
                                                                   
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="vendorMaster" items="${vendorMaster}" varStatus="status">
                                                                    <tr>
                                                                        <td><input type="checkbox" value="${vendorMaster.vendorRegNo}" id="checkedId" name="checkedId"></td>
                                                                        <td>${vendorMaster.vendorRegNo}</td>
                                                                         <td>${vendorMaster.vendorName}</td>
                                                                         <td>${vendorMaster.vendorAddressLine1}</td>
                                                                         <td>${vendorMaster.vendorEmailID}</td>
                                                                         <td>${vendorMaster.vendorMobNo}</td>
                                                                         <td><input type="text"  name="start_price" id="start_price" onkeyup="calculate()" class="form-control"></td>
                                                                         <td><input type="text" name="loading_factor_per" id="loading_factor_per" onkeyup="calculate()" class="form-control"></td>
                                                                         <td><input type="text" id="loading_factor_val"  name="loading_factor_val" onkeyup="calculate()" class="form-control"></td>
                                                                         <td><input name="final_price" id="final_price" class="form-control" maxlength="130" readonly="true"/></td>
                                                                          
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        
                                    

                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="auctionMaster.htm?act=addVendorItemForAuction" title="" value="Add">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    
                                       
                                                 <div class="col-sm-3">
                                            <label class="control-label">Edit/Delete Vendor List:</label>
                                        </div>  
                                    <div class="col-md-12 col-sm-12">
                                         
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty auctionVendor1}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Vendor Code</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Address</th>
                                                                    <th>Email Id</th>
                                                                    <th>Mobile No</th>
                                                                    <th>Basic Start Price</th>
                                                                    <th>Loading Factor (%)</th>
                                                                    <th>Loading Factor (Value)</th>
                                                                    <th>Final Price</th>
                                                                     <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="auctionVendor1" items="${auctionVendor1}" varStatus="status">
                                                                    <tr>
                                                                    
                                                                <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                                                <input type="hidden" name="item_id" id="item_id" value="${item_no}">
                                                                        <td><input type="checkbox" value="${auctionVendor1.id}" name="checkedIdd${status.count}"></td>
                                                                        <td>${auctionVendor1.vendorCode}</td>
                                                                         <td>${auctionVendor1.vendorName}</td>
                                                                         <td>${auctionVendor1.address}</td>
                                                                         <td><input name="email_id" value="${auctionVendor1.emailId}" class="form-control"   maxlength="230" /></td>
                                                                         <td><input name="mobile_no${status.count}" value="${auctionVendor1.mobileNo}" class="form-control"   maxlength="130" /></td>
                                                                         <td><input type="text"  name="start_price1${status.count}" id="start_price" onkeyup="calculate()" value="${auctionVendor1.vendorBasicStartPrice}" class="form-control"></td>
                                                                         <td><input type="text" name="loading_factor_per1${status.count}" id="loading_factor_per" onkeyup="calculate()" value="${auctionVendor1.loadingFactorPer}" class="form-control"></td>
                                                                         <td><input type="text" id="loading_factor_val"  name="loading_factor_val1${status.count}" onkeyup="calculate()" class="form-control" value="${auctionVendor1.loadingFactorVal}"></td>
                                                                         <td><input name="final_price1${status.count}" id="final_price" class="form-control" maxlength="130" readonly="true" value="${auctionVendor1.finalPrice}"/></td>
                                                                         <td style="width: 50px;"> <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="auctionMaster.htm?act=editVendorItemForAuction" title="" value="Edit"></td>
<!--                                                                         <td style="width: 50px;"><a type="submit" name="edit" id="edit" formaction="auctionMaster.htm?act=editVendorItemForAuction">Edit</a></td>-->
                                                                    </tr>
                                                                </c:forEach>
                                                              
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
   
        
    

<!--    <script>
        function edit(){
            alert("");
              var ref_no=document.getElementById("ref_no").value;
              var item_id = document.getElementById("item_id").value;
             window.location='auctionMaster.htm?act=editVendorItemForAuction&ref_no='+ref_no+'&item_id='+item_id ;
        }
    </script>-->

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="auctionMaster.htm?act=deleteVendorItemForAuction" title="" value="Delete">
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
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
