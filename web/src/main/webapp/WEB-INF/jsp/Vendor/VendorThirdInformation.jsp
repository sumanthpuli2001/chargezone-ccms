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
        <script>

            var tempCount3 = 1;
            function Policy()
            {

                //      $(function () {

                //        $("#policyCloneid").on("click", function () {

                tempCount3++;
                //                        alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount3 + "</td>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"text\" step=\"any\" name='certificate" + tempCount3 + "' id='certificate" + tempCount3 + "' onFocus=\"(this.id=this.value)\" onchange=\"totalValueChange(this,this.id);\" min=\"0\" class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"file\" name='certificatefile" + tempCount3 + "' id='certificatefile" + tempCount3 + "'</td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable").append(clone);
                document.getElementById('policyCount').value = tempCount3;
//                var expenseType = document.getElementById('expenseType').value;
                addAPolicy(tempCount3);
            }
            //       });
            //   });

            function addAPolicy(id) {
                //                alert(id);
                var element2 = document.getElementById('policyId1');
                var obj2 = document.getElementById("policyId" + id);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }

            function removePolicy(policyDiv) {

                try {
//                tempCount3--;
                    //         alert("a");
                    var currentMinusName = policyDiv;
                    //  var currentMinusId = currentMinusName.split("addmoreFile")[1];


                    //    
                    //    
//    var val = document.getElementById("policyCount").value;
//                alert("aaa" + val);
                    //   var element = document.getElementsByName("amount" + currentMinusId)[0].value;
//                alert("bbbb" + element);
                    //  val = val - 1;
                    //    var element2 = document.getElementById('txtresult').value;
//                alert("cccccccc " + element2)
                    //    document.getElementById('txtresult').value = '';
                    //    document.getElementById('txtresult').value = parseFloat(element2) - parseFloat(element);
                    //    var element21 = document.getElementById('txtresultCTC').value;
                    //    document.getElementById('txtresultCTC').value = '';
                    //    document.getElementById('txtresultCTC').value = parseFloat(element21) - parseFloat(element);

                    //    document.getElementById("policyCount").value = val;
                    //    alert("a");
                    element1 = document.getElementById(policyDiv);

                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

            function deleteid(id, vendorId)
            {
                //  alert("aa");
                window.location = 'vendorInformation.htm?act=deleteapprovalSetting&checkId=' + id + '&vendorEmailId=' + vendorId;
            }

        </script>
    </head>
    <body>


        <div class="content-wrapper container-fluid" style="min-height:720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Vendor Information</h1>
                <!--            <ol class="breadcrumb">
                                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                                <li class="active">Vendor Third Information</li>
                            </ol>-->
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

                                <form:form action="vendorInformation.htm?act=thirdVendorInformation" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                           class="form-horizontal" role="form" name="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Company Name :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.companyName}<h5>
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
                                                        <div class="col-sm-12">
                                                            <label class="control-label">List of Major Customers (Please enclose extra sheet if required) / Customer Ratings/ Work Completion certificates :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Major Customers<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <form:input path="majorCustomers" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Customer Ratings<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="customerRatings" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Work Completion certificates : For New Vendors ( competency mapping)<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="workCompletionCertificates" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label class="control-label">Work Force :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Total Staff<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="totalStaff" pattern="[0-9]+" title="Input only numbers" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Skilled Workers<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="skilledWorkers" class="form-control" pattern="[0-9]+" title="Input only numbers"  maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Unskilled Workers<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="unskilledWorkers" class="form-control" pattern="[0-9]+" title="Input only numbers"  maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Sex Ratio  (HR department)<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="sexRatio" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Suspension of work (Due to legal issue, any pending work or in efficiency of organization to complete)<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="suspensionOfWork" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Business Continuity / Contingency Plan :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <form:input path="businessContinuity" class="form-control"   maxlength="300" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>

                                                    </div>

                                                    

                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label class="control-label">QUALITY/ENVIRONMENT/SAFETY/SUSTAINABILITY ASSURANCE/Fair Labour Standard (If required include separate sheet) :<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>

                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Organization of QA : (With number of Employee ) Please share certificate no:<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="organizationOfQa" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Environment : Please share certificate no:<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="environment" class="form-control"   maxlength="200" required="required"/>
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">SUSTAINABILITY ASSURANCE  : GRI/ESG/IR/ISO26000/Sustainability Report or assurance statement<span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <form:input path="sustainability" class="form-control"   maxlength="200" />
                                                        </div>
                                                        <div class="col-sm-3">

                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Fair Labour Standard: SA 8000/SEDEX/WRAP/ Or Third party verifies Labour certificate</label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="file" class="form-control" id="panFile" name="fairLabourStandardFile" accept="" onchange="checkFileSize();">
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
                                                            <input type="submit" class="btn btn1"  id="submit1" title="submit1" value="SUBMIT AND CONTINUE" >
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