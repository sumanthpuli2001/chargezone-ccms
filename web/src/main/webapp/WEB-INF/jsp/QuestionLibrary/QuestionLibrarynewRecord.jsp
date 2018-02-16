<%--
    Document   : EmployeeRegistrationForm
    Created on : Oct 3, 2015, 10:16:00 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Create</title>
        <script>
            var tempCount3 = 1;
            $(function () {
                $("#questionCloneid").on("click", function () {
                    tempCount3++;
                    var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                            + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                            + "<td id=\"policyTd" + tempCount3 + "\"><div><input type=\"text\" name='ans"+ tempCount3 + "' id='ans"+ tempCount3 + "'  class=\"form-control\">"
                            + "</div></td>"
                            + "<td style=\"text-align: center\"><div><input type=\"radio\" name='correctans' id='correctans" + tempCount3 + "' value='r" + tempCount3 + "' class=\"iCheck-helper\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#questionTable").append(clone);
                    document.getElementById('questionCount').value = tempCount3;
                    //                var expenseType = document.getElementById('expenseType').value;
                    addAPolicy(tempCount3);

                });
            });
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
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Registration Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Registration Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" method="post" commandName="questionLibrary" action="questionLibrary.htm?act=submitQuestionLibrarynewRecord">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Category:<span style="color: red;font-size: 12px;"></span></label>
                                                    <form:select path="mprEmployeeCategory" id="mprEmployeeCategory" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${categoryList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>marks<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="marks" id="marks" class="form-control" placeholder="marks"></form:input>
                                                <form:errors path="marks" cssClass="errorDiv"></form:errors>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>question<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:textarea path="question" id="question" class="form-control" placeholder="question"></form:textarea>
                                                <form:errors path="question" cssClass="errorDiv"></form:errors>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>type<span style="color: red;font-size: 12px;">*</span></label>
                                                <%--<form:input path="type" class="form-control" placeholder="type"></form:input>--%>
                                                <form:select path="type" id="type" class="form-control ">
                                                            <option value="">--Select--</option>
                                                            <form:option value='0'>MCQ</form:option>
                                                            <form:option value='1'>Essay</form:option>
                                                        </form:select>
                                                <%--<form:errors path="type" cssClass="errorDiv"></form:errors>--%>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <fieldset>
                                                        <input type="radio" name="status" id="status" value="0" checked>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <input type="radio" name="status" id="status" value="1">InActive
                                                    </fieldset>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                </div>
                                                <div class="col-sm-4">
                                                </div>
                                                <div class="col-sm-2">
                                                <form:button>Submit</form:button>
                                                </div>

                                            </div>
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="questionTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                            <th style="text-align: center; vertical-align: middle">Answer</th>
                                                            <th style="text-align: center; vertical-align: middle">Correct answer</th>
                                                            <th style="text-align: center; vertical-align: middle">Add New</th>
                                                        <input type="hidden" name="questionCount" id="questionCount" value="1"/>
                                                        </tr>
                                                        <tr>
                                                            <td style="text-align: center">1</td>
                                                            <td id="policyTd1"><div>
                                                                    <input type="text" name="ans1" id="ans1"  class="form-control">
                                                                    </td>
                                                                    <td style="text-align: center">
                                                                        <input type="radio" name="correctans" id="correctans1" value="r1" class="iCheck-helper">
                                                                    </td>
                                                                    <td style="text-align: center">
                                                                        <span style='margin-top: 5px;'>
                                                                            <input type="button" value="+" id="questionCloneid"  />
                                                                        </span>
                                                                    </td>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div>

                                            <!--                                            <div class="col-md-12 col-sm-12">
                                                                                            <div class="table-responsive">
                                                                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                                                    <tr>
                                                                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                                                        <th style="text-align: center; vertical-align: middle">Policy Number</th>
                                                                                                        <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td style="text-align: center">1</td>
                                                                                                        <td style="text-align: center">
                                                                                                            <input type="text" name="policyNumber1" id="policyNumber1"  class="form-control">
                                                                                                        </td>
                                                                                                        <td style="text-align: center">
                                                                                                            <input type="number" name="amount1" id="amount1" min="0" class="form-control">
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
                                                                                    </div> 
                                                                                </div>  
                                                                            </div>
                                                                        </div>
                                                                        <div class="tab-pane" id="tab_3"></div>
                                                                    </div>
                                                                </div>
                                                            </section>
                                                        </div>
                                    </form:form>
                                </div>
                                    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                                    </html>
                                    
