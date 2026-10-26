 <%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=tenderPriceComparisonReport.xls");
%> 
<html>
    <head>
        <title>Tender Price Comparison</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
       
        
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">
                                            
                                        <div class="col-md-12 col-sm-12">
                                            
                                            <table border="1px" class="table table-bordered table-striped table-hover" style="width:100%; font-size: 12px; border-collapse: collapse;" align="center">

                                                <thead>

                                                    <tr>
                                                        <th colspan="13" style="text-align:center; background:#f2f2f2;">
                                                            Tender Information
                                                        </th>
                                                    </tr>

                                                </thead>

                                                <tbody>

                                                    <tr>
                                                        <td colspan="2"><b>Tender No</b></td>
                                                        <td colspan="2">${tenderMaster.refNo}</td>

                                                        <td colspan="2"><b>Project Name</b></td>
                                                        <td colspan="2">${tenderMaster.title}</td>

                                                        <td colspan="2"><b>Project ID</b></td>
                                                        <td colspan="2">${tenderMaster.projectId}</td>

                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="2"><b>PR No</b></td>
                                                        <td colspan="2">${tenderMaster.prNo}</td>

                                                        <td colspan="2"><b>Billing Location</b></td>
                                                        <td colspan="2">${tenderMaster.location}</td>

                                                        <td colspan="2"><b>Tender Date</b></td>
                                                        <td colspan="2">${tender_date}</td>

                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="2"><b>Tender Due Date</b></td>
                                                        <td colspan="2">${tender_due_date}</td>

                                                        <td colspan="2"><b>Created By</b></td>
                                                        <td colspan="2">${tenderMaster.contactPerson}</td>

                                                        <td colspan="2"><b>Contact No</b></td>
                                                        <td colspan="2">${tenderMaster.tenderAdminContactNumber}</td>

                                                        <td></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="3"><b>Bid Sent Vendors</b></td>
                                                        <td colspan="3">${total_vendor}</td>

                                                        <td colspan="3"><b>Bid Received Vendors</b></td>
                                                        <td colspan="3">${total_bid}</td>

                                                        <td></td>
                                                    </tr>                                                    

                                                    <!-- Price Bid Comparison -->
                                                    <c:if test="${!empty vendorTenderBidItem1}">                                                       
                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13" style="text-align:center; background:#f2f2f2;">
                                                                Price Bid Comparison For Item
                                                            </th>
                                                        </tr>

                                                        <tr>
                                                            <th rowspan="3">Sr No.</th>
                                                            <th colspan="4">Vendor Code</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="4">Vendor Name</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th>Item Code</th>
                                                            <th>Description</th>
                                                            <th>Qty</th>
                                                            <th>UOM</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                            </c:if>
                                                            
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <c:forEach var="item1" items="${vendorTenderBidItem1}" varStatus="status">

                                                            <tr>

                                                                <td>${status.count}</td>
                                                                <td>${item1[1]}</td>
                                                                <td>${item1[2]}</td>
                                                                <td>${item1[4]}</td>
                                                                <td>${item1[3]}</td>

                                                                <c:if test="${vendor_code1 != ''}">
                                                                    <td>Rs. <fmt:formatNumber value="${item1[5]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                    <td>Rs. <fmt:formatNumber value="${item1[6]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>

                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false" />

                                                                    <c:forEach var="item2" items="${vendorTenderBidItem2}">

                                                                        <c:if test="${item1[0] == item2[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item2[5]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item2[6]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found2" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found2}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false" />

                                                                    <c:forEach var="item3" items="${vendorTenderBidItem3}">

                                                                        <c:if test="${item1[0] == item3[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item3[5]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item3[6]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found3" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found3}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false" />

                                                                    <c:forEach var="item4" items="${vendorTenderBidItem4}">

                                                                        <c:if test="${item1[0] == item4[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item4[5]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item4[6]}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found4" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found4}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>
                                                                        
                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>

                                                            </tr>

                                                        </c:forEach>

                                                        <tr>
                                                            <th colspan="5"><b>Ex-work Price/FOB</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th colspan="5"><b>Packing & Forwarding</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${packingValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${packingValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${packingValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${packingValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th  colspan="5"><b>Charges</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td>${chargesValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${chargesValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${chargesValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${chargesValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Insurance</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${insuranceValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${insuranceValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${insuranceValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${insuranceValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>Erection Commision</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${errectionValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${errectionValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${errectionValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${errectionValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Discount</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${discountValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${discountValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${discountValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${discountValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price without GST</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>GST</b></th>
                                                            
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${igstValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${igstValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${igstValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${igstValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Rating</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${rank1}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${rank2}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${rank3}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${rank4}</td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>
                                                        
                                                        <tr>
                                                            <th  colspan="5"><b>No Of Item Regret</b></th>
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${regret1}</td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${regret2}</td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${regret3}</td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${regret4}</td>
                                                            </c:if>
                                                            
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                        </tr>

                                                    </c:if>
                                                        
                                                    <!-- Service Price Bid Comparison -->
                                                    <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">

                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13" style="text-align:center; background:#f2f2f2;">
                                                                Price Bid Comparison For Service
                                                            </th>
                                                        </tr>

                                                        <tr>

                                                            <th rowspan="3">Sr No.</th>
                                                            <th colspan="4">Item Details</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>
                                                            </c:if>
                                                                  
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="4">Vendor Name</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>
                                                            </c:if>
                                                                  
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th>Item Code</th>
                                                            <th>Description</th>
                                                            <th>Qty</th>
                                                            <th>UOM</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                            </c:if>
                                                                  
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <c:forEach var="item1" items="${ServicevendorTenderBidItem1}" varStatus="status1">

                                                            <tr>

                                                                <td>${status1.count}</td>
                                                                <td>${item1[1]}</td>
                                                                <td>${item1[2]}</td>
                                                                <td>${item1[4]}</td>
                                                                <td>${item1[3]}</td>

                                                                <c:if test="${vendor_code1 != ''}">
                                                                    <td>Rs. <fmt:formatNumber value="${item1[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                    <td>Rs. <fmt:formatNumber value="${item1[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>

                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false"/>

                                                                    <c:forEach var="item2" items="${ServicevendorTenderBidItem2}">

                                                                        <c:if test="${item1[0] == item2[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item2[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item2[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found2" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found2}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false"/>

                                                                    <c:forEach var="item3" items="${ServicevendorTenderBidItem3}">

                                                                        <c:if test="${item1[0] == item3[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item3[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item3[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found3" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found3}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false"/>

                                                                    <c:forEach var="item4" items="${ServicevendorTenderBidItem4}">

                                                                        <c:if test="${item1[0] == item4[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item4[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item4[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found4" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found4}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>
                                                                
                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>

                                                            </tr>

                                                        </c:forEach>


                                                        <tr>

                                                            <th colspan="5"><b>Ex-work Price/FOB</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>                                                                
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>                                                                
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>                                                                
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>Discount</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${serviceDiscountValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${serviceDiscountValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${serviceDiscountValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${serviceDiscountValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>Final Evaluated Price Without GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. ${String.format("%.2f",serviceTaxTotal1 - servicegstFinal1)}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. ${String.format("%.2f",serviceTaxTotal2 - servicegstFinal2)}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. ${String.format("%.2f",serviceTaxTotal3 - servicegstFinal3)}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. ${String.format("%.2f",serviceTaxTotal4 - servicegstFinal4)}</td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${servicegst1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${servicegst2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${servicegst3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${servicegst4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>Final Evaluated Price</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>Rating</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${rank1}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${rank2}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${rank3}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${rank4}</td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <th colspan="5"><b>No Of Item Regret</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${regret1}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${regret2}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${regret3}</td>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${regret4}</td>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                    </c:if>
                                                        
                                                    <!-- Terms & Condition Comparison -->
                                                    <c:if test="${!empty vendorTermsCondition1}">

                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="13" style="text-align:center; background:#f2f2f2;">
                                                                Terms & Condition Comparison
                                                            </th>
                                                        </tr>

                                                        <tr>

                                                            <th rowspan="3">Sr No.</th>
                                                            <th rowspan="3" colspan="2">Terms Condition</th>
                                                            <th rowspan="3" colspan="2">Description</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <tr>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>
                                                            </c:if>
                                                                
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="2"></td>
                                                            </c:if>

                                                        </tr>

                                                        <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status2">

                                                            <tr>

                                                                <td>${status2.count}</td>
                                                                <td colspan="2">${vendorTermsCondition1.termsCondition}</td>
                                                                <td colspan="2">${vendorTermsCondition1.description}</td>

                                                                <c:if test="${vendor_code1 != ''}">

                                                                    <td>
                                                                        <c:choose>
                                                                            <c:when test="${vendorTermsCondition1.response == 0}">
                                                                                Accept
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                Reject
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </td>

                                                                    <td>${vendorTermsCondition1.comment}</td>

                                                                </c:if>

                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false"/>

                                                                    <c:forEach var="vendorTermsCondition2" items="${vendorTermsCondition2}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition2.termsCondition}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${vendorTermsCondition2.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${vendorTermsCondition2.comment}</td>

                                                                            <c:set var="found2" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found2}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false"/>

                                                                    <c:forEach var="vendorTermsCondition3" items="${vendorTermsCondition3}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition3.termsCondition}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${vendorTermsCondition3.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${vendorTermsCondition3.comment}</td>

                                                                            <c:set var="found3" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found3}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false"/>

                                                                    <c:forEach var="vendorTermsCondition4" items="${vendorTermsCondition4}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == vendorTermsCondition4.termsCondition}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${vendorTermsCondition4.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${vendorTermsCondition4.comment}</td>

                                                                            <c:set var="found4" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found4}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="2"></td>
                                                                </c:if>

                                                            </tr>

                                                        </c:forEach>

                                                    </c:if>


                                                    <!-- Vendor Comparison -->

                                                    <tr>
                                                        <th colspan="13"></th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="13"></th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="13" style="text-align:center; background:#f2f2f2;">
                                                            Vendor Comparison
                                                        </th>
                                                    </tr>

                                                    <tr>

                                                        <th>Sr No.</th>
                                                        <th>Vendor Code</th>
                                                        <th>Vendor Name</th>
                                                        <th>Supply Part</th>
                                                        <th>Service Part</th>
                                                        <th>Basic Total</th>
                                                        <th>GST Value</th>
                                                        <th>Total including Tax</th>
                                                        <th>Budget Value</th>
                                                        <th>Difference Between Budget Value VS Received Proposal</th>
                                                        <th>Difference In Percentage</th>
                                                        <th colspan="2"></th>
                                                    </tr>

                                                    <c:set var="sn" value="0" />
                                                    <c:set var="sn" value="${sn + 1}" />

                                                    <tr>

                                                        <td>${sn}</td>
                                                        <td>${vendor_code1}</td>
                                                        <td>${vendor_name1}</td>
                                                        
                                                        <td>Rs. <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                        <td>Rs. <fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                        <td>Rs. <fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1 + Total1 - igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                        
                                                        <td>Rs. <fmt:formatNumber value="${servicegstFinal1 + igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                        
                                                        <td>Rs. <fmt:formatNumber value="${Total1 + serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                        <td>${tenderMaster.value}</td>

                                                        <td>Rs. <fmt:formatNumber value="${tenderMaster.value - Total1 - serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                        
                                                        <td><fmt:formatNumber value="${((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2" />%</td>
                                                        
                                                        <td colspan="2"></td>

                                                    </tr>

                                                    <c:if test="${vendor_code2 != ''}">

                                                        <c:set var="sn" value="${sn + 1}" />

                                                        <tr>

                                                            <td>${sn}</td>
                                                            <td>${vendor_code2}</td>
                                                            <td>${vendor_name2}</td>
                                                            
                                                            <td>Rs. <fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2 + Total2 - igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${servicegstFinal2 + igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${Total2 + serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>${tenderMaster.value}</td>

                                                            <td>Rs. <fmt:formatNumber value="${tenderMaster.value - Total2 - serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2" />%</td>                                                            

                                                            <td colspan="2"></td>

                                                        </tr>

                                                    </c:if>

                                                    <c:if test="${vendor_code3 != ''}">

                                                        <c:set var="sn" value="${sn + 1}" />

                                                        <tr>

                                                            <td>${sn}</td>
                                                            <td>${vendor_code3}</td>
                                                            <td>${vendor_name3}</td>
                                                            
                                                            <td>Rs. <fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3 + Total3 - igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${servicegstFinal3 + igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${Total3 + serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>${tenderMaster.value}</td>

                                                            <td>Rs. <fmt:formatNumber value="${tenderMaster.value - Total3 - serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2" />%</td>

                                                            <td colspan="2"></td>

                                                        </tr>

                                                    </c:if>

                                                    <c:if test="${vendor_code4 != ''}">

                                                        <c:set var="sn" value="${sn + 1}" />

                                                        <tr>

                                                            <td>${sn}</td>
                                                            <td>${vendor_code4}</td>
                                                            <td>${vendor_name4}</td>

                                                            <td>Rs. <fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4 + Total4 - igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${servicegstFinal4 + igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>Rs. <fmt:formatNumber value="${Total4 + serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td>${tenderMaster.value}</td>

                                                            <td>Rs. <fmt:formatNumber value="${tenderMaster.value - Total4 - serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                            <td><fmt:formatNumber value="${((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2" />%</td>

                                                            <td colspan="2"></td>

                                                        </tr>

                                                    </c:if>                                                      

                                                </tbody>

                                            </table>
                                        
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    
</html>


