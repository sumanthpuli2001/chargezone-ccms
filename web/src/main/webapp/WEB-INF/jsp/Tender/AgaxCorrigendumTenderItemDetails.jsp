<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

                                                    <c:choose>
                                                        <c:when test="${empty fileDetail}">
                                                            There Is No Any Record
                                                        </c:when>
                                                        <c:otherwise>
                                                            
                                                            <c:set var="count" value="0" scope="page" />
                                                                    
                                                                
                                                                <c:forEach var="fileDetail" items="${fileDetail}" varStatus="status">
                                                                    
                                                                    <br>
                                                                    
                                                                    <c:if test="${fileDetail.serType == 'Service1'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Sr. No.</th>
                                                                                    <th>Item Description</th>
                                                                                    <th>UOM</th>
                                                                                    <th>Qty</th>
                                                                                    <th>Remark</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '2'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail2}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '3'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail3}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                        
                                                                    <c:if test="${fileDetail.serType == 'Service2'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        <c:if test="${status1.count == '1'}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                    <th>${serviceDetail.srNo}</th>
                                                                                                    <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                                </tr>
                                                                                            </thead>
                                                                                            <tbody>
                                                                                        </c:if>
                                                                                        <c:if test="${status1.count != '1'}">
                                                                                            <tr>
                                                                                                <td>${serviceDetail.srNo}</td>
                                                                                                <td>${serviceDetail.itemDesc}</td>
                                                                                                <c:if test="${i1 >= 1}">
                                                                                                    <td>${serviceDetail.onlyBearing1}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 2}">
                                                                                                    <td>${serviceDetail.onlyBearing2}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 3}">
                                                                                                    <td>${serviceDetail.onlyBearing3}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 4}">
                                                                                                    <td>${serviceDetail.onlyBearing4}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 5}">
                                                                                                    <td>${serviceDetail.onlyBearing5}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 6}">
                                                                                                    <td>${serviceDetail.onlyBearing6}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 7}">
                                                                                                    <td>${serviceDetail.onlyBearing7}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 8}">
                                                                                                    <td>${serviceDetail.onlyBearing8}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 9}">
                                                                                                    <td>${serviceDetail.onlyBearing9}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 10}">
                                                                                                    <td>${serviceDetail.onlyBearing10}</td>
                                                                                                </c:if>
                                                                                            </tr>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                
                                                                                <c:if test="${status.count == '2'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail2}" varStatus="status1">
                                                                                        <c:if test="${status1.count == '1'}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                    <th>${serviceDetail.srNo}</th>
                                                                                                    <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                                </tr>
                                                                                            </thead>
                                                                                            <tbody>
                                                                                        </c:if>
                                                                                        <c:if test="${status1.count != '1'}">
                                                                                            <tr>
                                                                                                <td>${serviceDetail.srNo}</td>
                                                                                                <td>${serviceDetail.itemDesc}</td>
                                                                                                <c:if test="${i1 >= 1}">
                                                                                                    <td>${serviceDetail.onlyBearing1}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 2}">
                                                                                                    <td>${serviceDetail.onlyBearing2}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 3}">
                                                                                                    <td>${serviceDetail.onlyBearing3}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 4}">
                                                                                                    <td>${serviceDetail.onlyBearing4}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 5}">
                                                                                                    <td>${serviceDetail.onlyBearing5}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 6}">
                                                                                                    <td>${serviceDetail.onlyBearing6}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 7}">
                                                                                                    <td>${serviceDetail.onlyBearing7}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 8}">
                                                                                                    <td>${serviceDetail.onlyBearing8}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 9}">
                                                                                                    <td>${serviceDetail.onlyBearing9}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 10}">
                                                                                                    <td>${serviceDetail.onlyBearing10}</td>
                                                                                                </c:if>
                                                                                            </tr>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                            
                                                                                <c:if test="${status.count == '3'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail3}" varStatus="status1">
                                                                                        <c:if test="${status1.count == '1'}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                    <th>${serviceDetail.srNo}</th>
                                                                                                    <th>${serviceDetail.itemDesc}</th>
                                                                                                    <c:if test="${serviceDetail.onlyBearing1 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing1}</th>
                                                                                                        <c:set var = "i1" value="1"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing2 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing2}</th>
                                                                                                        <c:set var = "i1" value="2"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing3 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing3}</th>
                                                                                                        <c:set var = "i1" value="3"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing4 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing4}</th>
                                                                                                        <c:set var = "i1" value="4"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing5 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing5}</th>
                                                                                                        <c:set var = "i1" value="5"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing6 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing6}</th>
                                                                                                        <c:set var = "i1" value="6"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing7 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing7}</th>
                                                                                                        <c:set var = "i1" value="7"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing8 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing8}</th>
                                                                                                        <c:set var = "i1" value="8"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing9 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing9}</th>
                                                                                                        <c:set var = "i1" value="9"/>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.onlyBearing10 != ''}">
                                                                                                        <th>${serviceDetail.onlyBearing10}</th>
                                                                                                        <c:set var = "i1" value="10"/>
                                                                                                    </c:if>
                                                                                                </tr>
                                                                                            </thead>
                                                                                            <tbody>
                                                                                        </c:if>
                                                                                        <c:if test="${status1.count != '1'}">
                                                                                            <tr>
                                                                                                <td>${serviceDetail.srNo}</td>
                                                                                                <td>${serviceDetail.itemDesc}</td>
                                                                                                <c:if test="${i1 >= 1}">
                                                                                                    <td>${serviceDetail.onlyBearing1}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 2}">
                                                                                                    <td>${serviceDetail.onlyBearing2}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 3}">
                                                                                                    <td>${serviceDetail.onlyBearing3}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 4}">
                                                                                                    <td>${serviceDetail.onlyBearing4}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 5}">
                                                                                                    <td>${serviceDetail.onlyBearing5}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 6}">
                                                                                                    <td>${serviceDetail.onlyBearing6}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 7}">
                                                                                                    <td>${serviceDetail.onlyBearing7}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 8}">
                                                                                                    <td>${serviceDetail.onlyBearing8}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 9}">
                                                                                                    <td>${serviceDetail.onlyBearing9}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${i1 >= 10}">
                                                                                                    <td>${serviceDetail.onlyBearing10}</td>
                                                                                                </c:if>
                                                                                            </tr>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                            
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                        
                                                                        
                                                                    <c:if test="${fileDetail.serType == 'Service3'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Sr. No.</th>
                                                                                    <th>Particular</th>
                                                                                    <th>Scheduled Amount</th>
                                                                                    
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.particular}</td>
                                                                                            <td>${serviceDetail.scheduledAmount}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '2'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetai2}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.particular}</td>
                                                                                            <td>${serviceDetail.scheduledAmount}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '3'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail3}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.particular}</td>
                                                                                            <td>${serviceDetail.scheduledAmount}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                        
                                                                    <c:if test="${fileDetail.serType == 'Service4'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        <c:if test="${status1.count == '1'}">
                                                                                            <thead>
                                                                                                <tr>
                                                                                                    <th>${serviceDetail.name}</th>
                                                                                                    <c:if test="${serviceDetail.security1 != ''}">
                                                                                                        <th>${serviceDetail.security1}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security2 != ''}">
                                                                                                        <th>${serviceDetail.security2}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security3 != ''}">
                                                                                                        <th>${serviceDetail.security3}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security4 != ''}">
                                                                                                        <th>${serviceDetail.security4}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security5 != ''}">
                                                                                                        <th>${serviceDetail.security5}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security6 != ''}">
                                                                                                        <th>${serviceDetail.security6}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security7 != ''}">
                                                                                                        <th>${serviceDetail.security7}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security8 != ''}">
                                                                                                        <th>${serviceDetail.security8}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security9 != ''}">
                                                                                                        <th>${serviceDetail.security9}</th>
                                                                                                    </c:if>
                                                                                                    <c:if test="${serviceDetail.security10 != ''}">
                                                                                                        <th>${serviceDetail.security10}</th>
                                                                                                    </c:if>
                                                                                                </tr>
                                                                                            </thead>
                                                                                            <tbody>
                                                                                        </c:if>
                                                                                        <c:if test="${status1.count != '1'}">        
                                                                                            <tr>
                                                                                                <td>${serviceDetail.name}</td>
                                                                                                <c:if test="${serviceDetail.security1 != ''}">
                                                                                                    <td>${serviceDetail.security1}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security2 != ''}">
                                                                                                    <td>${serviceDetail.security2}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security3 != ''}">
                                                                                                    <td>${serviceDetail.security3}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security4 != ''}">
                                                                                                    <td>${serviceDetail.security4}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security5 != ''}">
                                                                                                    <td>${serviceDetail.security5}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security6 != ''}">
                                                                                                    <td>${serviceDetail.security6}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security7 != ''}">
                                                                                                    <td>${serviceDetail.security7}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security8 != ''}">
                                                                                                    <td>${serviceDetail.security8}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security9 != ''}">
                                                                                                    <td>${serviceDetail.security9}</td>
                                                                                                </c:if>
                                                                                                <c:if test="${serviceDetail.security10 != ''}">
                                                                                                    <td>${serviceDetail.security10}</td>
                                                                                                </c:if>
                                                                                                
                                                                                            </tr>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                    
                                                                    <c:if test="${fileDetail.serType == 'Service5'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Sr. No.</th>
                                                                                    <th>Item Description</th>
                                                                                    <th>UOM</th>
                                                                                    <th>Qty</th>
                                                                                    <th>Remark</th>
                                                                                    <th>Header / Sub Header</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                            <td>${serviceDetail.headerNonheader}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                
                                                                                <c:if test="${status.count == '2'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail2}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                            <td>${serviceDetail.headerNonheader}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>        
                                                                                
                                                                                <c:if test="${status.count == '3'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail3}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.itemDesc}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.remark}</td>
                                                                                            <td>${serviceDetail.headerNonheader}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                        
                                                                    <c:if test="${fileDetail.serType == 'Service6'}">
                                                                        Service Type : ${fileDetail.serType} <br>
                                                                        Title : ${fileDetail.title} <br>
                                                                        Service File : ${fileDetail.fileName} <br>
                                                                        
                                                                        <table id="table_1" class="table table-bordered" style="" align="Center">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Sr. No.</th>
                                                                                    <th>PC Type</th>
                                                                                    <th>Item Description</th>
                                                                                    <th>UOM</th>
                                                                                    <th>Qty</th>
                                                                                    <th>AMC Required Days</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                                <c:if test="${status.count == '1'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail1}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.pcType}</td>
                                                                                            <td>${serviceDetail.itemDescription}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.amcRequiredDays}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '2'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail2}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.pcType}</td>
                                                                                            <td>${serviceDetail.itemDescription}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.amcRequiredDays}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                                <c:if test="${status.count == '3'}">
                                                                                    <c:forEach var="serviceDetail" items="${serviceDetail3}" varStatus="status1">
                                                                                        
                                                                                        <tr>
                                                                                            <td>${serviceDetail.srNo}</td>
                                                                                            <td>${serviceDetail.pcType}</td>
                                                                                            <td>${serviceDetail.itemDescription}</td>
                                                                                            <td>${serviceDetail.uom}</td>
                                                                                            <td>${serviceDetail.qty}</td>
                                                                                            <td>${serviceDetail.amcRequiredDays}</td>
                                                                                        </tr>
                                                                                    </c:forEach>
                                                                                </c:if>
                                                                            </tbody>
                                                                        </table>
                                                                    </c:if>
                                                                        
                                                                    <hr>
                                                                </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
