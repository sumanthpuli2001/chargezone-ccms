<%-- 
    Document   : 
    Created on : Jun 11, 2020, 2:38:52 PM
    Author     : Samir Tailor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Vendor List</title>
    </head>
    <script>
        function recycle() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;

            window.location = 'vendorInformation.htm?act=recyclevendor&id=' + y + '&comment=' + comment1;
        }
        function reject() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;

            window.location = 'vendorInformation.htm?act=rejectvendor&id=' + y + '&comment=' + comment1;
        }

        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'approvalSetting.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="vendorInformation.htm?act=approvetwosubmit" method="post" 
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">

                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">


                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <input type="hidden" id="id" name="id" value="${list.id}">
                                                    <input type="hidden" id="id1" name="id1" value="${list.id}">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Company Name :</td>
                                                            <td>${list.companyName}</td>
                                                            <td>Contact Parson Name :</td>
                                                            <td>${list.contactName}</td>
                                                        </tr>
                                                    </table>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Policy File :</td>
                                                            <td>
                                                                <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}"> ${list.policy1File}</a>
                                                            </td>
                                                        </tr>
                                                        <!--                                                        <tr>
                                                                                                                    <td>Terms & Condition File :</td>
                                                                                                                    <td><a href="vendorInformation.htm?act=downloadCertificates&amp;fileName=${list.termsConditionFile}&userId=${list.id}">${list.termsConditionFile}</a></td>
                                                        
                                                                                                                </tr>-->
                                                    </table>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <td>Type Of Concern </td>
                                                            <td>${list.typeOfConcern}</td>
                                                        </tr>

                                                        <tr>
                                                            <td>Type Of Vendors</td>
                                                            <td>

                                                                <c:if test="${list.good == 'on'}">
                                                                    Goods<br>
                                                                </c:if> 


                                                                <c:if test="${list.service == 'on'}">
                                                                    Service<br>
                                                                </c:if>
                                                                <c:if test="${list.general_traders == 'on'}">
                                                                    General Traders<br>
                                                                </c:if>

                                                                <c:if test="${list.contract == 'on'}">
                                                                    Contract <br>
                                                                </c:if> 
                                                                <c:if test="${list.electricalService == 'electrical'}">
                                                                    Electrical <br>
                                                                </c:if> 
                                                                <c:if test="${list.electricalService == 'service'}">
                                                                    Service<br>
                                                                </c:if>


                                                            </td>
                                                        </tr>


                                                    </table>


                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <h4>External Provider Details</h4>
                                                        <tr>
                                                            <td>Address </td>
                                                            <td>Office</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Address Line 1 </td>
                                                            <td>${list.officeAddressLine1}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Address Line 2 </td>
                                                            <td>${list.officeAddressLine2}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Address Line 3 </td>
                                                            <td>${list.officeAddressLine3}</td>

                                                        </tr>


                                                        <tr>
                                                            <td>Pin </td>
                                                            <td>${list.officePin}</td>

                                                        </tr>


                                                        <tr>
                                                            <td>Year of establishment of company </td>
                                                            <td>${list.establishment}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Company website </td>
                                                            <td>${list.officeWebsite}</td>

                                                        </tr>

                                                        <tr>
                                                            <td>Telephone (With STD Code) </td>
                                                            <td>${list.officeTelephone}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Business Tel No </td>
                                                            <td>${list.officeMobile}</td>

                                                        </tr>
                                                        <tr>
                                                            <td>Fax </td>
                                                            <td>${list.officeFax}</td>

                                                        </tr>


                                                    </table>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>
                                                            <tr>
                                                                <th>External Provider Contacts</th>
                                                                <th>Name</th>
                                                                <th>Job Title</th>
                                                                <th>Phone No. / Email</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Sales/Commercial Contact(s)</td>
                                                                <td>${list.sales_name}</td> <!-- Example Name -->
                                                                <td>${list.sales_job}</td> <!-- Example Job Title -->
                                                                <td>${list.sales_phone}</td> <!-- Example Contact -->
                                                            </tr>
                                                            <tr>
                                                                <td>Technical Contact(s)</td>
                                                                <td>${list.technical_name}</td> <!-- Example Name -->
                                                                <td>${list.technical_job}</td> <!-- Example Job Title -->
                                                                <td>${list.technical_phone}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Quality/Health & Safety Contact(s)</td>
                                                                <td>${list.quality_name}</td> <!-- Example Name -->
                                                                <td>${list.quality_job}</td> <!-- Example Job Title -->
                                                                <td>${list.quality_phone}</td>
                                                            </tr>
                                                        </tbody>
                                                    </table>

                                                    <table id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>
                                                            <tr>
                                                        <h4>Company registration details:</h4>

                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>CST No.</td>
                                                                <td>${list.cst_no}</td> <!-- Example Name -->

                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.cst_file}&id=${list.id}"> ${list.cst_file}</a>
                                                                </td>




                                                                <!-- Example Job Title -->

                                                            </tr>
                                                            <tr>
                                                                <td>GST No.</td>
                                                                <td>${list.gstinNo}</td> <!-- Example Name -->

                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.gstinFile}&id=${list.id}"> ${list.gstinFile}</a>
                                                                </td>
                                                                <!-- Example Job Title -->
                                                            </tr>
                                                            <tr>
                                                                <td>VAT TIN No.</td>
                                                                <td>${list.vat_pin}</td> <!-- Example Name -->


                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.vat_file}&id=${list.id}"> ${list.vat_file}</a>
                                                                </td>
                                                            </tr>

                                                            <tr>
                                                                <td>PAN No.</td>
                                                                <td>${list.panNo}</td> <!-- Example Name -->

                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.panFile}&id=${list.id}"> ${list.panFile}</a>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>Service tax No.</td>
                                                                <td>${list.service_tax}</td> <!-- Example Name -->
                                                                <!-- Example Job Title -->
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.service_file}&id=${list.id}"> ${list.service_file}</a>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>ECC (Excise Control Code) No.</td>
                                                                <td>${list.ecc_no}</td> <!-- Example Name -->
                                                                <!-- Example Job Title -->
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ecc_file}&id=${list.id}"> ${list.ecc_file}</a>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>


                                                    <table id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                        <thead>
                                                            <tr>
                                                        <h4>Payment/Banking Information:</h4>

                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>Account Number.</td>
                                                                <td>${list.accountNumber}</td> <!-- Example Name -->


                                                            </tr>
                                                            <tr>
                                                                <td>Bank Name</td>
                                                                <td>${list.bankName}</td> <!-- Example Name -->
                                                            </tr>
                                                            <tr>
                                                                <td>Branch.</td>
                                                                <td>${list.branch}</td> <!-- Example Name -->
                                                            </tr>

                                                            <tr>
                                                                <td>IFSC Code.</td>
                                                                <td>${list.ifscCode}</td> <!-- Example Name -->
                                                            </tr>
                                                            <tr>
                                                                <td>Swift Code (if any)</td>
                                                                <td>${list.swiftCode}</td> <!-- Example Name -->

                                                            </tr>

                                                            <tr>
                                                                <td>Employee Name</td>
                                                                <td>${list.approvalOne}</td> <!-- Example Name -->

                                                            </tr>




                                                        </tbody>
                                                    </table>


                                                    <c:if test="${list.electricalService=='electrical'}">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" align="center">

                                                            <thead>
                                                                <tr>
                                                            <h4>Table with File Attachment and Comment</h4>

                                                            </tr>
                                                            <tr>

                                                                <th>Criteria</th>
                                                                <th>Selection Criteria</th>

                                                                <th>Comment</th>
                                                                <th>Attachment</th>
                                                                <th>Score</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="list3" items="${list3}" >
                                                                    <tr>
                                                                <input type="hidden" name="id11" value="${list3.id}">

                                                                <td>${list3.criteria}</td>
                                                                <td>${list3.selectionCriteria}</td>

                                                                <td>${list3.comment}</td>
                                                                <td>
                                                                    <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list3.attachment}&userId=${list.id}"> ${list3.attachment}</a>
                                                                </td>


                                                                

                                                                <td><textarea name="score"  required="required"></textarea></td>
                                                                </tr>


                                                            </c:forEach>
                                                            </tbody>

                                                        </table>
                                                    </c:if>




                                                    <!--                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center">
                                                                                                            <tr>
                                                                                                                <td>SCORE</td>
                                                                                                                <td><textarea name="score"  required="required"></textarea></td>                                                        </tr>
                                                                                                        </table>-->











                                                </c:forEach>

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                    <tr>
                                                        <th colspan="5">Approval History</th>
                                                    </tr>
                                                </table>
                                                <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <tr>
                                                        <th style="text-align: center; vertical-align: middle">Sr. No.</th>
                                                        <th style="text-align: center; vertical-align: middle">User</th>
                                                        <th style="text-align: center; vertical-align: middle">Date Time</th>
                                                        <th style="text-align: center; vertical-align: middle">Comment</th>
                                                        <th style="text-align: center; vertical-align: middle">Action</th>
                                                    </tr>
                                                    <c:forEach var="vendorApproval" items="${vendorApproval}" varStatus="status">
                                                        <tr>
                                                            <td style="text-align: center">
                                                                ${status.count}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.userId}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.dateTime}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.description}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorApproval.activity}
                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </table>


                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                    <tr>
                                                        <td>Comment</td>
                                                        <td>
                                                            <input name="comment" class="form-control ">
                                                        </td>
                                                    </tr>
                                                </table>

                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="recycle();"> &nbsp;&nbsp;Recycle</button>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <input type="submit" class="btn btn-primary" style="float: right;width: 100px;" id="submit1" title="submit1" value="Approve" >
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="reject();">&nbsp;&nbsp;Reject</button>
                                                    </div>
                                                </div>



                                            </form:form>

                                        </div>
                                    </div>

                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>

    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
