<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <title>Session Expired</title>
    </head>
    <body>
              <div class="wrapper">
                       <table id="table_1" style="width: 100%">
                           <tbody>
                               <tr style="background-color: #3c8dbc"> 
                                   <td colspan="3">
                                         <a href="#" class="logo">
                                     <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px; margin: 20px;" /></span>
                                        </a>
                                   </td>
                               </tr>
                               <tr>
                                   <td>
                                         <div class="titleBold" style="font-size: 20px; margin: 20px;">Sorry, Your session has expired or invalidated.</div>
                                   </td> 
                               </tr>
                               <tr>
                                   <td style="width: 40%; padding-left:20px;">
                                       Description about it :<br /><br />
                                            - It has been expired As You have not used for 15 minutes.<br />
                                            <br />Or<br /><br />
                                            - It has been invalidated As You have logged out.<br />
                                   </td> 
                                    <td>
                                    <div style="margin: 20px"><img src="StorageYard/Images/disco.jpg"></div>
                                    </td>
                               </tr>
                           </tbody>
                       </table>
                   <div class="title16" style="clear: both;margin: 20px;">If you want to go to login page.
                            <button type="button" class="btn btn-primary" onclick="location.href='logIn.html?act=loginClick';"  style="background-color: #0070c0;border-radius: 6px;width: auto;text-align: center; font-weight: bold; " >Click Here</button>

                       <!--<a href="logIn.html?act=loginClick">Click here</a>.-->
                   </div>
            </div>
</div>
    </body>
</html>

<!--        <div>
            <div style="width: 100%;">
                <div class="title24 titleBold" style="margin: 20px;">Sorry, Your session has expired or invalidated.</div>
                <div style="margin: 20px;">
                    <div style="margin: 20px">Description about it : </div>

                    <div style="margin: 30px;">
                        <div>
                            - It has been expired As You have not used for 15 minutes.<br />
                            <br />Or<br /><br />
                            - It has been invalidated As You have logged out.<br />
                        </div>
                        <div style="margin: 30px;float: right"><img src="StorageYard/Images/disco.jpg"></div>
                    </div>
                </div>
            </div>
            <div class="title16" style="clear: both;margin: 20px;">If you want to go to login page.<a href="logIn.html?act=loginClick">Click here</a>.</div>
        </div>-->