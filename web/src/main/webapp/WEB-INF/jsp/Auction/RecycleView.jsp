<%-- 
    Document   : RecycleView
    Created on : 8 Aug, 2022, 5:25:55 PM
    Author     : admin
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction Information</title>
        
<script language="javascript" type="text/javascript">
    
    function recycleTender()
    {
        window.location='auctionMaster.htm?act=recycleAuction';
    }
    
    function rejectTender()
    {
        window.location='auctionMaster.htm?act=rejectAuction';
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
            <h1>Auction Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Auction Information</li>
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
                                <form:form action="auctionMaster.htm?act=submitRecycleView" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                       name="form"    class="form-horizontal" role="form">
                                    
                                    ${type}  Auction Information
                                    <hr>
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Type :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="type" value="${type}" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Reference No. :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-2">
                                             <form:input path="auctionNo" id="auctionNo" class="form-control" value="${auctionNo}"  maxlength="30" required="required" readonly="true"/>
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
                                            <label class="control-label">Auction Value :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="value" class="form-control" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Item Category :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="categoryId" class="form-control"   maxlength="30" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Fee :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="docCost" class="form-control"   pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction EMD :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="emd" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Location :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="location" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="biddingStartdate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Due Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="hidden" name="biddingEnddate1" value="${auctionMaster.biddingEnddate}">
                                            <%--<form:input id='datetimepicker2' path="submitLastdate" class="form-control"   maxlength="30" required="required"/>--%>
                                            <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                             <div class='input-group date' id='datetimepicker1'>
                                                   <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                                <input name="biddingEnddate" class="form-control form_datetime" placeholder="dd-mm-yyyy --:--" path="biddingEnddate" value="${submitLastdate}" />
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
                                            <label class="control-label">Last Bidding Time :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class='input-group date' id='datetimepicker2'>
                                              <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                              <input class="form-control form_datetime" placeholder="hh:mm:ss" path="lastBiddingTime"  name="lastBiddingTime" value="00:02:00"/>
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                             <script type="text/javascript">
                                                $(function () {
                                                    $('#datetimepicker2').datetimepicker({
                                                        format: 'HH:mm:ss', 
                                                      
                                                    });
                                                });
                                            </script>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Extend Time :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class='input-group date' id='datetimepicker3'>
                                              <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                              <input class="form-control form_datetime" placeholder="hh:mm:ss" path="extendTime"  name="extendTime" value="00:02:00"/>
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                                            </div>
                                             <script type="text/javascript">
                                                $(function () {
                                                    $('#datetimepicker3').datetimepicker({
                                                        format: 'HH:mm:ss', 
                                                       
                                                    });
                                                });
                                            </script>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">No. Of Time Extend :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="extendTimeNo" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">
                                                <c:if test="${type == 'Reverse'}">
                                                    Auto Decrement (%) :
                                                </c:if>
                                                <c:if test="${type == 'Forward'}">
                                                    Auto Increment (%) :
                                                </c:if>
                                                
                                            </label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="autoDecIncAmount" class="form-control" pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Refresh Rate (In Second) :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="refreshRate" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Bidding Display :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="bidding_display" class="form-control" id="pmpyearss" onchange="selectcycleName(this.value);" required="true">
                                                <option value="Rank">Rank</option>
                                                <c:if test="${type == 'Reverse'}">
                                                    <option value="L1">L1</option>
                                                </c:if>
                                                <c:if test="${type == 'Forward'}">
                                                    <option value="H1">H1</option>
                                                </c:if>
                                                
                                                <option value="Both">Both</option>
                                            </select>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Work Description :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="workDesc" class="form-control"   maxlength="200" required="required"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">P.R. No. :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="prNo" class="form-control"   maxlength="30" />
                                        </div>
                                    </div>
                                    
                                    
                                    Auction Contact Person
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
                                             <form:input path="auctionAdminContactNumber" class="form-control" value="${ph_no}"  maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Authorize By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="auctionAuthorizePerson" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="auctionAuthorizeContactNo" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    Item Details &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="window.open('auctionMaster.htm?act=addItemDocument&ref_no=${auctionMaster.auctionNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Attachment File</a>
                                    
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser1(id); ">Refresh</a>
                                    <hr>
         
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>                                  
<script type="text/javascript">

                    
            var win2 = window.open("auctionMaster.htm?act=addItemDocument");
            win2.close();
            var str5 = document.getElementById("auctionNo").value;
            var ID1;
            function showuser1(str1)
            {
                str1 = document.getElementById("auctionNo").value;
                //var str5=str1;
              //  alert(str1);
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

                xreq1.open("post", "auctionMaster.htm?act=agaxAuctionItemDetails&q=" + str5, true);
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
                                    
                                    
                                    Auction Attachment
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">General Terms & Conditions :<span style="color: red;font-size: 12px;">*</span></label>
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
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${generalDocs.attachmentDoc}&RefNo=${refNo}">${generalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="auctionMaster.htm?act=deleteRecycleAttachmentDoc&docid=${generalDocs.id}&id=${id}" onclick=""/></td>
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
                                            <label class="control-label">Tender Additional Document :<span style="color: red;font-size: 12px;">*</span></label>
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
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${additionalDocs.attachmentDoc}&RefNo=${refNo}">${additionalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="auctionMaster.htm?act=deleteRecycleAttachmentDoc&docid=${additionalDocs.id}&id=${id}" onclick=""/></td>
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
                                            <label class="control-label">Tender Technical Document :<span style="color: red;font-size: 12px;">*</span></label>
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
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${technicalDocs.attachmentDoc}&RefNo=${refNo}">${technicalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                        <td><input type="submit" value="-" id="policyCloneid" formaction="auctionMaster.htm?act=deleteRecycleAttachmentDoc&docid=${technicalDocs.id}&id=${id}" onclick=""/></td>
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
                                    
                                   
                                    
                                    Auction Remark
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-4">
                                            <label class="control-label">Auction Remark</label>
                                        </div>
                                        <div class="col-sm-7">
                                            <textarea name="remark" class="form-control">${auction_remark}</textarea>
                                        </div>
                                    </div>
                                    
                                    Vendor Details
                                    <hr>
                                    
                                   <center><a href="#" onclick="window.open('auctionMaster.htm?act=uploadExcelVendorForAuction&ref_no=${auctionNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');">Upload Excel</a> 
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <a href="#" onclick="window.open('auctionMaster.htm?act=searchVendorForAuction&ref_no=${auctionNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Search</a> 

                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="showuser(id); ">Refresh</a></center>
<script type="text/javascript">

                    var win = window.open("auctionMaster.htm?act=searchVendorForAuction");
                    win.close();
                    //win.onunload =showuser;

                    var str7 = document.getElementById("auctionNo").value;
                    
                    function showuser(str)
                    {
                        str = document.getElementById("auctionNo").value;
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

                        xreq.open("post", "auctionMaster.htm?act=agaxAuctionVendorDetails&q=" + str7, true);
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
<script language="javascript" type="text/javascript">
    function calculate_price()
    {
        
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        
        if (document.form.start_price.length == null)
        {
            document.form.final_price.value = parseFloat(document.form.start_price.value) + parseFloat(document.form.loading_factor_val.value) + parseFloat((document.form.start_price.value * document.form.loading_factor_per.value / 100).toFixed(2));
        }
        while (i1 < document.form.start_price.length) 
        {
            
            alert("");
            document.form.final_price[i1].value = parseFloat(document.form.start_price[i1].value) + parseFloat(document.form.loading_factor_val[i1].value) + parseFloat((document.form.start_price[i1].value * document.form.loading_factor_per[i1].value / 100 ).toFixed(2));
            i1++;
            j1++;
	}
    }
    </script>
    <!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>

