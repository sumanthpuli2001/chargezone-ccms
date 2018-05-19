<%-- 
    Document   : EmployeePFForm3A
    Created on : May 16, 2018, 2:44:31 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            th{
                vertical-align:top;
                text-align:center;
            }
        </style>
    </head>
    <!DOCTYPE html>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post" commandName="employeePFForm3A" action="employeePFForm3A.htm?act=createClick">

                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <div style="text-align: center">
                                                <b>FORM 3 A [REVISED]</b><br/>
                                                <b>EMPLOYEE'S PROVIDENT FUND ORGANISATION</b><br/>
                                                <b>THE EMPLOYEE'S PROVIDENT FUND SCHEME, 1952[Paras 35 & 42]</b><br/>
                                                <b>AND THE EMPLOYEE'S PENSION SCHEME, 1995[Para 19]</b><br/>
                                                <b>Contribution Card for currency period from 01-Apr-2013 to 31-Mar-2014</b>
                                            </div>
                                            <br/> 
                                            <div class="col-sm-6">
                                                1. Account No. <br/>
                                                2. Name/Surname(in block letters) <br/>
                                                3. Father's/Husband's Name <br/>
                                                4. Statutory Rate of Contribution <br/>
                                                5. Voluntary Higher Rate of Employee's contribution of any <br/>
                                                6. Name & Address of the Factory / Establishment <br/> 
                                                7. Code Number
                                            </div>
                                            <div class="col-sm-6">
                                                <b>:${employeeMaster.employeeName}</b><br/>
                                                <b>:${employeeMaster.employeeName}</b><br/> 
                                                <b>:${employeeMaster.employeeName}</b><br/> 
                                                <b>:${employeeMaster.employeeName}</b><br/> 
                                                <b>:${employeeMaster.employeeName}</b><br/> 
                                                <b>:${employeeMaster.employeeName}</b><br/> 
                                                <b>:${employeeMaster.employeeName}</b>
                                            </div>
                                            <div class="col-sm-12" style="margin-top:20px">

                                                <table class="table table-bordered" >
                                                    <thead>
                                                        <tr>
                                                            <th rowspan="2" style="vertical-align: top;">Month</th>
                                                            <th colspan="3" style="vertical-align: top;">WORKER'S SHARE</th>
                                                            <th colspan="2" style="vertical-align: top;">EMPLOYER'S SHARE</th>
                                                            <th rowspan="2" style="vertical-align: top;">Refund of <br/>Advance</th>
                                                            <th rowspan="2" style="vertical-align: top;">No. of <br/> days/period of <br/>non contributing <br/>service<br/>(if any)</th>
                                                            <th rowspan="2" style="vertical-align: top;">Remarks</th>
                                                        </tr>
                                                        <tr>
                                                            <th style="vertical-align: top;">Amount of <br/>Wages</th>
                                                            <th style="vertical-align: top;">E.P.F. 12%</th>
                                                            <th style="vertical-align: top;">Rate of <br/>higher <br/>voluntary <br/>contribution<br/>(if any)</th>
                                                            <th style="vertical-align: top;">E.P.F. <br/>Difference <br/>between 12% <br/>& 8.33% (if any)</th>
                                                            <th style="vertical-align: top;">Pension fund <br/>Contribution <br/>8.33%</th>
                                                        </tr>
                                                        <tr style="font-size:13px;">
                                                            <th>1</th>
                                                            <th>2</th>
                                                            <th>3</th>
                                                            <th>3a</th>
                                                            <th>4a</th>
                                                            <th>4b</th>
                                                            <th>5</th>
                                                            <th>6</th>
                                                            <th>7</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                    </tbody>
                                                    <tfoot>
                                                        <tr style="font-size:13px;">
                                                            <th>Total</th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <p style="text-justify: auto; margin:0 15px">
                                                Certified that the total amount of contribution(both shares) indicated in this card i.e. 
                                                Rs.9,177.00 has already been remitted it full in  E.P.F. A/c No.1 & Pension fund A/c No.10 
                                                Rs.1,623.00
                                                <br/>
                                                Certified that the difference between the total of the contribution shown under the 
                                                Cols. 3,3a,4a,&4b of the above table and that arrived at on the total wages shown in column
                                                2 at the prescribed rate is solely due to rounding of the contributions to the nearest rupee
                                                under the rules.
                                            </p>
                                            <br/><br/><br/>
                                            <b style="text-align:left;text-justify: auto; margin-left:15px">
                                                Date: &emsp;28-Feb-2014<span style="float:right;margin-right:15px">Signature of Employer(with Office seal)</span>
                                            </b>
                                        </div>

                                    </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>

    </script>
</html>
