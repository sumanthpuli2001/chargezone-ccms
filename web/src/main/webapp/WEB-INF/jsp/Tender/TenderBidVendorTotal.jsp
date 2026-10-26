<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Information</title>

        <script>
            function closewindow() {
                //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
                window.opener.document.getElementById('requireDocument3').innerHTML = '${technicalfile}';
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
                var t = document.getElementById("refNo").value;
                var t1 = document.getElementById("vendor_code").value;

                window.location = 'tenderMaster.htm?act=vendorDocAttachByAdminDelete&id=' + id + '&refNo=' + t + '&vendor_code=' + t1;
            }
        </script>
        <style type="text/css">
            h1{
                font-weight: bold;
            }
            h5{
                font-weight: bold;
            }
        </style>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>VENDER INFORMATION</h1>

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">

                                <form:form action="tenderMaster.htm?act=vendorDocAttachByAdminSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    <input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">

                                            <h5>Bid Vendor :</h5>
                                            <div style="overflow-x: auto; overflow-y: auto; border: 1px solid #ddd; margin: auto; width: 100%;">
                                                <table class="table table-bordered" style="width: 100%;" align="center">   
                                                    <thead>
                                                        <tr>
                                                            <th>Vendor Code</th>
                                                            <th>Vendor Name</th>
                                                            <th>Email ID</th>
                                                            <th>Mobile No.</th>
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <c:forEach var="list2" items="${list2}" varStatus="status">
                                                            <tr>
                                                                <td>${list2[0]}</td>
                                                                <td>${list2[1]}</td>
                                                                <td>${list2[3]}</td>
                                                                <td>${list2[2]}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <h5>Regret Vendor :</h5>

                                            <div style="overflow-x: auto;overflow-y: auto; border: 1px solid #ddd; margin: auto; width: 100%;">
                                                <table class="table table-bordered" style="width: 100%;" align="center">   
                                                    <thead>
                                                        <tr>
                                                            <th>Vendor Code</th>
                                                            <th>Name</th>
                                                            <th>Email ID</th>
                                                            <th>Mobile No.</th>
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <c:forEach var="list3" items="${list3}" varStatus="status">
                                                            <tr>
                                                                <td>${list3[0]}</td>
                                                                <td>${list3[1]}</td>
                                                                <td>${list3[3]}</td>
                                                                <td>${list3[2]}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <h5>Remaining Vendor :</h5>
                                            <div style="overflow-x: auto; overflow-y: auto; border: 1px solid #ddd; margin: auto;">
                                                <table class="table table-bordered" style="" align="center">
                                                    <thead>
                                                        <tr>
                                                            <th>Vendor Code</th>
                                                            <th>Name</th>
                                                            <th>Email ID</th>
                                                            <th>Mobile No.</th>
                                                        </tr>
                                                    </thead>

                                                    <tbody>
                                                        <c:forEach var="list1" items="${list1}" varStatus="status">
                                                            <c:set var="i1" value="0"/>
                                                            <c:forEach var="list2" items="${list2}" varStatus="status1">
                                                                <c:if test="${list1.vendorCode == list2[0]}">
                                                                    <c:set var="i1" value="1"/>
                                                                </c:if>
                                                            </c:forEach>
                                                            <c:forEach var="list3" items="${list3}" varStatus="status1">
                                                                <c:if test="${list1.vendorCode == list3[0]}">
                                                                    <c:set var="i1" value="1"/>
                                                                </c:if>
                                                            </c:forEach>
                                                            <c:if test="${i1 == 0}">
                                                                <tr>
                                                                    <td>${list1.vendorCode}</td>
                                                                    <td>${list1.vendorName}</td>
                                                                    <td>${list1.emailId}</td>
                                                                    <td>${list1.mobileNo}</td>
                                                                </tr>
                                                            </c:if>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>

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