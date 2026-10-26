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
        
    </head>
    <body>
        <div class="content-wrapper container-fluid" style="min-height: 720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Vendor Information</h1>

            </section>

            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">

                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" style="padding: 0px" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                                </c:if>
                                <!--<div class="form-bottom contact-form">-->

                                <form:form action="vendorInformation.htm?act=secondVendorInformation" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Company Name :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.companyName}</h5>
                                                <form:input type="hidden" path="companyName" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Email ID :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.vendorEmailId}</h5>
                                                <form:input type="hidden" path="vendorEmailId" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">PRODUCT / SERVICES OFFERED (Please indicate special Items):<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <form:input path="productService" class="form-control"   maxlength="300" />
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label class="control-label">Company registration details</label>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">CST No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="cst_no"  class="form-control"   maxlength="30"  required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="cstFile" name="cstFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">GST No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="gstinNo" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="gstinFile" name="gstinFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">VAT TIN No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="vat_pin"  class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="vatPinFile" name="vatPinFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">PAN No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="panNo" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="panFile" name="panFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Service tax No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="service_tax"  class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="serviceTaxFile" name="serviceTaxFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">ECC (Excise Control Code) No.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="ecc_no"  class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="eccNoFile" name="eccNoFile" accept="" onchange="checkFileSize();">
                                        </div>
                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Type of GST Registration<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="typeOfGst"  class="form-control " required="required">
                                                <form:option value="Regular">Regular</form:option>
                                                <form:option value="Composite">Composite</form:option>
                                                <form:option value="Not Registered">Not Registered</form:option>
                                            </form:select>

                                        </div>
                                        <div class="col-sm-3">

                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label class="control-label">Payment/Banking Information</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Account Number.<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="accountNumber"  class="form-control"   maxlength="30" required="required"/>
                                        </div>

                                    </div>
                                        
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Bank Name <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="bankName"  class="form-control"   maxlength="30" required="required"/>
                                        </div>

                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Branch<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="branch"  class="form-control"   maxlength="30" required="required"/>
                                        </div>

                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">IFSC Code<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="ifscCode"  class="form-control"   maxlength="30" required="required"/>
                                        </div>

                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Swift Code (if any)<span style="color: red;font-size: 12px;"></span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input  path="swiftCode"  class="form-control"   maxlength="30" />
                                        </div>

                                    </div>
                                        
                                         <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Cancel Cheque</label>
                                        </div>
                                        <div class="col-sm-3">
                                          <input type="file" class="form-control" id="chequeFile" name="chequeFile" accept="" onchange="checkFileSize();">
                                        </div>
                                        <div class="col-sm-3">
                                            
                                        </div>
                                    </div>



                                    <script language="javascript">

                                        function one()
                                        {
                                            if (document.getElementById("e").checked == true)
                                            {
                                                document.getElementById("submit1").disabled = false;
                                                document.form.submit1.disabled = false;
                                            } else {
                                                document.getElementById("submit1").disabled = true;
                                                document.form.submit1.disabled = true;

                                            }

                                        }
                                    </script>                            
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn1" style="width: 200px;" id="submit1" title="submit1" value="SAVE AND NEXT" onclick="return fileValidation();">
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