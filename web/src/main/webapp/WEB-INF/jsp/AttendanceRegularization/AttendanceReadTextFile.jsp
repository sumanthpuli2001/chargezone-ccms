<%-- 
    Document   : AttendanceReadTextFile
    Created on : 29 Aug, 2017, 5:04:49 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Monthly Employee Shift Upload For Text File</title>
    </head>
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

//            var rawFile = new XMLHttpRequest();
//            rawFile.open("GET", file, false);
//            rawFile.onreadystatechange = function ()
//            {
//                if (rawFile.readyState === 4)
//                {
//                    if (rawFile.status === 200 || rawFile.status == 0)
//                    {
//                        var allText = rawFile.responseText;
//                        alert(allText);
//                    }
//                }
//            }
//            rawFile.send(null);

            $('#saveSubmit2').show();
         
            var validExts = new Array(".txt");
            var fileExt = sender.value;
//            alert("asd1"+JSON.stringify(fileExt));
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Monthly Employee Attendance Upload TextFile</h1>
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
        <form:form class="form-horizontal" role="form" action="attendanceRegularizationMaster.htm?act=readTextFile" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">

                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Upload TextFile:</h3>

                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6" id="excelDiv">
                                            <input type="file" name="file1" id="file11" value="" onchange="checkfile(this);"/>
                                            <input type="hidden" id="fileName" name="fileName" value=""/>
                                            <!--<span  class="label label-primary"> <a href="attendanceRegularizationMaster.htm?act=readTextFile">Submit</a> </span>-->
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

</html>