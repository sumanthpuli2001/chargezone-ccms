<%-- 
    Document   : TenderDashboard
    Created on : Sep 20, 2024, 9:52:35 AM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>


    <head>
        <title>My DashBoard</title>
        <style><%@include file="/StorageYard/CSS/Dashboard/Tenderdashboard.css"%> </style>

        <!-- Add this in your <head> section for Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <style>

            * {
                box-sizing: border-box;
            }

            #exTab {
                width: 100%;
            }

            .search-container {
                display: flex;
                align-items: center;
                margin-left: auto;
            }

            #search-bar {
                height: 30px;
                width: 150px;
                padding: 4px 10px 4px 30px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 13px;
                position: relative;
            }

            .fa-search {
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
                color: #ccc;
                font-size: 16px;
            }

            .modal {
                display: none;
                position: absolute;
                z-index: 1;
                left: 590px;
                top: 40px;
                width: 90%;
                max-width: 500px;
                max-height: 260px;
                overflow-y: auto;
                padding: 10px;
                background-color: #fefefe;
                border-radius: 10px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                animation: fadeIn 0.5s;
                right: 10vh;
            }

            .modal-content h2 {
                margin-top: 0;
            }

            .input-field {
                margin-bottom: 15px;
            }

            .input-field input, 
            .input-field select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .input-field-row {
                display: flex;
                gap: 10px;
            }

            .input-field-row .input-field {
                flex: 1;
            }

            .close {
                color: black;
                float: right;
                opacity: 1;
                font-size: 28px;
                font-weight: bold;
                text-decoration: none;
                cursor: pointer;
            }

            button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            button:hover {
                background-color: #45a049;
            }

            @keyframes fadeIn {
                from { opacity: 0; }
                to { opacity: 1; }
            }

            @media (max-width: 768px) {
                #search-bar {
                    width: 100%;
                }

                .input-field-row {
                    flex-direction: column;
                }
            }
            .fa-search {
                color: #333;
                font-size: 16px;
                margin-left: -30px;
                cursor: pointer;
            }

            .full-width {
                clear: both;
                width: 200%;
                float: none;
            }

            .box-content > div > span {
                color: black;
            }

            .container-boxes {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
                gap: 5px;
                padding: 10px;
            }

            .box {
                width: 220px;
                height: 100px;
                border-radius: 10px;
                font-family: 'Arial', sans-serif;
                font-weight: bold;
                display: flex;
                align-items: center;
                justify-content: center;
                text-align: center;
                cursor: pointer;
                font-size: 15px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
                transition: transform 0.1s;
            }
            .box:hover{
                transform: translatey(-5px);
                box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            }


        </style>

        <script>
                    function viewClick(id) {
                    var loginName = $('#loginName' + id).val();
                            window.location = 'approvalSetting.htm?act=viewClick&id=' + loginName;
                    }
            function deleteCheck11() {
            var checkboxes = "";
                    checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
            if (checkboxes[i].checked) {
            return true;
            }
            }
            alert("Please, Select one or more record(s).");
                    return false;
            }
        </script>

    </head>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!--        <section class="content-header">
                    <h1> My DashBoard</h1>
        
                </section>-->
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="dashboard.htm?act=tendernoRightsDashboard" method="post" commandName=""
                   name='form1'  class="form-horizontal" role="form">
            <%--<input type="text" name="id" id="id" value="${list0}">--%>

            <section class="content-header" style="margin: 55px 5px 10px 5px;">
                <div class="row" style="margin-left: -25px; width: 105%;">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="">
                            <div id="exTab" class="container" style="width: 100%;">
                                <ul class="nav nav-pills nav-tabs" style="display: flex; justify-content: space-between; align-items: center;">
                                    <li style="cursor: pointer;" class="active">

                                        <a href="dashboard.htm?act=tendernoRightsDashboard">
                                            <i class="fa fa-circle-o"></i>Dashboard
                                        </a>
                                    </li>
                                      <li>
                                        <a href="dashboard.htm?act=oapTracker">
                                            <i class="fa fa-circle-o"></i>OAP Tracker
                                        </a>
                                    </li>
                                    <li>
                                        <a href="dashboard.htm?act=aocTracker">
                                            <i class="fa fa-circle-o"></i>AOC Tracker
                                        </a>
                                    </li>
                                    <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">
                                        <input type="" onclick="openModal()" id="search-bar" placeholder="Filter" style="height: 30px; width: 150px; padding: 4px 10px 4px 30px;">
                                        <i class="fa fa-search"  style="transform: translateY(-50%); cursor: pointer; margin-left: 5px;"></i>
                                    </li>
                                </ul>
                            </div>

                            <div id="searchModal" class="modal">
                                <div class="modal-content" style="box-shadow: none;">
                                    <span class="close" onclick="closeModal()">&times;</span>
                                    <h2>Search</h2>

                                    <div class="input-field-row">

                                        <div class="col-sm-6">
                                            <label class="control-label">From Date :</label>
                                            <div class='input-group date' id='datetimepicker1'>
                                                <input name="Fromdate" type="text" class="form-control form_datetime" value="" maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                            </div>
                                        </div>

                                        <div class="col-sm-6">
                                            <label class="control-label">To Date :</label>
                                            <div class='input-group date' id='datetimepicker2'>
                                                <input name="Todate" type="text" class="form-control form_datetime" value="" maxlength="30" />
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="input-field-row">

                                        <div class="input-field col-sm-12">
                                            <label for="date-filter">Filter By:</label>
                                            <select id="date-filter" name="Filter">
                                                <option value="--select--">--SELECT--</option>
                                                <option value="last-week">Last-1-Week</option>
                                                <option value="last-month">Last-1-Month</option>
                                                <option value="last-6-month">Last-6-Month</option>
                                                <option value="last-year">Last-1-Year</option>
                                            </select>
                                        </div>

                                        <div class="input-field col-sm-12">
                                            <label for="date-Department">Department</label>
                                            <select id="date-Department" name="Department">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list" items="${list0}">                                                   
                                                    <option value="${list.departmentName}">${list.departmentName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <button type="submit" class="btn btn-primary" style="width: 100px; margin-bottom: 4vh; margin-left: -3vh;" title="" name="btn" value="1" onclick="submitSearch()">Apply</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <script type="text/javascript">
                                        $(function () {
                                        $('#datetimepicker1').datetimepicker({
                                        format: 'DD-MM-YYYY',
                                        });
                                                $('#datetimepicker2').datetimepicker({
                                        format: 'DD-MM-YYYY',
                                        });
                                        });
                                        function openModal() {
                                        document.getElementById("searchModal").style.display = "block";
                                        }

                                function closeModal() {
                                document.getElementById("searchModal").style.display = "none";
                                }

                                function submitSearch() {
                                const fromDate = document.getElementsByName("Fromdate")[0].value;
                                        const toDate = document.getElementsByName("Todate")[0].value;
                                        const dateFilter = document.getElementById("date-filter").value;
                                        const dateDepartment = document.getElementById("date-Department").value;
                                        console.log("From Date:", fromDate, "To Date:", toDate, "Filter By:", dateFilter, "Department", dateDepartment);
                                        closeModal();
                                }

                                window.onclick = function(event) {
                                const modal = document.getElementById("searchModal");
                                        if (event.target == modal) {
                                modal.style.display = "none";
                                }
                                }
                            </script>

                            <div class="container-boxes">

                                <div class="box" style="background-color: #e0edf9; border-top: 3px solid #3498db;">
                                    <a href="dashboard.htm?act=totalPr&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-file-alt" style="color: #3498db;"></i>
                                            <div>
                                                <span>Total PR</span> <br>
                                                <span class="number" style="color: #3498db;">${prRaised}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #bdeec0; border-top: 3px solid #2ecc71;">
                                    <a href="dashboard.htm?act=underApproval&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-check-circle" style="color: #2ecc71;"></i>
                                            <div>
                                                <span>Under Approval</span> <br>
                                                <span class="number" style="color: #2ecc71;">${underApproval}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>



                                <div class="box" style="background-color: #bbe6ec; border-top: 3px solid #1abc9c;">
                                    <a href="dashboard.htm?act=rejectedPr&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-times-circle" style="color: #1abc9c;"></i>
                                            <div>
                                                <span>Rejected PR</span> <br>
                                                <span class="number" style="color: #1abc9c;">${rejectedPr}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #ffdea9; border-top: 3px solid #e67e22;">
                                    <a href="dashboard.htm?act=livePr&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-bolt" style="color: #e67e22;"></i>
                                            <div>
                                                <span>Live PR</span> <br>
                                                <span class="number" style="color: #e67e22;">${livePr}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div> 
                                <div class="box" style="background-color: #e3f2fd; border-top: 3px solid #2980b9;">
                                    <a href="dashboard.htm?act=tenderPendingToFloat&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-spinner" style="color: #2980b9;"></i>
                                            <div>
                                                <span>Tender Pending to Float</span> <br>
                                                <span class="number" style="color: #2980b9;">${approve}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>




                                <div class="box" style="background-color: #fde8e9; border-top: 3px solid #e74c3c;">
                                    <a href="dashboard.htm?act=assginedToBuyer&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-user-check" style="color: #e74c3c;"></i>
                                            <div>
                                                <span>Assigned to Buyer</span> <br>
                                                <span class="number" style="color: #e74c3c;">${assbuyer}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #fef9e7; border-top: 3px solid #f39c12;">
                                    <a href="dashboard.htm?act=pendingToAssign&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-hourglass-half" style="color: #f39c12;"></i>
                                            <div>
                                                <span>Pending To Assign</span> <br>
                                                <span class="number" style="color: #f39c12;">${pendassign}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #f0d9ff; border-top: 3px solid #9b59b6;">
                                    <a href="dashboard.htm?act=tenderCreated&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-folder-plus" style="color: #9b59b6;"></i>
                                            <div>
                                                <span>Tender Created</span> <br>
                                                <span class="number" style="color: #9b59b6;">${tendercount}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #ffd3b6; border-top: 3px solid #e67e22;">
                                    <a href="dashboard.htm?act=tenderClosed&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-lock" style="color: #e67e22;"></i>
                                            <div>
                                                <span>Tender Closed</span> <br>
                                                <span class="number" style="color: #e67e22;">${tenderclosed}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>

                                <div class="box" style="background-color: #d4f4dd; border-top: 3px solid #2ecc71;">
                                    <a href="dashboard.htm?act=liveTender&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}" style="text-decoration: none; color: inherit;">
                                        <div class="box-content">
                                            <i class="fas fa-play-circle" style="color: #2ecc71;"></i>
                                            <div>
                                                <span>Live Tender</span> <br>
                                                <span class="number" style="color: #2ecc71;">${tenderLive}</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>

                            <div class="container-graphs">
                                <div class="chart-box">
                                    <div class="chart-container">
                                        <canvas id="barChart1"></canvas>
                                    </div>
                                </div>

                                <div class="chart-box">
                                    <div class="chart-container">
                                        <canvas id="barChart3"></canvas>
                                    </div>
                                </div>
                            </div>

                            <div class="container-graphs full-width">

                                <div class="chart-box">
                                    <div class="chart-container ">
                                        <canvas id="barChart4"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <script>
                            var barChartData1 = {
                            labels: ['${prmonthName1}', '${prmonthName2}', '${prmonthName3}', '${prmonthName4}', '${prmonthName5}', '${prmonthName6}', '${prmonthName7}', '${prmonthName8}', '${prmonthName9}', '${prmonthName10}', '${prmonthName11}', '${prmonthName12}'],
                                    datasets: [{
                                    barThickness: 30,
                                            label: 'MONTH WISE PR DATA',
                                            backgroundColor: [
                                                    "rgba(173, 216, 230, 0.6)", // Light Blue
                                                    "rgba(144, 238, 144, 0.6)", // Light Green
                                                    "rgba(255, 182, 193, 0.6)", // Light Pink
                                                    "rgba(255, 160, 122, 0.6)", // Light Coral
                                                    "rgba(221, 160, 221, 0.6)", // Light Purple
                                                    "rgba(240, 230, 140, 0.6)", // Light Khaki
                                                    "rgba(175, 238, 238, 0.6)", // Light Cyan
                                                    "rgba(135, 206, 250, 0.6)", // Light Sky Blue
                                                    "rgba(245, 222, 179, 0.6)", // Wheat
                                                    "rgba(152, 251, 152, 0.6)", // Pale Green
                                                    "rgba(216, 191, 216, 0.6)", // Thistle
                                                    "rgba(250, 235, 215, 0.6)"  // Antique White
                                            ],
                                            borderColor: [
                                                    "rgba(173, 216, 230, 1)", // Light Blue
                                                    "rgba(144, 238, 144, 1)", // Light Green
                                                    "rgba(255, 182, 193, 1)", // Light Pink
                                                    "rgba(255, 160, 122, 1)", // Light Coral
                                                    "rgba(221, 160, 221, 1)", // Light Purple
                                                    "rgba(240, 230, 140, 1)", // Light Khaki
                                                    "rgba(175, 238, 238, 1)", // Light Cyan
                                                    "rgba(135, 206, 250, 1)", // Light Sky Blue
                                                    "rgba(245, 222, 179, 1)", // Wheat
                                                    "rgba(152, 251, 152, 1)", // Pale Green
                                                    "rgba(216, 191, 216, 1)", // Thistle
                                                    "rgba(250, 235, 215, 1)"  // Antique White
                                            ],
                                            borderWidth: 1,
                                            data: [${prnumberOfValue1}, ${prnumberOfValue2}, ${prnumberOfValue3}, ${prnumberOfValue4}, ${prnumberOfValue5}, ${prnumberOfValue6}, ${prnumberOfValue7}, ${prnumberOfValue8}, ${prnumberOfValue9}, ${prnumberOfValue10}, ${prnumberOfValue11}, ${prnumberOfValue12}],
                                    }]
                            };
                                    var ctxBar1 = document.getElementById('barChart1').getContext('2d');
                                    var myBarChart1 = new Chart(ctxBar1, {
                                    type: 'bar',
                                            data: barChartData1,
                                            options: {
                                            responsive: true,
                                                    maintainAspectRatio: false,
                                                    plugins: {
                                                    legend: {
                                                    display: true,
                                                            labels: {
                                                            generateLabels: function(chart) {
                                                            return chart.data.datasets.map(function(dataset, i) {
                                                            return {
                                                            text: dataset.label,
                                                                    fillStyle: 'transparent',
                                                                    strokeStyle: 'transparent',
                                                                    datasetIndex: i
                                                            };
                                                            });
                                                            }
                                                            }
                                                    }
                                                    },
                                                    onClick: function (event, elements) {
                                                    if (elements.length > 0) {
                                                    var clickedElementIndex = elements[0].index
                                                            var links = [
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName1}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName2}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName3}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName4}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName5}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName6}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName7}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName8}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName9}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName10}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName11}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWisePr&label=${prmonthName12}&Filter=${Filter}&Department=${Department}"
                                                            ];
                                                            if (links[clickedElementIndex]) {
                                                    window.location.href = links[clickedElementIndex];
                                                    } else {
                                                    console.error("No link found for the clicked element.");
                                                    }
                                                    }
                                                    }
                                            }
                                    });
                                    var barChartData3 = {
                                    labels: ['${monthName1}', '${monthName2}', '${monthName3}', '${monthName4}', '${monthName5}', '${monthName6}', '${monthName7}', '${monthName8}', '${monthName9}', '${monthName10}', '${monthName11}', '${monthName12}'],
                                            datasets: [{
                                            barThickness: 30,
                                                    label: 'MONTH WISE TENDER DATA',
                                                    backgroundColor: [
                                                            "rgba(135, 206, 235, 0.6)", // Light Steel Blue
                                                            "rgba(173, 216, 230, 0.6)", // Light Blue
                                                            "rgba(240, 128, 128, 0.6)", // Light Salmon
                                                            "rgba(210, 180, 140, 0.6)", // Tan
                                                            "rgba(176, 224, 230, 0.6)", // Powder Blue
                                                            "rgba(255, 228, 181, 0.6)", // Moccasin
                                                            "rgba(238, 232, 170, 0.6)", // Pale Goldenrod
                                                            "rgba(255, 239, 213, 0.6)", // Papaya Whip
                                                            "rgba(152, 251, 152, 0.6)", // Pale Green
                                                            "rgba(216, 191, 216, 0.6)", // Thistle
                                                            "rgba(240, 248, 255, 0.6)", // Alice Blue
                                                            "rgba(211, 211, 211, 0.6)"  // Light Gray
                                                    ],
                                                    borderColor: [
                                                            "rgba(135, 206, 235, 1)", // Light Steel Blue
                                                            "rgba(173, 216, 230, 1)", // Light Blue
                                                            "rgba(240, 128, 128, 1)", // Light Salmon
                                                            "rgba(210, 180, 140, 1)", // Tan
                                                            "rgba(176, 224, 230, 1)", // Powder Blue
                                                            "rgba(255, 228, 181, 1)", // Moccasin
                                                            "rgba(238, 232, 170, 1)", // Pale Goldenrod
                                                            "rgba(255, 239, 213, 1)", // Papaya Whip
                                                            "rgba(152, 251, 152, 1)", // Pale Green
                                                            "rgba(216, 191, 216, 1)", // Thistle
                                                            "rgba(240, 248, 255, 1)", // Alice Blue
                                                            "rgba(211, 211, 211, 1)"  // Light Gray
                                                    ],
                                                    borderWidth: 1,
                                                    data: [${numberOfValue1}, ${numberOfValue2}, ${numberOfValue3}, ${numberOfValue4}, ${numberOfValue5}, ${numberOfValue6}, ${numberOfValue7}, ${numberOfValue8}, ${numberOfValue9}, ${numberOfValue10}, ${numberOfValue11}, ${numberOfValue12}],
                                            }]
                                    };
                                    var ctxBar3 = document.getElementById('barChart3').getContext('2d');
                                    var myBarChart3 = new Chart(ctxBar3, {
                                    type: 'bar',
                                            data: barChartData3,
                                            options: {
                                            responsive: true,
                                                    maintainAspectRatio: false,
                                                    onClick: function(event, elements) {
                                                    if (elements.length > 0) {
                                                    var clickedElementIndex = elements[0].index;
                                                            var links = [
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName1}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName2}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName3}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName4}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName5}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName6}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName7}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName8}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName9}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName10}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName11}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=monthWiseTender&label=${monthName12}&Filter=${Filter}&Department=${Department}"
                                                            ];
                                                            if (links[clickedElementIndex]) {
                                                    window.location.href = links[clickedElementIndex];
                                                    } else {
                                                    console.error("No link found for the clicked element.");
                                                    }
                                                    }
                                                    },
                                                    plugins: {
                                                    legend: {
                                                    display: true,
                                                            labels: {
                                                            generateLabels: function(chart){
                                                            return chart.data.datasets.map(function(dataset, i){
                                                            return {
                                                            text: dataset.label,
                                                                    fillStyle: 'transparent',
                                                                    strokeStyle: 'transparent',
                                                                    datasetIndex: i
                                                            };
                                                            });
                                                            }
                                                            }
                                                    }
                                                    }
                                            }
                                    });
                                    var ctxBar4 = document.getElementById('barChart4').getContext('2d');
                                    // Gradient setup
                                    const gradient1 = ctxBar4.createLinearGradient(0, 0, 0, 600);
                                    gradient1.addColorStop(0, 'rgba(255, 99, 132, 0.8)');
                                    gradient1.addColorStop(1, 'rgba(255, 99, 132, 0.2)');
                                    const gradient2 = ctxBar4.createLinearGradient(0, 0, 0, 600);
                                    gradient2.addColorStop(0, 'rgba(54, 162, 235, 0.8)');
                                    gradient2.addColorStop(1, 'rgba(54, 162, 235, 0.2)');
                                    const gradient3 = ctxBar4.createLinearGradient(0, 0, 0, 600);
                                    gradient3.addColorStop(0, 'rgba(255, 206, 86, 0.8)');
                                    gradient3.addColorStop(1, 'rgba(255, 206, 86, 0.2)');
                                    var barChartData4 = {
                                    labels: ['${firstElement1_1}', '${secondElement1_1}', '${thirdElement1_1}', '${fourthElement1_1}', '${fifthElement1_1}', '${sixthElement1_1}', '${seventhElement1_1}', '${eighthElement1_1}', '${ninthElement1_1}', '${tenthElement1_1}'],
                                            datasets: [
                                            {
                                            label: 'Total Tender',
                                                    data: [${firstElement1_2}, ${secondElement1_2}, ${thirdElement1_2}, ${fourthElement1_2}, ${fifthElement1_2}, ${sixthElement1_2}, ${seventhElement1_2}, ${eighthElement1_2}, ${ninthElement1_2}, ${tenthElement1_2}],
                                                    backgroundColor: gradient1,
                                                    borderColor: 'rgba(255, 99, 132, 1)',
                                                    borderWidth: 1,
                                                    borderRadius: 10
                                            },
                                            {
                                            label: 'Live Tender',
                                                    data: [${firstElement1_3}, ${secondElement1_3}, ${thirdElement1_3}, ${fourthElement1_3}, ${fifthElement1_3}, ${sixthElement1_3}, ${seventhElement1_3}, ${eighthElement1_3}, ${ninthElement1_3}, ${tenthElement1_3}],
                                                    backgroundColor: gradient2,
                                                    borderColor: 'rgba(54, 162, 235, 1)',
                                                    borderWidth: 1,
                                                    borderRadius: 10
                                            },
                                            {
                                            label: 'Close Tender',
                                                    data: [${firstElement1_4}, ${secondElement1_4}, ${thirdElement1_4}, ${fourthElement1_4}, ${fifthElement1_4}, ${sixthElement1_4}, ${seventhElement1_4}, ${eighthElement1_4},${ninthElement1_4}, ${tenthElement1_4} ],
                                                    backgroundColor: gradient3,
                                                    borderColor: 'rgba(255, 206, 86, 1)',
                                                    borderWidth: 1,
                                                    borderRadius: 10
                                            }
                                            ]
                                    };
                                    
                                    
                                    
                                    var myBarChart4 = new Chart(ctxBar4, {
                                    type: 'bar',
                                            data: barChartData4,
                                            options: {
                                            responsive: true,
                                                    maintainAspectRatio: false,
                                                    onClick: function (event, elements) {
                                                    if (elements.length > 0) {
                                                    var clickedElementIndex = elements[0].index;
                                                            var datasetIndex = elements[0].datasetIndex;
                                                            var links = {
                                                            0: [
                                                                    "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                    "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}"
                                                            ],
                                                                    1: [
                                                                            "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}"
                                                                    ],
                                                                    2: [
                                                                            "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}",
                                                                            "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=${Filter}&Department=${Department}"
                                                                    ]
                                                            };
                                                            if (links[datasetIndex] && links[datasetIndex][clickedElementIndex]) {
                                                    window.location.href = links[datasetIndex][clickedElementIndex];
                                                    } else {
                                                    console.error("No link found for the clicked element.");
                                                    }
                                                    }
                                                    }
                                            ,
                                                    plugins: {
                                                    legend: {
                                                    display: true,
                                                            position: 'top',
                                                            labels: {
                                                            color: '#333',
                                                                    font: {
                                                                    size: 14,
                                                                            weight: 'bold'
                                                                    }
                                                            },
                                                    },
                                                            tooltip: {
                                                            backgroundColor: 'rgba(0,0,0,0.7)',
                                                                    titleFont: { size: 14 },
                                                                    bodyFont: { size: 13 },
                                                                    padding: 10,
                                                                    cornerRadius: 8
                                                            }
                                                    },
                                                    scales: {
                                                    x: {
                                                    ticks: { color: '#555', font: { size: 12, weight: 'bold' } },
                                                            grid: { display: false }
                                                    },
                                                            y: {
                                                            ticks: { color: '#555', font: { size: 12, weight: 'bold' }, callback: (value) => value + ' Tenders' },
                                                                    grid: { color: '#ddd', lineWidth: 0.5 }
                                                            }
                                                    }
                                            }
                                    });
                                                            
                        </script>

                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                    </div>
                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
                <!--</div>-->
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

</html>                       
