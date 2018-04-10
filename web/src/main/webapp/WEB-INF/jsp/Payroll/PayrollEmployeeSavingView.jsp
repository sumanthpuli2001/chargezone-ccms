<%--
    Document   : PayrollProfessionalTaxView
    Created on : Jul 13, 2016, 4:24:25 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Saving Create</title>
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Saving : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">create</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="payrollSavingAmount.htm?act=createSubmit" method="post" 
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

                                    <div class="box-body no-padding">

                                        <div class="row">
                                            <div class="col-md-12 col-sm-12" style="font-size: 16px; margin: 10px 0px 20px 0px;">
                                                <b>Employee Name :</b>
                                                <span>${employeeMaster.employeeName}</span>
                                                <input type="hidden" name="employeeId" value="${employeeMaster.id}">

                                                &nbsp;&nbsp;&nbsp;
                                                <b> Year : </b>
                                                <span>${payrollFormSixteenMaster.payrollFinancialYear.title}</span> 
                                                <input type="hidden" name="yearId" value="${payrollFormSixteenMaster.id}">  

                                            </div>
                                        </div>
                                        <div class="table table-bordered">
                                            <c:forEach var="listOfLoan" items="${finalData}" varStatus="myindex">

                                                <div style="text-align: center;"><b>Section - ${listOfLoan[0]}</b></div>
                                                <br/>
                                                <table id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <th>Sr. No.</th>
                                                            <th>Saving Type
                                                            </th>
                                                            <th>Amount</th>
                                                            <th>Proof submission </th>
                                                            <th> </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="listOfLoan1" items="${listOfLoan[1]}" varStatus="myindex1">
                                                        <input type="hidden" id="hrId" name="hrId" value="${myindex1.count}"/>
                                                        <tr>
                                                            <td>${myindex1.count}</td>
                                                            <td>
                                                                <c:out value="${listOfLoan1}"/> </br>
                                                            </td>
                                                            <td><input type="text" name="savingTypeAmount1" value="0.0" class="form-control"></td>
                                                            <td> <input type="file" name="file1" id="file11" value="" onchange="checkfile(this,${myindex1.count});"/></td>
                                                            <td><div class="col-sm-6" id="uploadDiv${myindex1.count}" name="uploadDiv${myindex1.count}" style="display: none">
                                                                    <input type="submit" style="width: 100px;"  value="UPLOAD" class="btn btn-primary" id="saveSubmit2"  onclick="document.getElementById('save').value = '1';" />
                                                                </div></td>
                                                                <td><input type="hidden" id="hrId" name="hrId" value="${myindex1.count}"/></td> 
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </c:forEach>
                                        </div>
                                        <c:if test="${!empty employeelist}">
                                        </c:if>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script type="text/javascript" language="javascript">
        function checkfile(sender,index) {
//          alert("hii"+index);
                var tflag11 = document.getElementById("hrId").value;
//            alert(tflag11);
            $('#saveSubmit2').show();

            var validExts = new Array(".xlsx", ".xls");
            var fileExt = sender.value;
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (validExts.indexOf(fileExt) < 0) {
                alert("Invalid file selected, valid files are of " +
                        validExts.toString() + " types.");
                document.getElementById('file11').value = '';
                return false;
                $("#uploadDiv"+index).hide();

            }
            else {
                $("#uploadDiv"+index).show();
                return true;
            }
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>