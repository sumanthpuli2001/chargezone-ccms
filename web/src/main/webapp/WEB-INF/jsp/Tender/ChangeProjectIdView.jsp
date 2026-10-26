
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender information</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=changeProjectIdSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Tender Information</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="refNo" id="refNo" class="form-control" value="${refNo}"  maxlength="30" required="true"/>           


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Tender No</label>
                                    <input type="text" class="input-field" readonly="true"  value="${tenderMaster.refNo}" />


                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Project Name</label>
                                    <input type="text" class="input-field" readonly="true"  value="${prMaster.title}" />


                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Project ID</label>
                                    <input type="text" name="projectId" id="projectId" class="input-field" value="${prMaster.projectId}"  maxlength="30" required="true"/>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>PR No</label>
                                    <input type="text"  class="input-field" value="${refNo}"  maxlength="30" readonly="true"/>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Budget Amount</label>
                                    <input type="text" name="value" id="value" value="${value1}" class="input-field"  onKeyUp="change(this.id, event);
                                            return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" maxlength="200" required="required"/> 

                                </div>
                            </div>
                            <script language="javascript" type="text/javascript">

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
                                    var classification = document.form.categoryId.value;
                                    var value = document.form.value.value;
                                    var i1 = 0;
                                    while (i1 < document.form.classificationName.length)
                                    {
                                        var classificationName = document.form.classificationName[i1].value;
                                        var prValue = document.form.prValue[i1].value;
                                        var bidRequired = document.form.bidRequired[i1].value;
                                        if (classification == classificationName)
                                        {
                                            if (parseFloat(value) >= parseFloat(prValue))
                                            {
                                                document.form.quotes.value = bidRequired;
                                                break;
                                            }
                                        }
                                        i1++;
                                    }

                                }
                            </script>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Single Quote attachment</label>
                                    <div>
                                        <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&RefNo=${refNo}&fileName=${singleQuoteAttachment}">
                                            <span>${singleQuoteAttachment}</span>
                                        </a>

                                        <input type="file" id="singleQuoteAttachment" name="singleQuoteAttachment" class="input-field">

                                        <input type="hidden" name="singleQuoteAttachment1" value="${singleQuoteAttachment}" id="singleQuoteAttachment1">
                                    </div>

                                </div>
                            </div>                            



                        </div>
                    </div>

                    <div class="form-group">
                                <h6 class="fw-600">Tender Contact Person</h6>
                            </div>

                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created by</label>
                                        <p class="fw-600">${tenderMaster.contactPerson}</p>

                                    </div>
                                </div>
                                
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>End User Name</label>
                                        <p class="fw-600">${tenderMaster.endUserName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>End User No</label>
                                        <p class="fw-600">${tenderMaster.endUserNumber}</p>
                                    </div>
                                </div>


                            </div>
                        </div>  
                    </div>



                    <div class="form-group">
                                <h6 class="fw-600">Item Details</h6>
                            </div>

                    <table id="commonNoPageTable" class="table table-striped bg-white" style="width: 100%" align="Center"  >

                        <thead>
                            <tr>
                                <th>Sr. No.</th>
                                <th  style="min-width: 180px;">Item Code</th>
                                <th style="min-width: 530px;">Item Description</th>
                                <th style="min-width: 180px;">Purpose</th>
                                <th style="min-width: 180px;">Make</th>
                                <th style="min-width: 180px;">UOM</th>
                                <th >Qty</th>

                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>

                            <c:forEach var="TenderItemMaster1" items="${TenderItemMaster1}" varStatus="status">

                                <tr>
                                    <td>${TenderItemMaster1.srNo}</td>
                                    <td>${TenderItemMaster1.itemCode}</td>
                                    <td>${TenderItemMaster1.itemDescription}</td>
                                    <td>${TenderItemMaster1.deliveryScheduleQty}</td>
                                    <td>${TenderItemMaster1.deliveryScheduleDate}</td>
                                    <td>${TenderItemMaster1.uom}</td>
                                    <td>${TenderItemMaster1.qty}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                    <c:if test="${tenderMaster.type == 'Contract'  || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">        

                        <c:if test="${tenderMaster.type == 'Contract Civil'}">
                            <div class="form-group">
                                <h6 class="fw-600">Steel Details</h6>
                            </div>
                        </c:if>
                        <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                           <div class="form-group">
                                <h6 class="fw-600">Item Details</h6>
                            </div>
                        </c:if>
                        <hr>
                        <table id="commonNoPageTable0" class="table  table-striped bg-white" style="width: 100%" align="Center"  >

                            <thead>
                                <tr>
                                    <th>Sr. No.</th>
                                    <th style="min-width: 180px;">Item Code</th>
                                    <th style="min-width: 530px;">Item Description</th>
                                    <th  style="min-width: 180px;">Purpose</th>
                                    <th style="min-width: 180px;">Make</th>
                                    <th style="min-width: 180px;">UOM</th>
                                    <th >Qty</th>

                                </tr>
                            </thead>
                            <c:set var="count" value="0" scope="page" />
                            <tbody>

                                <c:forEach var="TenderItemMaster2" items="${TenderItemMaster2}" varStatus="status">

                                    <tr>
                                        <td>${TenderItemMaster2.srNo}</td>
                                        <td>${TenderItemMaster2.itemCode}</td>
                                        <td>${TenderItemMaster2.itemDescription}</td>
                                        <td>${TenderItemMaster2.deliveryScheduleQty}</td>
                                        <td>${TenderItemMaster2.deliveryScheduleDate}</td>
                                        <td>${TenderItemMaster2.uom}</td>
                                        <td>${TenderItemMaster2.qty}</td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>


                    </c:if> 

                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">


                            <button type="submit" class="btn theme-btn" style="width: 150px!important;" >Submit</button>

                        </div>
                    </div>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
