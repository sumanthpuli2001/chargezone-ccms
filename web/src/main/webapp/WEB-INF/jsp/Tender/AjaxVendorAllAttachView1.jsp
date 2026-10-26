<%-- 
    Document   : AjaxVendorAllAttachView1
    Created on : Jan 28, 2026, 3:22:11 PM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<!DOCTYPE html>

<input type="hidden" name="refNo" id="refNo" value="${refNo}">

<div class="col-md-12 col-sm-12">

    <table id="VendorCommercialAttachment" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
        <thead>
            <tr>
                <th data-dt-order="disable">Attachment</th>
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
            <c:forEach var="list1" items="${list3}" varStatus="status">
                <tr>
                    <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                </tr>
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
    <c:if test="${technical.size()>0}">
        <h5 class="fw-600">Technical Specification</h5> 

        <table id="technicalSpecificationTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <thead>
                <tr>
                    <th data-dt-order="disable">Attachment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list1" items="${technical}" varStatus="status">
                    <tr>
                        <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${price.size()>0}">
        <h5 class="fw-600">  Price Specification</h5>

        <table id="priceSpecificationTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <thead>
                <tr>
                    <th data-dt-order="disable">Attachment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list1" items="${price}" varStatus="status">
                    <tr>
                        <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${revise_technical.size()>0}">
        <h5 class="fw-600"> Revise Specification</h5>

        <table id="reviseSpecificationTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <thead>
                <tr>
                    <th data-dt-order="disable">Attachment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list1" items="${revise_technical}" varStatus="status">
                    <tr>
                        <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${revise_price.size()>0}">

        <h5 class="fw-600">Revise Price Specification</h5>
        <table id="revisePriceSpecificationTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
            <thead>
                <tr>
                    <th data-dt-order="disable">Attachment</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="list1" items="${revise_price}" varStatus="status">
                    <tr>
                        <td><a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list1.attachment}&RefNo=${ref_no}&vendor_code=${vendor_code}">${list1.attachment}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>



</div>





<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>




