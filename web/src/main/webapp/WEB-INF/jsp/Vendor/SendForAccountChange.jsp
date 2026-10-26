<%-- 
    Document   : SendForAccountChange
    Created on : 19 Feb, 2025, 1:00:04 PM
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
                <div style="display: flex; height: 25px;
                     justify-content: space-between;
                     align-items: center;">
                    <h3 style="margin-top: 1px;">Vendor Information</h3>
                    <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
                </div>
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
                                                    <c:if test="${vendorInformation.status1=='3' or vendorInformation.finacialFlag=='3' or vendorInformation.technicalFlag=='3' or vendorInformation.hrApprovalFlag=='3' or vendorInformation.safteyApprovalFlag=='3'}">
                                                        <div style="border: 1px solid; padding: 10px; border-radius: 5px; margin: 6px;">
                                                            <c:if test="${vendorInformation.status1=='3'}">
                                                                <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Level 1 Team</p>
                                                            </c:if>
                                                            <c:if test="${vendorInformation.finacialFlag=='3'}">
                                                                <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Financial Approval Team</p>
                                                            </c:if>
                                                            <c:if test="${vendorInformation.technicalFlag=='3'}">
                                                                <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Technical Team</p>
                                                            </c:if>
                                                            <c:if test="${vendorInformation.hrApprovalFlag=='3'}">
                                                                <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By HR Approval Team</p>
                                                            </c:if>
                                                            <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">
                                                                <p style="margin: 0; color: #007bff; font-weight: bold;">Recycle By Safety Approval Team</p>
                                                            </c:if>
                                                        </div>
                                                    </c:if>

                                                    <div id="exTab" class="">	
                                                        <ul class="nav nav-pills nav-tabs ">
                                                            <li class="active"><a href="vendorInformation.htm?act=policyUpdateVendorInformation" <c:if test="${vendorInformation.status1=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>1 <sup>st</sup> Level Approve</a></li>
                                                            <li ><a href="vendorInformation.htm?act=policyUpdateVendorInformation" <c:if test="${vendorInformation.finacialFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Finacial Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=electricTechnicalRecycle" <c:if test="${vendorInformation.technicalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Technical Approval</a></li>
                                                            <li><a href="vendorInformation.htm?act=hrCriteriaRecycleView" <c:if test="${vendorInformation.hrApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>HR Approval</a></li>

                                                                <li><a href="vendorInformation.htm?act=safetyCriteriaRecycleView" <c:if test="${vendorInformation.safteyApprovalFlag=='3'}">style="color: red;"</c:if>><i class="fa fa-circle-o"></i>Safety Approval</a></li>
                                                                <li ><a href="vendorInformation.htm?act=activeVenderProfileView" ><i class="fa fa-circle-o"></i>View Vendor</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <h4 style="color:green;">Changes Related Account Details Send successfully.......</h4>
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


