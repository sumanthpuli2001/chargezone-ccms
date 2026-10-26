
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRC Details View</title>
    </head>
    <style>
            textarea{
                width: 100%;
            }

            input[type="checkbox"]:disabled + label::before{
                background: gray;
            }
            input[type="checkbox"]:disabled + label:hover::before{
                background: gray;
                border: 1px solid #d4d4d5;
            }
            /*            @media print {
                            a[href]:after {
                                content: none !important;
            
                            }*/
        </style>
        <style>
            p {
                     word-wrap: break-word; /* Allows words to break if necessary */
                    max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
                }
                .break-after-80 {
                    word-wrap: break-word;
                    overflow-wrap: break-word;
                    max-width: 100ch; /* Limits to approximately 80 characters per line */
                    text-transform: capitalize;

                }
             .nav-tabs-custom {
                border-top: 0px solid #00a65a;

            }
        </style>
        <script>
                function printCustom() {
                    // Add custom print logic or redirection here
//                            alert('Redirecting to printable version...');
                    // Example redirection
                    window.location.href = 'oapForm.htm?act=oapPrint';
                }
            </script>
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
    <body>
       
    <main class="d-flex align-items-end justify-content-end">
         <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
         <section class="main-content">
              <form:form action=".htm?act=" commandName="departmentMaster" method="post">
           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">CRC Details View</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
<!--                          <a class="btn theme-btn mr-3"  href = "oapForm.htm?act=crcHistory&id=${id}" >
                                <i class="fa fa-history"></i>History
                            </a>-->
                        <a class="btn theme-btn " href="oapForm.htm?act=crcPrint&id=${id}" class="btn btn-primary" onclick="printCustom()" title="Print this page">
                            <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                        </a>
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
                             Contract Review Checklist
                            </td>
                        </tr>
                    </tbody>
                </table>

                        <br>
                        
      <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>PCS Order Details:</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                            <td style="border: 1px solid black;"> <span>${list.documentNo}</span>
                                            <td style="border: 1px solid black;"><strong>PCS Name:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.pcsName}</span>
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Document Revision No.:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.documentRevisionNo}</span>
                                            <td style="border: 1px solid black;"><strong>OAP Number: </strong></td>
                                            <td style="border: 1px solid black;"><span>${list.oapNumber}</span>
                                        </tr>

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Document Verification details</strong></td>
                                            </tr>

                                        </thead>


                                        <tr>
                                            <td style="border: 1px solid black; padding: 5px;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="site" id="site" 
                                                           value="${list.siteSurveyAcceptance}" 
                                                           ${list.siteSurveyAcceptance == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Site Survey Acceptance
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="agreement" id="agreement" 
                                                           value="${list.aggrementAcceptance}" 
                                                           ${list.aggrementAcceptance == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Agreement Acceptance
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="land" id="land" 
                                                           value="${list.landOwnerShipDocument}" 
                                                           ${list.landOwnerShipDocument == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Land Ownership Document
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="noc" id="noc" 
                                                           value="${list.nocConsent}" 
                                                           ${list.nocConsent == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    NOC/Consent
                                                </label>
                                            </td>
                                        </tr>






                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list.comment}</p>
                                            </td>

                                        </tr>

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Approval Receipt Details</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td style="border: 1px solid black;">
                                                <label style="display: inline;">
                                                    <input type="checkbox" name="plan" id="plan" 
                                                           value="${list.planLayoutSigned}" 
                                                           ${list.planLayoutSigned == '1' ? 'checked' : ''} disabled> Plan layout Signed by Ownership
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black;">
                                                <label style="display: inline;">
                                                    <input type="checkbox" name="projectOap" id="projectOap" 
                                                           value="${list.projectBudgetOap}" 
                                                           ${list.projectBudgetOap == '1' ? 'checked' : ''} disabled> Project Budget in line with OAP:
                                                </label>
                                            </td>
                                            <td colspan="4" style="border: 1px solid black; text-align: center;">
                                                <label style="display: inline;">
                                                    <input type="checkbox" name="timeline" id="timeline" 
                                                           value="${list.projectTimelineOap}" 
                                                           ${list.projectTimelineOap == '1' ? 'checked' : ''} disabled> Project Timeline in line with OAP:
                                                </label>
                                            </td>
                                        </tr>


                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list.aaprovalComment}</p>

                                            </td>

                                        </tr>

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Order Review & Engineering details</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Bill of Material No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.billMaterialNo}</span>
                                            <td style="border: 1px solid black;"><strong>PCS Drawing Number:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.pcsDrawingNumber}</span>
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Scope of Work No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.scopeWork}</span>
                                            <td style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.deliverableReleaseDate}</span>

                                            </td>    
                                        </tr>  

                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>New Revision No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.newRevisionNumber}</span>

                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Reviewer Comment:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list.reviewerComment}</p>
                                            </td>

                                        </tr>


                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Prepared By:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.preparedBy}</span>
                                            <td style="border: 1px solid black;"><strong>Designation:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.designation}</span>

                                        </tr> 
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Project Engineer:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list.projectEngineer}</span>


                                        </tr>

                                        

                                        <tr>
                                            <td colspan="4" style="border: 1px solid black; text-align: center; background-color: skyblue"><strong>Approval Status</strong></td>
                                        </tr>
                                        <thead>
                                            <tr>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Sr. No</th>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">User</th>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Comment</th>
                                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                                <tr>
                                                    <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                                    <td style="border: 1px solid black;">${list0.userId}</td> <!-- User ID -->
                                                    <td style="border: 1px solid black;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                                    <td style="border: 1px solid black;">
                                                        <c:if test="${list0.approvalStatus == '1'}">
                                                            Approved
                                                        </c:if>           
                                                        <c:if test="${list0.approvalStatus == '2'}">
                                                            recycle
                                                        </c:if>
                                                        <c:if test="${list0.approvalStatus == '3'}">
                                                            Rejected
                                                        </c:if>
                                                        <c:if test="${list0.approvalStatus == '4'}">
                                                            Partially Approve
                                                        </c:if>
                                                    </td> <!-- Approval Status -->
                                                </tr>
                                            </c:forEach>
                                        </tbody> 









                                        <!--                                            <thead>
                                                                                        <tr>
                                                                                            <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Order Approved details</strong></td>
                                                                                        </tr>
                                        
                                                                                    </thead>
                                        
                                        
                                                                                    <tr>
                                                                                        <td style="border: 1px solid black;"><strong>Approving Authority Comment:</strong></td>
                                                                                        <td colspan="3" style="border: 1px solid black;">
                                                                                            <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                        </td>                                              
                                                                                    </tr>
                                        
                                                                                    <tr>
                                                                                        <td style="border: 1px solid black;"><strong>Approved By:</strong></td>
                                                                                        <td style="border: 1px solid black;"><input  class="form-control"/> </td>                                                   
                                                                                        <td style="border: 1px solid black;"><strong>Designation:</strong></td>
                                                                                        <td style="border: 1px solid black;"><input  class="form-control"/> </td>                                                   
                                        
                                                                                    </tr> 
                                                                                    <tr>
                                                                                        <td style="border: 1px solid black;"><strong>Project Manager</strong></td>
                                                                                        <td style="border: 1px solid black;"><input  class="form-control"/> </td>                                                   
                                        
                                        
                                                                                    </tr>
                                        
                                        
                                                                                    <tr>
                                                                                        <td style="border: 1px solid black;"><strong>Signature & Date:</strong></td>
                                                                                        <td colspan="3" style="border: 1px solid black;">
                                                                                            <textarea style="width: 100%; height: 100px; border: none; resize: none;"></textarea>
                                                                                        </td>                                              
                                                                                    </tr>                     -->







                                    </table>

                                            <h6>Activity Milestone</h6>
                                            <table id="commonTable" class="table table-striped bg-white" style="max-width: 100%;" align="center">
                                                <thead>

                                                    <tr>
                                                        <th >Sr No</th>
                                                        <th>Activity</th>
                                                        <th >Activity By</th>
                                                        <th>Date</th>
                                                        <th >Status</th>
                                                        <th >Comments</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="oaplogmaster" items="${oaplogmaster}" varStatus="status">
                                                        <tr>
                                                            <td >${status.count}</td>
                                                            <td>${oaplogmaster.activity}</td>
                                                            <td >${oaplogmaster.activityBy}</td>
                                                            <td>${oaplogmaster.date}</td>
                                                            <td >${oaplogmaster.status}</td>
                                                            <td >${oaplogmaster.comments}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>                    
                        
                        
                        
                        
                        
                        

              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
