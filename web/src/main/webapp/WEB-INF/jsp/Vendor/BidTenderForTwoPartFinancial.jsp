<%-- 
    Document   : BidTenderForTwoPartFinancial
    Created on : 22 Aug, 2023, 9:21:30 AM
    Author     : Bulwark-5
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
 
 
 var tempCount3 = 1;
            function Policy()
            {
        
                    tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='sr_no' id='sr_no'></td>"
                        
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='item_description' id='item_description'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='delivery_schedule_date' id='delivery_schedule_date'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='item_remark' id='item_remark'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='uom' id='uom'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='qty' id='qty'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='unit_rate' id='unit_rate' required=\"true\" onKeyUp=\"change(this.id, event); return itemcal(this.id);\" onKeyPress=\"return isNumberKey(event)\"  onChange=\"return itemcal(this.id)\"></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='net_rate' id='net_rate' required=\"true\" readonly=\"true\"></td>"
                
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='hsn_no' id='hsn_no'></td>"
                + "<td style=\"text-align: center\"><input type=\"text\" class=\"form-control\" name='vendor_remark' id='vendor_remark'></td>"
                
                + "<input type=\"hidden\"  name='item_discount_val' value='0'>"
                + "<input type=\"hidden\"  name='item_discount' value='0'>"
                + "<input type=\"hidden\"  name='item_packing_val' value='0'>"
                + "<input type=\"hidden\"  name='item_packing' value='0'>"
                + "<input type=\"hidden\"  name='item_freight_val' value='0'>"
                + "<input type=\"hidden\"  name='item_freight' value='0'>"
                + "<input type=\"hidden\"  name='item_errection' value='0'>"
                + "<input type=\"hidden\"  name='item_other_charges' value='0'>"
                + "<input type=\"hidden\"  name='item_igst' value='0'>"
                + "<input type=\"hidden\"  name='item_cgst' value='0'>"
                + "<input type=\"hidden\"  name='item_sgst' value='0'>"
                + "<input type=\"hidden\"  name='item_insurance_value' value='0'>"
                + "<input type=\"hidden\"  name='item_total' value='0'>"
                + "<input type=\"hidden\"  name='item_regret' value='0'>"
                //+ "<input type=\"hidden\"  name='item_code' value=''>"
                + "<input type=\"hidden\"  name='attachment_required' value=''>"
                + "<input type=\"hidden\"  name='delivery_schedule_qty' value=''>"
                + "<input type=\"hidden\"  name='item_location' value=''>"
                + "<input type=\"hidden\"  name='pur_no' value=''>"
                + "<input type=\"hidden\"  name='item_no' value=''>"
                + "<input type=\"hidden\"  name='pr_no' value=''>"
        
+ "<td style=\"text-align: center\"><input type=\"text\"  name='item_code' class=\"form-control\" value='' placeholder=\"Item Code\" required='true'></td>"
//+ "<td style=\"text-align: center\"></td>"
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
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        if (document.form.unit_rate.length == null)
        {
                document.form.net_rate.value = (document.form.unit_rate.value * document.form.qty.value).toFixed(2);
                total = (total + document.form.unit_rate.value * document.form.qty.value).toFixed(2);
        }
        while (i1 < document.form.unit_rate.length) 
        {
            document.form.net_rate[i1].value = (document.form.unit_rate[i1].value * document.form.qty[i1].value).toFixed(2);
            total = total + document.form.unit_rate[i1].value * document.form.qty[i1].value;
            i1++;
            j1++;
	}
        
        document.form.total_amount.value = total;
        
        if (document.form.common_tax.checked == true)
        {
            grand_total = total;
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
                discount = total * discount / 100;
            }
            else
            {
                
            }
            grand_total = grand_total - discount;
            
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
            
            
            var freight_val = document.form.freight_val.value;
            var freight = document.form.freight.value;
            if(freight_val == "")
            {
                freight_val=0;
            }
            if(freight == "")
            {
                freight=0;
            }
            if(freight_val == 0)
            {
                freight = grand_total * freight / 100;
            }
            else
            {
                
            }
            
            grand_total = grand_total + parseFloat(freight);
            
            var errection = document.form.errection.value;
            if(errection == "")
            {
                errection=0;
            }
            grand_total = grand_total + parseFloat(errection);
            
            var other_charges = document.form.other_charges.value;
            if(other_charges == "")
            {
                other_charges=0;
            }
            grand_total = grand_total + parseFloat(other_charges);
            
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
        }
        else
        {
            //item wise tax calculation
            i1 = 0;
            j1 = 1;
            k1  = 0;
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
                
                if(item_discount_val == "")
                {
                    item_discount_val=0;
                }
                if(item_discount == "")
                {
                    item_discount=0;
                }
                if(item_discount_val == 0)
                {
                    item_discount = item_total * item_discount / 100;
                }
                else
                {

                }
                item_total = item_total - item_discount;
                
                if(item_packing_val == "")
                {
                    item_packing_val=0;
                }
                if(item_packing == "")
                {
                    item_packing=0;
                }
                if(item_packing_val == 0)
                {
                    item_packing = item_total * item_packing / 100;
                }
                else
                {

                }
                item_total = item_total + parseFloat(item_packing);
                
                if(item_freight_val == "")
                {
                    item_freight_val=0;
                }
                if(item_freight == "")
                {
                    item_freight=0;
                }
                if(item_freight_val == 0)
                {
                    item_freight = item_total * item_freight / 100;
                }
                else
                {

                }
                item_total = item_total + parseFloat(item_freight);
                
                
                if(item_errection == "")
                {
                    item_errection=0;
                }
                item_total = item_total + parseFloat(item_errection);
            
                if(item_other_charges == "")
                {
                    item_other_charges=0;
                }
                item_total = item_total + parseFloat(item_other_charges);
            
                if(item_igst == "")
                {
                    item_igst=0;
                }
                item_igst = item_total * item_igst / 100;
            
                if(item_cgst == "")
                {
                    item_cgst=0;
                }
                item_cgst = item_total * item_cgst / 100;
            
                if(item_sgst == "")
                {
                    item_sgst=0;
                }
                item_sgst = item_total * item_sgst / 100;
            
                item_total = item_total + parseFloat(item_igst) + parseFloat(item_cgst) + parseFloat(item_sgst);
            
                if(item_insurance_value == "")
                {
                    item_insurance_value=0;
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
                
                if(item_discount_val == "")
                {
                    item_discount_val=0;
                }
                if(item_discount == "")
                {
                    item_discount=0;
                }
                if(item_discount_val == 0)
                {
                    item_discount = item_total * item_discount / 100;
                }
                else
                {

                }
                item_total = item_total - item_discount;
                
                if(item_packing_val == "")
                {
                    item_packing_val=0;
                }
                if(item_packing == "")
                {
                    item_packing=0;
                }
                if(item_packing_val == 0)
                {
                    item_packing = item_total * item_packing / 100;
                }
                else
                {

                }
                item_total = item_total + parseFloat(item_packing);
                
                if(item_freight_val == "")
                {
                    item_freight_val=0;
                }
                if(item_freight == "")
                {
                    item_freight=0;
                }
                if(item_freight_val == 0)
                {
                    item_freight = item_total * item_freight / 100;
                }
                else
                {

                }
                item_total = item_total + parseFloat(item_freight);
                
                
                if(item_errection == "")
                {
                    item_errection=0;
                }
                item_total = item_total + parseFloat(item_errection);
            
                if(item_other_charges == "")
                {
                    item_other_charges=0;
                }
                item_total = item_total + parseFloat(item_other_charges);
            
                if(item_igst == "")
                {
                    item_igst=0;
                }
                item_igst = item_total * item_igst / 100;
            
                if(item_cgst == "")
                {
                    item_cgst=0;
                }
                item_cgst = item_total * item_cgst / 100;
            
                if(item_sgst == "")
                {
                    item_sgst=0;
                }
                item_sgst = item_total * item_sgst / 100;
            
                item_total = item_total + parseFloat(item_igst) + parseFloat(item_cgst) + parseFloat(item_sgst);
            
                if(item_insurance_value == "")
                {
                    item_insurance_value=0;
                }
                item_total = item_total + parseFloat((item_total * item_insurance_value / 100));
            
                
                item_total1 = item_total1 + item_total


            
                
                i1++;
                j1++;
            }
            
            grand_total = item_total1; 
            document.form.grand_total.value = grand_total.toFixed(2);
            
            
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
                        document.form.action = "vendor.htm?act=venderTenderItemDetailTwoPart&id=" + id;
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
                        document.form.action = "vendor.htm?act=venderTenderItemDetailTwoPart&id=" + id;
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
                                <form:form action="vendor.htm?act=bidTenderForTwoPartFinancialSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                      name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                                    
                                    Financial Bid
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
                                            <input type="text" name="tender_revision"  class="form-control" value="${rivision}" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" readonly="true"/>
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
                                        
                                    </div>
                                    
                                    
                                    
                                    
                                    
                                    
                                    Item List
                                    <hr>
                                    
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="policyTable" id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>Item Detail</th>
                                                                    <th>Remark</th>
                                                                    <th>UOM</th>
                                                                    
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    
                                                                    <th>Vendor Remark</th>
                                                                    <th>Regret</th>
                                                                    <th>Item Wise Taxes & Duties
                                                                    <span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="policyCloneid" onclick="Policy();"/>
                                                                </span>
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                <c:choose>
                                                                    <c:when test="${empty vendorTenderBidItem}">

                                                                        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status">
                                                                            <tr>
                                                                                <td>${tenderItemMaster.srNo} </td>
                                                                                <td>${tenderItemMaster.itemDescription} </td>
                                                                                <td>${tenderItemMaster.deliveryScheduleDate}</td>
                                                                                <td>${tenderItemMaster.remark}</td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="uom" class="form-control" value="">
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="uom" class="form-control" value="${tenderItemMaster.uom}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="qty" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="qty" class="form-control" value="${tenderItemMaster.qty}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="unit_rate" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="unit_rate" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="net_rate" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="net_rate" class="form-control" value="" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="hsn_no" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="hsn_no" class="form-control" value="" required="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input type="hidden" name="vendor_remark" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="text" name="vendor_remark" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom == ''}">
                                                                                        <input name="Regret" type="hidden" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${tenderItemMaster.uom != ''}">
                                                                                        <input type="button" name="itemsubmit" class="form-control"  value="Tax Details" id="${status.count}" onClick="check(this.id);" />
                                                                                    </c:if>
                                                                                    
                                                                                </td>
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
                                                                                <input type="hidden" name="item_description"  value="${tenderItemMaster.itemDescription}" >
                                                                                <input type="hidden" name="item_remark"  value="${tenderItemMaster.remark}" >
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
                                                                                <td>${vendorTenderBidItem.itemDescription}</td>
                                                                                <td>${vendorTenderBidItem.deliveryScheduleDate}</td>
                                                                                <td>${vendorTenderBidItem.remark}</td>
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="uom" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="uom" class="form-control" value="${vendorTenderBidItem.uom}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="qty" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="qty" class="form-control" value="${vendorTenderBidItem.qty}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="unit_rate" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="unit_rate" class="form-control" value="${vendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="net_rate" class="form-control" value="0" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="net_rate" class="form-control" value="${vendorTenderBidItem.netRate}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="hsn_no" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="hsn_no" class="form-control" value="${vendorTenderBidItem.hsnNo}" required="true">
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                               
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="vendor_remark" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="vendor_remark" class="form-control" value="${vendorTenderBidItem.vendorRemark}" >
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${vendorTenderBidItem.uom == ''}">
                                                                                        <input name="Regret" type="hidden" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
                                                                                    
                                                                                </td>
                                                                                <td>
                                                                                    
                                                                                    <c:if test="${vendorTenderBidItem.uom != ''}">
                                                                                        <input type="button" name="itemsubmit" class="form-control"  value="Tax Details" id="${status.count}" onClick="check(this.id);" />
                                                                                    </c:if>
                                                                                    
                                                                                </td>
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
                                                                                <input type="hidden" name="item_description"  value="${vendorTenderBidItem.itemDescription}" >
                                                                                <input type="hidden" name="item_remark"  value="${vendorTenderBidItem.remark}" >
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
                                                    
                                                </table>
                                                <table>
                                                    <tbody>
                                                                            
                                                                            <tr>
                                                                                
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td style="width: 80%;">Total</td>
                                                                                <td><input type="text" name="total_amount" class="form-control" value="${item_total}" required="true" readonly="true"></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                
                                                                            </tr>
                                                            </tbody>
                                                    
                                                </table>
                                            </div>
                                        </div>
                                    
                                    
                                    Taxes & Other Details (Common For All Items) 
                                    <hr>  
                                    
                                    <div class="form-group">
                                        <div class="col-sm-8">
                                            <c:if test="${select_common == '1'}">
                                                <input type="checkbox" name="common_tax" value="1"   onClick="admsg();return itemcal(1);" checked="true"/>
                                            </c:if>
                                            <c:if test="${select_common != '1'}">
                                                <input type="checkbox" name="common_tax" value="1"  onClick="admsg();return itemcal(1);" />
                                            </c:if>
                                            
                                            <label class="control-label">select for common tax (Use This Field If Taxes & Duties Are Same For All Item) </label>
                                        </div>
                                        
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Discount :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <c:if test="${discount_type == '0'}">
                                                (%) <input type="radio" name="discount_val" value="0"   onClick="return itemcal(1);" required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${discount_type != '0'}">
                                                (%) <input type="radio" name="discount_val" value="0"   onClick="return itemcal(1);" required="true" />
                                            </c:if>
                                            <c:if test="${discount_type == '1'}">
                                                (Value) <input type="radio" name="discount_val" value="1"   onClick="return itemcal(1);" required="true" checked="true"/>
                                            </c:if>
                                             <c:if test="${discount_type != '1'}">
                                                (Value) <input type="radio" name="discount_val" value="1"   onClick="return itemcal(1);" required="true"/>
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="discount" value="${discount_value}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Packing And Forwarding Charges :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <c:if test="${packing_type == '0'}">
                                                (%) <input type="radio" name="packing_val" value="0"  required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${packing_type != '0'}">
                                                (%) <input type="radio" name="packing_val" value="0"  required="true"/>
                                            </c:if>
                                            <c:if test="${packing_type == '1'}">
                                                (Value) <input type="radio" name="packing_val" value="1"  required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${packing_type != '1'}">
                                                (Value) <input type="radio" name="packing_val" value="1"  required="true"/>
                                            </c:if>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="packing" value="${packing_value}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Freight <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <c:if test="${freight_type == '0'}">
                                                (%) <input type="radio" name="freight_val" value="0"  required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${freight_type != '0'}">
                                                (%) <input type="radio" name="freight_val" value="0"  required="true"/>
                                            </c:if>
                                            <c:if test="${freight_type == '1'}">
                                                (Value) <input type="radio" name="freight_val" value="1"  required="true" checked="true"/>
                                            </c:if>
                                            <c:if test="${freight_type != '1'}">
                                                (Value) <input type="radio" name="freight_val" value="1"  required="true"/>
                                            </c:if>
                                            
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="freight" value="${freight_value}" class="form-control"   maxlength="30" required onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Errection & commission(value) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="errection" value="${errection_value}" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" class="form-control"   maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Other Charges / Inspection Charges (on GST is applicable) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="other_charges" value="${charges_value}" class="form-control" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">IGST (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="igst" value="${igst_value}" class="form-control" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">CGST (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="cgst" value="${cgst_value}" class="form-control" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">SGST (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="sgst" value="${sgst_value}" class="form-control" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Insurance (%) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="insurance_value" value="${insurance_value}" class="form-control" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"  maxlength="30" required/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Grand Total <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="grand_total" value="${grand_total}" class="form-control"   maxlength="30" required readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Grand Total In Words <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <input name="venodr_total_words" value="${grand_total_word}" class="form-control"   maxlength="30" required readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 200px!important;"  title="" value="SAVE AND NEXT">
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
    </body>
   
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
     <body onLoad="return itemcal(1);" >
        </body>
<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
   
</html>

