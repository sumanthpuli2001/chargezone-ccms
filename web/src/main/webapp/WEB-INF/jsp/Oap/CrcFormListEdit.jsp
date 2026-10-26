
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRC FORM Edit</title>
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
                <form:form action="oapForm.htm?act=CrcFormListEditsubmit" method="post" commandName="vendorInformation1"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">CRC FORM Edit</h5>
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
                             Contract Review Checklist
                            </td>
                        </tr>
                    </tbody>
                </table>
                    <input type="hidden" name="id" value="${id}">

                    <div style=" max-width: 100%; margin: auto; border: 0px solid black;">
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
                                                    <td colspan="4" style="border: 1px solid black; background-color: skyblue"><strong>PCS Order Details:</strong></td>
                                                </tr>

                                            </thead>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Document No</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="documentNo" id="documentNo" readonly value="${crcForm.documentNo}"/>  </td>                                                   
                                                <td style="border: 1px solid black;"><strong>PCS Name:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="pcsName" id="pcsName"  value="${crcForm.pcsName}" readonly /> </td>    
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Document Revision No:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="documentRevisonNo" id="documentRevisonNo" readonly value="${crcForm.documentRevisionNo}"/> </td>                                                   
                                                <td style="border: 1px solid black;"><strong>OAP Number: </strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="oapNumber" id="oapNumber"  value="${crcForm.oapNumber}" readonly/> </td>    
                                            </tr>

                                            <thead>
                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Document Verification details</strong></td>
                                                </tr>

                                            </thead>


                                            <tr>
                                                <td style="border: 1px solid black;width:25%;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="site" id="site" 
                                                               value="${crcForm.siteSurveyAcceptance}" 
                                                               ${crcForm.siteSurveyAcceptance == '1' ? 'checked' : ''}> Site Survey acceptance
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width:25%;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="agreement" id="agreement" 
                                                               value="${crcForm.aggrementAcceptance}" 
                                                               ${crcForm.aggrementAcceptance == '1' ? 'checked' : ''}> Agreement acceptance
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width:25%;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="land" id="land" 
                                                               value="${crcForm.landOwnerShipDocument}" 
                                                               ${crcForm.landOwnerShipDocument == '1' ? 'checked' : ''}> Land Ownership Document
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black; width:25%;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="noc" id="noc" 
                                                               value="${crcForm.nocConsent}" 
                                                               ${crcForm.nocConsent == '1' ? 'checked' : ''}> NOC/Consent
                                                    </div>
                                                </td>
                                            </tr>




                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Comment if Unviable: <span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="3" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;"name="commentUnviable" id="commentUnviable" required="required">${crcForm.comment}</textarea>
                                                </td>

                                            </tr>

                                            <thead>
                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Approval Receipt Details</strong></td>
                                                </tr>

                                            </thead>

                                            <tr>
                                                <td style="border: 1px solid black;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="plan" id="plan" 
                                                               value="${crcForm.planLayoutSigned}" 
                                                               ${crcForm.planLayoutSigned == '1' ? 'checked' : ''}> Plan layout Signed by Ownership
                                                    </div>
                                                </td>
                                                <td style="border: 1px solid black;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="projectOap" id="projectOap" 
                                                               value="${crcForm.projectBudgetOap}" 
                                                               ${crcForm.projectBudgetOap == '1' ? 'checked' : ''}> Project Budget in line with OAP
                                                    </div>
                                                </td>
                                                <td colspan="4" style="border: 1px solid black; text-align: center;">
                                                    <div style="display: inline;">
                                                        <input type="checkbox" name="timeline" id="timeline" 
                                                               value="${crcForm.projectTimelineOap}" 
                                                               ${crcForm.projectTimelineOap == '1' ? 'checked' : ''}> Project Timeline in line with OAP
                                                    </div>
                                                </td>
                                            </tr>


                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Comment if Unviable:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="3" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;" name="Comments" id="Comments" required="required">${crcForm.aaprovalComment}</textarea>
                                                </td>

                                            </tr>

                                            <thead>
                                                <tr>
                                                    <td colspan="4" style="border: 1px solid black; background-color: skyblue; text-align: center"><strong>Order Review & Engineering details</strong></td>
                                                </tr>

                                            </thead>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Bill of Material No:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="bill" id="bill"  value="${crcForm.billMaterialNo}" /> </td>                                                   
                                                <td style="border: 1px solid black;"><strong>PCS Drawing Number:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="pcsdraw" id="pcsdraw"  value="${crcForm.pcsDrawingNumber}" /> </td>    
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Scope of Work No:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="scope" id="scope" value="${crcForm.scopeWork}" /> </td>                                                   
                                                <td style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                                                <td style="border: 1px solid black;">
                                                    <div class="input-group date" id="datetimepickers">
                                                        <input name="Fromdate1" id="Fromdate1" type="text" class="input-field form_datetime" value="${crcForm.deliverableReleaseDate}" maxlength="30" />
                                                       
                                                    </div>
                                                </td>    
                                            </tr>  
                                            <script>
$(function () {

                                                        // Initialize Flatpickr
                                                        flatpickr("#Fromdate1", {
                                                            dateFormat: "d-m-Y", // Set your desired format
                                                            allowInput: true // Allow manual input if required
                                                        });
                                                        });
                                                    </script> 
                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>New Revision No:</strong></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="newrevision" id="newrevision" value="${crcForm.newRevisionNumber}" /> </td>                                                   

                                            </tr>

                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Reviewer Comment:<span style="color: red;font-size: 12px;">*</span></strong></td>
                                                <td colspan="3" style="border: 1px solid black;">
                                                    <textarea class="textarea-field" style="width: 100%; height: 100px; border: none; resize: none;" name="reviewercomments" id="reviewercomments" required="required">${crcForm.reviewerComment}</textarea>
                                                </td>

                                            </tr>


                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Prepared By:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="preparedby" id="preparedby" value="${crcForm.preparedBy}"required="required"/> </td>                                                   
                                                <td style="border: 1px solid black;"><strong>Designation:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="designation" id="designation" value="${crcForm.designation}"required="required"/> </td>                                                   

                                            </tr> 
                                            <tr>
                                                <td style="border: 1px solid black;"><strong>Project Engineer:</strong><span style="color: red;font-size: 12px;">*</span></td>
                                                <td style="border: 1px solid black;"><input  class="input-field" name="projectengineer" id="projectengineer" value="${crcForm.projectEngineer}"required="required"/> </td>                                                   


                                            </tr>

                                        </table>

                                      
                                        <div class="col-3 p-0">
                                            <div class="form-group comment-box">
                                                <label for="approvalName">Project Manager:</label>
                                                <input class="input-field" id="approvalName" name="approvalName" readonly="true" value="${projectmanger}">
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
