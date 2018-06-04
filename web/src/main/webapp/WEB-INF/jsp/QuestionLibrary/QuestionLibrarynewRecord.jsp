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
        <title>Question Library</title>
        <script>
            var tempCount3 = 1;
            $(function () {
                $("#questionCloneid").on("click", function () {
                    tempCount3++;
                    var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                            + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                            + "<td id=\"policyTd" + tempCount3 + "\"><div><input type=\"text\" name='ans" + tempCount3 + "' id='ans" + tempCount3 + "'  class=\"form-control\">"
                            + "</div></td>"
//                            + "<td style=\"text-align: center\"><div><input type=\"radio\" name='correctans' id='correctans" + tempCount3 + "' value='r" + tempCount3 + "' class=\"iCheck-helper\"></td>"
                            + "<td style=\"text-align: center\"><div><input type=\"radio\" name='correctans' id='correctans" + tempCount3 + "' value='r1' class=\"iCheck-helper\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                    $("#questionTable").append(clone);
                    document.getElementById('questionCount').value = tempCount3;
//                    document.getElementById('1').className += "iradio_square-blue";
//                    document.getElementById('1').style.cssText ="position: absolute; top: -10%; left: -10%; display: block; width: 120%; height: 120%; margin: 0px; padding: 0px; background: rgb(255, 255, 255) none repeat scroll 0% 0%; border: 0px none; opacity: 0";
                    //                var expenseType = document.getElementById('expenseType').value;
                    addAPolicy(tempCount3);

                });
            });

            var maxID = 0;
            function getTemplateRow() {
                var x = document.getElementById("templateRow").cloneNode(true);
                x.id = "";
                x.style.display = "";
                x.innerHTML = x.innerHTML.replace(/{id}/, ++maxID);
                return x;
            }
            function addRow() {
                var t = document.getElementById("questionTable");
                var rows = t.getElementsByTagName("tr");
                var r = rows[rows.length - 1];
                r.parentNode.insertBefore(getTemplateRow(), r);

            }
            function removePolicy(policyDiv) {
                alert(policyDiv);
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
        <script>
            function selectMCQ(val) {
                if (val == '0') {
                    $('#questionTable').show();
                    $('#mcqshow').show();


                } else {
                    $('#questionTable').hide();
                    $('#mcqshow').hide();

                }
            }
            function removeIt1(ii, jj, k1) {

                var element1 = document.getElementById(ii);
                var element2 = document.getElementById(jj);
                var element3 = document.getElementById(k1);
                element1.parentNode.removeChild(element1);
                element2.parentNode.removeChild(element2);
                element3.parentNode.removeChild(element3);
            }
        </script>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>QUESTION LIBRARY </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Question Create Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" name="form" method="post" commandName="questionLibrary" onsubmit="return checkValidation()" action="questionLibrary.htm?act=submitQuestionLibrarynewRecord">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <label>   <span style="color: red;font-size: 16px;">*</span><span style="color: red;font-size: 12px;"> Indicate Mandatory filed</span></label>
                                    </div>
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                    <label>Category<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:select path="mprEmployeeCategory.id" id="mprEmployeeCategory" class="form-control" required="true">
                                                    <form:option value="" label="-- Select --" />
                                                    <form:options items="${categoryList}"></form:options>
                                                </form:select>
                                                <form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>
                                                    <span id="mprEmployeeCategoryCo" style="color: red;"></span>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Marks<span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="marks" id="marks" class="form-control" placeholder="Marks"></form:input>
                                                <form:errors path="marks" cssClass="errorDiv"></form:errors>
                                                    <span id="marksCo" style="color: red;"></span>

                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Type<span style="color: red;font-size: 12px;">*</span></label>
                                                <%--<form:input path="type" class="form-control" placeholder="type"></form:input>--%>
                                                <form:select path="type" id="type" class="form-control" onchange="selectMCQ(this.value);">
                                                    <option value="">--Select--</option>
                                                    <form:option value='0'>MCQ</form:option>
                                                    <form:option value='1'>Essay</form:option>
                                                </form:select>
                                                <span id="idCo" style="color: red;"></span>
                                                <%--<form:errors path="type" cssClass="errorDiv"></form:errors>--%>
                                            </div>
                                        </div>
                                        &nbsp;
                                        <div>

                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10">
                                                <label class="control-label">Question :<span style="color: red;font-size: 12px;">*</span></label>
                                                <label>&nbsp;</label>  
                                                <form:textarea  path="question" id="editor"></form:textarea>
                                                <form:errors path="question" cssClass="errorDiv"/>
                                                <span id="editorCo" style="color: red;"></span>

                                                <!--                                                    <div id="editor">
                                                                                                        <h1>Hello world!</h1>
                                                                                                        <p>I'm an instance of <a href="http://ckeditor.com">CKEditor</a>.</p>
                                                                                                    </div>-->

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Status<span style="color: red;font-size: 12px;">*</span></label>
                                                <fieldset>
                                                    <!--                                                    <input type="radio" name="status" id="status" value="0" checked>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                        <input type="radio" name="status" id="status" value="1">Inactive-->
                                                    <form:radiobutton path="satatus" id="status" name="status"  value="0" required="true"/>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <form:radiobutton path="satatus" id="status" name="status" value="1" required="true"/>Inactive
                                                </fieldset>
                                                <form:errors path="satatus" cssClass="errorDiv"/>
                                                <span id="satatusCo" style="color: red;"></span>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                            </div>
                                            <div class="col-sm-4">
                                            </div>
                                            <!--                                            <div class="col-sm-2">
                                            <%--<form:button>Submit</form:button>--%>
                                            </div>-->

                                        </div>
                                            
                                        <div id="mcqshow" class="form-group">
                                            <div class="col-sm-6">
                                                <label>MCQ Options</label>
                                            </div>

                                        </div>
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="questionTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <tr>
                                                        <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                        <th style="text-align: center; vertical-align: middle">Answer <span style="color: red;font-size: 12px;">*</span></th>
                                                        <th style="text-align: center; vertical-align: middle">Correct Answer <span style="color: red;font-size: 12px;">*</span></th>
                                                        <!--<th style="text-align: center; vertical-align: middle">Add New</th>-->
                                                    <input type="hidden" name="questionCount" id="questionCount" value="1"/>
                                                    </tr>
                                                    <c:if test="${questionAns==null}">
                                                        <tr id="templateRow">

                                                            <td style="text-align: center">1</td>


                                                            <td id="policyTd1">
                                                                <input type="text" name="ans1" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>

                                                            <td style="text-align: center">
                                                                <!--<input type="radio" name="correctans"  value="1" >-->
                                                                <form:radiobutton path="ansId"  name="correctans"  value="1" />
                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                            <form:errors path="ansId" cssClass="errorDiv"/>

                                                            <!--                                                        <td style="text-align: center">
                                                                                                                        <span style='margin-top: 5px;'>
                                                                                                                            <input type="button" value="+"  onclick="addRow();"  />
                                                                                                                            <input type="button" value="-"   onclick="removePolicy('templateRow');"/>
                                                                                                                        </span>
                                                                                                                    </td>-->

                                                        </tr>
                                                        <tr id="templateRow">

                                                            <td style="text-align: center">2</td>


                                                            <td id="policyTd1">
                                                                <input type="text" name="ans2" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>

                                                            <td style="text-align: center">
                                                                <!--<input type="radio" name="correctans"  value="2" >-->
                                                                <form:radiobutton path="ansId"  name="correctans"  value="2" />

                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                        </tr>
                                                        <tr id="templateRow">
                                                            <td style="text-align: center">3</td>
                                                            <td id="policyTd1">
                                                                <input type="text" name="ans3" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>
                                                            <td style="text-align: center">
                                                                <!--<input type="radio" name="correctans"  value="3" >-->
                                                                <form:radiobutton path="ansId"  name="correctans"  value="3"/>
                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                        </tr>
                                                        <tr id="templateRow">
                                                            <td style="text-align: center">4</td>
                                                            <td>
                                                                <input type="text" name="ans4" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>
                                                            <td style="text-align: center">
                                                                <form:radiobutton path="ansId"  name="correctans"  value="4" />
                                                                <!--<input type="radio" name="correctans"  value="4" >-->
                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                        </tr>
                                                        <tr id="templateRow">
                                                            <td style="text-align: center">5</td>
                                                            <td id="policyTd1">
                                                                <input type="text" name="ans5" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>

                                                            <td style="text-align: center">
                                                                <!--<input type="radio" name="correctans"  value="5" >-->
                                                                <form:radiobutton path="ansId"  name="correctans"  value="5" />
                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                        </tr>
                                                        <tr id="templateRow">
                                                            <td style="text-align: center">6</td>
                                                            <td id="policyTd1">
                                                                <input type="text" name="ans6" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>
                                                            <td style="text-align: center">
                                                                <!--<input type="radio" name="correctans"  value="6" >-->
                                                                <form:radiobutton path="ansId" id="ansId"  name="correctans"  value="6"/>
                                                                <!--                                                            <input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>
                                                        </tr>
                                                    </c:if>
                                                    <c:forEach var="questionAns" items="${questionAns}" varStatus="status">
                                                        <tr id="templateRow">

                                                            <%--<c:if test="${status.count eq 1}">--%>
                                                            <td style="text-align: center">${status.count}</td>
                                                            <%--</c:if>--%>
                                                            <%--<c:if test="${status.count eq 1}">--%>
                                                            <td id="policyTd1">
                                                                <input type="text" name="ans${status.count}" id="ans1" value="${questionAns.ans}" class="form-control" >
                                                            </td>
                                                            <%--</c:if>--%>
                                                            <%--<c:if test="${status.count eq 1}">--%>
                                                            <td style="text-align: center">

<!--<input type="radio" name="correctans"  value="${status.count}" >-->
                                                                <form:radiobutton path="ansId"  name="correctans" checked="${questionAns.id == questionLibrary.ansId ? 'checked' : '' }" value="${status.count}"/>
                                                                <!--<input type="checkbox" name="correctans"  value="r1" class="iCheck-helper">-->
                                                            </td>

                                                            <%--</c:if>--%>
                                                            <%--<c:if test="${status.count eq 1}">--%>
                                                            <%--</c:if>--%>
                                                        </tr>
                                                        <%--<c:if test="${status.count eq 3}">--%>
<!--                                                            <tr id="ans3${status.count}" id="templateRow" >

                                                                <td style="text-align: center" >4</td>

                                                                <td id="policyTd1">
                                                                    <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                </td>

                                                                <td style="text-align: center">
                                                                    <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center" >5</td>

                                                                <td id="policyTd1">
                                                                    <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                </td>

                                                                <td style="text-align: center">
                                                                    <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center" >6</td>

                                                                <td id="policyTd1">
                                                                    <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                </td>

                                                                <td style="text-align: center">
                                                                    <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                </td>

                                                            </tr>-->
                                                        <%--</c:if>--%>
                                                        <%--<c:if test="${status.count eq 4}">--%>
                                                        <!--                                                            <tr>
                                                                                                                        <td style="text-align: center" >5</td>
                                                        
                                                                                                                        <td id="policyTd1">
                                                                                                                            <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                                                                        </td>
                                                        
                                                                                                                        <td style="text-align: center">
                                                                                                                            <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                                                                        </td>
                                                                                                                    </tr>
                                                                                                                    <tr>
                                                                                                                        <td style="text-align: center" >6</td>
                                                        
                                                                                                                        <td id="policyTd1">
                                                                                                                            <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                                                                        </td>
                                                        
                                                                                                                        <td style="text-align: center">
                                                                                                                            <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                                                                        </td>
                                                        
                                                                                                                    </tr>-->
                                                        <%--</c:if>--%>
                                                        <%--<c:if test="${status.count eq 5}">--%>

                                                        <!--                                                            <tr>
                                                                                                                        <td style="text-align: center" >6</td>
                                                        
                                                                                                                        <td id="policyTd1">
                                                                                                                            <input type="text" name="ans1"  value="${questionAns.ans}" class="form-control">
                                                                                                                        </td>
                                                        
                                                                                                                        <td style="text-align: center">
                                                                                                                            <input type="radio" name="correctans" value="r1"  class="iCheck-helper" checked="true">
                                                                                                                        </td>
                                                        
                                                                                                                    </tr>-->
                                                        <%--</c:if>--%>
                                                        <%--<c:if test="${status.count ne 1}">--%>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                        </div>
                                        <%--</c:if>--%>
                                        <div class="form-group">
                                            <div class=" col-sm-6 col-sm-offset-5">
                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form:form>
    </div>




    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">

</html>
<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<script>
            initSample();
</script>
<script>
    function checkValidation() {

        var type = document.getElementById("type").value;
        if ('' == type) {
            document.getElementById("idCo").innerHTML = 'Please Select Type';

        }
        var marks = document.getElementById("marks").value;
        if ('' == marks) {
            document.getElementById("marksCo").innerHTML = 'Please Enter Marks';

        }
        var mprEmployeeCategory = document.getElementById("mprEmployeeCategory").value;
        if ('' == mprEmployeeCategory) {
            document.getElementById("mprEmployeeCategoryCo").innerHTML = 'Please Select Category';

        }
//        var editor = document.getElementById("editor").value;
//        if ('' == editor) {
//            document.getElementById("editorCo").innerHTML = 'Please Enter Question';
//
//        }
//        var satatus = document.getElementById("satatus").value;
//        if ('' == satatus) {
//            document.getElementById("satatusCo").innerHTML = 'Select Question tatus';
//
//        }
//
//        var ans1 = document.getElementById("ans1").value;
//        if ('' == ans1) {
//            document.getElementById("ans1Co").innerHTML = 'Enter Marks';
//
//        }
//        var ansId = document.getElementById("ansId").value;
//        if ('' == ansId) {
//            document.getElementById("ansIdCo").innerHTML = 'Enter Marks';
//
//        }
        if ('' == type && '' == marks && '' == mprEmployeeCategory) {
            return false;
        }else{
        return true;
    }
    }
</script>
