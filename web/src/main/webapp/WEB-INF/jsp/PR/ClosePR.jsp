
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close PR</title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'specialCoupon.htm?act=editPunched&id=' + id;
        }
    </script>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form class="form-horizontal" role="form1" action="prMaster.htm?act=closePrSubmit" method="post" enctype="multipart/form-data" name='form' onsubmit='return saveSubmit11();'>

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Close PR</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                    <input type="hidden" name="id"  value="${id}" />

                    <hr>
                   <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <br>
                    
                    
                    
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Reference No</label>
                                        <p class="fw-600">${prMaster.prNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Item Category</label>
                                        <p class="fw-600">${prMaster.type}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>PR classification</label>
                                        <p class="fw-600">${prMaster.categoryId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${prMaster.title}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project ID</label>
                                        <p class="fw-600">${prMaster.projectId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Subject Description</label>
                                        <p class="fw-600">${prMaster.workDesc}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Plant</label>
                                        <p class="fw-600">${prMaster.plant}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Billing Location</label>
                                        <p class="fw-600">${prMaster.billingLocation}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Date</label>
                                        <p class="fw-600">${prMaster.announceDate}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By</label>
                                        <p class="fw-600">${prMaster.contactPerson}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created Contact Number</label>
                                        <p class="fw-600">${prMaster.prAdminContactNumber}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Name</label>
                                        <p class="fw-600">${prMaster.technicalContactName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Technical Person Contact No</label>
                                        <p class="fw-600">${prMaster.technicalContactNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>PR Estimate Cost With GST</label>
                                        <p class="fw-600">${prMaster.value}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Min Quotes Required</label>
                                        <p class="fw-600">${prMaster.quotes}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Business Type</label>
                                        <p class="fw-600">${prMaster.businessType}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Project Type</label>
                                        <p class="fw-600">${prMaster.projectType}</p>
                                    </div>
                                </div>
                               <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Name of Location Partner</label>
                                                <p class="fw-600">${prMaster.nameofLocationPartner}</p>
                                            </div>
                                        </div>
                                        <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                            <div class="form-group">
                                                <label>Mobile No Location Partner</label>
                                                <p class="fw-600">${prMaster.mobileNoLocationPartner}</p>
                                            </div>
                                        </div>      
                                    
                                    
                                    
                            </div>
                        </div>  
                    </div>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label>PO No <span style="color: red;font-size: 12px;">*</span></label>
                                    <input type="text" name="tender_no"    class="input-field"  maxlength="100"   required="required"  />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label>Vendor Details <span style="color: red;font-size: 12px;">*</span></label>
                                    <!--                                    <input type="text" name="vendor_details"    class="input-field"  maxlength="100"   required="required"  />-->

                                    <select class="select-input" id="vendor_details" name="vendor_details" required="required" 
                                            required="required">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="vendorInformation1" items="${vendorInformation1}">
                                            <option value="${vendorInformation1[4]}">${vendorInformation1[4]}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                            </div>
                            
                            <div class="col-lg-5 col-md-6">
                                <table id="policyTable"  style="width:100%;"  align="center">
                                    <tr style="text-align: center;">

                                        <th >Attachment<span style="color: red;font-size: 12px;">*</span></th>
                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                    </tr>
                                    <tr id="policyRow1" >
                                        <td >
                                            <input id="attachment1" name="attach" class="input-field" required="required" type="file"onchange="validateFileSize(this)">
                                            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                        </td> 

                                        <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                            <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                            </div>
                                        </td>

                                    </tr>
                                </table>
                            
                    </div>

                    <script>

                                function validateFileSize(input) {
                                const file = input.files[0];
                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                        var errorSpan = input.parentNode.querySelector("span");
                                        if (file && file.size > maxSize) {
                                errorSpan.style.display = 'block';
                                        input.value = '';
                                } else {
                                errorSpan.style.display = 'none';
                                }
                                }

                        var tempCount3 = 1;
                                $(function () {
                                $("#policyCloneid").on("click", function () {
                                tempCount3++;
                                        var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"

                                        + "<td><input type=\"file\" class=\"input-field\" name=\"attach\" id=\"attachment" + tempCount3 + "\" onchange=\"validateFileSize(this)\">"
                                        + "<span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"


                                        + "<td style='text-align: center' class='d-flex justify-content-center align-items-center'>"
                                        + "<div class='clone-action delete-parent-field' title='Remove' style='cursor:pointer;' "
                                        + "onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                                        + "</div></td>"

                                        + "</tr>";
                                        $("#policyTable").append(clone);
                                        document.getElementById('policyCount').value = tempCount3;
                                });
                                });
                                function removePolicy(policyDiv) {
                                try {
                                var element1 = document.getElementById(policyDiv);
                                        element1.parentNode.removeChild(element1);
                                        var policyCount = document.getElementById('policyTable').rows.length - 1;
                                        document.getElementById('policyCount').value = policyCount;
                                } catch (e) {
                                console.log(e);
                                }
                                }

                    </script>
                    
                           <div class="col-lg-12 col-md-6">
                                <div class="form-group comment-box">
                                    <label class="control-label">Remark<span class="text-danger">*</span></label>
                                    <textarea type="text" maxlength="250" class="textarea-field Remark" id="Remark" name="Remark"  required="true"></textarea>
                                </div>
                            </div>           
                        </div>
                    </div>
                  <%--<c:if test="${empty closePr.vendorDetail and empty closePr.tenderNo and empty closePr.attachment and empty closePr.remark}">--%>
                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn" style="width: 150px!important;" >Submit</button>
                        </div>
                    </div>
                    <%--</c:if>--%>
                    <!--<div class="tab-pane" id="tab_3"></div>-->
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
