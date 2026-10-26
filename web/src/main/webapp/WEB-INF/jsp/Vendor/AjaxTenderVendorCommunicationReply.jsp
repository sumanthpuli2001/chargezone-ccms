<%-- 
    Document   : AjaxTenderVendorCommunicationReply
    Created on : Feb 5, 2026, 11:19:23 AM
    Author     : Sumanth
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<form:form action="vendor.htm?act=tenderVendorCommunicationSubmit" method="post" enctype="multipart/form-data" name="myform2" id="myform2"
           class="form-horizontal" role="form">


    <c:set var="count" value="0" scope="page" />

    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
    <input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">

    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
        <div>
            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
        </div>
    </div>
    <br>

    <div class="rounded-4 mt-4">
        <div class="row mb-3">
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label  class="label">Subject<span class="text-danger">*</span></label>

                    <input type="text" class="input-field" id="subject" name="subject"  required="true"value="RE: ${subject}">
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label  class="label">Message<span class="text-danger">*</span></label>

                    <input type="text" class="input-field" id="msg" name="msg" required="true" value="${msg}">
                </div>
            </div>

        </div>
    </div> 

<table id="policyTable" class="table table-borderless"  style="width:100%;"  align="center">
    <thead>
        <tr  style="text-align: center;">
            <th class="fw-500">Attachment</th>
            <th  class="fw-500" style="text-align: center; vertical-align: middle">Add New</th>
    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
</tr>
</thead>
<tbody>
    <tr id="policyRow1">

        <td>
            <input id="vendorReplyAttachment" name="generalfile1" class="input-field" type="file"onchange="validateFileSize(this)">
            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
        </td> 


        <td style="text-align: center" class="d-flex justify-content-center align-items-center">
            <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
            </div>
        </td>
    </tr>
</tbody>
</table>


   

</form:form>