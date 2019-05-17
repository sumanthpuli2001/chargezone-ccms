<%-- 
    Document   : MyProfile
    Created on : 27 Feb, 2018, 2:13:05 PM
    Author     : Vikas
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top.jsp"%>

<%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
<%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Candidate Registration</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

        <!--        <style>
                    .labelDiv {
                        width: 120px;
                    }
                </style>-->
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }
            td,table{
                text-align: center;
                vertical-align: center;
                padding: 5px;
            }
            th{
                text-align: left;
                vertical-align: center;
                padding: 5px;
            }
        </style>
        <script>
//            $(function () {
//            $("#datepicker").datepicker();
//            });
            $(function() {
            $('#datepicker').datepicker({
            changeMonth: true,
                    changeYear: true,
                    yearRange: '1900:' + new Date().getFullYear().toString(),
                    showButtonPanel: true,
                    dateFormat: 'dd/mm/yy',
                    onClose: function(dateText, inst) {

                    var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                            var date = $("#ui-datepicker-div .ui-datepicker-date :selected").val();
                    }
            });
            });
                    $(function() {
                    $('#datepicker45').datepicker({
                    changeMonth: true,
                            changeYear: true,
                            yearRange: '1900:' + new Date().getFullYear().toString(),
//                            showButtonPanel: true,
                            dateFormat: 'dd/mm/yy',
                            onClose: function(dateText, inst) {
                            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                                    var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                                    var date = $("#ui-datepicker-div .ui-datepicker-date :selected").val();
                            }
                    });
                    });
                    $(function() {
                    $('#datepicker46').datepicker({
                    changeMonth: true,
                            changeYear: true,
                            yearRange: '1900:' + new Date().getFullYear().toString(),
//                            showButtonPanel: true,
                            dateFormat: 'dd/mm/yy',
                            onClose: function(dateText, inst) {
                            var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                                    var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                                    var date = $("#ui-datepicker-div .ui-datepicker-date :selected").val();
                            }
                    });
                    });
                    $(function () {
                    $("#datepicker1").datepicker();
                    });
                    $(function () {
                    $("#datepicker2").datepicker();
                    });
                    var i1 = 1;
                    var i2 = 1;
                    var i3 = 1;
                    var i4 = 1;
                    $(function () {
                    $('#buttonQualification').click(function () {
                    i1++;
                            var addNewRow = "<tr id='table_1_rowNo_" + i1 + "'>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateAcademicQualification.academicYearFrom\" class=\"form-control academicFrom\" id=\"academicFrom\" placeholder=\"Year From\"/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='number' min='0' name='candidateAcademicQualification.academicYearTo' class='form-control academicTo' id='academicTo' placeholder='Year To'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateAcademicQualification.academicExamination' class='form-control' placeholder='Academic Qualification'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateAcademicQualification.academicBoard' class='form-control' placeholder='Academic Board'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='number' min='0' name='candidateAcademicQualification.academicNumberOfAttempts' class='form-control' placeholder='No Of Attempts'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateAcademicQualification.academicMarksInPercent' class='form-control' placeholder='Academic Marks(%)'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateAcademicQualification.academicClass' class='form-control' placeholder='Academic Class'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateAcademicQualification.academicRankOrScholarship' class='form-control' placeholder='Academic Rank/Scholarship'/>" +
                            "</td>" +
                            "<td>" +
                            "<button type=\"button\" class='btn btn-flat' style='width: 50px;' id='removeQualification' onClick=\"removeChild1('table_1_rowNo_" + i1 + "');\" value=\"-\">-</button>" +
                            "</td>" +
                            "</tr>";
                            document.getElementById("countId").value = i1;
                            $('#tbodyQualification').append(addNewRow);
                    });
                    });
                    $(function () {
                    i2++;
                            $('#buttonExperience').click(function () {
                    var addNewRow = "<tr id='table_2_rowNo_" + i2 + "'>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateExperienceDetail.experienceYearFrom\" class=\"form-control experienceFrom\" id=\"experienceFrom\" placeholder=\"Year From\"/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='number' min='0' name='candidateExperienceDetail.experienceYearTo' class='form-control experienceTo' id='experienceTo' placeholder='Year To'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateExperienceDetail.experienceOrganization' class='form-control' placeholder='Experience Organization'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateExperienceDetail.experienceDepartment' class='form-control' placeholder='Experience Department'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateExperienceDetail.experienceDesignation' class='form-control' placeholder='Experience Designation'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateExperienceDetail.experienceJobResponsibilities' class='form-control' placeholder='Experience Job Responsibilities'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateExperienceDetail.experienceRemunerationOnJoin\" class=\"form-control\" placeholder=\"Remuneration On Join\"/>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateExperienceDetail.experienceRemunerationOnLeaving\" class=\"form-control\" placeholder=\"Remuneration On Leave\"/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateExperienceDetail.experienceReasonForLeaving' class='form-control' placeholder='Reason For Leaving'/>" +
                            "</td>" +
                            "<td>" +
                            "<button type=\"button\" class='btn btn-flat' style='width: 50px;' id='removeExperience' onClick=\"removeChild2('table_2_rowNo_" + i2 + "');\" value=\"-\">-</button>" +
                            "</td>" +
                            "</tr>";
                            document.getElementById("countId").value = i2;
                            $('#tbodyExperience').append(addNewRow);
                    });
                    });
                    $(function () {
                    i3++;
                            $('#buttonFamilyBackground').click(function () {
                    var addNewRow = "<tr id='table_3_rowNo_" + i3 + "'>" +
                            "<td>" +
                            "<input type='text' name='candidateFamilyBackground.familyMemberName' class='form-control' placeholder='Name'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateFamilyBackground.relationWithFamilyMember' class='form-control' placeholder='Relation With Member'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateFamilyBackground.familyMemberAge\" class=\"form-control \"  placeholder='Age'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateFamilyBackground.familyMemberQualification' class='form-control' placeholder='Qualification'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateFamilyBackground.familyMemberMonthlyIncome' class='form-control' placeholder='Designation Ocuupation'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateFamilyBackground.familyMemberMonthlyIncome\" class=\"form-control\" placeholder='Monthly Income'/>" +
                            "</td>" +
                            "<td>" +
                            "<button type=\"button\" class='btn btn-flat' style='width: 50px;' id='removeFamilyBackground' onClick=\"removeChild3('table_3_rowNo_" + i3 + "');\" value=\"-\">-</button>" +
                            "</td>" +
                            "</tr>";
                            document.getElementById("countId").value = i3;
                            $('#tbodyFamilyBackground').append(addNewRow);
                    });
                    });
                    $(function () {
                    i4++;
                            $('#buttonOtherReferences').click(function () {
                    var addNewRow = "<tr id='table_4_rowNo_" + i4 + "'>" +
                            "<td>" +
                            "<input type='text' name='candidateOtherReferences.referenceNonRelativesName' class='form-control' placeholder='Name'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateOtherReferences.referenceNonRelativesOrganization' class='form-control' placeholder='Organization'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type='text' name='candidateOtherReferences.referenceNonRelativesPosition' class='form-control' placeholder='Position'/>" +
                            "</td>" +
                            "<td>" +
                            "<input type=\"number\" min=\"0\" name=\"candidateOtherReferences.referenceNonRelativesContactNmber\" class=\"form-control\" placeholder='Contact Nmber'/>" +
                            "</td>" +
                            "<td>" +
                            "<button type=\"button\" class='btn btn-flat' style='width: 50px;' id='removeOtherReferences' onClick=\"removeChild4('table_4_rowNo_" + i4 + "');\" value=\"-\">-</button>" +
                            "</td>" +
                            "</tr>";
                            document.getElementById("countId").value = i4;
                            $('#tbodyOtherReferences').append(addNewRow);
                    });
                    });</script>
        <script>
                    function removeChild1(removeRowId1) {

                    i1--;
                            document.getElementById("countId").value = i1;
                            var element1 = document.getElementById(removeRowId1);
                            element1.parentNode.removeChild(element1);
                    }
            function removeChild2(removeRowId1) {

            i1--;
                    document.getElementById("countId").value = i2;
                    var element1 = document.getElementById(removeRowId1);
                    element1.parentNode.removeChild(element1);
            }
            function removeChild3(removeRowId1) {

            i1--;
                    document.getElementById("countId").value = i3;
                    var element1 = document.getElementById(removeRowId1);
                    element1.parentNode.removeChild(element1);
            }
            function removeChild4(removeRowId1) {

            i1--;
                    document.getElementById("countId").value = i4;
                    var element1 = document.getElementById(removeRowId1);
                    element1.parentNode.removeChild(element1);
            }
//            function inputRadio(){
//                    alert("hiii");
//                }
        </script>
    </head>
    <body >
        <section class="content-header">
            <h1><b>Candidate Registration</b></h1>
            <button type="button" class="btn btn-primary" style="float: left; width: 120px;" onclick="window.location = 'vacancy.htm?act=candidateProfile'"><i class="fa fa-backward"></i>&nbsp&nbsp&nbsp;Back</button>
            <!--<button type="button" class="btn btn-primary" style="float: right; width: 120px;" onclick="window.location = 'vacancy.htm?act=showVacancyList'"><i class="fa fa-home"></i>&nbsp&nbsp&nbsp;Home</button>-->

        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <br/>
        <br/>
        <form:form action="vacancy.htm?act=tryToAdd" method="post" enctype="multipart/form-data"  commandName="combinedCandidateClasses"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <!--<input type="hidden" id="empreqid" name="empreqid" value="${candidateApplyJob.id}">-->
            <form:hidden path="candidateApplyJob.id"></form:hidden>
            <form:hidden path="candidateApplyJob2.id"></form:hidden>

                <section class="content">
                    <div class="row">

                        <div class="col-sm-12">
                            <div class="col-sm-5">
                                <table class="table-bordered" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th colspan="2" style="text-align: left">Photograph<span style="color: red;font-size: 12px;"> *</span></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${photographAttachment eq ''}">
                                            <tr>
                                                <td>
                                                <td><input type="file" name="candidateApplyJob.photograph" class="form-control"/></td>
                                                </td> 
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td><input type="file" name="candidateApplyJob.photograph" class="form-control"/></td> 
                                            </tr>
                                            <tr>
                                                <td><a href="vacancy.htm?act=downloadCandidatePhotograph&amp;fileName=${photographAttachment}">${photographAttachment}</a></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                </tbody>
                            </table>
                            </br>
                        </div>
                        <!--                        <div class="col-sm-7">
                                                    <table class="table-bordered" style="width:100%">
                                                        <thead>
                                                            <tr>
                                                                <th style="text-align: left">Post Applied For<span style="color: red;font-size: 12px;"> *</span></th>
                                                            </tr>
                                                        </thead>
                        <%--<c:if test="${empty candidateJobApplyNAmeList}">--%>
                            <tbody>
                                <tr>
                                    <td>
                        <%--<form:input path="candidateApplyJob2.postAppliedFor" class="form-control" placeholder="Enter Applied Post" required="true"></form:input>--%>
</td>
                                    </tr>
                                </tbody>
                        <%--</c:if>--%>
                        <%--<c:if test="${!empty candidateJobApplyNAmeList}">--%>
                            <tbody>
                                <tr>
                                    <td><input value="${jobprofileName}" class="form-control" placeholder="Enter Applied Post" required="true"></input></td>
                                </tr>
                            </tbody>
                        <%--</c:if>--%>
                    </table>
                    </br>
                </div>-->
                    </div>

                    <div class="col-sm-12">
                        <center>
                            <h3>Personal Information</h3>
                        </center>
                        </br>
                    </div>    

                    <div class="col-sm-12">
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th style="text-align: center">First Name<span style="color: red;font-size: 12px;"> *</span></th>
                                    <th style="text-align: center">Middle Name<span style="color: red;font-size: 12px;"> *</span></th>
                                    <th style="text-align: center">Last Name<span style="color: red;font-size: 12px;"> *</span></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><form:input path="candidateApplyJob.name" class="form-control" placeholder="First Name" required="true"></form:input></td>
                                    <td><form:input path="candidateApplyJob.middleName" class="form-control" placeholder="Middle Name" required="true"></form:input></td>
                                    <td><form:input path="candidateApplyJob2.lastName" class="form-control" placeholder="Last Name" required="true"></form:input></td>
                                    </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>

                        <div class="col-sm-12">
                            </br>
                            <table class="table-bordered" style="width:100%;text-align: left;" >
                                <tbody>
                                    <tr>
                                        <th colspan="2" style="text-align: left">Basic Details :</th>
                                    </tr>
                                    <tr>
                                        <th>Gender<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td style="text-align:left">
                                        <form:radiobutton  path="candidateApplyJob.sex" id="sexMale" value="false" required="true"/>Male &emsp;
                                        <form:radiobutton  path="candidateApplyJob.sex" id="sexFemale" value="true" required="true"/>Female
                                    </td>
                                </tr>
                                <!--                                <tr>
                                                                    <th>Your D.O.B<span style="color: red;font-size: 12px;"> *</span></th>
                                
                                                            <div class="input-group form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <td>
                                <form:input path="candidateApplyJob.dob" class="form-control" id="datepicker" placeholder="Select Your D.O.B" readonly="true" required="true"></form:input>
                                </td>
                            </div>
                            </tr>-->
                                    <!--                                <tr>
                                                                        <th>Father D.O.B<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                        <td><form:input path="candidateApplyJob.fatherDob" id="datepicker45" class="form-control" size="16" placeholder="dd/MM/yyyy" readonly="true" required="true"></form:input>
                                                                    </div>
                                                                    </tr>-->
                                    <!--                                <tr>
                                                                        <th>Father Name<span style="color: red;font-size: 12px;"> *</span></th>
                                                                        <td><form:input path="candidateApplyJob.fatherName" class="form-control" placeholder="Enter Father Name" required="true"></form:input></td>
                                                                    </tr>
                                                                    <tr>-->
                                    <!--                                    <th>Mother Name<span style="color: red;font-size: 12px;"> *</span></th>
                                                                        <td><form:input path="candidateApplyJob.motherName" class="form-control" placeholder="Enter Mother Name" required="true"></form:input></td>
                                                                    </tr>-->
                                    <!--                                <tr>
                                                                    <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                        <th>Mother D.O.B<span style="color: red;font-size: 12px;"> *</span></th>
                                                                        <td><form:input path="candidateApplyJob.motherDob" id="datepicker46"  class="form-control" size="16" placeholder="Select Mother's D.O.B" readonly="true" required="true"></form:input></td>
                                                                    </div>
                                                                    </tr>-->
                                    <tr>
                                        <th>Blood Group<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td>
                                        <form:select path="candidateApplyJob.bloodGroup" id="bloodGroups" class="form-control" required="true">
                                <option value="">--Select--</option>
                                <form:option value="A +ve">A+</form:option>
                                <form:option value="A -ve">A-</form:option>
                                <form:option value="B +ve">B+</form:option>
                                <form:option value="B -ve">B-</form:option>
                                <form:option value="AB +ve">AB+</form:option>
                                <form:option value="AB -ve">AB-</form:option>
                                <form:option value="O +ve">O+</form:option>
                                <form:option value="O -ve">O-</form:option>
                            </form:select>
                            </td>
                            </tr>
                            <!--                            <tr>
                                                            <th>Height<span style="color: red;font-size: 12px;"> *</span></th>
                                                            <td><form:input path="candidateApplyJob2.height" class="form-control" placeholder="Enter Height" required="true"></form:input></td>
                                                            </tr>-->
                                <!--                                <tr>
                                                                    <th>Weight<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <td><form:input path="candidateApplyJob2.weight" class="form-control" placeholder="Enter Weight" required="true"></form:input></td>
                                                                </tr>-->
                                <!--                                <tr>
                                                                    <th>Religion<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <td><form:input path="candidateApplyJob2.religion" class="form-control" placeholder="Enter Religion" required="true"></form:input></td>
                                                                </tr>-->
                                <tr>
                                    <th>Marital Status<span style="color: red;font-size: 12px;"> *</span></th>
                                    <td style="text-align:left">
                                    <form:radiobutton path="candidateApplyJob.martialStatus" id="unmarriedStatus" value="UnMarried" required="true"/>Unmarried &emsp;
                                    <form:radiobutton path="candidateApplyJob.martialStatus" id="marriedStatus" value="Married" required="true"/>Married &emsp;
                                    <form:radiobutton path="candidateApplyJob.martialStatus" id="otherStatus" value="Other" required="true"/>Other 
                                </td>
                            </tr>
                            <tr>
                                <th>Addiction<span style="color: red;font-size: 12px;"> *</span></th>
                                <td style="text-align:left">
                                    <form:checkbox path="candidateApplyJob2.smokingHabit" id="smoking"  value="1"/>Smoking &emsp;
                                    <form:checkbox path="candidateApplyJob2.chewingHabit" id="chewing"  value="1"/>Chewing &emsp;
                                    <form:checkbox path="candidateApplyJob2.tobaccoHabit" id="tobacco"  value="1"/>Tobacco &nbsp;
                                    <form:checkbox path="candidateApplyJob2.otherHabit" id="tobacco"  value="1"/>Other
                                </td>
                            </tr>
                            <tr>
                                <th colspan="2" style="text-align: left">Languages Known<span style="color: red;font-size: 12px;"> *</span></th>
                            </tr>
                            <tr>
                                <th>English</th>
                                <td style="text-align:left">
                                    <form:checkbox path="candidateApplyJob2.readEnglish" id="readEnglish"  value="1"/>Read &emsp;
                                    <form:checkbox path="candidateApplyJob2.writeEnglish" id="writeEnglish"  value="1"/>Write &emsp;
                                    <form:checkbox path="candidateApplyJob2.speakEnglish" id="speakEnglish"  value="1"/>Speak &nbsp;
                                </td>
                            </tr>    
                            <tr>    
                                <th>Hindi</th>
                                <td style="text-align:left">    
                                    <form:checkbox path="candidateApplyJob2.readHindi" id="readHindi"  value="1"/>Read &emsp;
                                    <form:checkbox path="candidateApplyJob2.writeHindi" id="writeHindi"  value="1"/>Write &emsp;
                                    <form:checkbox path="candidateApplyJob2.speakHindi" id="speakHindi"  value="1"/>Speak &nbsp;
                                </td>
                            </tr>    
                            <tr>    
                                <th>Gujarati</th>
                                <td style="text-align:left">
                                    <form:checkbox path="candidateApplyJob2.readGujarati" id="readGujarati"  value="1"/>Read &emsp;
                                    <form:checkbox path="candidateApplyJob2.writeGujarati" id="writeGujarati"  value="1"/>Write &emsp;
                                    <form:checkbox path="candidateApplyJob2.speakGujarati" id="speakGujarati"  value="1"/>Speak &nbsp;
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        </br>
                    </div>    

                    <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th colspan="2">Contact Details</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>Email Id<span style="color: red;font-size: 12px;"> *</span></th>
                                    <td><form:input path="candidateApplyJob.emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Invalid Email format." class="form-control" placeholder="example@domain.com" required="true"></form:input></td>
                                    </tr>
                                    <tr>
                                        <th>Personal Contact No<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input type="number" min="0" path="candidateApplyJob.contactNo" placeholder="Enter Contact No" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input></td>
                                    </tr>
                                    <!--                                    <tr>
                                                                            <th>Residential Contact No<span style="color: red;font-size: 12px;"> *</span></th>
                                                                            <td><form:input type="number" min="0" path="candidateApplyJob2.residentPhoneNumber" class="form-control" placeholder="Enter Residential Contact No" required="true"></form:input></td>
                                                                        </tr>-->
                                    <!--                                    <tr>
                                                                            <th>Emergency Contact Person<span style="color: red;font-size: 12px;"> *</span></th>
                                                                            <td><form:input path="candidateApplyJob.emergencyContactPerson" class="form-control" placeholder="Enter Emergency contact Person" required="true"></form:input></td>
                                                                        </tr>-->
                                    <!--                                    <tr>
                                                                            <th>Emergency Contact No<span style="color: red;font-size: 12px;"> *</span></th>
                                                                            <td><form:input type="number" min="0" path="candidateApplyJob.emergencyContactNo" class="form-control" placeholder="Enter Emergency Contact No" required="true"></form:input></td>
                                                                        </tr>-->
                                </tbody>
                            </table>
                            </br>
                        </div>

                        <div class="col-sm-12">
                            </br>
                            <table class="table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th colspan="2">Residential Details</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>Present Address<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:textarea path="candidateApplyJob.presentAddress" class="form-control" placeholder="Enter Present Address" required="true"></form:textarea></td>
                                    </tr>
                                    <tr>
                                        <th>Permanent Address<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:textarea path="candidateApplyJob.permanentAddress" class="form-control" placeholder="Enter Permanent Address" required="true"></form:textarea></td>
                                    </tr>
                                    <tr>
                                        <th>City<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input path="candidateApplyJob.city" class="form-control" placeholder="Enter City" required="true"></form:input></td>
                                    </tr>
                                </tbody>
                            </table>
                            </br>
                        </div> 

                        <div class="col-sm-12">
                            </br>
                            <table class="table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th colspan="2">CTC Details</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>Current CTC:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input path="candidateApplyJob2.anyRelativeInSPCL" class="form-control" placeholder="Current CTC" required="true"></form:input></td>
                                    </tr>
                                    <tr>
                                        <th>Current CTC(On Hand):<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input path="candidateApplyJob2.physicalDamageOrDiseases" class="form-control" placeholder="Current CTC(On Hand)" required="true"></form:input></td>
                                    </tr>
                                    <tr>
                                        <th>Expected CTC:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input path="candidateApplyJob2.criminalCaseBackground" class="form-control" placeholder="Expected CTC" required="true"></form:input></td>
                                    </tr>
                                    <tr>
                                        <th>Expected CTC(On Hand):</th>
                                        <td><form:input path="candidateApplyJob2.insurancePolicyNumber" class="form-control" placeholder="Expected CTC(On Hand)"></form:input></td>
                                    </tr>
                                    <tr>
                                        <th>No. of years of commitment you can give:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <td><form:input path="candidateApplyJob2.drivingLicenceNumber" class="form-control" placeholder="No. of Years" required="true"></form:input></td>
                                    </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>
                                      <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                
                            </thead>
                            <tbody>
                                
                            <div>
                                <tr>
                                <th>Reference Source :<span style="color: red;font-size: 12px;"> *</span></th>
                                <td style="text-align:left">
                                    <form:checkbox path="candidateApplyJob2.friend" id="friend"  value="1"/>Friend &emsp;
                                    <form:checkbox path="candidateApplyJob2.naukri" id="naukri"  value="1"/>Naukri &emsp;
                                    <form:checkbox path="candidateApplyJob2.indeed" id="indeed"  value="1"/>Indeed &nbsp;
                                    <form:checkbox path="candidateApplyJob2.other" id="other"  value="1"/>Other
                                </td>
                            </tr>
                                
                            
                                </tbody>
                            </table>
                            </br>
                        </div>           
                                         <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th colspan="2">Please Rate Yourself Out Of ‘10’ For Following Skills</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            <div>
                                <tr>
                                    <th>Accounting:</th>
                                    <td><form:input type="number" min="0" path="candidateApplyJob2.salaryBreakupOther" class="form-control" placeholder=""></form:input></td>
                                    </tr>
                                </div>
                                <!--                                <tr>
                                                                    <th>PF<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <td style="text-align: left" id="pfStatusTd">
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus1" value="1" required="true"/>Yes 
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus0" value="0" required="true"/>No
                        </td>
                    </tr>-->
                            <tr>
                            <div id="trPfNo">
                                <th>Loyalty:</th>
                                <td><span style="color: red;font-size: 12px;"> *</span><form:input type="number" min="0" path="candidateApplyJob2.salaryBreakupTotal" class="form-control" placeholder=""></form:input></td>
                                </div>
                                </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>  
                            
                            
                            
                             <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th colspan="2">3 Qualities Which Make You Different / Outstanding Than Other:</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            <div>
                                <tr>
                                    <th>Professional:</th>
                                    <td><form:textarea type="text" min="0" path="candidateApplyJob2.salaryBreakupBasic" class="form-control" placeholder=""></form:textarea></td>
                                    </tr>
                                </div>
                              
                            <tr>
                            <div >
                                <th>Personal:</th>
                                <td><span style="color: red;font-size: 12px;"> *</span><form:textarea type="text" min="0" path="candidateApplyJob2.salaryBreakupDaVdaSdAll" class="form-control" placeholder=""></form:textarea></td>
                                </div>
                                </tr>
                                </tbody>
                            </table>
                            </br>
                        </div> 
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                                    
                                     <div class="col-sm-12">
                        </br>  
                        <center>
                            <h3>Please Rate Yourself Out Of ‘10’ For Following Skills(English)</h3>
                        </center>
                        </br>
                    </div>  

                    <div class="col-sm-12">
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr style="text-align:center">
                                    <th rowspan="2" style="text-align:center">Speaking</th>
                                    <th rowspan="2" style="text-align:center">Writing</th>
                                    <th rowspan="2" style="text-align:center">Reading</th>
                                    <th rowspan="2" style="text-align:center">Leadership</th>
                                    <th rowspan="2" style="text-align:center">Responsible</th>
                                    <th rowspan="2" style="text-align:center">Confident</th>
                                    <th rowspan="2" style="text-align:center">Honest</th>
                                    <!--<th style="text-align:center"><button type="button" id="buttonExperience" class="btn btn-flat" style="width: 50px;" data-original-title="" title="" > + </button></th>-->
                                </tr>
                                
                            </thead>
                            <tbody id="tbodyExperience">
                                <c:choose>
                                    <c:when test="${empty cedList}">
                                        <tr>
                                    <input type="hidden" name="countId" id="countId" value="1">
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceYearFrom" class="form-control" placeholder=""/></td>
                                    <!--<td><input type="number" min="0" name="candidateExperienceDetail.experienceYearTo" class="form-control" placeholder="Year To"/></td>-->
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceOrganization" class="form-control" placeholder=""/></td>
                                    <td><input  type="number" min="0"name="candidateExperienceDetail.experienceDepartment" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceDesignation" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceJobResponsibilities" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceRemunerationOnJoin" class="form-control" placeholder=""/></td>
                                    <!--<td><input type="number" min="0" name="candidateExperienceDetail.experienceRemunerationOnLeaving" class="form-control" placeholder=""/></td>-->
                                    <td><input type="number" min="0" name="candidateExperienceDetail.experienceReasonForLeaving" class="form-control" placeholder=""/></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${cedList}" var="list">
                                        <tr>
                                        <input type="hidden" name="countId" id="countId" value="1">
                                        <input type="hidden" min="0" name="candidateExperienceDetail.id" class="form-control" value="${list.id}"/>
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceYearFrom" class="form-control" value="${list.experienceYearFrom}"/></td>
                                        <!--<td><input type="number" min="0" name="candidateExperienceDetail.experienceYearTo" class="form-control" value="${list.experienceYearTo}"/></td>-->
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceOrganization" class="form-control" value="${list.experienceOrganization}"/></td>
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceDepartment" class="form-control" value="${list.experienceDepartment}"/></td>
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceDesignation" class="form-control" value="${list.experienceDesignation}"/></td>
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceJobResponsibilities" class="form-control" value="${list.experienceJobResponsibilities}"/></td>
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceRemunerationOnJoin" class="form-control" value="${list.experienceRemunerationOnJoin}"/></td>
                                        <!--<td><input type="number" min="0" name="candidateExperienceDetail.experienceRemunerationOnLeaving" class="form-control" value="${list.experienceRemunerationOnLeaving}"/></td>-->
                                        <td><input type="number" min="0" name="candidateExperienceDetail.experienceReasonForLeaving" class="form-control" value="${list.experienceReasonForLeaving}"/></td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>                      

                    <div class="col-sm-12">
                        </br>  
                        <center>
                            <h3>Please Rate Yourself Out Of ‘10’ For Following Skills(Excel)</h3>
                        </center>
                        </br>
                    </div>   

                    <div class="col-sm-12">
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr style="text-align:center">
                                    <th style="text-align:center">Basic</th>
                                    <th style="text-align:center">V Look Up</th>
                                    <th style="text-align:center">Pivot Table</th>
                                    <th style="text-align:center">Punctual</th>
                                    <th style="text-align:center">Team work</th>
                                    <th style="text-align:center">Positive</th>
                                    <!--<th style="text-align:center"><button type="button" id="buttonFamilyBackground" class="btn btn-flat" style="width: 50px;" data-original-title="" title="" > + </button></th>-->
                                </tr>
                            </thead>
                            <tbody id="tbodyFamilyBackground">
                                <c:choose>
                                    <c:when test="${empty cfbList}">
                                        <tr>
                                    <input type="hidden" name="countId" id="countId" value="1">
                                    <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberName" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateFamilyBackground.relationWithFamilyMember" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberAge" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberQualification" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberDesignationOccupation" class="form-control" placeholder=""/></td>
                                    <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberMonthlyIncome" class="form-control" placeholder=""/></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${cfbList}" var="list">
                                        <tr>
                                        <input type="hidden" name="countId" id="countId" value="1">
                                        <input type="hidden" min="0" name="candidateFamilyBackground.id" class="form-control" value="${list.id}"/>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberName" class="form-control" value="${list.familyMemberName}"/></td>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.relationWithFamilyMember" class="form-control" value="${list.relationWithFamilyMember}"/></td>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberAge" class="form-control" value="${list.familyMemberAge}"/></td>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberQualification" class="form-control" value="${list.familyMemberQualification}"/></td>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberDesignationOccupation" class="form-control" value="${list.familyMemberDesignationOccupation}"/></td>
                                        <td><input type="number" min="0" name="candidateFamilyBackground.familyMemberMonthlyIncome" class="form-control" value="${list.familyMemberMonthlyIncome}"/></td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>       

<!--                        <div class="col-sm-12">
                            </br>  
                            <center>
                                <h3>Past Salary Information</h3>
                            </center>
                            </br>
                        </div>       -->

<!--                        <div class="col-sm-12">
                            <table class="table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Present Salary Breakup</th>
                                        <th>Salary Slip to be Attached</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>Basic</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupBasic" class="form-control salary" id="basicSalary" placeholder="Enter Basic Salary"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>DA/VDA/SD/ALL</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupDaVdaSdAll" class="form-control salary" id="davdaSalary" placeholder="Enter Da/Vd/Sd/All"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>HRA</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupHRA" class="form-control salary" id="hraSalary" placeholder="Enter HRA"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>CONVEYANCE ALL.</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupConveyanceAll" class="form-control salary" id="conveyanceSalary" placeholder="Enter CONVEYANCE ALL."></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>LTA</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupLTA" class="form-control salary" id="ltaSalary" placeholder="Enter LTA"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>MED.</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupMED" class="form-control salary" id="medSalary" placeholder="Enter MED."></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>BONUS</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupBonus" class="form-control salary" id="bonusSalary" placeholder="Enter Bonus"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>OTHER, If any</th>
                                        <td><form:input type="number" min="0" step="any" path="candidateApplyJob2.salaryBreakupOther" class="form-control salary" id="otherSalary" placeholder="Enter Other"></form:input></td>

                                    </tr>
                                    <tr>
                                        <th>TOTAL</th>
                                        <td><form:input type="number" step="any" path="candidateApplyJob2.salaryBreakupTotal" class="form-control salaryTotal" id="salaryTotal" placeholder="Enter Total Salary"></form:input></td>                                      
                                    </tr>
                                    <tr>
                                        <th>Salary Slip Attachment<span style="color: red;font-size: 12px;"> *</span></th>
                                        <c:choose>
                                            <c:when test="${salarySlipAttachment eq '' or salarySlipAttachment eq null}">
                                            <td><input type="file" name="candidateApplyJob2.salarySlipAttachment" class="form-control" required="true"></td>                                      
                                        </tr> 
                                    </c:when>
                                    <c:otherwise>
                                    <td>
                                        <input type="file" name="candidateApplyJob2.salarySlipAttachment" class="form-control">
                                        <a href="vacancy.htm?act=downloadCandidateSalaryAttachment&amp;fileName=${salarySlipAttachment}">${salarySlipAttachment}</a>
                                    </td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>    
                            </tbody>
                        </table>
                        </br>
                    </div>    -->
                                    
                                    
                         <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th colspan="2">Goals:</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            <div>
                                <tr>
                                    <th>Long term:  5 years </th>
                                    <td><form:input type="text"  path="candidateApplyJob2.salaryBreakupHRA" class="form-control" placeholder=""></form:input></td>
                                    </tr>
                                </div>
                                <!--                                <tr>
                                                                    <th>PF<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <td style="text-align: left" id="pfStatusTd">
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus1" value="1" required="true"/>Yes 
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus0" value="0" required="true"/>No
                        </td>
                    </tr>-->
                            <tr>
                            <div id="trPfNo">
                                <th>Short term:  2 years</th>
                                <td><span style="color: red;font-size: 12px;"> *</span><form:input type="text"  path="candidateApplyJob2.salaryBreakupConveyanceAll" class="form-control" placeholder=""></form:input></td>
                                </div>
                                </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>           

                    <div class="col-sm-12">
                        </br>
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr>
                                    <th colspan="2">Are you Covered Under ?</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>Can You Join Immediate:<span style="color: red;font-size: 12px;"> *</span></th>
                                    <td style="text-align: left" id="esicStatusTd">
                                        <form:radiobutton path="candidateApplyJob2.esicStatus" name="esicStatus" id="esicStatus1" value="1" required="true"/>Yes
                                        <form:radiobutton path="candidateApplyJob2.esicStatus" name="esicStatus" id="esicStatus0" value="0" required="true"/>No
                                    </td>
                                </tr>
                            <div id="trEsicNo">
                                <tr>
                                    <th>Possibility Of Having Less Notice Period:</th>
                                    <td><form:input type="number" min="0" path="candidateApplyJob2.esicNumber" class="form-control" placeholder=""></form:input></td>
                                    </tr>
                                </div>
                                <!--                                <tr>
                                                                    <th>PF<span style="color: red;font-size: 12px;"> *</span></th>
                                                                    <td style="text-align: left" id="pfStatusTd">
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus1" value="1" required="true"/>Yes 
                            <form:radiobutton path="candidateApplyJob2.pfStatus" name="pfStatus" id="pfStatus0" value="0" required="true"/>No
                        </td>
                    </tr>-->
                            <tr>
                            <div id="trPfNo">
                                <th>% Increment Expected After 1 Year:</th>
                                <td><span style="color: red;font-size: 12px;"> *</span><form:input type="number" min="0" path="candidateApplyJob2.pfNumber" class="form-control" placeholder=""></form:input></td>
                                </div>
                                </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>   
                                
                                  
                        <div class="col-sm-12">
                            
                            <center>
                                <h3>Growth:</h3>
                            </center>
                           
                        </div>  
                        <div class="col-sm-12">
                            </br>
                            <table class="table-bordered" style="width:100%">
                                <thead>
                                    <tr>
                                        <th style="text-align:center">Salary when Started:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th style="text-align:center">Salary when leaving:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th style="text-align:center">No of years:<span style="color: red;font-size: 12px;"> *</span></th>
                                        <!--<th style="text-align:center">Total Experience In Month<span style="color: red;font-size: 12px;"> *</span></th>-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><form:input type="number" min="0" path="candidateApplyJob2.salaryExpected" class="form-control" placeholder=""></form:input></td>
                                    <td><form:input path="candidateApplyJob2.noticePeriod" class="form-control" placeholder="" required="true"></form:input></td>
                                    <td><form:input type="number" min="0" path="candidateApplyJob.experianceDateJoiningYear" class="form-control" step="any" placeholder="" required="true"></form:input></td>
                                    <!--<td><form:input type="number" min="0" path="candidateApplyJob.experianceDateJoiningMonth" class="form-control" step="any" placeholder="" required="true"></form:input></td>-->
                                    </tr>
                                </tbody>
                            </table>
                            </br>
                        </div>            

                        <div class="col-sm-12">
                            </br>  
                            <center>
                                <h3>Academic Qualification Information</h3>
                            </center>
                            </br>
                        </div>  

                        <div class="col-sm-12">
                            <table class="table-bordered" style="width:100%">
                                <thead>
                                    <tr style="text-align:center">
                                        <th colspan="2" style="text-align:center">Year<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">Examination<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">Board/College/University<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">No. of Attempts<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">Academic Marks(%)<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">Academic Class<span style="color: red;font-size: 12px;"> *</span></th>
                                        <th rowspan="2" style="text-align:center">Rank Or Scholarship(if Any)</th>
                                        <th style="text-align:center"><button type="button" id="buttonQualification" class="btn btn-flat" style="width: 50px;" data-original-title="" title="" >+</button></th>
                                    </tr>
                                    <tr>
                                        <th style="text-align:center">From</th>
                                        <th style="text-align:center">To</th>
                                    </tr>
                                </thead>
                                <tbody id="tbodyQualification">
                                <c:choose>
                                    <c:when test="${empty caqList}">
                                        <tr>
                                    <input type="hidden" name="countId" id="countId" value="1">
                                    <td><input type="number" min="0" name="candidateAcademicQualification.academicYearFrom" class="form-control academicFrom" id="academicFrom" placeholder="Year From" required="true"/></td>
                                    <td><input type="number" min="0" name="candidateAcademicQualification.academicYearTo" class="form-control academicTo" id="academicTo" placeholder="Year To" required="true"/></td>
                                    <td><input type="text" name="candidateAcademicQualification.academicExamination" class="form-control" placeholder="Academic Examination" required="true"/></td>
                                    <td><input type="text" name="candidateAcademicQualification.academicBoard" class="form-control" placeholder="Academic Board" required="true"/></td>
                                    <td><input type="number" min="0" name="candidateAcademicQualification.academicNumberOfAttempts" class="form-control" placeholder="No of Attempts" required="true"/></td>
                                    <td><input type="text" name="candidateAcademicQualification.academicMarksInPercent" class="form-control" placeholder="Academic Marks(%)" required="true"/></td>
                                    <td><input type="text" name="candidateAcademicQualification.academicClass" class="form-control" placeholder="Academic Class" required="true"/></td>
                                    <td><input type="text" name="candidateAcademicQualification.academicRankOrScholarship" class="form-control" placeholder="Academic Rank/Scholarship"/></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${caqList}" var="list">
                                        <tr>
                                        <input type="hidden" name="countId" id="countId" value="1">
                                        <input type="hidden" min="0" name="candidateAcademicQualification.id" class="form-control" value="${list.id}"/>
                                        <td><input type="number" min="0" name="candidateAcademicQualification.academicYearFrom" class="form-control academicFrom" value="${list.academicYearFrom}" id="academicFrom" placeholder="Year From" required="true"/></td>
                                        <td><input type="number" min="0" name="candidateAcademicQualification.academicYearTo" class="form-control academicTo" value="${list.academicYearTo}" id="academicTo" placeholder="Year To" required="true"/></td>
                                        <td><input type="text" name="candidateAcademicQualification.academicExamination" class="form-control" value="${list.academicExamination}" placeholder="Academic Examination" required="true"/></td>
                                        <td><input type="text" name="candidateAcademicQualification.academicBoard" class="form-control" value="${list.academicBoard}" placeholder="Academic Board" required="true"/></td>
                                        <td><input type="number" min="0" name="candidateAcademicQualification.academicNumberOfAttempts" class="form-control" value="${list.academicNumberOfAttempts}" placeholder="No of Attempts" required="true"/></td>
                                        <td><input type="text" name="candidateAcademicQualification.academicMarksInPercent" class="form-control" value="${list.academicMarksInPercent}" placeholder="Academic Marks(%)" required="true"/></td>
                                        <td><input type="text" name="candidateAcademicQualification.academicClass" class="form-control" value="${list.academicClass}" placeholder="Academic Class" required="true"/></td>
                                        <td><input type="text" name="candidateAcademicQualification.academicRankOrScholarship" class="form-control" value="${list.academicRankOrScholarship}" placeholder="Academic Rank/Scholarship"/></td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>

                    

                    <div class="col-sm-12">
                        </br>  
                        <center>
                            <!--<h3>Reference Information(Other than Relatives)</h3>-->
                        </center>
                        </br>
                    </div>

                    <div class="col-sm-12">
                        <table class="table-bordered" style="width:100%">
                            <thead>
                                <tr style="text-align:center">
                                    <th style="text-align:center">Strength</th>
                                    <th style="text-align:center">Weakness</th>
                                    <th style="text-align:center">Previous Job (Positive)</th>
                                    <th style="text-align:center">Previous Job (Negative)</th>
                                    <!--<th style="text-align:center"><button type="button" id="buttonOtherReferences" class="btn btn-flat" style="width: 50px;" data-original-title="" title="" > + </button></th>-->
                                </tr>
                            </thead>
                            <tbody id="tbodyOtherReferences">
                                <c:choose>
                                    <c:when test="${empty corList}">
                                        <tr>
                                    <input type="hidden" name="countId" id="countId" value="1">
                                    <td><input type="text" name="candidateOtherReferences.referenceNonRelativesName" class="form-control" placeholder=""/></td>
                                    <td><input type="text" name="candidateOtherReferences.referenceNonRelativesOrganization" class="form-control" placeholder=""/></td>
                                    <td><input type="text" name="candidateOtherReferences.referenceNonRelativesPosition" class="form-control" placeholder=""/></td>
                                    <td><input type="text"  min="0" name="candidateOtherReferences.referenceNonRelativesContactNmber" class="form-control" placeholder=""/></td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${corList}" var="list">
                                        <tr>
                                        <input type="hidden" name="countId" id="countId" value="1">
                                        <input type="hidden" min="0" name="candidateOtherReferences.id" class="form-control" value="${list.id}"/>
                                        <td><input type="text" name="candidateOtherReferences.referenceNonRelativesName" class="form-control" value="${list.referenceNonRelativesName}"/></td>
                                        <td><input type="text" name="candidateOtherReferences.referenceNonRelativesOrganization" class="form-control" value="${list.referenceNonRelativesOrganization}"/></td>
                                        <td><input type="text" name="candidateOtherReferences.referenceNonRelativesPosition" class="form-control" value="${list.referenceNonRelativesPosition}"/></td>
                                        <td><input type="number" min="0" name="candidateOtherReferences.referenceNonRelativesContactNmber" class="form-control" value="${list.referenceNonRelativesContactNmber}"/></td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>      

                </div><!-- /.col -->
            </div><!-- /.row -->

        </section>
        <div class="form-group">
            <div class=" col-sm-12" style="text-align: center;">
                <c:choose>
                    <c:when test="${certificateAttachment eq ''}">
                        <div class=" col-sm-6" style="text-align: right;">
                            Resume<span style="color: red;font-size: 12px;"> *</span>
                        </div>
                        <div class=" col-sm-6" style="text-align: left;">
                            <input type="file" name="candidateApplyJob.certificateAttach" class="form-control" required="true">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class=" col-sm-4" style="text-align: right;">
                            Resume<span style="color: red;font-size: 12px;"> *</span>
                        </div>
                        <c:if test="${empty certificateAttachment}">
                            <div class=" col-sm-4" style="text-align: left;">
                                <input type="file" name="candidateApplyJob.certificateAttach" class="form-control" required="true">
                            </div>
                            <div class=" col-sm-4" style="text-align: left;">
                                <a href="vacancy.htm?act=downloadCandidateCertificate&amp;fileName=${certificateAttachment}">${certificateAttachment}</a>
                            </div>  
                        </c:if>
                        <c:if test="${!empty certificateAttachment}">
                            <div class=" col-sm-4" style="text-align: left;">
                                <input type="file" name="candidateApplyJob.certificateAttach" class="form-control" >
                            </div>
                            <div class=" col-sm-4" style="text-align: left;">
                                <a href="vacancy.htm?act=downloadCandidateCertificate&amp;fileName=${certificateAttachment}">${certificateAttachment}</a>
                            </div>  
                        </c:if>

                    </c:otherwise>
                </c:choose>
            </div>
            </br>
        </div>

        <div class="form-group">
            </br>

            <div class=" col-sm-12" style="text-align: center;">
                <button type="submit" class="btn btn-primary" style="width: 200px !important;" data-original-title="" title="" >Save</button>
            </div>
            <!--            <div class=" col-sm-6" style="text-align: center;">
                            <button type="button" class="btn btn-primary" style="width: 200px !important;" onclick="onapply(${sessionScope.ApplayJobUserMaster.id},${idvanacy});" data-original-title="" title="" >Apply</button>
                        </div>  
                        <div class="col-sm-12" style="text-align: center;">
            
                        </div>-->
            <!--            <div class="col-sm-12" style="text-align: right;">
            
                            <a href="vacancy.htm?act=applyJobRegistration&id=${sessionScope.ApplayJobUserMaster.id}&vacancyId=${idvanacy}"  onclick="return confirm('Are you Ready to Apply?')">Apply</a>
                        </div>-->
        </div>

    </form:form>
    <script>
                function onapply(appuserid, vanacyID)
                {
//                window.location = "vacancy.htm?act=applyJobRegistration&id=${sessionScope.ApplayJobUserMaster.id}&vacancyId=${idvanacy}";
                window.location = 'vacancy.htm?act=applyJobRegistration&id=' + appuserid + '&vacancyId=' + vanacyID;
                }

    </script>


    <!-- Javascript -->
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->

</body>
<script type="text/javascript">
                $('.form_datetime_dob').datetimepicker({
        //language:  'fr',
        weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                startDate: dt1,
                endDate: dt,
                forceParse: 0
        });</script>


</script>
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script type="text/javascript">
            function checkFilecertificate()
            {
            var fup = document.getElementById('certificateId1');
                    var certificateId1 = fup.value;
//            alert(certificateId1);
                    var ext = certificateId1.substring(certificateId1.lastIndexOf('.') + 1);
                    if (ext == "pdf")
            {
            return true;
            } else
            {
            alert("Upload pdf files only");
                    fup.focus();
                    return false;
            }
            }

</script>
<script>
    $('#trEsicNo').hide();
            $('#trPfNo').hide();
            $(function(){
            $('input[name=esicStatus]').on('ifChecked', function (event) {
            alert("hiii");
                    if (this.value === 1) {
            $('#trEsicNo').show(500);
            } else {
            $('#trEsicNo').hide(500);
            }
            });
            });
            < !--




            $(function(){
//            $('input[name=pfStatus]').on('ifChecked', function (event) {
//                alert("hiii");
//                if (this.value === 1) {
//                    $('#trPfNo').show(500);
//                } else {
//                    $('#trPfNo').hide(500);
            }
            });
    });
            -- ></script>
<script>

            $(function () {
            $(".salary").on('propertychange input', function () {
            var s = 0.0;
                    $("#salaryTotal").val(s);
                    $(".salary").each(function (i) {
            if ($(this).val() !== null && $(this).val() !== "")
            {
            s += parseInt($(this).val());
//                  alert(s);
            }
            });
                    $("#salaryTotal").val(parseInt(s));
            });
            });</script>
<script>
            function validateForm()

            {

            var x = document.getElementById('').value;
                    var atpos = x.indexOf(“@”);
                    var dotpos = x.lastIndexOf(“.”);
                    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length)

            {

            alert(“Please enter a valid email address.”);
                    return false;
            }

            }
</script>
<script type="text/javascript">
    var dt = new Date();
            dt.setFullYear(new Date().getFullYear() - 18);
            var dt1 = new Date();
            dt1.setFullYear(new Date().getFullYear() - 100);
            $('.form_datetime_dob25').datetimepicker({
    //language:  'fr',
    weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            startDate: dt1,
            endDate: dt,
            forceParse: 0
    });</script>

<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
<!--<script src="StorageYard/Plugins/jQuery/jQuery-2.1.4.min.js"></script>-->
<!--============= Move On Last in this Page ===========================-->
<!--<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->
<!--============= Move On Last in this Page =================================-->
<script src="StorageYard/Plugins/jQueryUI/jquery-ui.min.js"></script>
<script src="StorageYard/Plugins/fastclick/fastclick.min.js"></script>
<script src="StorageYard/JS/bootstrap/app.min.js"></script>
<script src="StorageYard/Plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="StorageYard/Plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="StorageYard/Plugins/chartjs/Chart.min.js"></script>
<script src="StorageYard/Plugins/daterangepicker/moment.min.js"></script>
<script src="StorageYard/Plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
<script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="StorageYard/Plugins/iCheck/icheck.min.js"></script>
<script src="StorageYard/JS/JQuery/common.js"></script>
<script src="StorageYard/JS/bootstrap/jquery.tokeninput.js"></script>
<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
</html>
