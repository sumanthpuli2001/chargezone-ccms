<%-- 
    Document   : CreateDepartment
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor Information</title>
    </head>
    <body>
        <script>
            function viewClick(id) {
                window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
            }
        </script>


    
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendorInformation.htm?act=viewVendorSubmit" commandName="designationMaster" method="post">
                    <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
                    <input type="hidden" name="vendor_code" value="${vendorMaster.vendorRegNo}">                    
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Information</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a class="btn theme-btn light-btn mr-3"  onclick="history.back();"  >Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                    <hr>
      
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> Ensure your file size is within <strong>5MB</strong> for a smooth upload. <br>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div>                
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Vendor Code</label>
                                    <input type="text" name="vendor_code"  value="${vendorMaster.vendorRegNo}"  class="input-field" maxlength="100"  readonly />
                                </div>
                            </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label"> Vendor Name <span style="color:red;font-size:12px;">*</span>  </label>
                                            <input type="text" name="vendor_name" value="${vendorMaster.vendorName}" class="input-field" maxlength="100" required />
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label"> Vendor Email Id <span style="color:red;font-size:12px;">*</span> </label>
                                            <input type="email" name="vendor_email_id" value="${vendorMaster.vendorEmailID}" class="input-field" maxlength="100" required />
                                        </div>
                                    </div>

                                    <div class="col-lg-8">
                                        <div class="form-group">
                                            <label class="control-label"> Vendor Address <span style="color:red;font-size:12px;">*</span>  </label>
                                            <input type="text" name="vendor_address"  value="${vendorMaster.vendorAddressLine1}"  class="input-field" maxlength="200" required />
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label">Vendor CC</label>
                                            <input type="text" name="vendor_cc" value="${vendorMaster.vendorcc}" class="input-field" maxlength="200" />
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label"> Vendor Mobile No. <span style="color:red;font-size:12px;">*</span> </label>
                                            <input type="text" name="vendor_mobile_no" value="${vendorMaster.vendorMobNo}"   class="input-field"   maxlength="15" required />
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label">  Vendor Status <span style="color:red;font-size:12px;">*</span></label>
                                            <select id="vendor_status" name="vendor_status" class="selectpicker select-input" required>
                                                <option value="">Select Status</option>
                                                <option value="1" <c:if test="${vendorMaster.flag == 1}">selected</c:if>> Active </option>
                                                <option value="0" <c:if test="${vendorMaster.flag == 0}">selected</c:if>> InActive </option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-4 col-md-6">
                                        <div class="form-group">
                                            <label class="control-label"> Vendor Remark <span style="color:red;font-size:12px;">*</span>  </label>
                                            <input type="text" name="vendor_remark" value="${vendorMaster.vendorRemark}"  class="input-field"  maxlength="1000"  required />
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="cta d-flex justify-content-center align-items-center">
                                <button type="submit" class="btn theme-btn">Submit</button>
                            </div>

                </form:form>
            </section>
        </main>
    </body>
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
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
