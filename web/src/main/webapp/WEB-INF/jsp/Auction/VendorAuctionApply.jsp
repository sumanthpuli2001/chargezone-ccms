<%-- 
    Document   : VendorAuctionApply
    Created on : 30 Jul, 2022, 10:36:07 AM
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





                                
                                    
                                <form:form action="vendorAuction.htm?act=vendorAuctionApplySubmit" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                        name="form"   class="form-horizontal" role="form">
                                    
                                    <hr>
                                    <input type="hidden" name="auction_no" value="${auction_no}">
                                    <input type="hidden" name="difference_In_Time" value="${difference_In_Time}">
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Type :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="type" value="${type}" class="form-control" readonly="true"/>
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
                                    
                                    <div class="form-group">
                                        <c:if test="${auctionMaster.biddingDisplay == 'Rank' || auctionMaster.biddingDisplay == 'Both'}">
                                            <div class="col-sm-3">
                                                <label class="control-label">Rank :</label>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="text" name="rank" class="form-control" value="${Rank}"   readonly="true">
                                            </div>
                                        </c:if>
                                        
                                        
                                        <c:if test="${auctionMaster.biddingDisplay != 'Rank'}">
                                            <div class="col-sm-2">
                                                <label class="control-label">
                                                    <c:if test="${auctionMaster.type == 'Reverse'}">
                                                        L1 Price :
                                                    </c:if>
                                                    <c:if test="${auctionMaster.type != 'Reverse'}">
                                                        H1 Price :
                                                    </c:if>
                                                </label>
                                            </div>
                                            <div class="col-sm-3">
                                                <c:if test="${auctionMaster.type == 'Reverse'}">
                                                    <input name="l1_price" type="text" class="form-control" value="${l1_price}"   readonly="true">
                                                </c:if>
                                                <c:if test="${auctionMaster.type != 'Reverse'}">
                                                    <input name="h1_price" type="text" class="form-control" value="${h1_price}"   readonly="true">
                                                </c:if>

                                            </div>
                                        </c:if>
                                        
                                        
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Loading Factor (%) :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="loading_per" class="form-control" value="${loading_per}"   readonly="true">
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Loading Factor (Value) :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="loading_val" class="form-control" value="${loading_val}"   readonly="true">
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Final Price :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="final_price"  class="form-control" value="${final_price}"   readonly="true">
                                            
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Vendor Price :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="hidden" name="auto" value="${auctionMaster.autoDecIncAmount}">
                                            <input type="hidden" name="start_price1" value="${start_price}">
                                            <input type="text" name="start_price" class="form-control" value="${start_price}"  required="true" onKeyPress="return isNumberKey(event)" onChange="return calculate_price2()">
                                        </div>
                                        <div class="col-sm-1">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" title="" value="Auto" onclick="calculate_price()">
                                        </div>
                                    </div>    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Submit" onclick="return calculate_price1()">
                                            <input type="button" class="btn btn-danger" style="width: 100px;"  title="" value="CANCEL" onclick="window.location='vendorAuction.htm?act=liveVendorAuction'">
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
    
    function calculate_price1()
    {
        var auto = document.form.auto.value;
        var type = document.form.type.value;
        var start_price = document.form.start_price.value;
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
    
    function calculate_price()
    {
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
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
    
    function calculate_price2()
    {
        var i1 = 0;
        var j1 = 1;
	var k1  = 0;
        var total = 0;
        var grand_total = 0;
        var loading_per = document.form.loading_per.value;
        var loading_val = document.form.loading_val.value;
        var start_price = document.form.start_price.value;
        var start_price1 = document.form.start_price1.value;
        var auto = document.form.auto.value;
        var type = document.form.type.value;
        
        if(type === 'Reverse')
        {
         //   document.form.start_price.value = (start_price).toFixed(2);
            grand_total = parseFloat(start_price) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
        }
        if(type === 'Forward')
        {
         //   document.form.start_price.value = (start_price).toFixed(2);
            grand_total = parseFloat(start_price) + parseFloat(loading_val) + parseFloat(loading_per * start_price / 100);
        }
        
        
        document.form.final_price.value = grand_total.toFixed(2);
        
        
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

