<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Demo Project</title>
    <link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
    <link href="css/table.css" rel="stylesheet" type="text/css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>

<div id="templatemo_wrapper_outter">

    <div id="templatemo_wrapper_inner">

        <div id="templatemo_header">
            This is Header
        </div> <!-- end of templatemo_header -->

        <div id="templatemo_menu">

            <ul>
                <ul>
                    <li><a href="home?page=home" class="current">Home</a></li>
                    <li><a href="ulist?page=list">User</a></li>
                    <li><a href="logout?page=logout" >Logout</a></li>
                </ul>
            </ul>

        </div> <!-- end of templatemo_menu -->

        <div id="templatemo_content_wrapper">

            <div id="templatemo_sidebar_wrapper">

                <div id="templatemo_sidebar_top"></div>
                <div id="templatemo_sidebar">

                    <h2>Our Services</h2>

                    <ul class="categories_list">
                        <li><a href="#">Test1</a></li>
                        <li><a href="#">Test2</a></li>
                    </ul>

                    <div class="cleaner_h30"></div>

                </div>
                <div id="templatemo_sidebar_bottom"></div>

            </div>



            <div id="templatemo_content">

                <div class="content_section">

                    <h2>User List</h2>
                </div>
                <h2><a href="userForm?page=userForm">Add New User</a></h2>
                <table>
                    <tr>
                        <th>User Name</th>
                        <th>Password</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.password}</td>
                            <td>${user.role}</td>
                            <td><a href="uedit?page=edit&id=${user.id}"><img src="../images/edit.jpg" height="30px" width="40px" alt="Edit"></a></td>
                            <td><a href="udelete?page=delete&id=${user.id}"><img src="../images/delete.jpg" height="30px" width="40px" alt="Delete"></a></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

            <div class="cleaner"></div>

        </div> <!-- end of templatemo_content_wrapper -->

        <div id="templatemo_footer">

            This is Footer
        </div><!-- end of footer -->

    </div> <!-- end of templatemo_wrapper_inner -->

</div> <!-- end of templatemo_wrapper_outter -->

</body>
</html>



