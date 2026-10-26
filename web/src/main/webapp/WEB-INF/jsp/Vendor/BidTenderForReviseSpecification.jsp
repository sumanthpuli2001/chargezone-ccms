<%-- 
    Document   : BidTenderForReviseBidAttachment
    Created on : 16 Jan, 2024, 12:01:52 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Specification</title>
        
<script language="javascript" type="text/javascript">
    
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
    
        
        function test_skill(aa) {
           
          // setTimeout('', 500);
          // alert("");
        aa = document.form.grand_total.value;
//alert(form.grand_total.value);

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
                document.form.grand_total_word.value = aaa;


            }
          
</script>

    </head>
   
    <!---->
    <!--<body onLoad="return test_skill('1');">-->  
    
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Specification  </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Specification  </li>
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
                                <form:form action="vendor.htm?act=bidTenderForReviseSpecificationSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                      name="form"  class="form-horizontal" role="form" onsubmit="return validation();">
                                    
                                    Vendor Specification  
                                     <p align="right"><a target="blank" href="tenderMaster.htm?act=priceBidRevisePrint&refNo=${refNo}&vendorCode=${vendor_code}">Price Bid Print</a>
                                        </p>
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
                                            <input name="tender_revision" class="form-control" value="${rivision}" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required" readonly/>
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
                                    
                                    
                                   
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                    <B>Technical specification : </B>&nbsp;&nbsp;&nbsp;<a href="#" onclick="window.open('vendor.htm?act=addVendorReviseTechnicalSpecification&bid_type=1&ref_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attachment File</a> 

                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser5(id); ">Refresh</a>
                                    
                <script type="text/javascript">

                //    var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                //    win.close();
                    //win.onunload =showuser;

                    var str7 = document.getElementById("refNo").value;
                    
                    function showuser5(str)
                    {
                        str = document.getElementById("refNo").value;
                        //alert("");
                        str7 = str;
                        
                        //if(win && win.closed){
                        var xreq, ID;

                        if (str == "")
                        {
                            document.getElementById("showtext5").innerHTML = "";
                            return;
                        }
                        if (window.XMLHttpRequest)
                        {
                            xreq = new XMLHttpRequest();
                        }
                        else
                        {
                            xreq = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        xreq.onreadystatechange = function()
                        {
                            if ((xreq.readyState == 4) && (xreq.status == 200))
                            {
                                document.getElementById("showtext5").innerHTML = xreq.responseText;

                            }
                        }

                        xreq.open("post", "vendor.htm?act=agaxVendorReviseTechnicalSpecification&bid_type=1&q=" + str7, true);
                        xreq.send();

                        //}
                        window.clearInterval(ID);
                    }
                   
                    var ID = window.setInterval(showuser5(str7), 1000);
                    
</script>
                            </div>
                                        <div class="col-sm-5">
                <div id="showtext5"></div>
                
                                    </div>
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                    <B>Price specification : </B>&nbsp;&nbsp;&nbsp;<a href="#" onclick="window.open('vendor.htm?act=addVendorRevisePriceSpecification&bid_type=1&ref_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attachment File</a> 

                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser6(id); ">Refresh</a>
                                    
                <script type="text/javascript">

                //    var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                //    win.close();
                    //win.onunload =showuser;

                    var str7 = document.getElementById("refNo").value;
                    
                    function showuser6(str)
                    {
                        str = document.getElementById("refNo").value;
                        //alert("");
                        str7 = str;
                        
                        //if(win && win.closed){
                        var xreq, ID;

                        if (str == "")
                        {
                            document.getElementById("showtext6").innerHTML = "";
                            return;
                        }
                        if (window.XMLHttpRequest)
                        {
                            xreq = new XMLHttpRequest();
                        }
                        else
                        {
                            xreq = new ActiveXObject("Microsoft.XMLHTTP");
                        }
                        xreq.onreadystatechange = function()
                        {
                            if ((xreq.readyState == 4) && (xreq.status == 200))
                            {
                                document.getElementById("showtext6").innerHTML = xreq.responseText;

                            }
                        }

                        xreq.open("post", "vendor.htm?act=agaxVendorRevisePriceSpecification&bid_type=1&q=" + str7, true);
                        xreq.send();

                        //}
                        window.clearInterval(ID);
                    }
                   
                    var ID = window.setInterval(showuser6(str7), 1000);
                    
</script>
                            </div>
                                        <div class="col-sm-5">
                <div id="showtext6"></div>
                
                                    </div>
                                    </div>
                                    
                                    
                                    
                                    
                                   
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-4">
                                            
                                            
                                            <input type="submit" class="btn btn-primary" name="submit" style="width: 100px;"  title="" value="SUBMIT" >
                                            
                                            
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
<body onLoad="return test_skill('1');">
    </body>
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>

