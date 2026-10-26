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
        <title>Vendor Invitation</title>
    </head>
    <body>
        <style>           
            input[type="text"], textarea {
                text-transform: uppercase;
            }
        </style>

        <script>
            document.addEventListener("input", function (e) {
                const el = e.target;

                if (
                    el.matches("input:not([type='hidden']):not([type='checkbox']):not([type='radio']), textarea")
                ) {
                    if (el.type === "email") {
                        el.value = el.value.toLowerCase();
                    } else {
                        el.value = el.value.toUpperCase();
                    }
                }
            });
        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="vendorInvitation.htm?act=submitVendorInvitation"  method="post"  commandName="vendorInvitation"
                           class="form-horizontal"  role="form" >


                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Vendor Invitation</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn" id="submit1" >Submit</button>
                        </div>

                    </div>
                    <hr>

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <c:if test="${!empty failureMessage}">
                        <div class="fadeOutEffect alert alert-danger mt-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                            <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                            <div>
                                <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${!empty successMessage}">
                        <div class="fadeOutEffect alert alert-info mt-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                            <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                            <div>                             
                                <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                            </div>
                        </div>
                    </c:if>
                  
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label">Company Name <span class="text-danger">*</span></label>
                                    <input type="text" name="companyName" style="text-transform: uppercase;"  class="input-field" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <div class="form-group">
                                    <label class="control-label"> Email Id <span class="text-danger">*</span></label>
                                    <div class="form-group">
                                        <form:input path="vendorEmailId"  id="vendorEmail" type="email"  cssClass="input-field" placeholder="Eg: abc@gmail.com" maxlength="100" required="required"  oninput="this.value = this.value.toLowerCase();"/>
                                        <!-- Error message container -->
                                        <div id="emailError" style="color: red; font-size: 0.9em; margin-top: 5px;"></div>
                                    </div>
                                    <script>
                                    document.getElementById("submit1").addEventListener("click", function(e) {
                                        var emailField = document.getElementById("vendorEmail");
                                        var email = emailField.value.trim();

                                        // Regex allowing multiple dots in domain, final TLD 2-24 letters
                                        var pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,24}$/;

                                        if (!pattern.test(email)) {
                                            e.preventDefault(); // Stop form submission
                                             Swal.fire({
                                                icon: 'error',
                                                title: 'Invalid Email',
                                                text: 'Please enter a valid email with correct format and domain extension',
                                                confirmButtonText: 'OK'
                                            });
                                            emailField.focus();
                                            return false;
                                        }
                                    });
                                    </script>


                                </div>
                            </div>


                            <div class="col-lg-3 col-md-6"> 
                                <div class="form-group">
                                    <label class="control-label">Vendor Invite Source <span class="text-danger">*</span></label>
                                    <select class="select-input" id="vendorInviteSource" name="vendorInviteSource" required="true">
                                        <option value="">--select--</option>
                                        <c:forEach var="list" items="${list5}">
                                            <option value="${list.source}">${list.source}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                                        
                            <div class="col-lg-3 col-md-6"> 
                                <div class="form-group">
                                    <label class="control-label">Vendor Contact No</label>
                                    <input type="text" class="input-field" id="vendorContactNo" name="vendorContactNo" onchange="checkMobile()" placeholder="Ex: 9876543210" minlength="10" maxlength="10" pattern="^\d{10,}$" inputmode="numeric" oninput="this.value = this.value.replace(/\D/g,'')">                                    
                                    <div id="mobileError" style="color:red;"></div>
                                </div>
                            </div>
                            <script>
                                function checkMobile() {
                                    var mobile = document.getElementById("vendorContactNo").value;
                                    var error = document.getElementById("mobileError");
                                    var input = document.getElementById("vendorContactNo");

                                    if (mobile.length != 0 && mobile.length != 10) {
                                        error.innerText = "Mobile number must be 10 digits";
                                        input.style.border = "1px solid red";
                                     } else {
                                        error.innerText = "";
                                        input.style.border = "1px solid #ccc";
                                    }
                                }

                                function validateMobile() {
                                    var mobile = document.getElementById("vendorContactNo").value;

                                    if (mobile.length != 10) {
                                        checkMobile();
                                        return false;
                                    }
                                    return true;
                                }
                            </script>
                        </div>
                                        
                        <div class="checkbox-container" >
                            <div class="checkbox-label">
                                <div class="nested-options show" id="group-options">

                                    <table  id="commonDocTable" class="table table-striped bg-white"  align="center" style="width: 100%;">
                                        <thead>
                                            <tr>
                                                <th data-dt-order="disable">Group Name</th>
                                                <th data-dt-order="disable">Categories</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="item" items="${list}" varStatus="status">

                                                <tr>
                                                    <td style="border: 1px solid #ddd; padding: 8px;">
                                                        <div style="display: flex; align-items: center;">
                                                            <input type="checkbox" name="groupIdd"  value="${item.id}" id="checkbox-${item.id}" onclick="toggleCategoryList(${item.id})">
                                                            <span style="font-size: 13px; margin-left: 10px;">${item.groupName}</span>
                                                        </div>
                                                    </td>
                                                    <td style="border: 1px solid #ddd; padding: 8px;">
                                                        <div id="category-list-container-${item.id}" style="display: none; padding-left: 20px;">
                                                            <c:forEach var="subItem" items="${list1}" varStatus="subStatus">
                                                                <c:if test="${subItem.groupMasterId == item.id}">
                                                                    <div>
                                                                        <input type="checkbox" id="checkboxx-${subItem.id}" name="groupCategoryId" value="${subItem.id}" onclick="SubtoggleCategoryList(${subItem.id})" class="category-option">
                                                                        <span for="category-${subItem.id}" style="font-size: 13px;">
                                                                            ${subItem.groupCatogryName}
                                                                        </span>
                                                                    </div>

                                                                    <div id="category-list-containerrr-${subItem.id}" style="display: none; padding-left: 20px; border-left: 2px solid #ddd; padding-top: 10px; margin-left: 20px;">
                                                                        <c:forEach var="subsubitem" items="${list2}" varStatus="subsubStatus">
                                                                            <c:if test="${subsubitem.groupCategoryId == subItem.id}">
                                                                                <div style="border: 1px solid #ddd; padding: 8px; margin-bottom: 8px;">
                                                                                    <input type="checkbox" name="groupSubcategory" value="${subsubitem.id}" class="category-option">
                                                                                    <span for="category-${subsubitem.id}" style="font-size: 13px;">
                                                                                        ${subsubitem.subCategoryName}
                                                                                    </span>
                                                                                </div>
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </div>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <script>
                                 // Function to toggle the visibility of the category list based on checkbox status
                                 function toggleCategoryList(groupId) {
                                     var checkbox = document.getElementById('checkbox-' + groupId);
                                     var categoryListContainer = document.getElementById('category-list-container-' + groupId);

                                     // Toggle visibility
                                     if (checkbox.checked) {
                                         categoryListContainer.style.display = 'block';  // Show the categories
                                     } else {
                                         categoryListContainer.style.display = 'none';  // Hide the categories
                                     }
                                 }

                                 function SubtoggleCategoryList(groupId) {
                                     var checkbox = document.getElementById('checkboxx-' + groupId);
                                     var categoryListContainer = document.getElementById('category-list-containerrr-' + groupId);

                                     // Toggle visibility
                                            if (checkbox.checked) {
                                                categoryListContainer.style.display = 'block';  // Show the categories
                                            } else {
                                                categoryListContainer.style.display = 'none';  // Hide the categories
                                            }
                                        }

                                        function validateForm() {
                                            // Get all selected groups
                                            var groups = document.querySelectorAll('input[name="groupIdd"]:checked');

                                            // Check if at least one group is selected
                                            if (groups.length === 0) {
                                                Swal.fire({
                                                    icon: 'warning',
                                                    title: 'Selection Required',
                                                    text: 'Please select at least one group.',
                                                    confirmButtonText: 'OK'
                                                });

                                                return false; // Stop form submission
                                            }


                                            // Loop through selected groups
                                            for (var i = 0; i < groups.length; i++) {
                                                var groupId = groups[i].value;
                                                var categories = document.querySelectorAll('#category-list-container-' + groupId + ' input[name="groupCategoryId"]:checked');

                                                if (categories.length === 0) {
                                                    Swal.fire({
                                                        icon: 'warning',
                                                        title: 'Selection Required',
                                                        text: 'Please select at least one category for the selected group: '
                                                                + groups[i].nextElementSibling.innerText,
                                                        confirmButtonText: 'OK'
                                                    });
                                                    return false;
                                                }

                                                // Check subcategories for each selected category
                                                for (var j = 0; j < categories.length; j++) {
                                                    var categoryId = categories[j].value;

                                                    var subcategories = document.querySelectorAll(
                                                            '#category-list-containerrr-' + categoryId + ' input[name="groupSubcategory"]:checked'
                                                            );

                                                    if (subcategories.length === 0) {
                                                        Swal.fire({
                                                            icon: 'warning',
                                                            title: 'Selection Required',
                                                            text: 'Please select at least one subcategory for the selected category: '
                                                                    + categories[j].nextElementSibling.innerText,
                                                            confirmButtonText: 'OK'
                                                        });

                                                        return false; // 🔴 loop + form submit બંધ કરશે
                                                    }
                                                }

                                            }

                                            return true; // All validations passed
                                        }

                                        // Attach validation to form submit
                                        var form = document.querySelector('form'); // Make sure your form tag exists
                                        if (form) {
                                            form.onsubmit = function () {
                                                return validateForm();
                                            };
                                        }

                                    </script>
                                </div>
                                <br>
                                <div class="form-group">

                                </div>
                            </div>
                        </div>
                    </div>
                
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
