<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
<script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <title>Logout</title>
    <script type="text/javascript">
        $(function(){ 
        window.setInterval(function(){
   // 'blink' class is toggled into 'P' tag between the interval of 500 ms
         $('a').blink();
         }, 500);
        });
</script>
  <style>
           a {transition: color 200ms ease;}
           a.blink {color:transparent;}
        </style>
    </head>
    <body>
        <div>
            <div>
                <div class="wrapper">
                       <table id="table_1" style="width: 100%">
                           <tbody>
                               <tr style="background-color: #3c8dbc"> 
                                   <td colspan="3">
                                         <a href="#" class="logo">
                                     <!--<span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px; margin: 20px;" /></span>-->
                                        </a>
                                   </td>
                               </tr>
                               <tr>
                                   <td colspan="3">
                                         <div class="titleBold" style="font-size: 25px; margin: 20px;">You have successfully logged out!</div>
                                       <!--<p>You have successfully logged out!</p>-->
                                   </td> 
                               </tr>
                               <tr>
                                   <td style="width: 40%; padding:20px;">
                                            <table id="table_1" class="table table-bordered table-striped table-responsive" style="font-size:18px " align="Center"  >
                                                <tbody>
                                                <tr>
                                                    <td><b>Last Log Details</b></td>
                                                    <td>&nbsp;&nbsp;</td>
                                                </tr>
                                                <tr>
                                                    <td>In Time</td>
                                                    <td>${userLoginLogStart}</td>
                                                </tr>
                                                <tr>
                                                    <td>Out Time</td>
                                                    <td>${userLoginLogEnd}</td>
                                                </tr>
                                                <tr>
                                                    <td>Duration(In Minutes)</td>
                                                    <td>${Logindurationmin}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                   </td> 
                                    <td>
<!--                                    <div style="margin: 30px"><img src="StorageYard/Images/disco.jpg"></div>-->
                                    </td>
                               </tr>
                           </tbody>
                       </table>
                                                <div class="title16" style="clear: both;margin: 10px;padding: 5px;"><b>If you want to sign in again. -</b>
                          <!--<a href="logIn.html?act=loginClick" id="loginlink">Click Here</a>-->
     <button type="button" class="btn btn-primary" onclick="location.href='logIn.html?act=loginClick';"  style="background-color: #0070c0;border-radius: 6px;width: auto;text-align: center; font-weight: bold; " >Click Here</button>
            </div>
</div>
    </body>
</html>
<!--                <div class="title24 titleBold" style="margin: 20px;">You have successfully logged out!</div>
                <div style="margin: 20px;">
                    <div style="margin: 20px">Description : </div>

                    <div style="margin: 30px">
                        <div style="float: left">
                            <div style="margin: 10px;"><div class="title16 label1">In Time</div> - ${userLoginLogStart}</div>
                            <br />
                            <div style="margin: 10px;"><div class="title16 label1">Out Time</div> - ${userLoginLogEnd}</div>
                        </div>
                        
                    </div>
                </div>
            </div>
          