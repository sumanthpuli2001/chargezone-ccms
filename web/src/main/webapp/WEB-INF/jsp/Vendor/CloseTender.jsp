<%-- 
    Document   : CLOSE TENDER
    Created on : 21 Nov, 2024, 4:53:21 PM
    Author     : Bulwark-5
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLOSE TENDER</title>
    </head>

    <body >
          <script>
            jQuery.noConflict();
            jQuery(document).ready(function () {

                jQuery("#employeeName").tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. ."
                });
            });

        </script>

        <script>
            $('#select_all').on('change', function () {
                $('.switch-input').prop('checked', this.checked).trigger('change');
            });
        </script>
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNewVendor.jsp"%>
            <section class="main-content">
                <form:form action="employeeMaster.htm?act=disableEmployee" method="post" 
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>
                            <h5 class="fw-600 mb-0">CLOSE TENDER</h5>
                        </div>
                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                        </div>
                    </div> 
                    <hr>                  
                     <table id="commonTable" class="table table-striped bg-white" style="min-width: 100%;" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                           
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Tender Ref No.</th>
                                                                    <th>Project Name </th>
                                                                    <th>Tender Date </th>
                                                                    <th>Tender Due Date </th>
                                                                    <th>Tender Type </th>
                                                                  <!--  <th>Bid View</th> -->
                                                                    <th data-dt-order="disable">Print</th>
                                                                  
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        
                                                                        <td>${list[0]}</td>
                                                                        <td>${list[1]}</td>
                                                                        <td>${list[2]}</td>
                                                                        <td>${list[3]}</td>
                                                                        <td>${list[4]} Part</td>
                                                                        <td>
                                                                                <a  href="vendor.htm?act=priceBidVendorSidePrint&refNo=${list[0]}&vendorCode=${username}">Print</a><br>
                                                                                
                                                                                <c:if test="${list[6] == '1'}">
                                                                                    <a  href="vendor.htm?act=revisePriceBidReviseVenSidePrint&refNo=${list[0]}&vendorCode=${username}">Revise Bid Print</a>
                                                                                </c:if>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                        </form:form>  
                </section>
            </main>
        </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    <script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }
    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var j;
        var imgsize = 1;

        var slides = document.getElementsByClassName("mySlides");


        if (n > slides.length) {
            slideIndex = 1;
        }
        if (n < 1) {
            slideIndex = slides.length;
        }
        if (n === 1 && slides.length === 0) {
            slides.length = 1;

        }

        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slides[slideIndex - 1].style.display = "block";


    }


</script>

<script>
    showSlides();
    var slideIndex = 0;

    function showSlides() {
        var slides = document.getElementsByClassName("mySlides");
        var n;

        for (n = 0; n < slides.length; n++) {
            slides[n].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1;
        }

        slides[slideIndex - 1].style.display = "block";

        setTimeout(showSlides, 5000); // Change image every 2 seconds
    }
</script>



<script>
    var rrslideIndex = 1;
    rrshowSlides(rrslideIndex);

    function rrplusSlides(n) {
        rrshowSlides(rrslideIndex += n);
    }
    function rrcurrentSlide(n) {
        rrshowSlides(rrslideIndex = n);
    }

    function rrshowSlides(n) {
        var i;
        var j;
        var imgsize = 1;

        var rrslides = document.getElementsByClassName("rrmySlides");


        if (n > rrslides.length) {
            rrslideIndex = 1;
        }
        if (n < 1) {
            rrslideIndex = rrslides.length;
        }
        if (n === 1 && rrslides.length === 0) {
            rrslides.length = 1;

        }

        for (i = 0; i < rrslides.length; i++) {
            rrslides[i].style.display = "none";
        }

        rrslides[rrslideIndex - 1].style.display = "block";


    }


</script>
<script>
    rrshowSlides();
    var rrslideIndex = 0;

    function rrshowSlides() {
        var rrslides = document.getElementsByClassName("rrmySlides");
        var n;

        for (n = 0; n < rrslides.length; n++) {
            rrslides[n].style.display = "none";
        }
        rrslideIndex++;
        if (rrslideIndex > rrslides.length) {
            rrslideIndex = 1;
        }

        rrslides[rrslideIndex - 1].style.display = "block";

        setTimeout(rrshowSlides, 5000); // Change image every 2 seconds
    }
</script>
  </html>
