<%--
    Document   : UserDetail
    Created on : Jan 18, 2016, 9:45:44 AM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Detail</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
            if (flag3) {
                flag3 = false;
                if (passwordVal()) {
                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        function passwordVal() {
            var pass = document.getElementById('password').value;
            if (pass === "") {
                document.getElementById('passError').innerHTML = "- It must not be empty or whitespace";
                return false;
            } else {
                return true;
            }
        }
    </script>
    <script>
        function userName1(val) {
            var abc = document.getElementById("employeeId").value;
            document.getElementById("userName").value = abc;
        }
        function showTxt(info) {
            if (info === "Married") {
                $("#hideInfo1").show(500);
                $("#hideInfo2").show(500);
            } else {
                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
            }
        }
    </script>
    <script>
//        function selectShift(rotationId) {
////            alert('Call Ajax');
//            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
//            $.post("shiftRotationMaster.htm?act=readRotationAjax",
//                    {
//                        rotationId: rotationId
//                    }, function (responseTxt, statusTxt, xhr) {
//                if (statusTxt === "success") {
//                    document.getElementById('shiftMasterId').innerHTML = responseTxt;
//                }
//                if (statusTxt === "error")
//                    alert("Error: " + xhr.status + ": " + xhr.statusText);
//            });
//        }
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
        function buttonFun5() {
            var className = $('#minusId5').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId5').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId5').innerHTML = 'Expand';
            }
        }
        function buttonFun7() {
            var className = $('#minusId7').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId7').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId7').innerHTML = 'Expand';
            }
        }
        //change profile picture.
        function changeButton() {
            var className = document.getElementById("photographUpdate").value;
            if (className != null || className != '') {
//                document.getElementById('imageSrc').innerHTML = "<button naem='updateImg' class='btn btn-primary' onclick='updatePP();'> update</botton>";
                var photographUpdate = document.getElementById("photographUpdate").files[0];
                var userName = '${userName}';
                var fd = new FormData();
                fd.append('userName', '${userName}');
                fd.append('photographUpdate', photographUpdate);
                $.ajax({
                    url: 'employeeMaster.htm?act=displayPicture',
                    data: fd,
                    processData: false,
                    contentType: false,
                    type: 'POST',
                    success: function (result) {
                        $("#photograph").attr("src", result);
                    }
                });
            }
        }

    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role=" ">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="#" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <%--<form:hidden path="userMaster.id"></form:hidden>--%>
            <%--<form:hidden path="id"></form:hidden>--%>
            <%--<form:hidden path="shiftType"></form:hidden>--%>
            <%--<form:hidden path="shiftHoursId"></form:hidden>--%>
            <%--<form:hidden path="shiftRotationDate"></form:hidden>--%>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->
                                <div class="box box-info collapsed-box ">
                                    <div class="box-header">
                                        <h3 class="box-title">Personal Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                            <!--                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Id:</label>
                                                        <form:input path="employeeId" class="form-control"  readonly="true"></form:input>
                                                        <form:errors path="employeeId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Employee Name:</label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Name:</label>
                                                        <form:input path="fatherName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Mother's Name:</label>
                                                        <form:input path="motherName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Date Of Birth:</label>
                                                        <form:input path="dateOfBirthOfEmpFather" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                        <form:errors path="dateOfBirthOfEmpFather" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Mother's Date Of Birth:</label>
                                                        <form:input path="dateOfBirthOfEmpMother" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                        <form:errors path="dateOfBirthOfEmpMother" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Sex:</label>&nbsp;&nbsp;
                                                        <c:if test="${employeeMaster.gender}">
                                                            <input type="text" class="form-control" value="Male" readonly="true"/>

                                                        </c:if>
                                                        <c:if test="${!employeeMaster.gender}">
                                                            <input type="text" class="form-control" value="Female" readonly="true"/>

                                                        </c:if>
                                                        <!--                                                            <fieldset id="group1">
                                                                                                                    form:radiobutton path="gender" value="0"/>Male&nbsp;&nbsp;
                                                                                                                    form:radiobutton path="gender" value="1"/>Female
                                                                                                                </fieldset>-->
                                                        <%--<form:errors path="gender" cssClass="errorDiv"></form:errors>--%>
                                                    </div>

                                                    <div class="col-sm-6">

                                                        <label>Marital Status:</label>
                                                        <c:choose>
                                                            <c:when test="${'Other' eq employeeMaster.maritalStatus}">
                                                                <form:input type="text" path="maritalStatusOthers" class="form-control" readonly="true"/>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <form:input type="text" path="maritalStatus" class="form-control" readonly="true"/>
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <!--                                                        <fieldset id="group2">
                                                                                                                    form:radiobutton path="maritalStatus"  value="UnMarried"/>UnMarried
                                                                                                                    form:radiobutton path="maritalStatus"  value="Married"/>Married
                                                                                                                    form:radiobutton path="maritalStatus" value="Other"/>Other
        
                                                                                                                </fieldset>-->

                                                        <!--                                                        <div style="display: none;" class="col-sm-6" id="otherMaritalStatusId">
                                                                                                                </div>-->

                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Date Of Birth:</label>
                                                        <form:input path="dateOfBirth" id="dob" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                        <form:errors path="dateOfBirth" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-3">
                                                            <label>Photograph:</label>
                                                            <img src="${imgFile}" id="photograph" name="photograph" width="150px" height="150px"/>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <!--                                                        <label>Update Photo:</label>
                                                                                                                <div id="imageSrc">
                                                                                                                    <input type="file" class="form-control" id="photographUpdate" name="photographUpdate" onchange="changeButton();" accept="image/*">
                                                                                                                </div>-->
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Present Address:</label>
                                                        <form:textarea path="presentAddress" class="form-control" readonly="true"></form:textarea>
                                                        <form:errors path="presentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Permanent Address</label>
                                                        <form:textarea path="permanentAddress" class="form-control" readonly="true"></form:textarea>
                                                        <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>City:</label>
                                                        <form:input path="cityOfEmployee" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Blood Groups:</label>
                                                        <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                        <form:input path="bloodGroups" id="bloodGroups" class="form-control" readonly="true"/>
                                                        <!--<option value="Select">--Select--</option>-->
                                                        <%--<form:option value="A+">A+</form:option>--%>
                                                        <%--<form:option value="A-">A-</form:option>--%>
                                                        <%--<form:option value="B+">B+</form:option>--%>
                                                        <%--<form:option value="B-">B-</form:option>--%>
                                                        <%--<form:option value="AB+">AB+</form:option>--%>
                                                        <%--<form:option value="AB-">AB-</form:option>--%>
                                                        <%--<form:o/ption value="O+">O+</form:option>--%>
                                                        <%--<form:op/tion value="O-">O-</form:option>--%>
                                                        <%--</form:select>--%>
                                                    </div>
                                                </div>
                                                <c:choose>
                                                    <c:when test="${'Married' eq employeeMaster.maritalStatus}">
                                                        <div class="form-group" id="hideInfo1" style="display: none;">
                                                            <div class="col-sm-6">
                                                                <label>Spouse Name:</label>
                                                                <form:input path="spouseName" class="form-control"></form:input>
                                                                </div>
                                                                <div class="col-sm-6">
                                                                    <label>Spouse's Date Of Birth:</label>
                                                                <form:input path="dateOfBirthOfEmpSpous" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div id="hideInfo2" style="display: none;">
                                                                <div class="form-group">
                                                                    <div class="col-sm-6">
                                                                        <label>Child Name1:</label>
                                                                    <form:input path="child1" class="form-control" readonly="true"></form:input>
                                                                    </div>
                                                                    <div class="col-sm-6">
                                                                        <label>Child1's Date Of Birth:</label>
                                                                    <form:input path="dateOfBirthOfEmpChilld1" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <div class="col-sm-6">
                                                                        <label>Child Name2:</label>
                                                                    <form:input path="child2" class="form-control" readonly="true"></form:input>
                                                                    </div>
                                                                    <div class="col-sm-6">
                                                                        <label>Child2's Date Of Birth:</label>
                                                                    <form:input path="dateOfBirthOfEmpChild2" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!--</div>-->
                                                    </c:otherwise>
                                                </c:choose>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <!--pesonal detail complete-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Contact Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label >Email Id:</label>
                                                        <form:input path="emailAddress" pattern="[^ @]*@[^ @]*" class="form-control" placeholder="abc@domain.com" required="" readonly="true"></form:input>
                                                        <form:errors path="emailAddress" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Contact No.1:</label>
                                                        <form:input path="contactNo1" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="contactNo1" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Contact No.2:</label>
                                                        <form:input path="contactNo2" id="contactNo1" maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="contactNo2" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Emergency Contact Person:</label>
                                                        <form:input path="emergencyContactPerson" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact No:</label>
                                                        <form:input path="emergencyContactNo"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--contact detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Document Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>PAN Card No.:</label>
                                                        <form:input path="panCard" id="pancard" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="panCard" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label >Passport No.:</label>
                                                        <form:input path="passportNo" id="passportNo" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Passport Issue Date:</label>
                                                            <!--<div class="input-group date form_datetime"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <form:input path="passportIssueDate" class="form-control" size="16" readonly="true"></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        <form:errors path="passportIssueDate" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class=" col-sm-6">
                                                            <label>Passport Expiry Date:</label>
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="passportExpiryDate" class="form-control" size="16" readonly="true"></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Aadhar Card:</label>
                                                        <form:input path="adharCard" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="adharCard" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Any Other Government Document Photo Id Proof:</label>
                                                            <div class="col-sm-6">
                                                            <form:input path="govLicenceName" type="text" class="form-control" placeholder="Photo ID Name" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-6">
                                                            <form:input path="drivingLicence" type="text" class="form-control" placeholder="ID No." readonly="true"></form:input>
                                                            </div>
                                                        </div>

                                                    </div><!-- /.col -->
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Document detail completes here-->
                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Organization Specific Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Official E - Mail ID:</label>
                                                        <form:input path="officeEmailId" id="officeEmailId" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="officeEmailId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Highest Education Details</label>
                                                        <form:input path="highestEducationDetails" id="highestEducationDetails" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="highestEducationDetails" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label>Experience on Date Of Joining: Year:</label>
                                                        <form:input path="experienceYearOnDoj" class="form-control" readonly="true"/>
                                                        <form:errors path="experienceYearOnDoj" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <label>Month:</label>
                                                        <form:input path="experienceMonthOnDoj" class="form-control" readonly="true"/>
                                                        <form:errors path="experienceMonthOnDoj" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Company:</label>
                                                        <form:input path="company" class="form-control" readonly="true"/>
                                                        <form:errors path="company" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Zydex Location:</label>
                                                        <form:select path="zydexLocationMaster.id" class="form-control" disabled="true">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${zydexLocationMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Work Location:</label>
                                                        <form:select path="locationMaster.id" id="locationMaster" class="form-control" disabled="true">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${location}"></form:options>
                                                        </form:select>
                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Level:</label>

                                                        <form:select path="levelMaster.id" id="levelMasterId" class="form-control" disabled="true">
                                                            <form:options items="${level}" ></form:options>
                                                        </form:select>
                                                        <form:errors path="levelMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Department:</label>
                                                        <form:select path="departmentMaster.id" id="departmentMaster" class="form-control" disabled="true">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Designation:</label>
                                                        <form:select path="designationMaster.id" id="designationMaster" class="form-control" disabled="true">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${desigList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Role:</label>
                                                        <form:input path="role" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Date Of Joining:</label>
                                                            <!--<div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">-->
                                                        <form:input path="dateOfJoining" class="form-control" size="16" value="" readonly="true"></form:input>
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                            <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                            <!--</div>-->
                                                        <form:errors path="dateOfJoining" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Last Year's Performance Rating:</label>
                                                        <form:input path="lastYearPerformanceRating" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Type:</label>
                                                        <form:input path="employeeType" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                    </div>
                                    <!--organization detail completes here-->
                                    <div class="box box-info collapsed-box" id="empInfo_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee's Bank Account Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId7">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun7();"><i class="fa fa-plus" id="minusId7"></i></button>
                                            </div>
                                        </div>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Bank Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="bankName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="bankName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Bank Account No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="bankAccountNo" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="bankAccountNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>IFSC Code:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="bankIfscCode" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="bankIfscCode" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <!--bank detail complete-->
                                    <div class="box box-info collapsed-box collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Reporting Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <!--<label class="col-sm-2 control-label" style="float: left;">Reporting Manager:</label>-->
                                                        <!--                                                        <div class="col-sm-12">
                                                                                                                    <label>Reporting Manager:</label>
                                                                                                                </div>-->
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6" id="levelIdDiv1">
                                                            <label>Reporting Manager:</label>
                                                        <form:input path="reportingManagerLevel1" class="form-control" onchange="reportingLevelSet();" readonly="true"></form:input>
                                                        <form:errors path="reportingManagerLevel1" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                    </div>
                                                    <!--                                                    <div class="col-sm-6" id="levelIdDiv2">
                                                                                                            <label>Level 2:</label>
                                                                                                            <input type="text" name="reportingManagerLevel2Name" id="reportingManagerLevel2Name" class="form-control" readonly="true"/>
                                                                                                        </div>
                                                                                                    <div class="form-group">
                                                                                                        <div class="col-sm-6" id="levelIdDiv3">
                                                                                                            <label>Level 3:</label>
                                                                                                            <input type="text" name="reportingManagerLevel3Name" id="reportingManagerLevel3Name" class="form-control" readonly="true"/>
                                                                                                        </div>
                            
                                                                                                        <div class="col-sm-6" id="levelIdDiv4">
                                                                                                            <label>Level 4:</label>
                                                                                                            <input type="text" name="reportingManagerLevel4Name" id="reportingManagerLevel4Name" class="form-control" readonly="true"/>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="form-group" id="levelIdDiv5">
                                                                                                        <div class="col-sm-6">
                                                                                                            <label>Functional Head:</label>
                                                                                                            <input type="text" name="reportingManagerLevel5Name" id="reportingManagerLevel5Name" class="form-control" readonly="true"/>
                                                                                                        </div>
                            
                                                                                                        <div class="col-sm-6" id="levelIdDiv6">
                                                                                                            <label>CEO/Proprietor/MD:</label>
                                                                                                            <input type="text" name="reportingManagerLevel6Name" id="reportingManagerLevel6Name" class="form-control" readonly="true"/>
                                                                                                        </div>
                                                                                                    </div>-->
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>


                                    <div class="form-group">
                                        <div class=" col-sm-12" style="text-align: center;">
                                            <button class="btn btn-primary" onclick="history.back();" style="width: 100px;">BACK</button>
                                        </div>
                                    </div>

                                    <div class="tab-pane" id="tab_3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
        </form:form>
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });</script>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            var reportingManagerString = '${preList}';
            var reportingManagerStringSplitArray = reportingManagerString.split('name: "');
            var reportingManager = reportingManagerStringSplitArray[1].split('"')[0];
            var reportingManagerId = reportingManager.split('/')[0];
            document.getElementById("reportingManagerLevel1").value = reportingManager;
            //        alert("this is result String    " + reportingMana);
            reportingLevelSet(reportingManagerId);
            //            jQuery("#reportingManagerLevel1").val() = reportingManager;
        });




        //when document loaded it loads based on erlier reporting manager
        function reportingLevelSet(reportingManagerId) {
            var level = reportingManagerId;

            if (level != null && level != '') {
                $.ajax({
                    url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
                    type: 'GET',
                    success: function (result) {
                        var array = result.split("~");
                        //                        document.getElementById("reportingManagerLevel2").value = array[0];
                        //                        document.getElementById("reportingManagerLevel3").value = array[1];
                        //                        document.getElementById("reportingManagerLevel4").value = array[2];
                        ////this conditions checks for level 5 and level 6 if these are empty then set conditional values(for id in databese)
                        //                        if ((array[4] == "" || array[4] == null) && (array[5] == "" || array[5] == null)) {
                        //                            if (array[2] == "" || array[2] == null) {
                        //                                document.getElementById("reportingManagerLevel6").value = level;
                        //                            } else {
                        //                                document.getElementById("reportingManagerLevel5").value = level;
                        //                                document.getElementById("reportingManagerLevel6").value = array[2];
                        //                            }
                        //                        } else {
                        //                            document.getElementById("reportingManagerLevel5").value = array[4];
                        //                            document.getElementById("reportingManagerLevel6").value = array[5];
                        //                        }
                        document.getElementById("reportingManagerLevel2Name").value = array[6];
                        document.getElementById("reportingManagerLevel3Name").value = array[7];
                        document.getElementById("reportingManagerLevel4Name").value = array[8];
                        //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for values display on jsp)
                        if ((array[10] == "" || array[10] == null) && (array[11] == "" || array[11] == null)) {
                            if (array[6] == "" || array[6] == null) {
                                document.getElementById("reportingManagerLevel6Name").value = array[12];
                                //array[12] is for employee name od reporting manager.
                            } else {
                                document.getElementById("reportingManagerLevel5Name").value = array[12];
                                document.getElementById("reportingManagerLevel6Name").value = array[6];
                            }
                        } else {
                            document.getElementById("reportingManagerLevel5Name").value = array[10];
                            document.getElementById("reportingManagerLevel6Name").value = array[11];
                        }
                    }
                });

            }
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('input[name=maritalStatus]').on('ifChecked', function (event) {
            if (this.value === "Married") {
                $("#hideInfo1").show(500);
                $("#hideInfo2").show(500);
                $("#otherMaritalStatusId").hide(500);
            } else {

                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").hide(500);
            }
            if (this.value === "Other") {
                $("#hideInfo1").hide(500);
                $("#hideInfo2").hide(500);
                $("#otherMaritalStatusId").show(500);
            }

        });
        $('#gender1').iCheck('check');
    </script>



</html>


