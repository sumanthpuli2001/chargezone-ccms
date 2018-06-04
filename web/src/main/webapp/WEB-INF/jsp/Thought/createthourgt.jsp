<%-- 
    Document   : Dashbordsetting
    Created on : 20 Feb, 2018, 9:57:16 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Dashbord Setting </title>
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>DASHBOARD SETTING</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li><li>Setting</li>
                <li class="active">Dashbord Setting</li>
            </ol>
        </section>
       <ul class="nav nav-tabs">
    <li class="active"><a href="">Thought oF the Day</a></li>
    <li><a href="thoughtMaster.htm?act=createthought1">Upload Video</a></li>
    <li><a href="thoughtMaster.htm?act=createthought2">Gallery</a></li>
    <li><a href="thoughtMaster.htm?act=createthought3">R & R</a></li>
  </ul> 
        <form:form class="form-horizontal" role="form1" action="thoughtMaster.htm?act=Submitthought"  method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                 <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Thought OF The Day:<span style="color: red;font-size: 12px;"></span></label>
                                                        <textarea  id="thought" name="thought" class="form-control"></textarea>
                                                    </div>
                                                    <div class="col-sm-6">
                                                    <label>Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input type="text" id="date" name="date" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>

                                                </div>



                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >submit</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    </script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
