<%-- 
    Document   : EditVendorCriteria
    Created on : Nov 30, 2024, 5:16:24 PM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Edit Vendor Criteria</title>
        
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="vendorCriteriaMaster.htm?act=editVendorTechnicalCriteriaSubmit" method="post" commandName=""
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Edit Vendor Criteria</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn" onclick="return Validate()" >Submit</button>
                        </div>
                    </div>
                    <c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>                             
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                    <hr>
                     <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    
                   
                    <input type="hidden" name="id" id="id" value="${vendorCriteriaMaster.id}">

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group  Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="groupName" name="groupName" required="true" onchange="fetchGroupCategory(this.value)" >
                                        <c:forEach var="list" items="${list}">  
                                            <c:choose>
                                                <c:when test="${groupMasterId==list.id}">
                                                    <option value="${list.id}" selected="true">${list.groupName} </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${list.id}">${list.groupName}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select> 
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group Category Name : </label>
                                    <select class="select-input" id="groupCategoryName" name="groupCategoryName"  onchange="fetchGroupSubCategory(this.value)">
                                        <option value="${groupCategory.id}" >${groupCategory.groupCatogryName}</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Sub Category Name :</label>
                                    <select class="select-input" id="subCategoryName" name="subCategoryName" onchange="fetchDepartmentCategory(this.value)">
                                        <option value="${groupSubCategory.id}" >${groupSubCategory.subCategoryName}</option>
                                    </select>
                                    </div>
                                </div>

                                <div class="col-lg-3 col-md-6">
                                    <div class="form-group">
                                        <label class="control-label">Department Category : <span class="text-danger">*</span></label>
                                        <select class="select-input" id="DepartmentCategory" name="DepartmentCategory" required="true">
                                            <option value="HR" <c:if test="${departmentCategory eq 'HR'}">selected</c:if>>HR</option>
                                            <option value="HSE" <c:if test="${departmentCategory eq 'HSE'}">selected</c:if>>HSE</option>
                                            <option value="IT" <c:if test="${departmentCategory eq 'IT'}">selected</c:if>>IT</option>
                                            <option value="TECHNICAL" <c:if test="${departmentCategory eq 'TECHNICAL'}">selected</c:if>>TECHNICAL</option>
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <table id="commonTable7" class="table table-striped bg-white" align="center">
                            <thead>
                                <tr>
                                    <th width="2%">Sr.No</th>
                                    <th style="max-width: 20px;">Criteria Name</th>
                                    <th style="max-width: 30px;">Criteria Description</th>
                                    <th>Attachment Required</th>
                                    <th data-dt-order="disable" style="width:100px;" class="text-center">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list2" items="${list2}" varStatus="status">
                                    <tr>
                                        <td> ${status.count}</td>
                                        <input type="hidden"  value= class="form-control" readonly />
                                        <td class="terms-details">${list2.criteriaName}</td> 
                                        <td class="terms-details">${list2.criteriaDescription}</td> 
                                        <td>
                                            <c:choose>
                                                <c:when test="${list2.mandatory == 'Yes'}">
                                                    <i class="fa fa-check-circle text-success" title="Compulsory"></i>
                                                </c:when>
                                                <c:otherwise>
                                                    <i class="fa fa-times-circle text-danger" title="Not Compulsory"></i>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="text-center">
                                            <div class="row m-0 p-0 d-flex justify-content-center">
                                                <a href="#" class="d-flex text-danger p-1 mx-1 action-link delete-doc-row"
                                                   data-toggle="tooltip" data-id="${list2.id}" data-placement="left" title="Delete">
                                                    <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon">
                                                </a>
                                                <a href="vendorCriteriaMaster.htm?act=editVendorTechnicalCriteriaPartTwo&id=${list2.id}" class="d-block text-info p-1 mx-1 action-link" data-toggle="tooltip" data-placement="left" title="Edit">
                                                    <img src="StorageYard/assets/images/edit-icon.svg" onload="SVGInject(this)" alt="Edit Icon">
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                        <table id="policyTable5" class="table table-borderless" >
                            <tr>
                                <th>Sr. No.</th>
                                <th>Criteria Name</th>
                                <th>Criteria Description</th>
                                <th>Attachment Required</th>
                                <th>Add New</th>
                                <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>
                            </tr>
                            <tr id="policyRow1">
                                <td id="policyId1" style="width: 15vh;">
                                    <input style="width: 15vh; " type="text" class="input-field" name="srNo1" value="1" readonly>
                                </td>
                                <td id="name1">
                                    <textarea class="textarea-field" name="Criteria" placeholder="Criteria Name" id="Criteria"></textarea>
                                </td>
                                <td id="value1">
                                    <textarea class="textarea-field" name="CriteriaDescription" placeholder="Criteria Description" id="CriteriaDescription"></textarea>
                                </td>
                                <td id="value1">
                                    <select name="mandatory" id="mandatory" class="select-input">
                                        <option value="">-- Select --</option>
                                        <option value="Yes">Yes</option>
                                        <option value="No">No</option>
                                    </select>
                                </td>
                                <td style="">
                                    <div id="policyCloneid5" class="">
                                        <div class="clone-action clone-new-field mx-auto" title="Add">
                                            <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Add">
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <script>
                            var tempCount5 = 1;
                            $(function () {
                                $("#policyCloneid5").on("click", function () {
                                    tempCount5++;
                                    var clone = "<tr id='addmoreFile" + tempCount5 + "' style='clear:both;'>"
                                            + "<td id=\"policyId" + tempCount5 + "\"><input style=\"width: 15vh; \" type=\"text\" class=\"input-field\" name=\"srNo" + tempCount5 + "\" value=\"" + tempCount5 + "\" readonly></td>"
                                            + "<td><textarea class=\"textarea-field\" placeholder=\"Criteria Name\" name=\"Criteria" + "\" id=\"Criteria" + tempCount5 + "\"></textarea></td>"
                                            + "<td><textarea class=\"textarea-field\" placeholder=\"Criteria Description\" name=\"CriteriaDescription" + "\" id=\"CriteriaDescription" + tempCount5 + "\"></textarea></td>"
                                            + "<td>"
                                            + "<select name='mandatory' class='select-input' id='mandatory" + tempCount5 + "'>"
                                            + "<option value=''>-- Select --</option>"
                                            + "<option value='Yes'>Yes</option>"
                                            + "<option value='No'>No</option>"
                                            + "</select>"
                                            + "</td>"
                                            + "<td >"
                                            + " <div class='clone-action delete-parent-field mx-auto' title='Remove' onclick=\"removePolicy('addmoreFile" + tempCount5 + "');\">" 
                                            + " <img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'/>" 
                                            + " </div>"
                                            + "</td>" + "</tr>";
                                    $("#policyTable5").append(clone);
                                    $('.select-input').selectpicker('refresh');
                                    document.getElementById('policyCount5').value = tempCount5;
    
                                    updateSerialNumbers();
                                });
                            });

                            function addBPolicy33(id) {
                                var element2 = document.getElementById('mandatory');
                                var obj2 = document.getElementById("mandatory" + id);
                                for (var i2 = 0; i2 < element2.options.length; i2++) {
                                    var opt2 = document.createElement("option");
                                    opt2.value = element2.options[i2].value;
                                    opt2.text = element2.options[i2].text;
                                    obj2.appendChild(opt2);
                                }
                            }

                            function removePolicy(policyDiv) {
                                try {
                                    var element1 = document.getElementById(policyDiv);
                                    element1.parentNode.removeChild(element1);
                                    updateSerialNumbers();
                                    var policyCount5 = document.getElementById('policyTable5').rows.length - 1;
                                    document.getElementById('policyCount5').value = policyCount5;
                                } catch (e) {
                                    console.log(e);
                                }
                            }

                            function updateSerialNumbers() {
                                var table = document.getElementById('policyTable5');
                                var srNo = 1;
                                for (var i = 0; i < table.rows.length; i++) {
                                    var row = table.rows[i];
                                    if (row.querySelector('th')) continue;
                                    var input = row.cells[0]?.querySelector('input');
                                    if (input) {
                                        input.value = srNo++;
                                    }
                                }
                            }
                        </script>  
                        
                        <table id="commonTable" class="table table-striped bg-white" align="Center"  >
                            <c:choose>
                                <c:when test="${empty list3}"></c:when>
                                <c:otherwise>
                                    <thead>
                                        <tr>
                                            <th>Sr.No</th>
                                            <th>Criteria Name</th>
                                            <th>Criteria Description</th>
                                            <th>Date Time</th>
                                            <th>Created By</th>
                                            <th data-dt-order="disable">Action</th>
                                        </tr>
                                    </thead>
                                    <c:set var="count" value="0" scope="page" />
                                    <tbody>
                                        <c:forEach var="list3" items="${list3}" varStatus="status" >
                                            <tr>
                                                <td> ${status.count}</td>
                                                <td class="terms-details">${list3.criteriaName}</td>
                                                <td class="terms-details">${list3.criteriaDescription}</td>
                                                <td>${list3.date}</td>
                                                <td>${list3.action}</td>
                                                <td>${list3.actionBy}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </c:otherwise>
                            </c:choose>
                        </table>

                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
        var savedGroupCategoryId   = "${groupCategory.id}";
        var savedSubCategoryId     = "${groupSubCategory.id}";
        var savedDepartmentCategory = "${departmentCategory}";

        function fetchGroupCategory(groupName, selectedGroupCategoryId) {
            var groupMasterId = document.getElementById("groupName").value;
            $.ajax({
                data: 'groupName=' + groupName,
                url: "group.htm?act=selectgroupCategoryByGroupName",
                success: function (content) {
                    var data1 = "<option value=''>-- Select --</option>";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupCategory']).length;
                    var object = obj['groupCategory'];
                    for (var i = 0; i < objLength; i++) {
                        var selected = (selectedGroupCategoryId && object[i].id == selectedGroupCategoryId) ? " selected" : "";
                        data1 += "<option value='" + object[i].id + "'" + selected + ">" + object[i].groupCategoryName + "</option>";
                    }
                    document.getElementById('groupCategoryName').innerHTML = data1;
                    $('.select-input').selectpicker('refresh');

                    if (selectedGroupCategoryId) {
                        fetchGroupSubCategory(selectedGroupCategoryId, savedSubCategoryId);
                    }
                }
            });
        }

        function fetchGroupSubCategory(groupCategoryName, selectedSubCategoryId) {
            $.ajax({
                data: 'groupCategoryName=' + groupCategoryName,
                url: "group.htm?act=selectgroupSubCategoryByGroupCategory",
                success: function (content) {
                    var data1 = "<option value=''>-- Select --</option>";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupSubCategory']).length;
                    var object = obj['groupSubCategory'];
                    for (var i = 0; i < objLength; i++) {
                        var selected = (selectedSubCategoryId && object[i].id == selectedSubCategoryId) ? " selected" : "";
                        data1 += "<option value='" + object[i].id + "'" + selected + ">" + object[i].subCategoryName + "</option>";
                    }
                    document.getElementById('subCategoryName').innerHTML = data1;
                    $('.select-input').selectpicker('refresh');

                    if (selectedSubCategoryId) {
                        fetchDepartmentCategory(selectedSubCategoryId, savedDepartmentCategory);
                    }
                }
            });
        }

        function fetchDepartmentCategory(SubCategoryName, selectedDepartmentName) {
            $.ajax({
                type: "GET",
                url: "group.htm?act=selectDepartmentCategoryBygroupSubCategory",
                data: {subCategoryName: SubCategoryName},
                dataType: "json",
                success: function (data) {
                    console.log("Response:", data);

                    var options = "<option value=''>--select--</option>";
                    var list = data.departmentCategory;

                    if (list && list.length > 0) {
                        for (var i = 0; i < list.length; i++) {
                            var selected = (selectedDepartmentName && list[i].departmentName === selectedDepartmentName) ? " selected" : "";
                            options += "<option value='" + list[i].id + "'" + selected + ">" + list[i].departmentName + "</option>";
                        }
                        $("#DepartmentCategory").html(options);
                        $('.select-input').selectpicker('refresh');
                    } else {
                        if (!selectedDepartmentName) {
                            alert("Please select any one department category for this Group Sub Category");
                        }
                        $("#DepartmentCategory").html("<option value=''>--select--</option>");
                    }
                },
                error: function (xhr, status, error) {
                    console.error("AJAX Error:", status, error, xhr.responseText);
                }
            });
        }

        $(document).ready(function () {
            var groupMasterId = document.getElementById("groupName").value;
            if (groupMasterId) {
                fetchGroupCategory(groupMasterId, savedGroupCategoryId);
            }
        });
    </script>
    
    <script>
        $(document).on('click', '.delete-doc-row', function (e) {
                    e.preventDefault();

                    var $row = $(this).closest('tr');
                    var id = $(this).data('id');
                    Swal.fire({
                        title: 'Are you sure you want to delete this?',
                        text: 'You will not be able to recover this record!',
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonText: 'Yes, delete it!',
                        cancelButtonText: 'No, cancel',
                        reverseButtons: true,
                        customClass: {
                            confirmButton: 'confirm-delete',
                            cancelButton: 'theme-btn light-btn'
                        }
                    }).then((result) => {
                        if (result.isConfirmed) {
                            $.ajax({
                                url: 'vendorCriteriaMaster.htm?act=criteiaDelete&id=' + id,
                                type: 'POST',
                                data: JSON.stringify({
                                    id: id
                                }),
                                contentType: 'application/json',
                                success: function (response) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Deleted!',
                                        text: response.message || 'Record has been deleted.'
                                    });
                                    $('#commonTable7')
                                        .DataTable()
                                        .row($row)
                                        .remove()
                                        .draw();
                                },
                                error: function (xhr) {
                                    Swal.fire({
                                    icon: 'error',
                                    title: 'Error!',
                                    text: 'Error deleting record: ' + xhr.responseText
                                    });
                                }
                            });
                        }
                    });
                });
    </script>
    
</html>
