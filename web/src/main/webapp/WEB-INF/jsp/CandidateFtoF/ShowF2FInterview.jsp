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
        <style>
            td,tr,th,table{
                text-align: left;
                vertical-align: middle;
                padding: 10px;
            }
            table.table-bordered > tbody > tr > td{
                border:1px solid black;
            }
        </style>
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
            <h1>FACE TO FACE INVITATION VIEW</h1>
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

                                    <!--                                    <div class="box box-info collapsed-box ">
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
                                                                        </div>-->

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
                                                <div class="box-header" style="text-align: right;">
                                                    <button class="btn btn-facebook "  style="width: 100px;" onclick="printDiv('printableArea')">Print &nbsp;<span><i class="fa fa-print"></i></span></button>
                                                </div>
                                                <div id="printableArea">
                                                    <div class="col-sm-12">
                                                        <div class="box-header" style="text-align: right;">
                                                            <span><img src="StorageYard/Images/logo.png"  style="text-align: right;"/></span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <table border="1">
                                                                <tr>
                                                                    <td>
                                                                        <span><img src="StorageYard/candidate/candidateimage/${candidateApplyJob.applayJobUserMaster.id}/${candidateApplyJob.photograph}" style="border: 1px solid black;" width="85px; !important" height="100px; !important"></span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <table border="1" style="border: 1px solid black;width:100%;">
                                                                <tr>
                                                                    <td>
                                                                        <label>Post Applied For:</label> &nbsp;&nbsp;&nbsp;
                                                                        <span>${candidateApplyJob2.postAppliedFor}</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                        </br></br>
                                                    </div>
                                                    <div class="col-sm-12">
                                                        </br></br>
                                                        <label>PERSONAL DATA:</label> </br>
                                                        <table border="1" style="border: 1px solid black;width:100%;">
                                                            <tr>
                                                                <td style="text-align: center;">
                                                                    <label>First Name:</label> &nbsp;&nbsp;
                                                                    <span>${candidateApplyJob.name}</span>
                                                                </td>
                                                                <td style="text-align: center;">
                                                                    <label>Middle Name:</label> &nbsp;&nbsp;
                                                                    <span>${candidateApplyJob.fatherName}</span>
                                                                </td>
                                                                <td style="text-align: center;">
                                                                    <label>Last Name:</label> &nbsp;&nbsp;
                                                                    <span>${candidateApplyJob2.lastName}</span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>

                                                    <div class="col-sm-12">
                                                        </br></br>
                                                        <table border="1" class="table table-bordered" style="width:100%;">
                                                            <tr>
                                                                <td><label>Gender</label></td>
                                                                <c:if test="${candidateApplyJob.sex eq 'false'}"><td colspan="3">Male</td></c:if>
                                                                <c:if test="${candidateApplyJob.sex eq 'true'}"><td colspan="3">Female</td></c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan="5"><label>Telephone Number</label></td>
                                                                </tr>
                                                                <tr>
                                                                    <td><label>Residence</label></td>
                                                                    <td colspan="3">${candidateApplyJob2.residentPhoneNumber}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Mobile</label></td>
                                                                <td colspan="3">${candidateApplyJob.contactNo}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Email</label></td>
                                                                <td colspan="3">${candidateApplyJob.emailId}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="5"><label>Present Address</label></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="5">${candidateApplyJob.presentAddress}</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="5"><label>Permanent Address</label></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="5">${candidateApplyJob.permanentAddress}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Date of Birth</label></td>
                                                                <td colspan="3">${candidateApplyJob.dob}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Religion</label></td>
                                                                <td colspan="3">${candidateApplyJob2.religion}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Height</label></td>
                                                                <td colspan="3">${candidateApplyJob2.height}<span>&nbsp;</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Weight</label></td>
                                                                <td colspan="3">${candidateApplyJob2.weight}<span>&nbsp;</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Marital Status</label></td>
                                                                <td colspan="3">${candidateApplyJob.martialStatus}<span>&nbsp;</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Blood Group</label></td>
                                                                <td colspan="3">${candidateApplyJob.bloodGroup}<span>&nbsp;</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Languages Known</label></td>
                                                                <td><label>English</label></td>
                                                                <td><label>Hindi</label></td>
                                                                <td><label>Gujarati</label></td>
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: right"><label>Read</label></td>
                                                                <c:if test="${candidateApplyJob2.readEnglish eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.readEnglish eq 0 or candidateApplyJob2.readEnglish eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.readHindi eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.readHindi eq 0 or candidateApplyJob2.readHindi eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.readGujarati eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.readGujarati eq 0 or candidateApplyJob2.readGujarati eq null}"><td>N</td></c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: right"><label>Write</label></td>
                                                                <c:if test="${candidateApplyJob2.writeEnglish eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.writeEnglish eq 0 or candidateApplyJob2.writeEnglish eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.writeHindi eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.writeHindi eq 0 or candidateApplyJob2.writeHindi eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.writeGujarati eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.writeGujarati eq 0 or candidateApplyJob2.writeGujarati eq null}"><td>N</td></c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td style="text-align: right"><label>Speak</label></td>
                                                                <c:if test="${candidateApplyJob2.speakEnglish eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.speakEnglish eq 0 or candidateApplyJob2.speakEnglish eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.speakHindi eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.speakHindi eq 0 or candidateApplyJob2.speakHindi eq null}"><td>N</td></c:if>
                                                                <c:if test="${candidateApplyJob2.speakGujarati eq 1}"><td>Y</td></c:if>
                                                                <c:if test="${candidateApplyJob2.speakGujarati eq 0 or candidateApplyJob2.speakGujarati eq null}"><td>N</td></c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td><label>Any Physical Limitation/ Chronic Disease?</label></td>
                                                                    <td colspan="3">${candidateApplyJob2.physicalDamageOrDiseases}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Any criminal case or background?</label></td>
                                                                <td colspan="3">${candidateApplyJob2.criminalCaseBackground}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Insurance Policy Number</label></td>
                                                                <td colspan="3">${candidateApplyJob2.insurancePolicyNumber}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Driving License No</label></td>
                                                                <td colspan="3">${candidateApplyJob2.drivingLicenceNumber}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Any relatives employed in SPCL?</label></td>
                                                                <td colspan="3">${candidateApplyJob2.anyRelativeInSPCL}</td>
                                                            </tr>
                                                            <tr>
                                                                <td><label>Habit of Smoking, Chewing Tobacco, other?</label></td>
                                                                <td colspan="3">
                                                                    <c:if test="${candidateApplyJob2.smokingHabit eq 1}">Smoking&nbsp;</c:if>
                                                                    <c:if test="${candidateApplyJob2.chewingHabit eq 1}">,Chewing&nbsp;</c:if>
                                                                    <c:if test="${candidateApplyJob2.tobaccoHabit eq 1}">,Tobacco&nbsp;</c:if>
                                                                    <c:if test="${candidateApplyJob2.otherHabit eq 1}">,Other</c:if>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>    
                                                        <div class="col-sm-12">
                                                            </br>
                                                            <label>FAMILY BACKGROUND:</label> </br>
                                                            <table border="1"  class="table table-bordered">
                                                                <tr>
                                                                    <td style="text-align: center;">
                                                                        <label>Name</label>
                                                                    </td>
                                                                    <td style="text-align: center;">
                                                                        <label>Relation</label>
                                                                    </td>
                                                                    <td style="text-align: center;">
                                                                        <label>Age</label>
                                                                    </td>
                                                                    <td style="text-align: center;">
                                                                        <label>Qualification</label>
                                                                    </td>
                                                                    <td style="text-align: center;">
                                                                        <label>Designation  & Occupation</label>
                                                                    </td>
                                                                    <td style="text-align: center;">
                                                                        <label>Monthly Income</label>
                                                                    </td>
                                                                </tr>
                                                            <c:forEach items="${candidateFamilyBackground}" var="list">
                                                                <tr>
                                                                    <td style="text-align: center;"> ${list.familyMemberName} </td>
                                                                    <td style="text-align: center;"> ${list.relationWithFamilyMember} </td>
                                                                    <td style="text-align: center;"> ${list.familyMemberAge} </td>
                                                                    <td style="text-align: center;"> ${list.familyMemberQualification} </td>
                                                                    <td style="text-align: center;"> ${list.familyMemberDesignationOccupation} </td>
                                                                    <td style="text-align: center;"> ${list.familyMemberMonthlyIncome} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </div>

                                                    <div class="col-sm-12">
                                                        </br>
                                                        <label>ACADEMIC QUALIFICATION:</label> </br>
                                                        <table border="1"  class="table table-bordered">
                                                            <tr>
                                                                <td colspan="2" style="text-align: center; vertical-align: middle"><label>Year</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Examination</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Board/ College/ Institution</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>No. Of Attempts</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Marks(%)</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Class</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Rank Or Scholarship(if Any)</label></td>

                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center; vertical-align: middle"><label>From Year</label></td>
                                                                <td style="text-align: center; vertical-align: middle"><label>To Year</label></td>
                                                            </tr>
                                                            <tr>
                                                            </tr>
                                                            <c:forEach items="${candidateAcademicQualification}" var="list">
                                                                <tr>
                                                                    <td style="text-align: center;"> ${list.academicYearFrom} </td>
                                                                    <td style="text-align: center;"> ${list.academicYearTo} </td>
                                                                    <td style="text-align: center;"> ${list.academicExamination} </td>
                                                                    <td style="text-align: center;"> ${list.academicBoard} </td>
                                                                    <td style="text-align: center;"> ${list.academicNumberOfAttempts} </td>
                                                                    <td style="text-align: center;"> ${list.academicMarksInPercent} </td>
                                                                    <td style="text-align: center;"> ${list.academicClass} </td>
                                                                    <td style="text-align: center;"> ${list.academicRankOrScholarship} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </div>

                                                    <div class="col-sm-12">
                                                        </br>
                                                        <label>ACADEMIC QUALIFICATION:</label> </br>
                                                        <table border="1"  class="table table-bordered">
                                                            <tr>
                                                                <td colspan="2" style="text-align: center; vertical-align: middle"><label>Year</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Organization</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Department</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Designation</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Job Responsibilities</label></td>
                                                                <td colspan="2" style="text-align: center; vertical-align: middle"><label>Total Remuneration</label></td>
                                                                <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Reason For Leaving</label></td> 
                                                            </tr>
                                                            <tr>
                                                                <td style="text-align: center; vertical-align: middle"><label>From Year</label></td>
                                                                <td style="text-align: center; vertical-align: middle"><label>To Year</label></td>
                                                                <td style="text-align: center; vertical-align: middle"><label>On Joining</label></td>
                                                                <td style="text-align: center; vertical-align: middle"><label>On Leaving</label></td>
                                                            </tr>
                                                            <c:forEach items="${candidateExperienceDetail}" var="list">
                                                                <tr>
                                                                    <td style="text-align: center;"> ${list.experienceYearFrom} </td>
                                                                    <td style="text-align: center;"> ${list.experienceYearTo} </td>
                                                                    <td style="text-align: center;"> ${list.experienceOrganization} </td>
                                                                    <td style="text-align: center;"> ${list.experienceDepartment} </td>
                                                                    <td style="text-align: center;"> ${list.experienceDesignation} </td>
                                                                    <td style="text-align: center;"> ${list.experienceJobResponsibilities} </td>
                                                                    <td style="text-align: center;"> ${list.experienceRemunerationOnJoin} </td>
                                                                    <td style="text-align: center;"> ${list.experienceRemunerationOnLeaving} </td>
                                                                    <td style="text-align: center;"> ${list.experienceReasonForLeaving} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </div>

                                                    <div class="col-sm-12">            
                                                        </br>
                                                        <div class="col-sm-6">
                                                            <label>Present Salary Details:</label> </br>
                                                            <table border="1"  class="table table-bordered">
                                                                <tr>
                                                                    <td style="text-align: center; vertical-align: middle"><label>Present Salary Breakup</label></td>
                                                                    <td style="text-align: center; vertical-align: middle"><label>Salary Slip to be Attached</label></td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">Basic</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupBasic}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">DA/VDA/SD/ALL</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupDaVdaSdAll}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">HRA</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupHRA}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">CONVEYANCE ALL.</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupConveyanceAll}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">LTA</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupLTA}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">MED.</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupMED}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">BONUS</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupBonus}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">OTHER, If any</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupOther}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">TOTAL</td>
                                                                    <td style="vertical-align: middle">${candidateApplyJob2.salaryBreakupTotal}</td>
                                                                </tr>
                                                                <tr>
                                                                    <td style="vertical-align: middle">Salary Slip</td>
                                                                    <td style="vertical-align: middle">
                                                                        <a href="vacancy.htm?act=downloadCandidateSalaryAttachment&cajid=${candidateApplyJob.id}&fileName=${candidateApplyJob2.salarySlipAttachment}">${candidateApplyJob2.salarySlipAttachment}</a>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                        </br>
                                                        <div class="col-sm-6">
                                                            <table border="1"  class="table table-bordered" style="width:100%">
                                                                <tr>
                                                                    <td style="vertical-align: middle;"><label>Salary Expected:</label>&nbsp;&nbsp;<span>${candidateApplyJob2.salaryExpected}</span></td>
                                                                </tr>
                                                            </table>
                                                            <table border="1"  class="table table-bordered">
                                                                <tr>
                                                                    <td style="vertical-align: middle"><label>Joining Time Required:&nbsp;&nbsp;</label><span>${candidateApplyJob2.noticePeriod}</span></td>
                                                                </tr>
                                                            </table>
                                                            <table border="1"  class="table table-bordered">
                                                                <tr>
                                                                    <td style="vertical-align: middle">
                                                                        <c:if test="${candidateApplyJob2.esicStatus eq 1}"><label>ESIC:</label>&nbsp;&nbsp;<span>Yes</span></br></c:if>
                                                                        <c:if test="${candidateApplyJob2.esicStatus eq 0}"><label>ESIC:</label>&nbsp;&nbsp;<span>No</span></br></c:if>
                                                                        <label>ESIC No:</label>&nbsp;&nbsp;<span>${candidateApplyJob2.esicNumber}</span></br>
                                                                        <c:if test="${candidateApplyJob2.pfStatus eq 1}"><label>PF:</label>&nbsp;&nbsp;<span>Yes</span></br></c:if>
                                                                        <c:if test="${candidateApplyJob2.pfStatus eq 0}"><label>PF:</label>&nbsp;&nbsp;<span>No</span></br></c:if>
                                                                        <label>PF No:</label>&nbsp;&nbsp;<span>${candidateApplyJob2.pfNumber}</span>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <table border="1"  class="table table-bordered">
                                                                <tr>
                                                                    <td style="vertical-align: middle">
                                                                        <label>Download Attached Resume:</label>&nbsp;&nbsp;<span><a href="vacancy.htm?act=downloadCandidateCertificate&cajid=${candidateApplyJob.id}&fileName=${candidateApplyJob.certificateAttach}">${candidateApplyJob.certificateAttach}</a></span></br>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </div>
                                                    </div>

                                                    <div class="col-sm-12">
                                                        </br>
                                                        <label>REFERENCES(Other than relatives):</label> </br>
                                                        <table border="1"  class="table table-bordered">
                                                            <tr>
                                                                <td  style="text-align: center; vertical-align: middle"><label>Name</label></td>
                                                                <td  style="text-align: center; vertical-align: middle"><label>Organization</label></td>
                                                                <td  style="text-align: center; vertical-align: middle"><label>Position</label></td>
                                                                <td  style="text-align: center; vertical-align: middle"><label>Contact No.</label></td>
                                                            </tr>
                                                            <c:forEach items="${candidateOtherReferences}" var="list">
                                                                <tr>
                                                                    <td style="text-align: center;"> ${list.referenceNonRelativesName} </td>
                                                                    <td style="text-align: center;"> ${list.referenceNonRelativesOrganization} </td>
                                                                    <td style="text-align: center;"> ${list.referenceNonRelativesPosition} </td>
                                                                    <td style="text-align: center;"> ${list.referenceNonRelativesContactNmber} </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>
                                                    </div>
                                                    <div class="col-sm-12">
                                                        </br>
                                                        <label>Sign. Of candidate :</label> </br>

                                                    </div>
                                                </div>                
                                            </div>

                                        </div>
                                    </div>
                                    <!--                                    <div class="box box-info collapsed-box ">
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
                                    <%--<c:forEach  var="comment" items="${commentlist}" varStatus="loop">--%>
                                        <div class="form-group">
                                    <%--<c:if test="${loop.index eq 0}">--%>
                                        <div class="col-sm-2">
                                            <label>Interviewer Comment:</label> &nbsp;&nbsp;&nbsp;
                                        </div>
                                    <%--</c:if>--%>
                                    <%--<c:if test="${loop.index ne 0}">--%>
                                        <div class="col-sm-2">

                                        </div>
                                    <%--</c:if>--%>
                                    <div class="col-sm-8">
                                        <label>${comment[2]}</label> &nbsp;&nbsp;&nbsp;
                                        <textarea class="form-control"
                                                  id="interviewerRemark" name="interviewerRemark"   disabled>${comment[1]}</textarea>
                                    </div>

                                </div>
                                    <%--</c:forEach>--%>
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label>HR Comment:</label> &nbsp;&nbsp;&nbsp;
                                        </div>
                                        <div class="col-sm-8">

                                    <%--<form:input path="message" id="budget1" readonly="true" class="form-control" placeholder="Comment:"></form:input>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>-->


                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Candidate F2F Observations:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="box-header" style="text-align: right;">
                                                    <button class="btn btn-facebook "  style="width: 100px;" onclick="printDivtwo('printableAreatwo')">Print &nbsp;<span><i class="fa fa-print"></i></span></button>
                                                </div>
                                                <div id="printableAreatwo">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="box-header" style="text-align: right;">
                                                            <span><img src="StorageYard/Images/logo.png"  style="text-align: right;"/></span>
                                                        </div>
                                                        <div class="box-body no-padding">
                                                            <div class="col-sm-6">
                                                                <label>Position:</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.vacancyMaster.name}</span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Date Of Interview  :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.dateOfInterview}</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Name of the candidate:</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.candidateApplyJob.name}</span>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>Venue :</label> &nbsp;&nbsp;&nbsp;
                                                                <span>${candidateF2FRequest.location}</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <table>
                                                                <tr>
                                                                    <td><label>Interview Panel Member:</label></td>
                                                                    <td>
                                                                        <c:forEach  var="test" items="${comitteeList}">

                                                                            &nbsp;&nbsp;&nbsp; &nbsp;<span>${test.employeeMaster.employeeName}</span>
                                                                            <br>
                                                                        </c:forEach>
                                                                    </td>
                                                                </tr>
                                                            </table>

                                                        </div>
                                                        <div class="col-md-12 col-sm-12" div  style="margin-top:20px">
                                                            <div class="col-sm-6">
                                                                <label>Interview Evaluation&nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                            </br>
                                                            <div style="padding:0 5%;">
                                                                <table id="questionTable" border="1" class="table" style="" align="Center" >
                                                                    <tr>
                                                                        <th style="text-align: center; vertical-align: middle">Rating</th>
                                                                        <th style="text-align: center; vertical-align: middle">Excellent</th>
                                                                        <th style="text-align: center; vertical-align: middle">Very Good</th>
                                                                        <th style="text-align: center; vertical-align: middle">Acceptable</th>
                                                                        <th style="text-align: center; vertical-align: middle">Not Suitable</th>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: center">Technical knowledge<span style="color: red;font-size: 20px;">*</span></td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="technicalKnowledge" required="required"  value="1" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="technicalKnowledge" required="required"  value="2" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="technicalKnowledge" required="required"  value="3" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="technicalKnowledge" required="required"  value="4" />
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: center">Experience<span style="color: red;font-size: 20px;">*</span></td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="experience" required="required"  value="1"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="experience" required="required"  value="2"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="experience" required="required"  value="3" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="experience" required="required"  value="4"  />
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: center">Communication Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="commSkill" required="required"  value="1"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="commSkill" required="required"  value="2"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="commSkill" required="required"  value="3" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="commSkill" required="required"  value="4"  />
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: center">Inter-Personal Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="interPerSkill" required="required"  value="1"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="interPerSkill" required="required"  value="2" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="interPerSkill" required="required"  value="3" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="interPerSkill" required="required"  value="4"  />
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: center">Leadership Skills<span style="color: red;font-size: 20px;">*</span></td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="leaderSkill" required="required"  value="1"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="leaderSkill" required="required"  value="2"  />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="leaderSkill" required="required"  value="3" />
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <form:radiobutton path="leaderSkill" required="required"  value="4"  />
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12 col-sm-12"></br></div>            
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="col-sm-6">
                                                                <label>Area for Training Required &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12 col-sm-12" style="padding:0 5%;">
                                                            <div class="col-sm-6">
                                                                <table border="1" class="table table-bordered" style="text-align:center;" align="Center" >
                                                                    <tr>
                                                                        <td><label>Strengths</label></td>
                                                                        <td>${candidateF2FRequest.strengths}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Weaknesses</label></td>
                                                                        <td>${candidateF2FRequest.weaknesses}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Type Of Training</label></td>
                                                                        <td>${candidateF2FRequest.typeOfTraining}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Other Skills</label></td>
                                                                        <td>${candidateF2FRequest.otherSkills}</td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                            <div class="col-md-12 col-sm-12"></br></div>            
                                                            <div class="col-md-12 col-sm-12">
                                                                <div class="col-sm-6">
                                                                    <label>Overall Rating &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6" style="padding:0 5%;">
                                                                <table id="questionTable" border="1" class="table" style="" align="Center"  >
                                                                    <tr>
                                                                        <td style="text-align: center"> <label>Excellent:</label>
                                                                            <form:radiobutton path="excellent" required="required" readonly="true" value="1" />
                                                                        </td>
                                                                        <td style="text-align: center"><label>Very Good:</label>
                                                                            <form:radiobutton path="excellent" required="required" readonly="true" value="2" />
                                                                        </td>
                                                                        <td style="text-align: center"><label>Acceptable:</label>
                                                                            <form:radiobutton path="excellent" required="required" readonly="true" value="3" />
                                                                        </td>
                                                                        <td style="text-align: center"><label>Not Suitable:</label>
                                                                            <form:radiobutton path="excellent" required="required" readonly="true" value="4" />
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">

                                                            <c:forEach  var="comment" items="${commentlist}" varStatus="loop">
                                                                <div class="form-group">
                                                                    <c:if test="${loop.index eq 0}">
                                                                        <div class="col-sm-2">
                                                                            <label>Interviewer:</label>
                                                                        </div>
                                                                    </c:if>
                                                                    <c:if test="${loop.index ne 0}">
                                                                        <div class="col-sm-2">

                                                                        </div>
                                                                    </c:if>
                                                                    <div class="col-sm-8">
                                                                        <label>${comment[2]}</label>
                                                                    </div>

                                                                </div>
                                                            </c:forEach>
                                                            <div class="form-group">
                                                                <div class="col-sm-2">
                                                                    <label>Comment:</label> &nbsp;&nbsp;&nbsp;
                                                                </div>
                                                                <div class="col-sm-8">
                                                                    <div>${candidateF2FRequest.message}</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-12">
                                                                </br>
                                                                <label>Sign. Of candidate :</label> </br>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">History:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <label><h4></h4></label>
                                                        <table border="1" style="width: 100%;" align="center">
                                                                <c:choose>
                                                                    <c:when test="${empty list1}">
                                                                        <tr>
                                                                            <td align="center">
                                                                                <c:out value="There is no record found."></c:out>
                                                                                </td>
                                                                            </tr>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <thead>
                                                                        <th colspan="4" style="text-align:center">Vacancy History Detail </th>
                                                                        <tr>
                                                                            <th style="width: 50px;">Vacancy Name</th>
                                                                            <th style="width: 50px;">Date</th>
                                                                            <th style="width: 50px;">Comment's</th>
                                                                            <th style="width: 50px;">Status</th>
                                                                        </tr>
                                                                        </thead>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                <tbody>
                                                                    <c:forEach var="list" items="${list1}">
                                                                        <tr>
                                                                            <td>${vacancyName}</td>
                                                                            <td>${list[4]}</td>
                                                                            <td>${list[3]}</td>
                                                                            <td>${list[5]} By&nbsp${list[1]}</td>
                                                                        </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        <table border="1" style="width: 100%;" align="center">
                                                        <c:choose>
                                                            <c:when test="${empty HistoryList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                <th colspan="4" style="text-align:center">History Detail </th>
                                                                <tr>
                                                                    <th style="width: 50px;">Name</th>
                                                                    <th style="width: 50px;">Date</th>
                                                                    <th style="width: 50px;">Comment</th>
                                                                    <th style="width: 50px;">Status</th>
                                                                </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${HistoryList}">
                                                                <tr>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[6]}</td>
                                                                    <td>${list[3]}</td>
                                                                    <td>${list[5]} By&nbsp${list[1]}</td>
                                                                </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- /.col -->
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
<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }
</script>
<script type="text/javascript">
    function printDivtwo(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }
</script>
</html>
<style>
    table,tr,td,th{
        border: 1px black solid;
    }
</style>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
