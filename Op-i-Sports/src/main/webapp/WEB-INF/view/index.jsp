<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<html xmlns:ng="http://angularjs.org" class="ng-app:angle" id="ng-app" ng-app="angle">
	<head>
	    <meta charset="utf-8">
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<link rel="SHORTCUT ICON" href="resources/images/favicon.ico" type="image/x-icon" />
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="{{app.description}}">
   <meta name="keywords" content="app, responsive, angular, bootstrap, dashboard, admin">
   <title data-ng-bind="::pageTitle()">Angle - Angular Bootstrap Admin Template</title>
   <!-- Bootstrap styles-->
   <link rel="stylesheet" href="app/css/bootstrap.css" data-ng-if="!app.layout.isRTL">
   <link rel="stylesheet" href="app/css/bootstrap-rtl.css" data-ng-if="app.layout.isRTL">
   <!-- Application styles-->
   <link rel="stylesheet" href="app/css/app.css" data-ng-if="!app.layout.isRTL">
   <link rel="stylesheet" href="app/css/app-rtl.css" data-ng-if="app.layout.isRTL">
   <link rel="stylesheet" href="app/css/personalizado.css" data-ng-if="app.layout.isRTL">
   <!-- Themes-->
   <link rel="stylesheet" ng-href="{{app.layout.theme}}" data-ng-if="app.layout.theme">
</head>

<body data-ng-class="{ 'layout-fixed' : app.layout.isFixed, 'aside-collapsed' : app.layout.isCollapsed, 'layout-boxed' : app.layout.isBoxed, 'layout-fs': app.useFullLayout, 'hidden-footer': app.hiddenFooter, 'layout-h': app.layout.horizontal, 'aside-float': app.layout.isFloat}">
   <div data-ui-view="" data-autoscroll="false" class="wrapper"></div>
   <script src="app/js/base.js"></script>
   <script src="app/js/app.js"></script>

</body>

</html>