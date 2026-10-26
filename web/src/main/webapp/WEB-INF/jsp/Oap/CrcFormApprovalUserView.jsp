
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRC Approval View Details</title>
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
<form:form action="oapForm.htm?act=CrcFormApprovalUserApprove" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">CRC Approval View Details</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        <button type="submit" class="btn theme-btn  mr-3" value="">Approve</button>
                        <button type="submit" class="btn theme-btn  mr-3"  formaction="oapForm.htm?act=CrcFormPartiallyApprove" title="" value=""  onclick="makeDateRequired()">Partially Approve</button>
                        <button type="submit" class="btn theme-btn  mr-3" formaction="oapForm.htm?act=CrcFormRecycle" title="" value="" >ReWork</button>
                        <button type="submit" class="btn theme-btn  mr-3"  formaction="oapForm.htm?act=CrcFormreject" title="" value="" >Reject</button>
                    </div>
                </div>
    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="oapFormId" value="${list55.id}">
    <input type="hidden" name="crcFormId" value="${crcFormId}">
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
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>PCS Order Details:</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.documentNo}</span>
                                            <td style="border: 1px solid black;"><strong>PCS Name:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.pcsName}</span>
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Document Revision No.:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.documentRevisionNo}</span>
                                            <td style="border: 1px solid black;"><strong>OAP Number: </strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.oapNumber}</span>
                                        </tr>

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Document Verification details</strong></td>
                                            </tr>

                                        </thead>


                                        <tr>
                                            <td style="border: 1px solid black; padding: 5px; width: 25%;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="site" id="site" 
                                                           value="${list55.siteSurveyAcceptance}" 
                                                           ${list55.siteSurveyAcceptance == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Site Survey acceptance
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;width: 25%;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="agreement" id="agreement" 
                                                           value="${list55.aggrementAcceptance}" 
                                                           ${list55.aggrementAcceptance == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Agreement acceptance
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;width: 25%;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="land" id="land" 
                                                           value="${list55.landOwnerShipDocument}" 
                                                           ${list55.landOwnerShipDocument == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    Land Ownership Document
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black; padding: 5px;width: 25%;">
                                                <label style="display: block; color: #333;">
                                                    <input type="checkbox" name="noc" id="noc" 
                                                           value="${list55.nocConsent}" 
                                                           ${list55.nocConsent == '1' ? 'checked' : ''} 
                                                           disabled> 
                                                    NOC/Consent
                                                </label>
                                            </td>
                                        </tr>






                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list55.comment}</p>
                                               
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
                                                           value="${list55.planLayoutSigned}" 
                                                           ${list55.planLayoutSigned == '1' ? 'checked' : ''} disabled> Plan layout Signed by Ownership
                                                </label>
                                            </td>
                                            <td style="border: 1px solid black;">
                                                <label style="display: inline;">
                                                    <input type="checkbox" name="projectOap" id="projectOap" 
                                                           value="${list55.projectBudgetOap}" 
                                                           ${list55.projectBudgetOap == '1' ? 'checked' : ''} disabled> Project Budget in line with OAP:
                                                </label>
                                            </td>
                                            <td colspan="4" style="border: 1px solid black; text-align: center;">
                                                <label style="display: inline;">
                                                    <input type="checkbox" name="timeline" id="timeline" 
                                                           value="${list55.projectTimelineOap}" 
                                                           ${list55.projectTimelineOap == '1' ? 'checked' : ''} disabled> Project Timeline in line with OAP:
                                                </label>
                                            </td>
                                        </tr>


                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list55.aaprovalComment}</p>
                                           
                                            </td>

                                        </tr>

                                        <thead>
                                            <tr>
                                                <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Order Review & Engineering details</strong></td>
                                            </tr>

                                        </thead>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Bill of Material No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.billMaterialNo}</span>                                                 
                                            <td style="border: 1px solid black;"><strong>PCS Drawing Number:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.pcsDrawingNumber}</span>
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Scope of Work No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.scopeWork}</span>
                                                                                               
                                            <td style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.deliverableReleaseDate}</span>
                                               
                                            </td>    
                                        </tr>  
                                         
                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>New Revision No:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.newRevisionNumber}</span>

                                        </tr>

                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Reviewer Comment:</strong></td>
                                            <td colspan="3" style="border: 1px solid black;"><p>${list55.reviewerComment}</p>
                                                
                                            </td>

                                        </tr>


                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Prepared By:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.preparedBy}</span>
                                            <td style="border: 1px solid black;"><strong>Designation:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.designation}</span>

                                        </tr> 
                                        <tr>
                                            <td style="border: 1px solid black;"><strong>Project Engineer:</strong></td>
                                            <td style="border: 1px solid black;"><span>${list55.projectEngineer}</span>


                                        </tr>

                                    </table>      

  <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
<!--                  <textarea type="text"  required="true" class="form-control" id="comment" name="comment"></textarea>-->

                        </div>
                    </div> 

                                   
<div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Completion Date :</label>
                            <div class="col-3 p-0" class="input-group date" >
                             <input name="partialldate"  placeholder="DD/MM/YYYY"type="text" class="input-field form_datetime" id="partialDate" maxlength="30" autocomplete="off"/>

                        </div>
                    </div> 
</div>
<script>
                                            // Initialize Flatpickr
                                            flatpickr("#partialDate", {
                                                dateFormat: "d-m-Y", // Set your desired format
                                                allowInput: true // Allow manual input if required
                                            });
                                    </script> 

<script>
function makeDateRequired() {
    document.getElementById("partialDate").required = true;
}
</script>

                                    

                                    <br>
                                     
                                    <div class="form-group">
                                         <div style="display: flex;  justify-content: center;">

                                             <button type="submit" class="btn theme-btn  mr-3" value="">Approve</button>
                                            <button type="submit" class="btn theme-btn  mr-3"  formaction="oapForm.htm?act=CrcFormPartiallyApprove" title="" value=""  onclick="makeDateRequired()">Partially Approve</button>
                                            <button type="submit" class="btn theme-btn  mr-3" formaction="oapForm.htm?act=CrcFormRecycle" title="" value="" >ReWork</button>
                                            <button type="submit" class="btn theme-btn  mr-3"  formaction="oapForm.htm?act=CrcFormreject" title="" value="" >Reject</button>

                                        </div>
                                    </div>
                    
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
