<%-- 
    Document   : AjaxVendorAllAttachView
    Created on : Jan 27, 2026, 11:17:55 AM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<!DOCTYPE html>

<input type="hidden" name="refNo" id="refNo" value="${refNo}">

<div class="col-md-12 col-sm-12">


    <table id="VendorCommercialAttachment" class="table  table-striped bg-white" style="" align="Center"  >

        <thead>
        <div class="fw-600">Vendor All Attachment</div>
        <tr>
            <th data-dt-order="disable">Document</th>
        </tr>
        </thead>


        <c:set var="count" value="0" scope="page" />
        <tbody>


            <c:forEach var="list1" items="${list1}" varStatus="status">

                <tr>
                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                </tr>
            </c:forEach>
            <c:forEach var="list1" items="${list2}" varStatus="status">
                <tr>
                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                </tr>
            </c:forEach>
            <c:forEach var="item" items="${list3}" varStatus="status">
                <c:if test="${not empty item.attachment}">
                    <tr>
                        <td>
                            <a class="fw-600 text-break gradient-text"
                               href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${item.attachment}&amp;RefNo=${ref_no}&amp;vendor_code=${vendor_code}">
                                ${item.attachment}
                            </a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
            <c:forEach var="list1" items="${list4}" varStatus="status">
                <tr>
                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                </tr>
            </c:forEach>
            <c:forEach var="list1" items="${list5}" varStatus="status">
                <tr>
                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                </tr>
            </c:forEach>
        </tbody>


    </table>



</div>





<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>



