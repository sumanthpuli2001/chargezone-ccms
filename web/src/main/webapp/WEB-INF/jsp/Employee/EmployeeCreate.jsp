<%-- 
    Document   : EmployeeCreate
    Created on : 29 March, 2025, 9:35:37 AM
    Author     : Prachi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Employee</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="employeeMaster.htm?act=submitEmployeeMaster" method="post" commandName="employeeMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">Create Employee</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="employeeMaster.htm?act=showList" class="btn theme-btn light-btn mr-3">Back</a>
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
                                    <label for="name" class="label">Username<span class="text-danger">*</span></label>
                                    <form:input path="employeeCode" class="input-field"   maxlength="30" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Full Name<span class="text-danger">*</span></label>
                                    <form:input path="name" class="input-field" maxlength="30" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Department :<span class="text-danger">*</span></label>
                                        <form:select path="department"  class="select-input " required="required">
                                        <option value="">--select--</option>

                                        <c:forEach var="departmentMaster" items="${departmentMaster}">
                                            <form:option value="${departmentMaster.departmentName}">${departmentMaster.departmentName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>                                           
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Designation :<span class="text-danger">*</span></label>
                                    <form:select path="designation"  class="select-input " required="required">
                                        <option value="">--select--</option>
                                        <c:forEach var="designationMaster" items="${designationMaster}">
                                            <form:option value="${designationMaster.designationName}">${designationMaster.designationName}</form:option>
                                        </c:forEach>
                                    </form:select>                                
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Email Id :<span class="text-danger">*</span></label>
                                    <input type="email" id="emailId" name="emailId" pattern="[^ @]*@[^ @]*" class="input-field" placeholder="Eg: abc@gmail.com" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Phone No :<span class="text-danger">*</span></label>
                                    <input id="phNo" name="phNo" class="input-field" pattern="^\+[1-9][0-9]{0,3}\s?[0-9]{6,14}$"
                                        placeholder="Eg: +91 8765432198" required
                                        title="Enter a valid phone number with country code (e.g. +91 8765432198)"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Mobile No :<span class="text-danger">*</span></label>
                                    <input type="tel" id="mobileNo" name="mobileNo" class="input-field" required
                                        pattern="^\+[1-9][0-9]{0,3}\s?[0-9]{6,14}$" placeholder="Eg: +91 8765432198"
                                        title="Enter a valid phone number with country code (e.g. +91 8765432198)" >
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">City :<span class="text-danger">*</span></label>
                                    <input id="city" name="city" class="input-field" required="required"/>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Pin code :<span class="text-danger">*</span></label>
                                    <input id="pincode" name="pincode" class="input-field" pattern="[0-9]{1,6}" placeholder="Eg: 432198" required="required" />
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Location :<span class="text-danger">*</span></label>
                                        <form:select path="location"  class="select-input " required="required">
                                        <option value="">--select--</option>
                                        <c:forEach var="companyLocation" items="${companyLocation}">
                                            <form:option value="${companyLocation.locationName}">${companyLocation.locationName}</form:option>
                                        </c:forEach>
                                    </form:select>                               
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="name" class="label">Rights :<span class="text-danger">*</span></label>
                                        <form:select path="rightsName" class="select-input " required="required">
                                        <option value="">--select--</option>
                                        <c:forEach var="rightsType" items="${rightsType}">
                                            <c:choose>
                                                <c:when test="${rightsType eq  employeeMaster.rightsName}">
                                                    <form:option value="${rightsType}" selected="true">${rightsType}</form:option>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:option value="${rightsType}">${rightsType}</form:option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </form:select>                               
                                </div>
                            </div>
                               
                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Address Line 1 :<span class="text-danger">*</span></label>
                                    <textarea id="addressLine1" name="addressLine1" class="textarea-field comment" rows="2" required="required"></textarea>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Address Line 2 :<span class="text-danger">*</span></label>
                                    <textarea id="addressLine2" name="addressLine2" class="textarea-field comment" rows="2" required="required"></textarea>
                                </div>
                            </div>
                                
                            <div class="col-lg-12 col-md-12">
                                <div class="form-group">
                                    <label>Address Line 3 :<span class="text-danger">*</span></label>
                                    <textarea  id="addressLine3" name="addressLine3" class="textarea-field comment" required="required" rows="2"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">    
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
