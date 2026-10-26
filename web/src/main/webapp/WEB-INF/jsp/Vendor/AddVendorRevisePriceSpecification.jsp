<%-- 
    Document   : AddVendorRevisePriceSpecification
    Created on : 16 Jan, 2024, 12:19:26 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attach Document</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
           window.opener.showuser6('1');
         //   window.opener.showtext5('1');
		window.close();
	}
</script>

<script language="javascript" type="text/javascript">
    
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
            
            
            function Documentdelete(id)
            {
                var t=document.getElementById("ref_no").value;
                window.location='vendor.htm?act=vendorRevisePriceSpecificationDelete&id='+id+'&ref_no='+t;
            }
</script>

    </head>
    
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Attach Document</h1>
            
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
                                <form:form action="vendor.htm?act=addVendorRevisePriceSpecificationSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                        name="form"   class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <div class="form-group">
                                        
                                        <div class="col-sm-6">
                                            <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Vendor Technical Specification :</th>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        
                                                                <c:forEach var="list" items="${generalDocument}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list.attachment}&RefNo=${list.refNo}&vendor_code=${vendor_code}">${list.attachment}</a>
                                                                            
                                                                        </td>
                                                                        <td style="text-align: center">
                                                                            <span style='margin-top: 5px;'>
                                                                                <input type="button" value="-" onclick="Documentdelete(${list.id});"/>
                                                                            </span>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                    
                                                        
                                                        <tr>
                                                            <td style="text-align: center">
                                                                <input type="file" class="form-control" id="generalfile" name="generalfile" accept="" onchange="form.submit()">
                                                            </td>
                                                            <td style="text-align: center">
                                                                <span style='margin-top: 5px;'>
                                                                    
                                                                </span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                           <!-- <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="SUBMIT"> -->
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
     
    

</html>



