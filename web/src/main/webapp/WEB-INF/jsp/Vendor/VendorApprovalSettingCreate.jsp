<%-- 
    Document   : VendorApprovalSettingCreate
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Vendor Approval</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendorApprovalSetting.htm?act=approvalWorkFlowSubmit" commandName="tenderApprovalSetting" method="post">

                    <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Create Vendor Approval</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="vendorApprovalSetting.htm?act=showList" class="btn theme-btn light-btn mr-3">Back</a>
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
                    
                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Approver Name<span class="text-danger">*</span></label>
                                    <input type="text" name="approvalName" class="input-field" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <table id="policyTable" class="table table-borderless" style="max-width: 100%" align="center">
                        <tr>
                            <th class="pl-0">Approval User</th>
                            <th class="text-center">Add New</th>
                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                        </tr>
                        <tr id="policyId1">
                            <td class="pl-0">
                                <div>
                                    <select id="userList1" name="userList" class="select-input user-dropdown" required="true">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="employeeMaster1" items="${employeeMaster1}" varStatus = "status">
                                            <option value="${employeeMaster1.employeeCode}">${employeeMaster1.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <span id="policyError1" style="color: red;"></span>
                            </td>
                            <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                    <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                </div>
                            </td>
                        </tr>
                    </table>

                    <script>
                        var tempCount3 = 1;
                        $(function () {
                            $("#policyCloneid").on("click", function () {
                                tempCount3++;
                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                        + "<td id=\"addmoreFile" + tempCount3 + "\" class='pl-0' style=\"text-align: center\"><div>\n\
                                            <select id='userList1" + tempCount3 + "' name='userList'" + "' class=\"select-input user-dropdown\">"
                                        + "<option value=''>--Select--</option>"
                                        + "<c:forEach var='employeeMaster1' items='${employeeMaster1}'>"
                                        + "<option value='${employeeMaster1.employeeCode}'>${employeeMaster1.name}</option>"
                                        + "</c:forEach>"
                                        + "</select>"
                                        + "</div></td>"
                                        + "<td class=\"d-flex justify-content-center align-items-center\">"
                                        + "<span style='margin-top: 5px;'>"
                                        + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                                        + "</div>"
                                        + "</span>"
                                        + "</td>"
                                        + "</tr>";
                                $("#policyTable").append(clone);
                                document.getElementById('policyCount').value = tempCount3;
                                $('.select-input').selectpicker("refresh");
                                updateDropdownOptions();
                            });

                            $(document).on("change", ".user-dropdown", function () {
                                updateDropdownOptions();
                            });

                            $(document).on("click", ".delete-parent-field", function () {
                                $(this).closest("tr").remove();

                                var policyCount = $("#policyTable tr").length - 1;
                                $("#policyCount").val(policyCount);

                                updateDropdownOptions();
                            });
                        });

                        function updateDropdownOptions() {
                            let selectedValues = [];
                            $(".user-dropdown").each(function () {
                                let val = $(this).val();
                                if (val) {
                                    selectedValues.push(val);
                                }
                            });

                            $(".user-dropdown").each(function () {
                                let currentDropdown = $(this);
                                let currentValue = currentDropdown.val();

                                currentDropdown.find("option").each(function () {
                                    let optionValue = $(this).val();
                                    if (optionValue === "") return;

                                    if (optionValue === currentValue) {
                                        $(this).show();
                                    }
                                    else if (selectedValues.includes(optionValue)) {
                                        $(this).hide();
                                    }
                                    else {
                                        $(this).show();
                                    }
                                });
                                currentDropdown.selectpicker("refresh");
                            });
                        }
                    </script>

                    <div class="form-group">    
                        <div style="display: flex; justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>

