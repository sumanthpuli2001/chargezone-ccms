<%--
    Document   :
    Created on : Oct 9, 2015, 10:47:55 AM
    Author     : Dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Performance Appraisal Stage-Wise Report</title>
    </head>

    <script>
        function selectDropsDown11(val) {
            if (val == 'stageWise') {
                $('#employeeName').show();
                $('#stages').show();
                $('#selecctallId').show();

                $('#departmentIdDiv').show();
                $('#competencyEId').hide(500);

            } else if (val == 'competency') {
                $('#competencyEId').show();
                $('#stages').hide();
                $('#stages1').hide();
                $('#selecctallId').hide();
//                $('#departmentIdDiv').show();

            } else if (val == 'rating') {
                $('#competencyEId').hide(500);
                $('#stages').hide();
                $('#stages1').hide();
                $('#selecctallId').hide();
//                $('#departmentIdDiv').show();

            } else if (val == 'idp') {
                $('#competencyEId').hide(500);
                $('#stages').hide();
                $('#stages1').hide();
                $('#selecctallId').hide();
//                $('#departmentIdDiv').show();

            }
        }
    </script>

    <style>
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee PMP Search: </h1>

        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="appraisalPerformance.htm?act=searchSubmit" method="post" commandName="appraisalPerformanceMaster"
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                    <!--<h3 class="box-title">Employee Detail</h3>-->
                                    <!--                                        <div class="box-tools pull-right">
                                                                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>
                                                                            </div>-->
                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">

                                                <!--                                                <div class="col-sm-6" id="competencyEId" style="display: none;">
                                                                                                    <label>Competency Evaluation:</label>
                                                                                                    <select name="competencyEvaluation_Id" id="competencyEvaluation_Id" class="form-control" onchange="ajaxfun();"/>
                                                                                                    <option value="">--SELECT--</option>
                                                <%--<c:forEach var="competencyMap" items="${competencyMap}">--%>
                                                    <option value="${competencyMap.key}">${competencyMap.value}</option>
                                                <%--</c:forEach>--%>
                                                </select>
                                            </div>-->
                                                <div class="col-sm-6" id="competencyEId" >
                                                    <label>Cycle Name:</label>
                                                    <select name="pmpyear" id="pmpyear" class="form-control" onchange="ajaxfun();"/>
                                                    <!--<option value="">--SELECT--</option>-->
                                                    <c:forEach var="pmpyearMap" items="${pmpyearList}">
                                                        <option value="${pmpyearMap.key}">${pmpyearMap.value}</option>
                                                    </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <br/>
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class=" col-sm-12" style="text-align: center;">
                                                    <button type="submit" class="btn btn-primary" style="width: 100px;" >Submit</button>
                                                </div>
                                                
                                            </div>
                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form>
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2, minView: 2,
            forceParse: 0,
            endDate: new Date()});</script>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeMasterId").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });</script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#zydexLocationId").tokenInput(${zydexLocationList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });</script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#levelId").tokenInput(${levelList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });</script>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#departmentId").tokenInput(${departmentList}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });</script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $('#selecctall').on('ifChecked', function (event) {
            //        if ($('.checkAll').filter(':checked').length == $('.check').length) {
            $('.checkbox1').iCheck('check');
            //        }
        });
        $('#selecctall').on('ifUnchecked', function (event) {
            $('.checkbox1').iCheck('uncheck');
        });</script>
</html>
