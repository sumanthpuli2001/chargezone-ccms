<%-- 
    Document   : kaizen
    Created on : Apr 13, 2018, 9:57:51 AM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head> 
        <title>Training Type Master </title>

    </head>
    <style>
        table, th, th {
            border: 2px solid black;
            border-collapse: collapse;
        }
        th, th {
            padding: 15px;
        }
    </style>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Kaizen</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Kaizen</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="table">
                                <table style="width:100%">
                                    <tr>
                                        <th colspan="3">Kaizen Sr. No.</th>
                                        <th colspan="5"><input type="text" size="50px;"></th>
                                        <th colspan="2">Team Leader</th>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="3">Team Name </th>
                                        <th colspan="5"><input type="text" size="50px;"></th>
                                        <th colspan="2">Kaizen Idea Generator</th>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="3">Department </th>
                                        <th colspan="5"><input type="text" size="50px;"></th>
                                        <th colspan="2" rowspan="3">Team Member </th>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr style="vertical-align: top;">
                                        <th colspan="3" rowspan="5">
                                            Problem Description: ): <br>Electricity Consumption is more  <br>
                                            <textarea style="resize: none" rows="12" cols="35"></textarea>
                                        </th>
                                        <th colspan="5" rowspan="5" style="text-align: center;" >
                                            Before Photo <br>
                                            <input type="file" class="form-control" id="photograph" name="photograph" accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                            <span style="font-size: 14px; color: red;" id="photographError"></span>
                                        </th>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="2">Start Date </th>
                                        <th colspan="2">
                                            <input type="text" id="datetimepicker2" class="form-control" placeholder="Please select start Date"  name="validityFrom" readonly="true" required="true"/>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th colspan="2">Completion Date  </th>
                                        <th colspan="2">
                                            <input type="text" id="datetimepicker1" class="form-control" placeholder="Please select Completion Date" name="validityFrom" readonly="true" required="true"/>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th colspan="2">Budget Requirement  </th>
                                        <th colspan="2"><input type="text"></th>
                                    </tr>
                                    <tr style="vertical-align: top;">
                                        <th colspan="3" rowspan="5">Improvement Description :<br>We can remove the unnecessary lights<br>
                                            <textarea style="resize: none" rows="12" cols="35"></textarea>
                                        </th>
                                        <th colspan="5" rowspan="5" style="text-align: center;">After Photo<br>
                                          <input type="file" class="form-control" id="photograph" name="photograph" accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                            <span style="font-size: 14px; color: red;" id="photographError"></span>
                                        </th>
                                        <th colspan="2" rowspan="1">Tangible Benefit </th>
                                        <th colspan="2" rowspan="1"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="2" rowspan="1">Intangible Benefit </th>
                                        <th colspan="2" rowspan="1"><input type="text"></th>
                                    </tr>
                                    <tr>
                                        <th colspan="2" rowspan="3" style="vertical-align: top;height: 200px !important;">Horizontal Deployment: </th>
                                        <th colspan="2" rowspan="3" style="height: 200px !important; vertical-align: top;">
                                            <textarea style="resize: none" rows="8" cols="23"></textarea>
                                        </th>
                                    </tr>

                                    <tr></tr>
                                    <tr></tr>
                                    <tr>
                                        <th colspan="2" >
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Productivity
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" />  
                                        </div>
                                    </div>
                                    </th>
                                    <th colspan="2">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Quality
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" />
                                        </div>
                                    </div>
                                    </th>
                                    <th colspan="2" >
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Delivery
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" /> 
                                        </div>
                                    </div>
                                    </th>
                                    <th colspan="2">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Safety
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" />
                                        </div>
                                    </div>
                                    </th>
                                    <th colspan="2" >
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Cost
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" />  
                                        </div>
                                    </div>
                                    </th>
                                    <th colspan="2">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="col-md-6 col-sm-6" style="text-align: left;">
                                            Morale
                                        </div>
                                        <div class="col-md-6 col-sm-6" style="text-align:right">
                                            <input type="checkbox" /> 
                                        </div>
                                    </div>
                                    </th>

                                    </tr>

                                </table>
                            </div>
                        </div> <!--/tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>
    <script>
        $(document).ready(function () {
            $('#datetimepicker2').datepicker({
            });
        });
        $(document).ready(function () {
            $('#datetimepicker1').datepicker({
            });
        });
    </script>
    <script>
        function checkFileSize() {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('photograph').files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 102400) {
                    document.getElementById('photograph').value = '';
                    document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
                } else {
                    document.getElementById('photographError').innerHTML = '';
                }
                // check file size
        }
    </script>
</html>