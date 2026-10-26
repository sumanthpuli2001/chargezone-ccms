<%-- 
    Document   : ApprovalWorkFlowSelect
    Created on : 29 Jan, 2024, 4:50:30 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <title>Approve Auction Work Flow</title>

        <script>
            var tempCount1 = 1;
            $(function () {
                $("#glCloneid").on("click", function () {
                    tempCount1++;
                    var clone = "<tr id='glFile" + tempCount1 + "' style='clear:both;'>"

                            + "<td id=\"glTd" + tempCount1 + "\" style=\"text-align: center\"><input type=\"text\" step=\"any\" name='glcode" + tempCount1 + "' id='glcode" + tempCount1 + "'  class=\"form-control\"></td>"
                            + "<td ><div><select id='costCenterId" + tempCount1 + "' name='costCenterId" + tempCount1 + "' class=\"form-control\">"
                            + "</select>"
                            + "</div><span id=\"policyError" + tempCount1 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='costCenterNo" + tempCount1 + "' id='costCenterNo" + tempCount1 + "'  class=\"form-control\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removegl('glFile" + tempCount1 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#glTable").append(clone);
                    document.getElementById('policyCount').value = tempCount1;
                    alert(tempCount1);
                    addAGL(tempCount1);
                });
            });
            function addAGL(id) {
                var element2 = document.getElementById('costCenterId1');
                var obj2 = document.getElementById("costCenterId" + id);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removegl(policyDiv) {
                try {
                    var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("glFile")[1];
                    var val = document.getElementById("policyCount").value;
                    // var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {
                }
            }
        </script>

        <script>
            var tempCount2 = 1;
            $(function () {
                $("#dcCloneid").on("click", function () {
                    tempCount2++;
                    var clone = "<tr id='dcNumber" + tempCount2 + "' style='clear:both;'>"


                            + "<td id=\"dcNumberTd" + tempCount2 + "\" style=\"text-align: center\"><input type=\"text\"  name='dcNumber" + tempCount2 + "' id='dcNumber" + tempCount2 + "'   class=\"form-control\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removedc('dcNumber" + tempCount2 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#dcTable").append(clone);
                    document.getElementById('dcCount').value = tempCount2;
                    addAPolicy(tempCount2);
                });
            });
            function addAPolicy(id) {
                var element2 = document.getElementById('dcId1');
                var obj2 = document.getElementById("policyId" + id);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removedc(policyDiv) {
                try {
                    var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("dcNumber")[1];
                    var val = document.getElementById("policyCount").value;
                    //   var element = document.getElementsByName("dcNumber" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {
                }
            }
        </script>

        <script>
            var tempCount3 = 1;
            $(function () {
                $("#policyCloneid").on("click", function () {
                    console.log("H1");
                    tempCount3++;
                    var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"


                            + "<td id=\"addmoreFile" + tempCount3 + "\" style=\"text-align: center\"><div><select id='userList" + tempCount3 + "' name='userList" + tempCount3 + "' class=\"form-control\">"
                            + "</select>"
                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#policyTable").append(clone);
                    document.getElementById('policyCount').value = tempCount3;

                    addBPolicy(tempCount3);

                });
            });
            function addBPolicy(id) {

                var element2 = document.getElementById('userList1');
                var obj2 = document.getElementById("userList" + id);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removePolicy(policyDiv) {
                try {
                    var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("addmoreFile")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {
                }
            }
        </script>


        <script>
            var tempCount4 = 1;
            $(function () {

                $("#imageCloneid").on("click", function () {
                    tempCount4++;
                    var clone = "<tr id='imageId" + tempCount4 + "' style='clear:both;'>"


                            + "<td id=\"imageFileId" + tempCount4 + "\" style=\"text-align: center\"><div><input type='file' id='imageId" + tempCount4 + "' name='imageId" + tempCount4 + "' class=\"form-control\">"

                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removeImage('imageId" + tempCount4 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";

                    let
                    ids = document.getElementById("ids")
                    ids.value = tempCount4;
                    console.log(ids);
                    $("#imageTable").append(clone);
                    document.getElementById('imageCount').value = tempCount4;
                    addAPolicy(tempCount4);
                });
            });
            function addAPolicy(id) {
                var element2 = document.getElementById('imageId1');
                var obj2 = document.getElementById("imageId" + id);
                let
                ids = document.getElementById("ids")
                ids.value = element2.options.length;
                console.log(ids);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removeImage(policyDiv) {
                try {
                    var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("imageId")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {
                }
            }
        </script>


        <script>
            var tempCount5 = 1;
            $(function () {
                $("#attachmentCloneid").on("click", function () {
                    tempCount5++;
                    var clone = "<tr id='attachmentId" + tempCount5 + "' style='clear:both;'>"


                            + "<td id=\"attachmentFileId" + tempCount5 + "\" style=\"text-align: center\"><div><input type='file' id='attachmentId" + tempCount5 + "' name='attachmentId" + tempCount5 + "' class=\"form-control\">"

                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removeAttachment('attachmentId" + tempCount5 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#attachmentTable").append(clone);
                    document.getElementById('attachmentCount').value = tempCount5;
                    addAPolicy(tempCount5);
                });
            });
            function addAPolicy(id) {
                var element2 = document.getElementById('attachmentId1');
                var obj2 = document.getElementById("attachmentId" + id);
                var ids = document.getElementById(ids);
                ids.value = id;
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }
            function removeAttachment(policyDiv) {
                try {
                    var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("attachmentId")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {
                }
            }
        </script>


        <script>

            jQuery.noConflict();
            jQuery(document).ready(function () {
                jQuery("#vendorCode").tokenInput(${preList}, {
                    preventDuplicates: true,
                    noResultsText: "No Result", tokenLimit: "1",
                    searchingText: "Searching ......",
                    prePopulate: "[]"
                });
            });






        </script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>


    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Approve Auction Work Flow</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approve Auction Work Flow</li>
            </ol>
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
                                <form:form action="auctionMaster.htm?act=approvalWorkFlowSubmit" method="post" commandName="tenderMaster"
                                           class="form-horizontal" role="form" enctype="multipart/form-data">
                                    <P align="right">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="history.back();" title="" value="Back" >
                                            </P>
                                    <input type="hidden" id="id" name="id" value="${id}">

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction No:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="refNo" name="refNo" value="${refNo}" readonly="true">
                                        </div>
                                    <!--    <div class="col-sm-2">
                                            <label class="control-label">Vendor Code:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="vendorCode" name="vendorCode" value="${vendorCode}">
                                        </div> -->
                                    </div>




                                    <hr>    
                                    <p>Auction Approval</p><hr>
                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <tr>

                                                        <th style="text-align: center; vertical-align: middle">Approval List</th>
                                                        <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->

                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    <tr>

                                                        <td id="policyId1"><div>
                                                                <select id="tenderApprovalSetting"  name="tenderApprovalSetting"   class="form-control">
                                                                 <c:forEach var="tenderApprovalSetting" items="${tenderApprovalSetting}" varStatus = "status">
                                                                
                                                                   
                                                                   
                                                                        <option value="${tenderApprovalSetting.id}">${tenderApprovalSetting.approvalName}</option>
                                                                  
                                                                
                                                                 </c:forEach>
                                                                        </select>
                                                            </div>
                                                            <span id="policyError1" style="color: red;"></span>
                                                        </td>





                                                    </tr>
                                                </table>

                                                <hr>

                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label class="control-label">Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <textarea type="text" class="form-control" id="comment" name="comment" value="${comment}" required="true"></textarea>
                                                    </div>
                                                </div>

                                               

                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
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

                    </html>
