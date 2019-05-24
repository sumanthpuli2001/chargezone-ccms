<%-- 
    Document   : PolicyReport
    Created on : 13 Jul, 2018, 1:15:41 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Policy Search</title>
    </head>
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
            <h1>SEARCH POLICY</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search Policy</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="policyMaster.htm?act=policyReportGet" method="post" name='form' onsubmit='return saveSubmit11();'>
            <!--<input type="hidden" name="policyName" value="${policyName}">-->
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
                                                <div class="col-sm-3">
                                                    <label>Select Policy Type : <span style="color: red;font-size: 12px;"></span></label>
                                                </div>
                                                <div class="col-sm-5">
                                                    <select name="policyId1" id="policyId1"  class="form-control">
                                                        <option value="" label="-- Select --" ></option>
                                                        <c:forEach var="comp" items="${policyName}">
                                                            <option value="${comp.key}" label="${comp.value}" ></option>
                                                        </c:forEach>
                                                    </select>
                                                    <span id="policyError" style="color: red;"></span>
                                                </div>
                                            </div>
                                        </div>`
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                            <div class="form-group">
                                <div class=" col-sm-12">
                                    <center>
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button><br><br>
                                    </center>
                                </div>
                            </div>

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        <form:form action="" method="post" commandName="bankStatement.htm"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="policyId1" value="${policyId1}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <c:choose>
                                        <c:when test="${!empty list}">
                                            <div class="box-header" style="text-align: right;">
                                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div id="printableArea">
                                        <c:choose>
                                            <c:when test="${empty list}">
                                                <tr>
                                                    <td align="center">
                                                        <c:out value="There is no record found."></c:out>
                                                        </td>
                                                    </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <center>  <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/> </center> 

                                                <div class="form-group">
                                                    <center><b><font size="4">Vadera & Co.</font></b></center> 
                                                </div>
                                                <div class="box-body no-padding">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="table table-bordered">
                                                                <table border="1" id="tableid" style="width: 100%;">

                                                                    <thead>
                                                                        <tr>
                                                                            <th>Policy Name</th>
                                                                            <th>Read Date</th>
                                                                            <th>Reader Name</th>
                                                                            <th>policy Accepted Time</th>
                                                                            <th>policy Accepted</th>

                                                                        </tr>
                                                                    </thead>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <tbody>

                                                                <c:forEach var="list" items="${list}">

                                                                <tr>
                                                                    <td>${pc.name}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <c:if test="${list[3] == 1}"><td><span class="badge">Yes</span></td></c:if>
                                                                    <c:if test="${list[3] == 0}"><td><span class="badge">No</span></td></c:if>
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

                            </div>
                        </div><!-- /.col -->
                </section>
            </div>
        </c:if>
    </div>
</form:form>
    <script type="text/javascript">
    function ExportToExcel(tableid) {
        var htmltable = document.getElementById('tableid');
        var html = htmltable.outerHTML;
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
    }
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
