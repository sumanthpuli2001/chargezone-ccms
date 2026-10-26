
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deliverable AOC View</title>
    </head>
    <body>
       
    <main class="d-flex align-items-end justify-content-end">
         <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
         <section class="main-content">
              <form:form action=".htm?act=" commandName="departmentMaster" method="post">
           
                <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                    <div class="page-title d-flex align-items-center">
                        <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                            <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                alt="Menu collapse">
                            <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                alt="Menu collapse">
                        </div>

                        <h5 class="fw-600 mb-0">Deliverable AOC View</h5>
                    </div>

                    <div class="cta d-flex align-items-center">
                        <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                        <a href="oapForm.htm?act=DeliverablePrint1&id=${id}" class="btn theme-btn" onclick="printCustom()" title="Print this page">
                            <i class="fa fa-arrow-right"></i>&nbsp;&nbsp;Print
                        </a>
                    </div>
                </div>

                <hr>

                 <input type="hidden" name="id" id="id" value="${id}"> 
                
                 <h6>AOC Form Details</h6>
                <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Document Number</label>
                                        <p class="fw-600">${aocForm.documentNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Depo.Name</label>
                                        <p class="fw-600">${aocForm.hubDepoName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${aocForm.clientProjectName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By</label>
                                        <p class="fw-600">${aocForm.userId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Client Name</label>
                                        <p class="fw-600">${aocForm.mobileNo}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${aocForm.createdDate}</p>
                                    </div>
                                </div>
                               
                            
                            </div>
                        </div>  
                    </div> 
                 <h6>KOM Form Details</h6>
                <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Document Number</label>
                                        <p class="fw-600">${kickOffForm.documentNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Hub Location</label>
                                        <p class="fw-600">${kickOffForm.hubLocation}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${kickOffForm.projectName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Designation</label>
                                        <p class="fw-600">${kickOffForm.designation}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date & Time</label>
                                        <p class="fw-600">${kickOffForm.dateTime}</p>
                                    </div>
                                </div>
                                
                               
                            
                            </div>
                        </div>  
                    </div> 
                
                  <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${list13.date}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-12 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <p class="fw-600">${list13.description}</p>
                                    </div>
                                </div>
                       </div>
                        </div>  
                    </div>              
                                    
                                    <table id="commonTable"  class="table table-striped bg-white"  style="max-width: 100%;"> 

                                        <thead>
                                            <tr>
                                                <th >Description</th>
                                                <th >Design Co-ordinator</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                        <c:forEach var="list12" items="${list12}">
                                            <tr>
                                                <td ><span>${list12.description}</span>
                                                </td> 
                                                <td ><span>${list12.designCoordinator}</span>
                                                </td> 


                                            </tr>
                                        </c:forEach>

</tbody>

                                    </table> 
                                    
                                    
                                    <h6>AOC Deliverable Multi Attachment</h6>                      
                                    
                <table id="commonTable1" class="table  table-striped bg-white" style="max-width: 100%;" align="Center">
                                        <thead>
                                            <tr>
                                                <th>Document Name</th>
                                                <th>Attachment 
                                                    <c:if test="${prdSize != 0}">
                                                    <a href="oapForm.htm?act=delimultiDocxdownloadzip&id1=${delivablemultiid}" style="text-decoration: none; color: black; font-size: 16px;">
                                                        &nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-download"></i>
                                                    </a>
                                                        </c:if>
                                                </th>


                                            </tr>
                                        </thead>

                                        <c:forEach var="list5" items="${list5}" varStatus="status">
                                            <tr>
                                                <td>${list5.description}</td>
                                                <td>
                                                    <a class="fw-600 text-break gradient-text" href="oapForm.htm?act=delivmultiDocxdownload&fileName=${list5.attachement}&id1=${list5.oapId}">${list5.attachement}</a>
                                                </td>




                                            </tr>
                                        </c:forEach>


                                    </table>
                                    <h6>Approval Status</h6>
                                           
                                    <table id="commonTable2" class="table table-striped bg-white" align="center" style="max-width: 100%;">

                                            <thead>
                                                <tr>
                                                    <th >Sr. No</th>
                                                    <th >User</th>
                                                    <th >Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="list0" items="${list0}" varStatus="status">
                                                    <tr>
                                                        <td> ${status.count}</td> 
                                                        <td>${list0.designAssign}</td> 
                                                        <td>
                                                            <c:if test="${list0.flagStatus == '1'}">
                                                                Approved
                                                            </c:if>  
                                                            <c:if test="${list0.flagStatus == '2'}">
                                                                Recycle
                                                            </c:if>  
                                                            <c:if test="${list0.flagStatus == '3'}">
                                                                Reject
                                                            </c:if>
                                                        </td> 
                                                    </tr>
                                                </c:forEach>
                                            </tbody>



                                        </table>                
                                    
                                    
                                    
                                    
              </form:form>
        </section>
    </main>
</body>
 <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
 
 
 
</html>
