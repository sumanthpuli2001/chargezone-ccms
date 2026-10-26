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
 //           window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
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
            
            
            function Documentdelete(id)
            {
                var t=document.getElementById("refNo").value;
                var t1=document.getElementById("vendor_code").value;
                
                window.location='tenderMaster.htm?act=vendorDocAttachByAdminServiceDelete&id='+id+'&refNo='+t+'&vendor_code='+t1;
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
                                <form:form action="tenderMaster.htm?act=vendorDocAttachByAdminServiceSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    <input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">
                                    <div class="form-group">
                                        
                                        <div class="col-sm-6">
                                            <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">General Terms & Conditions :</th>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        
                                                                <c:forEach var="list" items="${generalDoc}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${list.document}&RefNo=${refNo}">${list.document}</a>
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
                                        <div class="col-sm-6">
                                            <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Tender Additional Document :</th>
                                                            <input type="hidden" name="policyCount1" id="policyCount1" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="list" items="${additionalDoc}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${list.document}&RefNo=${refNo}">${list.document}</a>
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
                                        <div class="col-sm-6">
                                            <table id="policyTable2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Tender Technical Document :</th>
                                                            <input type="hidden" name="policyCount2" id="policyCount2" value="1"/>
                                                        </tr>
                                                        
                                                                <c:forEach var="list" items="${technicalDoc}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${list.document}&RefNo=${refNo}">${list.document}</a>
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
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                
                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Select</th>
                                                                    <th>Code</th>
                                                                    <th>Name</th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                <c:forEach var="list" items="${vendorDetails}" varStatus="status">
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <c:if test="${list.vendorCode eq vendor_code}">
                                                                                <input type="checkbox" name="checkId" value="${list.vendorCode}" checked id="deptCheckId" >
                                                                            </c:if>
                                                                            <c:if test="${list.vendorCode ne vendor_code}">
                                                                                <input type="checkbox" name="checkId" value="${list.vendorCode}" id="deptCheckId" >
                                                                            </c:if>
                                                                            
                                                                        </td>
                                                                        <td>${list.vendorCode}</td>
                                                                        <td>${list.vendorName}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                            
                                                    
                                                </table>

                                                
                                            </div>
                                        </div>

                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="SUBMIT">
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