<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

                    <th style="margin: 0px;width: 5px;text-align: center" id="midYearDivid">SR.NO</th>
                    <th style="margin: 0px;width: 130px;text-align: center" id="midYearDivid">KRA Goal</th>
                    <th style="margin: 0px;width: 130px;text-align: center" id="endYearDivid1">Matric</th>
                    <th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Weightage</th>
                    <th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Changed By</th>
                    <th style="margin: 0px;width: 5px;text-align: center" id="finalScoreid01">Date</th>
                        <c:forEach var="deletedkraGoalList" items="${deletedkraGoalList}" varStatus="status">
                        <tr>
                            <td>${status.count}</td> 
                            <td><textarea name="" id="" class="form-control" disabled="true">${deletedkraGoalList.deletedKra}</textarea></td>
                            <td><textarea name="" id="" class="form-control" disabled="true">${deletedkraGoalList.deletedMetric}</textarea></td>
                            <td><input type="text" name="" id="" value="${deletedkraGoalList.deletedWeightage}" disabled="true" class="form-control"></td>  
                            <td><input type="text" name="" id="" value="${deletedkraGoalList.deletedBy}" disabled="true" class="form-control"></td>  
                            <td><input type="text" name="" id="" value="${deletedkraGoalList.kraDeletedDate}" disabled="true" class="form-control"></td>  
                        </tr>  
                    </c:forEach>
               