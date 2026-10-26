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
        <title>Vendor Registration</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
<!--        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">-->

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
            
            
            
        </script>
    </head>
    <body>
        <div class="content-wrapper container-fluid" style="min-height: 720px;">
       
        <section class="content-header">
            <h1>Vendor Terms Condition</h1>
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

                <form:form action="vendorInformation.htm?act=termsconditionVendorInformation" method="post" enctype="multipart/form-data" commandName="vendorInformation"
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
                                            <label class="control-label">Contact Parson Name :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.contactName}</h5>
                                            <form:input type="hidden" path="contactName" class="form-control"   maxlength="30" required="required"/>
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
                                            <label class="control-label">Terms and Condition :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <a target="#" href="StorageYard/General_Terms_and_Conditions.pdf">termscondition.pdf</a>
                                        </div>
                                    </div>
                                        
                                     
                                        
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Terms & Condition Accept :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="checkbox" id="e" name="e" onchange="one()" />
                                        </div>
                                    </div>
                                        
<script language="javascript"> 

function one()
{
                if (document.getElementById("e").checked == true)
                {
                    document.getElementById("submit1").disabled= false;
                    document.form.submit1.disabled = false;
                }
                else {
                    document.getElementById("submit1").disabled= true;
                    document.form.submit1.disabled = true;

                }
   
}
</script>                            
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SUBMIT AND CONTINUE" disabled="true" onclick="return fileValidation();">
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