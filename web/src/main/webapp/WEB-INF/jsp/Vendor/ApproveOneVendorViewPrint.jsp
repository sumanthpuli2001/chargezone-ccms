<%-- 
    Document   : ApproveOneVendorViewPrint
    Created on : 18 Nov, 2024, 5:04:42 PM
    Author     : Bulwarks-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>	
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Print Page</title>



        <style>



            /* Main container */
            .main-container {
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
            }

            /* Flex container for top row */
            .flex-row {
                display: flex;
                justify-content: space-between;
                gap: 20px;

            }

            /* Styling for left and right tables */
            .flex-table {
                flex: 1;
                border-collapse: collapse;
                width: 100%;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            .table-title {
                font-size: 15px;
                font-weight: bold;
                padding: 12px;

                text-align: center;
                background-color: #e0e7ff;
            }

            /* Table headers */
            th, td {
                padding: 12px;
                text-align: left;
                border-bottom: 1px solid #dddddd;
            }

            /* Alternate row colors */
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            tr:hover {
                background-color: #e9f5ff;
            }

            /* Styling for bottom table */
            .bottom-table {
                width: 100%;
                border-collapse: collapse;              
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            /* Link styling */
            a {
                color: #007BFF;
                text-decoration: none;
                font-weight: bold;
            }

            a:hover {
                text-decoration: underline;
            }

            /* Table cell styling */
            td:first-child {

                width: 35%;
                color: #333;
            }


            /* Center the Print button */
        .button-container {
            text-align: center; /* Center the button horizontally */
            margin-top: 20px;   /* Optional: add space above the button */
        }

        .print-button {
            border-radius: 2vh;
            font-size: 2vh;
    font-weight: 700;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-bottom: 2rem;
        }

        .print-button:hover {
            background-color: #45a049;
        }
        </style>



    </head>
    <body>
        <script>
            function printPage() {
                var content = document.getElementById("content-to-print").innerHTML;
                var originalContent = document.body.innerHTML;

                // Set the content to print
                document.body.innerHTML = content;

                // Print the page
                window.print();

                // Restore the original content after printing
                document.body.innerHTML = originalContent;
            }
        </script>
<div class="button-container">
        <button class="print-button" onclick="printPage()">Print</button>
    </div>
        <div id="content-to-print">
            <c:forEach var="list" items="${list}" varStatus="status">
                <input type="hidden" id="id" name="id" value="${list.id}">
                <input type="hidden" id="id1" name="id1" value="${list.id}">

                <div class="main-container">
                    <!-- Top row with Company Information and Policy File -->
                    <div class="flex-row">
                        <!-- Company Information Table (Left Side) -->
                        <table class="flex-table">
                            <tr class="table-title">
                                <td colspan="2">Company Information</td>
                            </tr>
                            <tr>
                                <td>Company Name:</td>
                                <td>${list.companyName}</td>
                            </tr>
                        </table>

                        <!-- Policy File Table (Right Side) -->
                        <table class="flex-table">
                            <tr class="table-title">
                                <td colspan="2">Policy File</td>
                            </tr>
                            <tr>
                                <td>Policy File:</td>
                                <td>
                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.policy1File}&id=${list.id}">
                                        ${list.policy1File}
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <!-- Bottom section with Type of Concern, Vendors, and Location Details -->

                    <div class="flex-row">
                        <table class="bottom-table">
                            <tr class="table-title">
                                <td colspan="2">Type of Concern & Vendor Details</td>
                            </tr>
                            <tr>
                                <td>Type Of Concern:</td>
                                <td>${list.typeOfConcern}</td>
                            </tr>
                            <tr>
                                <td>Type Of Vendors:</td>
                                <td>
                                    <c:if test="${list.good == 'on'}">Goods<br></c:if>
                                    <c:if test="${list.service == 'on'}">Service<br></c:if>
                                    <c:if test="${list.general_traders == 'on'}">General Traders<br></c:if>
                                    <c:if test="${list.contract == 'on'}">Contract<br></c:if>
                                    <c:if test="${list.electricalService == 'electrical'}">Electrical<br></c:if>
                                    <c:if test="${list.electricalService == 'service'}">Service<br></c:if>
                                    </td>
                                </tr>
                            </table>

                            <!-- Location Details Table -->
                            <table class="bottom-table">
                                <tr class="table-title">
                                    <td colspan="2">Location Details</td>
                                </tr>
                                <tr>
                                    <td>Country:</td>
                                    <td>${list.officeCountry}</td>
                            </tr>
                            <tr>
                                <td>State:</td>
                                <td>${list.officeState}</td>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td>${list.officeCity}</td>
                            </tr>
                        </table>
                    </div>
                    <!-- External Provider Details Table -->


                    <div class="flex-row">
                        <table class="bottom-table">
                            <tr class="table-title">
                                <td colspan="2">External Provider Details</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>Office</td>
                            </tr>
                            <tr>
                                <td>House No:</td>
                                <td>${list.officeAddressLine1}</td>
                            </tr>
                            <tr>
                                <td>Street:</td>
                                <td>${list.officeAddressLine2}</td>
                            </tr>
                            <tr>
                                <td>District:</td>
                                <td>${list.officeAddressLine3}</td>
                            </tr>
                            <tr>
                                <td>Pin:</td>
                                <td>${list.officePin}</td>
                            </tr>
                            <tr>
                                <td>Year of Establishment:</td>
                                <td>${list.establishment}</td>
                            </tr>
                            <tr>
                                <td>Company Website:</td>
                                <td>${list.officeWebsite}</td>
                            </tr>
                            <tr>
                                <td>Primary Mobile Number:</td>
                                <td>${list.officeTelephone}</td>
                            </tr>
                            
                            <tr>
                                <td>Secondary Mobile Number:</td>
                                <td>${list.secoundMobile}</td>
                            </tr>
                          
                        </table>

                       

                    </div>

                    <!-- External Provider Contacts Table -->
                    <table class="bottom-table" id="table_1">
                        <thead>
                            <tr class="table-title">
                                <th>Vendor Contacts</th>
                                <th>Name</th>
                                <th>Job Title</th>
                               
                                <th>Phone No.</th>
                                 <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Sales/Commercial Contact(s)</td>
                                <td>${list.sales_name}</td>
                                <td>${list.sales_job}</td>
                                <td>${list.sales_phone}</td>
                                <td>${list.saleEmail}</td>
                            </tr>
                            <tr>
                                <td>Technical Contact(s)</td>
                                <td>${list.technical_name}</td>
                                <td>${list.technical_job}</td>
                                <td>${list.technical_phone}</td>
                                 <td>${list.technicalContactEmail}</td>
                            </tr>
                            <tr>
                                <td>Quality/Health & Safety Contact(s)</td>
                                <td>${list.quality_name}</td>
                                <td>${list.quality_job}</td>
                                <td>${list.quality_phone}</td>
                                 <td>${list.qualityEmail}</td>
                            </tr>
                        </tbody>
                    </table>

                    <!-- Company Registration Details Table -->
                    <table class="bottom-table" id="table_1">
                        <tr class="table-title">
                            <td colspan="3">Company Registration Details</td>
                        </tr>
                        <tbody>
                            <tr>
                                <td>GST No.</td>
                                <td>${list.gstinNo}</td>
                                <td>
                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.gstinFile}&id=${list.id}">${list.gstinFile}</a>
                                </td>
                            </tr>
                            <tr>
                                <td>PAN No.</td>
                                <td>${list.panNo}</td>
                                <td>
                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.panFile}&id=${list.id}">${list.panFile}</a>
                                </td>
                            </tr>
                            <tr>
                                <td>MSME</td>
                                <td>${list.service_tax}</td>
                                <td>
                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.service_file}&id=${list.id}">${list.service_file}</a>
                                </td>
                            </tr>
                            <tr>
                                <td>IEC</td>
                                <td>${list.ecc_no}</td>
                                <td>
                                    <a href="vendorInformation.htm?act=downloadFileAprrove1&amp;fileName=${list.ecc_file}&id=${list.id}">${list.ecc_file}</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>


                </div>
            </c:forEach>
        </div>

    </body>
</html>
