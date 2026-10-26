
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit PR</title>
    </head>

     <body onload="myFunction()">
         
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
                    dom: 't<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>',
                    ...obj,
            });
            }
        </script>
         <script>
        function cancelClick() {
            window.location = 'prMaster.htm?act=listPRList';
        }
    </script>
         
    <script language="javascript" type="text/javascript">
            function isNumberKey(evt) {

                var charCode = (evt.which) ? evt.which : event.keyCode;

                if (charCode == 46) {
                    return true;
                }

                if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                    return false;
                }

                return true;
            }


            var classificationData = [];

            <c:forEach var="c" items="${pr_group_classification}">

                classificationData.push({

                    classification : "${c.classificationName}".trim(),

                    prValue : parseFloat("${c.prValue}"),

                    bidRequired : "${c.bidRequired}"

                });

            </c:forEach>


            function itemcal() {

                var classification =
                        document.getElementById("categoryId").value.trim();

                var value =
                        parseFloat(document.getElementById("value").value);

                var quotesField =
                        document.getElementById("quotes");


                if (classification === "" || isNaN(value)) {

                    quotesField.value = "";
                    return;
                }


                var matchedRows = classificationData.filter(function(item) {

                    return item.classification === classification;

                });


                matchedRows.sort(function(a, b) {

                    return b.prValue - a.prValue;

                });


                var matchedBid = "";


                for (var i = 0; i < matchedRows.length; i++) {

                    if (value >= matchedRows[i].prValue) {

                        matchedBid = matchedRows[i].bidRequired;
                        break;
                    }
                }


                quotesField.value = matchedBid;
            }


            function gettender() {
            var t = document.getElementById("refNo").value;
                    var tenderPhase = document.getElementById("tenderPhase").value;
                    window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

            var tempCount3 = 1;
                    function Policy() {
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
                    function Policy1() {
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
                    function Policy2() {
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

            function stateChange2() {
            if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
            var a = xmlHttp.responseText;
                    var c = a.split("*");
                    var b = c[0].split("$");
                    var d = c[1].split("$");
                    if (b.length == 2) {
            form["vendor_email_id"].value = b[0];
            } else {
            for (var i = 0; i < b.length - 1; i++) {
            form["vendor_email_id"][i].value = b[i];
            }
            }

            if (d.length == 2) {
            form["vendor_mob_no"].value = d[0];
            } else {
            for (var i = 0; i < d.length - 1; i++) {
            form["vendor_mob_no"][i].value = d[i];
            }
            }
            }
            }

            function myFunction() {

            var t = document.getElementById("type").value;
                    if (t == 'Procurement') {
            document.getElementById("myP1").style.display = "none";
                    document.getElementById("myP2").style.display = "none";
                    document.getElementById("myP3").style.display = "none";
                    document.getElementById("myP4").style.display = "block";
            } else {

            document.getElementById("myP1").style.display = "block";
                    document.getElementById("myP2").style.display = "block";
                    document.getElementById("myP3").style.display = "block";
                    document.getElementById("myP4").style.display = "none";
            }
            }
        </script>
        <script>
            var tempCount1 = 1;
                    $(function () {
                    $("#glCloneid").on("click", function () {
                    tempCount1++;
                            var clone = "<tr id='glFile" + tempCount1 + "' style='clear:both;'>"

                            + "<td id=\"glTd" + tempCount1 + "\" style=\"text-align: center\"><input type=\"text\" step=\"any\" name='glcode" + tempCount1 + "' id='glcode" + tempCount1 + "'  class=\"form-control\"></td>"
                            + "<td ><div><select id='costCenterId" + tempCount1 + "' name='costCenterId" + tempCount1 + "' class=\"form-control\">"
                            + "</select>"
                            + "</div><span id=\"policyError" + tempCount1 + "\" style=\"color: red;\"></span></td>"
                            + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='costCenterNo" + tempCount1 + "' id='costCenterNo" + tempCount1 + "'  class=\"form-control\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removegl('glFile" + tempCount1 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                            $("#glTable").append(clone);
                            document.getElementById('policyCount').value = tempCount1;
                            alert(tempCount1);
                            addAGL(tempCount1);
                    });
                    });
                    function addAGL(id) {
                    var element2 = document.getElementById('costCenterId1');
                            var obj2 = document.getElementById("costCenterId" + id);
                            for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                            opt2.value = element2.options[i2].value;
                            opt2.text = element2.options[i2].text;
                            obj2.appendChild(opt2);
                    }
                    }
            function removegl(policyDiv) {
            try {
            var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("glFile")[1];
                    var val = document.getElementById("policyCount").value;
                    val = val - 1;
                    
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
            } catch (e) {
            }
            }
        </script>

        <script>
            var tempCount2 = 1;
                    $(function () {
                    $("#dcCloneid").on("click", function () {
                    tempCount2++;
                            var clone = "<tr id='dcNumber" + tempCount2 + "' style='clear:both;'>"


                            + "<td id=\"dcNumberTd" + tempCount2 + "\" style=\"text-align: center\"><input type=\"text\"  name='dcNumber" + tempCount2 + "' id='dcNumber" + tempCount2 + "'   class=\"form-control\"></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removedc('dcNumber" + tempCount2 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                            $("#dcTable").append(clone);
                            document.getElementById('dcCount').value = tempCount2;
                            addAPolicy(tempCount2);
                    });
                    });
                    function addAPolicy(id) {
                    var element2 = document.getElementById('dcId1');
                            var obj2 = document.getElementById("policyId" + id);
                            for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                            opt2.value = element2.options[i2].value;
                            opt2.text = element2.options[i2].text;
                            obj2.appendChild(opt2);
                    }
                    }
            function removedc(policyDiv) {
            try {
            var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("dcNumber")[1];
                    var val = document.getElementById("policyCount").value;
                    //   var element = document.getElementsByName("dcNumber" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
            } catch (e) {
            }
            }
        </script>

        <script>
            var tempCount3 = 1;
                    $(function () {
                    $("#policyCloneid").on("click", function () {
                    console.log("H1");
                            tempCount3++;
                            var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"


                            + "<td id=\"addmoreFile" + tempCount3 + "\" style=\"text-align: center\"><div><select id='userList" + tempCount3 + "' name='userList" + tempCount3 + "' class=\"form-control\">"
                            + "</select>"
                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                            $("#policyTable").append(clone);
                            document.getElementById('policyCount').value = tempCount3;
                            addBPolicy(tempCount3);
                    });
                    });
                    function addBPolicy(id) {

                    var element2 = document.getElementById('userList1');
                            var obj2 = document.getElementById("userList" + id);
                            for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                            opt2.value = element2.options[i2].value;
                            opt2.text = element2.options[i2].text;
                            obj2.appendChild(opt2);
                    }
                    }
            function removePolicy(policyDiv) {
            try {
            var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("addmoreFile")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
            } catch (e) {
            }
            }
        </script>

        <script>
            var tempCount4 = 1;
                    $(function () {

                    $("#imageCloneid").on("click", function () {
                    tempCount4++;
                            var clone = "<tr id='imageId" + tempCount4 + "' style='clear:both;'>"


                            + "<td id=\"imageFileId" + tempCount4 + "\" style=\"text-align: center\"><div><input type='file' id='imageId" + tempCount4 + "' name='imageId" + tempCount4 + "' class=\"form-control\">"

                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removeImage('imageId" + tempCount4 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                            let
                            ids = document.getElementById("ids")
                            ids.value = tempCount4;
                            console.log(ids);
                            $("#imageTable").append(clone);
                            document.getElementById('imageCount').value = tempCount4;
                            addAPolicy(tempCount4);
                    });
                    });
                    function addAPolicy(id) {
                    var element2 = document.getElementById('imageId1');
                            var obj2 = document.getElementById("imageId" + id);
                            let
                            ids = document.getElementById("ids")
                            ids.value = element2.options.length;
                            console.log(ids);
                            for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                            opt2.value = element2.options[i2].value;
                            opt2.text = element2.options[i2].text;
                            obj2.appendChild(opt2);
                    }
                    }
            function removeImage(policyDiv) {
            try {
            var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("imageId")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
            } catch (e) {
            }
            }
        </script>

        <script>
            var tempCount5 = 1;
                    $(function () {
                    $("#attachmentCloneid").on("click", function () {
                    tempCount5++;
                            var clone = "<tr id='attachmentId" + tempCount5 + "' style='clear:both;'>"


                            + "<td id=\"attachmentFileId" + tempCount5 + "\" style=\"text-align: center\"><div><input type='file' id='attachmentId" + tempCount5 + "' name='attachmentId" + tempCount5 + "' class=\"form-control\">"

                            + "</div></td>"
                            + "<td style=\"text-align: center\">"
                            + "<span style='margin-top: 5px;'>"
                            + "<input type=\"button\"value=\"-\"  onclick=\"removeAttachment('attachmentId" + tempCount5 + "');\"/>"
                            + "</span>"
                            + "</td>"
                            + "</tr>";
                            $("#attachmentTable").append(clone);
                            document.getElementById('attachmentCount').value = tempCount5;
                            addAPolicy(tempCount5);
                    });
                    });
                    function addAPolicy(id) {
                    var element2 = document.getElementById('attachmentId1');
                            var obj2 = document.getElementById("attachmentId" + id);
                            var ids = document.getElementById(ids);
                            ids.value = id;
                            for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                            opt2.value = element2.options[i2].value;
                            opt2.text = element2.options[i2].text;
                            obj2.appendChild(opt2);
                    }
                    }
            function removeAttachment(policyDiv) {
            try {
            var currentMinusName = policyDiv;
                    var currentMinusId = currentMinusName.split("attachmentId")[1];
                    var val = document.getElementById("policyCount").value;
                    //var element = document.getElementsByName("amount" + currentMinusId)[0].value;
                    val = val - 1;
                    //   var element2 = document.getElementById('txtresult').value;
                    // document.getElementById('txtresult').value = '';
                    //  document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    // var element21 = document.getElementById('txtresultCTC').value;
                    //  document.getElementById('txtresultCTC').value = '';
                    //   document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);
                    //   document.getElementById("policyCount").value = val;
                    element1 = document.getElementById(policyDiv);
                    element1.parentNode.removeChild(element1);
            } catch (e) {
            }
            }
        </script>


        <script>

            jQuery.noConflict();
                    jQuery(document).ready(function () {
            jQuery("#vendorCode").tokenInput(${preList}, {
            preventDuplicates: true,
                    noResultsText: "No Result", tokenLimit: "1",
                    searchingText: "Searching ......",
                    prePopulate: "[]"
            });
            });</script>

        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>
        <style>
            .period-group { --p-radius: 8px; }

            .period-group {
                display: flex;
                flex-wrap: nowrap;
                align-items: stretch;
                gap: 6px;
            }

            .period-group .input-field {
                flex: 1 1 auto;
                width: 1%;
                min-width: 0;
                margin: 0 !important;
                border-radius: var(--p-radius) !important;
            }

            .period-group .select-input,
            .period-group .select2-container,
            .period-group .nice-select {
                flex: 0 0 110px;
                width: 110px !important;
                margin: 0 !important;
            }

            .period-group .select-input,
            .period-group .select2-container .select2-selection,
            .period-group .select2-container--default .select2-selection--single,
            .period-group .select2-container--bootstrap4 .select2-selection--single,
            .period-group .nice-select {
                border-radius: var(--p-radius) !important;
            }

            .period-group .input-field::-webkit-outer-spin-button,
            .period-group .input-field::-webkit-inner-spin-button { -webkit-appearance: none; margin: 0; }
            .period-group .input-field { -moz-appearance: textfield; }

            .period-badge {
                display: inline-block; padding: 5px 10px; margin-right: 4px;
                border-radius: 5px; color: #fff !important; font-size: 12px; font-weight: 600;
            }
            .period-badge b { color: #fff !important; font-weight: 700; }
        </style>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="prMaster.htm?act=updatePRMaster" method="post" enctype="multipart/form-data" commandName="prMaster"
                           name="form"   class="form-horizontal" role="form">
                    <input type="hidden" name="pr_no" id="pr_no" value="${ref_no}">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Edit PR</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="cancelClick();" class="btn theme-btn light-btn mr-3">Back</a>
                             <button type="submit"class="btn theme-btn mr-3" id="PRSAVEDRAFTS"    formaction="prMaster.htm?act=prSaveAsDraftSubmit">
                                Save As A Draft
                            </button>
                            <button type="submit" class="btn theme-btn" onclick="return handleSubmit(event)">Submit</button>               
                        </div>
                    </div>  
                     <c:if test="${!empty failureMessage}">                        
                        <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">                       
                        <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <br>
                    <input type="hidden" name="pr_no" id="pr_no" value="${ref_no}">
                    <input type="hidden" name="prType" id="prType" value="${prType}">
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>

                    
                    <div class="rounded-4 mt-4">
                        <div class="row">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">PR Reference No. : </label>
                                    <input type="text" name="ref_no" id="ref_no" class="input-field" value="${prMaster.prNo}"  maxlength="30" pattern="[0-9]+" onkeypress="return (event.charCode != 8 && event.charCode == 0 || (event.charCode >= 48 && event.charCode <= 57))" readonly="true"/>
                                </div>
                            </div>
                            <c:if test="${omsMaster != null}">
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">OMS Ticket No. : </label>
                                        <input type="text" name="ticketId" id="ticketId" class="input-field" value="${omsMaster.ticketId}" readonly="true"/>
                                        <input type="hidden" name="omsMasterId" id="omsMasterId" class="input-field" value="${omsMaster.id}" />
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">OMS Ticket Id : </label>
                                        <input type="text" class="input-field" value="${omsMaster.omsPrId}" readonly="true"/>
                                    </div>
                                </div>
                            </c:if>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Item Category : </label>
                                    <input type="text" name="type" id="type" class="input-field" value="${prMaster.type}"  maxlength="30"  readonly="true"/>                                </div>
                            </div>    

                             <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">PR Classification :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="categoryId" name="categoryId" onchange="itemcal()" required>
                                        <option value="">--SELECT--</option>
                                        <c:set var="previousName" value="" />
                                        <c:forEach var="pr_classification" items="${pr_group_classification}">
                                            <c:if test="${previousName != pr_classification.classificationName}">
                                                <option value="${pr_classification.classificationName}" ${pr_classification.classificationName == prMaster.categoryId ? 'selected' :''}>
                                                    ${pr_classification.classificationName}
                                                </option>
                                                <c:set var="previousName" value="${pr_classification.classificationName}" />
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">PR Estimate Cost With GST : <span class="text-danger">*</span></label>
                                    <!--<input type="text" class="input-field" name="value" id="value" value="${prMaster.value}" onkeyup="itemcal()" onkeypress="return isNumberKey(event)" required/>-->
                                    <div class="period-group">
                                        <select id="costCurrency" class="select-input" name="costCurrency" required></select>

                                        <input type="text" class="input-field" name="value" id="value" value="${prMaster.value}"
                                               onkeyup="itemcal()" onkeypress="return isNumberKey(event)" required/>
                                    </div>

                                    <input type="hidden" name="costCurrencyName" id="costCurrencyName">
                                    <input type="hidden" name="valueInr" id="valueInr">
                                    <input type="hidden" name="exchangeRate" id="exchangeRate">

                                    <script>
                                        $(function () {

                                            fillCostCurrencySelect('INR');

                                            if ($.fn.selectpicker) {
                                                $('#costCurrency').selectpicker('refresh');
                                            }

                                            $('#costCurrencyName').val('INR');
                                            $('#exchangeRate').val('1');

                                            $('#value').on('keyup', function () {
                                                $('#valueInr').val($(this).val());
                                            });

                                            $('#valueInr').val($('#value').val());
                                        });


                                        function fillCostCurrencySelect(selectedCode) {

                                            var list = CurrencyHelper.getCurrencies();
                                            var html = '';

                                            selectedCode = (selectedCode || '').toUpperCase();

                                            for (var i = 0; i < list.length; i++) {

                                                var c = list[i];

                                                html += '<option value="' + c.code + '"' +
                                                        (c.code === selectedCode ? ' selected="selected"' : '') +
                                                        '>' +
                                                        c.symbol + '-' + c.code +
                                                        '</option>';
                                            }

                                            $('#costCurrency').html(html);
                                        }
                                    </script>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Business Type :<span class="text-danger">*</span> </label>
                                    <form:select path="businessType"  class="select-input" required="required">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="pr_business_type" items="${pr_business_type}">
                                            <c:choose>
                                                <c:when test="${pr_business_type.businessType eq  prMaster.businessType}">
                                                    <form:option value="${pr_business_type.businessType}" selected="true">${pr_business_type.businessType}</form:option>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${pr_business_type.businessType}">${pr_business_type.businessType}</form:option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select> 
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Project Type :<span class="text-danger">*</span> </label>
                                    <form:select path="projectType"  class="select-input" required="required">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="pr_project_type" items="${pr_project_type}">
                                            <c:choose>
                                                <c:when test="${pr_project_type.projectType eq  prMaster.projectType}">
                                                    <form:option value="${pr_project_type.projectType}" selected="true">${pr_project_type.projectType}</form:option>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${pr_project_type.projectType}">${pr_project_type.projectType}</form:option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Plant :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="plantcode" name="plantcode" style="font-size: 12px; padding: 5px;" required="required" onchange="plantCode111(this.value);">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="list11" items="${list11}">
                                            <c:choose>
                                                <c:when test="${list11.plantCode eq prMaster.plant}">
                                                    <option value="${list11.plantCode}" selected="selected"
                                                            data-site-gst="${list11.gst}" 
                                                            data-purchasingOrganisation="${list11.purchasingOrganisation}" 
                                                            data-address="${list11.address}">
                                                        ${list11.plantName}-${list11.plantCode}
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list11.plantCode}"
                                                            data-site-gst="${list11.gst}" 
                                                            data-purchasingOrganisation="${list11.purchasingOrganisation}" 
                                                            data-address="${list11.address}">
                                                        ${list11.plantName}-${list11.plantCode}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Location Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="locationcode" name="locationcode" style=" font-size: 12px; padding: 5px;" required="required">
                                       
                                       
                                    </select>
                                </div>
                                <input type="hidden" name="gst" id="gst" class="form-control"   maxlength="200" required="required"/>
                                <input type="hidden" name="locationaddress" id="locationaddress" class="form-control"   maxlength="200" required="required"/>
                                <script>
                                            document.getElementById('locationcode').addEventListener('change', function () {

                                    var selectedProject = this.options[this.selectedIndex];
                                            var locationaddress = selectedProject.getAttribute('data-site-loaction');
                                            var billingLoactionTextarea = document.getElementById('locationaddress');
                                            billingLoactionTextarea.value = locationaddress || '';
                                    });</script>     




                                <input type="hidden" name="purchasing" id="purchasing" class="form-control"   maxlength="200" required="required"/>



                                <input type="hidden" name="address" id="address" class="form-control"   maxlength="200" required="required"/>



                                <script>
                                            document.getElementById('plantcode').addEventListener('change', function () {

                                    var selectedProject = this.options[this.selectedIndex];
                                            var gst = selectedProject.getAttribute('data-site-gst');
                                            var purchasingOrganisation = selectedProject.getAttribute('data-purchasingOrganisation');
                                            var address = selectedProject.getAttribute('data-address');
                                            var billingGstTextarea = document.getElementById('gst');
                                            var sitePurchasingTextarea = document.getElementById('purchasing');
                                            var siteAddressTextarea = document.getElementById('address');
                                            billingGstTextarea.value = gst || '';
                                            sitePurchasingTextarea.value = purchasingOrganisation || '';
                                            siteAddressTextarea.value = address || '';
                                    });</script> 
                            </div>
                                
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Delivery Period :<span class="text-danger">*</span></label>

                                    <div class="period-group">
                                        <input type="number" id="period_value" class="input-field"
                                               min="1" placeholder="Enter number" required>
                                        <select id="period_unit" class="select-input">
                                            <option value="1" selected>Day</option>
                                            <option value="7">Week</option>
                                            <option value="365">Year</option>
                                        </select>
                                    </div>

                                    <div id="period_result" class="mt-2" style="display:none;">
                                        <span class="period-badge bg-primary"><b id="res_year">0</b> Year</span>
                                        <span class="period-badge bg-info"><b id="res_week">0</b> Week</span>
                                        <span class="period-badge bg-success"><b id="res_day">0</b> Day</span>
                                    </div>

                                    <input type="hidden" name="delivery_period" id="delivery_period">
                                    <input type="hidden" name="delivery_period_days" id="delivery_period_days">
                                </div>
                            </div>

                            <script>
                                function label(n, name) {
                                    return n + ' ' + name + (n > 1 ? 's' : '');
                                }

                                function updateDeliveryPeriod() {
                                    var val  = parseInt($('#period_value').val(), 10);
                                    var mult = parseInt($('#period_unit').val(), 10);

                                    if (!val || val < 1) {
                                        $('#period_result').hide();
                                        $('#delivery_period, #delivery_period_days').val('');
                                        return;
                                    }

                                    var totalDays = val * mult;
                                    var years = Math.floor(totalDays / 365);
                                    var rem   = totalDays % 365;
                                    var weeks = Math.floor(rem / 7);
                                    var days  = rem % 7;

                                    $('#res_year').text(years);
                                    $('#res_week').text(weeks);
                                    $('#res_day').text(days);
                                    $('#period_result').show();

                                    var parts = [];
                                    if (years) parts.push(label(years, 'Year'));
                                    if (weeks) parts.push(label(weeks, 'Week'));
                                    if (days)  parts.push(label(days,  'Day'));

                                    $('#delivery_period').val(parts.join(' '));
                                    $('#delivery_period_days').val(totalDays);
                                }

                                /* "1 Year 5 Weeks 5 Days" -> total days (also reads "2 weeks", "15 Days", or a plain number as days) */
                                function periodTextToDays(text) {
                                    text = $.trim(text || '');
                                    if (!text) return 0;
                                    var y = /(\d+)\s*year/i.exec(text);
                                    var w = /(\d+)\s*week/i.exec(text);
                                    var d = /(\d+)\s*day/i.exec(text);
                                    if (y || w || d) {
                                        return (y ? parseInt(y[1], 10) : 0) * 365
                                             + (w ? parseInt(w[1], 10) : 0) * 7
                                             + (d ? parseInt(d[1], 10) : 0);
                                    }
                                    var n = parseInt(text, 10);
                                    return isNaN(n) ? 0 : n;
                                }

                                $('#period_value, #period_unit').on('input change', updateDeliveryPeriod);

                                /* ---------- EDIT PAGE: set saved value ---------- */
                                $(document).ready(function () {
                                    var savedPeriod = '<c:out value="${prMaster.deliveryPeriod}"/>';
                                    var totalDays   = periodTextToDays(savedPeriod);

                                    if (totalDays > 0) {
                                        var unit  = (totalDays % 365 === 0) ? 365 : (totalDays % 7 === 0) ? 7 : 1;
                                        var value = totalDays / unit;

                                        $('#period_value').val(value);
                                        $('#period_unit').val(unit);
                                        if ($('#period_unit').data('selectpicker')) $('#period_unit').selectpicker('refresh');
                                        $('#period_unit').trigger('change');   // runs updateDeliveryPeriod() and rebuilds the badges and hidden fields
                                    }
                                });
                            </script>
                            
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label"> Technical Reviewer <span class="text-danger">*</span> </label>
                                    
                                    
                                    <select class="select-input"  id="technicalCommittee" name="technicalCommittee"  required="required"   >
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="employeeMaster1" items="${employeeMaster1}" varStatus="status">
                                            <c:if test="${prMaster.technicalCommittee eq employeeMaster1.employeeCode}">
                                                <option value="${employeeMaster1.employeeCode}" selected>${employeeMaster1.name}</option>
                                            </c:if>
                                                <option value="${employeeMaster1.employeeCode}">${employeeMaster1.name}</option>                                                
                                        </c:forEach>
                                    </select> 
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Project Name :<span class="text-danger">*</span> </label>
                                    <input type="text" name="title" value="${prMaster.title}" id="title" class="input-field"  required="required">
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">   Project ID :<span class="text-danger">*</span> </label>
                                    <input type="text" name="projectId" value="${prMaster.projectId}" id="projectId" class="input-field"  required="required">
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-group">
                                    <label  class="label">  PR Subject Description :<span class="text-danger">*</span> </label>
                                    <textarea type="text" maxlength="250" class="textarea-field comment" id="workDesc" name="workDesc"  required="required">${prMaster.workDesc}</textarea>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label"> Minimum Quotes Required : </label>
                                    <input type="text" name="quotes" id="quotes" class="input-field" value="${prMaster.quotes}" readonly="true"/>
                                </div>
                            </div>                            
                            <script>
                                     function plantCode111(plantCode) {

                                        var selectedLocation = "${prMaster.locationName}"; // JSP value

                                        $.ajax({
                                            url: "prMaster.htm?act=locationOnBasePlantCode",
                                            type: "GET",
                                            data: { plantCode: plantCode },
                                            dataType: "json",
                                            success: function(obj) {

                                                var data1 = "<option value=''>-- Select --</option>";
                                                var locations = obj.locationMasters;

                                                for (var i = 0; i < locations.length; i++) {

                                                    var selected = "";
                                                    if (locations[i].locationName === selectedLocation) {
                                                        selected = " selected";
                                                    }

                                                    data1 += "<option value='" + locations[i].locationName + "'" +
                                                             selected +
                                                             " data-site-location='" + locations[i].address + "'>" +
                                                             locations[i].locationName +
                                                             "</option>";
                                                }

                                                $('#locationcode').html(data1);
                                                $('.select-input').selectpicker('refresh');
                                            }
                                        });
                                    }
                                        $(document).ready(function () {
                                            var plantCode = $("#plantcode").val(); // Replace with your source
                                            plantCode111(plantCode);
                                        });
                            </script>
                            <script>

                                function changecontactperson()
                                {
                                var committee_approval = document.form.committee_approval.value;
                                        var technical_person = document.form.technical_contact_name.value;
                                        const myArray = technical_person.split("::");
                                }
                            </script>     
                           <div class="col-sm-6">

                        <label class="checkbox-inline">
                            <input type="checkbox"
                                   id="singleQuoteCheckbox"
                                   name="singleQuoteCheckbox"
                                   value="1"
                                   onclick="toggleAttachment()"
                                   <c:if test="${prMaster.singleQuoteFlag == 1}">
                                       checked="checked"
                                   </c:if> />
                            If single quote Please Attach File
                        </label>

    <!-- default value when unchecked -->
    <input type="hidden" name="singleQuoteCheckbox" value="0">

    <div class="col-lg-7 col-md-6"
         id="attachmentSection"
         style="display:${prMaster.singleQuoteFlag == 1 ? 'block' : 'none'};">

        <!-- show download link if file exists -->
        <c:if test="${not empty prMaster.singleQuoteAttachment}">
            <a class="fw-600 text-break gradient-text"
               href="prMaster.htm?act=downloadPrSingleQuoteAttachment&prNo=${prMaster.prNo}&id=${prMaster.id}&page=viewapprovePR">
                ${prMaster.singleQuoteAttachment}
            </a>
        </c:if>

        <!-- file upload -->
        <input type="file" id="singleQuoteAttachment" name="singleQuoteAttachment" class="input-field" onchange="validateFileSize(this)"/>
        <input type="hidden" id="singleQuoteAttachment1" name="singleQuoteAttachment1" value="${prMaster.singleQuoteAttachment}" class="input-field" />

    </div>

</div>
                        </div>

                       <script>
                            function toggleAttachment() {
                                
                                 var checkBox = document.getElementById("singleQuoteCheckbox");
                        var attachment = document.getElementById("attachmentSection");
                        var fileInput = document.getElementById("singleQuoteAttachment");

                        if (checkBox.checked) {
                            attachment.style.display = "block";
                            fileInput.setAttribute("required", "required"); // make required
                        } else {
                            attachment.style.display = "none";
                            fileInput.removeAttribute("required"); // remove required
                            fileInput.value = ""; // optional: clear selected file
                        }
                            }
                        </script>
                        <script>
                                function validateFileSize(input) {

                                    const file = input.files[0];

                                    if (file) {

                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                        if (file.size > maxSize) {

                                            Swal.fire({
                                                icon: 'error',
                                                title: 'File Too Large',
                                                text: 'File size must be less than 5 MB'
                                            });

                                            input.value = '';
                                        }
                                    }
                                }
                                </script>
                        <br>



                        <div class="form-group">
                                <h6 class="fw-600">PR Contact Person Details</h6>
                            </div>

                         <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Created By :</label>
                                    <input type="text" name="contactPerson" id="contactPerson" class="input-field" value="${employee_name}"  maxlength="30" readonly="true"/>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Contact Number :</label>
                                    <input type="text" name="contactPersonNumber" id="contactPersonNumber" class="input-field" value="${ph_no}" readonly="true"  maxlength="30" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">
                                    Technical Person Name : <span class="text-danger">*</span>
                                </label>

                                <select name="technicalContactName" id="technicalContactName" onchange="changetechnicalperson()" class="select-input" required="required">
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="employeeMaster1" items="${employeeMaster1}">
                                        <c:if test="${prMaster.technicalContactName eq employeeMaster1.employeeCode}">
                                            <option value="${employeeMaster1.employeeCode}" data-phone="${employeeMaster1.phNo}" selected>${employeeMaster1.name}</option>
                                        </c:if>
                                        <option value="${employeeMaster1.employeeCode}" data-phone="${employeeMaster1.phNo}">${employeeMaster1.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Technical Person Contact Number</label>
                                <form:input path="technicalContactNo" id="technicalContactNo" class="input-field" readonly="true" required="required"/>
                            </div>
                        </div>

                        <script>
                            function changetechnicalperson() {
                                var select = document.getElementById("technicalContactName");
                                var phone = select.options[select.selectedIndex].getAttribute("data-phone");

                                if (phone) {
                                    document.getElementById("technicalContactNo").value = phone;
                                } else {
                                    document.getElementById("technicalContactNo").value = "";
                                }
                            }

                            window.onload = function() {
                                changetechnicalperson();
                            };
                        </script>
                        
                        
                            <!-- Billing Location -->
                            <div class="col-lg-4 col-md-6">
                                <label class="label">
                                    Billing Location :
                                    <span class="text-danger">*</span>
                                </label>
                                <form:select path="billingLocation"  class="select-input" required="required">
                                    <option value="">--SELECT--</option>
                                    <c:forEach var="billingLocation" items="${billing_location}">
                                        <c:choose>
                                            <c:when test="${billingLocation.locationName eq  prMaster.billingLocation}">
                                                <form:option value="${billingLocation.locationName}" selected="true">${billingLocation.locationName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${billingLocation.locationName}" >${billingLocation.locationName}</form:option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                            
                            <div class="col-lg-4 col-md-6">
                            <div class="form-group">
                                <label class="label">Name of Location Partner</label>

                                <input  class="input-field"  name="nameofLocationPartner" id="nameofLocationPartner" value="${prMaster.nameofLocationPartner}" placeholder="Enter Name of Location Partner"  />

                            </div>    
                        </div>
                        </div>
                        
                                    <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                <label class="label">Mobile No of Location Partner</label>

                                <input  class="input-field"  name="mobileNoLocationPartner" id="mobileNoLocationPartner" value="${prMaster.mobileNoLocationPartner}" oninput="this.value = this.value.replace(/[^0-9]/g, '')" placeholder="Mobile No of Location Partner"  />

                            </div>    
                        </div>  
                        </div>  
                            
                            
                            
                    </div>

                    <h6 class="fw-600">Site Address</h6>
                    <c:if test="${not empty list6}">
                        <table id="commonTable" class="table table-striped bg-white mt-3" style="min-width: 100%" align="center">
                            <thead>
                                <tr>
                                    <th>Address1</th>
                                    <th>Address2</th>
                                    <th>Pincode</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Remarks</th>
                                    <th data-dt-order="disable">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="addr" items="${list6}">
                                    <tr>
                                        <td style="text-align: center;"><c:out value="${addr.address1}"/></td>
                                        <td style="text-align: center;"><c:out value="${addr.address2}"/></td>
                                        <td style="text-align: center;"><c:out value="${addr.pincode}"/></td>
                                        <td style="text-align: center;"><c:out value="${addr.city}"/></td>
                                        <td style="text-align: center;"><c:out value="${addr.state}"/></td>
                                        <td style="text-align: center;"><c:out value="${addr.remark}"/></td>
                                        <td style="text-align: center;">
                                            <a href="prMaster.htm?act=multipleAddressDelete&deleteId=${addr.id}&id=${id}" class="delete-address">
                                                <img src="StorageYard/assets/images/clone-delete-btn.svg" onload="SVGInject(this)" alt="Remove" style="width: 35px; height: 35px;">
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <br>
                    </c:if>

                    <%-- ================= ADD NEW ADDRESS ================= --%>
                    <table class="table table-striped bg-white dt-scroll myTableNoSorting" id="siteAddressTable" style="width:100%;" align="center">
                        <thead>
                            <tr>
                                <th>Address1</th>
                                <th>Address2</th>
                                <th>Pincode</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Remarks (Optional)</th>
                                <th data-dt-order="disable">Add New</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr id="policyRow1">
                                <td><input type="text" placeholder="Address1" class="input-field" name="Address1" id="Address11"></td>
                                <td><input type="text" placeholder="Address2" class="input-field" name="Address2" id="Address21"></td>

                                <td>
                                    <input type="text" placeholder="Pincode" class="input-field pincode-field" maxlength="6"
                                           inputmode="numeric" name="pincodes" id="pincodes1" autocomplete="postal-code">
                                    <div class="pin-msg"></div>
                                </td>

                                <td><input type="text" placeholder="City" class="input-field city-field" name="cityes" id="cityes1"></td>

                                <td>
                                    <select name="states" class="select-input selectpicker state-select" id="states1"
                                            data-live-search="true" data-width="100%" data-container="body">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="billingLocation" items="${billing_location}">
                                            <option value="${billingLocation.locationName}">${billingLocation.locationName}</option>
                                        </c:forEach>
                                    </select>
                                </td>

                                <td><textarea class="textarea-field remarkes" name="remarkes" id="remarkes1" placeholder="Enter your remarks..." maxlength="250"></textarea></td>

                                <td style="text-align:center;">
                                    <div class="d-flex justify-content-center align-items-center">
                                        <div class="clone-action clone-new-field d-flex justify-content-center align-items-center mb-2" id="policyCloneid5" style="cursor:pointer;">
                                            <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>

                    <style>
                        #siteAddressTable .pin-msg { display: block; font-size: 12px; line-height: 1.3; margin-top: 4px; }
                        #siteAddressTable .pin-msg.error { color: #dc3545; font-weight: 500; }
                        #siteAddressTable .pin-msg.info  { color: #6c757d; }
                        #siteAddressTable .pin-msg.warn  { color: #e08a00; }

                        #siteAddressTable td .input-field.pin-invalid,
                        #siteAddressTable td .input-field.field-error,
                        #siteAddressTable td .textarea-field.field-error,
                        #siteAddressTable td .dropdown-toggle.field-error,
                        #siteAddressTable td .dropdown-toggle.field-error:focus {
                            border: 1px solid #dc3545 !important;
                            box-shadow: 0 0 0 1px rgba(220,53,69,.15) !important;
                        }
                    </style>

                    <script>
                    $(document).ready(function () {

                        $('.selectpicker').selectpicker();

                        var stateOptionsHtml = $('#states1').html();     // cached for cloned rows
                        var tempCount5 = 1;

                        /* ---- delete a SAVED address: ask first ---- */
                        $(document).on('click', 'a.delete-address', function (e) {
                            e.preventDefault();
                            var href = this.href;
                            Swal.fire({
                                title: 'Are you sure you want to delete this address?',
                                text: 'You will not be able to recover this record!',
                                icon: 'warning',
                                showCancelButton: true,
                                confirmButtonText: 'Yes, delete it!',
                                cancelButtonText: 'No, cancel',
                                reverseButtons: true
                            }).then(function (result) {
                                if (result.isConfirmed) window.location = href;
                            });
                        });

                        /* ============ ROW REQUIRED LOGIC ============
                           Row is "active" once the user writes anything in it.
                           Active row -> Address1, Address2, Pincode, City, State are mandatory.
                           Remarks is optional. Empty row -> nothing is mandatory.
                        =============================================== */
                        var FIELDS          = 'input.input-field, textarea.textarea-field, select.state-select';
                        var REQUIRED_FIELDS = 'input.input-field, select.state-select';

                        function isRowActive($row) {
                            var active = false;
                            $row.find(FIELDS).each(function () {
                                if ($.trim($(this).val()) !== '') { active = true; return false; }
                            });
                            return active;
                        }
                        function markError($el) {
                            ($el.is('select') ? $el.siblings('.dropdown-toggle') : $el).addClass('field-error');
                        }
                        function clearError($el) {
                            $el.removeClass('field-error');
                            $el.siblings('.dropdown-toggle').removeClass('field-error');
                        }
                        function syncRow($row) {
                            var active = isRowActive($row);
                            if (!active) $row.find('.field-error').removeClass('field-error');
                            return active;
                        }

                        /* ============ PINCODE HELPERS ============ */
                        function showMsg($row, type, text) {
                            $row.find('.pin-msg').attr('class', 'pin-msg ' + type).text(text);
                        }
                        function clearPinState($row) {
                            var $pin = $row.find('.pincode-field');
                            $pin.removeClass('pin-invalid field-error').removeData('ok').removeData('bad').removeData('pending');
                            $row.find('.pin-msg').attr('class', 'pin-msg').text('');
                        }
                        function clearAutoFilled($row) {
                            if ($row.data('auto')) {
                                $row.find('.city-field').val('');
                                $row.find('select.state-select').val('').selectpicker('refresh');
                                $row.data('auto', false);
                            }
                        }
                        function setPinError($row, text) {
                            var $pin = $row.find('.pincode-field');
                            $pin.addClass('pin-invalid').data('bad', true).removeData('pending');
                            showMsg($row, 'error', text);
                            clearAutoFilled($row);
                        }
                        function setState($row, name) {
                            var $s = $row.find('select.state-select');
                            var target = $.trim(name).toLowerCase();
                            var val = null;

                            $s.find('option').each(function () {
                                if (this.value && $.trim($(this).text()).toLowerCase() === target) { val = this.value; return false; }
                            });
                            if (val === null) {
                                $s.find('option').each(function () {
                                    var t = $.trim($(this).text()).toLowerCase();
                                    if (this.value && (t.indexOf(target) > -1 || target.indexOf(t) > -1)) { val = this.value; return false; }
                                });
                            }
                            if (val === null) {
                                $s.append($('<option>').val(name).text(name));
                                val = name;
                            }
                            $s.val(val).selectpicker('refresh');
                            clearError($s);
                        }

                        /* ============ PINCODE LOOKUP (api.postalpincode.in) ============ */
                        function lookupPincode($row, showFormatError) {
                            var $pin  = $row.find('.pincode-field');
                            var pin   = $.trim($pin.val());
                            var reqId = ($pin.data('req') || 0) + 1;
                            $pin.data('req', reqId);

                            clearPinState($row);
                            if (!pin) return;

                            if (!/^[1-9][0-9]{5}$/.test(pin)) {
                                if (showFormatError) setPinError($row, 'Please enter a valid 6-digit PIN code');
                                return;
                            }

                            $pin.data('pending', true);
                            showMsg($row, 'info', 'Checking pincode...');
                            var isCurrent = function () { return reqId === $pin.data('req'); };

                            var ctrl  = new AbortController();
                            var timer = setTimeout(function () { ctrl.abort(); }, 10000);

                            fetch('https://api.postalpincode.in/pincode/' + pin, { signal: ctrl.signal })
                                .then(function (response) { return response.json(); })
                                .then(function (data) {
                                    clearTimeout(timer);
                                    if (!isCurrent()) return;

                                    if (data && data[0] && data[0].Status === 'Success' && data[0].PostOffice && data[0].PostOffice.length) {
                                        var po = data[0].PostOffice[0];
                                        var city = (po.Block && po.Block !== 'NA') ? po.Block : po.Name;

                                        $pin.data('ok', true).removeData('pending');
                                        showMsg($row, 'info', '');
                                        $row.find('.city-field').val(city).removeClass('field-error');
                                        setState($row, po.State);
                                        $row.data('auto', true);
                                    } else {
                                        setPinError($row, 'Invalid PIN Code');
                                    }
                                })
                                .catch(function (error) {
                                    clearTimeout(timer);
                                    console.error('Error fetching PIN details:', error);
                                    if (!isCurrent()) return;
                                    $pin.removeData('pending');
                                    showMsg($row, 'warn', 'Unable to fetch details. Please enter city and state manually.');
                                });
                        }

                        /* ============ EVENTS (delegated: cloned rows work automatically) ============ */
                        $('#siteAddressTable')
                            .on('input', '.pincode-field', function () {
                                this.value = this.value.replace(/\D/g, '');
                                var $row = $(this).closest('tr');
                                clearPinState($row);
                                if (this.value.length === 6) lookupPincode($row, false);
                            })
                            .on('blur', '.pincode-field', function () {
                                var $row = $(this).closest('tr'), $pin = $(this);
                                if ($.trim($pin.val()) && !$pin.data('ok') && !$pin.data('pending') && !$pin.data('bad')) {
                                    lookupPincode($row, true);
                                }
                            })
                            .on('input change', FIELDS, function () {
                                var $el = $(this), $row = $el.closest('tr');
                                if (!$el.hasClass('pincode-field') && $.trim($el.val()) !== '') clearError($el);
                                syncRow($row);
                            });

                        /* ============ ADD NEW ROW ============ */
                        $('#policyCloneid5').on('click', function () {
                            tempCount5++;
                            var n = tempCount5;

                            var row = [
                                '<tr id="addmoreFile' + n + '">',
                                  '<td><input type="text" class="input-field" placeholder="Address1" name="Address1" id="Address1' + n + '"></td>',
                                  '<td><input type="text" class="input-field" placeholder="Address2" name="Address2" id="Address2' + n + '"></td>',
                                  '<td><input type="text" class="input-field pincode-field" placeholder="Pincode" name="pincodes" id="pincodes' + n + '" maxlength="6" inputmode="numeric" autocomplete="postal-code"><div class="pin-msg"></div></td>',
                                  '<td><input type="text" class="input-field city-field" placeholder="City" name="cityes" id="cityes' + n + '"></td>',
                                  '<td><select name="states" id="states' + n + '" class="select-input selectpicker state-select" data-live-search="true" data-width="100%" data-container="body">' + stateOptionsHtml + '</select></td>',
                                  '<td><textarea class="textarea-field remarkes" placeholder="Enter your remarks..." name="remarkes" id="remarkes' + n + '" maxlength="250"></textarea></td>',
                                  '<td style="text-align:center;"><div class="clone-action delete-parent-field" title="Remove" style="cursor:pointer; display:inline-block;">',
                                      '<img src="StorageYard/assets/images/clone-delete-btn.svg" onload="SVGInject(this)" alt="Remove"></div></td>',
                                '</tr>'
                            ].join('');

                            var $row = $(row).appendTo('#siteAddressTable tbody');
                            $row.find('select.state-select').val('');
                            $row.find('.selectpicker').selectpicker();
                            $('#policyCount5').val(n);
                        });

                        /* ============ DELETE NEW (unsaved) ROW ============ */
                        $('#siteAddressTable').on('click', '.delete-parent-field', function () {
                            $(this).closest('tr').remove();
                            $('#policyCount5').val($('#siteAddressTable tbody tr').length);
                        });

                        /* ============ FINAL VALIDATION ============ */
                        window.validateSiteAddress = function () {
                            var ok = true, $firstBad = null;

                            $('#siteAddressTable tbody tr').each(function () {
                                var $row = $(this);
                                if (!syncRow($row)) return;                   // completely empty row: skip

                                $row.find(REQUIRED_FIELDS).each(function () {
                                    var $el = $(this);
                                    if ($.trim($el.val()) === '') {
                                        ok = false;
                                        markError($el);
                                        $firstBad = $firstBad || $el;
                                    }
                                });

                                var $pin = $row.find('.pincode-field');
                                if ($pin.data('bad'))     { ok = false; $firstBad = $firstBad || $pin; }
                                if ($pin.data('pending')) { ok = false; showMsg($row, 'info', 'Please wait, checking pincode...'); $firstBad = $firstBad || $pin; }
                            });

                            if ($firstBad) {
                                ($firstBad.is('select') ? $firstBad.siblings('.dropdown-toggle') : $firstBad).focus();
                            }
                            return ok;
                        };

                        $('#siteAddressTable').closest('form').on('submit', function (e) {
                            // "Save As A Draft" (formaction=savePRMaster) skips this check
                            var sub = e.originalEvent && e.originalEvent.submitter;
                            if (sub && /savePRMaster/.test(sub.getAttribute('formaction') || '')) return;

                            if (!window.validateSiteAddress()) e.preventDefault();
                        });
                    });
                    </script>
                    
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="form-group">
                                <h6 class="fw-600">Add Vendor</h6>
                            </div>

                            <button type="button" onclick="searchAddVendor()"
                                    class="btn theme-btn d-flex align-items-center"
                                    data-toggle="modal" data-target="#iteamDocsUploadkgV">
                                <i class="fa fa-search " style="color: white;"></i>
                                Search
                            </button>

                        </div>
                        <script type="text/javascript">
                                    var str111 = document.getElementById("pr_no").value;
                                    function showuser111(str) {

                                    str = document.getElementById("pr_no").value;
                                            //alert("");
                                            strV = str;
                                            //if(win && win.closed){
                                            var xreq, ID;
                                            if (str == "") {
                                    document.getElementById("showtext1111").innerHTML = "";
                                            return;
                                    }
                                    if (window.XMLHttpRequest) {
                                    xreq = new XMLHttpRequest();
                                    }
                                    else {
                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                    }
                                    xreq.onreadystatechange = function () {
                                    if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext1111").innerHTML = xreq.responseText;
                                            setTimeout(() => {
                                            if ($('#VendorDetailsTable').length) {
                                            const table1 = initTable('#VendorDetailsTable');
                                            }

                                            }, 100);
                                            $('.select-input').selectpicker('refresh');
                                    }
                                    }

                                    xreq.open("get", "prMaster.htm?act=agaxTenderVendorDetails&q=" + str111, true);
                                            xreq.send();
                                            //}
                                            window.clearInterval(ID);
                                    }

                            var ID = window.setInterval(showuser111(str111), 1000);</script>

                        <div id="showtext1111"></div> 

                        <br>


                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                        <c:if test="${prType == 'Contract Civil'}">

                            <h6 class="fw-600 mr-4 mb-0">Civil Details</h6>
                            <button type="button" class="btn theme-btn" data-toggle="modal" data-target="#itemDetailsImport1" onclick="loadModelGood();">
                                <img src="StorageYard/assets/images/attachment.svg"
                                     class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)"
                                     alt="Attachment" >
                                Attachment
                            </button>
                            <!--<h6>Civil Details</h6><hr>-->
                        </c:if>
                    </div>
                   
                    <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                        <c:if test="${prType != 'Contract Civil'}">
                            <c:if test="${prType != 'Service'}">
                                <div class="form-group">
                                <h6 class="fw-600">Items Details</h6>
                            </div>
                                
                                <button type="button" class="btn theme-btn" data-toggle="modal" data-target="#itemDetailsImport1" onclick="loadModelGood();">
                                    <img src="StorageYard/assets/images/attachment.svg"
                                         class="attachment mr-1 d-inline"
                                         onload="SVGInject(this)"
                                         alt="Attachment" >
                                    Attachment
                                </button>
                            </c:if>

                            <c:if test="${prType == 'Service'}">
                                <div class="form-group">
                                <h6 class="fw-600">Items Details For Service</h6>
                            </div>
                               
                                <button type="button" class="btn theme-btn" data-toggle="modal" data-target="#itemDetailsImport1" onclick="loadModelGood();">
                                    <img src="StorageYard/assets/images/attachment.svg"
                                         class="attachment mr-1 d-inline"
                                         onload="SVGInject(this)"
                                         alt="Attachment" >
                                    Attachment
                                </button>
                            </c:if>
                        </c:if>
                    </div>
                    <script type="text/javascript">
                                //  var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
                                //  win2.close();
                                var str5 = document.getElementById("pr_no").value;
                                var ID1;
                                function showuser1(str1) {
                                str1 = document.getElementById("pr_no").value;
                                        //var str5=str1;
                                        //  alert(str1);
                                        //if(win2 && win2.closed ){
                                        var xreq1;
                                        if (str1 === "") {
                                document.getElementById("showtext1").innerHTML = "";
                                        return;
                                }

                                try {
                                xreq1 = new XMLHttpRequest();
                                } catch (e) {
                                try {
                                xreq1 = new ActiveXObject("Msxml2.XMLHTTP");
                                } catch (e) {
                                try {
                                xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                                } catch (e) {
                                alert("No AJAX!?");
                                        return false;
                                }
                                }
                                }

                                xreq1.onreadystatechange = function () {
                                if (xreq1.readyState == 4 && xreq1.status == 200) {
                                document.getElementById("showtext1").innerHTML = xreq1.responseText;
                                        setTimeout(()=> {
                                        if ($('#itemsDetailsTable').length) {
                                        const table1 = initNoPageTable('#itemsDetailsTable');
                                                $('#entriesPerPage').on('change', function () {
                                        table1.page.len($(this).val()).draw();
                                        });
                                                $('#searchBox').on('keyup', function () {
                                        table1.search(this.value).draw();
                                        });
                                                setTimeout(insertMiddleScroll, 100);
                                                function insertMiddleScroll() {
                                                const dtScroll = $('#itemsDetailsTable').closest('.dt-scroll');
                                                        const head = dtScroll.find('.dt-scroll-head');
                                                        const headInner = head.find('.dt-scroll-headInner');
                                                        const body = dtScroll.find('.dt-scroll-body');
                                                        const foot = dtScroll.find('.dt-scroll-foot');
                                                        if (!dtScroll.length || !body.length) return;
                                                        if (!dtScroll.find('.middle-scrollbar').length) {
                                                $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
                                                }

                                                const middleScroll = dtScroll.find('.middle-scrollbar');
                                                        const inner = middleScroll.find('div');
                                                        inner.width(body.get(0).scrollWidth);
                                                        middleScroll.off('scroll');
                                                        body.off('scroll');
                                                        head.off('scroll');
                                                        foot.off('scroll');
                                                        function syncScroll(source, scrollLeft) {
                                                        if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                                                                if (source !== 'body') body.scrollLeft(scrollLeft);
                                                                if (source !== 'head') head.scrollLeft(scrollLeft);
                                                                if (source !== 'foot') foot.scrollLeft(scrollLeft); // ✅ Footer scroll sync
                                                        }

                                                middleScroll.on('scroll', function() {
                                                syncScroll('middle', $(this).scrollLeft());
                                                });
                                                        body.on('scroll', function() {
                                                        syncScroll('body', $(this).scrollLeft());
                                                        });
                                                        head.on('scroll', function() {
                                                        syncScroll('head', $(this).scrollLeft());
                                                        });
                                                        foot.on('scroll', function() {
                                                        syncScroll('foot', $(this).scrollLeft());
                                                        });
                                                }
                                        }
                                        }, 200);
                                }
                                }


                                xreq1.open("GET", "prMaster.htm?act=agaxPRItemDetails&q=" + str5, true);
                                        xreq1.send();
                                        //}
                                        window.clearInterval(ID1);
                                }
                        ID1 = window.setInterval(showuser1(str5), 1000);</script>

                    <div id="showtext1" class="bg-white"></div>


                    <c:if test="${prType == 'Contract' || prType == 'Contract Civil' || prType == 'Contract Electrical'}">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <c:if test="${prType == 'Contract Civil'}">

                                <h6 class="fw-600 mr-4 mb-0"> Steel Details</h6>
                                <button type="button" class="btn theme-btn" data-toggle="modal" data-target="#itemDetailsService" onclick="loadModelService();">
                                    <img src="StorageYard/assets/images/attachment.svg"
                                         class="attachment mr-1 d-inline"
                                         onload="SVGInject(this)"
                                         alt="Attachment" >
                                    Attachment
                                </button>       



                            </c:if>
                            <c:if test="${prType != 'Contract Civil'}"> 

                                <h6 class="fw-600 mr-4 mb-0">Item Details For Service</h6>
                                <button type="button" class="btn theme-btn" data-toggle="modal" data-target="#itemDetailsService" onclick="loadModelService();">
                                    <img src="StorageYard/assets/images/attachment.svg"
                                         class="attachment mr-1 d-inline"
                                         onload="SVGInject(this)"
                                         alt="Attachment" >
                                    Attachment
                                </button>     
                            </c:if>

                        </div>          

                        <script type="text/javascript">
                                    //  var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
                                    //  win2.close();
                                    var str5 = document.getElementById("pr_no").value;
                                    var ID1;
                                    function showuser11(str1) {
                                    str1 = document.getElementById("pr_no").value;
                                            //var str5=str1;
                                            //  alert(str1);
                                            //if(win2 && win2.closed ){
                                            var xreq1;
                                            if (str1 === "") {
                                    document.getElementById("showtext11").innerHTML = "";
                                            return;
                                    }

                                    try {
                                    xreq1 = new XMLHttpRequest();
                                    } catch (e) {
                                    try {
                                    xreq1 = new ActiveXObject("Msxml2.XMLHTTP");
                                    } catch (e) {
                                    try {
                                    xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                                    } catch (e) {
                                    alert("No AJAX!?");
                                            return false;
                                    }
                                    }
                                    }

                                    xreq1.onreadystatechange = function () {
                                    if (xreq1.readyState == 4 && xreq1.status == 200) {
                                    document.getElementById("showtext11").innerHTML = xreq1.responseText;
                                            setTimeout(() => {
                                            if ($('#serviceDetailsTable').length) {
                                            const table1 = initNoPageTable('#serviceDetailsTable');
                                                    $('#entriesPerPage').on('change', function () {
                                            table1.page.len($(this).val()).draw();
                                            });
                                                    $('#searchBox').on('keyup', function () {
                                            table1.search(this.value).draw();
                                            });
                                                    setTimeout(insertMiddleScroll, 100);
                                                    function insertMiddleScroll() {
                                                    const dtScroll = $('#serviceDetailsTable').closest('.dt-scroll');
                                                            const head = dtScroll.find('.dt-scroll-head');
                                                            const headInner = head.find('.dt-scroll-headInner');
                                                            const body = dtScroll.find('.dt-scroll-body');
                                                            const foot = dtScroll.find('.dt-scroll-foot');
                                                            if (!dtScroll.length || !body.length) return;
                                                            if (!dtScroll.find('.middle-scrollbar').length) {
                                                    $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
                                                    }

                                                    const middleScroll = dtScroll.find('.middle-scrollbar');
                                                            const inner = middleScroll.find('div');
                                                            inner.width(body.get(0).scrollWidth);
                                                            middleScroll.off('scroll');
                                                            body.off('scroll');
                                                            head.off('scroll');
                                                            foot.off('scroll');
                                                            function syncScroll(source, scrollLeft) {
                                                            if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                                                                    if (source !== 'body') body.scrollLeft(scrollLeft);
                                                                    if (source !== 'head') head.scrollLeft(scrollLeft);
                                                                    if (source !== 'foot') foot.scrollLeft(scrollLeft); // ✅ Footer scroll sync
                                                            }

                                                    middleScroll.on('scroll', function() {
                                                    syncScroll('middle', $(this).scrollLeft());
                                                    });
                                                            body.on('scroll', function() {
                                                            syncScroll('body', $(this).scrollLeft());
                                                            });
                                                            head.on('scroll', function() {
                                                            syncScroll('head', $(this).scrollLeft());
                                                            });
                                                            foot.on('scroll', function() {
                                                            syncScroll('foot', $(this).scrollLeft());
                                                            });
                                                    }
                                            }
                                            }, 200);
                                    }
                                    }


                                    xreq1.open("GET", "prMaster.htm?act=agaxPRItemDetails1&q=" + str5, true);
                                            xreq1.send();
                                            //}
                                            window.clearInterval(ID1);
                                    }
                            ID1 = window.setInterval(showuser11(str5), 1000);</script>


                        <div id="showtext11"></div>  

                    </c:if> 


                    

                    <div class="form-group">
                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                            <div class="d-flex align-items-center">
                                <h6 class="fw-600">Technical Document</h6>
                            </div>
                            

                            <button type="button" class="btn theme-btn d-flex align-items-center" data-toggle="modal"
                                    data-target="#techDocsUpload" onclick="requestDocTechTab();">
                                <img src="StorageYard/assets/images/attachment.svg" class="attachment mr-1 d-inline"
                                     onload="SVGInject(this)" alt="User Image">
                                Attachment
                            </button>

                        </div>

                        <script type="text/javascript">
                                    //    var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                                    //    win.close();
                                    //win.onunload =showuser;

                                    var str7 = document.getElementById("pr_no").value;
                                    function showuser7(str) {
                                    str = document.getElementById("pr_no").value;
                                            //alert("");
                                            str7 = str;
                                            //if(win && win.closed){
                                            var xreq, ID;
                                            if (str == "") {
                                    document.getElementById("showtext7").innerHTML = "";
                                            return;
                                    }
                                    if (window.XMLHttpRequest) {
                                    xreq = new XMLHttpRequest();
                                    }
                                    else {
                                    xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                    }
                                    xreq.onreadystatechange = function () {
                                    if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext7").innerHTML = xreq.responseText;
                                            setTimeout(() => {
                                            if ($('#techDocumentsTable0').length) {
                                            const table1 = initNoPageTable('#techDocumentsTable0');
                                            }
                                            }, 100);
                                    }
                                    }

                                    xreq.open("get", "prMaster.htm?act=agaxTechnicalFileDetails&bid_type=1&q=" + str7, true);
                                            xreq.send();
                                            //}
                                            window.clearInterval(ID);
                                    }

                            var ID = window.setInterval(showuser7(str7), 1000);</script>
                        <div id="showtext7" class="bg-white"></div>


                        <div class="col-12 p-0">
                            <div class="form-group comment-box">
                                <label class="control-label">Remark :<span class="text-danger">*</span></label>
                                <textarea type="text" maxlength="250" class="textarea-field comment" id="remarkss" name="remarkss" required>${prMaster.remarks}</textarea>
                                
                            </div>
                        </div>
                       
                        <script type="text/javascript">
                                    document.addEventListener("DOMContentLoaded", function () {
                                    var textarea = document.getElementById("remarks1");
                                            var counter = document.getElementById("charCount_remarkss");
                                            var maxChars = 250;
                                            function updateCounter() {
                                            var count = textarea.value.length;
                                                    var remaining = maxChars - count;
                                                    counter.textContent = remaining + " characters remaining";
                                                    if (remaining <= 20) {
                                            counter.style.color = "red";
                                            } else {
                                            counter.style.color = "green";
                                            }
                                            }

                                    updateCounter();
                                            textarea.addEventListener("input", updateCounter);
                                    });
                        </script>
                    </div>
                                <div class="form-group">
                                <h6 class="fw-600">PR Approval User</h6>
                            </div>
                    
                    <div class="col-12"></div>
                    <div class="col-12 p-0">
                        <div class="form-group">
                            <label  class="label">Approval User<span class="text-danger">*</span> </label>
                           <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                           <select id="userList1"  name="userList1"  class="select-input" required>
                        <option value="">--SELECT--</option>
                        <c:forEach var="employeeMaster1" items="${employeeMaster1}">
                            <c:choose>
                                <c:when test="${employeeMaster1.employeeCode eq  prUser}">
                                    <option value="${employeeMaster1.employeeCode}" selected="true">${employeeMaster1.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${employeeMaster1.employeeCode}" >${employeeMaster1.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select> 
                        </div>
                    </div>
                    <c:if test="${not empty approvalList}">
                    <table id="commonTable6" class="table  table-striped bg-white" style="min-width: 100%;" align="Center"  >
                        <thead>
                            <tr>
                                <th>PR No.</th>
                                <th>User</th>
                                <th>Date Time</th>
                                <th>Comment </th>
                                <th>Approval Status</th>
                        </thead>
                        </tr>
                        <tbody>

                            <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                <tr> 
                                    <td>${approvalList.prNo}</td>
                                    <td>${approvalList.userId}</td>
                                    <td>${approvalList.dateTime}</td>
                                    <td>${approvalList.comment}</td>
                                    <td>${approvalList.approvalStatus}</td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment:<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" required name="comment" >${approvalComment}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="cta d-flex justify-content-center align-items-center">
                             <button type="submit"class="btn theme-btn mr-3" id="PRSAVEDRAFT"    formaction="prMaster.htm?act=prSaveAsDraftSubmit">
                                Save As A Draft
                            </button>
                            <button type="submit" class="btn theme-btn" style="width: 100px;" onclick="return handleSubmit(event)" title="" value="SUBMIT">Submit </button>
                            
                        </div>
                    </div>
                        
                          <script>
                document.getElementById("PRSAVEDRAFT").addEventListener('click', function () {
        var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
        
                requiredFields.forEach(function (field) {
                field.removeAttribute('required');
                });
        });</script>           
          <script>
                document.getElementById("PRSAVEDRAFTS").addEventListener('click', function () {
        var requiredFields = document.querySelectorAll('input[required], textarea[required], file[required], select[required]');
        
                requiredFields.forEach(function (field) {
                field.removeAttribute('required');
                });
        });
            </script>  
            
                </form:form>

                <form:form id="myForm" enctype="multipart/form-data" commandName="prMaster" name="form"
                           class="form-horizontal" role="form">
                    <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />
                    <input type="hidden" id="ref_no" name="ref_no1" value="${ref_no}" />

                    <div class="modal fade" id="itemDetailsImport1" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="itemDetailsImportLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="itemDetailsImportLabel1">Items Details Attachments</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal" onclick="showuser1();">Close</button>                                   
                                    </div>
                                </div>
                                <div class="modal-body import-items px-lg-4 position-relative blank">
                                    <div class="file-upload-base file-upload-area d-flex flex-column align-items-center justify-content-center rounded-3"
                                         id="file-upload-area" style="min-height: 250px;">
                                        <div class="upload-icon pb-3">
                                            <img src="StorageYard/assets/images/upload-icon.svg" class="mx-auto" onload="SVGInject(this)" alt="Upload Icon">
                                        </div>
                                        <p class="fw-600 upload-text mb-2 fs-14">Drag & drop files
                                            or
                                            <span class="gradient-text underline-text browseFile" data-target="#browseIteamFile" id="browseFile">Browse</span>
                                        </p>
                                        <p class="fs-13">Supported formats:
                                            <a href="StorageYard/Sample_File For Create PR new.xlsx">.xlsx</a>
                                        </p>
                                        <input type="file" id="browseIteamFile" name="service_file" hidden accept=".xlsx" />
                                    </div>

                                    <div class="importedDataTable mt-4 pt-2">
                                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                            <h6 class="fw-600 mr-4 mb-0 d-none" id="itemDetailsTitle">Please Wait</h6>
                                            <button type="button" id="deleteSelectedIteam" class="btn theme-btn delete-btn d-none">
                                                <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)" alt="Delete Icon">
                                                Delete Selected
                                            </button>
                                        </div>
                                        <div id="itemDetailsDiv1" class="bg-white d-none"></div>
                                        <script>
                                            document.getElementById('browseIteamFile').addEventListener('change', function () {
                                                var file = this.files[0];
                                                if (!file) {
                                                    return;
                                                }

                                                var fileName = file.name.toLowerCase();
                                                if (!fileName.endsWith('.xlsx')) {
                                                    this.value = '';

                                                    bootoast.toast({
                                                        message: 'Please upload only an Excel (.xlsx) file.',
                                                        type: 'error',
                                                        position: 'top-center',
                                                        timeout: 2.5,
                                                        animationDuration: 250,
                                                        dismissable: true
                                                    });
                                                    return;
                                                }

                                                    $('#itemDetailsTitle').removeClass('d-none');
                                                    var form = document.getElementById('myForm');
                                                    var formData = new FormData(form);
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'prMaster.htm?act=addServicePRSubmit', true);
                                                    xhr.onload = function () {
                                                    if (xhr.status === 200) {
//                                                    document.getElementById('itemDetailsDiv1').innerHTML = xhr.responseText;
                                                            $('#itemDetailsDiv1').removeClass('d-none');
//                                                           // initsetupImportItems();
                                                                loadModelGood();
//                                                                 setupImportItemsTable1();
                                                            Swal.fire({
                                                            icon: 'success',
                                                                    title: 'Success',
                                                                    text: ' Items Details attachment added successfully',
                                                                    confirmButtonColor: '#3085d6',
                                                                    confirmButtonText: 'OK'
                                                            });
                                                    } else {
                                                    console.error("Error occurred: " + xhr.statusText);
                                                            Swal.fire({
                                                            icon: 'error',
                                                                    title: 'Oops...',
                                                                    text: 'Something went wrong! Please try again.'
                                                            });
                                                    }
                                                    };
                                                    xhr.onerror = function () {
                                                    console.error("Request failed.");
                                                            Swal.fire({
                                                            icon: 'error',
                                                                    title: 'Network Error',
                                                                    text: 'Unable to connect to the server. Please check your connection.'
                                                            });
                                                    };
                                                    xhr.send(formData);
                                            });
//                                                    function initsetupImportItems() {
                                                   
                                                   
                                            // Service tab script
                                            function setupImportItemsTable1() {
                                            if ($('#importItemsDetailsTable1').length) {
                                            initNoPageTable('#importItemsDetailsTable1');
                                                    $('#itemDetailsTitle').addClass('d-none');
                                                    $('#select_all_Iteam').on('change', function () {
                                            $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                                            });
                                                    $('#importItemsDetailsTable1 tbody').on('change', '.rowCheckbox', function () {
                                            const anyChecked = $('.rowCheckbox:checked').length > 0;
                                                    $('#deleteSelectedIteam').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                                                    $('#select_all_Iteam').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                                            });
                                                    $('#deleteSelectedIteam').on('click', function () {
                                            var selectedIds = [];
                                                    $('.rowCheckbox:checked').each(function () {
                                            var selectedId = $(this).val();
                                                    selectedIds.push(selectedId);
                                            });
                                                    if (selectedIds.length === 0) {
                                            return Swal.fire({
                                            icon: 'warning',
                                                    title: 'No Selection',
                                                    text: 'Please select at least one row to delete.'
                                            });
                                            }

                                            const msg = selectedIds.length === 1
                                                    ? 'Are you sure you want to delete this item details?'
                                                    : `Are you sure you want to delete these ${selectedIds.length} item details?`;
                                                    const confirmText = selectedIds.length === 1
                                                    ? 'Yes, delete it!'
                                                    : 'Yes, delete them!';
                                                    Swal.fire({
                                                    title: msg,
                                                            text: 'You will not be able to recover these records!',
                                                            icon: 'warning',
                                                            showCancelButton: true,
                                                            confirmButtonText: confirmText,
                                                            cancelButtonText: 'No, cancel',
                                                            reverseButtons: true,
                                                            customClass: {
                                                            confirmButton: 'confirm-delete',
                                                                    cancelButton: 'theme-btn light-btn'
                                                            },
                                                    }).then((result) => {
                                            if (result.isConfirmed) {
                                            $.ajax({
                                            url: 'prMaster.htm?act=deletePrItemMaterial&Ids=' + selectedIds.join(','),
                                                    type: 'POST',
                                                    data: JSON.stringify({ ids: selectedIds }),
                                                    contentType: 'application/json',
                                                    success: function (response) {
                                                    Swal.fire({
                                                    icon: 'success',
                                                            title: 'Deleted!',
                                                            text: response.message
                                                    });
                                                            $('#importItemsDetailsTable1').DataTable().rows(function (idx, data, node) {
                                                    return $(node).find('.rowCheckbox').is(':checked');
                                                    }).remove().draw();
                                                            $('#deleteSelectedIteam').addClass('d-none');
                                                    },
                                                    error: function (xhr) {
                                                    Swal.fire({
                                                    icon: 'error',
                                                            title: 'Error!',
                                                            text: 'Error deleting records: ' + xhr.responseText
                                                    });
                                                    }
                                            });
                                            }
                                            });
                                            });
                                                    setTimeout(insertMiddleScroll, 100);
                                                    function insertMiddleScroll() {
                                                    const dtScroll = $('#importItemsDetailsTable1').closest('.dt-scroll');
                                                            const head = dtScroll.find('.dt-scroll-head');
                                                            const headInner = head.find('.dt-scroll-headInner');
                                                            const body = dtScroll.find('.dt-scroll-body');
                                                            const foot = dtScroll.find('.dt-scroll-foot');
                                                            if (!dtScroll.length || !body.length) return;
                                                            if (!dtScroll.find('.middle-scrollbar').length) {
                                                    $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
                                                    }

                                                    const middleScroll = dtScroll.find('.middle-scrollbar');
                                                            const inner = middleScroll.find('div');
                                                            inner.width(body.get(0).scrollWidth);
                                                            middleScroll.off('scroll');
                                                            body.off('scroll');
                                                            head.off('scroll');
                                                            foot.off('scroll');
                                                            function syncScroll(source, scrollLeft) {
                                                            if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                                                                    if (source !== 'body') body.scrollLeft(scrollLeft);
                                                                    if (source !== 'head') head.scrollLeft(scrollLeft);
                                                                    if (source !== 'foot') foot.scrollLeft(scrollLeft); // ✅ Footer scroll sync
                                                            }

                                                    middleScroll.on('scroll', function() {
                                                    syncScroll('middle', $(this).scrollLeft());
                                                    });
                                                            body.on('scroll', function() {
                                                            syncScroll('body', $(this).scrollLeft());
                                                            });
                                                            head.on('scroll', function() {
                                                            syncScroll('head', $(this).scrollLeft());
                                                            });
                                                            foot.on('scroll', function() {
                                                            syncScroll('foot', $(this).scrollLeft());
                                                            });
                                                    }
                                            }
                                            }
                                        </script>
                                         <div id="resultDivPipe" class="bg-white"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--Item Details For Service-->
                    <div class="modal fade" id="itemDetailsService" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="itemDetailsServiceLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="itemDetailsServiceLabel1">Items Details Attachments</h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                                                onclick="showuser11();">Close</button>
                                        <%--                                        <button type="button" class="btn theme-btn ml-3 d-none"
                                                                                    id="importSubmitBtn1">Submit</button>--%>
                                    </div>
                                </div>
                                <div class="modal-body import-items px-lg-4 position-relative blank">
                                    <div class="file-upload-base file-upload-area d-flex flex-column align-items-center justify-content-center rounded-3"
                                         id="file-upload-area" style="min-height: 250px;">
                                        <div class="upload-icon pb-3">
                                            <img src="StorageYard/assets/images/upload-icon.svg" class="mx-auto" onload="SVGInject(this)" alt="Upload Icon">
                                        </div>
                                        <p class="fw-600 upload-text mb-2 fs-14">Drag & drop files
                                            or
                                            <span class="gradient-text underline-text browseFile" data-target="#browseServiceFile" id="browseFile1">Browse</span>
                                        </p>
                                        <p class="fs-13">Supported formats:
                                            <a href="StorageYard/Sample_File For Create PR new.xlsx">.xlsx</a>
                                        </p>
                                        <input type="file" id="browseServiceFile" name="iteamSampleFile" hidden accept=".xlsx" />
                                    </div>

                                    <div class="importedDataTable mt-4 pt-2">
                                        <div class="content-top mb-3 d-flex align-items-center justify-content-between">
                                            <h6 class="fw-600 mr-4 mb-0 d-none" id="itemDetailsServiceTitle">Please Wait</h6>

                                            <button type="button" id="deleteSelectedservice"
                                                    class="btn theme-btn delete-btn d-none">
                                                <img src="StorageYard/assets/images/delete-icon.svg" class="icon"
                                                     onload="SVGInject(this)" alt="Delete Icon">
                                                Delete Selected
                                            </button>
                                        </div>
                                        <div id="iteamServiceDiv1" class="bg-white d-none"> </div>

                                        <script>
                                                    document.getElementById('browseServiceFile').addEventListener('change', function () {
                                                    var file = this.files[0];
                                                    if (!file) {
                                                        return;
                                                    }

                                                    var fileName = file.name.toLowerCase();

                                                    if (!fileName.endsWith('.xlsx')) {

                                                        this.value = '';
                                                        bootoast.toast({
                                                            message: 'Please upload only an Excel (.xlsx) file.',
                                                            type: 'error',
                                                            position: 'top-center',
                                                            timeout: 2.5,
                                                            animationDuration: 250,
                                                            dismissable: true
                                                        });

                                                        return;
                                                    }
                                                    $('#itemDetailsServiceTitle').removeClass('d-none');
                                                    var form = document.getElementById('myForm');
                                                    var formData = new FormData(form);
                                                    var xhr = new XMLHttpRequest();
                                                    xhr.open('POST', 'prMaster.htm?act=addServicePRSubmit1', true);
                                                    xhr.onload = function () {
                                                    if (xhr.status === 200) {
//                                                    document.getElementById('iteamServiceDiv1').innerHTML = xhr.responseText;
                                                            $('#iteamServiceDiv1').removeClass('d-none');
                                                             loadModelService();
//                                                            initsetupImportService();
                                                            Swal.fire({
                                                            icon: 'success',
                                                                    title: 'Success',
                                                                    text: ' Items Details attachment added successfully',
                                                                    confirmButtonColor: '#3085d6',
                                                                    confirmButtonText: 'OK'
                                                            });
                                                    } else {
                                                    console.error("Error occurred: " + xhr.statusText);
                                                            Swal.fire({
                                                            icon: 'error',
                                                                    title: 'Oops...',
                                                                    text: 'Something went wrong! Please try again.'
                                                            });
                                                    }
                                                    };
                                                    xhr.onerror = function () {
                                                    console.error("Request failed.");
                                                            Swal.fire({
                                                            icon: 'error',
                                                                    title: 'Network Error',
                                                                    text: 'Unable to connect to the server. Please check your connection.'
                                                            });
                                                    };
                                                    xhr.send(formData);
                                            });
//                                                    function initsetupImportService() {
//                                                    setupImportItemsServiceTable1();
//                                                    }

                                            // ServiceItesm tab script
                                            function setupImportItemsServiceTable1() {
                                            if ($('#importItemsServiceTable1').length) {
                                            initNoPageTable('#importItemsServiceTable1');
                                                    $('#itemDetailsServiceTitle').addClass('d-none');
                                                    $('#select_all_service').on('change', function () {
                                            $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                                            });
                                                    $('#importItemsServiceTable1 tbody').on('change', '.rowCheckbox', function () {
                                            const anyChecked = $('.rowCheckbox:checked').length > 0;
                                                    $('#deleteSelectedservice').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                                                    $('#select_all_service').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                                            });
                                                    $('#deleteSelectedservice').on('click', function () {
                                            var selectedIds = [];
                                                    $('.rowCheckbox:checked').each(function () {
                                            var selectedId = $(this).val();
                                                    selectedIds.push(selectedId);
                                            });
                                                    if (selectedIds.length === 0) {
                                            return Swal.fire({
                                            icon: 'warning',
                                                    title: 'No Selection',
                                                    text: 'Please select at least one row to delete.'
                                            });
                                            }

                                            const msg = selectedIds.length === 1
                                                    ? 'Are you sure you want to delete this service item details?'
                                                    : `Are you sure you want to delete these ${selectedIds.length} service item details?`;
                                                    const confirmText = selectedIds.length === 1
                                                    ? 'Yes, delete it!'
                                                    : 'Yes, delete them!';
                                                    Swal.fire({
                                                    title: msg,
                                                            text: 'You will not be able to recover these records!',
                                                            icon: 'warning',
                                                            showCancelButton: true,
                                                            confirmButtonText: confirmText,
                                                            cancelButtonText: 'No, cancel',
                                                            reverseButtons: true,
                                                            customClass: {
                                                            confirmButton: 'confirm-delete',
                                                                    cancelButton: 'theme-btn light-btn'
                                                            },
                                                    }).then((result) => {
                                            if (result.isConfirmed) {
                                            $.ajax({
                                            url: 'prMaster.htm?act=deletePrItemMaterial1&Ids=' + selectedIds.join(','),
                                                    type: 'POST',
                                                    data: JSON.stringify({ ids: selectedIds }),
                                                    contentType: 'application/json',
                                                    success: function (response) {
                                                    Swal.fire({
                                                    icon: 'success',
                                                            title: 'Deleted!',
                                                            text: response.message
                                                    });
                                                            $('#importItemsServiceTable1').DataTable().rows(function (idx, data, node) {
                                                    return $(node).find('.rowCheckbox').is(':checked');
                                                    }).remove().draw();
                                                            $('#deleteSelectedservice').addClass('d-none');
                                                    },
                                                    error: function (xhr) {
                                                    Swal.fire({
                                                    icon: 'error',
                                                            title: 'Error!',
                                                            text: 'Error deleting records: ' + xhr.responseText
                                                    });
                                                    }
                                            });
                                            }
                                            });
                                            });
                                                    setTimeout(insertMiddleScroll, 100);
                                                    function insertMiddleScroll() {
                                                    const dtScroll = $('#importItemsServiceTable1').closest('.dt-scroll');
                                                            const head = dtScroll.find('.dt-scroll-head');
                                                            const headInner = head.find('.dt-scroll-headInner');
                                                            const body = dtScroll.find('.dt-scroll-body');
                                                            const foot = dtScroll.find('.dt-scroll-foot');
                                                            if (!dtScroll.length || !body.length) return;
                                                            if (!dtScroll.find('.middle-scrollbar').length) {
                                                    $('<div class="middle-scrollbar"><div></div></div>').insertAfter(head);
                                                    }
                                                    const middleScroll = dtScroll.find('.middle-scrollbar');
                                                            const inner = middleScroll.find('div');
                                                            inner.width(body.get(0).scrollWidth);
                                                            middleScroll.off('scroll');
                                                            body.off('scroll');
                                                            head.off('scroll');
                                                            foot.off('scroll');
                                                            function syncScroll(source, scrollLeft) {
                                                            if (source !== 'middle') middleScroll.scrollLeft(scrollLeft);
                                                                    if (source !== 'body') body.scrollLeft(scrollLeft);
                                                                    if (source !== 'head') head.scrollLeft(scrollLeft);
                                                                    if (source !== 'foot') foot.scrollLeft(scrollLeft); // ✅ Footer scroll sync
                                                            }

                                                    middleScroll.on('scroll', function() {
                                                    syncScroll('middle', $(this).scrollLeft());
                                                    });
                                                            body.on('scroll', function() {
                                                            syncScroll('body', $(this).scrollLeft());
                                                            });
                                                            head.on('scroll', function() {
                                                            syncScroll('head', $(this).scrollLeft());
                                                            });
                                                            foot.on('scroll', function() {
                                                            syncScroll('foot', $(this).scrollLeft());
                                                            });
                                                    }
                                            }
                                            }
                                        </script>
                                         <div id="resultDivPipe1" class="bg-white"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--Technical Document-->                                                     
                    <div class="modal fade" id="techDocsUpload" data-backdrop="static" data-keyboard="false"
                         tabindex="-1" aria-labelledby="techDocsUploadLabel" aria-hidden="true">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="techDocsUploadLabel">Attach Technical Document
                                    </h5>
                                    <div class="cta-btn d-flex align-items-center">
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser7(id);"
                                                data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3"
                                                id="uploadSubmitBtn">Submit</button>
                                    </div>
                                </div>

                                <div class="modal-body">

                                    <table id="commonDocTable" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">
                                        <thead>
                                            <tr>
                                                <th>Technical Document</th>
                                                <th >Attachment Required From Vendor</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <div class="col-md-12">
                                                        <input type="file" name="generalfile" id="generalfile" class="input-field py-2 fs-12i">
                                                    </div>
                                                </td>
                                                <td class="text-center" >
                                                    <input type="checkbox" name="attachment_required" id="attachment_required" value="1" style="transform: scale(1.5);">
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>

                                    <div id="AjaxTechDiv" class="p-1"></div>

                                </div>
                            </div>
                        </div>
                    </div>             

                    <script type="text/javascript">

                                const bootoast = window.Bootoast;
                                document.getElementById('uploadSubmitBtn').addEventListener('click', function () {
                        const fileInput = document.getElementById("generalfile");
                                const checkbox = document.getElementById("attachment_required");
                                const refNoValue = document.getElementById('tender_no')?.value;
                                if (!fileInput || fileInput.files.length === 0) {

                        Swal.fire({
                        icon: 'warning',
                                title: 'Please select a file to upload.',
                                timer: 3000,
                                showConfirmButton: false,
                                position: 'top'
                        });
                                return;
                        }

                        var form = document.getElementById('myForm');
                                var formData = new FormData(form);
                                formData.append('generalfile', fileInput.files[0]);
                                formData.append('policyCount', 1);
                                //            console.log(refNoValue);
                                //            if (refNoValue) {
                                //                formData.append('ref_no', refNoValue);
                                //            }

                                const xhr = new XMLHttpRequest();
                                xhr.open('POST', 'prMaster.htm?act=addTechnicalFileDetailsSubmit', true);
                                xhr.onload = function () {
                                if (xhr.status === 200) {
                                const uploadedFileName = fileInput.files[0].name;
                                        Swal.fire({
                                        icon: 'success',
                                                title: 'Technical Document Successfully Added.',
                                                timer: 3000,
                                                showConfirmButton: false,
                                                position: 'top'
                                        });
                                        requestDocTechTab();
                                        // Hide modal
                                        // $('#techDocsUpload').modal('hide');
                                        // Reset file input
                                        fileInput.value = '';
                                } else {
                                Swal.fire({
                                icon: 'error',
                                        title: 'Upload failed: ' + xhr.statusText,
                                        timer: 4000,
                                        showConfirmButton: false,
                                        position: 'top'
                                });
                                }
                                };
                                xhr.onerror = function () {
                                console.error('Network error.');
                                        Swal.fire({
                                        icon: 'error',
                                                title: 'Network error occurred.',
                                                timer: 4000,
                                                showConfirmButton: false,
                                                position: 'top'
                                        });
                                };
                                xhr.send(formData);
                                setupImportTechnicalDocument();
                        });
                                //            function initResultContent() {
                                //          }
                    </script>  
                    <script type="text/javascript">
                                var str7 = document.getElementById("pr_no").value;
                                function requestDocTechTab(str) {
                                str = document.getElementById("pr_no").value;
                                        str7 = str;
                                        var xreq, ID;
                                        if (str == "") {
                                document.getElementById("AjaxTechDiv").innerHTML = "";
                                        return;
                                }
                                if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                                }
                                else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                                }
                                xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                document.getElementById("AjaxTechDiv").innerHTML = xreq.responseText;
                                        setTimeout(() => {
                                        if ($('#AjaxTechTab').length) {
                                        const table1 = initDocTable('#AjaxTechTab');
                                        }
                                        }, 100);
                                }
                                }

                                xreq.open("get", "prMaster.htm?act=addTechnicalFileDetails&ref_no=" + str7, true);
                                        xreq.send();
                                        window.clearInterval(ID);
                                }

                        var ID = window.setInterval(requestDocTechTab(str7), 1000);</script>
                    </div>      


                    <div class="modal fade" id="iteamDocsUploadkgV" data-backdrop="static"
                         data-keyboard="false" tabindex="-1" aria-labelledby="iteamDocsUploadkgVLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">

                                <div class="modal-header align-items-center">
                                    <h5 class="modal-title" id="iteamDocsUploadkgVLabel">Vendor Details :</h5>
                                    <div class="cta-btn d-flex align-items-center"> 
                                        <button type="button" class="btn theme-btn light-btn" onclick="showuser111(id);" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn theme-btn ml-3" onclick="submitCheckedVendorkg11()" title="">Search</button>
                                        <button type="button" class="btn theme-btn ml-3"  onclick="submitCheckedVendor11()" title="">Add</button>                                            
                                    </div>
                                </div>
                                <div class="modal-body">
                                    <div class="bg-white" id="IteamDetailsDivV">
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <script type="text/javascript">
                                function searchAddVendor() {
                                const formData = new FormData();
                                        const queryParams = new URLSearchParams(formData).toString();
                                        const xhr = new XMLHttpRequest();
                                        xhr.onreadystatechange = function () {
                                        if (xhr.readyState === 4 && xhr.status === 200) {
                                        const resultDiv = document.getElementById("IteamDetailsDivV");
                                                if (resultDiv) {
                                        resultDiv.innerHTML = xhr.responseText;
                                                initResultContent();
                                                setTimeout(() => {

                                                }, 100);
                                        } else {
                                        console.error("Element with ID 'IteamDetailsDivV' not found.");
                                        }
                                        }
                                        };
                                        xhr.open("GET", "prMaster.htm?act=searchVendorToAddInPr&ref_no=${ref_no}", true);
                                        xhr.send();
                                        function initResultContent() {
                                        setupImportVendorTable();
                                        }
                                }
                    </script>
                    <script>
                        function toggleAllCheckboxes11() {
                        //               var ref_no = document.getElementById("prNo").value;
                        var materialCheck = document.getElementById("vendorId");
                                var checkboxes = document.getElementsByName("checkedId");
                                for (var i = 0; i < checkboxes.length; i++) {
                        checkboxes[i].checked = materialCheck.checked;
                        }
                        }

                        function submitCheckedVendor11() {

                        var checkboxes = document.getElementsByName("checkedId");
                                var ref_no = document.getElementById("pr_no").value;
                                var atLeastOneChecked = false;
                                for (var i = 0; i < checkboxes.length; i++) {
                        if (checkboxes[i].checked) {
                        atLeastOneChecked = true;
                                break;
                        }
                        }

                        if (!atLeastOneChecked) {
                        //        alert("Select at least one item.");
                        Swal.fire({
                        title: 'Select at least one Vendor.',
                                icon: 'warning',
                                timer: 2000,
                                showConfirmButton: false
                        });
                                return false;
                        }

                        var form = document.getElementById("myForm");
                                var formData = new FormData(form);
                                formData.append("ref_no", ref_no);
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "prMaster.htm?act=addVendorForPr", true);
                                xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4) {
                                if (xhr.status === 200) {
                                document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;
                                        Swal.fire({
                                        title: 'Vendor Added Successfully',
                                                icon: 'success',
                                                timer: 2000,
                                                showConfirmButton: false
                                        });
                                        searchAddVendor();
                                        setupImportVendorTable();
                                } else {
                                Swal.fire({
                                title: 'An error occurred while adding items.',
                                        icon: 'error',
                                        timer: 2000,
                                        showConfirmButton: false
                                });
                                }
                                }
                                };
                                xhr.send(formData);
                        }
                    </script>
                    <script>
                        function submitCheckedVendorkg11() {
                        var vendor_code = document.getElementById("vendor_code").value;
                                var vendor_name = document.getElementById("vendor_name").value;
                                var vendor_remark = document.getElementById("vendor_remark").value;
                                var ref_no = document.getElementById("pr_no").value;
                                var form = document.getElementById("myForm");
                                var formData = new FormData();
                                formData.append("vendor_code", vendor_code);
                                formData.append("vendor_name", vendor_name);
                                formData.append("vendor_remark", vendor_remark);
                                formData.append("ref_no", ref_no);
                                var xhr = new XMLHttpRequest();
                                xhr.open("POST", "prMaster.htm?act=searchVendorForPrSubmit", true);
                                xhr.onreadystatechange = function () {
                                if (xhr.readyState === 4) {
                                if (xhr.status === 200) {
                                document.getElementById("IteamDetailsDivV").innerHTML = xhr.responseText;
                                        setTimeout(() => {
                                        setupImportVendorTable();
                                                if ($('#AjaxVendorAddTable').length) {
                                        const table1 = initTable('#AjaxVendorAddTable');
                                        }
                                        //                            searchAddVendor();
                                        }, 100);
                                } else {
                                Swal.fire({
                                title: 'An error occurred while submitting data.',
                                        icon: 'error',
                                        timer: 2000,
                                        showConfirmButton: false
                                });
                                }
                                }
                                };
                                xhr.send(formData);
                        }
                    </script>

                    <script>
                        function setupImportVendorTable() {
                        if ($('#AjaxVendorTable').length) {
                        initTable('#AjaxVendorTable');
                                $('#select_all').on('change', function () {
                        $('.rowCheckbox').prop('checked', this.checked).trigger('change');
                        });
                                $('#AjaxVendorTable tbody').on('change', '.rowCheckbox', function () {
                        const anyChecked = $('.rowCheckbox:checked').length > 0;
                                $('#deleteSelectedVendor').toggleClass('d-none', !anyChecked).toggleClass('', anyChecked);
                                $('#select_all').prop('checked', $('.rowCheckbox:checked').length === $('.rowCheckbox').length);
                        });
                                $('#deleteSelectedVendor').on('click', function () {
                        var selectedIds = [];
                                $('.rowCheckbox:checked').each(function () {

                        var selectedId = $(this).val();
                                //           alert(selectedId);
                                selectedIds.push(selectedId);
                        });
                                if (selectedIds.length === 0) {
                        return Swal.fire({
                        icon: 'warning',
                                title: 'No Selection',
                                text: 'Please select at least one row to delete.'
                        });
                        }

                        const msg = selectedIds.length === 1
                                ? 'Are you sure you want to remove selected vendor?'
                                : `Are you sure you want to delete these ${selectedIds.length} Vendors?`;
                                const confirmText = selectedIds.length === 1
                                ? 'Yes, delete it!'
                                : 'Yes, delete them!';
                                Swal.fire({
                                title: msg,
                                        text: 'You will not be able to recover these records!',
                                        icon: 'warning',
                                        showCancelButton: true,
                                        confirmButtonText: confirmText,
                                        cancelButtonText: 'No, cancel',
                                        reverseButtons: true,
                                        customClass: {
                                        confirmButton: 'confirm-delete',
                                                cancelButton: 'theme-btn light-btn'
                                        },
                                }).then((result) => {
                        if (result.isConfirmed) {
                        $.ajax({
                        url: 'prMaster.htm?act=deleteVendorForPr&ref_no=${ref_no}&Ids=' + selectedIds.join(','),
                                type: 'POST',
                                data: JSON.stringify({ ids: selectedIds }),
                                contentType: 'application/json',
                                success: function (response) {
                                Swal.fire({
                                icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message
                                });
                                        $('#deleteSelectedVendor').addClass('d-none');
                                        $('#AjaxVendorTable')
                                        .DataTable()
                                        .rows(function (idx, data, node) {
                                        return $(node).find('.rowCheckbox').is(':checked');
                                        })
                                        .remove()
                                        .draw();
                                        loadAddServiceDocument();
                                },
                                error: function (xhr) {
                                Swal.fire({
                                icon: 'error',
                                        title: 'Error!',
                                        text: 'Error deleting records: ' + xhr.responseText
                                });
                                }
                        });
                        }
                        });
                        });
                        }
                        }
                    </script>  
                    





                </form:form>  
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
        <script src="StorageYard/assets/js/TableScript/pr-scripts1.js" type="text/javascript"></script>
 
<script>
        function handleSubmit(event) {

            if ($.fn.DataTable.isDataTable('#importItemsDetailsTable1')) {

                var table = $('#importItemsDetailsTable1').DataTable();

                if (table.rows().count() === 0) {

                    event.preventDefault();

                    Swal.fire({
                        icon: 'warning',
                        title: 'No Items',
                        text: 'Please attach line item before submitting.'
                    });

                    return false;
                }

            } else {

                var rowCount = $('#importItemsDetailsTable1 tbody tr').length;

                if (rowCount === 0) {

                    event.preventDefault();

                    Swal.fire({
                        icon: 'warning',
                        title: 'No Items',
                        text: 'Please attach line item before submitting.'
                    });

                    return false;
                }
            }

            var prtype = $('#prType').val();

            if (prtype === "Contract Electrical" || prtype === "Contract Civil") {

                if ($.fn.DataTable.isDataTable('#importItemsServiceTable1')) {

                    var serviceTable = $('#importItemsServiceTable1').DataTable();

                    if (serviceTable.rows().count() === 0) {

                        event.preventDefault();

                        Swal.fire({
                            icon: 'warning',
                            title: 'No Service Items',
                            text: 'Please attach service line item before submitting.'
                        });

                        return false;
                    }

                } else {

                    var serviceRowCount = $('#importItemsServiceTable1 tbody tr').length;

                    if (serviceRowCount === 0) {

                        event.preventDefault();

                        Swal.fire({
                            icon: 'warning',
                            title: 'No Service Items',
                            text: 'Please attach service line item before submitting.'
                        });

                        return false;
                    }
                }
            }

            return true;
        }
    </script>
    <script>
                                $(document).on('click', '.delete-doc-row', function (e) {
                                e.preventDefault();
                                var $row = $(this).closest('tr');
                                var id = $(this).data('id');
                                var fieldOne = $('#pr_no').val();
                                Swal.fire({
                                title: 'Are you sure you want to delete this?',
                                        text: 'You will not be able to recover this record!',
                                        icon: 'warning',
                                        showCancelButton: true,
                                        confirmButtonText: 'Yes, delete it!',
                                        cancelButtonText: 'No, cancel',
                                        reverseButtons: true,
                                        customClass: {
                                        confirmButton: 'confirm-delete',
                                                cancelButton: 'theme-btn light-btn'
                                        }
                                }).then((result) => {
                        if (result.isConfirmed) {
                        $.ajax({
                        url: 'prMaster.htm?act=technicalFileDetailsDelete',
                                type: 'POST',
                                data: {
                                id: id,
                                        ref_no: fieldOne,
                                },
                                 success: function (response) {
                                Swal.fire({
                                icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message || 'Record has been deleted.'
                                });
                                        $('#AjaxTechTab')
                                        .DataTable()
                                        .row($row)
                                        .remove()
                                        .draw();
                                },
                                error: function (xhr) {
                                Swal.fire({
                                icon: 'error',
                                        title: 'Error!',
                                        text: 'Error deleting record: ' + xhr.responseText
                                });
                                }
                        });
                        }
                        });
                        }); 
                        
                        
        </script>
        
        <script>
            loadModelGood();
            function loadModelGood() {
            var str1 = document.getElementById("pr_no").value;
//            alert(str1)
            var xreq1;
            if (str1 === "") {
                document.getElementById("resultDivPipe").innerHTML = "";
                return;
            }

            try {
                xreq1 = new XMLHttpRequest();
            } catch (e) {
                try {
                    xreq1 = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("No AJAX!?");
                        return false;
                    }
                }
            }

            xreq1.onreadystatechange = function () {
                if (xreq1.readyState == 4 && xreq1.status == 200) {
                    document.getElementById("resultDivPipe").innerHTML = xreq1.responseText;
                    setTimeout(() => {
                        if ($('#importItemsDetailsTable1').length) {
                            setupImportItemsTable1();
                        }
                    }, 100);
                }
            };

            xreq1.open("GET", "prMaster.htm?act=addServicePRDocument&ref_no=" + str1, true);
            xreq1.send();
        }
        </script>
      <script>
          loadModelService();
            function loadModelService() {
            var str1 = document.getElementById("pr_no").value;
//            alert(str1)
            var xreq1;
            if (str1 === "") {
                document.getElementById("resultDivPipe1").innerHTML = "";
                return;
            }

            try {
                xreq1 = new XMLHttpRequest();
            } catch (e) {
                try {
                    xreq1 = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                        alert("No AJAX!?");
                        return false;
                    }
                }
            }

            xreq1.onreadystatechange = function () {
                if (xreq1.readyState == 4 && xreq1.status == 200) {
                    document.getElementById("resultDivPipe1").innerHTML = xreq1.responseText;
                    setTimeout(() => {
                        if ($('#importItemsServiceTable1').length) {
                            setupImportItemsServiceTable1();
                        }
                    }, 100);
                }
            };

            xreq1.open("GET", "prMaster.htm?act=addServicePRDocument1&ref_no=" + str1, true);
            xreq1.send();
        }
        </script>
</html>
