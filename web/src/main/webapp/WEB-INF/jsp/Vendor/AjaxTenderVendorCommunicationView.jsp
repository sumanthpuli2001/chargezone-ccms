<%-- 
    Document   : AjaxTenderVendorCommunicationView
    Created on : Feb 5, 2026, 10:59:28 AM
    Author     : Sumanth
--%>
<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<form:form action="vendor.htm?act=tenderVendorCommunicationReply" method="post" enctype="multipart/form-data" name="myform1" id="myform1"
           class="form-horizontal" role="form">

    <c:set var="count" value="0" scope="page" />

    <input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">
    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
    <input type="hidden" name="id" id="id" value="${id}">

    <div class="rounded-4 mt-4">
        <div class="row mb-3">
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label  class="label">Subject</label>
                    <input type="text" class="input-field" id="technicalfile" name="subject" value="${subject}">
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label  class="label">Message</label>
                    <input type="text" class="input-field" id="technicalfile" name="msg" value="${msg}">
                </div>
            </div>
        </div>
    </div>

    <table id="vendorQueryReply" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
        <c:choose>
            <c:when test="${empty commMasterAttachment}">

            </c:when>
            <c:otherwise>
                <thead>
                    <tr>
                        <th>Sr.No.</th>
                        <th>Subject</th>

                    </tr>
                </thead>
                <c:set var="count" value="0" scope="page" />
                <tbody>
                    <c:forEach var="commMasterAttachment" items="${commMasterAttachment}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${commMasterAttachment.attachment}&RefNo=${tender_no}">${commMasterAttachment.attachment}</a>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </c:otherwise>
        </c:choose>
    </table>


</form:form>








