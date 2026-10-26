<%-- 
    Document   : AgaxTenderCommitteeDetails
    Created on : 25 Aug, 2022, 2:58:34 PM
    Author     : admin
--%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<input type="hidden" name="tenderCommitteecount" id="tenderCommitteecount" value="${tenderCommittee1count}"/>


        <table id="${bid_type == '1' ? 'PriceCommitteeTable' : 'TechCommitteeTable'}" class="table table-striped bg-white dt-scroll" align="Center"  >

    <thead>
        <tr>
            <th style="text-align: left;">Sr.No</th>
            <th>User Name</th>
            <th>Employee Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="tenderCommittee1" items="${tenderCommittee1}" varStatus="status">
            <tr>
        <input type="hidden" name="user_name" value="${tenderCommittee1.userId}">
        <td style="text-align: left;">${status.count}</td>
        <td>${tenderCommittee1.userId}</td>
        <td>${tenderCommittee1.fullName}</td>
    </tr>
</c:forEach>
</tbody>
</table>
   
