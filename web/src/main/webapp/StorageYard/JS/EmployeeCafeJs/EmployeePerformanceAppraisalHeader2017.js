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


var i = 1;
$(function () {
    $("#addRowButtonId").on("click", function () {
        var flag11 = document.getElementById("flagId").value;
//        var flagMidId = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;

        i = document.getElementById("countId").value;
        xx = document.getElementById("kragoalLength").value;
        if (i == 0) {
            i = 1;
//            alert(i);
        }
        if (i == 8) {
            alert("Your Can Enter Only 8 KRA");
        }
        if (i <= 7) {
//            if (i == 0) {
//                i = 1;
//            } else {
//                i++;
//            }
            xx++;
            i++;

//<![CDATA[
            var clone = "<tr id='row_1_" + i + "' style='clear:both;'>"
                    + "<td id='removeKRAID" + i + "' class='removeClass' style='margin: 0px;width: 45px;' valign=\"middle\">" + i + "</td>"
                    + "<td id=\"\"><textarea name=\"kraGoal" + i + "\" id=\"kraGoal" + i + "\" class=\"form-control\"></textarea><span id=\"kraGoalErr" + i + "\" style=\"color:red;\"></td>"
                    + "<td id=\"\"><textarea name=\"metric" + i + "\" id=\"metric" + i + "\" class=\"form-control\"></textarea></td>"

                    + "<td id=\"currency_div_td_" + i + "\"><div>"
                    + "<select id='kraCategoryMap" + i + "' name='kraCategoryMap" + i + "' class=\"form-control\">"
                    + "</select>"
                    + "</div></td>"

                    + "<td id=\"flagId1_" + i + "\"><input type=\"Text\" name=\"weightage" + i + "\" id=\"weightage" + i + "\" onkeypress=\"return allowOnlyNumber1(event);\" onchange=\"weightageCountEmp()\" class=\"form-control\"></td>"
//                    + "<td id=\"flagId2_" + i + "\"><div><select id=\"midYearDiv" + i + "\" name=\"midYearDiv" + i + "\" class=\"form-control\">"
                    + "<option value=\"\">--SELECT--</option>"
                    + "<option value=\"Yet to Start\">Yet to Start</option>"
                    + "<option value=\"In Progress\">In Progress</option>"
                    + "<option value=\"Completed\">Completed</option>"
                    + "<option value=\"Canceled\">Canceled</option></select>"
                    + "</div></td>"
                    + "<td id=\"flagId3_" + i + "\"><div><select id=\"endYearDiv" + i + "\" name=\"endYearDiv" + i + "\" class=\"form-control\">"
                    + "<option value=\"\">--SELECT--</option>"
                    + "<option value=\"Yet to Start\">Yet to Start</option>"
                    + "<option value=\"In Progress\">In Progress</option>"
                    + "<option value=\"Completed\">Completed</option>"
                    + "<option value=\"Canceled\">Canceled</option></select>"
                    + "</div></td>"
                    + "<td id=\"flagId41_" + i + "\"><input type=\"Text\" id=\"empfinalScore" + i + "\" name=\"employeefinalScore" + i + "\" onkeypress=\"return allowOnlyNumber1(event);\" onchange=\"CountEmpScore()\" class=\"form-control\"></td>"
                    + "<td id=\"flagId4_" + i + "\"><input type=\"Text\" id=\"finalScore" + i + "\" name=\"finalScore" + i + "\" class=\"form-control\"></td>"
                    + "<td style=\"text-align: center\" id=\"edit" + i + "\">"
                    + "<span style=\'margin-top: 5px;\' id=\"editC" + i + "\">"
                    + "<button type=\"button\" class=\"btns btn-warnings\">Edit</button>"
                    + "</span><br/>"
                    + "<td id=\"\" style=\"text-align: center\">"
                    + "<span style='margin-top: 5px;'>"
                    + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild1('row_1_" + i + "', 'row_2_" + i + "', 'row_3_" + i + "', 'row_4_" + i + "', 'row_5_" + i + "', 'row_6_" + i + "', 'row_7_" + i + "', 'row_8_" + i + "', 'row_9_" + i + "');\">"
                    + "</span>"
                    + "</td>"
                    + "</tr>"
//                    + "<tr id=\"row_2_" + i + "\">"
//                    + "<td colspan=\"4\"><b>Employees Mid - Year Self – Assessment KRA:</b></td>"
//                    + "<td colspan=\"4\"><b>Managers Mid - Year Review / Evaluation KRA:</b></td>"
//                    + "</tr>"
//                    + "<tr id=\"row_3_" + i + "\">"
//                    + "<td colspan=\"4\"><textarea id=\"employeeMidYearSelfAssesssmentGoal" + i + "\" name=\"employeeMidYearSelfAssesssmentGoal" + i + "\" type=\"Text\" style=\"width: 474px;\" class=\"form-control\"></textarea></td>"
//                    + "<td colspan=\"4\"><textarea id=\"managerMidYearSelfAssesssmentGoal" + i + "\" name=\"managerMidYearSelfAssesssmentGoal" + i + "\" type=\"Text\" style=\"width: 474px;\" class=\"form-control\"></textarea></td>"
//                    + "</tr>"

                    + "<tr id=\"row_4_" + i + "\">"
                    + "<td colspan=\"4\"><b>Employees  Self – Assessment KRA:</b></td>"
                    + "<td colspan=\"4\"><b>Managers Review / Evaluation KRA:</b></td>"
                    + "</tr>"
                    + "<tr id=\"row_5_" + i + "\">"
                    + "<td colspan=\"4\"><textarea id=\"employeeEndYearSelfAssesssmentGoal" + i + "\" name=\"employeeEndYearSelfAssesssmentGoal" + i + "\" type=\"Text\" style=\"width: 474px;\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"4\"><textarea id=\"managerEndYearSelfAssesssmentGoal" + i + "\" name=\"managerEndYearSelfAssesssmentGoal" + i + "\" type=\"Text\" style=\"width: 474px;\" class=\"form-control\"></textarea></td>"
                    + "</tr>";
            $("#demo").append(clone);
        }
        //]]>
        document.getElementById("countId").value = i;
//        alert(i);
        optionsofKraCategory(i);
//        alert("Limt" + document.getElementById("countId").value);
        document.getElementById("kragoalLength").value = xx;
//        alert(i);
//        alert(flag11);
//        alert(flagEndId);
        if (flag11 == 'true') {

//            document.getElementById("kraGoal" + i).required = true;
//            document.getElementById("metric" + i).required = true;
            var weightage11 = document.getElementById("weightage" + i).value;
//            alert("heloooo" + weightage11);
//            document.getElementById("weightage" + i).required = true;
//            document.getElementById("weightage" + i).readOnly = true;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";
            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
            var empfinalScore = document.getElementById("empfinalScore" + i).value;
//            alert("empfinalScore" + i);

            document.getElementById("empfinalScore" + i).readOnly = true;
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
        }
//        else if (flagMidId == 'true') {
////            alert("bjjbb" + flagMidId);
//            document.getElementById("kraGoal" + i).required = true;
//            document.getElementById("metric" + i).required = true;
//
////            document.getElementById("midYearDiv" + i).required = true;
//            var weightage11 = document.getElementById("weightage" + i).value;
////            document.getElementById("weightage" + i).required = true;
////            document.getElementById("weightage" + i).readOnly = true;
//            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("endYearDiv" + i).style.cursor = "default";
//            var finalScore = document.getElementById("finalScore" + i).value;
//            document.getElementById("finalScore" + i).readOnly = true;
//            //// add for employeefinal score
//            var empfinalScore = document.getElementById("empfinalScore" + i).value;
//            document.getElementById("empfinalScore" + i).readOnly = true;
////            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
////            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
////validation
//            document.getElementById("midYearDiv" + i).required = true;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).required = true;
//            document.getElementById("empMidyearSelfassOtheractivty").required = true;
//        }
        else if (flagEndId == 'true') {
            document.getElementById("kraGoal" + i).required = true;
            document.getElementById("metric" + i).required = true;
            var weightage11 = document.getElementById("weightage" + i).value;
            document.getElementById("weightage" + i).required = true;
//            document.getElementById("weightage" + i).readOnly = true;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
            //// add for employeefinal score

            var empfinalScore = document.getElementById("empfinalScore" + i).value;
            document.getElementById("empfinalScore" + i).required = true;
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
            ///validation////
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).required = true;
//            document.getElementById("empEndyearSelfassOtheractivty").required = true;
            // Individual Development Plan validation
//            document.getElementById("text" + i).required = true;
        } else {

//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";
            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
            //// add for employeefinal score
            var empfinalScore = document.getElementById("empfinalScore" + i).value;
            document.getElementById("empfinalScore" + i).readOnly = true;
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;

        }

    });
});
function removeChild1(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, removeRowId_6, removeRowId_7, removeRowId_8, removeRowId_9)
{
//    alert("Dhaval");
    try {


        i--;
        document.getElementById("countId").value = i;
//        alert("Dhaval" + i);
        var element1 = document.getElementById(removeRowId_1);
//        var element2 = document.getElementById(removeRowId_2);
//        var element3 = document.getElementById(removeRowId_3);
        var element4 = document.getElementById(removeRowId_4);
        var element5 = document.getElementById(removeRowId_5);
        var element6 = document.getElementById(removeRowId_6);
        var element7 = document.getElementById(removeRowId_7);
        var element8 = document.getElementById(removeRowId_8);
        var element9 = document.getElementById(removeRowId_9);
        element1.parentNode.removeChild(element1);
//        element2.parentNode.removeChild(element2);
//        element3.parentNode.removeChild(element3);
        element4.parentNode.removeChild(element4);
        element5.parentNode.removeChild(element5);
        element6.parentNode.removeChild(element6);
        element7.parentNode.removeChild(element7);
        element8.parentNode.removeChild(element8);
        element9.parentNode.removeChild(element9);
    } catch (e) {

    }
}
function removeChild3(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
{
//    , 'removeKRAID${status.count}'
    try {
        var val = document.getElementById("countId").value;
        document.getElementById("countId").value = (--val);
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
                    document.getElementById("removeKRAID" + m).value;
                    try {

                        $("#removeKRAID" + m).attr('id', "removeKRAID" + counter);

                    } catch (err) {

                    }
                    //replace id
                    $("#kraGoal" + m).attr('id', "kraGoal" + counter);
                    $("#metric" + m).attr('id', "metric" + counter);
                    $("#kraCategoryMap" + m).attr('id', "kraCategoryMap" + counter);
                    $("#weightage" + m).attr('id', "weightage" + counter);
                    $("#midYearDiv" + m).attr('id', "midYearDiv" + counter);
                    $("#endYearDiv" + m).attr('id', "endYearDiv" + counter);
                    $("#finalScore" + m).attr('id', "finalScore" + counter);
                    $("#EditByEmployee" + m).attr('id', "EditByEmployee" + counter);
                    $("#employeeMidYearSelfAssesssmentGoal" + m).attr('id', "employeeMidYearSelfAssesssmentGoal" + counter);
                    $("#managerMidYearSelfAssesssmentGoal" + m).attr('id', "managerMidYearSelfAssesssmentGoal" + counter);
                    $("#employeeEndYearSelfAssesssmentGoal" + m).attr('id', "employeeEndYearSelfAssesssmentGoal" + counter);
                    $("#managerEndYearSelfAssesssmentGoal" + m).attr('id', "managerEndYearSelfAssesssmentGoal" + counter);
                    $("#kragoal_id" + m).attr('id', "kragoal_id" + counter);
                    //name replace
                    $("#kraGoal" + counter).attr('name', "kraGoal" + counter);
                    $("#metric" + counter).attr('name', "metric" + counter);
                    $("#kraCategoryMap" + counter).attr('name', "kraCategoryMap" + counter);
                    $("#weightage" + counter).attr('name', "weightage" + counter);
                    $("#midYearDiv" + counter).attr('name', "midYearDiv" + counter);
                    $("#endYearDiv" + counter).attr('name', "endYearDiv" + counter);
                    $("#finalScore" + counter).attr('name', "finalScore" + counter);
                    $("#EditByEmployee" + counter).attr('name', "EditByEmployee" + counter);
                    $("#employeeMidYearSelfAssesssmentGoal" + counter).attr('name', "employeeMidYearSelfAssesssmentGoal" + counter);
                    $("#managerMidYearSelfAssesssmentGoal" + counter).attr('name', "managerMidYearSelfAssesssmentGoal" + counter);
                    $("#employeeEndYearSelfAssesssmentGoal" + counter).attr('name', "employeeEndYearSelfAssesssmentGoal" + counter);
                    $("#managerEndYearSelfAssesssmentGoal" + counter).attr('name', "managerEndYearSelfAssesssmentGoal" + counter);
                    $("#kragoal_id" + counter).attr('name', "kragoal_id" + counter);
//                    $("#EditByEmployee" + m).attr('onclick', "changeReadonly('" + counter + "')");
                } catch (err) {
//                    alert('Old ' + (m + 1) + ' New ' + counter);
//                    alert("dhaval");
                    try {

                        document.getElementById("removeKRAID" + (m + 1)).value;
                        $("#removeKRAID" + (m + 1)).attr('id', "removeKRAID" + counter);
                    } catch (err) {

                    }
                    //repalce id
                    $("#kraGoal" + (m + 1)).attr('id', "kraGoal" + counter);
                    $("#metric" + (m + 1)).attr('id', "metric" + counter);
                    $("#kraCategoryMap" + (m + 1)).attr('id', "kraCategoryMap" + counter);
                    $("#weightage" + (m + 1)).attr('id', "weightage" + counter);
                    $("#midYearDiv" + (m + 1)).attr('id', "midYearDiv" + counter);
                    $("#endYearDiv" + (m + 1)).attr('id', "endYearDiv" + counter);
                    $("#finalScore" + (m + 1)).attr('id', "finalScore" + counter);
                    $("#EditByEmployee" + (m + 1)).attr('id', "EditByEmployee" + counter);
                    $("#employeeMidYearSelfAssesssmentGoal" + (m + 1)).attr('id', "employeeMidYearSelfAssesssmentGoal" + counter);
                    $("#managerMidYearSelfAssesssmentGoal" + (m + 1)).attr('id', "managerMidYearSelfAssesssmentGoal" + counter);
                    $("#employeeEndYearSelfAssesssmentGoal" + (m + 1)).attr('id', "employeeEndYearSelfAssesssmentGoal" + counter);
                    $("#managerEndYearSelfAssesssmentGoal" + (m + 1)).attr('id', "managerEndYearSelfAssesssmentGoal" + counter);
                    $("#kragoal_id" + (m + 1)).attr('id', "kragoal_id" + counter);
                    //replace name
                    $("#kraGoal" + counter).attr('name', "kraGoal" + counter);
                    $("#metric" + counter).attr('name', "metric" + counter);
                    $("#kraCategoryMap" + counter).attr('name', "kraCategoryMap" + counter);
                    $("#weightage" + counter).attr('name', "weightage" + counter);
                    $("#midYearDiv" + counter).attr('name', "midYearDiv" + counter);
                    $("#endYearDiv" + counter).attr('name', "endYearDiv" + counter);
                    $("#finalScore" + counter).attr('name', "finalScore" + counter);
                    $("#EditByEmployee" + counter).attr('name', "EditByEmployee" + counter);
                    $("#employeeMidYearSelfAssesssmentGoal" + counter).attr('name', "employeeMidYearSelfAssesssmentGoal" + counter);
                    $("#managerMidYearSelfAssesssmentGoal" + counter).attr('name', "managerMidYearSelfAssesssmentGoal" + counter);
                    $("#employeeEndYearSelfAssesssmentGoal" + counter).attr('name', "employeeEndYearSelfAssesssmentGoal" + counter);
                    $("#managerEndYearSelfAssesssmentGoal" + counter).attr('name', "managerEndYearSelfAssesssmentGoal" + counter);
                    $("#kragoal_id" + counter).attr('name', "kragoal_id" + counter);

                    m++;
                }
                document.getElementById("removeKRAID" + counter).innerHTML = counter;
                $("#EditByEmployee" + counter).attr('onclick', "changeReadonly('" + counter + "')");

                counter++;
            }
        } catch (err) {
        }
        var kraremovedIdVal = document.getElementById('kraremovedIdVal').value;
        document.getElementById('kraremovedIdVal').value = kraremovedIdVal + "," + id;
        weightageCountEmp();
    } catch (e) {

    }
}

// Additional Activity / Project

////////////////////////////changes by date 4-26-2017////new PMP///////////////////////////////////////////
//function removeActivityChild(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
//{
////    , 'removeKRAID${status.count}'
//    try {
//        var val = document.getElementById("countactivityId").value;
//        document.getElementById("countactivityId").value = (--val);
//        var element1 = document.getElementById(removeRowId_1);
//        var element2 = document.getElementById(removeRowId_2);
//        var element3 = document.getElementById(removeRowId_3);
//        var element4 = document.getElementById(removeRowId_4);
//        var element5 = document.getElementById(removeRowId_5);
//        element1.parentNode.removeChild(element1);
//        element2.parentNode.removeChild(element2);
//        element3.parentNode.removeChild(element3);
//        element4.parentNode.removeChild(element4);
//        element5.parentNode.removeChild(element5);
//        var counter = 1;
//        try {
//            for (var m = 1; m <= (val + 1); m++) {
//                try {
//                    document.getElementById("removeKRAactivitiesID" + m).value;
//                    $("#removeKRAactivitiesID" + m).attr('id', "removeKRAactivitiesID" + counter);
//                    //replace id
//                    $("#kraGoal_activity" + m).attr('id', "kraGoal_activity" + counter);
//                    $("#metric_activity" + m).attr('id', "metric_activity" + counter);
//                    $("#kraCategoryMapOther" + m).attr('id', "kraCategoryMapOther" + counter);
//                    $("#priority" + m).attr('id', "priority" + counter);
//                    $("#midYearDivOther" + m).attr('id', "midYearDivOther" + counter);
//                    $("#endYearDivOther" + m).attr('id', "endYearDivOther" + counter);
//                    $("#activity" + m).attr('id', "activity" + counter);
//                    $("#EditByEmployeeact" + m).attr('id', "EditByEmployeeact" + counter);
//                    $("#empMidyearSelfassessmentGoalActivities" + m).attr('id', "empMidyearSelfassessmentGoalActivities" + counter);
//                    $("#managerMidYearSelfAssesssmentGoalActivities" + m).attr('id', "managerMidYearSelfAssesssmentGoalActivities" + counter);
//                    $("#empEndyearSelfassessmentGoalActivities" + m).attr('id', "empEndyearSelfassessmentGoalActivities" + counter);
//                    $("#managerEndYearSelfAssesssmentGoalActivities" + m).attr('id', "managerEndYearSelfAssesssmentGoalActivities" + counter);
//                    $("#kragoal_activity_id" + m).attr('id', "kragoal_activity_id" + counter);
//                    //name replace
//                    $("#kraGoal_activity" + counter).attr('name', "kraGoal_activity" + counter);
//                    $("#metric_activity" + counter).attr('name', "metric_activity" + counter);
//                    $("#kraCategoryMapOther" + counter).attr('name', "kraCategoryMapOther" + counter);
//                    $("#priority" + counter).attr('name', "priority" + counter);
//                    $("#midYearDivOther" + counter).attr('name', "midYearDivOther" + counter);
//                    $("#endYearDivOther" + counter).attr('name', "endYearDivOther" + counter);
//                    $("#activity" + counter).attr('name', "activity" + counter);
//                    $("#EditByEmployeeact" + counter).attr('name', "EditByEmployeeact" + counter);
//                    $("#empMidyearSelfassessmentGoalActivities" + counter).attr('name', "empMidyearSelfassessmentGoalActivities" + counter);
//                    $("#managerMidYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerMidYearSelfAssesssmentGoalActivities" + counter);
//                    $("#empEndyearSelfassessmentGoalActivities" + counter).attr('name', "empEndyearSelfassessmentGoalActivities" + counter);
//                    $("#managerEndYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerEndYearSelfAssesssmentGoalActivities" + counter);
//                    $("#kragoal_activity_id" + counter).attr('name', "kragoal_activity_id" + counter);
//                } catch (err) {
//
//                    document.getElementById("removeKRAactivitiesID" + (m + 1)).value;
//                    $("#removeKRAactivitiesID" + (m + 1)).attr('id', "removeKRAactivitiesID" + counter);
//                    //repalce id
//                    $("#kraGoal_activity" + (m + 1)).attr('id', "kraGoal_activity" + counter);
//                    $("#metric_activity" + (m + 1)).attr('id', "metric_activity" + counter);
//                    $("#kraCategoryMapOther" + (m + 1)).attr('id', "kraCategoryMapOther" + counter);
//                    $("#priority" + (m + 1)).attr('id', "priority" + counter);
//                    $("#midYearDivOther" + (m + 1)).attr('id', "midYearDivOther" + counter);
//                    $("#endYearDivOther" + (m + 1)).attr('id', "endYearDivOther" + counter);
//                    $("#activity" + (m + 1)).attr('id', "activity" + counter);
//                    $("#EditByEmployeeact" + (m + 1)).attr('id', "EditByEmployeeact" + counter);
//                    $("#empMidyearSelfassessmentGoalActivities" + (m + 1)).attr('id', "empMidyearSelfassessmentGoalActivities" + counter);
//                    $("#managerMidYearSelfAssesssmentGoalActivities" + (m + 1)).attr('id', "managerMidYearSelfAssesssmentGoalActivities" + counter);
//                    $("#empEndyearSelfassessmentGoalActivities" + (m + 1)).attr('id', "empEndyearSelfassessmentGoalActivities" + counter);
//                    $("#managerEndYearSelfAssesssmentGoalActivities" + (m + 1)).attr('id', "managerEndYearSelfAssesssmentGoalActivities" + counter);
//                    $("#kragoal_activity_id" + (m + 1)).attr('id', "kragoal_activity_id" + counter);
//
//                    //replace name
//                    $("#kraGoal_activity" + counter).attr('name', "kraGoal_activity" + counter);
//                    $("#metric_activity" + counter).attr('name', "metric_activity" + counter);
//                    $("#kraCategoryMapOther" + counter).attr('name', "kraCategoryMapOther" + counter);
//                    $("#priority" + counter).attr('name', "priority" + counter);
//                    $("#midYearDivOther" + counter).attr('name', "midYearDivOther" + counter);
//                    $("#endYearDivOther" + counter).attr('name', "endYearDivOther" + counter);
//                    $("#activity" + counter).attr('name', "activity" + counter);
//                    $("#EditByEmployeeact" + counter).attr('name', "EditByEmployeeact" + counter);
//                    $("#empMidyearSelfassessmentGoalActivities" + counter).attr('name', "empMidyearSelfassessmentGoalActivities" + counter);
//                    $("#managerMidYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerMidYearSelfAssesssmentGoalActivities" + counter);
//                    $("#empEndyearSelfassessmentGoalActivities" + counter).attr('name', "empEndyearSelfassessmentGoalActivities" + counter);
//                    $("#managerEndYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerEndYearSelfAssesssmentGoalActivities" + counter);
//                    $("#kragoal_activity_id" + counter).attr('name', "kragoal_activity_id" + counter);
//                    m++;
//                }
//                document.getElementById("removeKRAactivitiesID" + counter).innerHTML = counter;
//                $("#EditByEmployeeact" + counter).attr('onclick', "changeReadonlyOther('" + counter + "')");
//                counter++;
//            }
//
//        } catch (err) {
//
//        }
//        var kraremovedActivitiesIdVal = document.getElementById('kraremovedActivitiesIdVal').value;
//        document.getElementById('kraremovedActivitiesIdVal').value = kraremovedActivitiesIdVal + "," + id;
//    } catch (e) {
//
//    }
//}

////////////////////////////changes by date 4-26-2017////new PMP///////////////////////////////////////////

// Individual //Chabage by Date 11/11/2016

//function removeIndividualChild(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
//{
////    , 'removeKRAID${status.count}'
//    try {
//        var val = document.getElementById("IndividualId").value;
//        document.getElementById("IndividualId").value = (--val);
//        var element1 = document.getElementById(removeRowId_1);
//        var element2 = document.getElementById(removeRowId_2);
//        var element3 = document.getElementById(removeRowId_3);
//        var element4 = document.getElementById(removeRowId_4);
//        var element5 = document.getElementById(removeRowId_5);
//        element1.parentNode.removeChild(element1);
//        element2.parentNode.removeChild(element2);
//        element3.parentNode.removeChild(element3);
//        element4.parentNode.removeChild(element4);
//        element5.parentNode.removeChild(element5);
//        var counter = 1;
//        try {
//            for (var m = 1; m <= (val + 1); m++) {
//                try {
//                    document.getElementById("removeKRAIndividualID" + m).value;
//                    $("#removeKRAIndividualID" + m).attr('id', "removeKRAIndividualID" + counter);
//                    //replace id
//                    $("#text" + m).attr('id', "text" + counter);
//                    $("#individualtextDiv" + m).attr('id', "individualtextDiv" + counter);
//                    $("#trainingSelectId" + m).attr('id', "trainingSelectId" + counter);
//                    $("#trainingSelectTextinput" + m).attr('id', "trainingSelectTextinput" + counter);
//                    $("#midYearRetxtId" + m).attr('id', "midYearRetxtId" + counter);
//                    $("#endYearRetxtId" + m).attr('id', "endYearRetxtId" + counter);
//                    $("#managerMidYearRemark" + m).attr('id', "managerMidYearRemark" + counter);
//                    $("#managerEndYearRemark" + m).attr('id', "managerEndYearRemark" + counter);
//                    $("#IndividualDevelopmentPlanId" + m).attr('id', "IndividualDevelopmentPlanId" + counter);
//                    //name replace
//                    $("#text" + counter).attr('name', "text" + counter);
//                    $("#individualtextDiv" + counter).attr('name', "individualtextDiv" + counter);
//                    $("#trainingSelectId" + counter).attr('name', "trainingSelectId" + counter);
//                    $("#trainingSelectTextinput" + counter).attr('name', "trainingSelectTextinput" + counter);
//                    $("#midYearRetxtId" + counter).attr('name', "midYearRetxtId" + counter);
//                    $("#endYearRetxtId" + counter).attr('name', "endYearRetxtId" + counter);
//                    $("#managerMidYearRemark" + counter).attr('name', "managerMidYearRemark" + counter);
//                    $("#managerEndYearRemark" + counter).attr('name', "managerEndYearRemark" + counter);
//                    $("#IndividualDevelopmentPlanId" + counter).attr('name', "IndividualDevelopmentPlanId" + counter);
//                } catch (err) {
//
//                    document.getElementById("removeKRAIndividualID" + (m + 1)).value;
//                    $("#removeKRAIndividualID" + (m + 1)).attr('id', "removeKRAIndividualID" + counter);
//
//                    //repalce id
//                    $("#text" + (m + 1)).attr('id', "text" + counter);
//                    $("#individualtextDiv" + (m + 1)).attr('id', "individualtextDiv" + counter);
//                    $("#trainingSelectId" + (m + 1)).attr('id', "trainingSelectId" + counter);
//                    $("#trainingSelectTextinput" + (m + 1)).attr('id', "trainingSelectTextinput" + counter);
//                    $("#midYearRetxtId" + (m + 1)).attr('id', "midYearRetxtId" + counter);
//                    $("#endYearRetxtId" + (m + 1)).attr('id', "endYearRetxtId" + counter);
//                    $("#managerMidYearRemark" + (m + 1)).attr('id', "managerMidYearRemark" + counter);
//                    $("#managerEndYearRemark" + (m + 1)).attr('id', "managerEndYearRemark" + counter);
//                    $("#IndividualDevelopmentPlanId" + (m + 1)).attr('id', "IndividualDevelopmentPlanId" + counter);
//
//                    //replace name
//                    $("#text" + counter).attr('name', "text" + counter);
//                    $("#individualtextDiv" + counter).attr('name', "individualtextDiv" + counter);
//                    $("#trainingSelectId" + counter).attr('name', "trainingSelectId" + counter);
//                    $("#trainingSelectTextinput" + counter).attr('name', "trainingSelectTextinput" + counter);
//                    $("#midYearRetxtId" + counter).attr('name', "midYearRetxtId" + counter);
//                    $("#endYearRetxtId" + counter).attr('name', "endYearRetxtId" + counter);
//                    $("#managerMidYearRemark" + counter).attr('name', "managerMidYearRemark" + counter);
//                    $("#managerEndYearRemark" + counter).attr('name', "managerEndYearRemark" + counter);
//                    $("#IndividualDevelopmentPlanId" + counter).attr('name', "IndividualDevelopmentPlanId" + counter);
//                    m++;
//                }
//                document.getElementById("removeKRAIndividualID" + counter).innerHTML = counter;
//                counter++;
//            }
//        } catch (err) {
//        }
//        var kraremovedIndividualIdVal = document.getElementById('kraremovedIndividualIdVal').value;
//        document.getElementById('kraremovedIndividualIdVal').value = kraremovedIndividualIdVal + "," + id;
//    } catch (e) {
//
//    }
//}
//Chabage by Date 11/11/2016
//===========================================================================
//Chabage by Date 26/04/2017========activity===========================
//var i = 1;
//$(function () {
//    $("#addactivityRowButtonId").on("click", function () {
//        var flag11 = document.getElementById("flagId").value;
//        var flagMidId = document.getElementById("flagMidId").value;
//        var flagEndId = document.getElementById("flagEndId").value;
////        alert("DDDD=======>" + flag11);
////        alert(flagMidId);
////        alert(flagMidId);
//
//        a1 = document.getElementById("countactivityId").value;
////        alert("a1" + a1);
//        xx = document.getElementById("kragoalLengthactivity").value;
////        alert("xx" + xx);
//        if (a1 == 0) {
//            a1 = 1;
//        } else {
//            a1++;
//        }
////        if (a1 <= 2) {
//
////        a1++;
//        xx++;
////            
//        var clone = "<tr id='row_1_a" + a1 + "' style='clear:both;'>"
////                + "<td valign=\"middle\">" + a1 + "</td>"
//                + "<td id='removeKRAactivitiesID" + a1 + "' class='removeactivitiesClass' style='margin: 0px;width: 45px;' valign=\"middle\">" + a1 + "</td>"
//                + "<td id=\"\"><textarea name=\"kraGoal_activity" + a1 + "\" id=\"kraGoal_activity" + a1 + "\" class=\"form-control saveRequried\"></textarea><span id=\"kraGoalErr" + a1 + "\" style=\"color:red;\"></td>"
//                + "<td id=\"\"><textarea name=\"metric_activity" + a1 + "\" id=\"metric_activity" + a1 + "\" class=\"form-control saveRequried\"></textarea></td>"
//
//                + "<td id=\"currency_div_td_" + a1 + "\"><div>"
//                + "<select id='kraCategoryMapOther" + a1 + "' name='kraCategoryMapOther" + a1 + "' class=\"form-control saveRequried\">"
//                + "</select>"
//                + "</div></td>"
//                + "<td id=\"flagId1_a" + a1 + "\">"
//                + " <select id=\"priority" + a1 + "\" name=\"priority" + a1 + "\" class=\"form-control saveRequried\" style=\"margin: 0px; width: 115px; \">"
//                + " <option value=\"\">--SELECT--</option>"
//                + " <option value=\"High Priority\">High Priority</option>"
//                + " <option value=\"Medium Priority\">Medium Priority</option>"
//                + " <option value=\"Low Priority\">Low Priority</option>"
//                + "</select>"
//                + "</td>"
//                + "<td id=\"flagId2_a" + a1 + "\"><div><select id=\"midYearDivOther" + a1 + "\" name=\"midYearDivOther" + a1 + "\" class=\"form-control saveRequried\">"
//                + "<option value=\"\">--SELECT--</option>"
//                + "<option value=\"Yet to Start\">Yet to Start</option>"
//                + "<option value=\"In Progress\">In Progress</option>"
//                + "<option value=\"Completed\">Completed</option>"
//                + "<option value=\"Canceled\">Canceled</option></select>"
//                + "</div></td>"
//                + "<td id=\"flagId3_a" + a1 + "\"><div><select id=\"endYearDivOther" + a1 + "\" name=\"endYearDivOther" + a1 + "\" class=\"form-control saveRequried\">"
//                + "<option value=\"\">--SELECT--</option>"
//                + "<option value=\"Yet to Start\">Yet to Start</option>"
//                + "<option value=\"In Progress\">In Progress</option>"
//                + "<option value=\"Completed\">Completed</option>"
//                + "<option value=\"Canceled\">Canceled</option></select>"
//                + "</div></td>"
//
//                + "<td id=\"flagId4_a" + a1 + "\">"
//                + "<select id=\"activity" + a1 + "\" name=\"activity" + a1 + "\" class=\"form-control saveRequried\" style=\"margin: 0px;width: 115px;\">"
//                + " <option value=\"\">--SELECT--</option>"
//                + "<option value=\"Excellent\">Excellent</option>"
//                + "<option value=\"Very Good\">Very Good</option>"
//                + "<option value=\"Good\">Good</option>"
//                + " <option value=\"Average\">Average</option>"
//                + " <option value=\"Needs Improvement\">Needs Improvement</option>"
//                + " </select>"
//                + "</td>"
//
//                + "<td style=\"text-align: center\" id=\"edit" + a1 + "\">"
//                + "<span style=\'margin-top: 5px;\' id=\"editC" + a1 + "\">"
//                + "<button type=\"button\" class=\"btns btn-warnings\">Edit</button>"
//                + "</span><br/>"
//
//                + "<td id=\"\" style=\"text-align: center\">"
//                + "<span style='margin-top: 5px;'>"
//                + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId1\" onclick=\"removeChild12('row_1_a" + a1 + "', 'row_2_a" + a1 + "', 'row_3_a" + a1 + "', 'row_4_a" + a1 + "', 'row_5_a" + a1 + "', 'row_6_a" + a1 + "', 'row_7_a" + a1 + "', 'row_8_a" + a1 + "', 'row_9_a" + a1 + "');\">"
//                + "</span>"
//                + "</td>"
//                + "</tr>"
//                + "<tr id=\"row_2_a" + a1 + "\">"
//                //<![CDATA[
//                + "<td colspan=\"4\"><b>Employees Mid - Year Self – Assessment For Other Project:</b></td>"
//                + "<td colspan=\"4\"><b\>Managers Mid - Year Review / Evaluation For Other Projects:</b\></td>"
//                + "</tr>"
//                + "<tr id=\"row_3_a" + a1 + "\">"
//                + "<td colspan=\"4\"><textarea id=\"empMidyearSelfassessmentGoalActivities" + a1 + "\" name=\"empMidyearSelfassessmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control saveRequried\"></textarea></td>"
//                + "<td colspan=\"4\"><textarea id=\"managerMidYearSelfAssesssmentGoalActivities" + a1 + "\" name=\"managerMidYearSelfAssesssmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control saveRequried\"></textarea></td>"
//                + "</tr>"
//
//                + "<tr id=\"row_4_a" + a1 + "\">"
//                + "<td colspan=\"4\"><b>Employees End - Year Self – Assessment For Other Project:</b></td>"
//                + "<td colspan=\"4\"><b>Managers End - Year Review / Evaluation For Other Project:</b></td>"
//                + "</tr>"
//                + "<tr id=\"row_5_a" + a1 + "\">"
//                + "<td colspan=\"4\"><textarea id=\"empEndyearSelfassessmentGoalActivities" + a1 + "\" name=\"empEndyearSelfassessmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control saveRequried\"></textarea></td>"
//                + "<td colspan=\"4\"><textarea id=\"managerEndYearSelfAssesssmentGoalActivities" + a1 + "\" name=\"managerEndYearSelfAssesssmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control saveRequried\"></textarea></td>"
//                + "</tr>";//]]>
//        $("#demo10").append(clone);
////        }
//
//        document.getElementById("countactivityId").value = a1;
//        optionsofKraCategoryOther(a1);
//        document.getElementById("kragoalLengthactivity").value = xx;
//        if (flag11 == 'true') {
////            alert("FIRST YEAR" + flag11);
////            document.getElementById("kraGoal_activity" + a1).required = true;
////            document.getElementById("metric_activity" + a1).required = true;
////            document.getElementById("metric_activity" + a1).required = true;
//
//            document.getElementById("midYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("midYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("endYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("endYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("priority" + a1).style.pointerEvents = "block";
//            document.getElementById("activity" + a1).style.pointerEvents = "none";
//            document.getElementById("activity" + a1).style.cursor = "default";
//
////            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).readOnly = true;
//            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
//            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//        } else if (flagMidId == 'true') {
////            alert("bjjbb" + flagMidId);
////            document.getElementById("kraGoal_activity" + a1).required = true;
////            document.getElementById("metric_activity" + a1).required = true;
////            document.getElementById("kraCategoryMapOther" + a1).required = true;
//
//            document.getElementById("endYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("endYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("activity" + a1).style.pointerEvents = "none";
//            document.getElementById("activity" + a1).style.cursor = "default";
////            var finalScore = document.getElementById("finalScore" + i).value;
////            document.getElementById("finalScore" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
//            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//////validation
//            document.getElementById("midYearDivOther" + a1).required = true;
//            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).required = true;
////            document.getElementById("empMidyearSelfassOtheractivty").required = true;
//        } else if (flagEndId == 'true') {
////            alert("Thired YEAR" + flagEndId);
////            document.getElementById("kraGoal_activity" + a1).required = true;
////            document.getElementById("metric_activity" + a1).required = true;
////            var weightage11 = document.getElementById("weightage" + i).value;
////            document.getElementById("weightage" + i).readOnly = true;
//            document.getElementById("midYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("midYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("activity" + a1).style.pointerEvents = "none";
//            document.getElementById("activity" + a1).style.cursor = "default";
////            var finalScore = document.getElementById("finalScore" + i).value;
////            document.getElementById("finalScore" + i).readOnly = true;
////            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).readOnly = true;
////            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
////            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
////            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//            ///validation////
//            document.getElementById("employeeEndYearSelfAssesssmentGoalActivities" + a1).required = true;
////            document.getElementById("empEndyearSelfassOtheractivty").required = true;
//
//        } else {
//            document.getElementById("midYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("midYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("endYearDivOther" + a1).style.pointerEvents = "none";
//            document.getElementById("endYearDivOther" + a1).style.cursor = "default";
//            document.getElementById("priority" + a1).style.pointerEvents = "block";
//            document.getElementById("activity" + a1).style.pointerEvents = "none";
//            document.getElementById("activity" + a1).style.cursor = "default";
//
////            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).readOnly = true;
//            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
//            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
//            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
//
//        }
//
//    });
//});
//
//function removeChild12(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, removeRowId_6, removeRowId_7, removeRowId_8, removeRowId_9)
//{
////    alert("Dhaval");
//    try {
//
//
//        a1--;
////        alert("Dhaval" + a1);
//        document.getElementById("countactivityId").value = a1;
////        alert("Dhaval" + a1);
//
//
//        var element1 = document.getElementById(removeRowId_1);
////        alert("Dhaval" + element1);
//        var element2 = document.getElementById(removeRowId_2);
////        alert("Dhaval" + element2);
//        var element3 = document.getElementById(removeRowId_3);
////        alert("Dhaval" + element3);
//        var element4 = document.getElementById(removeRowId_4);
////        alert("Dhaval" + element4);
//        var element5 = document.getElementById(removeRowId_5);
////        alert("Dhaval" + element5);
//        var element6 = document.getElementById(removeRowId_6);
////        alert("Dhaval" + element6);
//        var element7 = document.getElementById(removeRowId_7);
////        alert("Dhaval" + element7);
//        var element8 = document.getElementById(removeRowId_8);
////        alert("Dhaval" + element8);
//        var element9 = document.getElementById(removeRowId_9);
////        alert("Dhaval" + element9);
//        element1.parentNode.removeChild(element1);
//        element2.parentNode.removeChild(element2);
//        element3.parentNode.removeChild(element3);
//        element4.parentNode.removeChild(element4);
//        element5.parentNode.removeChild(element5);
//        element6.parentNode.removeChild(element6);
//        element7.parentNode.removeChild(element7);
//        element8.parentNode.removeChild(element8);
//        element9.parentNode.removeChild(element9);
//    } catch (e) {
//
//    }
//}
//Chabage by Date 26/04/2017
//////////////////////////Closed Activity////////////////////////////////////////////////////////////////
//Chabage by Date 11/11/2016
//var j = 1;
//$(function () {
//    var flag11 = document.getElementById("flagId").value;
//    var flagMidId = document.getElementById("flagMidId").value;
//    var flagEndId = document.getElementById("flagEndId").value;
////    alert("WWWWWWWWWWWWWW" + flagEndId);
//    $("#addIndividualId").on("click", function () {
//        j = document.getElementById("IndividualId").value;
//        if (j == 0) {
//            j = 1;
//        }
//        if (j <= 4) {
////        alert("aaa" + j);
//            j++;
////                alert(i1);
//            var clone = "<tr id='1moreFile_1_" + j + "'>"
//                    + "<td style=\"text-align: center\">" + j + "</td>"
//                    + "<td><textarea type=\"Text\" id=\"text" + j + "\" name=\"text" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "<td><div>"
//                    + "<select id=\"individualtextDiv" + j + "\" name=\"individualtextDiv" + j + "\" class=\"form-control\">"
//                    + "<option value=\"\">--SELECT--</option>"
//                    + "<option value=\"Technical\">Technical</option>"
//                    + "<option value=\"Other\">Other</option>"
//                    + "<option value =\"Soft Skill\">Soft Skill</option>"
//                    + "</select>"
//                    + "</div>"
//                    + "</td>"
//                    + "<td><div>"
//                    + "<select id=\"trainingSelectId" + j + "\" name=\"trainingSelectId" + j + "\" class=\"form-control\" onchange=\"trainingSelect(" + j + ")\">"
//                    + "<option value=\"\">--SELECT--</option>"
//                    + "<option value=\"On The Job Training\">On The Job Training</option>"
//                    + "<option value=\"Classroom Training\">Classroom Training</option>"
//                    + "<option value=\"Other\">Other</option>"
//                    + "</select>"
//                    + "</div>"
//                    + "</td>"
//                    + "<td><div>"
//                    + "<textarea class=\"form-control\" id=\"trainingSelectTextinput" + j + "\" name=\"trainingSelectTextinput" + j + "\" style=\"display: none\"></textarea>"
//                    + "</div>"
//                    + "</td>"
//                    + "<td style=\"text-align: center\">"
//                    + "<span style=\'margin-top: 5px;\'>"
//                    + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild_j('1moreFile_1_" + j + "', '1moreFile_2_" + j + "', '1moreFile_3_" + j + "','1moreFile_4_" + j + "','1moreFile_5_" + j + "');\">"
//                    + "</span>"
//                    + "</td>"
//                    + "</tr>"
//
//                    + "<tr id='1moreFile_2_" + j + "'>"
//                    + "<td colspan=\"3\"><b>Employee Mid-Year Remark</b></td>"
//                    + "<td colspan=\"3\"><b>Employee End-Year Remark</b></td>"
//                    + "</tr>"
//                    + "<tr id='1moreFile_3_" + j + "'>"
//                    + "<td colspan=\"3\" id=\"midYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"midYearRemark" + j + "\" name=\"midYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "<td colspan=\"3\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"endYearRemark" + j + "\" name=\"endYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "</tr>"
//                    + "<tr id='1moreFile_4_" + j + "'>"
//                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager Mid-Year Remark</b></td>"
//                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager End-Year Remark</b></td>"
//                    + "</tr>"
//                    + "<tr id='1moreFile_5_" + j + "'>"
//                    + "<td colspan=\"3\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"managerMidYearRemark" + j + "\" name=\"managerMidYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "<td colspan=\"3\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"managerEndYearRemark" + j + "\" name=\"managerEndYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "</tr>"; //]]>
//            $("#demo5").append(clone);
//            document.getElementById("IndividualId").value = j;
//        }
//        if (flag11 == 'true') {
/////////indivisual Plan//////
//
////            document.getElementById("text" + j).required = true;
////            document.getElementById("individualtextDiv" + j).required = true;
////            document.getElementById("trainingSelectId" + j).required = true;
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
////                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
////                document.getElementById("trainingSelectTextinput" + j).required = true;
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//
//            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
//            document.getElementById("managerMidYearRemark" + j).readOnly = true;
//            document.getElementById("managerEndYearRemark" + j).readOnly = true;
//        } else if (flagMidId == 'true') {
////            alert("djjdjdjdjdjdjdjdjdjdjdjdjd"+flagMidId);
//
////            document.getElementById("text" + j).required = true;
////            document.getElementById("individualtextDiv" + j).required = true;
////            document.getElementById("trainingSelectId" + j).required = true;
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
////                document.getElementById("trainingSelectTextinput" + j).required = true;
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//
////                alert("djjdjdjdjdjdjdjdjdjdjdjdjd===>"+flagMidId);
//
////            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
//            document.getElementById("managerMidYearRemark" + j).readOnly = true;
//            document.getElementById("managerEndYearRemark" + j).readOnly = true;
////            $('#midYearReId' + j).hide();
////            $('#midYearRetxtId' + j).hide();
////            $('#endYearReId' + j).hide();
////            $('#endYearRetxtId' + j).hide();
//
//        } else if (flagEndId == 'true') {
////            document.getElementById("text" + j).required = true;
////            document.getElementById("individualtextDiv" + j).required = true;
////            document.getElementById("trainingSelectId" + j).required = true;
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
////                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
////                document.getElementById("trainingSelectTextinput" + j).required = true;
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("managerEndYearRemark" + j).readOnly = true;
//            document.getElementById("managerMidYearRemark" + j).readOnly = true;
////            document.getElementById("endYearRemark" + j).readOnly = true;
//        }
//
//    });
//});
//function trainingSelect(j) {
//
////    j = document.getElementById("IndividualId").value;
//    var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
////    alert("HHHHHHHHHHHHHHHHHHHHH");
//
//    if (selectedValue1 == "Other") {
//        document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//    } else {
//        document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//    }
//
//}
//function removeChild_j(removeRow_1_Id, removeRow_2_Id, removeRow_3_Id, removeRow_4_Id, removeRow_5_Id) {
//    j--
//    document.getElementById("IndividualId").value = j;
//    try {
//
//        var element1 = document.getElementById(removeRow_1_Id);
//        var element2 = document.getElementById(removeRow_2_Id);
//        var element3 = document.getElementById(removeRow_3_Id);
//        var element4 = document.getElementById(removeRow_4_Id);
//        var element5 = document.getElementById(removeRow_5_Id);
//        element1.parentNode.removeChild(element1);
//        element2.parentNode.removeChild(element2);
//        element3.parentNode.removeChild(element3);
//        element4.parentNode.removeChild(element4);
//        element5.parentNode.removeChild(element5);
//    } catch (e) {
//
//    }
//}
//function trainingSelectCloneOfTable1(j) {
//    var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//    if (selectedValue1 == "Other") {
//        document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//    } else {
//        document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//    }
//}

//function ajaxfun() {
//
////
//    var competencyEvaluationId = document.getElementById("competencyEvaluation_Id").value;
////    alert('Dhaval Parmar' + competencyEvaluationId);
//    $.ajax({
//        type: "POST",
//        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
////                    data: "selectedvalue=" + selectedVal,
//        data: {"selectedvalue": competencyEvaluationId},
//        dataType: "text",
//        success: function (responseTxt) {
////                        alert(responseTxt);
//            var subCompentency = document.getElementById("demo9").innerHTML = responseTxt;
//            var flag11 = document.getElementById("flagId").value;
//            var flagMidId = document.getElementById("flagMidId").value;
//            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
////            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
////            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);
//            if (flag11 == 'true') {
//                for (i = 1; i <= count; i++) {
//
//                    var compentencyMidYear = document.getElementById("compentencyMidYear" + i).value;
////                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
//            if (flagMidId == 'true') {
////                alert("fdfddffhdf");
//                for (i = 1; i <= count; i++) {
//
//                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
////                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
//            if (flagEndId == 'true') {
////                alert("fdfddffhdf");
//                for (i = 1; i <= count; i++) {
//
//                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
////                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
//                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
//                }
//            }
//
//            //var arr=new Array();
//
//            //arr=responseTxt;
//
//            //if (selectedVal == 'Air') {
////                            document.getElementById("deviateId1").value = responseTxt;
////                        } else {
////
////                            document.getElementById("deviateId1").value = "";
////                        }
////                        data = response;
////                        return response;
//        },
//        error: function () {
//            alert('Please Select Only One Competency Evaluation');
//        }
//    });
//}


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
//alert("a2");
//alert("a3");

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
//alert("a4");
//alert("a5");
//alert("a6");
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

function weightageCountEmp() {

    var total = 1;
    var countId = document.getElementById("countId").value;
//    alert('aaaaaa'+countId);
    var weightage = 0;
    var flag1 = false;
    while (total <= countId) {
        var val = document.getElementById("weightage" + total).value;
        if (val !== "") {
            weightage += parseFloat(val);
        }
        if (val === "" && !flag1) {
            flag1 = true;
        }
        if (weightage > 75) {

            weightage -= parseFloat(val);
            weitageAlert();
            document.getElementById("weightage" + total).value = "";
            break;
        } else {
//            if (!flag1 && total === countId) {
//                weitageAlert();
//                break;
//            } else if (countId === '1' && weightage < 75) {
//                weitageAlert();
//                document.getElementById("weightage" + total).value = "";
//
//                break;
//            }
//            else if (total + '' == countId + '' && weightage < 75 && !flag1) {
////                weitageAlert();
//                weightage -= parseFloat(val);
//                document.getElementById("weightage" + total).value = "";
//            }
        }

        total++;
    }
    document.getElementById("weightageScore").value = weightage;

    if (weightage > 75) {
        document.getElementById("weightageScore").value = "";
    }

}
function CountEmpScore() {
//    alert("aaaaaaaa");


    var total = 1;
    var countId = document.getElementById("countId").value;
//    alert(countId);
//    alert('aaaaaa'+countId);
    var empfinalscore = 0;
    var flag1 = false;
    while (total <= countId) {
        var val = document.getElementById("empfinalScore" + total).value;
//        alert(val);

        if (val !== "") {
            empfinalscore += parseFloat(val);
        }
        if (val === "" && !flag1) {
            flag1 = true;
        }
        if (empfinalscore > 75) {

            empfinalscore -= parseFloat(val);
//            weitageAlert();
            document.getElementById("empfinalScore" + total).value = "";
            break;
        } else {
//            if (!flag1 && total === countId) {
//                weitageAlert();
//                break;
//            } else if (countId === '1' && weightage < 75) {
//                weitageAlert();
//                document.getElementById("weightage" + total).value = "";
//
//                break;
//           
//            else if (total + '' == countId + '' && weightage < 75 && !flag1) {
////                weitageAlert();
//                weightage -= parseFloat(val);
//                document.getElementById("weightage" + total).value = "";
//            }
        }

        total++;
    }
    document.getElementById("empScore").value = empfinalscore;
//    alert(empfinalscore);

    

}
function weitageAlert() {
    var booID = setInterval(function () {
        document.getElementById('bootCloseBtnId').onclick = '';
        clearInterval(booID);
    }, 500);
    bootbox.dialog({
        size: 'small',
        message: "<h1>Oh ! Your Weightage Score is Not Valid…</h1>",
    });
}

/////////////////////////////////////footer///////////////////////////////////////////////////////////////
//if (window.confirm("Are You Sure ! You want to submit")) {
//    
//}
$(document).on("click", ":submit", function (e) {
    var msg = "Are you sure you want to " + $(this).val();

    if (confirm(msg)) {

        if ($(this).val() !== "" && $(this).val() === "submit") {

            var flag11 = document.getElementById("flagId").value;
            var flagmid = document.getElementById("flagMidId").value;
            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
//            var countId = document.getElementById("IndividualId").value;
            var kragoalLength = document.getElementById("kragoalLength").value;
            //var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
            var w1 = document.getElementById("weightageScore").value;
            var w1 = document.getElementById("weightageScore").value;
            if (w1 < 75 || w1 > 75) {
                weitageAlert();
                return false;
            }
            if (flag11 === 'true') {
                document.getElementById("kraGoal1").required = true;
                document.getElementById("metric1").required = true;
                document.getElementById("weightage1").required = true;
                for (i = 1; i <= kragoalLength; i++) {
                    document.getElementById("kraGoal" + i).required = true;
                    document.getElementById("metric" + i).required = true;
                    document.getElementById("kraCategoryMap" + i).required = true;
                    document.getElementById("weightage" + i).required = true;
                }
                var w1 = document.getElementById("weightageScore").value;
                if (w1 < 75 || w1 > 75) {
                    weitageAlert();
                    return false;
                }
//                var kraGoal_activityVar = document.getElementById("kraGoal_activity1").value;
//                if (kraGoal_activityVar !== '') {
//
//                    document.getElementById("kraGoal_activity1").required = true;
//                    document.getElementById("kraCategoryMapOther1").required = true;
//                    document.getElementById("metric_activity1").required = true;
//                    document.getElementById("priority1").required = true;
//
//                }
//            document.getElementById("priority1").required = true;
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoal_activityVar = document.getElementById("kraGoal_activity" + i).value;
//                    if (kraGoal_activityVar !== '') {
//                        document.getElementById("kraGoal_activity" + i).required = true;
//                        document.getElementById("metric_activity" + i).required = true;
//                        document.getElementById("kraCategoryMapOther" + i).required = true;
//                        document.getElementById("priority" + i).required = true;
//                    }
//                }

//                for (i = 1; i <= count; i++) {
//                document.getElementById("competencyStartYear" + i).required = true;
//            document.getElementById("compentencyStartRemark" + i).required = true;

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

                document.getElementById("midYearRemark1").readOnly = true;
                document.getElementById("endYearRemark1").readOnly = true;
//        document.getElementById("kraGoal_activity1").required = true;
//        document.getElementById("metric_activity1").required = true;
//        document.getElementById("priority1").required = true;


//            } 
//            else if (flagmid === 'true') {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
//                document.getElementById("midYearDiv1").required = true;
//                for (i = 1; i <= count; i++) {
//                document.getElementById("compentencyMidYear" + i).required = true;
//            document.getElementById("compentencyMidRemark" + i).required = true;

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
//            document.getElementById("priority1").required = true;
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


//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75 || w1 > 75) {
//                    weitageAlert();
//                    return false;
//                }
//        document.getElementById("kraGoal_activity1").required = true;
//        document.getElementById("metric_activity1").required = true;
//        document.getElementById("priority1").required = true;
//        document.getElementById("kraCategoryMapOther1").required = true;
//        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;

//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var kraGoalactivity = document.getElementById("kraGoal_activity" + i).value;
//                    if (kraGoalactivity !== '') {
//                        document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//                    } else {
//                        document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = false;
//                    }
//                }

//            } 
            } else if (flagEndId === "true") {
                document.getElementById("kraGoal1").required = true;
                document.getElementById("metric1").required = true;
                document.getElementById("weightage1").required = true;
                document.getElementById("endYearDiv1").required = true;

//                for (i = 1; i <= count; i++) {
//                document.getElementById("compentencyEndYear" + i).required = true;
//            document.getElementById("compentencyEndRemark" + i).required = true;
//                }
                for (i = 1; i <= kragoalLength; i++) {

                    document.getElementById("weightage" + i).required = true;
                    document.getElementById("endYearDiv" + i).required = true;
                    document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).required = true;
                }
//                for (i = 1; i <= countId; i++) {
////                document.getElementById("individualtextDiv" + i).required = true;
////                document.getElementById("trainingSelectId" + i).required = true;
//                    var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//                    if (selectedValue1 == "Other") {
//                        document.getElementById("trainingSelectTextinput" + i).required = true;
//                    }
//
//                }

//                var kraGoal_activityVar = document.getElementById("kraGoal_activity1").value;
//                if (kraGoal_activityVar !== '') {
//                    alert("dhahah");
//                    document.getElementById("kraGoal_activity1").required = true;
//                    document.getElementById("kraCategoryMapOther1").required = true;
//                    document.getElementById("metric_activity1").required = true;
//                    document.getElementById("priority1").required = true;
////                document.getElementById("midYearDivOther1").required = true;
//                    document.getElementById("endYearDivOther1").required = true;
//                    document.getElementById("empEndyearSelfassessmentGoalActivities1").required = true;
//
//                }
//            document.getElementById("priority1").required = true;
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


                var w1 = document.getElementById("weightageScore").value;
                if (w1 < 75 || w1 > 75) {
                    weitageAlert();
                    return false;
                }
            }

        } else if ($(this).val() !== "" && $(this).val() === "save") {

//        alert($(this).val());   
            $('.saveRequried').removeAttr('required');

        }
    } else {
//        alert('cancle');
        var w1 = document.getElementById("weightageScore").value;
        if (w1 < 75 || w1 > 75) {
            weitageAlert();
            return false;
        }
        return false;
    }

});

$(document).ready(function () {
//    alert("kdjdssd");
//    performancefinalScoreRatingsEmployee();
    var flag11 = document.getElementById("flagId").value;
    var flag11a = document.getElementById("flagId").value;
//    alert("first Year" + flag11);
//    alert("first Year" + flag11a);
    var flagmid = document.getElementById("flagMidId").value;
//    alert("MID year" + flagmid);
    var flagEndId = document.getElementById("flagEndId").value;
//    alert("End year" + flagEndId);
    var cycleCompletedflag = document.getElementById("cycleCompletedflag").value;
//    alert("completed year" + cycleCompletedflag);
    var kragoalLength = document.getElementById("kragoalLength").value;
    //var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
    var managerStatus = document.getElementById("managerStatus").value;
    var employeeStatus = document.getElementById("employeeStatus").value;
    //var year = document.getElementById("yearparmStr").value;
//    var IndividualId = document.getElementById("IndividualId").value;

//    alert(IndividualId + "<===============IndividualId");
//    alert("XXXXXXXXXXXXXXXXXXXXXXXXX" + kragoalLengthactivity);

    var weightage = document.getElementById("weightage").value;
    var weightageScore = document.getElementById("weightageScore").value;
//    var finalScore = document.getElementById("finalScore1").value;
//    alert(finalScore + "XXXXXXXXXXXXXXXXXXXXXXXXX");

    var countId = document.getElementById("countId").value;
    var bodyId = document.getElementById("bodyId").value;
    var pmpstartyearstatus = document.getElementById("pmpstartyearstatus").value;
    var pmpmidyearstatus = document.getElementById("pmpmidyearstatus").value;
    var pmpendyearstatus = document.getElementById("pmpendyearstatus").value;
    var pmpasEmployee = document.getElementById("pmpasEmployee").value;
//    alert("mid status" + pmpmidyearstatus);
//    alert("End status" + pmpmidyearstatus);
//    alert("pmpasEmployee" + pmpasEmployee);
    if (flag11 === 'true') {
//        if (employeeStatus === '1') {
//            document.getElementById("save").disabled = true;
//        }
//        alert("managerStatus" + managerStatus);
        if (employeeStatus === '1') {
            document.getElementById("EditByEmployee").disabled = true;
//            document.getElementById("addRowButtonId").disabled = true;
        }
//        alert("Coutuuuuuuu" + kragoalLength);
//        document.getElementById("kraGoal1").required = true;
//        document.getElementById("metric1").required = true;
//        }
//        document.getElementById("weightage1").readOnly = true;
//        document.getElementById("midYearDiv1").style.pointerEvents = "none";
//        document.getElementById("midYearDiv1").style.cursor = "default";
        document.getElementById("endYearDiv1").style.pointerEvents = "none";
        document.getElementById("endYearDiv1").style.cursor = "default";

        // add nishant new field
        document.getElementById("finalScore1").readOnly = true;
         document.getElementById("empfinalScore1").readOnly = true;
        for (i = 1; i <= kragoalLength; i++) {
            document.getElementById("empfinalScore" + i).readOnly = true;
        }

//        var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;
//        var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
        var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal1").value;
        document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;

//        var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal1").value;
        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
//        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//        document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
        for (i = 1; i <= kragoalLength; i++) {
//            alert("Coutuuuuuuu" + kragoalLength);
//            if (managerStatus === '0') {10/12-/2016
//                document.getElementById("EditByEmployee" + i).disabled = true;
//            } else {
//                document.getElementById("EditByEmployee" + i).disabled = false;
//            }

            if (managerStatus == '0') {
//                alert("managerStatus" + managerStatus);
                var kra = document.getElementById('kraGoal' + i).readOnly = false;
                document.getElementById("metric" + i).readOnly = false;
            } else {
                var kra = document.getElementById('kraGoal' + i).readOnly = true;
                document.getElementById("metric" + i).readOnly = true;
            }

            ////////////////Convet Float to Integer////////////////////////////////////////
//            var w1 = document.getElementById("weightage" + i).value;
//            if (!w1 == "0") {

//                var abc = Math.round(w1);
//                document.getElementById("weightage" + i).value = abc;
//            }
            //////////////////////////////////////////////////////////////////////////////
//            alert("weightage1"+abc);
            var weightage11 = document.getElementById("weightage" + i).value;
//            document.getElementById("weightage" + i).readOnly = true;
//            var midYearDiv = document.getElementById("midYearDiv" + i).value;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
//            document.getElementById("midYearDiv" + i).disabled = true;
            var endYearDiv = document.getElementById("endYearDiv" + i).value;
//            document.getElementById("endYearDiv" + i).disabled = true;
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";
            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
//            alert("a1");
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
////            alert("a2");
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            alert("a3");
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
////            alert("a4");
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
        }
//    } 
//    else if (flagmid === 'true') {

//        if (employeeStatus === '1') {
//            document.getElementById("save").disabled = true;
//        }
//        if (managerStatus === '0') {
//            document.getElementById("EditByEmployee").disabled = true;
//        }
//        var kra = document.getElementById("kraGoal1").value;
////        document.getElementById("metric1").required = true;
//        /////change by mid
//        if (kra !== '') {
//            document.getElementById("weightage1").readOnly = true;
//        } else {
//            document.getElementById("weightage1").readOnly = false;
//        }
//        document.getElementById("midYearDiv1").style.pointerEvents = "none";
//        document.getElementById("midYearDiv1").style.cursor = "default";
//        document.getElementById("endYearDiv1").style.pointerEvents = "none";
//        document.getElementById("endYearDiv1").style.cursor = "default";
//        document.getElementById("finalScore1").readOnly = true;
//        var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;

//        var empselfassStatus = document.getElementById("midyearEmpSelfassStatus1").value;
//        if (empselfassStatus === '0') {
//            document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;
//        }
//        if (pmpmidyearstatus === 'false' && pmpasEmployee === 'false') {
//
//            document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;
//        }

//        if (pmpendyearstatus === 'false') {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
//        }

//        var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
//        var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal1").value;
//        document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
////        var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal1").value;
//        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
//        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//        document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
//        alert("middate" + flagmid);
//        for (i = 1; i <= kragoalLength; i++) {

//            if (managerStatus === '0') {10/12-/2016
//                document.getElementById("EditByEmployee" + i).disabled = false;
//            } else {
//                document.getElementById("EditByEmployee" + i).disabled = false;
//            }

//            var kra = document.getElementById('kraGoal' + i).readOnly = true;
//            document.getElementById("metric" + i).readOnly = true;
//            var weightage11 = document.getElementById("weightage" + i).value;
//            document.getElementById("weightage" + i).readOnly = true;
//            var endYearDiv = document.getElementById("endYearDiv" + i).value;
//            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("endYearDiv" + i).style.cursor = "default";
////            document.getElementById("endYearDiv" + i).disabled = true;
//            var finalScore = document.getElementById("finalScore" + i).value;
//            document.getElementById("finalScore" + i).style.pointerEvents = "none";
//            document.getElementById("finalScore" + i).style.cursor = "default";
//            document.getElementById("finalScore" + i).disabled = true;
//            var empmidyearself = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            if (pmpmidyearstatus === 'false' && pmpasEmployee === 'false' || empmidyearself == '') {
////                alert("Mid year Div==" + pmpmidyearstatus);
//                document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
////                alert("Mid year Div True");
//                document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            }
//            var empselfassStatus = document.getElementById("midyearEmpSelfassStatus" + i).value;
//            if (empselfassStatus === '0') {
//                document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
//                document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            }


//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = false;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
//        }
//        document.getElementById("empMidyearSelfassOtheractivty").readOnly = false;
//        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//        document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
    } else if ((flagEndId === "true") && (cycleCompletedflag=='false')) {



//        document.getElementById("kraGoal1").required = true;
//        document.getElementById("metric1").required = true;
//        document.getElementById("weightage1").readOnly = true;
//        document.getElementById("midYearDiv1").style.pointerEvents = "none";
//        document.getElementById("midYearDiv1").style.cursor = "default";
//        var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;

        var empendyearStatus = document.getElementById("endyearEmpSelfassStatus1").value;
        if (empendyearStatus === '0') {
            ///// addd emp final score
            document.getElementById("empfinalScore1").readOnly = false;
            for (i = 1; i <= kragoalLength; i++) {
                document.getElementById("empfinalScore" + i).readOnly = false;
            }
            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = false;
        } else {
            document.getElementById("empfinalScore1").readOnly = true;
            for (i = 1; i <= kragoalLength; i++) {
                document.getElementById("empfinalScore" + i).readOnly = true;
            }
            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
        }
//        if (pmpendyearstatus === 'false' && pmpasEmployee === 'false') {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
//        }
//        var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
        var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal1").value;
        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
        if (employeeStatus === '1') {
            document.getElementById("save").disabled = true;
//            document.getElementById("EditByEmployee").disabled = false;
        }
//        if (managerStatus === '0') {
//            document.getElementById("EditByEmployee").disabled = true;
//        }
//        var finalScore = document.getElementById("finalScore1").value;
//        alert(flagEndId + "end");

//        if (finalScore == "") {
//            alert("FinalScore");
//            $('#finalScoreid').hide();
//            $('#finalScoreid').hide();
//        }
        for (i = 1; i <= kragoalLength; i++) {

            if (managerStatus === '0') {
//                alert("Dhaval");
//                document.getElementById("EditByEmployee" + i).disabled = true;
            } else {
//                document.getElementById("EditByEmployee" + i).disabled = false;
            }


            var kra = document.getElementById('kraGoal' + i).readOnly = true;
            document.getElementById("metric" + i).readOnly = true;
            var weightage11 = document.getElementById("weightage" + i).value;
            document.getElementById("weightage" + i).readOnly = true;
//            var midYearDiv = document.getElementById("midYearDiv" + i).value;
////            document.getElementById("midYearDiv" + i).disabled = true;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
//            var endYearDiv = document.getElementById("endYearDiv" + i).value;
//            document.getElementById("endYearDiv" + i).disabled = false;


            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;

            var empendyearStatus = document.getElementById("endyearEmpSelfassStatus" + i).value;
            if (empendyearStatus === '0') {
                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
            } else {
                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            }


//            var aab = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            if (pmpendyearstatus === 'false' && pmpasEmployee === 'false' || aab == "") {
//
//                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
//
//                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            }
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
        }
//        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//        document.getElementById("empEndyearSelfassOtheractivty").readOnly = false;
//        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
    } else if (cycleCompletedflag == 'true') {



//        document.getElementById("kraGoal1").required = true;
//        document.getElementById("metric1").required = true;
//        document.getElementById("weightage1").readOnly = true;
//        document.getElementById("midYearDiv1").style.pointerEvents = "none";
//        document.getElementById("midYearDiv1").style.cursor = "default";
//        var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;

        var empendyearStatus = document.getElementById("endyearEmpSelfassStatus1").value;
//        if (empendyearStatus === '0') {
//            ///// addd emp final score
//            document.getElementById("empfinalScore1").readOnly = false;
//            for (i = 1; i <= kragoalLength; i++) {
//                document.getElementById("empfinalScore" + i).readOnly = false;
//            }
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
            document.getElementById("empfinalScore1").readOnly = true;
            for (i = 1; i <= kragoalLength; i++) {
                document.getElementById("empfinalScore" + i).readOnly = true;
            }
            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
//        }
//        if (pmpendyearstatus === 'false' && pmpasEmployee === 'false') {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("employeeEndYearSelfAssesssmentGoal1").readOnly = true;
//        }
//        var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal1").value;
//        document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
        var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal1").value;
        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
//        if (employeeStatus === '1') {
            document.getElementById("save").disabled = true;
//            document.getElementById("EditByEmployee").disabled = true;
//            document.getElementById("submit").disabled = true;
//        }
//        if (managerStatus === '0') {
//            document.getElementById("EditByEmployee").disabled = true;
//        }
//        var finalScore = document.getElementById("finalScore1").value;
//        alert(flagEndId + "end");

//        if (finalScore == "") {
//            alert("FinalScore");
//            $('#finalScoreid').hide();
//            $('#finalScoreid').hide();
//        }
        for (i = 1; i <= kragoalLength; i++) {

            if (managerStatus === '0') {
//                alert("Dhaval");
//                document.getElementById("EditByEmployee" + i).disabled = true;
            } else {
//                document.getElementById("EditByEmployee" + i).disabled = false;
            }


            var kra = document.getElementById('kraGoal' + i).readOnly = true;
            document.getElementById("metric" + i).readOnly = true;
            var weightage11 = document.getElementById("weightage" + i).value;
            document.getElementById("weightage" + i).readOnly = true;
//            var midYearDiv = document.getElementById("midYearDiv" + i).value;
////            document.getElementById("midYearDiv" + i).disabled = true;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";
//            var endYearDiv = document.getElementById("endYearDiv" + i).value;
//            document.getElementById("endYearDiv" + i).disabled = false;


            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
//            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;

            var empendyearStatus = document.getElementById("endyearEmpSelfassStatus" + i).value;
//            if (empendyearStatus === '0') {
//                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            }


//            var aab = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            if (pmpendyearstatus === 'false' && pmpasEmployee === 'false' || aab == "") {
//
//                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
//
//                document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            }
//            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = false;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
        }
//        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//        document.getElementById("empEndyearSelfassOtheractivty").readOnly = false;
//        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
    } else {

//        offTimeline
//        alert("Offline");
//        document.getElementById("midYearDiv1").style.pointerEvents = "none";
//        document.getElementById("midYearDiv1").style.cursor = "default";
        document.getElementById("endYearDiv1").style.pointerEvents = "none";
        document.getElementById("endYearDiv1").style.cursor = "default";

//        document.getElementById("employeeMidYearSelfAssesssmentGoal1").readOnly = true;
//        document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
//        addd new emp score field
        document.getElementById("empfinalScore1").readOnly = true;
        for (i = 1; i <= kragoalLength; i++) {
            document.getElementById("empfinalScore" + i).readOnly = true;
        }

        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
        document.getElementById('finalScore1').readOnly = true;
        for (i = 1; i <= kragoalLength; i++) {
//            alert("Offline11111111");
            document.getElementById('kraGoal' + i).readOnly = false;
            document.getElementById("metric" + i).readOnly = false;
            document.getElementById("weightage" + i).readOnly = false;

            document.getElementById("kraCategoryMap" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMap" + i).style.cursor = "default";

//            var midYearDiv = document.getElementById("midYearDiv" + i).value;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";

//            var midYearDiv = document.getElementById("endYearDiv" + i).value;
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";

//            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;


        }


//        //Other activity
////        alert("activity");
//        document.getElementById("kraGoal_activity1").readOnly = false;
//        document.getElementById("metric_activity1").readOnly = false;
//
//        document.getElementById("kraCategoryMapOther1").style.pointerEvents = "none";
//        document.getElementById("kraCategoryMapOther1").style.cursor = "default";
//
//
//
//        document.getElementById("priority1").style.pointerEvents = "none";
//        document.getElementById("priority1").style.cursor = "default";
//
//        document.getElementById("midYearDivOther1").style.pointerEvents = "none";
//        document.getElementById("midYearDivOther1").style.cursor = "default";
//
//        document.getElementById("endYearDivOther1").style.pointerEvents = "none";
//        document.getElementById("endYearDivOther1").style.cursor = "default";
//
//        document.getElementById("activity1").style.pointerEvents = "none";
//        document.getElementById("activity1").style.cursor = "default";
//
//        document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
//        document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
//        document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//        document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
//
//        for (i = 1; i <= kragoalLengthactivity; i++) {
//
//            var kraGoal_activityVar = document.getElementById("kraGoal_activity" + i).value;
////            if (kraGoal_activityVar !== '') {
//            //document.getElementById("kraGoal_activity" + i).required = true;
//            //document.getElementById("metric_activity" + i).required = true;
//            //document.getElementById("kraCategoryMapOther" + i).required = true;
//            //document.getElementById("priority" + i).required = true;
//
//            document.getElementById("kraCategoryMapOther" + i).style.pointerEvents = "none";
//            document.getElementById("kraCategoryMapOther" + i).style.cursor = "default";
//
//            document.getElementById("priority" + i).style.pointerEvents = "none";
//            document.getElementById("priority" + i).style.cursor = "default";
//
//            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//            document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
////            }
//        }

////        Competency Evaluation
//        var count = document.getElementById("subCompentencyCount").value;
//        for (i = 1; i <= count; i++) {
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//        }

////        Individual Development Plan
//        var individualId = document.getElementById("IndividualId").value;
//        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
//        document.getElementById("individualtextDiv1").style.cursor = "default";
//        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
//        document.getElementById("trainingSelectId1").style.cursor = "default";
//        for (i = 1; i <= individualId; i++) {
//
//            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
//            document.getElementById("individualtextDiv" + i).style.cursor = "default";
//            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
//            document.getElementById("trainingSelectId" + i).style.cursor = "default";
//        }

//        Behaviors:

        for (i = 1; i <= 5; i++) {
//
//            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
//            document.getElementById("midYearScore" + i).style.cursor = "default";

            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
            document.getElementById("endYearScore" + i).style.pointerEvents = "default";
        }



    }


////////////Behiouer//////////////////
    if (flag11 === 'true') {

        for (i = 1; i <= 5; i++) {
//            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
//            document.getElementById("midYearScore" + i).style.pointerEvents = "default";
            //alert("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");

            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
            document.getElementById("endYearScore" + i).style.pointerEvents = "default";
        }
    }
//    if (flagmid === 'true') {
//        //alert(flagmid);
//        for (i = 1; i <= 5; i++) {
////
////            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
////
////            document.getElementById("midYearScore" + i).style.pointerEvents = "default";
//
//            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
//            document.getElementById("endYearScore" + i).style.pointerEvents = "default";
//        }
//    }
    if (flagEndId === 'true') {
        //alert(flagEndId);
        for (i = 1; i <= 5; i++) {
//            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
//            document.getElementById("midYearScore" + i).style.cursor = "default";
            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
            document.getElementById("endYearScore" + i).style.cursor = "default";
        }

    }
//////////////////Other Activity KRA/////////////////////////////////////////////////////
    //var year = document.getElementById("yearparmStr").value;
    //alert("OOOO");
//    if (year == 2016 && year !== "") {
//        alert("HEllo==" + year);
//
//        if (flag11 === 'true') {
////        alert("dddddd");
////         for (i = 1; i <= kragoalLengthactivity; i++) {
////        document.getElementById("kraGoal_activity1").required = true;
////        document.getElementById("metric_activity1").required = true;
////        document.getElementById("priority1").required = true;
//
//
//            document.getElementById("midYearDivOther1").style.pointerEvents = "none";
//            document.getElementById("midYearDivOther1").style.cursor = "default";
//            document.getElementById("endYearDivOther1").style.pointerEvents = "none";
//            document.getElementById("endYearDivOther1").style.cursor = "default";
//            document.getElementById("activity1").style.pointerEvents = "none";
//            document.getElementById("activity1").style.cursor = "default";
//            var empMidyearSelfassessmentGoalActivities1 = document.getElementById("empMidyearSelfassessmentGoalActivities1").value;
//            document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
//            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
//            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
//            document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
//            for (i = 1; i <= kragoalLengthactivity; i++) {
////            alert(managerStatus);
//                if (managerStatus === '0') {
//                    document.getElementById("EditByEmployeeact" + i).disabled = true;
//                } else {
//                    document.getElementById("EditByEmployeeact" + i).disabled = false;
//                }
//                if (managerStatus == '0') {
////                alert("managerStatus" + managerStatus);
//                    var kra1 = document.getElementById("kraGoal_activity" + i).readOnly = false;
//                    document.getElementById("metric_activity" + i).readOnly = false;
//                } else {
//                    try {
//
//                        document.getElementById("kraGoal_activity" + i).readOnly = true;
//                        document.getElementById("metric_activity" + i).readOnly = true;
//                    } catch (err) {
//                    }
//
//                }
//
//                var midYearDivOther = document.getElementById("midYearDivOther" + i).value;
////            alert("df");
//                document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
////            alert("dfdf123");
//                document.getElementById("midYearDivOther" + i).style.cursor = "default";
////            alert("dfdf5/64");
//                var endYearDivOther = document.getElementById("endYearDivOther" + i).value;
//                document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
//                document.getElementById("endYearDivOther" + i).style.cursor = "default";
//                var activity = document.getElementById("activity" + i).value;
//                document.getElementById("activity" + i).style.pointerEvents = "none";
//                document.getElementById("activity" + i).style.cursor = "default";
////            alert("a1");
//                var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
////            alert("a2");
//                document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
////            alert("a3");
//                var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
////            alert("a4");
//                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//                var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + i).value;
//                document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
//                var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
//                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//            }
//        } else if (flagmid === 'true') {
////        document.getElementById("kraGoal_activity1").required = true;
////        document.getElementById("metric_activity1").required = true;
////        document.getElementById("priority1").required = true;
////        alert("dsf");
////        document.getElementById("kraCategoryMapOther1").required = true;
//
//            document.getElementById("endYearDivOther1").style.pointerEvents = "none";
//            document.getElementById("endYearDivOther1").style.cursor = "default";
//            document.getElementById("activity1").style.pointerEvents = "none";
//            document.getElementById("activity1").style.cursor = "default";
//            var empMidyearActivityStatus = document.getElementById("midyearEmpSelfassActivityStatus1").value;
//            if (empMidyearActivityStatus === '0') {
//                document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = false;
//            } else {
//                document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
//            }
////        if (pmpmidyearstatus === 'false' && pmpasEmployee === 'false') {
//////            alert("Mid year Div==" + pmpmidyearstatus);
////            document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = false;
////        } else {
//////            alert("Mid year Div True");
////            document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
////        }
////        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
//            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
//            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
//            document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
//            for (i = 1; i <= kragoalLengthactivity; i++) {
//
//
//
//
//                if (managerStatus == '0') {
////                alert("managerStatus" + managerStatus);
//                    var kra1 = document.getElementById("kraGoal_activity" + i).readOnly = false;
//                    document.getElementById("metric_activity" + i).readOnly = false;
//                } else {
//                    var kra1 = document.getElementById("kraGoal_activity" + i).readOnly = true;
//                    document.getElementById("metric_activity" + i).readOnly = true;
//                }
//                //alert("dsffdgdfgdfgdgddfgddgdgdg");
//                document.getElementById("kraCategoryMapOther" + i).readOnly = true;
////            var midYearDiv = document.getElementById("midYearDivOther" + i).value;
////            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
////            document.getElementById("midYearDivOther" + i).style.cursor = "default";
//                var endYearDivOther = document.getElementById("endYearDivOther" + i).value;
//                document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
//                document.getElementById("endYearDivOther" + i).style.cursor = "default";
//                document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//                document.getElementById("activity" + i).style.pointerEvents = "none";
//                document.getElementById("activity" + i).style.cursor = "default";
////            alert("a1");
////            var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
//////            alert("a2");
////            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
////            alert("a3");
//                var empMidyearActivityStatus = document.getElementById("midyearEmpSelfassActivityStatus" + i).value;
//                if (empMidyearActivityStatus === '0') {
//                    document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = false;
//                } else {
//                    document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
//                }
//
//
////            if (pmpmidyearstatus === 'false' && pmpasEmployee === 'false') {
//////                alert("Mid year Div==" + pmpmidyearstatus);
////                document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = false;
////            } else {
//////                alert("Mid year Div True");
////                document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
////            }
//                var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
////            alert("a4");
//                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//                var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + i).value;
//                document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
//                var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
//                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//            }
//
//        } else if (flagEndId === 'true') {
////        document.getElementById("kraGoal_activity1").required = true;
////        document.getElementById("metric_activity1").required = true;
////        document.getElementById("priority1").required = true;
//            document.getElementById("midYearDivOther1").style.pointerEvents = "none";
//            document.getElementById("midYearDivOther1").style.cursor = "default";
////                alert("managerStatus");
//
//            document.getElementById("activity1").style.pointerEvents = "none";
//            document.getElementById("activity1").style.cursor = "default";
////        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
//            var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities1").value;
//            document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
//            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
//            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
////        document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
//            var empEndyearActivityStatus = document.getElementById("endyearEmpSelfassActivityStatus1").value;
//            if (empEndyearActivityStatus === '0') {
//                document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = false;
//            } else {
//                document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//            }
//
////        if (pmpendyearstatus === 'false' && pmpasEmployee === 'false') {
//////                alert("Mid year Div==" + pmpmidyearstatus);
////            document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = false;
////        } else {
//////                alert("Mid year Div True");
////            document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
////        }
//
//            for (i = 1; i <= kragoalLengthactivity; i++) {
//
//
//                if (managerStatus == '0') {
////                alert("managerStatus" + managerStatus);
//                    var kra1 = document.getElementById("kraGoal_activity" + i).readOnly = false;
//                    document.getElementById("metric_activity" + i).readOnly = false;
//                } else {
//                    var kra1 = document.getElementById("kraGoal_activity" + i).readOnly = true;
//                    document.getElementById("metric_activity" + i).readOnly = true;
//                }
//
//
//                document.getElementById("activity" + i).style.pointerEvents = "none";
//                document.getElementById("activity" + i).style.cursor = "default";
//                var midYearDivOther = document.getElementById("midYearDivOther" + i).value;
//                document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
//                document.getElementById("midYearDivOther" + i).style.cursor = "default";
////            var endYearDiv = document.getElementById("endYearDivOther" + i).value;
////            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
////            document.getElementById("endYearDivOther" + i).style.cursor = "default";
////            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
////            alert("a1");
//                var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
//                document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
//                var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
//                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
////            var empEndyearSelfassessmentGoalActivities = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
////            document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
//                var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
//                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//
//                var empEndyearActivityStatus = document.getElementById("endyearEmpSelfassActivityStatus" + i).value;
//                if (empEndyearActivityStatus === '0') {
//                    document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = false;
//                } else {
//                    document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
//                }
//
////            if (pmpendyearstatus === 'false' && pmpasEmployee === 'false') {
//////                alert("Mid year Div==" + pmpmidyearstatus);
////                document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = false;
////            } else {
//////                alert("Mid year Div True");
////                document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
////            }
//            }
//        }
//    }

//////////////////Other Activity KRA/////////////////////////////////////////////////////

});
function performancefinalScoreRatingsEmployee() {
//    var totalScore = parseInt(document.getElementById("totalScore").value);
    //    var behaviorsEndyearTotalscore = parseInt(document.getElementById("behaviorsEndyearTotalscore").value);
    //    alert("DODODOD" + behaviorsEndyearTotalscore);
    //    var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore;
//    alert("ajay");
    var behaviorsFinalscore12 = document.getElementById("behaviorsFinalscore").value;
//    alert("POPOPOPO" + behaviorsFinalscore12);
    $('#score1').hide();
    $('#score2').hide();
    $('#score3').hide();
    $('#score4').hide();
    $('#score5').hide();
//    alert("score1" + behaviorsFinalscore12);
    if ((behaviorsFinalscore12 >= 106) && (behaviorsFinalscore12 <= 110))
    {
        $('#score1').show();
    }
    if ((behaviorsFinalscore12 >= 101) && (behaviorsFinalscore12 <= 105))
    {
//        alert("81 to 90");
        $('#score2').show();
    } else if ((behaviorsFinalscore12 >= 80) && (behaviorsFinalscore12 <= 100))
    {
        //        alert("score1" + behaviorsFinalscore12);
//        alert("71 to 80");
        $('#score3').show();
    } else if ((behaviorsFinalscore12 >= 51) && (behaviorsFinalscore12 <= 79))
    {
        //        alert("51 to 70");
        $('#score4').show();
    } else if ((behaviorsFinalscore12 >= 1) && (behaviorsFinalscore12 <= 50))
    {
//        alert("50 to 0");
        $('#score5').show();
    }

}
function changeReadonly1(id) {
//    alert("hello" + id);

    var kra = document.getElementById('kraGoal' + id);
    var metric = document.getElementById('metric' + id);
//    var midYear = document.getElementById('midYearDiv' + id);
    var endYear = document.getElementById('endYearDiv' + id);

    kra.readOnly = false;
    metric.readOnly = false;
//    if (midYear !== null) {
//        midYear.readOnly = false;
//    }
    if (endYear !== null) {
        endYear.readOnly = false;
    }
}

function optionsofKraCategory(id) {
//    alert("Ajay" + id);
    var element2 = document.getElementById('kraCategoryMapHiddenMap');
    var obj2 = document.getElementById("kraCategoryMap" + id);
    for (var i2 = 0; i2 < element2.options.length; i2++) {
        var opt2 = document.createElement("option");
        opt2.value = element2.options[i2].value;
        opt2.text = element2.options[i2].text;
        obj2.appendChild(opt2);
    }
}
function optionsofKraCategoryOther(id) {
//    alert("Ajay" + id);
    var element2 = document.getElementById('kraCategoryMapHiddenMap');
    var obj2 = document.getElementById("kraCategoryMapOther" + id);
    for (var i2 = 0; i2 < element2.options.length; i2++) {
        var opt2 = document.createElement("option");
        opt2.value = element2.options[i2].value;
        opt2.text = element2.options[i2].text;
        obj2.appendChild(opt2);
    }
}



function myajaxfun1(competencyEvaluationId) {

//
//        alert('Dhaval Parmar' + competencyEvaluationId);
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
//            var flagMidId = document.getElementById("flagMidId").value;
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
//            if (flagMidId == 'true') {
////                alert("fdfddffhdf");
//                for (i = 1; i <= count; i++) {
//
//                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
////                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
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