<%-- 
    Document   : TrainingCreate
    Created on : Mar 8, 2018, 4:26:04 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html>-->
<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Training</title>
<script>
//        jQuery.noConflict();
//        jQuery(document).ready(function () {
//            jQuery("#trainingOwner").tokenInput(${list}, {
//                preventDuplicates: true,
//                noResultsText: "No Result",
//                tokenLimit: "1",
//                searchingText: "Searching ......",
//                prePopulate: ${preList}
//
//            });
//        });
        jQuery(document).ready(function () {
            reportingLevelSet();
        });
        function reportingLevelSet() {
            alert('hi');
            var level = document.getElementById("trainingOwner").value;
            if (level != null && level != '') {
                $.ajax({
                    url: 'employeeMaster.htm?act=readReportingHierarchy&id=' + level,
                    type: 'GET',
                    success: function (result) {
                        //                        alert("this is result String    " + result);
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
                                document.getElementById("reportingManagerLevel6").value = array[2];
                            }
                        } else {
                            //                            document.getElementById("reportingManagerLevel5").value = level;
                            if (array[4] == "" || array[4] == null) {
                                document.getElementById("reportingManagerLevel5").value = level;

                            } else {
                                document.getElementById("reportingManagerLevel5").value = array[4];
                            }
                            document.getElementById("reportingManagerLevel6").value = array[5];
                            //                            if (array[4] != "" || array[4] != null) {

                            //                            }

                        }
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
            </script>
</head>
<script>
    function getTrainingSubType() {
        var trainingTypeId = document.getElementById('trainingType').value;

//            alert("trainingType id    " + trainingTypeId);
        if (trainingTypeId != "") {
            $.get("trainingMaster.htm?act=getSubTypeByTrainingType",
                    {
                        trainingTypeId: trainingTypeId
                    },
            function (responseJson) {
////                    $(".result").html(data);
//                    alert("response     " + responseJson);
//                    var tempjson = JSON.parse(responseJson);
//                    alert("jsosnsnssnsn    "+tempjson[0]);
                var $select = $('#SubtypeBytrainingTypeId'); // Locate HTML DOM element with ID "someselect".
//                    alert("this is my select    " + select);
                $select.find("option").remove(); // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
                $.each(responseJson, function (key, value) {               // Iterate over the JSON object.
//                        alert(key + '     ' + value);

                    $('#SubtypeBytrainingTypeId')
                            .append($("<option></option>")
                                    .attr("value", key)
                                    .text(value));

//                        var opt = document.createElement('option');
//                        opt.value = key;
//                        opt.innerHTML = value;
//                        select.appendChild(opt);
////                        $("<option>").val(key).text(value).appendTo($select);

//                        alert("Load was performed.");
                });
                setDesignation();
            });
////                alert("response     " + responseJson);
//            }
        }


    }

    function checkBlankField() {
        var flag = true;
        if ($('#trainingTitle').val() == '') {
            document.getElementById('trainingTitleError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#trainer').val() == '') {
            document.getElementById('trainerError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#trainingType').val() == '') {
            document.getElementById('trainingTypeError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#venue').val() == '') {
            document.getElementById('venueError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#startDate').val() == '') {
            document.getElementById('startDateError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#endDate').val() == '') {
            document.getElementById('endDateError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#trainingTimeForm').val() == '') {
            document.getElementById('trainingTimeFormError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        if ($('#trainingTimeTo').val() == '') {
            document.getElementById('trainingTimeToError').innerHTML = '-It must not be empty or white space.';
            flag = false;
        }
        return flag;
    }

    function trainerOnchangeFunction(idString) {
        if (document.getElementById(idString).innerHTML != null) {
            document.getElementById(idString).innerHTML = '';
        }
    }
//    function dateCheck() {
//        var today = new Date();
//        var startDateString = $('#startDate').val();
//        var a = startDateString.split("/");
//        var startDate = new Date(a[2], a[1] - 1, a[0]);
//        var flag = startDate.toDateString() >= today.toDateString();
//        if (!flag) {
//            document.getElementById('startDate').value = '';
//            alert("Start Date Not Less than Today Date.");
//        }
//        else{
//            document.getElementById('startDate').value;
//        }
//    }
//    function dateCheck1(endDateString) {
//        alert(endDateString);
//        var startDateString = $('#startDate').val();
//        var a = startDateString.split("/");
//        var startDate = new Date(a[2], a[1] - 1, a[0]);
//
//        var b = endDateString.split("/");
//        var endDate = new Date(b[2], b[1] - 1, b[0]);
//        var flag = endDate.toDateString() >= startDate.toDateString();
//        alert(endDate.toDateString());
//        alert(startDate.toDateString());
//        if (!flag) {
//            document.getElementById('endDate').value = '';
//            alert("End Date Not Less than Start Date.");
//        }
//    }

 
</script>



<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>Add Training</h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Training</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <!-- Custom Tabs -->
                <div class="nav-tabs-custom">
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab_1">


                            <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                            <c:if test="${!empty successMessage}">
                                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                            </c:if>
                            <c:if test="${!empty failureMessage}">
                                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                            </c:if>

                            <!--form--> 
                            <form:form class="form-horizontal" method="post" onsubmit='return checkBlankField();'
                                       commandName="trainingMaster" action="trainingMaster.htm?act=createSubmit">


                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Training Title<span style="color: red;font-size: 12px;">*</span></label>
                                        <form:input path="trainingTitle" id="trainingTitle" class="form-control" onchange="trainerOnchangeFunction('trainingTitleError');"/>
                                        <span style="font-size: 14px; color: #dd4b39;" id="trainingTitleError"></span>
                                    </div>
                                    <div class="col-sm-5">
                                        <label class="control-label">Description<span style="color: red;font-size: 12px;"></span></label>
                                        <form:textarea path="trainingDescription" class="form-control"/>
                                        <%--<form:errors path="trainingDescription" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Training Requester<span style="color: red;font-size: 12px;"></span></label>
                                        <%--<form:input path="trainingOwner" class="form-control"/>--%>
                                        <form:input path="trainingOwner" class="form-control" onchange="reportingLevelSet();"></form:input>
                                    </div>
                                    <div class="col-sm-5">
                                        ${trainingMaster.trainer.trainerName}
                                        <label class="control-label">Trainer<span style="color: red;font-size: 12px;">*</span></label>
                                        <%--<form:select name="trainer" id="trainer" class="form-control" path="trainer" >--%>
                                        <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                        <%--<form:options items="${trainerMap}"></form:options>--%>
                                        <%--</form:select>--%>
                                        <select name="trainer" class="form-control" path="trainer.id" id="trainer" onchange="trainerOnchangeFunction('trainerError');">
                                            <option value="">--Select--</option>
                                            <c:forEach items="${trainerMap}" var="trainer">
                                                <option value="${trainer.key}">${trainer.value}</option>
                                            </c:forEach>
                                        </select>
                                        <span style="font-size: 14px; color: #dd4b39;" id="trainerError"></span>
                                        <%--<form:errors path="trainer" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Training Type<span style="color: red;font-size: 12px;">*</span></label>
                                        <%--<form:select name="trainingtype" id="trainingtype" path="trainingType" class="form-control" onchange="getTrainingSubType();">--%>
                                        <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                        <%--<form:options items="${trainingTypeMap}"></form:options>--%>
                                        <%--</form:select>--%>
                                        <select name="trainingType"  id="trainingType" class="form-control" path="trainingType.id" onchange="getTrainingSubType();
                                                trainerOnchangeFunction('trainingTypeError');">
                                            <option value="">--Select--</option>
                                            <c:forEach items="${trainingTypeMap}" var="trainingTypeMap">
                                                <option value="${trainingTypeMap.key}">${trainingTypeMap.value}</option>
                                            </c:forEach>
                                        </select>
                                        <span style="font-size: 14px; color: #dd4b39;" id="trainingTypeError"></span>
                                        <%--<form:errors path="trainingType" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                    <div class="col-sm-5">
                                        <label class="control-label">Training sub-type ${trainingSubType.id}<span style="color: red;font-size: 12px;">*</span></label>
                                        <select name="SubtypeBytrainingTypeId" id="SubtypeBytrainingTypeId"  path="trainingSubType.id" class="form-control" >
                                            <option value="" label="-- Select --" ></option>
                                            <%--<form:options items="${desigList}"></form:options>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Venue<span style="color: red;font-size: 12px;">*</span></label>
                                        <form:input path="venue" class="form-control" id="venue" onchange="trainerOnchangeFunction('venueError');"/>
                                        <span style="font-size: 14px; color: #dd4b39;" id="venueError"></span>
                                        <%--<form:errors path="venue" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                    <div class="col-sm-5">
                                        <label class="control-label">Cost<span style="color: red;font-size: 12px;"></span></label>
                                        <form:input path="cost" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Start Date<span style="color: red;font-size: 12px;">*</span></label>
                                        <div class="input-group date form_Startdatetime"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                            <c:if test="${empty startdate}">
                                            <form:input path="startDate" id="startDate" class="form-control" size="16" type="text" value="" readonly="true" onchange="trainerOnchangeFunction('startDateError');dateCheck();" ></form:input>
                                            </c:if>
                                             <c:if test="${!empty startdate}">
                                            <form:input path="startDate" id="startDate" class="form-control" size="16" type="text" value="${startdate}" readonly="true" onchange="trainerOnchangeFunction('startDateError');dateCheck();" ></form:input>
                                             </c:if>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                <%--<form:errors path="startDate" cssClass="errorDiv"></form:errors>--%>

                                        </div>
                                        <span style="font-size: 14px; color: #dd4b39;" id="startDateError"></span>
                                    </div>
                                    <div class="col-sm-5">
                                        <label class="control-label">End Date<span style="color: red;font-size: 12px;">*</span></label>
                                        <div class="input-group date form_Enddatetime"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                            <form:input path="endDate" id="endDate" class="form-control" size="16" type="text" value="" readonly="true" onchange="trainerOnchangeFunction('endDateError');dateCheck1(this.value);"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <span style="font-size: 14px; color: #dd4b39;" id="endDateError"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label class="control-label">Training time from<span style="color: red;font-size: 12px;">*</span></label>
                                            <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                            <form:input path="trainingTimeForm" id="trainingTimeForm" class="form-control" type="text" size="16" value="" readonly="true" onchange="trainerOnchangeFunction('trainingTimeFormError');"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <span style="font-size: 14px; color: #dd4b39;" id="trainingTimeFormError"></span>
                                        </div>
                                        <div class="col-sm-5">
                                            <label class="control-label">Training time to<span style="color: red;font-size: 12px;">*</span></label>
                                            <div class="input-group date form_datetime" data-date-format="hh:ii " data-link-field="dtp_input1">
                                            <form:input path="trainingTimeTo" id="trainingTimeTo" class="form-control" size="16" value="" readonly="true" onchange="trainerOnchangeFunction('trainingTimeToError');"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                            <span style="font-size: 14px; color: #dd4b39;" id="trainingTimeToError"></span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label class="control-label">Training Source<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="trainingSource" class="form-control"/>
                                        </div>
                                        <div class="col-sm-5">
                                            <label class="control-label">Reimbursable<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:radiobutton path="reimbursable" value="1" required="required"/>Yes
                                            <form:radiobutton path="reimbursable" value="0" required="required"/>No
                                        </div>
                                    </div>
                                    <div class="form-group">
<!--                                        <div class="col-sm-5">
                                            <label class="control-label">Company Sponsor<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:radiobutton path="companySponsor" value="1" required="required"/>Yes
                                            <form:radiobutton path="companySponsor" value="0" required="required"/>No
                                        </div>-->
<!--                                        <div class="col-sm-5">
                                            <label class="control-label">Status<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:radiobutton path="status" value="1" required="required"/>Active
                                            <form:radiobutton path="status" value="0" required="required"/>Inactive
                                        </div>-->
                                    </div>
                                <!--</div>-->
<!--                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label class="control-label">Company Sponsor<span style="color: red;font-size: 12px;">*</span></label>
                                        <form:radiobutton path="companySponsor" value="1" required="required"/>Yes
                                        <form:radiobutton path="companySponsor" value="0" required="required"/>No
                                        <%--<form:errors path="companySponsor" cssClass="errorDiv"></form:errors>--%>
                                    </div>
<!--                                    <div class="col-sm-5">
                                        <label class="control-label">Status<span style="color: red;font-size: 12px;">*</span></label>
                                        <form:radiobutton path="status" value="1" required="required"/>Active
                                        <form:radiobutton path="status" value="0" required="required"/>Inactive
                                        <%--<form:errors path="status" cssClass="errorDiv"></form:errors>--%>
                                    </div>
                                </div>-->
                                <div class="form-group">
                                    <div class="col-sm-6 col-sm-offset-5">
                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                    </div>
                                    <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                            </div>-->
                                </div>
                        </div>
                            </form:form>


                        </div><!-- /.tab-pane -->
                    </div><!--tab-content>
                </div><!--nav-tabs-custom>
            </div><!-- /.col -->
                </div>
            </div>
        </div>
    </section><!-- /.content -->

</div><!--content-wrapper-->
<script type="text/javascript">
    $('.form_Startdatetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 2,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_Enddatetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 2,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_datetime').datetimepicker({
        //language:  'fr',
//        language: 'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>


<!--</html>-->
