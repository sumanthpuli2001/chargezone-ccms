
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item Details</title>
    </head>
     <script>
        function initDocTable(selector, obj = {}) {
            return $(selector).DataTable({
                paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                ...obj,
            });
        }
    </script>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=changeItemDetailsSubmit" method="post" enctype="multipart/form-data" 
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Item Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">           
 <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                 <div class="col-md-12 col-sm-12">
                                        

                                            <c:choose>
                                                <c:when test="${empty tenderItemMaster}">

                                                </c:when>
                                                <c:otherwise>

                                                    <c:set var="count" value="0" scope="page" />



                                                    <table id="policyTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="Center">
                                                        <thead>
                                                            <tr >
                                                                <th>Sr. No. <span style="color: red;font-size: 12px;" id="srNo">*</span></th>
                                                                <th >Item Code <span style="color: red;font-size: 12px;" id="itemCode">*</span> </th>
                                                                <th >Item Description <span style="color: red;font-size: 12px;" id="itemDescription">*</span></th>
                                                                <th  >Purpose <span style="color: red;font-size: 12px;" id="Purpose">*</span></th>
                                                                <th  >Make <span style="color: red;font-size: 12px;" id="itemDetails">*</span></th>
                                                                <th>UOM <span style="color: red;font-size: 12px;" id="UOM">*</span></th>
                                                                <th>Qty <span style="color: red;font-size: 12px;" id="QTY">*</span></th>
                                                                <th>GST <span style="color: red;font-size: 12px;" id="GST">*</span></th>
                                                                <th>Add New Item</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">

                                                                <tr>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                            <input type="hidden" name="id2" value="${tenderItemMaster.id}">
                                                            <td><input type="text" name="sr_no" class="input-field" value="${tenderItemMaster.srNo}"></td>
                                                            <td><input type="text" name="item_code" class="input-field" value="${tenderItemMaster.itemCode}"></td>
                                                            <td><input type="text" name="item_description" class="input-field" value="${tenderItemMaster.itemDescription}"></td>
                                                            <td><input type="text" name="purpose" class="input-field" value="${tenderItemMaster.deliveryScheduleQty}"></td>
                                                            <td><input type="text" name="remark" class="input-field" value="${tenderItemMaster.deliveryScheduleDate}"></td>
                                                            <td><input type="text" name="uom" class="input-field" value="${tenderItemMaster.uom}"></td>
                                                            <td><input type="text" name="qty" class="input-field" value="${tenderItemMaster.qty}"></td>
                                                            <td><input type="text" name="gst" class="input-field" value="${tenderItemMaster.gst}"></td>
                                                            <td></td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                           <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                                                <div class="clone-action clone-new-field mb-2"
                                                                     id="policyCloneid"
                                                                     style="cursor:pointer;"
                                                                     onclick="Policy();">
                                                                    <img src="StorageYard/assets/images/clone-btn.svg"
                                                                         onload="SVGInject(this)"
                                                                         alt="Clone Btn" />
                                                                </div>
                                                            </td>


                                                        </tr>



                                                        </tbody>
                                                    </table>



                                                

                                                </c:otherwise>
                                            </c:choose>






                                            <c:choose>
                                                <c:when test="${empty tenderItemMaster1}">

                                                </c:when>
                                                <c:otherwise>

                                                    <c:set var="count" value="0" scope="page" />

                                                    Service Item Details

                                                    <table id="table_2" class="table table-bordered" style="" align="Center">
                                                        <thead>
                                                            <tr>
                                                                <th>Sr. No.</th>
                                                                <th>Item Code</th>
                                                                <th>Item Description</th>
                                                                <th>Purpose </th>
                                                                <th>Make</th>
                                                                <th>UOM</th>
                                                                <th>Qty</th>
                                                                <th>GST</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster1}" varStatus="status1">

                                                                <tr>
                                                            <input type="hidden" name="policyCount1" id="policyCount1" value="1"/>
                                                            <input type="hidden" name="id1" value="${tenderItemMaster.id}">
                                                            <td><input type="text" name="sr_no1" class="input-field" value="${tenderItemMaster.srNo}"></td>
                                                            <td><input type="text" name="item_code1" class="input-field" value="${tenderItemMaster.itemCode}"></td>
                                                            <td><input type="text" name="item_description1" class="input-field" value="${tenderItemMaster.itemDescription}"></td>
                                                            <td><input type="text" name="purpose1" class="input-field" value="${tenderItemMaster.deliveryScheduleQty}"></td>
                                                            <td><input type="text" name="remark1" class="input-field" value="${tenderItemMaster.deliveryScheduleDate}"></td>
                                                            <td><input type="text" name="uom1" class="input-field" value="${tenderItemMaster.uom}"></td>
                                                            <td><input type="text" name="qty1" class="input-field" value="${tenderItemMaster.qty}"></td>
                                                            <td><input type="text" name="gst1" class="input-field" value="${tenderItemMaster.gst}"></td>

                                                            </tr>
                                                        </c:forEach>

                                                        <tr>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td></td>
                                                            <td style="width: 7%;"><span style='margin-top: 5px;' class="col-sm-1">
                                                                    <input type="button" value="+" id="policyCloneid1" onclick="Policy1();"/>
                                                                </span></td>

                                                        </tr>


                                                        </tbody>
                                                    </table>



                                                    <hr>

                                                </c:otherwise>
                                            </c:choose>
                                        
                                    </div>



                                    <div class="form-group">
                                        <div style="display: flex;  justify-content: center;">

                                            <button type="Submit" class="btn theme-btn" style="width: 120px!important;" onclick="closewindow();" >Submit</button>
                                        </div>
                                    </div>   
                    
                    
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
            function closewindow() {
                //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
                //     window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.showuser1('1');
                window.close();
            }
        </script>

        <script>
               if ($("#policyTable").length) {
               const table1 = initDocTable("#policyTable");
               }
           var i10 = 1;

           var tempCount3 = 1;
           function Policy()
           {

               tempCount3++;
               //                        alert(tempCount3);
               var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"

                       + ""
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='SRNO" + tempCount3 + "' id='SRNO" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='ITEMCODE" + tempCount3 + "' id='ITEMCODE" + tempCount3 + "'onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='ITEMDESCRIPTION" + tempCount3 + "' id='ITEMDESCRIPTION" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='PURPOSE" + tempCount3 + "' id='PURPOSE" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\"  step=\"any\" name='ITEMDETAILS" + tempCount3 + "' id='ITEMDETAILS" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='UOM" + tempCount3 + "' id='UOM" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='QTY" + tempCount3 + "' id='QTY" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='GST" + tempCount3 + "' id='GST" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                       + "<td style='text-align: center;'>"
                       + "<span style='margin-top: 5px;'>"
                       + "<div class='clone-action delete-parent-field' title='Remove' "
                       + "style='cursor:pointer; display:inline-block;' "
                       + "onclick=\"removeStep1Tr('addmoreFile" + tempCount3 + "');\">"
                       + "<img src='StorageYard/assets/images/clone-delete-btn.svg' "
                       + "onload='SVGInject(this)' alt='Remove'>"
                       + "</div>"
                       + "</span>"
                       + "</td>"
                       + "</tr>";

               $("#policyTable").append(clone);
               document.getElementById('policyCount').value = tempCount3;
//                var expenseType = document.getElementById('expenseType').value;
               addAPolicy(tempCount3);
           }

           function removeStep1Tr(cloneTr_Id) {



               try {
                   tempCount3--;
                   var val = document.getElementById("policyCount").value;
                   val = val - 1;
                   document.getElementById("policyCount").value = val;
                   var element1 = document.getElementById(cloneTr_Id);

                   element1.parentNode.removeChild(element1);
               } catch (e) {

               }


           }

        </script>


        <script>

            var i10 = 1;

            var tempCount4 = 1;
            function Policy1()
            {

                tempCount4++;
                //                        alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount4 + "' style='clear:both;'>"

                        + ""
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='SRNOO" + tempCount4 + "' id='SRNOO" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='ITEMCODEE" + tempCount4 + "' id='ITEMCODEE" + tempCount4 + "'onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='ITEMDESCRIPTIONN" + tempCount4 + "' id='ITEMDESCRIPTIONN" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='PURPOSEE" + tempCount4 + "' id='PURPOSEE" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\"  step=\"any\" name='ITEMDETAILSS" + tempCount4 + "' id='ITEMDETAILSS" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='UOMM" + tempCount4 + "' id='UOMM" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='QTYY" + tempCount4 + "' id='QTYY" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='GSTT" + tempCount4 + "' id='GSTT" + tempCount4 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"input-field\"></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removeStep1Tr1('addmoreFile" + tempCount4 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#table_2").append(clone);
                document.getElementById('policyCount1').value = tempCount4;
//                var expenseType = document.getElementById('expenseType').value;
                addAPolicy(tempCount4);
            }

            function removeStep1Tr1(cloneTr_Id1) {

                try {


                    tempCount4--;
                    var val1 = document.getElementById("policyCount1").value;
                    val1 = val1 - 1;

                    document.getElementById("policyCount1").value = val1;
                    var element2 = document.getElementById(cloneTr_Id1);
                    element2.parentNode.removeChild(element2);

                } catch (e) {

                }


            }

        </script>
</html>
