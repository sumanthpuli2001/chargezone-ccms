<%-- 
    Document   : TechnicalApprovalActiveView
    Created on : 7 Jan, 2025, 3:07:31 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Vendor List</title>

        <style>



            /* Main container */
            .main-container {

                margin: 20px auto;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
            }

            /* Flex container for top row */
            .flex-row {
                display: flex;
                justify-content: space-between;
                gap: 20px;
                margin-bottom: 20px;
            }

            /* Styling for left and right tables */
            .flex-table {
                flex: 1;
                border-collapse: collapse;
                width: 100%;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            .table-title {
                font-size: 18px;
                font-weight: bold;
                padding: 12px;

                text-align: center;
                background-color: #e0e7ff;
            }

            /* Table headers */
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #dddddd;
            }

            /* Alternate row colors */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e9f5ff;
            }

            /* Styling for bottom table */
            .bottom-table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            /* Link styling */
            a {
                /*color: #007BFF;*/
                text-decoration: none;
                /*font-weight: bold;*/
            }

            a:hover {
                /*text-decoration: underline;*/
            }

            /* Table cell styling */
            td:first-child {
                /*font-weight: bold;*/
                /*width: 35%;*/
                color: #333;
            }
        </style>
    </head>
    <script>
        function recycle() {
            var id = document.getElementsByName('id1');
            y = id[0].value;
            var comment = document.getElementsByName('comment');
            comment1 = comment[0].value;
            window.location = 'vendorInformation.htm?act=RecycleButtonApproval2&id=' + y + '&comment=' + comment1;
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

        function print() {
            var id = document.getElementById('id').value;


            window.location = 'vendorInformation.htm?act=technicalApprovalPrintPage&id=' + id;
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

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">Vendor List</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="vendorInformation.htm?act=ButtonApprovalsTechnical1" method="post"
                   name='form' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">

                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                            
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">


                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                    <input type="hidden" id="id" name="id" value="${list.id}">
                                                    <input type="hidden" id="id1" name="id1" value="${list.id}">


                                                    <div class="main-container">
                                                        <!-- Top row with Company Information and Policy File -->
                                                        <div class="flex-row">
                                                            <table class="flex-table"  style="" align="Center"  >

                                                                <tr class="table-title">
                                                                    <td colspan="2">Company Information</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Company Name:</td>
                                                                    <td>${list.companyName}</td>
                                                                </tr>


                                                            </table>

                                                            <table class="flex-table"  style="" align="Center"  >

                                                                <tr class="table-title">
                                                                    <td colspan="2">Policy File</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Policy File :</td>
                                                                    <td>
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}"> ${list.policy1File}</a>
                                                                    </td>
                                                                </tr>

                                                            </table>
                                                        </div>


                                                        <table class="bottom-table"  style="" align="Center"  >
                                                            <tr class="table-title">
                                                                <td colspan="2">Type of Company </td>
                                                            </tr>

                                                        </table>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label class="control-label" style="margin-left: 8px;">Type Of Vendors  :<span style="color: red;font-size: 12px;"></span></label>
                                                            </div>
                                                            <div class="col-sm-12">
                                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">

                                                                    <c:forEach var="list222" items="${list222}" varStatus="status">

                                                                        <tr>
                                                                        <input type="hidden" class="form-control" id="groupId" name="groupId" value="${list222[2]}<" />
                                                                        <td>${list222[2]}</td>
                                                                        <td>${list222[3]}</td>
                                                                        <td>${list222[4]}</td>
                                                                        </tr>
                                                                    </c:forEach>

                                                                </table>
                                                            </div>
                                                        </div>

                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" align="center">
                                                            <tr class="table-title">
                                                                <td colspan="2">Location Details</td>
                                                            </tr>

                                                            <tbody>
                                                                <tr>
                                                                    <td>Country</td>
                                                                    <td>${list.officeCountry}</td> <!-- Example Name -->


                                                                </tr>
                                                                <tr>
                                                                    <td>State</td>
                                                                    <td>${list.officeState}</td> <!-- Example Name -->
                                                                </tr>
                                                                <tr>
                                                                    <td>City</td>
                                                                    <td>${list.officeCity}</td> <!-- Example Name -->
                                                                </tr>



                                                            </tbody>
                                                        </table>     

                                                        <table class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr class="table-title">
                                                                <td colspan="2">External Provider Details</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Address </td>
                                                                <td>Office</td>
                                                            </tr>
                                                            <tr>
                                                                <td>House No</td>
                                                                <td>${list.officeAddressLine1}</td>
                                                            </tr>
                                                            <tr>
                                                                <td>Street</td>
                                                                <td>${list.officeAddressLine2}</td>

                                                            </tr>
                                                            <tr>
                                                                <td>District</td>
                                                                <td>${list.officeAddressLine3}</td>
                                                            </tr>


                                                            <tr>
                                                                <td>Pin </td>
                                                                <td>${list.officePin}</td>
                                                            </tr>


                                                            <tr>
                                                                <td>Year of Establishment of Company </td>
                                                                <td>${list.establishment}</td>
                                                            </tr>

                                                            <tr>
                                                                <td>Company Website </td>
                                                                <td>${list.officeWebsite}</td>
                                                            </tr>

                                                            <tr>
                                                                <td>Primary Mobile Number</td>
                                                                <td>${list.officeTelephone}</td>

                                                            </tr>

                                                            <tr>
                                                                <td>Secondary Mobile number</td>
                                                                <td>${list.secoundMobile}</td>
                                                            </tr>



                                                        </table>

                                                        <table class="bottom-table"  class="table table-bordered table-striped table-hover">
                                                            <thead>
                                                                <tr class="table-title" >
                                                                    <th>External Provider Contacts</th>
                                                                    <th>Name</th>
                                                                    <th>Job Title</th>
                                                                    <th>Phone No.</th>
                                                                    <th>Email </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <td>Sales/Commercial Contact(s)</td>
                                                                    <td>${list.sales_name}</td> <!-- Example Name -->
                                                                    <td>${list.sales_job}</td> <!-- Example Job Title -->
                                                                    <td>${list.sales_phone}</td> <!-- Example Contact -->
                                                                    <td>${list.saleEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Technical Contact(s)</td>
                                                                    <td>${list.technical_name}</td> <!-- Example Name -->
                                                                    <td>${list.technical_job}</td> <!-- Example Job Title -->
                                                                    <td>${list.technical_phone}</td>
                                                                    <td>${list.technicalContactEmail}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Finance and Accounts </td>
                                                                    <td>${list.quality_name}</td> <!-- Example Name -->
                                                                    <td>${list.quality_job}</td> <!-- Example Job Title -->
                                                                    <td>${list.quality_phone}</td>
                                                                    <td>${list.qualityEmail}</td>
                                                                </tr>
                                                            </tbody>
                                                        </table>


                                                        <h5>Technical Criteria</h5>

                                                        <table class="bottom-table" id="table_155" class="table table-bordered table-striped table-hover" style="" align="Center" >
                                                            <input type="hidden" name="vendorPercentage" id="vendorPercentage" value="${vendorPercentage[0].technicalPercentage}">


                                                            <tr style="background: gainsboro">

                                                                <th>Criteria</th>
                                                                <th>Selection Criteria</th>
                                                                <th>Comment</th>
                                                                <th>Attachment</th>
                                                                <th>Vendor Score</th>
                                                                <th>Accept</th>
                                                                <th>Score</th>
                                                            </tr>
                                                            <c:forEach var="list5" items="${generalList}" varStatus="status">

                                                                <tr>
                                                                    <td style="width: 15%">${list5.criteria}</td>
                                                                    <td style="width: 25%">${list5.selectionCriteria}</td>
                                                                    <td style="width: 10%">${list5.comment}</td>
                                                                    <td style="width: 15%">
                                                                        <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list5.attachment}&id=${list5.id}"> ${list5.attachment}</a>
                                                                    </td>
                                                                <input type="hidden" name="hrId" value="${list5.id}">
                                                                <td style="width: 10%">${list5.score}</td>
                                                                <td style="width: 15%">
                                                                    <select class="form-control" name="accept" id="accept${status.count}" onchange="response();">
                                                                        <c:choose>
                                                                            <c:when test="${list5.response=='2'}">
                                                                                <option selected="true" value="2">Accept</option>
                                                                                <option value="1">Partial Accept</option>  
                                                                                <option value="0">Reject</option>
                                                                            </c:when>
                                                                            <c:when test="${list5.response=='1'}">
                                                                                <option  value="2">Accept</option>
                                                                                <option selected="true" value="1">Partial Accept</option>  
                                                                                <option value="0">Reject</option>
                                                                            </c:when>
                                                                            <c:when test="${list5.response=='0'}">
                                                                                <option  value="2">Accept</option>
                                                                                <option  value="1">Partial Accept</option>  
                                                                                <option selected="true" value="0">Reject</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="2">Accept</option>
                                                                                <option value="1">Partial Accept</option>  
                                                                                <option value="0">Reject</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </select>
                                                                </td>
                                                                <td style="width: 15%"><input type="text" id="remark${status.count}"  name="remark" class="form-control"></td>
                                                                </tr>
                                                            </c:forEach>
                                                            <tr>
                                                                <td colspan="6">Total</td>
                                                                <td><input type="text" id="total" readonly="true" name="total" class="form-control"></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="6">Total Percentage</td>
                                                                <td><input type="text" id="percentage" readonly="true" name="percentage" class="form-control"></td>
                                                            </tr>
                                                        </table>





                                                    </div>
                                                    <script>
                                                        function response() {
                                                            var l = document.form.hrId.length;


                                                            var i = 1;
                                                            var sum = 0;
                                                            var total = l * 2;



                                                            if (l == null)
                                                            {
                                                                var accept = document.getElementById("accept1").value;
                                                                document.getElementById("remark1").value = accept;
                                                                var remark1 = parseFloat(document.getElementById("remark1").value) || 0; // Convert to number
                                                                sum = sum + remark1;
                                                            } else {
                                                                while (i <= l) {
                                                                    var accept = document.getElementById("accept" + i).value;
                                                                    document.getElementById("remark" + i).value = accept;
                                                                    var remark1 = parseFloat(document.getElementById("remark" + i).value) || 0; // Convert to number
                                                                    sum = sum + remark1;
                                                                    i++;
                                                                }
                                                            }
                                                            if (l != null)
                                                            {

                                                                document.getElementById("total").value = sum;

                                                                // Update total after summing
                                                                var total1 = (sum * 100) / total;
                                                                document.getElementById("percentage").value = total1.toFixed(2) + "%";
                                                                var vendorPercentage = document.getElementById("vendorPercentage").value;

                                                                if (total1 >= vendorPercentage)
                                                                {
                                                                    document.getElementById("submit1").removeAttribute('disabled');
                                                                } else {
                                                                    document.getElementById("submit1").setAttribute('disabled', true);
                                                                }
                                                            } else {
                                                                var total1 = (sum * 100) / 2;
                                                                document.getElementById("total").value = sum;
                                                                document.getElementById("percentage").value = total1.toFixed(2) + "%";

                                                                var vendorPercentage = document.getElementById("vendorPercentage").value;

                                                                if (total1 >= vendorPercentage)
                                                                {
                                                                    document.getElementById("submit1").removeAttribute('disabled');
                                                                } else {
                                                                    document.getElementById("submit1").setAttribute('disabled', true);
                                                                }


                                                            }


                                                        }
                                                    </script>

                                                </c:forEach>

                                                <table class="bottom-table"  id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                    <tr class="table-title">
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


                                                <table  class="bottom-table" id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                                                    <tr>
                                                        <td>Comment</td>
                                                        <td>
                                                            <textarea name="comment" class="form-control "></textarea>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <div class="form-group">
                                                    <div class="col-sm-12" style="text-align: center;margin-top: 10px;">
                                                        <input type="submit" class="btn btn-primary" style="width:120px!important;" id="submit1" title="submit1" value="Send To Vendor" >
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
     <body onload="response();">

    </body>
</html>

