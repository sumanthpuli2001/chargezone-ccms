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
            <h1>EMPLOYEE SAVING  </h1>
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
                                <form:form action="payrollEmployeeFormSixteen.htm?act=redirectToFormEmployeeSaving" method="post" enctype="multipart/form-data" 
                                           name='form1'  class="form-horizontal"  role="form">

                                    <div class="box-body no-padding">

                                        <div class="row">
                                            <div class="col-md-12 col-sm-12" style="font-size: 16px; margin: 10px 0px 20px 0px;">
                                                <b>Employee Name :</b>
                                                <span>${employeeMaster.employeeName}</span>
                                                <input type="hidden" id="employeeId" name="employeeId" value="${employeeMaster.id}">

                                                &nbsp;&nbsp;&nbsp;
                                                <b> Year : </b>
                                                <span>${payrollFormSixteenMaster.payrollFinancialYear.title}</span> 
                                                <input type="hidden" id="yearId" name="yearId" value="${payrollFormSixteenMaster.id}">  

                                            </div>
                                        </div>
                                        <div class="table table-bordered">
                                            <c:forEach var="listOfLoan" items="${finalData}" varStatus="myindex">

                                                <div style="text-align: center;"><b>Section - ${listOfLoan[0]}</b></div>
                                                <br/>
                                                <input type="hidden" name="savingTypeId" id="savingTypeId" value="${taxDeductioncomponentIDList}" class="form-control">
                                                <table id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <th>Sr. No.</th>
                                                            <th>Saving Type</th>
                                                            <th>Amount</th>
                                                            <th>Proof submission </th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="listOfLoan1" items="${listOfLoan[1]}" varStatus="myindex1">
                                                            <%--<c:forEach var="listOfLoan2" items="${listOfLoan[2]}" varStatus="myindex2">--%>
                                                        <input type="hidden" id="hrId" name="hrId" value="${myindex1.count}"/>
                                                        <input type="hidden" id="limitamount${listOfLoan1[1]}" name="limitamount${listOfLoan1[1]}" value="${listOfLoan1[2]}"/>
                                                        <input type="hidden" id="compenontid" name="compenontid" value="${listOfLoan1[1]}"/>
                                                        <tr>
                                                            <td>${myindex1.count}</td>
                                                            <td>


                                                                <c:out value="${listOfLoan1[0]}"/> </br>
                                                            </td>

                                                            <td><input type="text" name="savingTypeAmount" id="savingTypeAmount${listOfLoan1[1]}" value="0.0" class="form-control" onfocus="this.oldvalue = ${listOfLoan1[2]};
                                                                    this.idvalue = savingTypeAmount${listOfLoan1[1]};" onchange="pepe(this.value, this.oldvalue, this.idvalue);
                                                                            this.oldvalue = ${listOfLoan1[2]};
                                                                            this.idvalue = savingTypeAmount${listOfLoan1[1]};"></td>
                                                            <td> <input type="file" name="file11" id="file${listOfLoan1[1]}" value="" onfocus="this.idvalue1 = ${listOfLoan1[1]};" onchange="changeButton(this.idvalue1);this.idvalue1 = ${listOfLoan1[1]};"
                                                                        /></td>

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
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT" onclick="submittax();" >
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
    <script>
        function changeButton(idvalue) {
           
        
            var className = document.getElementById("file" + idvalue).value;
            if (className != null || className != '') {
//                document.getElementById('imageSrc').innerHTML = "<button naem='updateImg' class='btn btn-primary' onclick='updatePP();'> update</botton>";
                if (typeof FileReader !== "undefined") {
                    var fileSize = document.getElementById("file" + idvalue).files[0].size;
//                alert("my File size is   " + fileSize);
//                    if (fileSize > 102400) {
//                        document.getElementById('file11').value = '';
//                        document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
//                    } else {
//                        document.getElementById('photographError').innerHTML = '';
                    var photographUpdate = document.getElementById("file" + idvalue).files[0];
                    var userName = '${employeeMaster.id}';
                    var finicailyear = '${payrollFormSixteenMaster.payrollFinancialYear.id}';
                    var fd = new FormData();
                    fd.append('userName', '${employeeMaster.id}');
                    fd.append('finicailyear', '${payrollFormSixteenMaster.payrollFinancialYear.id}');
                    fd.append('compenomtid', idvalue);
                    fd.append('photographUpdate', photographUpdate);
                    $.ajax({
                        url: 'payrollEmployeeFormSixteen.htm?act=displayPictureTaxDeduction',
                        data: fd,
                        processData: false,
                        contentType: false,
                        type: 'POST',
                        success: function (result) {
                            $("#photograph").attr("src", result);
                        }
                    });
                    //                    }
                    // check file size
                }

            }
        }

    </script>
    <script type="text/javascript" language="javascript">
        function submittax() {

            var emplId = document.getElementById("employeeId").value;
//            alert(emplId);
            var yearID = document.getElementById("yearId").value;
            //            alert(yearID);
            var savingTypeIdList = document.getElementById("savingTypeId").value;
//            alert(savingTypeIdList);
            var savingTypeId = savingTypeIdList.split(",");
            var list = [];
            var finalData1 = [];
            var finalData2 = [];
            var amount = 0;
            var file = '';
            var data1;
            for (var i = 0; i < savingTypeId.length; i++) {
                amount = document.getElementById("savingTypeAmount" + savingTypeId[i].replace(" ", "")).value;
                file = document.getElementById("file" + savingTypeId[i].replace(" ", "")).value;
                data1 = savingTypeId[i].replace(" ", "");
                var subList = [];
                var finalData = [];
                subList.push(savingTypeId[i].replace(" ", "") + "-");
                subList.push(amount + "-");
                //                if (i + 1 == savingTypeId.length) {
//                    subList.push(file.replace("C:\\fakepath\\", ""));
//                } else {
                subList.push(file.replace("C:\\fakepath\\", "") + "-");
//                subList.push(file.replace("", "") + "-");
                //                }
                list.push(subList);
                finalData.push(data1);
                finalData1.push(finalData); // conpemnet tax  decution id
            }
//            alert(list);
            $.ajax({
                type: "POST",
                url: "payrollEmployeeFormSixteen.htm?act=clickSubmitSavingAmount&list=" + list + "&emplId=" + emplId + "&yearID=" + yearID + "&finalData1=" + finalData1,
                data: {},
                dataType: "text",
                success: function (responseTxt) {

                },
            });
        }
    </script>
    <script type="text/javascript">
        function pepe(enteredAmount, limitAmount, id) {
            var flag = true;
            if (enteredAmount != '' && limitAmount != '') {
                var enteredAmountInDouble = parseFloat(enteredAmount);
                var limitAmountInDouble = parseFloat(limitAmount);
                if (enteredAmountInDouble + 1 > limitAmountInDouble) {
                    id.value = '0.0';
                    alert("Tax Amount must be less than " + limitAmount);
                    flag = false;
                }
            }
            return flag;
        }
    </script> 
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
