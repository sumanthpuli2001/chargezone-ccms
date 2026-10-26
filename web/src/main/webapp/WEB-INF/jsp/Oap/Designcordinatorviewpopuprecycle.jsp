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
    <div class="content-wrapper" style="margin-left: 5px;">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Service Details</h1>

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
                                <form:form action="oapForm.htm?act=Designcordinatorviewpopuprecyclesubmit" method="post" enctype="multipart/form-data" 
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="id" id="id" value="${id}">
                                    <input type="hidden" name="type" id="type" value="${type}">


                                  



                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Files <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="service_file" value="" class="form-control" />
                                        </div>
                                        <br>
                                        <div class="col-sm-3">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" title="Submit" value="Submit">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>

                                    <div style="font-weight: bold;"> Item Details </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-danger" style="width: 100px;" formaction="oapForm.htm?act=deleteDesigncordinatorviewpopup" title="" value="Delete" >

                                    <div class="form-group">
                                        <br>
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <c:choose>
                                                    <c:when test="${empty list1}">

                                                    </c:when>
                                                    <c:otherwise>

                                                        <table class="table table-bordered" style="" align="Center">
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Sr.No</th>
                                                                    <th>Item Code</th>
                                                                    <th>Item Description</th>
                                                                    <th>Purpose</th>
                                                                    <th>Make</th>
                                                                    <th>UOM</th>
                                                                    <th>Qty</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="listItem" items="${list1}" varStatus="status">
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="deptCheckId" value="${listItem.id}">
                                                                        </td>
                                                                        <td>${listItem.sno}</td>
                                                                        <td>${listItem.iteamCode}</td>
                                                                        <td>${listItem.iteamDescription}</td>
                                                                        <td>${listItem.purpose}</td>
                                                                        <td>${listItem.make}</td>
                                                                        <td>${listItem.uom}</td>
                                                                        <td>${listItem.qty}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>

                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>

                                    </div>


                                </div>
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