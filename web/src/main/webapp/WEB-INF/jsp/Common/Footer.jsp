<%--
    Document   : footer
    Created on : 21/05/2021
    Author     : chetan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <!--<script src="StorageYard/Plugins/jQuery/jQuery-2.1.4.min.js"></script>-->
    <!--============= Move On Last in this Page ===========================-->
    <!--<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->
    <!--============= Move On Last in this Page =================================-->
    <script src="StorageYard/Plugins/jQueryUI/jquery-ui.min.js"></script>
    <script src="StorageYard/Plugins/fastclick/fastclick.min.js"></script>
    <script src="StorageYard/JS/bootstrap/app.min.js"></script>
    <script src="StorageYard/Plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="StorageYard/Plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="StorageYard/Plugins/chartjs/Chart.min.js"></script>
    <script src="StorageYard/Plugins/daterangepicker/moment.min.js"></script>
    <script src="StorageYard/Plugins/fullcalendar/fullcalendar.min.js"></script>
    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="StorageYard/Plugins/iCheck/icheck.min.js"></script>
    <script src="StorageYard/JS/JQuery/common.js"></script>
    <script src="StorageYard/JS/bootstrap/jquery.tokeninput.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>


    
    <div class="footer-copyright-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer-copy-right">
                        <br>© 2023 <a href="http://www.bulwarks.com/" target="_blank"><strong>Bulwark Systems</strong></a> All rights reserved.
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<label style="font-weight: normal;float: right;"> © 2019 <a href="http://www.gipcl.com/" target="_blank"><strong>GIPCL</strong></a> All rights reserved. </label>--%>
    <script>
        //==============================================================//
        //set time out for errorDiv Class
        window.setTimeout(function () {
            $(".errorDiv").fadeTo(500, 0).slideUp(500, function () {
                $(this).remove();
            });
        }, 8000);
        //============================================================//
    </script>
</body>
</html>
