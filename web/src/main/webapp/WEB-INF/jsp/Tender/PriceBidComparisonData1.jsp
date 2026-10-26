<%-- 
    Document   : PriceBidComparisonData1
    Created on : 19 Jan, 2024, 9:46:18 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Price Comparison</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" >
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tender Price Comparison</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Price Comparison</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">

            

                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <div class="box-header">
                                        </div>
                                        <div class="box-body no-padding">

                                            <div class="row">

                                                <div class="col-md-12 col-sm-12">
                                                    <P align="right" class="content-header" style="margin: 0px;box-shadow : none">
                                                        <input type="button" class="btn btn-primary" style="width: 100px;" onclick="history.back();" title="" value="Back" >
                                                        <input type="button" class="btn btn-primary" style="width: 100px;" onclick="window.print();" title="" value="Print" >
                                                    </P>

                                                  
                                                    <!--                                            <div class="table">-->



                                                    <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                        <tr>
                                                            <td  style="padding: 0px;">Tender No.</td>
                                                            <td  style="padding: 0px;">${tenderMaster.refNo}</td>
                                                        </tr>
                                                        <tr>
                                                            <td  style="padding: 0px;">Tender Title</td>
                                                            <td  style="padding: 0px;">${tenderMaster.title}</td>
                                                            <td  style="padding: 0px;">Tender ID</td>
                                                            <td  style="padding: 0px;">${tenderMaster.projectId}</td>
                                                        </tr>
                                                        <tr>
                                                            <td  style="padding: 0px;">Tender Start Date</td>
                                                            <td  style="padding: 0px;">${tenderMaster.announceDate}</td>
                                                            <td  style="padding: 0px;">Tender End Date</td>
                                                            <td  style="padding: 0px;">${tenderMaster.submitLastdate}</td>
                                                        </tr>
                                                        <tr>
                                                            <td  style="padding: 0px;">PR No.</td> 
                                                            <td  style="padding: 0px;">${tenderMaster.prNo}</td>
                                                            <td  style="padding: 0px;">PR Item No.</td> 
                                                            <td  style="padding: 0px;">${tenderMaster.prItemNo}</td>
                                                        </tr>
                                                        <tr>
                                                            <td  style="padding: 0px;">Created By</td>
                                                            <td  style="padding: 0px;">${tenderMaster.contactPerson}</td>

                                                        </tr>
                                                        <tr>
                                                            <td  style="padding: 0px;">Plant Name</td>
                                                            <td  style="padding: 0px;">${tenderMaster.plantName}</td>

                                                        </tr>
                                                    </table>
                                                    <style> 
                                                        .table_wrapper{
                                                            display: block;
                                                            overflow-x: auto;
                                                            white-space: wrap;
                                                        }
                                                    </style>  
                                                    
                                                    <c:set var="i" value="0"/>
                                                    <div class="table_wrapper">
                                                        <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                            <c:forEach var="finalList" items="${finalList}" varStatus="status">
                                                                <c:set var="i" value="${finalList.size()}"/>
                                                                <tr>
                                                                    <td style="padding: 0px;">Sr No.</td>
                                                                    <td style="padding: 0px;">Item Details</td>
                                                                    <td style="padding: 0px;">Plant</td>
                                                                    <td style="padding: 0px;">Quantity</td>
                                                                    <td style="padding: 0px;">UOM</td>
                                                                    <td style="padding: 0px;">Condition Value</td>
                                                                    <td style="padding: 0px;">${finalList[5]}</td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">${finalList[65]}</td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td style="padding: 0px;">${finalList[125]}</td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td style="padding: 0px;">${finalList[185]}</td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td rowspan="11"  style="padding: 0px;">${status.count}</td>
                                                                    <td rowspan="11" style="padding: 0px;">${finalList[1]} ${finalList[2]}</td>
                                                                    <td rowspan="11" style="padding: 0px;">${tenderMaster.plantName}</td>
                                                                    <td rowspan="11" style="padding: 0px;">${finalList[4]}</td>
                                                                    <td rowspan="11" style="padding: 0px;">${finalList[3]}</td>
                                                                    <td style="padding: 0px;">Basic Price</td>
                                                                    <td style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">${finalList[36]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">${finalList[9]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">${finalList[96]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">${finalList[69]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">${finalList[156]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">${finalList[129]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">${finalList[216]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">${finalList[189]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Discount</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">
                                                                            <c:if test="${finalList[41] == '0'}">
                                                                                (${finalList[42]} %) 
                                                                            </c:if>
                                                                            ${finalList[43]}
                                                                        </c:if>
                                                                        <c:if test="${finalList[59] == ''}">
                                                                            <c:if test="${finalList[12] == '0'}">
                                                                                (${finalList[13]} %) 
                                                                            </c:if>
                                                                            ${finalList[14]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">
                                                                                <c:if test="${finalList[101] == '0'}">
                                                                                    (${finalList[102]} %) 
                                                                                </c:if>
                                                                                ${finalList[103]}
                                                                            </c:if>
                                                                            <c:if test="${finalList[119] == ''}">
                                                                                <c:if test="${finalList[72] == '0'}">
                                                                                    (${finalList[73]} %) 
                                                                                </c:if>
                                                                                ${finalList[74]}
                                                                            </c:if>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">
                                                                                <c:if test="${finalList[161] == '0'}">
                                                                                    (${finalList[162]} %) 
                                                                                </c:if>
                                                                                ${finalList[163]}
                                                                            </c:if>
                                                                            <c:if test="${finalList[179] == ''}">
                                                                                <c:if test="${finalList[132] == '0'}">
                                                                                    (${finalList[133]} %) 
                                                                                </c:if>
                                                                                ${finalList[134]}
                                                                            </c:if>
                                                                        </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">
                                                                                <c:if test="${finalList[221] == '0'}">
                                                                                    (${finalList[222]} %) 
                                                                                </c:if>
                                                                                ${finalList[123]}
                                                                            </c:if>
                                                                            <c:if test="${finalList[239] == ''}">
                                                                                <c:if test="${finalList[192] == '0'}">
                                                                                    (${finalList[193]} %) 
                                                                                </c:if>
                                                                                ${finalList[194]}
                                                                            </c:if>
                                                                        </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Packing & Forwarding</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">(${finalList[45]} %) ${finalList[46]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">(${finalList[16]} %) ${finalList[17]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">(${finalList[105]} %) ${finalList[106]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">(${finalList[76]} %) ${finalList[77]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">(${finalList[165]} %) ${finalList[166]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">(${finalList[136]} %) ${finalList[137]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">(${finalList[225]} %) ${finalList[226]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">(${finalList[196]} %) ${finalList[197]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Errection</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">(${finalList[48]} %) ${finalList[49]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">(${finalList[19]} %) ${finalList[20]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">(${finalList[108]} %) ${finalList[109]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">(${finalList[79]} %) ${finalList[80]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">(${finalList[168]} %) ${finalList[169]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">(${finalList[139]} %) ${finalList[140]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">(${finalList[228]} %) ${finalList[229]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">(${finalList[199]} %) ${finalList[200]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Other Charges</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">(${finalList[51]} %) ${finalList[52]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">(${finalList[22]} %) ${finalList[23]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">(${finalList[111]} %) ${finalList[112]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">(${finalList[82]} %) ${finalList[83]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">(${finalList[171]} %) ${finalList[172]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">(${finalList[142]} %) ${finalList[143]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">(${finalList[231]} %) ${finalList[232]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">(${finalList[202]} %) ${finalList[203]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">GST</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">(${finalList[54]} %) ${finalList[55]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">(${finalList[25]} %) ${finalList[26]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">(${finalList[114]} %) ${finalList[115]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">(${finalList[85]} %) ${finalList[86]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">(${finalList[174]} %) ${finalList[175]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">(${finalList[145]} %) ${finalList[146]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">(${finalList[234]} %) ${finalList[235]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">(${finalList[205]} %) ${finalList[206]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Insurance</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">(${finalList[57]} %) ${finalList[58]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">(${finalList[28]} %) ${finalList[29]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">(${finalList[117]} %) ${finalList[118]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">(${finalList[88]} %) ${finalList[89]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">(${finalList[177]} %) ${finalList[178]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">(${finalList[148]} %) ${finalList[149]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">(${finalList[237]} %) ${finalList[238]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">(${finalList[208]} %) ${finalList[209]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Landed Rate</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">${finalList[59]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">${finalList[30]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">${finalList[119]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">${finalList[90]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">${finalList[179]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">${finalList[150]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">${finalList[239]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">${finalList[210]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Total Value</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">${finalList[38]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">${finalList[11]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">${finalList[98]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">${finalList[71]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">${finalList[158]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">${finalList[131]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">${finalList[218]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">${finalList[191]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Freight</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">${finalList[61]} ${finalList[64]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">${finalList[32]} ${finalList[35]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">${finalList[121]} ${finalList[124]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">${finalList[92]} ${finalList[95]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">${finalList[181]} ${finalList[184]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">${finalList[152]} ${finalList[155]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">${finalList[241]} ${finalList[244]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">${finalList[212]} ${finalList[215]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                                <tr>
                                                                    <td  style="padding: 0px;">Make / Model</td>
                                                                    <td  style="padding: 0px;">
                                                                        <c:if test="${finalList[59] != ''}">${finalList[60]}</c:if>
                                                                        <c:if test="${finalList[59] == ''}">${finalList[31]}</c:if>
                                                                        </td>
                                                                    <c:if test="${finalList.size() > 66}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[119] != ''}">${finalList[120]}</c:if>
                                                                            <c:if test="${finalList[119] == ''}">${finalList[91]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 126}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[179] != ''}">${finalList[180]}</c:if>
                                                                            <c:if test="${finalList[179] == ''}">${finalList[151]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                    <c:if test="${finalList.size() > 186}">
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[239] != ''}">${finalList[240]}</c:if>
                                                                            <c:if test="${finalList[239] == ''}">${finalList[211]}</c:if>
                                                                            </td>
                                                                    </c:if>
                                                                </tr>
                                                            </c:forEach>
                                                        </table>

                                                    </div>




                                                    <c:if test="${i > 246}">
                                                        <p style="page-break-after: always;">&nbsp;</p>
                                                        <div class="table_wrapper">
                                                            <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                                <c:forEach var="finalList" items="${finalList}" varStatus="status">
                                                                    <c:set var="i" value="${finalList.size()}"/>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Sr No.</td>
                                                                        <td  style="padding: 0px;">Item Details</td>
                                                                        <td  style="padding: 0px;">Plant</td>
                                                                        <td  style="padding: 0px;">Quantity</td>
                                                                        <td  style="padding: 0px;">UOM</td>
                                                                        <td  style="padding: 0px;">Condition Value</td>
                                                                        <td  style="padding: 0px;">${finalList[245]}</td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">${finalList[305]}</td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">${finalList[365]}</td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">${finalList[425]}</td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td rowspan="11">${status.count}</td>
                                                                        <td rowspan="11">${finalList[1]} ${finalList[2]}</td>
                                                                        <td rowspan="11">${tenderMaster.plantName}</td>
                                                                        <td rowspan="11">${finalList[4]}</td>
                                                                        <td rowspan="11">${finalList[3]}</td>
                                                                        <td  style="padding: 0px;">Basic Price</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">${finalList[276]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">${finalList[249]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">${finalList[336]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">${finalList[309]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">${finalList[396]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">${finalList[369]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">${finalList[456]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">${finalList[429]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Discount</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">
                                                                                <c:if test="${finalList[281] == '0'}">
                                                                                    (${finalList[282]} %) 
                                                                                </c:if>
                                                                                ${finalList[283]}
                                                                            </c:if>
                                                                            <c:if test="${finalList[299] == ''}">
                                                                                <c:if test="${finalList[252] == '0'}">
                                                                                    (${finalList[253]} %) 
                                                                                </c:if>
                                                                                ${finalList[254]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">
                                                                                    <c:if test="${finalList[341] == '0'}">
                                                                                        (${finalList[342]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[343]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[359] == ''}">
                                                                                    <c:if test="${finalList[312] == '0'}">
                                                                                        (${finalList[313]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[314]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">
                                                                                    <c:if test="${finalList[401] == '0'}">
                                                                                        (${finalList[402]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[403]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[419] == ''}">
                                                                                    <c:if test="${finalList[372] == '0'}">
                                                                                        (${finalList[373]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[374]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">
                                                                                    <c:if test="${finalList[461] == '0'}">
                                                                                        (${finalList[462]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[463]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[479] == ''}">
                                                                                    <c:if test="${finalList[432] == '0'}">
                                                                                        (${finalList[433]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[434]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Packing & Forwarding</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">(${finalList[285]} %) ${finalList[286]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">(${finalList[256]} %) ${finalList[257]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">(${finalList[355]} %) ${finalList[346]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">(${finalList[316]} %) ${finalList[317]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">(${finalList[405]} %) ${finalList[406]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">(${finalList[376]} %) ${finalList[377]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">(${finalList[465]} %) ${finalList[466]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">(${finalList[436]} %) ${finalList[437]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Errection</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">(${finalList[288]} %) ${finalList[289]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">(${finalList[259]} %) ${finalList[260]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">(${finalList[348]} %) ${finalList[349]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">(${finalList[319]} %) ${finalList[320]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">(${finalList[408]} %) ${finalList[409]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">(${finalList[379]} %) ${finalList[380]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">(${finalList[468]} %) ${finalList[469]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">(${finalList[439]} %) ${finalList[440]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Other Charges</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">(${finalList[291]} %) ${finalList[292]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">(${finalList[262]} %) ${finalList[263]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">(${finalList[351]} %) ${finalList[352]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">(${finalList[322]} %) ${finalList[323]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">(${finalList[411]} %) ${finalList[412]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">(${finalList[382]} %) ${finalList[383]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">(${finalList[471]} %) ${finalList[472]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">(${finalList[442]} %) ${finalList[443]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">GST</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">(${finalList[294]} %) ${finalList[295]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">(${finalList[265]} %) ${finalList[266]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">(${finalList[354]} %) ${finalList[355]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">(${finalList[325]} %) ${finalList[326]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">(${finalList[414]} %) ${finalList[415]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">(${finalList[385]} %) ${finalList[386]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">(${finalList[474]} %) ${finalList[475]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">(${finalList[445]} %) ${finalList[446]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Insurance</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">(${finalList[297]} %) ${finalList[298]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">(${finalList[268]} %) ${finalList[269]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">(${finalList[357]} %) ${finalList[358]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">(${finalList[328]} %) ${finalList[329]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">(${finalList[417]} %) ${finalList[418]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">(${finalList[388]} %) ${finalList[389]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">(${finalList[477]} %) ${finalList[478]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">(${finalList[448]} %) ${finalList[449]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Landed Rate</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">${finalList[299]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">${finalList[270]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">${finalList[359]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">${finalList[330]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">${finalList[419]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">${finalList[390]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">${finalList[479]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">${finalList[450]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Total Value</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">${finalList[278]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">${finalList[251]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">${finalList[338]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">${finalList[311]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">${finalList[398]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">${finalList[371]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">${finalList[458]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">${finalList[431]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Freight</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">${finalList[301]} ${finalList[304]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">${finalList[272]} ${finalList[275]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">${finalList[361]} ${finalList[364]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">${finalList[332]} ${finalList[335]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">${finalList[421]} ${finalList[424]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">${finalList[392]} ${finalList[395]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">${finalList[481]} ${finalList[484]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">${finalList[452]} ${finalList[455]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Make / Model</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[299] != ''}">${finalList[300]}</c:if>
                                                                            <c:if test="${finalList[299] == ''}">${finalList[271]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 306}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[359] != ''}">${finalList[360]}</c:if>
                                                                                <c:if test="${finalList[359] == ''}">${finalList[331]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 366}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[419] != ''}">${finalList[420]}</c:if>
                                                                                <c:if test="${finalList[419] == ''}">${finalList[391]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 426}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[479] != ''}">${finalList[480]}</c:if>
                                                                                <c:if test="${finalList[479] == ''}">${finalList[451]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </div>
                                                    </c:if>


                                                    <c:if test="${i > 486}">
                                                        <p style="page-break-after: always;">&nbsp;</p>
                                                        <div class="table_wrapper">
                                                            <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                                <c:forEach var="finalList" items="${finalList}" varStatus="status">
                                                                    <c:set var="i" value="${finalList.size()}"/>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Sr No.</td>
                                                                        <td  style="padding: 0px;">Item Details</td>
                                                                        <td  style="padding: 0px;">Plant</td>
                                                                        <td  style="padding: 0px;">Quantity</td>
                                                                        <td  style="padding: 0px;">UOM</td>
                                                                        <td  style="padding: 0px;">Condition Value</td>
                                                                        <td  style="padding: 0px;">${finalList[485]}</td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">${finalList[545]}</td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">${finalList[605]}</td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">${finalList[665]}</td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td rowspan="11">${status.count}</td>
                                                                        <td rowspan="11">${finalList[1]} ${finalList[2]}</td>
                                                                        <td rowspan="11">${tenderMaster.plantName}</td>
                                                                        <td rowspan="11">${finalList[4]}</td>
                                                                        <td rowspan="11">${finalList[3]}</td>
                                                                        <td  style="padding: 0px;">Basic Price</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">${finalList[516]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">${finalList[489]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">${finalList[576]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">${finalList[549]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">${finalList[636]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">${finalList[609]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">${finalList[696]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">${finalList[669]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Discount</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">
                                                                                <c:if test="${finalList[521] == '0'}">
                                                                                    (${finalList[522]} %) 
                                                                                </c:if>
                                                                                ${finalList[523]}
                                                                            </c:if>
                                                                            <c:if test="${finalList[539] == ''}">
                                                                                <c:if test="${finalList[492] == '0'}">
                                                                                    (${finalList[493]} %) 
                                                                                </c:if>
                                                                                ${finalList[494]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">
                                                                                    <c:if test="${finalList[581] == '0'}">
                                                                                        (${finalList[582]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[583]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[599] == ''}">
                                                                                    <c:if test="${finalList[552] == '0'}">
                                                                                        (${finalList[553]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[554]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">
                                                                                    <c:if test="${finalList[641] == '0'}">
                                                                                        (${finalList[642]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[643]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[659] == ''}">
                                                                                    <c:if test="${finalList[612] == '0'}">
                                                                                        (${finalList[613]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[614]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">
                                                                                    <c:if test="${finalList[701] == '0'}">
                                                                                        (${finalList[702]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[703]}
                                                                                </c:if>
                                                                                <c:if test="${finalList[719] == ''}">
                                                                                    <c:if test="${finalList[672] == '0'}">
                                                                                        (${finalList[673]} %) 
                                                                                    </c:if>
                                                                                    ${finalList[674]}
                                                                                </c:if>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Packing & Forwarding</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">(${finalList[525]} %) ${finalList[526]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">(${finalList[496]} %) ${finalList[497]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">(${finalList[585]} %) ${finalList[586]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">(${finalList[556]} %) ${finalList[557]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">(${finalList[645]} %) ${finalList[646]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">(${finalList[616]} %) ${finalList[617]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">(${finalList[705]} %) ${finalList[706]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">(${finalList[676]} %) ${finalList[677]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Errection</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">(${finalList[528]} %) ${finalList[529]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">(${finalList[499]} %) ${finalList[500]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">(${finalList[588]} %) ${finalList[589]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">(${finalList[559]} %) ${finalList[560]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">(${finalList[648]} %) ${finalList[649]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">(${finalList[619]} %) ${finalList[620]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">(${finalList[708]} %) ${finalList[709]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">(${finalList[679]} %) ${finalList[680]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Other Charges</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">(${finalList[531]} %) ${finalList[532]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">(${finalList[502]} %) ${finalList[503]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">(${finalList[591]} %) ${finalList[592]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">(${finalList[562]} %) ${finalList[563]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">(${finalList[651]} %) ${finalList[652]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">(${finalList[622]} %) ${finalList[623]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">(${finalList[711]} %) ${finalList[712]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">(${finalList[682]} %) ${finalList[683]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">GST</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">(${finalList[534]} %) ${finalList[535]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">(${finalList[505]} %) ${finalList[506]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">(${finalList[594]} %) ${finalList[595]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">(${finalList[565]} %) ${finalList[566]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">(${finalList[654]} %) ${finalList[655]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">(${finalList[625]} %) ${finalList[626]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">(${finalList[714]} %) ${finalList[715]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">(${finalList[685]} %) ${finalList[686]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Insurance</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">(${finalList[537]} %) ${finalList[538]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">(${finalList[508]} %) ${finalList[509]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">(${finalList[597]} %) ${finalList[598]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">(${finalList[568]} %) ${finalList[569]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">(${finalList[657]} %) ${finalList[658]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">(${finalList[628]} %) ${finalList[629]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">(${finalList[717]} %) ${finalList[718]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">(${finalList[688]} %) ${finalList[689]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Landed Rate</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">${finalList[539]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">${finalList[510]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">${finalList[599]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">${finalList[570]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">${finalList[659]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">${finalList[630]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">${finalList[719]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">${finalList[690]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Total Value</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">${finalList[518]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">${finalList[491]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">${finalList[578]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">${finalList[551]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">${finalList[638]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">${finalList[611]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">${finalList[698]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">${finalList[671]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Freight</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">${finalList[541]} ${finalList[544]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">${finalList[512]} ${finalList[515]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">${finalList[601]} ${finalList[604]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">${finalList[572]} ${finalList[575]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">${finalList[661]} ${finalList[664]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">${finalList[632]} ${finalList[635]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">${finalList[721]} ${finalList[724]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">${finalList[692]} ${finalList[695]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                    <tr>
                                                                        <td  style="padding: 0px;">Make / Model</td>
                                                                        <td  style="padding: 0px;">
                                                                            <c:if test="${finalList[539] != ''}">${finalList[540]}</c:if>
                                                                            <c:if test="${finalList[539] == ''}">${finalList[511]}</c:if>
                                                                            </td>
                                                                        <c:if test="${finalList.size() > 546}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[599] != ''}">${finalList[600]}</c:if>
                                                                                <c:if test="${finalList[599] == ''}">${finalList[571]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 606}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[659] != ''}">${finalList[660]}</c:if>
                                                                                <c:if test="${finalList[659] == ''}">${finalList[631]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                        <c:if test="${finalList.size() > 666}">
                                                                            <td  style="padding: 0px;">
                                                                                <c:if test="${finalList[719] != ''}">${finalList[720]}</c:if>
                                                                                <c:if test="${finalList[719] == ''}">${finalList[691]}</c:if>
                                                                                </td>
                                                                        </c:if>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </div>
                                                    </c:if>
                                                    <table id="table_122" class="table table-bordered" style="" align="Center"  >
                                                        <tr>
                                                            <td  style="padding: 0px;">Vendor Code</td>
                                                            <td  style="padding: 0px;">Contact Person</td>
                                                            <td  style="padding: 0px;">Contact Email Id</td>
                                                            <td  style="padding: 0px;">Contact No.</td>
                                                            <td  style="padding: 0px;">Quotation No.</td>
                                                            <td  style="padding: 0px;">Grand Total</td>
                                                        </tr>
                                                        <c:forEach var="list1" items="${list1}" varStatus="status">
                                                            <tr>
                                                                <td  style="padding: 0px;">${list1.vendorCode}</td>
                                                                <td  style="padding: 0px;">${list1.contactPerson}</td>
                                                                <td  style="padding: 0px;">${list1.conactEmail}</td>
                                                                <td  style="padding: 0px;">${list1.contactNo}</td>
                                                                <td  style="padding: 0px;">${list1.offerNo}</td>
                                                                <td  style="padding: 0px;">${list1.finalTotal}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </table>

                                                    <br>
                                                    <h3>Approval Comments</h3>
                                                    <br>

                                                    <table id="table_12" class="table table-bordered" style="" align="Center"  >
                                                        <thead>
                                                            <tr>
                                                                <th>User Id</th>
                                                                <th>Comment</th>
                                                                <th>Date Time</th>

                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list2" items="${list21}" varStatus="status">
                                                                <tr>

                                                                    <td  style="padding: 0px;">${list2.userId}</td>
                                                                    <td  style="padding: 0px;">${list2.approvalComment}</td>
                                                                    <td  style="padding: 0px;">${list2.dateTime}</td>

                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>

                                                    <!--                                            </div>-->

                                                    <div class="form-group" style="margin-bottom: 0px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;">Tender Date </label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            ${tender_date}
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-bottom: 0px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;">Tender Due Date </label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            ${tender_due_date}
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-bottom: 0px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;">Bid Sent From No. Of Vendor </label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            ${total_vendor}
                                                        </div>
                                                    </div>
                                                    <div class="form-group" style="margin-bottom: 0px;">
                                                        <div class="col-sm-3">
                                                            <label class="control-label" style="padding-top: 0px;">Bid Received From No. Of Vendor </label>
                                                        </div>
                                                        <div class="col-sm-3">
                                                            ${total_bid}
                                                        </div>
                                                    </div>





                                                </div>

                                            </div><!-- /.tab-pane -->
                                        </div>
                                    </div><!-- /.tab-content -->
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                    </section>

                

        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
</html>


