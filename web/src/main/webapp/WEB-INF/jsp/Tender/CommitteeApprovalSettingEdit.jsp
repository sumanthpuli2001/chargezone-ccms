<%-- 
    Document   : CommitteeApprovalSettingEdit
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Committee Approval</title>
    </head>
    <body>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderApproval.htm?act=editSubmit1" method="post" id="mainForm"
                           commandName="committeeApprovalSetting" class="form-horizontal" role="form">

                    <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Edit Committee Approval</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a href="tenderApproval.htm?act=showList1" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>

                    <input type="hidden" id="id" value="${id}" name="id"/>
                    <input type="hidden" name="committeeUsersize" id="committeeUsersize" value="${length}">

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Approver Name<span class="text-danger">*</span></label>
                                    <input type="text" name="approvalName" value="${appSetting.approvalName}" class="input-field" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>

                    <style>
                        .delete-btn1{
                            cursor: pointer;
                        }
                    </style>
                    <script type="text/javascript">
                        var str7 = document.getElementById("id").value;
                        function showuser7(str) {
                            str = document.getElementById("id").value;
                            str7 = str;
                            var xreq, ID;
                            if (str == "") {
                                document.getElementById("showtext7").innerHTML = "";
                                return;
                            }
                            if (window.XMLHttpRequest) {
                                xreq = new XMLHttpRequest();
                            } else {
                                xreq = new ActiveXObject("Microsoft.XMLHTTP");
                            }
                            xreq.onreadystatechange = function () {
                                if ((xreq.readyState == 4) && (xreq.status == 200)) {
                                    document.getElementById("showtext7").innerHTML = xreq.responseText;
                                    setTimeout(() => {
                                        if ($('#commonTable').length) {
                                            const table1 = initNoPageTable('#commonTable');
                                        }
                                    }, 100);
                                    setTimeout(function () {
                                        loadExistingUsers();
                                    }, 100);
                                }
                            }

                            xreq.open("get", "tenderApproval.htm?act=committeeApprovalSettingAjax&id=" + str7, true);
                            xreq.send();
                            window.clearInterval(ID);
                        }

                        var ID = window.setInterval(showuser7(str7), 1000);
                    </script>
                    <div id="showtext7"></div>
                    <table id="policyTable" class="table table-borderless" style="max-width: 100%" align="center">
                        <tr>
                            <th class="pl-0">Approval User</th>
                            <th class="text-center">Add New</th>
                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                        </tr>
                        <tr id="policyId1">
                            <td class="pl-0">
                                <div>
                                    <select id="userList1" name="userList" class="select-input user-dropdown">
                                        <option value="">--SELECT--</option>
                                        <c:forEach var="employeeMaster1" items="${employeeMaster1}" varStatus="status">
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

                    <div class="form-group">
                        <div style="display: flex; justify-content: center;">
                            <button type="button" class="btn theme-btn" onclick="submitForm()">Submit</button>
                        </div>
                    </div>

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

    <script>
        let existingUsers = [];
        function loadExistingUsers() {
            let ids = $("#existingUserIds").val();
            existingUsers = ids
                ? ids.split(",").filter(x => x.trim() !== "")
                : [];
            updateDropdownOptions();
        }

        var tempCount3 = 1;
        $(function () {
            $("#policyCloneid").on("click", function () {
                tempCount3++;
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td id=\"addmoreFile" + tempCount3 + "\"  class='pl-0' style=\"text-align: center\"><div>"
                        + "<select id='userList1" + tempCount3 + "' name='userList' class=\"select-input user-dropdown\">"
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
                    }else if (existingUsers.includes(optionValue)) {
                        $(this).hide();
                    }
                    else {
                        $(this).show();
                    }
                });
                currentDropdown.selectpicker("refresh");
            });
        }

        $(document).on('click', '.delete-btn1', function (e) {
            e.preventDefault();
            var $row = $(this).closest('tr');
            var id = $(this).data('id');
            var apprID = $(this).data('appr-id');
            Swal.fire({
                title: 'Are you sure?',
                text: "Do you really want to delete this User?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#6c757d',
                confirmButtonText: 'Yes, delete it!',
                reverseButtons: true,
                customClass: {
                    confirmButton: 'confirm-delete',
                    cancelButton: 'theme-btn light-btn'
                }
            }).then((result) => {
                if (!result.isConfirmed) {
                    return;
                }
                $.ajax({
                    url: 'tenderApproval.htm?act=deleteusers&id=' + id + '&apprId=' + apprID,
                    type: 'POST',
                    data: JSON.stringify({
                        id: id,
                        apprID: apprID,
                    }),
                    contentType: 'application/json',
                    success: function (response) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Deleted!',
                            text: response.message || 'Record has been deleted.'
                        });
                        $('#commonTable').DataTable().row($row).remove().draw();
                        showuser7();
                        var currentSize = parseInt(document.getElementById('committeeUsersize').value) || 0;
                        if (currentSize > 0) {
                            document.getElementById('committeeUsersize').value = currentSize - 1;
                        }
                    },
                    error: function (xhr) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error!',
                            text: 'Error deleting record: ' + xhr.responseText
                        });
                    }
                });
            });
//            });
        });

        function submitForm() {
            var userSize = parseInt(document.getElementById('committeeUsersize').value) || 0;

            // If no existing users, at least one dropdown must be selected
            if (userSize === 0) {
                var allSelects = document.querySelectorAll('select[name="userList"]');
                var hasSelection = false;

                allSelects.forEach(function (sel) {
                    if (sel.value !== '' && sel.value !== null) {
                        hasSelection = true;
                    }
                });

                if (!hasSelection) {
                    Swal.fire({
                        icon: 'warning',
                        title: 'Approval User Required',
                        text: 'Please select at least one approval user before submitting.',
                        confirmButtonText: 'OK',
                        confirmButtonColor: '#3085d6'
                    });
                    return false;
                }
            }

            document.getElementById('mainForm').submit();
        }
    </script>

</html>