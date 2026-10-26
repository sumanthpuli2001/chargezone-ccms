<%-- 
    Document   : AjaxSearchVendorToAddInPr
    Created on : Jul 14, 2025, 4:13:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<div>
    <h6 class="fw-600">Vendor Information</h6>
    <c:if test="${!empty successMessage}">
        <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
    </c:if>
    <c:if test="${!empty failureMessage}">
        <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
    </c:if>

    <div class="rounded-4 mt-4">
        <div class="row mb-3">
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Code :</label>
                    <input type="text" class="input-field" id="vendor_code" name="vendor_code"  >
                </div>
            </div>

            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Name :</label>
                    <input type="text" class="input-field" id="vendor_name" name="vendor_name"  >
                </div>
            </div>

            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Remark :</label>
                    <input type="text" id="vendor_remark" name="vendor_remark" class="input-field"   maxlength="1000" />
                </div>
            </div>
        </div>
    </div>

    <div class="table_wrapper">
        <div class="col-md-12 p-0">
            <table id="AjaxVendorAddTable" class="table table-striped" style="" align="Center"  >
                <c:choose>
                    <c:when test="${empty vendorMaster}"></c:when>
                    <c:otherwise>
                        <thead>
                            <tr>
                                <th  data-dt-order="disable" class="text-center">Select</th>
                                <th>Vendor Code</th>
                                <th>Vendor Name</th>
                                <th>Address</th>
                                <th>Email Id</th>
                                <th>Mobile No</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="vendorMaster" items="${vendorMaster}" varStatus="status">
                                <tr>
                                    <td class="text-center" ><input type="checkbox" value="${vendorMaster.vendorRegNo}" name="checkedId"></td>
                                    <td>${vendorMaster.vendorRegNo}</td>
                                    <td>${vendorMaster.vendorName}</td>
                                    <td>${vendorMaster.vendorAddressLine1}</td>
                                    <td>${vendorMaster.vendorEmailID}</td>
                                    <td>${vendorMaster.vendorMobNo}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>

    <div class="d-flex align-items-center justify-content-between mt-2 mb-2">
        <h6 class="fw-600">Added Vendor</h6>

        <button type="button" id="deleteSelectedVendor" class="btn theme-btn delete-btn d-none">
            <img src="StorageYard/assets/images/delete-icon.svg"
                 class="icon" onload="SVGInject(this)"
                 alt="Delete Icon">
            Delete Selected
        </button>
    </div>

    <div class="col-md-12 p-0">
        <div class="table_wrapper">
            <table id="AjaxVendorTable" class="table table-striped bg-white" align="Center"  >
                <c:choose>
                    <c:when test="${empty tenderVendor1}"></c:when>
                    <c:otherwise>
                        <thead>
                            <tr>
                                <th data-dt-order="disable" class="text-center"><input type="checkbox" name="select_all_rows" id="select_all"></th>
                                <th>Vendor Code</th>
                                <th>Vendor Name</th>
                                <th>Address</th>
                                <th>Email Id</th>
                                <th>Mobile No</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="tenderVendor1" items="${tenderVendor1}" varStatus="status">                               
                                <tr>
                                    <td class="text-center">
                                        <input type="checkbox" value="${tenderVendor1.id}" id="checkedId" name="select_current_row" class="rowCheckbox" >
                                    </td>
                                    <td>${tenderVendor1.vendorCode}</td>
                                    <td>${tenderVendor1.vendorName}</td>
                                    <td>${tenderVendor1.address}</td>
                                    <td>${tenderVendor1.emailId}</td>
                                    <td>${tenderVendor1.mobileNo}</td>
                                </tr>                                    
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="7">
                                    <span style="display: inline-block; width: 15px; height: 15px; background-color: #ffcdd2; border: 1px solid #a9a9a9; margin-right: 5px;"></span>
                                    Deleted
                                    &nbsp;&nbsp;&nbsp;
                                    <span style="display: inline-block; width: 15px; height: 15px; background-color: #accdf8; border: 1px solid #a9a9a9; margin-right: 5px;"></span>
                                    Added
                                    &nbsp;&nbsp;&nbsp;
                                </td>
                            </tr>
                        </tfoot>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
</div>

<link rel="stylesheet" href="StorageYard/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="StorageYard/assets/css/bootstrap-select.min.css">
<link rel="stylesheet" href="StorageYard/assets/css/all.min.css">
<link rel="stylesheet" href="StorageYard/assets/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="StorageYard/assets/css/buttons.bootstrap4.min.css">
<link href="StorageYard/assets/css/bootoast.min.css" rel="stylesheet" type="text/css"/>
<link href="StorageYard/assets/css/flatpickr.min.css" rel="stylesheet" type="text/css"/>
<!-- Theme CSS -->
<link rel="stylesheet" href="StorageYard/assets/css/global.min.css">
<link rel="stylesheet" href="StorageYard/assets/css/style.min.css">
