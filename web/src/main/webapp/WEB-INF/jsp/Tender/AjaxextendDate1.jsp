<%-- 
    Document   : AjaxextendDate1
    Created on : Jan 24, 2026, 12:16:49 PM
    Author     : Sumanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

 <input type="hidden" name="refNo" id="refNo" value="${refNo}">
<input type="hidden" name="submitLastdate1" id="submitLastdate1" value="${submitLastdate}">


<div>
    <div class="row d-flex align-items-center justify-content-between">
        <div class="col-6">
            <div class="form-group">
                <label> Extend Date <span class="text-danger">*</span> </label>
                <input type="text" name="submitLastdate" id="submitLastdate" class="input-field form_datetime" placeholder="dd-mm-yyyy --:--"
                       value="${submitLastdate}" style="background-color: #fff; cursor: text;"/>
            </div>
        </div>

    </div>
    
</div>