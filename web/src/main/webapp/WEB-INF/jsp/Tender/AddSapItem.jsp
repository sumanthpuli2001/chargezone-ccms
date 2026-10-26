<%-- 
    Document   : AddSapItem
    Created on : 8 Nov, 2022, 11:14:10 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAP Item Data</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
 //           window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
            window.opener.showuser1('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SAP Item Data</h1>
            
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
                                <form:form action="tenderMaster.htm?act=getSapItemSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Purchase Requisitions No. :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="pr_no" name="pr_no"  >
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Plant :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="plant" class="form-control">
                                                <c:forEach var="plantMaster" items="${plantMaster}" varStatus="status1">
                                                    <option value="${plantMaster.plantCode}">${plantMaster.plantCode}</option>
                                                </c:forEach>
                                                    
                                                    
                                            </select>
                                           
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                            <input type="submit" class="btn btn-primary" style="width: 150px!important;" onclick="return Validate()"  title="" value="Get Material PR">
                                            <input type="submit" class="btn btn-primary" style="width: 150px!important;" onclick="return Validate()" formaction="tenderMaster.htm?act=getSapServiceItemSubmit" title="" value="Get Service PR">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty sapTenderMaster}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <th><div align="center">Sr. No.</div></th>
                                                                    <th><div align="center">Item Code</div></th>
                                                                    <th><div align="center">Item Description</div></th>
                                                                    <th><div align="center">Item Long Text </div></th>
                                                                    <th><div align="center">UoM</div></th>
                                                                    <th><div align="center">Quantity</div></th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="sapTenderMaster" items="${sapTenderMaster}" varStatus="status">
                                                                    <tr>
                                                                        <td><input type="checkbox" value="${sapTenderMaster.id}" name="checkId"></td>
                                                                        <td>${sapTenderMaster.srNo}</td>
                                                                                            <td>${sapTenderMaster.itemCode}</td>
                                                                                            <td>${sapTenderMaster.itemDesc}</td>
                                                                                            <td>${sapTenderMaster.deliSch}</td>
                                                                                            <td>${sapTenderMaster.uom}</td>
                                                                                            <td>${sapTenderMaster.qty}</td>
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
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="tenderMaster.htm?act=addSapItemSubmit" title="" value="Add">
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty tenderItemMaster}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th><div align="center">Sr No.</div></th>
                                                                    <th><div align="center">Item Code</div></th>
                                                                    <th><div align="center">Item Description</div></th>
                                                                    <th><div align="center">Item Long Text </div></th>
                                                                    <th><div align="center">UoM</div></th>
                                                                    <th><div align="center">Quantity</div></th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                                                    <tr>
                                                                        <td><input type="checkbox" value="${tenderItemMaster.id}" name="checkedIdd"></td>
                                                                        <td>${tenderItemMaster.srNo}</td>
                                                                                            <td>${tenderItemMaster.itemCode}</td>
                                                                                            <td>${tenderItemMaster.itemDescription}</td>
                                                                                            <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                                                                            <td>${tenderItemMaster.uom}</td>
                                                                                            <td>${tenderItemMaster.qty}</td>
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
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" formaction="tenderMaster.htm?act=deleteSapItem" title="" value="Delete">
                                            
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
