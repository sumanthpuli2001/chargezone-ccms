<%-- 
    Document   : TempVendor
    Created on : 17 Oct, 2023, 4:09:22 PM
    Author     : Seth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title>Add Temporary Vendor</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
    </script>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
         
          <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Add Temporary Vendor</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>


        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="vendorInformation.htm?act=submitTempVendor" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <input type="hidden" name="vendor_code1" value="">


                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-3">
                                                                                                <label class="control-label">Vendor Code </label>
                                                                                            </div>
                                                                                            <div class="col-sm-3">
                                                                                                <input type="text" name="vendor_code" value="${vendorMaster.vendorRegNo}" class="form-control"/>
                                                                                            </div>
                                            
                                                                                        </div>-->


                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Name <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="vendor_name" value="${vendorMaster.vendorName}" class="form-control"   maxlength="100" required="required"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Address <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <textarea type="text" name="vendor_address" value="${vendorMaster.vendorAddressLine1}" class="form-control"   maxlength="100" required="required"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Email Id <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="vendor_email_id" value="${vendorMaster.vendorEmailID}" class="form-control"   maxlength="100" required="required"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor CC </label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="vendor_cc" value="${vendorMaster.cc}" class="form-control"   maxlength="200" />
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Mobile No. <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <input type="text" name="vendor_mobile_no" value="${vendorMaster.vendorMobNo}" class="form-control"   maxlength="100" required="required"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Status <span style="color: red;font-size: 12px;">*</span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <label class="control-label"> Active </label> <input type="radio" name="vendor_status" value="1" class="form-control" required="required"/>
                                                    &nbsp;&nbsp;
                                                    <label class="control-label"> InActive </label><input type="radio" name="vendor_status" value="0" class="form-control" required="required"/>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-3">
                                                    <label class="control-label">Vendor Remark <span style="color: red;font-size: 12px;"></span></label>
                                                </div>
                                                <div class="col-sm-3">
                                                    <textarea type="text" name="vendor_remark" value="${vendorMaster.remark}" class="form-control" row="8" ></textarea>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SUBMIT" >
                                                </div>
                                            </div>


                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->

                            </div><!-- /.box-body -->

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>

    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });</script>

    <script type="text/javascript">
        function printDiv(divName) {
            var printContents = document.getElementById(divName).innerHTML;
            var originalContents = document.body.innerHTML;

            document.body.innerHTML = printContents;

            window.print();

            document.body.innerHTML = originalContents;
        }
    </script>
    <script type="text/javascript">
        function ExportToExcel() {
            var htmltable = document.getElementById('tableid');
            var html = htmltable.outerHTML;
            window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>