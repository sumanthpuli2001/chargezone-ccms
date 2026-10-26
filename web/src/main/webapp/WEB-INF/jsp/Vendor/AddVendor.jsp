<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Vendor</title>
        <script>
            function viewClick(id) {
                window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
            }
        </script>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                </c:if>

                <form:form class="form-horizontal" role="form1" action="vendorInformation.htm?act=submitNewVendor" method="post" name='form' onsubmit='return saveSubmit11();'>
                    <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Add Vendor</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a class="btn theme-btn light-btn mr-3"  onclick="history.back();"  >Back</a>
                            <button type="submit" id="submit1" title="submit1" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                    <hr>
      
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span>  Indicate That Attachment Are Mandatory
                        </div>
                    </div>
                    <div class="rounded-4 mt-4">
                        <div class="row">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">  Vendor Code <span style="color:red;font-size:12px;">*</span>  </label>
                                    <input type="text" name="vendor_code" value="${vendorMaster.vendorRegNo}" class="input-field" required />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">  Vendor Name <span style="color:red;font-size:12px;">*</span> </label>
                                    <input type="text" name="vendor_name" value="${vendorMaster.vendorName}" class="input-field" maxlength="100" required />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">  Vendor Address <span style="color:red;font-size:12px;">*</span> </label>
                                    <textarea name="vendor_address" rows="1" class="input-field"  maxlength="100" required>${vendorMaster.vendorAddressLine1}</textarea>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label"> Vendor Email Id <span style="color:red;font-size:12px;">*</span> </label>
                                    <input type="email"   name="vendor_email_id"    placeholder="Eg: abc@gmail.com"  value="${vendorMaster.vendorEmailID}"   class="input-field" maxlength="100"  required />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Vendor CC</label>
                                    <input type="text" name="vendor_cc"  value="${vendorMaster.cc}"  class="input-field"   maxlength="200" />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">  Vendor Mobile No. <span style="color:red;font-size:12px;">*</span> </label>
                                    <input type="text"  name="vendor_mobile_no"  placeholder="Eg: +918765432198"    value="${vendorMaster.vendorMobNo}"  class="input-field"  pattern="[+][0-9]{1,4}[0-9]{6,}"  required />
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Vendor Remark</label>
                                    <textarea name="vendor_remark" rows="1" class="input-field">${vendorMaster.remark}</textarea>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="control-label"> Vendor Status <span style="color:red;font-size:12px;">*</span>  </label>
                                    <select id="vendor_status" name="vendor_status"  class="selectpicker select-input" required>
                                        <option value="">Select Status</option>
                                        <option value="1" ${vendorMaster.status == 1 ? 'selected' : ''}>Active</option>
                                        <option value="0" ${vendorMaster.status == 0 ? 'selected' : ''}>Inactive</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                                    <div class="tab-pane" id="tab_3"></div>
                                    <div class="cta d-flex justify-content-center align-items-center">
                                        <button type="submit" id="submit1" title="submit1" class="btn theme-btn">  Submit </button>
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

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>