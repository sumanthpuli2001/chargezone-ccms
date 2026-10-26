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

            function fileValidation()
            {
                var chequefile = document.getElementById('chequeFile');
                var chequePath = chequefile.value;

                var allowedExtensions = /(\.jpg|\.jpeg|\.pdf|\.gif)$/i;
                if (!allowedExtensions.exec(chequePath)) {
                    alert('Only pdf and jpg File type allow in cheque');
                    chequePath.value = '';
                    return false;
                }

                if (chequePath == '')
                {
                    alert("Please upload Cancel Cheque file");
                    return false;
                }

                var awareAboutSafety = document.getElementById('awareAboutSafety');
                var awareAboutSafety1 = awareAboutSafety.value;
                if (awareAboutSafety1 == 'Select')
                {
                    alert("Please select safety precautions");
                    return false;
                }

                var incidentsDuringWork = document.getElementById('incidentsDuringWork');
                var incidentsDuringWork1 = incidentsDuringWork.value;
                if (incidentsDuringWork1 == 'Select')
                {
                    alert("Please select incidents During Work");
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
                window.location = 'vendorInformation.htm?act=deletequality&checkId=' + id + '&vendorEmailId=' + vendorId;
            }

            function deleteid1(id, vendorId)
            {
                window.location = 'vendorInformation.htm?act=deleteclearance&checkId=' + id + '&vendorEmailId=' + vendorId;
            }


        </script>

        <script>

            var tempCount31 = 1;
            function Policy1()
            {

                //      $(function () {

                //        $("#policyCloneid").on("click", function () {

                tempCount31++;
                //                        alert(tempCount3);
                var clone = "<tr id='addmoreFile" + tempCount31 + "' style='clear:both;'>"
                        + "<td style=\"text-align: center\">" + tempCount31 + "</td>"
                        + ""
                        + "<td style=\"text-align: center\"><input type=\"text\" name='processDetail" + tempCount31 + "' id='processDetail" + tempCount31 + "' onFocus=\"(this.id=this.value)\"  class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" name='hazardiousMaterial" + tempCount31 + "' id='hazardiousMaterial" + tempCount31 + "' class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" name='govCert" + tempCount31 + "' id='govCert" + tempCount31 + "' class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\"><input type=\"text\" name='description" + tempCount31 + "' id='description" + tempCount31 + "' class=\"form-control\"></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removePolicy1('addmoreFile" + tempCount31 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#policyTable1").append(clone);
                document.getElementById('policyCount1').value = tempCount31;
                //                var expenseType = document.getElementById('expenseType').value;
                addAPolicy1(tempCount31);
            }
            //       });
            //   });

            function addAPolicy1(id) {
                //                alert(id);
                var element2 = document.getElementById('policyId1');
                var obj2 = document.getElementById("policyId1" + id);
                for (var i2 = 0; i2 < element2.options.length; i2++) {
                    var opt2 = document.createElement("option");
                    opt2.value = element2.options[i2].value;
                    opt2.text = element2.options[i2].text;
                    obj2.appendChild(opt2);
                }
            }

            function removePolicy1(policyDiv1) {

                try {
                    //                tempCount3--;
                    //         alert("a");
                    var currentMinusName = policyDiv1;
                    //    alert("a");
                    element1 = document.getElementById(policyDiv1);

                    element1.parentNode.removeChild(element1);
                } catch (e) {

                }
            }

        </script>

    </head>
    <body>
        <div class="content-wrapper container-fluid" style="min-height: 720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Vendor Information</h1>
                <!--            <ol class="breadcrumb">
                                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                                <li class="active">Vendor Forth Information</li>
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

                                <form:form action="vendorInformation.htm?act=fifthVendorInformation" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                           class="form-horizontal" role="form" name="form">
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

                                    <br>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label class="control-label">Supply Details</label>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Type of External Provider:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input type="checkbox" id="manufacturer" name="manufacturer" value="1" /> 1. Manufacturer 
                                        </div>

                                        <div class="col-sm-2">
                                            <input type="checkbox" id="dealer" name="dealer" value="1"/> 2. Authorized dealer/distributor  
                                        </div>

                                        <div class="col-sm-2">
                                            <input type="checkbox" id="traders" name="traders" value="1"/> 3. General Trader
                                        </div>


                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Dealing In :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-2">
                                            <input type="checkbox" id="materialSupply" name="materialSupply" value="1"/> Material Supply    
                                        </div>

                                        <div class="col-sm-2">
                                            <input type="checkbox" id="dealingServices" name="dealingServices" value="1"/> Services 
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">ESIC No.<span style="color: red;font-size: 12px;">*</span> </label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="esicNo" class="form-control"   maxlength="200" required="required"/>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Capabilities to offer related technical / after sales support:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="capabilities1"  class="form-control " required="required">
                                                <form:option value="Select">Select</form:option>
                                                <form:option value="No">No</form:option>
                                                <form:option value="Yes">Yes</form:option>

                                            </form:select>
                                        </div>


                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Specific Products and/or Services* proposed or supplied to PSI<span style="color: red;font-size: 12px;">*</span> </label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="specificProducts" class="form-control"   maxlength="200" required="required"/>
                                        </div>

                                    </div>

                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <label class="control-label">Quality MAnagement/Environment Management</label>
                                        </div>

                                    </div>
                                    <br>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Do you operate a quality management system?<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="qualityManagement"  class="form-control " required="required">
                                                <form:option value="Select">Select</form:option>
                                                <form:option value="No">No</form:option>
                                                <form:option value="Yes">Yes</form:option>

                                            </form:select>
                                        </div>


                                    </div>


                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Quality Certification<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>

                                        <div class="col-sm-1">
                                            <input type="checkbox" id="qualityIso" name="qualityIso" value="1" /> ISO 
                                        </div>

                                        <div class="col-sm-1">
                                            <input type="checkbox" id="qualityApi" name="qualityApi" value="1"/> API 
                                        </div>

                                        <div class="col-sm-1">
                                            <input type="checkbox" id="qualityIs" name="qualityIs" value="1"/> IS
                                        </div>
                                        <div class="col-sm-2">
                                            <input type="checkbox" id="qualityOthers" name="qualityOthers" value="1"/> Others (Specify if others)
                                        </div>


                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Do you operate an environmental management system (EMS)?<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="environmentManagement"  class="form-control " required="required">
                                                <form:option value="Select">Select</form:option>
                                                <form:option value="No">No</form:option>
                                                <form:option value="Yes">Yes</form:option>

                                            </form:select>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Not use Banned Metals as per Indian Chemical Regulation:
                                                <br>
                                                I) Chromium VI, 
                                                II)  Arsenic,
                                                III) Antimony & their oxides, 
                                                IV) Mercury & its derivatives 
                                                <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:select path="indianChemical"  class="form-control " required="required">
                                                <form:option value="Select">Select</form:option>
                                                <form:option value="No">No</form:option>
                                                <form:option value="Yes">Yes</form:option>

                                            </form:select>
                                        </div>

                                    </div>



                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SUBMIT AND CONTINUE" onclick="return fileValidation();">
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