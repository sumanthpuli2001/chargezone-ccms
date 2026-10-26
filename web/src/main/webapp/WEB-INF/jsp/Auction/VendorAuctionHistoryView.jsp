<%-- 
    Document   : VendorAuctionHistoryView
    Created on : 13 Aug, 2022, 3:47:33 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor History Information</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
 //           window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
   //         window.opener.showuser('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor History Information</h1>
            
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
                                <form:form action="auctionMaster.htm?act=searchVendorForAuctionSubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    
                                    <P align="right" class="content-header" style="margin: 0px;box-shadow : none">
                                                    <input type="button" class="btn btn-primary" style="width: 100px;" onclick="window.print();" title="" value="Print" >
                                                </P>
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                
                                                

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Auction No</th>
                                                                    <th>Vendor Code</th>
                                                                    <th>Price</th>
                                                                    <th>Date Time</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="li" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td>${li.auctionNo}</td>
                                                                        <td>${li.vendorCode}</td>
                                                                        <td>${li.finalTotal}</td>
                                                                        <td>${li.dateTime}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                                    
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <P align="right" class="content-header" style="margin: 0px;box-shadow : none">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                            </P>
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

