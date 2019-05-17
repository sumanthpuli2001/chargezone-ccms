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
        <title>Former Employee Details</title>
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
        if (typeof FileReader !== "undefined") {
        var fileSize = document.getElementById('photographUpdate').files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 102400) {
        document.getElementById('photographUpdate').value = '';
                document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
        } else {
        document.getElementById('photographError').innerHTML = '';
                var photographUpdate = document.getElementById("photographUpdate").files[0];
                var userName = '${param.userid}';
                var fd = new FormData();
                fd.append('userName', '${param.userid}');
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
        // check file size
        }

        }
        }

    </script>
    <script type="text/javascript" language="javascript">
        function checkfile(sender) {

        $('#saveSubmit2').show();
                var validExts = new Array(".jpg", ".jpeg", ".png");
                var fileExt = sender.value;
                fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
                if (validExts.indexOf(fileExt) < 0) {
        alert("Invalid file selected, valid files are of " +
                validExts.toString() + " types.");
                document.getElementById('file11').value = '';
                return false;
                $("#uploadDiv").hide();
        }
        else {
        $("#uploadDiv").show();
                return true;
        }
        }
    </script>
    <script>
        var i1 = 1;
                $(function () {
                $("#step1cloneid").on("click", function () {
                i1 = document.getElementById("firstStepCount").value;
                        i1++; if (i1 <= 8) {
                var clone = "<tr id='cloneTr_Id" + i1 + "'>"
                        + "<td style=\"text-align: center\">" + i1 + "</td>"
                        + "<td><input type=\"file\" class=\"form-control\" accept='image/jpg,image/jpeg,image/png' id='certificateId" + i1 + "' name='certificateId" + i1 + "' onchange='checkCertificateFileSize(" + i1 + ")'/></td>" + "<td style=\"text-align: center\"><input type =\"button\" value=\"-\" onclick=\"removeStep1Tr('cloneTr_Id" + i1 + "');\"/>"
                        + "</tr>";
                        $("#table_1").append(clone);
                        document.getElementById("firstStepCount").value = i1;
                }
                });
                });
                function removeStep1Tr(cloneTr_Id) {
                try {
                i1--;
                        var val = document.getElementById("firstStepCount").value;
                        val = val - 1;
                        document.getElementById("firstStepCount").value = val;
                        var element1 = document.getElementById(cloneTr_Id);
                        element1.parentNode.removeChild(element1);
                } catch (e) {

                }


                }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>FORMER EMPLOYEE DETAILS</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Former employee Details</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role=" ">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=editSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <form:hidden path="userMaster.id"></form:hidden>
            <form:hidden path="id"></form:hidden>
            <form:hidden path="shiftType"></form:hidden>
            <form:hidden path="shiftHoursId"></form:hidden>
            <form:hidden path="shiftRotationDate"></form:hidden>
            <input type="hidden" name="mariStatus" id="mariStatus" value="${maritalStatus}">

            <input type="hidden" name="empOwnProfile" id="empOwnProfile" value="1">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:forEach var="list" items="${employeeMasterExtensionList}">
                                <!--form horizontal starts here-->
                                <div class="box box-info collapsed-box ">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Official Details:</h3>
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
                                                        <label>Employee No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeId" class="form-control"  readonly="true"></form:input>
                                                        <form:errors path="employeeId" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeName" class="readItOnly form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Date Of Joining:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="dateOfJoining" class="form-control" size="16" value="" readonly="true" style="pointer-events: none; cursor: default;" ></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Date Of Birth:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="dateOfBirth" id="dob" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" style="pointer-events: none; cursor: default;" ></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">    
                                                        <div class="col-sm-6">
                                                            <label>Department:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="employeeTypeMaster.id" id="employeeTypeMaster.id" onchange="selectsubtype(this.value);" class="form-control" style="pointer-events: none; cursor: default;">
                                                            <form:option value="None" label="-- Select --" ></form:option>
                                                            <form:options items="${EmployeeTypeList}"></form:options>
                                                        </form:select>
                                                        </div>
                                                        <div class="col-sm-6" id="employeeSubTypeId">
                                                            <label>Division:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                                        <form:select path="employeeSubType.id" class="form-control" style="pointer-events: none; cursor: default;">
                                                            <form:option value="" label="-- Select --" ></form:option> 
                                                            <form:options items="${EmployeeSubTypeList}"></form:options>
                                                        </form:select>
                                                        </div>    
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Designation:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <select name="designationMasterByLevelId" id="designationMasterByLevelId" class="form-control" onchange="setDesignation()" style="pointer-events: none;">
                                                            <c:forEach var="desn" items="${desigList}">
                                                                <c:if test="${desn['key'] eq employeeMaster.designationMaster.id}">
                                                                    <option value="${desn['key']}" label="${desn['value']}" selected="true"></option>
                                                                </c:if>
                                                            </c:forEach>
                                                            <%--<form:options items="${desigList}"></form:options>--%>
                                                        </select>
                                                        <form:hidden path="designationMaster.id" class="form-control"></form:hidden>

                                                        <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Gender:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                            <fieldset id="group1">

                                                            <form:radiobutton path="gender" value="false"/>Male&nbsp;&nbsp;
                                                            <form:radiobutton path="gender" value="true" />Female&nbsp;&nbsp;

                                                        </fieldset>
                                                        <form:errors path="gender" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    

                                                    <div class="form-group">
                                                        
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Marital Status:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset id="group2">
                                                            <form:radiobutton path="maritalStatus"  value="Married"/>Married
                                                            <form:radiobutton path="maritalStatus"  value="UnMarried"/>UnMarried
                                                            <form:radiobutton path="maritalStatus" value="Other"/>Other

                                                        </fieldset>

                                                        <div style="display: none;" class="col-sm-6" id="otherMaritalStatusId">
                                                            <form:input type="text" path="maritalStatusOthers" class="form-control"/>
                                                        </div>

                                                    </div>
                                                    <div class="col-sm-3">
                                                            <label>Photograph:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <img src="${imgFile}" id="photograph" name="photograph" width="150px" height="150px"/>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <label>Update Photo:</label>
                                                        <div id="imageSrc">
                                                            <input type="file" class="form-control" id="photographUpdate" name="photographUpdate" onchange="checkfile(this);
                                                                                changeButton();" accept="image/jpg,image/jpeg,image/png">
                                                            <span style="font-size: 14px; color: red;" id="photographError"></span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Official E - Mail ID:</label>
                                                            <form:input path="officeEmailId" id="officeEmailId" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="officeEmailId" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.box-body -->

                                <!--pesonal detail complete-->
                                
                                <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Legal Documents:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Employee Name (First Name, Middle Name, Last Name as per Aadhar card)<span style="color: red;font-size: 12px;">*</span></label>

                                                        </div>
                                                        
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>PAN Card No:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="panCard" class="form-control"  style="text-transform: uppercase" placeholder="(1-5: alphabets, 6-9: digits, 10th: alphabet) Example: ASDFG4567A" readonly="true"></form:input>
                                                        <form:errors path="panCard" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Nationality:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="nationality" id="nationality" value="${list.nationality}" readonly="true" style="text-transform:uppercase" class="form-control">

                                                        </div>

                                                    </div>  

                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>First Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="firstName" id="firstName" value="${list.firstName}" class="form-control" readonly="true">
                                                            <span style="font-size: 14px; color: red;" id="firstNameError"></span>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Middle Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="middleName" id="middleName" value="${list.middleName}" class="form-control" readonly="true">
                                                            <span style="font-size: 14px; color: red;" id="middleNameError"></span>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">

                                                        <div class="col-sm-6">

                                                            <label>Last Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" name="lastName" id="lastName" value="${list.lastName}" class="form-control" readonly="true">
                                                            <span style="font-size: 14px; color: red;" id="lastNameError"></span>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label >Driving Licence No:</label>
                                                            <!--<input type="text" name="drivingLicence" id="drivingLicence" value="" class="form-control" readonly="true">-->
                                                            <form:input path="drivingLicence" type="text" class="form-control" placeholder="Please Specify No." readonly="true"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Driving Licence Type:<span style="color: red;font-size: 12px;"></span></label>
                                                            <select name="drivingLicenceType" id="drivingLicenceType" class="form-control">
                                                                <c:if test="${empty list.drivingLicenceType}">
                                                                <option value="">-- Select --</option>
                                                                <option value="2Wheeler">2Wheeler</option>
                                                                <option value="4Wheeler">4Wheeler</option>
                                                                <option value="Both">Both</option>

                                                            </c:if>
                                                            <c:if test="${!empty list.drivingLicenceType}">
                                                                <option <c:choose><c:when test="${list.drivingLicenceType eq '2Wheeler'}"> value="2Wheeler" selected="true"</c:when><c:otherwise>value="2Wheeler"</c:otherwise></c:choose>>2 Wheeler</option>
                                                                <option <c:choose><c:when test="${list.drivingLicenceType eq '4Wheeler'}"> value="4Wheeler" selected="true"</c:when><c:otherwise>value="4Wheeler"</c:otherwise></c:choose>>4 Wheeler</option>
                                                                <option <c:choose><c:when test="${list.drivingLicenceType eq 'Both'}"> value="Both" selected="true"</c:when><c:otherwise>value="Both"</c:otherwise></c:choose>>Both</option>
                                                            </c:if>
                                                            </select>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Aadhar Card:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="adharCard" id="adharCard" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="adharCard"  cssClass="errorDiv"></form:errors>
                                                        <span style="font-size: 14px; color: red;" id="adharCardError"></span>
                                                        </div>
                                                        
                                                    </div>


                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                
                                                        
                                 <div class="box box-info collapsed-box" id="personal_Detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Personal Contact Details:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button  class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId10">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun10();"><i class="fa fa-plus" id="minusId10" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Personal Email Id:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="emailAddress" pattern="[^ @]*@[^ @]*" class="form-control" readonly="true" placeholder="abc@domain.com" required=""></form:input>

                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Contact No.1:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="contactNo1" id="contactNo1" maxlength="14" readonly="true" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="contactNo1" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Contact No.2:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="contactNo2" id="contactNo2" maxlength="14" readonly="true" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                        <form:errors path="contactNo2" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Blood Group:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                        <form:select path="bloodGroups" id="bloodGroups" class="form-control ">
                                                            <option value="">--Select--</option>
                                                            <form:option value="A +ve">A +ve</form:option>
                                                            <form:option value="A -ve">A -ve</form:option>
                                                            <form:option value="B +ve">B +ve</form:option>
                                                            <form:option value="B -ve">B -ve</form:option>
                                                            <form:option value="AB +ve">AB +ve</form:option>
                                                            <form:option value="AB -ve">AB -ve</form:option>
                                                            <form:option value="O +ve">O +ve</form:option>
                                                            <form:option value="O -ve">O -ve</form:option>
                                                        </form:select>
                                                    </div>

                                                </div>
                                                <div class="form-group">
<!--                                                    <div class="col-sm-6">

                                                        <label>Religion:</label>
                                                        <input type="text" name="religion" id="religion" class="form-control">
                                                    </div>-->
                                                    <div class="col-sm-6">

                                                        <label>Languages known:</label>
                                                        <input type="text" name="languagesKnown" id="languagesKnown" value="${list.languagesKnown}" readonly="true" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Disclosed Health Concerns:</label>
                                                        <input type="text" name="disclosedHealthConcerns" id="disclosedHealthConcerns" value="${list.disclosedHealthConcerns}" readonly="true" class="form-control">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    
                                                    <div class="col-sm-6">

                                                        <label>Hobbies:</label>
                                                        <input name="hobbies" id="hobbies" value="${list.hobbies}" readonly="true" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Highest Education Details:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="highestEducationDetails" id="highestEducationDetails" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                </div>

                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                                        
                                <div class="box box-info collapsed-box" id="document_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Family Background:</h3>
                                            <div class="box-tools pull-right">
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Father's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="fatherName" class=" form-control" readonly="true"></form:input>
                                                        <form:errors path="fatherName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Father's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                            <form:input path="dateOfBirthOfEmpFather" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                        
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Mother's Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="motherName" class=" form-control" readonly="true"></form:input>
                                                        <form:errors path="motherName" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none;">
                                                            <label>Mother's Date Of Birth:</label>
                                                            <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                            <form:input path="dateOfBirthOfEmpMother" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        <form:errors path="dateOfBirthOfEmpMother" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div id="hideInfo1" style="display: none;margin-left: 2px;">
                                                        <div class="form-group" id="">
                                                            <div class="col-sm-6">
                                                                <label>Spouse Name:</label>
                                                            <form:input path="spouseName" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6" style="pointer-events: none;">
                                                                <label>Spouse's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime_dob" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpSpous" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">

                                                                <label>Spouse's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group10">
                                                                    <input type="radio" name="SpouseGender" id="SpouseGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="SpouseGender" id="SpouseGender" value="true"/>Female
                                                                </fieldset>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>  

                                                    <div id="hideInfo2" style="display: none;margin-left: 2px;">
                                                        <div class="form-group" id="">

                                                            <div class="col-sm-6">
                                                                <label>Child Name1:</label>
                                                            <form:input path="child1" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6" style="pointer-events: none;">
                                                                <label>Child1's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpChilld1" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6" cssStyle="pointer-events: none;">

                                                                <label>Child1's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group6">
                                                                    <input type="radio" name="childOneGender" id="childOneGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="childOneGender" id="childOneGender" value="true"/>Female
                                                                </fieldset>
                                                            </div> 
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">
                                                                <label>Child Name2:</label>
                                                            <form:input path="child2" class="form-control"></form:input>
                                                            </div>
                                                            <div class="col-sm-6" style="pointer-events: none;">
                                                                <label>Child2's Date Of Birth:</label>
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">

                                                                <form:input path="dateOfBirthOfEmpChild2" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                            
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-6">

                                                                <label>Child2's Gender:<span style="color: red;font-size: 12px;"></span></label>&nbsp;&nbsp;
                                                                <fieldset id="group6">
                                                                    <input type="radio" name="childTwoGender" id="childTwoGender" checked="true" value="false"/>Male&nbsp;&nbsp;
                                                                    <input type="radio" name="childTwoGender" id="childTwoGender" value="true"/>Female
                                                                </fieldset>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Present Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:textarea path="presentAddress" class="form-control" readonly="true"></form:textarea>
                                                        <form:errors path="presentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <form>
                                                                <label>Street/Road/Area:<span style="color: red;font-size: 12px;">*</span></label>

                                                                <textarea name="presentAddress2" id="presentAddress2" readonly="true"  class="form-control">${list.presentAddress2}</textarea>
                                                            </form>
                                                        <%--  <form:errors path="" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                        <label>Present City:</label>
                                                        <input type="text" name="presentCity" id="presentCity" readonly="true" value="${list.presentCity}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Present State:</label>
                                                        <input type="text" name="presentState" id="presentState" readonly="true" value="${list.presentState}" class="form-control">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">

                                                        <label>Present Postal Code:</label>
                                                        <input type="text" name="presentPostalCode" id="presentPostalCode" readonly="true" value="${list.presentPostalCode}" class="form-control">

                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>Present Country:</label>
                                                        <input type="text" name="presentCountry" id="presentCountry" readonly="true" value="${list.presentCountry}" class="form-control">

                                                    </div>
                                                </div>             

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Permanent Address:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:textarea path="permanentAddress" class="form-control" readonly="true"></form:textarea>
                                                        <form:errors path="permanentAddress" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Street/Road/Area:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <!--                                                            <input type="textarea" name="permanentAddress2" id="permanentAddress2" class="form-control">-->
                                                            <textarea name="permanentAddress2" id="permanentAddress2" readonly="true" class="form-control">${list.permanentAddress2}</textarea>

                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Permanent City:</label>
                                                            <input type="text" name="permanentCity" id="permanentCity" readonly="true" value="${list.permanentCity}" class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Permanent State:</label>
                                                            <input type="text" name="permanentState" id="permanentState" readonly="true" value="${list.permanentState}" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Permanent Postal Code:</label>
                                                            <input type="text" name="permanentPostalCode" id="permanentPostalCode" readonly="true" value="${list.permanentPostalCode}" class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">

                                                            <label>Permanent Country:</label>
                                                            <input type="text" name="permanentCountry" id="permanentCountry" readonly="true" value="${list.permanentCountry}" class="form-control">

                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-6">
                                                            <label>Emergency Contact No:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="emergencyContactNo" readonly="true"  maxlength="14" data-fv-numeric="true" data-fv-numeric-message="Please enter valid number" data-fv-phone-country11="IN" class="form-control"></form:input>
                                                            <form:errors path="emergencyContactNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label >Emergency Contact Person:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="emergencyContactPerson" readonly="true" class="form-control"></form:input>
                                                            <form:errors path="emergencyContactPerson" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">

                                                            <label>Relationship:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="RelationShip" id="RelationShip" readonly="true" value="${list.relationShip}" maxlength="14" class="form-control" >

                                                        </div>

                                                        <div class="col-sm-6">

                                                            <label>Emergency Contact Address:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="emergencyContactAddress"  id="emergencyContactAddress" readonly="true" value="${list.emergencyContactAddress}"  maxlength="14" class="form-control">

                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        
                                                        <div class="col-sm-6">

                                                            <label>Other important information relating to your emergency contact:<span style="color: red;font-size: 12px;"></span></label>
                                                            <input type="text" name="otherImpInfo" readonly="true" value="${list.otherImpInfo}" id="otherImpInfo" class="form-control">

                                                        </div> 
                                                    </div>


                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Organization Specific Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4"></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Name of Previous company:</label>
                                                            <input type="text" name="nameOfPreviousCompany" id="nameOfPreviousCompany" readonly="true" value="${list.nameOfPreviousCompany}" class="form-control">

                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Previous Company Location:</label>
                                                            <input type="text" name="previousCompanyLocation" id="previousCompanyLocation" readonly="true" value="${list.previousCompanyLocation}" class="form-control">

                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                            <div class="col-sm-6" style="pointer-events: none">
                                                                <label>Exp. on Date Of Joining:  Year:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="experienceYearOnDoj" class="form-control ">
                                                                <c:forEach begin="0" end="50" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceYearOnDoj" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-6" style="pointer-events: none">
                                                                <label>Exp. on Date Of Joining: Month:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <form:select path="experienceMonthOnDoj" class="form-control">
                                                                <c:forEach begin="0" end="11" var="counter">
                                                                    <form:option value="${counter}">${counter}</form:option>
                                                                </c:forEach>
                                                            </form:select>
                                                            <form:errors path="experienceMonthOnDoj" cssClass="errorDiv"></form:errors>
                                                            </div>

                                                        
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label >Company:</label>
                                                        <form:input path="company" class=" form-control" cssStyle="pointer-events: none;"></form:input>
                                                        <form:errors path="company" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label> Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="zydexLocationMaster.id" class="form-control" cssStyle="pointer-events: none;">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${zydexLocationMap}"></form:options>
                                                        </form:select>
                                                        <form:hidden path="zydexLocationMaster.id"/>

                                                        <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Level:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <form:select path="levelMaster.id" class="form-control" onchange="getDesignation();" cssStyle="pointer-events: none;">
                                                            <form:options items="${level}" ></form:options>
                                                        </form:select>

                                                        <form:errors path="levelMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Work Location:<span style="color: red;font-size: 12px;">*</span></label>


                                                        <form:select path="locationMaster.id" class="form-control" cssStyle="pointer-events: none;">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${location}"></form:options>
                                                        </form:select>

                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        

                                                        <div class="col-sm-6">
                                                            <label>Business Unit:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="departmentMaster.id" class="form-control" cssStyle="pointer-events: none;">
                                                            <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>

                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Type of Employment:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="employeeType" id="employeeType" class="form-control" cssStyle="pointer-events: none;">
                                                            <form:option value="Probation" label="Probation"></form:option>
                                                            <form:option value="Confirmed" label="Confirmed"></form:option>
                                                            <form:option value="Interns" label="Interns"></form:option>
                                                        </form:select>
                                                    </div>
                                                    </div>

                                                    <div class="form-group">
                                                        

                                                        <div class="col-sm-6">
                                                            <label>Role:</label>
                                                        <form:input path="role" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none">
                                                            <label>Work Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="shiftType" class="form-control">
                                                            <!--<option value="">--SELECT--</option>-->
                                                            <form:option value="" label="-- Select --" ></form:option>
                                                            <form:option value="HourlyBase" label="Hourly Base"></form:option>
                                                            <form:option value="ShiftBase" label="Shift Base"></form:option>
                                                        </form:select>
                                                        <form:errors path="shiftType" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">

                                                        <div class="col-sm-6">
                                                            <label>Last Year's Performance Rating:</label>
                                                            <input type="text" class="form-control" value="${lastYearPerformanceRatingsOfEmployee}" readonly="true">
                                                        <%--<form:hidden path="lastYearPerformanceRating" class="form-control"></form:input>--%>
                                                    </div>
                                                </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Basic Salary:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="basicSalary" class="form-control" style="pointer-events: none;"/>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>ESIC.No:<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="esicNo" class="form-control" style="pointer-events: none;"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>PF Contribution(By Employee):<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="pfAmount" class="form-control" style="pointer-events: none;"></form:input>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>PF Contribution(By Employer):<span style="color: red;font-size: 12px;"></span></label>
                                                            <form:input path="pfAmountEmployer" class="form-control" style="pointer-events: none;"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-4">
                                                            <label>Provident Fund:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <fieldset>
                                                            <form:radiobutton path="pf" readonly="true"   value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="pf" readonly="true" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Provident Tax:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset>
                                                            <form:radiobutton path="pt"  readonly="true" value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="pt" readonly="true" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>ESIC:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="esic" readonly="true" value="false"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="esic" readonly="true" value="true"/>YES
                                                        </fieldset>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-4">
                                                        <label>Salary Base:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="salaryBase" readonly="true" value="false" checked="checked"/>Month&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="salaryBase" readonly="true" value="true"/>Day
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>OT:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <fieldset>
                                                            <form:radiobutton path="ot" readonly="true" value="false" checked="checked"/>YES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="ot" readonly="true" value="true"/>NO
                                                        </fieldset>
                                                    </div>
                                                    <div class="col-sm-4">
                                                        <label>Odd Punch Required:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <fieldset>
                                                            <form:radiobutton path="oddPunch" readonly="true" value="false" checked="checked"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="oddPunch" readonly="true" value="true"/>YES
                                                        </fieldset>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select Allowance</th>
                                                                <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                    <c:choose>
                                                                        <c:when test="${not empty finalPolicyList}">
                                                                    <input type="hidden" name="policyCount" id="policyCount"  value="${fn:length(finalPolicyList)}"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="policyCount" id="policyCount"  value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty finalPolicyList}">
                                                                    <c:forEach var="comp" items="${finalPolicyList}" varStatus = "countVal">
                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalPolicyList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><div>
                                                                                    <select id="policyId${countVal.count}"  style="pointer-events: none;" name="policyId${countVal.count}"  class="form-control">
                                                                                        <option value="" >--SELECT-- ${comp[5]}</option>
                                                                                        <c:forEach var="policyData" items="${policy}" varStatus = "status">
                                                                                            <c:choose>
                                                                                                <c:when test="${comp[1] == policyData.value}">
                                                                                                    <option value="${policyData.key}" selected="selected">${comp[1]}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${policyData.key}"  >${policyData.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="policyError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--</td>-->
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <input type="text" name="policyNumber${countVal.count}" id="policyNumber${countVal.count}"  class="form-control"  value="${comp[2]}">
                                                                                                                                                        </td>-->
                                                                            <td style="text-align: center">
                                                                                <input type="number" name="amount${countVal.count}" style="pointer-events: none;" id="amount${countVal.count}" min="0" class="form-control" value="${comp[3]}">
                                                                            </td>

                                                                            <c:if test="${comp[4] eq 1}">

                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" style="pointer-events: none;" id="taxable${countVal.count}" checked="true">
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[4] ne 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" style="pointer-events: none;" id="taxable${countVal.count}" >
                                                                                </td>
                                                                            </c:if>
                                                                            <td style="text-align: center">
                                                                                <%--<c:choose>--%>
                                                                                <%--<c:when test="${countVal.first}">--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="+" id="policyCloneid" />-->
                                                                                <!--</span>-->
                                                                                <%--</c:if>--%>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="-" id="policyRemoveid" onclick="removeForEdit()"/>-->
                                                                                <!--</span>-->
                                                                                <%--</c:otherwise>--%>
                                                                                <%--</c:choose>--%>
                                                                                <c:if test="${countVal.last}">
                                                                                    <c:if test="${countVal.last}">
                                                                                        <span style='margin-top: 5px;'>
                                                                                            <input type="button" value="+" id="policyCloneid" />
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:if>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <tr>
                                                                        <td colspan="5" style="text-align: center;">No Data Found</td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                    </div>
                                                </div>
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table-responsive">
                                                        <table id="ctcTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <tr>
                                                                <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                                <th style="text-align: center; vertical-align: middle">Select CTC</th>
                                                                <!--<th style="text-align: center; vertical-align: middle">Policy Number</th>-->
                                                                <th style="text-align: center; vertical-align: middle">Amount</th>
                                                                <th style="text-align: center; vertical-align: middle">Taxable</th>
                                                                <th style="text-align: center; vertical-align: middle">Month</th>
                                                                <th style="text-align: center; vertical-align: middle">Year</th>
                                                                <th style="text-align: center; vertical-align: middle">Add New</th>
                                                                    <c:choose>
                                                                        <c:when test="${not empty finalPolicyList}">
                                                                    <input type="hidden" name="ctcCount" id="ctcCount"  value="${fn:length(finalctcList)}"/>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="hidden" name="ctcCount" id="ctcCount"  value="1"/>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            </tr>
                                                            <c:choose>
                                                                <c:when test="${not empty finalctcList}">
                                                                    <c:forEach var="comp" items="${finalctcList}" varStatus = "countVal">
                                                                        <input type="hidden" name="countSecond" id="countSecond" value="${fn:length(finalctcList)}"/>
                                                                        <tr>
                                                                            <td style="text-align: center">${countVal.count}</td>
                                                                            <td><div>
                                                                                    <select id="ctcId${countVal.count}"  style="pointer-events: none;" name="ctcId${countVal.count}"  class="form-control">
                                                                                        <option value="">--SELECT--</option>
                                                                                        <c:forEach var="policyData" items="${ctc}" varStatus = "status">
                                                                                            <c:choose>
                                                                                                <c:when test="${comp[1] == policyData.value}">
                                                                                                    <option value="${policyData.key}" selected="selected">${comp[1]}</option>
                                                                                                </c:when>
                                                                                                <c:otherwise>
                                                                                                    <option value="${policyData.key}" >${policyData.value}</option>
                                                                                                </c:otherwise>
                                                                                            </c:choose>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <span id="ctcError${countVal.count}" style="color: red;"></span>
                                                                            </td>
                                                                            <!--</td>-->
                                                                            <!--                                                                            <td style="text-align: center">
                                                                                                                                                            <input type="text" name="policyNumber${countVal.count}" id="policyNumber${countVal.count}"  class="form-control"  value="${comp[2]}">
                                                                                                                                                        </td>-->
                                                                            <td style="text-align: center">
                                                                                <input type="number" name="ctcamount${countVal.count}" style="pointer-events: none;" id="ctcamount${countVal.count}" min="0" class="form-control" value="${comp[2]}">
                                                                            </td>
                                                                            <c:if test="${comp[3] eq 1}">

                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" checked="true">
                                                                                </td>
                                                                            </c:if>
                                                                            <c:if test="${comp[3] ne 1}">
                                                                                <td style="text-align: center">
                                                                                    <input type="checkbox" name="taxable${countVal.count}" id="taxable${countVal.count}" >
                                                                                </td>
                                                                            </c:if>
                                                                            <td ><div>
                                                                                    <!--<label>Months:<span style="color: red;font-size: 12px;">*</span></label>-->
                                                                                    <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                                                                    <select id="month${countVal.count}"  style="pointer-events: none;" name="month${countVal.count}"  class="form-control ">

                                                                                        <c:choose>

                                                                                            <c:when test="${comp[4] eq 01}">
                                                                                                <!--<option value="01" selected="selected">January</option>-->
                                                                                                <option value="01" selected="selected">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 02}">
                                                                                                <!--<option value="02" selected="selected">February</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02" selected="selected">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 03}">
                                                                                                <!--<option value="03" selected="selected">March</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03" selected="selected">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 04}">
                                                                                                <!--<option value="04" selected="selected">April</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04" selected="selected">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 05}">
                                                                                                <!--<option value="05" selected="selected">May</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05" selected="selected">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 06}">
                                                                                                <!--<option value="06" selected="selected">June</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06" selected="selected">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 07}">
                                                                                                <!--<option value="07" selected="selected">July</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07" selected="selected">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 08}">
                                                                                                <!--<option value="08" selected="selected">August</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08" selected="selected">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 09}">
                                                                                                <!--<option value="09" selected="selected">September</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09" selected="selected">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 10}">
                                                                                                <!--<option value="10" selected="selected">October</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10" selected="selected">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 11}">
                                                                                                <!--<option value="11" selected="selected">November</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11" selected="selected">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${comp[4] eq 12}">
                                                                                                <!--<option value="12" selected="selected">December</option>-->
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12" selected="selected">December</option>
                                                                                            </c:when>
                                                                                            <c:when test="${empty comp[4] }">
                                                                                                <option value="">--Select--</option>
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:when>
                                                                                            <c:otherwise>
                                                                                                <option value="">--Select--</option>
                                                                                                <option value="01">January</option>
                                                                                                <option value="02">February</option>
                                                                                                <option value="03">March </option>
                                                                                                <option value="04">April</option>
                                                                                                <option value="05">May</option>
                                                                                                <option value="06">June</option>
                                                                                                <option value="07">July</option>
                                                                                                <option value="08">August</option>
                                                                                                <option value="09">September</option>
                                                                                                <option value="10">October </option>
                                                                                                <option value="11">November </option>
                                                                                                <option value="12">December</option>
                                                                                            </c:otherwise>
                                                                                        </c:choose>


                                                                                    </select>
                                                                                </div>
                                                                            </td>
                                                                            <td ><div>
                                                                                    <!--<td style="text-align: center">-->
                                                                                    <input  type="hidden" class="form-control" id="yearBase" value="${comp[5]}">
                                                                                    <select name="year1" id="year1"  style="pointer-events: none;" class="form-control" >
                                                                                        <option  name="year1" id="year1"  value="${comp[5]}">${comp[5]}</option> 

                                                                                    </select> 
                                                                                </div>
                                                                            </td>
                                                                            <td style="text-align: center">
                                                                                <%--<c:choose>--%>
                                                                                <%--<c:when test="${countVal.first}">--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="+" id="policyCloneid" />-->
                                                                                <!--</span>-->
                                                                                <%--</c:if>--%>
                                                                                <%--</c:when>--%>
                                                                                <%--<c:otherwise>--%>
                                                                                <!--<span style='margin-top: 5px;'>-->
                                                                                <!--<input type="button" value="-" id="policyRemoveid" onclick="removeForEdit()"/>-->
                                                                                <!--</span>-->
                                                                                <%--</c:otherwise>--%>
                                                                                <%--</c:choose>--%>
                                                                                <c:if test="${countVal.last}">
                                                                                    <c:if test="${countVal.last}">
                                                                                        <span style='margin-top: 5px;'>
                                                                                            <input type="button" value="+" id="ctcCloneid" />
                                                                                        </span>
                                                                                    </c:if>
                                                                                </c:if>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                </c:when>
                                                                <c:otherwise>

                                                                    <tr>
                                                                        <td colspan="5" style="text-align: center;">No Data Found</td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </table>
                                                    </div>
                                                </div>

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
                                                        <label>Bank Name:</label>
                                                        <form:input path="bankName" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="bankName" cssClass="errorDiv"></form:errors>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <label>Bank Account No.:</label>
                                                        <form:input path="bankAccountNo" class="form-control" readonly="true"></form:input>
                                                        <form:errors path="bankAccountNo" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>IFSC Code:</label>
                                                        <form:input path="bankIfscCode" class="form-control" readonly="true" placeholder="(1-4: alphabets, 5th: reserved as 0, 6-11: digits) Example: SBIN0898965"></form:input>
                                                        <form:errors path="bankIfscCode" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                        <div class="col-sm-6" style="pointer-events: none">
                                                            <label>Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:select path="paymentType" id="paymentType" class="form-control ">
                                                            <option value="">--Select--</option>
                                                            <form:option value="Bank">Bank</form:option>
                                                            <form:option value="Check">Check</form:option>

                                                        </form:select>
                                                    </div>
                                                    </div>
                                                    <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>PF No(Previous):<span style="color: red;font-size: 12px;"></span></label>
                                                    <form:input path="pfNo" id="pfNo" readonly="true" class="form-control"></form:input>
                                                            <%--<form:errors path="pfNo" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                    <div class="col-sm-6">

                                                        <label>PF No(VNC):<span style="color: red;font-size: 12px;"></span></label>
                                                        <input type="text" name="pfNoFlydocs" id="pfNoFlydocs" value="${list.pfNoFlydocs}" readonly="true" class="form-control">

                                                    </div>  
                                                </div>  
                                                <div class="form-group">
                                                    <div class="col-sm-6" style="pointer-events: none">

                                                        <label>PF Withdrawal Date:</label>
                                                        <div class="input-group date form_datetime_passport_issue"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <input type="text" name="withdrawalDate" id="withdrawalDate" value="${list.withdrawalDate}" size="16" readonly="true" class="form-control">
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>

                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>UAN No:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="uanNo" id="uanNo"  class="form-control" readonly="true"></form:input>
                                                            <%--<form:errors path="uanNo" cssClass="errorDiv"></form:errors>--%>
                                                    </div> 

                                                </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                    <!--bank detail complete-->
                                    <div class="box box-info collapsed-box">
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
                                                        <div class="col-sm-6" id="levelIdDiv1">
                                                            <label>Reporting Manager:<span style="color: red;font-size: 12px;">*</span></label>


                                                        <c:set var="OrigionalString" value="${preList}"/>
                                                        <c:set var="displayReportingManagerArray" value="${fn:split(OrigionalString, '\"')}" />
                                                        <!--this will split string on every double Quote and after split we will get exact required location on fourth location.-->
                                                        <input type="text" value="${displayReportingManagerArray[3]}" name="displayReportingManager" id="displayReportingManager" class="form-control" readonly="true"/>
                                                        <form:hidden path="reportingManagerLevel1"></form:hidden>
                                                        </div>

                                                        <div class="col-sm-6" id="levelIdDiv2">
                                                            <label>Level 2:</label>
                                                        <form:hidden path="reportingManagerLevel2"></form:hidden>
                                                        <input type="text" name="reportingManagerLevel2Name" value="${rmName2}" id="reportingManagerLevel2Name" class="form-control" readonly="true"/>
                                                        </div>

                                                    </div>


                                                    <div class="form-group">
                                                        <div class="col-sm-6" id="levelIdDiv3">
                                                            <label>Level 3:</label>
                                                        <form:hidden path="reportingManagerLevel3"></form:hidden>
                                                            <input type="text" name="reportingManagerLevel3Name" value="${rmName3}" id="reportingManagerLevel3Name" class="form-control" readonly="true"/>
                                                        </div>

                                                        <div class="col-sm-6" id="levelIdDiv4">
                                                            <label>Level 4:</label>
                                                        <form:hidden path="reportingManagerLevel4"></form:hidden>
                                                            <input type="text" name="reportingManagerLevel4Name" value="${rmName4}" id="reportingManagerLevel4Name" class="form-control" readonly="true"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group" id="levelIdDiv5">
                                                        <div class="col-sm-6">
                                                            <label>Functional Head:</label>
                                                        <form:hidden path="reportingManagerLevel5"></form:hidden>
                                                            <input type="text" name="reportingManagerLevel5Name" value="${rmName5}" id="reportingManagerLevel5Name" class="form-control" readonly="true"/>
                                                        </div>

                                                        <div class="col-sm-6" id="levelIdDiv6">
                                                            <label>CEO/Proprietor/MD:</label>
                                                        <form:hidden path="reportingManagerLevel6"></form:hidden>
                                                            <input type="text" name="reportingManagerLevel6Name" value="${rmName6}" id="reportingManagerLevel6Name" class="form-control" readonly="true"/>
                                                        </div>
                                                    </div>

                                                </div>

                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                    <div class="box box-info collapsed-box" id="login_detail_id">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Certificate Attachments</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId8">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun8();"><i class="fa fa-plus" id="minusId8" ></i></button>
                                                <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">

                                                    <!--                                                    <div class="form-group">
                                                <%--<c:forEach var="certificatesList" items="${certificatesList}">--%>

                                                    <div class="col-sm-12">
                                                        <span>[ <a href="employeeMaster.htm?act=downloadEmployeeCertificates&amp;fileName=${certificatesList}&userId=${employeeMaster.userMaster.id}">${certificatesList}</a> ]</span>
                                                    </div>
                                                <%--</c:forEach>--%>

                                            </div>-->
                                                <div class="box-body no-padding">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                                    <tr>
                                                                        <th style="text-align: center;width:55px">Sr No.</th>
                                                                        <th style="text-align: center;">Certificate Attach</th>
                                                                        <th style="text-align: center;width:55px"></th>
                                                                    </tr>
                                                                    <input type="hidden" name="firstStepCount" id="firstStepCount" value="1">
                                                                    <input type="hidden" name="certificateId1" id="certificateId1" value="certificatesList">
                                                                    <tr id="cloneTr_Id">
                                                                        <td style="text-align: center">1</td>
                                                                        <td>
                                                                            <input type="file" class="form-control" id="certificateId1" name="certificateId1" accept="image/jpg,image/jpeg,image/png"  onchange="checkCertificateFileSize(1);" disabled="true">
                                                                            <span style="font-size: 14px; color: red;" id="certificateError"></span>
                                                                            <c:forEach var="certificatesList" items="${certificatesList}">

                                                                                <div class="col-sm-12">
                                                                                    <span>[ <a href="employeeMaster.htm?act=downloadEmployeeCertificates&amp;fileName=${certificatesList}&userId=${employeeMaster.userMaster.id}">${certificatesList}</a> ]</span>
                                                                                </div>
                                                                            </c:forEach>
                                                                        </td>
                                                                        <td style="text-align: center"><span style='margin-top: 5px;'>
                                                                                <input type="button" value="+" id="step1cloneid" />  </span>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div></div>
                                                    </div></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                        <div class=" col-sm-12" style="text-align: center;">
                                            <input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div><!-- /.box-body --> 
                                
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

<script type="text/javascript">
            var dt = new Date();
            dt.setFullYear(new Date().getFullYear() - 18);
            var dt1 = new Date();
            dt1.setFullYear(new Date().getFullYear() - 100);
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

<script type="text/javascript">
            var dt = new Date();
            dt.setFullYear(new Date().getFullYear() - 10);
            var dt1 = new Date();
            dt1.setFullYear(new Date().getFullYear() + 10);
            $('.form_datetime_passport_issue').datetimepicker({
    //language:  'fr',
    weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            startDate: dt,
            endDate: dt1,
            forceParse: 0
    });</script>

<script type="text/javascript">
            var dt = new Date();
            var dt1 = new Date();
            dt1.setFullYear(new Date().getFullYear() + 10);
            $('.form_datetime_passport_expiry').datetimepicker({
    //language:  'fr',
    weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            startDate: dt,
            endDate: dt1,
            forceParse: 0
    });</script>

<script>
            jQuery.noConflict();
    <c:if test="${sessionScope.userRight.hr}">

    jQuery(document).ready(function () {
    jQuery("#reportingManagerLevel1").tokenInput(${list}, {
    preventDuplicates: true,
            noResultsText: "No Result",
            tokenLimit: "1",
            searchingText: "Searching ... .. .",
            prePopulate: ${preList}
    });
    });
    </c:if>
    jQuery(document).ready(function () {

    reportingLevelSet();
            //              if ($('#maritalStatus').attr('checked')) {
            //                        if ($('.checked input[name=maritalStatus]')) {
            if ($('#mariStatus').val() === "Married") {
    $("#hideInfo1").show(500);
            $("#hideInfo2").show(500);
            $("#otherMaritalStatusId").hide(500);
    } else {

    $("#hideInfo1").hide(500);
            $("#hideInfo2").hide(500);
            $("#otherMaritalStatusId").hide(500);
    }
    if ($('#mariStatus').val() === "Other") {
    $("#hideInfo1").hide(500);
            $("#hideInfo2").hide(500);
            $("#otherMaritalStatusId").show(500);
    }
    //                        }         if ($('#shiftType').find("option:selected")) {
    if ($('#shiftType').find("option:selected").val() == "HourlyBase") {
    $('#hourlyBaseTitleDiv').show();
            $('#shiftNameDiv').hide();
            $('#shiftRotationNameDiv').hide();
            $('#shiftRotationDateDiv').hide();
    }
    else if ($('#shiftType').find("option:selected").val() == "ShiftBase") {
    $('#shiftNameDiv').show();
            $('#shiftRotationNameDiv').show();
            $('#shiftRotationDateDiv').show();
            $('#hourlyBaseTitleDiv').hide();
    }
    else {
    $('#hourlyBaseTitleDiv').hide();
            $('#shiftNameDiv').hide();
            $('#shiftRotationNameDiv').hide();
            $('#shiftRotationDateDiv').hide();
    }
    }

    $('#levelIdDiv2').hide();
            $('#levelIdDiv3').hide();
            $('#levelIdDiv4').hide();
            $('#levelIdDiv5').hide();
            $('#levelIdDiv6').hide();
    }); //when document loaded it loads based on erlier reporting manager     function reportingLevelSet() {
            var level = document.getElementById("reportingManagerLevel1").value;
            if (level != null && level != '') {
    $.ajax({
    url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
            type: 'GET',
            success: function (result) {
            var array = result.split("~");
                    //blank whole fields before put new data
                    document.getElementById("reportingManagerLevel2").value = '';
                    document.getElementById("reportingManagerLevel3").value = '';
                    document.getElementById("reportingManagerLevel4").value = '';
                    document.getElementById("reportingManagerLevel5").value = '';
                    document.getElementById("reportingManagerLevel6").value = '';
                    document.getElementById("reportingManagerLevel2Name").value = '';
                    document.getElementById("reportingManagerLevel3Name").value = '';
                    document.getElementById("reportingManagerLevel4Name").value = '';
                    document.getElementById("reportingManagerLevel5Name").value = '';
                    document.getElementById("reportingManagerLevel6Name").value = '';
                    document.getElementById("reportingManagerLevel2").value = array[0];
                    document.getElementById("reportingManagerLevel3").value = array[1];
                    document.getElementById("reportingManagerLevel4").value = array[2];
                    //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for id in databese)
                    if ((array[4] == "" || array[4] == null) && (array[5] == "" || array[5] == null)) {
            if (array[2] == "" || array[2] == null) {
            document.getElementById("reportingManagerLevel6").value = level;
            } else {
            document.getElementById("reportingManagerLevel5").value = level;
                    document.getElementById("reportingManagerLevel6").value = array[2]; }
            } else {
            if (array[4] == "" || array[4] == null) {
            document.getElementById("reportingManagerLevel5").value = level;
            } else {
            document.getElementById("reportingManagerLevel5").value = array[4];
            }
            document.getElementById("reportingManagerLevel6").value = array[5];
            }
            document.getElementById("reportingManagerLevel2Name").value = array[6];
                    document.getElementById("reportingManagerLevel3Name").value = array[7];
                    document.getElementById("reportingManagerLevel4Name").value = array[8];
                    //this conditions checks for level 5 and level 6 if these are empty then set conditional values(for values display on jsp)
                    if ((array[10] == "" || array[10] == null) && (array[11] == "" || array[11] == null)) {
            if (array[6] == "" || array[6] == null) {
            document.getElementById("reportingManagerLevel6Name").value = array[12];
                    //array[12] is for employee name reporting manager.
            } else {
            document.getElementById("reportingManagerLevel5Name").value = array[12];
                    document.getElementById("reportingManagerLevel6Name").value = array[6]; }
            } else {
            if (array[10] == "" || array[10] == null) {
            document.getElementById("reportingManagerLevel5Name").value = array[12];
            } else {
            document.getElementById("reportingManagerLevel5Name").value = array[10];
            }
            document.getElementById("reportingManagerLevel6Name").value = array[11];
            }
            }
    });
    }
    }

    //this script is comented because only first level reporting manager is only required.
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel2").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //                prePopulate: ${preList2}
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel3").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //                prePopulate: ${preList3}
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel4").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //                prePopulate: ${preList4}
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel5").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //                prePopulate: ${preList5}
    //            });
    //        });
    //        jQuery(document).ready(function () {
    //            jQuery("#reportingManagerLevel6").tokenInput(${list}, {
    //                preventDuplicates: true,
    //                noResultsText: "No Result",
    //                tokenLimit: "1",
    //                searchingText: "Searching ... .. .",
    //                prePopulate: ${preList6}
    //            });
    //        });
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<!--    <script>
        $(document).ready(function () {
            showHide();
        });
        $("#levelMasterId").on('change', function () {
            showHide();
        });
        $("#WorkTypeSelectId").on("change", function () {
            shift();
        });
        function showHide() {
            var textVal = $("#levelMasterId option:selected").text();
            $('#levelIdDiv1').hide();
            
            if (textVal === "Level 1") {
                $('#levelIdDiv1').show();

            } else if (textVal === "Level 2") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();

            } else if (textVal === "Level 3") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();

            } else if (textVal === "Level 4") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();

            } else if (textVal === "Level 5") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').show();

            } else if (textVal === "Level 6") {
                $('#levelIdDiv1').show();
                $('#levelIdDiv2').show();
                $('#levelIdDiv3').show();
                $('#levelIdDiv4').show();
                $('#levelIdDiv5').show();
                $('#levelIdDiv6').show();
            }
        }

    </script>-->
<script>
    jQuery(document).ready(function () {

    //            });

    });
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
            //        $('#gender1').iCheck('check');
</script>

<script>
            var setOptionRemoveFlag = true;
            jQuery(document).ready(function () {
    setOptionRemoveFlag = false;
            getDesignation();
    });
            function getDesignation() {
            var levelMasterId = document.getElementById('levelMaster.id').value;
                    //            alert("levelmaster id    " + levelMasterId);
                    if (levelMasterId != "") {
            $.get("employeeMaster.htm?act=getDesignationByLevel",
            {
            levelMasterId: levelMasterId
            },
                    function (responseJson) {
                    ////                    $(".result").html(data);
                    //                    alert("response     " + responseJson);
                    //                    var tempjson = JSON.parse(responseJson);
                    //                    alert("jsosnsnssnsn    "+tempjson[0]);
                    var $select = $('#designationMasterByLevelId'); // Locate HTML DOM element with ID "someselect".
                            //                    alert("this is my select    " + select);
                            if (setOptionRemoveFlag) {
                    $select.find("option").remove(); // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                            alert("I have been called   " + setOptionRemoveFlag + " times");
                    }
                    $.each(responseJson, function (key, value) {               // Iterate over the JSON object.
                    //                        alert(key + '     ' + value);
                    if (!setOptionRemoveFlag && $("#designationMasterByLevelId option:first").val() != key) {
                    //this conditions check will remove duplicates from list.
                    $('#designationMasterByLevelId')
                            .append($("<option></option>")
                                    .attr("value", key)
                                    .text(value));
                    }
                    if (setOptionRemoveFlag) {
                    $('#designationMasterByLevelId')
                            .append($("<option></option>")
                                    .attr("value", key)
                                    .text(value));
                    }
                    });
                            setDesignation();
                            setOptionRemoveFlag = true; //this is setted again to true for option remove function call on onchange() event.
                    });
                    ////                alert("response     " + responseJson);
                    //            }
            }


            }
</script>
<script>
    function setDesignation() {

    var designationMasterId = document.getElementById('designationMasterByLevelId').value;
            //            alert("this is designation for it   " + designationMasterId);
            document.getElementById('designationMaster.id').value = designationMasterId;
    }
</script>
<script>
    <c:if test="${!sessionScope.userRight.hr}">

    $('.readItOnly').attr('readonly', true);
    </c:if>

</script>
</html>

