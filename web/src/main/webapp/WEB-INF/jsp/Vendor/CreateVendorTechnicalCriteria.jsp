<%-- 
    Document   : CreateVendorCriteria
    Created on : Nov 30, 2024, 4:01:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Create Vendor Criteria</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="vendorCriteriaMaster.htm?act=submitVendorCriteria" method="post" commandName=""
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Create Vendor Criteria</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="vendorCriteriaMaster.htm?act=showVendorCriteriaList" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
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
                    
                    
                  
                    
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group  Name :<span class="text-danger">*</span></label>
                                    <select class="select-input" id="groupName" name="groupName" required="true" onchange="fetchGroupCategory(this.value)">
                                        <option value="">--select--</option>
                                        <c:forEach var="list" items="${list}">
                                            <option value="${list.id}">${list.groupName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group Category Name : </label>
                                    <select class="select-input" id="groupCategoryName" name="groupCategoryName" onchange="fetchGroupSubCategory(this.value)">
                                        <option value="">--select--</option>
                                    </select> 
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Group Sub Category Name :</label>
                                    <select class="select-input" id="SubCategoryName" name="SubCategoryName" onchange="fetchDepartmentCategory(this.value)">
                                        <option value="">--select--</option>
                                    </select>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Department Category : <span class="text-danger">*</span></label>
                                    <select class="select-input" id="DepartmentCategory" name="DepartmentCategory" required="true">
                                        <option value="">--select--</option>
                                        <option value="HR">HR</option>
                                        <option value="HSE">HSE</option>
                                        <option value="IT">IT</option>
                                        <option value="TECHNICAL">TECHNICAL</option>
                                    </select>
                                </div>
                            </div>

                        </div>
                    </div>

                    <table id="policyTable5" class="table table-borderless" >
                        <tr>
                            <th>Sr. No.</th>
                            <th>Criteria Name</th>
                            <th>Criteria Description</th>
                            <th>Attachment Required</th>
                            <!--<th>Compulsory</th>-->
                            <th>Add New</th>
                            <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>
                        </tr>
                        <tr id="policyRow1">
                            <td id="policyId1" style="width: 15vh;">
                                <input required style="width: 15vh; " type="text" class="input-field" name="srNo1" value="1" readonly>
                            </td>
                            <td id="name1">
                                <textarea required class="textarea-field" name="Criteria" placeholder="Criteria Name" id="Criteria"></textarea>
                            </td>
                            <td id="value1">
                                <textarea required class="textarea-field" name="CriteriaDescription" placeholder="Criteria Description" id="CriteriaDescription"></textarea>
                            </td>
                            <td id="value1">
                                <select required name="mandatory" id="mandatory" class="select-input">
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
                                var policyCount5 = document.getElementById('policyTable5').rows.length - 1; // subtract 1 for header row
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


                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        function fetchGroupCategory(groupName) {
            var groupMasterId = document.getElementById("groupName").value;
            $.ajax({
                data: 'groupName=' + groupName,
                url: "group.htm?act=selectgroupCategoryByGroupName",
                success: function (content) {
                    var data1 = "";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupCategory']).length;
                    var object = obj['groupCategory'];
                    for (var i = 0; i < objLength; i++) {

                        if (i === 0) {
                            data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";
                        } else {
                            data1 += "<option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";
                        }
                        document.getElementById('groupCategoryName').innerHTML = data1;
                        $('.select-input').selectpicker('refresh');
                    }
                }
            });
        }

        function fetchGroupSubCategory(groupCategoryName) {
            var groupCategoryId = document.getElementById("groupCategoryName").value;
            $.ajax({
                data: 'groupCategoryName=' + groupCategoryName,
                url: "group.htm?act=selectgroupSubCategoryByGroupCategory",
                success: function (content) {
                    var data1 = "";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupSubCategory']).length;
                    var object = obj['groupSubCategory'];

                    for (var i = 0; i < objLength; i++) {
                        if (i === 0) {
                            data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].subCategoryName + "</option>";
                        } else {
                            data1 += "<option value='" + object[i].id + "'>" + object[i].subCategoryName + "</option>";
                        }
                        document.getElementById('SubCategoryName').innerHTML = data1;
                        $('.select-input').selectpicker('refresh');
                    }
                }
            });
        }
        function fetchDepartmentCategory(SubCategoryName) {
            $.ajax({
                type: "GET",
                url: "group.htm?act=selectDepartmentCategoryBygroupSubCategory",
                data: {subCategoryName: SubCategoryName},
                dataType: "json",
                success: function (data) {
                    console.log("? Response:", data);

                    var options = "<option value=''>--select--</option>";
                    var list = data.departmentCategory;

                    if (list && list.length > 0) {
                        for (var i = 0; i < list.length; i++) {
                            options += "<option value='" + list[i].id + "'>" + list[i].departmentName + "</option>";
                            
                        }
                        $("#DepartmentCategory").html(options);
                        $('.select-input').selectpicker('refresh');
                    } else {
                        alert("?? Please! Select any one department category for this Group Sub Category");
                        $("#DepartmentCategory").html("<option value=''>--select--</option>");
                    }
                },
                error: function (xhr, status, error) {
                    console.error("? AJAX Error:", status, error, xhr.responseText);
                }
            });
        }
    </script>

</html>
