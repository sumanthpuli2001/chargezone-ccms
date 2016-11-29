/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/////////////////////////Manager side///////////////////////////////////////////////////////////////////////////











function managerajaxfun() {

//
    var competencyEvaluationId = document.getElementById("competencyEvaluationId").value;
    //    alert('Dhaval Parmar' + competencyEvaluationId);
    $.ajax({
        type: "POST",
        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
        //                    data: "selectedvalue=" + selectedVal,
        data: {"selectedvalue": competencyEvaluationId},
        dataType: "text",
        success: function (responseTxt) {
//            alert(responseTxt);
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
            if (flagEndId == 'true') { //                alert("fdfddffhdf");
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
//    var flag11 = document.getElementById("flagId").value;
//    var flag11a = document.getElementById("flagId").value;
//    var flagmid = document.getElementById("flagMidId").value;
//    var flagEndId = document.getElementById("flagEndId").value;
//    var kragoalLengthactivity = document.getElementById("kragoalLengthactivity").value;
//    var kragoalLength = document.getElementById("kragoalLength").value;
//    var weightageScore = document.getElementById("weightageScore").value;
//    var managerStatus = document.getElementById("managerStatus").value;
//    alert("hello");
//    alert("fkgkdfg");
    var pmpstartyearstatus = document.getElementById("pmpstartyearstatus").value;
    var pmpmidyearstatus = document.getElementById("pmpmidyearstatus").value;
    var pmpendyearstatus = document.getElementById("pmpendyearstatus").value;
//    alert(pmpstartyearstatus);
//    alert(pmpmidyearstatus);
//    alert(pmpendyearstatus);
//    var pmpasManager = document.getElementById("pmpasManager").value;


    ///Compentency /////////////////////
    var count = document.getElementById("subCompentencyCount").value;
    for (i = 1; i <= count; i++) {
        if (pmpstartyearstatus === 'false') {
//            alert("a");
            document.getElementById("compentencyStartRemark" + i).readOnly = false;
            document.getElementById("competencyStartYear" + i).style.pointerEvents = "default";
            document.getElementById("competencyStartYear" + i).style.cursor = "default";

        } else {

//            alert("a1");
            document.getElementById("competencyStartYear" + i).style.pointerEvents = "none";
            document.getElementById("competencyStartYear" + i).style.cursor = "default";
            document.getElementById("compentencyStartRemark" + i).readOnly = true;
        }

        if (pmpmidyearstatus === 'false') {
//            alert("b");
            document.getElementById("compentencyMidYear" + i).readOnly = false;
            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "default";
            document.getElementById("compentencyMidYear" + i).style.cursor = "default";

        } else {
//            alert("b1");
            document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
            document.getElementById("compentencyMidYear" + i).style.cursor = "default";
            document.getElementById("compentencyMidRemark" + i).readOnly = true;
        }

        if (pmpendyearstatus === 'false') {
//            alert("c");
            document.getElementById("compentencyEndYear" + i).readOnly = false;
            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "default";
            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
        } else {
//            alert("c1");
            document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
            document.getElementById("compentencyEndYear" + i).style.cursor = "default";
            document.getElementById("compentencyEndRemark" + i).readOnly = true;
        }

    }
//    if (pmpstartyearstatus === 'false') {
//        document.getElementById("competencyStartYear" + i).readOnly = false;
//    } else {
//        document.getElementById("competencyStartYear" + i).style.cursor = "default";
//        document.getElementById("competencyStartYear" + i).readOnly = true;
//    }
//
//    if (pmpmidyearstatus === 'false') {
//        document.getElementById("compentencyMidYear" + i).readOnly = false;
//    } else {
//        document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
//        document.getElementById("compentencyMidYear" + i).style.cursor = "default";
//    }
//
//    if (pmpendyearstatus === 'false') {
//        document.getElementById("compentencyEndYear" + i).readOnly = false;
//    } else {
//        document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
//        document.getElementById("compentencyEndYear" + i).style.cursor = "default";
//    }



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
});
function myajaxfunManager1(competencyEvaluationId) {

//
//    var competencyEvaluationId = document.getElementById("competencyEvaluationId").value;
    //    alert('Dhaval Parmar' + competencyEvaluationId);
    $.ajax({
        type: "POST",
        url: "competencyEvaluationTextmaster.htm?act=ajaxCall&competencyEvaluationId=" + competencyEvaluationId,
        //                    data: "selectedvalue=" + selectedVal,
        data: {"selectedvalue": competencyEvaluationId},
        dataType: "text",
        success: function (responseTxt) {
//            alert(responseTxt);
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
                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
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

                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";

                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
                    document.getElementById("compentencyEndRemark" + i).readOnly = true;
                }
            }
            if (flagEndId == 'true') { //                alert("fdfddffhdf");
                for (i = 1; i <= count; i++) {

                    var compentencyMidYear = document.getElementById("compentencyStartYear" + i).value;
//                    document.getElementById("compentencyMidYear" + i).disabled = true;
                    document.getElementById("compentencyStartYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyStartYear" + i).style.cursor = "default";
                    document.getElementById("compentencyStartRemark" + i).readOnly = true;
                    document.getElementById("compentencyMidYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyMidYear" + i).style.cursor = "default";
                    document.getElementById("compentencyMidRemark" + i).readOnly = true;
                    document.getElementById("compentencyEndYear" + i).style.pointerEvents = "none";
                    document.getElementById("compentencyEndYear" + i).style.cursor = "default";
                }
            }
        },
        error: function () {
            alert('Please Select Only One Competency Evaluation');
        }
    });
}
////////////Competency Evaluation (As Per Zydex Competency Framework) ://////////////////
