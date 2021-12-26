<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@include file="/WEB-INF/views/includes/header.jsp" %>

                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                        <%=application.getMajorVersion() %> / 
                        <%=application.getMinorVersion() %>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
<%@include file="/WEB-INF/views/includes/footer.jsp" %>