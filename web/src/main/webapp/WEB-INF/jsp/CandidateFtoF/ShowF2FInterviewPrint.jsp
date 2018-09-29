<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <!--<div class="box box-info collapsed-box ">-->
    <body onload="window.print();">
        <div class="box-header">
            <h3 class="box-title">Candidate Detail:</h3>

        </div>
        <div class="box-body" >
            <div class="row">
                <div class="box-header" style="text-align: right;">
                    <!--<button class="btn btn-facebook "  style="width: 100px;" onclick="printDiv('printableArea')">Print &nbsp;<span><i class="fa fa-print"></i></span></button>-->
                    <!--<button class="btn btn-facebook "  style="width: 100px;" onclick="OnprintApplicationForm();">Print &nbsp;<span><i class="fa fa-print"></i></span></button>-->
                </div>
                <div id="printableArea">
                    <div class="col-sm-12">
                        <div class="box-header" style="text-align: right;">
                            <span><img src="StorageYard/Images/logo.png"  style="text-align: right;"/></span>
                        </div>
                        <table width="90%">
                            <tr>
                                <td width="50%">


                                    <!--<div class="col-sm-6">-->
                                    <table border="1">
                                        <tr>
                                            <td>
                                                <span><img src="StorageYard/candidate/candidateimage/${candidateApplyJob.applayJobUserMaster.id}/${candidateApplyJob.photograph}" style="border: 1px solid black;" width="85px; !important" height="100px; !important"></span>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                                <td>

                                    <!--</div>-->

                                    <table border="1" style="border: 1px solid black;width:100%;">
                                        <tr>
                                            <td>
                                                <label>Post Applied For:</label> &nbsp;&nbsp;&nbsp;
                                                <!--<span>${candidateApplyJob2.postAppliedFor}</span>-->
                                                <span>${jobVanacyName}</span>
                                            </td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                        </table>
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
                                <td><label>Present Address</label></td>
                                <td colspan="3">${candidateApplyJob.presentAddress}</td>
                            </tr>
                            <tr>
                                <td><label>Permanent Address</label></td>
                                <td colspan="3">${candidateApplyJob.permanentAddress}</td>
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
                        <label>EXPERIENCE INFORMATION(Starting With Present Job):</label> </br>
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
                            <c:forEach var="list" items="${candidateExperienceDetail}">
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

                    <!--<div class="col-sm-12">-->            
                    </br>

                    </br>
                    <center>
                        <table width="80%">
                            <tr>
                                <td width="50%">
                                    <label>Present Salary Details:</label> </br>
                                    <table border="1" style=""  class="table table-bordered">
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
                                                ${candidateApplyJob2.salarySlipAttachment}
                                            </td>
                                        </tr>
                                    </table>

                                </td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>

                                <td style="vertical-align: top">
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
                                                <label> Attached Resume:</label>&nbsp;&nbsp;<span>${candidateApplyJob.certificateAttach}</span></br>
                                            </td>
                                        </tr>
                                    </table>
                                    <!--                        </div>
                                                        </div>-->

                                </td>
                            </tr>
                        </table>
                    </center>
                    </br>
                    <!--                    <div class="col-sm-6">
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
                    <%--<c:if test="${candidateApplyJob2.esicStatus eq 1}"><label>ESIC:</label>&nbsp;&nbsp;<span>Yes</span></br></c:if>--%>
                    <%--<c:if test="${candidateApplyJob2.esicStatus eq 0}"><label>ESIC:</label>&nbsp;&nbsp;<span>No</span></br></c:if>--%>
                    <label>ESIC No:</label>&nbsp;&nbsp;<span>${candidateApplyJob2.esicNumber}</span></br>
                    <%--<c:if test="${candidateApplyJob2.pfStatus eq 1}"><label>PF:</label>&nbsp;&nbsp;<span>Yes</span></br></c:if>--%>
                    <%--<c:if test="${candidateApplyJob2.pfStatus eq 0}"><label>PF:</label>&nbsp;&nbsp;<span>No</span></br></c:if>--%>
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
            </div>-->
                    <!--</div>-->

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
        <!--</div>-->
    </body>
</html>
