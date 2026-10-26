 <%@ page contentType="text/html;application/vnd.ms-excel; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%
    response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=mult_table.xls");
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
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                            
<!--                                            <div class="table">-->

                                                <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status1">
                                                    
                                                    <c:if test="${status1.count == '1'}">
                                                        <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
                                                            <table   style="" align="Center"  border="1px">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                    <th>Currency Name</th>
                                                                    <c:if test="${vendor_code1 != ''}">
                                                                        <th>INR</th>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <th>INR</th>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <th>INR</th>
                                                                    </c:if>
                                                                </tr>
                                                                
                                                                <tr>
                                                                    <th>Exchange Rate</th>
                                                                    <c:if test="${vendor_code1 != ''}">
                                                                        <th>1.00</th>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <th>1.00</th>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <th>1.00</th>
                                                                    </c:if>
                                                                </tr>
                                                                
                                                                <tr>
                                                                    <td style="padding: 0px;">
                                                                        <table  style="padding:  0px;margin-bottom: 0px;" border="1px">
                                                                            <tr>
                                                                                <th>Sr.</th>
                                                                                <th>Item Description</th>
                                                                                <th>Quantity</th>
                                                                                <th>UOM</th>
                                                                            </tr>
                                                                            
                                                                            <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_1}" varStatus="status">
                                                                                <tr>
                                                                                    <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.srNo}</td>
                                                                                    <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.itemDesc}</td>
                                                                                    <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.quantity}</td>
                                                                                    <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.uom}</td>
                                                                                </tr>
                                                                            </c:forEach>
                                                                            
                                                                        </table>
                                                                        
                                                                    </td>
                                                                    <c:if test="${vendor_code1 != ''}">
                                                                        <td style="padding: 0px;width:180px">
                                                                        <table  style="padding:  0px;margin-bottom: 0px;" border="1px">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">
                                                                                            <c:if test="${serviceVendorTenderBidItem1.rate == '0'}">
                                                                                                Regret
                                                                                            </c:if>
                                                                                            <c:if test="${serviceVendorTenderBidItem1.rate != '0'}">
                                                                                                ${serviceVendorTenderBidItem1.rate}
                                                                                            </c:if>
                                                                                            
                                                                                        </td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.netRate}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem1.netRate}</td>
                                                                                    </tr>
                                                                                </c:forEach>
                                                                            
                                                                            </table>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <td  style="padding: 0px;width:180px">
                                                                            <table border="1px" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th  style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem12_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">
                                                                                            <c:if test="${serviceVendorTenderBidItem2.rate == '0'}">
                                                                                                Regret
                                                                                            </c:if>
                                                                                            <c:if test="${serviceVendorTenderBidItem2.rate != '0'}">
                                                                                                ${serviceVendorTenderBidItem2.rate}
                                                                                            </c:if>
                                                                                            
                                                                                        </td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem2.netRate}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem2.netRate}</td>
                                                                                    </tr>
                                                                                </c:forEach>
                                                                            
                                                                            </table>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <td  style="padding: 0px;width:180px">
                                                                            <table  border="1px" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem13_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;width:60px">
                                                                                            <c:if test="${serviceVendorTenderBidItem3.rate == '0'}">
                                                                                                Regret
                                                                                            </c:if>
                                                                                            <c:if test="${serviceVendorTenderBidItem3.rate != '0'}">
                                                                                                ${serviceVendorTenderBidItem3.rate}
                                                                                            </c:if>
                                                                                            
                                                                                        </td>
                                                                                     <td style="padding: 0px 0px;width:60px">${serviceVendorTenderBidItem3.netRate}</td>
                                                                                        <td style="padding: 0px 0px;width:60px">${serviceVendorTenderBidItem3.netRate}</td>
                                                                                    </tr>
                                                                                </c:forEach>
                                                                            
                                                                            </table>
                                                                        </td>
                                                                    </c:if>
                                                                </tr>
                                                                
                                                                
                                                                
                                                                
                                                                <tr>
                                                                    <td>
                                                                        <table border="1px">
                                                                            <tr>
                                                                                <td>
                                                                                    1. Ex-work Price/FOB
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    2. Discount
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    3. Packing & Forwarding
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    4. Freigst / Transportation
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    5. Erection Commision Charges
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    6. Other Charges
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    7. IGST
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    8. CGST
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    9. SGST
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    10. Insurance
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>
                                                                                    11. Final Evaluated Price
                                                                                </td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        
                                                                    </td>
                                                                    <c:if test="${vendor_code1 != ''}">
                                                                        <td>
                                                                        <table border="1px">
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value1_1}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value1_1}</td>
                                                                                <td>${discount1_1}</td>
                                                                                <td>${discount_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value1_1}</td>
                                                                                <td>${packing1_1}</td>
                                                                                <td>${packing_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value1_1}</td>
                                                                                <td>${freight1_1}</td>
                                                                                <td>${freight_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value1_1}</td>
                                                                                <td>${errection1_1}</td>
                                                                                <td>${errection_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value1_1}</td>
                                                                                <td>${charges1_1}</td>
                                                                                <td>${charges_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value1_1}</td>
                                                                                <td>${igst1_1}</td>
                                                                                <td>${igst_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value1_1}</td>
                                                                                <td>${cgst1_1}</td>
                                                                                <td>${cgst_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value1_1}</td>
                                                                                <td>${sgst1_1}</td>
                                                                                <td>${sgst_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value1_1}</td>
                                                                                <td>${insurance1_1}</td>
                                                                                <td>${insurance_after1_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after1_1}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        
                                                                            
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <td>
                                                                            <table border="1px">
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value2_1}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value2_1}</td>
                                                                                <td>${discount2_1}</td>
                                                                                <td>${discount_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value2_1}</td>
                                                                                <td>${packing2_1}</td>
                                                                                <td>${packing_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value2_1}</td>
                                                                                <td>${freight2_1}</td>
                                                                                <td>${freight_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value2_1}</td>
                                                                                <td>${errection2_1}</td>
                                                                                <td>${errection_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value2_1}</td>
                                                                                <td>${charges2_1}</td>
                                                                                <td>${charges_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value2_1}</td>
                                                                                <td>${igst2_1}</td>
                                                                                <td>${igst_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value2_1}</td>
                                                                                <td>${cgst2_1}</td>
                                                                                <td>${cgst_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value2_1}</td>
                                                                                <td>${sgst2_1}</td>
                                                                                <td>${sgst_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value2_1}</td>
                                                                                <td>${insurance2_1}</td>
                                                                                <td>${insurance_after2_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after2_1}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <td>
                                                                            <table border="1px">
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value3_1}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value3_1}</td>
                                                                                <td>${discount3_1}</td>
                                                                                <td>${discount_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value3_1}</td>
                                                                                <td>${packing3_1}</td>
                                                                                <td>${packing_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value3_1}</td>
                                                                                <td>${freight3_1}</td>
                                                                                <td>${freight_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value3_1}</td>
                                                                                <td>${errection3_1}</td>
                                                                                <td>${errection_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value13_1}</td>
                                                                                <td>${charges3_1}</td>
                                                                                <td>${charges_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value3_1}</td>
                                                                                <td>${igst3_1}</td>
                                                                                <td>${igst_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value3_1}</td>
                                                                                <td>${cgst3_1}</td>
                                                                                <td>${cgst_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value3_1}</td>
                                                                                <td>${sgst3_1}</td>
                                                                                <td>${sgst_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value3_1}</td>
                                                                                <td>${insurance3_1}</td>
                                                                                <td>${insurance_after3_1}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after3_1}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        </td>
                                                                    </c:if>
                                                                </tr>
                                                                    
                                                                </tbody>
                                                            </table>
                                                        </c:if>
                                                        <c:if test="${fileDetail.serType == 'Service2'}">
                                                            
                                                            <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    
                                                                    <tr>
                                                                        <td style="padding: 0px;">
                                                                            <table border="1px" >
                                                                                <c:forEach var="serviceDetail" items="${serviceDetail21_1}" varStatus="status">
                                                                                    <c:if test="${status.count == 1}">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th>${serviceDetail.srNo}</th>
                                                                                                <th>${serviceDetail.itemDesc}</th>
                                                                                            </tr>
                                                                                        </thead>

                                                                                        <tbody>
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                                        <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                                        
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_1}" varStatus="status">
                                                                                        <c:if test="${status.count == 1}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                                <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing1}</th>
                                                                                                                    <c:set var = "i1" value="1"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing2}</th>
                                                                                                                    <c:set var = "i1" value="2"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing3}</th>
                                                                                                                    <c:set var = "i1" value="3"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing4}</th>
                                                                                                                    <c:set var = "i1" value="4"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing5}</th>
                                                                                                                    <c:set var = "i1" value="5"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing6}</th>
                                                                                                                    <c:set var = "i1" value="6"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing7}</th>
                                                                                                                    <c:set var = "i1" value="7"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing8}</th>
                                                                                                                    <c:set var = "i1" value="8"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing9}</th>
                                                                                                                    <c:set var = "i1" value="9"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing10}</th>
                                                                                                                    <c:set var = "i1" value="10"/>
                                                                                                                </c:if>

                                                                                                </tr>
                                                                                            </thead>

                                                                                            <tbody>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                                            </c:if>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_1}" varStatus="status">
                                                                                        <c:if test="${status.count == 1}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                                <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing1}</th>
                                                                                                                    <c:set var = "i1" value="1"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing2}</th>
                                                                                                                    <c:set var = "i1" value="2"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing3}</th>
                                                                                                                    <c:set var = "i1" value="3"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing4}</th>
                                                                                                                    <c:set var = "i1" value="4"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing5}</th>
                                                                                                                    <c:set var = "i1" value="5"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing6}</th>
                                                                                                                    <c:set var = "i1" value="6"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing7}</th>
                                                                                                                    <c:set var = "i1" value="7"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing8}</th>
                                                                                                                    <c:set var = "i1" value="8"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing9}</th>
                                                                                                                    <c:set var = "i1" value="9"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing10}</th>
                                                                                                                    <c:set var = "i1" value="10"/>
                                                                                                                </c:if>

                                                                                                </tr>
                                                                                            </thead>

                                                                                            <tbody>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem22_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                                            </c:if>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_1}" varStatus="status">
                                                                                        <c:if test="${status.count == 1}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                                <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing1}</th>
                                                                                                                    <c:set var = "i1" value="1"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing2}</th>
                                                                                                                    <c:set var = "i1" value="2"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing3}</th>
                                                                                                                    <c:set var = "i1" value="3"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing4}</th>
                                                                                                                    <c:set var = "i1" value="4"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing5}</th>
                                                                                                                    <c:set var = "i1" value="5"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing6}</th>
                                                                                                                    <c:set var = "i1" value="6"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing7}</th>
                                                                                                                    <c:set var = "i1" value="7"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing8}</th>
                                                                                                                    <c:set var = "i1" value="8"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing9}</th>
                                                                                                                    <c:set var = "i1" value="9"/>
                                                                                                                </c:if>
                                                                                                                <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                                    <th>${serviceDetail.onlyBearing10}</th>
                                                                                                                    <c:set var = "i1" value="10"/>
                                                                                                                </c:if>

                                                                                                </tr>
                                                                                            </thead>

                                                                                            <tbody>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem23_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing1}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing2}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing3}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing4}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing5}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing6}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing7}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing8}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing9}</td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td>${serviceVendorTenderBidItem2.onlyBearing10}</td>
                                                                                            </c:if>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    
                                                                    
                                                                    
                                                                </tbody>
                                                            </table>
                                                            
                                                            
                                                        </c:if>
                                                        <c:if test="${fileDetail.serType == 'Service3'}">
                                                            <table border="1px" >
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    <tr>
                                                                        <td style="padding: 0px;">
                                                                            <table border="1px">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>Particlar<br>&nbsp;</th>
                                                                                    <th style="width:100px">Scheduled Amount<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">${status.count}<br><br><br></td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem31.particular}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem31.scheduledAmount}</td>
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem31.percent}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem31.percentRate}</td>
                                                                                            <td style="padding: 0px 0px;">
                                                                                                <c:if test="${serviceVendorTenderBidItem31.amountTotal == '0'}">
                                                                                                    Regret
                                                                                                </c:if>
                                                                                                <c:if test="${serviceVendorTenderBidItem31.amountTotal != '0'}">
                                                                                                    ${serviceVendorTenderBidItem31.amountTotal}
                                                                                                </c:if>    
                                                                                                
                                                                                            </td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem32" items="${serviceVendorTenderBidItem32_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem32.percent}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem32.percentRate}</td>
                                                                                            <td style="padding: 0px 0px;">
                                                                                                <c:if test="${serviceVendorTenderBidItem32.amountTotal == '0'}">
                                                                                                    Regret
                                                                                                </c:if>
                                                                                                <c:if test="${serviceVendorTenderBidItem32.amountTotal != '0'}">
                                                                                                    ${serviceVendorTenderBidItem32.amountTotal}
                                                                                                </c:if>    
                                                                                                
                                                                                            </td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem33" items="${serviceVendorTenderBidItem33_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem33.percent}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem33.percentRate}</td>
                                                                                            <td style="padding: 0px 0px;">
                                                                                                <c:if test="${serviceVendorTenderBidItem33.amountTotal == '0'}">
                                                                                                    Regret
                                                                                                </c:if>
                                                                                                <c:if test="${serviceVendorTenderBidItem33.amountTotal != '0'}">
                                                                                                    ${serviceVendorTenderBidItem33.amountTotal}
                                                                                                </c:if>    
                                                                                               
                                                                                            </td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                
                                                                </tbody>
                                                            </table>
                                                        </c:if>
                                                        <c:if test="${fileDetail.serType == 'Service4'}">
                                                            
                                                            <table border="1px">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    <tr>
                                                                        <td style="padding: 0px;">
                                                                            <table border="1px">
                                                                                <tr>
                                                                                    <th>Security Name	<br>&nbsp;</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>No. Of Person	</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Minimum Wages (Skilled/Unskilled)/Day</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th> % Statutory Obligation</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Total</th>
                                                                                </tr>
                                                                                <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                    <tr>
                                                                                        <th>Allowance</th>

                                                                                    </tr>
                                                                                    <tr>
                                                                                        <th>Allowance Total</th>
                                                                                    </tr>
                                                                                </c:if>
                                                                                <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                    <tr>
                                                                                        <th>Uniform & Training Charges</th>
                                                                                    </tr>
                                                                                </c:if>

                                                                                <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                    <tr>
                                                                                        <th>Service Charge</th>
                                                                                    </tr>
                                                                                </c:if>
                                                                                <tr>
                                                                                    <th>Total per day per person</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Total per Month(30 Days) per person</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Total per Year(365 Days) per person</th>
                                                                                </tr>
                                                                                <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                    <tr>
                                                                                        <th>Total per date difference per person for Date</th>
                                                                                    </tr>
                                                                                </c:if>
                                                                                <tr>
                                                                                    <th>Total per day</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Total per Month(30 Days)</th>

                                                                                </tr>
                                                                                <tr>
                                                                                    <th>Total per Year(365 Days)</th>

                                                                                </tr>
                                                                                <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                    <tr>
                                                                                        <th>Total per date difference  from date</th>

                                                                                    </tr>
                                                                                </c:if>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_1}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_1}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_1}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                
                                                                </tbody>
                                                            </table>
                                                            
                                                            
                                                        </c:if>
                                                        
                                                        <c:if test="${fileDetail.serType == 'Service6'}">
                                                           <table border="1px" align="Center"  >
                                                                <thead>
                                                                    <tr>
                                                                        <th>Vendor Code</th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_code1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_code2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_code3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>Vendor Name </th>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <th>${vendor_name1}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <th>${vendor_name2}</th>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <th>${vendor_name3}</th>
                                                                        </c:if>
                                                                    </tr>
                                                                    
                                                                    <tr>
                                                                        <td style="padding: 0px;">
                                                                            <table border="1px">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>PC Type<br>&nbsp;</th>
                                                                                    <th>Item Description<br>&nbsp;</th>
                                                                                    <th>UOM<br>&nbsp;</th>
                                                                                    <th>QTY<br>&nbsp;</th>
                                                                                    <th>AMC Required Days<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">${status.count}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.pcType}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.itemDesc}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.uom}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.quantity}</td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.amcRquiredDays}</td>
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.rate}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem61.amountTotal}</td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem62" items="${serviceVendorTenderBidItem62_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem62.rate}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem62.amountTotal}</td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table border="1px">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem63" items="${serviceVendorTenderBidItem63_1}" varStatus="status">
                                                                                        <tr>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem63.rate}<br><br><br></td>
                                                                                            <td style="padding: 0px 0px;">${serviceVendorTenderBidItem63.amountTotal}</td>
                                                                                        </tr>
                                                                                    </c:forEach>

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                
                                                                </tbody>
                                                            </table> 
                                                        </c:if>
                                                    </c:if>
                                                    
                                                </c:forEach>

                                               
<!--                                            </div>-->
                                        
                                        
                                       
                                        
                                        
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


