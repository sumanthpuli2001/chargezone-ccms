<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title>DashBoard</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
                        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <style>
            .dashboard-header {
                margin: -15px 15px 15px 15px;
                padding: 15px 20px;
                background-color: #ebebe4;
                border-radius: 10px 10px 0px 0px;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1);
                border-bottom: 2px solid #4e73df;
            }

            .header-row {
                display: flex;
                justify-content: space-between;
                align-items: center;
                flex-wrap: wrap;
            }

            .dashboard-title-section .dashboard-title {
                font-size: 2.2vh;
                font-weight: 600;
                color: #2c3e50;
            }

            .filter-button-section {
                position: relative;
                display: inline-block;
            }

            .filter-btn {
                background-color: #007bff;
                border: none;
                color: white;
                font-weight: 500;
                padding: 8px 18px;
                border-radius: 8px;
                transition: background-color 0.3s ease;
            }

            .filter-btn:hover {
                background-color: #0056b3;
                cursor: pointer;
            }

            .filter-popup {
                position: absolute;
                top: 110%;
                right: 0;
                width: 450px;
                background-color: #fff;
                border: 1px solid #ccc;
                border-radius: 10px;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.2);
                display: none;
                z-index: 999;
            }

            .filter-popup.show {
                display: block;
            }

            .popup-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                font-weight: 600;
                font-size: 1.1rem;
                margin-bottom: 15px;
            }

            .close-popup-btn {
                font-size: 1.2rem;
                cursor: pointer;
            }

            .popup-content {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 50px;
                margin-bottom: 16px;
            }

            .popup-content .form-group {
                display: flex;
                flex-direction: column;
            }

            .popup-content label {
                margin-bottom: 5px;
                font-weight: 500;
                font-size: 0.95rem;
            }

            .popup-footer {
                display: flex;
                justify-content: flex-end;
                gap: 10px;
            }

            .btn-apply, .btn-cancel {
                padding: 8px 16px;
                border: none;
                border-radius: 6px;
                font-weight: 500;
                font-size: 0.9rem;
                cursor: pointer;
            }

            .btn-apply {
                background-color: #00bcd4;
                color: white;
            }

            .btn-apply:hover {
                background-color: #0097a7;
            }

            .btn-cancel {
                background-color: #e0e0e0;
                color: #333;
            }

            .btn-cancel:hover {
                background-color: #ccc;
            }




            // Boxes and Chart  Starts here


            .summary-cards {
                margin: 20px 10px;
            }

            .card-grid {
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
                grid-template-rows: auto auto;
                gap: 10px;
            }

            .card-box {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background: #f8f9fc;
                border-left: 4px solid #4e73df;
                padding: 16px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0,0,0,0.06);
                transition: 0.3s ease;
            }

            .card-box:hover {
                transform: translateY(-3px);
                box-shadow: 0 6px 15px rgba(0,0,0,0.1);
            }

            .card-content {
                display: flex;
                flex-direction: column;
            }

            .card-title {
                font-size: 0.75rem;
                font-weight: 700;
                color: #4e73df;
                text-transform: uppercase;
                margin-bottom: 4px;
            }

            .card-value {
                font-size: 1.25rem;
                font-weight: 800;
                color: #343a40;
            }

            .card-icon {
                font-size: 1.5rem;
                color: #dddfeb;
            }



            .content-charts {
                margin: 10px 0px;
            }

            .charts-grid {
                display: grid;
                grid-template-columns: 2fr 1fr;
                gap: 9px;
                flex-wrap: wrap;
            }

            .chart-placeholder {
                background-color: #ffffff;
                padding: 20px;
                border-radius: 12px;
                box-shadow: 0 0 15px rgba(0,0,0,0.05);
                position: relative;
                overflow: hidden;
            }

            .chart-header {
                display: flex;
                gap: 15px;
                font-size: 1rem;
                font-weight: 600;
                color: #2c3e50;
                border-bottom: 2px solid #dee2e6;
                padding-bottom: 8px;
                margin-bottom: 20px;
            }

            .single-heading {
                justify-content: flex-start;
            }

            .tablink {
                cursor: pointer;
                padding: 5px 10px;
                color: #6c757d;
                font-weight: 600;
                border-radius: 4px;
                transition: all 0.3s ease;
            }

            .tablink.active {
                background-color: #4e73df;
                color: white;
            }

            .tab-content-wrapper {
                position: relative;
                height: 250px;
                overflow: hidden;
            }

            .tabcontent {
                position: absolute;
                width: 100%;
                height: 100%;
                top: 0;
                left: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
                transition: left 0.5s ease-in-out;
                background-color: #f8f9fc;
                font-weight: 600;
                color: #555;
            }

            .tabcontent.active-tab {
                left: 0;
            }


        </style>
    </head>

    <div class="content-wrapper">
        <form:form action="dashboard.htm?act=tenderDashboard" method="post" commandName=""
                   name="form1" class="form-horizontal" role="form">



            <section class="content-header dashboard-header" style="margin:"65px 15px 0px 10px">
                <div class="header-row">
                    <div class="dashboard-title-section">
                        <span class="dashboard-title"><i class="fa fa-tachometer-alt"></i> Dashboard</span>
                    </div>

                    <div class="filter-button-section">
                        <span id="filterBtn" class="filter-btn">
                            <i class="fa fa-filter me-1"></i> Filter
                        </span>

                        <div class="filter-popup" id="filterPopup">
                            <div class="popup-header">
                                <span class="popup-title">Search</span>
                                <span class="close-popup-btn">&times;</span>
                            </div>

                            <div class="popup-content">

                                <div>
                                    <div class="form-group">
                                        <label>From Date :</label>
                                        <input type="date" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Filter By:</label>
                                        <select class="form-control">
                                            <option>--SELECT--</option>
                                            <option>Status</option>
                                            <option>Type</option>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <div class="form-group">
                                        <label>To Date :</label>
                                        <input type="date" class="form-control">
                                    </div>


                                    <div class="form-group">
                                        <label>Department:</label>
                                        <select class="form-control">
                                            <option>--SELECT--</option>
                                            <option>HR</option>
                                            <option>IT</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="popup-footer">
                                <button type="submit" class="btn btn-apply">Apply</button>
                                <button type="button" class="btn btn-cancel close-popup-btn">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>




            <section class="dashboard-header">

                <div class="card-grid">


                    <div class="card-box" style="background: #e0edf9;">
                        <div class="card-content">
                            <div class="card-title">Total PR</div>
                            <div class="card-value">$215,000</div>
                        </div>
                        <i class="fa fa-dollar-sign card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #bdeec0;">
                        <div class="card-content">
                            <div class="card-title">Under Approval</div>
                            <div class="card-value">50%</div>
                        </div>
                        <i class="fa fa-tasks card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #ffdea9;">
                        <div class="card-content">
                            <div class="card-title">Live PR</div>
                            <div class="card-value">18</div>
                        </div>
                        <i class="fa fa-bell card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #bbe6ec;">
                        <div class="card-content">
                            <div class="card-title">Rejected PR</div>
                            <div class="card-value">1,024</div>
                        </div>
                        <i class="fa fa-users card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #fef9e7;">
                        <div class="card-content">
                            <div class="card-title">Tender Pending To Float</div>
                            <div class="card-value">76</div>
                        </div>
                        <i class="fa fa-envelope card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #fde8e9;">
                        <div class="card-content">
                            <div class="card-title">Pending To assign</div>
                            <div class="card-value">34</div>
                        </div>
                        <i class="fa fa-check card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #f0d9ff;">
                        <div class="card-content">
                            <div class="card-title">Assign To Buyer</div>
                            <div class="card-value">2</div>
                        </div>
                        <i class="fa fa-shield-alt card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #d4f4dd;">
                        <div class="card-content">
                            <div class="card-title">Tender Created</div>
                            <div class="card-value">12</div>
                        </div>
                        <i class="fa fa-database card-icon"></i>
                    </div>

                    <div class="card-box"  style="background: #ffd3b6;">
                        <div class="card-content">
                            <div class="card-title">Live Tender</div>
                            <div class="card-value">99.9%</div>
                        </div>
                        <i class="fa fa-clock card-icon"></i>
                    </div>
                     <div class="card-box"  style="background: #e0edf9;">
                    <div class="card-content">
                        <div class="card-title">Tender Closed</div>
                        <div class="card-value">$40,000</div>
                    </div>
                    <i class="fa fa-calendar card-icon"></i>
                </div>
                </div>
               
                <div class="content-charts" >
                    <div class="charts-grid">
                        <!-- Chart 1 -->
                        <div class="chart-placeholder">
                            <div class="chart-header single-heading">Earnings Overview</div>
                                                                    

                            <div class="chart-body">
                                <canvas id="barChart4"></canvas>
                            </div>
                        </div>

                        <!-- Chart 2 with PR and Tender tabs -->
                        <div class="chart-placeholder">
                            <div class="chart-header">
                                <span class="tablink active" onclick="openTab(event, 'prData')">PR Data</span>
                                <span class="tablink" onclick="openTab(event, 'tenderData')">Tender Data</span>
                            </div>
                            <div class="tab-content-wrapper">
                                <div id="prData" class="tabcontent active-tab">PR Data Placeholder</div>
                                <div id="tenderData" class="tabcontent">Tender Data Placeholder</div>
                            </div>
                        </div>
                    </div>



                </div>

            </section>

        </form:form>
    </div>

    <script>
        const filterBtn = document.getElementById("filterBtn");
                const filterPopup = document.getElementById("filterPopup");
                const closePopupBtns = document.querySelectorAll(".close-popup-btn");
                let
        isPopupForcedOpen = false;
        filterBtn.addEventListener("click", function (e) {
            e.stopPropagation();
            filterPopup.classList.toggle("show");
            isPopupForcedOpen = filterPopup.classList.contains("show");
        });
        filterPopup.addEventListener("mouseenter", function () {
            filterPopup.classList.add("show");
        });
        document.addEventListener("click", function (e) {
            if (!filterPopup.contains(e.target) && !filterBtn.contains(e.target)) {
                filterPopup.classList.remove("show");
            }
        });
        for (var i = 0; i < closePopupBtns.length; i++) {
            closePopupBtns[i].addEventListener("click", function () {
                filterPopup.classList.remove("show");
            });
        }



        function openTab(evt, tabName) {
            var i, tabcontent, tablinks;

            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].classList.remove("active-tab");
            }

            tablinks = document.getElementsByClassName("tablink");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].classList.remove("active");
            }

            document.getElementById(tabName).classList.add("active-tab");
            evt.currentTarget.classList.add("active");
        }

    </script>

    <script>
        
        
        
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

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
