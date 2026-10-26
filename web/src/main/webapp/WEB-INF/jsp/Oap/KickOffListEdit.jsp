
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kick Off Edit</title>
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
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
<form:form action="aocForm.htm?act=KickOffEditSubmit" method="post" commandName="KickOffForm"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Kick Off Edit</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn"  onclick="return Validate()" title="" value="">SUBMIT</button>

                        </div>
                    </div>

                    <hr>
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
                    <input type="hidden" name="id" id="id" value="${id}">
                    <input type="hidden" name="aocId" id="id" value="${aocformid}">


                    <div style=" max-width: 100%; margin: auto; border: 0px solid black;">
                        <br>
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                            </div>
                        </div>
                        </div>

                        <br>  

                        <table id="kickoff" class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                                            <thead>
                                                <tr>
                                                    <td colspan="5" style="border: 1px solid black; background-color: skyblue"><strong>B2B Hub Order Details</strong></td>
                                                </tr>

                                            </thead>
                                            <tbody>
                                                <tr> 
                                                    <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="documentno" id="documentno" value="${kickOffForm.documentNo}" readonly/> </td>    
                                                </tr>
                                                <tr>
                                                    <td  style="border: 1px solid black;"><strong>B2B Hub Location</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="hub" id="hub" value="${kickOffForm.hubLocation}"required="true"/> </td>                                                   
                                                    <td  style="border: 1px solid black;"><strong> Date&Time :</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                    <td style="border: 1px solid black;">
                                                        <div class="input-group date">
                                                            <input
                                                                id="datetimepicker1"
                                                                name="fromdateTime"
                                                                type="text"
                                                                class="input-field"
                                                                value="${kickOffForm.dateTime}"
                                                                maxlength="30"
                                                                required
                                                                />
                                                        </div>

                                                    </td>

                                            <script>
$(function () {

    flatpickr("#datetimepicker1", {
        enableTime: true,
        dateFormat: "d-m-Y H:i",
        time_24hr: true,
        allowInput: true,

        // When user clicks the field
        onOpen: function(selectedDates, dateStr, instance) {
            if (!instance.input.value) {
                instance.setDate(new Date(), false);
            }
        },

        // When user selects a date from calendar
        onChange: function(selectedDates, dateStr, instance) {
            if (selectedDates.length > 0) {
                const now = new Date();
                selectedDates[0].setHours(now.getHours());
                selectedDates[0].setMinutes(now.getMinutes());
                instance.setDate(selectedDates[0], false);
            }
        }
    });
    });
</script>






                                            <!-- Include the necessary script for datetimepicker -->

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Name:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="projectName" id="projectName" value="${kickOffForm.projectName}" required="true"/> </td>    
                                                <td  style="border: 1px solid black;"><strong>Minutes Prepared By:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="minutesprepared" id="minutesprepared" value="${kickOffForm.minutues}" required="true"/> </td> 

                                            </tr> 

                                            <thead>
                                                <tr>
                                                    <td id="policyTableHeader" colspan="5" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Attendees Present</strong></td>
                                                </tr>
                                                <tr>
                                                    <th style="border: 1px solid black;">Name<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Roll in Project<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Email<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Cell No<span style="color: red;font-size: 12px;">*</span></th>
                                                    <th style="border: 1px solid black;">Action</th>
                                                </tr>
                                            </thead>
                                            <c:forEach var="list44" items="${list44}">
                                                <tr>
                                                    <td style="border: 1px solid black;"><span>${list44.name}</span>
                                                    </td> 
                                                    <td style="border: 1px solid black;"><span>${list44.rollInProject}</span>
                                                    </td> 
                                                    <td style="border: 1px solid black;"><span>${list44.email}</span>
                                                    </td> 
                                                    <td style="border: 1px solid black;"><span>${list44.cellNo}</span>
                                                    </td> 
                                                    <td style="text-align: center; border: 1px solid black;">
<!--                                                        <a href="aocForm.htm?act=KickOffattdencesdelete&id=${list44.id}&id1=${kickOffForm.id}">
                                                            <i class="fas fa-trash-alt" style="color: gray;"></i>
                                                        </a>-->
                                                        
                                                        <div class="text-center">
                                                            <a data-id="${list44.id}"
                                                               data-id1="${kickOffForm.id}"
                                                               class="d-inline-block text-danger p-1 mx-1 kickoff-delete-btn"
                                                               data-toggle="tooltip"
                                                               data-placement="left"
                                                               title="Delete">
                                                                <img src="StorageYard/assets/images/delete-icon.svg"
                                                                     onload="SVGInject(this)"
                                                                     alt="Delete Icon"
                                                                     style="width: 22px; height: 22px;">
                                                            </a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                                <script>
document.querySelectorAll('.kickoff-delete-btn').forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        e.preventDefault();

        var $row = $(this).closest('tr');
        var id  = $(this).data('id');
        var id1 = $(this).data('id1');

        Swal.fire({
            title: 'Are you sure?',
            text: 'Do you really want to delete this Kickoff Attendance?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#6c757d',
            confirmButtonText: 'Yes, delete it!',
            reverseButtons: true,
            customClass: {
                confirmButton: 'confirm-delete',
                cancelButton: 'theme-btn light-btn'
            }
        }).then((result) => {
            if (!result.isConfirmed) return;

            $.ajax({
                url: 'aocForm.htm?act=KickOffattdencesdelete&id=' + id + '&id1=' + id1,
                type: 'POST',
                contentType: 'application/json',
                success: function (response) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Deleted!',
                        text: response.message || 'Record has been deleted.'
                    }).then(() => {
                       
                        window.location.href =
                            'aocForm.htm?act=KickOffListEdit&id=' + id1;
                    });
                },
                error: function (xhr) {
                    Swal.fire(
                        'Error!',
                        'Error deleting record: ' + xhr.responseText,
                        'error'
                    );
                }
            });
        });
    });
});
</script>



                                            <tbody id="policyBody">
                                                <tr id="addmoreFile1">
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="Name" class="input-field" id="name" name="name"/> </td> 
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="RollNO" class="input-field" id="roll" name="roll"/> </td> 
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="E-Mail" class="input-field" id="email" name="email"/> </td> 
                                                    <td style="border: 1px solid black;"><input type="text" placeholder="CellNo" class="input-field" id="cellno" name="cellno"/> </td> 
                                                    <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                                <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                                    <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                </div>
                                            </td>
                                                </tr>
                                            </tbody>

                                            <script>
                                                var tempCount3 = 1;
                                                $(function () {
                                                    $("#policyCloneid").on("click", function () {
                                                        tempCount3++;
                                                        var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"input-field\" placeholder=\"Name\" name=\"name" + "\" id=\"name" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"input-field\" placeholder=\"RollNO\" name=\"roll" + "\" id=\"roll" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"input-field\" placeholder=\"E-Mail\" name=\"email" + "\" id=\"email" + tempCount3 + "\"></td>"
                                                                + "<td style='border: 1px solid black;'><input type =\"text\" class=\"input-field\" placeholder=\"CellNo\" name=\"cellno" + "\" id=\"cellno" + tempCount3 + "\"></td>"
                                                               + "<td style='border: 1px solid black; text-align: center; vertical-align: middle;'>"
+ "<span style='margin-top: 5px; display: inline-block;'>"
+ "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-flex; align-items: center; justify-content: center;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
+ "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove' style='width: 70px; height: 70px;'>"
+ "</div>"
+ "</span>"
+ "</td>"
+ "</tr>";
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
                                                    <td colspan="5" style="border: 1px solid black;text-align: center;  background-color: skyblue"><strong>B2B Hub Deliverables Verification Details</strong></td>
                                                </tr>

                                            </thead>


                                            <td style="border: 1px solid black;"> 
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="design" id="design" 
                                                           value="${kickOffForm.designBasic}" 
                                                           ${kickOffForm.designBasic == '1' ? 'checked' : ''}> A. Design Basis Report 
                                                </div>
                                            </td>

                                            <td style="border: 1px solid black;"> 
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="boq" id="boq" 
                                                           value="${kickOffForm.boq}" 
                                                           ${kickOffForm.boq == '1' ? 'checked' : ''}> B.BOQ
                                                </div>
                                            </td>

                                            <td style="border: 1px solid black;"> 
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="loa" id="loa" 
                                                           value="${kickOffForm.laoLoi}" 
                                                           ${kickOffForm.laoLoi == '1' ? 'checked' : ''}> C.LOA / LOI
                                                </div>
                                            </td>

                                            <td style="border: 1px solid black;"> 
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="agreement" id="agreement" 
                                                           value="${kickOffForm.agreement}" 
                                                           ${kickOffForm.agreement == '1' ? 'checked' : ''}> D.Agreement
                                                </div>
                                            </td>

                                            <td style="border: 1px solid black;"> 
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="approved" id="approved" 
                                                           value="${kickOffForm.approvedLayout}" 
                                                           ${kickOffForm.approvedLayout == '1' ? 'checked' : ''}> E.Approved Layout Drawings
                                                </div>
                                            </td>




                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Agendas:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="agendas" id="agendas"required="true">${kickOffForm.agendas}</textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Issues:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="issues" id="issues" required="true">${kickOffForm.issues}</textarea>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Decisions:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="decisions" id="decisions">${kickOffForm.decisions}</textarea>
                                                </td>
                                            </tr>



                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black;text-align: center;  background-color: skyblue"><strong>Approval Receipt Details</strong></td>
                                                </tr>

                                            </thead>
                                            <td colspan="2" style="border: 1px solid black;">
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="plan" id="plan" value="${kickOffForm.planLayout}"
                                                           ${kickOffForm.planLayout == '1' ? 'checked' : ''}>
                                                    A.Plan layout Signed by Client
                                                </div>
                                            </td>  

                                            <td colspan="2" style="border: 1px solid black;">
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="projectBudget" id="projectBudget" value="${kickOffForm.projectBudget}"
                                                           ${kickOffForm.projectBudget == '1' ? 'checked' : ''}>
                                                    B.Project Budget in line with AOC
                                                </div>
                                            </td>  

                                            <td colspan="2" style="border: 1px solid black;">
                                                <div style="display: inline;">
                                                    <input type="checkbox" name="projectTimeline" id="projectTimeline" value="${kickOffForm.projectTimeLine}"
                                                           ${kickOffForm.projectTimeLine == '1' ? 'checked' : ''}>
                                                    C.Project Timeline in line with AOC
                                                </div>
                                            </td>  

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="comment" id="comment" required="true">${kickOffForm.comments}</textarea>
                                                </td>
                                            </tr>


                                            <thead>
                                                <tr>
                                                    <td colspan="6" style="border: 1px solid black;text-align: center;  background-color: skyblue"><strong>Order Review & Design Engineering details</strong></td>
                                                </tr>
                                            </thead>
                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>Design Basis Report No.:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="designs" id="designs" value="${kickOffForm.designBasicReport}"/> </td>    
                                                <td colspan="1" style="border: 1px solid black;"><strong>Approved Layout Drawing Number:</strong></td>
                                                <td colspan="2"style="border: 1px solid black;"><input  class="input-field" name="approvedlayout" id="approvedlayout" value="${kickOffForm.approvedLayoutDrawings}" /> </td> 

                                            </tr>   
                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>BOQ No</strong></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="boqno" id="boqno"  value="${kickOffForm.boqNo}"/> </td>    
                                                <td  colspan="1" style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                                                <td colspan="2" style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers1">
                                                        <input name="Fromdate" id="datetimepickers1" type="text" class="input-field form_datetime" value="${kickOffForm.deliverableReleaseDate}" maxlength="30"  />
                                                       
                                                    </div>
                                                </td> 



                                            </tr>  
                                            <script>
$(function () {

    flatpickr("#datetimepickers1", {
//        enableTime: true,
        dateFormat: "d-m-Y ",
        allowInput: true
    });
    });
</script>



                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Reviewer Comment:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="5" style="border: 1px solid black;">
                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="reviewercomment" id="reviewercomment" required="true">${kickOffForm.reviewsComments}</textarea>
                                                </td>
                                            </tr>



                                            <tr>
                                                <td colspan="1" style="border: 1px solid black;"><strong>New Revision No:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="newrevisonno" id="newrevisonno" value="${kickOffForm.newRevisonNo}" required="true"/> </td>    
                                                <td colspan="1" style="border: 1px solid black;"><strong> Prepared By:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="preparedby" id="preparedby" value="${kickOffForm.preparedBy}"required="true"/> </td> 

                                            </tr> 

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Designation</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td colspan="2" style="border: 1px solid black;"><input  class="input-field" name="designation" id="designation" value="${kickOffForm.designation}" required="true"/> 
                                                </td>

                                                <!--                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Signature & Date:</strong></td>
                                                                                                <td colspan="5" style="border: 1px solid black;">
                                                                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;" name="signaturedate" id="signaturedate">${kickOffForm.signatureDate}</textarea>
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
                                                                                                <td style="border: 1px solid black;"><input  class="input-field"/> </td>    
                                                                                                <td colspan="2" style="border: 1px solid black;"><strong> Designation:</strong></td>
                                                                                                <td style="border: 1px solid black;"><input  class="input-field"/> </td> 
                                                
                                                                                            </tr> 
                                                
                                                                                            <tr>
                                                
                                                                                                <td colspan="1" style="border: 1px solid black;"><strong> Project Manager</strong></td>
                                                                                                <td    style="border: 1px solid black;"><input  class="input-field"/> </td> 
                                                                                            </tr> 
                                                
                                                                                            <tr>
                                                                                                <td style="border: 1px solid black;"><strong>Signature & Date:</strong></td>
                                                                                                <td colspan="5" style="border: 1px solid black;">
                                                                                                    <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                                </td>
                                                                                            </tr>-->



                                        </table>

                     <div class="rounded-4 mt-4">
                                                    <div class="row mb-3">
                                                        <div class="col-lg-6 col-md-9">
                                                            <div class="form-group">
                                                    <label for="approvalName" style="display: inline-block; margin-left: 5px;">Approval Name:</label><span style="color: red;font-size: 12px;">*</span>

  <input class="input-field" id="approvalName" name="approvalName" readonly="true" value="${projectmanager}">

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                  

                                        <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">
                                            <button type="submit" class="btn theme-btn"  onclick="return Validate()" title="" value="">SUBMIT</button>
                                            </div>
                                        </div>




                    </form:form>
                    </section>
                    </main>
                    </body>
                    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
                    </html>
