<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Aman Bahukhandi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Bid</title>
        
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
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        
            grand_total = document.form.netrate1.value;
            
            var discount_val = document.form.discount_val.value;
            var discount = document.form.discount.value;
            if(discount_val == "")
            {
                discount_val=0;
            }
            if(discount == "")
            {
                discount=0;
            }
            if(discount_val == 0)
            {
                discount = grand_total * discount / 100;
            }
            else
            {
                
            }
            grand_total = grand_total - parseFloat(discount);
            var packing_val = document.form.packing_val.value;
            var packing = document.form.packing.value;
            if(packing_val == "")
            {
                packing_val=0;
            }
            if(packing == "")
            {
                packing=0;
            }
            if(packing_val == 0)
            {
                packing = grand_total * packing / 100;
            }
            else
            {
                
            }
            grand_total = grand_total + parseFloat(packing);
            
            
            var errection = document.form.errection.value;
            if(errection == "")
            {
                errection=0;
            }
            grand_total = grand_total + parseFloat((grand_total * errection / 100));
            
            var other_charges = document.form.other_charges.value;
            if(other_charges == "")
            {
                other_charges=0;
            }
            grand_total = grand_total + parseFloat((grand_total * other_charges / 100));
            
            var igst = document.form.igst.value;
            if(igst == "")
            {
                igst=0;
            }
            igst = grand_total * igst / 100;
            
            var cgst = document.form.cgst.value;
            if(cgst == "")
            {
                cgst=0;
            }
            cgst = grand_total * cgst / 100;
            
            var sgst = document.form.sgst.value;
            if(sgst == "")
            {
                sgst=0;
            }
            sgst = grand_total * sgst / 100;
            
            grand_total = grand_total + parseFloat(igst) + parseFloat(cgst) + parseFloat(sgst);
            var insurance_value = document.form.insurance_value.value;
            if(insurance_value == "")
            {
                insurance_value=0;
            }
            grand_total = grand_total + parseFloat((grand_total * insurance_value / 100));
            
            document.form.grand_total.value = grand_total.toFixed(2);
        
        //test_skill(grand_total.toFixed(2));
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
                        document.form.action = "vender_tender_item_detail.jsp?id=" + id;
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



    
    
    function validation()
    {
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        while (i1 < document.form.vendor_tech_desc.length) 
        {
            var cremark1 = '1techradion' + j1 ;
            var cremark2 = '2techradion' + j1 ;
            var cremark3 = '3techradion' + j1 ;
            var vvv = 'tech_vendor_remark' + j1
            if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true && document.getElementById(cremark3).checked != true)
            {
                alert("Please Select Technical Specification");
                    return false;
            }
            if (document.getElementById(cremark1).checked== false)
            {
                if (document.getElementById(vvv).value=='')
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
	k1  = 0;
        while (i1 < document.form.vendor_terms_desc.length) 
        {
            var cremark1 = '1termsradion' + j1 ;
            var cremark2 = '2termsradion' + j1 ;
            var cremark3 = '3termsradion' + j1 ;
            var vvv = 'terms_vendor_remark' + j1
            if (document.getElementById(cremark1).checked != true && document.getElementById(cremark2).checked != true && document.getElementById(cremark3).checked != true)
            {
                alert("Please Select Terms & Condition");
                    return false;
            }
            if (document.getElementById(cremark1).checked== false)
            {
                if (document.getElementById(vvv).value=='')
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

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Financial Bid</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Financial Bid</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="vendor.htm?act=venderTenderItemDetailSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                      name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                                    
                                    Financial Bid
                                    
                                    <input type="hidden" name="file_no" value="${file_no}">
                                    <input type="hidden" name="file_name" value="${file_name}">
                                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                                    <hr>
                                    <div class="form-group">
                                        
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender No. :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="refNo" id="refNo" class="form-control" value="${refNo}"  readonly="true"/>
                                        </div>
                                        
                                        <div class="col-sm-2">
                                            <label class="control-label">Title :</label>
                                        </div>
                                        <div class="col-sm-4">
                                            <form:input path="title" class="form-control"   readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Revision :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="value" class="form-control" value="0" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="announceDate" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Due Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="submitLastdate" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Subject Description :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <form:input path="workDesc" class="form-control"  readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Remark :</label>
                                        </div>
                                        <div class="col-sm-9">
                                            <form:input path="tenderRemark" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                   
                                    
                                    Tender Contact Person
                                    <hr>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Created By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="contactPerson" class="form-control" value="${employee_name}"  maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="tenderAdminContactNumber" class="form-control" value="${ph_no}"  maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Authorize By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="tenderAuthorizePerson" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="tenderAuthorizeContactNo" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    
                                    Item List
                                    <hr>
                                    
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Item Description</th>
                                                                    <th>Remark</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                  </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                            <tr>
                                                                                <input type="hidden" name="item_code" value="${item_code1}">
                                                                                <input type="hidden" name="sr_no" value="${sr_no1}">
                                                                                <td>${item_description1} </td>
                                                                                <td>${remark1}</td>
                                                                                <td><input type="text" name="uom" class="form-control" value="${uom1}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="qty" class="form-control" value="${qty1}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="rate1" class="form-control" value="${rate1}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="netrate1" class="form-control" value="${netrate1}" required="true" readonly="true"></td>
                                                                                
                                                                            </tr>
                                                                            
                                                                
                                                            </tbody>
                                                    
                                                </table>
                                            </div>
                                        </div>
                                    
                                    
                                    Taxes & Other Details 
                                    <hr>  
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Discount :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <c:if test="${discount_val1 == '0'}">
                                                (%) <input type="radio" name="discount_val" value="0" class="form-control"  required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${discount_val1 != '0'}">
                                                (%) <input type="radio" name="discount_val" value="0" class="form-control"  required="true"/>
                                            </c:if>
                                            <c:if test="${discount_val1 == '1'}">
                                                (Value) <input type="radio" name="discount_val" value="1" class="form-control" required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${discount_val1 != '1'}">
                                                (Value) <input type="radio" name="discount_val" value="1" class="form-control" required="true"/>
                                            </c:if>
                                             
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="discount" value="${discount1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Packing And Forwarding Charges(%) :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="hidden" name="packing_val" value="0" />
                                            
                                             <input name="packing" value="${packing1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                                <input type="hidden" name="freight_val" value="0"/>
                                            
                                             <input type="hidden" name="freight" value="0"/>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Errection & commission(%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="errection" value="${errection1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Other Charges / Inspection Charges (on GST is applicable)(%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="other_charges" value="${other_charges1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">GST (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="igst" value="${igst1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                             <input type="hidden" name="cgst" value="0" class="form-control"   />
                                             <input type="hidden" name="sgst" value="0" class="form-control"   />
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Insurance (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="insurance_value" value="${insurance_value1}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Grand Total <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="grand_total" value="${total_amount1}" class="form-control"   maxlength="30" required readonly="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <body onLoad="return itemcal(1);" >
        </body>
    
</html>
