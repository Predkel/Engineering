<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<script src="https://rawgit.com/RobinHerbots/jquery.inputmask/3.x/dist/jquery.inputmask.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#coefficient').inputmask({'alias': 'decimal', 'groupSeparator': ',', 'autoGroup': 'true'});  //static mask
    });
</script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/asserts/js/bootstrap.js" type="text/css"></script>
<script src="${pageContext.request.contextPath}/asserts/js/salvattore.min.js" type="text/css"></script>
</body>
</html>
