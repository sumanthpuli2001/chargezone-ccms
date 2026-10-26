$(document).ready(function () {
//    $('input').iCheck({
//        checkboxClass: 'icheckbox_square-blue',
//        radioClass: 'iradio_square-blue',
//        increaseArea: '10%' // optional
//    });
//    $('#toggleId').on('ifChanged', function (event) {
//        if (event.target.checked === true) {
//            $("input[name='checkId']").iCheck('check');
//        } else {
//            $("input[name='checkId']").iCheck('uncheck');
//        }
//    });
//    $('#table_1').DataTable();


});
window.setTimeout(function () {
    $(".alert-danger").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 11000);
window.setTimeout(function () {
    $(".alert-info").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 8000);
window.setTimeout(function () {
    $(".alert-warning").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 11000);
window.setTimeout(function () {
    $(".alert-success").fadeTo(500, 0).slideUp(500, function () {
        $(this).remove();
    });
}, 8000);
//==============================================================//
function changeReadonly(id) {
//    alert("hellouuuuu" + id);
//    var str = id;
//    alert("str" + str);
//    var res = str.split("EditByEmployee"+14);
////    var abc = id;
//    alert("res==" + res);
    var kra = document.getElementById('kraGoal' + id);
    var metric = document.getElementById('metric' + id);
    var midYear = document.getElementById('midYearDiv' + id);
    var endYear = document.getElementById('endYearDiv' + id);
    var weightages = document.getElementById('weightage' + id);
    kra.readOnly = false;
    weightages.readOnly = false;
    metric.readOnly = false;
    if (midYear !== null) {
        midYear.readOnly = false;
    }
    if (endYear !== null) {
        endYear.readOnly = false;
    }
}
function changeReadonlyOther(id) {
    var kraGoal_activity = document.getElementById('kraGoal_activity' + id);
    var metric_activity = document.getElementById('metric_activity' + id);
    var midYearDivOther = document.getElementById('midYearDivOther' + id);
    var endYearDivOther = document.getElementById('endYearDivOther' + id);
    kraGoal_activity.readOnly = false;
    metric_activity.readOnly = false;
    if (midYearDivOther !== null) {
        midYearDivOther.readOnly = false;
    }
    if (endYearDivOther !== null) {
        endYearDivOther.readOnly = false;
    }
}
//============================================================//
