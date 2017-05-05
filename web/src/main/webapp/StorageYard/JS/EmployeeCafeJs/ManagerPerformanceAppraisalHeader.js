/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/////////////////////////Manager side///////////////////////////////////////////////////////////////////////////



var i = 1;
$(function () {
    $("#addRowButtonId").on("click", function () {
        var flag11 = document.getElementById("flagId").value;
        var flagMidId = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;
        var startDate = document.getElementById("startDate1").value;

//        alert("flag11" + flag11);
//        alert("flagMidId" + flagEndId);
//        alert("flagEndId" + flagEndId);
        i = document.getElementById("countId").value;
        if (i == 0) {
            i = 1;
        }
        if (i <= 4) {
            i++;
//                alert(i1);
            var clone = "<tr id='row_1_" + i + "' style='clear:both;'>"
                    + "<td valign=\"middle\">" + i + "</td>"

                    + "<td id=\"\"><textarea name=\"kraGoal" + i + "\" id=\"kraGoal" + i + "\" class=\"form-control\"></textarea></td>"
                    + "<td id=\"\"><textarea name=\"metric" + i + "\" id=\"metric" + i + "\" class=\"form-control\"></textarea></td>"
                    + "<td id=\"currency_div_td_" + i + "\"><div>"
                    + "<select id='kraCategoryMap" + i + "' name='kraCategoryMap" + i + "' class=\"form-control\">"
                    + "</select>"
                    + "</div></td>"
                    + "<td id=\"flagId1_" + i + "\"><input type=\"number\" name=\"weightage" + i + "\" id=\"weightage" + i + "\" class=\"form-control\" onkeypress=\"return allowOnlyNumber(event);\" onchange=\"weightageCount(" + i + ")\"></td>"
                    + "<td id=\"flagId2_" + i + "\"><div><select id=\"midYearDiv" + i + "\" name=\"midYearDiv" + i + "\" class=\"form-control\">"
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
                    // + "<td id=\"flagId4_" + i + "\"><input type=\"Text\" class=\"form-control\"></td>"
                    + "<td id=\"flagId4_" + i + "\"><input type=\"Text\" id=\"finalScore" + i + "\" name=\"finalScore" + i + "\" class=\"form-control\"></td>"
                    //+ "<td style=\"text-align: center\">"
                    // + "<span style=\'margin-top: 5px;\'>"
                    + "<td style=\"text-align: center\" id=\"edit" + i + "\">"
                    + "<span style=\'margin-top: 5px;\' id=\"editC" + i + "\">"
                    + "<button type=\"button\" class=\"btns btn-warnings\">Edit</button>"
                    + "</span><br/>"
                    + "<span>" + startDate + "</span>"
                    + "<input type=\"hidden\" id=\"startDate" + i + "\" name=\"startDate" + i + "\" value=" + startDate + "></td>"
                    + "<td id=\"\" style=\"text-align: center\">"
                    + "<span style='margin-top: 5px;'>"
                    + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild1('row_1_" + i + "', 'row_2_" + i + "', 'row_3_" + i + "', 'row_4_" + i + "', 'row_5_" + i + "', 'row_6_" + i + "', 'row_7_" + i + "', 'row_8_" + i + "', 'row_9_" + i + "');\">"
                    + "</span>"
                    + "</td>"

                    + "</tr>"
//                + "<tr id='row_2_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Employeeâ€™s Mid - Year Self â€“ Assessment Goal:</b></td><td></td><td></td></tr>"
//                + "<tr id='row_3_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" id=\"employeeMidYearSelfAssesssmentGoal" + i + "\" name=\"employeeMidYearSelfAssesssmentGoal" + i + "\" class=\"form-control\"></textarea></td><td></td><td></td></tr>"
//                + "<tr id='row_4_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Managerâ€™s Mid - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>"
//                + "<tr id='row_5_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" id=\"managerMidYearSelfAssesssmentGoal" + i + "\" name=\"managerMidYearSelfAssesssmentGoal" + i + "\" class=\"form-control\"></textarea></td><td></td><td></td>"
//                + "</tr>"
//                + "<tr id='row_6_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Employeeâ€™s End - Year Self â€“ Assessment Goal:</b></td><td></td><td></td></tr>"
//                + "<tr id='row_7_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea id=\"employeeEndYearSelfAssesssmentGoal" + i + "\" name=\"employeeEndYearSelfAssesssmentGoal" + i + "\" type=\"Text\" class=\"form-control\"></textarea></td><td></td><td></td></tr>"
//                + "<tr id='row_8_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><b>Managerâ€™s End - Year Review / Evaluation Goal:</b></td><td></td><td></td></tr>"
//                + "<tr id='row_9_" + i + "' style='clear:both;'><td></td><td colspan=\"6\"><textarea type=\"Text\" id=\"managerEndYearSelfAssesssmentGoal" + i + "\" name=\"managerEndYearSelfAssesssmentGoal" + i + "\" class=\"form-control\"></textarea></td><td></td><td></td></tr>";
//
//<![CDATA[
                    + "<tr id=\"row_2_" + i + "\">"
                    + "<td colspan=\"4\"><b>Employees Mid - Year Self – Assessment KRA:</b></td>"
                    + "<td colspan=\"4\"><b>Managers Mid - Year Review / Evaluation KRA:</b></td>"
                    + "</tr>"
                    + "<tr id=\"row_3_" + i + "\">"
                    + "<td colspan=\"4\"><textarea id=\"employeeMidYearSelfAssesssmentGoal" + i + "\" name=\"employeeMidYearSelfAssesssmentGoal" + i + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"4\"><textarea id=\"managerMidYearSelfAssesssmentGoal" + i + "\" name=\"managerMidYearSelfAssesssmentGoal" + i + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                    + "</tr>"

                    + "<tr id=\"row_4_" + i + "\">"
                    + "<td colspan=\"4\"><b>Employees End - Year Self – Assessment KRA:</b></td>"
                    + "<td colspan=\"4\"><b>Managers End - Year Review / Evaluation KRA:</b></td>"
                    + "</tr>"
                    + "<tr id=\"row_5_" + i + "\">"
                    + "<td colspan=\"4\"><textarea id=\"employeeEndYearSelfAssesssmentGoal" + i + "\" name=\"employeeEndYearSelfAssesssmentGoal" + i + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"4\"><textarea id=\"managerEndYearSelfAssesssmentGoal" + i + "\" name=\"managerEndYearSelfAssesssmentGoal" + i + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                    + "</tr>";//]]>

            $("#demo").append(clone);
        }
        optionsofKraCategory(i);
        document.getElementById("countId").value = i;
        if (flag11 == 'true') {
//            document.getElementById("kraGoal" + i).required = true;
//            document.getElementById("metric" + i).required = true;

            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("midYearDiv" + i).style.cursor = "default";

            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";

            document.getElementById("finalScore" + i).style.pointerEvents = "none";
            document.getElementById("finalScore" + i).style.cursor = "default";





            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;

        } else if (flagMidId == 'true') {
//            alert("Dhasvfsdf" + flagMidId);
            var kra = document.getElementById('kraGoal' + i).readOnly = false;
            document.getElementById("metric" + i).readOnly = false;


//            var w1 = document.getElementById("weightage" + i).value;
//            var abc = Math.round(w1);
//            document.getElementById("weightage" + i).value = abc;

            var endYearDiv = document.getElementById("endYearDiv" + i).value;
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";

            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true;
//            var finalScore = document.getElementById("finalScore" + i).value;
//            document.getElementById("finalScore" + i).style.pointerEvents = "none";
//            document.getElementById("finalScore" + i).style.cursor = "default";
//            document.getElementById("finalScore" + i).disabled = true;
            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = false;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;




        } else if (flagEndId == 'true') {
            var kra = document.getElementById('kraGoal' + i).readOnly = false;
            document.getElementById("metric" + i).readOnly = false;

            var weightage11 = document.getElementById("weightage" + i).value;
            document.getElementById("weightage" + i).readOnly = false;

            var midYearDiv = document.getElementById("midYearDiv" + i).value;
//            document.getElementById("midYearDiv" + i).disabled = true;
            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("midYearDiv" + i).style.cursor = "default";


            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = false;

            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = false;
        }
    });

});

function removeChild1(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, removeRowId_6, removeRowId_7, removeRowId_8, removeRowId_9)
{
    i--;
    document.getElementById("countId").value = i;
    var element1 = document.getElementById(removeRowId_1);
    var element2 = document.getElementById(removeRowId_2);
    var element3 = document.getElementById(removeRowId_3);
    var element4 = document.getElementById(removeRowId_4);
    var element5 = document.getElementById(removeRowId_5);
    var element6 = document.getElementById(removeRowId_6);
    var element7 = document.getElementById(removeRowId_7);
    var element8 = document.getElementById(removeRowId_8);
    var element9 = document.getElementById(removeRowId_9);
    element1.parentNode.removeChild(element1);
    element2.parentNode.removeChild(element2);
    element3.parentNode.removeChild(element3);
    element4.parentNode.removeChild(element4);
    element5.parentNode.removeChild(element5);
    element6.parentNode.removeChild(element6);
    element7.parentNode.removeChild(element7);
    element8.parentNode.removeChild(element8);
    element9.parentNode.removeChild(element9);
}

function removeChild4(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
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
                    $("#removeKRAID" + m).attr('id', "removeKRAID" + counter);
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
                } catch (err) {
                    document.getElementById("removeKRAID" + (m + 1)).value;
                    $("#removeKRAID" + (m + 1)).attr('id', "removeKRAID" + counter);
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
function weightageCountEmp() {
//    alert('aaaaaa');
    var total = 1;
    var countId = document.getElementById("countId").value;
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
            if (!flag1 && total === countId) {
                weitageAlert();
                break;
            } else if (countId === '1' && weightage < 75) {
                weitageAlert();
                document.getElementById("weightage" + total).value = "";

                break;
            } else if (total + '' == countId + '' && weightage < 75 && !flag1) {
                weitageAlert();
                weightage -= parseFloat(val);
                document.getElementById("weightage" + total).value = "";
            }
        }

        total++;
    }
    document.getElementById("weightageScore").value = weightage;
    if (countId === '1' && weightage < 75) {
        document.getElementById("weightageScore").value = "";
    }

}
//function trainingSelect() {
//    var selectedValue1 = document.getElementById("trainingSelectId1").value;
//
//    if (selectedValue1 == "Other") {
//        document.getElementById("trainingSelectTextinput1").style.display = "block";
//    } else {
//        document.getElementById("trainingSelectTextinput1").style.display = "none";
//    }
//
//}
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


//        var j = 1;
//        $(function () {
//            $("#addIndividualId").on("click", function () {
//                j++;
//                var clone = "<tr id='1moreFile_1_" + j + "'>"
//                        + "<td style=\"text-align: center\">" + j + "</td>"
//                        + "<td><textarea type=\"Text\" class=\"form-control\"></textarea></td>"
//                        + "<td><div>"
//                        + "<select id=\"EndYearDiv\" class=\"form-control\">"
//                        + "<option value=\"\">--SELECT--</option>"
//                        + "<option value=\"Air\">Technical</option>"
//                        + "<option value=\"Bus\">Other</option>"
//                        + "<option value =\"SoftSkill\"> Soft Skill </option>"
//                        + "</select>"
//                        + "</div>"
//                        + "</td>"
//                        + "<td><div>"
//                        + "<select id=\"trainingSelectId1_" + j + "\" class=\"form-control\" onchange=\"trainingSelectCloneOfTable1(" + j + ")\">"
//                        + "<option value=\"\">--SELECT--</option>"
//                        + "<option value=\"Air\">On The Job Training</option>"
//                        + "<option value=\"SoftSkill\">Classroom Training</option>"
//                        + "<option value=\"Other\">Other</option>"
//                        + "</select>"
//                        + "</div>"
//                        + "</td>"
//                        + "<td><div>"
//                        + "<textarea class=\"form-control\" id=\"trainingSelectTextinput1_" + j + "\" style=\"display: none\"></textarea>"
//                        + "</div>"
//                        + "</td>"
//                        + "<td style=\"text-align: center\">" //                        + "<span style=\'margin-top: 5px;\'>"
//                        + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId\" onclick=\"removeChild_j('1moreFile_1_" + j + "', '1moreFile_2_" + j + "', '1moreFile_3_" + j + "');\">"
//                        + "</span>"
//                        + "</td>"
//                        + "</tr>"
//                        + "<tr id='1moreFile_2_" + j + "'>"
//                        + "<td></td>"
//                        + "<td><b>Mid-Year Remark</b></td>"
//                        + "<td colspan=\"2\"><textarea rows=\"3\" class=\"form-control\"></textarea></td>"
//                        + "<td></td>"
//                        + "<td></td>"
//                        + "</tr>"
//                        + "<tr id='1moreFile_3_" + j + "'>" //                        + "<td></td>"
//                        + "<td><b>End-Year Remark</b></td>" //                        + "<td colspan=\"2\"><textarea rows=\"3\" class=\"form-control\"></textarea></td>"
//                        + "<td></td>"
//                        + "<td></td>"
//                        + "</tr>";
//                $("#demo5").append(clone);
//            });
//
//


//        }); //////////////////////////ACTIVITY OTHER/////////////////////////////////////////////////////
var i = 1;
$(function () {
    $("#addactivityRowButtonId").on("click", function () {
        var flag11 = document.getElementById("flagId").value;
        var flagMidId = document.getElementById("flagMidId").value;
        var flagEndId = document.getElementById("flagEndId").value;
        //        alert("DDDD=======>" + flag11);
//        alert(flagMidId);
        //        alert(flagMidId);

        a1 = document.getElementById("countactivityId").value;
        //        alert("a1" + a1);
        xx = document.getElementById("kragoalLengthactivity").value;
        //        alert("xx" + xx);
        if (a1 == 0) {
            a1 = 1;
        } //        if (a1 <= 2) {

        a1++;
        xx++;
//            alert(a1);
        var clone = "<tr id='row_1_a" + a1 + "' style='clear:both;'>"
                + "<td valign=\"middle\">" + a1 + "</td>"
                + "<td id=\"\"><textarea name=\"kraGoal_activity" + a1 + "\" id=\"kraGoal_activity" + a1 + "\" class=\"form-control\"></textarea><span id=\"kraGoalErr" + a1 + "\" style=\"color:red;\"></td>"
                + "<td id=\"\"><textarea name=\"metric_activity" + a1 + "\" id=\"metric_activity" + a1 + "\" class=\"form-control\"></textarea></td>"

                + "<td id=\"currency_div_td_" + a1 + "\"><div>"
                + "<select id='kraCategoryMapOther" + a1 + "' name='kraCategoryMapOther" + a1 + "' class=\"form-control\">"
                + "</select>"
                + "</div></td>"


                + "<td id=\"flagId1_a" + a1 + "\">"
                + " <select id=\"priority" + a1 + "\" name=\"priority" + a1 + "\" class=\"form-control\" style=\"margin: 0px; width: 115px; \">"
                + " <option value=\"\">--SELECT--</option>"
                + " <option value=\"High Priority\">High Priority</option>" + " <option value=\"Medium Priority\">Medium Priority</option>"
                + " <option value=\"Low Priority\">Low Priority</option>"
                + "</select>"
                + "</td>"
                + "<td id=\"flagId2_a" + a1 + "\"><div><select id=\"midYearDivOther" + a1 + "\" name=\"midYearDivOther" + a1 + "\" class=\"form-control\">"
                + "<option value=\"\">--SELECT--</option>"
                + "<option value=\"Yet to Start\">Yet to Start</option>"
                + "<option value=\"In Progress\">In Progress</option>"
                + "<option value=\"Completed\">Completed</option>"
                + "<option value=\"Canceled\">Canceled</option></select>"
                + "</div></td>"
                + "<td id=\"flagId3_a" + a1 + "\"><div><select id=\"endYearDivOther" + a1 + "\" name=\"endYearDivOther" + a1 + "\" class=\"form-control\">"
                + "<option value=\"\">--SELECT--</option>"
                + "<option value=\"Yet to Start\">Yet to Start</option>"
                + "<option value=\"In Progress\">In Progress</option>"
                + "<option value=\"Completed\">Completed</option>"
                + "<option value=\"Canceled\">Canceled</option></select>" + "</div></td>" //
                + "<td id=\"flagId4_a" + a1 + "\">"
                + "<select id=\"activity" + a1 + "\" name=\"activity" + a1 + "\" class=\"form-control\" style=\"margin: 0px;width: 115px;\">"
                + " <option value=\"\">--SELECT--</option>"
                + "<option value=\"Excellent\">Excellent</option>"
                + "<option value=\"Very Good\">Very Good</option>"
                + "<option value=\"Good\">Good</option>"
                + " <option value=\"Average\">Average</option>"
                + " <option value=\"Needs Improvement\">Needs Improvement</option>"
                + " </select>"
                + "</td>"

                + "<td style=\"text-align: center\" id=\"edit" + a1 + "\">"
                + "<span style=\'margin-top: 5px;\' id=\"editC" + a1 + "\">"
                + "<button type=\"button\" class=\"btns btn-warnings\">Edit</button>"
                + "</span><br/>"
                //+ "<span>History</span></td>"
                + "<td id=\"\" style=\"text-align: center\">"
                + "<span style='margin-top: 5px;'>"
                + "<input type=\"button\" value=\"-\" id=\"removeRowButtonId1\" onclick=\"removeChild12('row_1_a" + a1 + "', 'row_2_a" + a1 + "', 'row_3_a" + a1 + "', 'row_4_a" + a1 + "', 'row_5_a" + a1 + "', 'row_6_a" + a1 + "', 'row_7_a" + a1 + "', 'row_8_a" + a1 + "', 'row_9_a" + a1 + "');\">"
                + "</span>"
                + "</td>"
                + "</tr>"
                //<![CDATA[
                + "<tr id=\"row_2_a" + a1 + "\">"
                + "<td colspan=\"4\"><b>Employees Mid - Year Self / Assessment For Other Project:</b></td>" + "<td colspan=\"4\"><b\>Managers Mid - Year Review / Evaluation For Other Project:</b\></td>"
                + "</tr>"
                + "<tr id=\"row_3_a" + a1 + "\">"
                + "<td colspan=\"4\"><textarea id=\"empMidyearSelfassessmentGoalActivities" + a1 + "\" name=\"empMidyearSelfassessmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                + "<td colspan=\"4\"><textarea id=\"managerMidYearSelfAssesssmentGoalActivities" + a1 + "\" name=\"managerMidYearSelfAssesssmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                + "</tr>"

                + "<tr id=\"row_4_a" + a1 + "\">"
                + "<td colspan=\"4\"><b>Employees End - Year Self / Assessment For Other Project:</b></td>"
                + "<td colspan=\"4\"><b>Managers End - Year Review / Evaluation For Other Project:</b></td>"
                + "</tr>"
                + "<tr id=\"row_5_a" + a1 + "\">"
                + "<td colspan=\"4\"><textarea id=\"empEndyearSelfassessmentGoalActivities" + a1 + "\" name=\"empEndyearSelfassessmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                + "<td colspan=\"4\"><textarea id=\"managerEndYearSelfAssesssmentGoalActivities" + a1 + "\" name=\"managerEndYearSelfAssesssmentGoalActivities" + a1 + "\" type=\"Text\" class=\"form-control\"></textarea></td>"
                + "</tr>";//]]>
        $("#demo10").append(clone);
//        }

        document.getElementById("countactivityId").value = a1;
        optionsofKraCategoryOther(a1);
        document.getElementById("kragoalLengthactivity").value = xx;
        if (flag11 == 'true') {
//            alert("FIRST YEAR" + flag11);
            //            document.getElementById("kraGoal_activity" + a1).required = true;
//            document.getElementById("metric_activity" + a1).required = true;

            document.getElementById("midYearDivOther" + a1).style.pointerEvents = "none";
            document.getElementById("midYearDivOther" + a1).style.cursor = "default";
            document.getElementById("endYearDivOther" + a1).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + a1).style.cursor = "default";
            document.getElementById("priority" + a1).style.pointerEvents = "block";
            document.getElementById("activity" + a1).style.pointerEvents = "none";


            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).value;
            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).readOnly = true;
            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            var employeeEndYearSelfAssesssmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
        } else if (flagMidId == 'true') {
//            alert("bjjbb" + flagMidId);
            //            document.getElementById("kraGoal_activity" + a1).required = true;
            //            document.getElementById("metric_activity" + a1).required = true;
//            var weightage11 = document.getElementById("weightage" + i).value;
            //            document.getElementById("weightage" + i).readOnly = true;
            document.getElementById("endYearDivOther" + a1).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + a1).style.cursor = "default";
            document.getElementById("activity" + a1).style.pointerEvents = "none";
            document.getElementById("activity" + a1).style.cursor = "default";
            //            var finalScore = document.getElementById("finalScore" + i).value;
//            document.getElementById("finalScore" + i).readOnly = true;
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).value;
            document.getElementById("empMidyearSelfassessmentGoalActivities" + a1).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            ////validation
            document.getElementById("midYearDivOther" + a1).required = true;
            document.getElementById("employeeMidYearSelfAssesssmentGoalActivities" + a1).required = true;
//            document.getElementById("empMidyearSelfassOtheractivty").required = true;
        } else if (flagEndId == 'true') {
//            alert("Thired YEAR" + flagEndId);
//            document.getElementById("kraGoal_activity" + a1).required = true;
//            document.getElementById("metric_activity" + a1).required = true;
            //            var weightage11 = document.getElementById("weightage" + i).value;
//            document.getElementById("weightage" + i).readOnly = true;
            document.getElementById("midYearDivOther" + a1).style.pointerEvents = "none";
            document.getElementById("midYearDivOther" + a1).style.cursor = "default";
            //            var finalScore = document.getElementById("finalScore" + i).value;
            //            document.getElementById("finalScore" + i).readOnly = true;
            var employeeMidYearSelfAssesssmentGoalActivities = document.getElementById("employeeMidYearSelfAssesssmentGoalActivities" + a1).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).value;
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            //            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            //            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            //            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).value;
            //            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + a1).readOnly = true;
            var employeeEndYearSelfAssesssmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).readOnly = true;
            ///validation////
            document.getElementById("empEndyearSelfassessmentGoalActivities" + a1).required = true;
            document.getElementById("empEndyearSelfassOtheractivty").required = true;

        }

    });
});

function removeChild12(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, removeRowId_6, removeRowId_7, removeRowId_8, removeRowId_9)
{
//    alert("Dhaval");
    try {


        a1--;
//        alert("Dhaval" + a1);
        document.getElementById("countactivityId").value = a1;
//        alert("Dhaval" + a1);


        var element1 = document.getElementById(removeRowId_1);
//        alert("Dhaval" + element1);
        var element2 = document.getElementById(removeRowId_2);
        //        alert("Dhaval" + element2);
        var element3 = document.getElementById(removeRowId_3);
//        alert("Dhaval" + element3);
        var element4 = document.getElementById(removeRowId_4);
//        alert("Dhaval" + element4);
        var element5 = document.getElementById(removeRowId_5);
        //        alert("Dhaval" + element5);         var element6 = document.getElementById(removeRowId_6);
        //        alert("Dhaval" + element6);
        var element7 = document.getElementById(removeRowId_7);
        //        alert("Dhaval" + element7);
        var element8 = document.getElementById(removeRowId_8);
//        alert("Dhaval" + element8);         var element9 = document.getElementById(removeRowId_9);
        //        alert("Dhaval" + element9);
        element1.parentNode.removeChild(element1);
        element2.parentNode.removeChild(element2);
        element3.parentNode.removeChild(element3);
        element4.parentNode.removeChild(element4);
        element5.parentNode.removeChild(element5);
        element6.parentNode.removeChild(element6);
        element7.parentNode.removeChild(element7);
        element8.parentNode.removeChild(element8);
        element9.parentNode.removeChild(element9);
    } catch (e) {

    }
}
//////////////////////////Closed Activity////////////////////////////////////////////////////////////////

// Additional Activity / Project

function removeActivityChild(removeRowId_1, removeRowId_2, removeRowId_3, removeRowId_4, removeRowId_5, id)
{
//    , 'removeKRAID${status.count}'
    try {
        var val = document.getElementById("countactivityId").value;
        document.getElementById("countactivityId").value = (--val);
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
                    document.getElementById("removeKRAactivitiesID" + m).value;
                    $("#removeKRAactivitiesID" + m).attr('id', "removeKRAactivitiesID" + counter);
                    //replace id
                    $("#kraGoal_activity" + m).attr('id', "kraGoal_activity" + counter);
                    $("#metric_activity" + m).attr('id', "metric_activity" + counter);
                    $("#kraCategoryMapOther" + m).attr('id', "kraCategoryMapOther" + counter);
                    $("#priority" + m).attr('id', "priority" + counter);
                    $("#midYearDivOther" + m).attr('id', "midYearDivOther" + counter);
                    $("#endYearDivOther" + m).attr('id', "endYearDivOther" + counter);
                    $("#activity" + m).attr('id', "activity" + counter);
                    $("#EditByEmployeeact" + m).attr('id', "EditByEmployeeact" + counter);
                    $("#empMidyearSelfassessmentGoalActivities" + m).attr('id', "empMidyearSelfassessmentGoalActivities" + counter);
                    $("#managerMidYearSelfAssesssmentGoalActivities" + m).attr('id', "managerMidYearSelfAssesssmentGoalActivities" + counter);
                    $("#empEndyearSelfassessmentGoalActivities" + m).attr('id', "empEndyearSelfassessmentGoalActivities" + counter);
                    $("#managerEndYearSelfAssesssmentGoalActivities" + m).attr('id', "managerEndYearSelfAssesssmentGoalActivities" + counter);
                    $("#kragoal_activity_id" + m).attr('id', "kragoal_activity_id" + counter);
                    //name replace
                    $("#kraGoal_activity" + counter).attr('name', "kraGoal_activity" + counter);
                    $("#metric_activity" + counter).attr('name', "metric_activity" + counter);
                    $("#kraCategoryMapOther" + counter).attr('name', "kraCategoryMapOther" + counter);
                    $("#priority" + counter).attr('name', "priority" + counter);
                    $("#midYearDivOther" + counter).attr('name', "midYearDivOther" + counter);
                    $("#endYearDivOther" + counter).attr('name', "endYearDivOther" + counter);
                    $("#activity" + counter).attr('name', "activity" + counter);
                    $("#EditByEmployeeact" + counter).attr('name', "EditByEmployeeact" + counter);
                    $("#empMidyearSelfassessmentGoalActivities" + counter).attr('name', "empMidyearSelfassessmentGoalActivities" + counter);
                    $("#managerMidYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerMidYearSelfAssesssmentGoalActivities" + counter);
                    $("#empEndyearSelfassessmentGoalActivities" + counter).attr('name', "empEndyearSelfassessmentGoalActivities" + counter);
                    $("#managerEndYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerEndYearSelfAssesssmentGoalActivities" + counter);
                    $("#kragoal_activity_id" + counter).attr('name', "kragoal_activity_id" + counter);
                } catch (err) {
                    document.getElementById("removeKRAactivitiesID" + (m + 1)).value;
                    $("#removeKRAactivitiesID" + (m + 1)).attr('id', "removeKRAactivitiesID" + counter);
                    //repalce id
                    $("#kraGoal_activity" + (m + 1)).attr('id', "kraGoal_activity" + counter);
                    $("#metric_activity" + (m + 1)).attr('id', "metric_activity" + counter);
                    $("#kraCategoryMapOther" + (m + 1)).attr('id', "kraCategoryMapOther" + counter);
                    $("#priority" + (m + 1)).attr('id', "priority" + counter);
                    $("#midYearDivOther" + (m + 1)).attr('id', "midYearDivOther" + counter);
                    $("#endYearDivOther" + (m + 1)).attr('id', "endYearDivOther" + counter);
                    $("#activity" + (m + 1)).attr('id', "activity" + counter);
                    $("#EditByEmployeeact" + (m + 1)).attr('id', "EditByEmployeeact" + counter);
                    $("#empMidyearSelfassessmentGoalActivities" + (m + 1)).attr('id', "empMidyearSelfassessmentGoalActivities" + counter);
                    $("#managerMidYearSelfAssesssmentGoalActivities" + (m + 1)).attr('id', "managerMidYearSelfAssesssmentGoalActivities" + counter);
                    $("#empEndyearSelfassessmentGoalActivities" + (m + 1)).attr('id', "empEndyearSelfassessmentGoalActivities" + counter);
                    $("#managerEndYearSelfAssesssmentGoalActivities" + (m + 1)).attr('id', "managerEndYearSelfAssesssmentGoalActivities" + counter);
                    $("#kragoal_activity_id" + (m + 1)).attr('id', "kragoal_activity_id" + counter);

                    //replace name
                    $("#kraGoal_activity" + counter).attr('name', "kraGoal_activity" + counter);
                    $("#metric_activity" + counter).attr('name', "metric_activity" + counter);
                    $("#kraCategoryMapOther" + counter).attr('name', "kraCategoryMapOther" + counter);
                    $("#priority" + counter).attr('name', "priority" + counter);
                    $("#midYearDivOther" + counter).attr('name', "midYearDivOther" + counter);
                    $("#endYearDivOther" + counter).attr('name', "endYearDivOther" + counter);
                    $("#activity" + counter).attr('name', "activity" + counter);
                    $("#EditByEmployeeact" + counter).attr('name', "EditByEmployeeact" + counter);
                    $("#empMidyearSelfassessmentGoalActivities" + counter).attr('name', "empMidyearSelfassessmentGoalActivities" + counter);
                    $("#managerMidYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerMidYearSelfAssesssmentGoalActivities" + counter);
                    $("#empEndyearSelfassessmentGoalActivities" + counter).attr('name', "empEndyearSelfassessmentGoalActivities" + counter);
                    $("#managerEndYearSelfAssesssmentGoalActivities" + counter).attr('name', "managerEndYearSelfAssesssmentGoalActivities" + counter);
                    $("#kragoal_activity_id" + counter).attr('name', "kragoal_activity_id" + counter);
                    m++;
                }
                document.getElementById("removeKRAactivitiesID" + counter).innerHTML = counter;
                counter++;
            }
        } catch (err) {

        }
        var kraremovedActivitiesIdVal = document.getElementById('kraremovedActivitiesIdVal').value;
        document.getElementById('kraremovedActivitiesIdVal').value = kraremovedActivitiesIdVal + "," + id;
    } catch (e) {

    }
}



//var j = 1;
//$(function () {
//    var flag11 = document.getElementById("flagId").value;
//    var flagMidId = document.getElementById("flagMidId").value;
//    var flagEndId = document.getElementById("flagEndId").value;
//    //    alert("WWWWWWWWWWWWWW" + flagEndId);
//    $("#addIndividualId").on("click", function () {
//        j = document.getElementById("IndividualId").value;
//        if (j == 0) {
//            j = 1;
//        }
//        if (j <= 4) {
////        alert("aaa" + j);
//            j++;
//            //                alert(i1);
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
//                    + "<td colspan=\"3\" id=\"midYearReId" + j + "\"><b>Mid-Year Remark</b></td>"
//                    + "<td colspan=\"3\" id=\"endYearReId" + j + "\"><b>End-Year Remark</b></td>"
//                    + "</tr>" + "<tr id='1moreFile_3_" + j + "'>"
//                    + "<td colspan=\"3\" id=\"midYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"midYearRemark" + j + "\" name=\"midYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "<td colspan=\"3\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"endYearRemark" + j + "\" name=\"endYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "</tr>"
//                    + "<tr id='1moreFile_4_" + j + "'>"
//                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager Mid-Year Remark</b></td>"
//                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager End-Year Remark</b></td>"
//                    + "</tr>" + "<tr id='1moreFile_5_" + j + "'>"
//                    + "<td colspan=\"3\"><textarea rows=\"3\" id=\"managerMidYearRemark" + j + "\" style=\"width: 451px;\" name=\"managerMidYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "<td colspan=\"3\"><textarea rows=\"3\" id=\"managerEndYearRemark" + j + "\" style=\"width: 451px;\" name=\"managerEndYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
//                    + "</tr>";
//            $("#demo5").append(clone);
//        }
//        document.getElementById("IndividualId").value = j;
//        if (flag11 == 'true') {
//
////            alert("Prem Ratan");
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
////                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
//            document.getElementById("managerMidYearRemark" + j).readOnly = true;
//            document.getElementById("managerEndYearRemark" + j).readOnly = true;
//
//
//        } else if (flagMidId == 'true') {
//            //                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
////            document.getElementById("text" + j).readonly = true;
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
//            document.getElementById("managerEndYearRemark" + j).readOnly = true;
//
//        } else if (flagEndId == 'true') {
//
//            //            document.getElementById("individualtextDiv" + j).required = true;
////            document.getElementById("trainingSelectId" + j).required = true;
//            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
//            if (selectedValue1 == "Other") {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
////                document.getElementById("trainingSelectTextinput" + j).required = true;
//            } else {
//                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + j).readOnly = true;
//            document.getElementById("endYearRemark" + j).readOnly = true;
//            document.getElementById("managerMidYearRemark" + j).readOnly = true;
//        }
//
//    });
//
//});
//function removeChild_j(removeRow_1_Id, removeRow_2_Id, removeRow_3_Id, removeRow_4_Id, removeRow_5_Id) {
//    j--
//    document.getElementById("IndividualId").value = j;
//    var element1 = document.getElementById(removeRow_1_Id);
//    var element2 = document.getElementById(removeRow_2_Id);
//    var element3 = document.getElementById(removeRow_3_Id);
//    var element4 = document.getElementById(removeRow_4_Id);
//    var element5 = document.getElementById(removeRow_5_Id);
//    element1.parentNode.removeChild(element1);
//    element2.parentNode.removeChild(element2);
//    element3.parentNode.removeChild(element3);
//    element4.parentNode.removeChild(element4);
//    element5.parentNode.removeChild(element5);
//}
//function trainingSelectCloneOfTable1(j) {
//    var selectedValue1 = document.getElementById("trainingSelectId1_" + j).value;
//    if (selectedValue1 == "Other") {
//        document.getElementById("trainingSelectTextinput1_" + j).style.display = "block";
//    } else {
//        document.getElementById("trainingSelectTextinput1_" + j).style.display = "none";
//    }
//}

// Individual

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



///////////////////////ajax in update History////////////
function managerhistoryajaxfun(kraId) {
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
            alert('Error occured');
        }
    });
}
function managerhistoryajaxfunOtherActivity(kraIdOther) {
    //    alert(kraIdOther);
//
    //    var updateKraid = document.getElementById("updateKraid").value;

    //    alert('Dhaval Parmar' + kraId);
    $.ajax({type: "POST",
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
} //$(document).on("click", ":submit", function (e) {
//    if ($(this).val() !== "" && $(this).val() === "submit") {
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




function allowOnlyNumber(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
    weightageCount();
}

function weightageCount(id) {
//    alert('aaaaaa' + id);
    var total = 1;
    var countId = document.getElementById("countId").value;

    var weightage = 0;
    var flag1 = 0;
    while (total <= countId) {
        var val = document.getElementById("weightage" + total).value;
        if (val > 75)
        {
            document.getElementById("weightage" + total).value = "";
        }
        if (val == "")
        {
            flag1 = 1;
        }
        if (val !== "") {
            weightage += parseFloat(val);
        }
        total++;
    }
//    alert(weightage);
    //if (weightage >= 75) {
    //alert("Your weightage above 75");
    //var flag3=false;
    //saveSubmit11(flag3);
    //alert(flag3);
    //} else {
    //var flag3=true;
    // alert(flag3);
    //    alert("dhavl" + weightage);
    document.getElementById("weightageScore").value = weightage;
    //saveSubmit11(flag3);
    if (flag1 === 0)
    {
        weightageNotGrater(id, weightage);
//        $('#errorId').hide(3000);
    }
}
function weightageNotGrater(id, weightage) {
//    alert("sdgkjh " + id);
//        swal("Oops...", "Something went wrong!", "error");
//    alert("weightage " + weightage);
    var weightage1 = document.getElementById("weightage" + id).value;     // alert("a");
//if(weightage1 == "")
//    alert("weightage"+weightage1);
//    var val = document.getElementById("finalScore" + id).value;
    var val = 75;
    var val1 = 0;
    //    alert(weightage + " > " + val + " && " + weightage + "<" + val);
    if (parseFloat(weightage) < 75 || parseFloat(weightage) > 75) {
        //    if (parseFloat(weightage) > parseFloat(val) || parseFloat(weightage) < parseFloat(val) ) {
        document.getElementById("weightage" + id).value = "";
        //        alert("Your Final Score Above Weightage Score");
        //        swal("Your Weightage Score is Not Valid");
        //        bootbox.alert("Your Weightage Score is Not Valid", function () {
        //            Example.show("Your Weightage Score is Not Valid");
//        });
        var booID = setInterval(function () {
            document.getElementById('bootCloseBtnId').onclick = '';
            clearInterval(booID);
        }, 500);
        bootbox.alert({
            size: 'small',
            //            message: "Oh ! Your Weightage Score is Not Valid…",
            message: '<h1>Oh ! Your Weightage Score is Not Valid…</h1>',
            callback: function () { /* your callback code */
            }
        })

//        bootbox.dialog({
//  title: "That html",
//  message: '<img src="images/bootstrap_logo.png" width="100px"/><br/> You can also use <b>html</b>'
//});
        document.getElementById("weightageScore").value = "";
    }
}
//    }
//});
//function show_alert() {
//
////    alert("Your Weightage Score is Not Valid");
//}

function finalScoreCount(id) {
    //    alert('aaaaaa' + id);

    //    alert("weightage" + weightage);
    var total = 1;
    var countId = document.getElementById("countId").value;
    var finalScore = 0;
    while (total <= countId) {
        var weightage = document.getElementById("weightage1").value;
        var val = document.getElementById("finalScore" + total).value;
        if (val !== "") {
            finalScore += parseFloat(val);
        }
        total++;
    }
    //    alert(finalScore);
//    alert("dhavl" + finalScore);
    document.getElementById("totalScore").value = finalScore;
    performancefinalScoreRatings();
    newFunction(id);
}
function newFunction(id) {
    //    alert("sdgkjh " + id);
//    var weightage = document.getElementById("weightage" + id).value;
    //    alert("weightage"+weightage);
//    var val = document.getElementById("finalScore" + id).value;
//    alert("val"+val);
    //weightage = (weightage * 113.4) / 100;
//    if (parseFloat(weightage) <= parseFloat(val)) {

    // Changes
    var total = 1;
    var countId = document.getElementById("countId").value;

    var finalScore = 0;
    while (total <= countId) {
//        alert('countId'+countId);
//        alert('index'+total);
        var val = document.getElementById("finalScore" + total).value;
//        alert(val);

        if (val !== "") {
            finalScore += parseFloat(val);
        }
        if (finalScore > 85)
        {
            document.getElementById("finalScore" + id).value = "";
            document.getElementById("totalScore").value = "";
            alert("Your Final Score Above 85");
            return false;
        }
        total++;
    }
    // Changes





//    if (parseFloat(val) < 85 || parseFloat(val) > 85) {
//        document.getElementById("finalScore" + id).value = "";
//        alert("Your Final Score Above 85");
////        prompt("Your Final Score Above Weightage Score");
//    }
    performancefinalScoreRatings();
}


function behaviorsCount() {
//    var total = 1;
    var behaviors = 0;
    //    var selectedString = value11.value;
    for (i = 1; i <= 5; i++) {
        var midYearScore = document.getElementById("midYearScore" + i).value;
//        alert('aaaaaa' + midYearScore);
        if (midYearScore !== "") {
            behaviors += parseFloat(midYearScore);
        }
    }
    //    alert(midYearScore);
    //    alert("behaviorsMidyearTotalscore" + behaviors);
    document.getElementById("behaviorsMidyearTotalscore").value = behaviors;

}

function behaviorsCountEndYear() {
    //    var total = 1;
    var behaviorsEnd = 0;
//    var selectedString = value11.value;
    for (i = 1; i <= 5; i++) {
        var endYearScore = document.getElementById("endYearScore" + i).value;

        if (endYearScore !== "") {
            behaviorsEnd += parseFloat(endYearScore);
        }
    }
//        alert(behaviorsEnd);
//    alert("behaviorsMidyearTotalscore" + behaviors);    
    document.getElementById("behaviorsEndyearTotalscore").value = behaviorsEnd;
    performancefinalScoreRatings();

}

function activityScoreCount(id) {
//        alert('aaaaaabbbbbccc');
//        alert('aaaaaa' + id);

    //    alert("weightage" + weightage);
    var total = 1;
    var countId = document.getElementById("countactivityId").value;
    var activityScore = 0;
    while (total <= countId) {
        var val = document.getElementById("activity" + total).value;
        if (val !== "") {
            activityScore += parseFloat(val);
        }
        total++;
    }
    //alert(activityScore);
//    alert("dhavl" + finalScore);
    document.getElementById("managerActivityScore").value = activityScore;
    performancefinalScoreRatings();
//    newFunction(id);
}

//function managerajaxfun() {
//
////
//    var competencyEvaluationId = document.getElementById("competencyEvaluationId").value;
//    //    alert('Dhaval Parmar' + competencyEvaluationId);
//    $.ajax({
//        type: "POST",
//        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
//        //                    data: "selectedvalue=" + selectedVal,
//        data: {"selectedvalue": competencyEvaluationId},
//        dataType: "text",
//        success: function (responseTxt) {
////            alert(responseTxt);
//            var subCompentency = document.getElementById("demo9").innerHTML = responseTxt;
//            var flag11 = document.getElementById("flagId").value;
//            var flagMidId = document.getElementById("flagMidId").value;
//            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
//            //            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
//            //            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);
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
//                //                alert("fdfddffhdf");
//                for (i = 1; i <= count; i++) {
//                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
//                    //                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
//            if (flagEndId == 'true') { //                alert("fdfddffhdf");
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
//        },
//        error: function () {
//            alert('Please Select Only One Competency Evaluation');
//        }
//    });
//}
function approveSubmit11() {

    var flag3 = false;

    var weightage = document.getElementById("weightageScore").value;
    var totalScore = document.getElementById("totalScore").value;
    flag3 = false;
    if (weightage === "") {
        alert("Please Enter Weightage");
        flag3 = false;
    } else if (weightage > 75) {
        alert("Your weightage above 75");
        flag3 = false;
    } else {
        flag3 = true;
    }
    //        } else {
//            alert("Dhacval");
//            flag3 = true;
    //        }

    //    if (totalScore === "") {
    //        alert("Please Enter TotalScore");
    //        flag3 = false; //    } else if (totalScore > 75) {
    //        alert("Your TotalScore above 75");
//        flag3 = false;
//    } else {
//        flag3 = true;
//    }
    if (flag3) {
        flag3 = true;
        document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
        document.form1.submit();
        return true;
    } else {
        return false;
    }
//    });
}



////////////////////////////////////footer side Java Scripts///////////////////////////////////////////////////////////////

$(document).on("click", ":submit", function (e) {
    //alert(e);
    if (confirm("Are you sure you want to Submit")) {
        if ($(this).val() !== "" && $(this).val() === "submit") {


            var flag11 = document.getElementById("flagId").value;
            var flagmid = document.getElementById("flagMidId").value;
            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
//            var countId = document.getElementById("IndividualId").value;
            var kragoalLength = document.getElementById("kragoalLength").value;
            var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;


            if (flag11 === 'true') {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
                for (i = 1; i <= kragoalLength; i++) {
//                    document.getElementById("kraGoal" + i).required = true;
//                    document.getElementById("metric" + i).required = true;
//                    document.getElementById("kraCategoryMap" + i).required = true;
                }
//                var activityid = document.getElementById("kraGoal_activity1").value;
//                if (activityid !== '') {
//                    document.getElementById("kraGoal_activity1").required = true;
//                    document.getElementById("metric_activity1").required = true;
//                    document.getElementById("priority1").required = true;
//                }
//                for (i = 1; i <= kragoalLengthactivity; i++) {
//                    var activityidOther = document.getElementById("kraGoal_activity" + i).value;
//                    if (activityidOther !== '') {
////                        document.getElementById("kraGoal_activity" + i).required = true;
////                        document.getElementById("metric_activity" + i).required = true;
////                        document.getElementById("priority" + i).required = true;
//
//
//                    }
//                }

//                for (i = 1; i <= count; i++) {
//                document.getElementById("competencyStartYear" + i).required = true;
//            document.getElementById("compentencyStartRemark" + i).required = true;

//                }
//                for (i = 1; i <= countId; i++) {
//
//                    var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//                    if (selectedValue1 == "Other") {
//                        //                document.getElementById("trainingSelectTextinput" + i).required = true;
//                    }
//                    //            document.getElementById("text" + i).required = true;
////            document.getElementById("individualtextDiv" + i).required = true;
//                    //            document.getElementById("trainingSelectId" + i).required = true;
//
//                }

                document.getElementById("midYearRemark1").readOnly = true;
                document.getElementById("endYearRemark1").readOnly = true;
//        document.getElementById("kraGoal_activity1").required = true;
//        document.getElementById("metric_activity1").required = true;
//        document.getElementById("priority1").required = true;
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75) {
//                    weitageAlert();
//                    return false;
//                }

            } else if (flagmid === 'true') {
//                document.getElementById("kraGoal1").required = true;
//                document.getElementById("metric1").required = true;
//                for (i = 1; i <= count; i++) {
//                document.getElementById("compentencyMidYear" + i).required = true; change 4/10/2016
//            document.getElementById("compentencyMidRemark" + i).required = true;

//                }
                for (i = 1; i <= kragoalLength; i++) {

                    document.getElementById("managerMidYearSelfAssesssmentGoal" + i).required = true;
                }

                for (i = 1; i <= 5; i++) {
                    document.getElementById("midYearScore" + i).required = true;
                    document.getElementById("managerMidYearReview" + i).required = true;
                }
//                document.getElementById("behaviorsMidyearOtherremark").required = true;

//                var indivisul = document.getElementById("text1").value;
//                if (indivisul !== '') {

//                document.getElementById("text1").required = true; change 4/10/2016
//                document.getElementById("individualtextDiv1").required = true; change 4/10/2016
//                document.getElementById("trainingSelectId1").required = true; change 4/10/2016
//                    if (selectedValue1 == "Other") {
//                    document.getElementById("trainingSelectTextinput" + i).required = true; change 4/10/2016
//                    }
//                }

//                for (i = 1; i <= countId; i++) {
//                    if (indivisul !== '') {
////                    document.getElementById("individualtextDiv" + i).required = true; change 4/10/2016
////                    document.getElementById("trainingSelectId" + i).required = true; change 4/10/2016
////                    var selectedValue1 = document.getElementById("trainingSelectId" + i).value; change 4/10/2016
//                        if (selectedValue1 == "Other") {
////                        document.getElementById("trainingSelectTextinput" + i).required = true; change 4/10/2016
//                        }
//                    }
//
//                }

                //        document.getElementById("kraGoal_activity1").required = true;
                //        document.getElementById("metric_activity1").required = true;
                //        document.getElementById("priority1").required = true;
                //        document.getElementById("kraCategoryMapOther1").required = true;
                //        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75) {
//                    weitageAlert();
//                    return false;
//                }
//                for (i = 1; i <= kragoalLengthactivity; i++) {
                //            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//                }

            } else if (flagEndId === "true") {
//            document.getElementById("kraGoal1").required = true;
//            document.getElementById("metric1").required = true;
                document.getElementById("finalScore1").required = true;

                for (i = 1; i <= kragoalLength; i++) {
                    document.getElementById("finalScore" + i).required = true;
                }
                // changes
                var val = document.getElementById("totalScore").value;
                var val1 = document.getElementById("managerActivityScore").value;
                var fval = parseInt(val) + parseInt(val1);
//                alert(fval);
                if (fval > 85)
                {
//                    alert("Your Final Score Above 85");
                    FinalAlert();
                    return false;
                }
//                if (val > 85)
//                {
//                    alert("Your Final Score Above 85");
//                    return false;
//                }
                // changes 

//                for (i = 1; i <= count; i++) {
//                document.getElementById("compentencyEndYear" + i).required = true; change 4/10/2016
//            document.getElementById("compentencyEndRemark" + i).required = true;
//                }

//                var w1 = document.getElementById("weightageScore").value;
//                if (w1 < 75) {
//                    weitageAlert();
//                    return false;
//                }
//                for (i = 1; i <= countId; i++) {
//                document.getElementById("trainingSelectId" + i).required = true; change 4/10/2016
//                var selectedValue1 = document.getElementById("trainingSelectId" + i).value; change 4/10/2016
//                    if (selectedValue1 == "Other") {
//                    document.getElementById("trainingSelectTextinput" + i).required = true; change 4/10/2016
//                    }

//                }

                for (i = 1; i <= kragoalLengthactivity; i++) {
                    var activityidOther = document.getElementById("kraGoal_activity" + i).value;
                    if (activityidOther !== '') {
//                        document.getElementById("kraGoal_activity" + i).required = true;
//                        document.getElementById("metric_activity" + i).required = true;
//                        document.getElementById("priority" + i).required = true;
                        document.getElementById("activity" + i).required = true;


                    }

                }
                for (i = 1; i <= kragoalLength; i++) {

                    document.getElementById("managerEndYearSelfAssesssmentGoal" + i).required = true;
                }
                for (i = 1; i <= 5; i++) {
                    document.getElementById("endYearScore" + i).required = true;
                    document.getElementById("managerEndYearReview" + i).required = true;
                }
//                document.getElementById("behaviorsEndyearOtherremark").required = true;
            }

        } else if ($(this).val() !== "" && $(this).val() === "save") {
            var flag11 = document.getElementById("flagId").value;
//        if (flag11 === 'true') {
//        alert($(this).val());
//            document.getElementsByClassName("saveRequried").required = false;
            $('.saveRequried').removeAttr('required');
//        }
        }

    } else {
        return false;
    }
});

$(document).ready(function () {
    var flag11 = document.getElementById("flagId").value;
    var flag11a = document.getElementById("flagId").value;
    var flagmid = document.getElementById("flagMidId").value;
    var flagEndId = document.getElementById("flagEndId").value;
//    alert("fkgkdfg" + flagmid);
    var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
    var kragoalLength = document.getElementById("kragoalLength").value;
    var weightageScore = document.getElementById("weightageScore").value;
    var managerStatus = document.getElementById("managerStatus").value;
//    alert("hello");
    var pmpmidyearstatus = document.getElementById("pmpmidyearstatus").value;
    var pmpendyearstatus = document.getElementById("pmpendyearstatus").value;
    var pmpasManager = document.getElementById("pmpasManager").value;
    if (flag11a === 'true') {
        document.getElementById("kraGoal_activity1").readOnly = true;
        document.getElementById("metric_activity1").readOnly = true;

        document.getElementById("kraCategoryMapOther1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMapOther1").style.cursor = "default";

        document.getElementById("priority1").style.pointerEvents = "none";
        document.getElementById("priority1").style.cursor = "default";


        document.getElementById("midYearDivOther1").style.pointerEvents = "none";
        document.getElementById("midYearDivOther1").style.cursor = "default";
        document.getElementById("endYearDivOther1").style.pointerEvents = "none";
        document.getElementById("endYearDivOther1").style.cursor = "default";
        document.getElementById("activity1").style.pointerEvents = "none";
        document.getElementById("activity1").style.cursor = "default";

        var empMidyearSelfassessmentGoalActivities1 = document.getElementById("empMidyearSelfassessmentGoalActivities1").value;
        document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;
        var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
        document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
        var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
        document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
        document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;

        for (i = 1; i <= kragoalLengthactivity; i++) {

            document.getElementById("kraGoal_activity" + i).readOnly = true;
            document.getElementById("metric_activity" + i).readOnly = true;

            document.getElementById("kraCategoryMapOther" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMapOther" + i).style.cursor = "default";

            document.getElementById("priority" + i).style.pointerEvents = "none";
            document.getElementById("priority" + i).style.cursor = "default";


            document.getElementById("midYearDivOther" + i).readOnly = true;
            document.getElementById("endYearDivOther" + i).readOnly = true;
            document.getElementById("activity" + i).readOnly = true;

//            if (managerStatus === '0') {
//                document.getElementById("EditByEmployeeact" + i).disabled = true;
//            } else {
//                document.getElementById("EditByEmployeeact" + i).disabled = false;
//            }

//            if (managerStatus == '0') {
//                //                alert("managerStatus" + managerStatus);
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = false;
//                document.getElementById("metric_activity" + i).readOnly = false;
//            } else {
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = true;
//                document.getElementById("metric_activity" + i).readOnly = true;
//            }

            var midYearDivOther = document.getElementById("midYearDivOther" + i).value;
            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("midYearDivOther" + i).style.cursor = "default";
            var endYearDivOther = document.getElementById("endYearDivOther" + i).value;
            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + i).style.cursor = "default";

//            alert("a1");
            var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
            //            alert("a2");
            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
//            alert("a3");
            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
            //            alert("a4");
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + i).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
        }
    } else if (flagmid === 'true') {
        //        document.getElementById("kraGoal_activity1").required = true;
        //        document.getElementById("metric_activity1").required = true;
        //        document.getElementById("priority1").required = true;
        document.getElementById("kraGoal_activity1").readOnly = true;
        document.getElementById("metric_activity1").readOnly = true;
        document.getElementById("kraCategoryMapOther1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMapOther1").style.cursor = "default";

        document.getElementById("priority1").style.pointerEvents = "none";
        document.getElementById("priority1").style.cursor = "default";

        document.getElementById("midYearDivOther1").style.pointerEvents = "none";
        document.getElementById("midYearDivOther1").style.cursor = "default";

        document.getElementById("endYearDivOther1").style.pointerEvents = "none";
        document.getElementById("endYearDivOther1").style.cursor = "default";
        document.getElementById("activity1").style.pointerEvents = "none";
        document.getElementById("activity1").style.cursor = "default";

        //        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
        var empMidyearSelfassessmentGoalActivities1 = document.getElementById("empMidyearSelfassessmentGoalActivities1").value;
        document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;


//        alert("djf");
//        alert(document.getElementById("midyearManagerSelfassActivityStatus1").value);
        var managerMidselfassStatus = document.getElementById("midyearManagerSelfassActivityStatus1").value;
//        alert(managerMidselfassStatus);
        if (managerMidselfassStatus === '0') {
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = false;
        } else {
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
        }

//        if (pmpmidyearstatus === 'false' && pmpasManager === 'false') {
////                alert("Mid year Div==" + pmpmidyearstatus);
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = false;
//        } else {
////                alert("Mid year Div True");
//            document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
//        }
//        var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
        //        document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
        var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
        document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
        document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
        for (i = 1; i <= kragoalLengthactivity; i++) {
            document.getElementById("kraGoal_activity" + i).readOnly = true;
            document.getElementById("metric_activity" + i).readOnly = true;

            document.getElementById("kraCategoryMapOther" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMapOther" + i).style.cursor = "default";

            document.getElementById("priority" + i).style.pointerEvents = "none";
            document.getElementById("priority" + i).style.cursor = "default";


            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("midYearDivOther" + i).style.cursor = "default";

            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + i).style.cursor = "default";
            document.getElementById("activity" + i).style.pointerEvents = "none";
            document.getElementById("activity" + i).style.cursor = "default";



//            if (managerStatus === '0') {
//                document.getElementById("EditByEmployeeact" + i).disabled = true;
//            } else {
//                document.getElementById("EditByEmployeeact" + i).disabled = false;
//            }

//            if (managerStatus == '0') {
////                alert("managerStatus" + managerStatus);
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = false;
//                document.getElementById("metric_activity" + i).readOnly = false;
//            } else {
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = true;
//                document.getElementById("metric_activity" + i).readOnly = true;
//            }

//            var midYearDiv = document.getElementById("midYearDivOther" + i).value;
            //            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
            //            document.getElementById("midYearDivOther" + i).style.cursor = "default";
            var endYearDivOther = document.getElementById("endYearDivOther" + i).value;
            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + i).style.cursor = "default";
            //            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
//            alert("a1");
            var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;

            var managerMidselfassStatus = document.getElementById("midyearManagerSelfassActivityStatus" + i).value;
            if (managerMidselfassStatus === '0') {
                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = false;
            } else {
                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
            }


//            if (pmpmidyearstatus === 'false' && pmpasManager === 'false') {
////                alert("Mid year Div==" + pmpmidyearstatus);
//                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = false;
//            } else {
////                alert("Mid year Div True");
//                document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//            }

            //            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
//            alert("a4");
            //            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + i).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
        }



    } else if (flagEndId === 'true') {

        document.getElementById("kraGoal_activity1").readOnly = true;
        document.getElementById("metric_activity1").readOnly = true;

        document.getElementById("kraCategoryMapOther1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMapOther1").style.cursor = "default";

        document.getElementById("priority1").style.pointerEvents = "none";
        document.getElementById("priority1").style.cursor = "default";


        document.getElementById("midYearDivOther1").style.pointerEvents = "none";
        document.getElementById("midYearDivOther1").style.cursor = "default";

        document.getElementById("endYearDivOther1").style.pointerEvents = "none";
        document.getElementById("endYearDivOther1").style.cursor = "default";

        document.getElementById("midYearDivOther1").style.pointerEvents = "none";
        document.getElementById("midYearDivOther1").style.cursor = "default";

//        document.getElementById("activity1").style.pointerEvents = "none";
//        document.getElementById("activity1").style.cursor = "default";

        //        document.getElementById("empMidyearSelfassessmentGoalActivities1").required = true;
        var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities1").value;
        document.getElementById("empMidyearSelfassessmentGoalActivities1").readOnly = true;

        var managerEndselfassStatus = document.getElementById("endyearManagerSelfassActivityStatus1").value;
        if (managerEndselfassStatus === '0') {
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = false;
        } else {
            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
        }
//        if (pmpendyearstatus === 'false' && pmpasManager === 'false') {
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = false;
//        } else {
//            document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;
//        }
        var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").value;
        document.getElementById("managerMidYearSelfAssesssmentGoalActivities1").readOnly = true;
        var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities1").value;
        document.getElementById("empEndyearSelfassessmentGoalActivities1").readOnly = true;
//        document.getElementById("managerEndYearSelfAssesssmentGoalActivities1").readOnly = true;


        for (i = 1; i <= kragoalLengthactivity; i++) {


            document.getElementById("kraGoal_activity" + i).readOnly = true;
            document.getElementById("metric_activity" + i).readOnly = true;

            document.getElementById("kraCategoryMapOther" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMapOther" + i).style.cursor = "default";

            document.getElementById("priority" + i).style.pointerEvents = "none";
            document.getElementById("priority" + i).style.cursor = "default";

            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("midYearDivOther" + i).style.cursor = "default";

            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none";
            document.getElementById("endYearDivOther" + i).style.cursor = "default";

//            if (managerStatus === '0') {
//                document.getElementById("EditByEmployeeact" + i).disabled = true;
//            } else {
//                document.getElementById("EditByEmployeeact" + i).disabled = false;
//            }

//            if (managerStatus == '0') {
////                alert("managerStatus" + managerStatus);
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = false;
//                document.getElementById("metric_activity" + i).readOnly = false;
//            } else {
//                var kra1 = document.getElementById('kraGoal_activity' + i).readOnly = true;
//                document.getElementById("metric_activity" + i).readOnly = true;
//            }
//            alert("hi");
//            var midYearDiv = document.getElementById("midYearDivOther" + i).value;
//            document.getElementById("midYearDivOther" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDivOther" + i).style.cursor = "default";
            //            var endYearDiv = document.getElementById("endYearDivOther" + i).value; //            document.getElementById("endYearDivOther" + i).style.pointerEvents = "none"; //            document.getElementById("endYearDivOther" + i).style.cursor = "default";
            //            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).required = true;
            //            alert("a1");

            var managerEndselfassStatus = document.getElementById("endyearManagerSelfassActivityStatus" + i).value;
            if (managerEndselfassStatus === '0') {
                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = false;
            } else {
                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
            }

//            if (pmpendyearstatus === 'false' && pmpasManager === 'false') {
//                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = false;
//            } else {
//                document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
//            }
            var empMidyearSelfassessmentGoalActivities = document.getElementById("empMidyearSelfassessmentGoalActivities" + i).value;
            document.getElementById("empMidyearSelfassessmentGoalActivities" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoalActivities = document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoalActivities" + i).readOnly = true;
            var empEndyearSelfassessmentGoalActivities = document.getElementById("empEndyearSelfassessmentGoalActivities" + i).value;
            document.getElementById("empEndyearSelfassessmentGoalActivities" + i).readOnly = true;
            //            var managerEndYearSelfAssesssmentGoalActivities = document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).value;
            //            document.getElementById("managerEndYearSelfAssesssmentGoalActivities" + i).readOnly = true;
        }
    }
    ////////////////////////kra Goal/////////////////////////////
    if (flag11 === 'true') {
        document.getElementById("kraGoal1").readOnly = true;
        document.getElementById("metric1").readOnly = true;
        document.getElementById("kraCategoryMap1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMap1").style.cursor = "default";
        document.getElementById("weightage1").readOnly = true;

        document.getElementById("midYearDiv1").style.pointerEvents = "none";
        document.getElementById("midYearDiv1").style.cursor = "default";
        document.getElementById("endYearDiv1").style.pointerEvents = "none";
        document.getElementById("endYearDiv1").style.cursor = "default";


        for (i = 1; i <= kragoalLength; i++) { //            alert("managerStatus" + managerStatus);
//            if (managerStatus == 0) {
//                var kra = document.getElementById('kraGoal' + i).readOnly = false;
//                document.getElementById("metric" + i).readOnly = false;
//            } else {
//
//                var kra = document.getElementById('kraGoal' + i).readOnly = true;
//                document.getElementById("metric" + i).readOnly = true;
////                document.getElementById("save").disabled = true;
//            }


//            document.getElementById("kraGoal" + i).required = true;
//            document.getElementById("metric" + i).required = true;
//            $('#errorId' + i).hide();
//            var w1 = document.getElementById("weightage" + i).value;
//            var abc = Math.round(w1);
//            document.getElementById("weightage" + i).value = abc;

            //            document.getElementById("weightage" + i).Math.round(i);
//            alert(abc);
            document.getElementById("kraGoal" + i).readOnly = true;
            document.getElementById("metric" + i).readOnly = true;
            document.getElementById("weightage" + i).readOnly = true;
            document.getElementById("kraCategoryMap" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMap" + i).style.cursor = "default";

            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("midYearDiv" + i).style.cursor = "default";

            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";

            document.getElementById("finalScore" + i).style.pointerEvents = "none";
            document.getElementById("finalScore" + i).style.cursor = "default";
            //            alert("ZYSEDHSDHDHDD");
            //            var weightage11 = document.getElementById("weightage" + i).value;
//            document.getElementById("weightage" + i).readOnly = true;
            //            var midYearDiv = document.getElementById("midYearDiv" + i).value;

            //            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";

//            var endYearDiv = document.getElementById("endYearDiv" + i).value;

//            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("endYearDiv" + i).style.cursor = "default";

//            var finalScore = document.getElementById("finalScore" + i).value;
            //            document.getElementById("finalScore" + i).readOnly = true;
            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
            //            document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//            document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
//            document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
//            document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;
        }
    } else if (flagmid === 'true') {
//        alert("middateDDDDDDDDDDDDDDDDA" + flagmid);
//        if (managerStatus == 1) {
//            document.getElementById("save").disabled = true;
//        }
        document.getElementById("kraGoal1").readOnly = true;
        document.getElementById("metric1").readOnly = true;

        document.getElementById("kraCategoryMap1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMap1").style.cursor = "default";
        document.getElementById("weightage1").readOnly = true;
        document.getElementById("midYearDiv1").style.pointerEvents = "none";
        document.getElementById("midYearDiv1").style.cursor = "default";
        document.getElementById("endYearDiv1").style.pointerEvents = "none";
        document.getElementById("endYearDiv1").style.cursor = "default";
        document.getElementById("finalScore1").readOnly = true;

//        if (pmpmidyearstatus === 'false' && pmpasManager === 'false') {
//            document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
//        }

        var managerMidselfassStatus = document.getElementById("midyearManagerSelfassStatus1").value;
        if (managerMidselfassStatus === '0') {
            document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = false;
        } else {
            document.getElementById("managerMidYearSelfAssesssmentGoal1").readOnly = true;
        }
        for (i = 1; i <= kragoalLength; i++) {
//            var kra = document.getElementById('kraGoal' + i).readOnly = true;
//            document.getElementById("metric" + i).readOnly = true; //            var weightage11 = document.getElementById("weightage" + i).value;
            //            document.getElementById("weightage" + i).readOnly = true;
            //            var w1 = document.getElementById("weightage" + i).value;
//            var abc = Math.round(w1);
            //            document.getElementById("weightage" + i).value = abc;

            document.getElementById("kraGoal" + i).readOnly = true;
            document.getElementById("metric" + i).readOnly = true;
            document.getElementById("kraCategoryMap" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMap" + i).style.cursor = "default";
            document.getElementById("weightage" + i).readOnly = true;

            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("midYearDiv" + i).style.cursor = "default";
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";



//            var endYearDiv = document.getElementById("endYearDiv" + i).value;
//            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("endYearDiv" + i).style.cursor = "default";

            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = true; //            var finalScore = document.getElementById("finalScore" + i).value;
            //            document.getElementById("finalScore" + i).style.pointerEvents = "none";
            //            document.getElementById("finalScore" + i).style.cursor = "default";
            //            document.getElementById("finalScore" + i).disabled = true;
            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;

            var managerMidselfassStatus = document.getElementById("midyearManagerSelfassStatus" + i).value;
            if (managerMidselfassStatus === '0') {
                document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = false;
            } else {
                document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            }
//            if (pmpmidyearstatus === 'false' && pmpasManager === 'false') {
//                document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
//                document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
//            }
//            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = false;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
        } //        document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
        //        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//
        //        document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
        //        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = true;

    } else if (flagEndId === 'true') {
//        if (managerStatus == 1) {
////            alert("Save is disable"+flagEndId);
//            document.getElementById("save").disabled = true;
//        }
        document.getElementById("kraGoal1").readOnly = true;
        document.getElementById("metric1").readOnly = true;

        document.getElementById("kraCategoryMap1").style.pointerEvents = "none";
        document.getElementById("kraCategoryMap1").style.cursor = "default";
        document.getElementById("weightage1").readOnly = true;
        document.getElementById("midYearDiv1").style.pointerEvents = "none";
        document.getElementById("midYearDiv1").style.cursor = "default";
        document.getElementById("endYearDiv1").style.pointerEvents = "none";
        document.getElementById("endYearDiv1").style.cursor = "default";


        var manaagerEndselfassStatus = document.getElementById("endyearManagerSelfassStatus1").value;
        if (manaagerEndselfassStatus === '0') {
            document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = false;
        } else {
            document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
        }

//        if (pmpendyearstatus === 'false' && pmpasManager === 'false') {
//            document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = false;
//        } else {
//            document.getElementById("managerEndYearSelfAssesssmentGoal1").readOnly = true;
//        }

        for (i = 1; i <= kragoalLength; i++) {
//            var kra = document.getElementById('kraGoal' + i).readOnly = true;
//            document.getElementById("metric" + i).readOnly = true;


//            var weightage11 = document.getElementById("weightage" + i).value;
//            document.getElementById("weightage" + i).readOnly = false;
//            var midYearDiv = document.getElementById("midYearDiv" + i).value;
////            document.getElementById("midYearDiv" + i).disabled = true;
//            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
//            document.getElementById("midYearDiv" + i).style.cursor = "default";





            document.getElementById("kraGoal" + i).readOnly = true;
            document.getElementById("metric" + i).readOnly = true;

            document.getElementById("kraCategoryMap" + i).style.pointerEvents = "none";
            document.getElementById("kraCategoryMap" + i).style.cursor = "default";
            document.getElementById("weightage" + i).readOnly = true;
            document.getElementById("midYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("midYearDiv" + i).style.cursor = "default";
            document.getElementById("endYearDiv" + i).style.pointerEvents = "none";
            document.getElementById("endYearDiv" + i).style.cursor = "default";


            var finalScore = document.getElementById("finalScore" + i).value;
            document.getElementById("finalScore" + i).readOnly = false;
            var employeeMidYearSelfAssesssmentGoal = document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var managerMidYearSelfAssesssmentGoal = document.getElementById("managerMidYearSelfAssesssmentGoal" + i).value;
            document.getElementById("managerMidYearSelfAssesssmentGoal" + i).readOnly = true;
            var employeeEndYearSelfAssesssmentGoal = document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).value;
            document.getElementById("employeeEndYearSelfAssesssmentGoal" + i).readOnly = true;

            var manaagerEndselfassStatus = document.getElementById("endyearManagerSelfassStatus" + i).value;
            if (manaagerEndselfassStatus === '0') {
                document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = false;
            } else {
                document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
            }
//            if (pmpendyearstatus === 'false' && pmpasManager === 'false') {
//                document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = false;
//            } else {
//                document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = true;
//            }
//            var managerEndYearSelfAssesssmentGoal = document.getElementById("managerEndYearSelfAssesssmentGoal" + i).value;
//            document.getElementById("managerEndYearSelfAssesssmentGoal" + i).readOnly = false;
        }

        //        document.getElementById("managerMidyearReviewevalOtheractivity").readOnly = true;
        //        document.getElementById("empMidyearSelfassOtheractivty").readOnly = true;
//
        //        document.getElementById("empEndyearSelfassOtheractivty").readOnly = true;
        //        document.getElementById("managerEndyearReviewevalOtheractivity").readOnly = false;

    }




    ///Compentency /////////////////////
//    var count = document.getElementById("subCompentencyCount").value;
//    if (flag11 == 'true') {
//        for (i = 1; i <= count; i++) {
//            var compentencyMidYear = document.getElementById("compentencyMidYear" + i).value;
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidRemark" + i).readOnly = true;
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//            document.getElementById("compentencyEndRemark" + i).readOnly = true;
//        }
//    } else if (flagmid === 'true') {
//        for (i = 1; i <= count; i++) {
//
//            document.getElementById("compentencyStartRemark" + i).readOnly = true;
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default"
//            document.getElementById("compentencyEndRemark" + i).readOnly = true;
//        }
//    } else if (flagEndId === 'true') {
//        for (i = 1; i <= count; i++) {
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//            document.getElementById("compentencyStartRemark" + i).readOnly = true;
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidRemark" + i).readOnly = true;
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default"
//        }
//    }
    //////////////////////////////////////////////////////////////

//    /////////////Individual Development Plan///////////////////////
//    var countId = document.getElementById("IndividualId").value;
//    ///////////////////Other wise filed show hide/////////////////////////
//    //    alert("c1" + countId);
////    for (i = 1; i <= countId; i++) {
////        var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
////        if (selectedValue1 == "Other") {
////            document.getElementById("trainingSelectTextinput" + i).style.display = "block";
////        } else {
////            document.getElementById("trainingSelectTextinput" + i).style.display = "none";
////        }
////    }
//    if (flag11 === 'true') {
//
//
//
//        document.getElementById("text1").readOnly = true;
//        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
//        document.getElementById("individualtextDiv1").style.cursor = "default";
//        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
//        document.getElementById("trainingSelectId1").style.cursor = "default";
//
//        for (i = 1; i <= countId; i++) {
//            //            alert("Prem Ratan");
//            document.getElementById("text" + i).readOnly = true;
//            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
//            document.getElementById("individualtextDiv" + i).style.cursor = "default";
//            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
//            document.getElementById("trainingSelectId" + i).style.cursor = "default";
//            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//            if (selectedValue1 == "Other") {
//                //                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
//                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + i).readOnly = true;
//            document.getElementById("endYearRemark" + i).readOnly = true;
//            document.getElementById("managerMidYearRemark" + i).readOnly = true;
//            document.getElementById("managerEndYearRemark" + i).readOnly = true;
//        }
//
//
//        //        document.getElementById("midYearRemark1").readOnly = true;
//        //        document.getElementById("endYearRemark1").readOnly = true;
//        //$('#printBtn').hide();
//    } else if (flagmid === 'true') {
//        document.getElementById("text1").readonly = true;
//
//        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
//        document.getElementById("individualtextDiv1").style.cursor = "default";
//        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
//        document.getElementById("trainingSelectId1").style.cursor = "default";
//        for (i = 1; i <= countId; i++) {
////            alert("countId====>" + countId);
//            document.getElementById("text" + i).readonly = true;
//            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
//            document.getElementById("individualtextDiv" + i).style.cursor = "default";
//            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
//            document.getElementById("trainingSelectId" + i).style.cursor = "default";
//
//            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//            if (selectedValue1 == "Other") {
//                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + i).readOnly = true;
//            document.getElementById("endYearRemark" + i).readOnly = true;
//            document.getElementById("managerEndYearRemark" + i).readOnly = true;
//        }
//    } else if (flagEndId === 'true') {
//        document.getElementById("text1").readonly = true;
//        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
//        document.getElementById("individualtextDiv1").style.cursor = "default";
//        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
//        document.getElementById("trainingSelectId1").style.cursor = "default";
//        for (i = 1; i <= countId; i++) {
//            document.getElementById("text" + i).readonly = true;
//            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
//            document.getElementById("individualtextDiv" + i).style.cursor = "default";
//            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
//            document.getElementById("trainingSelectId" + i).style.cursor = "default";
//            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//            if (selectedValue1 == "Other") {
//                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//            } else {
//                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
//            }
//            document.getElementById("midYearRemark" + i).readOnly = true;
//            document.getElementById("endYearRemark" + i).readOnly = true;
//            document.getElementById("managerMidYearRemark" + i).readOnly = true;
//        }
//    }
    ////////////Behiouer//////////////////
    if (flag11 === 'true') { //        alert("GGGGGGGGGGGGGGGGGIIIIIGGGGGGGGGAAAAAAAAAA");
        for (i = 1; i <= 5; i++) {
            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
            document.getElementById("midYearScore" + i).style.cursor = "default";
            //            document.getElementById('midYearScore' + i).value;
            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
            document.getElementById("endYearScore" + i).style.cursor = "default";
            document.getElementById("managerMidYearReview" + i).readOnly = true;
            document.getElementById("managerEndYearReview" + i).readOnly = true;
            document.getElementById("behaviorsMidyearOtherremark").readOnly = true;
            document.getElementById("behaviorsEndyearOtherremark").readOnly = true;
        }
    } else if (flagmid === 'true') {
        for (i = 1; i <= 5; i++) {

            document.getElementById("endYearScore" + i).style.pointerEvents = "none";
            document.getElementById("endYearScore" + i).style.cursor = "default";

            document.getElementById("managerEndYearReview" + i).readOnly = true; //            document.getElementById("behaviorsMidyearOtherremark").readOnly = true;
            document.getElementById("behaviorsEndyearOtherremark").readOnly = true;

//            $('#w' + i).show();
//            $('#midYearScore' + i).show();
//            $('#managerEndYearReviewId' + i).hide();
////        $('#endYearHeader').hide();
//            $('#endYearScore' + i).hide();
//            $('#endYearId' + i).hide();
//            $('#managerMidYearReview' + i).show();
//            $('#managerEndYearReview' + i).hide();
        }
//        $('#endYearHeader').hide();
        //        $('#behaviorsEndyearTotalscore').hide();
//        $('#behaviorsEndyearOtherremarkId').hide();
        //        $('#behaviorsEndyearOtherremark').hide();
//        $('#behaviorsTabId').show();
//        $('#RatingsTabId').show();
        //$('#printBtn').hide();
    } else if (flagEndId === 'true') {
        for (i = 1; i <= 5; i++) {
            document.getElementById("midYearScore" + i).style.pointerEvents = "none";
            document.getElementById("midYearScore" + i).style.cursor = "default";
            document.getElementById("managerMidYearReview" + i).readOnly = true;
            document.getElementById("behaviorsMidyearOtherremark").readOnly = true;
        }
        //        $('#behaviorsEndyearOtherremarkId').show();
        //        $('#behaviorsEndyearOtherremark').show();
//        $('#behaviorsTabId').show();
        //        $('#RatingsTabId').show();
        //$('#printBtn').show();
    }

    //    var totalScore = parseInt(document.getElementById("totalScore").value);
    //    var behaviorsEndyearTotalscore = parseInt(document.getElementById("behaviorsEndyearTotalscore").value);
    //    alert("DODODOD" + behaviorsEndyearTotalscore);
    //    alert("POPOPOPO" + totalScore);
    //    var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore;
//
//    document.getElementById("behaviorsFinalscore").value = behaviorsFinalscore12;
    performancefinalScoreRatings();



});
function performancefinalScoreRatings() {
    var managerActivityScore = 0;
    var totalScore = parseInt(document.getElementById("totalScore").value);
    var managerActivityScore = parseInt(document.getElementById("managerActivityScore").value);

    var behaviorsEndyearTotalscore = parseInt(document.getElementById("behaviorsEndyearTotalscore").value);
//        alert("DODODOD" + behaviorsEndyearTotalscore);
//    alert("POPOPOPO" + parseFloat('managerActivityScore'));
    if (isNaN(managerActivityScore)) {
//        alert("ssss");
        var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore;
        document.getElementById("behaviorsFinalscore").value = behaviorsFinalscore12;
    } else {

//        alert("yyyy");
        var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore + managerActivityScore;
        document.getElementById("behaviorsFinalscore").value = behaviorsFinalscore12;
    }
//    if (managerActivityScore !== managerActivityScore || managerActivityScore !== " ") {
//        alert(managerActivityScore);
//    }
//    var behaviorsFinalscore12 = totalScore + behaviorsEndyearTotalscore + managerActivityScore;
//    alert(behaviorsFinalscore12);

    $('#score1').hide();
    $('#score2').hide();
    $('#score3').hide();
    $('#score4').hide();
    $('#score5').hide();
    if ((behaviorsFinalscore12 >= 106) && (behaviorsFinalscore12 <= 110))
    {
        //        alert("score1" + behaviorsFinalscore12);
        $('#score1').show();

    }
    if ((behaviorsFinalscore12 >= 101) && (behaviorsFinalscore12 <= 105))
    {
        $('#score2').show();
    } else if ((behaviorsFinalscore12 >= 80) && (behaviorsFinalscore12 <= 100))
    {
        //        alert("score1" + behaviorsFinalscore12);
        $('#score3').show();
    } else if ((behaviorsFinalscore12 >= 51) && (behaviorsFinalscore12 <= 79))
    {
        $('#score4').show();
    } else if ((behaviorsFinalscore12 >= 0) && (behaviorsFinalscore12 <= 50)) {
        $('#score5').show();
    }

}
// By Ajay
function optionsofKraCategory(id) {
//    alert("Dhaval" + id);
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
//    alert("Dhaval" + id);
    var element2 = document.getElementById('kraCategoryMapHiddenMap');
    var obj2 = document.getElementById("kraCategoryMapOther" + id);
    for (var i2 = 0; i2 < element2.options.length; i2++) {
        var opt2 = document.createElement("option");
        opt2.value = element2.options[i2].value;
        opt2.text = element2.options[i2].text;
        obj2.appendChild(opt2);
    }
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

function FinalAlert() {
    var booID = setInterval(function () {
        document.getElementById('bootCloseBtnId').onclick = '';
        clearInterval(booID);
    }, 500);
    bootbox.dialog({
        size: 'small',
        message: "<h1>If score is going above 85 - Your Total score should not exceed 85.</h1>",
    });
}
//function myajaxfunManager1(competencyEvaluationId) {
//
////
////    var competencyEvaluationId = document.getElementById("competencyEvaluationId").value;
//    //    alert('Dhaval Parmar' + competencyEvaluationId);
//    $.ajax({
//        type: "POST",
//        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
//        //                    data: "selectedvalue=" + selectedVal,
//        data: {"selectedvalue": competencyEvaluationId},
//        dataType: "text",
//        success: function (responseTxt) {
////            alert(responseTxt);
//            var subCompentency = document.getElementById("demo9").innerHTML = responseTxt;
//            var flag11 = document.getElementById("flagId").value;
//            var flagMidId = document.getElementById("flagMidId").value;
//            var flagEndId = document.getElementById("flagEndId").value;
//            var count = document.getElementById("subCompentencyCount").value;
//            //            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
//            //            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + flag11);
//            if (flag11 == 'true') {
//                for (i = 1; i <= count; i++) {
//
//                    var compentencyMidYear = document.getElementById("compentencyMidYear" + i).value;
////                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
//            if (flagMidId == 'true') {
//                //                alert("fdfddffhdf");
//                for (i = 1; i <= count; i++) {
//                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
//                    //                    document.getElementById("compentencyMidYear" + i).disabled = true;
//                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
//
//                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
//                }
//            }
//            if (flagEndId == 'true') { //                alert("fdfddffhdf");
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
//                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//                }
//            }
//        },
//        error: function () {
//            alert('Please Select Only One Competency Evaluation');
//        }
//    });
//}
////////////Competency Evaluation (As Per Zydex Competency Framework) ://////////////////
