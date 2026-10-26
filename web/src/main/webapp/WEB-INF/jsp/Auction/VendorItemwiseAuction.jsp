<%-- 
    Document   : VendorItemwiseAuction
    Created on : 
    Author     : admin
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    
    
    
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
            
    	  
</script>

<script>
            $(function(){
	
	var note = $('#note'),
		ts = new Date(2022,00,00),
		newYear = true;
	
	if((new Date()) > ts){
		// The new year is here! Count towards something else.
		// Notice the *1000 at the end - time must be in milliseconds

		 ts = (new Date()).getTime() + ${difference_In_Time};
		
//		ts = (new Date()).getTime() + 10*1000;
		// + 01*24*60*60*1000;

//		 ts = (new Date()).getTime() + 01*24*60*60*1000;
		newYear = false;
	}
		
	$('#countdown').countdown({
		timestamp	: ts,
		callback	: function(days, hours, minutes, seconds){
			
			var message = "";
			
			message += days + " day" + ( days==1 ? '':'s' ) + ", ";
			message += hours + " hour" + ( hours==1 ? '':'s' ) + ", ";
			message += minutes + " minute" + ( minutes==1 ? '':'s' ) + " and ";
			message += seconds + " second" + ( seconds==1 ? '':'s' ) + " <br />";
			
			if(hours == 0 && minutes == 0 && seconds ==  0){
				alert('Time Finish....!!!!');
                                window.location = 'vendorAuction.htm?act=liveVendorAuction';
                                
				if ($alert.is(':visible')){
					$alert.hide();
				}
			}
			else {
				message += "Done";
			}
			
			note.html(message);
		}
	});
	
});

        </script>
      <%--  //countdown --%>

        <style>
            .example {
                font-family: 'Roboto', sans-serif;
                width: 550px;
                margin: auto;
                box-sizing: border-box;
            }
        </style>

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
                                
                                
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                    
                                    <div id="countdown">
                                </div>
                                    
                          <form:form action="vendorAuction.htm?act=vendorItemAuctionApplySubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
           name="form"   class="form-horizontal" role="form">
                                    
                                    <hr>
                                    <input type="hidden" name="auction_no" value="${auction_no}">
                                    <input type="hidden" name="difference_In_Time" value="${difference_In_Time}">
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Type :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="type" id="type" value="${type}" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction No. :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <form:input path="auctionNo" value="${type}" class="form-control" readonly="true"/>
                                            
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Title :</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="title" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="biddingStartdate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Due Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="biddingEnddate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Work Description :</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="workDesc" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                   <input type="hidden" name="auction_no" id="auction_no" value="${auctionMaster.auctionNo}"> 
                                            <input type="hidden" name="auto" id ="auto" value="${auctionMaster.autoDecIncAmount}">
                                          <%--<c:set var="i1" value="0" />--%> 
                                        <c:forEach var="list" items="${auctionItemMasterList}" varStatus="status" >
                                            <%--<c:set var="i2" value="${i1+1}" />--%> 
                             
                                           
                                   <label class="control-label"><b><ul>Item Details:</ul></b></label>
                                   <br>
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center">    
                                               <input type="hidden" name="item_id" id="item_id" value="${list[12]}">
                                               
                                                    <tr>
                                                        <th style="width: 50px;">Item Code</th>
                                                        <th style="width: 50px;">Item Name</th>
                                                        <th style="width: 50px;">Item Description </th>
                                                        <th style="width: 50px;">Item Remark  </th>
                                                        <th style="width: 50px;">Uom</th>
                                                        <th style="width: 50px;">Quantity</th>
                                                       
                                                    </tr>
                           
                                                    <tr>   
                                                <td style="width: 50px;">${list[0]}</td>
                                                <td style="width: 50px;">${list[1]}</td>
                                                <td style="width: 50px;">${list[2]}</td>
                                                <td style="width: 50px;">${list[3]}</td>
                                                <td style="width: 50px;">${list[4]}</td>
                                                <td style="width: 50px;">${list[5]}</td>    
                                        
                                                    </tr>
                                                

                                            </table>
                                                    
                                                 <div class="form-group"></div>
                                                  <div class="form-group">
                                      
                                         
                                            <div class="col-sm-3">
                                                <label class="control-label">Rank :</label>
                                            </div>
                                            <div class="col-sm-2">
                                                <input type="text" name="rank" id="rank" class="form-control" value="${list[11]}"   readonly="true">
                                            </div>
                                              <div class="form-group"></div>
                                        <div class="col-sm-3">
                                            <label class="control-label">Loading Factor (%) :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="text" name="loading_per" id="loading_per" class="form-control" value="${list[8]}"   readonly="true">
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Loading Factor (Value) :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="text" name="loading_val" id="loading_val" class="form-control" value="${list[9]}"   readonly="true">
                                        </div>
                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Final Price :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="text" name="final_price" id="final_price" class="form-control" value="${list[10]}"   readonly="true">
                                            
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Price :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            
                                            <input type="hidden" name="start_price1"  value="${list[7]}">
                                            <input type="text" name="start_price"  class="form-control" value="${list[7]}"  required="true" onKeyPress="return isNumberKey(event)" onChange="return calculate_price()">
                                        </div>
                                        <div class="col-sm-1">
                                            <input type="button" class="btn btn-primary"  style="width: 100px;" title="" value="Auto" onclick="calculate_price(${status.count})">
                                        </div>
                                        
                                        <div class="col-sm-1">
                                             <input type="submit" class="btn btn-primary" name="Submit${status.count}" id="Submit${status.count}" style="width: 100px;"  title="" value="Submit" onclick="return calculate_price1()">
                                        </div>
                                     
                                     </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            
                                          
<!--                                            <input type="button" class="btn btn-danger" style="width: 100px;"  title="" value="CANCEL" onclick="window.location='vendorAuction.htm?act=liveVendorAuction'">-->
                                        </div>
                                    </div>
                                                             
                                        
                                        </c:forEach>       

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
    function isNumberKey(evt){
//    {            alert("auto");
        var charCode = (evt.which) ? evt.which : event.keyCode
                if (charCode == 46)
                {
                    return true;
                }
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                    return false;

                return true;
    }
    
    function calculate_price1()
    {
        var auto = document.form.auto.value;
             
        var type = document.form.type.value;
  
        var start_price = document.getElementById(start_price).value;
        
        var start_price1 = document.form.start_price1.value;
       
        //var auto1 = parseFloat(start_price1) * parseFloat(auto) /100;
        if(type === 'Reverse')
        {
            var auto1 = parseFloat(start_price1) * parseFloat(auto) /100;
            var price = parseFloat(start_price1) - parseFloat(auto1);
            if(parseFloat(start_price) <= parseFloat(price))
            {
                
                return true;
            }
            else
            {
                alert("Auction amount should be less then " + price.toFixed(2) );
                return false;
            }
            
        }
        if(type === 'Forward')
        {
            var auto1 = parseFloat(start_price1) * parseFloat(auto) /100;
            var price = parseFloat(start_price1) + parseFloat(auto1);
            if(parseFloat(start_price) >= parseFloat(price))
            {
                
                return true;
            }
            else
            {
                alert("Auction amount should be more then " + price.toFixed(2) );
                return false;
            }
        }
        
        return true;
    }
    
    function calculate_price(id)
    {
        
        id = id-1;
       
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        
        if (document.form.loading_per.length == null)
        {
            var loading_per = document.form.loading_per.value;
            var loading_val = document.form.loading_val.value;
            var start_price = document.form.start_price.value;
            var start_price1 = document.form.start_price1.value;
            var auto = document.form.auto.value;
            var type = document.form.type.value;

            if(type === 'Reverse')
            {
                document.form.start_price.value = (start_price - (start_price * auto /100)).toFixed(2);
                grand_total = parseFloat(start_price - (start_price * auto /100)) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
            }
            if(type === 'Forward')
            {
                document.form.start_price.value = (start_price + (start_price * auto /100)).toFixed(2);
                grand_total = parseFloat(start_price + (start_price * auto /100)) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
            }


            document.form.final_price.value = grand_total.toFixed(2);
        }
        while (i1 < document.form.loading_per.length) 
        {
            if(i1 === id)
            {
               
                
                var loading_per = document.form.loading_per[i1].value;
                var loading_val = document.form.loading_val[i1].value;
                var start_price = document.form.start_price[i1].value;
                var start_price1 = document.form.start_price1[i1].value;
                var auto = document.form.auto.value;
                var type = document.form.type.value;
                
                if(type === 'Reverse')
                {
                    document.form.start_price[i1].value = (start_price - (start_price * auto /100)).toFixed(2);
                    grand_total = parseFloat(start_price - (start_price * auto /100)) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
                }
                if(type === 'Forward')
                {
                    document.form.start_price[i1].value = (start_price + (start_price * auto /100)).toFixed(2);
                    grand_total = parseFloat(start_price + (start_price * auto /100)) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
                }


                document.form.final_price[i1].value = grand_total.toFixed(2);
                
            }
            i1++;
        }
        
        
        
    }
</script>
<script>
    function autoRefresh() {
        window.location = 'vendorAuction.htm?act=applyAuction&auction_no=${auction_no}';
    }
    setInterval('autoRefresh()', ${refresh_rate});
</script>

    <!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
    
    <link href="StorageYard/countdown/jquery.countdown.css" rel="stylesheet" type="text/css"/>


    <script type="text/javascript" src="StorageYard/countdown/jquery.countdown.js" ></script>
</html>

