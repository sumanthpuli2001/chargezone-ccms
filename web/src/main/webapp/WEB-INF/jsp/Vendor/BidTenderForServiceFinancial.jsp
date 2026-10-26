
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Bid</title>
        
      
        <style type="text/css">
            h1{
                font-weight: bold;
            }
            h4{
                font-weight: bold;
            }
            .form-group{
                font-size: 14px;
            }
        </style>
    </head>
    <body>
        
    <main class="d-flex align-items-end justify-content-end">
         <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
         <section class="main-content">
            <form:form action="vendor.htm?act=bidTenderForServiceFinancialSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Financial Bid</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        <!--<button type="submit" class="btn theme-btn">SAVE AND NEXT</button>-->
                    </div>
                </div>

                <hr>

               <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div> 
                
                <br>
                <input type="hidden" name="tenderItemMasterCount" id="tenderItemMasterCount" value="${tenderItemMasterCount}">
                 <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                 <input type="hidden" name="refNo" id="refNo" value="${tenderMaster.refNo}">

                <div class="card-box rounded-3 mb-4 pt-3 pb-2">
                        <div class="row buyer-info">

                            <!-- Row 1 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Number</label>
                                <div class="fw-600">${tenderMaster.refNo}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Project Name</label>
                                <div class="fw-600">${tenderMaster.title}</div>
                            </div>
                            
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Revision :</label>
                                 <div class="fw-600">${rivision}</div>
                            </div>
                            
                            
                            <!-- Row 2 -->
                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Date</label>
                                <div class="fw-600">${tenderMaster.announceDate}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Due Date</label>
                                <div class="fw-600">${tenderMaster.submitLastdate}</div>
                            </div>

                            <div class="col-lg-4 col-md-4 pb-2">
                                <label class="text-muted">Tender Subject Description</label>
                                <div class="fw-600">${tenderMaster.workDesc}</div>
                            </div>
                             
                            <div class="col-lg-8 col-md-4 pb-2">
                                <label class="text-muted">Tender Remark</label>
                                <div class="fw-600">${tenderMaster.tenderRemark}</div>
                            </div>
                     </div>
                    </div>
                       <h5 class="fw-600">Tender Contact Person</h5> 

                    <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                        <div class="row buyer-info">

                            <!-- Created By -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>Created By</label>
                                    <p class="fw-600">${tenderMaster.contactPerson}</p>
                                </div>
                            </div>

                            <!-- Contact Number -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">Contact Number</label>
                                    <a href="tel:${tenderAdminContactNumber}"
                                       class="fw-600 fs-13">${tenderMaster.tenderAdminContactNumber}</a>
                                </div>
                            </div>

                            <!-- End User Name -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label>End User Name</label>
                                    <p class="fw-600">${tenderMaster.endUserName}</p>
                                </div>
                            </div>

                            <!-- End User Contact No -->
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="d-block">End User Contact No</label>
                                    <a href="tel:${endUserNumber}"
                                       class="fw-600 fs-13">${tenderMaster.endUserNumber}</a>
                                </div>
                            </div>
                          
                        </div>
                    </div>      
                            
                    <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">

                                        <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                            <h5 class="fw-600">Steel Details</h5>
                                        </c:if>
                                        <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                            <h5 class="fw-600">Item Details For Service</h5> 
                                        </c:if>

                                    </c:if>    
                                            <div class="table-responsive">
                      <table id="commonDocTable" class="table  table-striped bg-white dt-scroll"  style="width: 100%" align="Center"  >
                                            <thead>
                                                <tr>
                                                    <th>Sr No.</th>
                                                    <th style="min-width: 190px;">Item Code</th>
                                                    <th style="min-width: 530px;" >Item Description</th>
                                                    <th style="min-width: 190px;">Purpose</th>
                                                    <th style="min-width: 190px;">Make</th>
                                                    <th style="min-width: 150px;">Quantity</th>
                                                    <th style="min-width: 150px;">UOM</th>
                                                    <th style="min-width: 150px;">Unit Rate</th>
                                                    <th style="min-width: 150px;">Amount</th>
                                                    <th>Make / Model</th>
                                                    <th style="min-width: 150px;">HSN / SAC Code</th>
                                                        <c:if test="${tenderMaster.tenderPhase == 1}">
                                                        <th>Regret</th>
                                                        </c:if>                                              
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:choose>
                                                    <c:when test="${empty vendorTenderBidItem}">

                                                        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                                            <tr>
                                                                <td>${tenderItemMaster.srNo} </td>
                                                                <td>${tenderItemMaster.itemCode} </td>
                                                                <td>${tenderItemMaster.itemDescription} </td>
                                                                <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                                                <td>${tenderItemMaster.deliveryScheduleQty}</td>

                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input type="hidden" name="qty" class="input-field" value="0" >
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input type="text" name="qty" class="input-field" value="${tenderItemMaster.qty}" required="true" readonly="true">
                                                                    </c:if>

                                                                </td>
                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input type="hidden" name="uom" class="input-field" value="">
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input type="text" name="uom" class="input-field" value="${tenderItemMaster.uom}" required="true" readonly="true">
                                                                    </c:if>

                                                                </td>

                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input type="hidden" name="unit_rate" class="input-field" value="0" >
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input type="text" name="unit_rate" class="input-field" value="" required="true" onKeyUp="change(this.id, event);
                                                                                return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" style="width: 100px;">
                                                                    </c:if>

                                                                </td>
                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input type="hidden" name="net_rate" class="input-field" value="0" >
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input type="text" name="net_rate" class="input-field" value="" required="true" readonly="true">
                                                                    </c:if>

                                                                </td>

                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input type="hidden" name="vendor_remark" class="input-field" value="" >
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input type="text" name="vendor_remark" class="input-field" value="" style="width: 100px;" required="true">
                                                                    </c:if>

                                                                </td>
                                                                <td>
                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                        <input name="hsn_no" type="hidden" class="input-field" style="width:100%;" value="${tenderItemMaster.hsnNo}" >
                                                                    </c:if>
                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                        <input name="hsn_no" type="text" class="input-field" style="width:100%;" value="${tenderItemMaster.hsnNo}" required="true" minlength="6">
                                                                    </c:if>
                                                                </td>
                                                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                                                    <td>
                                                                        <c:if test="${tenderItemMaster.uom == ''}">
                                                                            <input name="Regret" type="hidden" Id="${status.count}" class="input-field" style="width:100%;" value="Regret" onClick="return itemcal1();
                                                                                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                        </c:if>
                                                                        <c:if test="${tenderItemMaster.uom != ''}">
                                                                            <input name="Regret" type="button" Id="${status.count}" class="input-field" style="width:100%;" value="Regret" onClick="return itemcal1();
                                                                                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                        </c:if>

                                                                    </td>

                                                                </c:if>
                                                                <!-- <td>
                                                                <%--<c:if test="${tenderItemMaster.uom != ''}">--%>
                                                                    <input type="button" name="itemsubmit" class="input-field"  value="Tax Details" id="${status.count}" onClick="check(this.id);" />
                                                                <%--</c:if>--%>
                                                                
                                                            </td> -->
                                                        <input type="hidden" name="item_discount_val"  value="0" >
                                                        <input type="hidden" name="item_discount"  value="0" >
                                                        <input type="hidden" name="item_packing_val"  value="0" >
                                                        <input type="hidden" name="item_packing"  value="0" >
                                                        <input type="hidden" name="item_freight_val"  value="0" >
                                                        <input type="hidden" name="item_freight"  value="0" >
                                                        <input type="hidden" name="item_errection"  value="0" >
                                                        <input type="hidden" name="item_other_charges"  value="0" >
                                                        <input type="hidden" name="item_igst"  value="0" >
                                                        <input type="hidden" name="item_cgst"  value="0" >
                                                        <input type="hidden" name="item_sgst"  value="0" >
                                                        <input type="hidden" name="item_insurance_value"  value="0" >
                                                        <input type="hidden" name="item_total"  value="0" >
                                                        <input type="hidden" name="item_regret"  value="0" >
                                                        <input type="hidden" name="item_code"  value="${tenderItemMaster.itemCode}" >
                                                        <input type="hidden" name="item_description"  value='${tenderItemMaster.itemDescription}' >
                                                        <input type="hidden" name="item_remark"  value='${tenderItemMaster.remark}' >
                                                        <input type="hidden" name="attachment_required"  value="${tenderItemMaster.attachmentRequired}" >
                                                        <input type="hidden" name="delivery_schedule_date"  value='${tenderItemMaster.deliveryScheduleDate}' >
                                                        <input type="hidden" name="delivery_schedule_qty"  value='${tenderItemMaster.deliveryScheduleQty}'>
                                                        <input type="hidden" name="item_location"  value="${tenderItemMaster.location}" >
                                                        <input type="hidden" name="pur_no"  value="${tenderItemMaster.purNo}" >
                                                        <input type="hidden" name="item_no"  value="${tenderItemMaster.itemNo}" >
                                                        <input type="hidden" name="sr_no"  value="${tenderItemMaster.srNo}" >
                                                        <input type="hidden" name="pr_no"  value="${tenderItemMaster.prNo}" >
                                                        </tr>
                                                    </c:forEach>
                                                </c:when>

                                                <c:otherwise>
                                                    <c:forEach var="vendorTenderBidItem" items="${vendorTenderBidItem}" varStatus="status">
                                                        <tr>
                                                            <td>${vendorTenderBidItem.srNo}</td>
                                                            <td>${vendorTenderBidItem.itemCode}</td>
                                                            <td>${vendorTenderBidItem.itemDescription}</td>
                                                            <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                                            <td>${vendorTenderBidItem.deliveryScheduleQty}</td>
                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input type="hidden" name="qty" class="input-field" value="0" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input type="text" name="qty" class="input-field" value="${vendorTenderBidItem.qty}" required="true" readonly="true">
                                                                </c:if>

                                                            </td>
                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input type="hidden" name="uom" class="input-field" value="" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input type="text" name="uom" class="input-field" value="${vendorTenderBidItem.uom}" required="true" readonly="true">
                                                                </c:if>

                                                            </td>


                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input type="hidden" name="unit_rate" class="input-field" value="0" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input type="text" name="unit_rate" class="input-field" value="${vendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event);
                                                                            return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" style="width: 100px;">
                                                                </c:if>

                                                            </td>
                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input type="hidden" name="net_rate" class="input-field" value="0" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input type="text" name="net_rate" class="input-field" value="${vendorTenderBidItem.netRate}" required="true" readonly="true">
                                                                </c:if>

                                                            </td>

                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input type="hidden" name="vendor_remark" class="input-field" value="" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input type="text" name="vendor_remark" class="input-field" value="${vendorTenderBidItem.vendorRemark}" style="width: 100px;" required="true">
                                                                </c:if>

                                                            </td>
                                                            <td>
                                                                <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                    <input name="hsn_no" type="hidden" class="input-field" style="width:100%;" value="${vendorTenderBidItem.hsnNo}" >
                                                                </c:if>
                                                                <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                    <input name="hsn_no" type="text" class="input-field" style="width:100%;" value="${vendorTenderBidItem.hsnNo}" required="true">
                                                                </c:if>
                                                            </td>
                                                            <c:if test="${tenderMaster.tenderPhase == 1}">
                                                                <td>
                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                        <input name="Regret" type="hidden" Id="${status.count}" class="input-field" style="width:100%;" value="Regret" onClick="return itemcal1();
                                                                                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                    </c:if>
                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                        <input name="Regret" type="button" Id="${status.count}" class="input-field" style="width:100%;" value="Regret" onClick="return itemcal1();
                                                                                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                    </c:if>

                                                                </td>
                                                            </c:if>
                                                            <!--<td>
                                                                
                                                            <%--<c:if test="${vendorTenderBidItem.uom != ''}">--%>
                                                                <input type="button" name="itemsubmit" class="input-field"  value="Tax Details" id="${status.count}" onClick="check(this.id);" />
                                                            <%--</c:if>--%>
                                                            
                                                        </td> -->
                                                        <input type="hidden" name="item_discount_val"  value="${vendorTenderBidItem.discountType}" >
                                                        <input type="hidden" name="item_discount"  value="${vendorTenderBidItem.discountValue}" >
                                                        <input type="hidden" name="item_packing_val"  value="${vendorTenderBidItem.packingType}" >
                                                        <input type="hidden" name="item_packing"  value="${vendorTenderBidItem.packingValue}" >
                                                        <input type="hidden" name="item_freight_val"  value="${vendorTenderBidItem.freightType}" >
                                                        <input type="hidden" name="item_freight"  value="${vendorTenderBidItem.freightValue}" >
                                                        <input type="hidden" name="item_errection"  value="${vendorTenderBidItem.errectionValue}" >
                                                        <input type="hidden" name="item_other_charges"  value="${vendorTenderBidItem.chargesValue}" >
                                                        <input type="hidden" name="item_igst"  value="${vendorTenderBidItem.igstValue}" >
                                                        <input type="hidden" name="item_cgst"  value="${vendorTenderBidItem.cgstValue}" >
                                                        <input type="hidden" name="item_sgst"  value="${vendorTenderBidItem.sgstValue}" >
                                                        <input type="hidden" name="item_insurance_value"  value="${vendorTenderBidItem.insuranceValue}" >
                                                        <input type="hidden" name="item_total"  value="${vendorTenderBidItem.totalValue}" >
                                                        <input type="hidden" name="item_regret"  value="${vendorTenderBidItem.itemRegret}" >
                                                        <input type="hidden" name="item_code"  value="${vendorTenderBidItem.itemCode}" >
                                                        <input type="hidden" name="item_description"  value='${vendorTenderBidItem.itemDescription}' >
                                                        <input type="hidden" name="item_remark"  value='${vendorTenderBidItem.remark}' >
                                                        <input type="hidden" name="attachment_required"  value="${vendorTenderBidItem.attachmentRequired}" >
                                                        <input type="hidden" name="delivery_schedule_date"  value='${vendorTenderBidItem.deliveryScheduleDate}' >
                                                        <input type="hidden" name="delivery_schedule_qty"  value='${vendorTenderBidItem.deliveryScheduleQty}' >
                                                        <input type="hidden" name="item_location"  value="${vendorTenderBidItem.location}" >
                                                        <input type="hidden" name="pur_no"  value="${vendorTenderBidItem.purNo}" >
                                                        <input type="hidden" name="item_no"  value="${vendorTenderBidItem.itemNo}" >
                                                        <input type="hidden" name="sr_no"  value="${vendorTenderBidItem.srNo}" >
                                                        <input type="hidden" name="pr_no"  value="${vendorTenderBidItem.prNo}" >
                                                        </tr>
                                                    </c:forEach>       
                                                </c:otherwise>

                                            </c:choose>
 </tbody>
 <tfoot>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>Total</td>
                                                <td>
                                                     <input type="text" name="total_amount" class="input-field"
                                                       value="<fmt:formatNumber value='${item_total}' minFractionDigits='2' maxFractionDigits='2' />"
                                                       required="true" readonly="true">
                                                </td>
                                                <td></td>
                                                <td></td>
                                                <c:if test="${tenderMaster.tenderPhase == 1}">
                                                <td></td>
                                                </c:if>
                                            </tr>
                                           
</tfoot>

                                        </table>  
                                            </div>
                                                
                                                <br>
                                                <h5 class="fw-600">  Taxes & Other Details  </h5>
                                
                                                <div>
                                    <input type="hidden" name="common_tax" value="1"   onClick="admsg();
                                            return itemcal(1);" />



                                    <input type="hidden" name="packing_val" value="0" />
                                    <input type="hidden" name="packing" value="0" />
                                    <input type="hidden" name="other_charges" value="0" />
                                    <input type="hidden" name="insurance_value" value="0" />
                                    <input type="hidden" name="errection" value="0" />
                                    <input type="hidden" name="discount_val" value="0" />
                                    <input type="hidden" name="discount1" value="0" />
                                    <input type="hidden" name="discount" value="0" />
                                    <input type="hidden" name="discount2" value="0" />



                                    <div class="form-group row align-items-center">


                                        <label class="col-sm-2 control-label">
                                            GST (%) <span style="color:red;font-size:12px;">*</span>
                                        </label>
                                        <div class="col-sm-4">
                                            <input name="igst" value="${igst_value}" class="input-field" onKeyUp="change(this.id, event);
                                                    return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input name="igst1"  class="input-field"  readonly="true"/>
                                        </div>
                                    </div>

                                    <input type="hidden" name="cgst" value="0" class="input-field" maxlength="30" required/>
                                    <input type="hidden" name="sgst" value="0" class="input-field" maxlength="30" required/>

                                    <div class="form-group row align-items-center">


                                        <label class="col-sm-2 control-label">
                                            <label class="control-label">Total <span style="color: red;font-size: 12px;">*</span></label>

                                        </label>


                                        <div class="col-sm-4">
                                            <input name="grand_total" value="${grand_total}" class="input-field"   maxlength="30" required readonly="true"/>

                                        </div>

</div>
                                            <br>

                 <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn">SAVE AND NEXT</button>
                        </div>
                    </div>                   
                                    
                
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
 <body onLoad="return itemcal(1);" >
</body>
  <script language="javascript" type="text/javascript">


            function admsg()
            {
                //   alert("a");
            }

            function isNumberKey(evt)
            {
                var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode == 46)
                {
                    return true
                }
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;

                return true;
            }

            function itemcal(a)
            {
                //    alert("");



                var i1 = 0;
                var j1 = 1;
                var k1 = 0;
                var total = 0;
                var grand_total = 0;
                if (document.form.unit_rate.length == null)
                {
                    document.form.net_rate.value = (document.form.unit_rate.value * document.form.qty.value).toFixed(2);
                    if (document.form.net_rate.value == 'NaN')
                    {
                        document.form.unit_rate.value = '';
                        document.form.net_rate.value = '0';
                    }
                    total = document.form.unit_rate.value * document.form.qty.value;
                }
                while (i1 < document.form.unit_rate.length)
                {
                    document.form.net_rate[i1].value = (document.form.unit_rate[i1].value * document.form.qty[i1].value).toFixed(2);
                    if (document.form.net_rate[i1].value == 'NaN')
                    {
                        document.form.unit_rate[i1].value = '';
                        document.form.net_rate[i1].value = '0';
                    }
                    total = total + document.form.unit_rate[i1].value * document.form.qty[i1].value;
                    i1++;
                    j1++;
                }

                document.form.total_amount.value = total.toFixed(2);



                if (document.form.common_tax.value == 1)
                {
                    grand_total = total;



                    var packing_val = document.form.packing_val.value;
                    var packing = document.form.packing.value;
                    if (packing_val == "")
                    {
                        packing_val = 0;
                    }
                    if (packing == "")
                    {
                        packing = 0;
                    }
                    if (packing_val == 0)
                    {
                        packing = grand_total * packing / 100;
                    }
                    else
                    {

                    }


                    var other_charges = document.form.other_charges.value;
                    if (other_charges == "")
                    {
                        other_charges = 0;
                    }

                    var insurance_value = document.form.insurance_value.value;
                    if (insurance_value == "")
                    {
                        insurance_value = 0;
                    }

                    var errection = document.form.errection.value;
                    if (errection == "")
                    {
                        errection = 0;
                    }
                    //   grand_total = grand_total + parseFloat((grand_total * errection / 100));
                    //   grand_total = grand_total + parseFloat((grand_total * insurance_value / 100));

                    //  grand_total = grand_total + parseFloat((grand_total * other_charges / 100));


                    grand_total = grand_total + parseFloat(packing) + parseFloat((grand_total * other_charges / 100)) + parseFloat((grand_total * insurance_value / 100)) + parseFloat((grand_total * errection / 100));



                    var discount_val = document.form.discount_val.value;
                    var discount = document.form.discount.value;

                    if (discount_val == "")
                    {
                        discount_val = 0;
                    }
                    if (discount == "")
                    {
                        discount = 0;
                    }
                    if (discount_val == 0)
                    {
                        discount = grand_total * discount / 100;
                    }
                    else
                    {

                    }

                    document.form.discount1.value = discount;
                    grand_total = grand_total - discount;
                    if (document.form.discount1.value == 'NaN')
                    {
                        document.form.discount.value = '';
                        document.form.discount1.value = '0';
                    }

                    document.form.discount2.value = grand_total;


                    var igst = document.form.igst.value;
                    if (igst == "")
                    {
                        igst = 0;
                    }
                    igst = grand_total * igst / 100;

                    var cgst = document.form.cgst.value;
                    if (cgst == "")
                    {
                        cgst = 0;
                    }
                    cgst = grand_total * cgst / 100;

                    var sgst = document.form.sgst.value;
                    if (sgst == "")
                    {
                        sgst = 0;
                    }
                    sgst = grand_total * sgst / 100;

                    document.form.igst1.value = igst.toFixed(2);

                    if (document.form.igst1.value == 'NaN')
                    {
                        document.form.igst.value = '';
                        document.form.igst1.value = '0';
                    }

                    grand_total = grand_total + parseFloat(igst) + parseFloat(cgst) + parseFloat(sgst);


                    document.form.grand_total.value = grand_total.toFixed(2);
                }
                else
                {
                    //item wise tax calculation
                    i1 = 0;
                    j1 = 1;
                    k1 = 0;
                    var item_total = 0;
                    var item_total1 = 0;
                    if (document.form.unit_rate.length == null)
                    {
                        document.form.net_rate.value = document.form.unit_rate.value * document.form.qty.value;
                        item_total = document.form.unit_rate.value * document.form.qty.value;

                        var item_discount_val = document.form.item_discount_val.value;
                        var item_discount = document.form.item_discount.value;
                        var item_packing_val = document.form.item_packing_val.value;
                        var item_packing = document.form.item_packing.value;
                        var item_freight_val = document.form.item_freight_val.value;
                        var item_freight = document.form.item_freight.value;
                        var item_errection = document.form.item_errection.value;
                        var item_other_charges = document.form.item_other_charges.value;
                        var item_igst = document.form.item_igst.value;
                        var item_cgst = document.form.item_cgst.value;
                        var item_sgst = document.form.item_sgst.value;
                        var item_insurance_value = document.form.item_insurance_value.value;

                        if (item_discount_val == "")
                        {
                            item_discount_val = 0;
                        }
                        if (item_discount == "")
                        {
                            item_discount = 0;
                        }
                        if (item_discount_val == 0)
                        {
                            item_discount = item_total * item_discount / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total - item_discount;

                        if (item_packing_val == "")
                        {
                            item_packing_val = 0;
                        }
                        if (item_packing == "")
                        {
                            item_packing = 0;
                        }
                        if (item_packing_val == 0)
                        {
                            item_packing = item_total * item_packing / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total + parseFloat(item_packing);

                        if (item_freight_val == "")
                        {
                            item_freight_val = 0;
                        }
                        if (item_freight == "")
                        {
                            item_freight = 0;
                        }
                        if (item_freight_val == 0)
                        {
                            item_freight = item_total * item_freight / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total + parseFloat(item_freight);


                        if (item_errection == "")
                        {
                            item_errection = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_errection / 100));

                        if (item_other_charges == "")
                        {
                            item_other_charges = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_other_charges / 100));

                        if (item_igst == "")
                        {
                            item_igst = 0;
                        }
                        item_igst = item_total * item_igst / 100;

                        if (item_cgst == "")
                        {
                            item_cgst = 0;
                        }
                        item_cgst = item_total * item_cgst / 100;

                        if (item_sgst == "")
                        {
                            item_sgst = 0;
                        }
                        item_sgst = item_total * item_sgst / 100;

                        item_total = item_total + parseFloat(item_igst) + parseFloat(item_cgst) + parseFloat(item_sgst);

                        if (item_insurance_value == "")
                        {
                            item_insurance_value = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_insurance_value / 100));


                        item_total1 = item_total1 + item_total;
                    }
                    while (i1 < document.form.unit_rate.length)
                    {

                        document.form.net_rate[i1].value = document.form.unit_rate[i1].value * document.form.qty[i1].value;
                        item_total = document.form.unit_rate[i1].value * document.form.qty[i1].value;
                        var item_discount_val = document.form.item_discount_val[i1].value;
                        var item_discount = document.form.item_discount[i1].value;
                        var item_packing_val = document.form.item_packing_val[i1].value;
                        var item_packing = document.form.item_packing[i1].value;
                        var item_freight_val = document.form.item_freight_val[i1].value;
                        var item_freight = document.form.item_freight[i1].value;
                        var item_errection = document.form.item_errection[i1].value;
                        var item_other_charges = document.form.item_other_charges[i1].value;
                        var item_igst = document.form.item_igst[i1].value;
                        var item_cgst = document.form.item_cgst[i1].value;
                        var item_sgst = document.form.item_sgst[i1].value;
                        var item_insurance_value = document.form.item_insurance_value[i1].value;

                        if (item_discount_val == "")
                        {
                            item_discount_val = 0;
                        }
                        if (item_discount == "")
                        {
                            item_discount = 0;
                        }
                        if (item_discount_val == 0)
                        {
                            item_discount = item_total * item_discount / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total - item_discount;

                        if (item_packing_val == "")
                        {
                            item_packing_val = 0;
                        }
                        if (item_packing == "")
                        {
                            item_packing = 0;
                        }
                        if (item_packing_val == 0)
                        {
                            item_packing = item_total * item_packing / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total + parseFloat(item_packing);

                        if (item_freight_val == "")
                        {
                            item_freight_val = 0;
                        }
                        if (item_freight == "")
                        {
                            item_freight = 0;
                        }
                        if (item_freight_val == 0)
                        {
                            item_freight = item_total * item_freight / 100;
                        }
                        else
                        {

                        }
                        item_total = item_total + parseFloat(item_freight);


                        if (item_errection == "")
                        {
                            item_errection = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_errection / 100));

                        if (item_other_charges == "")
                        {
                            item_other_charges = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_other_charges / 100));

                        if (item_igst == "")
                        {
                            item_igst = 0;
                        }
                        item_igst = item_total * item_igst / 100;

                        if (item_cgst == "")
                        {
                            item_cgst = 0;
                        }
                        item_cgst = item_total * item_cgst / 100;

                        if (item_sgst == "")
                        {
                            item_sgst = 0;
                        }
                        item_sgst = item_total * item_sgst / 100;

                        item_total = item_total + parseFloat(item_igst) + parseFloat(item_cgst) + parseFloat(item_sgst);

                        if (item_insurance_value == "")
                        {
                            item_insurance_value = 0;
                        }
                        item_total = item_total + parseFloat((item_total * item_insurance_value / 100));


                        item_total1 = item_total1 + item_total




                        i1++;
                        j1++;
                    }

                    grand_total = item_total1;
                    document.form.grand_total.value = grand_total.toFixed(2);


                }

                var freight_val = document.form.freight_val.value;
                var freight = document.form.freight.value;
                if (freight_val == "")
                {
                    freight_val = 0;
                }
                if (freight == "")
                {
                    freight = 0;
                }
                if (freight_val == 0)
                {
                    freight = grand_total * freight / 100;
                    document.form.freight1.value = freight.toFixed(2);
                }
                else
                {
                    document.form.freight1.value = freight;
                }



                test_skill(grand_total.toFixed(2));
            }









            function test_skill(aa) {
                //alert(form.vendor_grand_total.value);

                var junkVal = aa;

                var mytool_array = junkVal.split(".");

                junkVal = Math.floor(junkVal);
                var obStr = new String(junkVal);
                numReversed = obStr.split("");
                actnumber = numReversed.reverse();

                if (Number(junkVal) >= 0) {
                    //do nothing
                }
                else {
                    alert('wrong Number cannot be converted');
                    return false;
                }
                if (Number(junkVal) == 0) {
                    //document.getElementById('container').innerHTML=obStr+''+'Rupees Zero Only';
                    return false;
                }
                if (actnumber.length > 9) {
                    alert('Oops!!!! the Number is too big to covertes');
                    return false;
                }

                var iWords = ["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
                var ePlace = ['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];
                var tensPlace = ['dummy', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety'];

                var iWordsLength = numReversed.length;
                var totalWords = "";
                var inWords = new Array();
                var finalWord = "";
                j = 0;
                for (i = 0; i < iWordsLength; i++) {
                    switch (i)
                    {
                        case 0:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            inWords[j] = inWords[j] + ' Point ';
                            break;
                        case 1:
                            tens_complication();
                            break;
                        case 2:
                            if (actnumber[i] == 0) {
                                inWords[j] = '';
                            }
                            else if (actnumber[i - 1] != 0 && actnumber[i - 2] != 0) {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred and';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred';
                            }
                            break;
                        case 3:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Thousand";
                            }
                            break;
                        case 4:
                            tens_complication();
                            break;
                        case 5:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Lakh";
                            }
                            break;
                        case 6:
                            tens_complication();
                            break;
                        case 7:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            inWords[j] = inWords[j] + " Crore";
                            break;
                        case 8:
                            tens_complication();
                            break;
                        default:
                            break;
                    }
                    j++;
                }


                function tens_complication() {
                    if (actnumber[i] == 0) {
                        inWords[j] = '';
                    }
                    else if (actnumber[i] == 1) {
                        inWords[j] = ePlace[actnumber[i - 1]];
                    }
                    else {
                        inWords[j] = tensPlace[actnumber[i]];
                    }
                }
                inWords.reverse();
                for (i = 0; i < inWords.length; i++) {
                    finalWord += inWords[i];
                }


                var a = finalWord;
                //document.getElementById('container').innerHTML=obStr+'  '+finalWord;


                var abcd = mytool_array[1];
                junkVal = Math.floor(abcd);
                var obStr = new String(abcd);
                numReversed = obStr.split("");
                actnumber = numReversed.reverse();

                if (Number(junkVal) >= 0) {
                    //do nothing
                }
                else {
                    alert('wrong Number cannot be converted');
                    return false;
                }
                if (Number(junkVal) == 0) {
                    //     document.getElementById('container').innerHTML=obStr+''+'Rupees Zero Only';
                    //	document.getElementById('container1').innerHTML=a + ' Only';

                    var aaa = a + ' Only';
                    document.form.venodr_total_words.value = aaa;

                    return false;
                }
                if (actnumber.length > 9) {
                    alert('Oops!!!! the Number is too big to covertes');
                    return false;
                }

                var iWords = ["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
                var ePlace = ['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];
                var tensPlace = ['dummy', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety'];

                var iWordsLength = numReversed.length;
                var totalWords = "";
                var inWords = new Array();
                var finalWord = "";
                j = 0;
                for (i = 0; i < iWordsLength; i++) {
                    switch (i)
                    {
                        case 0:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            inWords[j] = inWords[j] + ' Only';
                            break;
                        case 1:
                            tens_complication();
                            break;
                        case 2:
                            if (actnumber[i] == 0) {
                                inWords[j] = '';
                            }
                            else if (actnumber[i - 1] != 0 && actnumber[i - 2] != 0) {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred and';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred';
                            }
                            break;
                        case 3:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Thousand";
                            }
                            break;
                        case 4:
                            tens_complication();
                            break;
                        case 5:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Lakh";
                            }
                            break;
                        case 6:
                            tens_complication();
                            break;
                        case 7:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            }
                            else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            inWords[j] = inWords[j] + " Crore";
                            break;
                        case 8:
                            tens_complication();
                            break;
                        default:
                            break;
                    }
                    j++;
                }

                function tens_complication() {
                    if (actnumber[i] == 0) {
                        inWords[j] = '';
                    }
                    else if (actnumber[i] == 1) {
                        inWords[j] = ePlace[actnumber[i - 1]];
                    }
                    else {
                        inWords[j] = tensPlace[actnumber[i]];
                    }
                }
                inWords.reverse();
                for (i = 0; i < inWords.length; i++) {
                    finalWord += inWords[i];
                }

                //	 document.getElementById('container1').innerHTML=a + ' And '+finalWord;

                var aaa = a + ' And ' + finalWord;
                document.form.venodr_total_words.value = aaa;


            }


            function check(id)
            {
                id = id - 1;

                var rate = form["unit_rate"];
                if (rate.length == null)
                {
                    var rate = form["unit_rate"];
                    //rate=document.form.rate.value;
                    //alert(rate);
                    if (form["unit_rate"].value == "0" || form["unit_rate"].value == "") {
                        //if(a.equals("0")){
                        alert('Please Enter Unit Amount');

                    }
                    else {
                        id = id + 1;
                        alert('To be filled only if Taxes & Duties are Different for Individual Items');
                        document.form.action = "vendor.htm?act=venderTenderItemDetail&id=" + id;
                        form.submit();
                    }

                }
                else {
                    //alert(form.elements["rate"][id].value);
                    if (form["unit_rate"][id].value == "0" || form["unit_rate"][id].value == "") {

                        alert('Please Enter Unit Amount');


                    }
                    else {
                        id = id + 1;
                        alert('To be filled only if Taxes & Duties are Different for Individual Items');
                        document.form.action = "vendor.htm?act=venderTenderItemDetail&id=" + id;
                        form.submit();
                    }


                }
            }





            function enable_text(a) {
                a = a - 1;
                var i = 0;

                var regret = form["Regret"];
                if (regret.length == null)
                {
                    if (form["Regret"].value == "Regret")
                    {
                        form["Regret"].value = "Bid";
                        form["item_regret"].value = '1';
                        form["unit_rate"].readOnly = true;
                        form["unit_rate"].value = '0';

                        form["item_discount_val"].value = 0;
                        form["item_discount"].value = 0;
                        form["item_packing_val"].value = 0;
                        form["item_packing"].value = 0;
                        form["item_freight_val"].value = 0;
                        form["item_freight"].value = 0;
                        form["item_errection"].value = 0;
                        form["item_other_charges"].value = 0;
                        form["item_igst"].value = 0;
                        form["item_cgst"].value = 0;
                        form["item_sgst"].value = 0;
                        form["item_insurance_value"].value = 0;
                        form["item_total"].value = 0;
                    }
                    else
                    {
                        form["Regret"].value = "Regret";

                        form["item_regret"].value = '0';
                        form["unit_rate"].readOnly = false;
                        form["unit_rate"].value = '0';

                    }
                }
                else
                {
                    if (form.elements["Regret"][a].value == "Regret")
                    {
                        form.elements["Regret"][a].value = "Bid";
                        form.elements["item_regret"][a].value = '1';
                        form.elements["unit_rate"][a].readOnly = true;
                        form.elements["unit_rate"][a].value = 0;

                        form.elements["item_discount_val"][a].value = 0;
                        form.elements["item_discount"][a].value = 0;
                        form.elements["item_packing_val"][a].value = 0;
                        form.elements["item_packing"][a].value = 0;
                        form.elements["item_freight_val"][a].value = 0;
                        form.elements["item_freight"][a].value = 0;
                        form.elements["item_errection"][a].value = 0;
                        form.elements["item_other_charges"][a].value = 0;
                        form.elements["item_igst"][a].value = 0;
                        form.elements["item_cgst"][a].value = 0;
                        form.elements["item_sgst"][a].value = 0;
                        form.elements["item_insurance_value"][a].value = 0;
                        form.elements["item_total"][a].value = 0;
                    }
                    else
                    {
                        form.elements["Regret"][a].value = "Regret";
                        form.elements["item_regret"][a].value = '0';
                        form.elements["unit_rate"][a].readOnly = false;
                        form.elements["unit_rate"][a].value = 0;
                    }

                }
            }





            function validation()
            {
                var i1 = 0;
                var j1 = 1;
                var k1 = 0;
                while (i1 < document.form.vendor_tech_desc.length)
                {
                    var cremark1 = '1techradion' + j1;
                    var cremark2 = '2techradion' + j1;
                    var cremark3 = '3techradion' + j1;
                    var vvv = 'tech_vendor_remark' + j1
                    if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true && document.getElementById(cremark3).checked != true)
                    {
                        alert("Please Select Technical Specification");
                        return false;
                    }
                    if (document.getElementById(cremark1).checked == false)
                    {
                        if (document.getElementById(vvv).value == '')
                        {
                            alert("Please add vendor remark");
                            return false;
                        }
                    }
                    i1++;
                    j1++;
                }


                i1 = 0;
                j1 = 1;
                k1 = 0;
                while (i1 < document.form.vendor_terms_desc.length)
                {
                    var cremark1 = '1termsradion' + j1;
                    var cremark2 = '2termsradion' + j1;
                    var cremark3 = '3termsradion' + j1;
                    var vvv = 'terms_vendor_remark' + j1
                    if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true && document.getElementById(cremark3).checked != true)
                    {
                        alert("Please Select Terms & Condition");
                        return false;
                    }
                    if (document.getElementById(cremark1).checked == false)
                    {
                        if (document.getElementById(vvv).value == '')
                        {
                            alert("Please add vendor remark");
                            return false;
                        }
                    }
                    i1++;
                    j1++;
                }
            }



        </script>
</html>
