<%-- 
    Document   : RightCreate
    Created on : 24-Jun-2020, 22:08:55
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Right</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Right</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Right</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="right.htm?act=submitRightMaster" method="post" commandName="rightMaster"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Right Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="rightName"  class="form-control"   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">User Right :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="u" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="u" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="u" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="u" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Employee Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="e" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="e" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="e" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="e" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Contractor Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="cn" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="cn" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="cn" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="cn" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Apprentice Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="a" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="a" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="a" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="a" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Coupon Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="co" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="co" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="co" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="co" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Card Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="ca" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="ca" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="ca" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="ca" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Wright Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="w" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="w" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="w" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="w" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Report Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="rp" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="rp" value="W" />
                                                Write</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Logs Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="l" value="R" />
                                                Read      </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Recharge Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <input type="checkbox" name="rc" value="R" />
                                                Read      </label>
                                            <label>
                                                <input type="checkbox" name="rc" value="W" />
                                                Write</label>
                                            <label>
                                                <input type="checkbox" name="rc" value="U" />
                                                Update</label>
                                            <label>
                                                <input type="checkbox" name="rc" value="D" />
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>