<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Price Comparison</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Price Comparison</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Price Comparison</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
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
                                            <center><a href="tenderMaster.htm?act=priceBidServiceComparisonView&refNo=${refNo}&pageNo=${pageNo}&next=sub">Previous</a> &nbsp;&nbsp;<a href="tenderMaster.htm?act=priceBidServiceComparisonView&refNo=${refNo}&pageNo=${pageNo}&next=add">Next</a></center>
                                            <br>
<!--                                            <div class="table">-->

                                                <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status1">
                                                    
                                                    <c:if test="${status1.count == '1'}">
                                                        <a href="tenderMaster.htm?act=priceBidServiceComparisonExport&refNo=${refNo}&file_name=${fileDetail.fileName}">Export To Excel</a>
                                                        
                                                        <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                            <tr>
                                                                                <th>Sr.<br>&nbsp;</th>
                                                                                <th>Item Description<br>&nbsp;</th>
                                                                                <th>Quantity<br>&nbsp;</th>
                                                                                <th>UOM<br>&nbsp;</th>
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">
                                                                                            <c:if test="${serviceVendorTenderBidItem1.rate == '0'}">
                                                                                                <c:if test="${serviceVendorTenderBidItem1.uom != ''}">
                                                                                                    Regret
                                                                                                </c:if>
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th  style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem12_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">
                                                                                            <c:if test="${serviceVendorTenderBidItem2.rate == '0'}">
                                                                                                <c:if test="${serviceVendorTenderBidItem2.uom != ''}">
                                                                                                    Regret
                                                                                                </c:if>
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem13_1}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;width:60px">
                                                                                            <c:if test="${serviceVendorTenderBidItem3.rate == '0'}">
                                                                                                <c:if test="${serviceVendorTenderBidItem3.uom != ''}">
                                                                                                    Regret
                                                                                                </c:if>
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
                                                                        <table>
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
                                                                        <table>
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
                                                                            <table>
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
                                                                            <table>
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                    <c:if test="${status1.count == '2'}">
                                                        <a href="tenderMaster.htm?act=priceBidServiceComparisonExport&refNo=${refNo}&file_name=${fileDetail.fileName}">Export To Excel</a>
                                                        <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                            <tr>
                                                                                <th>Sr.<br>&nbsp;</th>
                                                                                <th>Item Description<br>&nbsp;</th>
                                                                                <th>Quantity<br>&nbsp;</th>
                                                                                <th>UOM<br>&nbsp;</th>
                                                                            </tr>
                                                                            
                                                                            <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_2}" varStatus="status">
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_2}" varStatus="status">
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th  style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem12_2}" varStatus="status">
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem13_2}" varStatus="status">
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
                                                                        <table>
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
                                                                        <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value1_2}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value1_2}</td>
                                                                                <td>${discount1_2}</td>
                                                                                <td>${discount_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value1_2}</td>
                                                                                <td>${packing1_2}</td>
                                                                                <td>${packing_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value1_2}</td>
                                                                                <td>${freight1_2}</td>
                                                                                <td>${freight_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value1_2}</td>
                                                                                <td>${errection1_2}</td>
                                                                                <td>${errection_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value1_2}</td>
                                                                                <td>${charges1_2}</td>
                                                                                <td>${charges_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value1_2}</td>
                                                                                <td>${igst1_2}</td>
                                                                                <td>${igst_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value1_2}</td>
                                                                                <td>${cgst1_2}</td>
                                                                                <td>${cgst_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value1_2}</td>
                                                                                <td>${sgst1_2}</td>
                                                                                <td>${sgst_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value1_2}</td>
                                                                                <td>${insurance1_2}</td>
                                                                                <td>${insurance_after1_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after1_2}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        
                                                                            
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <td>
                                                                            <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value2_2}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value2_2}</td>
                                                                                <td>${discount2_2}</td>
                                                                                <td>${discount_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value2_2}</td>
                                                                                <td>${packing2_2}</td>
                                                                                <td>${packing_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value2_2}</td>
                                                                                <td>${freight2_2}</td>
                                                                                <td>${freight_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value2_2}</td>
                                                                                <td>${errection2_2}</td>
                                                                                <td>${errection_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value2_2}</td>
                                                                                <td>${charges2_2}</td>
                                                                                <td>${charges_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value2_2}</td>
                                                                                <td>${igst2_2}</td>
                                                                                <td>${igst_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value2_2}</td>
                                                                                <td>${cgst2_2}</td>
                                                                                <td>${cgst_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value2_2}</td>
                                                                                <td>${sgst2_2}</td>
                                                                                <td>${sgst_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value2_2}</td>
                                                                                <td>${insurance2_2}</td>
                                                                                <td>${insurance_after2_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after2_2}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <td>
                                                                            <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value3_2}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value3_2}</td>
                                                                                <td>${discount3_2}</td>
                                                                                <td>${discount_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value3_2}</td>
                                                                                <td>${packing3_2}</td>
                                                                                <td>${packing_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value3_2}</td>
                                                                                <td>${freight3_2}</td>
                                                                                <td>${freight_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value3_2}</td>
                                                                                <td>${errection3_2}</td>
                                                                                <td>${errection_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value13_2}</td>
                                                                                <td>${charges3_2}</td>
                                                                                <td>${charges_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value3_2}</td>
                                                                                <td>${igst3_2}</td>
                                                                                <td>${igst_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value3_2}</td>
                                                                                <td>${cgst3_2}</td>
                                                                                <td>${cgst_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value3_2}</td>
                                                                                <td>${sgst3_2}</td>
                                                                                <td>${sgst_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value3_2}</td>
                                                                                <td>${insurance3_2}</td>
                                                                                <td>${insurance_after3_2}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after3_2}</td>
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <c:forEach var="serviceDetail" items="${serviceDetail21_2}" varStatus="status">
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
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_2}" varStatus="status">
                                                                                    <tr>
                                                                                        <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                                        <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                                        
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_2}" varStatus="status">
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
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_2}" varStatus="status">
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
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem22_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_2}" varStatus="status">
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
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem23_2}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>Particlar<br>&nbsp;</th>
                                                                                    <th style="width:100px">Scheduled Amount<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem32" items="${serviceVendorTenderBidItem32_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem33" items="${serviceVendorTenderBidItem33_2}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_2}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_2}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_2}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>PC Type<br>&nbsp;</th>
                                                                                    <th>Item Description<br>&nbsp;</th>
                                                                                    <th>UOM<br>&nbsp;</th>
                                                                                    <th>QTY<br>&nbsp;</th>
                                                                                    <th>AMC Required Days<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem62" items="${serviceVendorTenderBidItem62_2}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem63" items="${serviceVendorTenderBidItem63_2}" varStatus="status">
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

                                                    <c:if test="${status1.count == '3'}">
                                                        <a href="tenderMaster.htm?act=priceBidServiceComparisonExport&refNo=${refNo}&file_name=${fileDetail.fileName}">Export To Excel</a>
                                                        <c:if test="${fileDetail.serType == 'Service1' || fileDetail.serType == 'Service5'}">
                                                            
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                            <tr>
                                                                                <th>Sr.<br>&nbsp;</th>
                                                                                <th>Item Description<br>&nbsp;</th>
                                                                                <th>Quantity<br>&nbsp;</th>
                                                                                <th>UOM<br>&nbsp;</th>
                                                                            </tr>
                                                                            
                                                                            <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_3}" varStatus="status">
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
                                                                        <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem1" items="${serviceVendorTenderBidItem11_3}" varStatus="status">
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th  style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem12_3}" varStatus="status">
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
                                                                            <table  class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th style="width:60px">Unit Price</th>
                                                                                    <th style="width:60px">Price</th>
                                                                                    <th style="width:60px">Landed Cost</th>
                                                                                </tr>
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem13_3}" varStatus="status">
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
                                                                        <table>
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
                                                                        <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value1_3}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value1_3}</td>
                                                                                <td>${discount1_3}</td>
                                                                                <td>${discount_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value1_3}</td>
                                                                                <td>${packing1_3}</td>
                                                                                <td>${packing_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value1_3}</td>
                                                                                <td>${freight1_3}</td>
                                                                                <td>${freight_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value1_3}</td>
                                                                                <td>${errection1_3}</td>
                                                                                <td>${errection_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value1_3}</td>
                                                                                <td>${charges1_3}</td>
                                                                                <td>${charges_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value1_3}</td>
                                                                                <td>${igst1_3}</td>
                                                                                <td>${igst_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value1_3}</td>
                                                                                <td>${cgst1_3}</td>
                                                                                <td>${cgst_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value1_3}</td>
                                                                                <td>${sgst1_3}</td>
                                                                                <td>${sgst_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value1_3}</td>
                                                                                <td>${insurance1_3}</td>
                                                                                <td>${insurance_after1_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after1_3}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        
                                                                            
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code2 != ''}">
                                                                        <td>
                                                                            <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value2_3}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value2_3}</td>
                                                                                <td>${discount2_3}</td>
                                                                                <td>${discount_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value2_3}</td>
                                                                                <td>${packing2_3}</td>
                                                                                <td>${packing_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value2_3}</td>
                                                                                <td>${freight2_3}</td>
                                                                                <td>${freight_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value2_3}</td>
                                                                                <td>${errection2_3}</td>
                                                                                <td>${errection_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value2_3}</td>
                                                                                <td>${charges2_3}</td>
                                                                                <td>${charges_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value2_3}</td>
                                                                                <td>${igst2_3}</td>
                                                                                <td>${igst_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value2_3}</td>
                                                                                <td>${cgst2_3}</td>
                                                                                <td>${cgst_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value2_3}</td>
                                                                                <td>${sgst2_3}</td>
                                                                                <td>${sgst_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value2_3}</td>
                                                                                <td>${insurance2_3}</td>
                                                                                <td>${insurance_after2_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after2_3}</td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                        </table>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${vendor_code3 != ''}">
                                                                        <td>
                                                                            <table>
                                                                            <tr>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                                <td style="width:60px">${total_value3_3}</td>
                                                                                <td style="width:60px">&nbsp;</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${discount_value3_3}</td>
                                                                                <td>${discount3_3}</td>
                                                                                <td>${discount_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${packing_value3_3}</td>
                                                                                <td>${packing3_3}</td>
                                                                                <td>${packing_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${freight_value3_3}</td>
                                                                                <td>${freight3_3}</td>
                                                                                <td>${freight_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${errection_value3_3}</td>
                                                                                <td>${errection3_3}</td>
                                                                                <td>${errection_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${charges_value13_3}</td>
                                                                                <td>${charges3_3}</td>
                                                                                <td>${charges_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${igst_value3_3}</td>
                                                                                <td>${igst3_3}</td>
                                                                                <td>${igst_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${cgst_value3_3}</td>
                                                                                <td>${cgst3_3}</td>
                                                                                <td>${cgst_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${sgst_value3_3}</td>
                                                                                <td>${sgst3_3}</td>
                                                                                <td>${sgst_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_value3_3}</td>
                                                                                <td>${insurance3_3}</td>
                                                                                <td>${insurance_after3_3}</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>${insurance_after3_3}</td>
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_3}" varStatus="status">
                                                                                    <tr>
                                                                                        <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                                        <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                                        
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                           
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                           
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem22_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                           
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem23_3}" varStatus="status">
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
                                                            </table>														<table id="table_122" class="table table-bordered" style="" align="Center"  >
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail21_3}" varStatus="status">
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

                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                
                                                                    <tr>
                                                                        <td style="padding: 0px;">
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                
                                                                                <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_3}" varStatus="status">
                                                                                    <tr>
                                                                                        <td>${serviceVendorTenderBidItem2.srNo}</td>
                                                                                        <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                                        
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem21_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem22_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem23_3}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>Particlar<br>&nbsp;</th>
                                                                                    <th style="width:100px">Scheduled Amount<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_3}" varStatus="status">
                                                                                    <tr>
                                                                                        <td style="padding: 0px 0px;">${status.count}<br><br><br></td>
                                                                                        <td style="padding: 0px 0px;">${serviceVendorTenderBidItem31.particular}</td>
                                                                                        <td style="padding: 0px 0px;">
                                                                                            
                                                                                            ${serviceVendorTenderBidItem31.scheduledAmount}
                                                                                        </td>
                                                                                    </tr>
                                                                                </c:forEach>

                                                                            </table>
                                                                        
                                                                        </td>
                                                                        <c:if test="${vendor_code1 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem31" items="${serviceVendorTenderBidItem31_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem32" items="${serviceVendorTenderBidItem32_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Percentage<br><br><br></th>
                                                                                        <th style="width:60px">Percentage Rate</th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem33" items="${serviceVendorTenderBidItem33_3}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem41_3}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code2 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem42_3}" varStatus="status">
                                                                                                        <td${serviceVendorTenderBidItem4.perDayPerDay}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>


                                                                                </table>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${vendor_code3 != ''}">
                                                                            <td style="padding: 0px;width:180px">
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                        <th>${serviceVendorTenderBidItem4.securityName}</th>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.noOfPerson}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.wages}</td>
                                                                                        </c:forEach>    
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                            <td>${serviceVendorTenderBidItem4.percentage}</td>
                                                                                        </c:forEach>
                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.perTotal}</td>
                                                                                                </c:forEach>    
                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowance}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.allowanceTotal}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.uCharges}</td>
                                                                                                </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.sCharges}</td>
                                                                                                    </c:forEach>    

                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPDPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPMPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPYPP}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>

                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                        <td>${serviceVendorTenderBidItem4.perDayPerPerson}</td>
                                                                                                    </c:forEach>    
                                                                                        </tr>
                                                                                    </c:if>

                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPD}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tPM}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <tr>
                                                                                                <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
                                                                                                    <td>${serviceVendorTenderBidItem4.tDY}</td>
                                                                                                </c:forEach>    

                                                                                    </tr>
                                                                                    <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                        <tr>
                                                                                                    <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem43_3}" varStatus="status">
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
                                                                            <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                <tr>
                                                                                    <th>Sr.<br>&nbsp;</th>
                                                                                    <th>PC Type<br>&nbsp;</th>
                                                                                    <th>Item Description<br>&nbsp;</th>
                                                                                    <th>UOM<br>&nbsp;</th>
                                                                                    <th>QTY<br>&nbsp;</th>
                                                                                    <th>AMC Required Days<br>&nbsp;</th>
                                                                                </tr>

                                                                                <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem61" items="${serviceVendorTenderBidItem61_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem62" items="${serviceVendorTenderBidItem62_3}" varStatus="status">
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
                                                                                <table class="table table-bordered" style="padding:  0px;margin-bottom: 0px;">
                                                                                    <tr>
                                                                                        <th style="width:60px">Rate<br><br><br></th>
                                                                                        <th style="width:60px">Amount Total</th>
                                                                                    </tr>

                                                                                    <c:forEach var="serviceVendorTenderBidItem63" items="${serviceVendorTenderBidItem63_3}" varStatus="status">
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
                                        
                                        
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Tender Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${tender_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Tender Due Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${tender_due_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Sent From No. Of Vendor </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${total_vendor}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Received From No. Of Vendor </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${total_bid}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open Date </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_date}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open By </label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_by}
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <div class="col-sm-3">
                                                <label class="control-label" style="padding-top: 0px;">Bid Open By ID</label>
                                            </div>
                                            <div class="col-sm-3">
                                                ${bid_open_by_id}
                                            </div>
                                        </div>
                                        
                                        
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

