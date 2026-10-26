<%-- 
    Document   : ReceiveAuctionView
    Created on : 6 Aug, 2022, 4:58:50 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Auction Detail</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
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

        
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Auction Detail</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Auction Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        
        
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div id="countdown">

                                </div>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
<!--                                            <div class="table">-->

                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    
                                                            <thead>
                                                                <tr>
                                                                    <th>Vendor Code</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Price </th>
                                                                    <th>Rank</th>
                                                                    <th>History</th>    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                               
                                                                    <c:forEach var="list" items="${auctionVendorBid}" varStatus="status">
                                                                        <tr>
                                                                            <td>${list[0]}</td>
                                                                            <td>${list[1]}</td>
                                                                            <td>${list[4]}</td>
                                                                            <td>${status.count} </td>
                                                                            <td>
                                                                                <a href="#" onclick="window.open('auctionMaster.htm?act=vendorAuctionHistoryView&vendorCode=${list[0]}&auction_no=${refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">History</a> 
                                                                                
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach>
                                                                    
                                                                    <c:forEach var="list" items="${auctionVendor}" varStatus="status">
                                                                        <c:set var = "i1" value="0"/>
                                                                        <c:forEach var="list1" items="${auctionVendorBid}" varStatus="status1">
                                                                            <c:if test="${list.vendorCode == list1[0]}">
                                                                                <c:set var = "i1" value="1"/>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                        <c:if test="${i1 == '0'}">
                                                                            <tr>
                                                                                <td>${list.vendorCode}</td>
                                                                                <td>${list.vendorName}</td>
                                                                                <td></td>
                                                                                <td> </td>
                                                                                <td>
                                                                                </td>
                                                                            </tr>
                                                                        </c:if>
                                                                        
                                                                        
                                                                    </c:forEach>
                                                                                                                           
                                                                 
                                                            </tbody>

                                                       
                                                </table>
<!--                                            </div>-->
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
    <link href="StorageYard/countdown/jquery.countdown.css" rel="stylesheet" type="text/css"/>


    <script type="text/javascript" src="StorageYard/countdown/jquery.countdown.js" ></script>
    <script>
    function autoRefresh() {
        window.location = window.location.href;
    }
    setInterval('autoRefresh()', 50000);
</script>
</html>



