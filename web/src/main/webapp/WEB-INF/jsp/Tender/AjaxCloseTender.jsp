<%-- 
    Document   : AjaxCloseTender
    Created on : Jul 15, 2025, 4:45:10 PM
    Author     : Sumanth
--%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



   
        
    
  <span style="color: red; font-size: 14px;" class="ml-3">* Indicates Mandatory Field.</span>

<div style="display: flex; flex-wrap: wrap; gap: 20px;">
    
    <!-- Tender No -->
    <div class="col-lg-4 col-md-6">
        <div class="form-group">
            <label>Tender No : <span style="color: red; font-size: 12px;">*</span></label>
            <input type="text" class="input-field" id="tender_no" name="tender_no" value="${tender_no}" readonly="true" />
        </div>
    </div>

    <!-- Remark -->
    
    
    <div class="col-lg-12 col-md-6">
                    <div class="form-group comment-box">
                        <label class="control-label">Remark :<span class="text-danger">*</span></label>
                        <textarea type="text" maxlength="250" class="textarea-field comment" id="remark" name="remark"  required="true"></textarea>
                     </div>
                </div>
    
    
    

</div>

                                    
                                   
                               

                           
        
       
 
  
