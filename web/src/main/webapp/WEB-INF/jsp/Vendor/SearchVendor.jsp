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
        <title> Vendor List</title>

        <link rel="stylesheet" href="StorageYard/assets/css/style.min.css">

    </head>
    <body>
        <script>
            function cancelClick() {

                window.location = 'employeeMaster.htm?act=showDesignationList';
            }
        </script>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0"> Upload Vendor Excel File</h5>
                    </div>
                    <form:form id="vendorForm" action="vendorInformation.htm?act=searchVendor1" commandName="search" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="val" id="val" value="${sessionScope.valueOfAll}"/>
                        <div class="cta d-flex align-items-center">


                            <%--<a onclick="history.back();" class="btn theme-btn light-btn mr-3">Cancel</a>--%>
                            <button  type="submit" class="btn theme-btn">Search</button>
                            <a onclick="window.location = 'vendorInformation.htm?act=addVendor'" class="btn theme-btn flex ml-3">
                                <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                Add New
                            </a>
                        </div>
                    </div>
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger">${errorMessage}</div>
                    </c:if>

                    <c:if test="${not empty successMessage}">
                        <div class="alert alert-success">${successMessage}</div>
                    </c:if>
                    <div class="rounded-4 mt-4">

                        <div class="content-top mb-0 d-flex align-items-center justify-content-between">


                            <div class="cta upload-file-cta d-flex align-items-center"></div>
                        </div>

                        <!-- File Upload Block -->
                        <div class="file-upload-base file-upload-area d-flex flex-column align-items-center justify-content-center rounded-3 my-4"
                             id="file-upload-area">
                            <div class="upload-icon pb-3">
                                <img src="StorageYard/assets/images/upload-icon.svg" class="mx-auto" onload="SVGInject(this)"
                                     alt="Upload Icon">
                            </div>
                            <p class="upload-text mb-0 fs-14"> Drag and Drop Attendance here <br>
                                or <span class="gradient-text underline-text" id="browseFile">Browse file</span>
                            </p>
                            <br>
                            <a class="fs-14" href="StorageYard/Vendor File.xlsx">Eg. Vendor File</a>
                            <input type="file" id="fileInput" name="vendorfile" hidden accept=".csv,.xls,.xlsx" />
                        </div>
                        <!-- File Upload Block -->


                        <!-- File Details Block -->
                        <div class="file-upload-base uploaded-file d-none flex-column align-items-center justify-content-center rounded-3 my-4"
                             id="uploaded-file-area">
                            <div class="upload-icon pb-3">
                                <img src="StorageYard/assets/images/xls-file-icon.svg" class="mx-auto" onload="SVGInject(this)"
                                     alt="Upload Icon">
                            </div>
                            <p class="uploaded-file-name mb-2 fw-500"></p>
                            <a class="fs-14 d-flex align-items-sm-start" id="resetFile" href="javascript:void(0)">
                                <img src="StorageYard/assets/images/delete-icon.svg" class="mr-2" onload="SVGInject(this)"
                                     alt="Delete Icon">
                                Remove File
                            </a>
                        </div>
                       
                        


                        <div class="col-12">
                           
                            


                            <h4>Vendor List</h4>

                            <div class="row mb-3">
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">Vendor Code</label>
                                        <input type="text" name="vendor_code" class="input-field" placeholder="Enter Vendor Code" >
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">Vendor Name</label>
                                        <input type="text" name="vendor_name" class="input-field" placeholder="Enter Vendor Name" >
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label class="label">Vendor Remark</label>
                                        <input type="text" name="vendor_remark" class="input-field" placeholder="Enter Vendor Remark" >
                                    </div>
                                </div>
                            </div>
                        </form:form>
                        <div class="row my-3">

                        </div>
                        <!-- Vendor Table Display (Below Form) -->

                        <div class="bg-white card-full-h">
                            <c:choose>
                                <c:when test="${empty vendorMaster}">
                                    <div class="alert alert-info text-center">
                                        There is no record to display.
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="row my-3">
                                        <div class="col-md-1 pr-md-1">
                                            <select id="entriesPerPage" class="select-input">
                                                <option value="10">10</option>
                                                <option value="25">25</option>
                                                <option value="50">50</option>
                                                <option value="-1">All</option>
                                            </select>
                                        </div>
                                        <div class="col-md-8 px-md-1">
                                            <input id="searchBox" type="text" class="input-field" placeholder="Search here...">
                                        </div>
                                        <div class="col-md-3 pl-md-1">
                                            <select id="typeFilter" class="select-input" title="Select Vendor Type" multiple>
                                                <option value="Permanent Vendor">Permenant</option>
                                                <option value="Temporary Vendor">Temporary</option>
                                            </select>
                                        </div>
                                    </div>

                                    <table id="searchvendor" class="table table-striped" style="width:100%">
                                        <thead class="text-center">
                                            <tr>
                                                <th>Vendor Code</th>
                                                <th>Vendor Name</th>
                                                <th>Email Id</th>
                                                <th>Mobile No.</th>
                                                <th>Vendor Type</th>
                                                <th>Vendor Status</th>
                                                <th>View / Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="vendorMaster" items="${vendorMaster}" varStatus="status">
                                                <tr>
                                                    <td>${vendorMaster.vendorRegNo}</td>
                                                    <td>${vendorMaster.vendorName}</td>
                                                    <td>${vendorMaster.vendorEmailID}</td>
                                                    <td>${vendorMaster.vendorMobNo}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${vendorMaster.vendorTypeId == 1}">Temporary Vendor</c:when>
                                                            <c:otherwise>Permanent Vendor</c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="${vendorMaster.flag == 1 ? 'text-success fw-500' : 'text-danger fw-500'}">
                                                        ${vendorMaster.flag == 1 ? 'Active' : 'Inactive'}
                                                    </td>



                                                    <td class="text-center">
                                                        <div class="d-flex align-items-center justify-content-center">
                                                            <a class="d-flex text-info p-1 mx-1 action-link "
                                                               href="vendorInformation.htm?act=viewVendor&id=${vendorMaster.vendorRegNo}"
                                                               role="button"
                                                               title="View"
                                                               aria-expanded="false">
                                                                <img src="StorageYard/assets/images/edit-icon.svg" onload="SVGInject(this)"
                                                                     alt="Edit Icon">
                                                            </a>
                                                        </div>
                                                    </td>                        





                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </div>

                    </div>
                </div>
            </section>


        </main>
    </body>
    <script src="StorageYard/assets/js/vendor.js"></script>
    <script src="StorageYard/assets/js/TableScript/serachvendor.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
