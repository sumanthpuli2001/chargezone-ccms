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
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Vendor Registration</h1>
<!--            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Vendor Information</li>
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

                <form:form action="vendor.htm?act=vendorRegistrationSubmit" method="post" enctype="multipart/form-data" 
                                           class="form-horizontal" role="form">
                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Registered Name of the Firm <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="fname" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Legal Status of the firm <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select name="sfirm" id="sfirm" class="form-control" tabindex="2" >
                                                <option value="proprietor" selected="selected">Proprietor</option>
                                                <option value="partnership">Partnership</option>
                                                <option value="public">Public</option>
                                                <option value="private">Private</option>
                                            </select>
                                            
                                           
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Year of Establishment Registration Date <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class='input-group date' id='datetimepicker1'>
                                                <input name="rdate" type="text" class="form-control form_datetime"   maxlength="30" required/>
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker1').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD/MM/YYYY',
                                                        });
                                                    });
                                                </script>
                                            </div>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Registration Date <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class='input-group date' id='datetimepicker2'>
                                                <input name="vrdate" type="text" class="form-control form_datetime"   maxlength="30" required/>
                                                <span class="input-group-addon">
                                                    <span class="fa fa-calendar"></span>
                                                </span>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#datetimepicker2').datetimepicker({
//                                                            defaultDate: new Date(),
                                                            format: 'DD/MM/YYYY',
                                                        });
                                                    });
                                                </script>
                                            </div>
                                        </div>
                                        
                                        
                                    </div>
                    
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">CIN No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="cinno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">CIN For C.S.T. No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachcinno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>  
                    
                                    <div class="form-group">
                                        <div class="col-sm-9">
                                            <label class="control-label">H.O/Registered/Regional Office</label>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Address <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="address" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Pin Code No <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="pinno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Name of Contact Person <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="cperson" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Phone No(Off.) <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="officeno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Phone No(Resi.) </label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="resino" class="form-control"   maxlength="100" />
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Mobile No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="mobno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Fax No	</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="faxno" class="form-control"   maxlength="100" />
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label">Email id <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-1">
                                            <label class="control-label">1)</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="email1" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <label class="control-label"></label>
                                        </div>
                                        <div class="col-sm-1">
                                            <label class="control-label">2)</label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="email2" class="form-control"   maxlength="100" />
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-9">
                                            <label class="control-label">Statutory Registration Details of Vendor (whichever applicable) </label>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Sales Tax No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="salesno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment Sales Tax No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachsalesno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Service Tax No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="stno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment Service Tax No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachstno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">C.S.T. No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="cstno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment For C.S.T. No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachcstno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">VAT No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="vatno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment for VAT No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachvatno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                        
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Income Tax/PAN NO. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="panno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Attachment for Income Tax/PAN NO. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachpanno" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Vendor Profile Attachment <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" name="attachvendorprofile" class="form-control"   maxlength="100" required="required"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Live Tender No. <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="tenderno" class="form-control"   maxlength="100" required="required"/>
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
                                            <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SUBMIT AND CONTINUE" >
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
     <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
        <!-- Javascript -->
       
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>