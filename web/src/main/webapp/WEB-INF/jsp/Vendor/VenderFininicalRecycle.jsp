<%-- 
    Document   : VenderFininicalRecycle
    Created on : 4 Jan, 2025, 9:18:02 AM
    Author     : bulwarks-2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vendor Information</title>
        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>

        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper" style="min-height: 720px;">
            <section class="content-header">
                <h1>Vendor Information</h1>
            </section>
            <section class="content">

                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" style="padding: 0px" role="alert">Information Submited Successfully</div>
                                </c:if>
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                                </c:if>
                                <form:form action="" method="post" commandName="vendorInformation"
                                           class="form-horizontal" role="form">
                                    <section class="content">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <!-- Custom Tabs -->
                                                <div class="nav-tabs-custom">
                                                    <div id="exTab" class="">	
                                                        <ul class="nav nav-pills nav-tabs ">
                                                            <li ><a href="vendorInformation.htm?act=policyUpdateVendorInformation"><i class="fa fa-circle-o"></i>1 <sup>st</sup> Level Approve</a></li>
                                                            <li class="active"><a href="vendorInformation.htm?act=policyUpdateVendorInformation"><i class="fa fa-circle-o"></i>Finacial Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=technicalApproval"><i class="fa fa-circle-o"></i>Technical Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=hrApproval"><i class="fa fa-circle-o"></i>HR Approval</a></li>

                                                            <li><a href="vendorInformation.htm?act=safetyApproval"><i class="fa fa-circle-o"></i>Safety Approval</a></li>
                                                            <li ><a href="vendorInformation.htm?act=activeVendor"><i class="fa fa-circle-o"></i>Active Vendor</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                  <h4 style="color:green;">  Your Profile Updated Successfully</h4>
                                            </div>
                                        </div>
                                    </section>
                                  


                                </form:form>

                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->

            </section><!-- /.content -->
        </div>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>


    </body>

</html>

