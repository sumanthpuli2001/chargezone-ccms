<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@include file="/WEB-INF/jsp/Common/EmployeeComman.jsp"%>--%>
<script type="text/javascript" src="StorageYard/JS/EmployeeCafeJs/EmployeePerformanceAppraisalHeader.js" charset="UTF-8"></script>
<table id="demo9" class="table table-bordered table-striped table-hover" style="" align="Center">



    <tr>
        
        <th style="text-align: center">No</th>
        <th style="text-align: center">Title</th>
        <th style="text-align: center">Start Year</th>
        <th style="text-align: center">Remark</th>
        <th style="text-align: center" id="midYearText">Mid Year</th>
        <th style="text-align: center" id="midYearRemarkText">Remark</th>
        <th style="text-align: center" id="endYearText">End Year</th>
        <th style="text-align: center" id="endYearRemarkText">Remark</th>
    </tr>
    <input type="hidden" name="subCompentencyCount" id="subCompentencyCount" value="${fn:length(list)}">
    <input type="hidden" name="competencyEvaluationId" id="competencyEvaluationId" value="${competencyEvaluationId}">
    
    <c:forEach var="list1" items="${list}" varStatus="status">

        <input type="hidden" name="compentencyTextMasterId${status.count}" id="compentencyTextMasterId${status.count}" value="${list1[0]}">
        <tr>
            
            <td id="subCompentencySrId${status.count}">${status.count}</td>
            <td id="subCompentencyTitleId${status.count}">${list1[1]}</td>
            <td id="subCompentencyStartId${status.count}">
                <select id="compentencyStartYear${status.count}" name="compentencyStartYear${status.count}" class="form-control">
                    <option value="">--SELECT--</option>
                    <option value="Exceed Expectations">Exceed Expectations</option>
                    <option value="Meet Expectations">Meet Expectations</option>
                    <option value="Need Improvement">Need Improvement</option>
                </select>
            </td>
            <td id="subCompentencyStartRemarkId${status.count}">
                <textarea type="Text" id="compentencyStartRemark${status.count}" name="compentencyStartRemark${status.count}" class="form-control" rows="4"></textarea>
            </td>
            <td id="subCompentencyMidId${status.count}">
                <select id="compentencyMidYear${status.count}" name="compentencyMidYear${status.count}" class="form-control">
                    <option value="">--SELECT--</option>
                    <option value="Exceed Expectations">Exceed Expectations</option>
                    <option value="Meet Expectations">Meet  Expectations</option>
                    <option value="Need Improvement">Need Improvement</option>
                </select>
            </td>
            <td id="subCompentencyMidRemarkId${status.count}">
                <textarea type="Text" id="compentencyMidRemark${status.count}" name="compentencyMidRemark${status.count}" class="form-control" rows="4"></textarea>
            </td>
            <td id="subCompentencyEndId${status.count}">
                <select id="compentencyEndYear${status.count}" name="compentencyEndYear${status.count}" class="form-control">
                    <option value="">--SELECT--</option>
                    <option value="Exceed Expectations">Exceed Expectations</option>
                    <option value="Meet Expectations">Meet  Expectations</option>
                    <option value="Need Improvement">Need Improvement</option>
                </select>
            </td>
            <td id="subCompentencyEndRemarkId${status.count}">
                <textarea type="Text" id="compentencyEndRemark${status.count}" name="compentencyEndRemark${status.count}" class="form-control" rows="4"></textarea>
            </td>

        </tr>

    </c:forEach>

</table>


