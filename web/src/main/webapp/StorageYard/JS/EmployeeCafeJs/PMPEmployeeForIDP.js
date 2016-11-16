/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/////////////////////////////////////Header////////////////////////////////////////////////////////////////////
//$(document).on("click", ":submit", function (e) {
//    if ($(this).val() !== "") {
//        alert($(this).val());
//    }
//});


// Individual

function removeIndividualChild(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
{
//    , 'removeKRAID${status.count}'
    try {
        var val = document.getElementById("IndividualId").value;
        document.getElementById("IndividualId").value = (--val);
        var element1 = document.getElementById(removeRowId_1);
        var element2 = document.getElementById(removeRowId_2);
        var element3 = document.getElementById(removeRowId_3);
        var element4 = document.getElementById(removeRowId_4);
        var element5 = document.getElementById(removeRowId_5);
        element1.parentNode.removeChild(element1);
        element2.parentNode.removeChild(element2);
        element3.parentNode.removeChild(element3);
        element4.parentNode.removeChild(element4);
        element5.parentNode.removeChild(element5);
        var counter = 1;
        try {
            for (var m = 1; m <= (val + 1); m++) {
                try {
                    document.getElementById("removeKRAIndividualID" + m).value;
                    $("#removeKRAIndividualID" + m).attr('id', "removeKRAIndividualID" + counter);
                    //replace id
                    $("#text" + m).attr('id', "text" + counter);
                    $("#individualtextDiv" + m).attr('id', "individualtextDiv" + counter);
                    $("#trainingSelectId" + m).attr('id', "trainingSelectId" + counter);
                    $("#trainingSelectTextinput" + m).attr('id', "trainingSelectTextinput" + counter);
                    $("#midYearRetxtId" + m).attr('id', "midYearRetxtId" + counter);
                    $("#endYearRetxtId" + m).attr('id', "endYearRetxtId" + counter);
                    $("#managerMidYearRemark" + m).attr('id', "managerMidYearRemark" + counter);
                    $("#managerEndYearRemark" + m).attr('id', "managerEndYearRemark" + counter);
                    $("#IndividualDevelopmentPlanId" + m).attr('id', "IndividualDevelopmentPlanId" + counter);
                    //name replace
                    $("#text" + counter).attr('name', "text" + counter);
                    $("#individualtextDiv" + counter).attr('name', "individualtextDiv" + counter);
                    $("#trainingSelectId" + counter).attr('name', "trainingSelectId" + counter);
                    $("#trainingSelectTextinput" + counter).attr('name', "trainingSelectTextinput" + counter);
                    $("#midYearRetxtId" + counter).attr('name', "midYearRetxtId" + counter);
                    $("#endYearRetxtId" + counter).attr('name', "endYearRetxtId" + counter);
                    $("#managerMidYearRemark" + counter).attr('name', "managerMidYearRemark" + counter);
                    $("#managerEndYearRemark" + counter).attr('name', "managerEndYearRemark" + counter);
                    $("#IndividualDevelopmentPlanId" + counter).attr('name', "IndividualDevelopmentPlanId" + counter);
                } catch (err) {

                    document.getElementById("removeKRAIndividualID" + (m + 1)).value;
                    $("#removeKRAIndividualID" + (m + 1)).attr('id', "removeKRAIndividualID" + counter);

                    //repalce id
                    $("#text" + (m + 1)).attr('id', "text" + counter);
                    $("#individualtextDiv" + (m + 1)).attr('id', "individualtextDiv" + counter);
                    $("#trainingSelectId" + (m + 1)).attr('id', "trainingSelectId" + counter);
                    $("#trainingSelectTextinput" + (m + 1)).attr('id', "trainingSelectTextinput" + counter);
                    $("#midYearRetxtId" + (m + 1)).attr('id', "midYearRetxtId" + counter);
                    $("#endYearRetxtId" + (m + 1)).attr('id', "endYearRetxtId" + counter);
                    $("#managerMidYearRemark" + (m + 1)).attr('id', "managerMidYearRemark" + counter);
                    $("#managerEndYearRemark" + (m + 1)).attr('id', "managerEndYearRemark" + counter);
                    $("#IndividualDevelopmentPlanId" + (m + 1)).attr('id', "IndividualDevelopmentPlanId" + counter);

                    //replace name
                    $("#text" + counter).attr('name', "text" + counter);
                    $("#individualtextDiv" + counter).attr('name', "individualtextDiv" + counter);
                    $("#trainingSelectId" + counter).attr('name', "trainingSelectId" + counter);
                    $("#trainingSelectTextinput" + counter).attr('name', "trainingSelectTextinput" + counter);
                    $("#midYearRetxtId" + counter).attr('name', "midYearRetxtId" + counter);
                    $("#endYearRetxtId" + counter).attr('name', "endYearRetxtId" + counter);
                    $("#managerMidYearRemark" + counter).attr('name', "managerMidYearRemark" + counter);
                    $("#managerEndYearRemark" + counter).attr('name', "managerEndYearRemark" + counter);
                    $("#IndividualDevelopmentPlanId" + counter).attr('name', "IndividualDevelopmentPlanId" + counter);
                    m++;
                }
                document.getElementById("removeKRAIndividualID" + counter).innerHTML = counter;
                counter++;
            }
        } catch (err) {
        }
        var kraremovedIndividualIdVal = document.getElementById('kraremovedIndividualIdVal').value;
        document.getElementById('kraremovedIndividualIdVal').value = kraremovedIndividualIdVal + "," + id;
    } catch (e) {

    }
}


var j = 1;
$(function () {
    var flag11 = document.getElementById("flagId").value;
    var flagMidId = document.getElementById("flagMidId").value;
    var flagEndId = document.getElementById("flagEndId").value;
//    alert("WWWWWWWWWWWWWW" + flagEndId);
    $("#addIndividualId").on("click", function () {
        j = document.getElementById("IndividualId").value;
        if (j == 0) {
            j = 1;
        }
        if (j <= 4) {
//        alert("aaa" + j);
            j++;
//                alert(i1);
            var clone = "<tr id='1moreFile_1_" + j + "'>"
                    + "<td style=\"text-align: center\">" + j + "</td>"
                    + "<td><textarea type=\"Text\" id=\"text" + j + "\" name=\"text" + j + "\" class=\"form-control\"></textarea></td>"
                    + "<td><div>"
                    + "<select id=\"individualtextDiv" + j + "\" name=\"individualtextDiv" + j + "\" class=\"form-control\">"
                    + "<option value=\"\">--SELECT--</option>"
                    + "<option value=\"Technical\">Technical</option>"
                    + "<option value=\"Other\">Other</option>"
                    + "<option value =\"Soft Skill\">Soft Skill</option>"
                    + "</select>"
                    + "</div>"
                    + "</td>"
                    + "<td><div>"
                    + "<select id=\"trainingSelectId" + j + "\" name=\"trainingSelectId" + j + "\" class=\"form-control\" onchange=\"trainingSelect(" + j + ")\">"
                    + "<option value=\"\">--SELECT--</option>"
                    + "<option value=\"On The Job Training\">On The Job Training</option>"
                    + "<option value=\"Classroom Training\">Classroom Training</option>"
                    + "<option value=\"Other\">Other</option>"
                    + "</select>"
                    + "</div>"
                    + "</td>"
                    + "<td><div>"
                    + "<textarea class=\"form-control\" id=\"trainingSelectTextinput" + j + "\" name=\"trainingSelectTextinput" + j + "\" style=\"display: none\"></textarea>"
                    + "</div>"
                    + "</td>"
                    + "<td style=\"text-align: center\">"
                    + "<span style=\'margin-top: 5px;\'>"
                    + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild_j('1moreFile_1_" + j + "', '1moreFile_2_" + j + "', '1moreFile_3_" + j + "','1moreFile_4_" + j + "','1moreFile_5_" + j + "');\">"
                    + "</span>"
                    + "</td>"
                    + "</tr>"

//                + "<tr id='1moreFile_2_" + j + "'>"
//                + "<td></td>"
//                + "<td id=\"midYearReId" + j + "\"><b>Mid-Year Remark</b></td>"
//                + "<td colspan=\"2\" id=\"midYearRetxtId" + j + "\"><textarea rows=\"3\" id=\"midYearRemark" + j + "\" name=\"midYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                + "<td></td>"
//                + "<td></td>"
//                + "</tr>"
//                + "<tr id='1moreFile_3_" + j + "'>"
//                + "<td></td>"
//                + "<td id=\"endYearReId" + j + "\"><b>End-Year Remark</b></td>"
//                + "<td colspan=\"2\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" id=\"endYearRemark" + j + "\" name=\"endYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                + "<td></td>"
//                + "<td></td>"
//                + "</tr>"
//                + "<tr id='1moreFile_4_" + j + "'>"
//                + "<td></td>"
//                + "<td id=\"endYearReId" + j + "\"><b>Manaager Mid-Year Remark</b></td>"
//                + "<td colspan=\"2\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" id=\"managerMidYearRemark" + j + "\" name=\"managerMidYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                + "<td></td>"
//                + "<td></td>"
//                + "</tr>"
//                + "<tr id='1moreFile_5_" + j + "'>"
//                + "<td></td>"
//                + "<td id=\"endYearReId" + j + "\"><b>Manager End-Year Remark</b></td>"
//                + "<td colspan=\"2\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" id=\"managerEndYearRemark" + j + "\" name=\"managerEndYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                + "<td></td>"
//                + "<td></td>"
//                + "</tr>";
                    //<![CDATA[
                    + "<tr id='1moreFile_2_" + j + "'>"
                    + "<td colspan=\"3\"><b>Employee Mid-Year Remark</b></td>"
                    + "<td colspan=\"3\"><b>Employee End-Year Remark</b></td>"
                    + "</tr>"
                    + "<tr id='1moreFile_3_" + j + "'>"
                    + "<td colspan=\"3\" id=\"midYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"midYearRemark" + j + "\" name=\"midYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"3\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"endYearRemark" + j + "\" name=\"endYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "</tr>"
                    + "<tr id='1moreFile_4_" + j + "'>"
                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager Mid-Year Remark</b></td>"
                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager End-Year Remark</b></td>"
                    + "</tr>"
                    + "<tr id='1moreFile_5_" + j + "'>"
                    + "<td colspan=\"3\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"managerMidYearRemark" + j + "\" name=\"managerMidYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"3\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"managerEndYearRemark" + j + "\" name=\"managerEndYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "</tr>"; //]]>
            $("#demo5").append(clone);
            document.getElementById("IndividualId").value = j;
        }
        if (flag11 == 'true') {
///////indivisual Plan//////

//            document.getElementById("text" + j).required = true;
//            document.getElementById("individualtextDiv" + j).required = true;
//            document.getElementById("trainingSelectId" + j).required = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
//                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + j).required = true;
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }

            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("endYearRemark" + j).readOnly = true;
            document.getElementById("managerMidYearRemark" + j).readOnly = true;
            document.getElementById("managerEndYearRemark" + j).readOnly = true;
        } else if (flagMidId == 'true') {
//            alert("djjdjdjdjdjdjdjdjdjdjdjdjd"+flagMidId);

//            document.getElementById("text" + j).required = true;
//            document.getElementById("individualtextDiv" + j).required = true;
//            document.getElementById("trainingSelectId" + j).required = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + j).required = true;
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }

//                alert("djjdjdjdjdjdjdjdjdjdjdjdjd===>"+flagMidId);

//            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("endYearRemark" + j).readOnly = true;
            document.getElementById("managerMidYearRemark" + j).readOnly = true;
            document.getElementById("managerEndYearRemark" + j).readOnly = true;
//            $('#midYearReId' + j).hide();
//            $('#midYearRetxtId' + j).hide();
//            $('#endYearReId' + j).hide();
//            $('#endYearRetxtId' + j).hide();

        } else if (flagEndId == 'true') {
//            document.getElementById("text" + j).required = true;
//            document.getElementById("individualtextDiv" + j).required = true;
//            document.getElementById("trainingSelectId" + j).required = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
//                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + j).required = true;
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }
            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("managerEndYearRemark" + j).readOnly = true;
            document.getElementById("managerMidYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
        }

    });
});
function trainingSelect(j) {

//    j = document.getElementById("IndividualId").value;
    var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//    alert("HHHHHHHHHHHHHHHHHHHHH");

    if (selectedValue1 == "Other") {
        document.getElementById("trainingSelectTextinput" + j).style.display = "block";
    } else {
        document.getElementById("trainingSelectTextinput" + j).style.display = "none";
    }

}
function removeChild_j(removeRow_1_Id, removeRow_2_Id, removeRow_3_Id, removeRow_4_Id, removeRow_5_Id) {
    j--
    document.getElementById("IndividualId").value = j;
    try {

        var element1 = document.getElementById(removeRow_1_Id);
        var element2 = document.getElementById(removeRow_2_Id);
        var element3 = document.getElementById(removeRow_3_Id);
        var element4 = document.getElementById(removeRow_4_Id);
        var element5 = document.getElementById(removeRow_5_Id);
        element1.parentNode.removeChild(element1);
        element2.parentNode.removeChild(element2);
        element3.parentNode.removeChild(element3);
        element4.parentNode.removeChild(element4);
        element5.parentNode.removeChild(element5);
    } catch (e) {

    }
}
function trainingSelectCloneOfTable1(j) {
    var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
    if (selectedValue1 == "Other") {
        document.getElementById("trainingSelectTextinput" + j).style.display = "block";
    } else {
        document.getElementById("trainingSelectTextinput" + j).style.display = "none";
    }
}

function ajaxfun() {

//
    var competencyEvaluationId = document.getElementById("competencyEvaluation_Id").value;
//    alert('Dhaval Parmar' + competencyEvaluationId);
    $.ajax({
        type: "POST",
        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
//                    data: "selectedvalue=" + selectedVal,
        data: {"selectedvalue": competencyEvaluationId},
        dataType: "text",
        success: function (responseTxt) {
//                        alert(responseTxt);
            var subCompentency = document.getElementById("demo9").innerHTML = responseTxt;
            var flag11 = document.getElementById("flagId").value;
            var flagMidId = document.getElementById("flagMidId").value;
            var flagEndId = document.getElementById("flagEndId").value;
            var count = document.getElementById("subCompentencyCount").value;
//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);
            if (flag11 == 'true') {
                for (i = 1; i <= count; i++) {

                    var compentencyMidYear = document.getElementById("compentencyMidYear" + i).value;
//                    document.getElementById("compentencyMidYear" + i).disabled = true;
                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
                }
            }
            if (flagMidId == 'true') {
//                alert("fdfddffhdf");
                for (i = 1; i <= count; i++) {

                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
//                    document.getElementById("compentencyMidYear" + i).disabled = true;
                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
                }
            }
            if (flagEndId == 'true') {
//                alert("fdfddffhdf");
                for (i = 1; i <= count; i++) {

                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
//                    document.getElementById("compentencyMidYear" + i).disabled = true;
                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
                }
            }

            //var arr=new Array();

            //arr=responseTxt;

            //if (selectedVal == 'Air') {
//                            document.getElementById("deviateId1").value = responseTxt;
//                        } else {
//
//                            document.getElementById("deviateId1").value = "";
//                        }
//                        data = response;
//                        return response;
        },
        error: function () {
            alert('Please Select Only One Competency Evaluation');
        }
    });
}

function historyajaxfun(kraId) {
//    alert(kraId);
//
//    var updateKraid = document.getElementById("updateKraid").value;

//    alert('Dhaval Parmar' + kraId);
    $.ajax({
        type: "POST",
        url: "updateAppraisalPerformanceKra.htm?act=historyAjaxCall&kraId=" + kraId,
//                    data: "selectedvalue=" + selectedVal,
        data: {"selectedvalue1": kraId},
        dataType: "text",
        success: function (responseTxt) {
//                        alert(responseTxt);
            document.getElementById("modeldemo").innerHTML = responseTxt;
//            var flag11 = document.getElementById("flagId").value;
//            var count = document.getElementById("subCompentencyCount").value;

//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);



        },
        error: function () {
            alert('History is Empty');
        }
    });
}

function historyajaxfunOtherActivity(kraIdOther) {
//    alert(kraIdOther);
//
//    var updateKraid = document.getElementById("updateKraid").value;

//    alert('Dhaval Parmar' + kraId);
    $.ajax({
        type: "POST",
        url: "appraisalPerformance.htm?act=historyAjaxCallOtherActivity&kraIdOther=" + kraIdOther,
//                    data: "selectedvalue=" + selectedVal,
        data: {"selectedvalue1": kraIdOther},
        dataType: "text",
        success: function (responseTxt) {
//                        alert(responseTxt);
            document.getElementById("modeldemo1").innerHTML = responseTxt;
//            var flag11 = document.getElementById("flagId").value;
//            var count = document.getElementById("subCompentencyCount").value;

//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
//            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);



        },
        error: function () {
            alert('History is Empty');
        }
    });
}

function deletedKraajaxfun(appraisalId) {
    $.ajax({
        type: "POST",
        url: "appraisalPerformance.htm?act=kraGoalAjax&appraisalId=" + appraisalId,
        data: {"selectedvalue1": appraisalId},
        dataType: "text",
        success: function (responseTxt) {
            document.getElementById("deletedKraDemo").innerHTML = responseTxt;

        },
        error: function () {
            alert('History is Empty');
        }
    });
}
function deletedActivitiesajaxfun(appraisalId) {
    $.ajax({
        type: "POST",
        url: "appraisalPerformance.htm?act=activitiesAjax&appraisalId=" + appraisalId,
        data: {"selectedvalue1": appraisalId},
        dataType: "text",
        success: function (responseTxt) {
            document.getElementById("deletedActivitydemo").innerHTML = responseTxt;

        },
        error: function () {
            alert('History is Empty');
        }
    });
}
function allowOnlyNumber1(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
//    weightageCountEmp();
}



/////////////////////////////////////footer///////////////////////////////////////////////////////////////

//$(document).on("click", ":submit", function (e) {
//    if (confirm("Are you sure you want to Submit")) {
//
//        if ($(this).val() !== "" && $(this).val() === "submit") {
//
//            var flag11 = document.getElementById("flagId").value;
//            var flagmid = document.getElementById("flagMidId").value;
//            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
//            var countId = document.getElementById("IndividualId").value;
//            var kragoalLength = document.getElementById("kragoalLength").value;
//            var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
//            var w1 = document.getElementById("weightageScore").value;
//            var w1 = document.getElementById("weightageScore").value;
//            if (w1 < 75 || w1 > 75) {
//                weitageAlert();
//                return false;
//            }
//            if (flag11 === 'true') {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
//                document.getElementById("weightage1").required = true;
//                for (i = 1; i <= kragoalLength; i++) {
//                    document.getElementById("kraGoal" + i).required = true;
//                    document.getElementById("metric" + i).required = true;
//                    document.getElementById("kraCategoryMap" + i).required = true;
//                    document.getElementById("weightage" + i).required = true;
//                }
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75 || w1 > 75) {
//                    weitageAlert();
//                    return false;
//                }
//                var kraGoal_activityVar = document.getElementById("kraGoal_activity1").value;
//                if (kraGoal_activityVar !== '') {
//
//                    document.getElementById("kraGoal_activity1").required = true;
//                    document.getElementById("kraCategoryMapOther1").required = true;
//                    document.getElementById("metric_activity1").required = true;
//                    document.getElementById("priority1").required = true;
//
//                }
////            document.getElementById("priority1").required = true;
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoal_activityVar = document.getElementById("kraGoal_activity" + i).value;
//                    if (kraGoal_activityVar !== '') {
//                        document.getElementById("kraGoal_activity" + i).required = true;
//                        document.getElementById("metric_activity" + i).required = true;
//                        document.getElementById("kraCategoryMapOther" + i).required = true;
//                        document.getElementById("priority" + i).required = true;
//                    }
//                }
//
//                for (i = 1; i <= count; i++) {
////                document.getElementById("competencyStartYear" + i).required = true;
////            document.getElementById("compentencyStartRemark" + i).required = true;
//
//                }
//                var induvisul = document.getElementById("text1").value;
//                if (induvisul !== '') {
//
//                }
//                for (i = 1; i <= countId; i++) {
//
//                    var induvisul = document.getElementById("text" + i).value;
//                    if (induvisul !== '') {
//
//                        var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//                        if (selectedValue1 == "Other") {
////                        document.getElementById("trainingSelectTextinput" + i).required = true;
//                        }
////                    document.getElementById("text" + i).required = true;
////                    document.getElementById("individualtextDiv" + i).required = true;
////                    document.getElementById("trainingSelectId" + i).required = true;
//
//                    }
//                }
//
//                document.getElementById("midYearRemark1").readOnly = true;
//                document.getElementById("endYearRemark1").readOnly = true;
////        document.getElementById("kraGoal_activity1").required = true;
////        document.getElementById("metric_activity1").required = true;
////        document.getElementById("priority1").required = true;
//
//
//            } else if (flagmid === 'true') {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
//                document.getElementById("midYearDiv1").required = true;
//                for (i = 1; i <= count; i++) {
////                document.getElementById("compentencyMidYear" + i).required = true;
////            document.getElementById("compentencyMidRemark" + i).required = true;
//
//                }
//                for (i = 1; i <= kragoalLength; i++) {
//                    document.getElementById("weightage" + i).required = true;
//                    document.getElementById("midYearDiv" + i).required = true;
//
//                    document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).required = true;
//                }
//                for (i = 1; i <= countId; i++) {
////            document.getElementById("individualtextDiv" + i).required = true;
////            document.getElementById("trainingSelectId" + i).required = true;
//                    var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//                    if (selectedValue1 == "Other") {
////                document.getElementById("trainingSelectTextinput" + i).required = true;
//                    }
//
//                }
//
//
//                var kraGoal_activityVar = document.getElementById("kraGoal_activity1").value;
//                if (kraGoal_activityVar !== '') {
//
//                    document.getElementById("kraGoal_activity1").required = true;
//                    document.getElementById("kraCategoryMapOther1").required = true;
//                    document.getElementById("metric_activity1").required = true;
//                    document.getElementById("priority1").required = true;
//                    document.getElementById("midYearDivOther1").required = true;
//                    document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
//
//                }
////            document.getElementById("priority1").required = true;
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoal_activityVar = document.getElementById("kraGoal_activity" + i).value;
//                    if (kraGoal_activityVar !== '') {
//                        document.getElementById("kraGoal_activity" + i).required = true;
//                        document.getElementById("metric_activity" + i).required = true;
//                        document.getElementById("kraCategoryMapOther" + i).required = true;
//                        document.getElementById("priority" + i).required = true;
//                        document.getElementById("midYearDivOther" + i).required = true;
////                    document.getElementById("endYearDivOther" + i).required = true;
//                        document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//                    }
//                }
//
//
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75 || w1 > 75) {
//                    weitageAlert();
//                    return false;
//                }
////        document.getElementById("kraGoal_activity1").required = true;
////        document.getElementById("metric_activity1").required = true;
////        document.getElementById("priority1").required = true;
////        document.getElementById("kraCategoryMapOther1").required = true;
////        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
//
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoalactivity = document.getElementById("kraGoal_activity" + i).value;
//                    if (kraGoalactivity !== '') {
//                        document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//                    } else {
//                        document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = false;
//                    }
//                }
//
//            } else if (flagEndId === "true") {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
//                document.getElementById("weightage1").required = true;
//                document.getElementById("endYearDiv1").required = true;
//
//                for (i = 1; i <= count; i++) {
////                document.getElementById("compentencyEndYear" + i).required = true;
////            document.getElementById("compentencyEndRemark" + i).required = true;
//                }
//                for (i = 1; i <= kragoalLength; i++) {
//
//                    document.getElementById("weightage" + i).required = true;
//                    document.getElementById("endYearDiv" + i).required = true;
//                    document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).required = true;
//                }
//                for (i = 1; i <= countId; i++) {
////                document.getElementById("individualtextDiv" + i).required = true;
////                document.getElementById("trainingSelectId" + i).required = true;
//                    var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//                    if (selectedValue1 == "Other") {
//                        document.getElementById("trainingSelectTextinput" + i).required = true;
//                    }
//
//                }
//
////                var kraGoal_activityVar = document.getElementById("kraGoal_activity1").value;
////                if (kraGoal_activityVar !== '') {
////                    alert("dhahah");
////                    document.getElementById("kraGoal_activity1").required = true;
////                    document.getElementById("kraCategoryMapOther1").required = true;
////                    document.getElementById("metric_activity1").required = true;
////                    document.getElementById("priority1").required = true;
//////                document.getElementById("midYearDivOther1").required = true;
////                    document.getElementById("endYearDivOther1").required = true;
////                    document.getElementById("empEndyearSelfassessmentGoalActivities1").required = true;
////
////                }
////            document.getElementById("priority1").required = true;
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoal_activityVar = document.getElementById("kraGoal_activity" + i).value;
////                        alert("SCSVSCSV"+kraGoal_activityVar);
//                    if (kraGoal_activityVar !== '') {
//                        document.getElementById("kraGoal_activity" + i).required = true;
//                        document.getElementById("metric_activity" + i).required = true;
//                        document.getElementById("kraCategoryMapOther" + i).required = true;
//                        document.getElementById("priority" + i).required = true;
////                    document.getElementById("midYearDivOther" + i).required = true;
//                        document.getElementById("endYearDivOther" + i).required = true;
//
//                        document.getElementById("empEndyearSelfassessmentGoalActivities" + i).required = true;
//                    }
//                }
//
//
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75 || w1 > 75) {
//                    weitageAlert();
//                    return false;
//                }
//            }
//
//        } else if ($(this).val() !== "" && $(this).val() === "save") {
//
////        alert($(this).val());   
//            $('.saveRequried').removeAttr('required');
//
//        }
//    } else {
//
//    }
//
//});

$(document).ready(function () {
   
    var flag11 = document.getElementById("flagId").value;
    var flagmid = document.getElementById("flagMidId").value;
   
    var flagEndId = document.getElementById("flagEndId").value;

    var countId = document.getElementById("IndividualId").value;

    if (flag11 === 'true') {
        for (i = 1; i <= countId; i++) {

            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
            }
//            document.getElementById("text" + i).required = true;
//            document.getElementById("individualtextDiv" + i).required = true;
//            document.getElementById("trainingSelectId" + i).required = true;
            document.getElementById("midYearRemark" + i).readOnly = true;
            document.getElementById("endYearRemark" + i).readOnly = true;
            document.getElementById("managerMidYearRemark" + i).readOnly = true;
            document.getElementById("managerEndYearRemark" + i).readOnly = true;
        }

        document.getElementById("midYearRemark1").readOnly = true;
        document.getElementById("endYearRemark1").readOnly = true;
    } else if (flagmid === 'true') {
       
        for (i = 1; i <= countId; i++) {
            var induvisul = document.getElementById("text" + i).value;
            if (induvisul !== '') {

                document.getElementById("text" + i).readOnly = true;
//            document.getElementById("individualtextDiv" + i).required = true;
//            document.getElementById("trainingSelectId" + i).required = true;
                var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
                if (selectedValue1 == "Other") {
                    document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + i).required = true;
                } else {
                    document.getElementById("trainingSelectTextinput" + i).style.display = "none";
                }


                document.getElementById("trainingSelectTextinput" + i).readOnly = true;
                document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
                document.getElementById("individualtextDiv" + i).style.cursor = "default";
                document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
                document.getElementById("trainingSelectId" + i).style.cursor = "default";
//            document.getElementById("midYearRemark" + i).readOnly = true;
                document.getElementById("endYearRemark" + i).readOnly = true;
                document.getElementById("managerMidYearRemark" + i).readOnly = true;
                document.getElementById("managerEndYearRemark" + i).readOnly = true;
            } else {
                document.getElementById("endYearRemark" + i).readOnly = true;
                document.getElementById("managerMidYearRemark" + i).readOnly = true;
                document.getElementById("managerEndYearRemark" + i).readOnly = true;
            }

        }
    } else if (flagEndId === 'true') {
//        alert(flagEndId + "flagEndId");
        for (i = 1; i <= countId; i++) {
            var induvisul = document.getElementById("text" + i).value;
            if (induvisul !== '') {
                document.getElementById("text" + i).readOnly = true;
                document.getElementById("midYearRemark" + i).readOnly = true;
                document.getElementById("trainingSelectTextinput" + i).readOnly = true;
                document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
                document.getElementById("individualtextDiv" + i).style.cursor = "default";
                document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
                document.getElementById("trainingSelectId" + i).style.cursor = "default";
                document.getElementById("managerMidYearRemark" + i).readOnly = true;
                document.getElementById("managerEndYearRemark" + i).readOnly = true;
            }
//            document.getElementById("text" + i).readOnly = true;
//            document.getElementById("individualtextDiv" + i).required = true;
//            document.getElementById("trainingSelectId" + i).required = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + i).required = true;
            } else {
                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
            }


            document.getElementById("midYearRemark" + i).readOnly = true;
            document.getElementById("managerMidYearRemark" + i).readOnly = true;
            document.getElementById("managerEndYearRemark" + i).readOnly = true;
        }
        document.getElementById("individualtextDiv1").display = true;
        document.getElementById("trainingSelectId1").display = true;
    }


});

