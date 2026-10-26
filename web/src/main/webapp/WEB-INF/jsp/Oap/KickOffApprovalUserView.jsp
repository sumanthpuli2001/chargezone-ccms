
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KickOff Approval View Details</title>
    </head>
    <style>
        p {
            word-wrap: break-word; /* Allows words to break if necessary */
            max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
        }
        .break-after-20 {
            word-wrap: break-word;
            overflow-wrap: break-word;
            max-width: 50ch; /* Approximately 20 characters per line */
        }
        @media print {
            a[href]:after {
                content: none !important;
                  }
        }
    </style>
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
                <form:form action="aocForm.htm?act=KickOffFormApprovalUserApprove" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">           
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">KickOff Approval View Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn mr-3" value="">Approve</button>
                            <button type="submit" class="btn theme-btn mr-3" formaction="aocForm.htm?act=KickOffFormRecycle" value="">ReWork</button>
                            <button type="submit" class="btn theme-btn " formaction="aocForm.htm?act=KickOffFormReject" title="" value="" >Reject</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="oapFormId" value="${list55.id}">
                    <input type="hidden" name="kickoffFormId" value="${kickoffFormId}">
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

                    <table  class="table table-bordered mb-4" style="max-width: 100%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->
                        <thead>
                            <tr>
                                <td colspan="5" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>B2B Hub Order Details</strong></td>
                            </tr>

                        </thead>
                        <tbody>
                            <tr>
                                <td  style="border: 1px solid black;"><strong>Document No</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><span>${list55.documentNo}</span>

                            </tr>
                            <tr>
                                <td  style="border: 1px solid black;"><strong>B2B Hub Location</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><span>${list55.hubLocation}</span>
                                <td colspan="1" style="border: 1px solid black;"><strong> Date&Time :</strong></td>
                                <td style="border: 1px solid black;"><span>${list55.dateTime}</span>

                                </td>




                                <!-- Include the necessary script for datetimepicker -->

                            <tr>
                                <td style="border: 1px solid black;"><strong>Project Name:</strong></td>
                                <td colspan="2" style="border: 1px solid black;"><span>${list55.projectName}</span>
                                <td colspan="1" style="border: 1px solid black;"><strong>Minutes Prepared By:</strong></td>
                                <td style="border: 1px solid black;"><span>${list55.minutues}</span>

                            </tr> 
                            <tr>
                                <td colspan="5" style="border: 1px solid black; background-color: skyblue; text-align: center;"><strong> Attendance</strong></td>
                            </tr>

                        <thead>
                            <tr>
                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;width: 20%;">Sr.No</th>
                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;width: 20%;">Name</th>
                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;width: 20%;">Roll In Project</th>
                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;width: 20%;">Email</th>
                                <th style="text-align: center; vertical-align: middle;border: 1px solid black;width: 20%;">Cell No</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list44" items="${list44}" varStatus="status">
                                <tr >
                                    <td style="border: 1px solid black;">${status.count}</td> <!-- Serial Number -->
                                    <td style="border: 1px solid black;">${list44.name}</td> <!-- User ID -->
                                    <td style="border: 1px solid black;">${list44.rollInProject}</td> <!-- Approval Comment -->
                                    <td style="border: 1px solid black;">${list44.email}</td> <!-- Approval Comment -->
                                    <td style="border: 1px solid black;">${list44.cellNo}</td> <!-- Approval Comment -->

                                </tr>
                            </c:forEach>
                        </tbody>
                        <thead>
                            <tr>
                                <td colspan="5" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>B2B Hub Deliverables Verification Details</strong></td>
                            </tr>

                        </thead>


                        <td style="border: 1px solid black;"> 
                            <label style="display: inline;">
                                <input type="checkbox" name="design" id="design" 
                                       value="${list55.designBasic}" disabled
                                       ${list55.designBasic == '1' ? 'checked' : ''}> A. Design Basis Report 
                            </label>
                        </td>

                        <td style="border: 1px solid black;"> 
                            <label style="display: inline;">
                                <input type="checkbox" name="boq" id="boq" disabled
                                       value="${list55.boq}" 
                                       ${list55.boq == '1' ? 'checked' : ''}> B.BOQ
                            </label>
                        </td>

                        <td style="border: 1px solid black;"> 
                            <label style="display: inline;">
                                <input type="checkbox" name="loa" id="loa" disabled
                                       value="${list55.laoLoi}" 
                                       ${list55.laoLoi == '1' ? 'checked' : ''}> C.LOA / LOI
                            </label>
                        </td>

                        <td style="border: 1px solid black;"> 
                            <label style="display: inline;">
                                <input type="checkbox" name="agreement" id="agreement" disabled 
                                       value="${list55.agreement}" 
                                       ${list55.agreement == '1' ? 'checked' : ''}> D.Agreement
                            </label>
                        </td>

                        <td style="border: 1px solid black;"> 
                            <label style="display: inline;">
                                <input type="checkbox" name="approved" id="approved" disabled
                                       value="${list55.approvedLayout}" 
                                       ${list55.approvedLayout == '1' ? 'checked' : ''}> E.Approved Layout Drawings
                            </label>
                        </td>




                        <tr>
                            <td style="border: 1px solid black;"><strong>Agendas:</strong></td>
                            <td colspan="5" style="border: 1px solid black;"><p>${list55.agendas}</p>
                            </td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Issues:</strong></td>
                            <td colspan="5" style="border: 1px solid black;"><p>${list55.issues}</p>
                            </td>
                        </tr>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Decisions:</strong></td>
                            <td colspan="5" style="border: 1px solid black;"><p>${list55.decisions}</p>
                            </td>
                        </tr>



                        <thead>
                            <tr>
                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>Approval Receipt Details</strong></td>
                            </tr>

                        </thead>
                        <td colspan="2" style="border: 1px solid black;">
                            <label style="display: inline;">
                                <input type="checkbox" name="plan" disabled id="plan" value="${list55.planLayout}"
                                       ${list55.planLayout == '1' ? 'checked' : ''}>
                                A. Plan Layout Signed by Client
                            </label>
                        </td>  

                        <td colspan="2" style="border: 1px solid black;">
                            <label style="display: inline;">
                                <input type="checkbox" name="projectBudget" disabled id="projectBudget" value="${list55.projectBudget}"
                                       ${list55.projectBudget == '1' ? 'checked' : ''}>
                                B. Project Budget in Line With AOC
                            </label>
                        </td>  

                        <td colspan="2" style="border: 1px solid black;">
                            <label style="display: inline;">
                                <input type="checkbox" name="projectTimeline" disabled id="projectTimeline" value="${list55.projectTimeLine}"
                                       ${list55.projectTimeLine == '1' ? 'checked' : ''}>
                                C. Project Timeline in Line With AOC
                            </label>
                        </td>  

                        <tr>
                            <td style="border: 1px solid black;"><strong>Comment if Unviable:</strong></td>
                            <td colspan="5" style="border: 1px solid black;"><p>${list55.comments}</p>
                            </td>
                        </tr>


                        <thead>
                            <tr>
                                <td colspan="6" style="border: 1px solid black; background-color: skyblue;text-align: center;"><strong>Order Review & Design Engineering details</strong></td>
                            </tr>
                        </thead>
                        <tr>
                            <td style="border: 1px solid black;"><strong>Design Basis Report No:</strong></td>
                            <td  colspan="2" style="border: 1px solid black;"><span>${list55.designBasicReport}</span>
                            <td colspan="1" style="border: 1px solid black;"><strong>Approved Layout Drawing Number:</strong></td>
                            <td style="border: 1px solid black;"><span>${list55.approvedLayoutDrawings}</span>

                        </tr>   
                        <tr>
                            <td style="border: 1px solid black;"><strong>BOQ No</strong></td>
                            <td colspan="2" style="border: 1px solid black;"><span>${list55.boqNo}</span>
                            <td colspan="1" style="border: 1px solid black;"><strong> Deliverable released date:</strong></td>
                            <td  style="border: 1px solid black;"><span>${list55.deliverableReleaseDate}</span>

                            </td> 



                        </tr>  



                        <tr>
                            <td style="border: 1px solid black;"><strong>Reviewer Comment:</strong></td>
                            <td colspan="5" style="border: 1px solid black;"><p>${list55.reviewsComments}</p>
                            </td>
                        </tr>



                        <tr>
                            <td style="border: 1px solid black;"><strong>New Revision No:</strong></td>
                            <td colspan="2" style="border: 1px solid black;"><span>${list55.newRevisonNo}</span>
                            <td colspan="1" style="border: 1px solid black;"><strong> Prepared By:</strong></td>
                            <td style="border: 1px solid black;"><span>${list55.preparedBy}</span>

                        </tr> 

                        <tr>
                            <td style="border: 1px solid black;"><strong>Designation</strong></td>
                            <td colspan="2" style="border: 1px solid black;"><span>${list55.designation}</span>
                            </td>



                    </table>





                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true"></textarea>
                        </div>
                    </div>  





                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn mr-3" value="">Approve</button>
                            <button type="submit" class="btn theme-btn mr-3" formaction="aocForm.htm?act=KickOffFormRecycle" value="">ReWork</button>
                            <button type="submit" class="btn theme-btn " formaction="aocForm.htm?act=KickOffFormReject" title="" value="" >Reject</button>
                        </div>
                    </div>   


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
