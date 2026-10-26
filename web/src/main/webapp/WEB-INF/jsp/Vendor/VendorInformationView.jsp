<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vendor Information</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/login/style.css">-->

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

        <!--        <style>
                    .labelDiv {
                        width: 120px;
                    }
                </style>-->
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

            @media print {
    table {
        border: solid #000 !important;
        border-width: 1px 0 0 1px !important;
    }
    
    th, td {
        border: solid #000 !important;
        border-width: 0 1px 1px 0 !important;
    }
}
        </style>
        <!--        <style>
                    element.style {
                        left: 0px !important;
                        top: 0px !important;
                        overflow: hidden !important;
                        margin: 0px !important;
                        padding: 0px !important;
                        height: 442px !important;
                        width: 1349px !important;
                        z-index: -999999 !important;
                        position: fixed !important;
                        margin-top: -50px !important;
                    }
                </style>-->
        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
            
            function fileValidation()
            {
                var fileInput = document.getElementById('policyFile');
                var filePath = fileInput.value;
                if(filePath == '')
                {
                    alert("Please upload policy file");
                    return false;
                }
                
                var pfileInput = document.getElementById('photograph');
                var pfilePath = pfileInput.value;
                if(pfilePath == '')
                {
                    alert("Please upload terms & condition file");
                    return false;
                }
                
                var vendorInput = document.getElementById('vendorFile');
                var vendorPath = vendorInput.value;
                if(vendorPath == '')
                {
                    alert("Please upload policy file");
                    return false;
                }
                
//
            }
            
            
            
        </script>
    </head>
    <body>
          <div class="content-wrapper container-fluid" style="min-height: 720px;">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Information View</h1>
            
            <br/>
        <input type="button" value="Print" onclick="window.print();" class="btn btn-primary">
        <br/>
        
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-12">

                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                      
                        <div class="tab-content">
        <br/>
        <div class="containers" >

                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info" style="padding: 0px" role="alert">${successMessage}</div>
                </c:if>
                <c:if test="${!empty faliureMessage}">
                    <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                </c:if>
                <!--<div class="form-bottom contact-form">-->

                <form:form action="vendorInformation.htm?act=finalsubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                           class="form-horizontal" role="form">
                    
                                            <form:input type="hidden" path="companyName" class="form-control"   maxlength="30" required="required"/>
                                            <form:input type="hidden" path="contactName" class="form-control"   maxlength="30" required="required"/>
                                            <form:input type="hidden" path="vendorEmailId" class="form-control"   maxlength="30" required="required"/>
                                        
                <c:forEach var="list" items="${list}" varStatus="status">
                    
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td width="80%"><b>GUJARAT FLUOROCHEMICALS LIMITED<br>(Dahej / Ranjitnagar Complex)<br><br>VENDOR REGISTRATION FORM</b></td>
                            <td><img src="StorageYard/Images/logo.png" style="height:50px;"></td>
                        </tr>
                    </table>
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td>Company Name :</td>
                            <td>${list.companyName}</td>
                            <td>Contact Parson Name :</td>
                            <td>${list.contactName}</td>
                        </tr>
                    </table>
                        
                        
                    
                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td>Type Of Concern </td>
                            <td>${list.typeOfConcern}</td>
                        </tr>
                            </table>
                    
                    
                    <table id="table_1" class="table table-bordered table-striped table-hover" align="Center"  >
                        <tr>
                            <td>Address </td>
                            <td>Office</td>
                            <td>Work</td>
                        </tr>
                        <tr>
                            <td>Address Line 1 </td>
                            <td>${list.officeAddressLine1}</td>
                            <td>${list.workAddressLine1}</td>
                        </tr>
                        <tr>
                            <td>Address Line 2 </td>
                            <td>${list.officeAddressLine2}</td>
                            <td>${list.workAddressLine2}</td>
                        </tr>
                        <tr>
                            <td>Address Line 3 </td>
                            <td>${list.officeAddressLine3}</td>
                            <td>${list.workAddressLine3}</td>
                        </tr>
                        <tr>
                            <td>City </td>
                            <td>${list.officeCity}</td>
                            <td>${list.workCity}</td>
                        </tr>
                        <tr>
                            <td>State </td>
                            <td>${list.officeState}</td>
                            <td>${list.workState}</td>
                        </tr>
                        <tr>
                            <td>Pin </td>
                            <td>${list.officePin}</td>
                            <td>${list.workPin}</td>
                        </tr>
                        <tr>
                            <td>Country </td>
                            <td>${list.officeCountry}</td>
                            <td>${list.workCountry}</td>
                        </tr>
                        <tr>
                            <td>Telephone (With STD Code) </td>
                            <td>${list.officeTelephone}</td>
                            <td>${list.workTelephone}</td>
                        </tr>
                        <tr>
                            <td>Mobile </td>
                            <td>${list.officeMobile}</td>
                            <td>${list.workMobile}</td>
                        </tr>
                        <tr>
                            <td>Fax </td>
                            <td>${list.officeFax}</td>
                            <td>${list.workFax}</td>
                        </tr>
                        <tr>
                            <td>Email Address </td>
                            <td>${list.officeEmail}</td>
                            <td>${list.workEmail}</td>
                        </tr>
                        <tr>
                            <td>Web Site </td>
                            <td>${list.officeWebsite}</td>
                            <td>${list.workWebsite}</td>
                        </tr>
                        <tr>
                            <td>Weekly Holidays </td>
                            <td>${list.officeWeeklyHoliday}</td>
                            <td>${list.workWeeklyHoliday}</td>
                        </tr>
                        <tr>
                            <td>Contact Person (Name) </td>
                            <td>${list.officeContactPersonName}</td>
                            <td>${list.workContactPersonName}</td>
                        </tr>
                        <tr>
                            <td>Designation </td>
                            <td>${list.officeContactDesignation}</td>
                            <td>${list.workContactDesignation}</td>
                        </tr>
                        <tr>
                            <td>Mobile No. </td>
                            <td>${list.officeContactMobile}</td>
                            <td>${list.workContactMobile}</td>
                        </tr>
                        <tr>
                            <td>Email Address </td>
                            <td>${list.officeContactEmail}</td>
                            <td>${list.workContactEmail}</td>
                        </tr>
                    </table>
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td>PRODUCT / SERVICES OFFERED (Please indicate special Items) :</td>
                            <td>${list.productService}</td>
                        </tr>
                    </table>
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td colspan="3">COMMERCIAL (Wherever applicable all to be supported with duplicate self attached copies)</td>
                        </tr>
                        <tr>
                            <td>PAN Detail </td>
                            <td>${list.panNo}</td>
                            <td>${list.panFile}</td>
                        </tr>
                        <tr>
                            <td>GSTIN Detail </td>
                            <td>${list.gstinNo}</td>
                            <td>${list.gstinFile}</td>
                        </tr>
                        <tr>
                            <td>Type of GST Registration </td>
                            <td>${list.typeOfGst}</td>
                            <td></td>
                        </tr>
                    </table>
                            
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td colspan="2">INFRASTRUCTURE</td>
                        </tr>
                        <tr>
                            <td>Present Product Wise Capacity / Expansion Planned </td>
                            <td>${list.productWiseCapacity}</td>
                        </tr>
                        <tr>
                            <td>Design & Development Capabilities </td>
                            <td>${list.developmentCapabilities}</td>
                        </tr>
                        <tr>
                            <td>Machinery / Technology ( Please enclose a list of machinery used, make, model, Capacity & Installation Date)</td>
                            <td>${list.machineryTechnology}</td>
                        </tr>
                        <tr>
                            <td>Material Handling & Storage Facilities </td>
                            <td>${list.materialHandling}</td>
                        </tr>
                    </table>
                        
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td colspan="3">Turn Over / Balance Sheet (Last Three Years – Include Extra Sheet if required)</td>
                        </tr>
                        <tr>
                            <td>First Year </td>
                            <td>${list.firstYear}</td>
                            <td>${list.firstYearFile}</td>
                        </tr>
                        <tr>
                            <td>Second Year </td>
                            <td>${list.secondYear}</td>
                            <td>${list.secondYearFile}</td>
                        </tr>
                        <tr>
                            <td>Third Year </td>
                            <td>${list.thirdYear}</td>
                            <td>${list.thirdYearFile}</td>
                        </tr>
                        <tr>
                            <td>Balance Sheet </td>
                            <td>${list.balanceSheet}</td>
                            <td>${list.balanceSheetFile}</td>
                        </tr>
                        <tr>
                            <td>MSME Certificate </td>
                            <td>${list.msmeCertificate}</td>
                            <td>${list.msmeCertificateFile}</td>
                        </tr>
                    </table>
                    
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                        <tr>
                            <td colspan="2">List of Major Customers (Please enclose extra sheet if required) / Customer Ratings/ Work Completion certificates :</td>
                        </tr>
                        <tr>
                            <td>Major Customers</td>
                            <td>${list.majorCustomers}</td>
                        </tr>
                        <tr>
                            <td>Customer Ratings</td>
                            <td>${list.customerRatings}</td>
                        </tr>
                        <tr>
                            <td>Work Completion certificates : For New Vendors ( competency mapping)</td>
                            <td>${list.workCompletionCertificates}</td>
                        </tr>
                    </table>
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                        <tr>
                            <td colspan="2">Work Force :</td>
                        </tr>
                        <tr>
                            <td>Total Staff</td>
                            <td>${list.totalStaff}</td>
                        </tr>
                        <tr>
                            <td>Skilled Workers</td>
                            <td>${list.skilledWorkers}</td>
                        </tr>
                        <tr>
                            <td>Unskilled Workers</td>
                            <td>${list.unskilledWorkers}</td>
                        </tr>
                        <tr>
                            <td>Sex Ratio (HR department)</td>
                            <td>${list.sexRatio}</td>
                        </tr>
                        <tr>
                            <td>Suspension of work (Due to legal issue, any pending work or in efficiency of organization to complete)</td>
                            <td>${list.suspensionOfWork}</td>
                        </tr
                        <tr>
                            <td>Business Continuity / Contingency Plan :</td>
                            <td>${list.businessContinuity}</td>
                        </tr>
                    </table>
                        
                    
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                        <tr>
                            <td colspan="2">QUALITY/ENVIRONMENT/SAFETY/SUSTAINABILITY ASSURANCE/Fair Labour Standard (If required include separate sheet) :</td>
                        </tr>
                        <tr>
                            <td>Organization of QA : (With number of Employee ) Please share certificate no:</td>
                            <td>${list.organizationOfQa}</td>
                        </tr>
                        <tr>
                            <td>Environment : Please share certificate no:</td>
                            <td>${list.environment}</td>
                        </tr>
                        <tr>
                            <td>SUSTAINABILITY ASSURANCE : GRI/ESG/IR/ISO26000/Sustainability Report or assurance statement</td>
                            <td>${list.sustainability}</td>
                        </tr>
                        <tr>
                            <td>Fair Labour Standard: SA 8000/SEDEX/WRAP/ Or Third party verifies Labour certificate</td>
                            <td>${list.fairLabourStandardFile}</td>
                        </tr>
                        <tr>
                            <td>Inspection Facilities (Please enclose details of inspection & test instruments, their Calibration Standards & Frequency) </td>
                            <td>${list.inspectionFacilities}</td>
                        </tr>
                        <tr>
                            <td>Inspection Procedure (For Finished Products only -Please hi-light specification & test methods)</td>
                            <td>${list.inspectionProcedure}</td>
                        </tr>
                        <tr>
                            <td>Change Management Process Modification</td>
                            <td>${list.changeManagementProcess}</td>
                        </tr>
                    </table>
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                        <tr>
                            <td colspan="1">Quality System : Please specify, if ISO 9001 / IATF16949, ISO 14001, ISO 45001 standard has been implemented or planned) :</td>
                        </tr>
                    </table>
                        
                        <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Select Certificate</th>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                        </tr>
                                                        <c:forEach var="vendorQualityCertificate" items="${vendorQualityCertificate}" varStatus="status">
                                                        <tr>
                                                            <td style="text-align: center">
                                                                ${vendorQualityCertificate.certificateDetails}
                                                            </td>
                                                            <td style="text-align: center">
                                                                
                                                                ${vendorQualityCertificate.certificateFile}
                                                                
                                                            </td>
                                                        </tr>
                                                        </c:forEach>
                        </table>
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                        <tr>
                            <td colspan="2">Sustainability: Please specify Sustainability initiatives – BRR Report, Carbon Footprint, Sustainability/ESG/IR Report, Zero waste to landfill or circular economy Certification, Green product, Green Company, Life cycle analysis certification has been implemented or planned) Share Link/Website or any publicly available document :</td>
                        </tr>
                        <tr>
                            <td>Sustainability initiatives : GRI Report/IR/ESG/Sustainability/ISO26000/ KPI Report wrt Materiality :</td>
                            <td>${list.sustainabilityInitiativesFile}</td>
                        </tr>
                        <tr>
                            <td>Carbon Footprint : ISO 14064 Carbon Footprint for Organization, ISO 14067 For Product Carbon Footprint.:</td>
                            <td>${list.carbonFootprint}</td>
                        </tr>
                        <tr>
                            <td>Sustainability/ESG/IR Report</td>
                            <td>${list.irReportFile}</td>
                        </tr>
                        <tr>
                            <td>Zero waste to landfill or circular economy Certification</td>
                            <td>${list.circularEconomyFile}</td>
                        </tr>
                        <tr>
                            <td>Green product, : ISO 14021/ ISO 14024 and ISO 14025 – Third party certified</td>
                            <td>${list.greenProductFile}</td>
                        </tr>
                        <tr>
                            <td>Green Company ; CII , GC Mark</td>
                            <td>${list.greenCompanyFile}</td>
                        </tr>
                        <tr>
                            <td>Life cycle analysis certification: ISO 14040 life cycle assessment, ISO 14044 life cycle impact assessment (LCIA)</td>
                            <td>${list.lifeCycleAnalysisFile}</td>
                        </tr>
                    </table>
                        
                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                        <tr>
                            <td colspan="5">Are you bound by law to take Clearance for Hazardous Material Handling / Processing (Yes/No.), If Yes, Give details with Certificate Copies) or Else Write NA</td>
                        </tr>
                    </table>
                        <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Process Detail</th>
                                                            <th style="text-align: center; vertical-align: middle">Hazardious Material</th>
                                                            <th style="text-align: center; vertical-align: middle">Govt. Cert. No.</th>
                                                            <th style="text-align: center; vertical-align: middle">Description</th>
                                                            <input type="hidden" name="policyCount1" id="policyCount1" value="1"/>
                                                        </tr>
                                                        <c:forEach var="vendorClearanceCertificate" items="${vendorClearanceCertificate}" varStatus="status">
                                                        <tr>
                                                            <td style="text-align: center">
                                                                ${vendorClearanceCertificate.processDetail}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorClearanceCertificate.hazardiousMaterial}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorClearanceCertificate.certificateNo}
                                                            </td>
                                                            <td style="text-align: center">
                                                                ${vendorClearanceCertificate.description}
                                                            </td>
                                                            
                                                        </tr>
                                                        </c:forEach>
                        </table>
                        
                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                            <tr>
                                <td>Are you / your employee aware about safety precautions / work methods and use of PPE at the time of work?</td>
                                <td>${list.awareAboutSafety}</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Are there any incidents during your working in any other organizations? (Yes/No) If yes, give details</td>
                                <td>${list.incidentsDuringWork}</td>
                                <td>${list.incidentsDetails}</td>
                            </tr>
                        </table>
                            
                            
                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                            <tr>
                                <td colspan="2">ADDITIONAL INFORMATION</td>
                            </tr>
                            <tr>
                                <td>Please also provide any other information you feel is necessary for us to know you better for a long terms relationship.</td>
                                <td>${list.additionalInformation}</td>
                            </tr>
                            <tr>
                                <td>Cancel Cheque</td>
                                <td>${list.chequeFile}</td>
                            </tr>
                            <tr>
                                <td>Information furnished by</td>
                                <td>${list.informationFurnishedByFile}</td>
                            </tr>
                        </table>
                            
                            
                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="left"  >
                            <tr>
                                <td width="25%">Name</td>
                                <td width="25%"></td>
                                <td width="25%">Designation</td>
                                <td width="25%"></td>
                            </tr>
                            <tr>
                                <td>Date</td>
                                <td></td>
                                <td>Place</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td colspan="2"><br><br><br>(Signature)</td>
                                <td colspan="2"><br><br><br>(Company's Stamp)</td>
                            </tr>
                            
                        </table>
                        
                        
                        
                </c:forEach>
                    
                Please note following:

                <ul>
                    <li>This needs to be signed by responsible personnel of your organization</li>
                    <li>Please enclose letter for request of making you as our supplier on your letter head duly signed and stamped with the same authorized person</li>
                    <li>Please enclosed all the motioned proof</li>
                    <li>Please enclose two blank letter heads of your company</li>
                    <li>Please Enclose Two Cross Cheque of your authorized Bank for our records of your bank</li>
                    <li>This form is only to collect information for appraisal purpose. It is not necessary that you will be registered with us as regular vendor</li>
                    <li>Given information are categorically confidential and will not be shared with anyone outside the business domain.</li>
                
                </ul>
                                        
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Upload Sign and Stamped Sustainable Policy :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="policyFile" name="policyFile" >
                                        </div>
                                    </div>
                
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Upload Sign and Stamped Terms and Condition :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="photograph" name="photograph" >
                                        </div>
                                    </div>
                                    <br><br>
                <b>Print form should be as per format provided with GFL logo, attached is print document, asthetically not OK.</b><br><br>
                
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Profile Upload<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="panFile" name="vendorFile" accept="" >
                                        </div>
                                        <div class="col-sm-3">
                                            
                                        </div>
                                    </div>
                
                  
                
                
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn1"  id="submit1" title="submit1" value="SUBMIT" onclick="return fileValidation();">
                                        </div>
                                    </div>
                                        
                                </form:form>

       </div>
          </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
           
        </section><!-- /.content -->
          </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <!-- Javascript -->
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>