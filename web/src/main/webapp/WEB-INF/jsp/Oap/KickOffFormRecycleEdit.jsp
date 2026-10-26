<%-- 
    Document   : KickOffFormRecycleEdit
    Created on : Aug 18, 2025, 5:00:15 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Kick Off Form </title>
        <!--<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <title>Order Acquisition Process Checklist</title>
        <!--        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">-->
    <style>
        #table_1 td {
    height: auto !important;
}

#table_1 img {
    width: auto;
    display: block;
    margin: 0 auto;
}
    </style>
    </head>
    
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">Kick Off Form </h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="aocForm.htm?act=kickoffFormsubmit" method="post" commandName="KickOffForm"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="text" name="id" id="id" value="${id}">
<input type="text" name="aocid" id="aocid" value="${aocid}">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">
                                        
                                  <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                    <tbody>
                        <tr>
                            <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                <img src="StorageYard/Images/logo.png" style="background-color: white; max-height: 8vh;">
                            </td>

                            <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                               Kick Off Meeting Report
                            </td>
                        </tr>
                    </tbody>
                </table>
      
                                        
                                        
                                        
                                        
                                         



                                        <div style="max-width: 95%; margin: auto; border: 0px solid black;">
                                            <br>
                                            <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                                                <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                                                <div>
                                                    <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                                                </div>
                                            </div>

                                            <br>
                                        <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                            <thead>
                                                <tr>
                                                    <td colspan="5" style="border: 1px solid black; background-color: skyblue"><strong>B2B Hub Order Details</strong></td>
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <tr> 
                                                <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="documentno" id="documentno" value="${documentid}" readonly/> </td>    
                                            </tr>
                                                <tr>
                                                    <td  style="border: 1px solid black;"><strong>B2B Hub Location</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td  colspan="2"style="border: 1px solid black;"><input  class="form-control" name="hub" id="hub" required="required"/> </td>                                                   
                                                    <td colspan="1" style="border: 1px solid black;"><strong> Date&Time :</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date" id="datetimepicker1">
                                                            <input name="fromdateTime" type="text" class="form-control form_datetime" value="" maxlength="30" required="required"/>
                                                            <span class="input-group-addon">
                                                                <span class="fa fa-calendar"></span>
                                                            </span>
                                                        </div>
                                                    </td>

                                            <script>
$(function () {

                                                $(function () {
                                                    $('#datetimepicker1').datetimepicker({
                                                        format: 'DD-MM-YYYY HH:mm',
                                                    });
                                                    $('#datetimepicker2').datetimepicker({
                                                        format: 'DD-MM-YYYY HH:mm',
                                                    });
                                                });
                                                });
                                            </script>


                                            <!-- Include the necessary script for datetimepicker -->
                                            
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="projectName" id="projectName" required="required"/> </td>    
                                                <td colspan="1" style="border: 1px solid black;"><strong>Minutes Prepared By:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;"><input  class="form-control" name="minutesprepared" id="minutesprepared" required="required"/> </td> 

                                            </tr> 

                                            <thead>
                                                <tr>
                                                    <td id="policyTableHeader" colspan="5" style="border: 1px solid black;text-align:center; background-color: skyblue"><strong>Attendees Present</strong></td>
                                                </tr>
                                                <tr>
                                                    <th style="border: 1px solid black;">Name<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Roll in Project<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Email<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Cell No<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Action</th>
                                                </tr>
                                            </thead>

                                            <tbody id="policyBody">
                                                <tr id="addmoreFile1">
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="Name" class="form-control" id="name" name="name" required="required"/> </td> 
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="RollNO" class="form-control" id="roll" name="roll" required="required"/> </td> 
                                                    <td style="border: 1px solid black;">
                                                        <input type="email" placeholder="E-Mail" class="form-control" id="email" name="email" required="required"/> 
                                                    </td>
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="CellNo" class="form-control" id="cellno" name="cellno" required="required"/> </td> 
                                                    <td style="text-align: center; border: 1px solid black;">
                                                        <span style="margin-top: 5px;">
                                                            <input type="button" value="+" id="policyCloneid"/>
                                                        </span>
                                                    </td>
                                                </tr>
                                            </tbody>

                                            <script>
                                                var tempCount3 = 1;
                                                $(function () {
                                                    $("#policyCloneid").on("click", function () {
                                                        tempCount3++;
                                                        var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"form-control\" placeholder=\"Name\" name=\"name" + "\" id=\"name" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"form-control\" placeholder=\"RollNO\" name=\"roll" + "\" id=\"roll" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"email\" class=\"form-control\" placeholder=\"E-Mail\" name=\"email" + "\" id=\"email" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"form-control\" placeholder=\"CellNo\" name=\"cellno" + "\" id=\"cellno" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'>"
                                                                + "<span style='margin-top: 5px;'>"
                                                                + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                                                                + "</span>"
                                                                + "</td>" + "</tr>";
                                                        $("#policyBody").append(clone);
                                                        document.getElementById('policyCount').value = tempCount3;
                                                    });
                                                });


                                                function removePolicy(policyDiv) {
                                                    try {
                                                        var element1 = document.getElementById(policyDiv);
                                                        element1.parentNode.removeChild(element1);

                                                        // Update the serial numbers
                                                        updateSerialNumbers();

                                                        // Update policyCount
                                                        var policyCount = document.getElementById('policyTable').rows.length - 1; // subtract 1 for header row
                                                        document.getElementById('policyCount').value = policyCount;
                                                    } catch (e) {
                                                        console.log(e);
                                                    }
                                                }

                                                function updateSerialNumbers() {
                                                    var table = document.getElementById('policyTable');
                                                    var rowCount = table.rows.length;
                                                    var srNo = 1;
                                                    for (var i = 1; i < rowCount; i++) {
                                                        if (table.rows[i].id !== '') { // Skip the header row
                                                            table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                                                        }
                                                    }
                                                }
                                            </script>



                                            <thead>
                                                <tr>
                                                    <td colspan="5" style="border: 1px solid black;text-align: center; background-color: skyblue"><strong>B2B Hub Deliverables Verification Details</strong></td>
                                                </tr>

                                            </thead>


                                            <td style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="design" id="design" > A. Design Basis Report 
                                                </div> 

                                            </td>  

                                            <td style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="boq" id="boq"> B.BOQ
                                                </div> 

                                            </td> 
                                            <td style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="loa" id="loa"> C.LOA / LOI
                                                </div> 

                                            </td> 

                                            <td style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="agreement" id="agreement"> D.Agreement
                                                </div> 

                                            </td> 
                                            <td style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="approved" id="approved"> E.Approved Layout Drawings
                                                </div> 

                                            </td> 
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Agendas:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="agendas" id="agendas" required="required"></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Issues:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="issues" id="issues" required="required"></textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Decisions:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="decisions" id="decisions" required="required"></textarea>
                                                </td>
                                            </tr>


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black;text-align: center; background-color: skyblue"><strong>Approval Receipt Details</strong></td>
                                                </tr>

                                            </thead>
                                            <td colspan="2" style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="plan" id="plan"> A. Plan layout Signed by Client
                                                </div> 

                                            </td>  

                                            <td colspan="2" style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="projectBudget" id="projectBudget"> B.Project Budget in line with AOC
                                                </div> 

                                            </td> 
                                            <td colspan="2" style="border: 1px solid black;"> <div style="display: inline;">
                                                    <input type="checkbox" name="projectTimeline" id="projectTimeline" > C.Project Timeline inline with AOC
                                                </div> 

                                            </td> 

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Comment if Unviable:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="comment" id="comment" required="required"></textarea>
                                                </td>
                                            </tr>

                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Order Review & Design Engineering details</strong></td>
                                                </tr>
                                            </thead>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Design Basis Report No.:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="form-control" name="designs" id="designs" /> </td>    
                                                <td colspan="2" style="border: 1px solid black;"><strong>Approved Layout Drawing Number:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="form-control" name="approvedlayout" id="approvedlayout" /> </td> 

                                            </tr>   
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>BOQ No</strong></td>
                                                <td style="border: 1px solid black;"><input  class="form-control" name="boqno" id="boqno" /> </td>    
                                                <td colspan="2" style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                                                <td  style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers1">
                                                        <input name="Fromdate" type="text" class="form-control form_datetime" value="" maxlength="30" />
                                                        <span class="input-group-addon">
                                                            <span class="fa fa-calendar"></span>
                                                        </span>
                                                    </div>
                                                </td> 



                                            </tr>  
                                            <script type="text/javascript">
                                                $(function () {
                                                    $('#datetimepickers1').datetimepicker({
                                                        format: 'DD-MM-YYYY',
                                                    });
                                                    $('#datetimepickers2').datetimepicker({
                                                        format: 'DD-MM-YYYY',
                                                    });
                                                });

                                            </script>


                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Reviewer Comment:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="reviewercomment" id="reviewercomment" required="required"></textarea>
                                                </td>
                                            </tr>



                                            <tr>
                                                <td style="border: 1px solid black;"><strong>New Revision No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="1" style="border: 1px solid black;"><input  class="form-control" name="newrevisonno" id="newrevisonno" required="required"/> </td>    
                                                <td style="border: 1px solid black;"><strong> Prepared By:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2"  style="border: 1px solid black;"><input  class="form-control" name="preparedby" id="preparedby" required="required"/> </td> 

                                            </tr> 

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Designation</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="form-control" name="designation" id="designation" required="required"/> 
                                                </td>

                                                <!--                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Signature & Date:</strong></td>
                                                                                                <td colspan="5" style="border: 1px solid black;">
                                                                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="signaturedate" id="signaturedate"></textarea>
                                                                                                </td>
                                                                                            </tr>-->

                                                <!--                                            <thead>
                                                                                                <tr>
                                                                                                    <td colspan="6" style="border: 1px solid black; background-color: skyblue"><strong>Order Approved details</strong></td>
                                                                                                </tr>
                                                
                                                                                            </thead>
                                                
                                                                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Approving Authority Comment:</strong></td>
                                                                                                <td colspan="5" style="border: 1px solid black;">
                                                                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                                </td>
                                                                                            </tr>
                                                
                                                                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Approved By:</strong></td>
                                                                                                <td style="border: 1px solid black;"><input  class="form-control"/> </td>    
                                                                                                <td colspan="2" style="border: 1px solid black;"><strong> Designation:</strong></td>
                                                                                                <td style="border: 1px solid black;"><input  class="form-control"/> </td> 
                                                
                                                                                            </tr> 
                                                
                                                                                            <tr>
                                                
                                                                                                <td colspan="1" style="border: 1px solid black;"><strong> Project Manager</strong></td>
                                                                                                <td    style="border: 1px solid black;"><input  class="form-control"/> </td> 
                                                                                            </tr> 
                                                
                                                                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Signature & Date:</strong></td>
                                                                                                <td colspan="5" style="border: 1px solid black;">
                                                                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                                </td>
                                                                                            </tr>-->



                                        </table>

                                        <br>
                                        <br>


                                        <table style="border-collapse: collapse; margin-left: 3vh;">
                                            <tr>
                                                <td style="padding: 5px; text-align: left;">
                                                    <label for="approvalName" style="display: inline-block; margin-left: 5px;">Approval Name:</label><span style="color: red;font-size: 12px;">*</span>
                                                </td>
                                                <td style="padding: 5px;">
                                                    <select class="form-control" id="approvalName" name="approvalName" 
                                                            style="width:225px; font-size: 12px; padding: 5px;" required="required">
                                                        <option value="">--SELECT--</option>
                                                        <c:forEach var="list10" items="${list10}">
                                                            <option value="${list10.id}">${list10.approvalName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>

 
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
                                            </div>
                                        </div>


                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>


