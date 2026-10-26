
<%-- 
    Document   : AjaxTenderAdminCommunication
    Created on : Jan 23, 2026, 11:07:10 AM
    Author     : Sumanth
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<form:form action="vendor.htm?act=tenderAdminCommunicationReply" method="post" enctype="multipart/form-data" name="myform1" id="myform1"
           class="form-horizontal" role="form">
    <c:set var="count" value="0" scope="page" />

    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
    <input type="hidden" name="id" id="id" value="${id}">
    <input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">
    <input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">


    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
        <div>
            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
        </div>
    </div>
    <br>
    <div class="rounded-4 mt-4">
        <div class="row mb-3">
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label  class="label">Subject<span class="text-danger">*</span></label>

                    <input type="text" class="input-field" id="subject" name="subject" required="true"  value="${subject}">
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



    <table id="vendorQueryReply" class="table  table-striped bg-white" style="width: 100%" align="Center"  >

        <thead>
            <tr>
                <th>Sr.No.</th>
                <th>Attachment</th>

            </tr>
        </thead>
        <c:set var="count" value="0" scope="page" />
        <tbody>
            <c:forEach var="commMasterAttachment" items="${commMasterAttachment}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${commMasterAttachment.attachment}</td>
                </tr>
            </c:forEach>
        </tbody>


    </table>
</form:form>






