<%-- 
    Document   : uploadCurrentOpening
    Created on : Mar 29, 2016, 10:39:38 AM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Current Opening</title>
        <script>      
//        function checkFileSize() {
//            if (typeof FileReader !== "undefined") {
//                var fileSize = document.getElementById('photograph').files[0].size;
////                alert("my File size is   " + fileSize);
//                if (fileSize > 102400) {
//                    document.getElementById('photograph').value = '';
//                    document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
//                } else {
//                    document.getElementById('photographError').innerHTML = '';
//                }
//                // check file size
//            }
//        }
          function saveSubmit11(){
                 var flag = true;
        if (null == document.getElementById('photograph').value
                || '' == document.getElementById('photograph').value) {
            alert("Please, Select file.");
             flag = false;
            if(flag){
                    flag = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Submit ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
                
            }
        }
        
        </script>
         <script>
            function RemoveClick() {
                window.location = "employeeReferral.htm?act=deleteCurrentOpeningimage&imgname=";
            }
        </script>
    </head>
    <body>
       <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>CURRENT OPENINGS</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Current Openings</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <form:form action="employeeReferral.htm?act=currentOpeningFileUpload"  enctype="multipart/form-data" method="post" commandName=""
                                       name='form1'  onsubmit="return saveSubmit11();" class="form-horizontal" role="form">
                                  <div class="form-group">  
                                     <div class="col-sm-1"></div>
                                  </div>
                                <div class="form-group">  
                                     <!--<div class="col-sm-1"></div>-->
                                <div class="col-sm-2">
                                    <label>Upload:</label></div>
                                        <div class="col-sm-6">
                                                            <input type="file" class="form-control" id="photograph" name="photograph" accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                                            <span style="font-size: 14px; color: red;" id="photographError"></span>

                                                        </div>
                                                        </div>

                                   <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-6">
                                            &nbsp;&nbsp;<button type="submit" style="width: 100px;" class="btn btn-primary" id="saveSubmit1" >SUBMIT</button>
                                        </div> 
                                    </div>
                            </form:form>
                               </div>
                    </div><!-- nav-tabs-custom -->
                </div>
            </div>
        </section>
             <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                               <form:form action="" method="post" commandName=""
                       name='form1' class="form-horizontal" role="form">
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <!--<button type="submit" class="btn btn-danger" ><i class="fa fa-trash-o"></i>&nbsp;&nbsp;Delete</button>-->
                                        
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1" class=" table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty finalList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no Current Opening."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <th>Image Name</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                               </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                                    <tbody>
                                                                         <c:forEach var="list" items="${finalList}">
                                                                        <tr><td>
                                                                            ${list}</td>
                                                                            <td style="width: 20%">
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle" onclick="window.location = 'employeeReferral.htm?act=deleteCurrentOpeningimage&imgname=${list}'" >
                                                                                            &nbsp;&nbsp;REMOVE
                                                                                </button>
                                                                            </div>
                                                                                </td>
                                                                        </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>
            </form:form>
                        </div>
                    </div><!-- nav-tabs-custom -->
                </div>
            </div>
        </section>
    </div>

    </body>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
