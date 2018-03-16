<%-- 
   Document   : CreateApproval
   Created on : 17 Feb, 2018, 4:39:07 PM
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
                        + "</div><span id=\"policyError" + tempCount3 + "\" style=\"color: red;\"></span></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" name='policyNumber" + tempCount3 + "' id='policyNumber" + tempCount3 + "' value=" + tempCount3 + " readonly=\"true\" class=\"form-control\"></td>"
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
            <h1>Create Approval:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Approval</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'approval.htm?act=approvalList'">List</button>
                                <span style="color: red;font-size: 12px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="approvalMaster" action="approval.htm?act=submitApproval" onsubmit="return saveSubmit()" >
                                    <form:hidden path="id"></form:hidden>
                                        <div class="col-sm-4"><span style="color: red;font-size: 12px;"></span>
                                            <label>Approval Name:<span style="color: red;font-size: 12px;"></span></label>
                                            <input name="name" id ="name" class="form-control" required></input>
                                            <span  id="monthError" cssClass="errorDiv"></span>
                                        </div>


                                        <!--                                    <div class="form-group">
                                                                                <div class="col-sm-3">
                                                                                    <label class="control-label"> * Add User :<span style="color: red;font-size: 12px;">*</span> </label>
                                                                                </div>-->

                                        <div class="form-group">
                                            <div class="col-md-8 col-sm-8">
                                                <div class="table-responsive">
                                                    <table id="policyTable" class="table table-bordered table-striped table-hover" style="margin-top: 10px" align="Center"  >
                                                        <tr>
                                                            <!--<th style="text-align: center; vertical-align: middle;width: 5%"></th>-->
                                                            <th style="text-align: center; vertical-align: middle">User Name</th>
                                                            <th style="text-align: center; vertical-align: middle">Level</th>
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
                                                        <td style="text-align: center">
                                                            <input type="text"  name="policyNumber1" id="policyNumber1" value="1" readonly="true"class="form-control">
                                                        </td>

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
        </section>
    </div>
</div>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
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

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
