<%-- 
    Document   : BidTenderForFinancialServiceManual
    Created on : 15 Mar, 2022, 11:18:07 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financial Bid</title>
    <body onLoad="return itemcal(1);">    
<script language="javascript" type="text/javascript">
 
    
    function admsg()
    {
       // alert("a");
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
    function isNumberKey1(evt)
    {
        var charCode = (evt.which) ? evt.which : event.keyCode
        //alert(charCode);
                if (charCode == 46)
                {
                    return true
                }
                if (charCode == 45)
                {
                    return true
                }
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;

                return true;
    }
            
    function itemcal(a)
    {
        //alert("");
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        if (document.form.unit_rate.length == null)
        {
                document.form.net_rate.value = parseFloat(document.form.unit_rate.value * document.form.qty.value).toFixed(2);
                total = document.form.unit_rate.value * document.form.qty.value;
        }
        while (i1 < document.form.unit_rate.length) 
        {
            document.form.net_rate[i1].value = parseFloat(document.form.unit_rate[i1].value * document.form.qty[i1].value).toFixed(2);
            total = total + document.form.unit_rate[i1].value * document.form.qty[i1].value;
            i1++;
            j1++;
	}
        
        document.form.total_amount.value = parseFloat(total).toFixed(2);
        
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
                        document.form.action = "vendor.htm?act=venderTenderService1ItemDetail&id=" + id;
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
                        document.form.action = "vendor.htm?act=venderTenderService1ItemDetail&id=" + id;
                        form.submit();
                    }


                }
            }
            
            
            function check5(id)
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
                        document.form.action = "vendor.htm?act=venderTenderService5ItemDetail&id=" + id;
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
                        document.form.action = "vendor.htm?act=venderTenderService5ItemDetail&id=" + id;
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
<style type="text/css">
    h1{
        font-weight: bold;
        margin: 0
    }
    h4{
        font-weight: bold;
    }
    .form-group{
        font-size: 14px;
    }
</style>

    </head>
    <!-- Content Wrapper. Contains page content -->
<body onLoad="return itemcal(1);" onpageshow="if (event.persisted) noBack();" onUnload="">
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
                                <form:form action="vendor.htm?act=bidTenderForFinancialServiceManualSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                      name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                                    
                                    <h4>Financial Bid</h4>
                                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                                    <hr>
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender No. :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="refNo" id="refNo" class="form-control" value="${refNo}"  readonly="true"/>
                                        </div>
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Title :</label>
                                        </div>
                                        <div class="col-sm-4">
                                            <form:input path="title" class="form-control"   readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Revision :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="tender_revision"  class="form-control" value="${rivision}" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" readonly="true"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="announceDate" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Due Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="submitLastdate" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Subject Description :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <form:input path="workDesc" class="form-control"  readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
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
                                        <div class="col-sm-3">
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
                                        <div class="col-sm-3">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="tenderAuthorizeContactNo" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Name of Location Partner</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input  class="form-control" value="${prm.nameofLocationPartner}"  maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Mobile No Location Partner</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input value="${prm.mobileNoLocationPartner}"  class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    
                                    Item List
                                    <hr>
                                    <input type="hidden" name="refNo" value="${refNo}">
                                    <input type="hidden" name="file_no" value="${file_no}">
                                    <input type="hidden" name="file_name" value="${file_name}">
                                    
                                    <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status">
                                        
                                        <c:if test="${status.count == file_no}">
                                            <input type="hidden" name="service_type" value="${fileDetail.serType}">
                                            <c:if test="${fileDetail.serType == 'Service1'}">
                                                
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>Remark</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                    <c:if test="${fileDetail.allowReg == 'allow_regret_service1'}">
                                                                        <th>Regret</th>
                                                                    </c:if>
                                                                    <c:if test="${fileDetail.taxReq == 'tax_apply_service1'}">
                                                                        <th>Item Wise Taxes & Duties</th>
                                                                    </c:if>
                                                                    
                                                                    
                                                                    
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                
                                                                <c:choose>
                                                                    <c:when test="${empty serviceVendorTenderBidItem}">

                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <tr>
                                                                                <td>${status.count} </td>
                                                                                <td>${serviceDetail.itemDesc} </td>
                                                                                <td>${serviceDetail.remark}</td>
                                                                                <td><input type="text" name="uom" class="form-control" value="${serviceDetail.uom}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="qty" class="form-control" value="${serviceDetail.qty}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="unit_rate" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="hsn_no" class="form-control" value="" required="true"></td>
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="" ></td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service1'}">
                                                                                    <td><input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/></td>
                                                                                </c:if>
                                                                                <c:if test="${fileDetail.taxReq == 'tax_apply_service1'}">
                                                                                        <td><input type="button" name="itemsubmit" class="form-control"  value="Tax Details" id="${status.count}" onClick="check(this.id);" /></td>
                                                                                </c:if>

                                                                                    
                                                                                
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
                                                                                <input type="hidden" name="sr_no"  value="${serviceDetail.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceDetail.itemDesc}" >
                                                                                <input type="hidden" name="item_remark"  value="${serviceDetail.remark}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </c:when>
                                                                            
                                                                    <c:otherwise>
                                                                         <c:forEach var="serviceVendorTenderBidItem" items="${serviceVendorTenderBidItem}" varStatus="status">
                                                                            <tr>
                                                                                <td>${status.count}</td>
                                                                                <td>${serviceVendorTenderBidItem.itemDesc}</td>
                                                                                <td>${serviceVendorTenderBidItem.remark}</td>
                                                                                <td><input type="text" name="uom" class="form-control" value="${serviceVendorTenderBidItem.uom}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="qty" class="form-control" value="${serviceVendorTenderBidItem.quantity}" required="true" readonly="true"></td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.itemRegret == '1'}">
                                                                                        <input type="text" name="unit_rate" class="form-control" value="${serviceVendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.itemRegret == '0'}">
                                                                                        <input type="text" name="unit_rate" class="form-control" value="${serviceVendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    
                                                                                    
                                                                                </td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="${serviceVendorTenderBidItem.netRate}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="hsn_no" class="form-control" value="${serviceVendorTenderBidItem.hsnNo}" required="true"></td>
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="${serviceVendorTenderBidItem.vendorRemark}" ></td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service1'}">
                                                                                    <td>
                                                                                        <c:if test="${serviceVendorTenderBidItem.itemRegret == '1'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Bid" onClick="return itemcal1();
                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem.itemRegret == '0'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                        </c:if>


                                                                                    </td>
                                                                                </c:if>
                                                                                <c:if test="${fileDetail.taxReq == 'tax_apply_service1'}">
                                                                                    <td><input type="button" name="itemsubmit" class="form-control"  value="Tax Details" id="${status.count}" onClick="check(this.id);" /></td>
                                                                                </c:if>
                                                                                    
                                                                                    
                                                                                <input type="hidden" name="item_discount_val"  value="${serviceVendorTenderBidItem.discountType}" >
                                                                                <input type="hidden" name="item_discount"  value="${serviceVendorTenderBidItem.discountValue}" >
                                                                                <input type="hidden" name="item_packing_val"  value="${serviceVendorTenderBidItem.packingType}" >
                                                                                <input type="hidden" name="item_packing"  value="${serviceVendorTenderBidItem.packingValue}" >
                                                                                <input type="hidden" name="item_freight_val"  value="${serviceVendorTenderBidItem.freightType}" >
                                                                                <input type="hidden" name="item_freight"  value="${serviceVendorTenderBidItem.freightValue}" >
                                                                                <input type="hidden" name="item_errection"  value="${serviceVendorTenderBidItem.errectionValue}" >
                                                                                <input type="hidden" name="item_other_charges"  value="${serviceVendorTenderBidItem.chargesValue}" >
                                                                                <input type="hidden" name="item_igst"  value="${serviceVendorTenderBidItem.igstValue}" >
                                                                                <input type="hidden" name="item_cgst"  value="${serviceVendorTenderBidItem.cgstValue}" >
                                                                                <input type="hidden" name="item_sgst"  value="${serviceVendorTenderBidItem.sgstValue}" >
                                                                                <input type="hidden" name="item_insurance_value"  value="${serviceVendorTenderBidItem.insuranceValue}" >
                                                                                <input type="hidden" name="item_total"  value="${serviceVendorTenderBidItem.totalValue}" >
                                                                                <input type="hidden" name="item_regret"  value="${serviceVendorTenderBidItem.itemRegret}" >
                                                                                <input type="hidden" name="item_code"  value="${serviceVendorTenderBidItem.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceVendorTenderBidItem.itemDesc}" >
                                                                                <input type="hidden" name="item_remark"  value="${serviceVendorTenderBidItem.remark}" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceVendorTenderBidItem.srNo}" >
                                                                            </tr>
                                                                        </c:forEach>       
                                                                    </c:otherwise>

                                                                </c:choose>
                                                                
                                                                
                                                                <c:if test="${fileDetail.totReq == 'total_required_service1'}">

                                                                
                                                                
                                                                
                                                                        <tr>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>Total</td>
                                                                                <td><input type="text" name="total_amount" class="form-control" value="${item_total}" required="true" readonly="true"></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                            </tr>
                                                                            
                                                                </c:if>
                                                            </tbody>
                                                    
                                                        </table>
                                                    </div>
                                                </div>      
                                                
                                    <c:if test="${fileDetail.taxReq == 'tax_apply_service1'}">

                                                                                
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
                                            <label class="control-label">Freight<span style="color: red;font-size: 12px;">*</span></label>
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
                                    
                                    </c:if>

                                    
                                                                                
                                                                                
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service2'}">

                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            
                                                                
                                                                <c:choose>
                                                                    <c:when test="${empty serviceVendorTenderBidItem2}">

                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>${serviceDetail.srNo}</th>
                                                                                        <th>${serviceDetail.itemDesc}</th>
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
                                                                            <c:if test="${status.count != 1}">
                                                                            <tr>
                                                                                <td>${serviceDetail.srNo}</td>
                                                                                <td>${serviceDetail.itemDesc} </td>
                                                                                <c:if test="${i1 >= 1}">
                                                                                    <td><input type="text" name="onlyBearing1" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 2}">
                                                                                    <td><input type="text" name="onlyBearing2" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 3}">
                                                                                    <td><input type="text" name="onlyBearing3" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 4}">
                                                                                    <td><input type="text" name="onlyBearing4" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 5}">
                                                                                    <td><input type="text" name="onlyBearing5" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 6}">
                                                                                    <td><input type="text" name="onlyBearing6" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>    
                                                                                <c:if test="${i1 >= 7}">
                                                                                    <td><input type="text" name="onlyBearing7" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>   
                                                                                <c:if test="${i1 >= 8}">
                                                                                    <td><input type="text" name="onlyBearing8" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 9}">
                                                                                    <td><input type="text" name="onlyBearing9" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if> 
                                                                                <c:if test="${i1 >= 10}">
                                                                                    <td><input type="text" name="onlyBearing10" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if> 
                                                                                    
                                                                                <input type="hidden" name="sr_no"  value="${serviceDetail.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceDetail.itemDesc}" >
                                                                                
                                                                            </tr>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </c:when>
                                                                            
                                                                    <c:otherwise>
                                                                        
                                                                            <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>${serviceDetail.srNo}</th>
                                                                                        <th>${serviceDetail.itemDesc}</th>
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
                                                                         <c:forEach var="serviceVendorTenderBidItem2" items="${serviceVendorTenderBidItem2}" varStatus="status">
                                                                             
                                                                             <tr>
                                                                                <td>${status.count}</td>
                                                                                <td>${serviceVendorTenderBidItem2.itemDesc}</td>
                                                                                
                                                                                <c:if test="${i1 >= 1}">
                                                                                    <td><input type="text" name="onlyBearing1" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing1}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 2}">
                                                                                    <td><input type="text" name="onlyBearing2" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing2}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 3}">
                                                                                    <td><input type="text" name="onlyBearing3" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing3}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 4}">
                                                                                    <td><input type="text" name="onlyBearing4" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing4}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 5}">
                                                                                    <td><input type="text" name="onlyBearing4" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing5}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 6}">
                                                                                    <td><input type="text" name="onlyBearing6" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing6}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 7}">
                                                                                    <td><input type="text" name="onlyBearing7" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing7}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 8}">
                                                                                    <td><input type="text" name="onlyBearing8" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing8}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 9}">
                                                                                    <td><input type="text" name="onlyBearing9" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing9}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 10}">
                                                                                    <td><input type="text" name="onlyBearing10" class="form-control" value="${serviceVendorTenderBidItem2.onlyBearing10}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)"></td>
                                                                                </c:if>
                                                                                <input type="hidden" name="sr_no"  value="${serviceVendorTenderBidItem2.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceVendorTenderBidItem2.itemDesc}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>       
                                                                    </c:otherwise>

                                                                </c:choose>
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                        
                                                            </tbody>
                                                    
                                                        </table>
                                                    </div>
                                                </div> 
                                                                                
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service3'}">
                                                 <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Particular</th>
                                                                    <th>Amount</th>
                                                                    <th>Percentage</th>
                                                                    <th>Percentage Amount</th>
                                                                    <th>Total Amount</th>
                                                                    <th>Vendor Remark</th>
                                                                    <c:if test="${fileDetail.allowReg == 'allow_regret_service3'}">
                                                                        <th>Regret</th>
                                                                    </c:if>
                                                                    
                                                                    
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                
                                                                <c:choose>
                                                                    <c:when test="${empty serviceVendorTenderBidItem3}">

                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceDetail.srNo} </td>
                                                                                <td>${serviceDetail.particular} </td>
                                                                                <td><input type="text" name="scheduled_amount" class="form-control" value="${serviceDetail.scheduledAmount}" required="true" readonly="true"></td>
                                                                                
                                                                                <c:if test="${fileDetail.negativeAmount == 'negative_amount_service3'}">
                                                                                    <td><input type="text" name="percentage" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey1(event)"  onChange="return itemcal3(this.id)"></td>
                                                                                </c:if>
                                                                                <c:if test="${fileDetail.negativeAmount != 'negative_amount_service3'}">
                                                                                    <td><input type="text" name="percentage" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal3(this.id)"></td>
                                                                                </c:if>
                                                                                
                                                                                
                                                                                
                                                                                <td><input type="text" name="percentage_amount" class="form-control" value="" required="true" readonly="true" ></td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="" required="true" readonly="true"></td>
                                                                                
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="" ></td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service3'}">
                                                                                    <td><input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal3();
                enable_text3(this.id);" title="Regret" onMouseDown='enable_text3(this.id);' onMouseUp="return itemcal3(this.id);"/></td>
                                                                                </c:if>
                                                                                <input type="hidden" name="item_regret"  value="0" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceDetail.srNo}" >
                                                                                <input type="hidden" name="particular"  value="${serviceDetail.particular}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </c:when>
                                                                            
                                                                    <c:otherwise>
                                                                         <c:forEach var="serviceVendorTenderBidItem3" items="${serviceVendorTenderBidItem3}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceVendorTenderBidItem3.srNo}</td>
                                                                                <td>${serviceVendorTenderBidItem3.particular}</td>
                                                                                
                                                                                <td><input type="text" name="scheduled_amount" class="form-control" value="${serviceVendorTenderBidItem3.scheduledAmount}" required="true" readonly="true"></td>
                                                                                <td>
                                                                                
                                                                                    <c:if test="${fileDetail.negativeAmount == 'negative_amount_service3'}">
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '1'}">
                                                                                            <input type="text" name="percentage" class="form-control" value="${serviceVendorTenderBidItem3.percent}" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey1(event)"  onChange="return itemcal3(this.id)" readonly="true">
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '0'}">
                                                                                            <input type="text" name="percentage" class="form-control" value="${serviceVendorTenderBidItem3.percent}" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey1(event)"  onChange="return itemcal3(this.id)">
                                                                                        </c:if>
                                                                                    </c:if>
                                                                                    <c:if test="${fileDetail.negativeAmount != 'negative_amount_service3'}">
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '1'}">
                                                                                            <input type="text" name="percentage" class="form-control" value="${serviceVendorTenderBidItem3.percent}" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal3(this.id)" readonly="true">
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '0'}">
                                                                                            <input type="text" name="percentage" class="form-control" value="${serviceVendorTenderBidItem3.percent}" required="true" onKeyUp="change(this.id, event); return itemcal3(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal3(this.id)">
                                                                                        </c:if>
                                                                                    </c:if>
                                                                                    
                                                                                    
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td><input type="text" name="percentage_amount" class="form-control" value="${serviceVendorTenderBidItem3.percentRate}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="${serviceVendorTenderBidItem3.amountTotal}" required="true" readonly="true"></td>
                                                                                
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="${serviceVendorTenderBidItem3.vendorRemark}" ></td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service3'}">
                                                                                    <td>
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '1'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Bid" onClick="return itemcal3();
                    enable_text3(this.id);" title="Regret" onMouseDown='enable_text3(this.id);' onMouseUp="return itemcal3(this.id);"/>
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem3.itemregret == '0'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal3();
                    enable_text3(this.id);" title="Regret" onMouseDown='enable_text3(this.id);' onMouseUp="return itemcal3(this.id);"/>
                                                                                        </c:if>


                                                                                    </td>
                                                                                </c:if>
                                                                                
                                                                                <input type="hidden" name="item_regret"  value="${serviceVendorTenderBidItem3.itemregret}" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceVendorTenderBidItem3.srNo}" >
                                                                                <input type="hidden" name="particular"  value="${serviceVendorTenderBidItem3.particular}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>       
                                                                    </c:otherwise>

                                                                </c:choose>
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                        <tr>
                                                                                <td></td>
                                                                                
                                                                                
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>Total</td>
                                                                                <td><input type="text" name="total_amount" class="form-control" value="${item_total}" required="true" readonly="true"></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                
                                                                            </tr>
                                                            </tbody>
                                                    
                                                        </table>
                                                    </div>
                                                </div>
                                                                                
                                                                                
<script>                                            
    function itemcal3(a)
    {
        //alert("");
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        if (document.form.percentage.length == null)
        {
            document.form.percentage_amount.value = document.form.scheduled_amount.value * document.form.percentage.value / 100;
            if(document.form.item_regret.value == '1')
            {
                var percentage_amount = 0;
                document.form.net_rate.value = 0;
                total = total + 0;
            }
            if(document.form.item_regret.value == '0')
            {
                var percentage_amount = document.form.scheduled_amount.value * document.form.percentage.value / 100;
                document.form.net_rate.value = parseFloat(document.form.scheduled_amount.value) + percentage_amount;
                total = total + (parseFloat(document.form.scheduled_amount.value) + percentage_amount);
            }
            
            
            
        }
        while (i1 < document.form.percentage.length) 
        {
            document.form.percentage_amount[i1].value = document.form.scheduled_amount[i1].value * document.form.percentage[i1].value / 100;
            if(document.form.item_regret[i1].value == '1')
            {
                var percentage_amount = 0;
                document.form.net_rate[i1].value = 0;
            
                total = total + 0;
            }
            if(document.form.item_regret[i1].value == '0')
            {
                var percentage_amount = document.form.scheduled_amount[i1].value * document.form.percentage[i1].value / 100;
                document.form.net_rate[i1].value = parseFloat(document.form.scheduled_amount[i1].value) + percentage_amount;
            
                total = total + (parseFloat(document.form.scheduled_amount[i1].value) + percentage_amount);
            }
            
            i1++;
            j1++;
	}
        
        document.form.total_amount.value = parseFloat(total).toFixed(2);
    }
    
    function enable_text3(a) {
                a = a - 1;
                var i = 0;
                
                var regret = form["Regret"];
                if (regret.length == null)
                {
                    if (form["Regret"].value == "Regret")
                    {
                        form["Regret"].value = "Bid";
                        form["item_regret"].value = '1';
                        form["percentage"].readOnly = true;
                        form["percentage"].value = '0';
                        
                        form["net_rate"].value = 0;
                    }
                    else
                    {
                        form["Regret"].value = "Regret";
                        
                        form["item_regret"].value = '0';
                        form["percentage"].readOnly = false;
                        form["percentage"].value = '0';
                        
                    }
                }
                else
                {
                    if (form.elements["Regret"][a].value == "Regret")
                    {
                        form.elements["Regret"][a].value = "Bid";
                        form.elements["item_regret"][a].value = '1';
                        form.elements["percentage"][a].readOnly = true;
                        form.elements["percentage"][a].value = 0;
                        
                        form.elements["net_rate"][a].value = 0;
                    }
                    else
                    {
                        form.elements["Regret"][a].value = "Regret";
                        form.elements["item_regret"][a].value = '0';
                        form.elements["percentage"][a].readOnly = false;
                        form.elements["percentage"][a].value = 0;
                    }

                }
            }
</script>
                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service4'}">
                                                <input type="hidden" name="from_date" value="${from_date}">
                                                <input type="hidden" name="to_date" value="${to_date}">
                                                <input type="hidden" name="diff_days" value="${diff_days}">
                                                
                                                  <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            
                                                                
                                                                
                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <c:if test="${status.count == 1}">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th></th>
                                                                                                    <c:if test="${serviceDetail.security1 != ''}">
                                                                                                        <th>${serviceDetail.security1}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security1}" >
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security2 != ''}">
                                                                                                        <th>${serviceDetail.security2}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security2}" >
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security3 != ''}">
                                                                                                        <th>${serviceDetail.security3}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security3}" >
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security4 != ''}">
                                                                                                        <th>${serviceDetail.security4}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security4}" >
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security5 != ''}">
                                                                                                        <th>${serviceDetail.security5}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security15}" >
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security6 != ''}">
                                                                                                        <th>${serviceDetail.security6}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security6}" >
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security7 != ''}">
                                                                                                        <th>${serviceDetail.security7}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security7}" >
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security8 != ''}">
                                                                                                        <th>${serviceDetail.security8}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security8}" >
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security9 != ''}">
                                                                                                        <th>${serviceDetail.security9}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security9}" >
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security10 != ''}">
                                                                                                        <th>${serviceDetail.security10}</th>
                                                                                                        <input type="hidden" name="security_name" class="form-control" value="${serviceDetail.security10}" >
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                        
                                                                                    </tr>
                                                                                </thead>

                                                                                <tbody>
                                                                            </c:if>
                                                                            <c:if test="${status.count != 1}">
                                                                                <c:set var = "obligations" value="${serviceDetail.name}"/>
                                                                            <tr>
                                                                                <td>Man Power Require </td>
                                                                                <c:if test="${i1 >= 1}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security1}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 2}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security2}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 3}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security3}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 4}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security4}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 5}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security5}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 6}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security6}" readonly="true" ></td>
                                                                                </c:if>    
                                                                                <c:if test="${i1 >= 7}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security7}" readonly="true" ></td>
                                                                                </c:if>   
                                                                                <c:if test="${i1 >= 8}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security8}" readonly="true" ></td>
                                                                                </c:if>
                                                                                <c:if test="${i1 >= 9}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security9}" readonly="true" ></td>
                                                                                </c:if> 
                                                                                <c:if test="${i1 >= 10}">
                                                                                    <td><input type="text" name="security" class="form-control" value="${serviceDetail.security10}" readonly="true" ></td>
                                                                                </c:if> 
                                                                                    
                                                                                
                                                                            </tr>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                            <tr>
                                                                                <td>Minimum Wages (Skilled/Unskilled)/Day</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="wage" id="wage" class="form-control" value="${serviceVendorTenderBidItem4.wages}" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <tr>
                                                                                <input type="hidden" name="obligations" id="obligations" value="${obligations}">
                                                                                <td> ${obligations} % Statutory Obligation</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="per" id="per" class="form-control" value="${serviceVendorTenderBidItem4.percentage}" readonly="true" ></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                                
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Total</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="" readonly="true" ></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="total" id="total" class="form-control" value="${serviceVendorTenderBidItem4.total}" readonly="true" ></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                                
                                                                            </tr>
                                                                            
                                                                            <c:if test="${fileDetail.allowance == 'allowance_service4'}">
                                                                                <tr>
                                                                                    <td>Allowance</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="allowance" id="allowance" class="form-control" value="${serviceVendorTenderBidItem4.allowance}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>Allowance Total</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" ></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="allowance_total" id="allowance_total" class="form-control" value="${serviceVendorTenderBidItem4.allowanceTotal}"  required="true"></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>

                                                                            </c:if>
                                                                            <c:if test="${fileDetail.allowance != 'allowance_service4'}">
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="0" required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="allowance" id="allowance" class="form-control" value="${serviceVendorTenderBidItem4.allowance}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="" readonly="true" >
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="allowance_total" id="allowance_total" class="form-control" value="${serviceVendorTenderBidItem4.allowanceTotal}"  required="true">
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.uniformTrainingCost == 'uniform_cost_service4'}">
                                                                                <tr>
                                                                                    <td>Uniform & Training Charges</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="uniform" id="uniform" class="form-control" value="${serviceVendorTenderBidItem4.uCharges}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.uniformTrainingCost != 'uniform_cost_service4'}">
                                                                                <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                               <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="uniform" id="uniform" class="form-control" value="${serviceVendorTenderBidItem4.uCharges}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.serviceCharge == 'service_charge_service4'}">
                                                                                <tr>
                                                                                    <td>Service Charge</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value"></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="service" id="service" class="form-control" value="${serviceVendorTenderBidItem4.sCharges}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" ></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.serviceCharge != 'service_charge_service4'}">
                                                                                  <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 6}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                                <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="0" required="true" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value">
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="service" id="service" class="form-control" value="${serviceVendorTenderBidItem4.sCharges}"  required="true" onKeyUp="wages_info(this.id);" onKeyPress="return isNumberKey(event)"  onChange="wages_info(this.id);" placeholder="Enter Value" >
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                                
                                                                            </c:if>    
                                                                                
                                                                            
                                                                            <tr>
                                                                                <td>Total per day per person</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if> 
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if> 
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="total_per_day" id="total_per_day" class="form-control" value="${serviceVendorTenderBidItem4.tPDPP}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Total per Month(30 Days) per person</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="total_per_month" id="total_per_month" class="form-control" value="${serviceVendorTenderBidItem4.tPMPP}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Total per Year(365 Days) per person</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="total_per_year" id="total_per_year" class="form-control" value="${serviceVendorTenderBidItem4.tPYPP}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            
                                                                            <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                <tr>
                                                                                    <td>Total per date difference ${diff_days} per person from ${from_date} to ${to_date}</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="${serviceVendorTenderBidItem4.perDayPerPerson}"  readonly="true"></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.dateWise != 'date_service4'}">
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="total_per_day_pp" id="total_per_day_pp" class="form-control" value="${serviceVendorTenderBidItem4.perDayPerPerson}"  readonly="true">
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                            </c:if>
                                                                            
                                                                            <tr>
                                                                                <td>Total per day</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="per_day" id="per_day" class="form-control" value="${serviceVendorTenderBidItem4.tPD}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Total per Month(30 Days)</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="per_month" id="per_month" class="form-control" value="${serviceVendorTenderBidItem4.tPM}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <tr>
                                                                                <td>Total per Year(365 Days)</td>
                                                                                <c:choose>
                                                                                    <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                        <c:if test="${i1 >= 1}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 2}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 3}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 4}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 5}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 6}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 7}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 8}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 9}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                        <c:if test="${i1 >= 10}">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="" readonly="true"></td>
                                                                                        </c:if>
                                                                                    </c:when>
                                                                                    <c:otherwise>
                                                                                        <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                            <td><input type="text" name="per_year" id="per_year" class="form-control" value="${serviceVendorTenderBidItem4.tDY}"  readonly="true"></td>
                                                                                        </c:forEach>    
                                                                                    </c:otherwise>

                                                                                </c:choose>
                                                                            </tr>
                                                                            <c:if test="${fileDetail.dateWise == 'date_service4'}">
                                                                                <tr>
                                                                                    <td>Total per date difference ${diff_days} from ${from_date} to ${to_date}</td>
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="" readonly="true"></td>
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <td><input type="text" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="${serviceVendorTenderBidItem4.perDayPerDay}"  readonly="true"></td>
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                                </tr>
                                                                            </c:if>
                                                                            <c:if test="${fileDetail.dateWise != 'date_service4'}">
                                                                                    <c:choose>
                                                                                        <c:when test="${empty serviceVendorTenderBidItem4}">
                                                                                            <c:if test="${i1 >= 1}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 2}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 3}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 4}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 5}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 6}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 7}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 8}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 9}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                            <c:if test="${i1 >= 10}">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="0" readonly="true">
                                                                                            </c:if>
                                                                                        </c:when>
                                                                                        <c:otherwise>
                                                                                            <c:forEach var="serviceVendorTenderBidItem4" items="${serviceVendorTenderBidItem4}" varStatus="status">
                                                                                                <input type="hidden" name="total_per_day_per_pp" id="total_per_day_per_pp" class="form-control" value="${serviceVendorTenderBidItem4.perDayPerDay}"  readonly="true">
                                                                                            </c:forEach>    
                                                                                        </c:otherwise>

                                                                                    </c:choose>
                                                                            </c:if>
                                                                    
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                        
                                                            </tbody>
                                                    
                                                        </table>
                                                    </div>
                                                </div> 
                                            </c:if>
                                        
                    <script type="text/javascript">
            function wages_info(pqr) {
             //  alert("");
            var i4=0;
            var obligations = document.form.obligations.value;
            //alert(document.form.wage.length);
            while (i4 < document.form.wage.length) 
            {
              
                var wage=document.form.wage[i4].value;
                
                if(wage > '0')
                {}
                else{
                    wage = 0;
                }
                document.form.per[i4].value = (parseFloat(wage) * parseFloat(obligations) / 100).toFixed(2) ;
                var percentage = (parseFloat(wage) * parseFloat(obligations) / 100).toFixed(2) ;
                document.form.total[i4].value = (parseFloat(wage) + parseFloat(percentage)).toFixed(2) ;
                
                var total = (parseFloat(document.form.wage[i4].value) + parseFloat(percentage)).toFixed(2) ;
            
                if(total > '0')
                {}
                else{
                    total = 0;
                }
                
                var allowance=document.form.allowance[i4].value;
                if(allowance > '0')
                {}
                else{
                    allowance = 0;
                }
                
                document.form.allowance_total[i4].value = parseFloat(total) + parseFloat(allowance);
                
                var per_day_charge = parseFloat(total) + parseFloat(document.form.allowance[i4].value) +  parseFloat(document.form.uniform[i4].value)  +  parseFloat(document.form.service[i4].value); 
                
                if(per_day_charge > '0')
                {}
                else{
                    per_day_charge = 0;
                }
                document.form.total_per_day[i4].value = per_day_charge;
                
                var diff_days = document.form.diff_days.value;
                var per_month_charge = per_day_charge * 30;
                var per_year_charge = per_day_charge * 365;
                var per_day_date_charge = per_day_charge * parseFloat(diff_days);
                
                
                document.form.total_per_month[i4].value = per_month_charge;
                document.form.total_per_year[i4].value = per_year_charge;
                document.form.total_per_day_pp[i4].value = per_day_date_charge;
                
                var per_day_charge_p = parseFloat(per_day_charge) * parseFloat(document.form.security[i4].value);
                var per_month_charge_p = per_day_charge_p * 30;
                var per_year_charge_p = per_day_charge_p * 365;
                var per_day_date_charge_p =  per_day_charge_p * parseFloat(diff_days);
                
                document.form.per_day[i4].value = per_day_charge_p;
                document.form.per_month[i4].value = per_month_charge_p;
                document.form.per_year[i4].value = per_year_charge_p;
                document.form.total_per_day_per_pp[i4].value = per_day_date_charge_p;
                
                i4++;
            }
               // alert("");
                
                
               // alert("");
                
                var v = pqr.split("_");
                var wages = document.getElementById("wage_" + v[1]).value;
                var percentage = document.getElementById("percentage").value;
                var per_1 = document.getElementById("per_" + v[1]);
                var total = document.getElementById("total_" + v[1]);

                var result = (wages * percentage) / 100;
                if (result != 0)
                {
                    per_1.value = result.toFixed(2);
                }
                if (per_1.value != 0)
                {
                    var c = parseFloat(per_1.value) + parseFloat(wages);
                    total.value = c.toFixed(2);
                }

                var service_charges = document.getElementById("service_" + v[1]).value;
                if (service_charges === "")
                    service_charges = 0;
                var date_wise = document.getElementById("total_per_day_pp1").value;
                if (date_wise === "")
                    date_wise = 0;
                var allowance_hidden = document.getElementById("allowance_hidden").value;

                var allowance_1;
                if (allowance_hidden != "") {

                    allowance_1 = document.getElementById("allowance_" + v[1]).value;
                    if (allowance_1 === "")
                        allowance_1 = 0;
                } else {
                    allowance_1 = 0;
                }
                var uniform_charges = document.getElementById("uniform_" + v[1]).value;
                if (uniform_charges === "")
                    uniform_charges = 0;
                var sec = document.getElementById("sec_" + v[1]).value;
                if (sec === "")
                    sec = 0;
                var total_per_day = document.getElementById("total_per_day_" + v[1]);
                var total_per_month = document.getElementById("total_per_month_" + v[1]);
                var total_per_year = document.getElementById("total_per_year_" + v[1]);
                var per_day = document.getElementById("per_day_" + v[1]);
                var per_month = document.getElementById("per_month_" + v[1]);
                var total_per_day_pp = document.getElementById("total_per_day_pp_" + v[1]);
                var total_per_day_per_pp = document.getElementById("total_per_day_per_pp_" + v[1]);
                var per_year = document.getElementById("per_year_" + v[1]);
                var allow_total = document.getElementById("allow_total_" + v[1]);
                var temp3 = (parseFloat(total.value) + parseFloat(allowance_1)).toFixed(2);
                var temp = (parseFloat(total.value) + parseFloat(uniform_charges) + parseFloat(allowance_1)).toFixed(2);

                //  var service_charge12 = (parseFloat(temp) * parseFloat(service_charges)) / 100;
                var temp2 = parseFloat(temp) + parseFloat(service_charges);

                allow_total.value = temp3;
                total_per_day.value = temp2.toFixed(2);

                var total_per_pp = parseFloat(total_per_day.value) * parseFloat(date_wise);
                total_per_day_pp.value = total_per_pp.toFixed(2);

                var month_final = parseFloat(total_per_day.value) * 30
                total_per_month.value = month_final.toFixed(2);

                var year_final = parseFloat(total_per_day.value) * 365;
                total_per_year.value = year_final.toFixed(2);

                var p_day = parseFloat(total_per_day.value) * parseFloat(sec);
                per_day.value = p_day.toFixed(2);

                var p_month = parseFloat(total_per_month.value) * parseFloat(sec);
                per_month.value = p_month.toFixed(2);

                var p_year = parseFloat(total_per_year.value) * parseFloat(sec);
                per_year.value = p_year.toFixed(2);

                var total_per_pp1 = parseFloat(per_day.value) * parseFloat(date_wise);
                total_per_day_per_pp.value = total_per_pp1.toFixed(2);
            }
                </script>
                                            <c:if test="${fileDetail.serType == 'Service5'}">

                                                    <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>Item Description</th>
                                                                    <th>Remark</th>
                                                                    <th>UOM</th>
                                                                    <th>Quantity</th>
                                                                    <th>Unit Rate</th>
                                                                    <th>Amount</th>
                                                                    <th>HSN No.</th>
                                                                    <th>Vendor Remark</th>
                                                                    <c:if test="${fileDetail.allowReg == 'allow_regret_service5'}">
                                                                        <th>Regret</th>
                                                                    </c:if>
                                                                    
                                                                    <th>Item Wise Taxes & Duties</th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                
                                                                <c:choose>
                                                                    <c:when test="${empty serviceVendorTenderBidItem}">

                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceDetail.srNo} </td>
                                                                                <td>${serviceDetail.itemDesc} </td>
                                                                                <td>${serviceDetail.remark}</td>
                                                                                
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="uom" class="form-control" value="" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="uom" class="form-control" value="${serviceDetail.uom}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="qty" class="form-control" value="0" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="qty" class="form-control" value="${serviceDetail.qty}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="unit_rate" class="form-control" value="0" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="unit_rate" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="net_rate" class="form-control" value="0" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="net_rate" class="form-control" value="" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="hsn_no" class="form-control" value="" required="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="hsn_no" class="form-control" value="" required="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input type="hidden" name="vendor_remark" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input type="text" name="vendor_remark" class="form-control" value="" >
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service5'}">
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom == ''}">
                                                                                        <input name="Regret" type="hidden" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
                                                                                        <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                    </c:if>
        
                                                                                </td>
                                                                                </c:if>
                                                                                <td>
                                                                                    <c:if test="${serviceDetail.uom != ''}">
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
                                                                                <input type="hidden" name="sr_no"  value="${serviceDetail.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceDetail.itemDesc}" >
                                                                                <input type="hidden" name="item_remark"  value="${serviceDetail.remark}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </c:when>
                                                                            
                                                                    <c:otherwise>
                                                                         <c:forEach var="serviceVendorTenderBidItem" items="${serviceVendorTenderBidItem}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceVendorTenderBidItem.srNo}</td>
                                                                                <td>${serviceVendorTenderBidItem.itemDesc}</td>
                                                                                <td>${serviceVendorTenderBidItem.remark}</td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="uom" class="form-control" value="${serviceVendorTenderBidItem.uom}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="uom" class="form-control" value="${serviceVendorTenderBidItem.uom}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="qty" class="form-control" value="${serviceVendorTenderBidItem.quantity}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="qty" class="form-control" value="${serviceVendorTenderBidItem.quantity}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="unit_rate" class="form-control" value="${serviceVendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <c:if test="${serviceVendorTenderBidItem.itemRegret == '1'}">
                                                                                            <input type="text" name="unit_rate" class="form-control" value="${serviceVendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)" readonly="true">
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem.itemRegret == '0'}">
                                                                                            <input type="text" name="unit_rate" class="form-control" value="${serviceVendorTenderBidItem.rate}" required="true" onKeyUp="change(this.id, event); return itemcal(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal(this.id)">
                                                                                        </c:if>
                                                                                        
                                                                                        
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="net_rate" class="form-control" value="${serviceVendorTenderBidItem.netRate}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="net_rate" class="form-control" value="${serviceVendorTenderBidItem.netRate}" required="true" readonly="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="hsn_no" class="form-control" value="${serviceVendorTenderBidItem.hsnNo}" required="true">
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="hsn_no" class="form-control" value="${serviceVendorTenderBidItem.hsnNo}" required="true">
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                        <input type="hidden" name="vendor_remark" class="form-control" value="${serviceVendorTenderBidItem.vendorRemark}" >
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="text" name="vendor_remark" class="form-control" value="${serviceVendorTenderBidItem.vendorRemark}" >
                                                                                    </c:if>
                                                                                    
                                                                                
                                                                                </td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service5'}">
                                                                                    <td>
                                                                                        <c:if test="${serviceVendorTenderBidItem.uom == ''}">
                                                                                            <input name="Regret" type="hidden" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                            <c:if test="${serviceVendorTenderBidItem.itemRegret == '1'}">
                                                                                                <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Bid" onClick="return itemcal1();
                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                            </c:if>
                                                                                            <c:if test="${serviceVendorTenderBidItem.itemRegret == '0'}">
                                                                                                <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal1();
                    enable_text(this.id);" title="Regret" onMouseDown='enable_text(this.id);' onMouseUp="return itemcal(this.id);"/>
                                                                                            </c:if>


                                                                                        </c:if>

                                                                                    </td>
                                                                                </c:if>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem.uom != ''}">
                                                                                        <input type="button" name="itemsubmit" class="form-control"  value="Tax Details" id="${status.count}" onClick="check(this.id);" />
                                                                                    </c:if>
                                                                                    
                                                                                    
                                                                                
                                                                                </td>
                                                                                <input type="hidden" name="item_discount_val"  value="${serviceVendorTenderBidItem.discountType}" >
                                                                                <input type="hidden" name="item_discount"  value="${serviceVendorTenderBidItem.discountValue}" >
                                                                                <input type="hidden" name="item_packing_val"  value="${serviceVendorTenderBidItem.packingType}" >
                                                                                <input type="hidden" name="item_packing"  value="${serviceVendorTenderBidItem.packingValue}" >
                                                                                <input type="hidden" name="item_freight_val"  value="${serviceVendorTenderBidItem.freightType}" >
                                                                                <input type="hidden" name="item_freight"  value="${serviceVendorTenderBidItem.freightValue}" >
                                                                                <input type="hidden" name="item_errection"  value="${serviceVendorTenderBidItem.errectionValue}" >
                                                                                <input type="hidden" name="item_other_charges"  value="${serviceVendorTenderBidItem.chargesValue}" >
                                                                                <input type="hidden" name="item_igst"  value="${serviceVendorTenderBidItem.igstValue}" >
                                                                                <input type="hidden" name="item_cgst"  value="${serviceVendorTenderBidItem.cgstValue}" >
                                                                                <input type="hidden" name="item_sgst"  value="${serviceVendorTenderBidItem.sgstValue}" >
                                                                                <input type="hidden" name="item_insurance_value"  value="${serviceVendorTenderBidItem.insuranceValue}" >
                                                                                <input type="hidden" name="item_total"  value="${serviceVendorTenderBidItem.totalValue}" >
                                                                                <input type="hidden" name="item_regret"  value="${serviceVendorTenderBidItem.itemRegret}" >
                                                                                <input type="hidden" name="item_code"  value="${serviceVendorTenderBidItem.srNo}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceVendorTenderBidItem.itemDesc}" >
                                                                                <input type="hidden" name="item_remark"  value="${serviceVendorTenderBidItem.remark}" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceVendorTenderBidItem.srNo}" >
                                                                            </tr>
                                                                        </c:forEach>       
                                                                    </c:otherwise>

                                                                </c:choose>
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                        <tr>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>Total</td>
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
                                                    <label class="control-label">Freight<span style="color: red;font-size: 12px;">*</span></label>
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


                                            </c:if>
                                            <c:if test="${fileDetail.serType == 'Service6'}">
                                                 <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr No.</th>
                                                                    <th>PC Type</th>
                                                                    <th>Description</th>
                                                                    <th>UOM</th>
                                                                    <th>QTY</th>
                                                                    <th>AMC Required days</th>
                                                                    <th>Rate</th>
                                                                    <th>Total Rate</th>
                                                                    <th>Remark</th>
                                                                    <c:if test="${fileDetail.allowReg == 'allow_regret_service6'}">
                                                                        <th>Regret</th>
                                                                    </c:if>
                                                                    
                                                                    
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                
                                                                <c:choose>
                                                                    <c:when test="${empty serviceVendorTenderBidItem6}">

                                                                        <c:forEach var="serviceDetail" items="${serviceDetail}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceDetail.srNo} </td>
                                                                                <td>${serviceDetail.pcType} </td>
                                                                                <td>${serviceDetail.itemDescription} </td>
                                                                                <td>${serviceDetail.uom} </td>
                                                                                <td><input type="text" name="qty" class="form-control" value="${serviceDetail.qty}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="amc_required_days" class="form-control" value="${serviceDetail.amcRequiredDays}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="rate" class="form-control" value="" required="true" onKeyUp="change(this.id, event); return itemcal4(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal4(this.id)"></td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="" required="true" readonly="true"></td>
                                                                                
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="" ></td>
                                                                                
                                                                                
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service6'}">
                                                                                    <td><input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal4();
                enable_text4(this.id);" title="Regret" onMouseDown='enable_text4(this.id);' onMouseUp="return itemcal4(this.id);"/></td>
                                                                                </c:if>
                                                                                <input type="hidden" name="item_regret"  value="0" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceDetail.srNo}" >
                                                                                <input type="hidden" name="uom"  value="${serviceDetail.uom}" >
                                                                                <input type="hidden" name="pc_type"  value="${serviceDetail.pcType}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceDetail.itemDescription}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </c:when>
                                                                            
                                                                    <c:otherwise>
                                                                         <c:forEach var="serviceVendorTenderBidItem6" items="${serviceVendorTenderBidItem6}" varStatus="status">
                                                                            <tr>
                                                                                <td>${serviceVendorTenderBidItem6.srNo}</td>
                                                                                <td>${serviceVendorTenderBidItem6.pcType}</td>
                                                                                <td>${serviceVendorTenderBidItem6.itemDesc}</td>
                                                                                <td>${serviceVendorTenderBidItem6.uom}</td>
                                                                                
                                                                                <td><input type="text" name="qty" class="form-control" value="${serviceVendorTenderBidItem6.quantity}" required="true" readonly="true"></td>
                                                                                <td><input type="text" name="amc_required_days" class="form-control" value="${serviceVendorTenderBidItem6.amcRequiredDays}" required="true" readonly="true"></td>
                                                                                <td>
                                                                                    <c:if test="${serviceVendorTenderBidItem6.itemregret == '1'}">
                                                                                        <input type="text" name="rate" class="form-control" value="${serviceVendorTenderBidItem6.rate}" required="true" onKeyUp="change(this.id, event); return itemcal4(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal4(this.id)" readonly="true" >
                                                                                    </c:if>
                                                                                    <c:if test="${serviceVendorTenderBidItem6.itemregret == '0'}">
                                                                                        <input type="text" name="rate" class="form-control" value="${serviceVendorTenderBidItem6.rate}" required="true" onKeyUp="change(this.id, event); return itemcal4(this.id);" onKeyPress="return isNumberKey(event)"  onChange="return itemcal4(this.id)">
                                                                                    </c:if>
                                                                                    
                                                                                    
                                                                                </td>
                                                                                <td><input type="text" name="net_rate" class="form-control" value="${serviceVendorTenderBidItem6.amountTotal}" required="true" readonly="true"></td>
                                                                                
                                                                                <td><input type="text" name="vendor_remark" class="form-control" value="${serviceVendorTenderBidItem6.vendorRemark}" ></td>
                                                                                <c:if test="${fileDetail.allowReg == 'allow_regret_service6'}">
                                                                                    <td>
                                                                                        <c:if test="${serviceVendorTenderBidItem6.itemregret == '1'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Bid" onClick="return itemcal4();
                    enable_text4(this.id);" title="Regret" onMouseDown='enable_text4(this.id);' onMouseUp="return itemcal4(this.id);"/>
                                                                                        </c:if>
                                                                                        <c:if test="${serviceVendorTenderBidItem6.itemregret == '0'}">
                                                                                            <input name="Regret" type="button" Id="${status.count}" class="form-control" style="width:100%;" value="Regret" onClick="return itemcal4();
                    enable_text4(this.id);" title="Regret" onMouseDown='enable_text4(this.id);' onMouseUp="return itemcal4(this.id);"/>
                                                                                        </c:if>


                                                                                    </td>
                                                                                </c:if>
                                                                                <input type="hidden" name="item_regret"  value="${serviceVendorTenderBidItem6.itemregret}" >
                                                                                <input type="hidden" name="sr_no"  value="${serviceVendorTenderBidItem6.srNo}" >
                                                                                <input type="hidden" name="uom"  value="${serviceVendorTenderBidItem6.uom}" >
                                                                                <input type="hidden" name="pc_type"  value="${serviceVendorTenderBidItem6.pcType}" >
                                                                                <input type="hidden" name="item_description"  value="${serviceVendorTenderBidItem6.itemDesc}" >
                                                                                
                                                                            </tr>
                                                                        </c:forEach>       
                                                                    </c:otherwise>

                                                                </c:choose>
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                        <tr>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td> </td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                <td>Total</td>
                                                                                <td><input type="text" name="total_amount" class="form-control" value="${item_total}" required="true" readonly="true"></td>
                                                                                <td></td>
                                                                                <td></td>
                                                                                
                                                                            </tr>
                                                            </tbody>
                                                    
                                                        </table>
                                                    </div>
                                                </div>
                                            </c:if>

<script>                                            
function itemcal4(a)
    {
        //alert("");
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        if (document.form.rate.length == null)
        {
                document.form.net_rate.value = document.form.rate.value * document.form.qty.value * document.form.amc_required_days.value;
                total = total + document.form.rate.value * document.form.qty.value  * document.form.amc_required_days.value;
        }
        while (i1 < document.form.rate.length) 
        {
            document.form.net_rate[i1].value = document.form.rate[i1].value * document.form.qty[i1].value  * document.form.amc_required_days[i1].value;
            total = total + document.form.rate[i1].value * document.form.qty[i1].value * document.form.amc_required_days[i1].value;
            i1++;
            j1++;
	}
        
        document.form.total_amount.value = parseFloat(total).toFixed(2);
                   }
                   
                   
        function enable_text4(a) {
                a = a - 1;
                var i = 0;
                
                var regret = form["Regret"];
                if (regret.length == null)
                {
                    if (form["Regret"].value == "Regret")
                    {
                        form["Regret"].value = "Bid";
                        form["item_regret"].value = '1';
                        form["rate"].readOnly = true;
                        form["rate"].value = '0';
                        
                        form["net_rate"].value = 0;
                    }
                    else
                    {
                        form["Regret"].value = "Regret";
                        
                        form["item_regret"].value = '0';
                        form["rate"].readOnly = false;
                        form["rate"].value = '0';
                        
                    }
                }
                else
                {
                    if (form.elements["Regret"][a].value == "Regret")
                    {
                        form.elements["Regret"][a].value = "Bid";
                        form.elements["item_regret"][a].value = '1';
                        form.elements["rate"][a].readOnly = true;
                        form.elements["rate"][a].value = 0;
                        
                        form.elements["net_rate"][a].value = 0;
                    }
                    else
                    {
                        form.elements["Regret"][a].value = "Regret";
                        form.elements["item_regret"][a].value = '0';
                        form.elements["rate"][a].readOnly = false;
                        form.elements["rate"][a].value = 0;
                    }

                }
            }
                   </script>
                   
                   
                   
                                        </c:if>
                                        
                                    </c:forEach>
                                    
                                    
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            
                                                            
                                                </table>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
   
</html>
