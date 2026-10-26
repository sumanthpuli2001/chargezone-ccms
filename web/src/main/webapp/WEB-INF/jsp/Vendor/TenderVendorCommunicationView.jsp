<%-- 
    Document   : TenderVendorCommunication
    Created on : 6 Jun, 2022, 11:41:01 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Communication</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
  //          window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
		window.close();
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
            
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Communication</h1>
            
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
                                <form:form action="vendor.htm?act=tenderVendorCommunicationReply" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    <input type="hidden" name="id" id="id" value="${id}">
                                    <input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Subject :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="technicalfile" name="subject" value="${subject}">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Message :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="technicalfile" name="msg" value="${msg}">
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty commMasterAttachment}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr.No.</th>
                                                                    <th>Subject</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="commMasterAttachment" items="${commMasterAttachment}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                         <td><a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${commMasterAttachment.attachment}&RefNo=${tender_no}">${commMasterAttachment.attachment}</a>
                                                                             
                                                                            </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="Reply">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
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
    <script>
        function Validate() {
            var pass = $('#password').val();
            var pass1 = $('#password1').val();
            if (pass != pass1) {
                alert('Password not match');
                return false;
            }
            return true;
        }
    </script>

</html>
