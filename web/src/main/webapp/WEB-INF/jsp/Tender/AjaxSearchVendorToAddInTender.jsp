<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<!-- Expose dynamic input values for Javascript retrieval -->
<input type="hidden" id="ref_no" value="${ref_no}">
<input type="hidden" id="tender_no" value="${ref_no}">

<script type="text/javascript">
    // Exposes the group categories map to global scope
    var groupHierarchy = ${not empty groupHierarchyJson ? groupHierarchyJson : '{}'};
</script>

<div>
    <div class="rounded-4 mt-4">
        <div class="row mb-3">
            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Code :</label>
                    <input type="text" class="input-field" id="vendor_code" name="vendor_code" >
                </div>
            </div>

            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Name :</label>
                    <input type="text" class="input-field" id="vendor_name" name="vendor_name" >
                </div>
            </div>

            <div class="col-lg-4 col-md-6">
                <div class="form-group">
                    <label class="control-label">Vendor Remark :</label>
                    <input type="text" id="vendor_remark" name="vendor_remark" class="input-field" maxlength="1000" />
                </div>
            </div>
        </div>
    </div>
        
    <div class="table_wrapper mt-3  ">
        <h6 class="fw-600">Search Vendor</h6>
        <hr>
        <div class="col-md-12 p-0">
            <table id="SearchVendorTable" class="table table-striped bg-white" style="width:100%">
                <c:choose>
                    <c:when test="${empty vendorMaster}"></c:when>
                    <c:otherwise>
                        <thead>
                            <tr>
                                <th data-dt-order="disable" class="text-center">Select</th>
                                <th>Vendor Code</th>
                                <th>Vendor Name</th>
                                <th>Address</th>
                                <th>Email Id</th>
                                <th>Mobile No</th>
                            </tr>
                        </thead>
                        <c:set var="count" value="0" scope="page" />
                        <tbody>
                            <c:forEach var="vendor" items="${vendorMaster}" varStatus="status">
                                <tr>
                                    <!-- Added class="vendorCheckbox" so the parent page JS picks it up -->
                                    <td class="text-center">
                                        <input type="checkbox" value="${vendor[0]}" name="checkedId" class="vendorCheckbox">
                                    </td>
                                    <td>${vendor[0]}</td>
                                    <td>${vendor[1]}</td>
                                    <td>${vendor[2]}</td>
                                    <td>${vendor[3]}</td>
                                    <td>${vendor[4]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </c:otherwise>
                </c:choose>
            </table>
        </div>
    </div>
        
    <div class="mt-3 table-responsive mt-3">        
        <h6 class="fw-600">Active Vendor</h6>
        <hr>
        <table id="AjaxVendorAddTable" class="table table-striped bg-white" style="width:100%">
            <thead>
                <tr>
                    <th data-dt-order="disable">
                        <input type="checkbox" id="selectAllVendor">
                    </th>
                    <th>SAP Code</th>
                    <th>Company Name</th>
                    <th>Email Id</th>
                    <th>Contact No</th>
                    <th>Group Name</th>
                    <th>Group Category</th>
                    <th>Group Sub Category</th>
                    <th>Country</th>
                    <th>State</th>
                    <th>City</th>
                    <th>GST No.</th>
                    <th>PAN No.</th>
                    <th>Risk Category</th>
                    <th>Vendor Invite Source</th>
                    <th>Invited By</th>
                    <th>Activated Date</th>
                </tr>

                <tr data-dt-order="disable">
                    <th></th>
                    <th>
                        <input type="text" id="sapCodeFilter" class="input-field" placeholder="Search SAP">
                    </th>
                    <th>
                        <input type="text" id="companyNameFilter" class="input-field" placeholder="Search Company">
                    </th>
                    <th>
                        <input type="text" id="vendorEmailIdFilter" class="input-field" placeholder="Search Email">
                    </th>
                    <th>
                        <input type="text" id="contactNoFilter" class="input-field" placeholder="Search Contact">
                    </th>
                    <th>
                        <input type="text" id="groupNameFilter" class="input-field" placeholder="Search Group Name">                        
                    </th>
                    <th>
                        <input type="text" id="groupCategoryFilter" class="input-field" placeholder="Search Group Category Name">                        
                    </th>
                    <th>
                        <input type="text" id="groupSubCategoryFilter" class="input-field" placeholder="Search Group Sub Category Name">                                           
                    </th>
                    <th>
                        <input type="text" id="country" class="input-field" placeholder="Search Country">                        
                    </th>
                    <th>
                        <input type="text" id="state" class="input-field" placeholder="Search State">                        
                    </th>
                    <th>
                        <input type="text" id="cityFilter" class="input-field" placeholder="Search City">
                    </th>
                    <th>
                        <input type="text" id="gstNoFilter" class="input-field" placeholder="Search GST">
                    </th>
                    <th>
                        <input type="text" id="panNoFilter" class="input-field" placeholder="Search PAN">
                    </th>
                    <th>
                        <input type="text" id="riskCategoryFilter" class="input-field" placeholder="Search Risk">
                    </th>
                    <th>
                        <input type="text" id="vendorInviteSourceFilter" class="input-field" placeholder="Search Source">
                    </th>
                    <th>
                        <input type="text" id="invitedByFilter" class="input-field" placeholder="Search Invited By">
                    </th>
                    <th>
                        <input type="text" id="activatedDateFilter" class="input-field" placeholder="Search Date">
                    </th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <div class="d-flex align-items-center justify-content-between mt-4 mb-2">
        <h6 class="fw-600">Added Vendor</h6>
        
        <button type="button" id="deleteSelectedVendor" class="btn theme-btn delete-btn d-none">
            <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)" alt="Delete Icon">
            Delete Selected
        </button>
    </div>
    <hr>

    <div class="col-md-12 p-0">
        <div class="table_wrapper">
            <table id="AjaxVendorTable" class="table table-striped bg-white" align="Center">
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
