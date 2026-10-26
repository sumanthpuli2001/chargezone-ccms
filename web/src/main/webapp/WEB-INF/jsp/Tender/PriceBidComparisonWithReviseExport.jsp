<%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition", "attachment; filename=priceBidWithReviseBidComparisonReport.xls");
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
                                                        <th colspan="21" style="text-align:center; background:#f2f2f2;">
                                                            Tender Information
                                                        </th>
                                                    </tr>

                                                </thead>

                                                <tbody>

                                                    <tr>
                                                        <td colspan="3"><b>Tender No</b></td>
                                                        <td colspan="3">${tenderMaster.refNo}</td>

                                                        <td colspan="3"><b>Project Name</b></td>
                                                        <td colspan="3">${tenderMaster.title}</td>

                                                        <td colspan="3"><b>Project ID</b></td>
                                                        <td colspan="3">${tenderMaster.projectId}</td>

                                                        <td colspan="3"></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="3"><b>PR No</b></td>
                                                        <td colspan="3">${tenderMaster.prNo}</td>

                                                        <td colspan="3"><b>Billing Location</b></td>
                                                        <td colspan="3">${tenderMaster.location}</td>

                                                        <td colspan="3"><b>Tender Date</b></td>
                                                        <td colspan="3">${tender_date}</td>

                                                        <td colspan="3"></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="3"><b>Tender Due Date</b></td>
                                                        <td colspan="3">${tender_due_date}</td>

                                                        <td colspan="3"><b>Created By</b></td>
                                                        <td colspan="3">${tenderMaster.contactPerson}</td>

                                                        <td colspan="3"><b>Contact No</b></td>
                                                        <td colspan="3">${tenderMaster.tenderAdminContactNumber}</td>

                                                        <td colspan="3"></td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="5"><b>Bid Sent Vendors</b></td>
                                                        <td colspan="5">${total_vendor}</td>

                                                        <td colspan="5"><b>Bid Received Vendors</b></td>
                                                        <td colspan="5">${total_bid}</td>

                                                        <td></td>
                                                    </tr>
                                                    
                                                    <!--Price Bid Comparison With Revise Bid For Item Table-->
                                                    <c:if test="${!empty vendorTenderBidItem1}">
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21" style="text-align:center; background:#f2f2f2;">
                                                                Price Bid Comparison With Revise Bid For Item
                                                            </th>
                                                        </tr>

                                                        <tr class="text-center">
                                                            <th rowspan="3" style="min-width:80px;">Sr No.</th>
                                                            <th colspan="4">Vendor Code</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_code1} Revise</th>
                                                                    </c:if>
                                                                </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_code2} Revise</th>
                                                                    </c:if>
                                                                </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_code3} Revise</th>
                                                                    </c:if>
                                                                </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_code4} Revise</th>
                                                                    </c:if>
                                                                </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr class="text-center">

                                                            <th colspan="4">Vendor Name</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_name1}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_name2}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_name3}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_name4}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr class="text-center">

                                                            <th>Item Code</th>
                                                            <th style="min-width:250px;">Description</th>
                                                            <th>Qty</th>
                                                            <th>UOM</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <th colspan="4"></th>                                                            
                                                            </c:if>

                                                        </tr>                                                   

                                                        <c:forEach var="item1" items="${vendorTenderBidItem1}" varStatus="status">

                                                            <tr>

                                                                <td class="text-center">${status.count}</td>
                                                                <td>${item1[1]}</td>
                                                                <td>${item1[2]}</td>
                                                                <td>${item1[4]}</td>
                                                                <td>${item1[3]}</td>

                                                                <c:if test="${vendor_code1 != ''}">

                                                                    <td>Rs. <fmt:formatNumber value="${item1[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                    <td>Rs. <fmt:formatNumber value="${item1[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                    <c:if test="${rev_submit_flag1 == '1'}">

                                                                        <c:set var="revFound1" value="false" />

                                                                        <c:forEach var="rev1" items="${reviseVendorTenderBidItem1}">

                                                                            <c:if test="${item1[0] == rev1[0]}">

                                                                                <td>Rs. <fmt:formatNumber value="${rev1[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <td>Rs. <fmt:formatNumber value="${rev1[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <c:set var="revFound1" value="true" />

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${!revFound1}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false" />

                                                                    <c:forEach var="item2" items="${vendorTenderBidItem2}">

                                                                        <c:if test="${item1[0] == item2[0]}">

                                                                            <td>Rs. <fmt:formatNumber value="${item2[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <td>Rs. <fmt:formatNumber value="${item2[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found2" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found2}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag2 == '1'}">

                                                                        <c:set var="revFound2" value="false" />

                                                                        <c:forEach var="rev2" items="${reviseVendorTenderBidItem2}">

                                                                            <c:if test="${item1[0] == rev2[0]}">

                                                                                <td>Rs. <fmt:formatNumber value="${rev2[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <td>Rs. <fmt:formatNumber value="${rev2[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <c:set var="revFound2" value="true" />

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${!revFound2}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false" />

                                                                    <c:forEach var="item3" items="${vendorTenderBidItem3}">

                                                                        <c:if test="${item1[0] == item3[0]}">

                                                                            <td>Rs. <fmt:formatNumber value="${item3[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <td>Rs. <fmt:formatNumber value="${item3[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found3" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found3}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag3 == '1'}">

                                                                        <c:set var="revFound3" value="false" />

                                                                        <c:forEach var="rev3" items="${reviseVendorTenderBidItem3}">

                                                                            <c:if test="${item1[0] == rev3[0]}">

                                                                                <td>Rs. <fmt:formatNumber value="${rev3[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <td>Rs. <fmt:formatNumber value="${rev3[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <c:set var="revFound3" value="true" />

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${!revFound3}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>

                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false" />

                                                                    <c:forEach var="item4" items="${vendorTenderBidItem4}">

                                                                        <c:if test="${item1[0] == item4[0]}">

                                                                            <td>Rs. <fmt:formatNumber value="${item4[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <td>Rs. <fmt:formatNumber value="${item4[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                            <c:set var="found4" value="true" />

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${!found4}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag4 == '1'}">

                                                                        <c:set var="revFound4" value="false" />

                                                                        <c:forEach var="rev4" items="${reviseVendorTenderBidItem4}">

                                                                            <c:if test="${item1[0] == rev4[0]}">

                                                                                <td>Rs. <fmt:formatNumber value="${rev4[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <td>Rs. <fmt:formatNumber value="${rev4[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                                <c:set var="revFound4" value="true" />

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${!revFound4}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>

                                                            </tr>

                                                        </c:forEach>
                                                        
                                                        <tr>
                                                            <th colspan="5"><b>Ex-work Price/FOB</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${rev_total_value1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${rev_total_value2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${rev_total_value3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${rev_total_value4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>
                                                        
                                                        <tr>
                                                            <th colspan="5"><b>Packing & Forwarding</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${packingValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revpackingValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revpackingValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${packingValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revpackingValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revpackingValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${packingValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revpackingValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revpackingValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${packingValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${packingValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revpackingValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revpackingValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>Charges</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${chargesValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revchargesValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revchargesValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${chargesValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revchargesValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revchargesValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${chargesValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revchargesValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revchargesValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${chargesValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${chargesValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revchargesValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revchargesValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Insurance</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${insuranceValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revinsuranceValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revinsuranceValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${insuranceValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revinsuranceValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revinsuranceValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${insuranceValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revinsuranceValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revinsuranceValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${insuranceValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${insuranceValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revinsuranceValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revinsuranceValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>Erection Commision</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${errectionValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${reverrectionValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${reverrectionValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${errectionValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${reverrectionValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${reverrectionValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${errectionValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${reverrectionValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${reverrectionValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${errectionValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${errectionValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${reverrectionValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${reverrectionValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Discount</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${discountValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revdiscountValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revdiscountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${discountValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revdiscountValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revdiscountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${discountValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revdiscountValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revdiscountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${discountValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${discountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revdiscountValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revdiscountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price without GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal1 - revigstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal2 - revigstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal3 - revigstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal4 - revigstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${igstValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revigstValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revigstValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${igstValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revigstValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revigstValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${igstValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revigstValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revigstValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${igstValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${igstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revigstValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revigstValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${Total4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revTotal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>Rating</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${rank1}</td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank1}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${rank2}</td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank2}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${rank3}</td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank3}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${rank4}</td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank4}</td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>No Of Item Regret</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${regret1}</td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret1}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${regret2}</td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret2}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${regret3}</td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret3}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${regret4}</td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret4}</td>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>
                                                    </c:if>
                                                        
                                                    <c:if test = "${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">    
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21" style="text-align:center; background:#f2f2f2;">
                                                                Price Bid Comparison With Revise Bid For Service
                                                            </th>
                                                        </tr>

                                                        <tr class="text-center">
                                                            <th rowspan="3">Sr No.</th>
                                                            <th colspan="4">Vendor Code</th>
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>
                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_code1}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>
                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_code2}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>
                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_code3}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>
                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_code4}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr class="text-center">
                                                            <th colspan="4">Vendor Name</th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>
                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_name1}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>
                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_name2}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>
                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_name3}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>
                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_name4}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
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
                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if> 

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>               

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Unit Price</th>
                                                                <th>Value</th>
                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th>Unit Price</th>
                                                                    <th>Value</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <c:forEach var="item1" items="${ServicevendorTenderBidItem1}" varStatus="status">
                                                            <tr>
                                                                <td class="text-center">${status.count}</td>
                                                                <td>${item1[1]}</td>
                                                                <td>${item1[2]}</td>
                                                                <td>${item1[4]}</td>
                                                                <td>${item1[3]}</td>

                                                                <c:if test="${vendor_code1 != ''}">
                                                                    <td>Rs. <fmt:formatNumber value="${item1[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                    <td>Rs. <fmt:formatNumber value="${item1[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                    <c:if test="${rev_submit_flag1 == '1'}">

                                                                        <c:set var="revFound1" value="false" />

                                                                        <c:forEach var="rev1" items="${revServicevendorTenderBidItem1}">
                                                                            <c:if test="${item1[0] == rev1[0]}">
                                                                                <td>Rs. <fmt:formatNumber value="${rev1[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <td>Rs. <fmt:formatNumber value="${rev1[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <c:set var="revFound1" value="true" />
                                                                            </c:if>
                                                                        </c:forEach>

                                                                        <c:if test="${!revFound1}">
                                                                            <td>-</td>
                                                                            <td>-</td>                                                    
                                                                        </c:if>

                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false" />

                                                                    <c:forEach var="item2" items="${ServicevendorTenderBidItem2}">
                                                                        <c:if test="${item1[0] == item2[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item2[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item2[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <c:set var="found2" value="true" />
                                                                        </c:if>
                                                                    </c:forEach>

                                                                    <c:if test="${!found2}">
                                                                        <td>-</td>
                                                                        <td>-</td>                                                
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag2 == '1'}">

                                                                        <c:set var="revFound2" value="false" />

                                                                        <c:forEach var="rev2" items="${revServicevendorTenderBidItem2}">
                                                                            <c:if test="${item1[0] == rev2[0]}">
                                                                                <td>Rs. <fmt:formatNumber value="${rev2[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <td>Rs. <fmt:formatNumber value="${rev2[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <c:set var="revFound2" value="true" />
                                                                            </c:if>
                                                                        </c:forEach>

                                                                        <c:if test="${!revFound2}">
                                                                            <td>-</td>
                                                                            <td>-</td>                                                    
                                                                        </c:if>

                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false" />

                                                                    <c:forEach var="item3" items="${ServicevendorTenderBidItem3}">
                                                                        <c:if test="${item1[0] == item3[0]}">
                                                                            <td>Rs. <fmt:formatNumber value="${item3[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item3[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <c:set var="found3" value="true" />
                                                                        </c:if>
                                                                    </c:forEach>

                                                                    <c:if test="${!found3}">
                                                                        <td>-</td>
                                                                        <td>-</td>                                                
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag3 == '1'}">

                                                                        <c:set var="revFound3" value="false" />

                                                                        <c:forEach var="rev3" items="${revServicevendorTenderBidItem3}">
                                                                            <c:if test="${item1[0] == rev3[0]}">                                                        
                                                                                <td>Rs. <fmt:formatNumber value="${rev3[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <td>Rs. <fmt:formatNumber value="${rev3[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <c:set var="revFound3" value="true" />
                                                                            </c:if>
                                                                        </c:forEach>

                                                                        <c:if test="${!revFound3}">
                                                                            <td>-</td>
                                                                            <td>-</td>                                                    
                                                                        </c:if>

                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false" />

                                                                    <c:forEach var="item4" items="${ServicevendorTenderBidItem4}">
                                                                        <c:if test="${item1[0] == item4[0]}">                                                    
                                                                            <td>Rs. <fmt:formatNumber value="${item4[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <td>Rs. <fmt:formatNumber value="${item4[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                            <c:set var="found4" value="true" />
                                                                        </c:if>
                                                                    </c:forEach>

                                                                    <c:if test="${!found4}">
                                                                        <td>-</td>
                                                                        <td>-</td>                                                
                                                                    </c:if>

                                                                    <c:if test="${rev_submit_flag4 == '1'}">

                                                                        <c:set var="revFound4" value="false" />

                                                                        <c:forEach var="rev4" items="${revServicevendorTenderBidItem4}">
                                                                            <c:if test="${item1[0] == rev4[0]}">
                                                                                <td>Rs. <fmt:formatNumber value="${rev4[5]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <td>Rs. <fmt:formatNumber value="${rev4[6]}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                                <c:set var="revFound4" value="true" />
                                                                            </c:if>
                                                                        </c:forEach>

                                                                        <c:if test="${!revFound4}">
                                                                            <td>-</td>
                                                                            <td>-</td>                                                    
                                                                        </c:if>

                                                                    </c:if>
                                                                </c:if>

                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>

                                                            </tr>
                                                        </c:forEach>


                                                        <tr>
                                                            <th colspan="5"><b>Ex-work Price/FOB</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTotalFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTotalFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTotalFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTotalFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Discount</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${serviceDiscountValue1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revserviceDiscountValue1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceDiscountValueFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${serviceDiscountValue2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revserviceDiscountValue2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceDiscountValueFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${serviceDiscountValue3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revserviceDiscountValue3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceDiscountValueFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${serviceDiscountValue4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceDiscountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revserviceDiscountValue4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceDiscountValueFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price without GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal1 - revservicegstFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal2 - revservicegstFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal3 - revservicegstFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal4 - revservicegstFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>GST</b></th>

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <td>${servicegst1}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td>${revservicegst1}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revservicegstFinal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td>${servicegst2}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td>${revservicegst2}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revservicegstFinal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td>${servicegst3}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td>${revservicegst3}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revservicegstFinal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td>${servicegst4}%</td>
                                                                <td>Rs. <fmt:formatNumber value="${servicegstFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td>${revservicegst4}%</td>
                                                                    <td>Rs. <fmt:formatNumber value="${revservicegstFinal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th colspan="5"><b>Final Evaluated Price</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal1}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal2}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal3}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>Rs. <fmt:formatNumber value="${serviceTaxTotal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>Rs. <fmt:formatNumber value="${revserviceTaxTotal4}" type="number" groupingUsed="true" minFractionDigits="2" maxFractionDigits="2" /></td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>Rating</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${rank1}</td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank1}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${rank2}</td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank2}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${rank3}</td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank3}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${rank4}</td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>${rank4}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr>
                                                            <th  colspan="5"><b>No Of Item Regret</b></th>
                                                                <c:if test="${vendor_code1 != ''}">
                                                                <td></td>
                                                                <td>${regret1}</td>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret1}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <td></td>
                                                                <td>${regret2}</td>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret2}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <td></td>
                                                                <td>${regret3}</td>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret3}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <td></td>
                                                                <td>${regret4}</td>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <td></td>
                                                                    <td>${regret4}</td>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>
                                                        
                                                    </c:if>
                                                    
                                                    <c:if test = "${!empty vendorTermsCondition1}">    
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21"></th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="21" style="text-align:center; background:#f2f2f2;">
                                                                Terms & Condition Comparison
                                                            </th>
                                                        </tr>
                                                        
                                                        <tr class="text-center">
                                                            <th rowspan="3">Sr No.</th>
                                                            <th colspan="4">Vendor Code</th>                                    

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_code1}</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_code1} Rev</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_code2}</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_code2} Rev</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_code3}</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_code3} Rev</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_code4}</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_code4} Rev</th>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr class="text-center">
                                                            <th colspan="4">Vendor Code</th>                                    

                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th colspan="2">${vendor_name1}</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th colspan="2">${vendor_name1}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th colspan="2">${vendor_name2}</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th colspan="2">${vendor_name2}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th colspan="2">${vendor_name3}</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th colspan="2">${vendor_name3}</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th colspan="2">${vendor_name4}</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th colspan="2">${vendor_name4}</th>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                        <tr class="text-center">
                                                            <th colspan="2">Terms Condition</th>
                                                            <th colspan="2">Description</th>
                                                            <c:if test="${vendor_code1 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>

                                                                <c:if test="${rev_submit_flag1 == '1'}">
                                                                    <th>Response</th>
                                                                    <th>Remark</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code2 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>

                                                                <c:if test="${rev_submit_flag2 == '1'}">
                                                                    <th>Response</th>
                                                                    <th>Remark</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code3 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>

                                                                <c:if test="${rev_submit_flag3 == '1'}">
                                                                    <th>Response</th>
                                                                    <th>Remark</th>
                                                                </c:if>
                                                            </c:if>

                                                            <c:if test="${vendor_code4 != ''}">
                                                                <th>Response</th>
                                                                <th>Remark</th>

                                                                <c:if test="${rev_submit_flag4 == '1'}">
                                                                    <th>Response</th>
                                                                    <th>Remark</th>
                                                                </c:if>
                                                            </c:if>
                                                                    
                                                            <c:if test="${vendor_code1 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code2 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code3 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>
                                                            <c:if test="${vendor_code4 == ''}">
                                                                <td colspan="4"></td>                                                            
                                                            </c:if>

                                                        </tr>

                                                    </thead>

                                                    <tbody>

                                                        <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">

                                                            <tr>

                                                                <td>${status.count}</td>
                                                                <td colspan="2">${vendorTermsCondition1.termsCondition}</td>
                                                                <td colspan="2">${vendorTermsCondition1.description}</td>


                                                                <c:if test="${vendor_code1 != ''}">

                                                                    <c:set var="found1" value="false"/>

                                                                    <c:forEach var="v1" items="${vendorTermsConditionPriceBid1}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == v1.termsCondition && vendorTermsCondition1.description == v1.description}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${v1.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${v1.comment}</td>

                                                                            <c:set var="found1" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${found1 == false}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>


                                                                    <c:if test="${rev_submit_flag1 == '1'}">

                                                                        <c:set var="revFound1" value="false"/>

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

                                                                </c:if>


                                                                <c:if test="${vendor_code2 != ''}">

                                                                    <c:set var="found2" value="false"/>

                                                                    <c:forEach var="v2" items="${vendorTermsConditionPriceBid2}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == v2.termsCondition && vendorTermsCondition1.description == v2.description}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${v2.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${v2.comment}</td>

                                                                            <c:set var="found2" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${found2 == false}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>


                                                                    <c:if test="${rev_submit_flag2 == '1'}">

                                                                        <c:set var="revFound2" value="false"/>

                                                                        <c:forEach var="r2" items="${vendorTermsCondition2}">

                                                                            <c:if test="${vendorTermsCondition1.termsCondition == r2.termsCondition}">

                                                                                <td>
                                                                                    <c:choose>
                                                                                        <c:when test="${r2.response == 0}">
                                                                                            Accept
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            Reject
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </td>

                                                                                <td>${r2.comment}</td>

                                                                                <c:set var="revFound2" value="true"/>

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${revFound2 == false}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>


                                                                <c:if test="${vendor_code3 != ''}">

                                                                    <c:set var="found3" value="false"/>

                                                                    <c:forEach var="v3" items="${vendorTermsConditionPriceBid3}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == v3.termsCondition && vendorTermsCondition1.description == v3.description}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${v3.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${v3.comment}</td>

                                                                            <c:set var="found3" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${found3 == false}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>


                                                                    <c:if test="${rev_submit_flag3 == '1'}">

                                                                        <c:set var="revFound3" value="false"/>

                                                                        <c:forEach var="r3" items="${vendorTermsCondition3}">

                                                                            <c:if test="${vendorTermsCondition1.termsCondition == r3.termsCondition}">

                                                                                <td>
                                                                                    <c:choose>
                                                                                        <c:when test="${r3.response == 0}">
                                                                                            Accept
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            Reject
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </td>

                                                                                <td>${r3.comment}</td>

                                                                                <c:set var="revFound3" value="true"/>

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${revFound3 == false}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>


                                                                <c:if test="${vendor_code4 != ''}">

                                                                    <c:set var="found4" value="false"/>

                                                                    <c:forEach var="v4" items="${vendorTermsConditionPriceBid4}">

                                                                        <c:if test="${vendorTermsCondition1.termsCondition == v4.termsCondition && vendorTermsCondition1.description == v4.description}">

                                                                            <td>
                                                                                <c:choose>
                                                                                    <c:when test="${v4.response == 0}">
                                                                                        Accept
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        Reject
                                                                                    </c:otherwise>
                                                                                </c:choose>
                                                                            </td>

                                                                            <td>${v4.comment}</td>

                                                                            <c:set var="found4" value="true"/>

                                                                        </c:if>

                                                                    </c:forEach>

                                                                    <c:if test="${found4 == false}">
                                                                        <td>-</td>
                                                                        <td>-</td>
                                                                    </c:if>


                                                                    <c:if test="${rev_submit_flag4 == '1'}">

                                                                        <c:set var="revFound4" value="false"/>

                                                                        <c:forEach var="r4" items="${vendorTermsCondition4}">

                                                                            <c:if test="${vendorTermsCondition1.termsCondition == r4.termsCondition}">

                                                                                <td>
                                                                                    <c:choose>
                                                                                        <c:when test="${r4.response == 0}">
                                                                                            Accept
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            Reject
                                                                                        </c:otherwise>
                                                                                    </c:choose>
                                                                                </td>

                                                                                <td>${r4.comment}</td>

                                                                                <c:set var="revFound4" value="true"/>

                                                                            </c:if>

                                                                        </c:forEach>

                                                                        <c:if test="${revFound4 == false}">
                                                                            <td>-</td>
                                                                            <td>-</td>
                                                                        </c:if>

                                                                    </c:if>

                                                                </c:if>
                                                                            
                                                                <c:if test="${vendor_code1 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code2 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code3 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>
                                                                <c:if test="${vendor_code4 == ''}">
                                                                    <td colspan="4"></td>                                                            
                                                                </c:if>

                                                            </tr>

                                                        </c:forEach>

                                                    </c:if>
                                                    <tr>
                                                        <th colspan="21"></th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="21"></th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="21" style="text-align:center; background:#f2f2f2;">
                                                            Vendor Comparison
                                                        </th>
                                                    </tr>

                                                    <tr>
                                                        <th colspan="2">Vendor Code</th>
                                                        <th colspan="2">Vendor Name</th>
                                                        <th colspan="2">Supply Part</th>
                                                        <th colspan="2">Service Part</th>
                                                        <th colspan="2">Basic Total</th>
                                                        <th colspan="2">GST Value</th>
                                                        <th colspan="2">Total including Tax</th>
                                                        <th colspan="2">Budget Value</th>
                                                        <th colspan="2">Difference Between Budget Value VS Received Proposal</th>
                                                        <th colspan="3">Difference In Percentage</th>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="2">${vendor_code1}</td>
                                                        <td colspan="2">${vendor_name1}</td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${Total1 - igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${serviceTaxTotal1 - servicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${(serviceTaxTotal1 - servicegstFinal1) + (Total1 - igstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${servicegstFinal1 + igstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${Total1 + serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - Total1 - serviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                        <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (Total1 + serviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                    </tr>
                                                    <c:if test="${rev_submit_flag1 == '1'}">
                                                        <tr>
                                                            <td colspan="2">${vendor_code1} Revise</td>
                                                            <td colspan="2">${vendor_name1}</td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${revTotal1 - revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${revserviceTaxTotal1 - revservicegstFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${(revserviceTaxTotal1 - revservicegstFinal1) + (revTotal1 - revigstValueFinal1)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${revservicegstFinal1 + revigstValueFinal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${revTotal1 + revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - revTotal1 - revserviceTaxTotal1}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (revTotal1 + revserviceTaxTotal1)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                        </tr>
                                                    </c:if>
                                                    <c:if test="${vendor_code2 != ''}">
                                                        <tr>
                                                            <td colspan="2">${vendor_code2}</td>
                                                            <td colspan="2">${vendor_name2}</td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total2 - igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${serviceTaxTotal2 - servicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${(serviceTaxTotal2 - servicegstFinal2) + (Total2 - igstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${servicegstFinal2 + igstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total2 + serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - Total2 - serviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (Total2 + serviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                        </tr>
                                                        <c:if test="${rev_submit_flag2 == '1'}">
                                                            <tr>
                                                                <td colspan="2">${vendor_code2} Revise</td>
                                                                <td colspan="2">${vendor_name2}</td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal2 - revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revserviceTaxTotal2 - revservicegstFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${(revserviceTaxTotal2 - revservicegstFinal2) + (revTotal2 - revigstValueFinal2)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revservicegstFinal2 + revigstValueFinal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal2 + revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - revTotal2 - revserviceTaxTotal2}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (revTotal2 + revserviceTaxTotal2)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                            </tr>
                                                        </c:if>
                                                    </c:if>
                                                    <c:if test="${vendor_code3 != ''}">
                                                        <tr>
                                                            <td colspan="2">${vendor_code3}</td>
                                                            <td colspan="2">${vendor_name3}</td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total3 - igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${serviceTaxTotal3 - servicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${(serviceTaxTotal3 - servicegstFinal3) + (Total3 - igstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${servicegstFinal3 + igstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total3 + serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - Total3 - serviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (Total3 + serviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                        </tr>
                                                        <c:if test="${rev_submit_flag3 == '1'}">
                                                            <tr>
                                                                <td colspan="2">${vendor_code3} Revise</td>
                                                                <td colspan="2">${vendor_name3}</td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal3 - revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revserviceTaxTotal3 - revservicegstFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${(revserviceTaxTotal3 - revservicegstFinal3) + (revTotal3 - revigstValueFinal3)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revservicegstFinal3 + revigstValueFinal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal3 + revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - revTotal3 - revserviceTaxTotal3}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (revTotal3 + revserviceTaxTotal3)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                            </tr>
                                                        </c:if>
                                                    </c:if>

                                                    <c:if test="${vendor_code4 != ''}">
                                                        <tr>
                                                            <td colspan="2">${vendor_code4}</td>
                                                            <td colspan="2">${vendor_name4}</td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total4 - igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${serviceTaxTotal4 - servicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${(serviceTaxTotal4 - servicegstFinal4) + (Total4 - igstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${servicegstFinal4 + igstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${Total4 + serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - Total4 - serviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                            <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (Total4 + serviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                        </tr>
                                                        <c:if test="${rev_submit_flag4 == '1'}">
                                                            <tr>
                                                                <td colspan="2">${vendor_code4} Revise</td>
                                                                <td colspan="2">${vendor_name4}</td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal4 - revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revserviceTaxTotal4 - revservicegstFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${(revserviceTaxTotal4 - revservicegstFinal4) + (revTotal4 - revigstValueFinal4)}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revservicegstFinal4 + revigstValueFinal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${revTotal4 + revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="2">Rs. <fmt:formatNumber value="${tenderMaster.value - revTotal4 - revserviceTaxTotal4}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                                                                <td colspan="3"><fmt:formatNumber value="${((tenderMaster.value - (revTotal4 + revserviceTaxTotal4)) * 100) / tenderMaster.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</td>
                                                            </tr>
                                                        </c:if>
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


