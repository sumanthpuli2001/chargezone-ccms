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
                window.opener.showuser1('1');
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
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="tenderMaster.htm?act=addServiceDocumentSubmit" method="post" enctype="multipart/form-data" 
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">



                                    <hr>



                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">File <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="service_file" value="" class="form-control" required  onchange="form.submit()"/>
                                            <a href="StorageYard/Sample_File For Create PR new.xlsx">Eg. Item Details File</a>
                                        </div>
                                    </div>


                                    <div class="form-group">
<!--                                        <div class="col-sm-6 col-sm-offset-5">
                                             <input type="submit" class="btn btn-primary" style="width: 100px;" title="Submit" value="Submit"> 
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>-->
                                    </div>

                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">

                                            <c:choose>
                                                <c:when test="${empty tenderItemMaster}">

                                                </c:when>
                                                <c:otherwise>

                                                    <c:set var="count" value="0" scope="page" />


                                                    <div style="overflow-x: auto; border: 1px solid #ddd; margin: auto;">
                                                        <table class="table table-bordered" style="min-width: 1500px; width: 100%;" align="center">
                                                            <thead>
                                                                <tr style="width: 5vh;">
                                                                    <th style="padding: 8px 35px;">Sr. No.</th>
                                                                    <th style="padding: 8px 35px;">Item Code</th>
                                                                    <th style="padding: 8px 30vh;">Item Description</th>
                                                                    <th style="padding: 8px 35px;">Purchase</th>
                                                                    <th style="padding: 8px 25vh;">Make</th>
                                                                    <th style="padding: 8px 35px;">Qty</th>   
                                                                    <th style="padding: 8px 35px;">UOM</th> 
                                                                    <th style="padding: 8px 35px;">Account Category</th>
                                                                    <th style="padding: 8px 35px;">Account Value</th>
                                                                    <th style="padding: 8px 35px;">Product Type</th>
                                                                    <th style="padding: 8px 35px;">Product Group</th>
                                                                    <th style="padding: 8px 35px;">TAX Code</th>
                                                                    <th style="padding: 8px 35px;">Price</th>
                                                                    <th style="padding: 8px 35px;">Delivery Date</th>
                                                                    <th style="padding: 8px 35px;">Start Date</th>
                                                                    <th style="padding: 8px 35px;">End Date</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">

                                                                    <tr>
                                                                        <td>${tenderItemMaster.srNo}</td>
                                                                        <td>${tenderItemMaster.itemCode}</td>
                                                                        <td>${tenderItemMaster.itemDescription}</td>
                                                                        <td>${tenderItemMaster.deliveryScheduleQty}</td>
                                                                        <td>${tenderItemMaster.deliveryScheduleDate}</td>

                                                                        <td>${tenderItemMaster.qty}</td>
                                                                        <td>${tenderItemMaster.uom}</td>
                                                                        <td>${tenderItemMaster.accountAssigmentCategory}</td>
                                                                        <td>${tenderItemMaster.accountAssigmentValue}</td>
                                                                        <td>${tenderItemMaster.productType}</td>
                                                                        <td>${tenderItemMaster.productGroup}</td>
                                                                        <td>${tenderItemMaster.taxCode}</td>
                                                                        <td>${tenderItemMaster.valuationPrice}</td>
                                                                        <td>${tenderItemMaster.deliveryDate}</td>
                                                                        <td>${tenderItemMaster.startDate}</td>
                                                                        <td>${tenderItemMaster.endDate}</td>
                                                                    </tr>
                                                                </c:forEach>


                                                            </tbody>
                                                        </table>
                                                    </div>



                                                    <hr>

                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="text-center">

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