<%-- 
    Document   : viewHrApprove
    Created on : 20 Aug, 2018, 3:51:59 PM
    Author     : Dell-1
--%>

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
    <script>
        function OnprintApplicationForm() {

            var applicationID = document.getElementById("applicationId").value;

            var applicationApplyID = document.getElementById("applicationApllyID").value;

            window.location = 'candidateF2FApproval.htm?act=printShowCandidateView&id=' + applicationID + '&applicationApplyID=' + applicationApplyID;

        }
    </script>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>FACE TO FACE INVITATION APPROVAL</h1>
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
                                           commandName="candidateF2FObservation" action="candidateF2FApproval.htm?act=SubmitFtoFByHr" onsubmit="return saveSubmit()" >
                                    <input type="hidden" id="applicationId" name="applicationId" value="${applicationId}">   
                                    <input type="hidden" id="applicationApllyID" name="applicationApllyID" value="${applicationApplyID}">   

                                    <!--                                    <div class="box box-info collapsed-box ">
                                                                            <div class="box-header">
                                                                                <h3 class="box-title">Man Power Planing Detail:</h3>
                                                                                <div class="box-tools pull-right">
                                                                                    <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun4()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                                                </div>
                                                                            </div>
                                                                            <div class="box-body">
                                                                                <div class="row">
                                                                                    <div class="col-md-12 col-sm-12">
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Man Power Planing Budget:</label> &nbsp;&nbsp;&nbsp;
                                                                                                <span> ${Mppbudget}</span>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Job Type:</label> &nbsp;&nbsp;&nbsp;
                                                                                                <span>${jobtypeNAme2}</span>    
                                                                                            </div>
                                                                                            <div class="col-sm-6">
                                                                                                <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                                                                <span >${designationName1}</span>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Location:</label>  &nbsp;&nbsp;&nbsp;
                                                                                                <span >${locationName2}</span>
                                                                                            </div>
                                                                                            <div class="col-sm-6">
                                                                                                <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                                                                <span>${departmentName2}</span>   
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                                                                <span> ${numberOfPositionMpp}</span>
                                                                                            </div>
                                                                                            <div class="col-sm-6">
                                                                                                <label>Work Experience(In Years): </label> &nbsp;&nbsp;&nbsp;
                                                                                                <span>${MppExperience}</span>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>-->

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
                                                                                                <label>Work Experience(In Years): </label> &nbsp;&nbsp;&nbsp;
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
                                                            <label>Vacancy Name&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span> ${vacancyName}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Vacancy Created Date&nbsp;&nbsp;:</label>
                                                            <span> ${fromDate}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Vacancy End Date:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span>${toDate}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Location&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span> ${locationName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Number Of Position:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span>${position}</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Job Type&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span >${jobtypeNAme}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Department:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span>${departmentName}</span>    
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Job Role&nbsp;&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                            <span >${designationName}</span>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Work Experience(In Years)&nbsp;:</label>
                                                            <span>${experiance}</span>   
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                                            <span>${description}</span>
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
                                                        <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="box-header" style="text-align: right;">
                                                            <label class="btn btn-facebook "  style="width: 100px;" onclick="OnprintApplicationForm();">Print &nbsp;<span><i class="fa fa-print"></i></span></label>
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

                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <table border="1" style="border: 1px solid black;width:100%;">
                                                                        <tr>
                                                                            <td>
                                                                                <label>Post Applied For:</label> &nbsp;&nbsp;&nbsp;
                                                                                <!--<span>${candidateApplyJob2.postAppliedFor}</span>-->
                                                                                <span>${vancyName}</span>
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
                                                                            <span>${candidateApplyJob.middleName}</span>
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
                                                                        <!--                                                                        <tr>
                                                                                                                                                    <td><label>Residence</label></td>
                                                                                                                                                    <td colspan="3">${candidateApplyJob2.residentPhoneNumber}</td>
                                                                                                                                            </tr>-->
                                                                    <tr>
                                                                        <td><label>Mobile</label></td>
                                                                        <td colspan="3">${candidateApplyJob.contactNo}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Email</label></td>
                                                                        <td colspan="3">${candidateApplyJob.emailId}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Present Address</label></td>
                                                                        <td colspan="3">${candidateApplyJob.presentAddress}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Permanent Address</label></td>
                                                                        <td colspan="3">${candidateApplyJob.permanentAddress}</td>
                                                                    </tr>
                                                                    <!--                                                                    <tr>
                                                                                                                                            <td><label>Date of Birth</label></td>
                                                                                                                                            <td colspan="3">${candidateApplyJob.dob}</td>
                                                                                                                                        </tr>-->
                                                                    <!--                                                                    <tr>
                                                                                                                                            <td><label>Religion</label></td>
                                                                                                                                            <td colspan="3">${candidateApplyJob2.religion}</td>
                                                                                                                                        </tr>-->
                                                                    <!--                                                                    <tr>
                                                                                                                                            <td><label>Height</label></td>
                                                                                                                                            <td colspan="3">${candidateApplyJob2.height}<span>&nbsp;</span></td>
                                                                                                                                        </tr>-->
                                                                    <!--                                                                    <tr>
                                                                                                                                            <td><label>Weight</label></td>
                                                                                                                                            <td colspan="3">${candidateApplyJob2.weight}<span>&nbsp;</span></td>
                                                                                                                                        </tr>-->
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
                                                                            <td><label>Current CTC:</label></td>
                                                                            <td colspan="3">${candidateApplyJob2.anyRelativeInSPCL}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Current CTC(On Hand):</label></td>
                                                                        <td colspan="3">${candidateApplyJob2.physicalDamageOrDiseases}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Expected CTC:</label></td>
                                                                        <td colspan="3">${candidateApplyJob2.criminalCaseBackground}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Expected CTC(On Hand):</label></td>
                                                                        <td colspan="3">${candidateApplyJob2.insurancePolicyNumber}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>No. Of Years Of Commitment You Can Give:</label></td>
                                                                        <td colspan="3">${candidateApplyJob2.drivingLicenceNumber}</td>
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
                                                                        <tr>
                                                                            <td><label>Reference Source :</label></td>
                                                                            <td colspan="3">
                                                                            <c:if test="${candidateApplyJob2.friend eq 1}">Friend&nbsp;</c:if>
                                                                            <c:if test="${candidateApplyJob2.naukri eq 1}">,Naukri&nbsp;</c:if>
                                                                            <c:if test="${candidateApplyJob2.indeed eq 1}">,Indeed&nbsp;</c:if>
                                                                            <c:if test="${candidateApplyJob2.other eq 1}">,Other</c:if>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>

                                                                            <td><label>Please Rate Yourself Out Of ?10? For Following Skills:</label></td>
                                                                            <td colspan="3"></td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td><label>Accounting:</label></td>
                                                                            <td colspan="3"> ${candidateApplyJob2.salaryBreakupOther}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Loyalty:</label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.salaryBreakupTotal}</td>
                                                                    </tr>

                                                                    <tr>

                                                                        <td><label>3 Qualities Which Make You Different / Outstanding Than Other:</label></td>
                                                                        <td colspan="3"></td>

                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Professional:</label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.salaryBreakupBasic}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Personal:</label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.salaryBreakupDaVdaSdAll}</td>
                                                                    </tr>
                                                                    <tr>

                                                                        <td><label>Goals:</label></td>
                                                                        <td colspan="3"></td>

                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Long term:  5 years </label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.salaryBreakupHRA}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Short term:  2 years</label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.salaryBreakupConveyanceAll}</td>
                                                                    </tr>
                                                                    <tr>

                                                                        <td><label>Goals:</label></td>
                                                                        <td colspan="3"></td>

                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>Can You Join Immediate: </label></td>

                                                                        <td colspan="3"> 
                                                                            <c:if test="${candidateApplyJob2.esicStatus eq 1}">Y</c:if>
                                                                            <c:if test="${candidateApplyJob2.esicStatus eq 0}">N</c:if>
                                                                            </td>

                                                                        </tr>
                                                                        <tr>
                                                                            <td><label>Possibility Of Having Less Notice Period:</label></td>
                                                                            <td colspan="3"> ${candidateApplyJob2.esicNumber}</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><label>% Increment Expected After 1 Year:</label></td>
                                                                        <td colspan="3"> ${candidateApplyJob2.pfNumber}</td>
                                                                    </tr>
                                                                </table>
                                                            </div>  


                                                            <div class="col-sm-12">
                                                                </br>
                                                                <label>Please Rate Yourself Out Of ?10? For Following Skills(Excel):</label> </br>
                                                                <table border="1" class="table table-bordered">
                                                                    <tr>
                                                                        <td style="text-align: center;">
                                                                            <label>Basic</label>
                                                                        </td>
                                                                        <td style="text-align: center;">
                                                                            <label>V Look Up</label>
                                                                        </td>
                                                                        <td style="text-align: center;">
                                                                            <label>Pivot Table</label>
                                                                        </td>
                                                                        <td style="text-align: center;">
                                                                            <label>Punctual</label>
                                                                        </td>
                                                                        <td style="text-align: center;">
                                                                            <label>Team work</label>
                                                                        </td>
                                                                        <td style="text-align: center;">
                                                                            <label>Positive</label>
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
                                                                <table border="1" class="table table-bordered">
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
                                                                <label>Please Rate Yourself Out Of ?10? For Following Skills(English):</label> </br>
                                                                <table border="1" class="table table-bordered">
                                                                    <tr>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Speaking</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Writing</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Reading</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Leadership</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Responsible</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Confident</label></td>
                                                                        <td rowspan="2" style="text-align: center; vertical-align: middle"><label>Honest</label></td>
                                                                        <!--<td rowspan="2" style="text-align: center; vertical-align: middle"><label>Reason For Leaving</label></td>--> 
                                                                    </tr>
                                                                    <tr>
                                                                        <!--                                                                        <td style="text-align: center; vertical-align: middle"><label>From Year</label></td>
                                                                                                                                                <td style="text-align: center; vertical-align: middle"><label>To Year</label></td>
                                                                                                                                                <td style="text-align: center; vertical-align: middle"><label>On Joining</label></td>
                                                                                                                                                <td style="text-align: center; vertical-align: middle"><label>On Leaving</label></td>-->
                                                                    </tr>
                                                                    <c:forEach var="list" items="${candidateExperienceDetail}">
                                                                        <tr>
                                                                            <td style="text-align: center;"> ${list.experienceYearFrom} </td>
                                                                            <!--<td style="text-align: center;"> ${list.experienceYearTo} </td>-->
                                                                            <td style="text-align: center;"> ${list.experienceOrganization} </td>
                                                                            <td style="text-align: center;"> ${list.experienceDepartment} </td>
                                                                            <td style="text-align: center;"> ${list.experienceDesignation} </td>
                                                                            <td style="text-align: center;"> ${list.experienceJobResponsibilities} </td>
                                                                            <td style="text-align: center;"> ${list.experienceRemunerationOnJoin} </td>
                                                                            <!--<td style="text-align: center;"> ${list.experienceRemunerationOnLeaving} </td>-->
                                                                            <td style="text-align: center;"> ${list.experienceReasonForLeaving} </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </table>
                                                            </div>

                                                            <div class="col-sm-12">            

                                                            </div>

                                                            <div class="col-sm-12">
                                                                </br>
                                                                <label>Other:</label> </br>
                                                                <table border="1" class="table table-bordered">
                                                                    <tr>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Strength</label></td>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Weakness</label></td>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Previous Job (Positive)</label></td>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Previous Job (Negative)</label></td>
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
                                                                <label>Growth:</label> </br>
                                                                <table border="1" class="table table-bordered">
                                                                    <tr>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Salary when Started</label></td>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>Salary when leaving</label></td>
                                                                        <td  style="text-align: center; vertical-align: middle"><label>No of years</label></td>
                                                                        <!--<td  style="text-align: center; vertical-align: middle"><label>Contact No.</label></td>-->
                                                                    </tr>
                                                                    <%--<c:forEach items="${candidateOtherReferences}" var="list">--%>
                                                                    <tr>
                                                                        <td style="text-align: center;"> ${candidateApplyJob2.salaryExpected} </td>
                                                                        <td style="text-align: center;"> ${candidateApplyJob2.noticePeriod} </td>
                                                                        <td style="text-align: center;"> ${candidateApplyJob.experianceDateJoiningYear} </td>
                                                                        <!--<td style="text-align: center;"> ${candidateApplyJob.experianceDateJoiningMonth} </td>-->
                                                                    </tr>
                                                                    <%--</c:forEach>--%>
                                                                </table>
                                                            </div>
                                                            <div class="col-sm-12">
                                                                <table border="1" class="table table-bordered">
                                                                    <tr>
                                                                        <td style="vertical-align: middle">
                                                                            <label>Download Attached Resume:</label>&nbsp;&nbsp;<span><a href="vacancy.htm?act=downloadCandidateCertificate&cajid=${candidateApplyJob.id}&fileName=${candidateApplyJob.certificateAttach}">${candidateApplyJob.certificateAttach}</a></span></br>
                                                                        </td>
                                                                    </tr>
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
                                            <label>Interviewer Comment:</label> &nbsp;&nbsp;&nbsp;
                                        </div>
                                        <div class="col-sm-8">

                                            <textarea class="form-control"
                                                      id="InterviewerAsHr" name="InterviewerAsHr"  onkeypress="myFunction()" ></textarea>
                                        </div>
                                        <span id="InterviewerAsHrError" style="color: red;"></span>
                                    </div>
                                    <div class="form-group">

                                        <div class="col-sm-2">
                                            <label>HR Comment:</label> &nbsp;&nbsp;&nbsp;
                                        </div>
                                        <div class="col-sm-8">

                                            <textarea class="form-control"
                                                      id="message" name="message" onkeypress="myFunction()"></textarea>
                                        </div>
                                        <span id="messageError" style="color: red;"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->

                                    <c:forEach var="list" items="${f2flist}">
                                        <div class="box box-info collapsed-box ">
                                            <div class="box-header">
                                                <h3 class="box-title">Candidate F2F Observations :  <b>${list.hrName}</b></h3>
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
                                                            <table style=" width: 90%; height: 0px !important;" border="1" class="table table-bordered" style="" cellspacing="0" cellpadding="0"  align="Center">
                                                                <tr>
                                                                    <td ><!--style="border:0px"-->
                                                                        <b>Date Of Interview&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                        &nbsp;&nbsp;${candidateF2FRequest.dateOfInterview} </td> 
                                                                    <td ><!--style="border:0px"-->
                                                                        <b>Name of the candidate&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                        &nbsp;&nbsp;${candidateF2FRequest.candidateApplyJob.name} </td> 

                                                                </tr>
                                                                <tr>
                                                                    <td ><!--style="border:0px"-->
                                                                        <b>Venue&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                        &nbsp;&nbsp;${candidateF2FRequest.location} </td> 
                                                                    <td ><!--style="border:0px"-->
                                                                        <b>Position&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                        &nbsp;&nbsp;${candidateF2FRequest.vacancyMaster.name} </td> 

                                                                </tr>
                                                                <tr >
                                                                    <td><label>Interview Panel Member:</label></td>
                                                                    <td>
                                                                        <c:forEach  var="test" items="${comitteeList}">

                                                                            &nbsp;&nbsp;&nbsp; &nbsp;<span>${test.employeeMaster.employeeName}</span>
                                                                            <br>
                                                                        </c:forEach>
                                                                    </td>
                                                                </tr>
                                                                <!--                                                            <div class="box-body no-padding">
                                                                                                                                <div class="col-sm-6">
                                                                                                                                    <label>Date Of Interview</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                    <span>${candidateF2FRequest.dateOfInterview}</span>
                                                                                                                                </div>
                                                                                                                                <div class="col-sm-6">
                                                                                                                                    <label>Venue </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                    <span>${candidateF2FRequest.location}</span>
                                                                                                                                </div>                 
                                                                                                                            </div>-->
                                                                <!--                                                            <div class="box-body no-padding">
                                                                                                                                <div class="col-sm-6">
                                                                                                                                    <label>Name of the candidate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b></label>
                                                                                                                                    <span>${candidateF2FRequest.candidateApplyJob.name}</span>
                                                                                                                                </div>
                                                                
                                                                                                                                <div class="col-sm-6">
                                                                                                                                    <label>Position</label>&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                    <span>${candidateF2FRequest.vacancyMaster.name}</span>
                                                                                                                                </div>
                                                                                                                            </div>-->
                                                            </table>
                                                            <br>

                                                            <!--                                                        <div class="form-group">
                                                                                                                        <table>
                                                                                                                            <tr >
                                                                                                                                <td><label>Interview Panel Member:</label></td>
                                                                                                                                <td>
                                                            <%--<c:forEach  var="test" items="${comitteeList}">--%>
    
                                                                &nbsp;&nbsp;&nbsp; &nbsp;<span>${test.employeeMaster.employeeName}</span>
                                                                <br>
                                                            <%--</c:forEach>--%>
                                                        </td>
                                                    </tr>
                                                </table>
    
                                            </div>-->
                                                            <div  >
                                                                <!--                                                            <div>
                                                                                                                                <label>Interview Evaluation&nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                                                                                            </div>-->
                                                                <input type="hidden" id="technicalKnowledge" name="technicalKnowledge" value="${candidateF2FRequest.technicalKnowledge}">
                                                                <input type="hidden" id="experience" name="experience" value="${candidateF2FRequest.experience}">
                                                                <input type="hidden" id="commSkill" name="commSkill" value="${candidateF2FRequest.commSkill}">
                                                                <input type="hidden" id="interPerSkill" name="interPerSkill" value="${candidateF2FRequest.interPerSkill}">
                                                                <input type="hidden" id="leaderSkill" name="leaderSkill" value="${candidateF2FRequest.leaderSkill}">
                                                                <input type="hidden" id="strengths" name="strengths" value="${candidateF2FRequest.strengths}">
                                                                <input type="hidden" id="excellent" name="excellent" value="${candidateF2FRequest.excellent}">
                                                                <input type="hidden" id="weaknesses" name="weaknesses" value="${candidateF2FRequest.weaknesses}">
                                                                <input type="hidden" id="typeOfTraining" name="typeOfTraining" value="${candidateF2FRequest.typeOfTraining}">
                                                                <input type="hidden" id="otherSkills" name="otherSkills" value="${candidateF2FRequest.otherSkills}">
                                                                <!--<input type="hidden" id="otherSkills" name="otherSkills" value="${candidateF2FRequest.otherSkills}">-->
                                                                <div >
                                                                    <table style=" width: 90%; height: 0px !important;" border="1" class="table table-bordered" cellspacing="0" cellpadding="0"  style="" align="Center">
                                                                        <tr>
                                                                            <td>
                                                                                <label>Interview Evaluation&nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                                            </td>
                                                                            <td>

                                                                            </td>
                                                                            <td>

                                                                            </td>
                                                                            <td>

                                                                            </td>
                                                                            <td>

                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left; vertical-align: middle">Rating</td>
                                                                            <td style="text-align: left; vertical-align: middle">Excellent</td>
                                                                            <td style="text-align: left; vertical-align: middle">Very Good</td>
                                                                            <td style="text-align: left; vertical-align: middle">Acceptable</td>
                                                                            <td style="text-align: left; vertical-align: middle">Not Suitable</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">Technical knowledge</td>
                                                                            <td style="text-align: left">
                                                                                <c:if test="${list.technicalKnowledge == 1}">Excellent</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.technicalKnowledge == 2}">Very Good</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.technicalKnowledge == 3}">Acceptable</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.technicalKnowledge == 4}">Not Suitable</c:if>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="text-align: left">Experience</td>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.experience == 1}">Excellent</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.experience == 2}">Very Good</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.experience == 3}">Acceptable</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.experience == 4}">Not Suitable</c:if>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="text-align: left">Communication Skills</td>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.commSkill == 1}">Excellent</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.commSkill == 2}">Very Good</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.commSkill == 3}">Acceptable</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.commSkill == 4}">Not Suitable</c:if>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="text-align: left">Inter-Personal Skills</td>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.interPerSkill == 1}">Excellent</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.interPerSkill == 2}">Very Good</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.interPerSkill == 3}">Acceptable</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.interPerSkill == 4}">Not Suitable</c:if>
                                                                            </tr>
                                                                            <tr>
                                                                                <td style="text-align: left">Leadership Skills</td>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.leaderSkill == 1}">Excellent</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.leaderSkill == 2}">Very Good</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.leaderSkill == 3}">Acceptable</c:if>
                                                                                <td style="text-align: left">
                                                                                <c:if test="${list.leaderSkill == 4}">Not Suitable</c:if>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </div>
                                                                <!--                                                            <div class="col-md-12 col-sm-12"></br></div>            -->
                                                                <!--                                                            <div >
                                                                                                                                <div >
                                                                                                                                    <label>Area for Training Required &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                                                                                                </div>
                                                                                                                            </div>-->
                                                                <br>

                                                                <div >
                                                                    <div >
                                                                        <table style=" width: 90%; height: 0px !important;" border="1" class="table table-bordered" cellspacing="0" cellpadding="0"  style="" align="Center">
                                                                            <tr>
                                                                                <td>
                                                                                    <label>Area for Training Required &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp; 
                                                                                </td>
                                                                                <td>

                                                                                </td>

                                                                            </tr>
                                                                            <tr>
                                                                                <td><label>Strengths</label></td>
                                                                                <td>${list.strengths}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td><label>Weaknesses</label></td>
                                                                            <td>${list.weaknesses}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td><label>Type Of Training</label></td>
                                                                            <td>${list.typeOfTraining}</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td><label>Other Skills</label></td>
                                                                            <td>${list.otherSkills}</td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                            <br>
                                                            <br>

                                                            <!--<div class="col-md-12 col-sm-12"></br></div>--> 
                                                            <table style=" width: 90%; height: 0px !important;" border="1" class="table table-bordered"  cellspacing="0" cellpadding="0" style="" align="Center">
                                                                <tr>
                                                                    <td> <label>Overall Rating  </label>&nbsp;&nbsp;-</td> 
                                                                    <td ><span> <c:if test="${list.excellent == 1}">Excellent</c:if>
                                                                            <c:if test="${list.excellent == 2}">Very Good</c:if>
                                                                            <c:if test="${list.excellent == 3}">Acceptable</c:if>
                                                                            <c:if test="${list.excellent == 4}">Not Suitable</c:if></span></td>
                                                                    </tr>
                                                                    <tr>
                                                                    <%--<c:forEach  var="comment" items="${commentlist}" varStatus="loop">--%>

                                                                        <%--<c:if test="${loop.index eq 0}">--%>
                                                                            <td>
                                                                                <label>Interviewer:</label>
                                                                            </td>
                                                                        <%--</c:if>--%>
                                                                        <%--<c:if test="${loop.index ne 0}">--%>
<!--                                                                            <td>

                                                                            </td>-->
                                                                        <%--</c:if>--%>
                                                                        <td>
                                                                            <label>${list.hrName}</label>
                                                                        </td>

                                                                        <!--</div>-->
                                                                    <%--</c:forEach>--%>
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        <label>Comment: </label> &nbsp;&nbsp;&nbsp;
                                                                    </td>
                                                                    <!--<div class="col-sm-8">-->
                                                                    <td>${list.comment}</td>
                                                                    <!--</div>-->
                                                                    <!--</div>-->
                                                                </tr>
                                                                <tr>
                                                                    <td>
                                                                        Sign. Of candidate : 
                                                                    </td>
                                                                    <td></td>
                                                                </tr>
                                                                <!--                                                                <div class="col-sm-12">
                                                                                                                            </br>
                                                                                                                            <label>Sign. Of candidate :</label> </br>
                                                                
                                                                                                                        </div>-->
                                                            </table>
                                                            <!--<div class="col-sm-6">-->
                                                            <!--<label>Overall Rating &nbsp;&nbsp;-:-</label>--> 
                                                            <!--<span>--> 
                                                            <%--<c:if test="${candidateF2FRequest.excellent == 1}">Excellent</c:if>--%>
                                                            <%--<c:if test="${candidateF2FRequest.excellent == 2}">Very Good</c:if>--%>
                                                            <%--<c:if test="${candidateF2FRequest.excellent == 3}">Acceptable</c:if>--%>


                                                            <!--</div>-->


                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </c:forEach> 
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Candidate F2F Observations :</h3>
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
                                                           <table style=" width: 90%; height: 0px !important;" border="1" class="table table-bordered" style="" cellspacing="0" cellpadding="0"  align="Center">
                                                            <tr>
                                                                <td ><!--style="border:0px"-->
                                                                    <b>Date Of Interview&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                    &nbsp;&nbsp;${candidateF2FRequest.dateOfInterview} </td> 
                                                                <td ><!--style="border:0px"-->
                                                                    <b>Name of the candidate&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                    &nbsp;&nbsp;${candidateF2FRequest.candidateApplyJob.name} </td> 

                                                            </tr>
                                                            <tr>
                                                                <td ><!--style="border:0px"-->
                                                                    <b>Venue&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                    &nbsp;&nbsp;${candidateF2FRequest.location} </td> 
                                                                <td ><!--style="border:0px"-->
                                                                    <b>Position&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                    &nbsp;&nbsp;${candidateF2FRequest.vacancyMaster.name} </td> 

                                                            </tr>
                                                            <tr >
                                                                <td><label>Interview Panel Member:</label></td>
                                                                <td>
                                                                    <c:forEach  var="test" items="${comitteeList}">

                                                                        &nbsp;&nbsp;&nbsp; &nbsp;<span>${test.employeeMaster.employeeName}</span>
                                                                        <br>
                                                                    </c:forEach>
                                                                </td>
                                                            </tr>
                                                            <!--                                                            <div class="box-body no-padding">
                                                                                                                            <div class="col-sm-6">
                                                                                                                                <label>Date Of Interview</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                <span>${candidateF2FRequest.dateOfInterview}</span>
                                                                                                                            </div>
                                                                                                                            <div class="col-sm-6">
                                                                                                                                <label>Venue </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                <span>${candidateF2FRequest.location}</span>
                                                                                                                            </div>                 
                                                                                                                        </div>-->
                                                            <!--                                                            <div class="box-body no-padding">
                                                                                                                            <div class="col-sm-6">
                                                                                                                                <label>Name of the candidate&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b></label>
                                                                                                                                <span>${candidateF2FRequest.candidateApplyJob.name}</span>
                                                                                                                            </div>
                                                            
                                                                                                                            <div class="col-sm-6">
                                                                                                                                <label>Position</label>&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>
                                                                                                                                <span>${candidateF2FRequest.vacancyMaster.name}</span>
                                                                                                                            </div>
                                                                                                                        </div>-->
                                                        </table>
                                                     
                                                   
                                                       
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Interview Evaluation &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <div class="col-md-12 col-sm-12">
                                                               <%--<form:input path="technicalKnowledge" id="technicalKnowledge" class="form-control" type="hidden"></form:input>--%>
                                                               <%--<form:input path="technicalKnowledge" id="technicalKnowledge" class="form-control" type="hidden"></form:input>--%>
                                                            <!--<div class="table-responsive">-->
                                                            <table id="questionTable" class="table" style="" align="Center"  >
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
                                                        </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <div class="form-group">

                                                            <div class="col-sm-6">
                                                                <label>Area for Training Required &nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Strengths :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:textarea path="strengths" id="strengths" class="form-control" placeholder="Employee Strengths" onchange="trainerOnchangeFunction('strengthsError');"></form:textarea>
                                                                <form:errors path="strengths" cssClass="errorDiv"></form:errors>
                                                                    <span style="font-size: 14px; color: #dd4b39;" id="strengthsError"></span>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Weaknesses :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:textarea path="weaknesses" id="weaknesses" class="form-control" placeholder="Employee Weaknesses" onchange="trainerOnchangeFunction('weaknessesError');"></form:textarea>
                                                                <form:errors path="weaknesses" cssClass="errorDiv"></form:errors>
                                                                    <span style="font-size: 14px; color: #dd4b39;" id="weaknessesError"></span>
                                                                </div>
                                                            </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <div class="form-group">
                                                                <div class="col-sm-8">
                                                                    <label>Type Of Training :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="typeOfTraining" id="typeOfTraining" class="form-control" placeholder="typeOfTraining" onchange="trainerOnchangeFunction('typeOfTrainingError');"></form:input>
                                                                <form:errors path="typeOfTraining" cssClass="errorDiv"></form:errors>
                                                                    <span style="font-size: 14px; color: #dd4b39;" id="typeOfTrainingError"></span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-8">
                                                                    <label>Technical Areas :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="technicalareas" id="technicalareas" class="form-control" placeholder="technicalareas" onchange="trainerOnchangeFunction('technicalareasError');"></form:input>
                                                                <form:errors path="technicalareas" cssClass="errorDiv"></form:errors>
                                                                    <span style="font-size: 14px; color: #dd4b39;" id="technicalareasError"></span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-sm-8">
                                                                    <label>Other Areas(Soft Skills/behavioral) :<span style="color: red;font-size: 15px;">*</span></label>
                                                                <form:input path="otherSkills" id="otherSkills" class="form-control" placeholder="otherSkills" onchange="trainerOnchangeFunction('otherSkillsError');"></form:input>
                                                                <form:errors path="otherSkills" cssClass="errorDiv"></form:errors>
                                                                    <span style="font-size: 14px; color: #dd4b39;" id="otherSkillsError"></span>

                                                                </div>
                                                            </div>
                                                            <div class="form-group">

                                                                <div class="col-sm-6">
                                                                    <label>Overall Rating <span style="color: red;font-size: 15px;">*</span>&nbsp;&nbsp;-:-</label> &nbsp;&nbsp;&nbsp;
                                                                </div>
                                                            </div>
                                                            <table id="questionTable" class="table" style="" align="Center"  >
                                                                <tr>
                                                                    <td style="text-align: center"> <label>Excellent:</label>
                                                                    <form:radiobutton path="excellent" required="required"  value="1" />
                                                                </td>
                                                                <td style="text-align: center"><label>Very Good:</label>
                                                                    <form:radiobutton path="excellent" required="required"  value="2" />
                                                                </td>
                                                                <td style="text-align: center"><label>Acceptable:</label>
                                                                    <form:radiobutton path="excellent" required="required"  value="3" />
                                                                </td>
                                                                <td style="text-align: center"><label>Not Suitable:</label>
                                                                    <form:radiobutton path="excellent" required="required"  value="4" />
                                                                </td>
                                                            </tr>
                                                        </table>

                                                        
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>






                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">History:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
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

                                    <div class="form-group">
                                        <div class="form-group">

                                            <div class="col-sm-2">
                                                <label> &nbsp;&nbsp;&nbsp;Comment:</label>
                                            </div>
                                            <div class="col-sm-8">

                                                <textarea class="form-control"
                                                          id="message" name="message" onkeypress="myFunction()"></textarea>
                                            </div>
                                            <span id="messageError" style="color: red;"></span>
                                        </div>
                                        <div class="col-sm-4" style="text-align: left">
                                            <%--<c:if test="${recruitmentMaster.mppStatus == 1 || recruitmentMaster.mppStatus == 2 || recruitmentMaster.mppStatus == 0}">--%>
                                            <input type="submit" class="btn btn-danger" id="btnType2" name="btnType"  value="REJECT" style="width: 100px"></input>
                                            <%--</c:if>--%>
                                        </div>
                                        <div class="col-sm-4" style="text-align: center">
                                            <%--<c:if test="${recruitmentMaster.mppStatus == 0 || recruitmentMaster.mppStatus == 3 || recruitmentMaster.mppStatus == 1}">--%>
                                            <input type="submit" class="btn btn-warning" id="btnType2" name="btnType"  value="ON HOLD"  style="width: 100px"></input>
                                            <%--</c:if>--%>
                                        </div>
                                        <div class="col-sm-4" style="text-align: right">
                                            <%--<c:if test="${recruitmentMaster.mppStatus == 0 || recruitmentMaster.mppStatus == 2 || recruitmentMaster.mppStatus == 3}">--%>
                                            <input type="submit" class="btn btn-success"  id="btnType1" name="btnType" value="APPROVE" style="width: 100px" ></input>
                                            <%--</c:if>--%>
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
            if (document.getElementById("InterviewerAsHr").value === "") {

                document.getElementById("InterviewerAsHrError").innerHTML = " It must be filled.";
                flag3 = false;
            } else if (document.getElementById("message").value === "") {

                document.getElementById("messageError").innerHTML = " It must be filled.";
                flag3 = false;
            }
            //            alert(document.getElementById("month").value);
            //            if (document.getElementById("policyId1").value === "") {
            //
            //                document.getElementById("policyerror").innerHTML = "- It must be filled.";
            //                flag3 = false;
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
    <script type="text/javascript">
        function printDivtwo(divName) {
            var printContents = document.getElementById(divName).innerHTML;
            var originalContents = document.body.innerHTML;
            document.body.innerHTML = printContents;
            window.print();
            document.body.innerHTML = originalContents;
        }
    </script>

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

</html>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
<script>
    function myFunction() {

        document.getElementById("InterviewerAsHrError").innerHTML = " ";
        document.getElementById("messageError").innerHTML = " ";
    }

</script>
