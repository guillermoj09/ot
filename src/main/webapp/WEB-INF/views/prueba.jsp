
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Grid Opons</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="resources/css/animate.css" rel="stylesheet">
    <link href="resources/css/style.css" rel="stylesheet">

</head>

<body>

    <div id="wrapper">
	<%@include file="menu.jsp"%>
        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <form role="search" class="navbar-form-custom" action="search_results.html">
                <div class="form-group">
                    <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                </div>
            </form>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <small class="pull-right">46h ago</small>
                                    <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a4.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right text-navy">5h ago</small>
                                    <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/profile.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right">23h ago</small>
                                    <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                    <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="mailbox.html">
                                    <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="mailbox.html">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="profile.html">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="grid_options.html">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="notifications.html">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="login.html">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>
            </ul>

        </nav>
        </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>Grid Options - based on Bootstrap Grid system overview</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Layout</a>
                        </li>
                        <li class="active">
                            <strong>Grid Opons</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Grid options</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="#">Config option 1</a>
                                </li>
                                <li><a href="#">Config option 2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                            <p>See how aspects of the Bootstrap grid system work across multiple devices with a handy table.</p>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>
                                            Extra small devices
                                            <small>Phones (&lt;768px)</small>
                                        </th>
                                        <th>
                                            Small devices
                                            <small>Tablets (&ge;768px)</small>
                                        </th>
                                        <th>
                                            Medium devices
                                            <small>Desktops (&ge;992px)</small>
                                        </th>
                                        <th>
                                            Large devices
                                            <small>Desktops (&ge;1200px)</small>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>Grid behavior</th>
                                        <td>Horizontal at all times</td>
                                        <td colspan="3">Collapsed to start, horizontal above breakpoints</td>
                                    </tr>
                                    <tr>
                                        <th>Max container width</th>
                                        <td>None (auto)</td>
                                        <td>750px</td>
                                        <td>970px</td>
                                        <td>1170px</td>
                                    </tr>
                                    <tr>
                                        <th>Class prefix</th>
                                        <td>
                                            <code>.col-xs-</code>
                                        </td>
                                        <td>
                                            <code>.col-sm-</code>
                                        </td>
                                        <td>
                                            <code>.col-md-</code>
                                        </td>
                                        <td>
                                            <code>.col-lg-</code>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th># of columns</th>
                                        <td colspan="4">12</td>
                                    </tr>
                                    <tr>
                                        <th>Max column width</th>
                                        <td class="text-muted">Auto</td>
                                        <td>60px</td>
                                        <td>78px</td>
                                        <td>95px</td>
                                    </tr>
                                    <tr>
                                        <th>Gutter width</th>
                                        <td colspan="4">30px (15px on each side of a column)</td>
                                    </tr>
                                    <tr>
                                        <th>Nestable</th>
                                        <td colspan="4">Yes</td>
                                    </tr>
                                    <tr>
                                        <th>Offsets</th>
                                        <td colspan="4">Yes</td>
                                    </tr>
                                    <tr>
                                        <th>Column ordering</th>
                                        <td colspan="4">Yes</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <p>Grid classes apply to devices with screen widths greater than or equal to the breakpoint sizes, and override grid classes targeted at smaller devices. Therefore, applying any
                                <code>.col-md-</code> class to an element will not only affect its styling on medium devices but also on large devices if a
                                <code>.col-lg-</code> class is not present.</p>

                    </div>
                </div>
            </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Stacked-to-horizontal</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                                <p>Using a single set of
                                    <code>.col-md-*</code> grid classes, you can create a default grid system that starts out stacked on mobile devices and tablet devices (the extra small to small range) before becoming horizontal on desktop (medium) devices. Place grid columns in any
                                    <code>.row</code>.</p>
                                <div class="row show-grid">
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                    <div class="col-md-1">.col-md-1</div>
                                </div>
                                <div class="row show-grid">
                                    <div class="col-md-8">.col-md-8</div>
                                    <div class="col-md-4">.col-md-4</div>
                                </div>
                                <div class="row show-grid">
                                    <div class="col-md-4">.col-md-4</div>
                                    <div class="col-md-4">.col-md-4</div>
                                    <div class="col-md-4">.col-md-4</div>
                                </div>
                                <div class="row show-grid">
                                    <div class="col-md-6">.col-md-6</div>
                                    <div class="col-md-6">.col-md-6</div>
                                </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Mobile and desktop</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <p>Don't want your columns to simply stack in smaller devices? Use the extra small and medium device grid classes by adding
                                <code>.col-xs-*</code>
                                <code>.col-md-*</code> to your columns. See the example below for a better idea of how it all works.</p>
                            <div class="row show-grid">
                                <div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
                                <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
                            </div>
                            <div class="row show-grid">
                                <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
                                <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
                                <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
                            </div>
                            <div class="row show-grid">
                                <div class="col-xs-6">.col-xs-6</div>
                                <div class="col-xs-6">.col-xs-6</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Mobile, tablet, desktops</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <p>Build on the previous example by creating even more dynamic and powerful layouts with tablet
                                <code>.col-sm-*</code> classes.</p>
                            <div class="row show-grid">
                                <div class="col-xs-12 col-sm-6 col-md-8">.col-xs-12 .col-sm-6 .col-md-8</div>
                                <div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
                            </div>
                            <div class="row show-grid">
                                <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
                                <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
                                <!-- Optional: clear the XS cols if their content doesn't match in height -->
                                <div class="clearfix visible-xs"></div>
                                <div class="col-xs-6 col-sm-4">.col-xs-6 .col-sm-4</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Responsive column resets</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <p>With the four tiers of grids available you're bound to run into issues where, at certain breakpoints, your columns don't clear quite right as one is taller than the other. To fix that, use a combination of a
                                <code>.clearfix</code> and our <a href="#responsive-utilities">responsive utility classes</a>.</p>
                            <div class="row show-grid">
                                <div class="col-xs-6 col-sm-3">
                                    .col-xs-6 .col-sm-3
                                    <br>Resize your viewport or check it out on your phone for an example.
                                </div>
                                <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>

                                <!-- Add the extra clearfix for only the required viewport -->
                                <div class="clearfix visible-xs"></div>

                                <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
                                <div class="col-xs-6 col-sm-3">.col-xs-6 .col-sm-3</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Offsetting columns</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <p>Move columns to the right using
                                <code>.col-md-offset-*</code> classes. These classes increase the left margin of a column by
                                <code>*</code> columns. For example,
                                <code>.col-md-offset-4</code> moves
                                <code>.col-md-4</code> over four columns.</p>
                            <div class="row show-grid">
                                <div class="col-md-4">.col-md-4</div>
                                <div class="col-md-4 col-md-offset-4">.col-md-4 .col-md-offset-4</div>
                            </div>
                            <div class="row show-grid">
                                <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
                                <div class="col-md-3 col-md-offset-3">.col-md-3 .col-md-offset-3</div>
                            </div>
                            <div class="row show-grid">
                                <div class="col-md-6 col-md-offset-3">.col-md-6 .col-md-offset-3</div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Nesting columns</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <p>To nest your content with the default grid, add a new
                                <code>.row</code> and set of
                                <code>.col-md-*</code> columns within an existing
                                <code>.col-md-*</code> column. Nested rows should include a set of columns that add up to 12.</p>
                            <div class="row show-grid">
                                <div class="col-md-9">
                                    Level 1: .col-md-9
                                    <div class="row show-grid">
                                        <div class="col-md-6">
                                            Level 2: .col-md-6
                                        </div>
                                        <div class="col-md-6">
                                            Level 2: .col-md-6
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Column ordering</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                                <p>Easily change the order of our built-in grid columns with
                                    <code>.col-md-push-*</code> and
                                    <code>.col-md-pull-*</code> modifier classes.</p>
                                <div class="row show-grid">
                                    <div class="col-md-9 col-md-push-3">.col-md-9 .col-md-push-3</div>
                                    <div class="col-md-3 col-md-pull-9">.col-md-3 .col-md-pull-9</div>
                                </div>
                    </div>
                </div>

            </div>
        </div>
        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2017
            </div>
        </div>

        </div>
        </div>



    <!-- Mainly scripts -->
    <script src="resources/js/jquery-3.1.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/plugins/peity/jquery.peity.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="resources/js/inspinia.js"></script>
    <script src="resources/js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="resources/js/plugins/iCheck/icheck.min.js"></script>

    <!-- Peity -->
    <script src="resources/js/demo/peity-demo.js"></script>
    
	<!-- SIGNATURE -->
	<script src="resources/jsing/numeric-1.2.6.min.js.descarga"></script>
	<script src="resources/jsing/bezier.js.descarga"></script>
	<script src="resources/jsing/jquery.signaturepad.js.descarga"></script>
	<script src="resources/jsing/json2.min.js.descarga"></script>	

	<script type="text/javascript" src="resources/js/jquery.rut.chileno.min.js"></script>

    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

</body>

</html>
