

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Site Survey</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                 alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                 alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Site Survey</h5>
                    </div>

                    <!-- If No data available then Hide this button -->
                    <div class="cta d-flex align-items-center">
                        <!--                        <button id="deleteSelected" class="btn theme-btn delete-btn d-none">
                                                    <img src="StorageYard/assets/images/delete-icon.svg" class="icon" onload="SVGInject(this)"
                                                         alt="Delete Icon">
                                                    Delete Selected
                                                </button>-->
                        <a onclick="window.location = 'oapForm.htm?act=Sitesurveypage'" class="btn theme-btn flex ml-3">
                            <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                            Add New
                        </a>
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
               <div class="mt-3 table-responsive">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <div>
                        <select id="entriesPerPage" class="select-input">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                            <option value="-1">ALL</option>
                        </select>
                    </div>
                    <div>
                        <input type="text" id="searchBox" class="input-field" placeholder="Search here...">
                    </div>
                </div>
                <table id="SiteSurveyTable" class="table table-striped bg-white" style="width:100%">
                    <thead>
                        <tr>
                           <th>Sr No</th>
                                <th>Survey Document No</th>
                                <th style="min-width: 190px;">Site Name</th>
                                <th style="min-width: 250px;">Site Address</th>
                                <th style="min-width: 250px;">Description</th>
                                <th style="min-width: 150px;">Start Date</th>
                                <th style="min-width: 150px;">End Date </th>
                                <th  style="min-width: 150px;">Created By</th>
                                <th  style="min-width: 150px;">Status</th>
                            <th class="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>

               

            </section>
        </main> 
    </body>
    <div class="modal fade" id="closeSiteSurvey" data-backdrop="static" data-keyboard="false" tabindex="-1"
         aria-labelledby="closeSiteSurveyLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">

                <div class="modal-header align-items-center">
                    <h5 class="modal-title" id="closeSiteSurveyLabel">Close Site Survey :</h5>
                    <div class="cta-btn d-flex align-items-center">
                        <button type="button" class="btn theme-btn light-btn" data-dismiss="modal"
                                onclick="event.preventDefault();">Close</button>
                        <button type="button" class="btn theme-btn ml-3" id="closeSurveyButton" title="">Submit</button>

                    </div>
                </div>

                <div class="modal-body">
                    <div id="resultDiv" class="bg-white">
                        <div style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                        <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                        <div>
                            <span style="font-weight: bold;">*</span> Fields marked with an asterisk are mandatory.
                        </div>
                    </div>
                        <br>
                        <div class="col-12 p-0">
                            <input type="hidden" name="id" id="id">

                            <div class="form-group comment-box">
                                <label class="control-label">Remark :<span class="text-danger">*</span></label>
                                <textarea type="text" maxlength="250" class="textarea-field remark" id="remark" name="remark"   required="true"></textarea>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
   $(document).ready(function () {

    var table = $('#SiteSurveyTable').DataTable({
        processing: true,
        serverSide: true,
        stateSave: false,
        ordering: true,
        orderMulti: false,
        order:       [[0, 'desc']],
        ajax: {
            url: 'formsCommon.htm?act=sitesurveyPaginationAjax',
            type: 'POST',
            cache: false,
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        },

        columns: [
          
            {
                data: 'srNo',
                orderable: true,
                searchable: true
            },
            {
                data: 'surveyDocumentNo',
                orderable: true,
                searchable: true
            },
            {
                data: 'siteName',
                orderable: true,
                searchable: true
            },
            {
                data: 'siteAddress',
                orderable: true,
                searchable: true
            },
            {
                data: 'description',
                orderable: true,
                searchable: true
            },
            {
                data: 'startDate',
                orderable: true,
                searchable: true
            },
            {
                data: 'endDate',
                orderable: true,
                searchable: true
            },
            {
                data: 'createdBy',
                orderable: true,
                searchable: true
            },
            {
                data: 'flagStatus',
                orderable: true,
                searchable: true
            },
            {
                data: 'action',
                orderable: false,
                searchable: false,
                render: function (data) {
                    return data;
                }
            }

        ],

        pageLength: 10,
        lengthChange: false,
        searching: true,
        info: true,
        autoWidth: false,
        responsive: true,
        scrollX: true,
        scrollCollapse: true,                                                    
        scrollY: '80vh',
        dom: 'rt<"table-bottom-info d-flex align-items-center justify-content-between pt-3"i p>'

    });

     $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });

    $('#entriesPerPage').on('change', function () {
        var val = $(this).val();
        if (val === "" || val === "-1") {
            var total = table.page.info().recordsTotal;
            table.page.len(total > 0 ? total : 1).draw();
        } else {
            table.page.len(parseInt(val, 10)).draw();
        }
    });
   
});
</script>
  <script>
   function loadClosesite(id) {
    console.log("Site Survey ID received:", id);
    document.getElementById("id").value = id;
}

document.addEventListener("DOMContentLoaded", function () {

    document.getElementById('closeSurveyButton').addEventListener('click', function () {

        var remark = document.getElementById("remark").value.trim();
        var Surveyid = document.getElementById("id").value.trim();

        if (Surveyid === "") {
            console.error("Missing Survey ID");
            return;
        }

        if (remark === "") {
            Swal.fire({
                title: 'Required Field',
                text: 'Remark is required.',
                icon: 'warning'
            });
            return;
        }

        Swal.fire({
            title: "Are you sure?",
            text: "Do you really want to close this Survey?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonText: "Yes, Close It"
        }).then((result) => {

            if (result.isConfirmed) {

                var btn = document.getElementById("closeSurveyButton");
                btn.disabled = true;

                var formData = new FormData();
                formData.append("id", Surveyid);
                formData.append("remark", remark);

                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'oapForm.htm?act=sitesurveyClose', true);

                xhr.onload = function () {
                    if (xhr.status === 200) {

                        Swal.fire({
                            icon: 'success',
                            title: 'Survey Closed Successfully'
                        }).then(() => {
                            location.reload();
                        });

                    } else {
                        console.error("Error: " + xhr.statusText);
                        btn.disabled = false;
                    }
                };

                xhr.onerror = function () {
                    console.error("Request failed.");
                    btn.disabled = false;
                };

                xhr.send(formData);
            }
        });
    });

});
                                </script>  
    
    
    
    
    
    
    
    
   
    

    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

  





</html>


