<%-- 
    Document   : paymentTypeMasterModeCreate
    Created on : Jan 31, 2020, 4:32:18 PM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Type Create</title>
    </head>
    
    
    <script>
        function selectShift(rotationId) {
                    //alert('Call Ajax');
            var paymentTypeMasterId = document.getElementById("id").value;
            
            var userName = '${param.userid}';
            var fd = new FormData();
            //fd.append('userName', '${param.userid}');
            fd.append('paymentModeId', rotationId);
            //alert("username"+employeeId)
            fd.append('paymentTypeMasterId', paymentTypeMasterId);
            $.ajax({
                url: 'payment.html?act=calculateAmountAjax',
                data: fd,
                processData: false,
                contentType: false,
                type: 'POST',
                success: function (result) {
                    //alert("Success: "+result);
                    document.getElementById("status1").innerHTML = result;
                    document.getElementById("status").value  = result;
                     //var input = document.createElement('input');
                       // input.setAttribute('type', 'hidden');
                       // input.setAttribute('status', result);
                       // document.body.appendChild(input);
                     //$("#status").attr("src", result);
                }
            });
        }
        
        function myFunction() {
            //var x = document.createElement("INPUT");
           // x.setAttribute("type", "text");
           // x.setAttribute("value", "Hello World!");
           // document.getElementById("status").innerHTML = document.getElementById("status1").innerHTML;
            //document.body.appendChild(x);
        }
    </script>
    
    
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Payment Mode</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Payment Mode Form</li>
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
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                              <form:form class="form-horizontal" method="post"
                                           modelAttribute="employeeTypeMaster" action="payment.html?act=createPaymentTypeMasterModeSubmit">
                                    <form:hidden path="id"></form:hidden>
                                   <%-- <form:hidden path="status"></form:hidden>--%>
                                    <input type="hidden" id="status" name="status">
                                   
                                   <%-- <form:input path="status" class="form-control"/>--%>
                                    
                                        <div class="form-group">
                                            <div class="col-sm-3">
                                                <label class="control-label">Select Payment Mode:<span style="color: red;font-size: 12px;">*</span></label>
                                            </div>
                                           
                                            <div class="col-sm-7">
                                                <select name="paymentMode" id="paymentMode" class="form-control" onchange="selectShift(this.value);">
                                                    <option value="">-- Select --</option>
                                                    <c:forEach var="shift1" items="${paymentModeMap}">
                                                       <option value="${shift1.key}" >${shift1.value}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                            
                                        
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="myFunction()" title="" value="SUBMIT">
                                        </div>
                                        <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                    <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                </div>-->
                                    </div>
                                    
                                     <div class="form-group">
                                        <div class="col-sm-10">
                                            <label class="control-label">Total Payment Amount:<span style="color: red;font-size: 12px;">*</span><span id="status1"></span> </label>
                                        </div>
                                    </div>
                                </form:form>
                            
                                    
                                   
                           <%-- <form action = "payment.html?act=createSubmit" method = "POST">
                               <!-- <input type="hidden" name = "id" value="${id}">-->
                                <div class="form-group">
                                    <div class="col-sm-3">
                                        <label class="control-label">Enter Payment Type:<span style="color: red;font-size: 12px;">*</span></label>
                                    </div>
                                    <div class="col-sm-7">
                                        <input type="text" name = "payment_Type">
                                    </div>
                                </div>
                                <!--<br />
                                Last Name: <input type = "text" name = "last_name" />-->
                                <input type = "submit" value = "Submit" />
                             </form>--%>
                                
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
</html>