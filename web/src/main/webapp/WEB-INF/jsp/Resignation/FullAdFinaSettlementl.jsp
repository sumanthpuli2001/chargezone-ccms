<%-- 
    Document   : FullAdFinaSettlementl
    Created on : 16 Apr, 2018, 12:21:57 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Resignation Employee</title>
    </head>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Resignation Employee</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Resignation Employee</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">


                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>

                                <!--form--> 
                                <form:form class="form-horizontal" method="post" onsubmit='return checkBlankField();'
                                           commandName="fullAndFinalSettlement" action="resignationMaster.htm?act=fullAndFinalSubmit">



                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label class="control-label">Resignation Employee :<span style="color: red;font-size: 12px;"></span></label>
                                                <!--<input type="text" name="empid" id="empid" class="form-control"/>-->
                                                 <form:input type="text" path="resignationEmpId" name="policyId1" id="policyId1" class="form-control"/>
                                        </div>
                                        <div class="col-sm-5">
                                            <label class="control-label">Notice Period :<span style="color: red;font-size: 12px;"></span></label>
                                                <form:input type="text" path="noticePeriod" name="noticePeriod" id="noticePeriod" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label class="control-label">Given Notice :<span style="color: red;font-size: 12px;"></span></label>
                                                <form:input type="text" path="givenNotice" name="givenNotice" id="givenNotice" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </div>
                            </form:form>


                        </div><!-- /.tab-pane -->
                    </div><!--tab-content>
                </div><!--nav-tabs-custom>
            </div><!-- /.col -->
                </div>
            </div>
        </section><!-- /.content -->
    </div>

    <script>
    jQuery.noConflict();
    jQuery(document).ready(function () {

        jQuery("#policyId1").tokenInput(${resignedEmployeelist}, {
            preventDuplicates: true,
            noResultsText: "No Result",
            tokenLimit: "1",
            searchingText: "Searching ... .. .",
            prePopulate: ${preList}
        });
    });

</script>
    
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
