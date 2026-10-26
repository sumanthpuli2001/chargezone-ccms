<%-- 
    Document   : TenderPrint1
    Created on : 20 Jan, 2024, 4:08:54 PM
    Author     : admin
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNewPrint.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Information</title>

        <script language="javascript" type="text/javascript">

            function recycleTender()
            {
                window.location = 'tenderMaster.htm?act=recycleTender';
            }

            function rejectTender()
            {
                window.location = 'tenderMaster.htm?act=rejectTender';
            }

            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

            var tempCount3 = 1;
            function Policy()
            {

                tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='generalfile" + tempCount3 + "' id='generalfile" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
                addAPolicy(tempCount3);
            }

            function removePolicy(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }


            var tempCount31 = 1;
            function Policy1()
            {

                tempCount31++;
                var clone = "<tr id='addmoreFile" + tempCount31 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='additionalfile" + tempCount31 + "' id='additionalfile" + tempCount31 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy1('addmoreFile" + tempCount31 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable1").append(clone);
                document.getElementById('policyCount1').value = tempCount31;
                addAPolicy(tempCount31);
            }

            function removePolicy1(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

            var tempCount32 = 1;
            function Policy2()
            {

                tempCount32++;
                var clone = "<tr id='addmoreFile" + tempCount32 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"file\" name='technicalfile" + tempCount32 + "' id='technicalfile" + tempCount32 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy2('addmoreFile" + tempCount32 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable2").append(clone);
                document.getElementById('policyCount2').value = tempCount32;
                addAPolicy(tempCount32);
            }

            function removePolicy2(policyDiv) {

                try {
                    var currentMinusName = policyDiv;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

            function updatedata(str) {
                var ss = "";
                //var ss=form["vendor_em"].value;
                if (typeof XMLHttpRequest != "undefined") {
                    xmlHttp = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                if (xmlHttp == null) {
                    alert("Browser does not support XMLHTTP Request")
                    return;
                }

                var url = "tenderMaster.htm?act=updateVendor";
                url += "&tender_no=" + str + "&str1=" + ss;
                alert(str);
                xmlHttp.onreadystatechange = stateChange2;
                alert(str);
                xmlHttp.open("GET", url, true);
                alert(str);
                xmlHttp.send(null);
                alert(str);
                //stateChange1();
            }

            function stateChange2()
            {
                if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
                {
                    var a = xmlHttp.responseText;

                    var c = a.split("*");
                    var b = c[0].split("$");
                    var d = c[1].split("$");

                    if (b.length == 2)
                    {
                        form["vendor_email_id"].value = b[0];
                    }
                    else
                    {
                        for (var i = 0; i < b.length - 1; i++)
                        {
                            form["vendor_email_id"][i].value = b[i];
                        }
                    }

                    if (d.length == 2)
                    {
                        form["vendor_mob_no"].value = d[0];
                    }
                    else
                    {
                        for (var i = 0; i < d.length - 1; i++)
                        {
                            form["vendor_mob_no"][i].value = d[i];
                        }
                    }
                }
            }


        </script>

    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=submitCorrigendumView" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0  no-print">${tenderPhase} Part Tender Information</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>
                            <a href="" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a> 
                            <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                            <input type="hidden" name="id" value="${id}">
                        </div>
                    </div>
                    <br>
                    <table class="table table-bordered printup" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle; border: 1px solid black !important;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px; border: 1px solid black !important;">
                                    Tender View
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender information
                            </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Item Category</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${tenderMaster.type}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Tender Reference No.</strong></td>
                            <td colspan="4" style="padding:3px 5px;"> ${tenderMaster.refNo}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Title</strong></td>
                            <td colspan="8" style="padding:3px 5px;">${tenderMaster.title}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Tender classification</strong></td>
                            <td colspan="8" style="padding:3px 5px;">${tenderMaster.categoryId}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>Tender Fee</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${tenderMaster.docCost}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong>Tender EMD</strong></td>
                            <td colspan="4" style="padding:3px 5px;">${tenderMaster.emd} </td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td style="padding:3px 5px;"><strong>Tender Location</strong></td>
                            <td colspan="8" style="padding:3px 5px;">${tenderMaster.location}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2"  style="padding:3px 5px;"><strong>Tender Start Date</strong></td>
                            <td colspan="1" style="padding:3px 5px;">${tenderMaster.announceDate} </td>
                            <td colspan="2" style="padding:3px 5px;"><strong>Tender End Date</strong></td>
                            <td colspan="4"style="padding:3px 5px;">${tenderMaster.submitLastdate}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2"  style="padding:3px 5px;"><strong>Tender Subject Description</strong></td>
                            <td colspan="1" style="padding:3px 5px;">${tenderMaster.workDesc} </td>
                            <td colspan="2" style="padding:3px 5px;"><strong>PR No</strong></td>
                            <td colspan="4"style="padding:3px 5px;">${pr_no}</td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2"  style="padding:3px 5px;"><strong>Plant Name</strong></td>
                            <td colspan="1" style="padding:3px 5px;">${tenderMaster.plantName} </td>
                            <td colspan="2" style="padding:3px 5px;"><strong>Delivery Location</strong></td>
                            <td colspan="4"style="padding:3px 5px;">${tenderMaster.deliveryLocation}</td>
                        </tr>

                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong> Created By</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${tenderMaster.contactPerson}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong> Created Contact No.</strong></td>
                            <td colspan="4" style="padding:3px 5px;">${tenderMaster.tenderAdminContactNumber} </td>
                        </tr>
                        <tr style="font-size:11px; height:20px;">
                            <td colspan="2" style="padding:3px 5px;"><strong>  End User Name</strong></td>
                            <td colspan="1"style="padding:3px 5px;">${tenderMaster.endUserName}</td>
                            <td colspan="2"  style="padding:3px 5px;"><strong> End User Number</strong></td>
                            <td colspan="4" style="padding:3px 5px;">${tenderMaster.endUserNumber} </td>
                        </tr>


                        </tbody>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                    <tr class="table-title">
                                        <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                            Civil Details
                                        </td>
                                    </tr> 

                                </c:if>
                                <c:if test="${tenderMaster.type != 'Contract Civil'}">
                                    <c:if test="${tenderMaster.type == 'Service'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Items Details For Service
                                            </td>
                                        </tr> 

                                    </c:if>
                                    <c:if test="${tenderMaster.type != 'Service'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Item Details
                                            </td>
                                        </tr>

                                    </c:if>
                                </c:if>
                        </tr>   
                        <tr>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">Sr. No</th>
                            <th  style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px; width: 15%;">Item Code</th>
                            <th   style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px; width: 40%;">Item Description</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 30%;">Details</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">UoM</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">Quantity</th>
                        </tr>

                        <tbody>
                            <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                <tr style="">
                                    <td   style="font-size: 9px; padding: 3px 5px;">${status.count}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.itemCode}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.itemDescription}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.deliveryScheduleDate}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.uom}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.qty}</td> 

                                </tr>
                            </c:forEach>
                    </table>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                               <c:if test="${tenderMaster.type == 'Contract' || tenderMaster.type == 'Contract Civil' || tenderMaster.type == 'Contract Electrical'}">

                                    <c:if test="${tenderMaster.type == 'Contract Civil'}">
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Steel Details
                                            </td>
                                        </tr> 
                                    </c:if>
                                    <c:if test="${tenderMaster.type != 'Contract Civil'}"> 
                                        <tr class="table-title">
                                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                                Item Details For Service
                                            </td>
                                        </tr> 

                                    </c:if>


                                </c:if>
                        </tr>   
                        <tr>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">Sr. No</th>
                            <th  style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px; width: 15%;">Item Code</th>
                            <th   style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px; width: 40%;">Item Description</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 30%;">Details</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">UoM</th>
                            <th  style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px; width: 5%;">Quantity</th>
                        </tr>

                        <tbody>
                            <c:forEach var="tenderItemMaster" items="${tenderServiceItemMaster}" varStatus="status">
                                <tr style="">
                                    <td   style="font-size: 9px; padding: 3px 5px;">${status.count}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.itemCode}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.itemDescription}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.deliveryScheduleDate}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.uom}</td> 
                                    <td  style="font-size: 9px; padding: 3px 5px;">${tenderItemMaster.qty}</td> 

                                </tr>
                            </c:forEach>
                    </table>
                    <br>
                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                Tender Attachment
                            </td>
                        <tbody>                   
                            <tr style="font-size:11px; height:20px;">
                                <td style="padding:3px 5px;"><strong>General Terms & Conditions</strong></td>
                            </tr>

                            <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"> ${generalDocs.document}   </td>
                                <tr>
                                </c:forEach>
                            <tr style="font-size:11px; height:20px;">
                                <td style="padding:3px 5px;"><strong>Tender Additional Document</strong></td>
                            </tr>

                            <c:forEach var="additionalDocs" items="${additionalDocs}" varStatus="status">
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"> ${additionalDocs.document}   </td>
                                <tr>
                                </c:forEach>
                            <tr style="font-size:11px; height:20px;">
                                <td style="padding:3px 5px;"><strong>Tender Technical Document</strong></td>
                            </tr>

                            <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                <tr style="font-size:11px; height:20px;">
                                    <td colspan="2" style="padding:3px 5px;"> ${technicalDocs.document}   </td>
                                <tr>
                                </c:forEach>
                        </tbody>
                    </table>
              
                            <br>
                            <c:if test="${tenderPhase != '1'}">
                            <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr class="table-title">
                            <td colspan="7" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                               Technical Detail / Specification
                            </td>
                        <tbody>                   
                            <tr style="font-size:11px; height:20px;">
                                <td style="padding:3px 5px;"><strong>Technical Specification Required From Vendor</strong></td>
                            </tr>                           
                            <tr>
                                <td colspan="2" style="padding:3px 5px;"> ${tenderTechnicalDoc}   </td>
                            </tr>
                        </tbody>
                            </table>
                            </c:if>
                         
                        <br>
                        <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                            <tr class="table-title">
                                <td colspan="10" style="text-align:center; background-color:#e0e7ff; padding:3px 5px;">
                                    Tender Remark
                                </td>
                            </tr>
                            <tr style="font-size:11px; height:20px;">
                                <td  style="padding:3px 5px; width: 20%;"><strong>Tender Remark</strong></td>
                                <td style="padding:3px 5px; width: 80%;">${tenderMaster.tenderRemark}</td>

                            </tr>
                        </table>

                    </form:form>
            </section>
        </main>
    </body>
    <!--    <body onload="window.print();">
        </body>-->
    <%@include file="/WEB-INF/jsp/Common/NewUIFooterPrint.jsp"%>
</html>
