<%-- 
    Document   : EmployeeCreate
    Created on : Jun 11, 2020, 2:39:39 PM
    Author     : Samir Tailor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tender Information</title>
        
<script language="javascript" type="text/javascript">
    
    function recycleTender()
    {
        window.location='tenderMaster.htm?act=recycleTender';
    }
    
    function rejectTender()
    {
        window.location='tenderMaster.htm?act=rejectTender';
    }
            
    function gettender() 
    {
        
        var t=document.getElementById("refNo").value;
        var tenderPhase = document.getElementById("tenderPhase").value;
        window.location='tenderMaster.htm?act=getTender&refNo='+t+'&tenderPhase='+tenderPhase;
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
            
        function updatedata(str){
	  var ss="";
	  //var ss=form["vendor_em"].value;
            if (typeof XMLHttpRequest != "undefined"){
		xmlHttp= new XMLHttpRequest();
		}
	  else if (window.ActiveXObject){
		xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
		}
	  if (xmlHttp==null){
	  alert("Browser does not support XMLHTTP Request")
	  return;
	  }
          
          var url="tenderMaster.htm?act=updateVendor";
	  url +="&tender_no=" +str+"&str1="+ss;
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
            if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
            { 
                var a=xmlHttp.responseText;

                var c=a.split("*");
                var b=c[0].split("$");
                var d=c[1].split("$");

                if(b.length==2)
                {
                    form["vendor_email_id"].value=b[0] ;
                }
                else
                {
                    for(var i=0;i<b.length-1;i++)
                    {
                        form["vendor_email_id"][i].value=b[i] ;
                    }
                }

                if(d.length==2)
                {
                   form["vendor_mob_no"].value=d[0] ;
                }
                else
                {
                   for(var i=0;i<d.length-1;i++)
                   {
                   form["vendor_mob_no"][i].value=d[i] ;
                   }
                }
            }   
	}

	  
</script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Information</li>
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
                                <form:form action="tenderMaster.htm?act=submitRecycleManualTenderView" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    
                                    ${tenderPhase} Part Tender Information
                                    <input type="hidden" name="tenderPhase" id="tenderPhase" value="${tenderPhase}">
                                    <hr>
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Type :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="type" value="Service" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Reference No. :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-2">
                                             <form:input path="refNo" id="refNo" class="form-control" value="${refNo}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Title :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="title" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Value :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="value" class="form-control" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender classification :
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="categoryId" class="form-control"   maxlength="30" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Fee :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="docCost" class="form-control"   pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender EMD :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="emd" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Location :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="location" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="announceDate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Tender Due Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            
                                            <%--<form:input id='datetimepicker2' path="submitLastdate" class="form-control"   maxlength="30" required="required"/>--%>
                                            <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                             <div class='input-group date' id='datetimepicker1'>
                                                   <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                                <input class="form-control form_datetime" placeholder="dd-mm-yyyy --:--" path="submitLastdate"  name="submitLastdate" value="${submitLastdate}"/>
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                             <script type="text/javascript">
                                                $(function () {
                                                    $('#datetimepicker1').datetimepicker({
                                                        format: 'DD-MM-YYYY HH:mm:ss', 
                                                        minDate: new Date()
                                                    });
                                                });
                                            </script>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Subject Description :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="workDesc" class="form-control"   maxlength="200" required="required"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">P.R. No. :
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="prNo" class="form-control"   maxlength="30" />
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
                                        
                                    Item Details&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="window.open('tenderMaster.htm?act=addServiceDocument1&ref_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attachment File</a>
                                    <hr>
                                    
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>                                  

<script type="text/javascript">

                    
            //var win2 = window.open("tenderMaster.htm?act=addServiceDocument");
            //win2.close();
            var str5 = document.getElementById("refNo").value;
            //str5 = "50";
            var ID1;
            function showuser1(str1)
            {
                str5 = document.getElementById("refNo").value;
                str1 = document.getElementById("refNo").value;
                //var str5=str1;
                //alert(str1);
                //if(win2 && win2.closed ){
                var xreq1;
                if (str1 === "")
                {
                    document.getElementById("showtext1").innerHTML = "";
                    return;
                }

                try {
                    xreq1 = new XMLHttpRequest();// Firefox, Opera 8.0+, Safari
                } catch (e) {
                    try {
                        xreq1 = new ActiveXObject("Msxml2.XMLHTTP"); // Internet Explorer
                    } catch (e) {
                        try {
                            xreq1 = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e) {
                            alert("No AJAX!?");
                            return false;
                        }
                    }
                }

                xreq1.onreadystatechange = function()
                {
                    if (xreq1.readyState == 4 && xreq1.status == 200)
                    {

                        document.getElementById("showtext1").innerHTML = xreq1.responseText;

                    }
                }

                xreq1.open("post", "tenderMaster.htm?act=agaxTenderItemDetailsByTenderNo&q=" + str5, true);
                xreq1.send();

                //}
                window.clearInterval(ID1);
            }
            ID1 = window.setInterval(showuser1(str5), 1000);
</script>


    <div id="showtext1"></div>
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                            </div>
                                        </div>
                                    
                                    Tender Attachment
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">General Terms & Conditions :</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${generalDocs.document}&RefNo=${refNo}">${generalDocs.document}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="tenderMaster.htm?act=deleteGeneralDocsR&docid=${generalDocs.id}" onclick=""/></td>
                                                                    </tr>
                                                        </c:forEach>
                                                                
                                                        
                                                        <tr>
                                                            <td style="text-align: center">
                                                                <input type="file" class="form-control" id="generalfile1" name="generalfile1" accept="" onchange="checkFileSize();">
                                                            </td>
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="policyCloneid" onclick="Policy();"/>
                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Additional Document :</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount1" id="policyCount1" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="additionalDocs" items="${additionalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${additionalDocs.document}&RefNo=${refNo}">${additionalDocs.document}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="tenderMaster.htm?act=deleteAdditionalDocsR&docid=${additionalDocs.id}" onclick=""/></td>
                                                                    </tr>
                                                        </c:forEach>
                                                        
                                                        
                                                        <tr>
                                                            <td style="text-align: center">
                                                                <input type="file" class="form-control" id="additionalfile1" name="additionalfile1" accept="" onchange="checkFileSize();">
                                                            </td>
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'>
                                                                    <input type="button" value="+" id="policyCloneid1" onclick="Policy1();"/>
                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Technical Document :</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount2" id="policyCount2" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${technicalDocs.document}&RefNo=${refNo}">${technicalDocs.document}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="tenderMaster.htm?act=deleteTechnicalDocsR&docid=${technicalDocs.id}" onclick=""/></td>
                                                                    </tr>
                                                        </c:forEach>
                                                        
                                                        <tr>
                                                            <td style="text-align: center">
                                                                <input type="file" class="form-control" id="technicalfile1" name="technicalfile1" accept="" onchange="checkFileSize();">
                                                            </td>
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'> 
                                                                    <input type="button" value="+" id="policyCloneid2" onclick="Policy2();"/>
                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    <c:if test="${tenderPhase == '3'}">
                                    Pre qualification Of Vendor
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Pre qualification Of Vendor For Three Part Tender.</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="preRemark" value="${tenderPreQualificationRemark}" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Excel File For Require Document From Vendor</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <a href="#" onclick="window.open('tenderMaster.htm?act=preQualifictionAttachByAdminfor3Phase&refNo=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attach File</a>
                                            <span id="requireDocument3">${tenderPreQualificationDocument}</span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Require Document From Vendor</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="preDocRemark" class="form-control">${tenderPreQualificationDocumentRemark}</textarea>
                                        </div>
                                    </div>
                                    </c:if>
                                    
                                    <c:if test="${tenderPhase != '1'}">
                                    Technical Detail / Specification
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Technical Detail For Three Part Tender.</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="technicalRemark" value="${tenderTechnicalRemark}" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Excel File For Technical Specification</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <a href="#" onclick="window.open('tenderMaster.htm?act=technicalSpecificationAttachByAdminfor2Phase&refNo=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attach File</a>
                                            <span id="requireDocument4">${tenderTechnicalDoc}</span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Technical Specification</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="technicalSpecRemark" class="form-control">${tenderTechnicalDocRemark}</textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Excel File For Terms And Condition</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <a href="#" onclick="window.open('tenderMaster.htm?act=termsConditionAttachByAdminfor2Phase&tender_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attach File</a>
                                            <span id="requireDocument5">${tenderTermsConditionDoc}</span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Terms And Condition</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="termsRemark" class="form-control">${tenderTermsConditionRemark}</textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Require Document From Vendor</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <a href="#" onclick="window.open('tenderMaster.htm?act=requiredDocAttachByAdminfor2Phase&tender_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attach File</a>
                                            <span id="requireDocument6">${tenderTechnicalDocument}</span>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Remark For Require Document From Vendor</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="docRemark" class="form-control">${tenderTechnicalDocumentRemark}</textarea>
                                        </div>
                                    </div>  
                                    </c:if>
                                    
                                    Tender Remark
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Tender Remark</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="remark" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    
                                    Vendor Details 
                                    <hr>
                                    
                                                                   
<center>  <a href="#" onclick="window.open('tenderMaster.htm?act=searchVendorForManualTender1&ref_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Search</a> 

                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser(id); ">Refresh</a></center>
<script type="text/javascript">

                    //var win = window.open("tenderMaster.htm?act=searchVendorForManualTender");
                    //win.close();
                    //win.onunload =showuser;

                    var str7 = document.getElementById("refNo").value;
                    
                    function showuser(str)
                    {
                        str = document.getElementById("refNo").value;
                        //alert("");
                        str7 = str;
                        
                        //if(win && win.closed){
                        var xreq, ID;

                        if (str == "")
                        {
                            document.getElementById("showtext").innerHTML = "";
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
                                document.getElementById("showtext").innerHTML = xreq.responseText;

                            }
                        }

                        xreq.open("post", "tenderMaster.htm?act=agaxTenderVendorDetails1&q=" + str7, true);
                        xreq.send();

                        //}
                        window.clearInterval(ID);
                    }
                   
                    var ID = window.setInterval(showuser(str7), 1000);
                    
</script>
                    
                <div id="showtext"></div>         
                
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                
                                            </div>
                                        </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Submit">
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

    <!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>
