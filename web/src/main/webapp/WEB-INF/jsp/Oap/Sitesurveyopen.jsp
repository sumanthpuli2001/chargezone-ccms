<%-- 
    Document   : Sitesurveyopen
    Created on : Apr 17, 2025, 3:06:22 PM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Site Survey Form</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" />

        <!-- Include Flatpickr JS -->
        <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
        <style>
            textArea{
                resize: vertical;
            }
        </style>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                <h3 style="margin-top: 1px;">Site Survey Form</h3>
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
        <form:form action="oapForm.htm?act=Sitesurveyopensubmit" method="post" commandName="oapForm"
                   name='form1'  class="form-horizontal" role="form">
            <input type="hidden" name="surveyid" id="surveyid" value="${surveyid}"/>
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
                                        <table class="table table-bordered" id="table_1" style="max-width: 95%; margin: auto; border: 1px solid black; border-collapse: collapse;">
                                            <tbody>
                                                <tr>
                                                    <td colspan="3" style="height: 10vh; border: 1px solid black; text-align: center; vertical-align: middle;">
                                                        <img src="StorageYard/Images/logo.png" style="background-color: white; max-height: 8vh;">
                                                    </td>

                                                    <td colspan="4" style="border: 1px solid black; text-align: center; vertical-align: middle; padding: 10px; font-weight: bold; font-size: 2.5vh;">Pre Installation Site Survey Report (PISSR)</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <br>
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered mb-3" style="max-width: 98%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                                    <thead>
                                                        <tr>
                                                            <td colspan="6" style="border: 1px solid black; background-color: skyblue"><strong>START OF THE DOCUMENT (ALL THE FIELDS ARE MANDATORY TO FILL)</strong></td>
                                                        </tr>
                                                    <tbody>
                                                        <tr>
                                                            <td colspan="2" style="border: 1px solid black;"><strong>Site Visit Date</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                            <td style="border: 1px solid black;">
                                                                <div class="input-group">
                                                                    <input name="sitedate1" style="width: 43vh; " type="text" placeholder="DD-MM-YYYY" class="form-control form_datetime" id="datetimepickers" required maxlength="30" required="required" autocomplete="off"/>
                                                                </div>
                                                            </td>
                                                            <td  colspan="2"style="border: 1px solid black;"><strong>Name of person who Conducted Site Survey</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                            <td style="border: 1px solid black;">
                                                                <input type="text" class="form-control" style="width: 43vh; "  name="Namesurveyperson" id="Namesurveyperson" required />
                                                            </td>

                                                        </tr>

                                                    <script>
$(function () {

                                                        // Initialize Flatpickr
                                                        flatpickr("#datetimepickers", {
                                                            dateFormat: "d-m-Y", // Set your desired format
                                                            allowInput: true // Allow manual input if required
                                                        });
                                                        });
                                                                                                        </script>

                                                    <tr>
                                                        <td colspan="2" style="border: 1px solid black;"><strong>Site Name </strong><span style="color: red;font-size: 12px;">*</span></td>
                                                        <td style="border: 1px solid black;">
                                                            <div class="input-group">
                                                                <input type="text" class="form-control" style="width: 43vh; "  name="Sitename" id="Sitename"  value="${siteSurvey.siteName}" readonly="true" />
                                                            </div>
                                                        </td>


                                                        </tbody>

                                                    <thead>
                                                        <tr style="background: red; color: white;">
                                                            <th style="width: 5%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Sr. No</th>
                                                            <th style="width: 20%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Points to be noted</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Description</th>
                                                            <th  colspan="2"style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Remarks</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Guidelines</th>
                                                        </tr>


                                                    </thead>

                                                    <tbody>
                                                        <c:forEach var="surveyCategory" items="${surveyCategory}" varStatus="status">

                                                            <c:set  var="category" value=""/>
                                                            <c:if test="${surveyCategory.categoryName!=''}">
                                                                <tr>
                                                                    <td colspan="6" style="border: 1px solid black;background-color: skyblue;padding: 4px; line-height: 1.2;"><b>${surveyCategory.categoryName}</b></td>
                                                                </tr>
                                                            </c:if>

                                                            <c:set var="counts" value="0"/>
                                                            <c:forEach var="surveySuCategory" items="${surveySuCategory}" varStatus="status1">

                                                                <c:if test="${surveySuCategory.surveyCategoryId==surveyCategory.id}">
                                                                    <c:set var="counts" value="${counts+1}"/>
                                                                    <tr>
                                                                        <td style="border: 1px solid black;">${counts}</td>
                                                                        <td style="border: 1px solid black;">${surveySuCategory.subCategoryName}</td>

                                                                        <td style="border: 1px solid black;">
                                                                            <textarea style="width: 100%" id="description" style="" required="true" name="description"></textarea>
                                                                        </td>
                                                                        <td  colspan="2"style="border: 1px solid black;">
                                                                            <textarea style="width: 100%" id="remarks" required="true"  name="remarks"></textarea>
                                                                        </td>
                                                                        <td style="border: 1px solid black;">${surveySuCategory.guidelines}</td>

                                                                    </tr>
                                                                </c:if>

                                                            </c:forEach>

                                                        </c:forEach>
                                                    </tbody>







                                                </table>




                                                <table style="max-width: 98%; margin: auto; border: 1px solid black; border-collapse: collapse;">
                                                    <thead>

                                                        <tr>
                                                        <tr style="background: red; color: white;">
                                                            <th style="width: 7%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Sr. No</th>
                                                            <th style="width: 20%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Points to be noted</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Description</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Remarks</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Guidelines</th>
                                                            <th style="width: 3%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Action</th>

                                                        </tr>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="6" style="border: 1px solid black;background-color: skyblue;padding: 4px; line-height: 1.2;"><b>Document for New Electricity Connection</b></td>

                                                        </tr>
                                                    </thead>
                                                    <tbody id="policyBody">
                                                        <tr id="addmoreFile1"  style="border: 1px solid black;">
                                                            <td id="policyBody">
                                                                <input type="hidden" class="form-control" name="srNo1" value="1" disabled>
                                                                &nbsp;&nbsp; 1
                                                            </td>


                                                            <td style="border: 1px solid black;"> <textarea  type="text" placeholder="Points to be noted" class="form-control" id="roll" name="roll" required="required"></textarea>  
                                                            <td style="border: 1px solid black;">
                                                                <textarea  placeholder="Description" class="form-control" id="email" name="email" required="required"></textarea> 
                                                            </td>
                                                            <td style="border: 1px solid black;">
                                                                <textarea  type="text" placeholder="Remarks" class="form-control" id="cellno" name="cellno" required="required"></textarea> 
                                                            <td style="border: 1px solid black;"><textarea type="text" placeholder="Guidelines" class="form-control" id="guidlines" name="guidlines" required="required"></textarea> 

                                                            <td style="text-align: center; border: 1px solid black;">
                                                                <span style="margin-top: 5px;">
                                                                    <input type="button" value="+" id="policyCloneid"/>
                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </tbody>

                                                    <script>
                                                        var tempCount3 = 1;
                                                        $(function () {
                                                            $("#policyCloneid").on("click", function () {
                                                                tempCount3++;
                                                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                                                        + "<td style='border: 1px solid black;' id='policyBody" + tempCount3 + "'><input type='hidden' class='form-control' name='srNo" + tempCount3 + "' value='" + tempCount3 + "' >" + tempCount3 + "</td>"
                                                                        + "<td style='border: 1px solid black;'><textarea type =\"text\" class=\"form-control\" placeholder=\"Points to be noted\" name=\"roll" + "\" id=\"roll" + tempCount3 + "\"></textarea> "
                                                                        + "<td style='border: 1px solid black;'><textarea type =\"email\" class=\"form-control\" placeholder=\"Description\" name=\"email" + "\" id=\"email" + tempCount3 + "\"></textarea> "
                                                                        + "<td style='border: 1px solid black;'><textarea type =\"text\" class=\"form-control\" placeholder=\"Remarks\" name=\"cellno" + "\" id=\"cellno" + tempCount3 + "\"></textarea> "
                                                                        + "<td style='border: 1px solid black;'><textarea type =\"text\" class=\"form-control\" placeholder=\"Guidelines\" name=\"guidlines" + "\" id=\"guidlines" + tempCount3 + "\"></textarea> "

                                                                        + "<td style='border: 1px solid black;'>"
                                                                        + "<span style='margin-top: 5px;'>"
                                                                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                                                                        + "</span>"
                                                                        + "</td>" + "</tr>";
                                                                $("#policyBody").append(clone);
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

                                                        function updateSerialNumbers() {
                                                            var table = document.getElementById('policyTable');
                                                            var rowCount = table.rows.length;
                                                            var srNo = 1;
                                                            for (var i = 1; i < rowCount; i++) {
                                                                if (table.rows[i].id !== '') { // Skip the header row
                                                                    table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                                                                }
                                                            }
                                                        }
                                                    </script>


                                                    <thead>
                                                        <tr style="background: red; color: white;">
                                                            <th style="width: 7%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Sr. No</th>
                                                            <th style="width: 20%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Points to be noted</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Description</th>
                                                            <th style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Remarks</th>
                                                            <th colspan="2" style="width: 25%; text-align: center; vertical-align: middle; border: 1px solid black; padding: 4px; line-height: 1.2;">Guidelines</th>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="6" style="border: 1px solid black; background-color: skyblue; padding: 4px; line-height: 1.2;"><b>Site Visit Observation/Remarks</b></td>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td style="border: 1px solid black;">1</td>
                                                            <td colspan="3" style="border: 1px solid black;">
                                                                <textarea type="text" placeholder="Points to be noted" id="siteremark" name="siteremark" required style="width: 100%; height: 100%; padding: 8px;"></textarea>
                                                            </td>
                                                            <td colspan="2" style="border: 1px solid black;">
                                                                <textarea type="text" placeholder="Points to be noted" id="siteremark1" name="siteremark1" required style="width: 100%; height: 100%; padding: 8px;"></textarea>
                                                            </td>
                                                        </tr>
                                                    </tbody>

                                                    <tr>
                                                        <td colspan="6" style="border: 1px solid black; background-color: skyblue; padding: 4px; line-height: 1.2;"><b> Conclusion</b></td>
                                                    </tr>

                                                    <tbody>
                                                        <tr>
                                                            <td style="border: 1px solid black;">1</td>
                                                            <td style="border: 1px solid black;">Site confirmed for business by Chargezone</td>

                                                            <td colspan="" style="border: 1px solid black;">
                                                                <textarea type="text" placeholder="Points to be noted" id="Conclusion1" name="Conclusion1" required style="width: 100%; height: 100%; padding: 8px;"></textarea>
                                                            </td>
                                                            <td style="border: 1px solid black;">This will be filled by Chargezone business team based on site survey report</td>
                                                            <td colspan="2" style="border: 1px solid black; text-align: center;">
                                                                <div style="display: inline-block; width: 90%;">
                                                                    <select id="Conclusion2" name="Conclusion2" required style="width: 100%; padding: 8px;">
                                                                        <option value="" disabled selected>Select an option</option>
                                                                        <option value="Yes">Yes</option>
                                                                        <option value="No">No</option>
                                                                    </select>
                                                                </div>
                                                            </td>
                                                        </tr>

                                                    </tbody>







                                                </table>




                                                <br>
                                                <div class="form-group">
                                                    <div class="col-sm-3 col-sm-offset-5">
                                                        <input type="submit" id="submitButton" class="btn btn-primary" style="width: 100px;" title="" value="SUBMIT">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>









        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
</html>




