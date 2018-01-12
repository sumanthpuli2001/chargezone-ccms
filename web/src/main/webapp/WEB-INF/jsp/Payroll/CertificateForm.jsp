<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title> List Of Certificate</title>
    </head>
<script>
          function viewClick(id) {
            window.location = "certificateTemplate.htm?act=ViewIndiviualFormCertificate&id="+id;
   
        }
        </script>
    <script>

        function saveSubmit11() {
            var flag3 = true;
//            alert(document.getElementById("month").value);
            if (document.getElementById("month").value == '') {
                document.getElementById("monthError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("monthError").innerHTML = '';
            }
//            alert(flag3);
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Certificate Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Certificate Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Type of Certificate :<span style="color: red;font-size: 12px;">*</span></label>
                                                   <select class="form-control" id="certificateId" onchange="selectsubtype(this.value);">
                                                        <option value="" label="-- Select --" ></option>
                                                        <c:forEach var="EmpType" items="${certificateList}">
                                                            <option value="${EmpType.key}" label="${EmpType.value}" ></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            </div>
                                          
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                            <div id="mybodytext" class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        
    </div>
    <script>
        function selectsubtype(typeId) {

//            var empSubTypeId = document.getElementById("employeeSubTypeId").value;
            //            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("certificateTemplate.htm?act=readCertificateTypeAjax",
                    {
                        certificateId: typeId,
                        empId: '${employeeMaster.id}'
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('mybodytext').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

//        $(document).ready(function () {
//            var empTypeId = document.getElementById("employeeTypeMasterId").value;
//            selectsubtype(empTypeId);
//
//        });

    </script>
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
        });
    </script>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });

    </script>
    <script type="text/javascript">
        window.onload = init;
        function init() {
            document.form1.month.options[new Date().getMonth()].selected = true;
        }
        var start = 1990;
        var end = new Date().getFullYear();
        var options11 = "";

        for (var year1 = end; year1 >= start; year1--) {
            options11 += "<option>" + year1 + "</option>";
        }
        document.getElementById('year11').innerHTML = options11;
    </script>
     <script type="text/javascript">
    function printDiv(divName) {
     var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;

     document.body.innerHTML = printContents;

     window.print();

     document.body.innerHTML = originalContents;
}
 </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

