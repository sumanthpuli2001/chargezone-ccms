<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@include file="/WEB-INF/jsp/Common/EmployeeComman.jsp"%>--%>
<!--<script type="text/javascript" src="StorageYard/JS/EmployeeCafeJs/EmployeePerformanceAppraisalHeader.js" charset="UTF-8"></script>-->
<!--<table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center">
    <tr>
    </tr>
    <input type="hidden" name="subCompentencyCount" id="subCompentencyCount" value="{fn:length(list)}">

</table>-->


<!--<div class="modal fade" id="History" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                <h4 class="modal-title" id="myModalLabel">History Detail</h4>-->

<!--<table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center">-->
<th style="margin: 0px;width: 5px;text-align: center" id="midYearDivid">SR.NO</th>
<th style="margin: 0px;width: 130px;text-align: center" id="midYearDivid">Kra Goal</th>
<th style="margin: 0px;width: 130px;text-align: center" id="endYearDivid1">Matric</th>
<th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Date</th>
<th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Weighted</th>
<th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Changed By</th>
    <c:forEach var="updateKraList1" items="${updateKraList}" varStatus="status">
    <tr>
        <td>${status.count}</td>
        <td>${updateKraList1[1]}</td>
        <td>${updateKraList1[2]}</td>
        <!--<td><input type="text" name="" id="" value="/$//{updateKraList1[3]}" disabled="true" class="form-control"></td>-->
        <td>${updateKraList1[3]}</td>
        <td>${updateKraList1[5]}</td>
        <td>${updateKraList1[4]}</td>
    </tr>
</c:forEach>
<!--</table>-->
<!--            </div>
        </div>-->
<!--</div>-->
<!--</div>-->