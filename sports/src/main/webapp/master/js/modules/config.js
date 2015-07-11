/**=========================================================
 * Module: config.js
 * App routes and resources configuration
 =========================================================*/

App.config(['$stateProvider', '$locationProvider', '$urlRouterProvider', 'RouteHelpersProvider',
function ($stateProvider, $locationProvider, $urlRouterProvider, helper) {
  'use strict';

  // Set the following to true to enable the HTML5 Mode
  // You may have to set <base> tag in index and a routing configuration in your server
  $locationProvider.html5Mode(false);

  // defaults to dashboard
  $urlRouterProvider.otherwise('/app/dashboard');

  // 
  // Application Routes
  // -----------------------------------   
  $stateProvider

    .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: helper.basepath('app.html'),
        controller: 'AppController',
        resolve: helper.resolveFor('fastclick', 'modernizr', 'icons', 'screenfull', 'animo', 'sparklines', 'slimscroll', 'classyloader', 'toaster', 'whirl')
    })
    .state('app.template', {
          url: '/template',
          title: 'Blank Template',
          templateUrl: helper.basepath('template.html')
    })
    .state('app.retos', {
          url: '/retos',
          title: 'Retos',
          templateUrl: helper.basepath('retos.html'),
          resolve: helper.resolveFor('flot-chart','flot-chart-plugins')
    })
    .state('app.establecimientos', {
        url: '/establecimientos',
        title: 'Establecimientos',
        templateUrl: helper.basepath('establecimientos.html'),
        resolve: helper.resolveFor('flot-chart','flot-chart-plugins')
    })
    .state('app.eventos', {
          url: '/eventos',
          title: 'Eventos',
          templateUrl: helper.basepath('Eventos.html'),
          resolve: helper.resolveFor('flot-chart','flot-chart-plugins')
    })
    .state('app.usuarios', {
        url: '/usuarios',
        title: 'Usuarios',
        templateUrl: helper.basepath('usuarios.html'),
        controller: 'UIGridController',
        resolve: helper.resolveFor('flot-chart','flot-chart-plugins')
    })

    // 
    // CUSTOM RESOLVES
    //   Add your own resolves properties
    //   following this object extend
    //   method
    // ----------------------------------- 
    // .state('app.someroute', {
    //   url: '/some_url',
    //   templateUrl: 'path_to_template.html',
    //   controller: 'someController',
    //   resolve: angular.extend(
    //     helper.resolveFor(), {
    //     // YOUR RESOLVES GO HERE
    //     }
    //   )
    // })
    ;


}]).config(['$ocLazyLoadProvider', 'APP_REQUIRES', function ($ocLazyLoadProvider, APP_REQUIRES) {
    'use strict';

    // Lazy Load modules configuration
    $ocLazyLoadProvider.config({
      debug: false,
      events: true,
      modules: APP_REQUIRES.modules
    });

}]).config(['$controllerProvider', '$compileProvider', '$filterProvider', '$provide',
    function ( $controllerProvider, $compileProvider, $filterProvider, $provide) {
      'use strict';
      // registering components after bootstrap
      App.controller = $controllerProvider.register;
      App.directive  = $compileProvider.directive;
      App.filter     = $filterProvider.register;
      App.factory    = $provide.factory;
      App.service    = $provide.service;
      App.constant   = $provide.constant;
      App.value      = $provide.value;

}]).config(['$translateProvider', function ($translateProvider) {

    $translateProvider.useStaticFilesLoader({
        prefix : 'app/i18n/',
        suffix : '.json'
    });
    $translateProvider.preferredLanguage('en');
    $translateProvider.useLocalStorage();
    $translateProvider.usePostCompiling(true);

}]).config(['tmhDynamicLocaleProvider', function (tmhDynamicLocaleProvider) {

    tmhDynamicLocaleProvider.localeLocationPattern('vendor/angular-i18n/angular-locale_{{locale}}.js');

    // tmhDynamicLocaleProvider.useStorage('$cookieStore');

}]).config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {

    cfpLoadingBarProvider.includeBar = true;
    cfpLoadingBarProvider.includeSpinner = false;
    cfpLoadingBarProvider.latencyThreshold = 500;
    cfpLoadingBarProvider.parentSelector = '.wrapper > section';

}]).config(['$tooltipProvider', function ($tooltipProvider) {

    $tooltipProvider.options({appendToBody: true});

}])
;
