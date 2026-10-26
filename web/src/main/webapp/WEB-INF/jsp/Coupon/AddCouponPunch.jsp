<%-- 
    Document   : addCouponPunch
    Created on : 21-Jul-2020, 11:44:18
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Coupon Punch</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Employee</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Add Coupon Punch</li>
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
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="specialCoupon.htm?act=submitAddCopounPunch" method="post" commandName="employeeMaster"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Card Code :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input name="cardCode" id="cardCode" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Date :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <div class="input-group date form_datetime"   data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                                                <input name="date" id="date"  class="form-control"  size="16" readonly="true" />
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="col-md-12 col-sm-12">
                                        <div class="table-responsive">
                                            <table id="couponTypeTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <tr>
                                                    <th style="text-align: center; vertical-align: middle">Item</th>
                                                    <th style="text-align: center; vertical-align: middle">Quantity</th>
                                                    <!--<th style="text-align: center; vertical-align: middle">Price</th>-->
                                                    <th style="text-align: center; vertical-align: middle">Add</th>
                                                        <c:choose>
                                                            <c:when test="${not empty finalFeeTypeList}">
                                                        <input type="hidden" name="couponTypeCount" id="couponTypeCount"  value="${fn:length(finalFeeTypeList)}"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="hidden" name="couponTypeCount" id="couponTypeCount" value="1"/>
                                                    </c:otherwise>
                                                </c:choose>
                                                </tr>
                                                <tr>
                                                    <!--<td style="text-align: center">1</td>-->
                                                    <td id="perquisitesTd1"><div>
                                                            <select id="item1"  name="item1"  class="form-control">
                                                                <option value="">--SELECT--</option>
                                                                <c:forEach var="couponType" items="${couponType}" varStatus = "status">
                                                                    <option value="${couponType}">${couponType}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </td>
                                                    <td style="text-align: center">
                                                        <input type="number" name="quantity1"  step="any" id="quantity1" min="0" class="form-control" >
                                                    </td>
<!--                                                    <td style="text-align: center">
                                                        <select id="price1"  name="price1"  class="form-control">
                                                            <option value="A">Actual</option>
                                                            <option value="S1">Subsidies 1</option>
                                                            <option value="S2">Subsidies 2</option>
                                                        </select>   
                                                    </td>-->
                                                    <td style="text-align: center">
                                                        <span style='margin-top: 5px;'>
                                                            <input type="button" value="+" id="couponTypeCloneid" />
                                                        </span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>   



                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
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
        });</script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        $(function () {
            $("#couponTypeCloneid").on("click", function () {
                //                alert("heeeeee");
                var tempCount6 = $('#couponTypeCount').val();
                //                alert(tempCount5);
                tempCount6++;
                var clone = "<tr id='" + tempCount6 + "' style='clear:both;'>"
                        //                        + "<td style=\"text-align: center\">" + tempCount6 + "</td>"
                        + "<td><div><select id=\"item" + tempCount6 + "\" name='item" + tempCount6 + "' class=\"form-control\">"
                        //                        + "<option value =\"\"> --SELECT-- </option>"
                        + "</select>"
                        + "</div></td>"
                        + "<td style=\"text-align: center\"><input type=\"number\" step=\"any\"  name='quantity" + tempCount6 + "' id='quantity" + tempCount6 + "' min=\"0\" class=\"form-control\"></td>"
//                        + "<td><div><select id=\"price" + tempCount6 + "\" name='price" + tempCount6 + "' class=\"form-control\">"
////                        + "<option value =\"\"> --SELECT-- </option>"
//                        + "  <option value='A'>Actual</option>"
//                        + "<option value='S1'>Subsidies 1</option>"
//                        + "<option value='S2'>Subsidies 2</option>"
//                        + "</select>"
//                        + "</div></td>"
                        + "<td style=\"text-align: center\">"
                        + "<span style='margin-top: 5px;'>"
                        + "<input type=\"button\"value=\"-\"  onclick=\"removeFeeType('" + tempCount6 + "');\"/>"
                        + "</span>"
                        + "</td>"
                        + "</tr>";
                $("#couponTypeTable").append(clone);

                document.getElementById('couponTypeCount').value = tempCount6;
                addFeeType(tempCount6);
                //                alert(tempCount5);
                //
            });
        });
        function addFeeType(id) {
            //            alert(id);
            var element2 = document.getElementById('item1');
            var obj2 = document.getElementById("item" + id);
            for (var i2 = 0; i2 < element2.options.length; i2++) {
                var opt2 = document.createElement("option");
                opt2.value = element2.options[i2].value;
                opt2.text = element2.options[i2].text;
                obj2.appendChild(opt2);
            }
        }

        function removeFeeType(policyDiv) {
            try {
                var val = document.getElementById("couponTypeCount").value;
                val = val - 1;
                document.getElementById("couponTypeCount").value = val;
                element1 = document.getElementById(policyDiv);
                //
                element1.parentNode.removeChild(element1);
            } catch (e) {

            }
        }



    </script>

</html>
