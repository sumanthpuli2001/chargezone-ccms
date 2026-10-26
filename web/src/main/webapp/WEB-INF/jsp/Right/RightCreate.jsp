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
        <title>Create Right</title>
    </head>
    <body>
        <script>
            function cancelClick() {
                window.location = 'right.htm?act=showList';
            }
        </script>
        
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="right.htm?act=submitRightMaster" method="post" commandName="rightMaster"
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-3 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Create Right</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="cancelClick();" class="btn theme-btn light-btn mr-3">Back</a>
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
                                    <label for="role-name" class="label">Right Name<span class="text-danger">*</span></label>
                                    <input name="rightName"  id="role-name" class="input-field"  placeholder="Enter Role Name" required="required"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="d-flex align-items-center">
                        <h6 class="fw-600 mr-4 mb-0 fs-18">Permissions</h6>
                        <label class="mb-0 d-flex align-items-center">
                            <input id="select_all" type="checkbox" class="switch-input">
                            <span class="check mr-2"></span>
                            Select All
                        </label>
                    </div>

                    <hr>
                    <br>
                    <h5 class="fw-600 mr-4 mb-0 fs-17">Master Management</h5>
                    <br>

                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">

                                    <input id="switch-1" name="emp_mgt" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Master Management
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-3" name="vendor_mgt" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Vendor Management<hr>
                                </label>
                            </div>
                        </div>

                        
                    </div>
                    
                    <hr>
                    <h5 class="fw-600 mr-4 mb-0 fs-17">PR Management</h5>
                    <br>
                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-35" name="prManagement" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    PR Management<hr>
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-35" name="omsCreator" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    OMS Approval<hr>
                                </label>
                            </div>
                        </div>
                    </div>
                    
                    <hr>
                    <br>
                    <h5 class="fw-600 mb-3">Tender Management</h5>

                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-4" name="create_tender" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Create Tender
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-5" name="authorize_tender" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Purchase Manager
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-6" name="tender_bid_open" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Bid Open
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-56" name="grnExecutive" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    GRN Executive 
                                </label>
                            </div>
                        </div>
                    </div>

                    <hr>
                    <br>
                    <div class="row">
                        <div class="col-12">
                            <h5 class="fw-600 mb-4 fs-17">Report Management</h5>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-7" name="user_report" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    User Report
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-8" name="tender_report" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Tender Report
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-9" name="oap_aoc_report" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    OAP/AOC Report
                                </label>
                            </div>
                        </div>
                    </div>
                    <hr>

                    <br>
                    <h5 class="fw-600 mb-4 fs-17" >OAP/AOC Management</h5>
                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">  
                                    <input id="switch-10" name="oap_creater" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    OAP Creater
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-11" name="oap_Approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    OAP Approval
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-12" name="aoc_creater" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    AOC Creater
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center" >
                                    <input id="switch-13" name="aoc_Approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    AOC Approval
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-14" name="oap_approval_creater" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Design Manager
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-15" name="aoc_approval_creater"class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Design Co Ordinator
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center" >
                                    <input id="switch-16" name="project_manager" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Project Manager
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-17" name="network_team" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Network Team
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-18" name="finance_team" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Finance Team
                                </label>
                            </div>
                        </div>



                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center"">
                                    <input id="switch-19" name="execitive_head" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Executive Head
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-20" name="project_Cordinator" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Project Coordinator
                                </label>
                            </div>
                        </div>


                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-21" name="site_survey"  class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Site Survey
                                </label>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <br>

                    <h5 class="fw-600 mb-4 fs-17" >Vendor Management</h5>
                    <div class="row">
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-22" name="vendor_request"  class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Vendor Request
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-23" name="vendor_invite" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Vendor Invite
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-24" name="vendor_information"  class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Vendor Information
                                </label>
                            </div>
                        </div>
                        
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-25" name="active_vender" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Active Vendor
                                </label>
                            </div>
                        </div>


                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-26" name="all_vender" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    All Vendor
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-27" name="complianceOfficer" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Compliance Officer
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-28" name="procurementHead" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Procurement Head
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-29" name="buyer_approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Buyer Approval
                                </label>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-30" name="financial_approval"  class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Financial Approval
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-31" name="technical_approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Technical Approval
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-32" name="hr_approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    HR Approval
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-33" name="safety_approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    Safety Approval
                                </label>
                            </div>
                        </div>
                        
                        <div class="col-md-6 col-lg-4">
                            <div class="form-group">
                                <label class="mb-0 d-flex align-items-center">
                                    <input id="switch-34" name="it_approval" class="switch-input" type="checkbox" value="1" />
                                    <span class="check mr-2"></span>
                                    IT Approval
                                </label>
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
        <script>
            function updateSelectAll() {
                const switches = $('.switch-input').not('#select_all');
                $('#select_all').prop(
                    'checked',
                    switches.length > 0 &&
                    switches.length === switches.filter(':checked').length
                );
            }

            $('#select_all').on('change', function () {
                $('.switch-input').not('#select_all')
                    .prop('checked', this.checked);
            });

            $(document).on('change', '.switch-input:not(#select_all)', function () {
                updateSelectAll();
            });
        </script>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
