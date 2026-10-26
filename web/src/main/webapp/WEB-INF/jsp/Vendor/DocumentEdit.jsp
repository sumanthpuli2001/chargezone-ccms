<%-- 
    Document   : SapEdit
    Created on : Oct 18, 2023, 12:07:42 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Document Edit</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                <h3 style="margin-top: 1px;">Document Edit</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">

                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if> 
                                <form:form action="oapForm.htm?act=DocumentEditSubmit" method="post" commandName="sapConnection"
                                           class="form-horizontal" role="form">

                                    <input type="hidden" name="id" value="${documentName.id}">
                                    <input type="hidden" name="state1" id="state1" value="${state}">
                                    <input type="hidden" name="discom1" id="discom1" value="${Discom}">
                                    <input type="hidden" name="connection1" id="connection1" value="${connection1}">
                                    <input type="hidden" name="discom1id" id="discom1id" value="${discom1}">
                                    <input type="hidden" name="connectionid" id="connectionid" value="${connection}">
                                    <div class="form-group row">
                                        <!-- State -->
                                        <div class="col-md-6 col-sm-12 d-flex align-items-center">
                                            <label class="col-md-3 col-sm-4 control-label text-nowrap" for="state">State:</label>
                                            <div class="col-md-9 col-sm-8">
                                                <input type="text" class="form-control" name="documentname" id="documentname" value="${state}" readonly="true"/>
                                            </div>
                                        </div>

                                        <!-- Discom -->
                                        <div class="col-md-6 col-sm-12 d-flex align-items-center">
                                            <label class="col-md-3 col-sm-4 control-label text-nowrap" for="discom">Discom:</label>
                                            <div class="col-md-9 col-sm-8">
                                                <input type="text" class="form-control" name="discom" id="discom" value="${Discom}" readonly="true"/>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Next Row -->
                                    <div class="form-group row">
                                        <!-- Connection Type -->
                                        <div class="col-md-6 col-sm-12 d-flex align-items-center">
                                            <label class="col-md-3 col-sm-4 control-label text-nowrap" for="connection">Connection Type:</label>
                                            <div class="col-md-9 col-sm-8">
                                                <input type="text" class="form-control" name="connectiontype" id="connectiontype" value="${connection1}" readonly="true"/>
                                            </div>
                                        </div>
                                    </div>






                                    <table  class="table table-bordered mb-4" style="max-width: 95%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->


                                        <thead>
                                            <tr>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black; ">Sr. No.</th>
                                                <th style="text-align: center; vertical-align: middle ; border: 1px solid black;">Document Name</th>
                                                <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Mandatory</th>
                                                <th style="text-align: center; vertical-align: middle; border: 1px solid black;">Action</th>
                                                <!-- private String documentName;
                                                    private String state;
                                                    private String compalsuary;-->
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="list1" items="${list4}" varStatus="status">
                                                <tr style="" >
                                                    <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                                    <td style="border: 1px solid black;">${list1.documentName}</td> <!-- User ID -->
                                                    <td style="border: 1px solid black;">${list1.compalsuary}</td> <!-- Approval Comment -->
                                                    <td style="text-align: center; border: 1px solid black;">
                                                        <a href="oapForm.htm?act=delete1&id=${list1.id}&id1=${documentName.id}">
                                                            <i class="fas fa-trash-alt" style="color: red;"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>


                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="max-width: 95%" align="center">
                                                    <tr>
                                                        <!--<th style="text-align: center; vertical-align: middle">Sr. No.</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Document Name</th>
                                                        <th style="text-align: center; vertical-align: middle">Mandatory</th>

                                                        <!--                                                            <th style="text-align: center; vertical-align: middle">Document name</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    <tr id="policyRow1">
                                                        <!--                                                        <td id="policyId1">
                                                                                                                    <input type="text" class="form-control" name="srNo1" value="1" readonly>
                                                                                                                </td>                                                           -->
                                                        <td>
                                                            <input id="attachment1" name="attach" class="form-control" type="text" placeholder="Document Name" >

                                                        </td> 



                                                        <td>
                                                            <select id="description1" class="form-control" name="descriptions" placeholder="Description" required="required">
                                                                <option value="" disabled selected>--SELECT--</option>
                                                                <option value="yes">Yes</option>
                                                                <option value="no">No</option>
                                                            </select>
                                                        </td>






                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;'>
                                                                <input type="button" value="+" id="policyCloneid"/>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <script>
                                        var tempCount3 = 1;
                                        $(function () {
                                            $("#policyCloneid").on("click", function () {
                                                tempCount3++;
                                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                                        //                                                        + "<td id='policyId" + tempCount3 + "'><input type='text' class='form-control' name='srNo" + tempCount3 + "' value='" + tempCount3 + "' readonly></td>"
                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"description\" name=\"description" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                                                    + "<td id='attachment1" + tempCount3 + "'><input type='file' class='form-control' name='attachment" + "' required></td>"

                                                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Document Name\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\"></td>"
                                                        + "<td><select type=\"text\" class=\"form-control\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\">"
                                                        + "<option value=\"\" disabled selected>--SELECT--</option>"
                                                        + "<option value=\"yes\">Yes</option>"
                                                        + "<option value=\"no\">No</option>"
                                                        + "</select></td>"

                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"remark\" name=\"remark" + "\" id=\"remark" + tempCount3 + "\"></td>"


                                                        + "<td >"
                                                        + "<span style='margin-top: 5px;'>"
                                                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                                                        + "</span>"
                                                        + "</td>" + "</tr>";
                                                $("#policyTable").append(clone);
                                                document.getElementById('policyCount').value = tempCount3;
                                            });
                                        });
                                        function removePolicy(policyDiv) {
                                            try {
                                                var element1 = document.getElementById(policyDiv);
                                                element1.parentNode.removeChild(element1);
                                                // Update the serial numbers
                                                updateSerialNumbers();
                                                // Update policyCount
                                                var policyCount = document.getElementById('policyTable').rows.length - 1; // subtract 1 for header row
                                                document.getElementById('policyCount').value = policyCount;
                                            } catch (e) {
                                                console.log(e);
                                            }
                                        }



                                    </script>
                                    <br>
                                    <br>







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
