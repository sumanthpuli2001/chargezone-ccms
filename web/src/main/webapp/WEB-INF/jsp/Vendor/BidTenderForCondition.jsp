<%-- 
    Document   : CreateDepartment
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Terms And Condition Bid</title>
    </head>

    <body >


      

       
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
               <form:form action="vendor.htm?act=bidTenderForConditionSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                    <input type="hidden" name="termsConditionCount" id="termsConditionCount" value="${termsConditionCount}">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Terms And Condition Bid</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
<!--                            <input type="submit" class="btn theme-btn" name="submit"  value="Submit" disabled="true"/>-->
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
                    <h5 class="fw-600">Financial Bid</h5>
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
                                <label class="text-muted">Tender Revision</label>
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
                        </div>
                    </div>
                    <h5 class="fw-600">Vendor Terms & Condition</h5> 
                    <div class="card-box rounded-3 mb-4 pt-3 pb-2">

                        <div class="row buyer-info">
                            
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Delivery Period (In weeks) :</label>
                                    <div class="fw-600">${tenderMaster.deliveryPeriod}</div>
                                    <input type="hidden" name="delivery_period" id="delivery_period" value="${tenderMaster.deliveryPeriod}">
                                </div>
                            </div>
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Terms of Payment :</label>
                                    <div class="fw-600">${tenderMaster.termsOfPayment}</div>
                                    <input type="hidden" name="terms_of_payment" id="terms_of_payment" value="${tenderMaster.termsOfPayment}">

                                </div>
                            </div>
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Mode Of Transport :</label>
                                    <div class="fw-600">${tenderMaster.modeOfTransport}</div>
                                    <input type="hidden" name="mode_of_transport" id="mode_of_transport" value="${tenderMaster.modeOfTransport}">

                                </div>
                            </div>
                        </div>
                        <div class="row buyer-info">
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Inco Terms :</label>
                                    <div class="fw-600">${tenderMaster.incoTerms}</div>
                                    <input type="hidden" name="inco_terms" id="inco_terms" value="${tenderMaster.incoTerms}">

                                </div>
                            </div>
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Grand Total :</label>
                                    <div class="fw-600">${grand_total1}</div>
                                    <input type="hidden" name="grand_total" value="${grand_total1}">

                                </div>
                            </div>
                            <div class="col-xxl-3 col-lg-3 col-md-3 pb-1">
                                <div class="form-group">
                                    <label class="text-muted">Grand Total In Words :</label>
                                    <div class="fw-600" id="grandTotalInWord"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                   <div class="col-12 p-0">
                    <div class="form-group comment-box">

                            <label class="control-label">Any Other Remark By Vendor :</label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="vendor_remark" name="vendor_remark">${remark_by_vendor}</textarea>
                            <small id="charCount_vendor_remark" style="font-size: 12px; color: green;">
                                250 characters remaining
                            </small>
                        </div>
                    </div> 
                    <script type="text/javascript">
                        document.addEventListener("DOMContentLoaded", function () {
                            var input = document.getElementById("vendor_remark");
                            var counter = document.getElementById("charCount_vendor_remark");
                            var maxChars = 250;

                            function updateCounter() {
                                var count = input.value.length;
                                var remaining = maxChars - count;
                                counter.textContent = remaining + " characters remaining";

                                if (remaining <= 20) {
                                    counter.style.color = "red";
                                } else {
                                    counter.style.color = "green";
                                }
                            }

                            updateCounter();
                            input.addEventListener("input", updateCounter);
                        });
                    </script>

                    <table id="commonNoPageTable" class="table  table-striped bg-white" style="min-width: 100%;" align="Center"  >
                        <thead>
                            <tr>
                                <th style="min-width: 230px;">Terms Condition</th>
                                <th style="min-width: 230px;">Description</th>
                                <th data-dt-order="disable">Yes</th>
                                <th data-dt-order="disable">No</th>
                                <th  style="min-width: 230px;" data-dt-order="disable">Remark</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${empty vendorTermsCondition1}">
                                    <c:forEach items= "${list4}" var="list4" varStatus="status">
                                        <tr>
                                            <td><input type="hidden" name="termsCondition" id="termsCondition" value="${list4[1]}" readonly="true" class="input-field" value="${list4[1]}">${list4[1]}</td>
                                            <td>  <input type="hidden" name="description" value="${list4[3]}" class="input-field" readonly="true"/>${list4[3]} </td>
                                            <td style="text-align: center"><input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0" /></td>
                                            <td style="text-align: center"><input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1" /></td>
                                            <td><textarea type="text" class="input-field" name="remarks" id="remarks${status.count}" maxlength="250"></textarea>
                                                <small id="charCount_remarks${status.count}" style="font-size: 12px; color: green;">
                                                    250 characters remaining
                                                </small>

                                                <script type="text/javascript">
                                                    document.addEventListener("DOMContentLoaded", function () {
                                                        var input = document.getElementById("remarks${status.count}");
                                                        var counter = document.getElementById("charCount_remarks${status.count}");
                                                        var maxChars = 250;

                                                        function updateCounter() {
                                                            var count = input.value.length;
                                                            var remaining = maxChars - count;
                                                            counter.textContent = remaining + " characters remaining";

                                                            if (remaining <= 20) {
                                                                counter.style.color = "red";
                                                            } else {
                                                                counter.style.color = "green";
                                                            }
                                                        }

                                                        updateCounter();
                                                        input.addEventListener("input", updateCounter);
                                                    });
                                                </script>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="vendorTermsCondition1" items="${vendorTermsCondition1}" varStatus="status">
                                        <tr>
                                    <input type="hidden" name="ids" id="ids" value="${vendorTermsCondition1.id}">
                                    <td><input type="hidden" name="termsCondition" id="termsCondition"  value="${vendorTermsCondition1.termsCondition}" readonly="true"  class="input-field" >${vendorTermsCondition1.termsCondition}</td>
                                    <td>
                                        <input type="hidden" name="description" id="description${status.count}" value="${vendorTermsCondition1.description}" readonly="true" class="input-field" />
                                        ${vendorTermsCondition1.description}
                                    </td>
                                    <td  style="text-align: center">
                                        <c:if test="${vendorTermsCondition1.response == 0}">
                                            <input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0"  checked/>
                                        </c:if>
                                        <c:if test="${vendorTermsCondition1.response != 0}">
                                            <input type="radio" name="documentYes${status.count}" id="yes${status.count}" value="0"  />
                                        </c:if>
                                    </td>
                                    <td  style="text-align: center">
                                        <c:if test="${vendorTermsCondition1.response == 1}">
                                            <input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1"  checked/>
                                        </c:if>
                                        <c:if test="${vendorTermsCondition1.response != 1}">
                                            <input type="radio" name="documentYes${status.count}" id="no${status.count}" value="1"  />
                                        </c:if>
                                    </td>
                                    <td> <textarea type="text" class="input-field"  name="remarks" id="remarks${status.count}" class="remarks" maxlength="250">${vendorTermsCondition1.comment}</textarea>
                                        <small id="charCount_remarks${status.count}" style="font-size: 12px; color: green;">
                                            250 characters remaining
                                        </small>

                                        <script type="text/javascript">
                                            document.addEventListener("DOMContentLoaded", function () {
                                                var input = document.getElementById("remarks${status.count}");
                                                var counter = document.getElementById("charCount_remarks${status.count}");
                                                var maxChars = 250;

                                                function updateCounter() {
                                                    var count = input.value.length;
                                                    var remaining = maxChars - count;
                                                    counter.textContent = remaining + " characters remaining";

                                                    if (remaining <= 20) {
                                                        counter.style.color = "red";
                                                    } else {
                                                        counter.style.color = "green";
                                                    }
                                                }

                                                updateCounter();
                                                input.addEventListener("input", updateCounter);
                                            });
                                        </script>
                                    </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table> 
                    <br>

                    <table id="commonDocTable" class="table  table-striped bg-white dt-scroll" style="min-width: 100%;" align="Center"  >
                        <thead>
                            <tr>
                                <th data-dt-order="disable">Tender Commercial Docs</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                <tr>
                                    <td>
                                        <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${generalDocs.document}&RefNo=${generalDocs.rfqNo}">${generalDocs.document}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:forEach var="tenderVendorDocs" items="${tenderVendorDocs}" varStatus="status">
                                <c:if test="${tenderVendorDocs.documentType == '1'}">
                                    <tr>
                                        <td>
                                            <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${tenderVendorDocs.document}&RefNo=${refNo}">${tenderVendorDocs.document}</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="form-group">
                        <div style="display:flex; justify-content:center; align-items:center; gap:8px;">
                            <input type="checkbox" name="common_tax" value="1"  onClick="admsg();" />  Accept Terms And Condition
                        </div>
                    </div>
                    <script language="javascript" type="text/javascript">


                        function admsg()
                        {
                            //alert("a");
                            if (document.form.common_tax.checked == true)
                            {
                                document.form.submit.disabled = false;
                                //   document.form.save.disabled = true;
                            }
                            else
                            {
                                document.form.submit.disabled = true;
                                //   document.form.save.disabled = false;
                            }
                        }
                    </script>                                    


                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <c:choose>
                                <c:when test="${not empty vendorTermsCondition1}">

                                    <input type="submit" class="btn theme-btn" name="submit" style="width: 200px!important;"  title="" value="SUBMIT" disabled="true">
                                </c:when>
                                <c:otherwise>


                                    <input type="submit" class="btn theme-btn" name="submit" style="width: 200px!important;"  title="" value="SUBMIT" disabled="true">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>


                </form:form>              
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
   
      <script>
function validation() {

    var rows = document.querySelectorAll("textarea[name='remarks']");

    for (var i = 0; i < rows.length; i++) {

        var rowNo = i + 1;

        var yesRadio = document.getElementById("yes" + rowNo);
        var noRadio = document.getElementById("no" + rowNo);
        var remarks = document.getElementById("remarks" + rowNo);

        // Check Yes/No selected
        if (!yesRadio.checked && !noRadio.checked) {

            Swal.fire({
                icon: 'warning',
                title: 'Selection Required',
                text: 'Please select Yes or No.'
            });

            return false;
        }

        // If No selected then Remarks required
        if (noRadio.checked && remarks.value.trim() === '') {

            Swal.fire({
                icon: 'warning',
                title: 'Remarks Required',
                text: 'Please enter Remarks when No is selected.',
                didClose: function () {
                    remarks.scrollIntoView({
                        behavior: 'smooth',
                        block: 'center'
                    });
                    remarks.focus();
                }
            });

            return false;
        }
    }

    return true;
}
          window.addEventListener("load", function () {
                test_skill(1);
            });


            function test_skill(aa) {

                // setTimeout('', 500);
//               alert("");
                aa = document.form.grand_total.value;
//               alert(form.grand_total.value);

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
                    document.form.grand_total_word.value = aaa;

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
              document.getElementById("grandTotalInWord").innerHTML = aaa;


            }

        </script>
        
</html>
