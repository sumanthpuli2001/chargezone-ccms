<%-- 
    Document   : ShowF2FInterview
    Created on : 23 Mar, 2018, 11:10:48 AM
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
                                           commandName="candidateF2FRequest" action="candidateF2FApproval.htm?act=approvalFaceToFaceInvitation" onsubmit="return saveSubmit()" >
                                    <input type="hidden" id="applicationId" name="applicationId" value="${applicationId}">   

                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Man Power Requisition Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun4()"><i class="fa fa-plus" id="minusId1"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>MPR Name:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${vacancyName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>MPR Budget:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${Mprbudget}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Job Type:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${jobtypeNAme1}</span>    
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                            <span >${designationName1}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Location:</label>  &nbsp;&nbsp;&nbsp;
                                                            <span >${locationName1}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${departmentName1}</span>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${numberOfPositionMpr}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Work Experience(In Years):</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${MprExperience}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${Mprdescription}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Vacancy Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Vacancy Name:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${vacancyName}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Vacancy Created Date:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${fromDate}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Vacancy End Date:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${toDate}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Location:</label> &nbsp;&nbsp;&nbsp;
                                                            <span> ${locationName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${position}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Job Type:</label>  &nbsp;&nbsp;&nbsp;
                                                            <span >${jobtypeNAme}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${departmentName}</span>    
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                            <span >${designationName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Work Experience(In Years):</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${experiance}</span>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${description}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${position}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Candidate Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Candidate Name:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.name}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Contact No:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.contactNo}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father Name:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.fatherName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Father Date Of Birth</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.fatherDob}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Mother Name:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.motherName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Mother Date Of Birth:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.motherDob}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Gender:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.sex}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Martial Status:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.martialStatus}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Candidate Date Of Birth:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.dob}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Blood Group:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.bloodGroup}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Present Address:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.presentAddress}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Permanent Address:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.permanentAddress}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>City:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.city}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Email Address:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.emailId}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact Person:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.emergencyContactPerson}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact No:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.emergencyContactNo}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Experience Date Joining Year:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.experianceDateJoiningYear}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Experience Date Joining Month:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${candidateF2FRequest.candidateApplyJob.experianceDateJoiningMonth}</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Candidate Face To Face Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="box-body no-padding">
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Date Of Interview  :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.dateOfInterview}</span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Venue :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.location}</span>
                                                            </div>
                                                        </div>
                                                        <c:forEach  var="comment" items="${commentlist}" varStatus="loop">
                                                            <div class="form-group">
                                                                <c:if test="${loop.index eq 0}">
                                                                    <div class="col-sm-2">
                                                                        <label>Interviewer Comment:</label> &nbsp;&nbsp;&nbsp;
                                                                    </div>
                                                                </c:if>
                                                                <c:if test="${loop.index ne 0}">
                                                                    <div class="col-sm-2">

                                                                    </div>
                                                                </c:if>
                                                                <div class="col-sm-8">
                                                                    <label>${comment[2]}</label> &nbsp;&nbsp;&nbsp;
                                                                    <textarea class="form-control"
                                                                              id="interviewerRemark" name="interviewerRemark"   disabled>${comment[1]}</textarea>
                                                                </div>

                                                            </div>
                                                        </c:forEach>
                                                        <div class="form-group">

                                                            <div class="col-sm-2">
                                                                <label>HR Comment:</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                            <div class="col-sm-8">

                                                                <textarea class="form-control"
                                                                          id="message" name="message" disabled></textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div><!-- /.tab-pane -->
            </div><!-- /.tab-content -->
    </div><!-- nav-tabs-custom -->
</div><!-- /.col -->
</div>
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
<script>
    function buttonFun1() {
        var className = $('#minusId1').attr('class');
        if (className == 'fa fa-plus') {
            document.getElementById('spanId1').innerHTML = 'Minimize';
        } else {
            document.getElementById('spanId1').innerHTML = 'Expand';
        }
    }
    function buttonFun2() {
        var className = $('#minusId2').attr('class');
        if (className == 'fa fa-plus') {
            document.getElementById('spanId2').innerHTML = 'Minimize';
        } else {
            document.getElementById('spanId2').innerHTML = 'Expand';
        }
    }
    function buttonFun3() {
        var className = $('#minusId3').attr('class');
        if (className == 'fa fa-plus') {
            document.getElementById('spanId3').innerHTML = 'Minimize';
        } else {
            document.getElementById('spanId3').innerHTML = 'Expand';
        }
    }
    function buttonFun4() {
        var className = $('#minusId4').attr('class');
        if (className == 'fa fa-plus') {
            document.getElementById('spanId4').innerHTML = 'Minimize';
        } else {
            document.getElementById('spanId4').innerHTML = 'Expand';
        }
    }
</script>

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
</html>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
