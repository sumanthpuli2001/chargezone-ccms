<%-- 
    Document   : AjaxTenderBidVendorTotal
    Created on : Jan 27, 2026, 10:13:53 AM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>


<div class="p-3">
    <h6 class="fw-600 mt-2">Bid Vendor</h6>
    <hr>
    <div class="table-responsive">
        <table id="commonTab" class="table table-striped bg-white" style="min-width: 100%">
            <thead>
                <tr>
                    <th style="text-align: left;">Vendor Code</th>
                    <th>Vendor Name</th>
                    <th>Email ID</th>
                    <th style="text-align: left;">Mobile No</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="list2" items="${list2}" varStatus="status">
                    <tr >
                        <td style="text-align: left;">${list2[0]}</td>
                        <td>${list2[1]}</td>
                        <td>${list2[3]}</td>
                        <td style="text-align: left;"> ${list2[2]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <h6 class="fw-600 mt-2">Regret Vendor</h6>
    <hr>
    <div class="table-responsive">
        <table id="commonTab1" class="table table-striped bg-white" align="center">                                                         
            <thead>
                <tr>
                    <th style="text-align: left;">Vendor Code</th>
                    <th>Name</th>
                    <th>Email ID</th>
                    <th>Mobile No.</th>
                    <th>Reason</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="list3" items="${list3}" varStatus="status">
                    <tr>
                        <td style="text-align: left;">${list3[0]}</td>
                        <td>${list3[1]}</td>
                        <td>${list3[3]}</td>
                        <td>${list3[2]}</td>
                        <td>${list3[4]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <h6 class="fw-600 mt-2">Remaining Vendor</h6>
    <hr>
    <div class="table-responsive">
        <table id="commonTab2" class="table table-striped bg-white" align="center">                                                         
            <thead>
                <tr>
                    <th style="text-align: left;">Vendor Code</th>
                    <th>Name</th>
                    <th>Email ID</th>
                    <th>Mobile No.</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="list1" items="${list1}" varStatus="status">
                    <c:set var="i1" value="0"/>
                    <c:forEach var="list2" items="${list2}" varStatus="status1">
                        <c:if test="${list1.vendorCode == list2[0]}">
                            <c:set var="i1" value="1"/>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="list3" items="${list3}" varStatus="status1">
                        <c:if test="${list1.vendorCode == list3[0]}">
                            <c:set var="i1" value="1"/>
                        </c:if>
                    </c:forEach>
                    <c:if test="${i1 == 0}">
                        <tr>
                            <td style="text-align: left;">${list1.vendorCode}</td>
                            <td>${list1.vendorName}</td>
                            <td>${list1.emailId}</td>
                            <td>${list1.mobileNo}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>





<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>




