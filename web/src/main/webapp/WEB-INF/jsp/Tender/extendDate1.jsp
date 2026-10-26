<%-- 
    Document   : extendDate1
    Created on : 29 Mar, 2024, 5:29:14 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extend Date</title>

        <script>
            function closewindow() {
                //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
                //      window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.location.reload();
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
                var t = document.getElementById("refNo").value;
                var t1 = document.getElementById("vendor_code").value;

                window.location = 'vendor.htm?act=vendorAttachDelete&id=' + id + '&refNo=' + t + '&vendor_code=' + t1;
            }
        </script>
        <style>
            #loading {
                position: fixed;
                display: block;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                text-align: center;
                opacity: 0.7;
                background-color: #fff;
                z-index: 99;
            }

            #loading-image {
                position: absolute;
                top: 50%;
                left: 50%;
                z-index: 100;
            }
        </style>
    </head>
    <div id="loading">
        <img id="loading-image" src="StorageYard/Images/ajax-loader.gif" alt="Loading..." />
    </div>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Extend Date</h1>

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
                                <form:form action="tenderMaster.htm?act=extendDate1Submit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="refNo" id="refNo" value="${refNo}">
                                    <input type="hidden" name="submitLastdate1" id="submitLastdate1" value="${submitLastdate}">
                                    <div class="form-group">

                                        <div class="col-sm-3">

                                            <%--<form:input id='datetimepicker2' path="submitLastdate" class="form-control"   maxlength="30" required="required"/>--%>
                                            <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->

                                            <div class='input-group date' id='datetimepicker1'>
                                                <!--<input path="submitLastdate" type="datetime-local" class="form-control" required="required">-->
                                                <input name="submitLastdate" class="form-control form_datetime" placeholder="dd-mm-yyyy --:--" value="${submitLastdate}" path="submitLastdate" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
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
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="$('#loading').show();"  title="" value="SUBMIT">
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
        $(window).load(function () {
            $('#loading').hide();
        });
        $("#Submit").click(function () {
            alert("");
            document.getElementById("loading").style.display = "none"
            //$('#loading').show();
        });
    </script>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>