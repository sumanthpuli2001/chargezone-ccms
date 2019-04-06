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
        <title>Monthly Employee Shift Assign Excel Upload</title>
    </head>
    <style>
        #tabs{ margin: 20px -20px; border: none; }
        #tabs, #ui-datepicker-div, .ui-datepicker{ font-size: 85%; }
        .clear{ clear: both; }
        .ui-datepicker-calendar {
        display: none;
    }
        /*.example-container{ background-color: #f4f4f4; border-bottom: solid 2px #777777; margin: 0 0 20px 40px; padding: 20px; }*/
        /*.example-container input{ border: solid 1px #aaa; padding: 4px; width: 175px; }*/
    </style>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">

    <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
            if (flag3) {

                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
    <script type="text/javascript" language="javascript">
        function checkfile(sender) {

            $('#saveSubmit2').show();

            var validExts = new Array(".xlsx", ".xls");
            var fileExt = sender.value;
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (validExts.indexOf(fileExt) < 0) {
                alert("Invalid file selected, valid files are of " +
                        validExts.toString() + " types.");
                document.getElementById('file11').value = '';
                return false;
                $("#uploadDiv").hide();

            } else {
                $("#uploadDiv").show();
                return true;
            }
        }
    </script>
    <script>
    function redirectToDownloadFile()
        {
            var month = $('#monthYear').val();
            if(month == '' || month == null){
                document.getElementById("Error").innerHTML = 'It must be Selected.';
                
            }else{
//                alert(month);
                window.location = 'shiftRotationMaster.htm?act=downloadEmployeeMonthlyShiftFile&month='+month;
            }
            
            
        }
    </script>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>MONTHLY EMPLOYEE SHIFT ASSIGN EXCEL UPLOAD</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Shift Assign Excel Upload</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="shiftRotationMaster.htm?act=monthlyShiftAssignExcelUploadSubmit" commandName="shiftRotationMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">

                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Upload Excel:</h3>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4" id="excelDiv">
                                            <input type="file" name="file1" id="file11" value="" onchange="checkfile(this);"/>
                                            <input type="hidden" id="fileName" name="fileName" value=""/>
                                            <span>[ <a href="#" onclick="redirectToDownloadFile();">Sample Excel</a> ]</span>
                                        </div>
                                        	
                                        <div class="col-sm-2">
                                            <div class="input-group date">
                                                <label for="startDate">Select Month & Year:</label>  
                                                <input name="monthYear" id="monthYear" class="date-picker"/> 
                                                <span id="Error" style="color: red;"></span>
                                            </div>                 
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5" id="uploadDiv" name="uploadDiv" style="display: none">
                                            <input type="submit" value="Upload" class="btn btn-primary" id="saveSubmit2"  onclick="document.getElementById('save').value = '1';" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="tab-pane" id="tab_3"></div>
                    </div>
                </div>

            </section>
        </form:form>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
     <script type="text/javascript">
      
$(function() {
    $('.date-picker').datepicker( {
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        dateFormat: 'MM yy',
        onClose: function(dateText, inst) { 
            $(this).datepicker('setDate', new Date(inst.selectedYear, inst.selectedMonth, 1));
        }
    });
});
    </script>
      
</html>

