<%-- 
    Document   : candidateF2FInvitation
    Created on : 20 Mar, 2018, 10:38:32 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Vacancy Detail List Report</title>
    </head>
    <script>
        var tempCount3 = 1;
        $(function () {
            $("#policyCloneid").on("click", function () {
                tempCount3++;
                //                alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' >"
//                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + "<td id=\"policyTd" + tempCount3 + "\"><div><input type=\"text\" id='policyId" + tempCount3 + "' name='policyId" + tempCount3 + "' class=\"form-control\" >"
                        + "</select>"
//                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
//                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "' value=" + tempCount3 + " readonly=\"true\" class=\"form-control\"></td>"
//                        + "<td style=\"text-align: center\"><input type=\"number\" name='amount" + tempCount3 + "' id='amount" + tempCount3 + "'  min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
//                $("#policyTable").addClass(token-input-input-token);
                document.getElementById('policyCount').value = tempCount3;
                jQuery("#policyId" + tempCount3).tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. .",
                    prePopulate: ${preList}
                });
//                var expenseType = document.getElementById('expenseType').value;
                addAPolicy(tempCount3);

            });
        });

        function addAPolicy(id) {
            //                alert(id);
            var element2 = document.getElementById('policyId1');
            var obj2 = document.getElementById("policyId" + id);

            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removePolicy(policyDiv) {
            try {
                tempCount3--;
                var val = document.getElementById("policyCount").value;
                val = val - 1;
                document.getElementById("policyCount").value = val;
                var element1 = document.getElementById(policyDiv);
                element1.parentNode.removeChild(element1);
            } catch (e) {

            }
        }

    </script>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Face To Face Invitation</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">F2F Invitation</li>
            </ol>
        </section>
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
                                <form:form class="form-horizontal" method="post"
                                           commandName="candidateF2FRequest" action="candidateF2FRequest.htm?act=submitFtoF" onsubmit="return saveSubmit()" >
                                    <input type="hidden" id="applicationId" name="applicationId" value="${applicationId}">   
                              
                                  
                                 
                                 <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Candidate Name:</label> &nbsp;&nbsp;&nbsp;
                                            <span>${candidateApplyJob.name}</span>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Vacancy Name:</label> &nbsp;&nbsp;&nbsp;
                                            <span>${vacancyMaster.name}</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label>Date Of Interview:<span style="color: red;font-size: 12px;">*</span></label>
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                <%--<form:input path="dateOfInterview" class="form-control" onchange="dateDifference(this.value);" placeholder="Date" readonly="true" ></form:input>--%>
                                                <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="dateOfInterview" readonly="true"/>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <%--<form:errors path="dateOfInterview" cssClass="errorDiv"></form:errors>--%>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Venue:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:textarea path="location" class="form-control" placeholder="Venue" rows="3"></form:textarea>
                                                <span id="empRemarkError" style="color: red;"></span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-8 col-sm-8">
                                                <div class="table-responsive">
                                                    <table id="policyTable" class="table table-bordered table-striped table-hover" style="margin-top: 10px" align="Center"  >
                                                        <tr>
                                                            <!--<th style="text-align: center; vertical-align: middle;width: 5%"></th>-->
                                                            <th style="text-align: center; vertical-align: middle">User Name</th>
                                                            <!--<th style="text-align: center; vertical-align: middle">Level</th>-->
                                                            <!--<th style="text-align: center; vertical-align: middle">Amount</th>-->
                                                            <th style="text-align: center; vertical-align: middle">Add New</th>
                                                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        <tr>
                                                            <!--<td style="text-align: center"></td>-->
                                                            <td id="policyTd1"><div>
                                                                    <input type="text" name="policyId1" id="policyId1" class="form-control"/>
                                                                    <errors id="policyerror" cssClass="errorDiv"></errors>
                                                                    <!--                                                                <select  name="policyId1" id="policyId1" class="form-control">
                                                                                                                                        <option value="" label="-- Select --"></option>
                                                                                                                                        <options items="${policyId1}"></options>
                                                                                                                                    </select>-->
                                                            </div>
                                                            <span id="policyError1" style="color: red;"></span>
                                                        </td>
<!--                                                        <td style="text-align: center">
                                                            <input type="text"  name="policyNumber1" id="policyNumber1" value="1" readonly="true"class="form-control">
                                                        </td>-->

                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;'>
                                                                <input type="button" value="+" id="policyCloneid" />
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"   title="" value="SUBMIT">
                                            </div>
                                            <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                        <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                    </div>-->
                                        </div>
                                    </div>
                                </div>
                                <!--                                    <div class="form-group">
                                                                        <div class="col-sm-6 col-sm-offset-5">
                                                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                                        </div>
                                                                                                                <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                                                    <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                                                </div>
                                                                    </div>-->
                            </form:form>
                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {

            jQuery("#policyId1").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
                prePopulate: ${preList}
            });
        });

    </script>
    <script>
        var flag3 = true;
        function saveSubmit() {
            //        if (document.getElementById("name").value === "") {
            //
            //            document.getElementById("monthError").innerHTML = "- It must be filled.";
            //            flag3 = false;
            //        }
            //            alert(document.getElementById("month").value);
            if (document.getElementById("policyId1").value === "") {

                document.getElementById("policyerror").innerHTML = "- It must be filled.";
                flag3 = false;
            }
            else {
                return true;
            }
            return false;
        }
    </script>

    <!--<script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    
    </script>-->

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
</html>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>

