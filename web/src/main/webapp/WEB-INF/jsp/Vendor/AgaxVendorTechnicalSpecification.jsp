<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Attachment</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            
                                                            <tbody>
                                                                <c:forEach var="generalDocument" items="${generalDocument}" varStatus="status">
                                                                    <tr>
                                                                <input type="hidden" name="user_name" value="${tenderCommittee1.userId}">
                                                                        <td>
                                                                            <a href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${generalDocument.attachment}&RefNo=${generalDocument.refNo}&vendor_code=${vendor_code}">${generalDocument.attachment}</a>
                                                                            
                                                                        </td>
                                                                         
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
</table>
