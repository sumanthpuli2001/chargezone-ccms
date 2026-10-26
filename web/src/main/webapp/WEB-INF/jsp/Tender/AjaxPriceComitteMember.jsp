<%-- 
    Document   : AjaxPriceComitteMember
    Created on : Jul 8, 2025, 9:59:01 AM
    Author     : Sumanth
--%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="p-3">
    <table id="${bid_type == '1' ? 'AjaxPriceComitteTable' : 'AjaxTechComitteTable'}" class="table table-striped bg-white dt-scroll" align="Center"  >
        
        <thead>
            <tr>
                <th class="text-center" width="10%">Sr. No</th>
                <th >User Name</th>
                <th >Full Name</th>

            </tr>
        </thead>
        <c:set var="count" value="0" scope="page" />
            <tbody>
                <c:forEach var="tenderCommittee1" items="${tenderCommittee1}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${tenderCommittee1.userId != null ? tenderCommittee1.userId : 'N/A'}</td>
                        <td>${tenderCommittee1.fullName != null ? tenderCommittee1.fullName : 'N/A'}</td>
                    </tr>
                </c:forEach>
            </tbody>       
        <tfoot></tfoot>
    </table>
</div>
