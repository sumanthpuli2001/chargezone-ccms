<%-- 
    Document   : CandidateApproval
    Created on : 26 Feb, 2018, 9:41:01 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Candidate Approval Assessment</title>
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Candidate Approval Assessment</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approval Assessment</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
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
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <!--<div class="form-group">-->


                                        <form:form class="form-horizontal" method="post" commandName="candidateApplyJob" action="recruitment.htm?act=assessmentClick">
                                            <input type="hidden" id="empreqid" name="empreqid" value="${mprMaster.id}">

                                            <div class="box box-info collapsed-box ">
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
                                            </div>
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
                                                        <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onClick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
                                                    </div>
                                                </div>
                                                <div class="box-body">
                                                    <div class="row">
                                                        <div class="box-header" style="text-align: right;">
                                                            <button class="btn btn-facebook "  style="width: 100px;" onclick="printDiv('printableArea')">Print &nbsp;<span><i class="fa fa-print"></i></span></button>
                                                        </div>
                                                        <div id="printableArea">
                                                        <div class="col-sm-12">
                                                            <div class="col-sm-6">
                                                                <table style="width:100%;">
                                                                    <tr>
                                                                        <td>
                                                                            <span><img src="StorageYard/candidate/candidateimage/${candidateApplyJob.applayJobUserMaster.id}/${candidateApplyJob.photograph}" style="border: 1px solid black;" width="85px; !important" height="100px; !important"></span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <table style="border: 1px solid black;width:100%;">
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
                                                            <table style="border: 1px solid black;width:100%;">
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
                                                            <table class="table table-bordered" style="width:100%;">
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
                                                            <table class="table table-bordered">
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
                                                            <table class="table table-bordered">
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
                                                            <table class="table table-bordered">
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
                                                                <table class="table table-bordered">
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
                                                                <table class="table table-bordered" style="width:100%">
                                                                    <tr>
                                                                        <td style="vertical-align: middle;"><label>Salary Expected:</label>&nbsp;&nbsp;<span>${candidateApplyJob2.salaryExpected}</span></td>
                                                                    </tr>
                                                                </table>
                                                                <table class="table table-bordered">
                                                                    <tr>
                                                                        <td style="vertical-align: middle"><label>Joining Time Required:&nbsp;&nbsp;</label><span>${candidateApplyJob2.noticePeriod}</span></td>
                                                                    </tr>
                                                                </table>
                                                                <table class="table table-bordered">
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
                                                                <table class="table table-bordered">
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
                                                            <table class="table table-bordered">
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
                                                                    <c:when test="${empty list}">
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
                                                                    <c:forEach var="list" items="${list}">
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
                                                <div class="col-md-12" style="text-align: right">
                                                    <c:if test="${candidateJobApplication.status eq 1 || candidateJobApplication.status eq 14}">
                                                        <button type="button" class="btn btn-danger" onclick="return reject(${candidateJobApplication.id},${candidateApplyJob.id});" value="Reject">Reject</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 11}">
                                                        <button type="button" class="btn btn-primary" onclick="offerLate(${candidateJobApplication.id},${candidateApplyJob.id});">Offer Later</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 1}">
                                                        <button type="button" class="btn btn-primary" onclick="shortlisted(${candidateJobApplication.id},${candidateApplyJob.id});">Shortlist</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 11 || candidateJobApplication.status eq 14}">
                                                        <button type="button" class="btn btn-primary" onclick="induction(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; Induction</button>
                                                    </c:if>
                                                    <c:if
                                                        test="${candidateJobApplication.status eq 2}">
                                                        <button type="button" class="btn btn-default" onclick="sendToF2F(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; F To F Interview</button>
                                                    </c:if>    
                                                    <c:if
                                                        test="${candidateJobApplication.status eq 6}">
                                                        <button type="button" class="btn btn-default" onclick="sendToF2F(${candidateJobApplication.id},${candidateApplyJob.id});">&nbsp; F To F Interview</button>
                                                    </c:if>    
                                                    <c:if test="${candidateJobApplication.status eq 2}">
                                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModalOnline">Online Assessment</button>
                                                    </c:if>
                                                    <c:if test="${candidateJobApplication.status eq 4}">
                                                        <button type="button" class="btn btn-default" id="btnType1" onclick="goToAns(${candidateJobApplication.id},${candidateApplyJob.id})" name="btnType" value="AssessMent"  >Check Assessment</button>
                                                    </c:if>
                                                </div>


                                            </div>
                                        </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <div class="container">
        <div class="modal fade" id="myModalOnline" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Online Assessment</h4>
                    </div>
                    <form:form class="form-horizontal" method="post" commandName="onlineAssessment" action="onlineAssessment.htm?act=submitAssessment"
                               onsubmit='return checkBoxCheck();'>
                        <section class="content">
                            <!--<div class="col-md-12">-->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                        <input type="hidden" value="${candidateJobApplication.id}" name="candidateJobApplicationId"/>
                                                        <label>Question Paper Name :<span style="color: red;font-size: 12px;"></span></label>

                                                        <select name="questions" class="form-control" id="questions" onchange="getTotalMarksAndNoOfQue(this);" required="true">
                                                            <option value="">--Select--</option>
                                                            <c:forEach items="${questions}" var="questions">
                                                                <option value="${questions.key}">${questions.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Passing Percentage : <span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="passingPercentage" id="passingPercentage" class="form-control" placeholder="Enter Passing Percentage" 
                                                                    required="true" onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="passingPercentage" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-4">
                                                            <label>Duration (In Minutes):<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="duration" id="duration" class="form-control" placeholder="Enter Duration" required="true"
                                                                    onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="duration" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity From :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select From Date" name="validityFrom" readonly="true" required="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Validity To :<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" id="datetimepicker1" class="form-control" name="validityTo" placeholder="Please select To Date" readonly="true" required="true"/>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Number Of Attempts :<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="noOfAttampt" id="noOfAttampt" class="form-control" placeholder="Enter Number Of Attempt" required="true"
                                                                    onkeypress="return isNumberKey(event)"></form:input>
                                                        <form:errors path="noOfAttampt" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                        <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                        <label>Number of Questions :<span style="color: red;font-size: 12px;" ></span></label>
                                                        <label id="test" name="test"></label>
                                                        <input type="hidden" id="NoOfQue" name="NoOfQue" >
                                                    </div>
                                                    <div class="col-sm-4">

                                                        <label>Total Marks :<span style="color: red;font-size: 12px;"></span></label>
                                                        <label id="test2" name="test2"></label>
                                                        <input type="hidden" id="totalMarks" name="totalMarks" >

                                                    </div>


                                                </div>

                                            </div>



                                            <!--<div class="row">-->
                                            <div class="form-group">
                                                <div class=" col-sm-5 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                                </div>
                                            </div>
                                            <div style="float: right;">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</div>-->
                            <!--</div>-->

                        </section>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <!-- FACE TO FACE FORE MODAL -->
    <div class="container">
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Face To Face</h4>
                    </div>
                    <div class="modal-body">
                        <p>Face To Face Assessment</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
        $('#datetimepicker1').datepicker({
        });
    });
</script>
<script>
    $(document).ready(function () {
        $('#datetimepicker2').datepicker({
        });
    });
</script>
<script>

    function getTotalMarksAndNoOfQue(id) {

        try {

            $.ajax({
                type: "POST",
                url: "onlineAssessment.htm?act=getTotalMarksAndNoOfQue&id=" + id.value,
                data: {},
                dataType: "json",
                success: function (responseTxt) {
                    //                    document.getElementById("name").value = JSON.stringify(responseTxt.check);
                    //                    document.getElementById("email").value = JSON.stringify(responseTxt.val2);
                    //                    document.getElementById("name").value = responseTxt
                    var v1 = JSON.stringify(responseTxt.check);
                    var v2 = JSON.stringify(responseTxt.val2);
                    //                    $('#test2').html(responseTxt.check).modal('show');
                    //                    $('#test').html(responseTxt.val2).modal('show');
                    document.getElementById("test2").innerHTML = responseTxt.check;
                    document.getElementById("test").innerHTML = responseTxt.val2;

                    document.getElementById("NoOfQue").value = responseTxt.val2;
                    document.getElementById("totalMarks").value = responseTxt.check;
                    //                    $('#NoOfQue').val(v1);
                    //                    $('#totalMarks').val(v2);
                    //                    alert(JSON.stringify(responseTxt.check));

                    //                    document.getElementById("").innerHTML = responseTxt;
                    if (responseTxt != '') {
                        document.getElementById("").value = "";


                    }
                },
                error: function () {

                }
            });



        } catch (e) {

        }


    }

</script>
<script>
    function goToAns(applicationId, candidateId) {
        window.location = 'onlineAssessment.htm?act=goToAns&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function sendToF2F(applicationId, candidateId) {
        window.location = 'candidateF2FRequest.htm?act=createCandidateF2FInvitation&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function induction(applicationId, candidateId) {
        window.location = 'employeeMaster.htm?act=inductionCreateClick&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function shortlisted(applicationId, candidateId) {
        window.location = 'candidateF2FRequest.htm?act=CandidateShortlisted&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function offerLate(applicationId, candidateId) {
        window.location = 'candidateF2FRequest.htm?act=offerLater&id=' + applicationId + '&candidateId=' + candidateId;
    }
</script>
<script>
    function reject(applicationId, candidateId) {
        var checkreject = confirm("If You Reject You Can Not Edit,Submit Or View. So, Are You Sure You Want to Reject This Candidate?");
        if (checkreject) {
            checkreject = document.getElementsByName('Reject');
            window.location = 'candidateF2FRequest.htm?act=reject&id=' + applicationId + '&candidateId=' + candidateId;
            return true;
        }
        return false;
    }
</script>
<script>
    function isNumberKey(evt)
    {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode != 46 && charCode > 31
                && (charCode < 48 || charCode > 57))
            return false;

        return true;
    }
</script>

