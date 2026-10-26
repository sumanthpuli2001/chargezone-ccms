<%-- 
    Document   : VendorAllLevelOneCriteria
    Created on : 4 Jan, 2025, 5:40:37 PM
    Author     : bulwarks-2
--%>

<%-- 
    Document   : VendorLevelOneHrCriteria
    Created on : 4 Jan, 2025, 12:50:33 PM
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
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }
            @media print{
                a[href]:after{
                    content :none !important;
                }
            }
        </style>


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
            <!-- Content Header (Page header) -->
         <section class="content-header">
                <h1>View All  Criteria</h1>
                <ol class="breadcrumb">

                    <input type="button" class="btn btn-primary" style="width: 100px;position: relative; bottom: 2vh; width: 100px; " onclick="history.back();" title="" value="Back">
                    <input type="button" class="btn btn-primary" style="width: 100px;position: relative; bottom: 2vh; width: 100px; " onclick="window.print();" title="" value="Print">
                </ol>
            </section>

            <!-- Main content -->
            <form:form action="vendorInformation.htm?act=allCriteriaLevelOneSubmited" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                       class="form-horizontal" role="form" name="form">
                <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}"/>





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
                                        <form:form action="vendorInformation.htm?act=allCriteriaSubmited" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                                   class="form-horizontal" role="form" name="form">
                                            <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}"/>


                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label class="control-label">Vendor Details</label>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">

                                                    <tbody>
                                                        <!-- Company Name -->
                                                        <tr>
                                                            <td>Company Name </td>
                                                            <td>${vendorInvitation.companyName}</td>
                                                        </tr>
                                                        <!-- Email Id -->
                                                        <tr>
                                                            <td>Email Id </td>
                                                            <td>${vendorInvitation.vendorEmailId}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">Type Of Vendors  </label>
                                                </div>
                                                <div class="col-sm-12">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                        <c:forEach var="list" items="${list7}" varStatus="status">

                                                            <tr>
                                                            <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list[2]}<" />
                                                            <td>${list[2]}</td>
                                                            <td>${list[3]}</td>
                                                            <td>${list[4]}</td>
                                                            </tr>
                                                        </c:forEach>

                                                    </table>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td>Type of Concern</td>
                                                            <td>${vendorInformation.typeOfConcern}</td>
                                                            <td>Country</td>
                                                            <td>${vendorInformation.officeCountry}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>State</td>
                                                            <td>${vendorInformation.officeState}</td>
                                                            <td>City</td>
                                                            <td>${vendorInformation.officeCity}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>House No.</td>
                                                            <td>${vendorInformation.officeAddressLine1}</td>
                                                            <td>Street</td>
                                                            <td>${vendorInformation.officeAddressLine2}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>District</td>
                                                            <td>${vendorInformation.officeAddressLine3}</td>
                                                            <td>PIN/ZIP Code</td>
                                                            <td>${vendorInformation.officePin}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Year of Establishment of Company</td>
                                                            <td>${vendorInformation.officeWebsite}</td>
                                                            <td>Company Website</td>
                                                            <td>${vendorInformation.officeWebsite}</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Primary Mobile No</td>
                                                            <td>${vendorInformation.officeTelephone}</td>
                                                            <td>Secondary Mobile No</td>
                                                            <td>${vendorInformation.sales_phone}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label class="control-label">Vendor Contacts</label>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Type</th>
                                                            <th>Name</th>
                                                            <th>Job Title</th>
                                                            <th>Phone No.</th>
                                                            <th>Email</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <!-- Sales/Commercial Contact(s) -->
                                                        <tr>
                                                            <td>Sales/Commercial Contact(s) </td>
                                                            <td>${vendorInformation.sales_name}</td>
                                                            <td>${vendorInformation.sales_job}</td>
                                                            <td>${vendorInformation.sales_phone}</td>
                                                            <td>${vendorInformation.saleEmail}</td>
                                                        </tr>
                                                        <!-- Technical Contact(s) -->
                                                        <tr>
                                                            <td>Technical Contact(s) </td>
                                                            <td>${vendorInformation.technical_name}</td>
                                                            <td>${vendorInformation.technical_job}</td>
                                                            <td>${vendorInformation.technical_phone}</td>
                                                            <td>${vendorInformation.technicalContactEmail}</td>
                                                        </tr>
                                                        <!-- Quality/Health & Safety Contact(s) -->
                                                        <tr>
                                                            <td>Finance and Accounts </td>
                                                            <td>${vendorInformation.quality_name}</td>
                                                            <td>${vendorInformation.quality_job}</td>
                                                            <td>${vendorInformation.quality_phone}</td>
                                                            <td>${vendorInformation.qualityEmail}</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label class="control-label">Company Registration Details</label>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">

                                                    <tbody>
                                                        <!-- GST No -->
                                                        <tr>
                                                            <td>GST No. </td>
                                                            <td>${vendorInformation.gstinNo}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.gstinFile}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.gstinFile}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- PAN No -->
                                                        <tr>
                                                            <td>PAN No. </td>
                                                            <td>${vendorInformation.panNo}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.panFile}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.panFile}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- MSME No -->
                                                        <tr>
                                                            <td>MSME No</td>
                                                            <td>${vendorInformation.service_tax}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.service_file}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.service_file}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- EPFO No -->
                                                        <tr>
                                                            <td>EPFO No. </td>
                                                            <td>${vendorInformation.pfNo}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.pfAttachment}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.pfAttachment}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- IEC -->
                                                        <tr>
                                                            <td>Import Export Code </td>
                                                            <td>${vendorInformation.ecc_file}</td>
                                                            <td>
                                                                ${vendorInformation.ecc_file}
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label class="control-label">Payment/Banking Information</label>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">

                                                    <tbody>
                                                        <!-- Account Number -->
                                                        <tr>
                                                            <td>Account Number </td>
                                                            <td>${vendorInformation.accountNumber}</td>
                                                        </tr>
                                                        <!-- Bank Name -->
                                                        <tr>
                                                            <td>Bank Name </td>
                                                            <td>${vendorInformation.bankName}</td>
                                                        </tr>
                                                        <!-- Branch -->
                                                        <tr>
                                                            <td>Branch </td>
                                                            <td>${vendorInformation.branch}</td>
                                                        </tr>
                                                        <!-- IFSC Code -->
                                                        <tr>
                                                            <td>IFSC Code </td>
                                                            <td>${vendorInformation.ifscCode}</td>
                                                        </tr>
                                                        <!-- Swift Code -->
                                                        <tr>
                                                            <td>Swift Code (if any)</td>
                                                            <td>${vendorInformation.swiftCode}</td>
                                                        </tr>
                                                        <!-- Cancel Cheque -->
                                                        <tr>
                                                            <td>Cancel Cheque </td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.cancelCheck}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.cancelCheck}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                    <label class="control-label">FINANCIAL STATEMENT (PROFIT AND LOSS / BALANCE SHEET)</label>
                                                </div>
                                            </div>

                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr style="background: gainsboro;">
                                                            <th>Year</th>
                                                            <th>Financial Year</th>
                                                            <th>Financial Amount</th>
                                                            <th>Financial Attachment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <!-- 1st Year -->
                                                        <tr>
                                                            <td>1st Year </td>
                                                            <td>${vendorInformation.finical1}</td>
                                                            <td>${vendorInformation.finicalAmount1}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment1}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.finicalAttachment1}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- 2nd Year -->
                                                        <tr>
                                                            <td>2nd Year </td>
                                                            <td>${vendorInformation.finical2}</td>
                                                            <td>${vendorInformation.finicalAmount2}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment2}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.finicalAttachment2}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                        <!-- 3rd Year -->
                                                        <tr>
                                                            <td>3rd Year </td>
                                                            <td>${vendorInformation.finical3}</td>
                                                            <td>${vendorInformation.finicalAmount3}</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${vendorInformation.finicalAttachment3}&amp;id=${vendorInformation.id}">
                                                                    ${vendorInformation.finicalAttachment3}
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>


                                            <!-- General Criteria -->
                                            <h5>General Criteria</h5>
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped table-hover">
                                                    <thead>
                                                        <tr style="background: gainsboro;">
                                                            <th>Criteria</th>
                                                            <th>Selection Criteria</th>
                                                            <th>Score</th>
                                                            <th>Comment</th>
                                                            <th>Attachment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="total" value="0" />
                                                        <c:set var="size" value="${list4.size() * 2}" />
                                                        <c:forEach var="list4" items="${list4}" varStatus="status">
                                                            <c:set var="total" value="${list4.score + total}" />
                                                            <tr>
                                                                <td>${list4.criteria}</td>
                                                                <td>${list4.selectionCriteria}</td>
                                                                <td>${list4.score}</td>
                                                                <td>${list4.comment}</td>
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list4.attachment}&amp;id=${list4.id}">
                                                                        ${list4.attachment}
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="2"><strong>Total</strong></td>
                                                            <td>${total}</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"><strong>Total Percentage</strong></td>
                                                            <td>${(total * 100) / size}%</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <!-- HR Criteria -->
                                            <h5>HR Criteria</h5>
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped table-hover">
                                                    <thead>
                                                        <tr style="background: gainsboro;">
                                                            <th>Criteria</th>
                                                            <th>Selection Criteria</th>
                                                            <th>Score</th>
                                                            <th>Comment</th>
                                                            <th>Attachment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="total1" value="0" />
                                                        <c:set var="size1" value="${list5.size() * 2}" />
                                                        <c:forEach var="list5" items="${list5}" varStatus="status">
                                                            <c:set var="total1" value="${list5.score + total1}" />
                                                            <tr>
                                                                <td>${list5.criteriaName}</td>
                                                                <td>${list5.criteriaDescription}</td>
                                                                <td>${list5.score}</td>
                                                                <td>${list5.comment}</td>
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list5.attachement}&amp;id=${list5.id}">
                                                                        ${list5.attachement}
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="2"><strong>Total</strong></td>
                                                            <td>${total1}</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"><strong>Total Percentage</strong></td>
                                                            <td>${(total1 * 100) / size1}%</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <!-- Safety Criteria -->
                                            <h5>Safety Criteria</h5>
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped table-hover">
                                                    <thead>
                                                        <tr style="background: gainsboro;">
                                                            <th>Criteria</th>
                                                            <th>Selection Criteria</th>
                                                            <th>Score</th>
                                                            <th>Comment</th>
                                                            <th>Attachment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:set var="total2" value="0" />
                                                        <c:set var="size2" value="${list6.size() * 2}" />
                                                        <c:forEach var="list6" items="${list6}" varStatus="status">
                                                            <c:set var="total2" value="${list6.score + total2}" />
                                                            <tr>
                                                                <td>${list6.criteriaName}</td>
                                                                <td>${list6.criteriaDescription}</td>
                                                                <td>${list6.score}</td>
                                                                <td>${list6.comment}</td>
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list6.attachement}&amp;id=${list6.id}">
                                                                        ${list6.attachement}
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="2"><strong>Total</strong></td>
                                                            <td>${total2}</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"><strong>Total Percentage</strong></td>
                                                            <td>${String.format('%.2f', (total2 * 100) / size2)}%</td>
                                                            <td colspan="2"></td>
                                                        </tr>
                                                    </tbody>
                                                </table>









                                                <div class="form-group">
                                                    <div class="col-sm-12 text-center" style="margin-top: 20px;">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;" title="" value="SUBMIT">
                                                    </div>
                                                </div>

                                            </form:form>
                                        </div><!-- /.tab-pane -->
                                    </div><!-- /.tab-content -->
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                </section><!-- /.content -->

            </form:form>
        </div>


        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    </body>
    <body onload="response();">

    </body>

</html>


