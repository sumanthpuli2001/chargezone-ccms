/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/////////////////////////Manager side///////////////////////////////////////////////////////////////////////////

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
                    + "<tr id='1moreFile_2_" + j + "'>"
                    + "<td colspan=\"3\" id=\"midYearReId" + j + "\"><b>Mid-Year Remark</b></td>"
                    + "<td colspan=\"3\" id=\"endYearReId" + j + "\"><b>End-Year Remark</b></td>"
                    + "</tr>" + "<tr id='1moreFile_3_" + j + "'>"
                    + "<td colspan=\"3\" id=\"midYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"midYearRemark" + j + "\" name=\"midYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"3\" id=\"endYearRetxtId" + j + "\"><textarea rows=\"3\" style=\"width: 451px;\" id=\"endYearRemark" + j + "\" name=\"endYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "</tr>"
                    + "<tr id='1moreFile_4_" + j + "'>"
                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager Mid-Year Remark</b></td>"
                    + "<td colspan=\"3\" id=\"endYearReId\"><b>Manager End-Year Remark</b></td>"
                    + "</tr>" + "<tr id='1moreFile_5_" + j + "'>"
                    + "<td colspan=\"3\"><textarea rows=\"3\" id=\"managerMidYearRemark" + j + "\" style=\"width: 451px;\" name=\"managerMidYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "<td colspan=\"3\"><textarea rows=\"3\" id=\"managerEndYearRemark" + j + "\" style=\"width: 451px;\" name=\"managerEndYearRemark" + j + "\" class=\"form-control\"></textarea></td>"
                    + "</tr>";
            $("#demo5").append(clone);
        }
        document.getElementById("IndividualId").value = j;
        if (flag11 == 'true') {

//            alert("Prem Ratan");
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
//                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }
            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("endYearRemark" + j).readOnly = true;
            document.getElementById("managerMidYearRemark" + j).readOnly = true;
            document.getElementById("managerEndYearRemark" + j).readOnly = true;


        } else if (flagMidId == 'true') {
            //                alert("djjdjdjdjdjdjdjdjdjdjdjdjd" + selectedValue1);
//            document.getElementById("text" + j).readonly = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }
            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("endYearRemark" + j).readOnly = true;
            document.getElementById("managerEndYearRemark" + j).readOnly = true;

        } else if (flagEndId == 'true') {

            //            document.getElementById("individualtextDiv" + j).required = true;
//            document.getElementById("trainingSelectId" + j).required = true;
            var selectedValue1 = document.getElementById("trainingSelectId" + j).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + j).style.display = "block";
//                document.getElementById("trainingSelectTextinput" + j).required = true;
            } else {
                document.getElementById("trainingSelectTextinput" + j).style.display = "none";
            }
            document.getElementById("midYearRemark" + j).readOnly = true;
            document.getElementById("endYearRemark" + j).readOnly = true;
            document.getElementById("managerMidYearRemark" + j).readOnly = true;
        }

    });

});
function removeChild_j(removeRow_1_Id, removeRow_2_Id, removeRow_3_Id, removeRow_4_Id, removeRow_5_Id) {
    j--
    document.getElementById("IndividualId").value = j;
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
}
function trainingSelectCloneOfTable1(j) {
    var selectedValue1 = document.getElementById("trainingSelectId1_" + j).value;
    if (selectedValue1 == "Other") {
        document.getElementById("trainingSelectTextinput1_" + j).style.display = "block";
    } else {
        document.getElementById("trainingSelectTextinput1_" + j).style.display = "none";
    }
}

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


////////////////////////////////////footer side Java Scripts///////////////////////////////////////////////////////////////

$(document).on("click", ":submit", function (e) {
    if (confirm("Are you sure you want to Submit")) {
        if ($(this).val() !== "" && $(this).val() === "submit") {


        } else if ($(this).val() !== "" && $(this).val() === "save") {
            
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
//    var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
//    var kragoalLength = document.getElementById("kragoalLength").value;
//    var weightageScore = document.getElementById("weightageScore").value;
    var managerStatus = document.getElementById("managerStatus").value;

    
    
    /////////////Individual Development Plan///////////////////////
    var countId = document.getElementById("IndividualId").value;
    ///////////////////Other wise filed show hide/////////////////////////
    //    alert("c1" + countId);
//    for (i = 1; i <= countId; i++) {
//        var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
//        if (selectedValue1 == "Other") {
//            document.getElementById("trainingSelectTextinput" + i).style.display = "block";
//        } else {
//            document.getElementById("trainingSelectTextinput" + i).style.display = "none";
//        }
//    }
    if (flag11 === 'true') {



        document.getElementById("text1").readOnly = true;
        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
        document.getElementById("individualtextDiv1").style.cursor = "default";
        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
        document.getElementById("trainingSelectId1").style.cursor = "default";

        for (i = 1; i <= countId; i++) {

            document.getElementById("text" + i).readOnly = true;
            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
            document.getElementById("individualtextDiv" + i).style.cursor = "default";
            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
            document.getElementById("trainingSelectId" + i).style.cursor = "default";
            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
            if (selectedValue1 == "Other") {

                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
            }
            document.getElementById("midYearRemark" + i).readOnly = true;
            document.getElementById("endYearRemark" + i).readOnly = true;
            document.getElementById("managerMidYearRemark" + i).readOnly = true;
            document.getElementById("managerEndYearRemark" + i).readOnly = true;
        }

    } else if (flagmid === 'true') {
        document.getElementById("text1").readonly = true;

        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
        document.getElementById("individualtextDiv1").style.cursor = "default";
        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
        document.getElementById("trainingSelectId1").style.cursor = "default";
        for (i = 1; i <= countId; i++) {
//            alert("countId====>" + countId);
            document.getElementById("text" + i).readonly = true;
            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
            document.getElementById("individualtextDiv" + i).style.cursor = "default";
            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
            document.getElementById("trainingSelectId" + i).style.cursor = "default";

            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
            }
            document.getElementById("midYearRemark" + i).readOnly = true;
            document.getElementById("endYearRemark" + i).readOnly = true;
            document.getElementById("managerEndYearRemark" + i).readOnly = true;
        }
    } else if (flagEndId === 'true') {
        document.getElementById("text1").readonly = true;
        document.getElementById("individualtextDiv1").style.pointerEvents = "none";
        document.getElementById("individualtextDiv1").style.cursor = "default";
        document.getElementById("trainingSelectId1").style.pointerEvents = "none";
        document.getElementById("trainingSelectId1").style.cursor = "default";
        for (i = 1; i <= countId; i++) {
            document.getElementById("text" + i).readonly = true;
            document.getElementById("individualtextDiv" + i).style.pointerEvents = "none";
            document.getElementById("individualtextDiv" + i).style.cursor = "default";
            document.getElementById("trainingSelectId" + i).style.pointerEvents = "none";
            document.getElementById("trainingSelectId" + i).style.cursor = "default";
            var selectedValue1 = document.getElementById("trainingSelectId" + i).value;
            if (selectedValue1 == "Other") {
                document.getElementById("trainingSelectTextinput" + i).style.display = "block";
            } else {
                document.getElementById("trainingSelectTextinput" + i).style.display = "none";
            }
            document.getElementById("midYearRemark" + i).readOnly = true;
            document.getElementById("endYearRemark" + i).readOnly = true;
            document.getElementById("managerMidYearRemark" + i).readOnly = true;
        }
    }
   
});

