
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site Survey Edit</title>
    </head>

    <body>

        <script>
            $('#select_all').on('change', function () {
            $('.switch-input').prop('checked', this.checked).trigger('change');
            });        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=SitesurveyeditSubmit" commandName="departmentMaster" enctype="multipart/form-data"  method="post">
                    <input type="hidden" name="id" id="id" value="${id}"/>
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Site Survey Edit</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a href="oapForm.htm?act=Sitesurvey"  class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div>
<c:if test="${!empty failureMessage}">
                    <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                <c:if test="${!empty successMessage}">
                    <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                        <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                        <div>                             
                            <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                        </div>
                    </div>
                </c:if>
                    <hr>

                    <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                    <br>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Site Name<span
                                            class="text-danger">*</span></label>

                                    <input class="input-field" name="sitename" id="sitename" placeholder="Enter Site Name"  value="${siteSurvey.siteName}"    required="required"/>       

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Site Address<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="siteaddress" id="siteaddress" placeholder="Enter Address" value="${siteSurvey.siteAddress}"  required="required"/>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Description<span
                                            class="text-danger">*</span></label>

                                    <textarea class="textarea-field"  name="description" id="description" maxlength="250"   style="resize: vertical; box-sizing: border-box;" required="required">${siteSurvey.description}</textarea>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Start Date<span
                                            class="text-danger">*</span></label>

                                    <div  class="form-group date" id="datetimepickers6" >
                                        <input placeholder="DD/MM/YYYY" name="Fromdate6" id="Fromdate6" type="text" value="${siteSurvey.startDate}"
                                               class="input-field form_datetime" maxlength="30"  autocomplete="off" required="true" 
                                               />
                                    </div>
                                </div>    


                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">End Date<span
                                            class="text-danger">*</span></label>

                                    <div  class="form-group date" id="datetimepickers5" >
                                        <input placeholder="DD/MM/YYYY" name="Fromdate7" id="Fromdate7" value="${siteSurvey.endDate}"  type="text" class="input-field form_datetime"  maxlength="30" autocomplete="off"    required="true"/>
                                    </div>
                                </div>   
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label  class="label">Location<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="location" id="location" placeholder="Enter Location"  value="${siteSurvey.location}"  required="required"/>

                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
$(function () {

                                flatpickr("#Fromdate6", {
                                dateFormat: "d-m-Y", // Set your desired format
                                        allowInput: true, // Allow manual input if required
                                        minDate: "today"     // Disable past dates
                                });
                                });
                                                        </script>

                    <script>
$(function () {

                                flatpickr("#Fromdate7", {
                                dateFormat: "d-m-Y", // Set your desired format
                                        allowInput: true, // Allow manual input if required
                                        minDate: "today" // Set minimum date to today
                                });
                                });
                                                        </script>


                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Type Of Charge<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="typeofcharge" id="typeofcharge" value="${siteSurvey.typeOfCharge}"  placeholder="Enter Type Of Charge"  required="required"/>

                                </div>  
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">No Of Charges<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="noofchargers" id="noofchargers"  value="${siteSurvey.noOfCharges}"  placeholder="Enter No Of Charge" required="required"/>

                                </div>  
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Google Coordinates Of The Location<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="google" id="google" value="${siteSurvey.googleCoordinates}" placeholder="Enter  Google Coordinates"  required="required"/>

                                </div>    
                            </div>
                                    <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Name of Location Partner<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="nameofLocationPartner" id="nameofLocationPartner" value="${siteSurvey.nameofLocationPartner}" placeholder="Enter Name of Location Partner"  required="required"/>

                                </div>    
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Mobile No of Location Partner<span
                                            class="text-danger">*</span></label>

                                    <input  class="input-field"  name="mobileNoLocationPartner" id="mobileNoLocationPartner" value="${siteSurvey.mobileNoLocationPartner}" placeholder="Mobile No of Location Partner"  required="required" oninput="this.value = this.value.replace(/[^0-9]/g, '')"/>

                                </div>    
                            </div>  
                        </div>
                    </div>   
                                    
                                    <c:if test="${not empty SurveyAttach}">
                                        <table id="commonTable" class="table  table-striped bg-white " style="width:100%" align="center">
                                            <thead>
                                                <tr>
                                                    <th>Sr No</th>
                                                    <th>Description</th>
                                                    <th>Attachment</th>
                                                    <th data-dt-order="disable">Action</th>
                                                </tr>
                                            </thead>
                                            <c:forEach var="SurveyAttach" items="${SurveyAttach}" varStatus="status">
                                                <tr>
                                                    <td ><span>${status.count}</span>
                                                    </td> 
                                                    <td ><span>${SurveyAttach.description}</span>
                                                    </td>
                                                    <td>


                                                        <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=surveydownload&fileName=${SurveyAttach.attachment}&id2=${siteSurvey.id}"> ${SurveyAttach.attachment}</a>
                                                    </td> 


                                                    <td style="text-align: center;">

                                                        <a href="oapForm.htm?act=Sitesurveyeditdocdelete&id4=${SurveyAttach.id}&id3=${siteSurvey.id}" class="d-block text-danger p-1 mx-1 action-link" data-toggle="tooltip"
                                                           data-placement="left" title="Delete">
                                                            <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"
                                                                 alt="Delete Icon">
                                                        </a>        


                                                    </td>
                                                </tr>
                                            </c:forEach>  




                                        </table> 
                                    </c:if>
                    <br>

                    <style>
                        #policyTable td {
                            padding: 10px 15px;
                        }
                    </style>
                    <div class="form-group">
                        <div class="col-md-12 p-0">
                            <div class="">
                                <table id="policyTable"  style="width:100%;"  align="center">
                                    <tr style="text-align: center;">

                                        <th >Attachment</th>
                                        <th >Description</th>


                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                    </tr>
                                    <tr id="policyRow1" >

                                        <td >
                                            <input id="attachment1" name="attach" class="input-field" type="file"onchange="validateFileSize(this)">
                                            <span id="fileError" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>

                                        </td> 



                                        <td>
                                            <input id="description1" name="descriptions" placeholder="Description" class="input-field" type="text" >
                                        </td> 

                                        <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                            <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                                <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                            </div>
                                        </td>




                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>

                    <script>

                                function validateFileSize(input) {
                                const file = input.files[0];
                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                        var errorSpan = input.parentNode.querySelector("span");
                                        if (file && file.size > maxSize) {
                                errorSpan.style.display = 'block';
                                        input.value = '';
                                } else {
                                errorSpan.style.display = 'none';
                                }
                                }

                        var tempCount3 = 1;
                                $(function () {
                                $("#policyCloneid").on("click", function () {
                                tempCount3++;
                                        var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"

                                        + "<td><input type=\"file\" class=\"input-field\" name=\"attach\" id=\"attachment" + tempCount3 + "\" onchange=\"validateFileSize(this)\">"
                                        + "<span id='fileError" + tempCount3 + "' style='display:none; color:red; font-size:12px;'>* File should not exceed 5MB</span></td>"

                                        + "<td><input type=\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions\" id=\"description" + tempCount3 + "\"></td>"

                                        + "<td style='text-align: center' class='d-flex justify-content-center align-items-center'>"
                                        + "<div class='clone-action delete-parent-field' title='Remove' style='cursor:pointer;' "
                                        + "onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                                        + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                                        + "</div></td>"

                                        + "</tr>";
                                        $("#policyTable").append(clone);
                                        document.getElementById('policyCount').value = tempCount3;
                                });
                                });
                                function removePolicy(policyDiv) {
                                try {
                                var element1 = document.getElementById(policyDiv);
                                        element1.parentNode.removeChild(element1);
                                        var policyCount = document.getElementById('policyTable').rows.length - 1;
                                        document.getElementById('policyCount').value = policyCount;
                                } catch (e) {
                                console.log(e);
                                }
                                }

                    </script>          


                    <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div> 


                </form:form>
            </section>
        </main>
    </body>
     <script>
document.addEventListener("DOMContentLoaded", function () {

    document.querySelectorAll('.action-link').forEach(function (el) {

        el.addEventListener('click', function (e) {

            // only for delete links
            if (!this.href.includes("Sitesurveyeditdocdelete")) {
                return;
            }

            e.preventDefault();

            let url = this.getAttribute('href');

            Swal.fire({
                title: 'Are you sure?',
                text: 'This will delete the Site Survey Attachment!',
                icon: 'warning',
                
                
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: 'theme-btn light-btn',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {

                if (result.isConfirmed) {

                    Swal.fire({
                        icon: 'success',
                        title: 'Site Survey Attachment deleted successfully.',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => {
                        window.location.href = url;
                    });
                }

            });

        });

    });

});
</script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
   


</html>
