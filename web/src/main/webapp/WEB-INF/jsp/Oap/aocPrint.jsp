
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AOC Details Print</title>
        <style>

            .nav-tabs-custom {
                border-top: 0px solid #00a65a;

            }
            .table-bordered {
                border-collapse: collapse;
                border: 0px solid #000 !important; 
            }
            /* Main container */
            .main-container {

                margin: 20px auto;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
            }

            /* Flex container for top row */
            .flex-row {
                display: flex;
                justify-content: space-between;
                gap: 20px;
                margin-bottom: 20px;
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
                font-size: 18px;
                font-weight: bold;
                padding: 12px;

                text-align: center;
                background-color: #e0e7ff;
            }
            #table_2 {
                border-radius: 0 !important;
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
                margin-top: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                overflow: hidden;
                background-color: #ffffff;
            }

            /* Link styling */
            a {
                /*color: #007BFF;*/
                text-decoration: none;
                /*font-weight: bold;*/
            }

            a:hover {
                /*text-decoration: underline;*/
            }

            /* Table cell styling */
            td:first-child {
                /*font-weight: bold;*/
                width: 35%;
                color: #333;
            }
        </style>
        <style>
            p {
                word-wrap: break-word; /* Allows words to break if necessary */
                max-width: 100ch; /* Restricts the paragraph to 20 characters wide */
            }
            .break-after-20 {
                word-wrap: break-word;
                overflow-wrap: break-word;
                max-width: 50ch; /* Approximately 20 characters per line */
            }

        </style>
        <style>
@media print {

  /* PAGE SETUP */
  @page {
    size: A4;
    margin: 10mm;
  }

  html, body {
    margin: 0 !important;
    padding: 0 !important;
    -webkit-print-color-adjust: exact !important;
    print-color-adjust: exact !important;
  }

  /* REMOVE SIDEBAR / SCREEN ELEMENTS */
  .sidebar,
  .toggle-sidebar,
  .no-print {
    display: none !important;
  }

  /* REMOVE LEFT EMPTY SPACE (BOOTSTRAP FIX) */
  main,
  .main-content,
  .container,
  .container-fluid,
  .row,
  [class^="col-"] {
    margin-left: 0 !important;
    padding-left: 0 !important;
    max-width: 100% !important;
    width: 100% !important;
  }

  /* KILL FLEX FOR PRINT */
  .flex-row {
    display: block !important;
  }

  /* CONTAINERS FLOW NATURALLY */
  .main-container,
  .flex-table,
  .bottom-table {
    width: 100% !important;
    height: auto !important;
    overflow: visible !important;
  }

  /* TABLE PAGINATION */
  table {
    width: 100% !important;
    border-collapse: collapse !important;
    page-break-after: auto;
    border-top: 1px solid #000 !important;
  }

  thead {
    display: table-header-group;
    border-top: 1px solid #000 !important;
  }

  tfoot {
    display: table-footer-group;
    border-top: 1px solid #000 !important;
  }

  tr {
    page-break-inside: avoid !important;
    break-inside: avoid !important;
  }

  th, td {
    border: 1px solid #000 !important;
    color: #000 !important;
    border-top: 1px solid #000 !important;
  }

  /* CLEAN PRINT */
  * {
    box-shadow: none !important;
    overflow: visible !important;
  }

  /* KEEP <a> TEXT (NO JS NEEDED) */

 a {
   pointer-events: none;
   text-decoration: none !important;
   color: black !important;
   border-bottom: none !important;
 }

 .gradient-text {
   background: none !important;
   -webkit-background-clip: initial !important;
   -webkit-text-fill-color: black !important;
   color: black !important;
   border-bottom: none !important;
 }
 
 .flex-table th, .flex-table td{
     border: 1px solid black !important;
 }
 
}
#table_1 td {
    height: auto !important;
}

#table_1 img {
    width: auto;
    display: block;
    margin: 0 auto;
}

#table_1 td:last-child {
    font-size: 16px !important;
    padding: 6px !important;
}
 
</style>
<script>
(function () {
  let storedLinks = [];

  window.onbeforeprint = function () {
    storedLinks = [];
    document.querySelectorAll('a').forEach(a => {
      const href = a.getAttribute('href');
      if (href) {
        storedLinks.push({ el: a, href });
        a.removeAttribute('href');
      }
    });
  };

  window.onafterprint = function () {
    storedLinks.forEach(item => {
      item.el.setAttribute('href', item.href);
    });
  };
})();
</script>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action=".htm?act=" commandName="" method="post">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2  d-print-none">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0  no-print">AOC Details print</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3 no-print">Back</a>

                            <a href="" onclick="window.print();" class="btn btn theme-btn no-print" style="background-color: #4CAF50; border-color: #4CAF50;" >
                                <i class="fa fa-print"></i>&nbsp;&nbsp;Print
                            </a>  

                        </div>
                    </div>

                    <hr>

                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                    <input type="hidden" name="id" value="${id}">
                    <input type="hidden" name="aocFormId" value="${list55.id}">

                    <table class="table table-bordered" id="table_1" style="width: 100%; border-collapse: collapse;">
                        <tbody>
                            <tr>
                                <td colspan="3" style="height: 40px; text-align: center; vertical-align: middle;">
                                    <img src="StorageYard/Images/logo.png" style="max-height: 30px;">
                                </td>

                                <td colspan="4" style="text-align: center; vertical-align: middle; padding: 6px; font-weight: bold; font-size: 16px;">
                                    Acquired Order Checklist
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <table  class="flex-table" id="table_2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        

                                                        <tr class="table-title">
                                                            <td colspan="4" style="text-align: center; background-color: #e0e7ff; font-size: 12px;padding: 3px 5px;">Hub / Depo Order Details</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Document No:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.documentNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Hub/Depo Name:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.hubDepoName}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>B2B:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.bb2}</td>
                                                            <td style="padding: 3px 5px;"><strong>B2B2C:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.bbc22}</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Client / Project Name:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.clientProjectName}</td>
                                                            <td style="padding: 3px 5px;"><strong>B2C:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.bc2}</td>
                                                        </tr>

                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Country:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.country}</td>
                                                            <td style="padding: 3px 5px;"><strong>State:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.state}</td>
                                                        </tr> 
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>City</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.city}</td>
                                                            <td style="padding: 3px 5px;"><strong>Street:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.hubDepoAddress}</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>District</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.district}</td>
                                                            <td style="padding: 3px 5px;"><strong>House No</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.houseNo}</td>
                                                        </tr>

                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Google Co-ordinates:</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list55.googleCoordinates}</td>

                                                        </tr>
                                                        <tr>
                                                            <td style="padding: 2px 4px; font-size: 10px;"><strong>Pcs Type:</strong></td>
                                                            <td style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <div style="display: inline-block; color: #333; margin-right: 5px;">
                                                                    <input type="checkbox" name="site" id="site" 
                                                                           value="${list55.pcTypeCar}" 
                                                                           ${list55.pcTypeCar == '1' ? 'checked' : ''} 
                                                                           style="width: 11px; height: 12px;" 
                                                                           disabled> A.Car
                                                                </div>
                                                                <div style="display: inline-block; color: #333; margin-right: 5px;">
                                                                    <input type="checkbox" name="agreement" id="agreement" 
                                                                           value="${list55.pcTypeBus}" 
                                                                           ${list55.pcTypeBus == '1' ? 'checked' : ''} 
                                                                           style="width: 11px; height: 12px;" 
                                                                           disabled> B.Bus
                                                                </div>
                                                                <div style="display: inline-block; color: #333;">
                                                                    <input type="checkbox" name="land" id="land" 
                                                                           value="${list55.pcTypeTruckLmv}" 
                                                                           ${list55.pcTypeTruckLmv == '1' ? 'checked' : ''} 
                                                                           style="width: 11px; height: 12px;" 
                                                                           disabled> C.Truck / LMV
                                                                </div>
                                                            </td>
                                                            <td style=" font-size: 11px; height: 20px; padding: 3px 5px;"><strong>Others:</strong></td>
                                                            <td style=" font-size: 11px; height: 20px; padding: 3px 5px;">${list55.other}</td>
                                                        </tr>

                                                        <tr>
                                                            <td style="padding: 2px 4px; font-size: 11px;"><strong>Financial Model:</strong></td>
                                                            <td style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <div style="display: inline-block; color: #333; margin-right: 5px;">
                                                                    <input type="checkbox" name="site" id="site" 
                                                                           value="${list55.finacialModelCapex}" 
                                                                           ${list55.finacialModelCapex == '1' ? 'checked' : ''} 
                                                                           style="width: 12px; height: 12px;" 
                                                                           disabled> A. Capex
                                                                </div>
                                                                <div style="display: inline-block; color: #333; margin-right: 5px;">
                                                                    <input type="checkbox" name="agreement" id="agreement" 
                                                                           value="${list55.finacialModelOpex}" 
                                                                           ${list55.finacialModelOpex == '1' ? 'checked' : ''} 
                                                                           style="width: 12px; height: 12px;" 
                                                                           disabled> B. Opex
                                                                </div>
                                                            <td style=" font-size: 11px; height: 20px; padding: 3px 5px;"><strong>Co-ordinates:</strong></td>
                                                            <td style=" font-size: 11px; height: 20px; padding: 3px 5px;">${list55.coOrdinates}</td>
                                                        </tr>

                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Details of Contact Person:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.firstName}</td>
                                                            <td style="padding: 3px 5px;"><strong>Client E-mail:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.email}</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Client Name:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.mobileNo}</td>
                                                            <td style="padding: 3px 5px;"><strong>Mobile Number:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.alternateMobileNo}</td>
                                                        </tr>

                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Charge Zone Scope Of Work:</strong></td>
                                                            <td colspan="3" style="padding: 2px 4px;">
                                                                <p style="margin: 0;font-size: 12px;">${list55.chargeScope}</p>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Client Scope:</strong></td>
                                                            <td colspan="3" style="padding: 2px 4px;">
                                                                <p style="margin: 0;font-size: 12px;">${list55.clientScope}</p>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Specific Requirements of The Client:</strong></td>
                                                            <td colspan="3" style="padding: 2px 4px;">
                                                                <p style="margin: 0;font-size: 12px;">${list55.specificReqClients}</p>
                                                            </td>
                                                        </tr>
                                                        <tr class="table-title">
                                                            <td colspan="4" style="text-align: center; font-size: 12px;padding: 3px 5px;">Hub Deliverable Details</td>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;">Document Name</th>
                                                            <th colspan="1" style="font-size: 11px; height: 20px; padding: 2px 4px;">Document Ref No/Document Path</th>
                                                            <th colspan="" style="font-size: 11px; height: 20px; padding: 2px 4px;">Date</th>
                                                            <th colspan="" style="font-size: 11px; height: 20px; padding: 2px 4px;">Attachment</th>

                                                        </tr>
                                                        <tr>
                                                            <th colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                (i) Design Basis Report (Assumption Sheet)
                                                                <input type="checkbox" style="width: 12px; height: 12px; margin-left: 3px;" 
                                                                       name="assumption" disabled id="assumption" value="${list55.assumptionSheet}" 
                                                                       ${list55.assumptionSheet == '1' ? 'checked' : ''} 
                                                                       onclick="toggleInputs(this, 'assumptionRefNo', 'Fromdate1', 'file1')">
                                                            </th>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span id="assumptionRefNo" name="assumptionRefNo" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.assumptionRefNo}</span>
                                                            </td>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span name="Fromdate1" id="Fromdate1" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.assumptionDate}</span>
                                                            </td>
                                                            <td  style="font-size: 9px; height: 18px; padding: 1px 3px;">


                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list55.assumptionAttach}&id1=${list55.id}"> <span name="Fromdate1" id="Fromdate1" style="font-size: 9px; padding: 2px 4px;">${list55.assumptionAttach}</span></a>
                                                            </td>

                                                        </tr>
                                                        <tr>
                                                            <th colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                (ii) Estimated BOQ: 
                                                                <input type="checkbox" style="width: 12px; height: 12px; margin-left: 3px;" 
                                                                       disabled name="boq" id="boq" value="${list55.estimatedBoq}" 
                                                                       ${list55.estimatedBoq == '1' ? 'checked' : ''} 
                                                                       onclick="toggleInputs(this, 'boqRefNo', 'Fromdate2')">
                                                            </th>
                                                            <td colspan=1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span id="boqRefNo" name="boqRefNo" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.estimatedRefNo}</span>
                                                            </td>
                                                            <td colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">

                                                                <span name="Fromdate2" id="Fromdate2"style="font-size: 9px; padding: 2px 4px;">${list55.estimatedDate}</span>

                                                            </td>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list55.estimatedAttach}&id1=${list55.id}">  
                                                                    <span name="Fromdate1" id="Fromdate1" 
                                                                          style="font-size: 9px; padding: 2px 4px;">${list55.estimatedAttach}</span></a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                (iii) LOA / LOI: 
                                                                <input type="checkbox" style="width: 12px; height: 12px; margin-left: 3px;" 
                                                                       disabled name="lao" id="lao" value="${list55.loaLoi}" 
                                                                       ${list55.loaLoi == '1' ? 'checked' : ''} 
                                                                       onclick="toggleInputs(this, 'laoRefNo', 'Fromdate3')">
                                                            </th>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span id="laoRefNo" name="laoRefNo" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.loaLoiRefNo}</span>
                                                            </td>
                                                            <td colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span name="Fromdate3" id="Fromdate3" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.loaLoiDate}</span>
                                                            </td>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list55.loaAttach}&id1=${list55.id}">  
                                                                    <span name="Fromdate1" id="Fromdate1"  style="font-size: 9px; padding: 2px 4px;">${list55.loaAttach}</span></a>

                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                (iv) Agreement: 
                                                                <input type="checkbox" style="width: 12px; height: 12px; margin-left: 3px;" 
                                                                       disabled name="agremment" id="agremment" value="${list55.agreement}" 
                                                                       ${list55.agreement == '1' ? 'checked' : ''} 
                                                                       onclick="toggleInputs(this, 'agremmentRefNo', 'Fromdate4')">
                                                            </th>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span id="agremmentRefNo" name="agremmentRefNo" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.agreementRefNo}</span>
                                                            </td>
                                                            <td colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span name="Fromdate4" id="Fromdate4" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.agreementDate}</span>
                                                            </td>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list55.agreementAttach}&id1=${list55.id}">  <span name="Fromdate1" id="Fromdate1" 
                                                                  style="font-size: 9px; padding: 2px 4px;">${list55.agreementAttach}</span></a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                (v) Layout Drawings: 
                                                                <input type="checkbox" style="width: 12px; height: 12px; margin-left: 3px;" 
                                                                       disabled name="drawings" id="drawings" value="${list55.layoutDrawings}" 
                                                                       ${list55.layoutDrawings == '1' ? 'checked' : ''} 
                                                                       onclick="toggleInputs(this, 'drawingsRefNo', 'Fromdate5')">
                                                            </th>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span id="drawingsRefNo" name="drawingsRefNo" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.layoutRefNo}</span>
                                                            </td>
                                                            <td colspan="" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <span name="Fromdate5" id="Fromdate5" 
                                                                      style="font-size: 9px; padding: 2px 4px;">${list55.layoutDate}</span>
                                                            </td>
                                                            <td colspan="1" style="font-size: 9px; height: 18px; padding: 1px 3px;">
                                                                <a class="fw-600 text-break gradient-text" href="aocForm.htm?act=AocDocxdownload&fileName=${list55.layoutAttach}&id1=${list55.id}"> 
                                                                    <span name="Fromdate1" id="Fromdate1" 
                                                                          style="font-size: 9px; padding: 2px 4px;">${list55.layoutAttach}</span></a>
                                                            </td>
                                                        </tr>

                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Manpower Details: (A) Operations:</strong></td>
                                                            <td colspan="" style="padding: 2px 4px;">
                                                                <p class="break-after-20" style="margin: 0;font-size: 12px;">${list55.operationsSign}</p>
                                                            </td>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Sign:</strong></td>
                                                            <td colspan="" style="padding: 2px 4px;">
                                                                <p class="break-after-20" style="margin: 0;font-size: 12px;">${list55.operationsSign}</p>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>(B) Maintenance:</strong></td>
                                                            <td colspan="" style="padding: 2px 4px;">
                                                                <p class="break-after-20" style="margin: 0;font-size: 12px;">${list55.maintenance}</p>
                                                            </td>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Sign:</strong></td>
                                                            <td colspan="" style="padding: 2px 4px;">
                                                                <p class="break-after-20" style="margin: 0;font-size: 12px;">${list55.maintenanceSign}</p>
                                                            </td>
                                                        </tr>

                                                        <tr class="table-title">
                                                            <td colspan="4" style="text-align: center; font-size: 12px;padding: 3px 5px;">Charger Installation Details</td>
                                                        </tr>

                                  <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Project Timeline Category</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.projectTimelineCategory}</td>
                                                            <td style="padding: 3px 5px;"><strong>Zero Date:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.zeroDate}</td>
                                                        </tr>                       
                                  <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Completion Date</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.completionDate}</td>
                                                            <td style="padding: 3px 5px;"><strong>No.of Days</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.chargingRatePerUnit}</td>
                                                        </tr>                       
                                  <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Budget Allocated for Project</strong></td>
                                                            <td colspan="3" style="padding: 3px 5px;">${list55.projectBudgetAllocated}</td>
                                                            
                                                        </tr>                       
                                                 
                                                        <tr class="table-title">
                                                            <td colspan="4" style="text-align: center; font-size: 12px;padding: 3px 5px;">(Ordinance) Order Review details</td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Reviewing Authority Comment:</strong></td>
                                                            <td colspan="3" style="padding: 2px 4px;">
                                                                <p style="margin: 0;font-size: 12px;">${list55.authorityComments}</p>
                                                            </td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Order Effective Date:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.orderEffcectiveDate}</td>
                                                            <td style="padding: 3px 5px;"><strong>New Revision No:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.newRevisionNo}</td>
                                                        </tr>
                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Budget allocation Date:</strong></td>
                                                            <td colspan="5"style="padding: 3px 5px;">${list55.budjectAllocationDate}</td>

                                                        </tr>

                                                        <tr style="font-size: 11px; height: 20px; padding: 3px 5px;">
                                                            <td style="padding: 3px 5px;"><strong>Reviewed By:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.reviewedBy}</td>
                                                            <td style="padding: 3px 5px;"><strong>Designation:</strong></td>
                                                            <td style="padding: 3px 5px;">${list55.designation}</td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Profile:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectProfile}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Profit Center:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectCenter}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Company Code:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.companyCode}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Plant:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.plant}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Type</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectType}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Project Currency:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.projectCurrency}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Investment Profile:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.inverstmentProfile}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Discom:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${Discom1}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>No Of Charge Points:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfChargePoints}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>No Of Charger:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfCharger}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Overall Station Capacity (KW):</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.overallStationCapacityKw}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station AC Capacity (KW):</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationAcCapacityKw} </span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station DC Capacity (KW):</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationDcCapacityKw}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total MegaWatt(MW):</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalMegaWatt}</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station Type:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationType}</span>

                                                            </td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Tenant:</strong></td>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.tenant}</span> </td>
                                                        </tr>
                                                        
                                                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total Kw Rating:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalKwRating}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Specific Date From Client:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.specificDateFromClient}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Total Charger Capacity:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.totalChargerCapacity}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Charger Station Access Type:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.chargerStationAccessType}</span> </td>
                        </tr>

                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Auxiliary Load Of Station:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.auxiliaryLoadOfStation}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Charging Rate Per Unit:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.chargingRetePerUnit}</span> </td>
                        </tr>
                        <tr>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>No. of EVs to be Charged / No. of Parking:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.noOfEvsToBeChanged}</span>

                            </td>
                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Station Name:</strong></td>
                            <td style="font-size: 9px; padding: 3px 4px;"><span>${list55.stationName}</span> </td>
                        </tr>
                                                        
                           <td style="font-size: 9px; padding: 3px 4px;"><strong>Anchore Customer:</strong></td>
                                                    <td  style="font-size: 9px; padding: 3px 4px;"><span>${list55.anchoreCustomer}</span> </td>
                                                    
                                                <td style="font-size: 9px; padding: 3px 4px;"><strong>Scope of ChargeZone:</strong></td>
                                                    <td  style="font-size: 9px; padding: 3px 4px;"><span>${list55.scopeOfchargeZone == 1 ? 'YES' : 'NO'}</span> </td>
                                                </tr>
                                               <c:if test="${not empty list55.canopyVarient}">
                                                 <tr>
                                                     <td  style="font-size: 9px; padding: 3px 4px;"><strong>Canopy Varient:</strong></td>
                                                    <td colspan="3" style="font-size: 9px; padding: 3px 4px;"><span>${list55.canopyVarient}</span> </td>
                                                </tr>
                                                </c:if>                             
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Connection Type:</strong></td>
                                                            <td  style="font-size: 9px; padding: 3px 4px;"><span>${connection}</span>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Site Survey:</strong></td>
                                                            <td  style="font-size: 9px; padding: 3px 4px;"><span>${list55.siteSurvey}</span>

                                                        </tr>
                                                        <!--                                                        <tr>
                                                                                                                    <td style="font-size: 11px; height: 20px; padding: 2px 4px;"><strong>Signature & Date:</strong></td>
                                                                                                                    <td colspan="3" style="padding: 2px 4px;">
                                                                                                                        <p style="margin: 0;font-size: 12px;">${list55.signatureDate}</p>
                                                                                                                    </td>
                                                                                                                </tr>-->

                                                        <tr>
                                                            <td style="font-size: 9px; padding: 3px 4px;"><strong>Survey:</strong></td>
                                                            <td  colspan="5" style="font-size: 9px; padding: 3px 4px;">
                                                                <c:if test="${list55.surveyRadio == '1'}">
                                                                    Site Survey Created
                                                                </c:if>  
                                                                <c:if test="${list55.surveyRadio == '0'}">
                                                                    Site Survey Not Created
                                                                </c:if>



                                                        </tr>
                                                        <c:if test="${list55.surveyRadio == '1'}">
                                                            <tr class="table-title">
                                                                <th colspan="" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Sr No</th>
                                                                <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Survey No</th>
                                                                <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px; background-color: #e0e7ff; font-size: 9px;">Project Representative</th>


                                                            </tr>
                                                            
                                                                <c:forEach var="aocsurveyattach" items="${aocsurveyattach}" varStatus="status">
                                                                    <tr style="font-size: 10px; padding: 3px 5px;">
                                                                        <td colspan="" style="font-size: 10px; padding: 3px 5px;">${status.count}</td>
                                                                        <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${aocsurveyattach.surveyNo}</td>
                                                                        <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${aocsurveyattach.projectRepresentative}</td>

                                                                    </tr>
                                                                </c:forEach>
                                                           
                                                        </c:if>
                                                        <tr class="table-title">
                                                            <th colspan="2" style="text-align: center; vertical-align: middle;padding: 3px 4px;font-size: 9px;">Document Name</th>
                                                            <th colspan="3" style="text-align: center; vertical-align: middle;padding: 3px 4px;font-size: 9px;">Attachment</th>
                                                        </tr>

                                                       
                                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                                <tr style="font-size: 10px; padding: 3px 5px;">
                                                                    <td colspan="2" style="font-size: 10px; padding: 3px 5px;">${list[1]}</td>
                                                                    <td colspan="3" style="font-size: 10px; padding: 3px 5px;">
                                                                        <a href="aocForm.htm?act=AocDocxdownload&fileName=${list[0]}&id1=${list55.id}">${list[0]}</a>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>

                                                            <c:forEach var="list33" items="${list33}" varStatus="status">
                                                                <tr style="font-size: 10px; padding: 3px 5px;">
                                                                    <td colspan="2"style="font-size: 10px; padding: 3px 5px;">${list33[1]}</td>
                                                                    <td colspan="3"style="font-size: 10px; padding: 3px 5px;">
                                                                        <a href="aocForm.htm?act=AocDocxdownload&fileName=${list33[0]}&id1=${list55.id}">${list33[0]}</a></td>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                       


                                                        <tr  class="table-title">
                                                            <td colspan="4" style=" font-size: 11px; padding: 3px 4px;  text-align: center;"><strong>Approval Status</strong></td>
                                                        </tr>

                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Sr.No</th>
                                                            <th style="text-align: center; vertical-align: middle ; font-size: 9px; padding: 3px 5px;">User</th>
                                                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Comment</th>
                                                            <th style="text-align: center; vertical-align: middle; font-size: 9px; padding: 3px 5px;">Action</th>
                                                        </tr>

                                                        
                                                            <c:forEach var="list0" items="${list0}" varStatus="status">
                                                                <tr>
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${status.count}</td> <!-- Serial Number -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.userId}</td> <!-- User ID -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">${list0.approvalComment}</td> <!-- Approval Comment -->
                                                                    <td style="font-size: 9px; padding: 3px 5px;">
                                                                        <c:if test="${list0.approvalStatus == '1'}">
                                                                            Approved
                                                                        </c:if>           
                                                                        <c:if test="${list0.approvalStatus == '2'}">
                                                                            Recycle
                                                                        </c:if>
                                                                        <c:if test="${list0.approvalStatus == '3'}">
                                                                            Rejected
                                                                        </c:if>
                                                                    </td> <!-- Approval Status -->
                                                                </tr>
                                                            </c:forEach>
                                                        
                                                    </table>
                    
                    
                    

                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
