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



$(document).ready(function () {

    var flag11 = document.getElementById("flagId").value;
    var flag11a = document.getElementById("flagId").value;
//    alert("first Year" + flag11);
//    alert("first Year" + flag11a);
    var flagmid = document.getElementById("flagMidId").value;
//    alert("MID year" + flagmid);
    var flagEndId = document.getElementById("flagEndId").value;
//    alert("End year" + flagEndId);

    var pmpstartyearstatus = document.getElementById("pmpstartyearstatus").value;
    var pmpmidyearstatus = document.getElementById("pmpmidyearstatus").value;
    var pmpendyearstatus = document.getElementById("pmpendyearstatus").value;
//    var pmpasEmployee = document.getElementById("pmpasEmployee").value;
//    alert("pmpstartyearstatus =" + pmpstartyearstatus);
//    alert("pmpmidyearstatus =" + pmpmidyearstatus);
//    alert("pmpendyearstatus =" + pmpendyearstatus);
//    alert("pmpasEmployee" + pmpasEmployee);


//        Competency Evaluation
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

    ///Competency Evaluation /////////////////////
    var count = document.getElementById("subCompentencyCount").value;
    for (i = 1; i <= count; i++) {
//True/False vs 0/1 in mySQL
        if (pmpstartyearstatus === 'false') {
           
            document.getElementById("compentencyStartRemark" + i).readOnly = false;
            document.getElementById("competencyStartYear" + i).style.pointerEvents = "default";
            document.getElementById("competencyStartYear" + i).style.cursor = "default";

        } else {
           
            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
            document.getElementById("competencyStartYear" + i).style.cursor = "default";
            document.getElementById("compentencyStartRemark" + i).readOnly = true;
        }

        if (pmpmidyearstatus === 'false') {
            
            document.getElementById("compentencyMidYear" + i).readOnly = false;
            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "default";
            document.getElementById("compentencyMidYear" + i).style.cursor = "default";

        } else {
            
            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
            document.getElementById("compentencyMidRemark" + i).readOnly = true;
        }

        if (pmpendyearstatus === 'false') {
            
            document.getElementById("compentencyEndYear" + i).readOnly = false;
            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "default";
            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
        } else {
           
            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
            document.getElementById("compentencyEndRemark" + i).readOnly = true;
        }
    }
//    if (flag11 == 'true') {
//        for (i = 1; i <= count; i++) {
//
//            if (pmpstartyearstatus === 'false') {
//
//                document.getElementById("competencyStartYear" + i).readOnly = false;
//            } else {
//
//                document.getElementById("competencyStartYear" + i).style.cursor = "default";
//                document.getElementById("competencyStartYear" + i).readOnly = true;
//            }
//
//
//            var compentencyMidYear = document.getElementById("compentencyMidYear" + i).value;
//
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidRemark" + i).readOnly = true;
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//
//            document.getElementById("compentencyEndRemark" + i).readOnly = true;
//
//        }
//    } else if (flagmid === 'true') {
//
//        for (i = 1; i <= count; i++) {
//
//            if (pmpmidyearstatus === 'false') {
//                document.getElementById("compentencyMidYear" + i).readOnly = false;
//            } else {
//
//                document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//                document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            }
//            document.getElementById("compentencyStartRemark" + i).readOnly = true;
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//
//            document.getElementById("compentencyEndRemark" + i).readOnly = true;
//        }
//    } else if (flagEndId === 'true') {
//        for (i = 1; i <= count; i++) {
////            document.getElementById("compentencyEndYear" + i).required = true;
////            document.getElementById("compentencyEndRemark" + i).required = true;
////            document.getElementById("competencyStartYear" + i).disabled = true;
////            if (pmpendyearstatus === 'false' && pmpasEmployee === 'false') {
//            if (pmpendyearstatus === 'false') {
//
//                document.getElementById("compentencyEndYear" + i).readOnly = false;
//            } else {
//
//                document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//                document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//            }
//            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
//            document.getElementById("competencyStartYear" + i).style.cursor = "default";
//            document.getElementById("compentencyStartRemark" + i).readOnly = true;
//            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//            document.getElementById("compentencyMidRemark" + i).readOnly = true;
//        }
//    }

});







function myajaxfun1(competencyEvaluationId) {

//
    alert('Dhaval Parmar' + competencyEvaluationId);
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
            alert('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' + count);
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
        },
        error: function () {
            alert('Please Select Only One Competency Evaluation');
        }
    });
}